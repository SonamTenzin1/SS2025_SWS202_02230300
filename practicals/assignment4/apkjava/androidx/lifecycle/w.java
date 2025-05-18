package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.g;

/* compiled from: ServiceLifecycleDispatcher.java */
/* loaded from: classes.dex */
public class w {
    private final l a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f1778b = new Handler();

    /* renamed from: c, reason: collision with root package name */
    private a f1779c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServiceLifecycleDispatcher.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final l f1780f;

        /* renamed from: g, reason: collision with root package name */
        final g.b f1781g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f1782h = false;

        a(l lVar, g.b bVar) {
            this.f1780f = lVar;
            this.f1781g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1782h) {
                return;
            }
            this.f1780f.h(this.f1781g);
            this.f1782h = true;
        }
    }

    public w(k kVar) {
        this.a = new l(kVar);
    }

    private void f(g.b bVar) {
        a aVar = this.f1779c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.a, bVar);
        this.f1779c = aVar2;
        this.f1778b.postAtFrontOfQueue(aVar2);
    }

    public g a() {
        return this.a;
    }

    public void b() {
        f(g.b.ON_START);
    }

    public void c() {
        f(g.b.ON_CREATE);
    }

    public void d() {
        f(g.b.ON_STOP);
        f(g.b.ON_DESTROY);
    }

    public void e() {
        f(g.b.ON_START);
    }
}
