package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class o0 implements m0 {
    private static o0 a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f17232b;

    /* renamed from: c, reason: collision with root package name */
    private final ContentObserver f17233c;

    private o0(Context context) {
        this.f17232b = context;
        q0 q0Var = new q0(this, null);
        this.f17233c = q0Var;
        context.getContentResolver().registerContentObserver(zzbw.a, true, q0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o0 a(Context context) {
        o0 o0Var;
        synchronized (o0.class) {
            if (a == null) {
                a = androidx.core.content.c.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new o0(context) : new o0();
            }
            o0Var = a;
        }
        return o0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b() {
        Context context;
        synchronized (o0.class) {
            o0 o0Var = a;
            if (o0Var != null && (context = o0Var.f17232b) != null && o0Var.f17233c != null) {
                context.getContentResolver().unregisterContentObserver(a.f17233c);
            }
            a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.m0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final String u(final String str) {
        if (this.f17232b == null) {
            return null;
        }
        try {
            return (String) zzce.a(new zzcd(this, str) { // from class: com.google.android.gms.internal.measurement.n0
                private final o0 a;

                /* renamed from: b, reason: collision with root package name */
                private final String f17223b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f17223b = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzcd
                public final Object a() {
                    return this.a.c(this.f17223b);
                }
            });
        } catch (IllegalStateException | SecurityException e2) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String c(String str) {
        return zzbw.a(this.f17232b.getContentResolver(), str, null);
    }

    private o0() {
        this.f17232b = null;
        this.f17233c = null;
    }
}
