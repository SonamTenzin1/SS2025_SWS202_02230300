package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes.dex */
public final class zzdc {
    public static <T> zzcz<T> a(zzcz<T> zzczVar) {
        if ((zzczVar instanceof c1) || (zzczVar instanceof a1)) {
            return zzczVar;
        }
        if (zzczVar instanceof Serializable) {
            return new a1(zzczVar);
        }
        return new c1(zzczVar);
    }

    public static <T> zzcz<T> b(@NullableDecl T t) {
        return new b1(t);
    }
}
