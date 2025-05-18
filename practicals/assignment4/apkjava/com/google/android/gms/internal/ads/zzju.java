package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzju extends IOException {

    /* renamed from: f, reason: collision with root package name */
    private final String f16379f;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzju(String str) {
        super(r0.length() != 0 ? "Unsupported URI scheme: ".concat(r0) : new String("Unsupported URI scheme: "));
        String valueOf = String.valueOf(str);
        this.f16379f = str;
    }
}
