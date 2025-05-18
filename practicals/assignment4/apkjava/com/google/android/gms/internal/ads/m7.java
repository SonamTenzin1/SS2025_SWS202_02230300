package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@zzard
/* loaded from: classes2.dex */
abstract class m7 {

    /* renamed from: f, reason: collision with root package name */
    private final WeakReference<View> f12964f;

    public m7(View view) {
        this.f12964f = new WeakReference<>(view);
    }

    private final ViewTreeObserver c() {
        ViewTreeObserver viewTreeObserver;
        View view = this.f12964f.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    public final void a() {
        ViewTreeObserver c2 = c();
        if (c2 != null) {
            d(c2);
        }
    }

    public final void b() {
        ViewTreeObserver c2 = c();
        if (c2 != null) {
            e(c2);
        }
    }

    protected abstract void d(ViewTreeObserver viewTreeObserver);

    protected abstract void e(ViewTreeObserver viewTreeObserver);
}
