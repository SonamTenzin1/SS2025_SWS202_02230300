package com.google.firebase.crashlytics.internal.l;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.h;

/* compiled from: UnavailableAnalyticsEventLogger.java */
/* loaded from: classes2.dex */
public class f implements a {
    @Override // com.google.firebase.crashlytics.internal.l.a
    public void a(String str, Bundle bundle) {
        h.f().b("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
    }
}
