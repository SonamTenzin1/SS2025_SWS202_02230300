package com.bumptech.glide.load.o.g;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.internal.http2.Http2;

/* compiled from: StreamGifDecoder.java */
/* loaded from: classes.dex */
public class j implements com.bumptech.glide.load.j<InputStream, c> {
    private final List<ImageHeaderParser> a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.j<ByteBuffer, c> f9441b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9442c;

    public j(List<ImageHeaderParser> list, com.bumptech.glide.load.j<ByteBuffer, c> jVar, com.bumptech.glide.load.engine.z.b bVar) {
        this.a = list;
        this.f9441b = jVar;
        this.f9442c = bVar;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.j
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public u<c> b(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.i iVar) throws IOException {
        byte[] e2 = e(inputStream);
        if (e2 == null) {
            return null;
        }
        return this.f9441b.b(ByteBuffer.wrap(e2), i2, i3, iVar);
    }

    @Override // com.bumptech.glide.load.j
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, com.bumptech.glide.load.i iVar) throws IOException {
        return !((Boolean) iVar.a(i.f9440b)).booleanValue() && com.bumptech.glide.load.e.b(this.a, inputStream, this.f9442c) == ImageHeaderParser.ImageType.GIF;
    }
}
