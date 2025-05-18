package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzjy extends zzjx {

    /* renamed from: g, reason: collision with root package name */
    private final int f16385g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, List<String>> f16386h;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzjy(int i2, Map<String, List<String>> map, zzjq zzjqVar) {
        super(r0.toString(), zzjqVar);
        StringBuilder sb = new StringBuilder(26);
        sb.append("Response code: ");
        sb.append(i2);
        this.f16385g = i2;
        this.f16386h = map;
    }
}
