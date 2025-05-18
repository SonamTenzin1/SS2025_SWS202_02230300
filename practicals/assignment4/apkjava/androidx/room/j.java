package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import c.u.a.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: RoomDatabase.java */
/* loaded from: classes.dex */
public abstract class j {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;

    @Deprecated
    protected List<b> mCallbacks;

    @Deprecated
    protected volatile c.u.a.b mDatabase;
    private c.u.a.c mOpenHelper;
    private Executor mQueryExecutor;
    private Executor mTransactionExecutor;
    boolean mWriteAheadLoggingEnabled;
    private final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    private final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    private final Map<String, Object> mBackingFieldMap = new ConcurrentHashMap();
    private final g mInvalidationTracker = createInvalidationTracker();

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public static class a<T extends j> {
        private final Class<T> a;

        /* renamed from: b, reason: collision with root package name */
        private final String f2166b;

        /* renamed from: c, reason: collision with root package name */
        private final Context f2167c;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<b> f2168d;

        /* renamed from: e, reason: collision with root package name */
        private Executor f2169e;

        /* renamed from: f, reason: collision with root package name */
        private Executor f2170f;

        /* renamed from: g, reason: collision with root package name */
        private c.InterfaceC0094c f2171g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f2172h;

        /* renamed from: j, reason: collision with root package name */
        private boolean f2174j;
        private boolean l;
        private Set<Integer> n;
        private Set<Integer> o;
        private String p;
        private File q;

        /* renamed from: i, reason: collision with root package name */
        private c f2173i = c.AUTOMATIC;

        /* renamed from: k, reason: collision with root package name */
        private boolean f2175k = true;
        private final d m = new d();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Context context, Class<T> cls, String str) {
            this.f2167c = context;
            this.a = cls;
            this.f2166b = str;
        }

        public a<T> a(b bVar) {
            if (this.f2168d == null) {
                this.f2168d = new ArrayList<>();
            }
            this.f2168d.add(bVar);
            return this;
        }

        public a<T> b(androidx.room.s.a... aVarArr) {
            if (this.o == null) {
                this.o = new HashSet();
            }
            for (androidx.room.s.a aVar : aVarArr) {
                this.o.add(Integer.valueOf(aVar.startVersion));
                this.o.add(Integer.valueOf(aVar.endVersion));
            }
            this.m.b(aVarArr);
            return this;
        }

        public a<T> c() {
            this.f2172h = true;
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        public T d() {
            Executor executor;
            if (this.f2167c != null) {
                if (this.a != null) {
                    Executor executor2 = this.f2169e;
                    if (executor2 == null && this.f2170f == null) {
                        Executor d2 = c.b.a.a.a.d();
                        this.f2170f = d2;
                        this.f2169e = d2;
                    } else if (executor2 != null && this.f2170f == null) {
                        this.f2170f = executor2;
                    } else if (executor2 == null && (executor = this.f2170f) != null) {
                        this.f2169e = executor;
                    }
                    Set<Integer> set = this.o;
                    if (set != null && this.n != null) {
                        for (Integer num : set) {
                            if (this.n.contains(num)) {
                                throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                            }
                        }
                    }
                    if (this.f2171g == null) {
                        this.f2171g = new c.u.a.g.c();
                    }
                    String str = this.p;
                    if (str != null || this.q != null) {
                        if (this.f2166b != null) {
                            if (str != null && this.q != null) {
                                throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
                            }
                            this.f2171g = new p(str, this.q, this.f2171g);
                        } else {
                            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                        }
                    }
                    Context context = this.f2167c;
                    androidx.room.a aVar = new androidx.room.a(context, this.f2166b, this.f2171g, this.m, this.f2168d, this.f2172h, this.f2173i.k(context), this.f2169e, this.f2170f, this.f2174j, this.f2175k, this.l, this.n, this.p, this.q);
                    T t = (T) i.b(this.a, j.DB_IMPL_SUFFIX);
                    t.init(aVar);
                    return t;
                }
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }

        public a<T> e() {
            this.f2175k = false;
            this.l = true;
            return this;
        }

        public a<T> f(c.InterfaceC0094c interfaceC0094c) {
            this.f2171g = interfaceC0094c;
            return this;
        }

        public a<T> g(Executor executor) {
            this.f2169e = executor;
            return this;
        }
    }

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public void a(c.u.a.b bVar) {
        }

        public void b(c.u.a.b bVar) {
        }

        public void c(c.u.a.b bVar) {
        }
    }

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean g(ActivityManager activityManager) {
            if (Build.VERSION.SDK_INT >= 19) {
                return activityManager.isLowRamDevice();
            }
            return false;
        }

