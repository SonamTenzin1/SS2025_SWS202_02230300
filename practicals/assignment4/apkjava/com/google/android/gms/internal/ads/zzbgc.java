package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzbgc implements zzaho<zzbdf> {
    private static Integer b(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzbad.i(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzbdf zzbdfVar, Map map) {
        zzbft zzbftVar;
        zzbdf zzbdfVar2 = zzbdfVar;
        if (zzbad.a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(valueOf.length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzbad.e(sb.toString());
        }
        zzk.zzmc();
        if (map.containsKey("abort")) {
            if (zzbfs.g(zzbdfVar2)) {
                return;
            }
            zzbad.i("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        strArr2[i2] = jSONArray.getString(i2);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    zzbad.i(str2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(str2) : new String("Malformed demuxed URL list for precache: "));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (zzbfs.h(zzbdfVar2) != null) {
                zzbad.i("Precache task is already running.");
                return;
            }
            if (zzbdfVar2.c() == null) {
                zzbad.i("Precache requires a dependency provider.");
                return;
            }
            zzbde zzbdeVar = new zzbde((String) map.get("flags"));
            Integer b2 = b(map, "player");
            if (b2 == null) {
                b2 = 0;
            }
            zzbftVar = zzbdfVar2.c().zzbqr.a(zzbdfVar2, b2.intValue(), null, zzbdeVar);
            new zzbfq(zzbdfVar2, zzbftVar, str, strArr).zzvi();
        } else {
            zzbfq h2 = zzbfs.h(zzbdfVar2);
            if (h2 != null) {
                zzbftVar = h2.f14426b;
            } else {
                zzbad.i("Precache must specify a source.");
                return;
            }
        }
        Integer b3 = b(map, "minBufferMs");
        if (b3 != null) {
            zzbftVar.t(b3.intValue());
        }
        Integer b4 = b(map, "maxBufferMs");
        if (b4 != null) {
            zzbftVar.u(b4.intValue());
        }
        Integer b5 = b(map, "bufferForPlaybackMs");
        if (b5 != null) {
            zzbftVar.v(b5.intValue());
        }
        Integer b6 = b(map, "bufferForPlaybackAfterRebufferMs");
        if (b6 != null) {
            zzbftVar.w(b6.intValue());
        }
    }
}
