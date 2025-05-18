package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzayi {
    private final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private String f14274b = HttpUrl.FRAGMENT_ENCODE_SET;

    /* renamed from: c, reason: collision with root package name */
    private String f14275c = HttpUrl.FRAGMENT_ENCODE_SET;

    /* renamed from: d, reason: collision with root package name */
    private boolean f14276d = false;

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private String f14277e = HttpUrl.FRAGMENT_ENCODE_SET;

    @VisibleForTesting
    private final void b(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzbad.h("Can not create dialog without Activity Context");
        } else {
            zzaxi.a.post(new s5(this, context, str, z, z2));
        }
    }

    private final String d(Context context) {
        String str;
        synchronized (this.a) {
            if (TextUtils.isEmpty(this.f14274b)) {
                zzk.zzlg();
                String h0 = zzaxi.h0(context, "debug_signals_id.txt");
                this.f14274b = h0;
                if (TextUtils.isEmpty(h0)) {
                    zzk.zzlg();
                    this.f14274b = zzaxi.j0();
                    zzk.zzlg();
                    zzaxi.K(context, "debug_signals_id.txt", this.f14274b);
                }
            }
            str = this.f14274b;
        }
        return str;
    }

    private final void e(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = f(context, (String) zzyt.e().c(zzacu.L3), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzk.zzlg();
        zzaxi.J(context, str, buildUpon.build().toString());
    }

    private final Uri f(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", d(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    @VisibleForTesting
    private final boolean h(Context context, String str, String str2) {
        String j2 = j(context, f(context, (String) zzyt.e().c(zzacu.J3), str, str2).toString(), str2);
        if (TextUtils.isEmpty(j2)) {
            zzbad.e("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(j2.trim());
            String optString = jSONObject.optString("gct");
            this.f14277e = jSONObject.optString("status");
            synchronized (this.a) {
                this.f14275c = optString;
            }
            return true;
        } catch (JSONException e2) {
            zzbad.d("Fail to get in app preview response json.", e2);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean i(Context context, String str, String str2) {
        String j2 = j(context, f(context, (String) zzyt.e().c(zzacu.K3), str, str2).toString(), str2);
        if (TextUtils.isEmpty(j2)) {
            zzbad.e("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(j2.trim()).optString("debug_mode"));
            synchronized (this.a) {
                this.f14276d = equals;
            }
            return equals;
        } catch (JSONException e2) {
            zzbad.d("Fail to get debug mode response json.", e2);
            return false;
        }
    }

    @VisibleForTesting
    private static String j(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzk.zzlg().g0(context, str2));
        zzbbh<String> c2 = new zzayu(context).c(str, hashMap);
        try {
            return c2.get(((Integer) zzyt.e().c(zzacu.M3)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            String valueOf = String.valueOf(str);
            zzbad.c(valueOf.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf) : new String("Interrupted while retriving a response from: "), e2);
            c2.cancel(true);
            return null;
        } catch (TimeoutException e3) {
            String valueOf2 = String.valueOf(str);
            zzbad.c(valueOf2.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf2) : new String("Timeout while retriving a response from: "), e3);
            c2.cancel(true);
            return null;
        } catch (Exception e4) {
            String valueOf3 = String.valueOf(str);
            zzbad.c(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), e4);
            return null;
        }
    }

    private final void k(Context context, String str, String str2) {
        zzk.zzlg();
        zzaxi.j(context, f(context, (String) zzyt.e().c(zzacu.I3), str, str2));
    }

    public final void a(Context context, String str, String str2, String str3) {
        boolean m = m();
        if (i(context, str, str2)) {
            if (!m && !TextUtils.isEmpty(str3)) {
                e(context, str2, str3, str);
            }
            zzbad.e("Device is linked for debug signals.");
            b(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        k(context, str, str2);
    }

    public final boolean c(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzk.zzlq().m()) {
            return false;
        }
        zzbad.e("Sending troubleshooting signals to the server.");
        e(context, str, str2, str3);
        return true;
    }

    public final void g(Context context, String str, String str2) {
        if (!h(context, str, str2)) {
            b(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(this.f14277e)) {
            zzbad.e("Creative is not pushed for this device.");
            b(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.f14277e)) {
            zzbad.e("The app is not linked for creative preview.");
            k(context, str, str2);
        } else if ("0".equals(this.f14277e)) {
            zzbad.e("Device is linked for in app preview.");
            b(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final String l() {
        String str;
        synchronized (this.a) {
            str = this.f14275c;
        }
        return str;
    }

    public final boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.f14276d;
        }
        return z;
    }
}
