package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class p extends zzacj<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i2, String str, String str2) {
        super(i2, str, str2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ String h(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(a(), n());
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ String i(Bundle bundle) {
        String valueOf = String.valueOf(a());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(a());
            return bundle.getString(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag."));
        }
        return n();
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ String j(JSONObject jSONObject) {
        return jSONObject.optString(a(), n());
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void k(SharedPreferences.Editor editor, String str) {
        editor.putString(a(), str);
    }
}
