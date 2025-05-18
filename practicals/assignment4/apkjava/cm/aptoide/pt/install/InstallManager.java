package cm.aptoide.pt.install;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import cm.aptoide.pt.app.aptoideinstall.AptoideInstallManager;
import cm.aptoide.pt.database.room.RoomDownload;
import cm.aptoide.pt.database.room.RoomInstallation;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.downloadmanager.AptoideDownloadManager;
import cm.aptoide.pt.downloadmanager.DownloadNotFoundException;
import cm.aptoide.pt.downloadmanager.DownloadsRepository;
import cm.aptoide.pt.file.FileManager;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.installer.InstallCandidate;
import cm.aptoide.pt.install.installer.InstallationState;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.preferences.secure.SecurePreferences;
import cm.aptoide.pt.root.RootAvailabilityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Single;
import rx.schedulers.Schedulers;

/* loaded from: classes.dex */
public class InstallManager {
    private static final String TAG = "InstallManager";
    private final AptoideDownloadManager aptoideDownloadManager;
    private final AptoideInstallManager aptoideInstallManager;
    private final AptoideInstalledAppsRepository aptoideInstalledAppsRepository;
    private final Context context;
    private final DownloadsRepository downloadRepository;
    private final FileManager fileManager;
    private final ForegroundManager foregroundManager;
    private final InstallAppSizeValidator installAppSizeValidator;
    private final Installer installer;
    private final RootAvailabilityManager rootAvailabilityManager;
    private final SharedPreferences securePreferences;
    private final SharedPreferences sharedPreferences;
    private final rx.t.b dispatchInstallationsSubscription = new rx.t.b();
    private final rx.s.b<InstallCandidate> installCandidateSubject = rx.s.b.g1();

    public InstallManager(Context context, AptoideDownloadManager aptoideDownloadManager, Installer installer, RootAvailabilityManager rootAvailabilityManager, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, DownloadsRepository downloadsRepository, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, ForegroundManager foregroundManager, AptoideInstallManager aptoideInstallManager, InstallAppSizeValidator installAppSizeValidator, FileManager fileManager) {
        this.aptoideDownloadManager = aptoideDownloadManager;
        this.installer = installer;
        this.context = context;
        this.rootAvailabilityManager = rootAvailabilityManager;
        this.downloadRepository = downloadsRepository;
        this.aptoideInstalledAppsRepository = aptoideInstalledAppsRepository;
        this.sharedPreferences = sharedPreferences;
        this.securePreferences = sharedPreferences2;
        this.foregroundManager = foregroundManager;
        this.aptoideInstallManager = aptoideInstallManager;
        this.installAppSizeValidator = installAppSizeValidator;
        this.fileManager = fileManager;
    }

