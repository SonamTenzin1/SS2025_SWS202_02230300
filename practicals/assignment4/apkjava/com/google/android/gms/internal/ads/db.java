package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
final class db implements zzaho<zzbgz> {
    private final /* synthetic */ bb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(bb bbVar) {
        this.a = bbVar;
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
                    i2 = this.a.I;
                    if (i2 != parseInt) {
                        this.a.I = parseInt;
                        this.a.requestLayout();
                    }
                }
            } catch (Exception e2) {
                zzbad.d("Exception occurred while getting webview content height", e2);
            }
        }
    }
}
