package com.google.firebase.u;

/* compiled from: AutoValue_LibraryVersion.java */
/* loaded from: classes2.dex */
final class c extends g {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f20131b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2) {
        if (str != null) {
            this.a = str;
            if (str2 != null) {
                this.f20131b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    @Override // com.google.firebase.u.g
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.u.g
    public String c() {
        return this.f20131b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a.equals(gVar.b()) && this.f20131b.equals(gVar.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f20131b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.a + ", version=" + this.f20131b + "}";
    }
}
