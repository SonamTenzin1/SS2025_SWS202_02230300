package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
public final class zzp {
    private static zzp a;

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private Storage f11544b;

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private GoogleSignInAccount f11545c;

    /* renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    private GoogleSignInOptions f11546d;

    private zzp(Context context) {
        Storage b2 = Storage.b(context);
        this.f11544b = b2;
        this.f11545c = b2.c();
        this.f11546d = this.f11544b.d();
    }

    public static synchronized zzp c(Context context) {
        zzp d2;
        synchronized (zzp.class) {
            d2 = d(context.getApplicationContext());
        }
        return d2;
    }

    private static synchronized zzp d(Context context) {
        zzp zzpVar;
        synchronized (zzp.class) {
            if (a == null) {
                a = new zzp(context);
            }
            zzpVar = a;
        }
        return zzpVar;
    }

    public final synchronized void a() {
        this.f11544b.a();
        this.f11545c = null;
        this.f11546d = null;
    }

    public final synchronized void b(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f11544b.f(googleSignInAccount, googleSignInOptions);
        this.f11545c = googleSignInAccount;
        this.f11546d = googleSignInOptions;
    }
}
