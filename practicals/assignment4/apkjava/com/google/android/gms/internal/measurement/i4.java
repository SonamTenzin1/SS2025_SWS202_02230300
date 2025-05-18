package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class i4 extends h4<zzhy, zzhy> {
    private static void t(Object obj, zzhy zzhyVar) {
        ((zzfd) obj).zzb = zzhyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* synthetic */ zzhy a() {
        return zzhy.g();
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ zzhy b(zzhy zzhyVar) {
        zzhy zzhyVar2 = zzhyVar;
        zzhyVar2.i();
        return zzhyVar2;
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ void c(zzhy zzhyVar, int i2, int i3) {
        zzhyVar.c((i2 << 3) | 5, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* synthetic */ void d(zzhy zzhyVar, int i2, long j2) {
        zzhyVar.c(i2 << 3, Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* synthetic */ void e(zzhy zzhyVar, int i2, zzdu zzduVar) {
        zzhyVar.c((i2 << 3) | 2, zzduVar);
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ void f(zzhy zzhyVar, int i2, zzhy zzhyVar2) {
        zzhyVar.c((i2 << 3) | 3, zzhyVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* synthetic */ void g(zzhy zzhyVar, y4 y4Var) throws IOException {
        zzhyVar.h(y4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* bridge */ /* synthetic */ void h(Object obj, zzhy zzhyVar) {
        t(obj, zzhyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final boolean i(q3 q3Var) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* synthetic */ zzhy k(Object obj) {
        return ((zzfd) obj).zzb;
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ void l(zzhy zzhyVar, int i2, long j2) {
        zzhyVar.c((i2 << 3) | 1, Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* synthetic */ void m(zzhy zzhyVar, y4 y4Var) throws IOException {
        zzhyVar.e(y4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* synthetic */ void n(Object obj, zzhy zzhyVar) {
        t(obj, zzhyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* synthetic */ zzhy o(Object obj) {
        zzhy zzhyVar = ((zzfd) obj).zzb;
        if (zzhyVar != zzhy.a()) {
            return zzhyVar;
        }
        zzhy g2 = zzhy.g();
        t(obj, g2);
        return g2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* synthetic */ zzhy p(zzhy zzhyVar, zzhy zzhyVar2) {
        zzhy zzhyVar3 = zzhyVar;
        zzhy zzhyVar4 = zzhyVar2;
        return zzhyVar4.equals(zzhy.a()) ? zzhyVar3 : zzhy.b(zzhyVar3, zzhyVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final void q(Object obj) {
        ((zzfd) obj).zzb.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* synthetic */ int r(zzhy zzhyVar) {
        return zzhyVar.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h4
    public final /* synthetic */ int s(zzhy zzhyVar) {
        return zzhyVar.k();
    }
}
