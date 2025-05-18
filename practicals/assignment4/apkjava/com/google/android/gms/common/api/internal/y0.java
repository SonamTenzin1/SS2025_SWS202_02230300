package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
final class y0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f11797f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f11798g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ zzd f11799h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(zzd zzdVar, LifecycleCallback lifecycleCallback, String str) {
        this.f11799h = zzdVar;
        this.f11797f = lifecycleCallback;
        this.f11798g = str;
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
        zzd zzdVar = this.f11799h;
        i2 = zzdVar.f11893h;
        if (i2 > 0) {
            LifecycleCallback lifecycleCallback = this.f11797f;
            bundle = zzdVar.f11894i;
            if (bundle != null) {
                bundle3 = zzdVar.f11894i;
                bundle2 = bundle3.getBundle(this.f11798g);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.e(bundle2);
        }
        i3 = this.f11799h.f11893h;
        if (i3 >= 2) {
            this.f11797f.i();
        }
        i4 = this.f11799h.f11893h;
        if (i4 >= 3) {
            this.f11797f.g();
        }
        i5 = this.f11799h.f11893h;
        if (i5 >= 4) {
            this.f11797f.j();
        }
        i6 = this.f11799h.f11893h;
        if (i6 >= 5) {
            this.f11797f.f();
        }
    }
}
