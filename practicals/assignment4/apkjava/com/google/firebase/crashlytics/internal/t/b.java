package com.google.firebase.crashlytics.internal.t;

import com.google.firebase.crashlytics.internal.n.d0;
import com.google.firebase.crashlytics.internal.t.d;
import org.json.JSONObject;

/* compiled from: DefaultSettingsJsonTransform.java */
/* loaded from: classes2.dex */
class b implements h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b(d0 d0Var) {
        return new d(3600000 + d0Var.a(), new d.b(8, 4), new d.a(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    @Override // com.google.firebase.crashlytics.internal.t.h
    public d a(d0 d0Var, JSONObject jSONObject) {
        return b(d0Var);
    }
}
