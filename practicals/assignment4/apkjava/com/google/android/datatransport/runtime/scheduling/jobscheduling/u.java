package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.a;
import e.e.b.a.i.b0.j.i0;
import e.e.b.a.i.b0.j.j0;
import e.e.b.a.i.b0.j.q0;
import e.e.b.a.i.y.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: Uploader.java */
/* loaded from: classes2.dex */
public class u {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.backends.e f11355b;

    /* renamed from: c, reason: collision with root package name */
    private final j0 f11356c;

    /* renamed from: d, reason: collision with root package name */
    private final y f11357d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f11358e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f11359f;

    /* renamed from: g, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11360g;

    /* renamed from: h, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11361h;

    /* renamed from: i, reason: collision with root package name */
    private final i0 f11362i;

    @Inject
    public u(Context context, com.google.android.datatransport.runtime.backends.e eVar, j0 j0Var, y yVar, Executor executor, com.google.android.datatransport.runtime.synchronization.a aVar, e.e.b.a.i.c0.a aVar2, e.e.b.a.i.c0.a aVar3, i0 i0Var) {
        this.a = context;
        this.f11355b = eVar;
        this.f11356c = j0Var;
        this.f11357d = yVar;
        this.f11358e = executor;
        this.f11359f = aVar;
        this.f11360g = aVar2;
        this.f11361h = aVar3;
        this.f11362i = i0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean d(e.e.b.a.i.q qVar) {
        return Boolean.valueOf(this.f11356c.b1(qVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Iterable f(e.e.b.a.i.q qVar) {
        return this.f11356c.G(qVar);
    }

    private /* synthetic */ Object g(Iterable iterable, e.e.b.a.i.q qVar, long j2) {
        this.f11356c.e1(iterable);
        this.f11356c.O(qVar, this.f11360g.a() + j2);
        return null;
    }

    private /* synthetic */ Object i(Iterable iterable) {
        this.f11356c.q(iterable);
        return null;
    }

    private /* synthetic */ Object k() {
        this.f11362i.a();
        return null;
    }

    private /* synthetic */ Object m(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.f11362i.d(((Integer) r0.getValue()).intValue(), c.b.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    private /* synthetic */ Object o(e.e.b.a.i.q qVar, long j2) {
        this.f11356c.O(qVar, this.f11360g.a() + j2);
        return null;
    }

    private /* synthetic */ Object q(e.e.b.a.i.q qVar, int i2) {
        this.f11357d.a(qVar, i2 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(final e.e.b.a.i.q qVar, final int i2, Runnable runnable) {
        try {
            try {
                com.google.android.datatransport.runtime.synchronization.a aVar = this.f11359f;
                final j0 j0Var = this.f11356c;
                j0Var.getClass();
                aVar.b(new a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.b
                    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                    public final Object execute() {
                        return Integer.valueOf(j0.this.o());
                    }
                });
                if (!b()) {
                    this.f11359f.b(new a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.k
                        @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                        public final Object execute() {
                            u.this.r(qVar, i2);
                            return null;
                        }
                    });
                } else {
                    u(qVar, i2);
                }
            } catch (SynchronizationException unused) {
                this.f11357d.a(qVar, i2 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    public e.e.b.a.i.j a(com.google.android.datatransport.runtime.backends.m mVar) {
        com.google.android.datatransport.runtime.synchronization.a aVar = this.f11359f;
        final i0 i0Var = this.f11362i;
        i0Var.getClass();
        return mVar.b(e.e.b.a.i.j.a().i(this.f11360g.a()).k(this.f11361h.a()).j("GDT_CLIENT_METRICS").h(new e.e.b.a.i.i(e.e.b.a.b.b("proto"), ((e.e.b.a.i.y.a.a) aVar.b(new a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.o
            @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
            public final Object execute() {
                return i0.this.c();
            }
        })).f())).d());
    }

    boolean b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public /* synthetic */ Object h(Iterable iterable, e.e.b.a.i.q qVar, long j2) {
        g(iterable, qVar, j2);
        return null;
    }

    public /* synthetic */ Object j(Iterable iterable) {
        i(iterable);
        return null;
    }

    public /* synthetic */ Object l() {
        k();
        return null;
    }

    public /* synthetic */ Object n(Map map) {
        m(map);
        return null;
    }

    public /* synthetic */ Object p(e.e.b.a.i.q qVar, long j2) {
        o(qVar, j2);
        return null;
    }

    public /* synthetic */ Object r(e.e.b.a.i.q qVar, int i2) {
        q(qVar, i2);
        return null;
    }

    public com.google.android.datatransport.runtime.backends.g u(final e.e.b.a.i.q qVar, int i2) {
        com.google.android.datatransport.runtime.backends.g a;
        com.google.android.datatransport.runtime.backends.m mVar = this.f11355b.get(qVar.b());
        long j2 = 0;
        com.google.android.datatransport.runtime.backends.g e2 = com.google.android.datatransport.runtime.backends.g.e(0L);
        while (true) {
            final long j3 = j2;
            while (((Boolean) this.f11359f.b(new a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.e
                @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                public final Object execute() {
                    return u.this.d(qVar);
                }
            })).booleanValue()) {
                final Iterable iterable = (Iterable) this.f11359f.b(new a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.g
                    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                    public final Object execute() {
                        return u.this.f(qVar);
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return e2;
                }
                if (mVar == null) {
                    e.e.b.a.i.z.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", qVar);
                    a = com.google.android.datatransport.runtime.backends.g.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((q0) it.next()).b());
                    }
                    if (qVar.e()) {
                        arrayList.add(a(mVar));
                    }
                    a = mVar.a(com.google.android.datatransport.runtime.backends.f.a().b(arrayList).c(qVar.c()).a());
                }
                e2 = a;
                if (e2.c() == g.a.TRANSIENT_ERROR) {
                    this.f11359f.b(new a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.h
                        @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                        public final Object execute() {
                            u.this.h(iterable, qVar, j3);
                            return null;
                        }
                    });
                    this.f11357d.b(qVar, i2 + 1, true);
                    return e2;
                }
                this.f11359f.b(new a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.j
                    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                    public final Object execute() {
                        u.this.j(iterable);
                        return null;
                    }
                });
                if (e2.c() == g.a.OK) {
                    j2 = Math.max(j3, e2.b());
                    if (qVar.e()) {
                        this.f11359f.b(new a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.l
                            @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                            public final Object execute() {
                                u.this.l();
                                return null;
                            }
                        });
                    }
                } else if (e2.c() == g.a.INVALID_PAYLOAD) {
                    final HashMap hashMap = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String j4 = ((q0) it2.next()).b().j();
                        if (!hashMap.containsKey(j4)) {
                            hashMap.put(j4, 1);
                        } else {
                            hashMap.put(j4, Integer.valueOf(((Integer) hashMap.get(j4)).intValue() + 1));
                        }
                    }
                    this.f11359f.b(new a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.f
                        @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                        public final Object execute() {
                            u.this.n(hashMap);
                            return null;
                        }
                    });
                }
            }
            this.f11359f.b(new a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.i
                @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                public final Object execute() {
                    u.this.p(qVar, j3);
                    return null;
                }
            });
            return e2;
        }
    }

    public void v(final e.e.b.a.i.q qVar, final int i2, final Runnable runnable) {
        this.f11358e.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.d
            @Override // java.lang.Runnable
            public final void run() {
                u.this.t(qVar, i2, runnable);
            }
        });
    }
}
