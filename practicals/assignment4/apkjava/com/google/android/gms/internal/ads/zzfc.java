package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzfc extends zzfk {
    private final StackTraceElement[] n;

    public zzfc(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3, StackTraceElement[] stackTraceElementArr) {
        super(zzdyVar, str, str2, c0176zza, i2, 45);
        this.n = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        zzbz zzbzVar;
        StackTraceElement[] stackTraceElementArr = this.n;
        if (stackTraceElementArr != null) {
            zzdw zzdwVar = new zzdw((String) this.f16225k.invoke(null, stackTraceElementArr));
            synchronized (this.f16224j) {
                this.f16224j.j0(zzdwVar.f16177b.longValue());
                if (zzdwVar.f16178c.booleanValue()) {
                    zzbp.zza.C0176zza c0176zza = this.f16224j;
                    if (zzdwVar.f16179d.booleanValue()) {
                        zzbzVar = zzbz.ENUM_FALSE;
                    } else {
                        zzbzVar = zzbz.ENUM_TRUE;
                    }
                    c0176zza.y0(zzbzVar);
                } else {
                    this.f16224j.y0(zzbz.ENUM_FAILURE);
                }
            }
        }
    }
}
