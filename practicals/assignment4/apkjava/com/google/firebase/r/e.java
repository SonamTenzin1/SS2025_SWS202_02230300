package com.google.firebase.r;

import java.util.List;

/* compiled from: AutoValue_HeartBeatResult.java */
/* loaded from: classes2.dex */
final class e extends l {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f19893b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, List<String> list) {
        if (str != null) {
            this.a = str;
            if (list != null) {
                this.f19893b = list;
                return;
            }
            throw new NullPointerException("Null usedDates");
        }
        throw new NullPointerException("Null userAgent");
    }

    @Override // com.google.firebase.r.l
    public List<String> b() {
        return this.f19893b;
    }

    @Override // com.google.firebase.r.l
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.a.equals(lVar.c()) && this.f19893b.equals(lVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19893b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.a + ", usedDates=" + this.f19893b + "}";
    }
}
