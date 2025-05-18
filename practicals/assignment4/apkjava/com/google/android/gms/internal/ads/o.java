package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o extends zzacj<Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i2, String str, Float f2) {
        super(i2, str, f2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Float h(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(a(), n().floatValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Float i(Bundle bundle) {
        String valueOf = String.valueOf(a());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(a());
            return Float.valueOf(bundle.getFloat(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return n();
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Float j(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(a(), n().floatValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void k(SharedPreferences.Editor editor, Float f2) {
        editor.putFloat(a(), f2.floatValue());
    }
}
