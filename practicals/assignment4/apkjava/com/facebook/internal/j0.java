package com.facebook.internal;

import android.util.Log;
import cm.aptoide.pt.database.room.RoomNotification;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: Logger.kt */
/* loaded from: classes2.dex */
public final class j0 {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, String> f9783b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final com.facebook.g0 f9784c;

    /* renamed from: d, reason: collision with root package name */
    private final String f9785d;

    /* renamed from: e, reason: collision with root package name */
    private StringBuilder f9786e;

    /* renamed from: f, reason: collision with root package name */
    private int f9787f;

    /* compiled from: Logger.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final synchronized String f(String str) {
            String str2;
            str2 = str;
            for (Map.Entry entry : j0.f9783b.entrySet()) {
                str2 = kotlin.text.u.A(str2, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
            }
            return str2;
        }

        public final void a(com.facebook.g0 g0Var, int i2, String str, String str2) {
            boolean E;
            kotlin.jvm.internal.m.f(g0Var, "behavior");
            kotlin.jvm.internal.m.f(str, StoreTabGridRecyclerFragment.BundleCons.TAG);
            kotlin.jvm.internal.m.f(str2, "string");
            com.facebook.a0 a0Var = com.facebook.a0.a;
            if (com.facebook.a0.y(g0Var)) {
                String f2 = f(str2);
                E = kotlin.text.u.E(str, "FacebookSDK.", false, 2, null);
                if (!E) {
                    str = kotlin.jvm.internal.m.n("FacebookSDK.", str);
                }
                Log.println(i2, str, f2);
                if (g0Var == com.facebook.g0.DEVELOPER_ERRORS) {
                    new Exception().printStackTrace();
                }
            }
        }

        public final void b(com.facebook.g0 g0Var, String str, String str2) {
            kotlin.jvm.internal.m.f(g0Var, "behavior");
            kotlin.jvm.internal.m.f(str, StoreTabGridRecyclerFragment.BundleCons.TAG);
            kotlin.jvm.internal.m.f(str2, "string");
            a(g0Var, 3, str, str2);
        }

        public final void c(com.facebook.g0 g0Var, String str, String str2, Object... objArr) {
            kotlin.jvm.internal.m.f(g0Var, "behavior");
            kotlin.jvm.internal.m.f(str, StoreTabGridRecyclerFragment.BundleCons.TAG);
            kotlin.jvm.internal.m.f(str2, "format");
            kotlin.jvm.internal.m.f(objArr, "args");
            com.facebook.a0 a0Var = com.facebook.a0.a;
            if (com.facebook.a0.y(g0Var)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
                kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
                a(g0Var, 3, str, format);
            }
        }

        public final synchronized void d(String str) {
            kotlin.jvm.internal.m.f(str, "accessToken");
            com.facebook.a0 a0Var = com.facebook.a0.a;
            if (!com.facebook.a0.y(com.facebook.g0.INCLUDE_ACCESS_TOKENS)) {
                e(str, "ACCESS_TOKEN_REMOVED");
            }
        }

        public final synchronized void e(String str, String str2) {
            kotlin.jvm.internal.m.f(str, "original");
            kotlin.jvm.internal.m.f(str2, "replace");
            j0.f9783b.put(str, str2);
        }
    }

    public j0(com.facebook.g0 g0Var, String str) {
        kotlin.jvm.internal.m.f(g0Var, "behavior");
        kotlin.jvm.internal.m.f(str, StoreTabGridRecyclerFragment.BundleCons.TAG);
        this.f9787f = 3;
        this.f9784c = g0Var;
        q0 q0Var = q0.a;
        this.f9785d = kotlin.jvm.internal.m.n("FacebookSDK.", q0.k(str, StoreTabGridRecyclerFragment.BundleCons.TAG));
        this.f9786e = new StringBuilder();
    }

    private final boolean g() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        return com.facebook.a0.y(this.f9784c);
    }

    public final void b(String str) {
        kotlin.jvm.internal.m.f(str, "string");
        if (g()) {
            this.f9786e.append(str);
        }
    }

    public final void c(String str, Object... objArr) {
        kotlin.jvm.internal.m.f(str, "format");
        kotlin.jvm.internal.m.f(objArr, "args");
        if (g()) {
            StringBuilder sb = this.f9786e;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
            kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
            sb.append(format);
        }
    }

    public final void d(String str, Object obj) {
        kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
        kotlin.jvm.internal.m.f(obj, "value");
        c("  %s:\t%s\n", str, obj);
    }

    public final void e() {
        String sb = this.f9786e.toString();
        kotlin.jvm.internal.m.e(sb, "contents.toString()");
        f(sb);
        this.f9786e = new StringBuilder();
    }

    public final void f(String str) {
        kotlin.jvm.internal.m.f(str, "string");
        a.a(this.f9784c, this.f9787f, this.f9785d, str);
    }
}
