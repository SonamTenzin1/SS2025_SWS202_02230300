package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcbd {
    private final Executor a;

    /* renamed from: b, reason: collision with root package name */
    private final zzcau f15009b;

    public zzcbd(Executor executor, zzcau zzcauVar) {
        this.a = executor;
        this.f15009b = zzcauVar;
    }

    public final zzbbh<List<zzcbg>> a(JSONObject jSONObject, String str) {
        Future o;
        final String optString;
        char c2;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzbar.o(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null && (optString = optJSONObject.optString("name")) != null) {
                String optString2 = optJSONObject.optString("type");
                if ("string".equals(optString2)) {
                    c2 = 1;
                } else {
                    c2 = "image".equals(optString2) ? (char) 2 : (char) 0;
                }
                if (c2 == 1) {
                    o = zzbar.o(new zzcbg(optString, optJSONObject.optString("string_value")));
                } else if (c2 == 2) {
                    o = zzbar.d(this.f15009b.g(optJSONObject, "image_value"), new zzbam(optString) { // from class: com.google.android.gms.internal.ads.wg
                        private final String a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.a = optString;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbam
                        public final Object a(Object obj) {
                            return new zzcbg(this.a, (zzadw) obj);
                        }
                    }, this.a);
                }
                arrayList.add(o);
            }
            o = zzbar.o(null);
            arrayList.add(o);
        }
        return zzbar.d(zzbar.m(arrayList), vg.a, this.a);
    }
}
