package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class e implements AppMeasurement.OnEventListener {
    private final /* synthetic */ b a;

    public e(b bVar) {
        this.a = bVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final void a(String str, String str2, Bundle bundle, long j2) {
        a.b bVar;
        if (this.a.a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", c.f(str2));
            bVar = this.a.f18857b;
            bVar.a(2, bundle2);
        }
    }
}
