package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import cm.aptoide.pt.notification.PullingContentService;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.c0;
import com.facebook.internal.p0;
import com.facebook.v;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AccessTokenManager.kt */
/* loaded from: classes.dex */
public final class v {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static v f10572b;

    /* renamed from: c, reason: collision with root package name */
    private final c.q.a.a f10573c;

    /* renamed from: d, reason: collision with root package name */
    private final u f10574d;

    /* renamed from: e, reason: collision with root package name */
    private AccessToken f10575e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f10576f;

    /* renamed from: g, reason: collision with root package name */
    private Date f10577g;

    /* compiled from: AccessTokenManager.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GraphRequest c(AccessToken accessToken, GraphRequest.b bVar) {
            e f2 = f(accessToken);
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", f2.a());
            bundle.putString("client_id", accessToken.c());
            bundle.putString("fields", "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            GraphRequest x = GraphRequest.a.x(accessToken, f2.b(), bVar);
            x.H(bundle);
            x.G(e0.GET);
            return x;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GraphRequest d(AccessToken accessToken, GraphRequest.b bVar) {
            Bundle bundle = new Bundle();
            bundle.putString("fields", "permission,status");
            GraphRequest x = GraphRequest.a.x(accessToken, "me/permissions", bVar);
            x.H(bundle);
            x.G(e0.GET);
            return x;
        }

        private final e f(AccessToken accessToken) {
            String h2 = accessToken.h();
            if (h2 == null) {
                h2 = "facebook";
            }
            return kotlin.jvm.internal.m.a(h2, "instagram") ? new c() : new b();
        }

        public final v e() {
            v vVar;
            v vVar2 = v.f10572b;
            if (vVar2 != null) {
                return vVar2;
            }
            synchronized (this) {
                vVar = v.f10572b;
                if (vVar == null) {
                    a0 a0Var = a0.a;
                    c.q.a.a b2 = c.q.a.a.b(a0.c());
                    kotlin.jvm.internal.m.e(b2, "getInstance(applicationContext)");
                    v vVar3 = new v(b2, new u());
                    a aVar = v.a;
                    v.f10572b = vVar3;
                    vVar = vVar3;
                }
            }
            return vVar;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    /* loaded from: classes.dex */
    public static final class b implements e {
        private final String a = "oauth/access_token";

        /* renamed from: b, reason: collision with root package name */
        private final String f10578b = "fb_extend_sso_token";

        @Override // com.facebook.v.e
        public String a() {
            return this.f10578b;
        }

