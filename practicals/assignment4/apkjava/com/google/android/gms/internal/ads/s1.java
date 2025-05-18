package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s1 implements zzbbv<zzajw> {
    private final /* synthetic */ zzala a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzakh f13302b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s1(zzakh zzakhVar, zzala zzalaVar) {
        this.f13302b = zzakhVar;
        this.a = zzalaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbv
    public final /* synthetic */ void a(zzajw zzajwVar) {
        Object obj;
        zzala zzalaVar;
        zzala zzalaVar2;
        zzala zzalaVar3;
        obj = this.f13302b.a;
        synchronized (obj) {
            this.f13302b.f13938h = 0;
            zzalaVar = this.f13302b.f13937g;
            if (zzalaVar != null) {
                zzala zzalaVar4 = this.a;
                zzalaVar2 = this.f13302b.f13937g;
                if (zzalaVar4 != zzalaVar2) {
                    zzawz.m("New JS engine is loaded, marking previous one as destroyable.");
                    zzalaVar3 = this.f13302b.f13937g;
                    zzalaVar3.i();
                }
            }
            this.f13302b.f13937g = this.a;
        }
    }
}
