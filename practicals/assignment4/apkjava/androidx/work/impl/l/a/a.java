package androidx.work.impl.l.a;

import androidx.work.impl.n.p;
import androidx.work.n;
import androidx.work.v;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DelayedWorkTracker.java */
/* loaded from: classes.dex */
public class a {
    static final String a = n.f("DelayedWorkTracker");

    /* renamed from: b, reason: collision with root package name */
    final b f2469b;

    /* renamed from: c, reason: collision with root package name */
    private final v f2470c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, Runnable> f2471d = new HashMap();

    /* compiled from: DelayedWorkTracker.java */
    /* renamed from: androidx.work.impl.l.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0052a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ p f2472f;

        RunnableC0052a(p pVar) {
            this.f2472f = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.c().a(a.a, String.format("Scheduling work %s", this.f2472f.f2525c), new Throwable[0]);
            a.this.f2469b.a(this.f2472f);
        }
    }

    public a(b bVar, v vVar) {
        this.f2469b = bVar;
        this.f2470c = vVar;
    }

    public void a(p pVar) {
        Runnable remove = this.f2471d.remove(pVar.f2525c);
        if (remove != null) {
            this.f2470c.b(remove);
        }
        RunnableC0052a runnableC0052a = new RunnableC0052a(pVar);
        this.f2471d.put(pVar.f2525c, runnableC0052a);
        this.f2470c.a(pVar.a() - System.currentTimeMillis(), runnableC0052a);
    }

    public void b(String str) {
        Runnable remove = this.f2471d.remove(str);
        if (remove != null) {
            this.f2470c.b(remove);
        }
    }
}
