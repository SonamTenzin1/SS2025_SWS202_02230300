package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class m0 implements zzaho<zzbgz> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        zzbgz zzbgzVar2 = zzbgzVar;
        WindowManager windowManager = (WindowManager) zzbgzVar2.getContext().getSystemService("window");
        zzk.zzlg();
        DisplayMetrics b2 = zzaxi.b(windowManager);
        int i2 = b2.widthPixels;
        int i3 = b2.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzbgzVar2).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i2));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i3));
        zzbgzVar2.y("locationReady", hashMap);
        zzbad.i("GET LOCATION COMPILED");
    }
}
