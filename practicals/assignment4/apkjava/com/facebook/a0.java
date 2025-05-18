package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.a0;
import com.facebook.internal.a0;
import com.facebook.internal.p0;
import com.facebook.internal.q0;
import com.facebook.internal.r;
import com.facebook.o0.a0;
import com.facebook.o0.q0.h;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.w0;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FacebookSdk.kt */
/* loaded from: classes.dex */
public final class a0 {
    public static final a0 a = new a0();

    /* renamed from: b, reason: collision with root package name */
    private static final String f9644b = a0.class.getCanonicalName();

    /* renamed from: c, reason: collision with root package name */
    private static final HashSet<g0> f9645c;

    /* renamed from: d, reason: collision with root package name */
    private static Executor f9646d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile String f9647e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile String f9648f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile String f9649g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile Boolean f9650h;

    /* renamed from: i, reason: collision with root package name */
    private static AtomicLong f9651i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f9652j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f9653k;
    private static com.facebook.internal.i0<File> l;
    private static Context m;
    private static int n;
    private static final ReentrantLock o;
    private static String p;
    public static boolean q;
    public static boolean r;
    public static boolean s;
    private static final AtomicBoolean t;
    private static volatile String u;
    private static volatile String v;
    private static a w;
    private static boolean x;

    /* compiled from: FacebookSdk.kt */
    /* loaded from: classes.dex */
    public interface a {
        GraphRequest a(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.b bVar);
    }

    /* compiled from: FacebookSdk.kt */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    static {
        HashSet<g0> e2;
        e2 = w0.e(g0.DEVELOPER_ERRORS);
        f9645c = e2;
        f9651i = new AtomicLong(65536L);
        n = 64206;
        o = new ReentrantLock();
        com.facebook.internal.n0 n0Var = com.facebook.internal.n0.a;
        p = com.facebook.internal.n0.a();
        t = new AtomicBoolean(false);
        u = "instagram.com";
        v = "facebook.com";
        w = new a() { // from class: com.facebook.n
            @Override // com.facebook.a0.a
            public final GraphRequest a(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.b bVar) {
                GraphRequest t2;
                t2 = a0.t(accessToken, str, jSONObject, bVar);
                return t2;
            }
        };
    }

    private a0() {
    }

