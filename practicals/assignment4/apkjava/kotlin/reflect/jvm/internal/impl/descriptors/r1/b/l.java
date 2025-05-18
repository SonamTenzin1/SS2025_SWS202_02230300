package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.j0;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.m1;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.h;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.v;
import kotlin.reflect.y.internal.j0.d.a.n0.d0;
import kotlin.sequences.Sequence;

/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes2.dex */
public final class l extends p implements kotlin.reflect.jvm.internal.impl.descriptors.r1.b.h, v, kotlin.reflect.y.internal.j0.d.a.n0.g {
    private final Class<?> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a extends kotlin.jvm.internal.i implements Function1<Member, Boolean> {

        /* renamed from: h, reason: collision with root package name */
        public static final a f25349h = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "isSynthetic";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(Member.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member member) {
            kotlin.jvm.internal.m.f(member, "p0");
            return Boolean.valueOf(member.isSynthetic());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b extends kotlin.jvm.internal.i implements Function1<Constructor<?>, o> {

        /* renamed from: h, reason: collision with root package name */
        public static final b f25350h = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(o.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final o invoke(Constructor<?> constructor) {
            kotlin.jvm.internal.m.f(constructor, "p0");
            return new o(constructor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class c extends kotlin.jvm.internal.i implements Function1<Member, Boolean> {

        /* renamed from: h, reason: collision with root package name */
        public static final c f25351h = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "isSynthetic";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(Member.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member member) {
            kotlin.jvm.internal.m.f(member, "p0");
            return Boolean.valueOf(member.isSynthetic());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class d extends kotlin.jvm.internal.i implements Function1<Field, r> {

        /* renamed from: h, reason: collision with root package name */
        public static final d f25352h = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(r.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final r invoke(Field field) {
            kotlin.jvm.internal.m.f(field, "p0");
            return new r(field);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: classes2.dex */
    public static final class e extends Lambda implements Function1<Class<?>, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final e f25353f = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            kotlin.jvm.internal.m.e(simpleName, "it.simpleName");
            return Boolean.valueOf(simpleName.length() == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: classes2.dex */
    public static final class f extends Lambda implements Function1<Class<?>, kotlin.reflect.y.internal.j0.f.f> {

        /* renamed from: f, reason: collision with root package name */
        public static final f f25354f = new f();

        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.f.f invoke(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            if (!kotlin.reflect.y.internal.j0.f.f.A(simpleName)) {
                simpleName = null;
            }
            if (simpleName != null) {
                return kotlin.reflect.y.internal.j0.f.f.x(simpleName);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: classes2.dex */
    public static final class g extends Lambda implements Function1<Method, Boolean> {
        g() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        
            if (r0.a0(r5) == false) goto L9;
         */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean invoke(Method method) {
            boolean z = true;
            if (!method.isSynthetic()) {
                if (l.this.B()) {
                    l lVar = l.this;
                    kotlin.jvm.internal.m.e(method, "method");
                }
                return Boolean.valueOf(z);
            }
            z = false;
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class h extends kotlin.jvm.internal.i implements Function1<Method, u> {

        /* renamed from: h, reason: collision with root package name */
        public static final h f25356h = new h();

        h() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(u.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final u invoke(Method method) {
            kotlin.jvm.internal.m.f(method, "p0");
            return new u(method);
        }
    }

    public l(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "klass");
        this.a = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a0(Method method) {
        String name = method.getName();
        if (kotlin.jvm.internal.m.a(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            kotlin.jvm.internal.m.e(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (kotlin.jvm.internal.m.a(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean B() {
        return this.a.isEnum();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r1.b.v
    public int E() {
        return this.a.getModifiers();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean H() {
        return this.a.isInterface();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public d0 I() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public Collection<kotlin.reflect.y.internal.j0.d.a.n0.j> N() {
        List j2;
        Class<?>[] c2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.b.a.c(this.a);
        if (c2 != null) {
            ArrayList arrayList = new ArrayList(c2.length);
            for (Class<?> cls : c2) {
                arrayList.add(new n(cls));
            }
            return arrayList;
        }
        j2 = kotlin.collections.u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean Q() {
        return v.a.d(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.r1.b.e l(kotlin.reflect.y.internal.j0.f.c cVar) {
        return h.a.a(this, cVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.r1.b.e> getAnnotations() {
        return h.a.b(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public List<o> k() {
        Sequence r;
        Sequence m;
        Sequence u;
        List<o> A;
        Constructor<?>[] declaredConstructors = this.a.getDeclaredConstructors();
        kotlin.jvm.internal.m.e(declaredConstructors, "klass.declaredConstructors");
        r = kotlin.collections.n.r(declaredConstructors);
        m = kotlin.sequences.n.m(r, a.f25349h);
        u = kotlin.sequences.n.u(m, b.f25350h);
        A = kotlin.sequences.n.A(u);
        return A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r1.b.h
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public Class<?> w() {
        return this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public List<r> D() {
        Sequence r;
        Sequence m;
        Sequence u;
        List<r> A;
        Field[] declaredFields = this.a.getDeclaredFields();
        kotlin.jvm.internal.m.e(declaredFields, "klass.declaredFields");
        r = kotlin.collections.n.r(declaredFields);
        m = kotlin.sequences.n.m(r, c.f25351h);
        u = kotlin.sequences.n.u(m, d.f25352h);
        A = kotlin.sequences.n.A(u);
        return A;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.y.internal.j0.f.f> K() {
        Sequence r;
        Sequence m;
        Sequence v;
        List<kotlin.reflect.y.internal.j0.f.f> A;
        Class<?>[] declaredClasses = this.a.getDeclaredClasses();
        kotlin.jvm.internal.m.e(declaredClasses, "klass.declaredClasses");
        r = kotlin.collections.n.r(declaredClasses);
        m = kotlin.sequences.n.m(r, e.f25353f);
        v = kotlin.sequences.n.v(m, f.f25354f);
        A = kotlin.sequences.n.A(v);
        return A;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public List<u> M() {
        Sequence r;
        Sequence l;
        Sequence u;
        List<u> A;
        Method[] declaredMethods = this.a.getDeclaredMethods();
        kotlin.jvm.internal.m.e(declaredMethods, "klass.declaredMethods");
        r = kotlin.collections.n.r(declaredMethods);
        l = kotlin.sequences.n.l(r, new g());
        u = kotlin.sequences.n.u(l, h.f25356h);
        A = kotlin.sequences.n.A(u);
        return A;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public l i() {
        Class<?> declaringClass = this.a.getDeclaringClass();
        if (declaringClass != null) {
            return new l(declaringClass);
        }
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public Collection<kotlin.reflect.y.internal.j0.d.a.n0.j> a() {
        Class cls;
        List m;
        int u;
        List j2;
        cls = Object.class;
        if (kotlin.jvm.internal.m.a(this.a, cls)) {
            j2 = kotlin.collections.u.j();
            return j2;
        }
        j0 j0Var = new j0(2);
        Object genericSuperclass = this.a.getGenericSuperclass();
        j0Var.a(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.a.getGenericInterfaces();
        kotlin.jvm.internal.m.e(genericInterfaces, "klass.genericInterfaces");
        j0Var.b(genericInterfaces);
        m = kotlin.collections.u.m(j0Var.d(new Type[j0Var.c()]));
        u = kotlin.collections.v.u(m, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator it = m.iterator();
        while (it.hasNext()) {
            arrayList.add(new n((Type) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public kotlin.reflect.y.internal.j0.f.c d() {
        kotlin.reflect.y.internal.j0.f.c b2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(this.a).b();
        kotlin.jvm.internal.m.e(b2, "klass.classId.asSingleFqName()");
        return b2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof l) && kotlin.jvm.internal.m.a(this.a, ((l) obj).a);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.t
    public kotlin.reflect.y.internal.j0.f.f getName() {
        kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(this.a.getSimpleName());
        kotlin.jvm.internal.m.e(x, "identifier(klass.simpleName)");
        return x;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.z
    public List<a0> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.a.getTypeParameters();
        kotlin.jvm.internal.m.e(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public m1 getVisibility() {
        return v.a.a(this);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean isAbstract() {
        return v.a.b(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean isFinal() {
        return v.a.c(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public Collection<kotlin.reflect.y.internal.j0.d.a.n0.w> j() {
        Object[] d2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.b.a.d(this.a);
        if (d2 == null) {
            d2 = new Object[0];
        }
        ArrayList arrayList = new ArrayList(d2.length);
        for (Object obj : d2) {
            arrayList.add(new y(obj));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return h.a.c(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean o() {
        Boolean f2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.b.a.f(this.a);
        if (f2 != null) {
            return f2.booleanValue();
        }
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean r() {
        return this.a.isAnnotation();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean t() {
        Boolean e2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.b.a.e(this.a);
        if (e2 != null) {
            return e2.booleanValue();
        }
        return false;
    }

    public String toString() {
        return l.class.getName() + ": " + this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean u() {
        return false;
    }
}
