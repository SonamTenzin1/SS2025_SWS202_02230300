package androidx.coordinatorlayout.widget;

import c.i.j.f;
import c.i.j.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: DirectedAcyclicGraph.java */
/* loaded from: classes.dex */
public final class a<T> {
    private final f<ArrayList<T>> a = new g(10);

    /* renamed from: b, reason: collision with root package name */
    private final c.e.g<T, ArrayList<T>> f831b = new c.e.g<>();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<T> f832c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet<T> f833d = new HashSet<>();

    private void e(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (!hashSet.contains(t)) {
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.f831b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    e(arrayList2.get(i2), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    private ArrayList<T> f() {
        ArrayList<T> b2 = this.a.b();
        return b2 == null ? new ArrayList<>() : b2;
    }

    private void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.a.a(arrayList);
    }

    public void a(T t, T t2) {
        if (this.f831b.containsKey(t) && this.f831b.containsKey(t2)) {
            ArrayList<T> arrayList = this.f831b.get(t);
            if (arrayList == null) {
                arrayList = f();
                this.f831b.put(t, arrayList);
            }
            arrayList.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void b(T t) {
        if (this.f831b.containsKey(t)) {
            return;
        }
        this.f831b.put(t, null);
    }

    public void c() {
        int size = this.f831b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> n = this.f831b.n(i2);
            if (n != null) {
                k(n);
            }
        }
        this.f831b.clear();
    }

    public boolean d(T t) {
        return this.f831b.containsKey(t);
    }

    public List g(T t) {
        return this.f831b.get(t);
    }

    public List<T> h(T t) {
        int size = this.f831b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> n = this.f831b.n(i2);
            if (n != null && n.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f831b.j(i2));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f832c.clear();
        this.f833d.clear();
        int size = this.f831b.size();
        for (int i2 = 0; i2 < size; i2++) {
            e(this.f831b.j(i2), this.f832c, this.f833d);
        }
        return this.f832c;
    }

    public boolean j(T t) {
        int size = this.f831b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> n = this.f831b.n(i2);
            if (n != null && n.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
