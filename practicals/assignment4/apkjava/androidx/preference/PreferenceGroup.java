package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    final c.e.g<String, Long> V;
    private final Handler W;
    private List<Preference> X;
    private boolean Y;
    private int Z;
    private boolean a0;
    private int b0;
    private b c0;
    private final Runnable d0;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.V.clear();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes.dex */
    public interface c {
        int c(Preference preference);

        int f(String str);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.V = new c.e.g<>();
        this.W = new Handler();
        this.Y = true;
        this.Z = 0;
        this.a0 = false;
        this.b0 = Integer.MAX_VALUE;
        this.c0 = null;
        this.d0 = new a();
        this.X = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.h1, i2, i3);
        int i4 = t.j1;
        this.Y = androidx.core.content.d.g.b(obtainStyledAttributes, i4, i4, true);
        int i5 = t.i1;
        if (obtainStyledAttributes.hasValue(i5)) {
            k1(androidx.core.content.d.g.d(obtainStyledAttributes, i5, i5, Integer.MAX_VALUE));
        }
        obtainStyledAttributes.recycle();
    }

    private boolean j1(Preference preference) {
        boolean remove;
        synchronized (this) {
            preference.r0();
            if (preference.M() == this) {
                preference.g(null);
            }
            remove = this.X.remove(preference);
            if (remove) {
                String J = preference.J();
                if (J != null) {
                    this.V.put(J, Long.valueOf(preference.H()));
                    this.W.removeCallbacks(this.d0);
                    this.W.post(this.d0);
                }
                if (this.a0) {
                    preference.n0();
                }
            }
        }
        return remove;
    }

    public void Z0(Preference preference) {
        a1(preference);
    }

    public boolean a1(Preference preference) {
        long d2;
        if (this.X.contains(preference)) {
            return true;
        }
        if (preference.J() != null) {
            PreferenceGroup preferenceGroup = this;
            while (preferenceGroup.M() != null) {
                preferenceGroup = preferenceGroup.M();
            }
            String J = preference.J();
            if (preferenceGroup.b1(J) != null) {
                Log.e("PreferenceGroup", "Found duplicated key: \"" + J + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.L() == Integer.MAX_VALUE) {
            if (this.Y) {
                int i2 = this.Z;
                this.Z = i2 + 1;
                preference.O0(i2);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).l1(this.Y);
            }
        }
        int binarySearch = Collections.binarySearch(this.X, preference);
        if (binarySearch < 0) {
            binarySearch = (binarySearch * (-1)) - 1;
        }
        if (!h1(preference)) {
            return false;
        }
        synchronized (this) {
            this.X.add(binarySearch, preference);
        }
        j S = S();
        String J2 = preference.J();
        if (J2 != null && this.V.containsKey(J2)) {
            d2 = this.V.get(J2).longValue();
            this.V.remove(J2);
        } else {
            d2 = S.d();
        }
        preference.j0(S, d2);
        preference.g(this);
        if (this.a0) {
            preference.h0();
        }
        g0();
        return true;
    }

    public <T extends Preference> T b1(CharSequence charSequence) {
        T t;
        if (charSequence != null) {
            if (TextUtils.equals(J(), charSequence)) {
                return this;
            }
            int f1 = f1();
            for (int i2 = 0; i2 < f1; i2++) {
                PreferenceGroup preferenceGroup = (T) e1(i2);
                if (TextUtils.equals(preferenceGroup.J(), charSequence)) {
                    return preferenceGroup;
                }
                if ((preferenceGroup instanceof PreferenceGroup) && (t = (T) preferenceGroup.b1(charSequence)) != null) {
                    return t;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("Key cannot be null");
    }

    public int c1() {
        return this.b0;
    }

    public b d1() {
        return this.c0;
    }

    public Preference e1(int i2) {
        return this.X.get(i2);
    }

    @Override // androidx.preference.Preference
    public void f0(boolean z) {
        super.f0(z);
        int f1 = f1();
        for (int i2 = 0; i2 < f1; i2++) {
            e1(i2).q0(this, z);
        }
    }

    public int f1() {
        return this.X.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g1() {
        return true;
    }

    @Override // androidx.preference.Preference
    public void h0() {
        super.h0();
        this.a0 = true;
        int f1 = f1();
        for (int i2 = 0; i2 < f1; i2++) {
            e1(i2).h0();
        }
    }

    protected boolean h1(Preference preference) {
        preference.q0(this, U0());
        return true;
    }

    public boolean i1(Preference preference) {
        boolean j1 = j1(preference);
        g0();
        return j1;
    }

    public void k1(int i2) {
        if (i2 != Integer.MAX_VALUE && !Y()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.b0 = i2;
    }

    public void l1(boolean z) {
        this.Y = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m1() {
        synchronized (this) {
            Collections.sort(this.X);
        }
    }

    @Override // androidx.preference.Preference
    public void n0() {
        super.n0();
        this.a0 = false;
        int f1 = f1();
        for (int i2 = 0; i2 < f1; i2++) {
            e1(i2).n0();
        }
    }

    @Override // androidx.preference.Preference
    protected void s0(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            SavedState savedState = (SavedState) parcelable;
            this.b0 = savedState.f1805f;
            super.s0(savedState.getSuperState());
            return;
        }
        super.s0(parcelable);
    }

    @Override // androidx.preference.Preference
    protected Parcelable t0() {
        return new SavedState(super.t0(), this.b0);
    }

    @Override // androidx.preference.Preference
    protected void v(Bundle bundle) {
        super.v(bundle);
        int f1 = f1();
        for (int i2 = 0; i2 < f1; i2++) {
            e1(i2).v(bundle);
        }
    }

    @Override // androidx.preference.Preference
    protected void x(Bundle bundle) {
        super.x(bundle);
        int f1 = f1();
        for (int i2 = 0; i2 < f1; i2++) {
            e1(i2).x(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        int f1805f;

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
            this.f1805f = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1805f);
        }

        SavedState(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f1805f = i2;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
