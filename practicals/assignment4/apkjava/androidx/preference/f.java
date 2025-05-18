package androidx.preference;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.preference.DialogPreference;
import cm.aptoide.pt.database.room.RoomNotification;

/* compiled from: PreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public abstract class f extends androidx.fragment.app.c implements DialogInterface.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    private DialogPreference f1813f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f1814g;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence f1815h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f1816i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f1817j;

    /* renamed from: k, reason: collision with root package name */
    private int f1818k;
    private BitmapDrawable l;
    private int m;

    private void j(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    public DialogPreference d() {
        if (this.f1813f == null) {
            this.f1813f = (DialogPreference) ((DialogPreference.a) getTargetFragment()).findPreference(getArguments().getString(RoomNotification.KEY));
        }
        return this.f1813f;
    }

    protected boolean e() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(View view) {
        View findViewById = view.findViewById(R.id.message);
        if (findViewById != null) {
            CharSequence charSequence = this.f1817j;
            int i2 = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i2 = 0;
            }
            if (findViewById.getVisibility() != i2) {
                findViewById.setVisibility(i2);
            }
        }
    }

    protected View g(Context context) {
        int i2 = this.f1818k;
        if (i2 == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(i2, (ViewGroup) null);
    }

    public abstract void h(boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(c.a aVar) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.m = i2;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.savedstate.c targetFragment = getTargetFragment();
        if (targetFragment instanceof DialogPreference.a) {
            DialogPreference.a aVar = (DialogPreference.a) targetFragment;
            String string = getArguments().getString(RoomNotification.KEY);
            if (bundle == null) {
                DialogPreference dialogPreference = (DialogPreference) aVar.findPreference(string);
                this.f1813f = dialogPreference;
                this.f1814g = dialogPreference.c1();
                this.f1815h = this.f1813f.e1();
                this.f1816i = this.f1813f.d1();
                this.f1817j = this.f1813f.b1();
                this.f1818k = this.f1813f.a1();
                Drawable Z0 = this.f1813f.Z0();
                if (Z0 != null && !(Z0 instanceof BitmapDrawable)) {
                    Bitmap createBitmap = Bitmap.createBitmap(Z0.getIntrinsicWidth(), Z0.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    Z0.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    Z0.draw(canvas);
                    this.l = new BitmapDrawable(getResources(), createBitmap);
                    return;
                }
                this.l = (BitmapDrawable) Z0;
                return;
            }
            this.f1814g = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f1815h = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f1816i = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f1817j = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f1818k = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.l = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        androidx.fragment.app.d activity = getActivity();
        this.m = -2;
        c.a m = new c.a(activity).v(this.f1814g).g(this.l).r(this.f1815h, this).m(this.f1816i, this);
        View g2 = g(activity);
        if (g2 != null) {
            f(g2);
            m.w(g2);
        } else {
            m.j(this.f1817j);
        }
        i(m);
        androidx.appcompat.app.c a = m.a();
        if (e()) {
            j(a);
        }
        return a;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        h(this.m == -1);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f1814g);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f1815h);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f1816i);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f1817j);
        bundle.putInt("PreferenceDialogFragment.layout", this.f1818k);
        BitmapDrawable bitmapDrawable = this.l;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }
}
