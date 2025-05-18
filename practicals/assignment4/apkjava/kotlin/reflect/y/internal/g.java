package kotlin.reflect.y.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.k0.b;
import okhttp3.HttpUrl;

/* compiled from: kClassCache.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\"*\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin.jvm.PlatformType", HttpUrl.FRAGMENT_ENCODE_SET, "clearKClassCache", HttpUrl.FRAGMENT_ENCODE_SET, "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class g {
    private static b<String, Object> a;

    static {
        b<String, Object> b2 = b.b();
        m.e(b2, "empty<String, Any>()");
        a = b2;
    }

    public static final <T> KClassImpl<T> a(Class<T> cls) {
        m.f(cls, "jClass");
        String name = cls.getName();
        Object c2 = a.c(name);
        if (c2 instanceof WeakReference) {
            KClassImpl<T> kClassImpl = (KClassImpl) ((WeakReference) c2).get();
            if (m.a(kClassImpl != null ? kClassImpl.a() : null, cls)) {
                return kClassImpl;
            }
        } else if (c2 != null) {
            for (WeakReference weakReference : (WeakReference[]) c2) {
                KClassImpl<T> kClassImpl2 = (KClassImpl) weakReference.get();
                if (m.a(kClassImpl2 != null ? kClassImpl2.a() : null, cls)) {
                    return kClassImpl2;
                }
            }
            int length = ((Object[]) c2).length;
            WeakReference[] weakReferenceArr = new WeakReference[length + 1];
            System.arraycopy(c2, 0, weakReferenceArr, 0, length);
            KClassImpl<T> kClassImpl3 = new KClassImpl<>(cls);
            weakReferenceArr[length] = new WeakReference(kClassImpl3);
            b<String, Object> f2 = a.f(name, weakReferenceArr);
            m.e(f2, "K_CLASS_CACHE.plus(name, newArray)");
            a = f2;
            return kClassImpl3;
        }
        KClassImpl<T> kClassImpl4 = new KClassImpl<>(cls);
        b<String, Object> f3 = a.f(name, new WeakReference(kClassImpl4));
        m.e(f3, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        a = f3;
        return kClassImpl4;
    }
}
