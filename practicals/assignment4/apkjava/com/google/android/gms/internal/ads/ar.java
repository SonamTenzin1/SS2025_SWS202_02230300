package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ar implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzda f12266f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(zzda zzdaVar) {
        this.f12266f = zzdaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        boolean z;
        zzdy zzdyVar;
        ConditionVariable conditionVariable2;
        if (this.f12266f.f15819e != null) {
            return;
        }
        conditionVariable = zzda.a;
        synchronized (conditionVariable) {
            if (this.f12266f.f15819e != null) {
                return;
            }
            boolean z2 = false;
            try {
                z = ((Boolean) zzyt.e().c(zzacu.i2)).booleanValue();
            } catch (IllegalStateException unused) {
                z = false;
            }
            if (z) {
                try {
                    zzdyVar = this.f12266f.f15818d;
                    zzda.f15816b = new zzwo(zzdyVar.f16182b, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z2 = z;
            this.f12266f.f15819e = Boolean.valueOf(z2);
            conditionVariable2 = zzda.a;
            conditionVariable2.open();
        }
    }
}
