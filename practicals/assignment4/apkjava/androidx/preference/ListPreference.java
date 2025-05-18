package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    private CharSequence[] b0;
    private CharSequence[] c0;
    private String d0;
    private String e0;
    private boolean f0;

    /* loaded from: classes.dex */
    public static final class a implements Preference.f<ListPreference> {
        private static a a;

        private a() {
        }

        public static a b() {
            if (a == null) {
                a = new a();
            }
            return a;
        }

        @Override // androidx.preference.Preference.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            if (TextUtils.isEmpty(listPreference.h1())) {
                return listPreference.D().getString(r.f1883c);
            }
            return listPreference.h1();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.a0, i2, i3);
        this.b0 = androidx.core.content.d.g.q(obtainStyledAttributes, t.d0, t.b0);
        this.c0 = androidx.core.content.d.g.q(obtainStyledAttributes, t.e0, t.c0);
        int i4 = t.f0;
        if (androidx.core.content.d.g.b(obtainStyledAttributes, i4, i4, false)) {
            Q0(a.b());
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, t.q0, i2, i3);
        this.e0 = androidx.core.content.d.g.o(obtainStyledAttributes2, t.Y0, t.y0);
        obtainStyledAttributes2.recycle();
    }

    private int k1() {
        return f1(this.d0);
    }

    @Override // androidx.preference.Preference
    public void P0(CharSequence charSequence) {
        super.P0(charSequence);
        if (charSequence == null && this.e0 != null) {
            this.e0 = null;
        } else {
            if (charSequence == null || charSequence.equals(this.e0)) {
                return;
            }
            this.e0 = charSequence.toString();
        }
    }

    @Override // androidx.preference.Preference
    public CharSequence U() {
        if (V() != null) {
            return V().a(this);
        }
        CharSequence h1 = h1();
        CharSequence U = super.U();
        String str = this.e0;
        if (str == null) {
            return U;
        }
        Object[] objArr = new Object[1];
        if (h1 == null) {
            h1 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        objArr[0] = h1;
        String format = String.format(str, objArr);
        if (TextUtils.equals(format, U)) {
            return U;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }

    public int f1(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.c0) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.c0[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] g1() {
        return this.b0;
    }

    public CharSequence h1() {
        CharSequence[] charSequenceArr;
        int k1 = k1();
        if (k1 < 0 || (charSequenceArr = this.b0) == null) {
            return null;
        }
        return charSequenceArr[k1];
    }

    public CharSequence[] i1() {
        return this.c0;
    }

    public String j1() {
        return this.d0;
    }

    public void l1(String str) {
        boolean z = !TextUtils.equals(this.d0, str);
        if (z || !this.f0) {
            this.d0 = str;
            this.f0 = true;
            A0(str);
            if (z) {
                e0();
            }
        }
    }

    @Override // androidx.preference.Preference
    protected Object o0(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void s0(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            SavedState savedState = (SavedState) parcelable;
            super.s0(savedState.getSuperState());
            l1(savedState.f1795f);
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
        savedState.f1795f = j1();
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void u0(Object obj) {
        l1(P((String) obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        String f1795f;

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
            this.f1795f = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f1795f);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.d.g.a(context, m.f1865c, R.attr.dialogPreferenceStyle));
    }
}
