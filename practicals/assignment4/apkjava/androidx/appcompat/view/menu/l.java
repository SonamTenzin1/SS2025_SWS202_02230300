package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.m;
import androidx.core.view.u;

/* compiled from: MenuPopupHelper.java */
/* loaded from: classes.dex */
public class l {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final g f338b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f339c;

    /* renamed from: d, reason: collision with root package name */
    private final int f340d;

    /* renamed from: e, reason: collision with root package name */
    private final int f341e;

    /* renamed from: f, reason: collision with root package name */
    private View f342f;

    /* renamed from: g, reason: collision with root package name */
    private int f343g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f344h;

    /* renamed from: i, reason: collision with root package name */
    private m.a f345i;

    /* renamed from: j, reason: collision with root package name */
    private k f346j;

    /* renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f347k;
    private final PopupWindow.OnDismissListener l;

    /* compiled from: MenuPopupHelper.java */
    /* loaded from: classes.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l.this.e();
        }
    }

    public l(Context context, g gVar, View view, boolean z, int i2) {
        this(context, gVar, view, z, i2, 0);
    }

    private k a() {
        k qVar;
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(c.a.d.f2703c)) {
            qVar = new d(this.a, this.f342f, this.f340d, this.f341e, this.f339c);
        } else {
            qVar = new q(this.a, this.f338b, this.f342f, this.f340d, this.f341e, this.f339c);
        }
        qVar.m(this.f338b);
        qVar.v(this.l);
        qVar.q(this.f342f);
        qVar.g(this.f345i);
        qVar.s(this.f344h);
        qVar.t(this.f343g);
        return qVar;
    }

    private void l(int i2, int i3, boolean z, boolean z2) {
        k c2 = c();
        c2.w(z2);
        if (z) {
            if ((androidx.core.view.d.b(this.f343g, u.y(this.f342f)) & 7) == 5) {
                i2 -= this.f342f.getWidth();
            }
            c2.u(i2);
            c2.x(i3);
            int i4 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c2.r(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        c2.show();
    }

    public void b() {
        if (d()) {
            this.f346j.dismiss();
        }
    }

    public k c() {
        if (this.f346j == null) {
            this.f346j = a();
        }
        return this.f346j;
    }

    public boolean d() {
        k kVar = this.f346j;
        return kVar != null && kVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f346j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f347k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f342f = view;
    }

    public void g(boolean z) {
        this.f344h = z;
        k kVar = this.f346j;
        if (kVar != null) {
            kVar.s(z);
        }
    }

    public void h(int i2) {
        this.f343g = i2;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f347k = onDismissListener;
    }

    public void j(m.a aVar) {
        this.f345i = aVar;
        k kVar = this.f346j;
        if (kVar != null) {
            kVar.g(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f342f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f342f == null) {
            return false;
        }
        l(i2, i3, true, true);
        return true;
    }

    public l(Context context, g gVar, View view, boolean z, int i2, int i3) {
        this.f343g = 8388611;
        this.l = new a();
        this.a = context;
        this.f338b = gVar;
        this.f342f = view;
        this.f339c = z;
        this.f340d = i2;
        this.f341e = i3;
    }
}
