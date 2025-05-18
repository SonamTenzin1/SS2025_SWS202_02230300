package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    protected boolean V;
    private CharSequence W;
    private CharSequence X;
    private boolean Y;
    private boolean Z;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // androidx.preference.Preference
    public boolean U0() {
        return (this.Z ? this.V : !this.V) || super.U0();
    }

    public boolean Z0() {
        return this.V;
    }

    public void a1(boolean z) {
        boolean z2 = this.V != z;
        if (z2 || !this.Y) {
            this.V = z;
            this.Y = true;
            y0(z);
            if (z2) {
                f0(U0());
                e0();
            }
        }
    }

    public void b1(boolean z) {
        this.Z = z;
    }

    public void c1(CharSequence charSequence) {
        this.X = charSequence;
        if (Z0()) {
            return;
        }
        e0();
    }

    public void d1(CharSequence charSequence) {
        this.W = charSequence;
        if (Z0()) {
            e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e1(View view) {
        int i2;
        if (!(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        boolean z = true;
        if (this.V && !TextUtils.isEmpty(this.W)) {
            textView.setText(this.W);
        } else {
            if (!this.V && !TextUtils.isEmpty(this.X)) {
                textView.setText(this.X);
            }
            if (z) {
                CharSequence U = U();
                if (!TextUtils.isEmpty(U)) {
                    textView.setText(U);
                    z = false;
                }
            }
            i2 = z ? 8 : 0;
            if (i2 == textView.getVisibility()) {
                textView.setVisibility(i2);
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
        if (z) {
        }
        if (i2 == textView.getVisibility()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f1(l lVar) {
        e1(lVar.a(R.id.summary));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void l0() {
        super.l0();
        boolean z = !Z0();
        if (k(Boolean.valueOf(z))) {
            a1(z);
        }
    }

    @Override // androidx.preference.Preference
    protected Object o0(TypedArray typedArray, int i2) {
        return Boolean.valueOf(typedArray.getBoolean(i2, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void s0(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            SavedState savedState = (SavedState) parcelable;
            super.s0(savedState.getSuperState());
            a1(savedState.f1811f);
            return;
        }
        super.s0(parcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public Parcelable t0() {
        Parcelable t0 = super.t0();
        if (b0()) {
            return t0;
        }
        SavedState savedState = new SavedState(t0);
        savedState.f1811f = Z0();
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void u0(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        a1(N(((Boolean) obj).booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        boolean f1811f;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<SavedState> {
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

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1811f = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1811f ? 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
