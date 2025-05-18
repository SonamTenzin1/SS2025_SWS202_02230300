package com.google.firebase.crashlytics.internal;

import android.content.Context;
import com.google.firebase.crashlytics.internal.n.t;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DevelopmentPlatformProvider.java */
/* loaded from: classes2.dex */
public class g {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private b f18999b = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DevelopmentPlatformProvider.java */
    /* loaded from: classes2.dex */
    public class b {
        private final String a;

        /* renamed from: b, reason: collision with root package name */
        private final String f19000b;

        private b() {
            int p = t.p(g.this.a, "com.google.firebase.crashlytics.unity_version", "string");
            if (p == 0) {
                if (g.this.c("flutter_assets/NOTICES.Z")) {
                    this.a = "Flutter";
                    this.f19000b = null;
                    h.f().i("Development platform is: Flutter");
                    return;
                } else {
                    this.a = null;
                    this.f19000b = null;
                    return;
                }
            }
            this.a = "Unity";
            String string = g.this.a.getResources().getString(p);
            this.f19000b = string;
            h.f().i("Unity Editor version is: " + string);
        }
    }

    public g(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        if (this.a.getAssets() == null) {
            return false;
        }
        try {
            InputStream open = this.a.getAssets().open(str);
            if (open != null) {
                open.close();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private b f() {
        if (this.f18999b == null) {
            this.f18999b = new b();
        }
        return this.f18999b;
    }

    public String d() {
        return f().a;
    }

    public String e() {
        return f().f19000b;
    }
}
