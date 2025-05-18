package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzahq implements zzaho<Object> {
    private final Context a;

    public zzahq(Context context) {
        this.a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void a(Object obj, Map<String, String> map) {
        if (zzk.zzme().D(this.a)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case 94399:
                    if (str.equals("_aa")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 94401:
                    if (str.equals("_ac")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94407:
                    if (str.equals("_ai")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    zzk.zzme().y(this.a, str2);
                    return;
                case 1:
                    zzk.zzme().u(this.a, str2);
                    return;
                case 2:
                    zzk.zzme().v(this.a, str2);
                    return;
                default:
                    zzbad.g("logScionEvent gmsg contained unsupported eventName");
                    return;
            }
        }
    }
}
