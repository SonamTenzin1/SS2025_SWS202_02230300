package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes2.dex */
abstract class nt implements zzdbj {
    private final mt a;

    /* renamed from: b, reason: collision with root package name */
    private final mt f13063b;

    public nt(byte[] bArr) throws InvalidKeyException {
        this.a = b(bArr, 1);
        this.f13063b = b(bArr, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzdbj
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= (Integer.MAX_VALUE - this.a.f()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + this.a.f() + 16);
            if (allocate.remaining() >= bArr.length + this.a.f() + 16) {
                int position = allocate.position();
                this.a.c(allocate, bArr);
                allocate.position(position);
                byte[] bArr3 = new byte[this.a.f()];
                allocate.get(bArr3);
                allocate.limit(allocate.limit() - 16);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = new byte[32];
                this.f13063b.h(bArr3, 0).get(bArr4);
                int length = bArr2.length % 16 == 0 ? bArr2.length : (bArr2.length + 16) - (bArr2.length % 16);
                int remaining = allocate.remaining();
                int i2 = remaining % 16;
                int i3 = (i2 == 0 ? remaining : (remaining + 16) - i2) + length;
                ByteBuffer order = ByteBuffer.allocate(i3 + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(length);
                order.put(allocate);
                order.position(i3);
                order.putLong(bArr2.length);
                order.putLong(remaining);
                byte[] c2 = pt.c(bArr4, order.array());
                allocate.limit(allocate.limit() + 16);
                allocate.put(c2);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    abstract mt b(byte[] bArr, int i2) throws InvalidKeyException;
}
