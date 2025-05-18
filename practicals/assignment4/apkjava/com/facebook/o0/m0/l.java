package com.facebook.o0.m0;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.d0;
import com.facebook.g0;
import com.facebook.internal.h0;
import com.facebook.internal.j0;
import com.facebook.internal.p0;
import com.facebook.o0.m0.l;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ViewIndexer.kt */
/* loaded from: classes.dex */
public final class l {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final String f10292b;

    /* renamed from: c, reason: collision with root package name */
    private static l f10293c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f10294d;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference<Activity> f10295e;

    /* renamed from: f, reason: collision with root package name */
    private Timer f10296f;

    /* renamed from: g, reason: collision with root package name */
    private String f10297g;

    /* compiled from: ViewIndexer.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(d0 d0Var) {
            kotlin.jvm.internal.m.f(d0Var, "it");
            j0.a.b(g0.APP_EVENTS, l.f10292b, "App index sent to FB!");
        }

        public final GraphRequest a(String str, AccessToken accessToken, String str2, String str3) {
            kotlin.jvm.internal.m.f(str3, "requestType");
            if (str == null) {
                return null;
            }
            GraphRequest.c cVar = GraphRequest.a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format(Locale.US, "%s/app_indexing", Arrays.copyOf(new Object[]{str2}, 1));
            kotlin.jvm.internal.m.e(format, "java.lang.String.format(locale, format, *args)");
            GraphRequest A = cVar.A(accessToken, format, null, null);
            Bundle t = A.t();
            if (t == null) {
                t = new Bundle();
            }
            t.putString("tree", str);
            com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
            t.putString("app_version", com.facebook.o0.q0.g.d());
            t.putString("platform", "android");
            t.putString("request_type", str3);
            if (kotlin.jvm.internal.m.a(str3, "app_indexing")) {
                i iVar = i.a;
                t.putString("device_session_id", i.e());
            }
            A.H(t);
            A.D(new GraphRequest.b() { // from class: com.facebook.o0.m0.f
                @Override // com.facebook.GraphRequest.b
                public final void b(d0 d0Var) {
                    l.a.b(d0Var);
                }
            });
            return A;
        }
    }

    /* compiled from: ViewIndexer.kt */
    /* loaded from: classes.dex */
    private static final class b implements Callable<String> {

        /* renamed from: f, reason: collision with root package name */
        private final WeakReference<View> f10298f;

        public b(View view) {
            kotlin.jvm.internal.m.f(view, "rootView");
            this.f10298f = new WeakReference<>(view);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            View view = this.f10298f.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            kotlin.jvm.internal.m.e(encodeToString, "encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)");
            return encodeToString;
        }
    }

    /* compiled from: ViewIndexer.kt */
    /* loaded from: classes.dex */
    public static final class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                Activity activity = (Activity) l.this.f10295e.get();
                com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
                View e2 = com.facebook.o0.q0.g.e(activity);
                if (activity != null && e2 != null) {
                    String simpleName = activity.getClass().getSimpleName();
                    i iVar = i.a;
                    if (i.f()) {
                        h0 h0Var = h0.a;
                        if (h0.b()) {
                            com.facebook.o0.m0.n.e eVar = com.facebook.o0.m0.n.e.a;
                            com.facebook.o0.m0.n.e.a();
                            return;
                        }
                        FutureTask futureTask = new FutureTask(new b(e2));
                        l.this.f10294d.post(futureTask);
                        String str = HttpUrl.FRAGMENT_ENCODE_SET;
                        try {
                            str = (String) futureTask.get(1L, TimeUnit.SECONDS);
                        } catch (Exception e3) {
                            Log.e(l.f10292b, "Failed to take screenshot.", e3);
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("screenname", simpleName);
                            jSONObject.put("screenshot", str);
                            JSONArray jSONArray = new JSONArray();
                            com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
                            jSONArray.put(com.facebook.o0.m0.n.f.d(e2));
                            jSONObject.put("view", jSONArray);
                        } catch (JSONException unused) {
                            Log.e(l.f10292b, "Failed to create JSONObject");
                        }
                        String jSONObject2 = jSONObject.toString();
                        kotlin.jvm.internal.m.e(jSONObject2, "viewTree.toString()");
                        l.this.j(jSONObject2);
                    }
                }
            } catch (Exception e4) {
                Log.e(l.f10292b, "UI Component tree indexing failure!", e4);
            }
        }
    }

    static {
        String canonicalName = l.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        f10292b = canonicalName;
    }

    public l(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        this.f10295e = new WeakReference<>(activity);
        this.f10297g = null;
        this.f10294d = new Handler(Looper.getMainLooper());
        f10293c = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(l lVar, TimerTask timerTask) {
        kotlin.jvm.internal.m.f(lVar, "this$0");
        kotlin.jvm.internal.m.f(timerTask, "$indexingTask");
        try {
            Timer timer = lVar.f10296f;
            if (timer != null) {
                timer.cancel();
            }
            lVar.f10297g = null;
            Timer timer2 = new Timer();
            timer2.scheduleAtFixedRate(timerTask, 0L, 1000L);
            lVar.f10296f = timer2;
        } catch (Exception e2) {
            Log.e(f10292b, "Error scheduling indexing job", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(final String str) {
        a0 a0Var = a0.a;
        a0.k().execute(new Runnable() { // from class: com.facebook.o0.m0.e
            @Override // java.lang.Runnable
            public final void run() {
                l.k(str, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String str, l lVar) {
        kotlin.jvm.internal.m.f(str, "$tree");
        kotlin.jvm.internal.m.f(lVar, "this$0");
        p0 p0Var = p0.a;
        String m0 = p0.m0(str);
        AccessToken e2 = AccessToken.f9559f.e();
        if (m0 == null || !kotlin.jvm.internal.m.a(m0, lVar.f10297g)) {
            a aVar = a;
            a0 a0Var = a0.a;
            lVar.g(aVar.a(str, e2, a0.d(), "app_indexing"), m0);
        }
    }

    public final void g(GraphRequest graphRequest, String str) {
        if (graphRequest == null) {
            return;
        }
        d0 j2 = graphRequest.j();
        try {
            JSONObject c2 = j2.c();
            if (c2 != null) {
                if (kotlin.jvm.internal.m.a("true", c2.optString(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION))) {
                    j0.a.b(g0.APP_EVENTS, f10292b, "Successfully send UI component tree to server");
                    this.f10297g = str;
                }
                if (c2.has("is_app_indexing_enabled")) {
                    boolean z = c2.getBoolean("is_app_indexing_enabled");
                    i iVar = i.a;
                    i.n(z);
                    return;
                }
                return;
            }
            Log.e(f10292b, kotlin.jvm.internal.m.n("Error sending UI component tree to Facebook: ", j2.b()));
        } catch (JSONException e2) {
            Log.e(f10292b, "Error decoding server response.", e2);
        }
    }

    public final void h() {
        final c cVar = new c();
        try {
            a0 a0Var = a0.a;
            a0.k().execute(new Runnable() { // from class: com.facebook.o0.m0.g
                @Override // java.lang.Runnable
                public final void run() {
                    l.i(l.this, cVar);
                }
            });
        } catch (RejectedExecutionException e2) {
            Log.e(f10292b, "Error scheduling indexing job", e2);
        }
    }

    public final void l() {
        if (this.f10295e.get() == null) {
            return;
        }
        try {
            Timer timer = this.f10296f;
            if (timer != null) {
                timer.cancel();
            }
            this.f10296f = null;
        } catch (Exception e2) {
            Log.e(f10292b, "Error unscheduling indexing job", e2);
        }
    }
}
