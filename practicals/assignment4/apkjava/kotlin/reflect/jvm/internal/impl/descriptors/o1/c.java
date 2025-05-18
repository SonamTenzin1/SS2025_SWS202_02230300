package kotlin.reflect.jvm.internal.impl.descriptors.o1;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;

/* compiled from: PlatformDependentDeclarationFilter.kt */
/* loaded from: classes2.dex */
public interface c {

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    /* loaded from: classes2.dex */
    public static final class a implements c {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.c
        public boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, y0 y0Var) {
            m.f(eVar, "classDescriptor");
            m.f(y0Var, "functionDescriptor");
            return true;
        }
    }

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    /* loaded from: classes2.dex */
    public static final class b implements c {
        public static final b a = new b();

        private b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.c
        public boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, y0 y0Var) {
            m.f(eVar, "classDescriptor");
            m.f(y0Var, "functionDescriptor");
            return !y0Var.getAnnotations().R0(d.a());
        }
    }

    boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, y0 y0Var);
}
