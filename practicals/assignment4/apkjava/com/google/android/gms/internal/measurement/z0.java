package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes.dex */
final class z0<T> extends zzcy<T> {

    /* renamed from: f, reason: collision with root package name */
    private final T f17296f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(T t) {
        this.f17296f = t;
    }

    @Override // com.google.android.gms.internal.measurement.zzcy
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzcy
    public final T c() {
        return this.f17296f;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof z0) {
            return this.f17296f.equals(((z0) obj).f17296f);
        }
        return false;
    }

    public final int hashCode() {
        return this.f17296f.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f17296f);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
