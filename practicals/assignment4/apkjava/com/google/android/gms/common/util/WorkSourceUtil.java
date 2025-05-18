package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class WorkSourceUtil {
    private static final int a = Process.myUid();

    /* renamed from: b, reason: collision with root package name */
    private static final Method f12156b;

    /* renamed from: c, reason: collision with root package name */
    private static final Method f12157c;

    /* renamed from: d, reason: collision with root package name */
    private static final Method f12158d;

    /* renamed from: e, reason: collision with root package name */
    private static final Method f12159e;

    /* renamed from: f, reason: collision with root package name */
    private static final Method f12160f;

    /* renamed from: g, reason: collision with root package name */
    private static final Method f12161g;

    /* renamed from: h, reason: collision with root package name */
    private static final Method f12162h;

    /* renamed from: i, reason: collision with root package name */
    private static final Method f12163i;

    /* JADX WARN: Can't wrap try/catch for region: R(25:1|2|3|4|(21:49|50|7|8|9|10|11|12|13|(12:41|42|16|(9:36|37|19|(6:31|32|22|(2:27|28)|24|25)|21|22|(0)|24|25)|18|19|(0)|21|22|(0)|24|25)|15|16|(0)|18|19|(0)|21|22|(0)|24|25)|6|7|8|9|10|11|12|13|(0)|15|16|(0)|18|19|(0)|21|22|(0)|24|25) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0053, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0041, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Method method6 = null;
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            method = null;
        }
        f12156b = method;
        if (PlatformVersion.e()) {
            try {
                method2 = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused2) {
            }
            f12157c = method2;
            Method method7 = WorkSource.class.getMethod("size", new Class[0]);
            f12158d = method7;
            Method method8 = WorkSource.class.getMethod("get", Integer.TYPE);
            f12159e = method8;
            if (PlatformVersion.e()) {
                try {
                    method3 = WorkSource.class.getMethod("getName", Integer.TYPE);
                } catch (Exception unused3) {
                }
                f12160f = method3;
                if (PlatformVersion.l()) {
                    try {
                        method4 = WorkSource.class.getMethod("createWorkChain", new Class[0]);
                    } catch (Exception e2) {
                        Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e2);
                    }
                    f12161g = method4;
                    if (PlatformVersion.l()) {
                        try {
                            method5 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
                        } catch (Exception e3) {
                            Log.w("WorkSourceUtil", "Missing WorkChain class", e3);
                        }
                        f12162h = method5;
                        if (PlatformVersion.l()) {
                            try {
                                method6 = WorkSource.class.getMethod("isEmpty", new Class[0]);
                                method6.setAccessible(true);
                            } catch (Exception unused4) {
                            }
                        }
                        f12163i = method6;
                    }
                    method5 = null;
                    f12162h = method5;
                    if (PlatformVersion.l()) {
                    }
                    f12163i = method6;
                }
                method4 = null;
                f12161g = method4;
                if (PlatformVersion.l()) {
                }
                method5 = null;
                f12162h = method5;
                if (PlatformVersion.l()) {
                }
                f12163i = method6;
            }
            method3 = null;
            f12160f = method3;
            if (PlatformVersion.l()) {
            }
            method4 = null;
            f12161g = method4;
            if (PlatformVersion.l()) {
            }
            method5 = null;
            f12162h = method5;
            if (PlatformVersion.l()) {
            }
            f12163i = method6;
        }
        method2 = null;
        f12157c = method2;
        Method method72 = WorkSource.class.getMethod("size", new Class[0]);
        f12158d = method72;
        Method method82 = WorkSource.class.getMethod("get", Integer.TYPE);
        f12159e = method82;
        if (PlatformVersion.e()) {
        }
        method3 = null;
        f12160f = method3;
        if (PlatformVersion.l()) {
        }
        method4 = null;
        f12161g = method4;
        if (PlatformVersion.l()) {
        }
        method5 = null;
        f12162h = method5;
        if (PlatformVersion.l()) {
        }
        f12163i = method6;
    }

    private WorkSourceUtil() {
    }

    @KeepForSdk
    public static void a(WorkSource workSource, int i2, String str) {
        Method method = f12157c;
        if (method != null) {
            if (str == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            try {
                method.invoke(workSource, Integer.valueOf(i2), str);
                return;
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                return;
            }
        }
        Method method2 = f12156b;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i2));
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            }
        }
    }

    @KeepForSdk
    public static WorkSource b(Context context, String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo c2 = Wrappers.a(context).c(str, 0);
                if (c2 == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i2 = c2.uid;
                WorkSource workSource = new WorkSource();
                a(workSource, i2, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    @KeepForSdk
    public static String c(WorkSource workSource, int i2) {
        Method method = f12160f;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i2));
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }

    @KeepForSdk
    public static List<String> d(WorkSource workSource) {
        ArrayList arrayList = new ArrayList();
        int f2 = workSource == null ? 0 : f(workSource);
        if (f2 != 0) {
            for (int i2 = 0; i2 < f2; i2++) {
                String c2 = c(workSource, i2);
                if (!Strings.a(c2)) {
                    Preconditions.k(c2);
                    arrayList.add(c2);
                }
            }
        }
        return arrayList;
    }

    @KeepForSdk
    public static boolean e(Context context) {
        return (context == null || context.getPackageManager() == null || Wrappers.a(context).b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    @KeepForSdk
    public static int f(WorkSource workSource) {
        Method method = f12158d;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Preconditions.k(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }
}
