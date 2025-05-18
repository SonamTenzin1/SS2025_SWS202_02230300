package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzk;
import java.io.IOException;
import okhttp3.HttpUrl;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class zzcrc {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public String f15558b;

    public zzcrc(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        jsonReader.beginObject();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (!(nextName == null ? HttpUrl.FRAGMENT_ENCODE_SET : nextName).equals("params")) {
                jsonReader.skipValue();
            } else {
                str = jsonReader.nextString();
            }
        }
        this.a = str;
        jsonReader.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcrc a(Bundle bundle) {
        try {
            this.f15558b = zzk.zzlg().N(bundle).toString();
        } catch (JSONException unused) {
            this.f15558b = "{}";
        }
        return this;
    }
}
