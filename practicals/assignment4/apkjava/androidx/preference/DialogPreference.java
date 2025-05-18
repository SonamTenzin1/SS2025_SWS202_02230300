package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    private CharSequence V;
    private CharSequence W;
    private Drawable X;
    private CharSequence Y;
    private CharSequence Z;
    private int a0;

    /* loaded from: classes.dex */
    public interface a {
        <T extends Preference> T findPreference(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.D, i2, i3);
        String o = androidx.core.content.d.g.o(obtainStyledAttributes, t.N, t.E);
        this.V = o;
        if (o == null) {
            this.V = W();
        }
        this.W = androidx.core.content.d.g.o(obtainStyledAttributes, t.M, t.F);
        this.X = androidx.core.content.d.g.c(obtainStyledAttributes, t.K, t.G);
        this.Y = androidx.core.content.d.g.o(obtainStyledAttributes, t.P, t.H);
        this.Z = androidx.core.content.d.g.o(obtainStyledAttributes, t.O, t.I);
        this.a0 = androidx.core.content.d.g.n(obtainStyledAttributes, t.L, t.J, 0);
        obtainStyledAttributes.recycle();
    }

    public Drawable Z0() {
        return this.X;
    }

    public int a1() {
        return this.a0;
    }

    public CharSequence b1() {
        return this.W;
    }

    public CharSequence c1() {
        return this.V;
    }

    public CharSequence d1() {
        return this.Z;
    }

    public CharSequence e1() {
        return this.Y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void l0() {
        S().s(this);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.d.g.a(context, m.f1865c, R.attr.dialogPreferenceStyle));
    }
}
