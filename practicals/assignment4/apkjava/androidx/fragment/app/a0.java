package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpecialEffectsController.java */
/* loaded from: classes.dex */
public abstract class a0 {
    private final ViewGroup a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<e> f1534b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<e> f1535c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    boolean f1536d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f1537e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f1538f;

        a(d dVar) {
            this.f1538f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a0.this.f1534b.contains(this.f1538f)) {
                this.f1538f.e().g(this.f1538f.f().mView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f1540f;

        b(d dVar) {
            this.f1540f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f1534b.remove(this.f1540f);
            a0.this.f1535c.remove(this.f1540f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1542b;

        static {
            int[] iArr = new int[e.b.values().length];
            f1542b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1542b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1542b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: h, reason: collision with root package name */
        private final r f1543h;

        d(e.c cVar, e.b bVar, r rVar, androidx.core.os.b bVar2) {
            super(cVar, bVar, rVar.k(), bVar2);
            this.f1543h = rVar;
        }

        @Override // androidx.fragment.app.a0.e
        public void c() {
            super.c();
            this.f1543h.m();
        }

        @Override // androidx.fragment.app.a0.e
        void l() {
            Fragment k2 = this.f1543h.k();
            View findFocus = k2.mView.findFocus();
            if (findFocus != null) {
                k2.setFocusedView(findFocus);
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k2);
                }
            }
            if (g() == e.b.ADDING) {
                View requireView = f().requireView();
                if (requireView.getParent() == null) {
                    this.f1543h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k2.getPostOnViewCreatedAlpha());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class e {
        private c a;

        /* renamed from: b, reason: collision with root package name */
        private b f1544b;

        /* renamed from: c, reason: collision with root package name */
        private final Fragment f1545c;

        /* renamed from: d, reason: collision with root package name */
        private final List<Runnable> f1546d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private final HashSet<androidx.core.os.b> f1547e = new HashSet<>();

        /* renamed from: f, reason: collision with root package name */
        private boolean f1548f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f1549g = false;

        /* compiled from: SpecialEffectsController.java */
        /* loaded from: classes.dex */
        class a implements b.a {
            a() {
            }

            @Override // androidx.core.os.b.a
            public void onCancel() {
                e.this.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SpecialEffectsController.java */
        /* loaded from: classes.dex */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SpecialEffectsController.java */
        /* loaded from: classes.dex */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            /* JADX INFO: Access modifiers changed from: package-private */
            public static c k(int i2) {
                if (i2 == 0) {
                    return VISIBLE;
                }
                if (i2 == 4) {
                    return INVISIBLE;
                }
                if (i2 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i2);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static c q(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return k(view.getVisibility());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void g(View view) {
                int i2 = c.a[ordinal()];
                if (i2 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i2 == 2) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i2 == 3) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i2 != 4) {
                    return;
                }
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        e(c cVar, b bVar, Fragment fragment, androidx.core.os.b bVar2) {
            this.a = cVar;
            this.f1544b = bVar;
            this.f1545c = fragment;
            bVar2.c(new a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.f1546d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f1548f = true;
            if (this.f1547e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f1547e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.b) it.next()).a();
            }
        }

        public void c() {
            if (this.f1549g) {
                return;
            }
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f1549g = true;
            Iterator<Runnable> it = this.f1546d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        public final void d(androidx.core.os.b bVar) {
            if (this.f1547e.remove(bVar) && this.f1547e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.a;
        }

        public final Fragment f() {
            return this.f1545c;
        }

        b g() {
            return this.f1544b;
        }

        final boolean h() {
            return this.f1548f;
        }

        final boolean i() {
            return this.f1549g;
        }

        public final void j(androidx.core.os.b bVar) {
            l();
            this.f1547e.add(bVar);
        }

        final void k(c cVar, b bVar) {
            int i2 = c.f1542b[bVar.ordinal()];
            if (i2 == 1) {
                if (this.a == c.REMOVED) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1545c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f1544b + " to ADDING.");
                    }
                    this.a = c.VISIBLE;
                    this.f1544b = b.ADDING;
                    return;
                }
                return;
            }
            if (i2 != 2) {
                if (i2 == 3 && this.a != c.REMOVED) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1545c + " mFinalState = " + this.a + " -> " + cVar + ". ");
                    }
                    this.a = cVar;
                    return;
                }
                return;
            }
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1545c + " mFinalState = " + this.a + " -> REMOVED. mLifecycleImpact  = " + this.f1544b + " to REMOVING.");
            }
            this.a = c.REMOVED;
            this.f1544b = b.REMOVING;
        }

        void l() {
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.a + "} {mLifecycleImpact = " + this.f1544b + "} {mFragment = " + this.f1545c + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, r rVar) {
        synchronized (this.f1534b) {
            androidx.core.os.b bVar2 = new androidx.core.os.b();
            e h2 = h(rVar.k());
            if (h2 != null) {
                h2.k(cVar, bVar);
                return;
            }
            d dVar = new d(cVar, bVar, rVar, bVar2);
            this.f1534b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    private e h(Fragment fragment) {
        Iterator<e> it = this.f1534b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    private e i(Fragment fragment) {
        Iterator<e> it = this.f1535c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a0 n(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.B0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a0 o(ViewGroup viewGroup, b0 b0Var) {
        int i2 = c.m.b.f3342b;
        Object tag = viewGroup.getTag(i2);
        if (tag instanceof a0) {
            return (a0) tag;
        }
        a0 a2 = b0Var.a(viewGroup);
        viewGroup.setTag(i2, a2);
        return a2;
    }

    private void q() {
        Iterator<e> it = this.f1534b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.g() == e.b.ADDING) {
                next.k(e.c.k(next.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e.c cVar, r rVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + rVar.k());
        }
        a(cVar, e.b.ADDING, rVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(r rVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + rVar.k());
        }
        a(e.c.GONE, e.b.NONE, rVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(r rVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + rVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, rVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(r rVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + rVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, rVar);
    }

    abstract void f(List<e> list, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.f1537e) {
            return;
        }
        if (!androidx.core.view.u.N(this.a)) {
            j();
            this.f1536d = false;
            return;
        }
        synchronized (this.f1534b) {
            if (!this.f1534b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f1535c);
                this.f1535c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                    }
                    eVar.b();
                    if (!eVar.i()) {
                        this.f1535c.add(eVar);
                    }
                }
                q();
                ArrayList arrayList2 = new ArrayList(this.f1534b);
                this.f1534b.clear();
                this.f1535c.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).l();
                }
                f(arrayList2, this.f1536d);
                this.f1536d = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        String str;
        String str2;
        boolean N = androidx.core.view.u.N(this.a);
        synchronized (this.f1534b) {
            q();
            Iterator<e> it = this.f1534b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            Iterator it2 = new ArrayList(this.f1535c).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                if (FragmentManager.H0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (N) {
                        str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                    } else {
                        str2 = "Container " + this.a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(eVar);
                    Log.v("FragmentManager", sb.toString());
                }
                eVar.b();
            }
            Iterator it3 = new ArrayList(this.f1534b).iterator();
            while (it3.hasNext()) {
                e eVar2 = (e) it3.next();
                if (FragmentManager.H0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (N) {
                        str = HttpUrl.FRAGMENT_ENCODE_SET;
                    } else {
                        str = "Container " + this.a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(eVar2);
                    Log.v("FragmentManager", sb2.toString());
                }
                eVar2.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        if (this.f1537e) {
            this.f1537e = false;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e.b l(r rVar) {
        e h2 = h(rVar.k());
        if (h2 != null) {
            return h2.g();
        }
        e i2 = i(rVar.k());
        if (i2 != null) {
            return i2.g();
        }
        return null;
    }

    public ViewGroup m() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f1534b) {
            q();
            this.f1537e = false;
            int size = this.f1534b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                e eVar = this.f1534b.get(size);
                e.c q = e.c.q(eVar.f().mView);
                e.c e2 = eVar.e();
                e.c cVar = e.c.VISIBLE;
                if (e2 == cVar && q != cVar) {
                    this.f1537e = eVar.f().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z) {
        this.f1536d = z;
    }
}
