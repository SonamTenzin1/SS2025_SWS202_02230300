package e.e.b.a.i.b0.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_PersistedEvent.java */
/* loaded from: classes2.dex */
public final class h0 extends q0 {
    private final long a;

    /* renamed from: b, reason: collision with root package name */
    private final e.e.b.a.i.q f20773b;

    /* renamed from: c, reason: collision with root package name */
    private final e.e.b.a.i.j f20774c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(long j2, e.e.b.a.i.q qVar, e.e.b.a.i.j jVar) {
        this.a = j2;
        if (qVar != null) {
            this.f20773b = qVar;
            if (jVar != null) {
                this.f20774c = jVar;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    @Override // e.e.b.a.i.b0.j.q0
    public e.e.b.a.i.j b() {
        return this.f20774c;
    }

    @Override // e.e.b.a.i.b0.j.q0
    public long c() {
        return this.a;
    }

    @Override // e.e.b.a.i.b0.j.q0
    public e.e.b.a.i.q d() {
        return this.f20773b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return this.a == q0Var.c() && this.f20773b.equals(q0Var.d()) && this.f20774c.equals(q0Var.b());
    }

    public int hashCode() {
        long j2 = this.a;
        return this.f20774c.hashCode() ^ ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f20773b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.a + ", transportContext=" + this.f20773b + ", event=" + this.f20774c + "}";
    }
}
