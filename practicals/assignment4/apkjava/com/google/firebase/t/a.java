package com.google.firebase.t;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.google.firebase.q.c;

/* compiled from: DataCollectionConfigStorage.java */
/* loaded from: classes2.dex */
public class a {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final SharedPreferences f20127b;

    /* renamed from: c, reason: collision with root package name */
    private final c f20128c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f20129d;

    public a(Context context, String str, c cVar) {
        Context a = a(context);
        this.a = a;
        this.f20127b = a.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f20128c = cVar;
        this.f20129d = c();
    }

    private static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : androidx.core.content.a.b(context);
    }

    private boolean c() {
        if (this.f20127b.contains("firebase_data_collection_default_enabled")) {
            return this.f20127b.getBoolean("firebase_data_collection_default_enabled", true);
        }
        return d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized boolean b() {
        return this.f20129d;
    }
}
