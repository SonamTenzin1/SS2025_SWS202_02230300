package cm.aptoide.pt;

import cm.aptoide.pt.abtesting.AbTestCacheValidator;
import cm.aptoide.pt.abtesting.ExperimentModel;
import java.util.HashMap;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ApplicationModule_ProvidesAbTestCacheValidatorFactory implements Provider {
    private final Provider<HashMap<String, ExperimentModel>> localCacheProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAbTestCacheValidatorFactory(ApplicationModule applicationModule, Provider<HashMap<String, ExperimentModel>> provider) {
        this.module = applicationModule;
        this.localCacheProvider = provider;
    }

    public static ApplicationModule_ProvidesAbTestCacheValidatorFactory create(ApplicationModule applicationModule, Provider<HashMap<String, ExperimentModel>> provider) {
        return new ApplicationModule_ProvidesAbTestCacheValidatorFactory(applicationModule, provider);
    }

    public static AbTestCacheValidator providesAbTestCacheValidator(ApplicationModule applicationModule, HashMap<String, ExperimentModel> hashMap) {
        return (AbTestCacheValidator) f.b.b.c(applicationModule.providesAbTestCacheValidator(hashMap));
    }

    @Override // javax.inject.Provider
    public AbTestCacheValidator get() {
        return providesAbTestCacheValidator(this.module, this.localCacheProvider.get());
    }
}
