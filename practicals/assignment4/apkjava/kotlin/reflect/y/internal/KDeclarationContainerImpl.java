package kotlin.reflect.y.internal;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.a.k;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.y.internal.a0;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.i.w.k;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.v;
import okhttp3.HttpUrl;

/* compiled from: KDeclarationContainerImpl.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\b \u0018\u0000 <2\u00020\u0001:\u0003<=>B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u0012\u0010#\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020%H&J\"\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0004J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u001a\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010/\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00100\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020%H\u0002JE\u00103\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0002\u00108J(\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015*\u0006\u0012\u0002\b\u00030\t2\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.H\u0002J=\u0010:\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0002\u0010;R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006?"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", HttpUrl.FRAGMENT_ENCODE_SET, "result", HttpUrl.FRAGMENT_ENCODE_SET, "desc", HttpUrl.FRAGMENT_ENCODE_SET, "isConstructor", HttpUrl.FRAGMENT_ENCODE_SET, "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", RoomInstalled.SIGNATURE, "findMethodBySignature", "findPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", HttpUrl.FRAGMENT_ENCODE_SET, "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", HttpUrl.FRAGMENT_ENCODE_SET, "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", HttpUrl.FRAGMENT_ENCODE_SET, "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: kotlin.f0.y.e.i, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {

    /* renamed from: f, reason: collision with root package name */
    public static final a f23095f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Class<?> f23096g = Class.forName("kotlin.a0.d.g");

    /* renamed from: h, reason: collision with root package name */
    private static final Regex f23097h = new Regex("<v#(\\d+)>");

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.i$a */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final Regex a() {
            return KDeclarationContainerImpl.f23097h;
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.i$b */
    /* loaded from: classes2.dex */
    public abstract class b {
        static final /* synthetic */ KProperty<Object>[] a = {g0.h(new y(g0.b(b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};

        /* renamed from: b, reason: collision with root package name */
        private final a0.a f23098b;

        /* compiled from: KDeclarationContainerImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: kotlin.f0.y.e.i$b$a */
        /* loaded from: classes2.dex */
        static final class a extends Lambda implements Function0<k> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ KDeclarationContainerImpl f23100f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(KDeclarationContainerImpl kDeclarationContainerImpl) {
                super(0);
                this.f23100f = kDeclarationContainerImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final k invoke() {
                return z.a(this.f23100f.a());
            }
        }

        public b() {
            this.f23098b = a0.d(new a(KDeclarationContainerImpl.this));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final k a() {
            T c2 = this.f23098b.c(this, a[0]);
            m.e(c2, "<get-moduleData>(...)");
            return (k) c2;
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;I)V", "accept", HttpUrl.FRAGMENT_ENCODE_SET, "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.i$c */
    /* loaded from: classes2.dex */
    protected enum c {
        DECLARED,
        INHERITED;

        public final boolean k(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "member");
            return bVar.i().g() == (this == DECLARED);
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.i$d */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements Function1<kotlin.reflect.jvm.internal.impl.descriptors.y, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final d f23104f = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
            m.f(yVar, "descriptor");
            return kotlin.reflect.y.internal.j0.h.c.f24255j.q(yVar) + " | " + RuntimeTypeMapper.a.g(yVar).getF23032b();
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.i$e */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements Function1<t0, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final e f23105f = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(t0 t0Var) {
            m.f(t0Var, "descriptor");
            return kotlin.reflect.y.internal.j0.h.c.f24255j.q(t0Var) + " | " + RuntimeTypeMapper.a.f(t0Var).getF23039f();
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "first", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "kotlin.jvm.PlatformType", "second", "compare"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.i$f */
    /* loaded from: classes2.dex */
    static final class f<T> implements Comparator {

        /* renamed from: f, reason: collision with root package name */
        public static final f<T> f23106f = new f<>();

        f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(u uVar, u uVar2) {
            Integer d2 = t.d(uVar, uVar2);
            if (d2 == null) {
                return 0;
            }
            return d2.intValue();
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "visitConstructorDescriptor", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "data", HttpUrl.FRAGMENT_ENCODE_SET, "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.i$g */
    /* loaded from: classes2.dex */
    public static final class g extends CreateKCallableVisitor {
        g(KDeclarationContainerImpl kDeclarationContainerImpl) {
            super(kDeclarationContainerImpl);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.l, kotlin.reflect.jvm.internal.impl.descriptors.o
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public KCallableImpl<?> h(l lVar, kotlin.u uVar) {
            m.f(lVar, "descriptor");
            m.f(uVar, "data");
            throw new IllegalStateException("No constructors should appear here: " + lVar);
        }
    }

    private final List<Class<?>> G(String str) {
        boolean I;
        int V;
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 1;
        while (str.charAt(i3) != ')') {
            int i4 = i3;
            while (str.charAt(i4) == '[') {
                i4++;
            }
            char charAt = str.charAt(i4);
            I = v.I("VZCBSIFJD", charAt, false, 2, null);
            if (I) {
                i2 = i4 + 1;
            } else if (charAt == 'L') {
                V = v.V(str, ';', i3, false, 4, null);
                i2 = V + 1;
            } else {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
            }
            arrayList.add(J(str, i3, i2));
            i3 = i2;
        }
        return arrayList;
    }

    private final Class<?> H(String str) {
        int V;
        V = v.V(str, ')', 0, false, 6, null);
        return J(str, V + 1, str.length());
    }

    private final Method I(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        Method I;
        if (z) {
            clsArr[0] = cls;
        }
        Method L = L(cls, str, clsArr, cls2);
        if (L != null) {
            return L;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (I = I(superclass, str, clsArr, cls2, z)) != null) {
            return I;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        m.e(interfaces, "interfaces");
        for (Class<?> cls3 : interfaces) {
            m.e(cls3, "superInterface");
            Method I2 = I(cls3, str, clsArr, cls2, z);
            if (I2 != null) {
                return I2;
            }
            if (z) {
                Class<?> a2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.a.e.a(kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.e(cls3), cls3.getName() + "$DefaultImpls");
                if (a2 != null) {
                    clsArr[0] = cls3;
                    Method L2 = L(a2, str, clsArr, cls2);
                    if (L2 != null) {
                        return L2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private final Class<?> J(String str, int i2, int i3) {
        String z;
        char charAt = str.charAt(i2);
        if (charAt == 'L') {
            ClassLoader e2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.e(a());
            String substring = str.substring(i2 + 1, i3 - 1);
            m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            z = kotlin.text.u.z(substring, '/', '.', false, 4, null);
            Class<?> loadClass = e2.loadClass(z);
            m.e(loadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return loadClass;
        }
        if (charAt == '[') {
            return g0.f(J(str, i2 + 1, i3));
        }
        if (charAt == 'V') {
            Class<?> cls = Void.TYPE;
            m.e(cls, "TYPE");
            return cls;
        }
        if (charAt == 'Z') {
            return Boolean.TYPE;
        }
        if (charAt == 'C') {
            return Character.TYPE;
        }
        if (charAt == 'B') {
            return Byte.TYPE;
        }
        if (charAt == 'S') {
            return Short.TYPE;
        }
        if (charAt == 'I') {
            return Integer.TYPE;
        }
        if (charAt == 'F') {
            return Float.TYPE;
        }
        if (charAt == 'J') {
            return Long.TYPE;
        }
        if (charAt == 'D') {
            return Double.TYPE;
        }
        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
    }

    private final Constructor<?> K(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Class[] clsArr = (Class[]) array;
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final Method L(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (m.a(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            m.e(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                if (m.a(method.getName(), str) && m.a(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final void f(List<Class<?>> list, String str, boolean z) {
        list.addAll(G(str));
        int size = ((r5.size() + 32) - 1) / 32;
        for (int i2 = 0; i2 < size; i2++) {
            Class<?> cls = Integer.TYPE;
            m.e(cls, "TYPE");
            list.add(cls);
        }
        if (z) {
            Class<?> cls2 = f23096g;
            list.remove(cls2);
            m.e(cls2, "DEFAULT_CONSTRUCTOR_MARKER");
            list.add(cls2);
            return;
        }
        list.add(Object.class);
    }

    public abstract Collection<l> A();

    public abstract Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> B(kotlin.reflect.y.internal.j0.f.f fVar);

    public abstract t0 C(int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Collection<KCallableImpl<?>> D(h hVar, c cVar) {
        List E0;
        KCallableImpl kCallableImpl;
        m.f(hVar, "scope");
        m.f(cVar, "belonginess");
        g gVar = new g(this);
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> a2 = k.a.a(hVar, null, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.m mVar : a2) {
            if (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) {
                kotlin.reflect.jvm.internal.impl.descriptors.b bVar = (kotlin.reflect.jvm.internal.impl.descriptors.b) mVar;
                if (!m.a(bVar.getVisibility(), t.f25371h) && cVar.k(bVar)) {
                    kCallableImpl = (KCallableImpl) mVar.L(gVar, kotlin.u.a);
                    if (kCallableImpl == null) {
                        arrayList.add(kCallableImpl);
                    }
                }
            }
            kCallableImpl = null;
            if (kCallableImpl == null) {
            }
        }
        E0 = c0.E0(arrayList);
        return E0;
    }

    protected Class<?> E() {
        Class<?> f2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.f(a());
        return f2 == null ? a() : f2;
    }

    public abstract Collection<t0> F(kotlin.reflect.y.internal.j0.f.f fVar);

    public final Constructor<?> u(String str) {
        m.f(str, "desc");
        return K(a(), G(str));
    }

    public final Constructor<?> v(String str) {
        m.f(str, "desc");
        Class<?> a2 = a();
        ArrayList arrayList = new ArrayList();
        f(arrayList, str, true);
        kotlin.u uVar = kotlin.u.a;
        return K(a2, arrayList);
    }

    public final Method w(String str, String str2, boolean z) {
        m.f(str, "name");
        m.f(str2, "desc");
        if (m.a(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(a());
        }
        f(arrayList, str2, false);
        Class<?> E = E();
        String str3 = str + "$default";
        Object[] array = arrayList.toArray(new Class[0]);
        m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return I(E, str3, (Class[]) array, H(str2), z);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.y x(String str, String str2) {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> B;
        String e0;
        m.f(str, "name");
        m.f(str2, RoomInstalled.SIGNATURE);
        if (m.a(str, "<init>")) {
            B = c0.E0(A());
        } else {
            kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(str);
            m.e(x, "identifier(name)");
            B = B(x);
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> collection = B;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (m.a(RuntimeTypeMapper.a.g((kotlin.reflect.jvm.internal.impl.descriptors.y) obj).getF23032b(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() != 1) {
            e0 = c0.e0(collection, "\n", null, null, 0, null, d.f23104f, 30, null);
            StringBuilder sb = new StringBuilder();
            sb.append("Function '");
            sb.append(str);
            sb.append("' (JVM signature: ");
            sb.append(str2);
            sb.append(") not resolved in ");
            sb.append(this);
            sb.append(':');
            sb.append(e0.length() == 0 ? " no members found" : '\n' + e0);
            throw new KotlinReflectionInternalError(sb.toString());
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.y) s.s0(arrayList);
    }

    public final Method y(String str, String str2) {
        Method I;
        m.f(str, "name");
        m.f(str2, "desc");
        if (m.a(str, "<init>")) {
            return null;
        }
        Object[] array = G(str2).toArray(new Class[0]);
        m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Class<?>[] clsArr = (Class[]) array;
        Class<?> H = H(str2);
        Method I2 = I(E(), str, clsArr, H, false);
        if (I2 != null) {
            return I2;
        }
        if (!E().isInterface() || (I = I(Object.class, str, clsArr, H, false)) == null) {
            return null;
        }
        return I;
    }

    public final t0 z(String str, String str2) {
        SortedMap h2;
        String e0;
        m.f(str, "name");
        m.f(str2, RoomInstalled.SIGNATURE);
        MatchResult a2 = f23097h.a(str2);
        if (a2 != null) {
            String str3 = a2.a().getA().b().get(1);
            t0 C = C(Integer.parseInt(str3));
            if (C != null) {
                return C;
            }
            throw new KotlinReflectionInternalError("Local property #" + str3 + " not found in " + a());
        }
        kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(str);
        m.e(x, "identifier(name)");
        Collection<t0> F = F(x);
        ArrayList arrayList = new ArrayList();
        for (Object obj : F) {
            if (m.a(RuntimeTypeMapper.a.f((t0) obj).getF23039f(), str2)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            if (arrayList.size() != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj2 : arrayList) {
                    u visibility = ((t0) obj2).getVisibility();
                    Object obj3 = linkedHashMap.get(visibility);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap.put(visibility, obj3);
                    }
                    ((List) obj3).add(obj2);
                }
                h2 = p0.h(linkedHashMap, f.f23106f);
                Collection values = h2.values();
                m.e(values, "properties\n             …\n                }.values");
                List list = (List) s.f0(values);
                if (list.size() == 1) {
                    m.e(list, "mostVisibleProperties");
                    return (t0) s.U(list);
                }
                kotlin.reflect.y.internal.j0.f.f x2 = kotlin.reflect.y.internal.j0.f.f.x(str);
                m.e(x2, "identifier(name)");
                e0 = c0.e0(F(x2), "\n", null, null, 0, null, e.f23105f, 30, null);
                StringBuilder sb = new StringBuilder();
                sb.append("Property '");
                sb.append(str);
                sb.append("' (JVM signature: ");
                sb.append(str2);
                sb.append(") not resolved in ");
                sb.append(this);
                sb.append(':');
                sb.append(e0.length() == 0 ? " no members found" : '\n' + e0);
                throw new KotlinReflectionInternalError(sb.toString());
            }
            return (t0) s.s0(arrayList);
        }
        throw new KotlinReflectionInternalError("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
    }
}
