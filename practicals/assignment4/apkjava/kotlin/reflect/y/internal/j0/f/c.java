package kotlin.reflect.y.internal.j0.f;

import java.util.List;
import okhttp3.HttpUrl;

/* compiled from: FqName.java */
/* loaded from: classes3.dex */
public final class c {
    public static final c a = new c(HttpUrl.FRAGMENT_ENCODE_SET);

    /* renamed from: b, reason: collision with root package name */
    private final d f24205b;

    /* renamed from: c, reason: collision with root package name */
    private transient c f24206c;

    public c(String str) {
        if (str == null) {
            a(1);
        }
        this.f24205b = new d(str, this);
    }

    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i3 = 2;
                break;
            case 8:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(format);
            case 8:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static c k(f fVar) {
        if (fVar == null) {
            a(13);
        }
        return new c(d.m(fVar));
    }

    public String b() {
        String b2 = this.f24205b.b();
        if (b2 == null) {
            a(4);
        }
        return b2;
    }

    public c c(f fVar) {
        if (fVar == null) {
            a(8);
        }
        return new c(this.f24205b.c(fVar), this);
    }

    public boolean d() {
        return this.f24205b.e();
    }

    public c e() {
        c cVar = this.f24206c;
        if (cVar != null) {
            if (cVar == null) {
                a(6);
            }
            return cVar;
        }
        if (!d()) {
            c cVar2 = new c(this.f24205b.g());
            this.f24206c = cVar2;
            if (cVar2 == null) {
                a(7);
            }
            return cVar2;
        }
        throw new IllegalStateException("root");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f24205b.equals(((c) obj).f24205b);
    }

    public List<f> f() {
        List<f> h2 = this.f24205b.h();
        if (h2 == null) {
            a(11);
        }
        return h2;
    }

    public f g() {
        f i2 = this.f24205b.i();
        if (i2 == null) {
            a(9);
        }
        return i2;
    }

    public f h() {
        f j2 = this.f24205b.j();
        if (j2 == null) {
            a(10);
        }
        return j2;
    }

    public int hashCode() {
        return this.f24205b.hashCode();
    }

    public boolean i(f fVar) {
        if (fVar == null) {
            a(12);
        }
        return this.f24205b.k(fVar);
    }

    public d j() {
        d dVar = this.f24205b;
        if (dVar == null) {
            a(5);
        }
        return dVar;
    }

    public String toString() {
        return this.f24205b.toString();
    }

    public c(d dVar) {
        if (dVar == null) {
            a(2);
        }
        this.f24205b = dVar;
    }

    private c(d dVar, c cVar) {
        if (dVar == null) {
            a(3);
        }
        this.f24205b = dVar;
        this.f24206c = cVar;
    }
}
