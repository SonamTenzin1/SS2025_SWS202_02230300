package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.e.b.c.f;
import e.e.b.c.m.h;
import e.e.b.c.m.i;
import e.e.b.c.m.j;
import e.e.b.c.p.d;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    private final Rect f18830c;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f18831d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f18832e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f18833f;

    /* renamed from: g, reason: collision with root package name */
    private float f18834g;

    /* renamed from: h, reason: collision with root package name */
    private float f18835h;

    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f18836b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f18837c;

        a(boolean z, View view, View view2) {
            this.a = z;
            this.f18836b = view;
            this.f18837c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            this.f18836b.setVisibility(4);
            this.f18837c.setAlpha(1.0f);
            this.f18837c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.f18836b.setVisibility(0);
                this.f18837c.setAlpha(0.0f);
                this.f18837c.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        final /* synthetic */ e.e.b.c.p.d a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Drawable f18840b;

        c(e.e.b.c.p.d dVar, Drawable drawable) {
            this.a = dVar;
            this.f18840b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(this.f18840b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {
        final /* synthetic */ e.e.b.c.p.d a;

        d(e.e.b.c.p.d dVar) {
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.e revealInfo = this.a.getRevealInfo();
            revealInfo.f21070c = Float.MAX_VALUE;
            this.a.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class e {
        public h a;

        /* renamed from: b, reason: collision with root package name */
        public j f18843b;
    }

    public FabTransformationBehavior() {
        this.f18830c = new Rect();
        this.f18831d = new RectF();
        this.f18832e = new RectF();
        this.f18833f = new int[2];
    }

    private ViewGroup K(View view) {
        View findViewById = view.findViewById(f.u);
        if (findViewById != null) {
            return f0(findViewById);
        }
        if (!(view instanceof com.google.android.material.transformation.b) && !(view instanceof com.google.android.material.transformation.a)) {
            return f0(view);
        }
        return f0(((ViewGroup) view).getChildAt(0));
    }

    private void L(View view, e eVar, i iVar, i iVar2, float f2, float f3, float f4, float f5, RectF rectF) {
        float S = S(eVar, iVar, f2, f4);
        float S2 = S(eVar, iVar2, f3, f5);
        Rect rect = this.f18830c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f18831d;
        rectF2.set(rect);
        RectF rectF3 = this.f18832e;
        T(view, rectF3);
        rectF3.offset(S, S2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void M(View view, RectF rectF) {
        T(view, rectF);
        rectF.offset(this.f18834g, this.f18835h);
    }

    private Pair<i, i> N(float f2, float f3, boolean z, e eVar) {
        i e2;
        i e3;
        if (f2 == 0.0f || f3 == 0.0f) {
            e2 = eVar.a.e("translationXLinear");
            e3 = eVar.a.e("translationYLinear");
        } else if ((z && f3 < 0.0f) || (!z && f3 > 0.0f)) {
            e2 = eVar.a.e("translationXCurveUpwards");
            e3 = eVar.a.e("translationYCurveUpwards");
        } else {
            e2 = eVar.a.e("translationXCurveDownwards");
            e3 = eVar.a.e("translationYCurveDownwards");
        }
        return new Pair<>(e2, e3);
    }

    private float O(View view, View view2, j jVar) {
        RectF rectF = this.f18831d;
        RectF rectF2 = this.f18832e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(-Q(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float P(View view, View view2, j jVar) {
        RectF rectF = this.f18831d;
        RectF rectF2 = this.f18832e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(0.0f, -R(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float Q(View view, View view2, j jVar) {
        float centerX;
        float centerX2;
        float f2;
        RectF rectF = this.f18831d;
        RectF rectF2 = this.f18832e;
        M(view, rectF);
        T(view2, rectF2);
        int i2 = jVar.a & 7;
        if (i2 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i2 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else if (i2 == 5) {
            centerX = rectF2.right;
            centerX2 = rectF.right;
        } else {
            f2 = 0.0f;
            return f2 + jVar.f21062b;
        }
        f2 = centerX - centerX2;
        return f2 + jVar.f21062b;
    }

    private float R(View view, View view2, j jVar) {
        float centerY;
        float centerY2;
        float f2;
        RectF rectF = this.f18831d;
        RectF rectF2 = this.f18832e;
        M(view, rectF);
        T(view2, rectF2);
        int i2 = jVar.a & 112;
        if (i2 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i2 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else if (i2 == 80) {
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        } else {
            f2 = 0.0f;
            return f2 + jVar.f21063c;
        }
        f2 = centerY - centerY2;
        return f2 + jVar.f21063c;
    }

    private float S(e eVar, i iVar, float f2, float f3) {
        long c2 = iVar.c();
        long d2 = iVar.d();
        i e2 = eVar.a.e("expansion");
        return e.e.b.c.m.a.a(f2, f3, iVar.e().getInterpolation(((float) (((e2.c() + e2.d()) + 17) - c2)) / ((float) d2)));
    }

    private void T(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f18833f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void U(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup K;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof e.e.b.c.p.d) && e.e.b.c.p.c.a == 0) || (K = K(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    e.e.b.c.m.d.a.set(K, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(K, e.e.b.c.m.d.a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(K, e.e.b.c.m.d.a, 0.0f);
            }
            eVar.a.e("contentFade").a(ofFloat);
            list.add(ofFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof e.e.b.c.p.d) {
            e.e.b.c.p.d dVar = (e.e.b.c.p.d) view2;
            int d0 = d0(view);
            int i2 = 16777215 & d0;
            if (z) {
                if (!z2) {
                    dVar.setCircularRevealScrimColor(d0);
                }
                ofInt = ObjectAnimator.ofInt(dVar, d.C0261d.a, i2);
            } else {
                ofInt = ObjectAnimator.ofInt(dVar, d.C0261d.a, d0);
            }
            ofInt.setEvaluator(e.e.b.c.m.c.b());
            eVar.a.e("color").a(ofInt);
            list.add(ofInt);
        }
    }

    private void W(View view, View view2, boolean z, e eVar, List<Animator> list) {
        float Q = Q(view, view2, eVar.f18843b);
        float R = R(view, view2, eVar.f18843b);
        Pair<i, i> N = N(Q, R, z, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            Q = this.f18834g;
        }
        fArr[0] = Q;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            R = this.f18835h;
        }
        fArr2[0] = R;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void X(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float t = u.t(view2) - u.t(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-t);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -t);
        }
        eVar.a.e("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y(View view, View view2, boolean z, boolean z2, e eVar, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof e.e.b.c.p.d) {
            e.e.b.c.p.d dVar = (e.e.b.c.p.d) view2;
            float O = O(view, view2, eVar.f18843b);
            float P = P(view, view2, eVar.f18843b);
            ((FloatingActionButton) view).i(this.f18830c);
            float width = this.f18830c.width() / 2.0f;
            i e2 = eVar.a.e("expansion");
            if (z) {
                if (!z2) {
                    dVar.setRevealInfo(new d.e(O, P, width));
                }
                if (z2) {
                    width = dVar.getRevealInfo().f21070c;
                }
                animator = e.e.b.c.p.a.a(dVar, O, P, e.e.b.c.v.a.b(O, P, 0.0f, 0.0f, f2, f3));
                animator.addListener(new d(dVar));
                b0(view2, e2.c(), (int) O, (int) P, width, list);
            } else {
                float f4 = dVar.getRevealInfo().f21070c;
                Animator a2 = e.e.b.c.p.a.a(dVar, O, P, width);
                int i2 = (int) O;
                int i3 = (int) P;
                b0(view2, e2.c(), i2, i3, f4, list);
                a0(view2, e2.c(), e2.d(), eVar.a.f(), i2, i3, width, list);
                animator = a2;
            }
            e2.a(animator);
            list.add(animator);
            list2.add(e.e.b.c.p.a.b(dVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Z(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof e.e.b.c.p.d) && (view instanceof ImageView)) {
            e.e.b.c.p.d dVar = (e.e.b.c.p.d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, e.e.b.c.m.e.a, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, e.e.b.c.m.e.a, 255);
            }
            ofInt.addUpdateListener(new b(view2));
            eVar.a.e("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(dVar, drawable));
        }
    }

    private void a0(View view, long j2, long j3, long j4, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j5 = j2 + j3;
            if (j5 < j4) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                createCircularReveal.setStartDelay(j5);
                createCircularReveal.setDuration(j4 - j5);
                list.add(createCircularReveal);
            }
        }
    }

    private void b0(View view, long j2, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j2 <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j2);
        list.add(createCircularReveal);
    }

    private void c0(View view, View view2, boolean z, boolean z2, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float Q = Q(view, view2, eVar.f18843b);
        float R = R(view, view2, eVar.f18843b);
        Pair<i, i> N = N(Q, R, z, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-Q);
                view2.setTranslationY(-R);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            L(view2, eVar, iVar, iVar2, -Q, -R, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -Q);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -R);
        }
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private int d0(View view) {
        ColorStateList p = u.p(view);
        if (p != null) {
            return p.getColorForState(view.getDrawableState(), p.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet J(View view, View view2, boolean z, boolean z2) {
        e e0 = e0(view2.getContext(), z);
        if (z) {
            this.f18834g = view.getTranslationX();
            this.f18835h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            X(view, view2, z, z2, e0, arrayList, arrayList2);
        }
        RectF rectF = this.f18831d;
        c0(view, view2, z, z2, e0, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        W(view, view2, z, e0, arrayList);
        Z(view, view2, z, z2, e0, arrayList, arrayList2);
        Y(view, view2, z, z2, e0, width, height, arrayList, arrayList2);
        V(view, view2, z, z2, e0, arrayList, arrayList2);
        U(view, view2, z, z2, e0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        e.e.b.c.m.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z, view2, view));
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener(arrayList2.get(i2));
        }
        return animatorSet;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            if (!(view2 instanceof FloatingActionButton)) {
                return false;
            }
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    protected abstract e e0(Context context, boolean z);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        if (fVar.f826h == 0) {
            fVar.f826h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18830c = new Rect();
        this.f18831d = new RectF();
        this.f18832e = new RectF();
        this.f18833f = new int[2];
    }
}
