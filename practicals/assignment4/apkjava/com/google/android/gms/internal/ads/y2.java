package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
final class y2 extends FilterInputStream {

    /* renamed from: f, reason: collision with root package name */
    private final long f13603f;

    /* renamed from: g, reason: collision with root package name */
    private long f13604g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y2(InputStream inputStream, long j2) {
        super(inputStream);
        this.f13603f = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a() {
        return this.f13603f - this.f13604g;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.f13604g++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = super.read(bArr, i2, i3);
        if (read != -1) {
            this.f13604g += read;
        }
        return read;
    }
}
