package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n extends zzacj<Long> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i2, String str, Long l) {
        super(i2, str, l, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Long h(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(a(), n().longValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Long i(Bundle bundle) {
        String valueOf = String.valueOf(a());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(a());
            return Long.valueOf(bundle.getLong(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return n();
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Long j(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(a(), n().longValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void k(SharedPreferences.Editor editor, Long l) {
        editor.putLong(a(), l.longValue());
    }
}
