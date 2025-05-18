package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class p0 {
    private final Map<String, Map<String, String>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(Map<String, Map<String, String>> map) {
        this.a = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p0 a() {
        return new p0(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b(Uri uri, String str, String str2, String str3) {
        if (this.a == null) {
            return null;
        }
        if (uri != null) {
            str = uri.toString();
        } else if (str == null) {
            return null;
        }
        Map<String, String> map = this.a.get(str);
        if (map == null) {
            return null;
        }
        if (str2 != null) {
            String valueOf = String.valueOf(str3);
            str3 = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
        }
        return map.get(str3);
    }
}
