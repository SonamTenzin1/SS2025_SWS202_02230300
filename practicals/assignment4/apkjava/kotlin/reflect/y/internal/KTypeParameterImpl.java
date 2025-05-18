package kotlin.reflect.y.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.a0;
import kotlin.reflect.y.internal.j0.d.b.k;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.j.b.g0.f;
import kotlin.reflect.y.internal.j0.j.b.g0.g;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.u;
import okhttp3.HttpUrl;

/* compiled from: KTypeParameterImpl.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u0006\u0012\u0002\b\u00030#*\u00020$H\u0002J\u0010\u0010%\u001a\u0006\u0012\u0002\b\u00030&*\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "container", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "name", HttpUrl.FRAGMENT_ENCODE_SET, "getName", "()Ljava/lang/String;", "upperBounds", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "getContainerClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "toKClassImpl", "Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: kotlin.f0.y.e.w, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class KTypeParameterImpl implements KTypeParameter {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f25016f = {g0.h(new y(g0.b(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};

    /* renamed from: g, reason: collision with root package name */
    private final e1 f25017g;

    /* renamed from: h, reason: collision with root package name */
    private final a0.a f25018h;

    /* renamed from: i, reason: collision with root package name */
    private final KTypeParameterOwnerImpl f25019i;

    /* compiled from: KTypeParameterImpl.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.w$a */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r1.values().length];
            iArr[r1.INVARIANT.ordinal()] = 1;
            iArr[r1.IN_VARIANCE.ordinal()] = 2;
            iArr[r1.OUT_VARIANCE.ordinal()] = 3;
            a = iArr;
        }
    }

    /* compiled from: KTypeParameterImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.w$b */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function0<List<? extends KTypeImpl>> {
        b() {
            super(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final List<? extends KTypeImpl> invoke() {
            int u;
            List<e0> upperBounds = KTypeParameterImpl.this.getF25017g().getUpperBounds();
            m.e(upperBounds, "descriptor.upperBounds");
            u = v.u(upperBounds, 10);
            ArrayList arrayList = new ArrayList(u);
            Iterator<T> it = upperBounds.iterator();
            while (it.hasNext()) {
                arrayList.add(new KTypeImpl((e0) it.next(), null, 2, 0 == true ? 1 : 0));
            }
            return arrayList;
        }
    }

    public KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, e1 e1Var) {
        KClassImpl<?> kClassImpl;
        Object L;
        m.f(e1Var, "descriptor");
        this.f25017g = e1Var;
        this.f25018h = a0.d(new b());
        if (kTypeParameterOwnerImpl == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.m b2 = getF25017g().b();
            m.e(b2, "descriptor.containingDeclaration");
            if (b2 instanceof e) {
                L = c((e) b2);
            } else if (b2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) {
                kotlin.reflect.jvm.internal.impl.descriptors.m b3 = ((kotlin.reflect.jvm.internal.impl.descriptors.b) b2).b();
                m.e(b3, "declaration.containingDeclaration");
                if (b3 instanceof e) {
                    kClassImpl = c((e) b3);
                } else {
                    g gVar = b2 instanceof g ? (g) b2 : null;
                    if (gVar != null) {
                        KClass e2 = kotlin.jvm.a.e(a(gVar));
                        m.d(e2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                        kClassImpl = (KClassImpl) e2;
                    } else {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + b2);
                    }
                }
                L = b2.L(new CreateKCallableVisitor(kClassImpl), u.a);
            } else {
                throw new KotlinReflectionInternalError("Unknown type parameter container: " + b2);
            }
            m.e(L, "when (val declaration = … $declaration\")\n        }");
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) L;
        }
        this.f25019i = kTypeParameterOwnerImpl;
    }

    private final Class<?> a(g gVar) {
        Class<?> d2;
        f c0 = gVar.c0();
        if (!(c0 instanceof k)) {
            c0 = null;
        }
        k kVar = (k) c0;
        q g2 = kVar != null ? kVar.g() : null;
        kotlin.reflect.jvm.internal.impl.descriptors.r1.a.f fVar = (kotlin.reflect.jvm.internal.impl.descriptors.r1.a.f) (g2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.r1.a.f ? g2 : null);
        if (fVar != null && (d2 = fVar.d()) != null) {
            return d2;
        }
        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + gVar);
    }

    private final KClassImpl<?> c(e eVar) {
        Class<?> p = g0.p(eVar);
        KClassImpl<?> kClassImpl = (KClassImpl) (p != null ? kotlin.jvm.a.e(p) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + eVar.b());
    }

    /* renamed from: b, reason: from getter */
    public e1 getF25017g() {
        return this.f25017g;
    }

    public boolean equals(Object other) {
        if (other instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) other;
            if (m.a(this.f25019i, kTypeParameterImpl.f25019i) && m.a(getName(), kTypeParameterImpl.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        String k2 = getF25017g().getName().k();
        m.e(k2, "descriptor.name.asString()");
        return k2;
    }

    @Override // kotlin.reflect.KTypeParameter
    public List<KType> getUpperBounds() {
        T c2 = this.f25018h.c(this, f25016f[0]);
        m.e(c2, "<get-upperBounds>(...)");
        return (List) c2;
    }

    public int hashCode() {
        return (this.f25019i.hashCode() * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance n() {
        int i2 = a.a[getF25017g().n().ordinal()];
        if (i2 == 1) {
            return KVariance.INVARIANT;
        }
        if (i2 == 2) {
            return KVariance.IN;
        }
        if (i2 == 3) {
            return KVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public String toString() {
        return TypeParameterReference.f22947f.a(this);
    }
}
