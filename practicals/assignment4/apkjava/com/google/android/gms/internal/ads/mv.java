package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class mv extends kv {

    /* renamed from: c, reason: collision with root package name */
    private static final Class<?> f12996c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private mv() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> f(Object obj, long j2, int i2) {
        zzdos zzdosVar;
        List<L> arrayList;
        List<L> g2 = g(obj, j2);
        if (g2.isEmpty()) {
            if (g2 instanceof zzdot) {
                arrayList = new zzdos(i2);
            } else if ((g2 instanceof fw) && (g2 instanceof zzdoj)) {
                arrayList = ((zzdoj) g2).N(i2);
            } else {
                arrayList = new ArrayList<>(i2);
            }
            gx.g(obj, j2, arrayList);
            return arrayList;
        }
        if (f12996c.isAssignableFrom(g2.getClass())) {
            ArrayList arrayList2 = new ArrayList(g2.size() + i2);
            arrayList2.addAll(g2);
            gx.g(obj, j2, arrayList2);
            zzdosVar = arrayList2;
        } else if (g2 instanceof zzdqw) {
            zzdos zzdosVar2 = new zzdos(g2.size() + i2);
            zzdosVar2.addAll((zzdqw) g2);
            gx.g(obj, j2, zzdosVar2);
            zzdosVar = zzdosVar2;
        } else {
            if (!(g2 instanceof fw) || !(g2 instanceof zzdoj)) {
                return g2;
            }
            zzdoj zzdojVar = (zzdoj) g2;
            if (zzdojVar.m0()) {
                return g2;
            }
            zzdoj N = zzdojVar.N(g2.size() + i2);
            gx.g(obj, j2, N);
            return N;
        }
        return zzdosVar;
    }

    private static <E> List<E> g(Object obj, long j2) {
        return (List) gx.L(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.kv
    public final <L> List<L> a(Object obj, long j2) {
        return f(obj, j2, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.kv
    public final <E> void b(Object obj, Object obj2, long j2) {
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
        gx.g(obj, j2, g2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.kv
    public final void e(Object obj, long j2) {
        Object unmodifiableList;
        List list = (List) gx.L(obj, j2);
        if (list instanceof zzdot) {
            unmodifiableList = ((zzdot) list).H();
        } else {
            if (f12996c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof fw) && (list instanceof zzdoj)) {
                zzdoj zzdojVar = (zzdoj) list;
                if (zzdojVar.m0()) {
                    zzdojVar.x0();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        gx.g(obj, j2, unmodifiableList);
    }
}
