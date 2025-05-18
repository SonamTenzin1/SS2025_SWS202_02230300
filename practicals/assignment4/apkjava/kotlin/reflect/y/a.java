package kotlin.reflect.y;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.KCallableImpl;
import kotlin.reflect.y.internal.calls.Caller;
import kotlin.reflect.y.internal.g0;
import okhttp3.HttpUrl;

/* compiled from: KCallablesJvm.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"value", HttpUrl.FRAGMENT_ENCODE_SET, "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class a {
    public static final void a(KCallable<?> kCallable, boolean z) {
        Caller<?> B;
        m.f(kCallable, "<this>");
        if (kCallable instanceof KMutableProperty) {
            KProperty kProperty = (KProperty) kCallable;
            Field b2 = c.b(kProperty);
            if (b2 != null) {
                b2.setAccessible(z);
            }
            Method c2 = c.c(kProperty);
            if (c2 != null) {
                c2.setAccessible(z);
            }
            Method e2 = c.e((KMutableProperty) kCallable);
            if (e2 == null) {
                return;
            }
            e2.setAccessible(z);
            return;
        }
        if (kCallable instanceof KProperty) {
            KProperty kProperty2 = (KProperty) kCallable;
            Field b3 = c.b(kProperty2);
            if (b3 != null) {
                b3.setAccessible(z);
            }
            Method c3 = c.c(kProperty2);
            if (c3 == null) {
                return;
            }
            c3.setAccessible(z);
            return;
        }
        if (kCallable instanceof KProperty.b) {
            Field b4 = c.b(((KProperty.b) kCallable).n());
            if (b4 != null) {
                b4.setAccessible(z);
            }
            Method d2 = c.d((KFunction) kCallable);
            if (d2 == null) {
                return;
            }
            d2.setAccessible(z);
            return;
        }
        if (kCallable instanceof KMutableProperty.a) {
            Field b5 = c.b(((KMutableProperty.a) kCallable).n());
            if (b5 != null) {
                b5.setAccessible(z);
            }
            Method d3 = c.d((KFunction) kCallable);
            if (d3 == null) {
                return;
            }
            d3.setAccessible(z);
            return;
        }
        if (kCallable instanceof KFunction) {
            KFunction kFunction = (KFunction) kCallable;
            Method d4 = c.d(kFunction);
            if (d4 != null) {
                d4.setAccessible(z);
            }
            KCallableImpl<?> b6 = g0.b(kCallable);
            Object member = (b6 == null || (B = b6.B()) == null) ? null : B.getMember();
            AccessibleObject accessibleObject = member instanceof AccessibleObject ? (AccessibleObject) member : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(true);
            }
            Constructor a = c.a(kFunction);
            if (a == null) {
                return;
            }
            a.setAccessible(z);
            return;
        }
        throw new UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + ')');
    }
}
