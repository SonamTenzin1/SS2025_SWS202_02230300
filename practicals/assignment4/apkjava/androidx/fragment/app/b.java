package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.b;
import androidx.fragment.app.a0;
import androidx.fragment.app.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
class b extends a0 {

    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a0.e.c.values().length];
            a = iArr;
            try {
                iArr[a0.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a0.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a0.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a0.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0035b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f1559f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ a0.e f1560g;

        RunnableC0035b(List list, a0.e eVar) {
            this.f1559f = list;
            this.f1560g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1559f.contains(this.f1560g)) {
                this.f1559f.remove(this.f1560g);
                b.this.s(this.f1560g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1562b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f1563c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a0.e f1564d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f1565e;

        c(ViewGroup viewGroup, View view, boolean z, a0.e eVar, k kVar) {
            this.a = viewGroup;
            this.f1562b = view;
            this.f1563c = z;
            this.f1564d = eVar;
            this.f1565e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.f1562b);
            if (this.f1563c) {
                this.f1564d.e().g(this.f1562b);
            }
            this.f1565e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class d implements b.a {
        final /* synthetic */ Animator a;

        d(Animator animator) {
            this.a = animator;
        }

        @Override // androidx.core.os.b.a
        public void onCancel() {
            this.a.end();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class e implements Animation.AnimationListener {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1568b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f1569c;

        /* compiled from: DefaultSpecialEffectsController.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.a.endViewTransition(eVar.f1568b);
                e.this.f1569c.a();
            }
        }

        e(ViewGroup viewGroup, View view, k kVar) {
            this.a = viewGroup;
            this.f1568b = view;
            this.f1569c = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class f implements b.a {
        final /* synthetic */ View a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1572b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f1573c;

        f(View view, ViewGroup viewGroup, k kVar) {
            this.a = view;
            this.f1572b = viewGroup;
            this.f1573c = kVar;
        }

        @Override // androidx.core.os.b.a
        public void onCancel() {
            this.a.clearAnimation();
            this.f1572b.endViewTransition(this.a);
            this.f1573c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0.e f1575f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ a0.e f1576g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f1577h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ c.e.a f1578i;

        g(a0.e eVar, a0.e eVar2, boolean z, c.e.a aVar) {
            this.f1575f = eVar;
            this.f1576g = eVar2;
            this.f1577h = z;
            this.f1578i = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.f(this.f1575f.f(), this.f1576g.f(), this.f1577h, this.f1578i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class h implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f1580f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f1581g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Rect f1582h;

        h(x xVar, View view, Rect rect) {
            this.f1580f = xVar;
            this.f1581g = view;
            this.f1582h = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1580f.k(this.f1581g, this.f1582h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1584f;

        i(ArrayList arrayList) {
            this.f1584f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.A(this.f1584f, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class j implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ m f1586f;

        j(m mVar) {
            this.f1586f = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1586f.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class k extends l {

        /* renamed from: c, reason: collision with root package name */
        private boolean f1588c;

        /* renamed from: d, reason: collision with root package name */
        private e.d f1589d;

        k(a0.e eVar, androidx.core.os.b bVar) {
            super(eVar, bVar);
            this.f1588c = false;
        }

        e.d e(Context context) {
            if (this.f1588c) {
                return this.f1589d;
            }
            e.d b2 = androidx.fragment.app.e.b(context, b().f(), b().e() == a0.e.c.VISIBLE);
            this.f1589d = b2;
            this.f1588c = true;
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class l {
        private final a0.e a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.os.b f1590b;

        l(a0.e eVar, androidx.core.os.b bVar) {
            this.a = eVar;
            this.f1590b = bVar;
        }

        void a() {
            this.a.d(this.f1590b);
        }

        a0.e b() {
            return this.a;
        }

        androidx.core.os.b c() {
            return this.f1590b;
        }

        boolean d() {
            a0.e.c cVar;
            a0.e.c q = a0.e.c.q(this.a.f().mView);
            a0.e.c e2 = this.a.e();
            return q == e2 || !(q == (cVar = a0.e.c.VISIBLE) || e2 == cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class m extends l {

        /* renamed from: c, reason: collision with root package name */
        private final Object f1591c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f1592d;

        /* renamed from: e, reason: collision with root package name */
        private final Object f1593e;

        m(a0.e eVar, androidx.core.os.b bVar, boolean z, boolean z2) {
            super(eVar, bVar);
            Object exitTransition;
            Object enterTransition;
            boolean allowEnterTransitionOverlap;
            if (eVar.e() == a0.e.c.VISIBLE) {
                if (z) {
                    enterTransition = eVar.f().getReenterTransition();
                } else {
                    enterTransition = eVar.f().getEnterTransition();
                }
                this.f1591c = enterTransition;
                if (z) {
                    allowEnterTransitionOverlap = eVar.f().getAllowReturnTransitionOverlap();
                } else {
                    allowEnterTransitionOverlap = eVar.f().getAllowEnterTransitionOverlap();
                }
                this.f1592d = allowEnterTransitionOverlap;
            } else {
                if (z) {
                    exitTransition = eVar.f().getReturnTransition();
                } else {
                    exitTransition = eVar.f().getExitTransition();
                }
                this.f1591c = exitTransition;
                this.f1592d = true;
            }
            if (!z2) {
                this.f1593e = null;
            } else if (z) {
                this.f1593e = eVar.f().getSharedElementReturnTransition();
            } else {
                this.f1593e = eVar.f().getSharedElementEnterTransition();
            }
        }

        private x f(Object obj) {
            if (obj == null) {
                return null;
            }
            x xVar = v.f1657b;
            if (xVar != null && xVar.e(obj)) {
                return xVar;
            }
            x xVar2 = v.f1658c;
            if (xVar2 != null && xVar2.e(obj)) {
                return xVar2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        x e() {
            x f2 = f(this.f1591c);
            x f3 = f(this.f1593e);
            if (f2 == null || f3 == null || f2 == f3) {
                return f2 != null ? f2 : f3;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f1591c + " which uses a different Transition  type than its shared element transition " + this.f1593e);
        }

        public Object g() {
            return this.f1593e;
        }

        Object h() {
            return this.f1591c;
        }

        public boolean i() {
            return this.f1593e != null;
        }

        boolean j() {
            return this.f1592d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List<k> list, List<a0.e> list2, boolean z, Map<a0.e, Boolean> map) {
        ViewGroup m2 = m();
        Context context = m2.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (k kVar : list) {
            if (kVar.d()) {
                kVar.a();
            } else {
                e.d e2 = kVar.e(context);
                if (e2 == null) {
                    kVar.a();
                } else {
                    Animator animator = e2.f1607b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        a0.e b2 = kVar.b();
                        Fragment f2 = b2.f();
                        if (Boolean.TRUE.equals(map.get(b2))) {
                            if (FragmentManager.H0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + f2 + " as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            boolean z3 = b2.e() == a0.e.c.GONE;
                            if (z3) {
                                list2.remove(b2);
                            }
                            View view = f2.mView;
                            m2.startViewTransition(view);
                            animator.addListener(new c(m2, view, z3, b2, kVar));
                            animator.setTarget(view);
                            animator.start();
                            kVar.c().c(new d(animator));
                            z2 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            k kVar2 = (k) it.next();
            a0.e b3 = kVar2.b();
            Fragment f3 = b3.f();
            if (z) {
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f3 + " as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z2) {
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f3 + " as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view2 = f3.mView;
                Animation animation = (Animation) c.i.j.i.c(((e.d) c.i.j.i.c(kVar2.e(context))).a);
                if (b3.e() != a0.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar2.a();
                } else {
                    m2.startViewTransition(view2);
                    e.RunnableC0037e runnableC0037e = new e.RunnableC0037e(animation, m2, view2);
                    runnableC0037e.setAnimationListener(new e(m2, view2, kVar2));
                    view2.startAnimation(runnableC0037e);
                }
                kVar2.c().c(new f(view2, m2, kVar2));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Map<a0.e, Boolean> x(List<m> list, boolean z, a0.e eVar, a0.e eVar2) {
        Iterator<m> it;
        View view;
        a0.e eVar3;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        a0.e eVar4;
        View view2;
        c.e.a aVar;
        ArrayList<View> arrayList3;
        a0.e eVar5;
        ArrayList<View> arrayList4;
        Rect rect;
        x xVar;
        a0.e eVar6;
        View view3;
        androidx.core.app.o enterTransitionCallback;
        androidx.core.app.o exitTransitionCallback;
        View view4;
        View view5;
        boolean z2 = z;
        a0.e eVar7 = eVar;
        a0.e eVar8 = eVar2;
        HashMap hashMap = new HashMap();
        x xVar2 = null;
        for (m mVar : list) {
            if (!mVar.d()) {
                x e2 = mVar.e();
                if (xVar2 == null) {
                    xVar2 = e2;
                } else if (e2 != null && xVar2 != e2) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (xVar2 == null) {
            for (m mVar2 : list) {
                hashMap.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return hashMap;
        }
        View view6 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayList<View> arrayList6 = new ArrayList<>();
        c.e.a aVar2 = new c.e.a();
        Object obj3 = null;
        View view7 = null;
        boolean z3 = false;
        for (m mVar3 : list) {
            if (!mVar3.i() || eVar7 == null || eVar8 == null) {
                aVar = aVar2;
                arrayList3 = arrayList6;
                eVar5 = eVar7;
                arrayList4 = arrayList5;
                rect = rect2;
                xVar = xVar2;
                eVar6 = eVar8;
                view3 = view6;
                view7 = view7;
            } else {
                Object B = xVar2.B(xVar2.g(mVar3.g()));
                ArrayList<String> sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                View view8 = view7;
                int i2 = 0;
                while (i2 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i2));
                    }
                    i2++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                if (!z2) {
                    enterTransitionCallback = eVar.f().getExitTransitionCallback();
                    exitTransitionCallback = eVar2.f().getEnterTransitionCallback();
                } else {
                    enterTransitionCallback = eVar.f().getEnterTransitionCallback();
                    exitTransitionCallback = eVar2.f().getExitTransitionCallback();
                }
                int i3 = 0;
                for (int size = sharedElementSourceNames.size(); i3 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i3), sharedElementTargetNames2.get(i3));
                    i3++;
                }
                c.e.a<String, View> aVar3 = new c.e.a<>();
                u(aVar3, eVar.f().mView);
                aVar3.p(sharedElementSourceNames);
                if (enterTransitionCallback == null) {
                    aVar2.p(aVar3.keySet());
                    c.e.a<String, View> aVar4 = new c.e.a<>();
                    u(aVar4, eVar2.f().mView);
                    aVar4.p(sharedElementTargetNames2);
                    aVar4.p(aVar2.values());
                    if (exitTransitionCallback == null) {
                        v.x(aVar2, aVar4);
                        v(aVar3, aVar2.keySet());
                        v(aVar4, aVar2.values());
                        if (aVar2.isEmpty()) {
                            arrayList5.clear();
                            arrayList6.clear();
                            eVar5 = eVar;
                            aVar = aVar2;
                            arrayList3 = arrayList6;
                            arrayList4 = arrayList5;
                            rect = rect2;
                            view3 = view6;
                            xVar = xVar2;
                            view7 = view8;
                            obj3 = null;
                            eVar6 = eVar2;
                        } else {
                            v.f(eVar2.f(), eVar.f(), z2, aVar3, true);
                            HashMap hashMap2 = hashMap;
                            View view9 = view6;
                            Rect rect3 = rect2;
                            aVar = aVar2;
                            ArrayList<View> arrayList8 = arrayList6;
                            androidx.core.view.r.a(m(), new g(eVar2, eVar, z, aVar4));
                            Iterator<View> it2 = aVar3.values().iterator();
                            while (it2.hasNext()) {
                                t(arrayList5, it2.next());
                            }
                            if (sharedElementSourceNames.isEmpty()) {
                                view7 = view8;
                            } else {
                                View view10 = (View) aVar3.get(sharedElementSourceNames.get(0));
                                xVar2.v(B, view10);
                                view7 = view10;
                            }
                            Iterator<View> it3 = aVar4.values().iterator();
                            while (it3.hasNext()) {
                                t(arrayList8, it3.next());
                            }
                            arrayList3 = arrayList8;
                            if (sharedElementTargetNames2.isEmpty() || (view5 = (View) aVar4.get(sharedElementTargetNames2.get(0))) == null) {
                                rect = rect3;
                                view4 = view9;
                            } else {
                                rect = rect3;
                                androidx.core.view.r.a(m(), new h(xVar2, view5, rect));
                                view4 = view9;
                                z3 = true;
                            }
                            xVar2.z(B, view4, arrayList5);
                            arrayList4 = arrayList5;
                            view3 = view4;
                            xVar = xVar2;
                            xVar2.t(B, null, null, null, null, B, arrayList3);
                            Boolean bool = Boolean.TRUE;
                            eVar5 = eVar;
                            hashMap = hashMap2;
                            hashMap.put(eVar5, bool);
                            eVar6 = eVar2;
                            hashMap.put(eVar6, bool);
                            obj3 = B;
                        }
                    } else {
                        throw null;
                    }
                } else {
                    throw null;
                }
            }
            z2 = z;
            eVar7 = eVar5;
            arrayList5 = arrayList4;
            rect2 = rect;
            view6 = view3;
            eVar8 = eVar6;
            aVar2 = aVar;
            arrayList6 = arrayList3;
            xVar2 = xVar;
        }
        View view11 = view7;
        c.e.a aVar5 = aVar2;
        ArrayList<View> arrayList9 = arrayList6;
        a0.e eVar9 = eVar7;
        ArrayList<View> arrayList10 = arrayList5;
        Rect rect4 = rect2;
        x xVar3 = xVar2;
        a0.e eVar10 = eVar8;
        View view12 = view6;
        ArrayList arrayList11 = new ArrayList();
        Iterator<m> it4 = list.iterator();
        Object obj4 = null;
        Object obj5 = null;
        while (it4.hasNext()) {
            m next = it4.next();
            if (next.d()) {
                hashMap.put(next.b(), Boolean.FALSE);
                next.a();
            } else {
                Object g2 = xVar3.g(next.h());
                a0.e b2 = next.b();
                boolean z4 = obj3 != null && (b2 == eVar9 || b2 == eVar10);
                if (g2 == null) {
                    if (!z4) {
                        hashMap.put(b2, Boolean.FALSE);
                        next.a();
                    }
                    arrayList2 = arrayList9;
                    arrayList = arrayList10;
                    it = it4;
                    view = view12;
                    eVar4 = eVar10;
                    view2 = view11;
                } else {
                    it = it4;
                    ArrayList<View> arrayList12 = new ArrayList<>();
                    Object obj6 = obj4;
                    t(arrayList12, b2.f().mView);
                    if (z4) {
                        if (b2 == eVar9) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        xVar3.a(g2, view12);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view12;
                        eVar3 = b2;
                        obj2 = obj5;
                        eVar4 = eVar10;
                        obj = obj6;
                    } else {
                        xVar3.b(g2, arrayList12);
                        view = view12;
                        eVar3 = b2;
                        obj = obj6;
                        arrayList = arrayList10;
                        obj2 = obj5;
                        arrayList2 = arrayList9;
                        eVar4 = eVar10;
                        xVar3.t(g2, g2, arrayList12, null, null, null, null);
                        if (eVar3.e() == a0.e.c.GONE) {
                            xVar3.r(g2, eVar3.f().mView, arrayList12);
                            androidx.core.view.r.a(m(), new i(arrayList12));
                        }
                    }
                    if (eVar3.e() == a0.e.c.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z3) {
                            xVar3.u(g2, rect4);
                        }
                        view2 = view11;
                    } else {
                        view2 = view11;
                        xVar3.v(g2, view2);
                    }
                    hashMap.put(eVar3, Boolean.TRUE);
                    if (next.j()) {
                        obj5 = xVar3.n(obj2, g2, null);
                        obj4 = obj;
                    } else {
                        obj5 = obj2;
                        obj4 = xVar3.n(obj, g2, null);
                    }
                }
                eVar10 = eVar4;
                view11 = view2;
                view12 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
                it4 = it;
            }
        }
        ArrayList<View> arrayList13 = arrayList9;
        ArrayList<View> arrayList14 = arrayList10;
        a0.e eVar11 = eVar10;
        Object m2 = xVar3.m(obj5, obj4, obj3);
        for (m mVar4 : list) {
            if (!mVar4.d()) {
                Object h2 = mVar4.h();
                a0.e b3 = mVar4.b();
                boolean z5 = obj3 != null && (b3 == eVar9 || b3 == eVar11);
                if (h2 != null || z5) {
                    xVar3.w(mVar4.b().f(), m2, mVar4.c(), new j(mVar4));
                }
            }
        }
        v.A(arrayList11, 4);
        ArrayList<String> o = xVar3.o(arrayList13);
        xVar3.c(m(), m2);
        xVar3.y(m(), arrayList14, arrayList13, o, aVar5);
        v.A(arrayList11, 0);
        xVar3.A(obj3, arrayList14, arrayList13);
        return hashMap;
    }

    @Override // androidx.fragment.app.a0
    void f(List<a0.e> list, boolean z) {
        a0.e eVar = null;
        a0.e eVar2 = null;
        for (a0.e eVar3 : list) {
            a0.e.c q = a0.e.c.q(eVar3.f().mView);
            int i2 = a.a[eVar3.e().ordinal()];
            if (i2 != 1 && i2 != 2 && i2 != 3) {
                if (i2 == 4 && q != a0.e.c.VISIBLE) {
                    eVar2 = eVar3;
                }
            } else if (q == a0.e.c.VISIBLE && eVar == null) {
                eVar = eVar3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        for (a0.e eVar4 : list) {
            androidx.core.os.b bVar = new androidx.core.os.b();
            eVar4.j(bVar);
            arrayList.add(new k(eVar4, bVar));
            androidx.core.os.b bVar2 = new androidx.core.os.b();
            eVar4.j(bVar2);
            boolean z2 = false;
            if (z) {
                if (eVar4 != eVar) {
                    arrayList2.add(new m(eVar4, bVar2, z, z2));
                    eVar4.a(new RunnableC0035b(arrayList3, eVar4));
                }
                z2 = true;
                arrayList2.add(new m(eVar4, bVar2, z, z2));
                eVar4.a(new RunnableC0035b(arrayList3, eVar4));
            } else {
                if (eVar4 != eVar2) {
                    arrayList2.add(new m(eVar4, bVar2, z, z2));
                    eVar4.a(new RunnableC0035b(arrayList3, eVar4));
                }
                z2 = true;
                arrayList2.add(new m(eVar4, bVar2, z, z2));
                eVar4.a(new RunnableC0035b(arrayList3, eVar4));
            }
        }
        Map<a0.e, Boolean> x = x(arrayList2, z, eVar, eVar2);
        w(arrayList, arrayList3, x.containsValue(Boolean.TRUE), x);
        Iterator<a0.e> it = arrayList3.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        arrayList3.clear();
    }

    void s(a0.e eVar) {
        eVar.e().g(eVar.f().mView);
    }

    void t(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (androidx.core.view.w.a(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    t(arrayList, childAt);
                }
            }
            return;
        }
        arrayList.add(view);
    }

    void u(Map<String, View> map, View view) {
        String G = androidx.core.view.u.G(view);
        if (G != null) {
            map.put(G, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(c.e.a<String, View> aVar, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(androidx.core.view.u.G(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
