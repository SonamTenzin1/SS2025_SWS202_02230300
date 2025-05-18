package e.h.a.h0;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* compiled from: DownloadEventPoolImpl.java */
/* loaded from: classes2.dex */
public class a {
    private final Executor a = e.h.a.k0.b.a(10, "EventPool");

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, LinkedList<d>> f21336b = new HashMap<>();

    /* compiled from: DownloadEventPoolImpl.java */
    /* renamed from: e.h.a.h0.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0277a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f21337f;

        RunnableC0277a(c cVar) {
            this.f21337f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c(this.f21337f);
        }
    }

    private void d(LinkedList<d> linkedList, c cVar) {
        for (Object obj : linkedList.toArray()) {
            if (obj != null && ((d) obj).d(cVar)) {
                break;
            }
        }
        Runnable runnable = cVar.a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean a(String str, d dVar) {
        boolean add;
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "setListener %s", str);
        }
        if (dVar != null) {
            LinkedList<d> linkedList = this.f21336b.get(str);
            if (linkedList == null) {
                synchronized (str.intern()) {
                    linkedList = this.f21336b.get(str);
                    if (linkedList == null) {
                        HashMap<String, LinkedList<d>> hashMap = this.f21336b;
                        LinkedList<d> linkedList2 = new LinkedList<>();
                        hashMap.put(str, linkedList2);
                        linkedList = linkedList2;
                    }
                }
            }
            synchronized (str.intern()) {
                add = linkedList.add(dVar);
            }
            return add;
        }
        throw new IllegalArgumentException("listener must not be null!");
    }

    public void b(c cVar) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "asyncPublishInNewThread %s", cVar.a());
        }
        if (cVar != null) {
            this.a.execute(new RunnableC0277a(cVar));
            return;
        }
        throw new IllegalArgumentException("event must not be null!");
    }

    public boolean c(c cVar) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "publish %s", cVar.a());
        }
        if (cVar != null) {
            String a = cVar.a();
            LinkedList<d> linkedList = this.f21336b.get(a);
            if (linkedList == null) {
                synchronized (a.intern()) {
                    linkedList = this.f21336b.get(a);
                    if (linkedList == null) {
                        if (e.h.a.k0.d.a) {
                            e.h.a.k0.d.a(this, "No listener for this event %s", a);
                        }
                        return false;
                    }
                }
            }
            d(linkedList, cVar);
            return true;
        }
        throw new IllegalArgumentException("event must not be null!");
    }
}
