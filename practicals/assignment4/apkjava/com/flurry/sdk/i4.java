package com.flurry.sdk;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class i4 extends r6 {
    public i4(t6 t6Var) {
        super(t6Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d9  */
    @TargetApi(18)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, Map<String, String>> h(h0 h0Var) {
        int i2;
        int i3;
        n nVar;
        Intent registerReceiver;
        HashMap hashMap = new HashMap();
        new HashMap();
        if (h0Var.a) {
            hashMap.put("boot.time", i(Long.toString(System.currentTimeMillis() - SystemClock.elapsedRealtime())));
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 18) {
                hashMap.put("disk.size.total.internal", i(Long.toString(statFs.getAvailableBlocksLong())));
                hashMap.put("disk.size.available.internal", i(Long.toString(statFs.getAvailableBlocksLong())));
            } else {
                hashMap.put("disk.size.total.internal", i(Long.toString(statFs.getAvailableBlocks())));
                hashMap.put("disk.size.available.internal", i(Long.toString(statFs.getAvailableBlocks())));
            }
            n nVar2 = h0Var.f10807b;
            if (nVar2 != null && !nVar2.a) {
                try {
                    StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
                    if (i4 >= 18) {
                        hashMap.put("disk.size.total.external", i(Long.toString(statFs2.getAvailableBlocksLong())));
                        hashMap.put("disk.size.available.external", i(Long.toString(statFs2.getAvailableBlocksLong())));
                    } else {
                        hashMap.put("disk.size.total.external", i(Long.toString(statFs2.getAvailableBlocks())));
                        hashMap.put("disk.size.available.external", i(Long.toString(statFs2.getAvailableBlocks())));
                    }
                } catch (Exception e2) {
                    d1.c(5, "SessionPropertiesFrame", e2.getMessage());
                }
            }
            m0.a();
            TelephonyManager telephonyManager = (TelephonyManager) b0.a().getSystemService("phone");
            hashMap.put("carrier.name", i(telephonyManager == null ? null : telephonyManager.getNetworkOperatorName()));
            m0.a();
            TelephonyManager telephonyManager2 = (TelephonyManager) b0.a().getSystemService("phone");
            hashMap.put("carrier.details", i(telephonyManager2 == null ? null : telephonyManager2.getNetworkOperator()));
        }
        ActivityManager activityManager = (ActivityManager) b0.a().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        Map<String, String> i5 = i(Long.toString(memoryInfo.availMem));
        StringBuilder sb = new StringBuilder("memory.available");
        sb.append(h0Var.a ? ".start" : ".end");
        hashMap.put(sb.toString(), i5);
        if (Build.VERSION.SDK_INT >= 16) {
            Map<String, String> i6 = i(Long.toString(memoryInfo.availMem));
            StringBuilder sb2 = new StringBuilder("memory.total");
            sb2.append(h0Var.a ? ".start" : ".end");
            hashMap.put(sb2.toString(), i6);
        }
        int i7 = -1;
        try {
            registerReceiver = b0.a().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e3) {
            e = e3;
            i2 = -1;
        }
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            r1 = intExtra == 2 || intExtra == 5;
            i2 = registerReceiver.getIntExtra("level", -1);
            try {
                i3 = registerReceiver.getIntExtra("scale", -1);
                i7 = i2;
            } catch (Exception e4) {
                e = e4;
                d1.c(5, "SessionPropertiesFrame", "Error getting battery status: ".concat(String.valueOf(e)));
                i7 = i2;
                i3 = -1;
                float f2 = i7 / i3;
                Map<String, String> i8 = i(Boolean.toString(r1));
                StringBuilder sb3 = new StringBuilder("battery.charging");
                sb3.append(h0Var.a ? ".start" : ".end");
                hashMap.put(sb3.toString(), i8);
                Map<String, String> i9 = i(Float.toString(f2));
                StringBuilder sb4 = new StringBuilder("battery.remaining");
                sb4.append(h0Var.a ? ".start" : ".end");
                hashMap.put(sb4.toString(), i9);
                nVar = h0Var.f10807b;
                if (nVar != null) {
                }
                return hashMap;
            }
            float f22 = i7 / i3;
            Map<String, String> i82 = i(Boolean.toString(r1));
            StringBuilder sb32 = new StringBuilder("battery.charging");
            sb32.append(h0Var.a ? ".start" : ".end");
            hashMap.put(sb32.toString(), i82);
            Map<String, String> i92 = i(Float.toString(f22));
            StringBuilder sb42 = new StringBuilder("battery.remaining");
            sb42.append(h0Var.a ? ".start" : ".end");
            hashMap.put(sb42.toString(), i92);
            nVar = h0Var.f10807b;
            if (nVar != null && nVar.a) {
                hashMap.put("instantapp.name", i(nVar.f10925b));
            }
            return hashMap;
        }
        i3 = -1;
        float f222 = i7 / i3;
        Map<String, String> i822 = i(Boolean.toString(r1));
        StringBuilder sb322 = new StringBuilder("battery.charging");
        sb322.append(h0Var.a ? ".start" : ".end");
        hashMap.put(sb322.toString(), i822);
        Map<String, String> i922 = i(Float.toString(f222));
        StringBuilder sb422 = new StringBuilder("battery.remaining");
        sb422.append(h0Var.a ? ".start" : ".end");
        hashMap.put(sb422.toString(), i922);
        nVar = h0Var.f10807b;
        if (nVar != null) {
            hashMap.put("instantapp.name", i(nVar.f10925b));
        }
        return hashMap;
    }

    private static Map<String, String> i(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", str);
        return hashMap;
    }

    @Override // com.flurry.sdk.u6
    public final s6 a() {
        return s6.SESSION_PROPERTIES;
    }
}
