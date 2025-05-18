package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public abstract class w7 {
    String a;

    /* renamed from: b, reason: collision with root package name */
    int f18009b;

    /* renamed from: c, reason: collision with root package name */
    Boolean f18010c;

    /* renamed from: d, reason: collision with root package name */
    Boolean f18011d;

    /* renamed from: e, reason: collision with root package name */
    Long f18012e;

    /* renamed from: f, reason: collision with root package name */
    Long f18013f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w7(String str, int i2) {
        this.a = str;
        this.f18009b = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean b(double d2, zzbj.zzd zzdVar) {
        try {
            return h(new BigDecimal(d2), zzdVar, Math.ulp(d2));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean c(long j2, zzbj.zzd zzdVar) {
        try {
            return h(new BigDecimal(j2), zzdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static Boolean d(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean e(String str, zzbj.zzd zzdVar) {
        if (!zzkg.S(str)) {
            return null;
        }
        try {
            return h(new BigDecimal(str), zzdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static Boolean f(String str, zzbj.zzf.zzb zzbVar, boolean z, String str2, List<String> list, String str3, zzet zzetVar) {
        if (str == null) {
            return null;
        }
        if (zzbVar == zzbj.zzf.zzb.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzbVar != zzbj.zzf.zzb.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (s7.a[zzbVar.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzetVar != null) {
                        zzetVar.K().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static Boolean g(String str, zzbj.zzf zzfVar, zzet zzetVar) {
        String E;
        List<String> list;
        Preconditions.k(zzfVar);
        if (str == null || !zzfVar.B() || zzfVar.C() == zzbj.zzf.zzb.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        zzbj.zzf.zzb C = zzfVar.C();
        zzbj.zzf.zzb zzbVar = zzbj.zzf.zzb.IN_LIST;
        if (C == zzbVar) {
            if (zzfVar.I() == 0) {
                return null;
            }
        } else if (!zzfVar.D()) {
            return null;
        }
        zzbj.zzf.zzb C2 = zzfVar.C();
        boolean G = zzfVar.G();
        if (!G && C2 != zzbj.zzf.zzb.REGEXP && C2 != zzbVar) {
            E = zzfVar.E().toUpperCase(Locale.ENGLISH);
        } else {
            E = zzfVar.E();
        }
        String str2 = E;
        if (zzfVar.I() == 0) {
            list = null;
        } else {
            List<String> H = zzfVar.H();
            if (!G) {
                ArrayList arrayList = new ArrayList(H.size());
                Iterator<String> it = H.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                H = Collections.unmodifiableList(arrayList);
            }
            list = H;
        }
        return f(str, C2, G, str2, list, C2 == zzbj.zzf.zzb.REGEXP ? str2 : null, zzetVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0081, code lost:
    
        if (r3 != null) goto L37;
     */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Boolean h(BigDecimal bigDecimal, zzbj.zzd zzdVar, double d2) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.k(zzdVar);
        if (zzdVar.B() && zzdVar.C() != zzbj.zzd.zza.UNKNOWN_COMPARISON_TYPE) {
            zzbj.zzd.zza C = zzdVar.C();
            zzbj.zzd.zza zzaVar = zzbj.zzd.zza.BETWEEN;
            if (C == zzaVar) {
                if (!zzdVar.H() || !zzdVar.J()) {
                    return null;
                }
            } else if (!zzdVar.F()) {
                return null;
            }
            zzbj.zzd.zza C2 = zzdVar.C();
            if (zzdVar.C() == zzaVar) {
                if (zzkg.S(zzdVar.I()) && zzkg.S(zzdVar.K())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzdVar.I());
                        bigDecimal4 = new BigDecimal(zzdVar.K());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!zzkg.S(zzdVar.G())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(zzdVar.G());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (C2 == zzaVar) {
                if (bigDecimal3 == null) {
                    return null;
                }
            }
            int i2 = s7.f17951b[C2.ordinal()];
            if (i2 == 1) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == -1);
            }
            if (i2 == 2) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 1);
            }
            if (i2 == 3) {
                if (d2 == 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                }
                if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d2).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d2).multiply(new BigDecimal(2)))) == -1) {
                    r5 = true;
                }
                return Boolean.valueOf(r5);
            }
            if (i2 == 4) {
                if (bigDecimal.compareTo(bigDecimal3) != -1 && bigDecimal.compareTo(bigDecimal4) != 1) {
                    r5 = true;
                }
                return Boolean.valueOf(r5);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a();
}
