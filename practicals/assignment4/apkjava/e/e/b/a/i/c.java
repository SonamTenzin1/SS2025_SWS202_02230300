package e.e.b.a.i;

import e.e.b.a.i.j;
import java.util.Map;
import okhttp3.HttpUrl;

/* compiled from: AutoValue_EventInternal.java */
/* loaded from: classes2.dex */
final class c extends j {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final Integer f20809b;

    /* renamed from: c, reason: collision with root package name */
    private final i f20810c;

    /* renamed from: d, reason: collision with root package name */
    private final long f20811d;

    /* renamed from: e, reason: collision with root package name */
    private final long f20812e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, String> f20813f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_EventInternal.java */
    /* loaded from: classes2.dex */
    public static final class b extends j.a {
        private String a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f20814b;

        /* renamed from: c, reason: collision with root package name */
        private i f20815c;

        /* renamed from: d, reason: collision with root package name */
        private Long f20816d;

        /* renamed from: e, reason: collision with root package name */
        private Long f20817e;

        /* renamed from: f, reason: collision with root package name */
        private Map<String, String> f20818f;

        @Override // e.e.b.a.i.j.a
        public j d() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " transportName";
            }
            if (this.f20815c == null) {
                str2 = str2 + " encodedPayload";
            }
            if (this.f20816d == null) {
                str2 = str2 + " eventMillis";
            }
            if (this.f20817e == null) {
                str2 = str2 + " uptimeMillis";
            }
            if (this.f20818f == null) {
                str2 = str2 + " autoMetadata";
            }
            if (str2.isEmpty()) {
                return new c(this.a, this.f20814b, this.f20815c, this.f20816d.longValue(), this.f20817e.longValue(), this.f20818f);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // e.e.b.a.i.j.a
        protected Map<String, String> e() {
            Map<String, String> map = this.f20818f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.e.b.a.i.j.a
        public j.a f(Map<String, String> map) {
            if (map != null) {
                this.f20818f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        @Override // e.e.b.a.i.j.a
        public j.a g(Integer num) {
            this.f20814b = num;
            return this;
        }

        @Override // e.e.b.a.i.j.a
        public j.a h(i iVar) {
            if (iVar != null) {
                this.f20815c = iVar;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        @Override // e.e.b.a.i.j.a
        public j.a i(long j2) {
            this.f20816d = Long.valueOf(j2);
            return this;
        }

        @Override // e.e.b.a.i.j.a
        public j.a j(String str) {
            if (str != null) {
                this.a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        @Override // e.e.b.a.i.j.a
        public j.a k(long j2) {
            this.f20817e = Long.valueOf(j2);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.e.b.a.i.j
    public Map<String, String> c() {
        return this.f20813f;
    }

    @Override // e.e.b.a.i.j
    public Integer d() {
        return this.f20809b;
    }

    @Override // e.e.b.a.i.j
    public i e() {
        return this.f20810c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.a.equals(jVar.j()) && ((num = this.f20809b) != null ? num.equals(jVar.d()) : jVar.d() == null) && this.f20810c.equals(jVar.e()) && this.f20811d == jVar.f() && this.f20812e == jVar.k() && this.f20813f.equals(jVar.c());
    }

    @Override // e.e.b.a.i.j
    public long f() {
        return this.f20811d;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f20809b;
        int hashCode2 = (((hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f20810c.hashCode()) * 1000003;
        long j2 = this.f20811d;
        int i2 = (hashCode2 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f20812e;
        return ((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f20813f.hashCode();
    }

    @Override // e.e.b.a.i.j
    public String j() {
        return this.a;
    }

    @Override // e.e.b.a.i.j
    public long k() {
        return this.f20812e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.a + ", code=" + this.f20809b + ", encodedPayload=" + this.f20810c + ", eventMillis=" + this.f20811d + ", uptimeMillis=" + this.f20812e + ", autoMetadata=" + this.f20813f + "}";
    }

    private c(String str, Integer num, i iVar, long j2, long j3, Map<String, String> map) {
        this.a = str;
        this.f20809b = num;
        this.f20810c = iVar;
        this.f20811d = j2;
        this.f20812e = j3;
        this.f20813f = map;
    }
}
