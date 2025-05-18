package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final class zzaq {
    public static zzc a(zzp zzpVar) {
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzpVar.f16553c;
        String str = map.get("Date");
        long c2 = str != null ? c(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i2 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            int i3 = 0;
            j2 = 0;
            j3 = 0;
            while (i2 < split.length) {
                String trim = split[i2].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i3 = 1;
                }
                i2++;
            }
            i2 = i3;
            z = true;
        } else {
            z = false;
            j2 = 0;
            j3 = 0;
        }
        String str3 = map.get("Expires");
        long c3 = str3 != null ? c(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long c4 = str4 != null ? c(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j5 = currentTimeMillis + (j2 * 1000);
            if (i2 != 0) {
                j6 = j5;
            } else {
                Long.signum(j3);
                j6 = (j3 * 1000) + j5;
            }
            j4 = j6;
        } else {
            j4 = 0;
            if (c2 <= 0 || c3 < c2) {
                j5 = 0;
            } else {
                j5 = currentTimeMillis + (c3 - c2);
                j4 = j5;
            }
        }
        zzc zzcVar = new zzc();
        zzcVar.a = zzpVar.f16552b;
        zzcVar.f14946b = str5;
        zzcVar.f14950f = j5;
        zzcVar.f14949e = j4;
        zzcVar.f14947c = c2;
        zzcVar.f14948d = c4;
        zzcVar.f14951g = map;
        zzcVar.f14952h = zzpVar.f16554d;
        return zzcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(long j2) {
        return d().format(new Date(j2));
    }

    private static long c(String str) {
        try {
            return d().parse(str).getTime();
        } catch (ParseException e2) {
            zzag.e(e2, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    private static SimpleDateFormat d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
