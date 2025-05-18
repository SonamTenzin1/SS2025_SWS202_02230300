package com.google.firebase.crashlytics.internal.l;

import android.os.Bundle;
import com.google.firebase.analytics.a.a;

/* compiled from: CrashlyticsOriginAnalyticsEventLogger.java */
/* loaded from: classes2.dex */
public class e implements a {
    private final a a;

    public e(a aVar) {
        this.a = aVar;
    }

    @Override // com.google.firebase.crashlytics.internal.l.a
    public void a(String str, Bundle bundle) {
        this.a.m0("clx", str, bundle);
    }
}
