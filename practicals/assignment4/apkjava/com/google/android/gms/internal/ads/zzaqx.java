package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.dataprovider.BuildConfig;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.HttpUrl;

@zzard
/* loaded from: classes2.dex */
public final class zzaqx implements zzarb {
    private static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private static zzarb f14077b;

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private static zzarb f14078c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f14079d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f14080e;

    /* renamed from: f, reason: collision with root package name */
    private final WeakHashMap<Thread, Boolean> f14081f;

    /* renamed from: g, reason: collision with root package name */
    private final ExecutorService f14082g;

    /* renamed from: h, reason: collision with root package name */
    private final zzbai f14083h;

    private zzaqx(Context context) {
        this(context, zzbai.y());
    }

    @VisibleForTesting
    private final Uri.Builder c(String str, String str2, String str3, int i2) {
        boolean z;
        String str4;
        try {
            z = Wrappers.a(this.f14080e).f();
        } catch (Throwable th) {
            zzbad.c("Error fetching instant app info", th);
            z = false;
        }
        try {
            str4 = this.f14080e.getPackageName();
        } catch (Throwable unused) {
            zzbad.i("Cannot obtain package name, proceeding.");
            str4 = "unknown";
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter(DeepLinkIntentReceiver.DeepLinksKeys.ID, "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 1 + str6.length());
            sb.append(str5);
            sb.append(" ");
            sb.append(str6);
            str6 = sb.toString();
        }
        return appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.f14083h.f14326f).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzacu.c())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "248613007").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzyt.f()).appendQueryParameter("sampling_rate", Integer.toString(i2)).appendQueryParameter("pb_tm", String.valueOf(zzyt.e().c(zzacu.M4)));
    }

    public static zzarb e(Context context, zzbai zzbaiVar) {
        synchronized (a) {
            if (f14078c == null) {
                if (((Boolean) zzyt.e().c(zzacu.l)).booleanValue()) {
                    zzaqx zzaqxVar = new zzaqx(context, zzbaiVar);
                    Thread thread = Looper.getMainLooper().getThread();
                    if (thread != null) {
                        synchronized (zzaqxVar.f14079d) {
                            zzaqxVar.f14081f.put(thread, Boolean.TRUE);
                        }
                        thread.setUncaughtExceptionHandler(new p3(zzaqxVar, thread.getUncaughtExceptionHandler()));
                    }
                    Thread.setDefaultUncaughtExceptionHandler(new o3(zzaqxVar, Thread.getDefaultUncaughtExceptionHandler()));
                    f14078c = zzaqxVar;
                } else {
                    f14078c = new zzarc();
                }
            }
        }
        return f14078c;
    }

    public static zzarb f(Context context) {
        synchronized (a) {
            if (f14077b == null) {
                if (((Boolean) zzyt.e().c(zzacu.l)).booleanValue()) {
                    f14077b = new zzaqx(context);
                } else {
                    f14077b = new zzarc();
                }
            }
        }
        return f14077b;
    }

    @Override // com.google.android.gms.internal.ads.zzarb
    public final void a(Throwable th, String str) {
        b(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzarb
    public final void b(Throwable th, String str, float f2) {
        if (zzazt.r(th) == null) {
            return;
        }
        String name = th.getClass().getName();
        StringWriter stringWriter = new StringWriter();
        zzdmb.a(th, new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int i2 = 0;
        boolean z = Math.random() < ((double) f2);
        int i3 = f2 > 0.0f ? (int) (1.0f / f2) : 1;
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(c(name, stringWriter2, str, i3).toString());
            int size = arrayList.size();
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                this.f14082g.submit(new q3(this, new zzbah(), (String) obj));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if (r3 == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(Thread thread, Throwable th) {
        boolean z = true;
        if (th != null) {
            boolean z2 = false;
            boolean z3 = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    if (zzazt.u(stackTraceElement.getClassName())) {
                        z2 = true;
                    }
                    if (zzaqx.class.getName().equals(stackTraceElement.getClassName())) {
                        z3 = true;
                    }
                }
            }
            if (z2) {
            }
        }
        z = false;
        if (z) {
            b(th, HttpUrl.FRAGMENT_ENCODE_SET, 1.0f);
        }
    }

    private zzaqx(Context context, zzbai zzbaiVar) {
        this.f14079d = new Object();
        this.f14081f = new WeakHashMap<>();
        this.f14082g = Executors.newCachedThreadPool();
        this.f14080e = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f14083h = zzbaiVar;
    }
}
