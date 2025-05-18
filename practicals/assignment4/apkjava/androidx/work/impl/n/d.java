package androidx.work.impl.n;

/* compiled from: Preference.java */
/* loaded from: classes.dex */
public class d {
    public String a;

    /* renamed from: b, reason: collision with root package name */
    public Long f2513b;

    public d(String str, boolean z) {
        this(str, z ? 1L : 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.a.equals(dVar.a)) {
            return false;
        }
        Long l = this.f2513b;
        Long l2 = dVar.f2513b;
        return l != null ? l.equals(l2) : l2 == null;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        Long l = this.f2513b;
        return hashCode + (l != null ? l.hashCode() : 0);
    }

    public d(String str, long j2) {
        this.a = str;
        this.f2513b = Long.valueOf(j2);
    }
}
