package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class l6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f17852f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17853g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17854h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ String f17855i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f17856j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzm f17857k;
    private final /* synthetic */ zzik l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l6(zzik zzikVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzm zzmVar) {
        this.l = zzikVar;
        this.f17852f = atomicReference;
        this.f17853g = str;
        this.f17854h = str2;
        this.f17855i = str3;
        this.f17856j = z;
        this.f17857k = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        synchronized (this.f17852f) {
            try {
                try {
                    zzelVar = this.l.f18193d;
                } catch (RemoteException e2) {
                    this.l.h().H().d("Failed to get user properties", zzet.x(this.f17853g), this.f17854h, e2);
                    this.f17852f.set(Collections.emptyList());
                }
                if (zzelVar == null) {
                    this.l.h().H().d("Failed to get user properties", zzet.x(this.f17853g), this.f17854h, this.f17855i);
                    this.f17852f.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.f17853g)) {
                    this.f17852f.set(zzelVar.f3(this.f17854h, this.f17855i, this.f17856j, this.f17857k));
                } else {
                    this.f17852f.set(zzelVar.K1(this.f17853g, this.f17854h, this.f17855i, this.f17856j));
                }
                this.l.d0();
                this.f17852f.notify();
            } finally {
                this.f17852f.notify();
            }
        }
    }
}
