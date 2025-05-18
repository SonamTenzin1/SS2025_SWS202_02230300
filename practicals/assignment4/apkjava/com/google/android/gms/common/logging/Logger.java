package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class Logger {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12085b;

    /* renamed from: c, reason: collision with root package name */
    private final GmsLogger f12086c;

    /* renamed from: d, reason: collision with root package name */
    private final int f12087d;

    @KeepForSdk
    public Logger(String str, String... strArr) {
        String sb;
        if (strArr.length == 0) {
            sb = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append("] ");
            sb = sb2.toString();
        }
        this.f12085b = sb;
        this.a = str;
        this.f12086c = new GmsLogger(str);
        int i2 = 2;
        while (i2 <= 7 && !Log.isLoggable(this.a, i2)) {
            i2++;
        }
        this.f12087d = i2;
    }

    @KeepForSdk
    public void a(String str, Object... objArr) {
        if (d(3)) {
            Log.d(this.a, c(str, objArr));
        }
    }

    @KeepForSdk
    public void b(String str, Object... objArr) {
        Log.e(this.a, c(str, objArr));
    }

    @KeepForSdk
    protected String c(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f12085b.concat(str);
    }

    @KeepForSdk
    public boolean d(int i2) {
        return this.f12087d <= i2;
    }
}
