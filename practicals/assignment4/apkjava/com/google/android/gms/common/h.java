package com.google.android.gms.common;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
final class h extends g {

    /* renamed from: g, reason: collision with root package name */
    private final byte[] f11924g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f11924g = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.g
    public final byte[] E0() {
        return this.f11924g;
    }
}
