package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.b;
import androidx.fragment.app.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentAnim.java */
/* loaded from: classes.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentAnim.java */
    /* loaded from: classes.dex */
    public class a implements b.a {
        final /* synthetic */ Fragment a;

        a(Fragment fragment) {
            this.a = fragment;
        }

        @Override // androidx.core.os.b.a
        public void onCancel() {
            if (this.a.getAnimatingAway() != null) {
                View animatingAway = this.a.getAnimatingAway();
                this.a.setAnimatingAway(null);
                animatingAway.clearAnimation();
            }
            this.a.setAnimator(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentAnim.java */
    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f1599b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ v.g f1600c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.b f1601d;

        /* compiled from: FragmentAnim.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f1599b.getAnimatingAway() != null) {
                    b.this.f1599b.setAnimatingAway(null);
                    b bVar = b.this;
                    bVar.f1600c.a(bVar.f1599b, bVar.f1601d);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, v.g gVar, androidx.core.os.b bVar) {
            this.a = viewGroup;
            this.f1599b = fragment;
            this.f1600c = gVar;
            this.f1601d = bVar;
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
    /* compiled from: FragmentAnim.java */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1603b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f1604c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ v.g f1605d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.b f1606e;

        c(ViewGroup viewGroup, View view, Fragment fragment, v.g gVar, androidx.core.os.b bVar) {
            this.a = viewGroup;
            this.f1603b = view;
            this.f1604c = fragment;
            this.f1605d = gVar;
            this.f1606e = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.f1603b);
            Animator animator2 = this.f1604c.getAnimator();
            this.f1604c.setAnimator(null);
            if (animator2 == null || this.a.indexOfChild(this.f1603b) >= 0) {
                return;
            }
            this.f1605d.a(this.f1604c, this.f1606e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Fragment fragment, d dVar, v.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        androidx.core.os.b bVar = new androidx.core.os.b();
        bVar.c(new a(fragment));
        gVar.b(fragment, bVar);
        if (dVar.a != null) {
            RunnableC0037e runnableC0037e = new RunnableC0037e(dVar.a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            runnableC0037e.setAnimationListener(new b(viewGroup, fragment, gVar, bVar));
            fragment.mView.startAnimation(runnableC0037e);
            return;
        }
        Animator animator = dVar.f1607b;
        fragment.setAnimator(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, bVar));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b(Context context, Fragment fragment, boolean z) {
        int nextTransition = fragment.getNextTransition();
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i2 = c.m.b.f3343c;
            if (viewGroup.getTag(i2) != null) {
                fragment.mContainer.setTag(i2, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, nextAnim);
        if (onCreateAnimation != null) {
            return new d(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, nextAnim);
        if (onCreateAnimator != null) {
            return new d(onCreateAnimator);
        }
        if (nextAnim == 0 && nextTransition != 0) {
            nextAnim = c(nextTransition, z);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                    if (loadAnimation != null) {
                        return new d(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                    if (loadAnimator != null) {
                        return new d(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                        if (loadAnimation2 != null) {
                            return new d(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        return null;
    }

    private static int c(int i2, boolean z) {
        if (i2 == 4097) {
            return z ? c.m.a.f3340e : c.m.a.f3341f;
        }
        if (i2 == 4099) {
            return z ? c.m.a.f3338c : c.m.a.f3339d;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z ? c.m.a.a : c.m.a.f3337b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentAnim.java */
    /* loaded from: classes.dex */
    public static class d {
        public final Animation a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f1607b;

        d(Animation animation) {
            this.a = animation;
            this.f1607b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        d(Animator animator) {
            this.a = null;
            this.f1607b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentAnim.java */
    /* renamed from: androidx.fragment.app.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0037e extends AnimationSet implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final ViewGroup f1608f;

        /* renamed from: g, reason: collision with root package name */
        private final View f1609g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f1610h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f1611i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f1612j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RunnableC0037e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1612j = true;
            this.f1608f = viewGroup;
            this.f1609g = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j2, Transformation transformation) {
            this.f1612j = true;
            if (this.f1610h) {
                return !this.f1611i;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f1610h = true;
                androidx.core.view.r.a(this.f1608f, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f1610h && this.f1612j) {
                this.f1612j = false;
                this.f1608f.post(this);
            } else {
                this.f1608f.endViewTransition(this.f1609g);
                this.f1611i = true;
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.f1612j = true;
            if (this.f1610h) {
                return !this.f1611i;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f1610h = true;
                androidx.core.view.r.a(this.f1608f, this);
            }
            return true;
        }
    }
}
