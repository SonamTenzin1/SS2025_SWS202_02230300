package kotlin.reflect.y.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.y.internal.a0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import okhttp3.HttpUrl;

/* compiled from: KParameterImpl.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0013\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\"H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", HttpUrl.FRAGMENT_ENCODE_SET, "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", HttpUrl.FRAGMENT_ENCODE_SET, "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: kotlin.f0.y.e.p, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class KParameterImpl implements KParameter {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f24978f = {g0.h(new y(g0.b(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), g0.h(new y(g0.b(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* renamed from: g, reason: collision with root package name */
    private final KCallableImpl<?> f24979g;

    /* renamed from: h, reason: collision with root package name */
    private final int f24980h;

    /* renamed from: i, reason: collision with root package name */
    private final KParameter.a f24981i;

    /* renamed from: j, reason: collision with root package name */
    private final a0.a f24982j;

    /* renamed from: k, reason: collision with root package name */
    private final a0.a f24983k;

    /* compiled from: KParameterImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.p$a */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function0<List<? extends Annotation>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Annotation> invoke() {
            return g0.e(KParameterImpl.this.f());
        }
    }

    /* compiled from: KParameterImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.p$b */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function0<Type> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Type invoke() {
            q0 f2 = KParameterImpl.this.f();
            if ((f2 instanceof w0) && m.a(g0.i(KParameterImpl.this.d().F()), f2) && KParameterImpl.this.d().F().i() == b.a.FAKE_OVERRIDE) {
                kotlin.reflect.jvm.internal.impl.descriptors.m b2 = KParameterImpl.this.d().F().b();
                m.d(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                Class<?> p = g0.p((e) b2);
                if (p != null) {
                    return p;
                }
                throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + f2);
            }
            return KParameterImpl.this.d().z().a().get(KParameterImpl.this.getF24980h());
        }
    }

    public KParameterImpl(KCallableImpl<?> kCallableImpl, int i2, KParameter.a aVar, Function0<? extends q0> function0) {
        m.f(kCallableImpl, "callable");
        m.f(aVar, "kind");
        m.f(function0, "computeDescriptor");
        this.f24979g = kCallableImpl;
        this.f24980h = i2;
        this.f24981i = aVar;
        this.f24982j = a0.d(function0);
        this.f24983k = a0.d(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final q0 f() {
        T c2 = this.f24982j.c(this, f24978f[0]);
        m.e(c2, "<get-descriptor>(...)");
        return (q0) c2;
    }

    public final KCallableImpl<?> d() {
        return this.f24979g;
    }

    public boolean equals(Object other) {
        if (other instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) other;
            if (m.a(this.f24979g, kParameterImpl.f24979g) && getF24980h() == kParameterImpl.getF24980h()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    /* renamed from: g, reason: from getter */
    public int getF24980h() {
        return this.f24980h;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        T c2 = this.f24983k.c(this, f24978f[1]);
        m.e(c2, "<get-annotations>(...)");
        return (List) c2;
    }

    @Override // kotlin.reflect.KParameter
    public String getName() {
        q0 f2 = f();
        i1 i1Var = f2 instanceof i1 ? (i1) f2 : null;
        if (i1Var == null || i1Var.b().G()) {
            return null;
        }
        f name = i1Var.getName();
        m.e(name, "valueParameter.name");
        if (name.y()) {
            return null;
        }
        return name.k();
    }

    @Override // kotlin.reflect.KParameter
    public KType getType() {
        e0 type = f().getType();
        m.e(type, "descriptor.type");
        return new KTypeImpl(type, new b());
    }

    @Override // kotlin.reflect.KParameter
    public boolean h() {
        q0 f2 = f();
        return (f2 instanceof i1) && ((i1) f2).l0() != null;
    }

    public int hashCode() {
        return (this.f24979g.hashCode() * 31) + Integer.valueOf(getF24980h()).hashCode();
    }

    @Override // kotlin.reflect.KParameter
    /* renamed from: i, reason: from getter */
    public KParameter.a getF24981i() {
        return this.f24981i;
    }

    @Override // kotlin.reflect.KParameter
    public boolean k() {
        q0 f2 = f();
        i1 i1Var = f2 instanceof i1 ? (i1) f2 : null;
        if (i1Var != null) {
            return kotlin.reflect.y.internal.j0.i.t.a.a(i1Var);
        }
        return false;
    }

    public String toString() {
        return ReflectionObjectRenderer.a.f(this);
    }
}
