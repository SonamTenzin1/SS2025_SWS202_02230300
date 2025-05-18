package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class AvailabilityException extends Exception {

    /* renamed from: f, reason: collision with root package name */
    private final c.e.a<zai<?>, ConnectionResult> f11656f;

    public AvailabilityException(c.e.a<zai<?>, ConnectionResult> aVar) {
        this.f11656f = aVar;
    }

    public ConnectionResult a(GoogleApi<? extends Api.ApiOptions> googleApi) {
        zai<? extends Api.ApiOptions> l = googleApi.l();
        Preconditions.b(this.f11656f.get(l) != null, "The given API was not part of the availability request.");
        return this.f11656f.get(l);
    }

    public final c.e.a<zai<?>, ConnectionResult> b() {
        return this.f11656f;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (zai<?> zaiVar : this.f11656f.keySet()) {
            ConnectionResult connectionResult = this.f11656f.get(zaiVar);
            if (connectionResult.e0()) {
                z = false;
            }
            String c2 = zaiVar.c();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 2 + valueOf.length());
            sb.append(c2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
