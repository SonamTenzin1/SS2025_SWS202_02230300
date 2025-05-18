package e.h.a;

import com.liulishuo.filedownloader.message.MessageSnapshot;
import e.h.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FileDownloadList.java */
/* loaded from: classes2.dex */
public class h {
    private final ArrayList<a.b> a;

    /* compiled from: FileDownloadList.java */
    /* loaded from: classes2.dex */
    private static final class b {
        private static final h a = new h();
    }

    public static h i() {
        return b.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.b bVar) {
        if (!bVar.v().p()) {
            bVar.F();
        }
        if (bVar.y().f().i()) {
            b(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a.b bVar) {
        if (bVar.H()) {
            return;
        }
        synchronized (this.a) {
            if (this.a.contains(bVar)) {
                e.h.a.k0.d.i(this, "already has %s", bVar);
            } else {
                bVar.T();
                this.a.add(bVar);
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.h(this, "add list in all %s %d %d", bVar, Byte.valueOf(bVar.v().getStatus()), Integer.valueOf(this.a.size()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<a.b> c(int i2, i iVar) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            Iterator<a.b> it = this.a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (next.v().G() == iVar && !next.v().p()) {
                    next.C(i2);
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<a.b> d(i iVar) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            Iterator<a.b> it = this.a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (next.z(iVar)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(int i2) {
        int i3;
        synchronized (this.a) {
            Iterator<a.b> it = this.a.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().A(i2)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(List<a.b> list) {
        synchronized (this.a) {
            Iterator<a.b> it = this.a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.a.clear();
        }
    }

    public a.b g(int i2) {
        synchronized (this.a) {
            Iterator<a.b> it = this.a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (next.A(i2)) {
                    return next;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<a.b> h(int i2) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            Iterator<a.b> it = this.a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (next.A(i2) && !next.P()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<a.b> j(int i2) {
        byte status;
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            Iterator<a.b> it = this.a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (next.A(i2) && !next.P() && (status = next.v().getStatus()) != 0 && status != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(a.b bVar) {
        return this.a.isEmpty() || !this.a.contains(bVar);
    }

    public boolean l(a.b bVar, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte k2 = messageSnapshot.k();
        synchronized (this.a) {
            remove = this.a.remove(bVar);
            if (remove && this.a.size() == 0 && m.b().v0()) {
                q.e().n(true);
            }
        }
        if (e.h.a.k0.d.a && this.a.size() == 0) {
            e.h.a.k0.d.h(this, "remove %s left %d %d", bVar, Byte.valueOf(k2), Integer.valueOf(this.a.size()));
        }
        if (remove) {
            t f2 = bVar.y().f();
            if (k2 == -4) {
                f2.g(messageSnapshot);
            } else if (k2 == -3) {
                f2.k(com.liulishuo.filedownloader.message.c.f(messageSnapshot));
            } else if (k2 == -2) {
                f2.c(messageSnapshot);
            } else if (k2 == -1) {
                f2.d(messageSnapshot);
            }
        } else {
            e.h.a.k0.d.b(this, "remove error, not exist: %s %d", bVar, Byte.valueOf(k2));
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.a.size();
    }

    private h() {
        this.a = new ArrayList<>();
    }
}
