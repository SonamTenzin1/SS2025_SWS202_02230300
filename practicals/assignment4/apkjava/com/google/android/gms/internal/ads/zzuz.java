package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@zzard
/* loaded from: classes2.dex */
public final class zzuz {
    private final float a;

    /* renamed from: b, reason: collision with root package name */
    private final float f16827b;

    /* renamed from: c, reason: collision with root package name */
    private final float f16828c;

    /* renamed from: d, reason: collision with root package name */
    private final float f16829d;

    /* renamed from: e, reason: collision with root package name */
    private final int f16830e;

    @VisibleForTesting
    public zzuz(float f2, float f3, float f4, float f5, int i2) {
        this.a = f2;
        this.f16827b = f3;
        this.f16828c = f2 + f4;
        this.f16829d = f3 + f5;
        this.f16830e = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float b() {
        return this.f16827b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float c() {
        return this.f16828c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float d() {
        return this.f16829d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e() {
        return this.f16830e;
    }
}
