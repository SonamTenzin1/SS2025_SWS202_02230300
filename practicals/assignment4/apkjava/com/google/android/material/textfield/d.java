package com.google.android.material.textfield;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.u;
import com.google.android.material.textfield.TextInputLayout;
import e.e.b.c.a0.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DropdownMenuEndIconDelegate.java */
/* loaded from: classes2.dex */
public class d extends com.google.android.material.textfield.e {

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f18783d;

    /* renamed from: e, reason: collision with root package name */
    private final TextWatcher f18784e;

    /* renamed from: f, reason: collision with root package name */
    private final View.OnFocusChangeListener f18785f;

    /* renamed from: g, reason: collision with root package name */
    private final TextInputLayout.e f18786g;

    /* renamed from: h, reason: collision with root package name */
    private final TextInputLayout.f f18787h;

    /* renamed from: i, reason: collision with root package name */
    @SuppressLint({"ClickableViewAccessibility"})
    private final TextInputLayout.g f18788i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f18789j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f18790k;
    private long l;
    private StateListDrawable m;
    private e.e.b.c.a0.g n;
    private AccessibilityManager o;
    private ValueAnimator p;
    private ValueAnimator q;

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class a implements TextWatcher {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        /* renamed from: com.google.android.material.textfield.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0203a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f18792f;

            RunnableC0203a(AutoCompleteTextView autoCompleteTextView) {
                this.f18792f = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f18792f.isPopupShowing();
                d.this.C(isPopupShowing);
                d.this.f18789j = isPopupShowing;
            }
        }

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d dVar = d.this;
            AutoCompleteTextView x = dVar.x(dVar.a.getEditText());
            x.post(new RunnableC0203a(x));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f18800c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            d.this.a.setEndIconActivated(z);
            if (z) {
                return;
            }
            d.this.C(false);
            d.this.f18789j = false;
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* renamed from: com.google.android.material.textfield.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0204d extends TextInputLayout.e {
        C0204d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, androidx.core.view.a
        public void g(View view, androidx.core.view.d0.c cVar) {
            super.g(view, cVar);
            cVar.Y(Spinner.class.getName());
            if (cVar.K()) {
                cVar.j0(null);
            }
        }

        @Override // androidx.core.view.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            d dVar = d.this;
            AutoCompleteTextView x = dVar.x(dVar.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.o.isTouchExplorationEnabled()) {
                d.this.F(x);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class e implements TextInputLayout.f {
        e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView x = d.this.x(textInputLayout.getEditText());
            d.this.D(x);
            d.this.u(x);
            d.this.E(x);
            x.setThreshold(0);
            x.removeTextChangedListener(d.this.f18784e);
            x.addTextChangedListener(d.this.f18784e);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f18786g);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class f implements TextInputLayout.g {
        f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i2 != 3) {
                return;
            }
            autoCompleteTextView.removeTextChangedListener(d.this.f18784e);
            if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f18785f) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (d.f18783d) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.F((AutoCompleteTextView) d.this.a.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class h implements View.OnTouchListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f18797f;

        h(AutoCompleteTextView autoCompleteTextView) {
            this.f18797f = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.B()) {
                    d.this.f18789j = false;
                }
                d.this.F(this.f18797f);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class i implements AutoCompleteTextView.OnDismissListener {
        i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.f18789j = true;
            d.this.l = System.currentTimeMillis();
            d.this.C(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f18800c.setChecked(dVar.f18790k);
            d.this.q.start();
        }
    }

    static {
        f18783d = Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f18784e = new a();
        this.f18785f = new c();
        this.f18786g = new C0204d(this.a);
        this.f18787h = new e();
        this.f18788i = new f();
        this.f18789j = false;
        this.f18790k = false;
        this.l = Long.MAX_VALUE;
    }

    private void A() {
        this.q = y(67, 0.0f, 1.0f);
        ValueAnimator y = y(50, 1.0f, 0.0f);
        this.p = y;
        y.addListener(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        long currentTimeMillis = System.currentTimeMillis() - this.l;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z) {
        if (this.f18790k != z) {
            this.f18790k = z;
            this.q.cancel();
            this.p.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(AutoCompleteTextView autoCompleteTextView) {
        if (f18783d) {
            int boxBackgroundMode = this.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.n);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void E(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f18785f);
        if (f18783d) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (B()) {
            this.f18789j = false;
        }
        if (!this.f18789j) {
            if (f18783d) {
                C(!this.f18790k);
            } else {
                this.f18790k = !this.f18790k;
                this.f18800c.toggle();
            }
            if (this.f18790k) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            } else {
                autoCompleteTextView.dismissDropDown();
                return;
            }
        }
        this.f18789j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int boxBackgroundMode = this.a.getBoxBackgroundMode();
        e.e.b.c.a0.g boxBackground = this.a.getBoxBackground();
        int c2 = e.e.b.c.q.a.c(autoCompleteTextView, e.e.b.c.b.f20972k);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            w(autoCompleteTextView, c2, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            v(autoCompleteTextView, c2, iArr, boxBackground);
        }
    }

    private void v(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, e.e.b.c.a0.g gVar) {
        int boxBackgroundColor = this.a.getBoxBackgroundColor();
        int[] iArr2 = {e.e.b.c.q.a.f(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f18783d) {
            u.m0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), gVar, gVar));
            return;
        }
        e.e.b.c.a0.g gVar2 = new e.e.b.c.a0.g(gVar.D());
        gVar2.X(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar, gVar2});
        int D = u.D(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int C = u.C(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        u.m0(autoCompleteTextView, layerDrawable);
        u.w0(autoCompleteTextView, D, paddingTop, C, paddingBottom);
    }

    private void w(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, e.e.b.c.a0.g gVar) {
        LayerDrawable layerDrawable;
        int c2 = e.e.b.c.q.a.c(autoCompleteTextView, e.e.b.c.b.o);
        e.e.b.c.a0.g gVar2 = new e.e.b.c.a0.g(gVar.D());
        int f2 = e.e.b.c.q.a.f(i2, c2, 0.1f);
        gVar2.X(new ColorStateList(iArr, new int[]{f2, 0}));
        if (f18783d) {
            gVar2.setTint(c2);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{f2, c2});
            e.e.b.c.a0.g gVar3 = new e.e.b.c.a0.g(gVar.D());
            gVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar});
        }
        u.m0(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AutoCompleteTextView x(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator y(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(e.e.b.c.m.a.a);
        ofFloat.setDuration(i2);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    private e.e.b.c.a0.g z(float f2, float f3, float f4, int i2) {
        k m = k.a().z(f2).D(f2).r(f3).v(f3).m();
        e.e.b.c.a0.g m2 = e.e.b.c.a0.g.m(this.f18799b, f4);
        m2.setShapeAppearanceModel(m);
        m2.Z(0, i2, 0, i2);
        return m2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        float dimensionPixelOffset = this.f18799b.getResources().getDimensionPixelOffset(e.e.b.c.d.N);
        float dimensionPixelOffset2 = this.f18799b.getResources().getDimensionPixelOffset(e.e.b.c.d.K);
        int dimensionPixelOffset3 = this.f18799b.getResources().getDimensionPixelOffset(e.e.b.c.d.L);
        e.e.b.c.a0.g z = z(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        e.e.b.c.a0.g z2 = z(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.n = z;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.m = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, z);
        this.m.addState(new int[0], z2);
        this.a.setEndIconDrawable(c.a.k.a.a.d(this.f18799b, f18783d ? e.e.b.c.e.f20995e : e.e.b.c.e.f20996f));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(e.e.b.c.j.f21024f));
        this.a.setEndIconOnClickListener(new g());
        this.a.addOnEditTextAttachedListener(this.f18787h);
        this.a.addOnEndIconChangedListener(this.f18788i);
        A();
        u.t0(this.f18800c, 2);
        this.o = (AccessibilityManager) this.f18799b.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean b(int i2) {
        return i2 != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean d() {
        return true;
    }
}
