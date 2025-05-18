package cm.aptoide.pt;

import java.util.Collection;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ApplicationModule_ProvidesIndicativeEventsFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesIndicativeEventsFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesIndicativeEventsFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesIndicativeEventsFactory(applicationModule);
    }

    public static Collection<String> providesIndicativeEvents(ApplicationModule applicationModule) {
        return (Collection) f.b.b.c(applicationModule.providesIndicativeEvents());
    }

    @Override // javax.inject.Provider
    public Collection<String> get() {
        return providesIndicativeEvents(this.module);
    }
}
