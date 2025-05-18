package io.sentry.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: PropertiesProvider.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class f {
    public static Boolean a(g _this, String str) {
        String b2 = _this.b(str);
        if (b2 != null) {
            return Boolean.valueOf(b2);
        }
        return null;
    }

    public static Double b(g _this, String str) {
        String b2 = _this.b(str);
        if (b2 != null) {
            try {
                return Double.valueOf(b2);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static List c(g _this, String str) {
        String b2 = _this.b(str);
        return b2 != null ? Arrays.asList(b2.split(",")) : Collections.emptyList();
    }

    public static Long d(g _this, String str) {
        String b2 = _this.b(str);
        if (b2 != null) {
            try {
                return Long.valueOf(b2);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static String e(g _this, String str, String str2) {
        String b2 = _this.b(str);
        return b2 != null ? b2 : str2;
    }
}
