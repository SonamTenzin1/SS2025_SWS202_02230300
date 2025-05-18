package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.SharedPreferencesUtils;

@TargetApi(17)
/* loaded from: classes2.dex */
public class zzaxr extends zzaxt {
    @Override // com.google.android.gms.internal.ads.zzaxo
    public final String a(Context context) {
        String str;
        zzazm a = zzazm.a();
        if (TextUtils.isEmpty(a.f14301b)) {
            if (ClientLibraryUtils.c()) {
                str = (String) zzazl.a(context, new c6(a, context));
            } else {
                str = (String) zzazl.a(context, new d6(a, GooglePlayServicesUtilLight.getRemoteContext(context), context));
            }
            a.f14301b = str;
        }
        return a.f14301b;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final int d(ContentResolver contentResolver) {
        return Settings.Global.getInt(contentResolver, "wifi_on", 0);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final Drawable e(Context context, Bitmap bitmap, boolean z, float f2) {
        if (z && f2 > 0.0f && f2 <= 25.0f) {
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                RenderScript create = RenderScript.create(context);
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(f2);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                return new BitmapDrawable(context.getResources(), createBitmap);
            } catch (RuntimeException unused) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
        }
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    @Override // com.google.android.gms.internal.ads.zzaxt, com.google.android.gms.internal.ads.zzaxo
    public final boolean k(Context context, WebSettings webSettings) {
        super.k(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final void m(Context context) {
        zzazm a = zzazm.a();
        zzawz.m("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(a.f14301b)) {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (ClientLibraryUtils.c() || remoteContext == null) {
                SharedPreferences.Editor putString = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (remoteContext == null) {
                    putString.apply();
                } else {
                    SharedPreferencesUtils.a(context, putString, "admob_user_agent");
                }
            }
            a.f14301b = defaultUserAgent;
        }
        zzawz.m("User agent is updated.");
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final int o(ContentResolver contentResolver) {
        return Settings.Global.getInt(contentResolver, "airplane_mode_on", 0);
    }
}
