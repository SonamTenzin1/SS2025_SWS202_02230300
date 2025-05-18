package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* loaded from: classes2.dex */
final class v3 extends FilterInputStream {

    /* renamed from: f, reason: collision with root package name */
    private final HttpURLConnection f13436f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public v3(HttpURLConnection httpURLConnection) {
        super(r0);
        InputStream c2;
        c2 = zzat.c(httpURLConnection);
        this.f13436f = httpURLConnection;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        this.f13436f.disconnect();
    }
}
