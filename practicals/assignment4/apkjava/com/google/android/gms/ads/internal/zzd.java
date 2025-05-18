package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzalr;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawl;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbal;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbbh;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzyt;
import java.util.concurrent.Executor;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzd {
    private long zzbqy = 0;
    private Context zzlj;

    public final void zza(Context context, zzbai zzbaiVar, String str, Runnable runnable) {
        zza(context, zzbaiVar, true, null, str, null, runnable);
    }

    public final void zza(Context context, zzbai zzbaiVar, String str, zzawl zzawlVar) {
        zza(context, zzbaiVar, false, zzawlVar, zzawlVar != null ? zzawlVar.d() : null, str, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0051, code lost:
    
        if (r11.b() != false) goto L17;
     */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zza(Context context, zzbai zzbaiVar, boolean z, zzawl zzawlVar, String str, String str2, Runnable runnable) {
        if (zzk.zzln().b() - this.zzbqy < 5000) {
            zzbad.i("Not retrying to fetch app settings");
            return;
        }
        this.zzbqy = zzk.zzln().b();
        boolean z2 = false;
        if (zzawlVar != null) {
            if (!(zzk.zzln().a() - zzawlVar.a() > ((Long) zzyt.e().c(zzacu.f3)).longValue())) {
            }
        }
        z2 = true;
        if (z2) {
            if (context == null) {
                zzbad.i("Context not provided to fetch application settings");
                return;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                zzbad.i("App settings could not be fetched. Required parameters missing");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.zzlj = applicationContext;
            zzalr b2 = zzk.zzlt().b(this.zzlj, zzbaiVar);
            zzaln<JSONObject> zzalnVar = zzalo.f13955b;
            zzalj a = b2.a("google.afma.config.fetchAppSettings", zzalnVar, zzalnVar);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzbbh a2 = a.a(jSONObject);
                zzbal zzbalVar = zze.zzbqz;
                Executor executor = zzbbm.f14331b;
                zzbbh c2 = zzbar.c(a2, zzbalVar, executor);
                if (runnable != null) {
                    a2.k(runnable, executor);
                }
                zzbao.a(c2, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e2) {
                zzbad.c("Error requesting application settings", e2);
            }
        }
    }
}
