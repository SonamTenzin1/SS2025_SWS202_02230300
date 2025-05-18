package io.sentry.android.core;

import android.content.Context;
import android.os.SystemClock;
import io.sentry.Integration;
import io.sentry.a4;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.f4;
import io.sentry.i3;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* compiled from: SentryAndroid.java */
/* loaded from: classes2.dex */
public final class g1 {
    private static final f4 a = h0.a();

    /* renamed from: b, reason: collision with root package name */
    private static final long f22136b = SystemClock.uptimeMillis();

    private static void a(x4 x4Var, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Integration integration : x4Var.getIntegrations()) {
            if (z && (integration instanceof FragmentLifecycleIntegration)) {
                arrayList2.add(integration);
            }
            if (z2 && (integration instanceof SentryTimberIntegration)) {
                arrayList.add(integration);
            }
        }
        if (arrayList2.size() > 1) {
            for (int i2 = 0; i2 < arrayList2.size() - 1; i2++) {
                x4Var.getIntegrations().remove((Integration) arrayList2.get(i2));
            }
        }
        if (arrayList.size() > 1) {
            for (int i3 = 0; i3 < arrayList.size() - 1; i3++) {
                x4Var.getIntegrations().remove((Integration) arrayList.get(i3));
            }
        }
    }

    public static void b(Context context, w1 w1Var) {
        c(context, w1Var, new a4.a() { // from class: io.sentry.android.core.c0
            @Override // io.sentry.a4.a
            public final void a(x4 x4Var) {
                g1.d((SentryAndroidOptions) x4Var);
            }
        });
    }

    public static synchronized void c(final Context context, final w1 w1Var, final a4.a<SentryAndroidOptions> aVar) {
        synchronized (g1.class) {
            q0.e().i(f22136b, a);
            try {
                try {
                    a4.k(i3.a(SentryAndroidOptions.class), new a4.a() { // from class: io.sentry.android.core.b0
                        @Override // io.sentry.a4.a
                        public final void a(x4 x4Var) {
                            g1.e(w1.this, context, aVar, (SentryAndroidOptions) x4Var);
                        }
                    }, true);
                    v1 j2 = a4.j();
                    if (j2.q().isEnableAutoSessionTracking() && t0.m(context)) {
                        j2.i(io.sentry.android.core.internal.util.i.a("session.start"));
                        j2.startSession();
                    }
                } catch (InstantiationException e2) {
                    w1Var.b(s4.FATAL, "Fatal error during SentryAndroid.init(...)", e2);
                    throw new RuntimeException("Failed to initialize Sentry's SDK", e2);
                } catch (InvocationTargetException e3) {
                    w1Var.b(s4.FATAL, "Fatal error during SentryAndroid.init(...)", e3);
                    throw new RuntimeException("Failed to initialize Sentry's SDK", e3);
                }
            } catch (IllegalAccessException e4) {
                w1Var.b(s4.FATAL, "Fatal error during SentryAndroid.init(...)", e4);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e4);
            } catch (NoSuchMethodException e5) {
                w1Var.b(s4.FATAL, "Fatal error during SentryAndroid.init(...)", e5);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(SentryAndroidOptions sentryAndroidOptions) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(w1 w1Var, Context context, a4.a aVar, SentryAndroidOptions sentryAndroidOptions) {
        b1 b1Var = new b1();
        boolean b2 = b1Var.b("timber.log.Timber", sentryAndroidOptions);
        boolean z = b1Var.b("androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks", sentryAndroidOptions) && b1Var.b("io.sentry.android.fragment.FragmentLifecycleIntegration", sentryAndroidOptions);
        boolean z2 = b2 && b1Var.b("io.sentry.android.timber.SentryTimberIntegration", sentryAndroidOptions);
        s0 s0Var = new s0(w1Var);
        b1 b1Var2 = new b1();
        f0 f0Var = new f0(b1Var2, sentryAndroidOptions);
        k0.i(sentryAndroidOptions, context, w1Var, s0Var);
        k0.d(context, sentryAndroidOptions, s0Var, b1Var2, f0Var, z, z2);
        aVar.a(sentryAndroidOptions);
        k0.c(sentryAndroidOptions, context, s0Var, b1Var2, f0Var);
        a(sentryAndroidOptions, z, z2);
    }
}
