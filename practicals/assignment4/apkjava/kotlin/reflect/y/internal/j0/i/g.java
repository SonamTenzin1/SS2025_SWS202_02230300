package kotlin.reflect.y.internal.j0.i;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* compiled from: MemberComparator.java */
/* loaded from: classes3.dex */
public class g implements Comparator<m> {

    /* renamed from: f, reason: collision with root package name */
    public static final g f24326f = new g();

    private g() {
    }

    private static Integer b(m mVar, m mVar2) {
        int c2 = c(mVar2) - c(mVar);
        if (c2 != 0) {
            return Integer.valueOf(c2);
        }
        if (d.B(mVar) && d.B(mVar2)) {
            return 0;
        }
        int compareTo = mVar.getName().compareTo(mVar2.getName());
        if (compareTo != 0) {
            return Integer.valueOf(compareTo);
        }
        return null;
    }

    private static int c(m mVar) {
        if (d.B(mVar)) {
            return 8;
        }
        if (mVar instanceof l) {
            return 7;
        }
        if (mVar instanceof t0) {
            return ((t0) mVar).m0() == null ? 6 : 5;
        }
        if (mVar instanceof y) {
            return ((y) mVar).m0() == null ? 4 : 3;
        }
        if (mVar instanceof e) {
            return 2;
        }
        return mVar instanceof d1 ? 1 : 0;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(m mVar, m mVar2) {
        Integer b2 = b(mVar, mVar2);
        if (b2 != null) {
            return b2.intValue();
        }
        return 0;
    }
}
