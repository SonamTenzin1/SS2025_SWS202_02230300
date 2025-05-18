package com.google.android.gms.internal.ads;

import android.text.TextUtils;

@zzard
/* loaded from: classes2.dex */
public final class zzada {
    public static void a(zzacy zzacyVar, zzacx zzacxVar) {
        if (zzacxVar.a() != null) {
            if (!TextUtils.isEmpty(zzacxVar.b())) {
                zzacyVar.b(zzacxVar.a(), zzacxVar.b(), zzacxVar.c(), zzacxVar.d());
                return;
            }
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
    }
}
