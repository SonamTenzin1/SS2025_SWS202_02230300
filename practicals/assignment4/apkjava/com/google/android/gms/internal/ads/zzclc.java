package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzclc {
    private final AtomicReference<zzamp> a = new AtomicReference<>();

    private final zzamp b() throws RemoteException {
        zzamp zzampVar = this.a.get();
        if (zzampVar != null) {
            return zzampVar;
        }
        zzbad.i("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    private final zzams f(String str, JSONObject jSONObject) throws RemoteException {
        zzamp b2 = b();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                if (b2.N6(jSONObject.getString("class_name"))) {
                    return b2.l6("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                }
                return b2.l6("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e2) {
                zzbad.c("Invalid custom event.", e2);
            }
        }
        return b2.l6(str);
    }

    public final boolean a() {
        return this.a.get() != null;
    }

    public final void c(zzamp zzampVar) {
        this.a.compareAndSet(null, zzampVar);
    }

    public final zzaov d(String str) throws RemoteException {
        return b().P2(str);
    }

    public final zzams e(String str, JSONObject jSONObject) throws RemoteException {
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
            return new zzanl(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
            return new zzanl(new AdUrlAdapter());
        }
        if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
            return new zzanl(new zzapl());
        }
        return f(str, jSONObject);
    }
}
