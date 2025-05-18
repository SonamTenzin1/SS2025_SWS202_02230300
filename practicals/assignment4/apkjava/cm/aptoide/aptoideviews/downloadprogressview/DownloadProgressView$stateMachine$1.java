package cm.aptoide.aptoideviews.downloadprogressview;

import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import cm.aptoide.aptoideviews.R;
import cm.aptoide.aptoideviews.common.AnimatedImageView;
import cm.aptoide.aptoideviews.common.Debouncer;
import cm.aptoide.aptoideviews.downloadprogressview.DownloadEventListener;
import cm.aptoide.aptoideviews.downloadprogressview.Event;
import cm.aptoide.aptoideviews.downloadprogressview.State;
import e.i.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadProgressView.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/tinder/StateMachine$GraphBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DownloadProgressView$stateMachine$1 extends Lambda implements Function1<a.c<State, Event, Object>, u> {
    final /* synthetic */ DownloadProgressView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadProgressView.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/tinder/StateMachine$GraphBuilder$StateDefinitionBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State$Queue;", "Lcom/tinder/StateMachine$GraphBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<a.c<State, Event, Object>.C0285a<State.Queue>, u> {
        final /* synthetic */ DownloadProgressView this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Queue;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C01051 extends Lambda implements Function2<State.Queue, Event, u> {
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01051(DownloadProgressView downloadProgressView) {
                super(2);
                this.this$0 = downloadProgressView;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ u invoke(State.Queue queue, Event event) {
                invoke2(queue, event);
                return u.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(State.Queue queue, Event event) {
                String str;
                m.f(queue, "$this$onEnter");
                m.f(event, "it");
                Log.d("DownloadProgressView", "State.Queue");
                this.this$0.resetProgress();
                ((ProgressBar) this.this$0._$_findCachedViewById(R.id.progressBar)).setIndeterminate(true);
                ((ImageView) this.this$0._$_findCachedViewById(R.id.cancelButton)).setVisibility(4);
                ((AnimatedImageView) this.this$0._$_findCachedViewById(R.id.resumePauseButton)).setVisibility(8);
                ((TextView) this.this$0._$_findCachedViewById(R.id.downloadProgressNumber)).setVisibility(8);
                TextSwitcher textSwitcher = (TextSwitcher) this.this$0._$_findCachedViewById(R.id.downloadState);
                str = this.this$0.downloadingText;
                textSwitcher.setText(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Queue;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$DownloadStart;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$1$2, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends Lambda implements Function2<State.Queue, Event.DownloadStart, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Queue> $this_state;
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DownloadProgressView downloadProgressView, a.c<State, Event, Object>.C0285a<State.Queue> c0285a) {
                super(2);
                this.this$0 = downloadProgressView;
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Queue queue, Event.DownloadStart downloadStart) {
                Debouncer debouncer;
                m.f(queue, "$this$on");
                m.f(downloadStart, "it");
                debouncer = this.this$0.debouncer;
                debouncer.reset();
                return a.c.C0285a.g(this.$this_state, queue, State.InProgress.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Queue;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$PauseStart;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$1$3, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass3 extends Lambda implements Function2<State.Queue, Event.PauseStart, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Queue> $this_state;
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(DownloadProgressView downloadProgressView, a.c<State, Event, Object>.C0285a<State.Queue> c0285a) {
                super(2);
                this.this$0 = downloadProgressView;
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Queue queue, Event.PauseStart pauseStart) {
                Debouncer debouncer;
                m.f(queue, "$this$on");
                m.f(pauseStart, "it");
                debouncer = this.this$0.debouncer;
                debouncer.reset();
                return a.c.C0285a.g(this.$this_state, queue, State.InitialPaused.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Queue;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$Reset;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$1$4, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass4 extends Lambda implements Function2<State.Queue, Event.Reset, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Queue> $this_state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(a.c<State, Event, Object>.C0285a<State.Queue> c0285a) {
                super(2);
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Queue queue, Event.Reset reset) {
                m.f(queue, "$this$on");
                m.f(reset, "it");
                return a.c.C0285a.c(this.$this_state, queue, null, 1, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Queue;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$CancelClick;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$1$5, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass5 extends Lambda implements Function2<State.Queue, Event.CancelClick, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Queue> $this_state;
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(DownloadProgressView downloadProgressView, a.c<State, Event, Object>.C0285a<State.Queue> c0285a) {
                super(2);
                this.this$0 = downloadProgressView;
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Queue queue, Event.CancelClick cancelClick) {
                DownloadEventListener downloadEventListener;
                Object obj;
                m.f(queue, "$this$on");
                m.f(cancelClick, "it");
                downloadEventListener = this.this$0.eventListener;
                if (downloadEventListener != null) {
                    DownloadEventListener.Action.Type type = DownloadEventListener.Action.Type.CANCEL;
                    obj = this.this$0.payload;
                    downloadEventListener.onActionClick(new DownloadEventListener.Action(type, obj));
                }
                return a.c.C0285a.g(this.$this_state, queue, State.Canceled.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Queue;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$InstallStart;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$1$6, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass6 extends Lambda implements Function2<State.Queue, Event.InstallStart, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Queue> $this_state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(a.c<State, Event, Object>.C0285a<State.Queue> c0285a) {
                super(2);
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Queue queue, Event.InstallStart installStart) {
                m.f(queue, "$this$on");
                m.f(installStart, "it");
                return a.c.C0285a.g(this.$this_state, queue, State.Installing.INSTANCE, null, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DownloadProgressView downloadProgressView) {
            super(1);
            this.this$0 = downloadProgressView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(a.c<State, Event, Object>.C0285a<State.Queue> c0285a) {
            invoke2(c0285a);
            return u.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(a.c<State, Event, Object>.C0285a<State.Queue> c0285a) {
            m.f(c0285a, "$this$state");
            c0285a.e(new C01051(this.this$0));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, c0285a);
            a.d.C0287a c0287a = a.d.a;
            c0285a.d(c0287a.a(Event.DownloadStart.class), anonymousClass2);
            c0285a.d(c0287a.a(Event.PauseStart.class), new AnonymousClass3(this.this$0, c0285a));
            c0285a.d(c0287a.a(Event.Reset.class), new AnonymousClass4(c0285a));
            c0285a.d(c0287a.a(Event.CancelClick.class), new AnonymousClass5(this.this$0, c0285a));
            c0285a.d(c0287a.a(Event.InstallStart.class), new AnonymousClass6(c0285a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadProgressView.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/tinder/StateMachine$GraphBuilder$StateDefinitionBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State$Canceled;", "Lcom/tinder/StateMachine$GraphBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends Lambda implements Function1<a.c<State, Event, Object>.C0285a<State.Canceled>, u> {
        final /* synthetic */ DownloadProgressView this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Canceled;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$2$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass1 extends Lambda implements Function2<State.Canceled, Event, u> {
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DownloadProgressView downloadProgressView) {
                super(2);
                this.this$0 = downloadProgressView;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ u invoke(State.Canceled canceled, Event event) {
                invoke2(canceled, event);
                return u.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(State.Canceled canceled, Event event) {
                boolean z;
                String str;
                m.f(canceled, "$this$onEnter");
                m.f(event, "it");
                Log.d("DownloadProgressView", "State.Canceled");
                this.this$0.resetProgress();
                ((ProgressBar) this.this$0._$_findCachedViewById(R.id.progressBar)).setIndeterminate(true);
                z = this.this$0.isPausable;
                if (z) {
                    ((ImageView) this.this$0._$_findCachedViewById(R.id.cancelButton)).setVisibility(0);
                    ((AnimatedImageView) this.this$0._$_findCachedViewById(R.id.resumePauseButton)).setVisibility(8);
                } else {
                    ((ImageView) this.this$0._$_findCachedViewById(R.id.cancelButton)).setVisibility(0);
                    ((AnimatedImageView) this.this$0._$_findCachedViewById(R.id.resumePauseButton)).setVisibility(8);
                }
                ((TextView) this.this$0._$_findCachedViewById(R.id.downloadProgressNumber)).setVisibility(8);
                TextSwitcher textSwitcher = (TextSwitcher) this.this$0._$_findCachedViewById(R.id.downloadState);
                str = this.this$0.downloadingText;
                textSwitcher.setText(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Canceled;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$Reset;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$2$2, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C01062 extends Lambda implements Function2<State.Canceled, Event.Reset, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Canceled> $this_state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01062(a.c<State, Event, Object>.C0285a<State.Canceled> c0285a) {
                super(2);
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Canceled canceled, Event.Reset reset) {
                m.f(canceled, "$this$on");
                m.f(reset, "it");
                return a.c.C0285a.g(this.$this_state, canceled, State.Queue.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Canceled;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$DownloadStart;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$2$3, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass3 extends Lambda implements Function2<State.Canceled, Event.DownloadStart, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Canceled> $this_state;
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(DownloadProgressView downloadProgressView, a.c<State, Event, Object>.C0285a<State.Canceled> c0285a) {
                super(2);
                this.this$0 = downloadProgressView;
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Canceled canceled, Event.DownloadStart downloadStart) {
                Debouncer debouncer;
                m.f(canceled, "$this$on");
                m.f(downloadStart, "it");
                debouncer = this.this$0.debouncer;
                debouncer.reset();
                return a.c.C0285a.g(this.$this_state, canceled, State.InProgress.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Canceled;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$PauseStart;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$2$4, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass4 extends Lambda implements Function2<State.Canceled, Event.PauseStart, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Canceled> $this_state;
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(DownloadProgressView downloadProgressView, a.c<State, Event, Object>.C0285a<State.Canceled> c0285a) {
                super(2);
                this.this$0 = downloadProgressView;
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Canceled canceled, Event.PauseStart pauseStart) {
                Debouncer debouncer;
                m.f(canceled, "$this$on");
                m.f(pauseStart, "it");
                debouncer = this.this$0.debouncer;
                debouncer.reset();
                return a.c.C0285a.g(this.$this_state, canceled, State.InitialPaused.INSTANCE, null, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DownloadProgressView downloadProgressView) {
            super(1);
            this.this$0 = downloadProgressView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(a.c<State, Event, Object>.C0285a<State.Canceled> c0285a) {
            invoke2(c0285a);
            return u.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(a.c<State, Event, Object>.C0285a<State.Canceled> c0285a) {
            m.f(c0285a, "$this$state");
            c0285a.e(new AnonymousClass1(this.this$0));
            C01062 c01062 = new C01062(c0285a);
            a.d.C0287a c0287a = a.d.a;
            c0285a.d(c0287a.a(Event.Reset.class), c01062);
            c0285a.d(c0287a.a(Event.DownloadStart.class), new AnonymousClass3(this.this$0, c0285a));
            c0285a.d(c0287a.a(Event.PauseStart.class), new AnonymousClass4(this.this$0, c0285a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadProgressView.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/tinder/StateMachine$GraphBuilder$StateDefinitionBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State$InProgress;", "Lcom/tinder/StateMachine$GraphBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass3 extends Lambda implements Function1<a.c<State, Event, Object>.C0285a<State.InProgress>, u> {
        final /* synthetic */ DownloadProgressView this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$InProgress;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$3$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass1 extends Lambda implements Function2<State.InProgress, Event, u> {
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DownloadProgressView downloadProgressView) {
                super(2);
                this.this$0 = downloadProgressView;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ u invoke(State.InProgress inProgress, Event event) {
                invoke2(inProgress, event);
                return u.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(State.InProgress inProgress, Event event) {
                int i2;
                boolean z;
                String str;
                m.f(inProgress, "$this$onEnter");
                m.f(event, "it");
                Log.d("DownloadProgressView", "State.InProgress");
                DownloadProgressView downloadProgressView = this.this$0;
                i2 = downloadProgressView.currentProgress;
                downloadProgressView.setProgress(i2);
                ((ProgressBar) this.this$0._$_findCachedViewById(R.id.progressBar)).setIndeterminate(false);
                z = this.this$0.isPausable;
                if (z) {
                    ((ImageView) this.this$0._$_findCachedViewById(R.id.cancelButton)).setVisibility(8);
                    ((AnimatedImageView) this.this$0._$_findCachedViewById(R.id.resumePauseButton)).setVisibility(0);
                } else {
                    ((ImageView) this.this$0._$_findCachedViewById(R.id.cancelButton)).setVisibility(0);
                    ((AnimatedImageView) this.this$0._$_findCachedViewById(R.id.resumePauseButton)).setVisibility(8);
                }
                ((AnimatedImageView) this.this$0._$_findCachedViewById(R.id.resumePauseButton)).play();
                ((TextView) this.this$0._$_findCachedViewById(R.id.downloadProgressNumber)).setVisibility(0);
                TextSwitcher textSwitcher = (TextSwitcher) this.this$0._$_findCachedViewById(R.id.downloadState);
                str = this.this$0.downloadingText;
                textSwitcher.setText(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$InProgress;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$PauseClick;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$3$2, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends Lambda implements Function2<State.InProgress, Event.PauseClick, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.InProgress> $this_state;
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DownloadProgressView downloadProgressView, a.c<State, Event, Object>.C0285a<State.InProgress> c0285a) {
                super(2);
                this.this$0 = downloadProgressView;
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.InProgress inProgress, Event.PauseClick pauseClick) {
                DownloadEventListener downloadEventListener;
                Object obj;
                m.f(inProgress, "$this$on");
                m.f(pauseClick, "it");
                downloadEventListener = this.this$0.eventListener;
                if (downloadEventListener != null) {
                    DownloadEventListener.Action.Type type = DownloadEventListener.Action.Type.PAUSE;
                    obj = this.this$0.payload;
                    downloadEventListener.onActionClick(new DownloadEventListener.Action(type, obj));
                }
                return a.c.C0285a.g(this.$this_state, inProgress, State.Paused.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$InProgress;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$PauseStart;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$3$3, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C01073 extends Lambda implements Function2<State.InProgress, Event.PauseStart, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.InProgress> $this_state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01073(a.c<State, Event, Object>.C0285a<State.InProgress> c0285a) {
                super(2);
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.InProgress inProgress, Event.PauseStart pauseStart) {
                m.f(inProgress, "$this$on");
                m.f(pauseStart, "it");
                return a.c.C0285a.g(this.$this_state, inProgress, State.Paused.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$InProgress;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$InstallStart;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$3$4, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass4 extends Lambda implements Function2<State.InProgress, Event.InstallStart, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.InProgress> $this_state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(a.c<State, Event, Object>.C0285a<State.InProgress> c0285a) {
                super(2);
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.InProgress inProgress, Event.InstallStart installStart) {
                m.f(inProgress, "$this$on");
                m.f(installStart, "it");
                return a.c.C0285a.g(this.$this_state, inProgress, State.Installing.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$InProgress;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$Reset;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$3$5, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass5 extends Lambda implements Function2<State.InProgress, Event.Reset, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.InProgress> $this_state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(a.c<State, Event, Object>.C0285a<State.InProgress> c0285a) {
                super(2);
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.InProgress inProgress, Event.Reset reset) {
                m.f(inProgress, "$this$on");
                m.f(reset, "it");
                return a.c.C0285a.g(this.$this_state, inProgress, State.Queue.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$InProgress;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$CancelClick;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$3$6, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass6 extends Lambda implements Function2<State.InProgress, Event.CancelClick, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.InProgress> $this_state;
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(DownloadProgressView downloadProgressView, a.c<State, Event, Object>.C0285a<State.InProgress> c0285a) {
                super(2);
                this.this$0 = downloadProgressView;
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.InProgress inProgress, Event.CancelClick cancelClick) {
                DownloadEventListener downloadEventListener;
                Object obj;
                m.f(inProgress, "$this$on");
                m.f(cancelClick, "it");
                downloadEventListener = this.this$0.eventListener;
                if (downloadEventListener != null) {
                    DownloadEventListener.Action.Type type = DownloadEventListener.Action.Type.CANCEL;
                    obj = this.this$0.payload;
                    downloadEventListener.onActionClick(new DownloadEventListener.Action(type, obj));
                }
                return a.c.C0285a.g(this.$this_state, inProgress, State.Canceled.INSTANCE, null, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(DownloadProgressView downloadProgressView) {
            super(1);
            this.this$0 = downloadProgressView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(a.c<State, Event, Object>.C0285a<State.InProgress> c0285a) {
            invoke2(c0285a);
            return u.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(a.c<State, Event, Object>.C0285a<State.InProgress> c0285a) {
            m.f(c0285a, "$this$state");
            c0285a.e(new AnonymousClass1(this.this$0));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, c0285a);
            a.d.C0287a c0287a = a.d.a;
            c0285a.d(c0287a.a(Event.PauseClick.class), anonymousClass2);
            c0285a.d(c0287a.a(Event.PauseStart.class), new C01073(c0285a));
            c0285a.d(c0287a.a(Event.InstallStart.class), new AnonymousClass4(c0285a));
            c0285a.d(c0287a.a(Event.Reset.class), new AnonymousClass5(c0285a));
            c0285a.d(c0287a.a(Event.CancelClick.class), new AnonymousClass6(this.this$0, c0285a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadProgressView.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/tinder/StateMachine$GraphBuilder$StateDefinitionBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State$Paused;", "Lcom/tinder/StateMachine$GraphBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$4, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass4 extends Lambda implements Function1<a.c<State, Event, Object>.C0285a<State.Paused>, u> {
        final /* synthetic */ DownloadProgressView this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Paused;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$4$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass1 extends Lambda implements Function2<State.Paused, Event, u> {
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DownloadProgressView downloadProgressView) {
                super(2);
                this.this$0 = downloadProgressView;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ u invoke(State.Paused paused, Event event) {
                invoke2(paused, event);
                return u.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(State.Paused paused, Event event) {
                String str;
                m.f(paused, "$this$onEnter");
                m.f(event, "it");
                Log.d("DownloadProgressView", "State.Paused");
                ((ProgressBar) this.this$0._$_findCachedViewById(R.id.progressBar)).setIndeterminate(false);
                ((ImageView) this.this$0._$_findCachedViewById(R.id.cancelButton)).setVisibility(0);
                DownloadProgressView downloadProgressView = this.this$0;
                int i2 = R.id.resumePauseButton;
                ((AnimatedImageView) downloadProgressView._$_findCachedViewById(i2)).setVisibility(0);
                ((AnimatedImageView) this.this$0._$_findCachedViewById(i2)).playReverse();
                ((TextView) this.this$0._$_findCachedViewById(R.id.downloadProgressNumber)).setVisibility(0);
                TextSwitcher textSwitcher = (TextSwitcher) this.this$0._$_findCachedViewById(R.id.downloadState);
                str = this.this$0.pausedText;
                textSwitcher.setText(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Paused;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$ResumeClick;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$4$2, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends Lambda implements Function2<State.Paused, Event.ResumeClick, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Paused> $this_state;
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DownloadProgressView downloadProgressView, a.c<State, Event, Object>.C0285a<State.Paused> c0285a) {
                super(2);
                this.this$0 = downloadProgressView;
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Paused paused, Event.ResumeClick resumeClick) {
                DownloadEventListener downloadEventListener;
                Object obj;
                m.f(paused, "$this$on");
                m.f(resumeClick, "it");
                downloadEventListener = this.this$0.eventListener;
                if (downloadEventListener != null) {
                    DownloadEventListener.Action.Type type = DownloadEventListener.Action.Type.RESUME;
                    obj = this.this$0.payload;
                    downloadEventListener.onActionClick(new DownloadEventListener.Action(type, obj));
                }
                return a.c.C0285a.g(this.$this_state, paused, State.InProgress.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Paused;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$CancelClick;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$4$3, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass3 extends Lambda implements Function2<State.Paused, Event.CancelClick, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Paused> $this_state;
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(DownloadProgressView downloadProgressView, a.c<State, Event, Object>.C0285a<State.Paused> c0285a) {
                super(2);
                this.this$0 = downloadProgressView;
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Paused paused, Event.CancelClick cancelClick) {
                DownloadEventListener downloadEventListener;
                Object obj;
                m.f(paused, "$this$on");
                m.f(cancelClick, "it");
                downloadEventListener = this.this$0.eventListener;
                if (downloadEventListener != null) {
                    DownloadEventListener.Action.Type type = DownloadEventListener.Action.Type.CANCEL;
                    obj = this.this$0.payload;
                    downloadEventListener.onActionClick(new DownloadEventListener.Action(type, obj));
                }
                return a.c.C0285a.g(this.$this_state, paused, State.Canceled.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Paused;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$Reset;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$4$4, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C01084 extends Lambda implements Function2<State.Paused, Event.Reset, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Paused> $this_state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01084(a.c<State, Event, Object>.C0285a<State.Paused> c0285a) {
                super(2);
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Paused paused, Event.Reset reset) {
                m.f(paused, "$this$on");
                m.f(reset, "it");
                return a.c.C0285a.g(this.$this_state, paused, State.Queue.INSTANCE, null, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(DownloadProgressView downloadProgressView) {
            super(1);
            this.this$0 = downloadProgressView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(a.c<State, Event, Object>.C0285a<State.Paused> c0285a) {
            invoke2(c0285a);
            return u.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(a.c<State, Event, Object>.C0285a<State.Paused> c0285a) {
            m.f(c0285a, "$this$state");
            c0285a.e(new AnonymousClass1(this.this$0));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, c0285a);
            a.d.C0287a c0287a = a.d.a;
            c0285a.d(c0287a.a(Event.ResumeClick.class), anonymousClass2);
            c0285a.d(c0287a.a(Event.CancelClick.class), new AnonymousClass3(this.this$0, c0285a));
            c0285a.d(c0287a.a(Event.Reset.class), new C01084(c0285a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadProgressView.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/tinder/StateMachine$GraphBuilder$StateDefinitionBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State$InitialPaused;", "Lcom/tinder/StateMachine$GraphBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$5, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass5 extends Lambda implements Function1<a.c<State, Event, Object>.C0285a<State.InitialPaused>, u> {
        final /* synthetic */ DownloadProgressView this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$InitialPaused;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$5$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass1 extends Lambda implements Function2<State.InitialPaused, Event, u> {
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DownloadProgressView downloadProgressView) {
                super(2);
                this.this$0 = downloadProgressView;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ u invoke(State.InitialPaused initialPaused, Event event) {
                invoke2(initialPaused, event);
                return u.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(State.InitialPaused initialPaused, Event event) {
                int i2;
                String str;
                m.f(initialPaused, "$this$onEnter");
                m.f(event, "it");
                Log.d("DownloadProgressView", "State.InitialPaused");
                ((ProgressBar) this.this$0._$_findCachedViewById(R.id.progressBar)).setIndeterminate(false);
                ((ImageView) this.this$0._$_findCachedViewById(R.id.cancelButton)).setVisibility(0);
                DownloadProgressView downloadProgressView = this.this$0;
                int i3 = R.id.resumePauseButton;
                ((AnimatedImageView) downloadProgressView._$_findCachedViewById(i3)).setVisibility(0);
                ((AnimatedImageView) this.this$0._$_findCachedViewById(i3)).setReverseAsDefault();
                ((TextView) this.this$0._$_findCachedViewById(R.id.downloadProgressNumber)).setVisibility(0);
                DownloadProgressView downloadProgressView2 = this.this$0;
                i2 = downloadProgressView2.currentProgress;
                downloadProgressView2.setProgress(i2);
                TextSwitcher textSwitcher = (TextSwitcher) this.this$0._$_findCachedViewById(R.id.downloadState);
                str = this.this$0.pausedText;
                textSwitcher.setText(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$InitialPaused;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$ResumeClick;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$5$2, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends Lambda implements Function2<State.InitialPaused, Event.ResumeClick, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.InitialPaused> $this_state;
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DownloadProgressView downloadProgressView, a.c<State, Event, Object>.C0285a<State.InitialPaused> c0285a) {
                super(2);
                this.this$0 = downloadProgressView;
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.InitialPaused initialPaused, Event.ResumeClick resumeClick) {
                DownloadEventListener downloadEventListener;
                Object obj;
                m.f(initialPaused, "$this$on");
                m.f(resumeClick, "it");
                downloadEventListener = this.this$0.eventListener;
                if (downloadEventListener != null) {
                    DownloadEventListener.Action.Type type = DownloadEventListener.Action.Type.RESUME;
                    obj = this.this$0.payload;
                    downloadEventListener.onActionClick(new DownloadEventListener.Action(type, obj));
                }
                return a.c.C0285a.g(this.$this_state, initialPaused, State.InProgress.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$InitialPaused;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$CancelClick;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$5$3, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass3 extends Lambda implements Function2<State.InitialPaused, Event.CancelClick, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.InitialPaused> $this_state;
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(DownloadProgressView downloadProgressView, a.c<State, Event, Object>.C0285a<State.InitialPaused> c0285a) {
                super(2);
                this.this$0 = downloadProgressView;
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.InitialPaused initialPaused, Event.CancelClick cancelClick) {
                DownloadEventListener downloadEventListener;
                Object obj;
                m.f(initialPaused, "$this$on");
                m.f(cancelClick, "it");
                downloadEventListener = this.this$0.eventListener;
                if (downloadEventListener != null) {
                    DownloadEventListener.Action.Type type = DownloadEventListener.Action.Type.CANCEL;
                    obj = this.this$0.payload;
                    downloadEventListener.onActionClick(new DownloadEventListener.Action(type, obj));
                }
                return a.c.C0285a.g(this.$this_state, initialPaused, State.Canceled.INSTANCE, null, 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$InitialPaused;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$Reset;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$5$4, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass4 extends Lambda implements Function2<State.InitialPaused, Event.Reset, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.InitialPaused> $this_state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(a.c<State, Event, Object>.C0285a<State.InitialPaused> c0285a) {
                super(2);
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.InitialPaused initialPaused, Event.Reset reset) {
                m.f(initialPaused, "$this$on");
                m.f(reset, "it");
                return a.c.C0285a.g(this.$this_state, initialPaused, State.Queue.INSTANCE, null, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(DownloadProgressView downloadProgressView) {
            super(1);
            this.this$0 = downloadProgressView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(a.c<State, Event, Object>.C0285a<State.InitialPaused> c0285a) {
            invoke2(c0285a);
            return u.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(a.c<State, Event, Object>.C0285a<State.InitialPaused> c0285a) {
            m.f(c0285a, "$this$state");
            c0285a.e(new AnonymousClass1(this.this$0));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, c0285a);
            a.d.C0287a c0287a = a.d.a;
            c0285a.d(c0287a.a(Event.ResumeClick.class), anonymousClass2);
            c0285a.d(c0287a.a(Event.CancelClick.class), new AnonymousClass3(this.this$0, c0285a));
            c0285a.d(c0287a.a(Event.Reset.class), new AnonymousClass4(c0285a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadProgressView.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/tinder/StateMachine$GraphBuilder$StateDefinitionBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State$Installing;", "Lcom/tinder/StateMachine$GraphBuilder;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$6, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass6 extends Lambda implements Function1<a.c<State, Event, Object>.C0285a<State.Installing>, u> {
        final /* synthetic */ DownloadProgressView this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Installing;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$6$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass1 extends Lambda implements Function2<State.Installing, Event, u> {
            final /* synthetic */ DownloadProgressView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DownloadProgressView downloadProgressView) {
                super(2);
                this.this$0 = downloadProgressView;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ u invoke(State.Installing installing, Event event) {
                invoke2(installing, event);
                return u.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(State.Installing installing, Event event) {
                String str;
                m.f(installing, "$this$onEnter");
                m.f(event, "it");
                Log.d("DownloadProgressView", "State.Installing");
                ((ProgressBar) this.this$0._$_findCachedViewById(R.id.progressBar)).setIndeterminate(true);
                ((ImageView) this.this$0._$_findCachedViewById(R.id.cancelButton)).setVisibility(4);
                ((AnimatedImageView) this.this$0._$_findCachedViewById(R.id.resumePauseButton)).setVisibility(8);
                ((TextView) this.this$0._$_findCachedViewById(R.id.downloadProgressNumber)).setVisibility(8);
                TextSwitcher textSwitcher = (TextSwitcher) this.this$0._$_findCachedViewById(R.id.downloadState);
                str = this.this$0.installingText;
                textSwitcher.setText(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DownloadProgressView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/downloadprogressview/State$Installing;", "it", "Lcm/aptoide/aptoideviews/downloadprogressview/Event$Reset;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressView$stateMachine$1$6$2, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends Lambda implements Function2<State.Installing, Event.Reset, a.b.C0283a.C0284a<? extends State, ? extends Object>> {
            final /* synthetic */ a.c<State, Event, Object>.C0285a<State.Installing> $this_state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(a.c<State, Event, Object>.C0285a<State.Installing> c0285a) {
                super(2);
                this.$this_state = c0285a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final a.b.C0283a.C0284a<State, Object> invoke(State.Installing installing, Event.Reset reset) {
                m.f(installing, "$this$on");
                m.f(reset, "it");
                return a.c.C0285a.g(this.$this_state, installing, State.Queue.INSTANCE, null, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(DownloadProgressView downloadProgressView) {
            super(1);
            this.this$0 = downloadProgressView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(a.c<State, Event, Object>.C0285a<State.Installing> c0285a) {
            invoke2(c0285a);
            return u.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(a.c<State, Event, Object>.C0285a<State.Installing> c0285a) {
            m.f(c0285a, "$this$state");
            c0285a.e(new AnonymousClass1(this.this$0));
            c0285a.d(a.d.a.a(Event.Reset.class), new AnonymousClass2(c0285a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadProgressView$stateMachine$1(DownloadProgressView downloadProgressView) {
        super(1);
        this.this$0 = downloadProgressView;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ u invoke(a.c<State, Event, Object> cVar) {
        invoke2(cVar);
        return u.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a.c<State, Event, Object> cVar) {
        m.f(cVar, "$this$create");
        cVar.b(State.Queue.INSTANCE);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
        a.d.C0287a c0287a = a.d.a;
        cVar.c(c0287a.a(State.Queue.class), anonymousClass1);
        cVar.c(c0287a.a(State.Canceled.class), new AnonymousClass2(this.this$0));
        cVar.c(c0287a.a(State.InProgress.class), new AnonymousClass3(this.this$0));
        cVar.c(c0287a.a(State.Paused.class), new AnonymousClass4(this.this$0));
        cVar.c(c0287a.a(State.InitialPaused.class), new AnonymousClass5(this.this$0));
        cVar.c(c0287a.a(State.Installing.class), new AnonymousClass6(this.this$0));
    }
}
