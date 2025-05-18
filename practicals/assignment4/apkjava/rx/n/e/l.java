package rx.n.e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: SubscriptionList.java */
/* loaded from: classes3.dex */
public final class l implements rx.k {

    /* renamed from: f, reason: collision with root package name */
    private List<rx.k> f26782f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f26783g;

    public l() {
    }

    private static void c(Collection<rx.k> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<rx.k> it = collection.iterator();
        while (it.hasNext()) {
            try {
                it.next().unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        rx.exceptions.a.d(arrayList);
    }

    public void a(rx.k kVar) {
        if (kVar.isUnsubscribed()) {
            return;
        }
        if (!this.f26783g) {
            synchronized (this) {
                if (!this.f26783g) {
                    List list = this.f26782f;
                    if (list == null) {
                        list = new LinkedList();
                        this.f26782f = list;
                    }
                    list.add(kVar);
                    return;
                }
            }
        }
        kVar.unsubscribe();
    }

    public void b(rx.k kVar) {
        if (this.f26783g) {
            return;
        }
        synchronized (this) {
            List<rx.k> list = this.f26782f;
            if (!this.f26783g && list != null) {
                boolean remove = list.remove(kVar);
                if (remove) {
                    kVar.unsubscribe();
                }
            }
        }
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26783g;
    }

    @Override // rx.k
    public void unsubscribe() {
        if (this.f26783g) {
            return;
        }
        synchronized (this) {
            if (this.f26783g) {
                return;
            }
            this.f26783g = true;
            List<rx.k> list = this.f26782f;
            this.f26782f = null;
            c(list);
        }
    }

    public l(rx.k... kVarArr) {
        this.f26782f = new LinkedList(Arrays.asList(kVarArr));
    }

    public l(rx.k kVar) {
        LinkedList linkedList = new LinkedList();
        this.f26782f = linkedList;
        linkedList.add(kVar);
    }
}
