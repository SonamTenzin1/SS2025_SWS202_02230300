package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class u2 extends s2 {

    /* renamed from: c, reason: collision with root package name */
    private static final Class<?> f17262c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private u2() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> f(Object obj, long j2, int i2) {
        zzfw zzfwVar;
        List<L> arrayList;
        List<L> g2 = g(obj, j2);
        if (g2.isEmpty()) {
            if (g2 instanceof zzfv) {
                arrayList = new zzfw(i2);
            } else if ((g2 instanceof m3) && (g2 instanceof zzfl)) {
                arrayList = ((zzfl) g2).d(i2);
            } else {
                arrayList = new ArrayList<>(i2);
            }
            k4.j(obj, j2, arrayList);
            return arrayList;
        }
        if (f17262c.isAssignableFrom(g2.getClass())) {
            ArrayList arrayList2 = new ArrayList(g2.size() + i2);
            arrayList2.addAll(g2);
            k4.j(obj, j2, arrayList2);
            zzfwVar = arrayList2;
        } else if (g2 instanceof zzia) {
            zzfw zzfwVar2 = new zzfw(g2.size() + i2);
            zzfwVar2.addAll((zzia) g2);
            k4.j(obj, j2, zzfwVar2);
            zzfwVar = zzfwVar2;
        } else {
            if (!(g2 instanceof m3) || !(g2 instanceof zzfl)) {
                return g2;
            }
            zzfl zzflVar = (zzfl) g2;
            if (zzflVar.a()) {
                return g2;
            }
            zzfl d2 = zzflVar.d(g2.size() + i2);
            k4.j(obj, j2, d2);
            return d2;
        }
        return zzfwVar;
    }

    private static <E> List<E> g(Object obj, long j2) {
        return (List) k4.F(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.s2
    public final <L> List<L> b(Object obj, long j2) {
        return f(obj, j2, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.s2
    public final <E> void c(Object obj, Object obj2, long j2) {
        List g2 = g(obj2, j2);
        List f2 = f(obj, j2, g2.size());
        int size = f2.size();
        int size2 = g2.size();
        if (size > 0 && size2 > 0) {
            f2.addAll(g2);
        }
        if (size > 0) {
            g2 = f2;
        }
        k4.j(obj, j2, g2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.s2
    public final void e(Object obj, long j2) {
        Object unmodifiableList;
        List list = (List) k4.F(obj, j2);
        if (list instanceof zzfv) {
            unmodifiableList = ((zzfv) list).y0();
        } else {
            if (f17262c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof m3) && (list instanceof zzfl)) {
                zzfl zzflVar = (zzfl) list;
                if (zzflVar.a()) {
                    zzflVar.I();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        k4.j(obj, j2, unmodifiableList);
    }
}
