package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Arrays;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzbcx extends zzbcp {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        if (r18 == 2) goto L19;
     */
    @Override // com.google.android.gms.internal.ads.zzbcp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzbco a(Context context, zzbdf zzbdfVar, int i2, boolean z, zzadi zzadiVar, zzbde zzbdeVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        boolean z2 = true;
        if (!(PlatformVersion.a() && (applicationInfo == null || applicationInfo.targetSdkVersion >= 11))) {
            return null;
        }
        zzbdg zzbdgVar = new zzbdg(context, zzbdfVar.b(), zzbdfVar.r(), zzadiVar, zzbdfVar.P());
        if (Build.VERSION.SDK_INT < 16) {
        }
        z2 = false;
        if (z2) {
            List asList = Arrays.asList(zzbdeVar.f14367e.split(","));
            if (asList.contains("3")) {
                return new zzbek(context, zzbdgVar, zzbdfVar, z, zzbcp.b(zzbdfVar), zzbdeVar);
            }
            if (asList.contains("1")) {
                return new zzbdq(context, zzbdgVar, zzbdfVar, i2, z, zzbcp.b(zzbdfVar), zzbdeVar);
            }
        }
        return new zzbcd(context, z, zzbcp.b(zzbdfVar), zzbdeVar, new zzbdg(context, zzbdfVar.b(), zzbdfVar.r(), zzadiVar, zzbdfVar.P()));
    }
}
