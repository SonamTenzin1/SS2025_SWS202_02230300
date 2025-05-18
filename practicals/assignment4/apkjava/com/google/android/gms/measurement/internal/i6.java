package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class i6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f17819f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17820g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17821h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ String f17822i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzm f17823j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzik f17824k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i6(zzik zzikVar, AtomicReference atomicReference, String str, String str2, String str3, zzm zzmVar) {
        this.f17824k = zzikVar;
        this.f17819f = atomicReference;
        this.f17820g = str;
        this.f17821h = str2;
        this.f17822i = str3;
        this.f17823j = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        synchronized (this.f17819f) {
            try {
                try {
                    zzelVar = this.f17824k.f18193d;
                } catch (RemoteException e2) {
                    this.f17824k.h().H().d("Failed to get conditional properties", zzet.x(this.f17820g), this.f17821h, e2);
                    this.f17819f.set(Collections.emptyList());
                }
                if (zzelVar == null) {
                    this.f17824k.h().H().d("Failed to get conditional properties", zzet.x(this.f17820g), this.f17821h, this.f17822i);
                    this.f17819f.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.f17820g)) {
                    this.f17819f.set(zzelVar.A2(this.f17821h, this.f17822i, this.f17823j));
                } else {
                    this.f17819f.set(zzelVar.r3(this.f17820g, this.f17821h, this.f17822i));
                }
                this.f17824k.d0();
                this.f17819f.notify();
            } finally {
                this.f17819f.notify();
            }
        }
    }
}
