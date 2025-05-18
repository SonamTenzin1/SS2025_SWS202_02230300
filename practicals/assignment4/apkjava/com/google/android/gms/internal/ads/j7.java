package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
final class j7<T> implements zzban<T> {
    private final /* synthetic */ zzbbv a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbbt f12813b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j7(zzbbw zzbbwVar, zzbbv zzbbvVar, zzbbt zzbbtVar) {
        this.a = zzbbvVar;
        this.f12813b = zzbbtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        this.f12813b.run();
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void b(T t) {
        this.a.a(t);
    }
}
