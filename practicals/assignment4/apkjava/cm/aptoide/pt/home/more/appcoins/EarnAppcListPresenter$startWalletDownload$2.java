package cm.aptoide.pt.home.more.appcoins;

import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.actions.PermissionService;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.schedulers.Schedulers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EarnAppcListPresenter.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lrx/Observable;", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "it", HttpUrl.FRAGMENT_ENCODE_SET, "call"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EarnAppcListPresenter$startWalletDownload$2<T, R> implements rx.m.e {
    final /* synthetic */ rx.b $actionCompletable;
    final /* synthetic */ EarnAppcListPresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EarnAppcListPresenter$startWalletDownload$2(EarnAppcListPresenter earnAppcListPresenter, rx.b bVar) {
        this.this$0 = earnAppcListPresenter;
        this.$actionCompletable = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: call$lambda-0, reason: not valid java name */
    public static final rx.e m232call$lambda0(EarnAppcListPresenter earnAppcListPresenter, Void r1) {
        PermissionManager permissionManager;
        PermissionService permissionService;
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        permissionManager = earnAppcListPresenter.permissionManager;
        permissionService = earnAppcListPresenter.permissionService;
        return permissionManager.requestExternalStoragePermission(permissionService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: call$lambda-1, reason: not valid java name */
    public static final rx.b m233call$lambda1(rx.b bVar, Void r1) {
        kotlin.jvm.internal.m.f(bVar, "$actionCompletable");
        return bVar;
    }

    @Override // rx.m.e
    public final rx.e<? extends Void> call(Void r3) {
        PermissionManager permissionManager;
        PermissionService permissionService;
        permissionManager = this.this$0.permissionManager;
        permissionService = this.this$0.permissionService;
        rx.e<Void> requestDownloadAllowingMobileData = permissionManager.requestDownloadAllowingMobileData(permissionService);
        final EarnAppcListPresenter earnAppcListPresenter = this.this$0;
        rx.e<R> j0 = requestDownloadAllowingMobileData.G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.y0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e m232call$lambda0;
                m232call$lambda0 = EarnAppcListPresenter$startWalletDownload$2.m232call$lambda0(EarnAppcListPresenter.this, (Void) obj);
                return m232call$lambda0;
            }
        }).j0(Schedulers.io());
        final rx.b bVar = this.$actionCompletable;
        return j0.H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.x0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.b m233call$lambda1;
                m233call$lambda1 = EarnAppcListPresenter$startWalletDownload$2.m233call$lambda1(rx.b.this, (Void) obj);
                return m233call$lambda1;
            }
        });
    }
}
