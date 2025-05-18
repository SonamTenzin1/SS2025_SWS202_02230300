package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzblz implements zzbls {
    private final Context a;

    public zzblz(Context context) {
        this.a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void a(Map<String, String> map) {
        CookieManager n;
        String str = map.get("cookie");
        if (TextUtils.isEmpty(str) || (n = zzk.zzli().n(this.a)) == null) {
            return;
        }
        n.setCookie("googleads.g.doubleclick.net", str);
    }
}
