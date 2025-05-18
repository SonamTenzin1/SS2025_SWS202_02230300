package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.analytics.a.a;
import com.google.firebase.crashlytics.internal.h;
import java.util.Locale;

/* compiled from: CrashlyticsAnalyticsListener.java */
/* loaded from: classes2.dex */
class f implements a.b {
    private com.google.firebase.crashlytics.internal.l.b a;

    /* renamed from: b, reason: collision with root package name */
    private com.google.firebase.crashlytics.internal.l.b f18990b;

    private static void b(com.google.firebase.crashlytics.internal.l.b bVar, String str, Bundle bundle) {
        if (bVar == null) {
            return;
        }
        bVar.J0(str, bundle);
    }

    private void c(String str, Bundle bundle) {
        com.google.firebase.crashlytics.internal.l.b bVar;
        if ("clx".equals(bundle.getString("_o"))) {
            bVar = this.a;
        } else {
            bVar = this.f18990b;
        }
        b(bVar, str, bundle);
    }

    @Override // com.google.firebase.analytics.a.a.b
    public void a(int i2, Bundle bundle) {
        String string;
        h.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i2), bundle));
        if (bundle == null || (string = bundle.getString("name")) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("params");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        c(string, bundle2);
    }

    public void d(com.google.firebase.crashlytics.internal.l.b bVar) {
        this.f18990b = bVar;
    }

    public void e(com.google.firebase.crashlytics.internal.l.b bVar) {
        this.a = bVar;
    }
}
