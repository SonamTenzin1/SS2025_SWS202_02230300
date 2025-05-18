package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Incorrect field signature: TK; */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class z3<K, V> implements Comparable<z3>, Map.Entry<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private final Comparable f17300f;

    /* renamed from: g, reason: collision with root package name */
    private V f17301g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ u3 f17302h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z3(u3 u3Var, Map.Entry<K, V> entry) {
        this(u3Var, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean g(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(z3 z3Var) {
        return ((Comparable) getKey()).compareTo((Comparable) z3Var.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return g(this.f17300f, entry.getKey()) && g(this.f17301g, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f17300f;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f17301g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f17300f;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f17301g;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f17302h.q();
        V v2 = this.f17301g;
        this.f17301g = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f17300f);
        String valueOf2 = String.valueOf(this.f17301g);
        StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public z3(u3 u3Var, K k2, V v) {
        this.f17302h = u3Var;
        this.f17300f = k2;
        this.f17301g = v;
    }
}
