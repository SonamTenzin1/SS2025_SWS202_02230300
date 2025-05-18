package com.google.firebase.crashlytics.internal.p;

import com.google.firebase.crashlytics.internal.p.g0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_StaticSessionData_OsData.java */
/* loaded from: classes2.dex */
public final class e0 extends g0.c {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19358b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f19359c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(String str, String str2, boolean z) {
        if (str != null) {
            this.a = str;
            if (str2 != null) {
                this.f19358b = str2;
                this.f19359c = z;
                return;
            }
            throw new NullPointerException("Null osCodeName");
        }
        throw new NullPointerException("Null osRelease");
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.c
    public boolean b() {
        return this.f19359c;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.c
    public String c() {
        return this.f19358b;
    }

    @Override // com.google.firebase.crashlytics.h.p.g0.c
    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0.c)) {
            return false;
        }
        g0.c cVar = (g0.c) obj;
        return this.a.equals(cVar.d()) && this.f19358b.equals(cVar.c()) && this.f19359c == cVar.b();
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19358b.hashCode()) * 1000003) ^ (this.f19359c ? 1231 : 1237);
    }

    public String toString() {
        return "OsData{osRelease=" + this.a + ", osCodeName=" + this.f19358b + ", isRooted=" + this.f19359c + "}";
    }
}
