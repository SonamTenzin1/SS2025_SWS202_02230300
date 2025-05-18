package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* compiled from: ExtensionRegistryLite.java */
/* loaded from: classes.dex */
public class p {
    private static boolean a = true;

    /* renamed from: c, reason: collision with root package name */
    private static volatile p f1380c;

    /* renamed from: e, reason: collision with root package name */
    private final Map<a, y.e<?, ?>> f1382e;

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?> f1379b = c();

    /* renamed from: d, reason: collision with root package name */
    static final p f1381d = new p(true);

    /* compiled from: ExtensionRegistryLite.java */
    /* loaded from: classes.dex */
    private static final class a {
        private final Object a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1383b;

        a(Object obj, int i2) {
            this.a = obj;
            this.f1383b = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f1383b == aVar.f1383b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f1383b;
        }
    }

    p() {
        this.f1382e = new HashMap();
    }

    public static p b() {
        p pVar = f1380c;
        if (pVar == null) {
            synchronized (p.class) {
                pVar = f1380c;
                if (pVar == null) {
                    pVar = a ? o.a() : f1381d;
                    f1380c = pVar;
                }
            }
        }
        return pVar;
    }

    static Class<?> c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public <ContainingType extends q0> y.e<ContainingType, ?> a(ContainingType containingtype, int i2) {
        return (y.e) this.f1382e.get(new a(containingtype, i2));
    }

    p(boolean z) {
        this.f1382e = Collections.emptyMap();
    }
}
