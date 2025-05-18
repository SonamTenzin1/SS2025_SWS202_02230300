package com.google.firebase.crashlytics.internal.p;

import com.google.firebase.crashlytics.internal.p.g0;

/* compiled from: AutoValue_StaticSessionData.java */
/* loaded from: classes2.dex */
final class b0 extends g0 {
    private final g0.a a;

    /* renamed from: b, reason: collision with root package name */
    private final g0.c f19321b;

    /* renamed from: c, reason: collision with root package name */
    private final g0.b f19322c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(g0.a aVar, g0.c cVar, g0.b bVar) {
        if (aVar != null) {
            this.a = aVar;
            if (cVar != null) {
                this.f19321b = cVar;
                if (bVar != null) {
                    this.f19322c = bVar;
                    return;
                }
                throw new NullPointerException("Null deviceData");
            }
            throw new NullPointerException("Null osData");
        }
        throw new NullPointerException("Null appData");
    }

    @Override // com.google.firebase.crashlytics.internal.p.g0
    public g0.a a() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.p.g0
    public g0.b c() {
        return this.f19322c;
    }

    @Override // com.google.firebase.crashlytics.internal.p.g0
    public g0.c d() {
        return this.f19321b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.a.equals(g0Var.a()) && this.f19321b.equals(g0Var.d()) && this.f19322c.equals(g0Var.c());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19321b.hashCode()) * 1000003) ^ this.f19322c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.a + ", osData=" + this.f19321b + ", deviceData=" + this.f19322c + "}";
    }
}
