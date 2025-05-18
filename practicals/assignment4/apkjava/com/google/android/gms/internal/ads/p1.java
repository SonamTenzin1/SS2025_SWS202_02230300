package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class p1 implements zzaho<zzalf> {
    private final /* synthetic */ zzdh a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzajw f13139b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzazk f13140c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzakh f13141d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p1(zzakh zzakhVar, zzdh zzdhVar, zzajw zzajwVar, zzazk zzazkVar) {
        this.f13141d = zzakhVar;
        this.a = zzdhVar;
        this.f13139b = zzajwVar;
        this.f13140c = zzazkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzalf zzalfVar, Map map) {
        Object obj;
        int i2;
        obj = this.f13141d.a;
        synchronized (obj) {
            zzbad.h("JS Engine is requesting an update");
            i2 = this.f13141d.f13938h;
            if (i2 == 0) {
                zzbad.h("Starting reload.");
                this.f13141d.f13938h = 2;
                this.f13141d.c(this.a);
            }
            this.f13139b.i("/requestReload", (zzaho) this.f13140c.a());
        }
    }
}
