package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.n.q;
import androidx.work.x;
import java.util.UUID;

/* compiled from: WorkForegroundUpdater.java */
/* loaded from: classes.dex */
public class l implements androidx.work.i {
    private static final String a = androidx.work.n.f("WMFgUpdater");

    /* renamed from: b, reason: collision with root package name */
    private final androidx.work.impl.utils.p.a f2594b;

    /* renamed from: c, reason: collision with root package name */
    final androidx.work.impl.foreground.a f2595c;

    /* renamed from: d, reason: collision with root package name */
    final q f2596d;

    /* compiled from: WorkForegroundUpdater.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.o.c f2597f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ UUID f2598g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ androidx.work.h f2599h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f2600i;

        a(androidx.work.impl.utils.o.c cVar, UUID uuid, androidx.work.h hVar, Context context) {
            this.f2597f = cVar;
            this.f2598g = uuid;
            this.f2599h = hVar;
            this.f2600i = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.f2597f.isCancelled()) {
                    String uuid = this.f2598g.toString();
                    x.a l = l.this.f2596d.l(uuid);
                    if (l != null && !l.g()) {
                        l.this.f2595c.a(uuid, this.f2599h);
                        this.f2600i.startService(androidx.work.impl.foreground.b.a(this.f2600i, uuid, this.f2599h));
                    } else {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                }
                this.f2597f.q(null);
            } catch (Throwable th) {
                this.f2597f.r(th);
            }
        }
    }

    public l(WorkDatabase workDatabase, androidx.work.impl.foreground.a aVar, androidx.work.impl.utils.p.a aVar2) {
        this.f2595c = aVar;
        this.f2594b = aVar2;
        this.f2596d = workDatabase.j();
    }

    @Override // androidx.work.i
    public e.e.c.a.a.a<Void> a(Context context, UUID uuid, androidx.work.h hVar) {
        androidx.work.impl.utils.o.c u = androidx.work.impl.utils.o.c.u();
        this.f2594b.b(new a(u, uuid, hVar, context));
        return u;
    }
}
