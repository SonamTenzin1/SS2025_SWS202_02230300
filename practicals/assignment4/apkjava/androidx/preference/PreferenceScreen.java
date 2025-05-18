package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.j;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    private boolean e0;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, androidx.core.content.d.g.a(context, m.f1870h, R.attr.preferenceScreenStyle));
        this.e0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.PreferenceGroup
    public boolean g1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void l0() {
        j.b e2;
        if (I() != null || G() != null || f1() == 0 || (e2 = S().e()) == null) {
            return;
        }
        e2.onNavigateToScreen(this);
    }

    public boolean n1() {
        return this.e0;
    }
}
