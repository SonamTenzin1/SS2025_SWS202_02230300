package cm.aptoide.pt;

import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes.dex */
public final class ApplicationModule_ProvidesV7CacheRetrofitFactory implements Provider {
    private final Provider<String> baseHostProvider;
    private final Provider<Converter.Factory> converterFactoryProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final ApplicationModule module;
    private final Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider;

    public ApplicationModule_ProvidesV7CacheRetrofitFactory(ApplicationModule applicationModule, Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Converter.Factory> provider3, Provider<CallAdapter.Factory> provider4) {
        this.module = applicationModule;
        this.baseHostProvider = provider;
        this.httpClientProvider = provider2;
        this.converterFactoryProvider = provider3;
        this.rxCallAdapterFactoryProvider = provider4;
    }

    public static ApplicationModule_ProvidesV7CacheRetrofitFactory create(ApplicationModule applicationModule, Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Converter.Factory> provider3, Provider<CallAdapter.Factory> provider4) {
        return new ApplicationModule_ProvidesV7CacheRetrofitFactory(applicationModule, provider, provider2, provider3, provider4);
    }

    public static Retrofit providesV7CacheRetrofit(ApplicationModule applicationModule, String str, OkHttpClient okHttpClient, Converter.Factory factory, CallAdapter.Factory factory2) {
        return (Retrofit) f.b.b.c(applicationModule.providesV7CacheRetrofit(str, okHttpClient, factory, factory2));
    }

    @Override // javax.inject.Provider
    public Retrofit get() {
        return providesV7CacheRetrofit(this.module, this.baseHostProvider.get(), this.httpClientProvider.get(), this.converterFactoryProvider.get(), this.rxCallAdapterFactoryProvider.get());
    }
}
