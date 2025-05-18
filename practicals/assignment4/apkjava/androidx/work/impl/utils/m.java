package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.n.p;
import androidx.work.t;
import androidx.work.x;
import java.util.UUID;

/* compiled from: WorkProgressUpdater.java */
/* loaded from: classes.dex */
public class m implements t {
    static final String a = androidx.work.n.f("WorkProgressUpdater");

    /* renamed from: b, reason: collision with root package name */
    final WorkDatabase f2602b;

    /* renamed from: c, reason: collision with root package name */
    final androidx.work.impl.utils.p.a f2603c;

    /* compiled from: WorkProgressUpdater.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ UUID f2604f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.work.e f2605g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.o.c f2606h;

        a(UUID uuid, androidx.work.e eVar, androidx.work.impl.utils.o.c cVar) {
            this.f2604f = uuid;
            this.f2605g = eVar;
            this.f2606h = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p m;
            String uuid = this.f2604f.toString();
            androidx.work.n c2 = androidx.work.n.c();
            String str = m.a;
            c2.a(str, String.format("Updating progress for %s (%s)", this.f2604f, this.f2605g), new Throwable[0]);
            m.this.f2602b.beginTransaction();
            try {
                m = m.this.f2602b.j().m(uuid);
            } finally {
                try {
                    return;
                } finally {
                }
            }
            if (m != null) {
                if (m.f2526d == x.a.RUNNING) {
                    m.this.f2602b.i().b(new androidx.work.impl.n.m(uuid, this.f2605g));
                } else {
                    androidx.work.n.c().h(str, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", uuid), new Throwable[0]);
                }
                this.f2606h.q(null);
                m.this.f2602b.setTransactionSuccessful();
                return;
            }
            throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
        }
    }

    public m(WorkDatabase workDatabase, androidx.work.impl.utils.p.a aVar) {
        this.f2602b = workDatabase;
        this.f2603c = aVar;
    }

    @Override // androidx.work.t
    public e.e.c.a.a.a<Void> a(Context context, UUID uuid, androidx.work.e eVar) {
        androidx.work.impl.utils.o.c u = androidx.work.impl.utils.o.c.u();
        this.f2603c.b(new a(uuid, eVar, u));
        return u;
    }
}
