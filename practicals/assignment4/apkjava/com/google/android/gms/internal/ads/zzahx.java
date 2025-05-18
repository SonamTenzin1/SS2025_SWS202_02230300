package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzahx implements zzaho<Object> {
    private final zzahy a;

    private zzahx(zzahy zzahyVar) {
        this.a = zzahyVar;
    }

    public static void b(zzbgz zzbgzVar, zzahy zzahyVar) {
        zzbgzVar.f("/reward", new zzahx(zzahyVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void a(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzato zzatoVar = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzatoVar = new zzato(str2, parseInt);
                }
            } catch (NumberFormatException e2) {
                zzbad.d("Unable to parse reward amount.", e2);
            }
            this.a.P(zzatoVar);
            return;
        }
        if ("video_start".equals(str)) {
            this.a.r();
        } else if ("video_complete".equals(str)) {
            this.a.j();
        }
    }
}
