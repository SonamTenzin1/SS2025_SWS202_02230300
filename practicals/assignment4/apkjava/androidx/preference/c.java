package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.c;
import cm.aptoide.pt.database.room.RoomNotification;

/* compiled from: ListPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class c extends f {
    int n;
    private CharSequence[] o;
    private CharSequence[] p;

    /* compiled from: ListPreferenceDialogFragmentCompat.java */
    /* loaded from: classes.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c cVar = c.this;
            cVar.n = i2;
            cVar.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    private ListPreference k() {
        return (ListPreference) d();
    }

    public static c l(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle(1);
        bundle.putString(RoomNotification.KEY, str);
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // androidx.preference.f
    public void h(boolean z) {
        int i2;
        if (!z || (i2 = this.n) < 0) {
            return;
        }
        String charSequence = this.p[i2].toString();
        ListPreference k2 = k();
        if (k2.k(charSequence)) {
            k2.l1(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.f
    public void i(c.a aVar) {
        super.i(aVar);
        aVar.t(this.o, this.n, new a());
        aVar.r(null, null);
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            ListPreference k2 = k();
            if (k2.g1() != null && k2.i1() != null) {
                this.n = k2.f1(k2.j1());
                this.o = k2.g1();
                this.p = k2.i1();
                return;
            }
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.n = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.o = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
        this.p = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.n);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.o);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.p);
    }
}
