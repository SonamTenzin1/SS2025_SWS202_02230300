package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class i {
    public final boolean a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f10816b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f10817c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10818d;

    /* loaded from: classes2.dex */
    static class a implements v1<i> {

        /* renamed from: com.flurry.sdk.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        final class C0161a extends DataOutputStream {
            C0161a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* loaded from: classes2.dex */
        final class b extends DataInputStream {
            b(InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
            }
        }

        @Override // com.flurry.sdk.v1
        public final /* synthetic */ void a(OutputStream outputStream, i iVar) throws IOException {
            i iVar2 = iVar;
            if (outputStream == null || iVar2 == null) {
                return;
            }
            C0161a c0161a = new C0161a(outputStream);
            c0161a.writeBoolean(iVar2.a);
            byte[] bArr = iVar2.f10816b;
            if (bArr == null) {
                c0161a.writeInt(0);
            } else {
                c0161a.writeInt(bArr.length);
                c0161a.write(iVar2.f10816b);
            }
            byte[] bArr2 = iVar2.f10817c;
            if (bArr2 == null) {
                c0161a.writeInt(0);
            } else {
                c0161a.writeInt(bArr2.length);
                c0161a.write(iVar2.f10817c);
            }
            c0161a.writeInt(iVar2.f10818d);
            c0161a.flush();
        }

        @Override // com.flurry.sdk.v1
        public final /* synthetic */ i b(InputStream inputStream) throws IOException {
            byte[] bArr;
            byte[] bArr2 = null;
            if (inputStream == null) {
                return null;
            }
            b bVar = new b(inputStream);
            boolean readBoolean = bVar.readBoolean();
            int readInt = bVar.readInt();
            if (readInt > 0) {
                bArr = new byte[readInt];
                bVar.read(bArr, 0, readInt);
            } else {
                bArr = null;
            }
            int readInt2 = bVar.readInt();
            if (readInt2 > 0) {
                bArr2 = new byte[readInt2];
                bVar.read(bArr2, 0, readInt2);
            }
            return new i(bArr2, bArr, readBoolean, bVar.readInt());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(byte[] bArr, byte[] bArr2, boolean z, int i2) {
        this.f10816b = bArr2;
        this.f10817c = bArr;
        this.a = z;
        this.f10818d = i2;
    }
}
