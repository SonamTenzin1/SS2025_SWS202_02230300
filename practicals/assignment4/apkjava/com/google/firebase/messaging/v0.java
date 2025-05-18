package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
final class v0 {
    private static final long a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b, reason: collision with root package name */
    private static final Object f19880b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static WakeLock f19881c;

    private static void a(Context context) {
        if (f19881c == null) {
            WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f19881c = wakeLock;
            wakeLock.c(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Intent intent) {
        synchronized (f19880b) {
            if (f19881c != null && c(intent)) {
                d(intent, false);
                f19881c.b();
            }
        }
    }

    static boolean c(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    private static void d(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ComponentName e(Context context, Intent intent) {
        synchronized (f19880b) {
            a(context);
            boolean c2 = c(intent);
            d(intent, true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!c2) {
                f19881c.a(a);
            }
            return startService;
        }
    }
}