    public static final void I(Context context) {
        boolean E;
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            kotlin.jvm.internal.m.e(applicationInfo, "try {\n          context.packageManager.getApplicationInfo(\n              context.packageName, PackageManager.GET_META_DATA)\n        } catch (e: PackageManager.NameNotFoundException) {\n          return\n        }");
            if (applicationInfo.metaData == null) {
                return;
            }
            if (f9647e == null) {
                Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                if (obj instanceof String) {
                    String str = (String) obj;
                    Locale locale = Locale.ROOT;
                    kotlin.jvm.internal.m.e(locale, "ROOT");
                    String lowerCase = str.toLowerCase(locale);
                    kotlin.jvm.internal.m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    E = kotlin.text.u.E(lowerCase, "fb", false, 2, null);
                    if (E) {
                        String substring = str.substring(2);
                        kotlin.jvm.internal.m.e(substring, "(this as java.lang.String).substring(startIndex)");
                        f9647e = substring;
                    } else {
                        f9647e = str;
                    }
                } else if (obj instanceof Number) {
                    throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                }
            }
            if (f9648f == null) {
                f9648f = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
            }
            if (f9649g == null) {
                f9649g = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
            }
            if (n == 64206) {
                n = applicationInfo.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
            }
            if (f9650h == null) {
                f9650h = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final void J(Context context, String str) {
        try {
            com.facebook.internal.q e2 = com.facebook.internal.q.a.e(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
            String n2 = kotlin.jvm.internal.m.n(str, "ping");
            long j2 = sharedPreferences.getLong(n2, 0L);
            try {
                com.facebook.o0.q0.h hVar = com.facebook.o0.q0.h.a;
                JSONObject a2 = com.facebook.o0.q0.h.a(h.a.MOBILE_INSTALL_EVENT, e2, com.facebook.o0.a0.a.c(context), q(context), context);
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String format = String.format("%s/activities", Arrays.copyOf(new Object[]{str}, 1));
                kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
                GraphRequest a3 = w.a(null, format, a2, null);
                if (j2 == 0 && a3.j().b() == null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong(n2, System.currentTimeMillis());
                    edit.apply();
                }
            } catch (JSONException e3) {
                throw new FacebookException("An error occurred while publishing install.", e3);
            }
        } catch (Exception e4) {
            p0 p0Var = p0.a;
            p0.i0("Facebook-publish", e4);
        }
    }

    public static final void K(Context context, final String str) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(str, "applicationId");
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        k().execute(new Runnable() { // from class: com.facebook.k
            @Override // java.lang.Runnable
            public final void run() {
                a0.L(applicationContext, str);
            }
        });
        com.facebook.internal.a0 a0Var = com.facebook.internal.a0.a;
        if (com.facebook.internal.a0.g(a0.b.OnDeviceEventProcessing)) {
            com.facebook.o0.s0.c cVar = com.facebook.o0.s0.c.a;
            if (com.facebook.o0.s0.c.b()) {
                com.facebook.o0.s0.c.g(str, "com.facebook.sdk.attributionTracking");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Context context, String str) {
        kotlin.jvm.internal.m.f(context, "$applicationContext");
        kotlin.jvm.internal.m.f(str, "$applicationId");
        a.J(context, str);
    }

    public static final synchronized void M(Context context) {
        synchronized (a0.class) {
            kotlin.jvm.internal.m.f(context, "applicationContext");
            N(context, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:4:0x0003, B:11:0x0013, B:12:0x0018, B:14:0x0036, B:16:0x003e, B:21:0x004a, B:23:0x004e, B:26:0x0057, B:28:0x0060, B:29:0x0063, B:31:0x0067, B:33:0x006b, B:35:0x0073, B:37:0x0079, B:38:0x0081, B:39:0x0086, B:40:0x0087, B:42:0x0097, B:45:0x00db, B:46:0x00e0, B:47:0x00e1, B:48:0x00e6, B:49:0x00e7, B:50:0x00ee, B:52:0x00ef, B:53:0x00f6, B:55:0x00f7, B:56:0x00fc), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ef A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:4:0x0003, B:11:0x0013, B:12:0x0018, B:14:0x0036, B:16:0x003e, B:21:0x004a, B:23:0x004e, B:26:0x0057, B:28:0x0060, B:29:0x0063, B:31:0x0067, B:33:0x006b, B:35:0x0073, B:37:0x0079, B:38:0x0081, B:39:0x0086, B:40:0x0087, B:42:0x0097, B:45:0x00db, B:46:0x00e0, B:47:0x00e1, B:48:0x00e6, B:49:0x00e7, B:50:0x00ee, B:52:0x00ef, B:53:0x00f6, B:55:0x00f7, B:56:0x00fc), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized void N(Context context, final b bVar) {
        boolean z;
        synchronized (a0.class) {
            kotlin.jvm.internal.m.f(context, "applicationContext");
            AtomicBoolean atomicBoolean = t;
            if (atomicBoolean.get()) {
                if (bVar != null) {
                    bVar.a();
                }
                return;
            }
            q0 q0Var = q0.a;
            q0.e(context, false);
            q0.f(context, false);
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.m.e(applicationContext, "applicationContext.applicationContext");
            m = applicationContext;
            com.facebook.o0.a0.a.c(context);
            Context context2 = m;
            if (context2 != null) {
                I(context2);
                String str = f9647e;
                if (str != null && str.length() != 0) {
                    z = false;
                    if (z) {
                        String str2 = f9649g;
                        if (!(str2 == null || str2.length() == 0)) {
                            atomicBoolean.set(true);
                            if (f()) {
                                a();
                            }
                            Context context3 = m;
                            if (context3 != null) {
                                if (context3 instanceof Application) {
                                    n0 n0Var = n0.a;
                                    if (n0.c()) {
                                        com.facebook.o0.q0.f fVar = com.facebook.o0.q0.f.a;
                                        Context context4 = m;
                                        if (context4 == null) {
                                            kotlin.jvm.internal.m.w("applicationContext");
                                            throw null;
                                        }
                                        com.facebook.o0.q0.f.x((Application) context4, f9647e);
                                    }
                                }
                                com.facebook.internal.d0 d0Var = com.facebook.internal.d0.a;
                                com.facebook.internal.d0.g();
                                com.facebook.internal.k0 k0Var = com.facebook.internal.k0.a;
                                com.facebook.internal.k0.x();
                                r.a aVar = com.facebook.internal.r.a;
                                Context context5 = m;
                                if (context5 != null) {
                                    aVar.a(context5);
                                    l = new com.facebook.internal.i0<>(new Callable() { // from class: com.facebook.m
                                        @Override // java.util.concurrent.Callable
                                        public final Object call() {
                                            File O;
                                            O = a0.O();
                                            return O;
                                        }
                                    });
                                    com.facebook.internal.a0 a0Var = com.facebook.internal.a0.a;
                                    com.facebook.internal.a0.a(a0.b.Instrument, new a0.a() { // from class: com.facebook.f
                                        @Override // com.facebook.internal.a0.a
                                        public final void a(boolean z2) {
                                            a0.P(z2);
                                        }
                                    });
                                    com.facebook.internal.a0.a(a0.b.AppEvents, new a0.a() { // from class: com.facebook.j
                                        @Override // com.facebook.internal.a0.a
                                        public final void a(boolean z2) {
                                            a0.Q(z2);
                                        }
                                    });
                                    com.facebook.internal.a0.a(a0.b.ChromeCustomTabsPrefetching, new a0.a() { // from class: com.facebook.l
                                        @Override // com.facebook.internal.a0.a
                                        public final void a(boolean z2) {
                                            a0.R(z2);
                                        }
                                    });
                                    com.facebook.internal.a0.a(a0.b.IgnoreAppSwitchToLoggedOut, new a0.a() { // from class: com.facebook.g
                                        @Override // com.facebook.internal.a0.a
                                        public final void a(boolean z2) {
                                            a0.S(z2);
                                        }
                                    });
                                    com.facebook.internal.a0.a(a0.b.BypassAppSwitch, new a0.a() { // from class: com.facebook.h
                                        @Override // com.facebook.internal.a0.a
                                        public final void a(boolean z2) {
                                            a0.T(z2);
                                        }
                                    });
                                    k().execute(new FutureTask(new Callable() { // from class: com.facebook.i
                                        @Override // java.util.concurrent.Callable
                                        public final Object call() {
                                            Void U;
                                            U = a0.U(a0.b.this);
                                            return U;
                                        }
                                    }));
                                    return;
                                }
                                kotlin.jvm.internal.m.w("applicationContext");
                                throw null;
                            }
                            kotlin.jvm.internal.m.w("applicationContext");
                            throw null;
                        }
                        throw new FacebookException("A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk.");
                    }
                    throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
                }
                z = true;
                if (z) {
                }
            } else {
                kotlin.jvm.internal.m.w("applicationContext");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File O() {
        Context context = m;
        if (context != null) {
            return context.getCacheDir();
        }
        kotlin.jvm.internal.m.w("applicationContext");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(boolean z) {
        if (z) {
            com.facebook.internal.t0.j jVar = com.facebook.internal.t0.j.a;
            com.facebook.internal.t0.j.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(boolean z) {
        if (z) {
            com.facebook.o0.c0 c0Var = com.facebook.o0.c0.a;
            com.facebook.o0.c0.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(boolean z) {
        if (z) {
            q = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(boolean z) {
        if (z) {
            r = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(boolean z) {
        if (z) {
            s = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void U(b bVar) {
        v.a.e().j();
        i0.a.a().d();
        if (AccessToken.f9559f.g()) {
            Profile.b bVar2 = Profile.f9636f;
            if (bVar2.b() == null) {
                bVar2.a();
            }
        }
        if (bVar != null) {
            bVar.a();
        }
        a0.a aVar = com.facebook.o0.a0.a;
        aVar.f(c(), f9647e);
        n0 n0Var = n0.a;
        n0.k();
        Context applicationContext = c().getApplicationContext();
        kotlin.jvm.internal.m.e(applicationContext, "getApplicationContext().applicationContext");
        aVar.g(applicationContext).b();
        return null;
    }

    public static final void a() {
        x = true;
    }

    public static final boolean b() {
        n0 n0Var = n0.a;
        return n0.a();
    }

    public static final Context c() {
        q0 q0Var = q0.a;
        q0.l();
        Context context = m;
        if (context != null) {
            return context;
        }
        kotlin.jvm.internal.m.w("applicationContext");
        throw null;
    }

    public static final String d() {
        q0 q0Var = q0.a;
        q0.l();
        String str = f9647e;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    public static final String e() {
        q0 q0Var = q0.a;
        q0.l();
        return f9648f;
    }

    public static final boolean f() {
        n0 n0Var = n0.a;
        return n0.b();
    }

    public static final boolean g() {
        n0 n0Var = n0.a;
        return n0.c();
    }

    public static final int h() {
        q0 q0Var = q0.a;
        q0.l();
        return n;
    }

    public static final String i() {
        q0 q0Var = q0.a;
        q0.l();
        String str = f9649g;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
    }

    public static final boolean j() {
        n0 n0Var = n0.a;
        return n0.d();
    }

    public static final Executor k() {
        ReentrantLock reentrantLock = o;
        reentrantLock.lock();
        try {
            if (f9646d == null) {
                f9646d = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            kotlin.u uVar = kotlin.u.a;
            reentrantLock.unlock();
            Executor executor = f9646d;
            if (executor != null) {
                return executor;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final String l() {
        return v;
    }

    public static final String m() {
        return "fb.gg";
    }

    public static final String n() {
        p0 p0Var = p0.a;
        String str = f9644b;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{p}, 1));
        kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
        p0.j0(str, format);
        return p;
    }

    public static final String o() {
        AccessToken e2 = AccessToken.f9559f.e();
        String h2 = e2 != null ? e2.h() : null;
        p0 p0Var = p0.a;
        return p0.C(h2);
    }

    public static final String p() {
        return u;
    }

    public static final boolean q(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        q0 q0Var = q0.a;
        q0.l();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static final long r() {
        q0 q0Var = q0.a;
        q0.l();
        return f9651i.get();
    }

    public static final String s() {
        return "16.2.0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GraphRequest t(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.b bVar) {
        return GraphRequest.a.A(accessToken, str, jSONObject, bVar);
    }

    public static final boolean u() {
        return f9652j;
    }

    public static final synchronized boolean v() {
        boolean z;
        synchronized (a0.class) {
            z = x;
        }
        return z;
    }

    public static final boolean w() {
        return t.get();
    }

    public static final boolean x() {
        return f9653k;
    }

    public static final boolean y(g0 g0Var) {
        boolean z;
        kotlin.jvm.internal.m.f(g0Var, "behavior");
        HashSet<g0> hashSet = f9645c;
        synchronized (hashSet) {
            if (u()) {
                z = hashSet.contains(g0Var);
            }
        }
        return z;
    }
}
