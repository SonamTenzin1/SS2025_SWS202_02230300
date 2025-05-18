package androidx.preference;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.u;
import androidx.preference.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    private Object A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private int L;
    private int M;
    private b N;
    private List<Preference> O;
    private PreferenceGroup P;
    private boolean Q;
    private boolean R;
    private e S;
    private f T;
    private final View.OnClickListener U;

    /* renamed from: f, reason: collision with root package name */
    private Context f1797f;

    /* renamed from: g, reason: collision with root package name */
    private j f1798g;

    /* renamed from: h, reason: collision with root package name */
    private androidx.preference.e f1799h;

    /* renamed from: i, reason: collision with root package name */
    private long f1800i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1801j;

    /* renamed from: k, reason: collision with root package name */
    private c f1802k;
    private d l;
    private int m;
    private int n;
    private CharSequence o;
    private CharSequence p;
    private int q;
    private Drawable r;
    private String s;
    private Intent t;
    private String u;
    private Bundle v;
    private boolean w;
    private boolean x;
    private boolean y;
    private String z;

    /* loaded from: classes.dex */
    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new a();

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<BaseSavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public BaseSavedState[] newArray(int i2) {
                return new BaseSavedState[i2];
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.x0(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Preference preference);

        void b(Preference preference);

        void e(Preference preference);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(Preference preference, Object obj);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean onPreferenceClick(Preference preference);
    }

    /* loaded from: classes.dex */
    private static class e implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        /* renamed from: f, reason: collision with root package name */
        private final Preference f1804f;

        e(Preference preference) {
            this.f1804f = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence U = this.f1804f.U();
            if (!this.f1804f.Z() || TextUtils.isEmpty(U)) {
                return;
            }
            contextMenu.setHeaderTitle(U);
            contextMenu.add(0, 0, 0, r.a).setOnMenuItemClickListener(this);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ClipboardManager clipboardManager = (ClipboardManager) this.f1804f.D().getSystemService("clipboard");
            CharSequence U = this.f1804f.U();
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", U));
            Toast.makeText(this.f1804f.D(), this.f1804f.D().getString(r.f1884d, U), 0).show();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface f<T extends Preference> {
        CharSequence a(T t);
    }

    public Preference(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.m = Integer.MAX_VALUE;
        this.n = 0;
        this.w = true;
        this.x = true;
        this.y = true;
        this.B = true;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = true;
        this.H = true;
        this.K = true;
        int i4 = q.f1879b;
        this.L = i4;
        this.U = new a();
        this.f1797f = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.q0, i2, i3);
        this.q = androidx.core.content.d.g.n(obtainStyledAttributes, t.O0, t.r0, 0);
        this.s = androidx.core.content.d.g.o(obtainStyledAttributes, t.R0, t.x0);
        this.o = androidx.core.content.d.g.p(obtainStyledAttributes, t.Z0, t.v0);
        this.p = androidx.core.content.d.g.p(obtainStyledAttributes, t.Y0, t.y0);
        this.m = androidx.core.content.d.g.d(obtainStyledAttributes, t.T0, t.z0, Integer.MAX_VALUE);
        this.u = androidx.core.content.d.g.o(obtainStyledAttributes, t.N0, t.E0);
        this.L = androidx.core.content.d.g.n(obtainStyledAttributes, t.S0, t.u0, i4);
        this.M = androidx.core.content.d.g.n(obtainStyledAttributes, t.a1, t.A0, 0);
        this.w = androidx.core.content.d.g.b(obtainStyledAttributes, t.M0, t.t0, true);
        this.x = androidx.core.content.d.g.b(obtainStyledAttributes, t.V0, t.w0, true);
        this.y = androidx.core.content.d.g.b(obtainStyledAttributes, t.U0, t.s0, true);
        this.z = androidx.core.content.d.g.o(obtainStyledAttributes, t.K0, t.B0);
        int i5 = t.H0;
        this.E = androidx.core.content.d.g.b(obtainStyledAttributes, i5, i5, this.x);
        int i6 = t.I0;
        this.F = androidx.core.content.d.g.b(obtainStyledAttributes, i6, i6, this.x);
        int i7 = t.J0;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.A = o0(obtainStyledAttributes, i7);
        } else {
            int i8 = t.C0;
            if (obtainStyledAttributes.hasValue(i8)) {
                this.A = o0(obtainStyledAttributes, i8);
            }
        }
        this.K = androidx.core.content.d.g.b(obtainStyledAttributes, t.W0, t.D0, true);
        int i9 = t.X0;
        boolean hasValue = obtainStyledAttributes.hasValue(i9);
        this.G = hasValue;
        if (hasValue) {
            this.H = androidx.core.content.d.g.b(obtainStyledAttributes, i9, t.F0, true);
        }
        this.I = androidx.core.content.d.g.b(obtainStyledAttributes, t.P0, t.G0, false);
        int i10 = t.Q0;
        this.D = androidx.core.content.d.g.b(obtainStyledAttributes, i10, i10, true);
        int i11 = t.L0;
        this.J = androidx.core.content.d.g.b(obtainStyledAttributes, i11, i11, false);
        obtainStyledAttributes.recycle();
    }

    private void C0() {
        if (TextUtils.isEmpty(this.z)) {
            return;
        }
        Preference A = A(this.z);
        if (A != null) {
            A.D0(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.z + "\" not found for preference \"" + this.s + "\" (title: \"" + ((Object) this.o) + "\"");
    }

    private void D0(Preference preference) {
        if (this.O == null) {
            this.O = new ArrayList();
        }
        this.O.add(preference);
        preference.m0(this, U0());
    }

    private void H0(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                H0(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    private void W0(SharedPreferences.Editor editor) {
        if (this.f1798g.r()) {
            editor.apply();
        }
    }

    private void X0() {
        Preference A;
        String str = this.z;
        if (str == null || (A = A(str)) == null) {
            return;
        }
        A.Y0(this);
    }

    private void Y0(Preference preference) {
        List<Preference> list = this.O;
        if (list != null) {
            list.remove(preference);
        }
    }

    private void y() {
        if (R() != null) {
            v0(true, this.A);
            return;
        }
        if (V0() && T().contains(this.s)) {
            v0(true, null);
            return;
        }
        Object obj = this.A;
        if (obj != null) {
            v0(false, obj);
        }
    }

    protected <T extends Preference> T A(String str) {
        j jVar = this.f1798g;
        if (jVar == null) {
            return null;
        }
        return (T) jVar.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean A0(String str) {
        if (!V0()) {
            return false;
        }
        if (TextUtils.equals(str, P(null))) {
            return true;
        }
        if (R() == null) {
            SharedPreferences.Editor c2 = this.f1798g.c();
            c2.putString(this.s, str);
            W0(c2);
            return true;
        }
        throw null;
    }

    public boolean B0(Set<String> set) {
        if (!V0()) {
            return false;
        }
        if (set.equals(Q(null))) {
            return true;
        }
        if (R() == null) {
            SharedPreferences.Editor c2 = this.f1798g.c();
            c2.putStringSet(this.s, set);
            W0(c2);
            return true;
        }
        throw null;
    }

    public Context D() {
        return this.f1797f;
    }

    public Bundle E() {
        if (this.v == null) {
            this.v = new Bundle();
        }
        return this.v;
    }

    public void E0(Bundle bundle) {
        v(bundle);
    }

    StringBuilder F() {
        StringBuilder sb = new StringBuilder();
        CharSequence W = W();
        if (!TextUtils.isEmpty(W)) {
            sb.append(W);
            sb.append(' ');
        }
        CharSequence U = U();
        if (!TextUtils.isEmpty(U)) {
            sb.append(U);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public void F0(Bundle bundle) {
        x(bundle);
    }

    public String G() {
        return this.u;
    }

    public void G0(boolean z) {
        if (this.w != z) {
            this.w = z;
            f0(U0());
            e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long H() {
        return this.f1800i;
    }

    public Intent I() {
        return this.t;
    }

    public void I0(int i2) {
        J0(c.a.k.a.a.d(this.f1797f, i2));
        this.q = i2;
    }

    public String J() {
        return this.s;
    }

    public void J0(Drawable drawable) {
        if (this.r != drawable) {
            this.r = drawable;
            this.q = 0;
            e0();
        }
    }

    public final int K() {
        return this.L;
    }

    public void K0(Intent intent) {
        this.t = intent;
    }

    public int L() {
        return this.m;
    }

    public void L0(int i2) {
        this.L = i2;
    }

    public PreferenceGroup M() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void M0(b bVar) {
        this.N = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean N(boolean z) {
        if (!V0()) {
            return z;
        }
        if (R() == null) {
            return this.f1798g.j().getBoolean(this.s, z);
        }
        throw null;
    }

    public void N0(d dVar) {
        this.l = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(int i2) {
        if (!V0()) {
            return i2;
        }
        if (R() == null) {
            return this.f1798g.j().getInt(this.s, i2);
        }
        throw null;
    }

    public void O0(int i2) {
        if (i2 != this.m) {
            this.m = i2;
            g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String P(String str) {
        if (!V0()) {
            return str;
        }
        if (R() == null) {
            return this.f1798g.j().getString(this.s, str);
        }
        throw null;
    }

    public void P0(CharSequence charSequence) {
        if (V() == null) {
            if (TextUtils.equals(this.p, charSequence)) {
                return;
            }
            this.p = charSequence;
            e0();
            return;
        }
        throw new IllegalStateException("Preference already has a SummaryProvider set.");
    }

    public Set<String> Q(Set<String> set) {
        if (!V0()) {
            return set;
        }
        if (R() == null) {
            return this.f1798g.j().getStringSet(this.s, set);
        }
        throw null;
    }

    public final void Q0(f fVar) {
        this.T = fVar;
        e0();
    }

    public androidx.preference.e R() {
        androidx.preference.e eVar = this.f1799h;
        if (eVar != null) {
            return eVar;
        }
        j jVar = this.f1798g;
        if (jVar != null) {
            return jVar.h();
        }
        return null;
    }

    public void R0(int i2) {
        S0(this.f1797f.getString(i2));
    }

    public j S() {
        return this.f1798g;
    }

    public void S0(CharSequence charSequence) {
        if ((charSequence != null || this.o == null) && (charSequence == null || charSequence.equals(this.o))) {
            return;
        }
        this.o = charSequence;
        e0();
    }

    public SharedPreferences T() {
        if (this.f1798g == null || R() != null) {
            return null;
        }
        return this.f1798g.j();
    }

    public final void T0(boolean z) {
        if (this.D != z) {
            this.D = z;
            b bVar = this.N;
            if (bVar != null) {
                bVar.b(this);
            }
        }
    }

    public CharSequence U() {
        if (V() != null) {
            return V().a(this);
        }
        return this.p;
    }

    public boolean U0() {
        return !a0();
    }

    public final f V() {
        return this.T;
    }

    protected boolean V0() {
        return this.f1798g != null && b0() && Y();
    }

    public CharSequence W() {
        return this.o;
    }

    public final int X() {
        return this.M;
    }

    public boolean Y() {
        return !TextUtils.isEmpty(this.s);
    }

    public boolean Z() {
        return this.J;
    }

    public boolean a0() {
        return this.w && this.B && this.C;
    }

    public boolean b0() {
        return this.y;
    }

    public boolean c0() {
        return this.x;
    }

    public final boolean d0() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e0() {
        b bVar = this.N;
        if (bVar != null) {
            bVar.e(this);
        }
    }

    public void f0(boolean z) {
        List<Preference> list = this.O;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2).m0(this, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(PreferenceGroup preferenceGroup) {
        if (preferenceGroup != null && this.P != null) {
            throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
        }
        this.P = preferenceGroup;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g0() {
        b bVar = this.N;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void h0() {
        C0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i0(j jVar) {
        this.f1798g = jVar;
        if (!this.f1801j) {
            this.f1800i = jVar.d();
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j0(j jVar, long j2) {
        this.f1800i = j2;
        this.f1801j = true;
        try {
            i0(jVar);
        } finally {
            this.f1801j = false;
        }
    }

    public boolean k(Object obj) {
        c cVar = this.f1802k;
        return cVar == null || cVar.a(this, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k0(l lVar) {
        Integer num;
        TextView textView;
        ImageView imageView;
        View a2;
        boolean Z;
        View view = lVar.itemView;
        view.setOnClickListener(this.U);
        view.setId(this.n);
        TextView textView2 = (TextView) lVar.a(R.id.summary);
        if (textView2 != null) {
            CharSequence U = U();
            if (!TextUtils.isEmpty(U)) {
                textView2.setText(U);
                textView2.setVisibility(0);
                num = Integer.valueOf(textView2.getCurrentTextColor());
                textView = (TextView) lVar.a(R.id.title);
                if (textView != null) {
                    CharSequence W = W();
                    if (!TextUtils.isEmpty(W)) {
                        textView.setText(W);
                        textView.setVisibility(0);
                        if (this.G) {
                            textView.setSingleLine(this.H);
                        }
                        if (!c0() && a0() && num != null) {
                            textView.setTextColor(num.intValue());
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                }
                imageView = (ImageView) lVar.a(R.id.icon);
                if (imageView != null) {
                    int i2 = this.q;
                    if (i2 != 0 || this.r != null) {
                        if (this.r == null) {
                            this.r = c.a.k.a.a.d(this.f1797f, i2);
                        }
                        Drawable drawable = this.r;
                        if (drawable != null) {
                            imageView.setImageDrawable(drawable);
                        }
                    }
                    if (this.r != null) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(this.I ? 4 : 8);
                    }
                }
                a2 = lVar.a(p.a);
                if (a2 == null) {
                    a2 = lVar.a(R.id.icon_frame);
                }
                if (a2 != null) {
                    if (this.r != null) {
                        a2.setVisibility(0);
                    } else {
                        a2.setVisibility(this.I ? 4 : 8);
                    }
                }
                if (!this.K) {
                    H0(view, a0());
                } else {
                    H0(view, true);
                }
                boolean c0 = c0();
                view.setFocusable(c0);
                view.setClickable(c0);
                lVar.d(this.E);
                lVar.e(this.F);
                Z = Z();
                if (Z && this.S == null) {
                    this.S = new e(this);
                }
                view.setOnCreateContextMenuListener(!Z ? this.S : null);
                view.setLongClickable(Z);
                if (Z || c0) {
                }
                u.m0(view, null);
                return;
            }
            textView2.setVisibility(8);
        }
        num = null;
        textView = (TextView) lVar.a(R.id.title);
        if (textView != null) {
        }
        imageView = (ImageView) lVar.a(R.id.icon);
        if (imageView != null) {
        }
        a2 = lVar.a(p.a);
        if (a2 == null) {
        }
        if (a2 != null) {
        }
        if (!this.K) {
        }
        boolean c02 = c0();
        view.setFocusable(c02);
        view.setClickable(c02);
        lVar.d(this.E);
        lVar.e(this.F);
        Z = Z();
        if (Z) {
            this.S = new e(this);
        }
        view.setOnCreateContextMenuListener(!Z ? this.S : null);
        view.setLongClickable(Z);
        if (Z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l0() {
    }

    public void m0(Preference preference, boolean z) {
        if (this.B == z) {
            this.B = !z;
            f0(U0());
            e0();
        }
    }

    public void n0() {
        X0();
        this.Q = true;
    }

    protected Object o0(TypedArray typedArray, int i2) {
        return null;
    }

    @Deprecated
    public void p0(androidx.core.view.d0.c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q() {
        this.Q = false;
    }

    public void q0(Preference preference, boolean z) {
        if (this.C == z) {
            this.C = !z;
            f0(U0());
            e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r0() {
        X0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s0(Parcelable parcelable) {
        this.R = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Parcelable t0() {
        this.R = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public String toString() {
        return F().toString();
    }

    @Override // java.lang.Comparable
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i2 = this.m;
        int i3 = preference.m;
        if (i2 != i3) {
            return i2 - i3;
        }
        CharSequence charSequence = this.o;
        CharSequence charSequence2 = preference.o;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.o.toString());
    }

    protected void u0(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(Bundle bundle) {
        Parcelable parcelable;
        if (!Y() || (parcelable = bundle.getParcelable(this.s)) == null) {
            return;
        }
        this.R = false;
        s0(parcelable);
        if (!this.R) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    @Deprecated
    protected void v0(boolean z, Object obj) {
        u0(obj);
    }

    public void w0() {
        j.c f2;
        if (a0() && c0()) {
            l0();
            d dVar = this.l;
            if (dVar == null || !dVar.onPreferenceClick(this)) {
                j S = S();
                if ((S == null || (f2 = S.f()) == null || !f2.onPreferenceTreeClick(this)) && this.t != null) {
                    D().startActivity(this.t);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(Bundle bundle) {
        if (Y()) {
            this.R = false;
            Parcelable t0 = t0();
            if (!this.R) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (t0 != null) {
                bundle.putParcelable(this.s, t0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x0(View view) {
        w0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean y0(boolean z) {
        if (!V0()) {
            return false;
        }
        if (z == N(!z)) {
            return true;
        }
        if (R() == null) {
            SharedPreferences.Editor c2 = this.f1798g.c();
            c2.putBoolean(this.s, z);
            W0(c2);
            return true;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z0(int i2) {
        if (!V0()) {
            return false;
        }
        if (i2 == O(i2 ^ (-1))) {
            return true;
        }
        if (R() == null) {
            SharedPreferences.Editor c2 = this.f1798g.c();
            c2.putInt(this.s, i2);
            W0(c2);
            return true;
        }
        throw null;
    }

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.d.g.a(context, m.f1871i, R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
