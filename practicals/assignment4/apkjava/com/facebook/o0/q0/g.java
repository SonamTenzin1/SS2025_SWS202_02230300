package com.facebook.o0.q0;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.facebook.a0;
import com.facebook.internal.p0;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.HttpUrl;

/* compiled from: AppEventUtility.kt */
/* loaded from: classes2.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    public static final void a() {
    }

    public static final void b() {
    }

    public static final String c(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "bytes");
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            i2++;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
            stringBuffer.append(format);
        }
        String stringBuffer2 = stringBuffer.toString();
        kotlin.jvm.internal.m.e(stringBuffer2, "sb.toString()");
        return stringBuffer2;
    }

    public static final String d() {
        a0 a0Var = a0.a;
        Context c2 = a0.c();
        try {
            String str = c2.getPackageManager().getPackageInfo(c2.getPackageName(), 0).versionName;
            kotlin.jvm.internal.m.e(str, "{\n      val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)\n      packageInfo.versionName\n    }");
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static final View e(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            return window.getDecorView().getRootView();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
    
        if (r0 == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean f() {
        boolean E;
        boolean E2;
        boolean J;
        boolean J2;
        boolean J3;
        boolean J4;
        boolean E3;
        boolean E4;
        String str = Build.FINGERPRINT;
        kotlin.jvm.internal.m.e(str, "FINGERPRINT");
        E = u.E(str, "generic", false, 2, null);
        if (!E) {
            kotlin.jvm.internal.m.e(str, "FINGERPRINT");
            E2 = u.E(str, "unknown", false, 2, null);
            if (!E2) {
                String str2 = Build.MODEL;
                kotlin.jvm.internal.m.e(str2, "MODEL");
                J = v.J(str2, "google_sdk", false, 2, null);
                if (!J) {
                    kotlin.jvm.internal.m.e(str2, "MODEL");
                    J2 = v.J(str2, "Emulator", false, 2, null);
                    if (!J2) {
                        kotlin.jvm.internal.m.e(str2, "MODEL");
                        J3 = v.J(str2, "Android SDK built for x86", false, 2, null);
                        if (!J3) {
                            String str3 = Build.MANUFACTURER;
                            kotlin.jvm.internal.m.e(str3, "MANUFACTURER");
                            J4 = v.J(str3, "Genymotion", false, 2, null);
                            if (!J4) {
                                String str4 = Build.BRAND;
                                kotlin.jvm.internal.m.e(str4, "BRAND");
                                E3 = u.E(str4, "generic", false, 2, null);
                                if (E3) {
                                    String str5 = Build.DEVICE;
                                    kotlin.jvm.internal.m.e(str5, "DEVICE");
                                    E4 = u.E(str5, "generic", false, 2, null);
                                }
                                if (!kotlin.jvm.internal.m.a("google_sdk", Build.PRODUCT)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static final double g(String str) {
        try {
            Matcher matcher = Pattern.compile("[-+]*\\d+([.,]\\d+)*([.,]\\d+)?", 8).matcher(str);
            if (!matcher.find()) {
                return 0.0d;
            }
            String group = matcher.group(0);
            p0 p0Var = p0.a;
            return NumberFormat.getNumberInstance(p0.y()).parse(group).doubleValue();
        } catch (ParseException unused) {
            return 0.0d;
        }
    }
}
