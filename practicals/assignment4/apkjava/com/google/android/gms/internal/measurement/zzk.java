package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzk extends zzq {

    /* renamed from: f, reason: collision with root package name */
    private final AtomicReference<Bundle> f17485f = new AtomicReference<>();

    /* renamed from: g, reason: collision with root package name */
    private boolean f17486g;

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r4 = r4.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T P(Bundle bundle, Class<T> cls) {
        Object obj;
        if (bundle == null || obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e2) {
            Log.w("AM", String.format("Unexpected object type. Expected, Received".concat(": %s, %s"), cls.getCanonicalName(), obj.getClass().getCanonicalName()), e2);
            throw e2;
        }
    }

    public final Bundle E0(long j2) {
        Bundle bundle;
        synchronized (this.f17485f) {
            if (!this.f17486g) {
                try {
                    this.f17485f.wait(j2);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.f17485f.get();
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzn
    public final void J(Bundle bundle) {
        synchronized (this.f17485f) {
            try {
                this.f17485f.set(bundle);
                this.f17486g = true;
            } finally {
                this.f17485f.notify();
            }
        }
    }

    public final String k0(long j2) {
        return (String) P(E0(j2), String.class);
    }
}
