package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
final class n5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17884f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Uri f17885g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17886h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ String f17887i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ l5 f17888j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n5(l5 l5Var, boolean z, Uri uri, String str, String str2) {
        this.f17888j = l5Var;
        this.f17884f = z;
        this.f17885g = uri;
        this.f17886h = str;
        this.f17887i = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17888j.b(this.f17884f, this.f17885g, this.f17886h, this.f17887i);
    }
}
