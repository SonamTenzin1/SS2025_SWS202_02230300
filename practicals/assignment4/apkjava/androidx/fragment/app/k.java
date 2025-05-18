package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentLayoutInflaterFactory.java */
/* loaded from: classes.dex */
public class k implements LayoutInflater.Factory2 {

    /* renamed from: f, reason: collision with root package name */
    private final FragmentManager f1621f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FragmentManager fragmentManager) {
        this.f1621f = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        r w;
        if (g.class.getName().equals(str)) {
            return new g(context, attributeSet, this.f1621f);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.m.c.f3346d);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(c.m.c.f3347e);
        }
        int resourceId = obtainStyledAttributes.getResourceId(c.m.c.f3348f, -1);
        String string = obtainStyledAttributes.getString(c.m.c.f3349g);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !i.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment i0 = resourceId != -1 ? this.f1621f.i0(resourceId) : null;
        if (i0 == null && string != null) {
            i0 = this.f1621f.j0(string);
        }
        if (i0 == null && id != -1) {
            i0 = this.f1621f.i0(id);
        }
        if (i0 == null) {
            i0 = this.f1621f.t0().a(context.getClassLoader(), attributeValue);
            i0.mFromLayout = true;
            i0.mFragmentId = resourceId != 0 ? resourceId : id;
            i0.mContainerId = id;
            i0.mTag = string;
            i0.mInLayout = true;
            FragmentManager fragmentManager = this.f1621f;
            i0.mFragmentManager = fragmentManager;
            i0.mHost = fragmentManager.w0();
            i0.onInflate(this.f1621f.w0().f(), attributeSet, i0.mSavedFragmentState);
            w = this.f1621f.w(i0);
            this.f1621f.g(i0);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Fragment " + i0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else if (!i0.mInLayout) {
            i0.mInLayout = true;
            FragmentManager fragmentManager2 = this.f1621f;
            i0.mFragmentManager = fragmentManager2;
            i0.mHost = fragmentManager2.w0();
            i0.onInflate(this.f1621f.w0().f(), attributeSet, i0.mSavedFragmentState);
            w = this.f1621f.w(i0);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + i0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        i0.mContainer = (ViewGroup) view;
        w.m();
        w.j();
        View view2 = i0.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (i0.mView.getTag() == null) {
                i0.mView.setTag(string);
            }
            return i0.mView;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
