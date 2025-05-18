package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* compiled from: AppCompatToggleButton.java */
/* loaded from: classes.dex */
public class v extends ToggleButton {

    /* renamed from: f, reason: collision with root package name */
    private final s f663f;

    public v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public v(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        l0.a(this, getContext());
        s sVar = new s(this);
        this.f663f = sVar;
        sVar.m(attributeSet, i2);
    }
}
