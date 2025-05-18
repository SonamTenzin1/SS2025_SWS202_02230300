package e.h.a;

import e.h.a.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: FileDownloadTaskLauncher.java */
/* loaded from: classes2.dex */
class p {
    private final b a = new b();

    /* compiled from: FileDownloadTaskLauncher.java */
    /* loaded from: classes2.dex */
    private static class a {
        private static final p a = new p();

        static {
            com.liulishuo.filedownloader.message.b.a().c(new a0());
        }
    }

    /* compiled from: FileDownloadTaskLauncher.java */
    /* loaded from: classes2.dex */
    private static class b {
        private ThreadPoolExecutor a;

        /* renamed from: b, reason: collision with root package name */
        private LinkedBlockingQueue<Runnable> f21381b;

        b() {
            d();
        }

        private void d() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.f21381b = linkedBlockingQueue;
            this.a = e.h.a.k0.b.b(3, linkedBlockingQueue, "LauncherTask");
        }

        public void a(x.b bVar) {
            this.a.execute(new c(bVar));
        }

        public void b(i iVar) {
            if (iVar == null) {
                e.h.a.k0.d.i(this, "want to expire by listener, but the listener provided is null", new Object[0]);
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Runnable> it = this.f21381b.iterator();
            while (it.hasNext()) {
                Runnable next = it.next();
                c cVar = (c) next;
                if (cVar.b(iVar)) {
                    cVar.a();
                    arrayList.add(next);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "expire %d tasks with listener[%s]", Integer.valueOf(arrayList.size()), iVar);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.a.remove((Runnable) it2.next());
            }
        }

        public void c(x.b bVar) {
            this.f21381b.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileDownloadTaskLauncher.java */
    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final x.b f21382f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f21383g = false;

        c(x.b bVar) {
            this.f21382f = bVar;
        }

        public void a() {
            this.f21383g = true;
        }

        public boolean b(i iVar) {
            x.b bVar = this.f21382f;
            return bVar != null && bVar.r(iVar);
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f21382f;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f21383g) {
                return;
            }
            this.f21382f.start();
        }
    }

    p() {
    }

    public static p c() {
        return a.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(i iVar) {
        this.a.b(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(x.b bVar) {
        this.a.c(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(x.b bVar) {
        this.a.a(bVar);
    }
}
