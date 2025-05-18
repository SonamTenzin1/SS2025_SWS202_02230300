package cm.aptoide.pt.install;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.ads.MinimalAdMapper;
import cm.aptoide.pt.app.CampaignAnalytics;
import cm.aptoide.pt.app.aptoideinstall.AptoideInstallManager;
import cm.aptoide.pt.app.migration.AppcMigrationManager;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.RoomStoredMinimalAdPersistence;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.database.room.RoomStoredMinimalAd;
import cm.aptoide.pt.dataprovider.ads.AdNetworkUtils;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.root.RootAvailabilityManager;
import cm.aptoide.pt.updates.UpdateRepository;
import cm.aptoide.pt.util.ReferrerUtils;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.FileUtils;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import rx.schedulers.Schedulers;

/* loaded from: classes.dex */
public class InstalledIntentService extends IntentService {
    private static final String TAG = InstalledIntentService.class.getName();
    private MinimalAdMapper adMapper;

    @Inject
    AppcMigrationManager appcMigrationManager;

    @Inject
    AptoideInstallManager aptoideInstallManager;

    @Inject
    CampaignAnalytics campaignAnalytics;

    @Inject
    FileUtils fileUtils;

    @Inject
    InstallAnalytics installAnalytics;
    private InstallManager installManager;
    private PackageManager packageManager;

    @Inject
    RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence;
    private RootAvailabilityManager rootAvailabilityManager;
    private SharedPreferences sharedPreferences;
    private rx.t.b subscriptions;

    @Inject
    UpdateRepository updatesRepository;

    public InstalledIntentService() {
        super("InstalledIntentService");
    }

