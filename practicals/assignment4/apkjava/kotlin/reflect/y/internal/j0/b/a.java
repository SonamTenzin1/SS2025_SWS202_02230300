package kotlin.reflect.y.internal.j0.b;

import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.s;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.o1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.o1.c;
import kotlin.reflect.y.internal.j0.k.n;

/* compiled from: BuiltInsLoader.kt */
/* loaded from: classes2.dex */
public interface a {
    public static final C0320a a = C0320a.a;

    /* compiled from: BuiltInsLoader.kt */
    /* renamed from: kotlin.f0.y.e.j0.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0320a {
        static final /* synthetic */ C0320a a = new C0320a();

        /* renamed from: b, reason: collision with root package name */
        private static final Lazy<a> f23154b;

        /* compiled from: BuiltInsLoader.kt */
        /* renamed from: kotlin.f0.y.e.j0.b.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static final class C0321a extends Lambda implements Function0<a> {

            /* renamed from: f, reason: collision with root package name */
            public static final C0321a f23155f = new C0321a();

            C0321a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final a invoke() {
                ServiceLoader load = ServiceLoader.load(a.class, a.class.getClassLoader());
                m.e(load, "implementations");
                a aVar = (a) s.V(load);
                if (aVar != null) {
                    return aVar;
                }
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
        }

        static {
            Lazy<a> a2;
            a2 = i.a(LazyThreadSafetyMode.PUBLICATION, C0321a.f23155f);
            f23154b = a2;
        }

        private C0320a() {
        }

        public final a a() {
            return f23154b.getValue();
        }
    }

    l0 a(n nVar, g0 g0Var, Iterable<? extends b> iterable, c cVar, kotlin.reflect.jvm.internal.impl.descriptors.o1.a aVar, boolean z);
}
