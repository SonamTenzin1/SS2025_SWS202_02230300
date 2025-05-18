package cm.aptoide.aptoideviews.video;

import android.widget.ProgressBar;
import android.widget.TextView;
import cm.aptoide.aptoideviews.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import okhttp3.HttpUrl;

/* compiled from: YoutubePlayer.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
final class YoutubePlayer$setListeners$2 extends Lambda implements Function0<u> {
    final /* synthetic */ YoutubePlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YoutubePlayer$setListeners$2(YoutubePlayer youtubePlayer) {
        super(0);
        this.this$0 = youtubePlayer;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((TextView) this.this$0._$_findCachedViewById(R.id.status_text)).setVisibility(0);
        ((YoutubeWebViewPlayer) this.this$0._$_findCachedViewById(R.id.webview)).setVisibility(4);
        ((ProgressBar) this.this$0._$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
    }
}
