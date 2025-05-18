package kotlin.reflect.y.internal.j0.l.u1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.y.internal.j0.b.e;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* compiled from: ErrorTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class i implements e1 {
    private final j a;

    /* renamed from: b, reason: collision with root package name */
    private final String[] f24845b;

    /* renamed from: c, reason: collision with root package name */
    private final String f24846c;

    public i(j jVar, String... strArr) {
        m.f(jVar, "kind");
        m.f(strArr, "formatParams");
        this.a = jVar;
        this.f24845b = strArr;
        String k2 = b.ERROR_TYPE.k();
        String k3 = jVar.k();
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
        String format = String.format(k3, Arrays.copyOf(copyOf, copyOf.length));
        m.e(format, "format(this, *args)");
        String format2 = String.format(k2, Arrays.copyOf(new Object[]{format}, 1));
        m.e(format2, "format(this, *args)");
        this.f24846c = format2;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public Collection<e0> a() {
        List j2;
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public e1 b(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* renamed from: c */
    public h w() {
        return k.a.h();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public boolean e() {
        return false;
    }

    public final j g() {
        return this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public List<kotlin.reflect.jvm.internal.impl.descriptors.e1> getParameters() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.e1> j2;
        j2 = u.j();
        return j2;
    }

    public final String h(int i2) {
        return this.f24845b[i2];
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public kotlin.reflect.y.internal.j0.b.h o() {
        return e.f23157h.a();
    }

    public String toString() {
        return this.f24846c;
    }
}
