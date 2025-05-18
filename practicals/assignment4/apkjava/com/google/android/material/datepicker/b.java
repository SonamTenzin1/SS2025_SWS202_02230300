package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CalendarStyle.java */
/* loaded from: classes2.dex */
public final class b {
    final a a;

    /* renamed from: b, reason: collision with root package name */
    final a f18566b;

    /* renamed from: c, reason: collision with root package name */
    final a f18567c;

    /* renamed from: d, reason: collision with root package name */
    final a f18568d;

    /* renamed from: e, reason: collision with root package name */
    final a f18569e;

    /* renamed from: f, reason: collision with root package name */
    final a f18570f;

    /* renamed from: g, reason: collision with root package name */
    final a f18571g;

    /* renamed from: h, reason: collision with root package name */
    final Paint f18572h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e.e.b.c.x.b.c(context, e.e.b.c.b.v, e.class.getCanonicalName()), e.e.b.c.l.O2);
        this.a = a.a(context, obtainStyledAttributes.getResourceId(e.e.b.c.l.R2, 0));
        this.f18571g = a.a(context, obtainStyledAttributes.getResourceId(e.e.b.c.l.P2, 0));
        this.f18566b = a.a(context, obtainStyledAttributes.getResourceId(e.e.b.c.l.Q2, 0));
        this.f18567c = a.a(context, obtainStyledAttributes.getResourceId(e.e.b.c.l.S2, 0));
        ColorStateList a = e.e.b.c.x.c.a(context, obtainStyledAttributes, e.e.b.c.l.T2);
        this.f18568d = a.a(context, obtainStyledAttributes.getResourceId(e.e.b.c.l.V2, 0));
        this.f18569e = a.a(context, obtainStyledAttributes.getResourceId(e.e.b.c.l.U2, 0));
        this.f18570f = a.a(context, obtainStyledAttributes.getResourceId(e.e.b.c.l.W2, 0));
        Paint paint = new Paint();
        this.f18572h = paint;
        paint.setColor(a.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
