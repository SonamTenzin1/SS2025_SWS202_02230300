package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzbde {
    public final boolean a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14364b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14365c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14366d;

    /* renamed from: e, reason: collision with root package name */
    public final String f14367e;

    /* renamed from: f, reason: collision with root package name */
    public final int f14368f;

    /* renamed from: g, reason: collision with root package name */
    public final int f14369g;

    /* renamed from: h, reason: collision with root package name */
    public final int f14370h;

    /* renamed from: i, reason: collision with root package name */
    public final int f14371i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f14372j;

    public zzbde(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.a = a(jSONObject, "aggressive_media_codec_release", zzacu.P);
        this.f14364b = c(jSONObject, "byte_buffer_precache_limit", zzacu.y);
        this.f14365c = c(jSONObject, "exo_cache_buffer_size", zzacu.D);
        this.f14366d = c(jSONObject, "exo_connect_timeout_millis", zzacu.u);
        this.f14367e = d(jSONObject, "exo_player_version", zzacu.t);
        this.f14368f = c(jSONObject, "exo_read_timeout_millis", zzacu.v);
        this.f14369g = c(jSONObject, "load_check_interval_bytes", zzacu.w);
        this.f14370h = c(jSONObject, "player_precache_limit", zzacu.x);
        this.f14371i = c(jSONObject, "socket_receive_buffer_size", zzacu.z);
        this.f14372j = a(jSONObject, "use_cache_data_source", zzacu.y3);
    }

    private static boolean a(JSONObject jSONObject, String str, zzacj<Boolean> zzacjVar) {
        return b(jSONObject, str, ((Boolean) zzyt.e().c(zzacjVar)).booleanValue());
    }

    private static boolean b(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    private static int c(JSONObject jSONObject, String str, zzacj<Integer> zzacjVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) zzyt.e().c(zzacjVar)).intValue();
    }

    private static String d(JSONObject jSONObject, String str, zzacj<String> zzacjVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return (String) zzyt.e().c(zzacjVar);
    }
}
