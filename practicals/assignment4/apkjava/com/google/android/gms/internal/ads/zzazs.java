package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzk;

@zzard
/* loaded from: classes2.dex */
public final class zzazs {
    private final View a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f14308b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f14309c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f14310d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f14311e;

    /* renamed from: f, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f14312f;

    /* renamed from: g, reason: collision with root package name */
    private ViewTreeObserver.OnScrollChangedListener f14313g = null;

    public zzazs(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.f14308b = activity;
        this.a = view;
        this.f14312f = onGlobalLayoutListener;
    }

    private static ViewTreeObserver d(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    private final void g() {
        ViewTreeObserver d2;
        if (this.f14309c) {
            return;
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f14312f;
        if (onGlobalLayoutListener != null) {
            Activity activity = this.f14308b;
            if (activity != null && (d2 = d(activity)) != null) {
                d2.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            zzk.zzmd();
            zzbbz.a(this.a, this.f14312f);
        }
        this.f14309c = true;
    }

    private final void h() {
        ViewTreeObserver d2;
        Activity activity = this.f14308b;
        if (activity != null && this.f14309c) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f14312f;
            if (onGlobalLayoutListener != null && (d2 = d(activity)) != null) {
                zzk.zzli().i(d2, onGlobalLayoutListener);
            }
            this.f14309c = false;
        }
    }

    public final void a() {
        this.f14310d = true;
        if (this.f14311e) {
            g();
        }
    }

    public final void b() {
        this.f14310d = false;
        h();
    }

    public final void c(Activity activity) {
        this.f14308b = activity;
    }

    public final void e() {
        this.f14311e = true;
        if (this.f14310d) {
            g();
        }
    }

    public final void f() {
        this.f14311e = false;
        h();
    }
}
