package com.facebook.o0.s0;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.a0;
import com.facebook.internal.p0;
import com.facebook.o0.v;
import java.util.List;
import java.util.Set;
import kotlin.collections.t;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;

/* compiled from: OnDeviceProcessingManager.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final c a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f10478b;

    static {
        Set<String> i2;
        i2 = w0.i("fb_mobile_purchase", "StartTrial", "Subscribe");
        f10478b = i2;
    }

    private c() {
    }

    private final boolean a(v vVar) {
        return (vVar.h() ^ true) || (vVar.h() && f10478b.contains(vVar.f()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean b() {
        boolean z;
        a0 a0Var = a0.a;
        if (!a0.q(a0.c())) {
            p0 p0Var = p0.a;
            if (!p0.X()) {
                z = true;
                if (z) {
                    e eVar = e.a;
                    if (e.b()) {
                        return true;
                    }
                }
                return false;
            }
        }
        z = false;
        if (z) {
        }
        return false;
    }

    public static final void e(final String str, final v vVar) {
        m.f(str, "applicationId");
        m.f(vVar, "event");
        if (a.a(vVar)) {
            a0 a0Var = a0.a;
            a0.k().execute(new Runnable() { // from class: com.facebook.o0.s0.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.f(str, vVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, v vVar) {
        List e2;
        m.f(str, "$applicationId");
        m.f(vVar, "$event");
        e eVar = e.a;
        e2 = t.e(vVar);
        e.c(str, e2);
    }

    public static final void g(final String str, final String str2) {
        a0 a0Var = a0.a;
        final Context c2 = a0.c();
        if (c2 == null || str == null || str2 == null) {
            return;
        }
        a0.k().execute(new Runnable() { // from class: com.facebook.o0.s0.a
            @Override // java.lang.Runnable
            public final void run() {
                c.h(c2, str2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Context context, String str, String str2) {
        m.f(context, "$context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        String n = m.n(str2, "pingForOnDevice");
        if (sharedPreferences.getLong(n, 0L) == 0) {
            e eVar = e.a;
            e.e(str2);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(n, System.currentTimeMillis());
            edit.apply();
        }
    }
}
