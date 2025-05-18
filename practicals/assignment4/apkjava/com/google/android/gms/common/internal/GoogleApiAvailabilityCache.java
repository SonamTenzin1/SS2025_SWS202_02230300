package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* loaded from: classes2.dex */
public class GoogleApiAvailabilityCache {
    private final SparseIntArray a;

    /* renamed from: b, reason: collision with root package name */
    private GoogleApiAvailabilityLight f11989b;

    public GoogleApiAvailabilityCache() {
        this(GoogleApiAvailability.q());
    }

    public void a() {
        this.a.clear();
    }

    public int b(Context context, Api.Client client) {
        Preconditions.k(context);
        Preconditions.k(client);
        int i2 = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int i3 = this.a.get(minApkVersion, -1);
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= this.a.size()) {
                i2 = i3;
                break;
            }
            int keyAt = this.a.keyAt(i4);
            if (keyAt > minApkVersion && this.a.get(keyAt) == 0) {
                break;
            }
            i4++;
        }
        if (i2 == -1) {
            i2 = this.f11989b.j(context, minApkVersion);
        }
        this.a.put(minApkVersion, i2);
        return i2;
    }

    public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.a = new SparseIntArray();
        Preconditions.k(googleApiAvailabilityLight);
        this.f11989b = googleApiAvailabilityLight;
    }
}
