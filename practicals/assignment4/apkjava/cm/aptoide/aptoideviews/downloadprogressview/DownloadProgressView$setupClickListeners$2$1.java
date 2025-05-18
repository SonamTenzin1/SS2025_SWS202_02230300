package cm.aptoide.aptoideviews.downloadprogressview;

import cm.aptoide.aptoideviews.downloadprogressview.Event;
import cm.aptoide.aptoideviews.downloadprogressview.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadProgressView.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DownloadProgressView$setupClickListeners$2$1 extends Lambda implements Function0<u> {
    final /* synthetic */ DownloadProgressView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadProgressView$setupClickListeners$2$1(DownloadProgressView downloadProgressView) {
        super(0);
        this.this$0 = downloadProgressView;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z;
        e.i.a aVar;
        e.i.a aVar2;
        e.i.a aVar3;
        z = this.this$0.isPausable;
        if (z) {
            aVar = this.this$0.stateMachine;
            if (m.a(aVar.b(), State.InProgress.INSTANCE)) {
                aVar3 = this.this$0.stateMachine;
                aVar3.g(Event.PauseClick.INSTANCE);
            } else {
                aVar2 = this.this$0.stateMachine;
                aVar2.g(Event.ResumeClick.INSTANCE);
            }
        }
    }
}
