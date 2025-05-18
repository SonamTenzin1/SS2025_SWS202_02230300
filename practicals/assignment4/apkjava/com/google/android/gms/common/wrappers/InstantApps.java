package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class InstantApps {
    private static Context a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f12171b;

    @KeepForSdk
    public static synchronized boolean a(Context context) {
        Boolean bool;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = a;
            if (context2 != null && (bool = f12171b) != null && context2 == applicationContext) {
                return bool.booleanValue();
            }
            f12171b = null;
            if (PlatformVersion.k()) {
                f12171b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f12171b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    f12171b = Boolean.FALSE;
                }
            }
            a = applicationContext;
            return f12171b.booleanValue();
        }
    }
}
