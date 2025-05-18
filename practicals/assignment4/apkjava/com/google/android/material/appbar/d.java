package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.u;

/* compiled from: ViewOffsetHelper.java */
/* loaded from: classes2.dex */
class d {
    private final View a;

    /* renamed from: b, reason: collision with root package name */
    private int f18401b;

    /* renamed from: c, reason: collision with root package name */
    private int f18402c;

    /* renamed from: d, reason: collision with root package name */
    private int f18403d;

    /* renamed from: e, reason: collision with root package name */
    private int f18404e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f18405f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f18406g = true;

    public d(View view) {
        this.a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.a;
        u.U(view, this.f18403d - (view.getTop() - this.f18401b));
        View view2 = this.a;
        u.T(view2, this.f18404e - (view2.getLeft() - this.f18402c));
    }

    public int b() {
        return this.f18401b;
    }

    public int c() {
        return this.f18403d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f18401b = this.a.getTop();
        this.f18402c = this.a.getLeft();
    }

    public boolean e(int i2) {
        if (!this.f18406g || this.f18404e == i2) {
            return false;
        }
        this.f18404e = i2;
        a();
        return true;
    }

    public boolean f(int i2) {
        if (!this.f18405f || this.f18403d == i2) {
            return false;
        }
        this.f18403d = i2;
        a();
        return true;
    }
}
