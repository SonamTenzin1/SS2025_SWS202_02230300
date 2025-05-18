package cm.aptoide.aptoideviews.video;

import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import cm.aptoide.aptoideviews.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YoutubePlayer.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class YoutubePlayer$setListeners$1 extends Lambda implements Function0<u> {
    final /* synthetic */ YoutubePlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YoutubePlayer$setListeners$1(YoutubePlayer youtubePlayer) {
        super(0);
        this.this$0 = youtubePlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m13invoke$lambda0(YoutubePlayer youtubePlayer) {
        m.f(youtubePlayer, "this$0");
        ((YoutubeWebViewPlayer) youtubePlayer._$_findCachedViewById(R.id.webview)).setVisibility(0);
        ((ProgressBar) youtubePlayer._$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        ((TextView) youtubePlayer._$_findCachedViewById(R.id.status_text)).setVisibility(8);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Handler handler;
        handler = this.this$0.threadHandler;
        final YoutubePlayer youtubePlayer = this.this$0;
        handler.postDelayed(new Runnable() { // from class: cm.aptoide.aptoideviews.video.b
            @Override // java.lang.Runnable
            public final void run() {
                YoutubePlayer$setListeners$1.m13invoke$lambda0(YoutubePlayer.this);
            }
        }, 500L);
    }
}
