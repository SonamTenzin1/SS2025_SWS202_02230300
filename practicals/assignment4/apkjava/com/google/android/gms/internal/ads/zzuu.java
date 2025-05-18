package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.root.execution.Command;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzuu extends Thread {

    /* renamed from: f, reason: collision with root package name */
    private boolean f16821f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f16822g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f16823h;

    /* renamed from: i, reason: collision with root package name */
    private final Object f16824i;

    /* renamed from: j, reason: collision with root package name */
    private final zzup f16825j;

    /* renamed from: k, reason: collision with root package name */
    private final int f16826k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final int r;
    private final String s;
    private final boolean t;
    private final boolean u;
    private final boolean v;

    public zzuu() {
        this(new zzup());
    }

    @VisibleForTesting
    private final r40 b(View view, zzuo zzuoVar) {
        boolean z;
        if (view == null) {
            return new r40(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (!TextUtils.isEmpty(text)) {
                zzuoVar.d(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
                return new r40(this, 1, 0);
            }
            return new r40(this, 0, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzbgz)) {
            WebView webView = (WebView) view;
            if (PlatformVersion.f()) {
                zzuoVar.n();
                webView.post(new p40(this, zzuoVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return new r40(this, 0, 1);
            }
            return new r40(this, 0, 0);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                r40 b2 = b(viewGroup.getChildAt(i4), zzuoVar);
                i2 += b2.a;
                i3 += b2.f13260b;
            }
            return new r40(this, i2, i3);
        }
        return new r40(this, 0, 0);
    }

    @VisibleForTesting
    private static boolean f() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Context b2 = zzk.zzlj().b();
            if (b2 == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) b2.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) b2.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) b2.getSystemService("power");
                    return powerManager == null ? false : powerManager.isScreenOn();
                }
            }
            return false;
        } catch (Throwable th) {
            zzk.zzlk().e(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void h() {
        synchronized (this.f16824i) {
            this.f16822g = true;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(true);
            zzbad.e(sb.toString());
        }
    }

    public final void a() {
        synchronized (this.f16824i) {
            this.f16822g = false;
            this.f16824i.notifyAll();
            zzbad.e("ContentFetchThread: wakeup");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void c(zzuo zzuoVar, WebView webView, String str, boolean z) {
        zzuoVar.m();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(Command.CommandHandler.TEXT);
                if (!this.t && !TextUtils.isEmpty(webView.getTitle())) {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzuoVar.c(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzuoVar.c(optString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzuoVar.h()) {
                this.f16825j.b(zzuoVar);
            }
        } catch (JSONException unused) {
            zzbad.e("Json string may be malformed.");
        } catch (Throwable th) {
            zzbad.b("Failed to get webview content.", th);
            zzk.zzlk().e(th, "ContentFetchTask.processWebViewContent");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void d(View view) {
        try {
            zzuo zzuoVar = new zzuo(this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.u);
            Context b2 = zzk.zzlj().b();
            if (b2 != null && !TextUtils.isEmpty(this.s)) {
                String str = (String) view.getTag(b2.getResources().getIdentifier((String) zzyt.e().c(zzacu.q0), DeepLinkIntentReceiver.DeepLinksKeys.ID, b2.getPackageName()));
                if (str != null && str.equals(this.s)) {
                    return;
                }
            }
            r40 b3 = b(view, zzuoVar);
            zzuoVar.p();
            if (b3.a == 0 && b3.f13260b == 0) {
                return;
            }
            if (b3.f13260b == 0 && zzuoVar.q() == 0) {
                return;
            }
            if (b3.f13260b == 0 && this.f16825j.a(zzuoVar)) {
                return;
            }
            this.f16825j.c(zzuoVar);
        } catch (Exception e2) {
            zzbad.c("Exception in fetchContentOnUIThread", e2);
            zzk.zzlk().e(e2, "ContentFetchTask.fetchContent");
        }
    }

    public final void e() {
        synchronized (this.f16824i) {
            if (this.f16821f) {
                zzbad.e("Content hash thread already started, quiting...");
            } else {
                this.f16821f = true;
                start();
            }
        }
    }

    public final zzuo g() {
        return this.f16825j.d(this.v);
    }

    public final boolean i() {
        return this.f16822g;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                if (f()) {
                    Activity a = zzk.zzlj().a();
                    if (a == null) {
                        zzbad.e("ContentFetchThread: no activity. Sleeping.");
                        h();
                    } else {
                        View view = null;
                        try {
                            if (a.getWindow() != null && a.getWindow().getDecorView() != null) {
                                view = a.getWindow().getDecorView().findViewById(R.id.content);
                            }
                        } catch (Exception e2) {
                            zzk.zzlk().e(e2, "ContentFetchTask.extractContent");
                            zzbad.e("Failed getting root view of activity. Content not extracted.");
                        }
                        if (view != null) {
                            view.post(new o40(this, view));
                        }
                    }
                } else {
                    zzbad.e("ContentFetchTask: sleeping");
                    h();
                }
                Thread.sleep(this.f16826k * 1000);
            } catch (InterruptedException e3) {
                zzbad.c("Error in ContentFetchTask", e3);
            } catch (Exception e4) {
                zzbad.c("Error in ContentFetchTask", e4);
                zzk.zzlk().e(e4, "ContentFetchTask.run");
            }
            synchronized (this.f16824i) {
                while (this.f16822g) {
                    try {
                        zzbad.e("ContentFetchTask: waiting");
                        this.f16824i.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    @VisibleForTesting
    private zzuu(zzup zzupVar) {
        this.f16821f = false;
        this.f16822g = false;
        this.f16823h = false;
        this.f16825j = zzupVar;
        this.f16824i = new Object();
        this.l = ((Integer) zzyt.e().c(zzacu.i0)).intValue();
        this.m = ((Integer) zzyt.e().c(zzacu.j0)).intValue();
        this.n = ((Integer) zzyt.e().c(zzacu.k0)).intValue();
        this.o = ((Integer) zzyt.e().c(zzacu.l0)).intValue();
        this.p = ((Integer) zzyt.e().c(zzacu.n0)).intValue();
        this.q = ((Integer) zzyt.e().c(zzacu.o0)).intValue();
        this.r = ((Integer) zzyt.e().c(zzacu.p0)).intValue();
        this.f16826k = ((Integer) zzyt.e().c(zzacu.m0)).intValue();
        this.s = (String) zzyt.e().c(zzacu.r0);
        this.t = ((Boolean) zzyt.e().c(zzacu.s0)).booleanValue();
        this.u = ((Boolean) zzyt.e().c(zzacu.w0)).booleanValue();
        this.v = ((Boolean) zzyt.e().c(zzacu.x0)).booleanValue();
        setName("ContentFetchTask");
    }
}
