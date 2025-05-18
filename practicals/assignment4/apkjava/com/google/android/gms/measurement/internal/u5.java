package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class u5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17976f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzig f17977g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzig f17978h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzif f17979i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u5(zzif zzifVar, boolean z, zzig zzigVar, zzig zzigVar2) {
        this.f17979i = zzifVar;
        this.f17976f = z;
        this.f17977g = zzigVar;
        this.f17978h = zzigVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
    
        if (com.google.android.gms.measurement.internal.zzkk.t0(r10.f17977g.a, r10.f17978h.a) != false) goto L27;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        zzif zzifVar;
        zzig zzigVar;
        boolean z2 = false;
        if (this.f17979i.n().T(this.f17979i.q().C())) {
            z = this.f17976f && this.f17979i.f18183c != null;
            if (z) {
                zzif zzifVar2 = this.f17979i;
                zzifVar2.J(zzifVar2.f18183c, true);
            }
        } else {
            if (this.f17976f && (zzigVar = (zzifVar = this.f17979i).f18183c) != null) {
                zzifVar.J(zzigVar, true);
            }
            z = false;
        }
        zzig zzigVar2 = this.f17977g;
        if (zzigVar2 != null) {
            long j2 = zzigVar2.f18190c;
            zzig zzigVar3 = this.f17978h;
            if (j2 == zzigVar3.f18190c) {
                if (zzkk.t0(zzigVar2.f18189b, zzigVar3.f18189b)) {
                }
            }
        }
        z2 = true;
        if (z2) {
            Bundle bundle = new Bundle();
            zzif.I(this.f17978h, bundle, true);
            zzig zzigVar4 = this.f17977g;
            if (zzigVar4 != null) {
                String str = zzigVar4.a;
                if (str != null) {
                    bundle.putString("_pn", str);
                }
                bundle.putString("_pc", this.f17977g.f18189b);
                bundle.putLong("_pi", this.f17977g.f18190c);
            }
            if (this.f17979i.n().T(this.f17979i.q().C()) && z) {
                long e2 = this.f17979i.u().f18204e.e();
                if (e2 > 0) {
                    this.f17979i.l().J(bundle, e2);
                }
            }
            this.f17979i.p().u0("auto", "_vs", bundle);
        }
        zzif zzifVar3 = this.f17979i;
        zzifVar3.f18183c = this.f17978h;
        zzifVar3.r().N(this.f17978h);
    }
}
