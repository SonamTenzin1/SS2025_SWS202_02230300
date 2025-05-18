package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.util.DisplayMetrics;
import io.sentry.s4;
import io.sentry.w1;
import io.sentry.x4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: ContextUtils.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class t0 {

    /* compiled from: ContextUtils.java */
    /* loaded from: classes2.dex */
    static class a {
        private final boolean a;

        /* renamed from: b, reason: collision with root package name */
        private final String f22258b;

        public a(boolean z, String str) {
            this.a = z;
            this.f22258b = str;
        }

        public Map<String, String> a() {
            HashMap hashMap = new HashMap();
            hashMap.put("isSideLoaded", String.valueOf(this.a));
            String str = this.f22258b;
            if (str != null) {
                hashMap.put("installerStore", str);
            }
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public static ApplicationInfo a(Context context, long j2, s0 s0Var) throws PackageManager.NameNotFoundException {
        if (s0Var.d() >= 33) {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(j2));
        }
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Context context, w1 w1Var) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.labelRes;
            if (i2 == 0) {
                CharSequence charSequence = applicationInfo.nonLocalizedLabel;
                if (charSequence != null) {
                    return charSequence.toString();
                }
                return context.getPackageManager().getApplicationLabel(applicationInfo).toString();
            }
            return context.getString(i2);
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Error getting application name.", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public static String[] c(s0 s0Var) {
        return s0Var.d() >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public static String d(Context context, s0 s0Var) {
        if (s0Var.d() >= 17) {
            return Settings.Global.getString(context.getContentResolver(), "device_name");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayMetrics e(Context context, w1 w1Var) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Error getting DisplayMetrics.", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f(w1 w1Var) {
        try {
            return Build.MODEL.split(" ", -1)[0];
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Error getting device family.", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(w1 w1Var) {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                return readLine;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException e2) {
            w1Var.b(s4.ERROR, "Exception while attempting to read kernel information", e2);
            return property;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ActivityManager.MemoryInfo h(Context context, w1 w1Var) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            w1Var.c(s4.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public static PackageInfo i(Context context, int i2, w1 w1Var, s0 s0Var) {
        try {
            if (s0Var.d() >= 33) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(i2));
            }
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i2);
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Error getting package info.", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PackageInfo j(Context context, w1 w1Var, s0 s0Var) {
        return i(context, 0, w1Var, s0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public static String k(PackageInfo packageInfo, s0 s0Var) {
        if (s0Var.d() >= 28) {
            return Long.toString(packageInfo.getLongVersionCode());
        }
        return l(packageInfo);
    }

    private static String l(PackageInfo packageInfo) {
        return Integer.toString(packageInfo.versionCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Object systemService = context.getSystemService("activity");
            if (!(systemService instanceof ActivityManager) || (runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses()) == null) {
                return false;
            }
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.importance == 100;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent n(Context context, x4 x4Var, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return o(context, new s0(x4Var.getLogger()), broadcastReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi", "UnspecifiedRegisterReceiverFlag"})
    public static Intent o(Context context, s0 s0Var, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (s0Var.d() >= 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, 2);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a p(Context context, w1 w1Var, s0 s0Var) {
        String str;
        try {
            PackageInfo j2 = j(context, w1Var, s0Var);
            PackageManager packageManager = context.getPackageManager();
            if (j2 != null && packageManager != null) {
                str = j2.packageName;
                try {
                    String installerPackageName = packageManager.getInstallerPackageName(str);
                    return new a(installerPackageName == null, installerPackageName);
                } catch (IllegalArgumentException unused) {
                    w1Var.c(s4.DEBUG, "%s package isn't installed.", str);
                    return null;
                }
            }
        } catch (IllegalArgumentException unused2) {
            str = null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public static void q(PackageInfo packageInfo, s0 s0Var, io.sentry.protocol.a aVar) {
        aVar.l(packageInfo.packageName);
        aVar.o(packageInfo.versionName);
        aVar.k(k(packageInfo, s0Var));
        if (s0Var.d() >= 16) {
            HashMap hashMap = new HashMap();
            String[] strArr = packageInfo.requestedPermissions;
            int[] iArr = packageInfo.requestedPermissionsFlags;
            if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    String str = strArr[i2];
                    hashMap.put(str.substring(str.lastIndexOf(46) + 1), (iArr[i2] & 2) == 2 ? "granted" : "not_granted");
                }
            }
            aVar.q(hashMap);
        }
    }
}
