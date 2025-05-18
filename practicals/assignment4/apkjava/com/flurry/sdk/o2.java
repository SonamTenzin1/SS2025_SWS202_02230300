package com.flurry.sdk;

import android.content.Context;

/* loaded from: classes2.dex */
public final class o2 {
    public static boolean a(String str) {
        Context a = b0.a();
        if (a != null) {
            return a.checkCallingOrSelfPermission(str) == 0;
        }
        d1.c(6, "PermissionUtil", "Context is null when checking permission.");
        return false;
    }
}
