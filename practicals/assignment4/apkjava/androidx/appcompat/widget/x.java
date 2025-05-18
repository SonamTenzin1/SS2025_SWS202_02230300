package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;

/* compiled from: DecorToolbar.java */
/* loaded from: classes.dex */
public interface x {
    void a(Menu menu, m.a aVar);

    boolean b();

    void c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    void h();

    void i(j0 j0Var);

    boolean j();

    void k(int i2);

    Menu l();

    void m(int i2);

    int n();

    androidx.core.view.y o(int i2, long j2);

    void p(m.a aVar, g.a aVar2);

    void q(int i2);

    ViewGroup r();

    void s(boolean z);

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    int t();

    void u();

    void v();

    void w(boolean z);
}
