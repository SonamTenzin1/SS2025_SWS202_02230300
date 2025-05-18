package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    private final Context g0;
    private final ArrayAdapter h0;
    private Spinner i0;
    private final AdapterView.OnItemSelectedListener j0;

    /* loaded from: classes.dex */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (i2 >= 0) {
                String charSequence = DropDownPreference.this.i1()[i2].toString();
                if (charSequence.equals(DropDownPreference.this.j1()) || !DropDownPreference.this.k(charSequence)) {
                    return;
                }
                DropDownPreference.this.l1(charSequence);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f1866d);
    }

    private int n1(String str) {
        CharSequence[] i1 = i1();
        if (str == null || i1 == null) {
            return -1;
        }
        for (int length = i1.length - 1; length >= 0; length--) {
            if (i1[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    private void o1() {
        this.h0.clear();
        if (g1() != null) {
            for (CharSequence charSequence : g1()) {
                this.h0.add(charSequence.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void e0() {
        super.e0();
        ArrayAdapter arrayAdapter = this.h0;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public void k0(l lVar) {
        Spinner spinner = (Spinner) lVar.itemView.findViewById(p.f1877e);
        this.i0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.h0);
        this.i0.setOnItemSelectedListener(this.j0);
        this.i0.setSelection(n1(j1()));
        super.k0(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void l0() {
        this.i0.performClick();
    }

    protected ArrayAdapter m1() {
        return new ArrayAdapter(this.g0, R.layout.simple_spinner_dropdown_item);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.j0 = new a();
        this.g0 = context;
        this.h0 = m1();
        o1();
    }
}
