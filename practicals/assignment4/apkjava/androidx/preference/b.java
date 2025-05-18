package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExpandButton.java */
/* loaded from: classes.dex */
final class b extends Preference {
    private long V;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, List<Preference> list, long j2) {
        super(context);
        Z0();
        a1(list);
        this.V = j2 + 1000000;
    }

    private void Z0() {
        L0(q.a);
        I0(o.a);
        R0(r.f1882b);
        O0(androidx.room.j.MAX_BIND_PARAMETER_CNT);
    }

    private void a1(List<Preference> list) {
        ArrayList arrayList = new ArrayList();
        CharSequence charSequence = null;
        for (Preference preference : list) {
            CharSequence W = preference.W();
            boolean z = preference instanceof PreferenceGroup;
            if (z && !TextUtils.isEmpty(W)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.M())) {
                if (z) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(W)) {
                charSequence = charSequence == null ? W : D().getString(r.f1885e, charSequence, W);
            }
        }
        P0(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.preference.Preference
    public long H() {
        return this.V;
    }

    @Override // androidx.preference.Preference
    public void k0(l lVar) {
        super.k0(lVar);
        lVar.d(false);
    }
}
