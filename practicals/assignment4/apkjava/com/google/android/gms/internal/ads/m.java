package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m extends zzacj<Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(int i2, String str, Integer num) {
        super(i2, str, num, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Integer h(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(a(), n().intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Integer i(Bundle bundle) {
        String valueOf = String.valueOf(a());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(a());
            return Integer.valueOf(bundle.getInt(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return n();
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Integer j(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(a(), n().intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void k(SharedPreferences.Editor editor, Integer num) {
        editor.putInt(a(), num.intValue());
    }
}