    private void checkAndBroadcastReferrer(final String str) {
        this.subscriptions.a(this.roomStoredMinimalAdPersistence.get(str).j0(Schedulers.io()).H(new rx.m.e() { // from class: cm.aptoide.pt.install.j2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return InstalledIntentService.this.a(str, (RoomStoredMinimalAd) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.install.l2
            @Override // rx.m.b
            public final void call(Object obj) {
                InstalledIntentService.lambda$checkAndBroadcastReferrer$3((RoomStoredMinimalAd) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.h2
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }

    private boolean checkAndLogNullPackageInfo(PackageInfo packageInfo, String str) {
        if (packageInfo != null) {
            return false;
        }
        CrashReport.getInstance().log(new IllegalArgumentException("PackageName null for package " + str));
        return true;
    }

    private PackageInfo databaseOnPackageAdded(String str) {
        PackageInfo packageInfo = AptoideUtils.SystemU.getPackageInfo(str, getPackageManager());
        if (checkAndLogNullPackageInfo(packageInfo, str)) {
            return packageInfo;
        }
        this.installManager.onAppInstalled(new RoomInstalled(packageInfo, this.packageManager, this.fileUtils)).I(new rx.m.a() { // from class: cm.aptoide.pt.install.d2
            @Override // rx.m.a
            public final void call() {
                InstalledIntentService.lambda$databaseOnPackageAdded$0();
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.k2
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
        return packageInfo;
    }

    private void databaseOnPackageRemoved(final String str) {
        this.installManager.onAppRemoved(str).a(this.updatesRepository.remove(str)).I(new rx.m.a() { // from class: cm.aptoide.pt.install.f2
            @Override // rx.m.a
            public final void call() {
                Logger.getInstance().d(InstalledIntentService.TAG, "databaseOnPackageRemoved: " + str);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.i2
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    private PackageInfo databaseOnPackageReplaced(final String str) {
        PackageInfo packageInfo = AptoideUtils.SystemU.getPackageInfo(str, getPackageManager());
        if (checkAndLogNullPackageInfo(packageInfo, str)) {
            return packageInfo;
        }
        this.installManager.onUpdateConfirmed(new RoomInstalled(packageInfo, this.packageManager, this.fileUtils)).a(this.updatesRepository.remove(str)).I(new rx.m.a() { // from class: cm.aptoide.pt.install.g2
            @Override // rx.m.a
            public final void call() {
                Logger.getInstance().d(InstalledIntentService.TAG, "databaseOnPackageReplaced: " + str);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.e2
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
        return packageInfo;
    }

    private rx.b knockCpi(final String str, final RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence, final RoomStoredMinimalAd roomStoredMinimalAd) {
        return rx.b.u(new Callable() { // from class: cm.aptoide.pt.install.m2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                InstalledIntentService.this.b(str, roomStoredMinimalAd, roomStoredMinimalAdPersistence);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkAndBroadcastReferrer$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(String str, RoomStoredMinimalAd roomStoredMinimalAd) {
        if (roomStoredMinimalAd != null) {
            return knockCpi(str, this.roomStoredMinimalAdPersistence, roomStoredMinimalAd);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$checkAndBroadcastReferrer$3(RoomStoredMinimalAd roomStoredMinimalAd) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$databaseOnPackageAdded$0() {
    }

    private /* synthetic */ Object lambda$knockCpi$9(String str, RoomStoredMinimalAd roomStoredMinimalAd, RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence) throws Exception {
        ReferrerUtils.broadcastReferrer(str, roomStoredMinimalAd.getReferrer(), getApplicationContext());
        AdNetworkUtils.knockCpi(this.adMapper.map(roomStoredMinimalAd));
        roomStoredMinimalAdPersistence.remove(roomStoredMinimalAd);
        return null;
    }

    private void reportPackageInfoNullEvent() {
        CrashReport.getInstance().log(new NullPointerException("PackageInfo is null."));
    }

    private void sendCampaignConversion(String str, PackageInfo packageInfo) {
        if (packageInfo != null) {
            this.campaignAnalytics.convertCampaignEvent(str, packageInfo.versionCode);
        } else {
            reportPackageInfoNullEvent();
        }
    }

    private void sendInstallEvent(String str, PackageInfo packageInfo) {
        if (packageInfo != null) {
            this.installAnalytics.installCompleted(str, packageInfo.versionCode, this.rootAvailabilityManager.isRootAvailable().y().b().booleanValue(), ManagerPreferences.allowRootInstallation(this.sharedPreferences));
        } else {
            reportPackageInfoNullEvent();
        }
    }

    private void sendUninstallEvent(String str) {
        this.installAnalytics.uninstallCompleted(str);
    }

    public /* synthetic */ Object b(String str, RoomStoredMinimalAd roomStoredMinimalAd, RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence) {
        lambda$knockCpi$9(str, roomStoredMinimalAd, roomStoredMinimalAdPersistence);
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ((AptoideApplication) getApplicationContext()).getApplicationComponent().inject(this);
        this.adMapper = new MinimalAdMapper();
        this.sharedPreferences = ((AptoideApplication) getApplicationContext()).getDefaultSharedPreferences();
        ((AptoideApplication) getApplicationContext()).getDefaultSharedPreferences();
        this.subscriptions = new rx.t.b();
        this.installManager = ((AptoideApplication) getApplicationContext()).getInstallManager();
        this.rootAvailabilityManager = ((AptoideApplication) getApplicationContext()).getRootAvailabilityManager();
        this.packageManager = getPackageManager();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
    
        if (r0.equals("android.intent.action.PACKAGE_REPLACED") == false) goto L10;
     */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            String encodedSchemeSpecificPart = intent.getData().getEncodedSchemeSpecificPart();
            char c2 = 0;
            if (TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED") || !intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                action.hashCode();
                switch (action.hashCode()) {
                    case -810471698:
                        break;
                    case 525384130:
                        if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1544582882:
                        if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        onPackageReplaced(encodedSchemeSpecificPart);
                        return;
                    case 1:
                        onPackageRemoved(encodedSchemeSpecificPart);
                        return;
                    case 2:
                        onPackageAdded(encodedSchemeSpecificPart);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    protected void onPackageAdded(String str) {
        Logger.getInstance().d(TAG, "Package added: " + str);
        PackageInfo databaseOnPackageAdded = databaseOnPackageAdded(str);
        checkAndBroadcastReferrer(str);
        sendInstallEvent(str, databaseOnPackageAdded);
        sendCampaignConversion(str, databaseOnPackageAdded);
        this.appcMigrationManager.persistCandidate(str);
        this.aptoideInstallManager.persistCandidate(str);
    }

    protected void onPackageRemoved(String str) {
        Logger.getInstance().d(TAG, "Packaged removed: " + str);
        sendUninstallEvent(str);
        databaseOnPackageRemoved(str);
    }

    protected void onPackageReplaced(String str) {
        Logger.getInstance().d(TAG, "Packaged replaced: " + str);
        PackageInfo databaseOnPackageReplaced = databaseOnPackageReplaced(str);
        sendInstallEvent(str, databaseOnPackageReplaced);
        sendCampaignConversion(str, databaseOnPackageReplaced);
        this.aptoideInstallManager.persistCandidate(str);
    }
}
