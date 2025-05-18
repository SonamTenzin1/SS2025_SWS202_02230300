package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzbfo implements zzaho<zzbdf> {
    private boolean a;

    private static int b(Context context, Map<String, String> map, String str, int i2) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i2;
        }
        try {
            zzyt.a();
            return zzazt.a(context, Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + str2.length());
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzbad.i(sb.toString());
            return i2;
        }
    }

    private static void c(zzbcq zzbcqVar, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbcqVar.u(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzbad.i(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzbcqVar.v(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbcqVar.y(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbcqVar.z(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbcqVar.A(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzbdf zzbdfVar, Map map) {
        int i2;
        zzbdf zzbdfVar2 = zzbdfVar;
        String str = (String) map.get("action");
        if (str == null) {
            zzbad.i("Action missing from video GMSG.");
            return;
        }
        if (zzbad.a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(str.length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzbad.e(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzbad.i("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbdfVar2.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                zzbad.i("Invalid color parameter in video GMSG.");
                return;
            }
        }
        if ("decoderProps".equals(str)) {
            String str3 = (String) map.get("mimeTypes");
            if (str3 == null) {
                zzbad.i("No MIME types specified for decoder properties inspection.");
                zzbcq.p(zzbdfVar2, "missingMimeTypes");
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                zzbad.i("Video decoder properties available on API versions >= 16.");
                zzbcq.p(zzbdfVar2, "deficientApiVersion");
                return;
            }
            HashMap hashMap = new HashMap();
            for (String str4 : str3.split(",")) {
                hashMap.put(str4, zzazr.b(str4.trim()));
            }
            zzbcq.q(zzbdfVar2, hashMap);
            return;
        }
        zzbcw i0 = zzbdfVar2.i0();
        if (i0 == null) {
            zzbad.i("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        if (!equals && !equals2) {
            zzbhq h2 = zzbdfVar2.h();
            if (h2 != null) {
                if ("timeupdate".equals(str)) {
                    String str5 = (String) map.get("currentTime");
                    if (str5 == null) {
                        zzbad.i("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    }
                    try {
                        h2.n7(Float.parseFloat(str5));
                        return;
                    } catch (NumberFormatException unused2) {
                        zzbad.i(str5.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str5) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                        return;
                    }
                }
                if ("skip".equals(str)) {
                    h2.k7();
                    return;
                }
            }
            zzbcq e2 = i0.e();
            if (e2 == null) {
                zzbcq.s(zzbdfVar2);
                return;
            }
            if ("click".equals(str)) {
                Context context = zzbdfVar2.getContext();
                int b2 = b(context, map, "x", 0);
                int b3 = b(context, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, b2, b3, 0);
                e2.B(obtain);
                obtain.recycle();
                return;
            }
            if ("currentTime".equals(str)) {
                String str6 = (String) map.get("time");
                if (str6 == null) {
                    zzbad.i("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    e2.m((int) (Float.parseFloat(str6) * 1000.0f));
                    return;
                } catch (NumberFormatException unused3) {
                    zzbad.i(str6.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(str6) : new String("Could not parse time parameter from currentTime video GMSG: "));
                    return;
                }
            }
            if ("hide".equals(str)) {
                e2.setVisibility(4);
                return;
            }
            if ("load".equals(str)) {
                e2.C();
                return;
            }
            if ("loadControl".equals(str)) {
                c(e2, map);
                return;
            }
            if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    e2.D();
                    return;
                } else {
                    e2.E();
                    return;
                }
            }
            if ("pause".equals(str)) {
                e2.k();
                return;
            }
            if ("play".equals(str)) {
                e2.l();
                return;
            }
            if ("show".equals(str)) {
                e2.setVisibility(0);
                return;
            }
            if ("src".equals(str)) {
                String str7 = (String) map.get("src");
                String[] strArr = {str7};
                String str8 = (String) map.get("demuxed");
                if (str8 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str8);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            strArr2[i3] = jSONArray.getString(i3);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused4) {
                        zzbad.i(str8.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(str8) : new String("Malformed demuxed URL list for playback: "));
                        strArr = new String[]{str7};
                    }
                }
                e2.t(str7, strArr);
                return;
            }
            if ("touchMove".equals(str)) {
                Context context2 = zzbdfVar2.getContext();
                e2.n(b(context2, map, "dx", 0), b(context2, map, "dy", 0));
                if (this.a) {
                    return;
                }
                zzbdfVar2.N();
                this.a = true;
                return;
            }
            if ("volume".equals(str)) {
                String str9 = (String) map.get("volume");
                if (str9 == null) {
                    zzbad.i("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    e2.setVolume(Float.parseFloat(str9));
                    return;
                } catch (NumberFormatException unused5) {
                    zzbad.i(str9.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(str9) : new String("Could not parse volume parameter from volume video GMSG: "));
                    return;
                }
            }
            if ("watermark".equals(str)) {
                e2.F();
                return;
            } else {
                zzbad.i(str.length() != 0 ? "Unknown video action: ".concat(str) : new String("Unknown video action: "));
                return;
            }
        }
        Context context3 = zzbdfVar2.getContext();
        int b4 = b(context3, map, "x", 0);
        int b5 = b(context3, map, "y", 0);
        int b6 = b(context3, map, "w", -1);
        int b7 = b(context3, map, "h", -1);
        int min = Math.min(b6, zzbdfVar2.U() - b4);
        int min2 = Math.min(b7, zzbdfVar2.f0() - b5);
        try {
            i2 = Integer.parseInt((String) map.get("player"));
        } catch (NumberFormatException unused6) {
            i2 = 0;
        }
        boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
        if (equals && i0.e() == null) {
            i0.c(b4, b5, min, min2, i2, parseBoolean, new zzbde((String) map.get("flags")));
            zzbcq e3 = i0.e();
            if (e3 != null) {
                c(e3, map);
                return;
            }
            return;
        }
        i0.d(b4, b5, min, min2);
    }
}
