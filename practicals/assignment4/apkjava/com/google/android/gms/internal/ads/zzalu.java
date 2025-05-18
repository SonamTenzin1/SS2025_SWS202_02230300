package com.google.android.gms.internal.ads;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzalu<I, O> implements zzalj<I, O> {
    private final zzall<O> a;

    /* renamed from: b, reason: collision with root package name */
    private final zzalm<I> f13959b;

    /* renamed from: c, reason: collision with root package name */
    private final zzakh f13960c;

    /* renamed from: d, reason: collision with root package name */
    private final String f13961d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalu(zzakh zzakhVar, String str, zzalm<I> zzalmVar, zzall<O> zzallVar) {
        this.f13960c = zzakhVar;
        this.f13961d = str;
        this.f13959b = zzalmVar;
        this.a = zzallVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(zzakw zzakwVar, zzalf zzalfVar, I i2, zzbbr<O> zzbbrVar) {
        try {
            zzk.zzlg();
            String j0 = zzaxi.j0();
            zzagz.o.c(j0, new i2(this, zzakwVar, zzbbrVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, j0);
            jSONObject.put("args", this.f13959b.b(i2));
            zzalfVar.Y(this.f13961d, jSONObject);
        } catch (Exception e2) {
            try {
                zzbbrVar.c(e2);
                zzbad.c("Unable to invokeJavascript", e2);
            } finally {
                zzakwVar.f();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzbbh<O> a(I i2) {
        zzbbr zzbbrVar = new zzbbr();
        zzakw h2 = this.f13960c.h(null);
        h2.d(new g2(this, h2, i2, zzbbrVar), new h2(this, zzbbrVar, h2));
        return zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh<O> zzf(I i2) throws Exception {
        return a(i2);
    }
}
