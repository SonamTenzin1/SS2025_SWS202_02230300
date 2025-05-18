package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzahu implements zzaho<Object> {
    private final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, zzahw> f13904b = new HashMap();

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void a(Object obj, Map<String, String> map) {
        String concat;
        String str = map.get(DeepLinkIntentReceiver.DeepLinksKeys.ID);
        String str2 = map.get("fail");
        String str3 = map.get("fail_reason");
        String str4 = map.get("fail_stack");
        String str5 = map.get("result");
        if (TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str4)) {
            concat = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            String valueOf = String.valueOf(str4);
            concat = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.a) {
            zzahw remove = this.f13904b.remove(str);
            if (remove == null) {
                String valueOf2 = String.valueOf(str);
                zzbad.i(valueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf2) : new String("Received result for unexpected method invocation: "));
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                String valueOf3 = String.valueOf(str3);
                String valueOf4 = String.valueOf(concat);
                remove.onFailure(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else {
                if (str5 == null) {
                    remove.a(null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (zzawz.n()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        zzawz.m(valueOf5.length() != 0 ? "Result GMSG: ".concat(valueOf5) : new String("Result GMSG: "));
                    }
                    remove.a(jSONObject);
                } catch (JSONException e2) {
                    remove.onFailure(e2.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzakg> zzbbh<JSONObject> b(EngineT enginet, String str, JSONObject jSONObject) {
        zzbbr zzbbrVar = new zzbbr();
        zzk.zzlg();
        String j0 = zzaxi.j0();
        c(j0, new n0(this, zzbbrVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, j0);
            jSONObject2.put("args", jSONObject);
            enginet.Y(str, jSONObject2);
        } catch (Exception e2) {
            zzbbrVar.c(e2);
        }
        return zzbbrVar;
    }

    public final void c(String str, zzahw zzahwVar) {
        synchronized (this.a) {
            this.f13904b.put(str, zzahwVar);
        }
    }
}
