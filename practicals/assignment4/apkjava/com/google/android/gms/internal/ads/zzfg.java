package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzfg extends zzfk {
    public zzfg(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        super(zzdyVar, str, str2, c0176zza, i2, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.f16224j.w0(zzbz.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.f16225k.invoke(null, this.f16221g.a())).booleanValue();
        synchronized (this.f16224j) {
            if (booleanValue) {
                this.f16224j.w0(zzbz.ENUM_TRUE);
            } else {
                this.f16224j.w0(zzbz.ENUM_FALSE);
            }
        }
    }
}
