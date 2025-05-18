package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* loaded from: classes2.dex */
public class zzdno {

    /* renamed from: b, reason: collision with root package name */
    private static volatile zzdno f16008b;

    /* renamed from: d, reason: collision with root package name */
    private final Map<a, zzdob.zzd<?, ?>> f16010d;
    private static final Class<?> a = c();

    /* renamed from: c, reason: collision with root package name */
    static final zzdno f16009c = new zzdno(true);

    /* loaded from: classes2.dex */
    static final class a {
        private final Object a;

        /* renamed from: b, reason: collision with root package name */
        private final int f16011b;

        a(Object obj, int i2) {
            this.a = obj;
            this.f16011b = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f16011b == aVar.f16011b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f16011b;
        }
    }

    zzdno() {
        this.f16010d = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdno b() {
        return dv.b(zzdno.class);
    }

    private static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzdno d() {
        return uu.b();
    }

    public static zzdno e() {
        zzdno zzdnoVar = f16008b;
        if (zzdnoVar == null) {
            synchronized (zzdno.class) {
                zzdnoVar = f16008b;
                if (zzdnoVar == null) {
                    zzdnoVar = uu.c();
                    f16008b = zzdnoVar;
                }
            }
        }
        return zzdnoVar;
    }

    public final <ContainingType extends zzdpk> zzdob.zzd<ContainingType, ?> a(ContainingType containingtype, int i2) {
        return (zzdob.zzd) this.f16010d.get(new a(containingtype, i2));
    }

    private zzdno(boolean z) {
        this.f16010d = Collections.emptyMap();
    }
}
