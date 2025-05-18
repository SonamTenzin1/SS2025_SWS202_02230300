package c.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import c.x.a;
import c.x.m;

/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public abstract class j0 extends m {
    private static final String[] P = {"android:visibility:visibility", "android:visibility:parent"};
    private int Q = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public class a extends n {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3575b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3576c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.a = viewGroup;
            this.f3575b = view;
            this.f3576c = view2;
        }

        @Override // c.x.n, c.x.m.f
        public void b(m mVar) {
            x.a(this.a).d(this.f3575b);
        }

        @Override // c.x.m.f
        public void c(m mVar) {
            this.f3576c.setTag(j.f3572b, null);
            x.a(this.a).d(this.f3575b);
            mVar.T(this);
        }

        @Override // c.x.n, c.x.m.f
        public void e(m mVar) {
            if (this.f3575b.getParent() == null) {
                x.a(this.a).c(this.f3575b);
            } else {
                j0.this.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements m.f, a.InterfaceC0100a {
        private final View a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3578b;

        /* renamed from: c, reason: collision with root package name */
        private final ViewGroup f3579c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f3580d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f3581e;

        /* renamed from: f, reason: collision with root package name */
        boolean f3582f = false;

        b(View view, int i2, boolean z) {
            this.a = view;
            this.f3578b = i2;
            this.f3579c = (ViewGroup) view.getParent();
            this.f3580d = z;
            g(true);
        }

        private void f() {
            if (!this.f3582f) {
                c0.h(this.a, this.f3578b);
                ViewGroup viewGroup = this.f3579c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z) {
            ViewGroup viewGroup;
            if (!this.f3580d || this.f3581e == z || (viewGroup = this.f3579c) == null) {
                return;
            }
            this.f3581e = z;
            x.c(viewGroup, z);
        }

        @Override // c.x.m.f
        public void a(m mVar) {
        }

        @Override // c.x.m.f
        public void b(m mVar) {
            g(false);
        }

        @Override // c.x.m.f
        public void c(m mVar) {
            f();
            mVar.T(this);
        }

        @Override // c.x.m.f
        public void d(m mVar) {
        }

        @Override // c.x.m.f
        public void e(m mVar) {
            g(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3582f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, c.x.a.InterfaceC0100a
        public void onAnimationPause(Animator animator) {
            if (this.f3582f) {
                return;
            }
            c0.h(this.a, this.f3578b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, c.x.a.InterfaceC0100a
        public void onAnimationResume(Animator animator) {
            if (this.f3582f) {
                return;
            }
            c0.h(this.a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class c {
        boolean a;

        /* renamed from: b, reason: collision with root package name */
        boolean f3583b;

        /* renamed from: c, reason: collision with root package name */
        int f3584c;

        /* renamed from: d, reason: collision with root package name */
        int f3585d;

        /* renamed from: e, reason: collision with root package name */
        ViewGroup f3586e;

        /* renamed from: f, reason: collision with root package name */
        ViewGroup f3587f;

        c() {
        }
    }

    private void k0(s sVar) {
        sVar.a.put("android:visibility:visibility", Integer.valueOf(sVar.f3608b.getVisibility()));
        sVar.a.put("android:visibility:parent", sVar.f3608b.getParent());
        int[] iArr = new int[2];
        sVar.f3608b.getLocationOnScreen(iArr);
        sVar.a.put("android:visibility:screenLocation", iArr);
    }

    private c l0(s sVar, s sVar2) {
        c cVar = new c();
        cVar.a = false;
        cVar.f3583b = false;
        if (sVar != null && sVar.a.containsKey("android:visibility:visibility")) {
            cVar.f3584c = ((Integer) sVar.a.get("android:visibility:visibility")).intValue();
            cVar.f3586e = (ViewGroup) sVar.a.get("android:visibility:parent");
        } else {
            cVar.f3584c = -1;
            cVar.f3586e = null;
        }
        if (sVar2 != null && sVar2.a.containsKey("android:visibility:visibility")) {
            cVar.f3585d = ((Integer) sVar2.a.get("android:visibility:visibility")).intValue();
            cVar.f3587f = (ViewGroup) sVar2.a.get("android:visibility:parent");
        } else {
            cVar.f3585d = -1;
            cVar.f3587f = null;
        }
        if (sVar != null && sVar2 != null) {
            int i2 = cVar.f3584c;
            int i3 = cVar.f3585d;
            if (i2 == i3 && cVar.f3586e == cVar.f3587f) {
                return cVar;
            }
            if (i2 != i3) {
                if (i2 == 0) {
                    cVar.f3583b = false;
                    cVar.a = true;
                } else if (i3 == 0) {
                    cVar.f3583b = true;
                    cVar.a = true;
                }
            } else if (cVar.f3587f == null) {
                cVar.f3583b = false;
                cVar.a = true;
            } else if (cVar.f3586e == null) {
                cVar.f3583b = true;
                cVar.a = true;
            }
        } else if (sVar == null && cVar.f3585d == 0) {
            cVar.f3583b = true;
            cVar.a = true;
        } else if (sVar2 == null && cVar.f3584c == 0) {
            cVar.f3583b = false;
            cVar.a = true;
        }
        return cVar;
    }

    @Override // c.x.m
    public String[] H() {
        return P;
    }

    @Override // c.x.m
    public boolean J(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.a.containsKey("android:visibility:visibility") != sVar.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c l0 = l0(sVar, sVar2);
        if (l0.a) {
            return l0.f3584c == 0 || l0.f3585d == 0;
        }
        return false;
    }

    @Override // c.x.m
    public void h(s sVar) {
        k0(sVar);
    }

    @Override // c.x.m
    public void k(s sVar) {
        k0(sVar);
    }

    public abstract Animator m0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public Animator n0(ViewGroup viewGroup, s sVar, int i2, s sVar2, int i3) {
        if ((this.Q & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f3608b.getParent();
            if (l0(u(view, false), I(view, false)).a) {
                return null;
            }
        }
        return m0(viewGroup, sVar2.f3608b, sVar, sVar2);
    }

    @Override // c.x.m
    public Animator o(ViewGroup viewGroup, s sVar, s sVar2) {
        c l0 = l0(sVar, sVar2);
        if (!l0.a) {
            return null;
        }
        if (l0.f3586e == null && l0.f3587f == null) {
            return null;
        }
        if (l0.f3583b) {
            return n0(viewGroup, sVar, l0.f3584c, sVar2, l0.f3585d);
        }
        return q0(viewGroup, sVar, l0.f3584c, sVar2, l0.f3585d);
    }

    public abstract Animator o0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0089, code lost:
    
        if (r17.E != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator q0(ViewGroup viewGroup, s sVar, int i2, s sVar2, int i3) {
        View view;
        boolean z;
        boolean z2;
        View view2;
        if ((this.Q & 2) != 2 || sVar == null) {
            return null;
        }
        View view3 = sVar.f3608b;
        View view4 = sVar2 != null ? sVar2.f3608b : null;
        int i4 = j.f3572b;
        View view5 = (View) view3.getTag(i4);
        if (view5 != null) {
            view2 = null;
            z2 = true;
        } else if (view4 == null || view4.getParent() == null) {
            if (view4 != null) {
                view = null;
                z = false;
                if (z) {
                    if (view3.getParent() != null) {
                        if (view3.getParent() instanceof View) {
                            View view6 = (View) view3.getParent();
                            if (!l0(I(view6, true), u(view6, true)).a) {
                                view4 = r.a(viewGroup, view3, view6);
                            } else {
                                int id = view6.getId();
                                if (view6.getParent() == null) {
                                    if (id != -1) {
                                        if (viewGroup.findViewById(id) != null) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    view2 = view;
                    z2 = false;
                    view5 = view3;
                }
                z2 = false;
                View view7 = view;
                view5 = view4;
                view2 = view7;
            }
            view4 = null;
            view = null;
            z = true;
            if (z) {
            }
            z2 = false;
            View view72 = view;
            view5 = view4;
            view2 = view72;
        } else {
            if (i3 == 4 || view3 == view4) {
                view = view4;
                z = false;
                view4 = null;
                if (z) {
                }
                z2 = false;
                View view722 = view;
                view5 = view4;
                view2 = view722;
            }
            view4 = null;
            view = null;
            z = true;
            if (z) {
            }
            z2 = false;
            View view7222 = view;
            view5 = view4;
            view2 = view7222;
        }
        if (view5 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            c0.h(view2, 0);
            Animator o0 = o0(viewGroup, view2, sVar, sVar2);
            if (o0 != null) {
                b bVar = new b(view2, i3, true);
                o0.addListener(bVar);
                c.x.a.a(o0, bVar);
                b(bVar);
            } else {
                c0.h(view2, visibility);
            }
            return o0;
        }
        if (!z2) {
            int[] iArr = (int[]) sVar.a.get("android:visibility:screenLocation");
            int i5 = iArr[0];
            int i6 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view5.offsetLeftAndRight((i5 - iArr2[0]) - view5.getLeft());
            view5.offsetTopAndBottom((i6 - iArr2[1]) - view5.getTop());
            x.a(viewGroup).c(view5);
        }
        Animator o02 = o0(viewGroup, view5, sVar, sVar2);
        if (!z2) {
            if (o02 == null) {
                x.a(viewGroup).d(view5);
            } else {
                view3.setTag(i4, view5);
                b(new a(viewGroup, view5, view3));
            }
        }
        return o02;
    }

    public void r0(int i2) {
        if ((i2 & (-4)) == 0) {
            this.Q = i2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
}
