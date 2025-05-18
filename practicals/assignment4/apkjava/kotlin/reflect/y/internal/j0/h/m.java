package kotlin.reflect.y.internal.j0.h;

import kotlin.jvm.internal.g;
import kotlin.text.u;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
public enum m {
    PLAIN { // from class: kotlin.f0.y.e.j0.h.m.b
        @Override // kotlin.reflect.y.internal.j0.h.m
        public String k(String str) {
            kotlin.jvm.internal.m.f(str, "string");
            return str;
        }
    },
    HTML { // from class: kotlin.f0.y.e.j0.h.m.a
        @Override // kotlin.reflect.y.internal.j0.h.m
        public String k(String str) {
            String A;
            String A2;
            kotlin.jvm.internal.m.f(str, "string");
            A = u.A(str, "<", "&lt;", false, 4, null);
            A2 = u.A(A, ">", "&gt;", false, 4, null);
            return A2;
        }
    };

    /* synthetic */ m(g gVar) {
        this();
    }

    public abstract String k(String str);
}
