package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class Storage {
    private static final Lock a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    private static Storage f11535b;

    /* renamed from: c, reason: collision with root package name */
    private final Lock f11536c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    private final SharedPreferences f11537d;

    @VisibleForTesting
    private Storage(Context context) {
        this.f11537d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @KeepForSdk
    public static Storage b(Context context) {
        Preconditions.k(context);
        Lock lock = a;
        lock.lock();
        try {
            if (f11535b == null) {
                f11535b = new Storage(context.getApplicationContext());
            }
            Storage storage = f11535b;
            lock.unlock();
            return storage;
        } catch (Throwable th) {
            a.unlock();
            throw th;
        }
    }

    private final void g(String str, String str2) {
        this.f11536c.lock();
        try {
            this.f11537d.edit().putString(str, str2).apply();
        } finally {
            this.f11536c.unlock();
        }
    }

    private static String h(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    @VisibleForTesting
    private final GoogleSignInAccount i(String str) {
        String k2;
        if (!TextUtils.isEmpty(str) && (k2 = k(h("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.a1(k2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @VisibleForTesting
    private final GoogleSignInOptions j(String str) {
        String k2;
        if (!TextUtils.isEmpty(str) && (k2 = k(h("googleSignInOptions", str))) != null) {
            try {
                return GoogleSignInOptions.M0(k2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final String k(String str) {
        this.f11536c.lock();
        try {
            return this.f11537d.getString(str, null);
        } finally {
            this.f11536c.unlock();
        }
    }

    private final void m(String str) {
        this.f11536c.lock();
        try {
            this.f11537d.edit().remove(str).apply();
        } finally {
            this.f11536c.unlock();
        }
    }

    @KeepForSdk
    public void a() {
        this.f11536c.lock();
        try {
            this.f11537d.edit().clear().apply();
        } finally {
            this.f11536c.unlock();
        }
    }

    @KeepForSdk
    public GoogleSignInAccount c() {
        return i(k("defaultGoogleSignInAccount"));
    }

    @KeepForSdk
    public GoogleSignInOptions d() {
        return j(k("defaultGoogleSignInAccount"));
    }

    @KeepForSdk
    public String e() {
        return k("refreshToken");
    }

    @KeepForSdk
    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Preconditions.k(googleSignInAccount);
        Preconditions.k(googleSignInOptions);
        g("defaultGoogleSignInAccount", googleSignInAccount.r1());
        Preconditions.k(googleSignInAccount);
        Preconditions.k(googleSignInOptions);
        String r1 = googleSignInAccount.r1();
        g(h("googleSignInAccount", r1), googleSignInAccount.s1());
        g(h("googleSignInOptions", r1), googleSignInOptions.t1());
    }

    public final void l() {
        String k2 = k("defaultGoogleSignInAccount");
        m("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(k2)) {
            return;
        }
        m(h("googleSignInAccount", k2));
        m(h("googleSignInOptions", k2));
    }
}
