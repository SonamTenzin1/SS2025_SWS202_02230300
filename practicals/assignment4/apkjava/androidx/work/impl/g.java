package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.n;
import androidx.work.q;
import androidx.work.w;
import androidx.work.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: WorkContinuationImpl.java */
/* loaded from: classes.dex */
public class g extends w {
    private static final String a = n.f("WorkContinuationImpl");

    /* renamed from: b, reason: collision with root package name */
    private final j f2423b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2424c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.work.g f2425d;

    /* renamed from: e, reason: collision with root package name */
    private final List<? extends z> f2426e;

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f2427f;

    /* renamed from: g, reason: collision with root package name */
    private final List<String> f2428g;

    /* renamed from: h, reason: collision with root package name */
    private final List<g> f2429h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2430i;

    /* renamed from: j, reason: collision with root package name */
    private q f2431j;

    public g(j jVar, List<? extends z> list) {
        this(jVar, null, androidx.work.g.KEEP, list, null);
    }

    private static boolean i(g gVar, Set<String> set) {
        set.addAll(gVar.c());
        Set<String> l = l(gVar);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (l.contains(it.next())) {
                return true;
            }
        }
        List<g> e2 = gVar.e();
        if (e2 != null && !e2.isEmpty()) {
            Iterator<g> it2 = e2.iterator();
            while (it2.hasNext()) {
                if (i(it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.c());
        return false;
    }

    public static Set<String> l(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> e2 = gVar.e();
        if (e2 != null && !e2.isEmpty()) {
            Iterator<g> it = e2.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().c());
            }
        }
        return hashSet;
    }

    public q a() {
        if (!this.f2430i) {
            androidx.work.impl.utils.b bVar = new androidx.work.impl.utils.b(this);
            this.f2423b.u().b(bVar);
            this.f2431j = bVar.d();
        } else {
            n.c().h(a, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f2427f)), new Throwable[0]);
        }
        return this.f2431j;
    }

    public androidx.work.g b() {
        return this.f2425d;
    }

    public List<String> c() {
        return this.f2427f;
    }

    public String d() {
        return this.f2424c;
    }

    public List<g> e() {
        return this.f2429h;
    }

    public List<? extends z> f() {
        return this.f2426e;
    }

    public j g() {
        return this.f2423b;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f2430i;
    }

    public void k() {
        this.f2430i = true;
    }

    public g(j jVar, String str, androidx.work.g gVar, List<? extends z> list) {
        this(jVar, str, gVar, list, null);
    }

    public g(j jVar, String str, androidx.work.g gVar, List<? extends z> list, List<g> list2) {
        this.f2423b = jVar;
        this.f2424c = str;
        this.f2425d = gVar;
        this.f2426e = list;
        this.f2429h = list2;
        this.f2427f = new ArrayList(list.size());
        this.f2428g = new ArrayList();
        if (list2 != null) {
            Iterator<g> it = list2.iterator();
            while (it.hasNext()) {
                this.f2428g.addAll(it.next().f2428g);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a2 = list.get(i2).a();
            this.f2427f.add(a2);
            this.f2428g.add(a2);
        }
    }
}
