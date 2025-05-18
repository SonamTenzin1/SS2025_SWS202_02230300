package c.i.h;

import android.graphics.Typeface;
import android.os.Handler;
import c.i.h.e;
import c.i.h.f;

/* compiled from: CallbackWithHandler.java */
/* loaded from: classes.dex */
class a {
    private final f.c a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f3209b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CallbackWithHandler.java */
    /* renamed from: c.i.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0071a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f.c f3210f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Typeface f3211g;

        RunnableC0071a(f.c cVar, Typeface typeface) {
            this.f3210f = cVar;
            this.f3211g = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3210f.b(this.f3211g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CallbackWithHandler.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f.c f3213f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3214g;

        b(f.c cVar, int i2) {
            this.f3213f = cVar;
            this.f3214g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3213f.a(this.f3214g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(f.c cVar, Handler handler) {
        this.a = cVar;
        this.f3209b = handler;
    }

    private void a(int i2) {
        this.f3209b.post(new b(this.a, i2));
    }

    private void c(Typeface typeface) {
        this.f3209b.post(new RunnableC0071a(this.a, typeface));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e.C0072e c0072e) {
        if (c0072e.a()) {
            c(c0072e.a);
        } else {
            a(c0072e.f3232b);
        }
    }
}
