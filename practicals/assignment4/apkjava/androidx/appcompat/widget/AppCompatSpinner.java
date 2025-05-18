package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.c;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements androidx.core.view.t {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f395f = {R.attr.spinnerMode};

    /* renamed from: g, reason: collision with root package name */
    private final androidx.appcompat.widget.d f396g;

    /* renamed from: h, reason: collision with root package name */
    private final Context f397h;

    /* renamed from: i, reason: collision with root package name */
    private b0 f398i;

    /* renamed from: j, reason: collision with root package name */
    private SpinnerAdapter f399j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f400k;
    private f l;
    int m;
    final Rect n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        boolean f401f;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f401f ? (byte) 1 : (byte) 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f401f = parcel.readByte() != 0;
        }
    }

    /* loaded from: classes.dex */
    class a extends b0 {
        final /* synthetic */ e o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, e eVar) {
            super(view);
            this.o = eVar;
        }

        @Override // androidx.appcompat.widget.b0
        public androidx.appcompat.view.menu.p b() {
            return this.o;
        }

        @Override // androidx.appcompat.widget.b0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (AppCompatSpinner.this.getInternalPopup().a()) {
                return true;
            }
            AppCompatSpinner.this.b();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().a()) {
                AppCompatSpinner.this.b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements f, DialogInterface.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        androidx.appcompat.app.c f403f;

        /* renamed from: g, reason: collision with root package name */
        private ListAdapter f404g;

        /* renamed from: h, reason: collision with root package name */
        private CharSequence f405h;

        c() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public boolean a() {
            androidx.appcompat.app.c cVar = this.f403f;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void b(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public int c() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void dismiss() {
            androidx.appcompat.app.c cVar = this.f403f;
            if (cVar != null) {
                cVar.dismiss();
                this.f403f = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void e(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public CharSequence f() {
            return this.f405h;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public Drawable h() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void i(CharSequence charSequence) {
            this.f405h = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void k(int i2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void l(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void m(int i2, int i3) {
            if (this.f404g == null) {
                return;
            }
            c.a aVar = new c.a(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f405h;
            if (charSequence != null) {
                aVar.v(charSequence);
            }
            androidx.appcompat.app.c a = aVar.s(this.f404g, AppCompatSpinner.this.getSelectedItemPosition(), this).a();
            this.f403f = a;
            ListView f2 = a.f();
            if (Build.VERSION.SDK_INT >= 17) {
                f2.setTextDirection(i2);
                f2.setTextAlignment(i3);
            }
            this.f403f.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public int n() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void o(ListAdapter listAdapter) {
            this.f404g = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            AppCompatSpinner.this.setSelection(i2);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i2, this.f404g.getItemId(i2));
            }
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: f, reason: collision with root package name */
        private SpinnerAdapter f407f;

        /* renamed from: g, reason: collision with root package name */
        private ListAdapter f408g;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f407f = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f408g = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof m0) {
                    m0 m0Var = (m0) spinnerAdapter;
                    if (m0Var.getDropDownViewTheme() == null) {
                        m0Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f408g;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f407f;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f407f;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f407f;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f407f;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f407f;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f408g;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f407f;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f407f;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes.dex */
    class e extends d0 implements f {
        private CharSequence O;
        ListAdapter P;
        private final Rect Q;
        private int R;

        /* loaded from: classes.dex */
        class a implements AdapterView.OnItemClickListener {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ AppCompatSpinner f409f;

            a(AppCompatSpinner appCompatSpinner) {
                this.f409f = appCompatSpinner;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppCompatSpinner.this.setSelection(i2);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    AppCompatSpinner.this.performItemClick(view, i2, eVar.P.getItemId(i2));
                }
                e.this.dismiss();
            }
        }

        /* loaded from: classes.dex */
        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.T(AppCompatSpinner.this)) {
                    e.this.dismiss();
                } else {
                    e.this.R();
                    e.super.show();
                }
            }
        }

        /* loaded from: classes.dex */
        class c implements PopupWindow.OnDismissListener {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f412f;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f412f = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f412f);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.Q = new Rect();
            C(AppCompatSpinner.this);
            I(true);
            N(0);
            K(new a(AppCompatSpinner.this));
        }

        void R() {
            int S;
            Drawable h2 = h();
            int i2 = 0;
            if (h2 != null) {
                h2.getPadding(AppCompatSpinner.this.n);
                i2 = w0.b(AppCompatSpinner.this) ? AppCompatSpinner.this.n.right : -AppCompatSpinner.this.n.left;
            } else {
                Rect rect = AppCompatSpinner.this.n;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i3 = appCompatSpinner.m;
            if (i3 == -2) {
                int a2 = appCompatSpinner.a((SpinnerAdapter) this.P, h());
                int i4 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.n;
                int i5 = (i4 - rect2.left) - rect2.right;
                if (a2 > i5) {
                    a2 = i5;
                }
                E(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                E((width - paddingLeft) - paddingRight);
            } else {
                E(i3);
            }
            if (w0.b(AppCompatSpinner.this)) {
                S = i2 + (((width - paddingRight) - y()) - S());
            } else {
                S = i2 + paddingLeft + S();
            }
            e(S);
        }

        public int S() {
            return this.R;
        }

        boolean T(View view) {
            return androidx.core.view.u.N(view) && view.getGlobalVisibleRect(this.Q);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public CharSequence f() {
            return this.O;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void i(CharSequence charSequence) {
            this.O = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void l(int i2) {
            this.R = i2;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void m(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean a2 = a();
            R();
            H(2);
            super.show();
            ListView j2 = j();
            j2.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                j2.setTextDirection(i2);
                j2.setTextAlignment(i3);
            }
            O(AppCompatSpinner.this.getSelectedItemPosition());
            if (a2 || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            J(new c(bVar));
        }

        @Override // androidx.appcompat.widget.d0, androidx.appcompat.widget.AppCompatSpinner.f
        public void o(ListAdapter listAdapter) {
            super.o(listAdapter);
            this.P = listAdapter;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        boolean a();

        void b(Drawable drawable);

        int c();

        void dismiss();

        void e(int i2);

        CharSequence f();

        Drawable h();

        void i(CharSequence charSequence);

        void k(int i2);

        void l(int i2);

        void m(int i2, int i3);

        int n();

        void o(ListAdapter listAdapter);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.K);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.n);
        Rect rect = this.n;
        return i3 + rect.left + rect.right;
    }

    void b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.l.m(getTextDirection(), getTextAlignment());
        } else {
            this.l.m(-1, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.d dVar = this.f396g;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        f fVar = this.l;
        if (fVar != null) {
            return fVar.c();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        f fVar = this.l;
        if (fVar != null) {
            return fVar.n();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.l != null) {
            return this.m;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    final f getInternalPopup() {
        return this.l;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        f fVar = this.l;
        if (fVar != null) {
            return fVar.h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f397h;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        f fVar = this.l;
        return fVar != null ? fVar.f() : super.getPrompt();
    }

    @Override // androidx.core.view.t
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.d dVar = this.f396g;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.d dVar = this.f396g;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.l;
        if (fVar == null || !fVar.a()) {
            return;
        }
        this.l.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.l == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f401f || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.l;
        savedState.f401f = fVar != null && fVar.a();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b0 b0Var = this.f398i;
        if (b0Var == null || !b0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        f fVar = this.l;
        if (fVar != null) {
            if (fVar.a()) {
                return true;
            }
            b();
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.d dVar = this.f396g;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        androidx.appcompat.widget.d dVar = this.f396g;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i2) {
        f fVar = this.l;
        if (fVar != null) {
            fVar.l(i2);
            this.l.e(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i2) {
        f fVar = this.l;
        if (fVar != null) {
            fVar.k(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i2) {
        if (this.l != null) {
            this.m = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.l;
        if (fVar != null) {
            fVar.b(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(c.a.k.a.a.d(getPopupContext(), i2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        f fVar = this.l;
        if (fVar != null) {
            fVar.i(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.d dVar = this.f396g;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.d dVar = this.f396g;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f400k) {
            this.f399j = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.l != null) {
            Context context = this.f397h;
            if (context == null) {
                context = getContext();
            }
            this.l.o(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
    
        if (r11 == null) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.appcompat.widget.AppCompatSpinner, android.view.View, android.widget.Spinner] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2, int i3, Resources.Theme theme) {
        super(context, attributeSet, i2);
        TypedArray typedArray;
        this.n = new Rect();
        l0.a(this, getContext());
        q0 v = q0.v(context, attributeSet, c.a.j.A2, i2, 0);
        this.f396g = new androidx.appcompat.widget.d(this);
        if (theme != null) {
            this.f397h = new c.a.o.d(context, theme);
        } else {
            int n = v.n(c.a.j.F2, 0);
            if (n != 0) {
                this.f397h = new c.a.o.d(context, n);
            } else {
                this.f397h = context;
            }
        }
        ?? r11 = -1;
        TypedArray typedArray2 = null;
        try {
            if (i3 == -1) {
                try {
                    typedArray = context.obtainStyledAttributes(attributeSet, f395f, i2, 0);
                    try {
                        boolean hasValue = typedArray.hasValue(0);
                        r11 = typedArray;
                        if (hasValue) {
                            i3 = typedArray.getInt(0, 0);
                            r11 = typedArray;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        r11 = typedArray;
                    }
                } catch (Exception e3) {
                    e = e3;
                    typedArray = null;
                } catch (Throwable th) {
                    th = th;
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                    throw th;
                }
                r11.recycle();
            }
            if (i3 == 0) {
                c cVar = new c();
                this.l = cVar;
                cVar.i(v.o(c.a.j.D2));
            } else if (i3 == 1) {
                e eVar = new e(this.f397h, attributeSet, i2);
                q0 v2 = q0.v(this.f397h, attributeSet, c.a.j.A2, i2, 0);
                this.m = v2.m(c.a.j.E2, -2);
                eVar.b(v2.g(c.a.j.C2));
                eVar.i(v.o(c.a.j.D2));
                v2.w();
                this.l = eVar;
                this.f398i = new a(this, eVar);
            }
            CharSequence[] q = v.q(c.a.j.B2);
            if (q != null) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, q);
                arrayAdapter.setDropDownViewResource(c.a.g.t);
                setAdapter(arrayAdapter);
            }
            v.w();
            this.f400k = true;
            SpinnerAdapter spinnerAdapter = this.f399j;
            if (spinnerAdapter != null) {
                setAdapter(spinnerAdapter);
                this.f399j = null;
            }
            this.f396g.e(attributeSet, i2);
        } catch (Throwable th2) {
            th = th2;
            typedArray2 = r11;
        }
    }
}
