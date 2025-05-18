package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import java.util.List;
import okhttp3.HttpUrl;

/* compiled from: ReflectJavaValueParameter.kt */
/* loaded from: classes2.dex */
public final class b0 extends p implements kotlin.reflect.y.internal.j0.d.a.n0.b0 {
    private final z a;

    /* renamed from: b, reason: collision with root package name */
    private final Annotation[] f25329b;

    /* renamed from: c, reason: collision with root package name */
    private final String f25330c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f25331d;

    public b0(z zVar, Annotation[] annotationArr, String str, boolean z) {
        kotlin.jvm.internal.m.f(zVar, "type");
        kotlin.jvm.internal.m.f(annotationArr, "reflectAnnotations");
        this.a = zVar;
        this.f25329b = annotationArr;
        this.f25330c = str;
        this.f25331d = z;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public e l(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        return i.a(this.f25329b, cVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public List<e> getAnnotations() {
        return i.b(this.f25329b);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.b0
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public z getType() {
        return this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.b0
    public kotlin.reflect.y.internal.j0.f.f getName() {
        String str = this.f25330c;
        if (str != null) {
            return kotlin.reflect.y.internal.j0.f.f.v(str);
        }
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.b0
    public boolean h() {
        return this.f25331d;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(b0.class.getName());
        sb.append(": ");
        sb.append(h() ? "vararg " : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }
}
