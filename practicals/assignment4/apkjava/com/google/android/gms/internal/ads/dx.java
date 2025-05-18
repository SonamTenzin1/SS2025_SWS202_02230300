package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
final class dx extends cx<zzdqu, zzdqu> {
    private static void t(Object obj, zzdqu zzdquVar) {
        ((zzdob) obj).zzhhd = zzdquVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ void a(zzdqu zzdquVar, int i2, long j2) {
        zzdquVar.k(i2 << 3, Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ void b(zzdqu zzdquVar, int i2, zzdmr zzdmrVar) {
        zzdquVar.k((i2 << 3) | 2, zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void c(zzdqu zzdquVar, int i2, zzdqu zzdquVar2) {
        zzdquVar.k((i2 << 3) | 3, zzdquVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ void d(zzdqu zzdquVar, ux uxVar) throws IOException {
        zzdquVar.h(uxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final boolean e(kw kwVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final void g(Object obj) {
        ((zzdob) obj).zzhhd.d();
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ zzdqu h(zzdqu zzdquVar) {
        zzdqu zzdquVar2 = zzdquVar;
        zzdquVar2.d();
        return zzdquVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ int i(zzdqu zzdquVar) {
        return zzdquVar.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ zzdqu j(Object obj) {
        return ((zzdob) obj).zzhhd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ zzdqu k(Object obj) {
        zzdqu zzdquVar = ((zzdob) obj).zzhhd;
        if (zzdquVar != zzdqu.f()) {
            return zzdquVar;
        }
        zzdqu i2 = zzdqu.i();
        t(obj, i2);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ int l(zzdqu zzdquVar) {
        return zzdquVar.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ zzdqu m() {
        return zzdqu.i();
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void n(zzdqu zzdquVar, int i2, long j2) {
        zzdquVar.k((i2 << 3) | 1, Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void o(zzdqu zzdquVar, int i2, int i3) {
        zzdquVar.k((i2 << 3) | 5, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ void p(zzdqu zzdquVar, ux uxVar) throws IOException {
        zzdquVar.b(uxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ void q(Object obj, zzdqu zzdquVar) {
        t(obj, zzdquVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ void r(Object obj, zzdqu zzdquVar) {
        t(obj, zzdquVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.cx
    public final /* synthetic */ zzdqu s(zzdqu zzdquVar, zzdqu zzdquVar2) {
        zzdqu zzdquVar3 = zzdquVar;
        zzdqu zzdquVar4 = zzdquVar2;
        return zzdquVar4.equals(zzdqu.f()) ? zzdquVar3 : zzdqu.a(zzdquVar3, zzdquVar4);
    }
}
