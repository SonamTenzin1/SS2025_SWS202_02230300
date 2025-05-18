package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import io.sentry.android.core.s0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FirstDrawDoneListener.java */
@SuppressLint({"ObsoleteSdkInt"})
/* loaded from: classes2.dex */
public class p implements ViewTreeObserver.OnDrawListener {
    private final Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<View> f22193b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f22194c;

    /* compiled from: FirstDrawDoneListener.java */
    /* loaded from: classes2.dex */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnDrawListener(p.this);
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
        }
    }

    private p(View view, Runnable runnable) {
        this.f22193b = new AtomicReference<>(view);
        this.f22194c = runnable;
    }

    private static boolean a(View view, s0 s0Var) {
        return view.getViewTreeObserver().isAlive() && b(view, s0Var);
    }

    @SuppressLint({"NewApi"})
    private static boolean b(View view, s0 s0Var) {
        if (s0Var.d() >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(View view) {
        view.getViewTreeObserver().removeOnDrawListener(this);
    }

    public static void e(View view, Runnable runnable, s0 s0Var) {
        p pVar = new p(view, runnable);
        if (s0Var.d() < 26 && !a(view, s0Var)) {
            view.addOnAttachStateChangeListener(new a());
        } else {
            view.getViewTreeObserver().addOnDrawListener(pVar);
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        final View andSet = this.f22193b.getAndSet(null);
        if (andSet == null) {
            return;
        }
        andSet.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: io.sentry.android.core.internal.util.a
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                p.this.d(andSet);
            }
        });
        this.a.postAtFrontOfQueue(this.f22194c);
    }
}
