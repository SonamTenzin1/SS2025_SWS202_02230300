package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes2.dex */
public final class zzjv implements zzkf {
    private final zzke a;

    /* renamed from: b, reason: collision with root package name */
    private RandomAccessFile f16380b;

    /* renamed from: c, reason: collision with root package name */
    private String f16381c;

    /* renamed from: d, reason: collision with root package name */
    private long f16382d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16383e;

    public zzjv() {
        this(null);
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long a(zzjq zzjqVar) throws zzjw {
        try {
            this.f16381c = zzjqVar.a.toString();
            RandomAccessFile randomAccessFile = new RandomAccessFile(zzjqVar.a.getPath(), "r");
            this.f16380b = randomAccessFile;
            randomAccessFile.seek(zzjqVar.f16359c);
            long j2 = zzjqVar.f16360d;
            if (j2 == -1) {
                j2 = this.f16380b.length() - zzjqVar.f16359c;
            }
            this.f16382d = j2;
            if (j2 >= 0) {
                this.f16383e = true;
                zzke zzkeVar = this.a;
                if (zzkeVar != null) {
                    zzkeVar.b();
                }
                return this.f16382d;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new zzjw(e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws zzjw {
        RandomAccessFile randomAccessFile = this.f16380b;
        if (randomAccessFile != null) {
            try {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    throw new zzjw(e2);
                }
            } finally {
                this.f16380b = null;
                this.f16381c = null;
                if (this.f16383e) {
                    this.f16383e = false;
                    zzke zzkeVar = this.a;
                    if (zzkeVar != null) {
                        zzkeVar.c();
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i2, int i3) throws zzjw {
        long j2 = this.f16382d;
        if (j2 == 0) {
            return -1;
        }
        try {
            int read = this.f16380b.read(bArr, i2, (int) Math.min(j2, i3));
            if (read > 0) {
                this.f16382d -= read;
                zzke zzkeVar = this.a;
                if (zzkeVar != null) {
                    zzkeVar.a(read);
                }
            }
            return read;
        } catch (IOException e2) {
            throw new zzjw(e2);
        }
    }

    public zzjv(zzke zzkeVar) {
        this.a = zzkeVar;
    }
}
