package com.facebook.internal;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;

/* compiled from: InstallReferrerUtil.kt */
/* loaded from: classes2.dex */
public final class g0 {
    public static final g0 a = new g0();

    /* compiled from: InstallReferrerUtil.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);
    }

    /* compiled from: InstallReferrerUtil.kt */
    /* loaded from: classes2.dex */
    public static final class b implements InstallReferrerStateListener {
        final /* synthetic */ InstallReferrerClient a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f9775b;

        b(InstallReferrerClient installReferrerClient, a aVar) {
            this.a = installReferrerClient;
            this.f9775b = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        
            if (r0 != false) goto L14;
         */
        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i2) {
            boolean J;
            boolean J2;
            if (i2 == 0) {
                try {
                    ReferrerDetails b2 = this.a.b();
                    kotlin.jvm.internal.m.e(b2, "{\n                      referrerClient.installReferrer\n                    }");
                    String a = b2.a();
                    if (a != null) {
                        J = kotlin.text.v.J(a, "fb", false, 2, null);
                        if (!J) {
                            J2 = kotlin.text.v.J(a, "facebook", false, 2, null);
                        }
                        this.f9775b.a(a);
                    }
                    g0.a.e();
                } catch (RemoteException | Exception unused) {
                    return;
                }
            } else if (i2 == 2) {
                g0.a.e();
            }
            this.a.a();
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void b() {
        }
    }

    private g0() {
    }

    private final boolean b() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        return com.facebook.a0.c().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("is_referrer_updated", false);
    }

    private final void c(a aVar) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        InstallReferrerClient a2 = InstallReferrerClient.c(com.facebook.a0.c()).a();
        try {
            a2.d(new b(a2, aVar));
        } catch (Exception unused) {
        }
    }

    public static final void d(a aVar) {
        kotlin.jvm.internal.m.f(aVar, "callback");
        g0 g0Var = a;
        if (g0Var.b()) {
            return;
        }
        g0Var.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        com.facebook.a0.c().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("is_referrer_updated", true).apply();
    }
}
