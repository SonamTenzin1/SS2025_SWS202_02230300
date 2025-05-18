package com.facebook.o0.o0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.facebook.internal.a0;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.v;

/* compiled from: InAppPurchaseManager.kt */
/* loaded from: classes2.dex */
public final class k {
    public static final k a = new k();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10379b = new AtomicBoolean(false);

    private k() {
    }

    public static final void a() {
        f10379b.set(true);
        b();
    }

    public static final void b() {
        if (f10379b.get()) {
            if (a.c()) {
                a0 a0Var = a0.a;
                if (a0.g(a0.b.IapLoggingLib2)) {
                    g gVar = g.a;
                    com.facebook.a0 a0Var2 = com.facebook.a0.a;
                    g.d(com.facebook.a0.c());
                    return;
                }
            }
            f fVar = f.a;
            f.g();
        }
    }

    private final boolean c() {
        List v0;
        try {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            Context c2 = com.facebook.a0.c();
            ApplicationInfo applicationInfo = c2.getPackageManager().getApplicationInfo(c2.getPackageName(), 128);
            kotlin.jvm.internal.m.e(applicationInfo, "context.packageManager.getApplicationInfo(\n              context.packageName, PackageManager.GET_META_DATA)");
            String string = applicationInfo.metaData.getString("com.google.android.play.billingclient.version");
            if (string == null) {
                return false;
            }
            v0 = v.v0(string, new String[]{"."}, false, 3, 2, null);
            return Integer.parseInt((String) v0.get(0)) >= 2;
        } catch (Exception unused) {
            return false;
        }
    }
}
