package e.e.b.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_Event.java */
/* loaded from: classes2.dex */
public final class a<T> extends c<T> {
    private final Integer a;

    /* renamed from: b, reason: collision with root package name */
    private final T f20724b;

    /* renamed from: c, reason: collision with root package name */
    private final d f20725c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Integer num, T t, d dVar) {
        this.a = num;
        if (t != null) {
            this.f20724b = t;
            if (dVar != null) {
                this.f20725c = dVar;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    @Override // e.e.b.a.c
    public Integer a() {
        return this.a;
    }

    @Override // e.e.b.a.c
    public T b() {
        return this.f20724b;
    }

    @Override // e.e.b.a.c
    public d c() {
        return this.f20725c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Integer num = this.a;
        if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
            if (this.f20724b.equals(cVar.b()) && this.f20725c.equals(cVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f20724b.hashCode()) * 1000003) ^ this.f20725c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.a + ", payload=" + this.f20724b + ", priority=" + this.f20725c + "}";
    }
}
