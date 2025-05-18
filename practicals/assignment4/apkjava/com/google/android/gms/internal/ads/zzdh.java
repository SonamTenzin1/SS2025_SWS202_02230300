package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes2.dex */
public final class zzdh {
    private static final String[] a = {"/aclk", "/pcs/click", "/dbm/clk"};

    /* renamed from: b, reason: collision with root package name */
    private String f15915b = "googleads.g.doubleclick.net";

    /* renamed from: c, reason: collision with root package name */
    private String f15916c = "/pagead/ads";

    /* renamed from: d, reason: collision with root package name */
    private String f15917d = "ad.doubleclick.net";

    /* renamed from: e, reason: collision with root package name */
    private String[] f15918e = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    /* renamed from: f, reason: collision with root package name */
    private zzdc f15919f;

    public zzdh(zzdc zzdcVar) {
        this.f15919f = zzdcVar;
    }

    private final Uri b(Uri uri, Context context, String str, boolean z, View view, Activity activity) throws zzdi {
        String zza;
        try {
            boolean d2 = d(uri);
            if (d2) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzdi("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzdi("Query parameter already exists: ms");
            }
            if (z) {
                zza = this.f15919f.zza(context, str, view, activity);
            } else {
                zza = this.f15919f.zza(context);
            }
            if (d2) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    int i2 = indexOf + 1;
                    return Uri.parse(uri2.substring(0, i2) + "dc_ms=" + zza + ";" + uri2.substring(i2));
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";dc_ms=" + zza + ";" + uri2.substring(indexOf2 + encodedPath.length()));
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 != -1) {
                int i3 = indexOf3 + 1;
                return Uri.parse(uri3.substring(0, i3) + "ms=" + zza + "&" + uri3.substring(i3));
            }
            return uri.buildUpon().appendQueryParameter("ms", zza).build();
        } catch (UnsupportedOperationException unused) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }

    private final boolean d(Uri uri) {
        uri.getClass();
        try {
            return uri.getHost().equals(this.f15917d);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final Uri a(Uri uri, Context context, View view, Activity activity) throws zzdi {
        try {
            return b(uri, context, uri.getQueryParameter("ai"), true, view, activity);
        } catch (UnsupportedOperationException unused) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }

    public final void c(MotionEvent motionEvent) {
        this.f15919f.zza(motionEvent);
    }

    public final boolean e(Uri uri) {
        uri.getClass();
        try {
            String host = uri.getHost();
            for (String str : this.f15918e) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    public final zzdc f() {
        return this.f15919f;
    }

    public final boolean g(Uri uri) {
        if (e(uri)) {
            for (String str : a) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
