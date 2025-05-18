package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class x1<T> implements v1<T> {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final int f11135b;

    /* renamed from: c, reason: collision with root package name */
    private final y1<T> f11136c;

    /* loaded from: classes2.dex */
    final class a extends DataOutputStream {
        a(OutputStream outputStream) {
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

    public x1(String str, int i2, y1<T> y1Var) {
        this.a = str;
        this.f11135b = i2;
        this.f11136c = y1Var;
    }

    @Override // com.flurry.sdk.v1
    public final void a(OutputStream outputStream, T t) throws IOException {
        if (outputStream == null || this.f11136c == null) {
            return;
        }
        a aVar = new a(outputStream);
        aVar.writeUTF(this.a);
        aVar.writeInt(this.f11135b);
        this.f11136c.a(this.f11135b).a(aVar, t);
        aVar.flush();
    }

    @Override // com.flurry.sdk.v1
    public final T b(InputStream inputStream) throws IOException {
        if (inputStream == null || this.f11136c == null) {
            return null;
        }
        b bVar = new b(inputStream);
        String readUTF = bVar.readUTF();
        if (this.a.equals(readUTF)) {
            return this.f11136c.a(bVar.readInt()).b(bVar);
        }
        throw new IOException("Signature: " + readUTF + " is invalid");
    }
}
