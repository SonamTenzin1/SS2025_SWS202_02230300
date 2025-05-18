package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzpo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zznr {
    private static final zzpu a = new n10();

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f16524b = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: c, reason: collision with root package name */
    public int f16525c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f16526d = -1;

    private final boolean b(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = f16524b.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.f16525c = parseInt;
                    this.f16526d = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean a(zzpo zzpoVar) {
        for (int i2 = 0; i2 < zzpoVar.a(); i2++) {
            zzpo.zza b2 = zzpoVar.b(i2);
            if (b2 instanceof zzps) {
                zzps zzpsVar = (zzps) b2;
                if (b(zzpsVar.f16594h, zzpsVar.f16595i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean c() {
        return (this.f16525c == -1 || this.f16526d == -1) ? false : true;
    }
}
