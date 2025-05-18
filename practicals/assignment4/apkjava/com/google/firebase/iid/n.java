package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.List;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class n {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private String f19649b;

    /* renamed from: c, reason: collision with root package name */
    private String f19650c;

    /* renamed from: d, reason: collision with root package name */
    private int f19651d;

    /* renamed from: e, reason: collision with root package name */
    private int f19652e = 0;

    public n(Context context) {
        this.a = context;
    }

    public static String c(com.google.firebase.j jVar) {
        String d2 = jVar.l().d();
        if (d2 != null) {
            return d2;
        }
        String c2 = jVar.l().c();
        if (!c2.startsWith("1:")) {
            return c2;
        }
        String[] split = c2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo f2 = f(this.a.getPackageName());
        if (f2 != null) {
            this.f19649b = Integer.toString(f2.versionCode);
            this.f19650c = f2.versionName;
        }
    }

    public synchronized String a() {
        if (this.f19649b == null) {
            h();
        }
        return this.f19649b;
    }

    public synchronized String b() {
        if (this.f19650c == null) {
            h();
        }
        return this.f19650c;
    }

    public synchronized int d() {
        PackageInfo f2;
        if (this.f19651d == 0 && (f2 = f("com.google.android.gms")) != null) {
            this.f19651d = f2.versionCode;
        }
        return this.f19651d;
    }

    public synchronized int e() {
        int i2 = this.f19652e;
        if (i2 != 0) {
            return i2;
        }
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i3 = 1;
        if (!PlatformVersion.k()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f19652e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f19652e = 2;
            return 2;
        }
        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.k()) {
            this.f19652e = 2;
            i3 = 2;
        } else {
            this.f19652e = 1;
        }
        return i3;
    }

    @KeepForSdk
    public boolean g() {
        return e() != 0;
    }
}
