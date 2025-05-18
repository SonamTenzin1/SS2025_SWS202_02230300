package kotlin.reflect.y.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.j;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d;
import kotlin.reflect.y.internal.a0;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.r1;
import okhttp3.HttpUrl;

/* compiled from: KTypeImpl.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001bH\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020,H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006-²\u0006\u0010\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u008a\u0084\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/KTypeBase;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getComputeJavaType$annotations", "()V", "isMarkedNullable", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "makeNullableAsSpecified", "nullable", "makeNullableAsSpecified$kotlin_reflection", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-reflection", "parameterizedTypeArguments"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: kotlin.f0.y.e.v, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class KTypeImpl implements KTypeBase {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f25004f = {g0.h(new y(g0.b(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), g0.h(new y(g0.b(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};

    /* renamed from: g, reason: collision with root package name */
    private final e0 f25005g;

    /* renamed from: h, reason: collision with root package name */
    private final a0.a<Type> f25006h;

    /* renamed from: i, reason: collision with root package name */
    private final a0.a f25007i;

    /* renamed from: j, reason: collision with root package name */
    private final a0.a f25008j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KTypeImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/KTypeProjection;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.v$a */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function0<List<? extends KTypeProjection>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function0<Type> f25010g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: KTypeImpl.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: kotlin.f0.y.e.v$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0405a extends Lambda implements Function0<Type> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ KTypeImpl f25011f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f25012g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Lazy<List<Type>> f25013h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0405a(KTypeImpl kTypeImpl, int i2, Lazy<? extends List<? extends Type>> lazy) {
                super(0);
                this.f25011f = kTypeImpl;
                this.f25012g = i2;
                this.f25013h = lazy;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Type invoke() {
                Type j2 = this.f25011f.j();
                if (j2 instanceof Class) {
                    Class cls = (Class) j2;
                    Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                    m.e(componentType, "{\n                      …                        }");
                    return componentType;
                }
                if (j2 instanceof GenericArrayType) {
                    if (this.f25012g == 0) {
                        Type genericComponentType = ((GenericArrayType) j2).getGenericComponentType();
                        m.e(genericComponentType, "{\n                      …                        }");
                        return genericComponentType;
                    }
                    throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this.f25011f);
                }
                if (j2 instanceof ParameterizedType) {
                    Type type = (Type) a.c(this.f25013h).get(this.f25012g);
                    if (type instanceof WildcardType) {
                        WildcardType wildcardType = (WildcardType) type;
                        Type[] lowerBounds = wildcardType.getLowerBounds();
                        m.e(lowerBounds, "argument.lowerBounds");
                        Type type2 = (Type) j.x(lowerBounds);
                        if (type2 == null) {
                            Type[] upperBounds = wildcardType.getUpperBounds();
                            m.e(upperBounds, "argument.upperBounds");
                            type = (Type) j.w(upperBounds);
                        } else {
                            type = type2;
                        }
                    }
                    m.e(type, "{\n                      …                        }");
                    return type;
                }
                throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this.f25011f);
            }
        }

        /* compiled from: KTypeImpl.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: kotlin.f0.y.e.v$a$b */
        /* loaded from: classes2.dex */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[r1.values().length];
                iArr[r1.INVARIANT.ordinal()] = 1;
                iArr[r1.IN_VARIANCE.ordinal()] = 2;
                iArr[r1.OUT_VARIANCE.ordinal()] = 3;
                a = iArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: KTypeImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: kotlin.f0.y.e.v$a$c */
        /* loaded from: classes2.dex */
        public static final class c extends Lambda implements Function0<List<? extends Type>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ KTypeImpl f25014f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(KTypeImpl kTypeImpl) {
                super(0);
                this.f25014f = kTypeImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Type> invoke() {
                Type j2 = this.f25014f.j();
                m.c(j2);
                return d.c(j2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function0<? extends Type> function0) {
            super(0);
            this.f25010g = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List<Type> c(Lazy<? extends List<? extends Type>> lazy) {
            return (List) lazy.getValue();
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends KTypeProjection> invoke() {
            Lazy a;
            int u;
            KTypeProjection d2;
            List<? extends KTypeProjection> j2;
            List<g1> M0 = KTypeImpl.this.getF25005g().M0();
            if (M0.isEmpty()) {
                j2 = u.j();
                return j2;
            }
            a = i.a(LazyThreadSafetyMode.PUBLICATION, new c(KTypeImpl.this));
            Function0<Type> function0 = this.f25010g;
            KTypeImpl kTypeImpl = KTypeImpl.this;
            u = v.u(M0, 10);
            ArrayList arrayList = new ArrayList(u);
            int i2 = 0;
            for (Object obj : M0) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    u.t();
                }
                g1 g1Var = (g1) obj;
                if (g1Var.c()) {
                    d2 = KTypeProjection.a.c();
                } else {
                    e0 type = g1Var.getType();
                    m.e(type, "typeProjection.type");
                    KTypeImpl kTypeImpl2 = new KTypeImpl(type, function0 == null ? null : new C0405a(kTypeImpl, i2, a));
                    int i4 = b.a[g1Var.a().ordinal()];
                    if (i4 == 1) {
                        d2 = KTypeProjection.a.d(kTypeImpl2);
                    } else if (i4 != 2) {
                        if (i4 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        d2 = KTypeProjection.a.b(kTypeImpl2);
                    } else {
                        d2 = KTypeProjection.a.a(kTypeImpl2);
                    }
                }
                arrayList.add(d2);
                i2 = i3;
            }
            return arrayList;
        }
    }

    /* compiled from: KTypeImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.v$b */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function0<KClassifier> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final KClassifier invoke() {
            KTypeImpl kTypeImpl = KTypeImpl.this;
            return kTypeImpl.d(kTypeImpl.getF25005g());
        }
    }

    public KTypeImpl(e0 e0Var, Function0<? extends Type> function0) {
        m.f(e0Var, "type");
        this.f25005g = e0Var;
        a0.a<Type> aVar = null;
        a0.a<Type> aVar2 = function0 instanceof a0.a ? (a0.a) function0 : null;
        if (aVar2 != null) {
            aVar = aVar2;
        } else if (function0 != null) {
            aVar = a0.d(function0);
        }
        this.f25006h = aVar;
        this.f25007i = a0.d(new b());
        this.f25008j = a0.d(new a(function0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KClassifier d(e0 e0Var) {
        e0 type;
        h w = e0Var.O0().w();
        if (w instanceof e) {
            Class<?> p = g0.p((e) w);
            if (p == null) {
                return null;
            }
            if (p.isArray()) {
                g1 g1Var = (g1) s.u0(e0Var.M0());
                if (g1Var != null && (type = g1Var.getType()) != null) {
                    KClassifier d2 = d(type);
                    if (d2 != null) {
                        return new KClassImpl(g0.f(kotlin.jvm.a.b(kotlin.reflect.y.b.a(d2))));
                    }
                    throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
                }
                return new KClassImpl(p);
            }
            if (!n1.l(e0Var)) {
                Class<?> d3 = d.d(p);
                if (d3 != null) {
                    p = d3;
                }
                return new KClassImpl(p);
            }
            return new KClassImpl(p);
        }
        if (w instanceof e1) {
            return new KTypeParameterImpl(null, (e1) w);
        }
        if (!(w instanceof d1)) {
            return null;
        }
        throw new NotImplementedError("An operation is not implemented: Type alias classifiers are not yet supported");
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> b() {
        T c2 = this.f25008j.c(this, f25004f[1]);
        m.e(c2, "<get-arguments>(...)");
        return (List) c2;
    }

    @Override // kotlin.reflect.KType
    public KClassifier c() {
        return (KClassifier) this.f25007i.c(this, f25004f[0]);
    }

    @Override // kotlin.reflect.KType
    public boolean e() {
        return this.f25005g.P0();
    }

    public boolean equals(Object other) {
        return (other instanceof KTypeImpl) && m.a(this.f25005g, ((KTypeImpl) other).f25005g);
    }

    /* renamed from: f, reason: from getter */
    public final e0 getF25005g() {
        return this.f25005g;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return g0.e(this.f25005g);
    }

    public int hashCode() {
        return this.f25005g.hashCode();
    }

    @Override // kotlin.jvm.internal.KTypeBase
    public Type j() {
        a0.a<Type> aVar = this.f25006h;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    public String toString() {
        return ReflectionObjectRenderer.a.h(this.f25005g);
    }

    public /* synthetic */ KTypeImpl(e0 e0Var, Function0 function0, int i2, g gVar) {
        this(e0Var, (i2 & 2) != 0 ? null : function0);
    }
}
