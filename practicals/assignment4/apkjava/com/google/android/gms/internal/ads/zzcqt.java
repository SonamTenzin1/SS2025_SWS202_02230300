package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public class zzcqt {
    private String a;

    /* loaded from: classes2.dex */
    public static class zza {
        private String a;

        public final zza b(String str) {
            this.a = str;
            return this;
        }
    }

    private zzcqt(zza zzaVar) {
        this.a = zzaVar.a;
    }

    public final Set<String> a() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.a.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String b() {
        return this.a.toLowerCase(Locale.ROOT);
    }

    public final int c() {
        String str = this.a;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1999289321:
                if (str.equals("NATIVE")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1372958932:
                if (str.equals("INTERSTITIAL")) {
                    c2 = 1;
                    break;
                }
                break;
            case 543046670:
                if (str.equals("REWARDED")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1951953708:
                if (str.equals("BANNER")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 6;
            case 1:
                return 3;
            case 2:
                return 7;
            case 3:
                return 1;
            default:
                return 0;
        }
    }
}
