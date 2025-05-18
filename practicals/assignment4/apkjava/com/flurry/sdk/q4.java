package com.flurry.sdk;

import android.util.Base64;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q4 implements f7<l> {
    @Override // com.flurry.sdk.f7
    public final /* synthetic */ void a(l lVar) {
        l lVar2 = lVar;
        boolean z = lVar2.f10893b;
        Map<m, String> a = lVar2.a();
        if (a != null && a.size() != 0) {
            m2.a().b(new i6(new j6(a, z)));
        } else {
            d1.c(2, "ReportedIDFrame", "Reported ids is empty, do not send the frame.");
        }
        Map<m, String> a2 = lVar2.a();
        HashMap hashMap = new HashMap();
        for (Map.Entry<m, String> entry : a2.entrySet()) {
            if (entry.getKey().equals(m.AndroidInstallationId)) {
                hashMap.put(entry.getKey().name(), c2.c(Base64.decode(entry.getValue(), 2)).toUpperCase(Locale.getDefault()));
            } else {
                hashMap.put(entry.getKey().name(), entry.getValue());
            }
        }
        g0.a();
        g0.f("Reported Ids", hashMap);
        d1.c(4, "IdObserver", "IdProvider" + lVar2.a());
    }
}
