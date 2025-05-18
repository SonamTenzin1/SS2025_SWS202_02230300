package androidx.preference;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import cm.aptoide.pt.database.room.RoomNotification;

/* compiled from: EditTextPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class a extends f {
    private EditText n;
    private CharSequence o;

    private EditTextPreference k() {
        return (EditTextPreference) d();
    }

    public static a l(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle(1);
        bundle.putString(RoomNotification.KEY, str);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // androidx.preference.f
    protected boolean e() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.f
    public void f(View view) {
        super.f(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.n = editText;
        if (editText != null) {
            editText.requestFocus();
            this.n.setText(this.o);
            EditText editText2 = this.n;
            editText2.setSelection(editText2.getText().length());
            if (k().f1() != null) {
                k().f1().a(this.n);
                return;
            }
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    @Override // androidx.preference.f
    public void h(boolean z) {
        if (z) {
            String obj = this.n.getText().toString();
            EditTextPreference k2 = k();
            if (k2.k(obj)) {
                k2.h1(obj);
            }
        }
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.o = k().g1();
        } else {
            this.o = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.o);
    }
}
