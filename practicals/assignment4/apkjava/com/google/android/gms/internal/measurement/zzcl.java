package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public abstract class zzcl<T> {

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static Context f17344b;

    /* renamed from: c, reason: collision with root package name */
    private static zzcz<p0> f17345c;

    /* renamed from: e, reason: collision with root package name */
    private final zzcr f17347e;

    /* renamed from: f, reason: collision with root package name */
    private final String f17348f;

    /* renamed from: g, reason: collision with root package name */
    private final T f17349g;

    /* renamed from: h, reason: collision with root package name */
    private volatile int f17350h;

    /* renamed from: i, reason: collision with root package name */
    private volatile T f17351i;
    private static final Object a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f17346d = new AtomicInteger();

    private zzcl(zzcr zzcrVar, String str, T t) {
        this.f17350h = -1;
        if (zzcrVar.f17352b != null) {
            this.f17347e = zzcrVar;
            this.f17348f = str;
            this.f17349g = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    private final String f(String str) {
        if (str != null && str.isEmpty()) {
            return this.f17348f;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.f17348f);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g() {
        f17346d.incrementAndGet();
    }

    public static void h(Context context) {
        synchronized (a) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (f17344b != context) {
                zzbx.d();
                zzcu.b();
                o0.b();
                f17346d.incrementAndGet();
                f17344b = context;
                f17345c = zzdc.a(t0.f17257f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<Double> i(zzcr zzcrVar, String str, double d2) {
        return new u0(zzcrVar, str, Double.valueOf(d2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<Long> j(zzcr zzcrVar, String str, long j2) {
        return new s0(zzcrVar, str, Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<String> k(zzcr zzcrVar, String str, String str2) {
        return new w0(zzcrVar, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<Boolean> l(zzcr zzcrVar, String str, boolean z) {
        return new v0(zzcrVar, str, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ p0 o() {
        new r0();
        return r0.a(f17344b);
    }

    abstract T e(Object obj);

    public final String m() {
        return f(this.f17347e.f17354d);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4 A[Catch: all -> 0x00e1, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x002a, B:12:0x00d2, B:13:0x0030, B:15:0x0040, B:19:0x0051, B:21:0x0057, B:23:0x005f, B:25:0x0078, B:27:0x0082, B:30:0x00b4, B:32:0x00c8, B:35:0x00d0, B:38:0x0070, B:39:0x0087, B:41:0x0090, B:43:0x00a2, B:44:0x00ad, B:45:0x00a7, B:47:0x00d7, B:48:0x00de, B:50:0x00df), top: B:4:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T n() {
        T t;
        m0 a2;
        Object u;
        int i2 = f17346d.get();
        if (this.f17350h < i2) {
            synchronized (this) {
                if (this.f17350h < i2) {
                    if (f17344b != null) {
                        p0 a3 = f17345c.a();
                        zzcr zzcrVar = this.f17347e;
                        String b2 = a3.b(zzcrVar.f17352b, null, zzcrVar.f17354d, this.f17348f);
                        if (b2 != null) {
                            t = e(b2);
                        } else {
                            String str = (String) o0.a(f17344b).u("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
                            if (!(str != null && zzbw.f17325c.matcher(str).matches())) {
                                Uri uri = this.f17347e.f17352b;
                                if (uri != null) {
                                    a2 = zzcj.b(f17344b, uri) ? zzbx.a(f17344b.getContentResolver(), this.f17347e.f17352b) : null;
                                } else {
                                    a2 = zzcu.a(f17344b, null);
                                }
                                if (a2 != null && (u = a2.u(m())) != null) {
                                    t = e(u);
                                    if (t == null) {
                                        Object u2 = o0.a(f17344b).u(f(this.f17347e.f17353c));
                                        T e2 = u2 != null ? e(u2) : null;
                                        t = e2 != null ? e2 : this.f17349g;
                                    }
                                }
                            } else if (Log.isLoggable("PhenotypeFlag", 3)) {
                                String valueOf = String.valueOf(m());
                                Log.d("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
                            }
                            t = null;
                            if (t == null) {
                            }
                        }
                        this.f17351i = t;
                        this.f17350h = i2;
                    } else {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                }
            }
        }
        return this.f17351i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcl(zzcr zzcrVar, String str, Object obj, s0 s0Var) {
        this(zzcrVar, str, obj);
    }
}
