package com.google.firebase.crashlytics.internal.n;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.crashlytics.internal.h;

/* compiled from: BatteryState.java */
/* loaded from: classes2.dex */
class p {
    private final Float a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f19072b;

    private p(Float f2, boolean z) {
        this.f19072b = z;
        this.a = f2;
    }

    public static p a(Context context) {
        Float f2 = null;
        boolean z = false;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z = e(registerReceiver);
                f2 = d(registerReceiver);
            }
        } catch (IllegalStateException e2) {
            h.f().e("An error occurred getting battery state.", e2);
        }
        return new p(f2, z);
    }

    private static Float d(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(intExtra / intExtra2);
    }

    private static boolean e(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }

    public Float b() {
        return this.a;
    }

    public int c() {
        Float f2;
        if (!this.f19072b || (f2 = this.a) == null) {
            return 1;
        }
        return ((double) f2.floatValue()) < 0.99d ? 2 : 3;
    }
}
