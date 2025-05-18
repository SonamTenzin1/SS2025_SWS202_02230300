package cm.aptoide.pt.install.installer;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.room.RoomFileToDownload;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.downloadmanager.Constants;
import cm.aptoide.pt.install.AppInstallerStatusReceiver;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.install.Installer;
import cm.aptoide.pt.install.InstallerAnalytics;
import cm.aptoide.pt.install.RootCommandTimeoutException;
import cm.aptoide.pt.install.RootInstallerProvider;
import cm.aptoide.pt.install.exception.InstallationException;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.packageinstaller.AppInstall;
import cm.aptoide.pt.packageinstaller.AppInstaller;
import cm.aptoide.pt.packageinstaller.InstallStatus;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.root.RootAvailabilityManager;
import cm.aptoide.pt.root.RootShell;
import cm.aptoide.pt.utils.BroadcastRegisterOnSubscribe;
import cm.aptoide.pt.utils.FileUtils;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;

/* loaded from: classes.dex */
public class DefaultInstaller implements Installer {
    public static final String OBB_FOLDER = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/";
    private static final String TAG = DefaultInstaller.class.getSimpleName();
    private final AppInstaller appInstaller;
    private final AppInstallerStatusReceiver appInstallerStatusReceiver;
    private final AptoideInstalledAppsRepository aptoideInstalledAppsRepository;
    private final Context context;
    private final FileUtils fileUtils;
    private final InstallationProvider installationProvider;
    private final InstallerAnalytics installerAnalytics;
    private final int installingStateTimeout;
    private final PackageManager packageManager;
    private final RootAvailabilityManager rootAvailabilityManager;
    private final RootInstallerProvider rootInstallerProvider;
    private final SharedPreferences sharedPreferences;
    private final rx.t.b dispatchInstallationsSubscription = new rx.t.b();
    private final rx.s.b<InstallationCandidate> installCandidateSubject = rx.s.b.g1();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cm.aptoide.pt.install.installer.DefaultInstaller$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status;

