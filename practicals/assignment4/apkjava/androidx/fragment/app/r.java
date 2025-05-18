package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.a0;
import androidx.lifecycle.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentStateManager.java */
/* loaded from: classes.dex */
public class r {
    private final l a;

    /* renamed from: b, reason: collision with root package name */
    private final t f1632b;

    /* renamed from: c, reason: collision with root package name */
    private final Fragment f1633c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1634d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f1635e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentStateManager.java */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f1636f;

        a(View view) {
            this.f1636f = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f1636f.removeOnAttachStateChangeListener(this);
            androidx.core.view.u.f0(this.f1636f);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentStateManager.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.c.values().length];
            a = iArr;
            try {
                iArr[g.c.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[g.c.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[g.c.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, t tVar, Fragment fragment) {
        this.a = lVar;
        this.f1632b = tVar;
        this.f1633c = fragment;
    }

    private boolean l(View view) {
        if (view == this.f1633c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f1633c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f1633c.performSaveInstanceState(bundle);
        this.a.j(this.f1633c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f1633c.mView != null) {
            t();
        }
        if (this.f1633c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f1633c.mSavedViewState);
        }
        if (this.f1633c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f1633c.mSavedViewRegistryState);
        }
        if (!this.f1633c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f1633c.mUserVisibleHint);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        l lVar = this.a;
        Fragment fragment2 = this.f1633c;
        lVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int j2 = this.f1632b.j(this.f1633c);
        Fragment fragment = this.f1633c;
        fragment.mContainer.addView(fragment.mView, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        Fragment fragment2 = fragment.mTarget;
        r rVar = null;
        if (fragment2 != null) {
            r m = this.f1632b.m(fragment2.mWho);
            if (m != null) {
                Fragment fragment3 = this.f1633c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                rVar = m;
            } else {
                throw new IllegalStateException("Fragment " + this.f1633c + " declared target fragment " + this.f1633c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (rVar = this.f1632b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f1633c + " declared target fragment " + this.f1633c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (rVar != null && (FragmentManager.f1494b || rVar.k().mState < 1)) {
            rVar.m();
        }
        Fragment fragment4 = this.f1633c;
        fragment4.mHost = fragment4.mFragmentManager.w0();
        Fragment fragment5 = this.f1633c;
        fragment5.mParentFragment = fragment5.mFragmentManager.z0();
        this.a.g(this.f1633c, false);
        this.f1633c.performAttach();
        this.a.b(this.f1633c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f1633c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i2 = this.f1635e;
        int i3 = b.a[fragment2.mMaxState.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = Math.min(i2, 5);
            } else if (i3 == 3) {
                i2 = Math.min(i2, 1);
            } else if (i3 != 4) {
                i2 = Math.min(i2, -1);
            } else {
                i2 = Math.min(i2, 0);
            }
        }
        Fragment fragment3 = this.f1633c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i2 = Math.max(this.f1635e, 2);
                View view = this.f1633c.mView;
                if (view != null && view.getParent() == null) {
                    i2 = Math.min(i2, 2);
                }
            } else {
                i2 = this.f1635e < 4 ? Math.min(i2, fragment3.mState) : Math.min(i2, 1);
            }
        }
        if (!this.f1633c.mAdded) {
            i2 = Math.min(i2, 1);
        }
        a0.e.b bVar = null;
        if (FragmentManager.f1494b && (viewGroup = (fragment = this.f1633c).mContainer) != null) {
            bVar = a0.n(viewGroup, fragment.getParentFragmentManager()).l(this);
        }
        if (bVar == a0.e.b.ADDING) {
            i2 = Math.min(i2, 6);
        } else if (bVar == a0.e.b.REMOVING) {
            i2 = Math.max(i2, 3);
        } else {
            Fragment fragment4 = this.f1633c;
            if (fragment4.mRemoving) {
                if (fragment4.isInBackStack()) {
                    i2 = Math.min(i2, 1);
                } else {
                    i2 = Math.min(i2, -1);
                }
            }
        }
        Fragment fragment5 = this.f1633c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i2 = Math.min(i2, 4);
        }
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i2 + " for " + this.f1633c);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        if (!fragment.mIsCreated) {
            this.a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f1633c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            l lVar = this.a;
            Fragment fragment3 = this.f1633c;
            lVar.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.f1633c.mState = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        String str;
        if (this.f1633c.mFromLayout) {
            return;
        }
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = null;
        Fragment fragment2 = this.f1633c;
        ViewGroup viewGroup2 = fragment2.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i2 = fragment2.mContainerId;
            if (i2 != 0) {
                if (i2 != -1) {
                    viewGroup = (ViewGroup) fragment2.mFragmentManager.q0().c(this.f1633c.mContainerId);
                    if (viewGroup == null) {
                        Fragment fragment3 = this.f1633c;
                        if (!fragment3.mRestored) {
                            try {
                                str = fragment3.getResources().getResourceName(this.f1633c.mContainerId);
                            } catch (Resources.NotFoundException unused) {
                                str = "unknown";
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f1633c.mContainerId) + " (" + str + ") for fragment " + this.f1633c);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f1633c + " for a container view with no id");
                }
            }
        }
        Fragment fragment4 = this.f1633c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f1633c.mView;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f1633c;
            fragment5.mView.setTag(c.m.b.a, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f1633c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (androidx.core.view.u.N(this.f1633c.mView)) {
                androidx.core.view.u.f0(this.f1633c.mView);
            } else {
                View view2 = this.f1633c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f1633c.performViewCreated();
            l lVar = this.a;
            Fragment fragment7 = this.f1633c;
            lVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f1633c.mView.getVisibility();
            float alpha = this.f1633c.mView.getAlpha();
            if (FragmentManager.f1494b) {
                this.f1633c.setPostOnViewCreatedAlpha(alpha);
                Fragment fragment8 = this.f1633c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.f1633c.setFocusedView(findFocus);
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f1633c);
                        }
                    }
                    this.f1633c.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.f1633c;
                if (visibility == 0 && fragment9.mContainer != null) {
                    z = true;
                }
                fragment9.mIsNewlyAdded = z;
            }
        }
        this.f1633c.mState = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        Fragment f2;
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        boolean z = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (z2 || this.f1632b.o().p(this.f1633c)) {
            j<?> jVar = this.f1633c.mHost;
            if (jVar instanceof androidx.lifecycle.a0) {
                z = this.f1632b.o().m();
            } else if (jVar.f() instanceof Activity) {
                z = true ^ ((Activity) jVar.f()).isChangingConfigurations();
            }
            if (z2 || z) {
                this.f1632b.o().g(this.f1633c);
            }
            this.f1633c.performDestroy();
            this.a.d(this.f1633c, false);
            for (r rVar : this.f1632b.k()) {
                if (rVar != null) {
                    Fragment k2 = rVar.k();
                    if (this.f1633c.mWho.equals(k2.mTargetWho)) {
                        k2.mTarget = this.f1633c;
                        k2.mTargetWho = null;
                    }
                }
            }
            Fragment fragment2 = this.f1633c;
            String str = fragment2.mTargetWho;
            if (str != null) {
                fragment2.mTarget = this.f1632b.f(str);
            }
            this.f1632b.q(this);
            return;
        }
        String str2 = this.f1633c.mTargetWho;
        if (str2 != null && (f2 = this.f1632b.f(str2)) != null && f2.mRetainInstance) {
            this.f1633c.mTarget = f2;
        }
        this.f1633c.mState = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        View view;
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f1633c.performDestroyView();
        this.a.n(this.f1633c, false);
        Fragment fragment2 = this.f1633c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.n(null);
        this.f1633c.mInLayout = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f1633c);
        }
        this.f1633c.performDetach();
        boolean z = false;
        this.a.e(this.f1633c, false);
        Fragment fragment = this.f1633c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z = true;
        }
        if (z || this.f1632b.o().p(this.f1633c)) {
            if (FragmentManager.H0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f1633c);
            }
            this.f1633c.initState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        Fragment fragment = this.f1633c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.H0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1633c);
            }
            Fragment fragment2 = this.f1633c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f1633c.mSavedFragmentState);
            View view = this.f1633c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f1633c;
                fragment3.mView.setTag(c.m.b.a, fragment3);
                Fragment fragment4 = this.f1633c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f1633c.performViewCreated();
                l lVar = this.a;
                Fragment fragment5 = this.f1633c;
                lVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f1633c.mState = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment k() {
        return this.f1633c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f1634d) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f1634d = true;
            while (true) {
                int d2 = d();
                Fragment fragment = this.f1633c;
                int i2 = fragment.mState;
                if (d2 == i2) {
                    if (FragmentManager.f1494b && fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            a0 n = a0.n(viewGroup, fragment.getParentFragmentManager());
                            if (this.f1633c.mHidden) {
                                n.c(this);
                            } else {
                                n.e(this);
                            }
                        }
                        Fragment fragment2 = this.f1633c;
                        fragment2.mHiddenChanged = false;
                        fragment2.onHiddenChanged(fragment2.mHidden);
                    }
                    return;
                }
                if (d2 > i2) {
                    switch (i2 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                a0.n(viewGroup2, fragment.getParentFragmentManager()).b(a0.e.c.k(this.f1633c.mView.getVisibility()), this);
                            }
                            this.f1633c.mState = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                } else {
                    switch (i2 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            this.f1633c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (FragmentManager.H0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f1633c);
                            }
                            Fragment fragment3 = this.f1633c;
                            if (fragment3.mView != null && fragment3.mSavedViewState == null) {
                                t();
                            }
                            Fragment fragment4 = this.f1633c;
                            if (fragment4.mView != null && (viewGroup3 = fragment4.mContainer) != null) {
                                a0.n(viewGroup3, fragment4.getParentFragmentManager()).d(this);
                            }
                            this.f1633c.mState = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                }
            }
        } finally {
            this.f1634d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f1633c);
        }
        this.f1633c.performPause();
        this.a.f(this.f1633c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f1633c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f1633c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f1633c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f1633c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.f1633c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f1633c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f1633c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f1633c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f1633c);
        }
        View focusedView = this.f1633c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f1633c);
                sb.append(" resulting in focused view ");
                sb.append(this.f1633c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f1633c.setFocusedView(null);
        this.f1633c.performResume();
        this.a.i(this.f1633c, false);
        Fragment fragment = this.f1633c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment.SavedState r() {
        Bundle q;
        if (this.f1633c.mState <= -1 || (q = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState s() {
        FragmentState fragmentState = new FragmentState(this.f1633c);
        Fragment fragment = this.f1633c;
        if (fragment.mState > -1 && fragmentState.r == null) {
            Bundle q = q();
            fragmentState.r = q;
            if (this.f1633c.mTargetWho != null) {
                if (q == null) {
                    fragmentState.r = new Bundle();
                }
                fragmentState.r.putString("android:target_state", this.f1633c.mTargetWho);
                int i2 = this.f1633c.mTargetRequestCode;
                if (i2 != 0) {
                    fragmentState.r.putInt("android:target_req_state", i2);
                }
            }
        } else {
            fragmentState.r = fragment.mSavedFragmentState;
        }
        return fragmentState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        if (this.f1633c.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f1633c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f1633c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f1633c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f1633c.mSavedViewRegistryState = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i2) {
        this.f1635e = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f1633c);
        }
        this.f1633c.performStart();
        this.a.k(this.f1633c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f1633c);
        }
        this.f1633c.performStop();
        this.a.l(this.f1633c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, t tVar, ClassLoader classLoader, i iVar, FragmentState fragmentState) {
        this.a = lVar;
        this.f1632b = tVar;
        Fragment a2 = iVar.a(classLoader, fragmentState.f1528f);
        this.f1633c = a2;
        Bundle bundle = fragmentState.o;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.setArguments(fragmentState.o);
        a2.mWho = fragmentState.f1529g;
        a2.mFromLayout = fragmentState.f1530h;
        a2.mRestored = true;
        a2.mFragmentId = fragmentState.f1531i;
        a2.mContainerId = fragmentState.f1532j;
        a2.mTag = fragmentState.f1533k;
        a2.mRetainInstance = fragmentState.l;
        a2.mRemoving = fragmentState.m;
        a2.mDetached = fragmentState.n;
        a2.mHidden = fragmentState.p;
        a2.mMaxState = g.c.values()[fragmentState.q];
        Bundle bundle2 = fragmentState.r;
        if (bundle2 != null) {
            a2.mSavedFragmentState = bundle2;
        } else {
            a2.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, t tVar, Fragment fragment, FragmentState fragmentState) {
        this.a = lVar;
        this.f1632b = tVar;
        this.f1633c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.r;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
