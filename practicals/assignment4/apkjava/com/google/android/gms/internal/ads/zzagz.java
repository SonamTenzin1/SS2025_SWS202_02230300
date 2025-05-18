package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzagz {
    public static final zzaho<zzbgz> a = z.a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzaho<zzbgz> f13888b = a0.a;

    /* renamed from: c, reason: collision with root package name */
    public static final zzaho<zzbgz> f13889c = b0.a;

    /* renamed from: d, reason: collision with root package name */
    public static final zzaho<zzbgz> f13890d = new e0();

    /* renamed from: e, reason: collision with root package name */
    public static final zzaho<zzbgz> f13891e = new f0();

    /* renamed from: f, reason: collision with root package name */
    public static final zzaho<zzbgz> f13892f = c0.a;

    /* renamed from: g, reason: collision with root package name */
    public static final zzaho<Object> f13893g = new g0();

    /* renamed from: h, reason: collision with root package name */
    public static final zzaho<zzbgz> f13894h = new h0();

    /* renamed from: i, reason: collision with root package name */
    public static final zzaho<zzbgz> f13895i = d0.a;

    /* renamed from: j, reason: collision with root package name */
    public static final zzaho<zzbgz> f13896j = new i0();

    /* renamed from: k, reason: collision with root package name */
    public static final zzaho<zzbgz> f13897k = new j0();
    public static final zzaho<zzbdf> l = new zzbfo();
    public static final zzaho<zzbdf> m = new zzbfp();
    public static final zzaho<zzbgz> n = new zzagy();
    public static final zzahu o = new zzahu();
    public static final zzaho<zzbgz> p = new k0();
    public static final zzaho<zzbgz> q = new l0();
    public static final zzaho<zzbgz> r = new m0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzaji zzajiVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzbad.i("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzdh d2 = ((zzbif) zzajiVar).d();
            if (d2 != null && d2.e(parse)) {
                parse = d2.a(parse, ((zzbhx) zzajiVar).getContext(), ((zzbih) zzajiVar).getView(), ((zzbhx) zzajiVar).a());
            }
        } catch (zzdi unused) {
            zzbad.i(str.length() != 0 ? "Unable to append parameter to URL: ".concat(str) : new String("Unable to append parameter to URL: "));
        }
        zzbhx zzbhxVar = (zzbhx) zzajiVar;
        new zzazi(zzbhxVar.getContext(), ((zzbig) zzajiVar).b().f14326f, zzavx.b(parse, zzbhxVar.getContext())).zzvi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void b(zzbhx zzbhxVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzbad.i("URL missing from httpTrack GMSG.");
        } else {
            new zzazi(zzbhxVar.getContext(), ((zzbig) zzbhxVar).b().f14326f, str).zzvi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void c(zzbif zzbifVar, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzdh d2 = zzbifVar.d();
            if (d2 != null) {
                d2.f().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzbad.i("Could not parse touch parameters from gmsg.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void d(zzbhx zzbhxVar, Map map) {
        PackageManager packageManager = zzbhxVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String optString = jSONObject2.optString(DeepLinkIntentReceiver.DeepLinksKeys.ID);
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e2) {
                                String valueOf = String.valueOf(optString7);
                                zzbad.c(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e2);
                            }
                        }
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        try {
                            jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                        } catch (JSONException e3) {
                            zzbad.c("Error constructing openable urls response.", e3);
                        }
                    } catch (JSONException e4) {
                        zzbad.c("Error parsing the intent data.", e4);
                    }
                }
                ((zzaji) zzbhxVar).j("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzaji) zzbhxVar).j("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzaji) zzbhxVar).j("openableIntents", new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void e(zzbhx zzbhxVar, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzbad.i("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbhxVar.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zzaji) zzbhxVar).y("openableURLs", hashMap);
    }
}
