package com.facebook.internal.s0;

import kotlin.jvm.internal.m;

/* compiled from: GateKeeper.kt */
/* loaded from: classes2.dex */
public final class a {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f9857b;

    public a(String str, boolean z) {
        m.f(str, "name");
        this.a = str;
        this.f9857b = z;
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.f9857b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return m.a(this.a, aVar.a) && this.f9857b == aVar.f9857b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.f9857b;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "GateKeeper(name=" + this.a + ", value=" + this.f9857b + ')';
    }
}
