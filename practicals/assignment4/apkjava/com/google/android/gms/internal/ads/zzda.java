package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import com.google.android.gms.internal.ads.zzbi;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes2.dex */
public class zzda {
    private static final ConditionVariable a = new ConditionVariable();

    /* renamed from: b, reason: collision with root package name */
    protected static volatile zzwo f15816b = null;

    /* renamed from: c, reason: collision with root package name */
    private static volatile Random f15817c = null;

    /* renamed from: d, reason: collision with root package name */
    private zzdy f15818d;

    /* renamed from: e, reason: collision with root package name */
    protected volatile Boolean f15819e;

    public zzda(zzdy zzdyVar) {
        this.f15818d = zzdyVar;
        zzdyVar.r().execute(new ar(this));
    }

    public static int d() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return e().nextInt();
        } catch (RuntimeException unused) {
            return e().nextInt();
        }
    }

    private static Random e() {
        if (f15817c == null) {
            synchronized (zzda.class) {
                if (f15817c == null) {
                    f15817c = new Random();
                }
            }
        }
        return f15817c;
    }

    public final void b(int i2, int i3, long j2) {
        c(i2, i3, j2, null);
    }

    public final void c(int i2, int i3, long j2, Exception exc) {
        try {
            a.block();
            if (!this.f15819e.booleanValue() || f15816b == null) {
                return;
            }
            zzbi.zza.C0174zza u = zzbi.zza.F().v(this.f15818d.f16182b.getPackageName()).u(j2);
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                zzdmb.a(exc, new PrintWriter(stringWriter));
                u.w(stringWriter.toString()).A(exc.getClass().getName());
            }
            zzws a2 = f15816b.a(((zzbi.zza) ((zzdob) u.p0())).g());
            a2.b(i2);
            if (i3 != -1) {
                a2.a(i3);
            }
            a2.c();
        } catch (Exception unused) {
        }
    }
}
