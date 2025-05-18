package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class t2 extends s2 {
    private t2() {
        super();
    }

    private static <E> zzfl<E> f(Object obj, long j2) {
        return (zzfl) k4.F(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.s2
    public final <L> List<L> b(Object obj, long j2) {
        zzfl f2 = f(obj, j2);
        if (f2.a()) {
            return f2;
        }
        int size = f2.size();
        zzfl d2 = f2.d(size == 0 ? 10 : size << 1);
        k4.j(obj, j2, d2);
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.s2
    public final <E> void c(Object obj, Object obj2, long j2) {
        zzfl f2 = f(obj, j2);
        zzfl f3 = f(obj2, j2);
        int size = f2.size();
        int size2 = f3.size();
        if (size > 0 && size2 > 0) {
            if (!f2.a()) {
                f2 = f2.d(size2 + size);
            }
            f2.addAll(f3);
        }
        if (size > 0) {
            f3 = f2;
        }
        k4.j(obj, j2, f3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.s2
    public final void e(Object obj, long j2) {
        f(obj, j2).I();
    }
}
