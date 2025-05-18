package com.bumptech.glide.p.l;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* compiled from: NotificationTarget.java */
/* loaded from: classes.dex */
public class f extends g<Bitmap> {

    /* renamed from: f, reason: collision with root package name */
    private final RemoteViews f9515f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f9516g;

    /* renamed from: h, reason: collision with root package name */
    private final int f9517h;

    /* renamed from: i, reason: collision with root package name */
    private final String f9518i;

    /* renamed from: j, reason: collision with root package name */
    private final Notification f9519j;

    /* renamed from: k, reason: collision with root package name */
    private final int f9520k;

    private void d() {
        ((NotificationManager) com.bumptech.glide.r.j.d((NotificationManager) this.f9516g.getSystemService("notification"))).notify(this.f9518i, this.f9517h, this.f9519j);
    }

    @Override // com.bumptech.glide.p.l.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onResourceReady(Bitmap bitmap, com.bumptech.glide.p.m.d<? super Bitmap> dVar) {
        this.f9515f.setImageViewBitmap(this.f9520k, bitmap);
        d();
    }
}