        static {
            int[] iArr = new int[InstallStatus.Status.values().length];
            $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status = iArr;
            try {
                iArr[InstallStatus.Status.INSTALLING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[InstallStatus.Status.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[InstallStatus.Status.WAITING_INSTALL_FEEDBACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[InstallStatus.Status.FAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[InstallStatus.Status.CANCELED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[InstallStatus.Status.UNKNOWN_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public DefaultInstaller(PackageManager packageManager, InstallationProvider installationProvider, AppInstaller appInstaller, FileUtils fileUtils, boolean z, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, int i2, RootAvailabilityManager rootAvailabilityManager, SharedPreferences sharedPreferences, InstallerAnalytics installerAnalytics, int i3, AppInstallerStatusReceiver appInstallerStatusReceiver, RootInstallerProvider rootInstallerProvider, Context context) {
        this.packageManager = packageManager;
        this.installationProvider = installationProvider;
        this.appInstaller = appInstaller;
        this.fileUtils = fileUtils;
        this.aptoideInstalledAppsRepository = aptoideInstalledAppsRepository;
        this.installerAnalytics = installerAnalytics;
        this.appInstallerStatusReceiver = appInstallerStatusReceiver;
        this.rootInstallerProvider = rootInstallerProvider;
        RootShell.debugMode = z;
        RootShell.defaultCommandTimeout = i2;
        this.rootAvailabilityManager = rootAvailabilityManager;
        this.sharedPreferences = sharedPreferences;
        this.installingStateTimeout = i3;
        this.context = context;
    }

    private rx.e<Installation> defaultInstall(final Context context, final Installation installation, final boolean z) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme(Constants.PACKAGE);
        return rx.e.a0(handleInstallationResult(intentFilter, installation, z), rx.e.P(new Callable() { // from class: cm.aptoide.pt.install.installer.z
            @Override // java.util.concurrent.Callable
            public final Object call() {
                DefaultInstaller.this.b(installation, z, context);
                return null;
            }
        })).I0(Schedulers.computation()).X(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                Installation installation2 = Installation.this;
                DefaultInstaller.lambda$defaultInstall$30(installation2, obj);
                return installation2;
            }
        });
    }

    private rx.e<Installation> handleInstallationResult(IntentFilter intentFilter, final Installation installation, final boolean z) {
        return rx.e.a0(waitPackageIntent(this.context, intentFilter, installation.getPackageName()).S0(this.installingStateTimeout, TimeUnit.MILLISECONDS, rx.e.P(new Callable() { // from class: cm.aptoide.pt.install.installer.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                DefaultInstaller.this.h(installation, z);
                return null;
            }
        })), this.appInstallerStatusReceiver.getInstallerInstallStatus().x(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.q
            @Override // rx.m.b
            public final void call(Object obj) {
                DefaultInstaller.this.i(installation, (InstallStatus) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(Installation.this.getPackageName().equalsIgnoreCase(((InstallStatus) obj).getPackageName()));
                return valueOf;
            }
        }).t().x(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.n
            @Override // rx.m.b
            public final void call(Object obj) {
                DefaultInstaller.this.j(installation, z, (InstallStatus) obj);
            }
        })).X(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Installation installation2 = Installation.this;
                DefaultInstaller.lambda$handleInstallationResult$35(installation2, obj);
                return installation2;
            }
        });
    }

    private boolean isInstalled(String str, int i2) {
        try {
            PackageInfo packageInfo = this.packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode == i2;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private boolean isSystem(Context context) {
        try {
            return (this.packageManager.getApplicationInfo(context.getPackageName(), 0).flags & 1) == 1;
        } catch (PackageManager.NameNotFoundException unused) {
            throw new AssertionError("Aptoide application not found by package manager.");
        }
    }

    private /* synthetic */ Void lambda$defaultInstall$29(Installation installation, boolean z, Context context) throws Exception {
        AppInstall map = map(installation);
        if (z) {
            this.appInstaller.install(map);
            return null;
        }
        updateInstallation(installation, z ? 3 : 0, 3);
        startInstallIntent(context, installation.getFile());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Installation lambda$defaultInstall$30(Installation installation, Object obj) {
        return installation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$dispatchInstallations$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(InstallationCandidate installationCandidate) {
        return moveInstallationFiles(installationCandidate.getInstallation()).b(rx.e.S(installationCandidate));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$dispatchInstallations$11(Installation installation) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Installation lambda$dispatchInstallations$2(Installation installation, Object obj) {
        return installation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$dispatchInstallations$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(InstallationCandidate installationCandidate, Boolean bool) {
        final Installation installation = installationCandidate.getInstallation();
        if (bool.booleanValue()) {
            installation.setStatus(4);
            return installation.save().M().X(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.j0
                @Override // rx.m.e
                public final Object call(Object obj) {
                    Installation installation2 = Installation.this;
                    DefaultInstaller.lambda$dispatchInstallations$2(installation2, obj);
                    return installation2;
                }
            });
        }
        if (installationCandidate.getForceDefaultInstall()) {
            return startDefaultInstallation(this.context, installation, false);
        }
        return startInstallation(this.context, installation, installationCandidate.getShouldSetPackageInstaller());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$dispatchInstallations$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(final InstallationCandidate installationCandidate) {
        return rx.e.S(Boolean.valueOf(isInstalled(installationCandidate.getInstallation().getPackageName(), installationCandidate.getInstallation().getVersionCode()))).p0(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool;
                bool = Boolean.FALSE;
                return bool;
            }
        }).E().G(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DefaultInstaller.this.d(installationCandidate, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$dispatchInstallations$6(Installation installation) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Installation lambda$dispatchInstallations$8(Installation installation, RoomInstalled roomInstalled) {
        return installation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$dispatchInstallations$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(final Installation installation) {
        return this.aptoideInstalledAppsRepository.get(installation.getPackageName(), installation.getVersionCode()).D(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1.getStatus() == 4);
                return valueOf;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Installation installation2 = Installation.this;
                DefaultInstaller.lambda$dispatchInstallations$8(installation2, (RoomInstalled) obj);
                return installation2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$downgrade$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b g(Installation installation) {
        return uninstall(installation.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InstallationState lambda$getState$18(String str, int i2, RoomInstalled roomInstalled) {
        if (roomInstalled != null) {
            return new InstallationState(roomInstalled.getPackageName(), roomInstalled.getVersionCode(), roomInstalled.getVersionName(), roomInstalled.getStatus(), roomInstalled.getType(), roomInstalled.getName(), roomInstalled.getIcon(), roomInstalled.getAppSize().longValue());
        }
        return new InstallationState(str, i2, 1, -1);
    }

    private /* synthetic */ Void lambda$handleInstallationResult$31(Installation installation, boolean z) throws Exception {
        if (installation.getStatus() != 3) {
            return null;
        }
        updateInstallation(installation, z ? 3 : 0, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleInstallationResult$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Installation installation, InstallStatus installStatus) {
        if (InstallStatus.Status.CANCELED.equals(installStatus.getStatus())) {
            this.installerAnalytics.logInstallCancelEvent(installation.getPackageName(), installation.getVersionCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleInstallationResult$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Installation installation, boolean z, InstallStatus installStatus) {
        Logger.getInstance().d("Installer", "status: " + installStatus.getStatus().name() + " " + installation.getPackageName());
        updateInstallation(installation, z ? 3 : 0, map(installStatus));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Installation lambda$handleInstallationResult$35(Installation installation, Object obj) {
        return installation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$install$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(Boolean bool) {
        this.installerAnalytics.installationType(ManagerPreferences.allowRootInstallation(this.sharedPreferences), bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$install$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e l(String str, Boolean bool) {
        return this.installationProvider.getInstallation(str).E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$install$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(boolean z, boolean z2, Installation installation) {
        installation.setStatus(3);
        installation.setType(-1);
        this.installCandidateSubject.onNext(new InstallationCandidate(installation, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$moveInstallationFiles$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(Installation installation) {
        String str = OBB_FOLDER + installation.getPackageName() + "/";
        this.fileUtils.deleteDir(new File(str));
        for (RoomFileToDownload roomFileToDownload : installation.getFiles()) {
            if (roomFileToDownload.getFileType() == 1 && FileUtils.fileExists(roomFileToDownload.getFilePath()) && !roomFileToDownload.getPath().equals(str)) {
                this.fileUtils.copyFile(roomFileToDownload.getPath(), str, roomFileToDownload.getFileName());
                roomFileToDownload.setPath(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Installation lambda$rootInstall$24(Installation installation, Void r1) {
        return installation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$rootInstall$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e o(Installation installation, Throwable th) {
        if (th instanceof RootCommandTimeoutException) {
            return updateInstallation(installation, 1, 5).save().M();
        }
        return rx.e.C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startInstallation$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e p(Installation installation, Throwable th) {
        return rootInstall(installation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startInstallation$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e q(Context context, Installation installation, boolean z, Throwable th) {
        return defaultInstall(context, installation, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Installation lambda$systemInstall$28(Installation installation, Void r1) {
        return installation;
    }

    private /* synthetic */ Void lambda$uninstall$16(String str, Uri uri) throws Exception {
        startUninstallIntent(this.context, str, uri);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$uninstall$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e s(IntentFilter intentFilter, String str, Void r3) {
        return waitPackageIntent(this.context, intentFilter, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$waitPackageIntent$37(Intent intent) {
        return null;
    }

    private AppInstall map(Installation installation) {
        AppInstall.InstallBuilder baseApk = AppInstall.builder().setPackageName(installation.getPackageName()).setBaseApk(installation.getFile());
        for (RoomFileToDownload roomFileToDownload : installation.getFiles()) {
            if (3 == roomFileToDownload.getFileType()) {
                baseApk.addApkSplit(new File(roomFileToDownload.getFilePath()));
            }
        }
        return baseApk.build();
    }

    private rx.b moveInstallationFiles(final Installation installation) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.install.installer.f0
            @Override // rx.m.a
            public final void call() {
                DefaultInstaller.this.n(installation);
            }
        }).a(installation.saveFileChanges()).n(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.o
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeInstallationFiles(Installation installation) {
        for (RoomFileToDownload roomFileToDownload : installation.getFiles()) {
            if (roomFileToDownload.getFileType() != 1) {
                FileUtils.removeFile(roomFileToDownload.getFilePath());
                Logger.getInstance().d(TAG, "removing the file " + roomFileToDownload.getFilePath() + " " + roomFileToDownload.getFileName());
            }
        }
    }

    private rx.e<Installation> rootInstall(final Installation installation) {
        if (ManagerPreferences.allowRootInstallation(this.sharedPreferences)) {
            return rx.e.l(this.rootInstallerProvider.provideRootInstaller(installation)).I0(Schedulers.computation()).X(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.k
                @Override // rx.m.e
                public final Object call(Object obj) {
                    Installation installation2 = Installation.this;
                    DefaultInstaller.lambda$rootInstall$24(installation2, (Void) obj);
                    return installation2;
                }
            }).C0(updateInstallation(installation, 1, 3)).o0(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.l
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return DefaultInstaller.this.o(installation, (Throwable) obj);
                }
            });
        }
        return rx.e.C(new InstallationException("User doesn't allow root installation"));
    }

    private rx.e<Installation> startDefaultInstallation(Context context, Installation installation, boolean z) {
        return defaultInstall(context, installation, z).G(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e b2;
                b2 = r1.save().b(rx.e.S((Installation) obj));
                return b2;
            }
        });
    }

    private void startInstallIntent(Context context, File file) {
        Uri fromFile;
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT > 23) {
            fromFile = FileProvider.e(context, "cm.aptoide.pt.provider", file);
        } else {
            fromFile = Uri.fromFile(file);
        }
        Logger.getInstance().v(TAG, fromFile.toString());
        intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
        intent.setFlags(268435459);
        context.startActivity(intent);
    }

    private rx.e<Installation> startInstallation(final Context context, final Installation installation, final boolean z) {
        return systemInstall(context, installation).o0(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DefaultInstaller.this.p(installation, (Throwable) obj);
            }
        }).o0(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.m0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DefaultInstaller.this.q(context, installation, z, (Throwable) obj);
            }
        }).w(t0.f6508f).G(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e b2;
                b2 = r1.save().b(rx.e.S((Installation) obj));
                return b2;
            }
        });
    }

    private void startUninstallIntent(Context context, String str, Uri uri) throws InstallationException {
        try {
            this.packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.UNINSTALL_PACKAGE", uri);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (PackageManager.NameNotFoundException e2) {
            CrashReport.getInstance().log(e2);
            throw new InstallationException(e2);
        }
    }

    private rx.e<Installation> systemInstall(Context context, final Installation installation) {
        if (isSystem(context)) {
            if (Build.VERSION.SDK_INT >= 28) {
                return defaultInstall(context, installation, true);
            }
            return rx.e.l(new SystemInstallOnSubscribe(context, this.packageManager, Uri.fromFile(installation.getFile()))).I0(Schedulers.computation()).X(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.x
                @Override // rx.m.e
                public final Object call(Object obj) {
                    Installation installation2 = Installation.this;
                    DefaultInstaller.lambda$systemInstall$28(installation2, (Void) obj);
                    return installation2;
                }
            }).C0(updateInstallation(installation, 2, 3));
        }
        return rx.e.C(new Throwable());
    }

    private Installation updateInstallation(Installation installation, int i2, int i3) {
        installation.setType(i2);
        installation.setStatus(i3);
        return installation;
    }

    private rx.e<Void> waitPackageIntent(Context context, IntentFilter intentFilter, final String str) {
        return rx.e.l(new BroadcastRegisterOnSubscribe(context, intentFilter, null, null)).F(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((Intent) obj).getData().toString().contains(str));
                return valueOf;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                DefaultInstaller.lambda$waitPackageIntent$37((Intent) obj);
                return null;
            }
        });
    }

    public /* synthetic */ Void b(Installation installation, boolean z, Context context) {
        lambda$defaultInstall$29(installation, z, context);
        return null;
    }

    @Override // cm.aptoide.pt.install.Installer
    public synchronized void dispatchInstallations() {
        rx.t.b bVar = this.dispatchInstallationsSubscription;
        rx.e s0 = this.installCandidateSubject.G(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.k0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DefaultInstaller.this.c((InstallationCandidate) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DefaultInstaller.this.e((InstallationCandidate) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.a
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }).s0();
        w wVar = new rx.m.b() { // from class: cm.aptoide.pt.install.installer.w
            @Override // rx.m.b
            public final void call(Object obj) {
                DefaultInstaller.lambda$dispatchInstallations$6((Installation) obj);
            }
        };
        t0 t0Var = t0.f6508f;
        bVar.a(s0.H0(wVar, t0Var));
        this.dispatchInstallationsSubscription.a(this.installCandidateSubject.X(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((InstallationCandidate) obj).getInstallation();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DefaultInstaller.this.f((Installation) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.b0
            @Override // rx.m.b
            public final void call(Object obj) {
                DefaultInstaller.this.removeInstallationFiles((Installation) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.s
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }).s0().H0(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.r
            @Override // rx.m.b
            public final void call(Object obj) {
                DefaultInstaller.lambda$dispatchInstallations$11((Installation) obj);
            }
        }, t0Var));
    }

    @Override // cm.aptoide.pt.install.Installer
    public rx.b downgrade(String str, boolean z, boolean z2) {
        return this.installationProvider.getInstallation(str).E().H(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DefaultInstaller.this.g((Installation) obj);
            }
        }).X0().a(install(str, z, z2));
    }

    public PackageManager getPackageManager() {
        return this.packageManager;
    }

    @Override // cm.aptoide.pt.install.Installer
    public rx.e<InstallationState> getState(final String str, final int i2) {
        return this.aptoideInstalledAppsRepository.getAsList(str, i2).X(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DefaultInstaller.lambda$getState$18(str, i2, (RoomInstalled) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.i0
            @Override // rx.m.b
            public final void call(Object obj) {
                Logger.getInstance().d("AptoideDownloadManager", "creating an installation state " + r1.getPackageName() + " state is: " + ((InstallationState) obj).getStatus());
            }
        }).t();
    }

    public /* synthetic */ Void h(Installation installation, boolean z) {
        lambda$handleInstallationResult$31(installation, z);
        return null;
    }

    @Override // cm.aptoide.pt.install.Installer
    public rx.b install(final String str, final boolean z, final boolean z2) {
        return this.rootAvailabilityManager.isRootAvailable().g(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.b
            @Override // rx.m.b
            public final void call(Object obj) {
                DefaultInstaller.this.k((Boolean) obj);
            }
        }).k(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.a0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DefaultInstaller.this.l(str, (Boolean) obj);
            }
        }).j0(Schedulers.computation()).x(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.y
            @Override // rx.m.b
            public final void call(Object obj) {
                DefaultInstaller.this.m(z, z2, (Installation) obj);
            }
        }).w(t0.f6508f).E().Z0().z();
    }

    public /* synthetic */ Void r(String str, Uri uri) {
        lambda$uninstall$16(str, uri);
        return null;
    }

    @Override // cm.aptoide.pt.install.Installer
    public void stopDispatching() {
        this.dispatchInstallationsSubscription.b();
        if (this.dispatchInstallationsSubscription.isUnsubscribed()) {
            return;
        }
        this.dispatchInstallationsSubscription.unsubscribe();
    }

    @Override // cm.aptoide.pt.install.Installer
    public rx.b uninstall(final String str) {
        final Uri fromParts = Uri.fromParts(Constants.PACKAGE, str, null);
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme(Constants.PACKAGE);
        return rx.e.P(new Callable() { // from class: cm.aptoide.pt.install.installer.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                DefaultInstaller.this.r(str, fromParts);
                return null;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.install.installer.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DefaultInstaller.this.s(intentFilter, str, (Void) obj);
            }
        }).X0();
    }

    @Override // cm.aptoide.pt.install.Installer
    public rx.b update(String str, boolean z, boolean z2) {
        return install(str, z, z2);
    }

    private int map(InstallStatus installStatus) {
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[installStatus.getStatus().ordinal()];
        if (i2 == 1) {
            return 3;
        }
        if (i2 != 2) {
            return i2 != 3 ? 1 : 6;
        }
        return 4;
    }
}
