package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class o1 extends q1 {

    /* renamed from: f, reason: collision with root package name */
    private int f17234f = 0;

    /* renamed from: g, reason: collision with root package name */
    private final int f17235g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzdu f17236h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o1(zzdu zzduVar) {
        this.f17236h = zzduVar;
        this.f17235g = zzduVar.f();
    }

    @Override // com.google.android.gms.internal.measurement.zzed
    public final byte a() {
        int i2 = this.f17234f;
        if (i2 < this.f17235g) {
            this.f17234f = i2 + 1;
            return this.f17236h.t(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f17234f < this.f17235g;
    }
}
