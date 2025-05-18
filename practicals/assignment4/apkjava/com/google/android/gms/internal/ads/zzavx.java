package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
/* loaded from: classes2.dex */
public final class zzavx {
    @VisibleForTesting
    private static Uri a(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            return Uri.parse(str.substring(0, i2) + str2 + "=" + str3 + "&" + str.substring(i2));
        }
        return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }

    public static String b(Uri uri, Context context) {
        if (!zzk.zzme().D(context)) {
            return uri.toString();
        }
        String n = zzk.zzme().n(context);
        if (n == null) {
            return uri.toString();
        }
        if (((Boolean) zzyt.e().c(zzacu.C0)).booleanValue()) {
            String str = (String) zzyt.e().c(zzacu.D0);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                zzk.zzme().u(context, n);
                return uri2.replace(str, n);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            uri = a(uri.toString(), "fbs_aeid", n);
            zzk.zzme().u(context, n);
        }
        return uri.toString();
    }

    public static String c(String str, Context context, boolean z) {
        String n;
        if ((((Boolean) zzyt.e().c(zzacu.K0)).booleanValue() && !z) || !zzk.zzme().D(context) || TextUtils.isEmpty(str) || (n = zzk.zzme().n(context)) == null) {
            return str;
        }
        if (((Boolean) zzyt.e().c(zzacu.C0)).booleanValue()) {
            CharSequence charSequence = (String) zzyt.e().c(zzacu.D0);
            if (!str.contains(charSequence)) {
                return str;
            }
            if (zzk.zzlg().T(str)) {
                zzk.zzme().u(context, n);
                return str.replace(charSequence, n);
            }
            if (!zzk.zzlg().U(str)) {
                return str;
            }
            zzk.zzme().v(context, n);
            return str.replace(charSequence, n);
        }
        if (str.contains("fbs_aeid")) {
            return str;
        }
        if (zzk.zzlg().T(str)) {
            zzk.zzme().u(context, n);
            return a(str, "fbs_aeid", n).toString();
        }
        if (!zzk.zzlg().U(str)) {
            return str;
        }
        zzk.zzme().v(context, n);
        return a(str, "fbs_aeid", n).toString();
    }
}