        @Override // com.facebook.v.e
        public String b() {
            return this.a;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    /* loaded from: classes.dex */
    public static final class c implements e {
        private final String a = "refresh_access_token";

        /* renamed from: b, reason: collision with root package name */
        private final String f10579b = "ig_refresh_token";

        @Override // com.facebook.v.e
        public String a() {
            return this.f10579b;
        }

        @Override // com.facebook.v.e
        public String b() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AccessTokenManager.kt */
    /* loaded from: classes.dex */
    public static final class d {
        private String a;

        /* renamed from: b, reason: collision with root package name */
        private int f10580b;

        /* renamed from: c, reason: collision with root package name */
        private int f10581c;

        /* renamed from: d, reason: collision with root package name */
        private Long f10582d;

        /* renamed from: e, reason: collision with root package name */
        private String f10583e;

        public final String a() {
            return this.a;
        }

        public final Long b() {
            return this.f10582d;
        }

        public final int c() {
            return this.f10580b;
        }

        public final int d() {
            return this.f10581c;
        }

        public final String e() {
            return this.f10583e;
        }

        public final void f(String str) {
            this.a = str;
        }

        public final void g(Long l) {
            this.f10582d = l;
        }

        public final void h(int i2) {
            this.f10580b = i2;
        }

        public final void i(int i2) {
            this.f10581c = i2;
        }

        public final void j(String str) {
            this.f10583e = str;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    /* loaded from: classes.dex */
    public interface e {
        String a();

        String b();
    }

    public v(c.q.a.a aVar, u uVar) {
        kotlin.jvm.internal.m.f(aVar, "localBroadcastManager");
        kotlin.jvm.internal.m.f(uVar, "accessTokenCache");
        this.f10573c = aVar;
        this.f10574d = uVar;
        this.f10576f = new AtomicBoolean(false);
        this.f10577g = new Date(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(v vVar, AccessToken.a aVar) {
        kotlin.jvm.internal.m.f(vVar, "this$0");
        vVar.m(aVar);
    }

    private final void m(final AccessToken.a aVar) {
        final AccessToken e2 = e();
        if (e2 == null) {
            if (aVar == null) {
                return;
            }
            aVar.a(new FacebookException("No current access token to refresh"));
            return;
        }
        if (!this.f10576f.compareAndSet(false, true)) {
            if (aVar == null) {
                return;
            }
            aVar.a(new FacebookException("Refresh already in progress"));
            return;
        }
        this.f10577g = new Date();
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        final HashSet hashSet3 = new HashSet();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final d dVar = new d();
        a aVar2 = a;
        c0 c0Var = new c0(aVar2.d(e2, new GraphRequest.b() { // from class: com.facebook.d
            @Override // com.facebook.GraphRequest.b
            public final void b(d0 d0Var) {
                v.n(atomicBoolean, hashSet, hashSet2, hashSet3, d0Var);
            }
        }), aVar2.c(e2, new GraphRequest.b() { // from class: com.facebook.b
            @Override // com.facebook.GraphRequest.b
            public final void b(d0 d0Var) {
                v.o(v.d.this, d0Var);
            }
        }));
        c0Var.g(new c0.a() { // from class: com.facebook.c
            @Override // com.facebook.c0.a
            public final void a(c0 c0Var2) {
                v.p(v.d.this, e2, aVar, atomicBoolean, hashSet, hashSet2, hashSet3, this, c0Var2);
            }
        });
        c0Var.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, d0 d0Var) {
        JSONArray optJSONArray;
        kotlin.jvm.internal.m.f(atomicBoolean, "$permissionsCallSucceeded");
        kotlin.jvm.internal.m.f(set, "$permissions");
        kotlin.jvm.internal.m.f(set2, "$declinedPermissions");
        kotlin.jvm.internal.m.f(set3, "$expiredPermissions");
        kotlin.jvm.internal.m.f(d0Var, "response");
        JSONObject d2 = d0Var.d();
        if (d2 == null || (optJSONArray = d2.optJSONArray("data")) == null) {
            return;
        }
        atomicBoolean.set(true);
        int i2 = 0;
        int length = optJSONArray.length();
        if (length <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("permission");
                String optString2 = optJSONObject.optString("status");
                p0 p0Var = p0.a;
                if (!p0.a0(optString) && !p0.a0(optString2)) {
                    kotlin.jvm.internal.m.e(optString2, "status");
                    Locale locale = Locale.US;
                    kotlin.jvm.internal.m.e(locale, "US");
                    String lowerCase = optString2.toLowerCase(locale);
                    kotlin.jvm.internal.m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    kotlin.jvm.internal.m.e(lowerCase, "status");
                    int hashCode = lowerCase.hashCode();
                    if (hashCode == -1309235419) {
                        if (lowerCase.equals("expired")) {
                            set3.add(optString);
                        }
                        Log.w("AccessTokenManager", kotlin.jvm.internal.m.n("Unexpected status: ", lowerCase));
                    } else if (hashCode == 280295099) {
                        if (lowerCase.equals("granted")) {
                            set.add(optString);
                        }
                        Log.w("AccessTokenManager", kotlin.jvm.internal.m.n("Unexpected status: ", lowerCase));
                    } else {
                        if (hashCode == 568196142 && lowerCase.equals("declined")) {
                            set2.add(optString);
                        }
                        Log.w("AccessTokenManager", kotlin.jvm.internal.m.n("Unexpected status: ", lowerCase));
                    }
                }
            }
            if (i3 >= length) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(d dVar, d0 d0Var) {
        kotlin.jvm.internal.m.f(dVar, "$refreshResult");
        kotlin.jvm.internal.m.f(d0Var, "response");
        JSONObject d2 = d0Var.d();
        if (d2 == null) {
            return;
        }
        dVar.f(d2.optString("access_token"));
        dVar.h(d2.optInt("expires_at"));
        dVar.i(d2.optInt("expires_in"));
        dVar.g(Long.valueOf(d2.optLong("data_access_expiration_time")));
        dVar.j(d2.optString("graph_domain", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(d dVar, AccessToken accessToken, AccessToken.a aVar, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, v vVar, c0 c0Var) {
        AccessToken accessToken2;
        Date d2;
        kotlin.jvm.internal.m.f(dVar, "$refreshResult");
        kotlin.jvm.internal.m.f(atomicBoolean, "$permissionsCallSucceeded");
        kotlin.jvm.internal.m.f(set, "$permissions");
        kotlin.jvm.internal.m.f(set2, "$declinedPermissions");
        kotlin.jvm.internal.m.f(set3, "$expiredPermissions");
        kotlin.jvm.internal.m.f(vVar, "this$0");
        kotlin.jvm.internal.m.f(c0Var, "it");
        String a2 = dVar.a();
        int c2 = dVar.c();
        Long b2 = dVar.b();
        String e2 = dVar.e();
        try {
            a aVar2 = a;
            if (aVar2.e().e() != null) {
                AccessToken e3 = aVar2.e().e();
                if ((e3 == null ? null : e3.m()) == accessToken.m()) {
                    if (!atomicBoolean.get() && a2 == null && c2 == 0) {
                        if (aVar != null) {
                            aVar.a(new FacebookException("Failed to refresh access token"));
                        }
                        vVar.f10576f.set(false);
                        return;
                    }
                    Date g2 = accessToken.g();
                    if (dVar.c() != 0) {
                        g2 = new Date(dVar.c() * 1000);
                    } else if (dVar.d() != 0) {
                        g2 = new Date((dVar.d() * 1000) + new Date().getTime());
                    }
                    Date date = g2;
                    if (a2 == null) {
                        a2 = accessToken.l();
                    }
                    String str = a2;
                    String c3 = accessToken.c();
                    String m = accessToken.m();
                    Set j2 = atomicBoolean.get() ? set : accessToken.j();
                    Set e4 = atomicBoolean.get() ? set2 : accessToken.e();
                    Set f2 = atomicBoolean.get() ? set3 : accessToken.f();
                    w k2 = accessToken.k();
                    Date date2 = new Date();
                    if (b2 != null) {
                        d2 = new Date(b2.longValue() * 1000);
                    } else {
                        d2 = accessToken.d();
                    }
                    Date date3 = d2;
                    if (e2 == null) {
                        e2 = accessToken.h();
                    }
                    AccessToken accessToken3 = new AccessToken(str, c3, m, j2, e4, f2, k2, date, date2, date3, e2);
                    try {
                        aVar2.e().r(accessToken3);
                        vVar.f10576f.set(false);
                        if (aVar != null) {
                            aVar.b(accessToken3);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        accessToken2 = accessToken3;
                        vVar.f10576f.set(false);
                        if (aVar != null && accessToken2 != null) {
                            aVar.b(accessToken2);
                        }
                        throw th;
                    }
                }
            }
            if (aVar != null) {
                aVar.a(new FacebookException("No current access token to refresh"));
            }
            vVar.f10576f.set(false);
        } catch (Throwable th2) {
            th = th2;
            accessToken2 = null;
        }
    }

    private final void q(AccessToken accessToken, AccessToken accessToken2) {
        a0 a0Var = a0.a;
        Intent intent = new Intent(a0.c(), (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.f10573c.d(intent);
    }

    private final void s(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.f10575e;
        this.f10575e = accessToken;
        this.f10576f.set(false);
        this.f10577g = new Date(0L);
        if (z) {
            if (accessToken != null) {
                this.f10574d.g(accessToken);
            } else {
                this.f10574d.a();
                p0 p0Var = p0.a;
                a0 a0Var = a0.a;
                p0.g(a0.c());
            }
        }
        p0 p0Var2 = p0.a;
        if (p0.c(accessToken2, accessToken)) {
            return;
        }
        q(accessToken2, accessToken);
        t();
    }

    private final void t() {
        PendingIntent broadcast;
        a0 a0Var = a0.a;
        Context c2 = a0.c();
        AccessToken.c cVar = AccessToken.f9559f;
        AccessToken e2 = cVar.e();
        AlarmManager alarmManager = (AlarmManager) c2.getSystemService("alarm");
        if (cVar.g()) {
            if ((e2 == null ? null : e2.g()) == null || alarmManager == null) {
                return;
            }
            Intent intent = new Intent(c2, (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
            intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
            if (Build.VERSION.SDK_INT >= 23) {
                broadcast = PendingIntent.getBroadcast(c2, 0, intent, 67108864);
            } else {
                broadcast = PendingIntent.getBroadcast(c2, 0, intent, 0);
            }
            try {
                alarmManager.set(1, e2.g().getTime(), broadcast);
            } catch (Exception unused) {
            }
        }
    }

    private final boolean u() {
        AccessToken e2 = e();
        if (e2 == null) {
            return false;
        }
        long time = new Date().getTime();
        return e2.k().k() && time - this.f10577g.getTime() > 3600000 && time - e2.i().getTime() > PullingContentService.UPDATES_INTERVAL;
    }

    public final void c() {
        q(e(), e());
    }

    public final void d() {
        if (u()) {
            k(null);
        }
    }

    public final AccessToken e() {
        return this.f10575e;
    }

    public final boolean j() {
        AccessToken f2 = this.f10574d.f();
        if (f2 == null) {
            return false;
        }
        s(f2, false);
        return true;
    }

    public final void k(final AccessToken.a aVar) {
        if (kotlin.jvm.internal.m.a(Looper.getMainLooper(), Looper.myLooper())) {
            m(aVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.a
                @Override // java.lang.Runnable
                public final void run() {
                    v.l(v.this, aVar);
                }
            });
        }
    }

    public final void r(AccessToken accessToken) {
        s(accessToken, true);
    }
}
