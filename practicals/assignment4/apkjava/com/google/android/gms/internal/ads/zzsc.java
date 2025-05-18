package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzsc extends zzsb {

    /* renamed from: h, reason: collision with root package name */
    private final int f16709h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, List<String>> f16710i;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzsc(int i2, Map<String, List<String>> map, zzry zzryVar) {
        super(r0.toString(), zzryVar, 1);
        StringBuilder sb = new StringBuilder(26);
        sb.append("Response code: ");
        sb.append(i2);
        this.f16709h = i2;
        this.f16710i = map;
    }
}
