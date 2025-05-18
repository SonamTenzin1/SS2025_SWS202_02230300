package kotlin.reflect.y.internal.j0.d.a;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.m.u.a;
import kotlin.text.u;

/* compiled from: JvmAbi.kt */
/* loaded from: classes2.dex */
public final class z {
    public static final z a = new z();

    /* renamed from: b, reason: collision with root package name */
    public static final c f23705b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f23706c;

    /* renamed from: d, reason: collision with root package name */
    private static final b f23707d;

    /* renamed from: e, reason: collision with root package name */
    private static final b f23708e;

    static {
        c cVar = new c("kotlin.jvm.JvmField");
        f23705b = cVar;
        b m = b.m(cVar);
        m.e(m, "topLevel(JVM_FIELD_ANNOTATION_FQ_NAME)");
        f23706c = m;
        b m2 = b.m(new c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        m.e(m2, "topLevel(FqName(\"kotlin.….ReflectionFactoryImpl\"))");
        f23707d = m2;
        b e2 = b.e("kotlin/jvm/internal/RepeatableContainer");
        m.e(e2, "fromString(\"kotlin/jvm/i…nal/RepeatableContainer\")");
        f23708e = e2;
    }

    private z() {
    }

    public static final String b(String str) {
        m.f(str, "propertyName");
        if (f(str)) {
            return str;
        }
        return "get" + a.a(str);
    }

    public static final boolean c(String str) {
        boolean E;
        boolean E2;
        m.f(str, "name");
        E = u.E(str, "get", false, 2, null);
        if (!E) {
            E2 = u.E(str, "is", false, 2, null);
            if (!E2) {
                return false;
            }
        }
        return true;
    }

    public static final boolean d(String str) {
        boolean E;
        m.f(str, "name");
        E = u.E(str, "set", false, 2, null);
        return E;
    }

    public static final String e(String str) {
        String a2;
        m.f(str, "propertyName");
        StringBuilder sb = new StringBuilder();
        sb.append("set");
        if (f(str)) {
            a2 = str.substring(2);
            m.e(a2, "this as java.lang.String).substring(startIndex)");
        } else {
            a2 = a.a(str);
        }
        sb.append(a2);
        return sb.toString();
    }

    public static final boolean f(String str) {
        boolean E;
        m.f(str, "name");
        E = u.E(str, "is", false, 2, null);
        if (!E || str.length() == 2) {
            return false;
        }
        char charAt = str.charAt(2);
        return m.h(97, charAt) > 0 || m.h(charAt, 122) > 0;
    }

    public final b a() {
        return f23708e;
    }
}
