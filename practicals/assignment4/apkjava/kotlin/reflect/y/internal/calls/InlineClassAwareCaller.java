package kotlin.reflect.y.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.KotlinReflectionInternalError;
import kotlin.reflect.y.internal.calls.CallerImpl;
import kotlin.reflect.y.internal.g0;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.l.e0;
import okhttp3.HttpUrl;

/* compiled from: InlineClassAwareCaller.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", HttpUrl.FRAGMENT_ENCODE_SET, "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: kotlin.f0.y.e.i0.g, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f23139b;

    /* renamed from: c, reason: collision with root package name */
    private final a f23140c;

    /* compiled from: InlineClassAwareCaller.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0086\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", HttpUrl.FRAGMENT_ENCODE_SET, "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.i0.g$a */
    /* loaded from: classes2.dex */
    private static final class a {
        private final IntRange a;

        /* renamed from: b, reason: collision with root package name */
        private final Method[] f23141b;

        /* renamed from: c, reason: collision with root package name */
        private final Method f23142c;

        public a(IntRange intRange, Method[] methodArr, Method method) {
            m.f(intRange, "argumentRange");
            m.f(methodArr, "unbox");
            this.a = intRange;
            this.f23141b = methodArr;
            this.f23142c = method;
        }

        /* renamed from: a, reason: from getter */
        public final IntRange getA() {
            return this.a;
        }

        /* renamed from: b, reason: from getter */
        public final Method[] getF23141b() {
            return this.f23141b;
        }

        /* renamed from: c, reason: from getter */
        public final Method getF23142c() {
            return this.f23142c;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        if ((r12 instanceof kotlin.reflect.y.internal.calls.BoundCaller) != false) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InlineClassAwareCaller(b bVar, Caller<? extends M> caller, boolean z) {
        IntRange k2;
        a aVar;
        Class<?> i2;
        m.f(bVar, "descriptor");
        m.f(caller, "caller");
        this.a = caller;
        this.f23139b = z;
        e0 returnType = bVar.getReturnType();
        m.c(returnType);
        Class<?> i3 = h.i(returnType);
        Method d2 = i3 != null ? h.d(i3, bVar) : null;
        if (f.a(bVar)) {
            aVar = new a(IntRange.f22979j.a(), new Method[0], d2);
        } else {
            int i4 = -1;
            if (!(caller instanceof CallerImpl.h.c)) {
                if (!(bVar instanceof l)) {
                    if (bVar.f0() != null && !(caller instanceof BoundCaller)) {
                        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = bVar.b();
                        m.e(b2, "descriptor.containingDeclaration");
                        if (!f.b(b2)) {
                            i4 = 1;
                        }
                    }
                    i4 = 0;
                }
            }
            int i5 = (z ? 2 : 0) + (((bVar instanceof y) && ((y) bVar).isSuspend()) ? 1 : 0);
            ArrayList arrayList = new ArrayList();
            w0 m0 = bVar.m0();
            e0 type = m0 != null ? m0.getType() : null;
            if (type != null) {
                arrayList.add(type);
            } else if (bVar instanceof l) {
                e C = ((l) bVar).C();
                m.e(C, "descriptor.constructedClass");
                if (C.m()) {
                    kotlin.reflect.jvm.internal.impl.descriptors.m b3 = C.b();
                    m.d(b3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    arrayList.add(((e) b3).s());
                }
            } else {
                kotlin.reflect.jvm.internal.impl.descriptors.m b4 = bVar.b();
                m.e(b4, "descriptor.containingDeclaration");
                if ((b4 instanceof e) && f.b(b4)) {
                    arrayList.add(((e) b4).s());
                }
            }
            List<i1> f2 = bVar.f();
            m.e(f2, "descriptor.valueParameters");
            Iterator<T> it = f2.iterator();
            while (it.hasNext()) {
                arrayList.add(((i1) it.next()).getType());
            }
            int size = arrayList.size() + i4 + i5;
            if (f.a(this) == size) {
                k2 = kotlin.ranges.l.k(Math.max(i4, 0), arrayList.size() + i4);
                Method[] methodArr = new Method[size];
                int i6 = 0;
                while (i6 < size) {
                    methodArr[i6] = (!(i6 <= k2.getF22973h() && k2.getF22972g() <= i6) || (i2 = h.i((e0) arrayList.get(i6 - i4))) == null) ? null : h.f(i2, bVar);
                    i6++;
                }
                aVar = new a(k2, methodArr, d2);
            } else {
                throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + f.a(this) + " != " + size + "\nCalling: " + bVar + "\nParameter types: " + a() + ")\nDefault: " + this.f23139b);
            }
        }
        this.f23140c = aVar;
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public List<Type> a() {
        return this.a.a();
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public Object call(Object[] args) {
        Object invoke;
        m.f(args, "args");
        a aVar = this.f23140c;
        IntRange a2 = aVar.getA();
        Method[] f23141b = aVar.getF23141b();
        Method f23142c = aVar.getF23142c();
        Object[] copyOf = Arrays.copyOf(args, args.length);
        m.e(copyOf, "copyOf(this, size)");
        m.d(copyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int f22972g = a2.getF22972g();
        int f22973h = a2.getF22973h();
        if (f22972g <= f22973h) {
            while (true) {
                Method method = f23141b[f22972g];
                Object obj = args[f22972g];
                if (method != null) {
                    if (obj != null) {
                        obj = method.invoke(obj, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        m.e(returnType, "method.returnType");
                        obj = g0.g(returnType);
                    }
                }
                copyOf[f22972g] = obj;
                if (f22972g == f22973h) {
                    break;
                }
                f22972g++;
            }
        }
        Object call = this.a.call(copyOf);
        return (f23142c == null || (invoke = f23142c.invoke(null, call)) == null) ? call : invoke;
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public M getMember() {
        return this.a.getMember();
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    /* renamed from: getReturnType */
    public Type getF23144c() {
        return this.a.getF23144c();
    }
}
