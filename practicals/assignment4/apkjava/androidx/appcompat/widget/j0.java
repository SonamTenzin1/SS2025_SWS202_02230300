package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.c0;

/* compiled from: ScrollingTabContainerView.java */
/* loaded from: classes.dex */
public class j0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: f, reason: collision with root package name */
    private static final Interpolator f548f = new DecelerateInterpolator();

    /* renamed from: g, reason: collision with root package name */
    Runnable f549g;

    /* renamed from: h, reason: collision with root package name */
    private c f550h;

    /* renamed from: i, reason: collision with root package name */
    c0 f551i;

    /* renamed from: j, reason: collision with root package name */
    private Spinner f552j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f553k;
    int l;
    int m;
    private int n;
    private int o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f554f;

        a(View view) {
            this.f554f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.smoothScrollTo(this.f554f.getLeft() - ((j0.this.getWidth() - this.f554f.getWidth()) / 2), 0);
            j0.this.f549g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return j0.this.f551i.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return ((d) j0.this.f551i.getChildAt(i2)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return j0.this.c((a.c) getItem(i2), true);
            }
            ((d) view).a((a.c) getItem(i2));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = j0.this.f551i.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = j0.this.f551i.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {

        /* renamed from: f, reason: collision with root package name */
        private final int[] f558f;

        /* renamed from: g, reason: collision with root package name */
        private a.c f559g;

        /* renamed from: h, reason: collision with root package name */
        private TextView f560h;

        /* renamed from: i, reason: collision with root package name */
        private ImageView f561i;

        /* renamed from: j, reason: collision with root package name */
        private View f562j;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d(Context context, a.c cVar, boolean z) {
            super(context, null, r5);
            int i2 = c.a.a.f2687d;
            int[] iArr = {R.attr.background};
            this.f558f = iArr;
            this.f559g = cVar;
            q0 v = q0.v(context, null, iArr, i2, 0);
            if (v.s(0)) {
                setBackgroundDrawable(v.g(0));
            }
            v.w();
            if (z) {
                setGravity(8388627);
            }
            c();
        }

        public void a(a.c cVar) {
            this.f559g = cVar;
            c();
        }

        public a.c b() {
            return this.f559g;
        }

        public void c() {
            a.c cVar = this.f559g;
            View b2 = cVar.b();
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.f562j = b2;
                TextView textView = this.f560h;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f561i;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f561i.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f562j;
            if (view != null) {
                removeView(view);
                this.f562j = null;
            }
            Drawable c2 = cVar.c();
            CharSequence d2 = cVar.d();
            if (c2 != null) {
                if (this.f561i == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f561i = appCompatImageView;
                }
                this.f561i.setImageDrawable(c2);
                this.f561i.setVisibility(0);
            } else {
                ImageView imageView2 = this.f561i;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f561i.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.f560h == null) {
                    t tVar = new t(getContext(), null, c.a.a.f2688e);
                    tVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    tVar.setLayoutParams(layoutParams2);
                    addView(tVar);
                    this.f560h = tVar;
                }
                this.f560h.setText(d2);
                this.f560h.setVisibility(0);
            } else {
                TextView textView2 = this.f560h;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f560h.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f561i;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            s0.a(this, z ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (j0.this.l > 0) {
                int measuredWidth = getMeasuredWidth();
                int i4 = j0.this.l;
                if (measuredWidth > i4) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, c.a.a.f2691h);
        appCompatSpinner.setLayoutParams(new c0.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private boolean d() {
        Spinner spinner = this.f552j;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f552j == null) {
            this.f552j = b();
        }
        removeView(this.f551i);
        addView(this.f552j, new ViewGroup.LayoutParams(-2, -1));
        if (this.f552j.getAdapter() == null) {
            this.f552j.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f549g;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f549g = null;
        }
        this.f552j.setSelection(this.o);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f552j);
        addView(this.f551i, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f552j.getSelectedItemPosition());
        return false;
    }

    public void a(int i2) {
        View childAt = this.f551i.getChildAt(i2);
        Runnable runnable = this.f549g;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f549g = aVar;
        post(aVar);
    }

    d c(a.c cVar, boolean z) {
        d dVar = new d(getContext(), cVar, z);
        if (z) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.n));
        } else {
            dVar.setFocusable(true);
            if (this.f550h == null) {
                this.f550h = new c();
            }
            dVar.setOnClickListener(this.f550h);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f549g;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c.a.o.a b2 = c.a.o.a.b(getContext());
        setContentHeight(b2.f());
        this.m = b2.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f549g;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f551i.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.l = (int) (View.MeasureSpec.getSize(i2) * 0.4f);
            } else {
                this.l = View.MeasureSpec.getSize(i2) / 2;
            }
            this.l = Math.min(this.l, this.m);
        } else {
            this.l = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.n, 1073741824);
        if (!z && this.f553k) {
            this.f551i.measure(0, makeMeasureSpec);
            if (this.f551i.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.o);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f553k = z;
    }

    public void setContentHeight(int i2) {
        this.n = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.o = i2;
        int childCount = this.f551i.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.f551i.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.f552j;
        if (spinner == null || i2 < 0) {
            return;
        }
        spinner.setSelection(i2);
    }
}
