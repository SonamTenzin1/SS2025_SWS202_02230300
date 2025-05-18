package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes.dex */
final class b1<T> implements zzcz<T>, Serializable {

    /* renamed from: f, reason: collision with root package name */
    @NullableDecl
    private final T f17129f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(@NullableDecl T t) {
        this.f17129f = t;
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final T a() {
        return this.f17129f;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof b1)) {
            return false;
        }
        T t = this.f17129f;
        T t2 = ((b1) obj).f17129f;
        if (t != t2) {
            return t != null && t.equals(t2);
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f17129f});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f17129f);
        StringBuilder sb = new StringBuilder(valueOf.length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
