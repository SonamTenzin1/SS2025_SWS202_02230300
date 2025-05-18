package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class f implements AppMeasurement.OnEventListener {
    private final /* synthetic */ d a;

    public f(d dVar) {
        this.a = dVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final void a(String str, String str2, Bundle bundle, long j2) {
        a.b bVar;
        if (str == null || str.equals("crash") || !c.e(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j2);
        bundle2.putBundle("params", bundle);
        bVar = this.a.a;
        bVar.a(3, bundle2);
    }
}
