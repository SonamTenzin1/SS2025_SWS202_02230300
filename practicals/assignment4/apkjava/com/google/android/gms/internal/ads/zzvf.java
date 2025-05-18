package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

@zzard
/* loaded from: classes2.dex */
public final class zzvf extends zzva {

    /* renamed from: c, reason: collision with root package name */
    private MessageDigest f16845c;

    @Override // com.google.android.gms.internal.ads.zzva
    public final byte[] a(String str) {
        byte[] bArr;
        byte[] bArr2;
        String[] split = str.split(" ");
        int i2 = 4;
        if (split.length == 1) {
            int a = zzve.a(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(a);
            bArr2 = allocate.array();
        } else {
            if (split.length < 5) {
                bArr = new byte[split.length << 1];
                for (int i3 = 0; i3 < split.length; i3++) {
                    int a2 = zzve.a(split[i3]);
                    int i4 = (a2 >> 16) ^ (65535 & a2);
                    byte[] bArr3 = {(byte) i4, (byte) (i4 >> 8)};
                    int i5 = i3 << 1;
                    bArr[i5] = bArr3[0];
                    bArr[i5 + 1] = bArr3[1];
                }
            } else {
                bArr = new byte[split.length];
                for (int i6 = 0; i6 < split.length; i6++) {
                    int a3 = zzve.a(split[i6]);
                    bArr[i6] = (byte) ((a3 >> 24) ^ (((a3 & 255) ^ ((a3 >> 8) & 255)) ^ ((a3 >> 16) & 255)));
                }
            }
            bArr2 = bArr;
        }
        this.f16845c = b();
        synchronized (this.f16841b) {
            MessageDigest messageDigest = this.f16845c;
            if (messageDigest == null) {
                return new byte[0];
            }
            messageDigest.reset();
            this.f16845c.update(bArr2);
            byte[] digest = this.f16845c.digest();
            if (digest.length <= 4) {
                i2 = digest.length;
            }
            byte[] bArr4 = new byte[i2];
            System.arraycopy(digest, 0, bArr4, 0, i2);
            return bArr4;
        }
    }
}
