package kotlin.reflect.y.internal.j0.i.s;

import kotlin.jvm.internal.m;

/* compiled from: DeprecationInfo.kt */
/* loaded from: classes3.dex */
public abstract class a implements Comparable<a> {
    @Override // java.lang.Comparable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        m.f(aVar, "other");
        int compareTo = k().compareTo(aVar.k());
        if (compareTo == 0 && !q() && aVar.q()) {
            return 1;
        }
        return compareTo;
    }

    public abstract b k();

    public abstract boolean q();
}
