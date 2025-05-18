package com.google.firebase;

import android.os.SystemClock;
import com.google.auto.value.AutoValue;

/* compiled from: StartupTime.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class n {
    public static n a(long j2, long j3, long j4) {
        return new g(j2, j3, j4);
    }

    public static n e() {
        return a(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long b();

    public abstract long c();

    public abstract long d();
}
