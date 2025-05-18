package c.i.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import c.i.h.f;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontRequestWorker.java */
/* loaded from: classes.dex */
public class e {
    static final c.e.e<String, Typeface> a = new c.e.e<>(16);

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f3221b = g.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    static final Object f3222c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final c.e.g<String, ArrayList<c.i.j.a<C0072e>>> f3223d = new c.e.g<>();

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    class a implements Callable<C0072e> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3224f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f3225g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ c.i.h.d f3226h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f3227i;

        a(String str, Context context, c.i.h.d dVar, int i2) {
            this.f3224f = str;
            this.f3225g = context;
            this.f3226h = dVar;
            this.f3227i = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0072e call() {
            return e.c(this.f3224f, this.f3225g, this.f3226h, this.f3227i);
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    class b implements c.i.j.a<C0072e> {
        final /* synthetic */ c.i.h.a a;

        b(c.i.h.a aVar) {
            this.a = aVar;
        }

        @Override // c.i.j.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C0072e c0072e) {
            this.a.b(c0072e);
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    class c implements Callable<C0072e> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3228f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f3229g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ c.i.h.d f3230h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f3231i;

        c(String str, Context context, c.i.h.d dVar, int i2) {
            this.f3228f = str;
            this.f3229g = context;
            this.f3230h = dVar;
            this.f3231i = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0072e call() {
            return e.c(this.f3228f, this.f3229g, this.f3230h, this.f3231i);
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    class d implements c.i.j.a<C0072e> {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // c.i.j.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C0072e c0072e) {
            synchronized (e.f3222c) {
                c.e.g<String, ArrayList<c.i.j.a<C0072e>>> gVar = e.f3223d;
                ArrayList<c.i.j.a<C0072e>> arrayList = gVar.get(this.a);
                if (arrayList == null) {
                    return;
                }
                gVar.remove(this.a);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList.get(i2).a(c0072e);
                }
            }
        }
    }

    private static String a(c.i.h.d dVar, int i2) {
        return dVar.d() + "-" + i2;
    }

    @SuppressLint({"WrongConstant"})
    private static int b(f.a aVar) {
        int i2 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        f.b[] b2 = aVar.b();
        if (b2 != null && b2.length != 0) {
            i2 = 0;
            for (f.b bVar : b2) {
                int b3 = bVar.b();
                if (b3 != 0) {
                    if (b3 < 0) {
                        return -3;
                    }
                    return b3;
                }
            }
        }
        return i2;
    }

    static C0072e c(String str, Context context, c.i.h.d dVar, int i2) {
        c.e.e<String, Typeface> eVar = a;
        Typeface c2 = eVar.c(str);
        if (c2 != null) {
            return new C0072e(c2);
        }
        try {
            f.a d2 = c.i.h.c.d(context, dVar, null);
            int b2 = b(d2);
            if (b2 != 0) {
                return new C0072e(b2);
            }
            Typeface b3 = c.i.e.d.b(context, null, d2.b(), i2);
            if (b3 != null) {
                eVar.d(str, b3);
                return new C0072e(b3);
            }
            return new C0072e(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0072e(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface d(Context context, c.i.h.d dVar, int i2, Executor executor, c.i.h.a aVar) {
        String a2 = a(dVar, i2);
        Typeface c2 = a.c(a2);
        if (c2 != null) {
            aVar.b(new C0072e(c2));
            return c2;
        }
        b bVar = new b(aVar);
        synchronized (f3222c) {
            c.e.g<String, ArrayList<c.i.j.a<C0072e>>> gVar = f3223d;
            ArrayList<c.i.j.a<C0072e>> arrayList = gVar.get(a2);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<c.i.j.a<C0072e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            gVar.put(a2, arrayList2);
            c cVar = new c(a2, context, dVar, i2);
            if (executor == null) {
                executor = f3221b;
            }
            g.b(executor, cVar, new d(a2));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface e(Context context, c.i.h.d dVar, c.i.h.a aVar, int i2, int i3) {
        String a2 = a(dVar, i2);
        Typeface c2 = a.c(a2);
        if (c2 != null) {
            aVar.b(new C0072e(c2));
            return c2;
        }
        if (i3 == -1) {
            C0072e c3 = c(a2, context, dVar, i2);
            aVar.b(c3);
            return c3.a;
        }
        try {
            C0072e c0072e = (C0072e) g.c(f3221b, new a(a2, context, dVar, i2), i3);
            aVar.b(c0072e);
            return c0072e.a;
        } catch (InterruptedException unused) {
            aVar.b(new C0072e(-3));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FontRequestWorker.java */
    /* renamed from: c.i.h.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0072e {
        final Typeface a;

        /* renamed from: b, reason: collision with root package name */
        final int f3232b;

        C0072e(int i2) {
            this.a = null;
            this.f3232b = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f3232b == 0;
        }

        @SuppressLint({"WrongConstant"})
        C0072e(Typeface typeface) {
            this.a = typeface;
            this.f3232b = 0;
        }
    }
}
