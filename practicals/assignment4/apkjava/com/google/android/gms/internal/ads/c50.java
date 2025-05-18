package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: classes2.dex */
final class c50 extends PushbackInputStream {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ z40 f12399f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c50(z40 z40Var, InputStream inputStream, int i2) {
        super(inputStream, 1);
        this.f12399f = z40Var;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.f12399f.f13682h.a();
        super.close();
    }
}
