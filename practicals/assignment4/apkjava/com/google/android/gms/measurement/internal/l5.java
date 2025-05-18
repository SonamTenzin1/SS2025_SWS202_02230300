package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
@TargetApi(14)
/* loaded from: classes2.dex */
public final class l5 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzhc f17851f;

    private l5(zzhc zzhcVar) {
        this.f17851f = zzhcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0098 A[Catch: Exception -> 0x01a3, TRY_ENTER, TryCatch #0 {Exception -> 0x01a3, blocks: (B:3:0x0006, B:6:0x0020, B:8:0x002e, B:14:0x0098, B:16:0x00a6, B:18:0x00b9, B:21:0x00c1, B:23:0x00c7, B:24:0x00da, B:25:0x00e1, B:28:0x00f1, B:31:0x0101, B:34:0x0109, B:36:0x010f, B:37:0x011a, B:41:0x0121, B:45:0x0142, B:46:0x0157, B:48:0x0148, B:49:0x015e, B:51:0x0164, B:53:0x016a, B:55:0x0170, B:57:0x0176, B:59:0x017e, B:63:0x0189, B:65:0x0197, B:67:0x019d, B:71:0x003f, B:74:0x004c, B:76:0x0052, B:78:0x0058, B:80:0x005e, B:82:0x0064, B:83:0x0070, B:85:0x0078, B:86:0x0083, B:88:0x008d, B:89:0x007d), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f1 A[Catch: Exception -> 0x01a3, TRY_ENTER, TryCatch #0 {Exception -> 0x01a3, blocks: (B:3:0x0006, B:6:0x0020, B:8:0x002e, B:14:0x0098, B:16:0x00a6, B:18:0x00b9, B:21:0x00c1, B:23:0x00c7, B:24:0x00da, B:25:0x00e1, B:28:0x00f1, B:31:0x0101, B:34:0x0109, B:36:0x010f, B:37:0x011a, B:41:0x0121, B:45:0x0142, B:46:0x0157, B:48:0x0148, B:49:0x015e, B:51:0x0164, B:53:0x016a, B:55:0x0170, B:57:0x0176, B:59:0x017e, B:63:0x0189, B:65:0x0197, B:67:0x019d, B:71:0x003f, B:74:0x004c, B:76:0x0052, B:78:0x0058, B:80:0x005e, B:82:0x0064, B:83:0x0070, B:85:0x0078, B:86:0x0083, B:88:0x008d, B:89:0x007d), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0120 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0121 A[Catch: Exception -> 0x01a3, TRY_LEAVE, TryCatch #0 {Exception -> 0x01a3, blocks: (B:3:0x0006, B:6:0x0020, B:8:0x002e, B:14:0x0098, B:16:0x00a6, B:18:0x00b9, B:21:0x00c1, B:23:0x00c7, B:24:0x00da, B:25:0x00e1, B:28:0x00f1, B:31:0x0101, B:34:0x0109, B:36:0x010f, B:37:0x011a, B:41:0x0121, B:45:0x0142, B:46:0x0157, B:48:0x0148, B:49:0x015e, B:51:0x0164, B:53:0x016a, B:55:0x0170, B:57:0x0176, B:59:0x017e, B:63:0x0189, B:65:0x0197, B:67:0x019d, B:71:0x003f, B:74:0x004c, B:76:0x0052, B:78:0x0058, B:80:0x005e, B:82:0x0064, B:83:0x0070, B:85:0x0078, B:86:0x0083, B:88:0x008d, B:89:0x007d), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(boolean z, Uri uri, String str, String str2) {
        Bundle y;
        Bundle bundle;
        try {
            if (!this.f17851f.n().r(zzap.H0)) {
                if (!this.f17851f.n().r(zzap.J0)) {
                    if (this.f17851f.n().r(zzap.I0)) {
                    }
                    y = null;
                    boolean z2 = false;
                    if (z) {
                        bundle = this.f17851f.l().y(uri);
                        if (bundle != null) {
                            bundle.putString("_cis", "intent");
                            if (this.f17851f.n().r(zzap.H0) && !bundle.containsKey("gclid") && y != null && y.containsKey("gclid")) {
                                bundle.putString("_cer", String.format("gclid=%s", y.getString("gclid")));
                            }
                            this.f17851f.S(str, "_cmp", bundle);
                        }
                    } else {
                        bundle = null;
                    }
                    if (this.f17851f.n().r(zzap.J0) && !this.f17851f.n().r(zzap.I0) && y != null && y.containsKey("gclid") && (bundle == null || !bundle.containsKey("gclid"))) {
                        this.f17851f.W("auto", "_lgclid", y.getString("gclid"), true);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    this.f17851f.h().O().b("Activity created with referrer", str2);
                    if (this.f17851f.n().r(zzap.I0)) {
                        if (y != null) {
                            this.f17851f.S(str, "_cmp", y);
                        } else {
                            this.f17851f.h().O().b("Referrer does not contain valid parameters", str2);
                        }
                        this.f17851f.W("auto", "_ldl", null, true);
                        return;
                    }
                    if (str2.contains("gclid") && (str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_term") || str2.contains("utm_content"))) {
                        z2 = true;
                    }
                    if (!z2) {
                        this.f17851f.h().O().a("Activity created with data 'referrer' without required params");
                        return;
                    } else {
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        this.f17851f.W("auto", "_ldl", str2, true);
                        return;
                    }
                }
            }
            zzkk l = this.f17851f.l();
            if (!TextUtils.isEmpty(str2)) {
                if (!str2.contains("gclid") && !str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium")) {
                    l.h().O().a("Activity created with data 'referrer' without required params");
                } else {
                    y = l.y(Uri.parse(str2.length() != 0 ? "https://google.com/search?".concat(str2) : new String("https://google.com/search?")));
                    if (y != null) {
                        y.putString("_cis", "referrer");
                    }
                    boolean z22 = false;
                    if (z) {
                    }
                    if (this.f17851f.n().r(zzap.J0)) {
                        this.f17851f.W("auto", "_lgclid", y.getString("gclid"), true);
                    }
                    if (TextUtils.isEmpty(str2)) {
                    }
                }
            }
            y = null;
            boolean z222 = false;
            if (z) {
            }
            if (this.f17851f.n().r(zzap.J0)) {
            }
            if (TextUtils.isEmpty(str2)) {
            }
        } catch (Exception e2) {
            this.f17851f.h().H().b("Throwable caught in handleReferrerForOnActivityCreated", e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.f17851f.h().P().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            Uri data = intent.getData();
            if (data != null && data.isHierarchical()) {
                this.f17851f.l();
                String str = zzkk.V(intent) ? "gs" : "auto";
                String queryParameter = data.getQueryParameter("referrer");
                boolean z = bundle == null;
                if (zzle.b() && zzap.K0.a(null).booleanValue()) {
                    this.f17851f.g().z(new n5(this, z, data, str, queryParameter));
                } else {
                    b(z, data, str, queryParameter);
                }
            }
        } catch (Exception e2) {
            this.f17851f.h().H().b("Throwable caught in onActivityCreated", e2);
        } finally {
            this.f17851f.s().D(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f17851f.s().P(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f17851f.s().N(activity);
        zzjl u = this.f17851f.u();
        u.g().z(new u6(u, u.j().b()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (zzkn.b() && zzap.f0.a(null).booleanValue()) {
            this.f17851f.u().F();
            this.f17851f.s().C(activity);
        } else {
            this.f17851f.s().C(activity);
            this.f17851f.u().F();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f17851f.s().O(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l5(zzhc zzhcVar, w4 w4Var) {
        this(zzhcVar);
    }
}
