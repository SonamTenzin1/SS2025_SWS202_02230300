package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
final class x0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f11794f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f11795g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ zzb f11796h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0(zzb zzbVar, LifecycleCallback lifecycleCallback, String str) {
        this.f11796h = zzbVar;
        this.f11794f = lifecycleCallback;
        this.f11795g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        zzb zzbVar = this.f11796h;
        i2 = zzbVar.f11889h;
        if (i2 > 0) {
            LifecycleCallback lifecycleCallback = this.f11794f;
            bundle = zzbVar.f11890i;
            if (bundle != null) {
                bundle3 = zzbVar.f11890i;
                bundle2 = bundle3.getBundle(this.f11795g);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.e(bundle2);
        }
        i3 = this.f11796h.f11889h;
        if (i3 >= 2) {
            this.f11794f.i();
        }
        i4 = this.f11796h.f11889h;
        if (i4 >= 3) {
            this.f11794f.g();
        }
        i5 = this.f11796h.f11889h;
        if (i5 >= 4) {
            this.f11794f.j();
        }
        i6 = this.f11796h.f11889h;
        if (i6 >= 5) {
            this.f11794f.f();
        }
    }
}