    private RoomInstalled convertDownloadToInstalled(RoomDownload roomDownload) {
        RoomInstalled roomInstalled = new RoomInstalled();
        roomInstalled.setPackageAndVersionCode(roomDownload.getPackageName() + roomDownload.getVersionCode());
        roomInstalled.setVersionCode(roomDownload.getVersionCode());
        roomInstalled.setVersionName(roomDownload.getVersionName());
        roomInstalled.setAppSize(Long.valueOf(roomDownload.getSize()));
        roomInstalled.setStatus(2);
        roomInstalled.setType(-1);
        roomInstalled.setPackageName(roomDownload.getPackageName());
        return roomInstalled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createDownloadAndRetry, reason: merged with bridge method [inline-methods] */
    public rx.e<Throwable> m(rx.e<? extends Throwable> eVar, final RoomDownload roomDownload) {
        return eVar.G(new rx.m.e() { // from class: cm.aptoide.pt.install.d1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.e(roomDownload, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createInstall, reason: merged with bridge method [inline-methods] */
    public Install j(RoomDownload roomDownload, InstallationState installationState, String str, String str2, int i2, Install.InstallationType installationType) {
        return new Install(mapInstallation(roomDownload), mapInstallationStatus(roomDownload, installationState), installationType, mapIndeterminateState(roomDownload, installationState), getSpeed(roomDownload), str, str2, i2, getVersionName(roomDownload, installationState), getAppName(roomDownload, installationState), getAppIcon(roomDownload, installationState), getDownloadSize(roomDownload, installationState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized List<Install> createInstallList(List<RoomDownload> list, List<RoomInstalled> list2, List<RoomInstalled> list3) {
        ArrayList arrayList;
        InstallationState installationState;
        Install.InstallationType installationType;
        InstallationState installationState2;
        Install.InstallationType installationType2;
        arrayList = new ArrayList();
        for (RoomDownload roomDownload : list) {
            boolean isAppInstalling = isAppInstalling(list3, roomDownload.getPackageName(), roomDownload.getVersionCode());
            int i2 = isAppInstalling ? 3 : 1;
            InstallationState installationState3 = new InstallationState(roomDownload.getPackageName(), roomDownload.getVersionCode(), i2, -1, roomDownload.getSize());
            Install.InstallationType installationType3 = Install.InstallationType.INSTALL;
            Iterator<RoomInstalled> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    installationState = installationState3;
                    installationType = installationType3;
                    break;
                }
                RoomInstalled next = it.next();
                if (roomDownload.getPackageName().equals(next.getPackageName())) {
                    if (roomDownload.getVersionCode() == next.getVersionCode()) {
                        if (!isAppInstalling) {
                            i2 = next.getStatus();
                        }
                        installationState2 = new InstallationState(next.getPackageName(), next.getVersionCode(), next.getVersionName(), i2, next.getType(), next.getName(), next.getIcon(), roomDownload.getSize());
                        installationType2 = Install.InstallationType.INSTALLED;
                    } else {
                        installationState2 = new InstallationState(next.getPackageName(), next.getVersionCode(), i2, -1, roomDownload.getSize());
                        if (next.getVersionCode() > roomDownload.getVersionCode()) {
                            installationType2 = Install.InstallationType.DOWNGRADE;
                        } else {
                            installationType2 = Install.InstallationType.UPDATE;
                        }
                    }
                    installationType = installationType2;
                    installationState = installationState2;
                }
            }
            arrayList.add(lambda$getInstall$17(roomDownload, installationState, roomDownload.getMd5(), roomDownload.getPackageName(), roomDownload.getVersionCode(), installationType));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: defaultInstall, reason: merged with bridge method [inline-methods] */
    public rx.b t(RoomDownload roomDownload) {
        return install(roomDownload, true, true);
    }

    private void dispatchInstallationCandidates() {
        rx.t.b bVar = this.dispatchInstallationsSubscription;
        rx.e<R> G = this.installCandidateSubject.G(new rx.m.e() { // from class: cm.aptoide.pt.install.o1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.g((InstallCandidate) obj);
            }
        });
        rx.m.b<? super Throwable> bVar2 = i3.f6452f;
        bVar.a(G.w(bVar2).s0().H0(new rx.m.b() { // from class: cm.aptoide.pt.install.c2
            @Override // rx.m.b
            public final void call(Object obj) {
                InstallManager.lambda$dispatchInstallationCandidates$4((RoomDownload) obj);
            }
        }, bVar2));
    }

    private String getAppIcon(RoomDownload roomDownload, InstallationState installationState) {
        if (roomDownload != null) {
            return roomDownload.getIcon();
        }
        return installationState.getIcon();
    }

    private String getAppName(RoomDownload roomDownload, InstallationState installationState) {
        if (roomDownload != null) {
            return roomDownload.getAppName();
        }
        return installationState.getName();
    }

    private long getDownloadSize(RoomDownload roomDownload, InstallationState installationState) {
        if (roomDownload != null) {
            return roomDownload.getSize();
        }
        return installationState.getAppSize();
    }

    private rx.e<Install.InstallationType> getInstallationType(String str, final int i2) {
        return this.aptoideInstalledAppsRepository.getInstalled(str).X(new rx.m.e() { // from class: cm.aptoide.pt.install.s0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.lambda$getInstallationType$32(i2, (RoomInstalled) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.install.g1
            @Override // rx.m.b
            public final void call(Object obj) {
                Logger.getInstance().d("AptoideDownloadManager", " emiting installation type");
            }
        });
    }

    private int getSpeed(RoomDownload roomDownload) {
        return 0;
    }

    private String getVersionName(RoomDownload roomDownload, InstallationState installationState) {
        if (roomDownload != null) {
            return roomDownload.getVersionName();
        }
        return installationState.getVersionName();
    }

    private rx.b initInstallationProgress(RoomDownload roomDownload) {
        return this.aptoideInstalledAppsRepository.save(convertDownloadToInstalled(roomDownload));
    }

    private boolean isAppInstalling(List<RoomInstalled> list, String str, int i2) {
        for (RoomInstalled roomInstalled : list) {
            if (str.equals(roomInstalled.getPackageName()) && i2 == roomInstalled.getVersionCode()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cleanTimedOutInstalls$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b b(RoomInstalled roomInstalled) {
        roomInstalled.setStatus(1);
        return this.aptoideInstalledAppsRepository.save(roomInstalled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cleanTimedOutInstalls$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(Install install) {
        return this.aptoideInstalledAppsRepository.get(install.getPackageName(), install.getVersionCode()).E().H(new rx.m.e() { // from class: cm.aptoide.pt.install.u1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.b((RoomInstalled) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cleanTimedOutInstalls$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(List list) {
        return rx.e.N(list).G(new rx.m.e() { // from class: cm.aptoide.pt.install.a1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.c((Install) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createDownloadAndRetry$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(RoomDownload roomDownload, Throwable th) {
        if (th instanceof DownloadNotFoundException) {
            Logger.getInstance().d(TAG, "saved the newly created download because the other one was null");
            return this.downloadRepository.save(roomDownload).b(rx.e.S(th));
        }
        return rx.e.C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$dispatchInstallationCandidates$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b f(InstallCandidate installCandidate, RoomDownload roomDownload) {
        return stopForegroundAndInstall(roomDownload.getMd5(), roomDownload.getAction(), installCandidate.getForceDefaultInstall(), installCandidate.getShouldSetPackageInstaller()).a(sendBackgroundInstallFinishedBroadcast(roomDownload));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$dispatchInstallationCandidates$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g(final InstallCandidate installCandidate) {
        return this.aptoideDownloadManager.getDownloadAsObservable(installCandidate.getMd5()).p0(null).D(new rx.m.e() { // from class: cm.aptoide.pt.install.i1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r0 != null);
                return valueOf;
            }
        }).O0(new rx.m.e() { // from class: cm.aptoide.pt.install.j1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1.getOverallDownloadStatus() == 1);
                return valueOf;
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.install.b1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.f(installCandidate, (RoomDownload) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$dispatchInstallationCandidates$4(RoomDownload roomDownload) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Iterable lambda$fetchInstalled$40(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Single lambda$filterInstalled$42(Install install, Boolean bool) {
        if (bool.booleanValue()) {
            return Single.m(null);
        }
        return Single.m(install);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getCurrentInstallation$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(RoomDownload roomDownload) {
        return getInstall(roomDownload.getMd5(), roomDownload.getPackageName(), roomDownload.getVersionCode());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Install.InstallationType lambda$getInstallationType$32(int i2, RoomInstalled roomInstalled) {
        if (roomInstalled == null) {
            return Install.InstallationType.INSTALL;
        }
        if (roomInstalled.getVersionCode() == i2) {
            return Install.InstallationType.INSTALLED;
        }
        if (roomInstalled.getVersionCode() > i2) {
            return Install.InstallationType.DOWNGRADE;
        }
        return Install.InstallationType.UPDATE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleNotEnoughSpaceForDownload$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e k(RoomDownload roomDownload, boolean z, boolean z2, boolean z3, Long l) {
        if (roomDownload.getSize() >= this.installAppSizeValidator.getAvailableSpace()) {
            roomDownload.setOverallDownloadStatus(9);
            roomDownload.setDownloadError(2);
            return this.downloadRepository.save(roomDownload).b(rx.e.S(roomDownload.getMd5()));
        }
        return startBackgroundInstallation(roomDownload.getMd5(), z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$install$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e l(RoomDownload roomDownload, RoomDownload roomDownload2) {
        return updateDownloadAction(roomDownload, roomDownload2).b(rx.e.S(roomDownload2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$install$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(RoomDownload roomDownload) {
        this.aptoideInstallManager.addAptoideInstallCandidate(roomDownload.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$install$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e o(RoomDownload roomDownload) {
        if (roomDownload.getOverallDownloadStatus() == 9) {
            roomDownload.setOverallDownloadStatus(0);
            return this.downloadRepository.save(roomDownload).b(rx.e.S(roomDownload));
        }
        return rx.e.S(roomDownload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$install$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e p(boolean z, boolean z2, RoomDownload roomDownload, RoomDownload roomDownload2) {
        if (!this.installAppSizeValidator.hasEnoughSpaceToInstallApp(roomDownload2)) {
            return handleNotEnoughSpaceForDownload(roomDownload2, z, true, z2);
        }
        return startBackgroundInstallation(roomDownload.getMd5(), z, true, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Iterable lambda$onAppInstalled$28(RoomInstalled roomInstalled, List list) {
        if (list.isEmpty()) {
            list.add(roomInstalled);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onAppInstalled$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b q(RoomInstalled roomInstalled, RoomInstalled roomInstalled2) {
        if (roomInstalled2.getVersionCode() == roomInstalled.getVersionCode()) {
            roomInstalled.setType(roomInstalled2.getType());
            roomInstalled.setStatus(4);
            return this.aptoideInstalledAppsRepository.save(roomInstalled).a(this.downloadRepository.remove(roomInstalled.getPackageName(), roomInstalled.getVersionCode()));
        }
        return this.aptoideInstalledAppsRepository.remove(roomInstalled2.getPackageName(), roomInstalled2.getVersionCode());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Iterable lambda$onAppRemoved$30(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onAppRemoved$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b r(String str, RoomInstalled roomInstalled) {
        return this.aptoideInstalledAppsRepository.remove(str, roomInstalled.getVersionCode());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Iterable lambda$retryTimedOutInstallations$34(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$retryTimedOutInstallations$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single s(Install install) {
        return getDownload(install.getMd5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendBackgroundInstallFinishedBroadcast$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(RoomDownload roomDownload) {
        this.context.sendBroadcast(new Intent(DownloadService.ACTION_INSTALL_FINISHED).putExtra(DownloadService.EXTRA_INSTALLATION_MD5, roomDownload.getMd5()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startBackgroundInstallation$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(boolean z, String str, boolean z2, boolean z3, RoomDownload roomDownload) {
        if (z) {
            this.installCandidateSubject.onNext(new InstallCandidate(str, z2, z3));
            this.foregroundManager.startDownloadService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startBackgroundInstallation$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b w(RoomDownload roomDownload) {
        return initInstallationProgress(roomDownload).a(startDownload(roomDownload));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$startBackgroundInstallation$23(String str, RoomDownload roomDownload) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ RoomDownload lambda$startInstalls$24(RoomDownload roomDownload, Long l) {
        return roomDownload;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Iterable lambda$wasAppEverInstalled$43(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ rx.e lambda$wasAppEverInstalled$45(List list) {
        if (list.isEmpty()) {
            return rx.e.S(Boolean.FALSE);
        }
        return rx.e.S(Boolean.TRUE);
    }

    private boolean mapIndeterminate(RoomDownload roomDownload) {
        if (roomDownload == null) {
            return false;
        }
        switch (roomDownload.getOverallDownloadStatus()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            default:
                return false;
            case 13:
            case 15:
                return true;
        }
    }

    private boolean mapIndeterminateState(RoomDownload roomDownload, InstallationState installationState) {
        return mapIndeterminate(roomDownload) || mapInstallIndeterminate(installationState.getStatus(), installationState.getType(), roomDownload);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        if (r4 != 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        if (r5.getOverallDownloadStatus() == 1) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean mapInstallIndeterminate(int i2, int i3, RoomDownload roomDownload) {
        boolean z = false;
        switch (i2) {
            case 2:
                if (roomDownload != null) {
                    break;
                }
                break;
        }
        if (roomDownload == null || roomDownload.getOverallDownloadStatus() != 0) {
            return z;
        }
        return true;
    }

    private int mapInstallation(RoomDownload roomDownload) {
        if (roomDownload != null) {
            int overallProgress = roomDownload.getOverallProgress();
            Logger.getInstance().d(TAG, " download is not null " + overallProgress + " state " + roomDownload.getOverallDownloadStatus());
            return overallProgress;
        }
        Logger.getInstance().d(TAG, " download is null");
        return 0;
    }

    private Install.InstallationStatus mapInstallationStatus(RoomDownload roomDownload, InstallationState installationState) {
        if (installationState.getStatus() == 4) {
            return Install.InstallationStatus.INSTALLED;
        }
        if (installationState.getStatus() == 3 && installationState.getType() != 0) {
            return Install.InstallationStatus.INSTALLING;
        }
        if (installationState.getStatus() == 6) {
            return Install.InstallationStatus.UNINSTALLED;
        }
        if (installationState.getStatus() == 2 && roomDownload != null && roomDownload.getOverallDownloadStatus() == 1) {
            return Install.InstallationStatus.DOWNLOADING;
        }
        if (installationState.getStatus() == 5) {
            return Install.InstallationStatus.INSTALLATION_TIMEOUT;
        }
        return lambda$getDownloadState$46(roomDownload);
    }

    private rx.b sendBackgroundInstallFinishedBroadcast(final RoomDownload roomDownload) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.install.q0
            @Override // rx.m.a
            public final void call() {
                InstallManager.this.u(roomDownload);
            }
        });
    }

    private rx.e<String> startBackgroundInstallation(final String str, final boolean z, final boolean z2, final boolean z3) {
        return this.aptoideDownloadManager.getDownloadAsSingle(str).e(i3.f6452f).A().x(new rx.m.b() { // from class: cm.aptoide.pt.install.j0
            @Override // rx.m.b
            public final void call(Object obj) {
                InstallManager.this.v(z3, str, z, z2, (RoomDownload) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.install.a2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.w((RoomDownload) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.install.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                String str2 = str;
                InstallManager.lambda$startBackgroundInstallation$23(str2, (RoomDownload) obj);
                return str2;
            }
        });
    }

    private rx.b startDownload(RoomDownload roomDownload) {
        if (roomDownload.getOverallDownloadStatus() == 1) {
            Logger.getInstance().d(TAG, "Saving an already completed download to trigger the download installation");
            return this.downloadRepository.save(roomDownload);
        }
        return this.aptoideDownloadManager.startDownload(roomDownload);
    }

    private rx.b stopForegroundAndInstall(String str, int i2, boolean z, boolean z2) {
        Logger.getInstance().d(TAG, "going to pop install from: " + str + "and download action: " + i2);
        if (i2 == 0) {
            return this.installer.install(str, z, z2);
        }
        if (i2 == 1) {
            return this.installer.update(str, z, z2);
        }
        if (i2 != 2) {
            return rx.b.s(new IllegalArgumentException("Invalid download action " + i2));
        }
        return this.installer.downgrade(str, z, z2);
    }

    private rx.b updateDownloadAction(RoomDownload roomDownload, RoomDownload roomDownload2) {
        if (roomDownload2.getAction() != roomDownload.getAction()) {
            roomDownload2.setAction(roomDownload.getAction());
            return this.downloadRepository.save(roomDownload2);
        }
        return rx.b.e();
    }

    public rx.b cancelInstall(String str, String str2, int i2) {
        return pauseInstall(str).a(this.aptoideInstalledAppsRepository.remove(str2, i2)).a(this.aptoideDownloadManager.cancelDownload(str)).n(new rx.m.b() { // from class: cm.aptoide.pt.install.z1
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    public rx.b cleanTimedOutInstalls() {
        return getTimedOutInstallations().E().G(new rx.m.e() { // from class: cm.aptoide.pt.install.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.d((List) obj);
            }
        }).Y0().X0();
    }

    public rx.e<List<RoomInstalled>> fetchInstalled() {
        return this.aptoideInstalledAppsRepository.getAllInstalledSorted().E().J(new rx.m.e() { // from class: cm.aptoide.pt.install.l1
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                InstallManager.lambda$fetchInstalled$40(list);
                return list;
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.install.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                RoomInstalled roomInstalled = (RoomInstalled) obj;
                valueOf = Boolean.valueOf(!roomInstalled.isSystemApp());
                return valueOf;
            }
        }).Y0();
    }

    public rx.e<List<RoomInstalled>> fetchInstalledExceptSystem() {
        return this.aptoideInstalledAppsRepository.getInstalledAppsFilterSystem();
    }

    public Single<Install> filterInstalled(final Install install) {
        return this.aptoideInstalledAppsRepository.isInstalled(install.getPackageName(), install.getVersionCode()).i(new rx.m.e() { // from class: cm.aptoide.pt.install.x1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.lambda$filterInstalled$42(Install.this, (Boolean) obj);
            }
        });
    }

    public rx.e<Install> getCurrentInstallation() {
        return this.aptoideDownloadManager.getCurrentInProgressDownload().D(new rx.m.e() { // from class: cm.aptoide.pt.install.c1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r0 != null);
                return valueOf;
            }
        }).j0(Schedulers.io()).u(new rx.m.e() { // from class: cm.aptoide.pt.install.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                String md5;
                md5 = ((RoomDownload) obj).getMd5();
                return md5;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.install.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.h((RoomDownload) obj);
            }
        });
    }

    public Single<RoomDownload> getDownload(String str) {
        return this.downloadRepository.getDownloadAsSingle(str);
    }

    public rx.e<List<String>> getDownloadOutOfSpaceMd5List() {
        return this.downloadRepository.getOutOfSpaceDownloads().D(new rx.m.e() { // from class: cm.aptoide.pt.install.x0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                List list = (List) obj;
                valueOf = Boolean.valueOf(!list.isEmpty());
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.install.q1
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e Y0;
                Y0 = rx.e.N((List) obj).X(new rx.m.e() { // from class: cm.aptoide.pt.install.n1
                    @Override // rx.m.e
                    public final Object call(Object obj2) {
                        String md5;
                        md5 = ((RoomDownload) obj2).getMd5();
                        return md5;
                    }
                }).Y0();
                return Y0;
            }
        });
    }

    public rx.e<Install.InstallationStatus> getDownloadState(String str) {
        return this.aptoideDownloadManager.getDownloadAsObservable(str).E().X(new rx.m.e() { // from class: cm.aptoide.pt.install.t0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.i((RoomDownload) obj);
            }
        });
    }

    public rx.e<Install> getInstall(final String str, final String str2, final int i2) {
        return rx.e.d(this.aptoideDownloadManager.getDownloadsByMd5(str), this.installer.getState(str2, i2), getInstallationType(str2, i2), new rx.m.g() { // from class: cm.aptoide.pt.install.y1
            @Override // rx.m.g
            public final Object a(Object obj, Object obj2, Object obj3) {
                return InstallManager.this.j(str, str2, i2, (RoomDownload) obj, (InstallationState) obj2, (Install.InstallationType) obj3);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.install.f0
            @Override // rx.m.b
            public final void call(Object obj) {
                Logger.getInstance().d(InstallManager.TAG, ((Install) obj).toString());
            }
        });
    }

    public rx.e<List<Install>> getInstallations() {
        return rx.e.d(this.aptoideDownloadManager.getDownloadsList(), this.aptoideInstalledAppsRepository.getAllInstalled(), this.aptoideInstalledAppsRepository.getAllInstalling(), new rx.m.g() { // from class: cm.aptoide.pt.install.z0
            @Override // rx.m.g
            public final Object a(Object obj, Object obj2, Object obj3) {
                List createInstallList;
                createInstallList = InstallManager.this.createInstallList((List) obj, (List) obj2, (List) obj3);
                return createInstallList;
            }
        }).t();
    }

    public Single<Long> getInstalledAppSize(String str) {
        return this.aptoideInstalledAppsRepository.getInstalled(str).E().Z0().n(new rx.m.e() { // from class: cm.aptoide.pt.install.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Long appSize;
                appSize = ((RoomInstalled) obj).getAppSize();
                return appSize;
            }
        });
    }

    public rx.e<List<Install>> getTimedOutInstallations() {
        return getInstallations().G(new rx.m.e() { // from class: cm.aptoide.pt.install.f1
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e Y0;
                Y0 = rx.e.N((List) obj).D(new rx.m.e() { // from class: cm.aptoide.pt.install.m0
                    @Override // rx.m.e
                    public final Object call(Object obj2) {
                        Boolean valueOf;
                        valueOf = Boolean.valueOf(((Install) obj2).getState().equals(Install.InstallationStatus.INSTALLATION_TIMEOUT));
                        return valueOf;
                    }
                }).Y0();
                return Y0;
            }
        });
    }

    public rx.e<String> handleNotEnoughSpaceForDownload(final RoomDownload roomDownload, final boolean z, final boolean z2, final boolean z3) {
        return this.fileManager.deleteCache(false).E().Z0().k(new rx.m.e() { // from class: cm.aptoide.pt.install.m1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.k(roomDownload, z, z2, z3, (Long) obj);
            }
        });
    }

    public Single<Boolean> hasNextDownload() {
        return this.aptoideDownloadManager.getCurrentActiveDownloads().E().X(new rx.m.e() { // from class: cm.aptoide.pt.install.o0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf((r0 == null || r0.isEmpty()) ? false : true);
                return valueOf;
            }
        }).Z0();
    }

    /* renamed from: install, reason: merged with bridge method [inline-methods] */
    public rx.b x(RoomDownload roomDownload) {
        return install(roomDownload, false, true);
    }

    public rx.e<Boolean> isInstalled(String str) {
        return this.aptoideInstalledAppsRepository.isInstalled(str).E();
    }

    /* renamed from: mapDownloadState, reason: merged with bridge method [inline-methods] */
    public Install.InstallationStatus i(RoomDownload roomDownload) {
        Install.InstallationStatus installationStatus;
        Install.InstallationStatus installationStatus2 = Install.InstallationStatus.UNINSTALLED;
        if (roomDownload != null) {
            switch (roomDownload.getOverallDownloadStatus()) {
                case 0:
                    installationStatus = Install.InstallationStatus.INITIAL_STATE;
                    break;
                case 1:
                case 10:
                case 12:
                case 14:
                default:
                    return installationStatus2;
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 11:
                case 15:
                    installationStatus = Install.InstallationStatus.DOWNLOADING;
                    break;
                case 6:
                    installationStatus = Install.InstallationStatus.PAUSED;
                    break;
                case 9:
                    int downloadError = roomDownload.getDownloadError();
                    if (downloadError != 1) {
                        return downloadError != 2 ? installationStatus2 : Install.InstallationStatus.NOT_ENOUGH_SPACE_ERROR;
                    }
                    return Install.InstallationStatus.GENERIC_ERROR;
                case 13:
                    installationStatus = Install.InstallationStatus.IN_QUEUE;
                    break;
            }
            return installationStatus;
        }
        Logger.getInstance().d(TAG, "mapping a null Download state");
        return installationStatus2;
    }

    public rx.b onAppInstalled(final RoomInstalled roomInstalled) {
        return this.aptoideInstalledAppsRepository.getAsList(roomInstalled.getPackageName()).E().J(new rx.m.e() { // from class: cm.aptoide.pt.install.e1
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                InstallManager.lambda$onAppInstalled$28(RoomInstalled.this, list);
                return list;
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.install.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.q(roomInstalled, (RoomInstalled) obj);
            }
        }).X0();
    }

    public rx.b onAppRemoved(final String str) {
        return this.aptoideInstalledAppsRepository.getAsList(str).E().J(new rx.m.e() { // from class: cm.aptoide.pt.install.h1
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                InstallManager.lambda$onAppRemoved$30(list);
                return list;
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.install.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.r(str, (RoomInstalled) obj);
            }
        }).X0();
    }

    public rx.b onUpdateConfirmed(RoomInstalled roomInstalled) {
        return onAppInstalled(roomInstalled);
    }

    public rx.b pauseInstall(String str) {
        return this.aptoideDownloadManager.pauseDownload(str);
    }

    public rx.b retryTimedOutInstallations() {
        return getTimedOutInstallations().E().J(new rx.m.e() { // from class: cm.aptoide.pt.install.v1
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                InstallManager.lambda$retryTimedOutInstallations$34(list);
                return list;
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.install.r1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.s((Install) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.install.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.t((RoomDownload) obj);
            }
        }).X0();
    }

    public void rootInstallAllowed(boolean z) {
        SecurePreferences.setRootDialogShowed(true, this.securePreferences);
        ManagerPreferences.setAllowRootInstallation(z, this.sharedPreferences);
    }

    public boolean showWarning() {
        return (!this.rootAvailabilityManager.isRootAvailable().y().b().booleanValue() || SecurePreferences.isRootDialogShowed(this.securePreferences) || ManagerPreferences.allowRootInstallation(this.securePreferences)) ? false : true;
    }

    public rx.b splitInstall(RoomDownload roomDownload) {
        return install(roomDownload, false, true);
    }

    public void start() {
        this.aptoideDownloadManager.start();
        dispatchInstallationCandidates();
        this.installer.dispatchInstallations();
    }

    public rx.e<Boolean> startInstalls(List<RoomDownload> list) {
        return rx.e.N(list).e1(rx.e.Q(0L, 1L, TimeUnit.SECONDS), new rx.m.f() { // from class: cm.aptoide.pt.install.i0
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                RoomDownload roomDownload = (RoomDownload) obj;
                InstallManager.lambda$startInstalls$24(roomDownload, (Long) obj2);
                return roomDownload;
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.install.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.x((RoomDownload) obj);
            }
        }).Y0().X(new rx.m.e() { // from class: cm.aptoide.pt.install.w1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool;
                bool = Boolean.TRUE;
                return bool;
            }
        }).p0(new rx.m.e() { // from class: cm.aptoide.pt.install.s1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool;
                bool = Boolean.FALSE;
                return bool;
            }
        });
    }

    public void stop() {
        this.aptoideDownloadManager.stop();
        this.installer.stopDispatching();
    }

    public rx.b uninstallApp(String str) {
        return this.installer.uninstall(str);
    }

    public boolean wasAppEverInstalled(final String str) {
        return ((Boolean) this.aptoideInstalledAppsRepository.getInstallationsHistory().E().J(new rx.m.e() { // from class: cm.aptoide.pt.install.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                InstallManager.lambda$wasAppEverInstalled$43(list);
                return list;
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.install.y0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(str.equals(((RoomInstallation) obj).getPackageName()));
                return valueOf;
            }
        }).Y0().G(new rx.m.e() { // from class: cm.aptoide.pt.install.k0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.lambda$wasAppEverInstalled$45((List) obj);
            }
        }).W0().b()).booleanValue();
    }

    public rx.b install(RoomDownload roomDownload, boolean z) {
        return install(roomDownload, false, z);
    }

    private rx.b install(final RoomDownload roomDownload, final boolean z, final boolean z2) {
        return this.aptoideDownloadManager.getDownloadAsSingle(roomDownload.getMd5()).e(i3.f6452f).A().G(new rx.m.e() { // from class: cm.aptoide.pt.install.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.l(roomDownload, (RoomDownload) obj);
            }
        }).t0(new rx.m.e() { // from class: cm.aptoide.pt.install.p1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.m(roomDownload, (rx.e) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.install.t1
            @Override // rx.m.b
            public final void call(Object obj) {
                InstallManager.this.n((RoomDownload) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.install.v0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.o((RoomDownload) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.install.b2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstallManager.this.p(z, z2, roomDownload, (RoomDownload) obj);
            }
        }).X0();
    }
}
