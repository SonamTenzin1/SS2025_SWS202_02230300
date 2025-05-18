package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i extends p {

    /* renamed from: g, reason: collision with root package name */
    private final Map<Api.Client, h> f11761g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ zaak f11762h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(zaak zaakVar, Map<Api.Client, h> map) {
        super(zaakVar, null);
        this.f11762h = zaakVar;
        this.f11761g = map;
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void a() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        boolean z;
        Context context2;
        zabe zabeVar;
        zad zadVar;
        zad zadVar2;
        zabe zabeVar2;
        Context context3;
        boolean z2;
        googleApiAvailabilityLight = this.f11762h.f11807d;
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(googleApiAvailabilityLight);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.f11761g.keySet()) {
            if (client.requiresGooglePlayServices()) {
                z2 = this.f11761g.get(client).f11758c;
                if (!z2) {
                    arrayList.add(client);
                }
            }
            arrayList2.add(client);
        }
        int i2 = -1;
        int i3 = 0;
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                context3 = this.f11762h.f11806c;
                i2 = googleApiAvailabilityCache.b(context3, (Api.Client) obj);
                if (i2 == 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList.size();
            while (i3 < size2) {
                Object obj2 = arrayList.get(i3);
                i3++;
                context = this.f11762h.f11806c;
                i2 = googleApiAvailabilityCache.b(context, (Api.Client) obj2);
                if (i2 != 0) {
                    break;
                }
            }
        }
        if (i2 == 0) {
            z = this.f11762h.m;
            if (z) {
                zadVar = this.f11762h.f11814k;
                if (zadVar != null) {
                    zadVar2 = this.f11762h.f11814k;
                    zadVar2.a();
                }
            }
            for (Api.Client client2 : this.f11761g.keySet()) {
                h hVar = this.f11761g.get(client2);
                if (client2.requiresGooglePlayServices()) {
                    context2 = this.f11762h.f11806c;
                    if (googleApiAvailabilityCache.b(context2, client2) != 0) {
                        zabeVar = this.f11762h.a;
                        zabeVar.h(new k(this, this.f11762h, hVar));
                    }
                }
                client2.connect(hVar);
            }
            return;
        }
        ConnectionResult connectionResult = new ConnectionResult(i2, null);
        zabeVar2 = this.f11762h.a;
        zabeVar2.h(new j(this, this.f11762h, connectionResult));
    }
}
