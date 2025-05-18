package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcpf {
    private final zzclc a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, zzcpk> f15489b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, List<zzcpk>> f15490c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Executor f15491d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f15492e;

    public zzcpf(zzclc zzclcVar, Executor executor, Context context) {
        this.a = zzclcVar;
        this.f15491d = executor;
        this.f15492e = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized void f() {
        JSONArray optJSONArray;
        JSONObject f2 = zzk.zzlk().r().q().f();
        if (f2 != null) {
            try {
                JSONArray optJSONArray2 = f2.optJSONArray("ad_unit_id_settings");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject = optJSONArray2.getJSONObject(i2);
                        String optString = jSONObject.optString("ad_unit_id", HttpUrl.FRAGMENT_ENCODE_SET);
                        String optString2 = jSONObject.optString("format", HttpUrl.FRAGMENT_ENCODE_SET);
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("ad_networks")) != null) {
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                                ArrayList arrayList2 = new ArrayList();
                                if (jSONObject2 != null) {
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                    Bundle bundle = new Bundle();
                                    if (optJSONObject2 != null) {
                                        Iterator<String> keys = optJSONObject2.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            bundle.putString(next, optJSONObject2.optString(next, HttpUrl.FRAGMENT_ENCODE_SET));
                                        }
                                    }
                                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                    if (optJSONArray3 != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                            String optString3 = optJSONArray3.optString(i4, HttpUrl.FRAGMENT_ENCODE_SET);
                                            if (!TextUtils.isEmpty(optString3)) {
                                                arrayList3.add(optString3);
                                            }
                                        }
                                        int size = arrayList3.size();
                                        int i5 = 0;
                                        while (i5 < size) {
                                            Object obj = arrayList3.get(i5);
                                            i5++;
                                            String str = (String) obj;
                                            g(str);
                                            zzcpk zzcpkVar = this.f15489b.get(str);
                                            if (zzcpkVar != null) {
                                                arrayList2.add(new zzcpk(str, optString2, bundle, zzcpkVar.f15497d));
                                            }
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList2);
                            }
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            this.f15490c.put(optString, arrayList);
                        }
                    }
                }
            } catch (JSONException e2) {
                zzawz.l("Malformed config loading JSON.", e2);
            }
        }
    }

    public final void a() {
        zzk.zzlk().r().u(new Runnable(this) { // from class: com.google.android.gms.internal.ads.um

            /* renamed from: f, reason: collision with root package name */
            private final zzcpf f13405f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13405f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13405f.e();
            }
        });
        this.f15491d.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.vm

            /* renamed from: f, reason: collision with root package name */
            private final zzcpf f13460f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13460f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13460f.d();
            }
        });
    }

    public final Map<String, List<zzcpk>> b() {
        return this.f15490c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e() {
        this.f15491d.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.wm

            /* renamed from: f, reason: collision with root package name */
            private final zzcpf f13516f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13516f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13516f.f();
            }
        });
    }

    public final void g(String str) {
        if (TextUtils.isEmpty(str) || this.f15489b.containsKey(str)) {
            return;
        }
        try {
            this.f15489b.put(str, new zzcpk(str, HttpUrl.FRAGMENT_ENCODE_SET, new Bundle(), this.a.d(str)));
        } catch (RemoteException unused) {
        }
    }
}
