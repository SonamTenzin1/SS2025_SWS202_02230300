package com.google.android.material.datepicker;

import android.os.Build;
import java.util.Date;
import java.util.Locale;

/* compiled from: DateStrings.java */
/* loaded from: classes2.dex */
class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(long j2) {
        return b(j2, Locale.getDefault());
    }

    static String b(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return o.b(locale).format(new Date(j2));
        }
        return o.f(locale).format(new Date(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(long j2) {
        return d(j2, Locale.getDefault());
    }

    static String d(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return o.n(locale).format(new Date(j2));
        }
        return o.f(locale).format(new Date(j2));
    }
}
