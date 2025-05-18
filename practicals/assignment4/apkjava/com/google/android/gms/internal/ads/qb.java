package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
final class qb implements zzaho<zzbgz> {
    private final /* synthetic */ ob a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qb(ob obVar) {
        this.a = obVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        int i2;
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(str);
                synchronized (this.a) {
                    i2 = this.a.G;
                    if (i2 != parseInt) {
                        this.a.G = parseInt;
                        this.a.requestLayout();
                    }
                }
            } catch (Exception e2) {
                zzbad.d("Exception occurred while getting webview content height", e2);
            }
        }
    }
}
