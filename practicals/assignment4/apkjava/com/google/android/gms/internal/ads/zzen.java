package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbk;
import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzen extends zzfk {
    private static final zzfl<zzch> n = new zzfl<>();
    private final Context o;
    private zzbk.zza p;

    public zzen(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3, Context context, zzbk.zza zzaVar) {
        super(zzdyVar, str, str2, c0176zza, i2, 27);
        this.p = null;
        this.o = context;
        this.p = zzaVar;
    }

    private static String c(zzbk.zza zzaVar) {
        if (zzaVar == null || !zzaVar.A() || zzef.f(zzaVar.B().x())) {
            return null;
        }
        return zzaVar.B().x();
    }

    private final String d() {
        try {
            if (this.f16221g.A() != null) {
                this.f16221g.A().get();
            }
            zzbp.zza z = this.f16221g.z();
            if (z == null || !z.d0()) {
                return null;
            }
            return z.U();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[Catch: all -> 0x011e, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001f, B:10:0x0029, B:15:0x0039, B:17:0x0045, B:18:0x0082, B:21:0x0091, B:23:0x00b7, B:25:0x00e7, B:26:0x00c1, B:30:0x00ce, B:32:0x00d8, B:33:0x00db, B:34:0x0048, B:37:0x0056, B:39:0x005c, B:42:0x006b, B:44:0x0075, B:46:0x007d, B:47:0x0080, B:49:0x00ea, B:50:0x00f0), top: B:3:0x000d }] */
    @Override // com.google.android.gms.internal.ads.zzfk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        boolean z;
        zzch zzchVar;
        zzbm zzbmVar;
        AtomicReference<zzch> a = n.a(this.o.getPackageName());
        synchronized (a) {
            zzch zzchVar2 = a.get();
            if (zzchVar2 != null && !zzef.f(zzchVar2.f15228b) && !zzchVar2.f15228b.equals("E") && !zzchVar2.f15228b.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                z = false;
                if (z) {
                    if (!zzef.f(c(this.p))) {
                        zzbmVar = zzbm.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
                    } else {
                        zzbk.zza zzaVar = this.p;
                        if (Boolean.valueOf(zzef.f(c(zzaVar)) && zzaVar != null && zzaVar.y() && zzaVar.z().z() == zzbm.ENUM_SIGNAL_SOURCE_GASS).booleanValue() && this.f16221g.x()) {
                            zzbmVar = zzbm.ENUM_SIGNAL_SOURCE_GASS;
                        } else {
                            zzbmVar = zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD;
                        }
                    }
                    Method method = this.f16225k;
                    Object[] objArr = new Object[3];
                    objArr[0] = this.o;
                    objArr[1] = Boolean.valueOf(zzbmVar == zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD);
                    objArr[2] = zzyt.e().c(zzacu.q2);
                    zzch zzchVar3 = new zzch((String) method.invoke(null, objArr));
                    if (zzef.f(zzchVar3.f15228b) || zzchVar3.f15228b.equals("E")) {
                        int i2 = ty.a[zzbmVar.ordinal()];
                        if (i2 == 1) {
                            zzchVar3.f15228b = this.p.B().x();
                        } else if (i2 == 2) {
                            String d2 = d();
                            if (!zzef.f(d2)) {
                                zzchVar3.f15228b = d2;
                            }
                        }
                    }
                    a.set(zzchVar3);
                }
                zzchVar = a.get();
            }
            z = true;
            if (z) {
            }
            zzchVar = a.get();
        }
        synchronized (this.f16224j) {
            if (zzchVar != null) {
                this.f16224j.C0(zzchVar.f15228b);
                this.f16224j.Z(zzchVar.f15229c);
                this.f16224j.v(zzchVar.f15230d);
                this.f16224j.w(zzchVar.f15231e);
                this.f16224j.A(zzchVar.f15232f);
            }
        }
    }
}
