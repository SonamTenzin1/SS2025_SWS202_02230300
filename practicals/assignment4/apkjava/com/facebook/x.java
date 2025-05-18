package com.facebook;

import android.content.SharedPreferences;
import org.json.JSONException;

/* compiled from: AuthenticationTokenCache.kt */
/* loaded from: classes.dex */
public final class x {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final SharedPreferences f10590b;

    /* compiled from: AuthenticationTokenCache.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public x(SharedPreferences sharedPreferences) {
        kotlin.jvm.internal.m.f(sharedPreferences, "sharedPreferences");
        this.f10590b = sharedPreferences;
    }

    public final void a() {
        this.f10590b.edit().remove("com.facebook.AuthenticationManager.CachedAuthenticationToken").apply();
    }

    public final void b(AuthenticationToken authenticationToken) {
        kotlin.jvm.internal.m.f(authenticationToken, "authenticationToken");
        try {
            this.f10590b.edit().putString("com.facebook.AuthenticationManager.CachedAuthenticationToken", authenticationToken.b().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public x() {
        this(r0);
        a0 a0Var = a0.a;
        SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.AuthenticationTokenManager.SharedPreferences", 0);
        kotlin.jvm.internal.m.e(sharedPreferences, "FacebookSdk.getApplicationContext()\n              .getSharedPreferences(\n                  AuthenticationTokenManager.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)");
    }
}
