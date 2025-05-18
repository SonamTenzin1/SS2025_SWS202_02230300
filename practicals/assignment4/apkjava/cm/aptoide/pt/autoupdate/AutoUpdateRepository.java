package cm.aptoide.pt.autoupdate;

import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.Single;

/* compiled from: AutoUpdateRepository.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcm/aptoide/pt/autoupdate/AutoUpdateRepository;", HttpUrl.FRAGMENT_ENCODE_SET, "autoUpdateService", "Lcm/aptoide/pt/autoupdate/AutoUpdateService;", "(Lcm/aptoide/pt/autoupdate/AutoUpdateService;)V", "autoUpdateModel", "Lcm/aptoide/pt/autoupdate/AutoUpdateModel;", "loadAndSaveAutoUpdateModel", "Lrx/Single;", "loadAutoUpdateModel", "loadFreshAutoUpdateModel", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AutoUpdateRepository {
    private AutoUpdateModel autoUpdateModel;
    private final AutoUpdateService autoUpdateService;

    public AutoUpdateRepository(AutoUpdateService autoUpdateService) {
        kotlin.jvm.internal.m.f(autoUpdateService, "autoUpdateService");
        this.autoUpdateService = autoUpdateService;
    }

    private final Single<AutoUpdateModel> loadAndSaveAutoUpdateModel() {
        Single<AutoUpdateModel> g2 = this.autoUpdateService.loadAutoUpdateModel().g(new rx.m.b() { // from class: cm.aptoide.pt.autoupdate.t
            @Override // rx.m.b
            public final void call(Object obj) {
                AutoUpdateRepository.m69loadAndSaveAutoUpdateModel$lambda0(AutoUpdateRepository.this, (AutoUpdateModel) obj);
            }
        });
        kotlin.jvm.internal.m.e(g2, "autoUpdateService.loadAu… { autoUpdateModel = it }");
        return g2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadAndSaveAutoUpdateModel$lambda-0, reason: not valid java name */
    public static final void m69loadAndSaveAutoUpdateModel$lambda0(AutoUpdateRepository autoUpdateRepository, AutoUpdateModel autoUpdateModel) {
        kotlin.jvm.internal.m.f(autoUpdateRepository, "this$0");
        kotlin.jvm.internal.m.e(autoUpdateModel, "it");
        autoUpdateRepository.autoUpdateModel = autoUpdateModel;
    }

    public final Single<AutoUpdateModel> loadAutoUpdateModel() {
        AutoUpdateModel autoUpdateModel = this.autoUpdateModel;
        if (autoUpdateModel != null) {
            if (autoUpdateModel == null) {
                kotlin.jvm.internal.m.w("autoUpdateModel");
                autoUpdateModel = null;
            }
            Single<AutoUpdateModel> m = Single.m(autoUpdateModel);
            kotlin.jvm.internal.m.e(m, "{\n      Single.just(autoUpdateModel)\n    }");
            return m;
        }
        return loadAndSaveAutoUpdateModel();
    }

    public final Single<AutoUpdateModel> loadFreshAutoUpdateModel() {
        return loadAndSaveAutoUpdateModel();
    }
}
