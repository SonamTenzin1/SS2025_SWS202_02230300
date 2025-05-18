package androidx.room;

import java.util.Iterator;

/* compiled from: EntityDeletionOrUpdateAdapter.java */
/* loaded from: classes.dex */
public abstract class b<T> extends q {
    public b(j jVar) {
        super(jVar);
    }

    protected abstract void bind(c.u.a.f fVar, T t);

    @Override // androidx.room.q
    protected abstract String createQuery();

    public final int handle(T t) {
        c.u.a.f acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.E();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        c.u.a.f acquire = acquire();
        int i2 = 0;
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                i2 += acquire.E();
            }
            return i2;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        c.u.a.f acquire = acquire();
        try {
            int i2 = 0;
            for (T t : tArr) {
                bind(acquire, t);
                i2 += acquire.E();
            }
            return i2;
        } finally {
            release(acquire);
        }
    }
}
