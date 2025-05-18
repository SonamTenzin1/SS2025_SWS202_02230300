package com.liulishuo.filedownloader.services;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: FileDownloadThreadPool.java */
/* loaded from: classes2.dex */
class h {

    /* renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f20525b;

    /* renamed from: d, reason: collision with root package name */
    private int f20527d;
    private SparseArray<e.h.a.g0.d> a = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private final String f20526c = "Network";

    /* renamed from: e, reason: collision with root package name */
    private int f20528e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(int i2) {
        this.f20525b = e.h.a.k0.b.a(i2, "Network");
        this.f20527d = i2;
    }

    private synchronized void d() {
        SparseArray<e.h.a.g0.d> sparseArray = new SparseArray<>();
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = this.a.keyAt(i2);
            e.h.a.g0.d dVar = this.a.get(keyAt);
            if (dVar != null && dVar.p()) {
                sparseArray.put(keyAt, dVar);
            }
        }
        this.a = sparseArray;
    }

    public void a(int i2) {
        d();
        synchronized (this) {
            e.h.a.g0.d dVar = this.a.get(i2);
            if (dVar != null) {
                dVar.r();
                boolean remove = this.f20525b.remove(dVar);
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "successful cancel %d %B", Integer.valueOf(i2), Boolean.valueOf(remove));
                }
            }
            this.a.remove(i2);
        }
    }

    public synchronized int b() {
        d();
        return this.a.size();
    }

    public void c(e.h.a.g0.d dVar) {
        dVar.s();
        synchronized (this) {
            this.a.put(dVar.k(), dVar);
        }
        this.f20525b.execute(dVar);
        int i2 = this.f20528e;
        if (i2 >= 600) {
            d();
            this.f20528e = 0;
        } else {
            this.f20528e = i2 + 1;
        }
    }

    public synchronized int e(String str, int i2) {
        if (str == null) {
            return 0;
        }
        int size = this.a.size();
        for (int i3 = 0; i3 < size; i3++) {
            e.h.a.g0.d valueAt = this.a.valueAt(i3);
            if (valueAt != null && valueAt.p() && valueAt.k() != i2 && str.equals(valueAt.l())) {
                return valueAt.k();
            }
        }
        return 0;
    }

    public synchronized List<Integer> f() {
        ArrayList arrayList;
        d();
        arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            SparseArray<e.h.a.g0.d> sparseArray = this.a;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i2)).k()));
        }
        return arrayList;
    }

    public synchronized boolean g(int i2) {
        boolean z;
        e.h.a.g0.d dVar = this.a.get(i2);
        if (dVar != null) {
            z = dVar.p();
        }
        return z;
    }

    public synchronized boolean h(int i2) {
        if (b() > 0) {
            e.h.a.k0.d.i(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int b2 = e.h.a.k0.e.b(i2);
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f20527d), Integer.valueOf(b2));
        }
        List<Runnable> shutdownNow = this.f20525b.shutdownNow();
        this.f20525b = e.h.a.k0.b.a(b2, "Network");
        if (shutdownNow.size() > 0) {
            e.h.a.k0.d.i(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.f20527d = b2;
        return true;
    }
}
