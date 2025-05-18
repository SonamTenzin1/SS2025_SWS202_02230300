package kotlin.reflect.y.internal;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.a.f;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.y.internal.KDeclarationContainerImpl;
import kotlin.reflect.y.internal.a0;
import kotlin.reflect.y.internal.j0.c.b.d;
import kotlin.reflect.y.internal.j0.e.a0.b.e;
import kotlin.reflect.y.internal.j0.e.a0.b.i;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.t;
import kotlin.reflect.y.internal.j0.e.z.g;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.j.b.w;
import kotlin.text.u;
import okhttp3.HttpUrl;

/* compiled from: KPackageImpl.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001,B\u001d\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\b2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0016J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\b2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012 \u000f*\b\u0018\u00010\u000eR\u00020\u00000\u000eR\u00020\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR\u0018\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00038TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "usageModuleName", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/Class;Ljava/lang/String;)V", "constructorDescriptors", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "methodOwner", "getMethodOwner", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "getUsageModuleName", "()Ljava/lang/String;", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", HttpUrl.FRAGMENT_ENCODE_SET, "getProperties", "hashCode", "toString", "Data", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: kotlin.f0.y.e.o, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class KPackageImpl extends KDeclarationContainerImpl {

    /* renamed from: i, reason: collision with root package name */
    private final Class<?> f24959i;

    /* renamed from: j, reason: collision with root package name */
    private final String f24960j;

    /* renamed from: k, reason: collision with root package name */
    private final a0.b<a> f24961k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KPackageImpl.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R%\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\r\u0010\u000eR/\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "kotlinClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "members", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "()Ljava/util/Collection;", "members$delegate", "metadata", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "getMetadata", "()Lkotlin/Triple;", "metadata$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "multifileFacade", "Ljava/lang/Class;", "getMultifileFacade", "()Ljava/lang/Class;", "multifileFacade$delegate", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope$delegate", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.o$a */
    /* loaded from: classes2.dex */
    public final class a extends KDeclarationContainerImpl.b {

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f24962d = {g0.h(new y(g0.b(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), g0.h(new y(g0.b(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), g0.h(new y(g0.b(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), g0.h(new y(g0.b(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), g0.h(new y(g0.b(a.class), "members", "getMembers()Ljava/util/Collection;"))};

        /* renamed from: e, reason: collision with root package name */
        private final a0.a f24963e;

        /* renamed from: f, reason: collision with root package name */
        private final a0.a f24964f;

        /* renamed from: g, reason: collision with root package name */
        private final a0.b f24965g;

        /* renamed from: h, reason: collision with root package name */
        private final a0.b f24966h;

        /* renamed from: i, reason: collision with root package name */
        private final a0.a f24967i;

        /* compiled from: KPackageImpl.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: kotlin.f0.y.e.o$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static final class C0404a extends Lambda implements Function0<f> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ KPackageImpl f24969f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0404a(KPackageImpl kPackageImpl) {
                super(0);
                this.f24969f = kPackageImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final f invoke() {
                return f.a.a(this.f24969f.a());
            }
        }

        /* compiled from: KPackageImpl.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: kotlin.f0.y.e.o$a$b */
        /* loaded from: classes2.dex */
        static final class b extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ KPackageImpl f24970f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ a f24971g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(KPackageImpl kPackageImpl, a aVar) {
                super(0);
                this.f24970f = kPackageImpl;
                this.f24971g = aVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Collection<KCallableImpl<?>> invoke() {
                return this.f24970f.D(this.f24971g.f(), KDeclarationContainerImpl.c.DECLARED);
            }
        }

        /* compiled from: KPackageImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: kotlin.f0.y.e.o$a$c */
        /* loaded from: classes2.dex */
        static final class c extends Lambda implements Function0<Triple<? extends kotlin.reflect.y.internal.j0.e.a0.b.f, ? extends l, ? extends kotlin.reflect.y.internal.j0.e.a0.b.e>> {
            c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Triple<kotlin.reflect.y.internal.j0.e.a0.b.f, l, kotlin.reflect.y.internal.j0.e.a0.b.e> invoke() {
                kotlin.reflect.y.internal.j0.d.b.c0.a a;
                f c2 = a.this.c();
                if (c2 == null || (a = c2.a()) == null) {
                    return null;
                }
                String[] a2 = a.a();
                String[] g2 = a.g();
                if (a2 == null || g2 == null) {
                    return null;
                }
                Pair<kotlin.reflect.y.internal.j0.e.a0.b.f, l> m = i.m(a2, g2);
                return new Triple<>(m.a(), m.b(), a.d());
            }
        }

        /* compiled from: KPackageImpl.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Class;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: kotlin.f0.y.e.o$a$d */
        /* loaded from: classes2.dex */
        static final class d extends Lambda implements Function0<Class<?>> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ KPackageImpl f24974g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(KPackageImpl kPackageImpl) {
                super(0);
                this.f24974g = kPackageImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Class<?> invoke() {
                String z;
                kotlin.reflect.y.internal.j0.d.b.c0.a a;
                f c2 = a.this.c();
                String e2 = (c2 == null || (a = c2.a()) == null) ? null : a.e();
                if (e2 == null) {
                    return null;
                }
                if (!(e2.length() > 0)) {
                    return null;
                }
                ClassLoader classLoader = this.f24974g.a().getClassLoader();
                z = u.z(e2, '/', '.', false, 4, null);
                return classLoader.loadClass(z);
            }
        }

        /* compiled from: KPackageImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: kotlin.f0.y.e.o$a$e */
        /* loaded from: classes2.dex */
        static final class e extends Lambda implements Function0<h> {
            e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final h invoke() {
                f c2 = a.this.c();
                if (c2 != null) {
                    return a.this.a().c().a(c2);
                }
                return h.b.f24422b;
            }
        }

        public a() {
            super();
            this.f24963e = a0.d(new C0404a(KPackageImpl.this));
            this.f24964f = a0.d(new e());
            this.f24965g = a0.b(new d(KPackageImpl.this));
            this.f24966h = a0.b(new c());
            this.f24967i = a0.d(new b(KPackageImpl.this, this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final f c() {
            return (f) this.f24963e.c(this, f24962d[0]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Triple<kotlin.reflect.y.internal.j0.e.a0.b.f, l, kotlin.reflect.y.internal.j0.e.a0.b.e> d() {
            return (Triple) this.f24966h.c(this, f24962d[3]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Class<?> e() {
            return (Class) this.f24965g.c(this, f24962d[2]);
        }

        public final h f() {
            T c2 = this.f24964f.c(this, f24962d[1]);
            m.e(c2, "<get-scope>(...)");
            return (h) c2;
        }
    }

    /* compiled from: KPackageImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012 \u0003*\b\u0018\u00010\u0001R\u00020\u00020\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.o$b */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function0<a> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a();
        }
    }

    /* compiled from: KPackageImpl.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.o$c */
    /* loaded from: classes2.dex */
    /* synthetic */ class c extends kotlin.jvm.internal.i implements Function2<w, n, t0> {

        /* renamed from: h, reason: collision with root package name */
        public static final c f24977h = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "loadProperty";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(w.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final t0 invoke(w wVar, n nVar) {
            m.f(wVar, "p0");
            m.f(nVar, "p1");
            return wVar.l(nVar);
        }
    }

    public KPackageImpl(Class<?> cls, String str) {
        m.f(cls, "jClass");
        this.f24959i = cls;
        this.f24960j = str;
        a0.b<a> b2 = a0.b(new b());
        m.e(b2, "lazy { Data() }");
        this.f24961k = b2;
    }

    private final h M() {
        return this.f24961k.invoke().f();
    }

    @Override // kotlin.reflect.y.internal.KDeclarationContainerImpl
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.l> A() {
        List j2;
        j2 = kotlin.collections.u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.KDeclarationContainerImpl
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> B(kotlin.reflect.y.internal.j0.f.f fVar) {
        m.f(fVar, "name");
        return M().a(fVar, d.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.y.internal.KDeclarationContainerImpl
    public t0 C(int i2) {
        Triple<kotlin.reflect.y.internal.j0.e.a0.b.f, l, e> d2 = this.f24961k.invoke().d();
        if (d2 == null) {
            return null;
        }
        kotlin.reflect.y.internal.j0.e.a0.b.f a2 = d2.a();
        l b2 = d2.b();
        e c2 = d2.c();
        h.f<l, List<n>> fVar = kotlin.reflect.y.internal.j0.e.a0.a.n;
        m.e(fVar, "packageLocalVariable");
        n nVar = (n) kotlin.reflect.y.internal.j0.e.z.e.b(b2, fVar, i2);
        if (nVar == null) {
            return null;
        }
        Class<?> a3 = a();
        t V = b2.V();
        m.e(V, "packageProto.typeTable");
        return (t0) g0.h(a3, nVar, a2, new g(V), c2, c.f24977h);
    }

    @Override // kotlin.reflect.y.internal.KDeclarationContainerImpl
    protected Class<?> E() {
        Class<?> e2 = this.f24961k.invoke().e();
        return e2 == null ? a() : e2;
    }

    @Override // kotlin.reflect.y.internal.KDeclarationContainerImpl
    public Collection<t0> F(kotlin.reflect.y.internal.j0.f.f fVar) {
        m.f(fVar, "name");
        return M().c(fVar, d.FROM_REFLECTION);
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> a() {
        return this.f24959i;
    }

    public boolean equals(Object other) {
        return (other instanceof KPackageImpl) && m.a(a(), ((KPackageImpl) other).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "file class " + kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(a()).b();
    }
}
