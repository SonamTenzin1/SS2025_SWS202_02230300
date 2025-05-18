package com.flurry.sdk;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class c2 {
    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
        }
    }

    public static String b(String str) {
        return str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str.length() <= 255 ? str : str.substring(0, 255);
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (byte b2 : bArr) {
            sb.append(cArr[(byte) ((b2 & 240) >> 4)]);
            sb.append(cArr[(byte) (b2 & 15)]);
        }
        return sb.toString();
    }

    public static void d() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Must be called from a background thread!");
        }
    }

    public static void e(int i2, String str, String str2, boolean z) {
        if (i2 < 100) {
            return;
        }
        String y = e7.a().l.y();
        long f2 = p2.f("last_streaming_session_id", Long.MIN_VALUE);
        HashMap hashMap = new HashMap();
        hashMap.put("fl.response.code", String.valueOf(i2));
        hashMap.put("fl.message", k(str));
        hashMap.put("fl.current.session", Boolean.toString(z));
        hashMap.put("fl.current.session.id", y);
        if (i2 != 200) {
            g0.a();
            g0.d("Flurry.SDKReport.ServerRequest", hashMap);
        }
        hashMap.put("fl.report.identifier", str2);
        if (f2 != Long.MIN_VALUE) {
            hashMap.put("fl.last.session.id", String.valueOf(f2));
        }
        g0.a();
        g0.f("Flurry.SDKReport.ServerRequest", hashMap);
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean g(int i2) {
        return Build.VERSION.SDK_INT >= i2;
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException e2) {
            d1.c(5, "GeneralUtil", "Unsupported UTF-8: " + e2.getMessage());
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static byte[] i(String str) {
        byte[] bArr = new byte[str.length() / 2];
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2 += 2) {
            StringBuilder sb = new StringBuilder(2);
            sb.append(charArray[i2]);
            sb.append(charArray[i2 + 1]);
            bArr[i2 / 2] = (byte) Integer.parseInt(sb.toString(), 16);
        }
        return bArr;
    }

    public static long j(String str) {
        if (str == null) {
            return 0L;
        }
        long j2 = 1125899906842597L;
        for (int i2 = 0; i2 < str.length(); i2++) {
            j2 = (j2 * 31) + str.charAt(i2);
        }
        return j2;
    }

    private static String k(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("status code")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("<!--|-->")) {
            if (!str2.contains("timestamp")) {
                String trim = str2.trim();
                if (trim.length() > 0) {
                    sb.append("<");
                    sb.append(trim);
                    sb.append(">");
                }
            }
        }
        return sb.toString();
    }
}
