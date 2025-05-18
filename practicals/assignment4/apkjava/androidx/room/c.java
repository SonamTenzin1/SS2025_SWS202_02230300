package androidx.room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: EntityInsertionAdapter.java */
/* loaded from: classes.dex */
public abstract class c<T> extends q {
    public c(j jVar) {
        super(jVar);
    }

    protected abstract void bind(c.u.a.f fVar, T t);

    public final void insert(T t) {
        c.u.a.f acquire = acquire();
        try {
            bind(acquire, t);
            acquire.j1();
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t) {
        c.u.a.f acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.j1();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        c.u.a.f acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i2 = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                jArr[i2] = acquire.j1();
                i2++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        c.u.a.f acquire = acquire();
        try {
            Long[] lArr = new Long[collection.size()];
            int i2 = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                lArr[i2] = Long.valueOf(acquire.j1());
                i2++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        c.u.a.f acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(tArr.length);
            int i2 = 0;
            for (T t : tArr) {
                bind(acquire, t);
                arrayList.add(i2, Long.valueOf(acquire.j1()));
                i2++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] tArr) {
        c.u.a.f acquire = acquire();
        try {
            for (T t : tArr) {
                bind(acquire, t);
                acquire.j1();
            }
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        c.u.a.f acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int i2 = 0;
            for (T t : tArr) {
                bind(acquire, t);
                jArr[i2] = acquire.j1();
                i2++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        c.u.a.f acquire = acquire();
        try {
            Long[] lArr = new Long[tArr.length];
            int i2 = 0;
            for (T t : tArr) {
                bind(acquire, t);
                lArr[i2] = Long.valueOf(acquire.j1());
                i2++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        c.u.a.f acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            int i2 = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                arrayList.add(i2, Long.valueOf(acquire.j1()));
                i2++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(Iterable<? extends T> iterable) {
        c.u.a.f acquire = acquire();
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                acquire.j1();
            }
        } finally {
            release(acquire);
        }
    }
}
