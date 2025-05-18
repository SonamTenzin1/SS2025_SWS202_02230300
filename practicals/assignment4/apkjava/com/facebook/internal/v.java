package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* compiled from: CustomTabUtils.kt */
/* loaded from: classes2.dex */
public final class v {
    public static final v a = new v();

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f9902b = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};

    private v() {
    }

    public static final String a() {
        HashSet S;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        Context c2 = com.facebook.a0.c();
        List<ResolveInfo> queryIntentServices = c2.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        kotlin.jvm.internal.m.e(queryIntentServices, "context.packageManager.queryIntentServices(serviceIntent, 0)");
        S = kotlin.collections.n.S(f9902b);
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            if (serviceInfo != null && S.contains(serviceInfo.packageName)) {
                return serviceInfo.packageName;
            }
        }
        return null;
    }

    public static final String b() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        return kotlin.jvm.internal.m.n("fbconnect://cct.", com.facebook.a0.c().getPackageName());
    }

    public static final String c(String str) {
        kotlin.jvm.internal.m.f(str, "developerDefinedRedirectURI");
        q0 q0Var = q0.a;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        return q0.d(com.facebook.a0.c(), str) ? str : q0.d(com.facebook.a0.c(), b()) ? b() : HttpUrl.FRAGMENT_ENCODE_SET;
    }
}
