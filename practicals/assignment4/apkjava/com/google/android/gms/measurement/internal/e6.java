package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class e6 extends f {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzik f17747e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e6(zzik zzikVar, s4 s4Var) {
        super(s4Var);
        this.f17747e = zzikVar;
    }

    @Override // com.google.android.gms.measurement.internal.f
    public final void b() {
        this.f17747e.h().K().a("Tasks have been queued for a long time");
    }
}
