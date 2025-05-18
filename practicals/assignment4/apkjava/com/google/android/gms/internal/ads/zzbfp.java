package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzbfp implements zzaho<zzbdf> {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0085 A[Catch: NumberFormatException -> 0x00ca, NullPointerException | NumberFormatException -> 0x00cc, TryCatch #2 {NullPointerException | NumberFormatException -> 0x00cc, blocks: (B:24:0x000c, B:3:0x0033, B:8:0x0069, B:11:0x007f, B:13:0x0085, B:14:0x00c3, B:21:0x007a), top: B:23:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a A[Catch: NumberFormatException -> 0x00ca, NullPointerException | NumberFormatException -> 0x00cc, TryCatch #2 {NullPointerException | NumberFormatException -> 0x00cc, blocks: (B:24:0x000c, B:3:0x0033, B:8:0x0069, B:11:0x007f, B:13:0x0085, B:14:0x00c3, B:21:0x007a), top: B:23:0x000c }] */
    @Override // com.google.android.gms.internal.ads.zzaho
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void a(zzbdf zzbdfVar, Map map) {
        int i2;
        zzbdf zzbdfVar2 = zzbdfVar;
        zzbhq h2 = zzbdfVar2.h();
        if (h2 == null) {
            try {
                zzbhq zzbhqVar = new zzbhq(zzbdfVar2, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzbdfVar2.e(zzbhqVar);
                h2 = zzbhqVar;
            } catch (NullPointerException | NumberFormatException e2) {
                zzbad.c("Unable to parse videoMeta message.", e2);
                zzk.zzlk().e(e2, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get("duration"));
        boolean equals = "1".equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        if (parseInt >= 0 && 3 >= parseInt) {
            i2 = parseInt;
            String str = (String) map.get("aspectRatio");
            float parseFloat3 = !TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
            if (zzbad.a(3)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 140);
                sb.append("Video Meta GMSG: currentTime : ");
                sb.append(parseFloat2);
                sb.append(" , duration : ");
                sb.append(parseFloat);
                sb.append(" , isMuted : ");
                sb.append(equals);
                sb.append(" , playbackState : ");
                sb.append(i2);
                sb.append(" , aspectRatio : ");
                sb.append(str);
                zzbad.e(sb.toString());
            }
            h2.i7(parseFloat2, parseFloat, i2, equals, parseFloat3);
        }
        i2 = 0;
        String str2 = (String) map.get("aspectRatio");
        if (!TextUtils.isEmpty(str2)) {
        }
        if (zzbad.a(3)) {
        }
        h2.i7(parseFloat2, parseFloat, i2, equals, parseFloat3);
    }
}
