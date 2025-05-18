package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzfh extends zzfk {
    private final View n;

    public zzfh(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3, View view) {
        super(zzdyVar, str, str2, c0176zza, i2, 57);
        this.n = view;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.n != null) {
            Boolean bool = (Boolean) zzyt.e().c(zzacu.y2);
            zzeg zzegVar = new zzeg((String) this.f16225k.invoke(null, this.n, this.f16221g.a().getResources().getDisplayMetrics(), bool));
            zzbp.zza.zzf.C0178zza y = zzbp.zza.zzf.y();
            y.u(zzegVar.f16202b.longValue()).v(zzegVar.f16203c.longValue()).w(zzegVar.f16204d.longValue());
            if (bool.booleanValue()) {
                y.A(zzegVar.f16205e.longValue());
            }
            this.f16224j.U((zzbp.zza.zzf) ((zzdob) y.p0()));
        }
    }
}
