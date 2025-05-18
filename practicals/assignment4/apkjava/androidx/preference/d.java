package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.c;
import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class d extends f {
    Set<String> n = new HashSet();
    boolean o;
    CharSequence[] p;
    CharSequence[] q;

    /* compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
    /* loaded from: classes.dex */
    class a implements DialogInterface.OnMultiChoiceClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
            if (z) {
                d dVar = d.this;
                dVar.o = dVar.n.add(dVar.q[i2].toString()) | dVar.o;
            } else {
                d dVar2 = d.this;
                dVar2.o = dVar2.n.remove(dVar2.q[i2].toString()) | dVar2.o;
            }
        }
    }

    private MultiSelectListPreference k() {
        return (MultiSelectListPreference) d();
    }

    public static d l(String str) {
        d dVar = new d();
        Bundle bundle = new Bundle(1);
        bundle.putString(RoomNotification.KEY, str);
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // androidx.preference.f
    public void h(boolean z) {
        if (z && this.o) {
            MultiSelectListPreference k2 = k();
            if (k2.k(this.n)) {
                k2.i1(this.n);
            }
        }
        this.o = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.f
    public void i(c.a aVar) {
        super.i(aVar);
        int length = this.q.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = this.n.contains(this.q[i2].toString());
        }
        aVar.k(this.p, zArr, new a());
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            MultiSelectListPreference k2 = k();
            if (k2.f1() != null && k2.g1() != null) {
                this.n.clear();
                this.n.addAll(k2.h1());
                this.o = false;
                this.p = k2.f1();
                this.q = k2.g1();
                return;
            }
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.n.clear();
        this.n.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.o = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.p = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.q = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.n));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.o);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.p);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.q);
    }
}
