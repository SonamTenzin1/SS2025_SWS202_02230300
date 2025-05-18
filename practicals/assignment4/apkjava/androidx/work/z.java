package androidx.work;

import android.os.Build;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* compiled from: WorkRequest.java */
/* loaded from: classes.dex */
public abstract class z {
    private UUID a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.work.impl.n.p f2678b;

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f2679c;

    /* compiled from: WorkRequest.java */
    /* loaded from: classes.dex */
    public static abstract class a<B extends a<?, ?>, W extends z> {

        /* renamed from: c, reason: collision with root package name */
        androidx.work.impl.n.p f2681c;

        /* renamed from: e, reason: collision with root package name */
        Class<? extends ListenableWorker> f2683e;
        boolean a = false;

        /* renamed from: d, reason: collision with root package name */
        Set<String> f2682d = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        UUID f2680b = UUID.randomUUID();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Class<? extends ListenableWorker> cls) {
            this.f2683e = cls;
            this.f2681c = new androidx.work.impl.n.p(this.f2680b.toString(), cls.getName());
            a(cls.getName());
        }

        public final B a(String str) {
            this.f2682d.add(str);
            return d();
        }

        public final W b() {
            W c2 = c();
            c cVar = this.f2681c.l;
            int i2 = Build.VERSION.SDK_INT;
            boolean z = (i2 >= 24 && cVar.e()) || cVar.f() || cVar.g() || (i2 >= 23 && cVar.h());
            androidx.work.impl.n.p pVar = this.f2681c;
            if (pVar.s) {
                if (z) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (pVar.f2531i > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.f2680b = UUID.randomUUID();
            androidx.work.impl.n.p pVar2 = new androidx.work.impl.n.p(this.f2681c);
            this.f2681c = pVar2;
            pVar2.f2525c = this.f2680b.toString();
            return c2;
        }

        abstract W c();

        abstract B d();

        public final B e(c cVar) {
            this.f2681c.l = cVar;
            return d();
        }

        public B f(long j2, TimeUnit timeUnit) {
            this.f2681c.f2531i = timeUnit.toMillis(j2);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.f2681c.f2531i) {
                return d();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        public final B g(e eVar) {
            this.f2681c.f2529g = eVar;
            return d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public z(UUID uuid, androidx.work.impl.n.p pVar, Set<String> set) {
        this.a = uuid;
        this.f2678b = pVar;
        this.f2679c = set;
    }

    public String a() {
        return this.a.toString();
    }

    public Set<String> b() {
        return this.f2679c;
    }

    public androidx.work.impl.n.p c() {
        return this.f2678b;
    }
}
