package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

@zzard
/* loaded from: classes2.dex */
final class w9 implements zzdsw {

    /* renamed from: f, reason: collision with root package name */
    private final ByteBuffer f13503f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w9(ByteBuffer byteBuffer) {
        this.f13503f = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.zzdsw, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzdsw
    public final void d1(long j2) throws IOException {
        this.f13503f.position((int) j2);
    }

    @Override // com.google.android.gms.internal.ads.zzdsw
    public final long k0() throws IOException {
        return this.f13503f.position();
    }

    @Override // com.google.android.gms.internal.ads.zzdsw
    public final ByteBuffer r(long j2, long j3) throws IOException {
        int position = this.f13503f.position();
        this.f13503f.position((int) j2);
        ByteBuffer slice = this.f13503f.slice();
        slice.limit((int) j3);
        this.f13503f.position(position);
        return slice;
    }

    @Override // com.google.android.gms.internal.ads.zzdsw
    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f13503f.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.f13503f.remaining());
        byte[] bArr = new byte[min];
        this.f13503f.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzdsw
    public final long size() throws IOException {
        return this.f13503f.limit();
    }
}
