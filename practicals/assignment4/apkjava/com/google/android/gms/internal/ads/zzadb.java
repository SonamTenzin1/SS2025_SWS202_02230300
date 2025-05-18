package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

@zzard
/* loaded from: classes2.dex */
public final class zzadb {
    public static boolean a(zzadi zzadiVar, zzadg zzadgVar, String... strArr) {
        if (zzadiVar == null || zzadgVar == null || !zzadiVar.a) {
            return false;
        }
        return zzadiVar.a(zzadgVar, zzk.zzln().b(), strArr);
    }

    public static zzadg b(zzadi zzadiVar) {
        if (zzadiVar == null) {
            return null;
        }
        return zzadiVar.c(zzk.zzln().b());
    }
}
