package com.facebook.o0.u0;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.o0.u0.j;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;

/* compiled from: ViewObserver.kt */
/* loaded from: classes2.dex */
public final class i implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: f, reason: collision with root package name */
    public static final a f10527f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Map<Integer, i> f10528g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final WeakReference<Activity> f10529h;

    /* renamed from: i, reason: collision with root package name */
    private final Handler f10530i;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f10531j;

    /* compiled from: ViewObserver.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final void a(Activity activity) {
            m.f(activity, "activity");
            int hashCode = activity.hashCode();
            Map map = i.f10528g;
            Integer valueOf = Integer.valueOf(hashCode);
            Object obj = map.get(valueOf);
            if (obj == null) {
                obj = new i(activity, null);
                map.put(valueOf, obj);
            }
            ((i) obj).g();
        }

        public final void b(Activity activity) {
            m.f(activity, "activity");
            i iVar = (i) i.f10528g.remove(Integer.valueOf(activity.hashCode()));
            if (iVar == null) {
                return;
            }
            iVar.h();
        }
    }

    private i(Activity activity) {
        this.f10529h = new WeakReference<>(activity);
        this.f10530i = new Handler(Looper.getMainLooper());
        this.f10531j = new AtomicBoolean(false);
    }

    public /* synthetic */ i(Activity activity, kotlin.jvm.internal.g gVar) {
        this(activity);
    }

    private final void e() {
        Runnable runnable = new Runnable() { // from class: com.facebook.o0.u0.b
            @Override // java.lang.Runnable
            public final void run() {
                i.f(i.this);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.f10530i.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(i iVar) {
        m.f(iVar, "this$0");
        try {
            com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
            View e2 = com.facebook.o0.q0.g.e(iVar.f10529h.get());
            Activity activity = iVar.f10529h.get();
            if (e2 != null && activity != null) {
                g gVar2 = g.a;
                for (View view : g.a(e2)) {
                    com.facebook.o0.m0.n.d dVar = com.facebook.o0.m0.n.d.a;
                    if (!com.facebook.o0.m0.n.d.g(view)) {
                        g gVar3 = g.a;
                        String d2 = g.d(view);
                        if ((d2.length() > 0) && d2.length() <= 300) {
                            j.a aVar = j.f10532f;
                            String localClassName = activity.getLocalClassName();
                            m.e(localClassName, "activity.localClassName");
                            aVar.c(view, e2, localClassName);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        if (this.f10531j.getAndSet(true)) {
            return;
        }
        com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
        View e2 = com.facebook.o0.q0.g.e(this.f10529h.get());
        if (e2 == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = e2.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        if (this.f10531j.getAndSet(false)) {
            com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
            View e2 = com.facebook.o0.q0.g.e(this.f10529h.get());
            if (e2 == null) {
                return;
            }
            ViewTreeObserver viewTreeObserver = e2.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        e();
    }
}