        @SuppressLint({"NewApi"})
        c k(Context context) {
            ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (Build.VERSION.SDK_INT >= 16 && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && !g(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public static class d {
        private HashMap<Integer, TreeMap<Integer, androidx.room.s.a>> a = new HashMap<>();

        private void a(androidx.room.s.a aVar) {
            int i2 = aVar.startVersion;
            int i3 = aVar.endVersion;
            TreeMap<Integer, androidx.room.s.a> treeMap = this.a.get(Integer.valueOf(i2));
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                this.a.put(Integer.valueOf(i2), treeMap);
            }
            androidx.room.s.a aVar2 = treeMap.get(Integer.valueOf(i3));
            if (aVar2 != null) {
                Log.w("ROOM", "Overriding migration " + aVar2 + " with " + aVar);
            }
            treeMap.put(Integer.valueOf(i3), aVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private List<androidx.room.s.a> d(List<androidx.room.s.a> list, boolean z, int i2, int i3) {
            TreeMap<Integer, androidx.room.s.a> treeMap;
            Set<Integer> keySet;
            boolean z2;
            do {
                if (z) {
                    if (i2 >= i3) {
                        return list;
                    }
                    treeMap = this.a.get(Integer.valueOf(i2));
                    if (treeMap == null) {
                        if (z) {
                            keySet = treeMap.descendingKeySet();
                        } else {
                            keySet = treeMap.keySet();
                        }
                        Iterator<Integer> it = keySet.iterator();
                        while (true) {
                            z2 = true;
                            boolean z3 = false;
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            int intValue = it.next().intValue();
                            if (!z ? !(intValue < i3 || intValue >= i2) : !(intValue > i3 || intValue <= i2)) {
                                z3 = true;
                            }
                            if (z3) {
                                list.add(treeMap.get(Integer.valueOf(intValue)));
                                i2 = intValue;
                                break;
                            }
                        }
                    } else {
                        return null;
                    }
                } else {
                    if (i2 <= i3) {
                        return list;
                    }
                    treeMap = this.a.get(Integer.valueOf(i2));
                    if (treeMap == null) {
                    }
                }
            } while (z2);
            return null;
        }

        public void b(androidx.room.s.a... aVarArr) {
            for (androidx.room.s.a aVar : aVarArr) {
                a(aVar);
            }
        }

        public List<androidx.room.s.a> c(int i2, int i3) {
            if (i2 == i3) {
                return Collections.emptyList();
            }
            return d(new ArrayList(), i3 > i2, i2, i3);
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries && isMainThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        c.u.a.b s0 = this.mOpenHelper.s0();
        this.mInvalidationTracker.n(s0);
        s0.n();
    }

    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            try {
                writeLock.lock();
                this.mInvalidationTracker.k();
                this.mOpenHelper.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public c.u.a.f compileStatement(String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.s0().F(str);
    }

    protected abstract g createInvalidationTracker();

    protected abstract c.u.a.c createOpenHelper(androidx.room.a aVar);

    @Deprecated
    public void endTransaction() {
        this.mOpenHelper.s0().z0();
        if (inTransaction()) {
            return;
        }
        this.mInvalidationTracker.f();
    }

    Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    public g getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public c.u.a.c getOpenHelper() {
        return this.mOpenHelper;
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    public boolean inTransaction() {
        return this.mOpenHelper.s0().P0();
    }

    public void init(androidx.room.a aVar) {
        c.u.a.c createOpenHelper = createOpenHelper(aVar);
        this.mOpenHelper = createOpenHelper;
        if (createOpenHelper instanceof o) {
            ((o) createOpenHelper).b(aVar);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            r2 = aVar.f2122g == c.WRITE_AHEAD_LOGGING;
            this.mOpenHelper.setWriteAheadLoggingEnabled(r2);
        }
        this.mCallbacks = aVar.f2120e;
        this.mQueryExecutor = aVar.f2123h;
        this.mTransactionExecutor = new r(aVar.f2124i);
        this.mAllowMainThreadQueries = aVar.f2121f;
        this.mWriteAheadLoggingEnabled = r2;
        if (aVar.f2125j) {
            this.mInvalidationTracker.i(aVar.f2117b, aVar.f2118c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void internalInitInvalidationTracker(c.u.a.b bVar) {
        this.mInvalidationTracker.d(bVar);
    }

    public boolean isOpen() {
        c.u.a.b bVar = this.mDatabase;
        return bVar != null && bVar.isOpen();
    }

    public Cursor query(String str, Object[] objArr) {
        return this.mOpenHelper.s0().H0(new c.u.a.a(str, objArr));
    }

    public void runInTransaction(Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.s0().j0();
    }

    public Cursor query(c.u.a.e eVar) {
        return query(eVar, (CancellationSignal) null);
    }

    public Cursor query(c.u.a.e eVar, CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null && Build.VERSION.SDK_INT >= 16) {
            return this.mOpenHelper.s0().S(eVar, cancellationSignal);
        }
        return this.mOpenHelper.s0().H0(eVar);
    }

    public <V> V runInTransaction(Callable<V> callable) {
        beginTransaction();
        try {
            try {
                V call = callable.call();
                setTransactionSuccessful();
                endTransaction();
                return call;
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                androidx.room.t.e.a(e3);
                endTransaction();
                return null;
            }
        } catch (Throwable th) {
            endTransaction();
            throw th;
        }
    }
}
