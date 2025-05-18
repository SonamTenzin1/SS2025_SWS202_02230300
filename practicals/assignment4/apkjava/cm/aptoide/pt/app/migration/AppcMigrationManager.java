package cm.aptoide.pt.app.migration;

import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import rx.e;

/* loaded from: classes.dex */
public class AppcMigrationManager {
    private static final long BDS_STORE_ID = 1966380;
    private AppcMigrationRepository appcMigrationRepository;
    private AptoideInstalledAppsRepository repository;

    public AppcMigrationManager(AptoideInstalledAppsRepository aptoideInstalledAppsRepository, AppcMigrationRepository appcMigrationRepository) {
        this.repository = aptoideInstalledAppsRepository;
        this.appcMigrationRepository = appcMigrationRepository;
    }

    public void addMigrationCandidate(String str) {
        this.appcMigrationRepository.addMigrationCandidate(str);
    }

    public e<Boolean> isAppMigrated(String str) {
        return this.appcMigrationRepository.isAppMigrated(str);
    }

    public e<Boolean> isMigrationApp(String str, final String str2, final int i2, final long j2, final boolean z) {
        return this.repository.getInstalled(str).X(new rx.m.e() { // from class: cm.aptoide.pt.app.migration.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                String str3 = str2;
                int i3 = i2;
                long j3 = j2;
                boolean z2 = z;
                valueOf = Boolean.valueOf((r6 == null || r1 == null || r6.getSignature() == null || r1.equals(r6.getSignature()) || r6.getVersionCode() > r2 || r3 != AppcMigrationManager.BDS_STORE_ID || !r5) ? false : true);
                return valueOf;
            }
        });
    }

    public void persistCandidate(String str) {
        this.appcMigrationRepository.persistCandidate(str);
    }
}
