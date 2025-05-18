package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback.java */
/* loaded from: classes.dex */
public abstract class j<E> extends f {

    /* renamed from: f, reason: collision with root package name */
    private final Activity f1616f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f1617g;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f1618h;

    /* renamed from: i, reason: collision with root package name */
    private final int f1619i;

    /* renamed from: j, reason: collision with root package name */
    final FragmentManager f1620j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this(dVar, dVar, new Handler(), 0);
    }

    @Override // androidx.fragment.app.f
    public View c(int i2) {
        return null;
    }

    @Override // androidx.fragment.app.f
    public boolean d() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity e() {
        return this.f1616f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context f() {
        return this.f1617g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler g() {
        return this.f1618h;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E i();

    public LayoutInflater j() {
        return LayoutInflater.from(this.f1617g);
    }

    @Deprecated
    public void k(Fragment fragment, String[] strArr, int i2) {
    }

    public boolean l(Fragment fragment) {
        return true;
    }

    public boolean m(String str) {
        return false;
    }

    public void n(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            androidx.core.content.a.k(this.f1617g, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void o(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            androidx.core.app.a.v(this.f1616f, intentSender, i2, intent, i3, i4, i5, bundle);
            return;
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public void p() {
    }

    j(Activity activity, Context context, Handler handler, int i2) {
        this.f1620j = new m();
        this.f1616f = activity;
        this.f1617g = (Context) c.i.j.i.d(context, "context == null");
        this.f1618h = (Handler) c.i.j.i.d(handler, "handler == null");
        this.f1619i = i2;
    }
}
