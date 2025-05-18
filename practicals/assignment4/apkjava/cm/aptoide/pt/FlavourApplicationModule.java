package cm.aptoide.pt;

import cm.aptoide.accountmanager.AccountService;
import cm.aptoide.accountmanager.AdultContent;
import cm.aptoide.pt.account.LoginPreferences;
import cm.aptoide.pt.ads.WalletAdsOfferCardManager;
import cm.aptoide.pt.ads.WalletAdsOfferManager;
import cm.aptoide.pt.blacklist.BlacklistManager;
import cm.aptoide.pt.install.PackageRepository;
import cm.aptoide.pt.preferences.AdultContentManager;
import cm.aptoide.pt.preferences.LocalPersistenceAdultContent;
import cm.aptoide.pt.preferences.Preferences;
import cm.aptoide.pt.preferences.SecurePreferences;
import com.google.android.gms.common.GoogleApiAvailability;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public class FlavourApplicationModule {
    private final AptoideApplication application;

    public FlavourApplicationModule(AptoideApplication aptoideApplication) {
        this.application = aptoideApplication;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Singleton
    public AdultContent provideAdultContent(LocalPersistenceAdultContent localPersistenceAdultContent, AccountService accountService) {
        return new AdultContentManager(localPersistenceAdultContent, accountService);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Singleton
    @Named
    public String provideAutoUpdateStoreName() {
        return "v9";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Singleton
    public LocalPersistenceAdultContent provideLocalAdultContent(Preferences preferences, @Named("secure") SecurePreferences securePreferences) {
        return new LocalPersistenceAdultContent(preferences, securePreferences);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Singleton
    public LoginPreferences provideLoginPreferences() {
        return new LoginPreferences(this.application, GoogleApiAvailability.q());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Singleton
    @Named
    public String providePartnerID() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Singleton
    @Named
    public String providesSupportEmail() {
        return this.application.getString(R.string.aptoide_email);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Singleton
    public WalletAdsOfferCardManager providesWalletAdsOfferCardManager(BlacklistManager blacklistManager, PackageRepository packageRepository) {
        return new WalletAdsOfferCardManager(blacklistManager, packageRepository);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Singleton
    public WalletAdsOfferManager providesWalletAdsOfferManager() {
        return new WalletAdsOfferManager(this.application.getApplicationContext().getPackageManager());
    }
}
