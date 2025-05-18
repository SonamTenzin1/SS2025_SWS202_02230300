package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
abstract class i extends g {

    /* renamed from: g, reason: collision with root package name */
    private static final WeakReference f11925g = new WeakReference(null);

    /* renamed from: h, reason: collision with root package name */
    private WeakReference f11926h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(byte[] bArr) {
        super(bArr);
        this.f11926h = f11925g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.g
    public final byte[] E0() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f11926h.get();
            if (bArr == null) {
                bArr = E3();
                this.f11926h = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] E3();
}
