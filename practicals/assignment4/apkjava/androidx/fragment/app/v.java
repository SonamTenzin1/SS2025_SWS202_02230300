package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
public class v {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b, reason: collision with root package name */
    static final x f1657b;

    /* renamed from: c, reason: collision with root package name */
    static final x f1658c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f1659f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Fragment f1660g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.b f1661h;

        a(g gVar, Fragment fragment, androidx.core.os.b bVar) {
            this.f1659f = gVar;
            this.f1660g = fragment;
            this.f1661h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1659f.a(this.f1660g, this.f1661h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1662f;

        b(ArrayList arrayList) {
            this.f1662f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.A(this.f1662f, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f1663f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Fragment f1664g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.b f1665h;

        c(g gVar, Fragment fragment, androidx.core.os.b bVar) {
            this.f1663f = gVar;
            this.f1664g = fragment;
            this.f1665h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1663f.a(this.f1664g, this.f1665h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f1666f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ x f1667g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f1668h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Fragment f1669i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f1670j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ ArrayList f1671k;
        final /* synthetic */ ArrayList l;
        final /* synthetic */ Object m;

        d(Object obj, x xVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f1666f = obj;
            this.f1667g = xVar;
            this.f1668h = view;
            this.f1669i = fragment;
            this.f1670j = arrayList;
            this.f1671k = arrayList2;
            this.l = arrayList3;
            this.m = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f1666f;
            if (obj != null) {
                this.f1667g.p(obj, this.f1668h);
                this.f1671k.addAll(v.k(this.f1667g, this.f1666f, this.f1669i, this.f1670j, this.f1668h));
            }
            if (this.l != null) {
                if (this.m != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f1668h);
                    this.f1667g.q(this.m, this.l, arrayList);
                }
                this.l.clear();
                this.l.add(this.f1668h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Fragment f1672f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Fragment f1673g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f1674h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ c.e.a f1675i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ View f1676j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ x f1677k;
        final /* synthetic */ Rect l;

        e(Fragment fragment, Fragment fragment2, boolean z, c.e.a aVar, View view, x xVar, Rect rect) {
            this.f1672f = fragment;
            this.f1673g = fragment2;
            this.f1674h = z;
            this.f1675i = aVar;
            this.f1676j = view;
            this.f1677k = xVar;
            this.l = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.f(this.f1672f, this.f1673g, this.f1674h, this.f1675i, false);
            View view = this.f1676j;
            if (view != null) {
                this.f1677k.k(view, this.l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f1678f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ c.e.a f1679g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Object f1680h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ h f1681i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f1682j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ View f1683k;
        final /* synthetic */ Fragment l;
        final /* synthetic */ Fragment m;
        final /* synthetic */ boolean n;
        final /* synthetic */ ArrayList o;
        final /* synthetic */ Object p;
        final /* synthetic */ Rect q;

        f(x xVar, c.e.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f1678f = xVar;
            this.f1679g = aVar;
            this.f1680h = obj;
            this.f1681i = hVar;
            this.f1682j = arrayList;
            this.f1683k = view;
            this.l = fragment;
            this.m = fragment2;
            this.n = z;
            this.o = arrayList2;
            this.p = obj2;
            this.q = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.e.a<String, View> h2 = v.h(this.f1678f, this.f1679g, this.f1680h, this.f1681i);
            if (h2 != null) {
                this.f1682j.addAll(h2.values());
                this.f1682j.add(this.f1683k);
            }
            v.f(this.l, this.m, this.n, h2, false);
            Object obj = this.f1680h;
            if (obj != null) {
                this.f1678f.A(obj, this.o, this.f1682j);
                View s = v.s(h2, this.f1681i, this.p, this.n);
                if (s != null) {
                    this.f1678f.k(s, this.q);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public interface g {
        void a(Fragment fragment, androidx.core.os.b bVar);

        void b(Fragment fragment, androidx.core.os.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class h {
        public Fragment a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1684b;

        /* renamed from: c, reason: collision with root package name */
        public androidx.fragment.app.a f1685c;

        /* renamed from: d, reason: collision with root package name */
        public Fragment f1686d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1687e;

        /* renamed from: f, reason: collision with root package name */
        public androidx.fragment.app.a f1688f;

        h() {
        }
    }

    static {
        f1657b = Build.VERSION.SDK_INT >= 21 ? new w() : null;
        f1658c = w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void A(ArrayList<View> arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void B(Context context, androidx.fragment.app.f fVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z, g gVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i4 = i2; i4 < i3; i4++) {
            androidx.fragment.app.a aVar = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                e(aVar, sparseArray, z);
            } else {
                c(aVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = sparseArray.keyAt(i5);
                c.e.a<String, String> d2 = d(keyAt, arrayList, arrayList2, i2, i3);
                h hVar = (h) sparseArray.valueAt(i5);
                if (fVar.d() && (viewGroup = (ViewGroup) fVar.c(keyAt)) != null) {
                    if (z) {
                        o(viewGroup, hVar, view, d2, gVar);
                    } else {
                        n(viewGroup, hVar, view, d2, gVar);
                    }
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, c.e.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View n = aVar.n(size);
            if (collection.contains(androidx.core.view.u.G(n))) {
                arrayList.add(n);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0039, code lost:
    
        if (r0.mAdded != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x008c, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x006e, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x008a, code lost:
    
        if (r0.mHidden == false) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(androidx.fragment.app.a aVar, u.a aVar2, SparseArray<h> sparseArray, boolean z, boolean z2) {
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        h hVar;
        Fragment fragment = aVar2.f1650b;
        if (fragment == null || (i2 = fragment.mContainerId) == 0) {
            return;
        }
        int i3 = z ? a[aVar2.a] : aVar2.a;
        boolean z6 = false;
        boolean z7 = true;
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 == 4) {
                    boolean z8 = !z2 ? false : false;
                    z5 = z8;
                    z4 = true;
                    z7 = false;
                    hVar = sparseArray.get(i2);
                    if (z6) {
                    }
                    if (!z2) {
                    }
                    if (z5) {
                    }
                    if (z2) {
                    }
                } else if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            z4 = false;
                            z7 = false;
                            z5 = false;
                            hVar = sparseArray.get(i2);
                            if (z6) {
                                hVar = p(hVar, sparseArray, i2);
                                hVar.a = fragment;
                                hVar.f1684b = z;
                                hVar.f1685c = aVar;
                            }
                            if (!z2 && z7) {
                                if (hVar != null && hVar.f1686d == fragment) {
                                    hVar.f1686d = null;
                                }
                                if (!aVar.r) {
                                    FragmentManager fragmentManager = aVar.t;
                                    fragmentManager.u0().p(fragmentManager.w(fragment));
                                    fragmentManager.T0(fragment);
                                }
                            }
                            if (z5 && (hVar == null || hVar.f1686d == null)) {
                                hVar = p(hVar, sparseArray, i2);
                                hVar.f1686d = fragment;
                                hVar.f1687e = z;
                                hVar.f1688f = aVar;
                            }
                            if (z2 || !z4 || hVar == null || hVar.a != fragment) {
                                return;
                            }
                            hVar.a = null;
                            return;
                        }
                    }
                } else {
                    if (z2) {
                        if (fragment.mHiddenChanged) {
                            if (!fragment.mHidden) {
                            }
                        }
                        z3 = false;
                        z6 = z3;
                        z4 = false;
                        z5 = false;
                        hVar = sparseArray.get(i2);
                        if (z6) {
                        }
                        if (!z2) {
                            if (hVar != null) {
                                hVar.f1686d = null;
                            }
                            if (!aVar.r) {
                            }
                        }
                        if (z5) {
                            hVar = p(hVar, sparseArray, i2);
                            hVar.f1686d = fragment;
                            hVar.f1687e = z;
                            hVar.f1688f = aVar;
                        }
                        if (z2) {
                            return;
                        } else {
                            return;
                        }
                    }
                    z3 = fragment.mHidden;
                    z6 = z3;
                    z4 = false;
                    z5 = false;
                    hVar = sparseArray.get(i2);
                    if (z6) {
                    }
                    if (!z2) {
                    }
                    if (z5) {
                    }
                    if (z2) {
                    }
                }
            }
            if (!z2) {
            }
            z5 = z8;
            z4 = true;
            z7 = false;
            hVar = sparseArray.get(i2);
            if (z6) {
            }
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        }
        if (z2) {
            z3 = fragment.mIsNewlyAdded;
            z6 = z3;
            z4 = false;
            z5 = false;
            hVar = sparseArray.get(i2);
            if (z6) {
            }
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        } else {
            if (!fragment.mAdded) {
            }
            z3 = false;
            z6 = z3;
            z4 = false;
            z5 = false;
            hVar = sparseArray.get(i2);
            if (z6) {
            }
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        }
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z) {
        int size = aVar.f1641c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b(aVar, aVar.f1641c.get(i2), sparseArray, false, z);
        }
    }

    private static c.e.a<String, String> d(int i2, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        c.e.a<String, String> aVar = new c.e.a<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i5);
            if (aVar2.C(i2)) {
                boolean booleanValue = arrayList2.get(i5).booleanValue();
                ArrayList<String> arrayList5 = aVar2.p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.p;
                        arrayList4 = aVar2.q;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.p;
                        arrayList3 = aVar2.q;
                        arrayList4 = arrayList6;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = arrayList4.get(i6);
                        String str2 = arrayList3.get(i6);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z) {
        if (aVar.t.q0().d()) {
            for (int size = aVar.f1641c.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f1641c.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Fragment fragment, Fragment fragment2, boolean z, c.e.a<String, View> aVar, boolean z2) {
        androidx.core.app.o enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(aVar.j(i2));
                arrayList.add(aVar.n(i2));
            }
            if (z2) {
                throw null;
            }
            throw null;
        }
    }

    private static boolean g(x xVar, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!xVar.e(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    static c.e.a<String, View> h(x xVar, c.e.a<String, String> aVar, Object obj, h hVar) {
        androidx.core.app.o enterTransitionCallback;
        ArrayList<String> arrayList;
        Fragment fragment = hVar.a;
        View view = fragment.getView();
        if (!aVar.isEmpty() && obj != null && view != null) {
            c.e.a<String, View> aVar2 = new c.e.a<>();
            xVar.j(aVar2, view);
            androidx.fragment.app.a aVar3 = hVar.f1685c;
            if (hVar.f1684b) {
                enterTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = aVar3.p;
            } else {
                enterTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = aVar3.q;
            }
            if (arrayList != null) {
                aVar2.p(arrayList);
                aVar2.p(aVar.values());
            }
            if (enterTransitionCallback == null) {
                x(aVar, aVar2);
                return aVar2;
            }
            throw null;
        }
        aVar.clear();
        return null;
    }

    private static c.e.a<String, View> i(x xVar, c.e.a<String, String> aVar, Object obj, h hVar) {
        androidx.core.app.o exitTransitionCallback;
        ArrayList<String> arrayList;
        if (!aVar.isEmpty() && obj != null) {
            Fragment fragment = hVar.f1686d;
            c.e.a<String, View> aVar2 = new c.e.a<>();
            xVar.j(aVar2, fragment.requireView());
            androidx.fragment.app.a aVar3 = hVar.f1688f;
            if (hVar.f1687e) {
                exitTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = aVar3.q;
            } else {
                exitTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = aVar3.p;
            }
            if (arrayList != null) {
                aVar2.p(arrayList);
            }
            if (exitTransitionCallback == null) {
                aVar.p(aVar2.keySet());
                return aVar2;
            }
            throw null;
        }
        aVar.clear();
        return null;
    }

    private static x j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        x xVar = f1657b;
        if (xVar != null && g(xVar, arrayList)) {
            return xVar;
        }
        x xVar2 = f1658c;
        if (xVar2 != null && g(xVar2, arrayList)) {
            return xVar2;
        }
        if (xVar == null && xVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(x xVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            xVar.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        xVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(x xVar, ViewGroup viewGroup, View view, c.e.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object t;
        c.e.a<String, String> aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f1686d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f1684b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            t = null;
        } else {
            t = t(xVar, fragment, fragment2, z);
            aVar2 = aVar;
        }
        c.e.a<String, View> i2 = i(xVar, aVar2, t, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(i2.values());
            obj3 = t;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, i2, true);
        if (obj3 != null) {
            rect = new Rect();
            xVar.z(obj3, view, arrayList);
            z(xVar, obj3, obj2, i2, hVar.f1687e, hVar.f1688f);
            if (obj != null) {
                xVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        androidx.core.view.r.a(viewGroup, new f(xVar, aVar, obj3, hVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(x xVar, ViewGroup viewGroup, View view, c.e.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f1686d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f1684b;
        Object t = aVar.isEmpty() ? null : t(xVar, fragment, fragment2, z);
        c.e.a<String, View> i2 = i(xVar, aVar, t, hVar);
        c.e.a<String, View> h2 = h(xVar, aVar, t, hVar);
        if (aVar.isEmpty()) {
            if (i2 != null) {
                i2.clear();
            }
            if (h2 != null) {
                h2.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, i2, aVar.keySet());
            a(arrayList2, h2, aVar.values());
            obj3 = t;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, i2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            xVar.z(obj3, view, arrayList);
            z(xVar, obj3, obj2, i2, hVar.f1687e, hVar.f1688f);
            Rect rect2 = new Rect();
            View s = s(h2, hVar, obj, z);
            if (s != null) {
                xVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = s;
        } else {
            view2 = null;
            rect = null;
        }
        androidx.core.view.r.a(viewGroup, new e(fragment, fragment2, z, h2, view2, xVar, rect));
        return obj3;
    }

    private static void n(ViewGroup viewGroup, h hVar, View view, c.e.a<String, String> aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f1686d;
        x j2 = j(fragment2, fragment);
        if (j2 == null) {
            return;
        }
        boolean z = hVar.f1684b;
        boolean z2 = hVar.f1687e;
        Object q = q(j2, fragment, z);
        Object r = r(j2, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object l = l(j2, viewGroup, view, aVar, hVar, arrayList, arrayList2, q, r);
        if (q == null && l == null) {
            obj = r;
            if (obj == null) {
                return;
            }
        } else {
            obj = r;
        }
        ArrayList<View> k2 = k(j2, obj, fragment2, arrayList, view);
        if (k2 == null || k2.isEmpty()) {
            obj = null;
        }
        Object obj2 = obj;
        j2.a(q, view);
        Object u = u(j2, q, obj2, l, fragment, hVar.f1684b);
        if (fragment2 != null && k2 != null && (k2.size() > 0 || arrayList.size() > 0)) {
            androidx.core.os.b bVar = new androidx.core.os.b();
            gVar.b(fragment2, bVar);
            j2.w(fragment2, u, bVar, new c(gVar, fragment2, bVar));
        }
        if (u != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            j2.t(u, q, arrayList3, obj2, k2, l, arrayList2);
            y(j2, viewGroup, fragment, view, arrayList2, q, arrayList3, obj2, k2);
            j2.x(viewGroup, arrayList2, aVar);
            j2.c(viewGroup, u);
            j2.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(ViewGroup viewGroup, h hVar, View view, c.e.a<String, String> aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f1686d;
        x j2 = j(fragment2, fragment);
        if (j2 == null) {
            return;
        }
        boolean z = hVar.f1684b;
        boolean z2 = hVar.f1687e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object q = q(j2, fragment, z);
        Object r = r(j2, fragment2, z2);
        Object m = m(j2, viewGroup, view, aVar, hVar, arrayList2, arrayList, q, r);
        if (q == null && m == null) {
            obj = r;
            if (obj == null) {
                return;
            }
        } else {
            obj = r;
        }
        ArrayList<View> k2 = k(j2, obj, fragment2, arrayList2, view);
        ArrayList<View> k3 = k(j2, q, fragment, arrayList, view);
        A(k3, 4);
        Object u = u(j2, q, obj, m, fragment, z);
        if (fragment2 != null && k2 != null && (k2.size() > 0 || arrayList2.size() > 0)) {
            androidx.core.os.b bVar = new androidx.core.os.b();
            gVar.b(fragment2, bVar);
            j2.w(fragment2, u, bVar, new a(gVar, fragment2, bVar));
        }
        if (u != null) {
            v(j2, obj, fragment2, k2);
            ArrayList<String> o = j2.o(arrayList);
            j2.t(u, q, k3, obj, k2, m, arrayList);
            j2.c(viewGroup, u);
            j2.y(viewGroup, arrayList2, arrayList, o, aVar);
            A(k3, 0);
            j2.A(m, arrayList2, arrayList);
        }
    }

    private static h p(h hVar, SparseArray<h> sparseArray, int i2) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i2, hVar2);
        return hVar2;
    }

    private static Object q(x xVar, Fragment fragment, boolean z) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return xVar.g(enterTransition);
    }

    private static Object r(x xVar, Fragment fragment, boolean z) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return xVar.g(exitTransition);
    }

    static View s(c.e.a<String, View> aVar, h hVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        androidx.fragment.app.a aVar2 = hVar.f1685c;
        if (obj == null || aVar == null || (arrayList = aVar2.p) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar2.p.get(0);
        } else {
            str = aVar2.q.get(0);
        }
        return aVar.get(str);
    }

    private static Object t(x xVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return xVar.B(xVar.g(sharedElementEnterTransition));
    }

    private static Object u(x xVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.getAllowReturnTransitionOverlap();
        } else {
            z2 = fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return xVar.n(obj2, obj, obj3);
        }
        return xVar.m(obj2, obj, obj3);
    }

    private static void v(x xVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            xVar.r(obj, fragment.getView(), arrayList);
            androidx.core.view.r.a(fragment.mContainer, new b(arrayList));
        }
    }

    private static x w() {
        try {
            return (x) Class.forName("c.x.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void x(c.e.a<String, String> aVar, c.e.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.n(size))) {
                aVar.l(size);
            }
        }
    }

    private static void y(x xVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        androidx.core.view.r.a(viewGroup, new d(obj, xVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(x xVar, Object obj, Object obj2, c.e.a<String, View> aVar, boolean z, androidx.fragment.app.a aVar2) {
        String str;
        ArrayList<String> arrayList = aVar2.p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            str = aVar2.q.get(0);
        } else {
            str = aVar2.p.get(0);
        }
        View view = aVar.get(str);
        xVar.v(obj, view);
        if (obj2 != null) {
            xVar.v(obj2, view);
        }
    }
}
