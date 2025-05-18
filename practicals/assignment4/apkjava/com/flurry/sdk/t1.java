package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public final class t1<ObjectType> extends s1<ObjectType> {
    public t1(v1<ObjectType> v1Var) {
        super(v1Var);
    }

    @Override // com.flurry.sdk.s1, com.flurry.sdk.v1
    public final void a(OutputStream outputStream, ObjectType objecttype) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream2 = null;
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
            } catch (Throwable th) {
                th = th;
            }
            try {
                super.a(gZIPOutputStream, objecttype);
                c2.f(gZIPOutputStream);
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream2 = gZIPOutputStream;
                c2.f(gZIPOutputStream2);
                throw th;
            }
        }
    }

    @Override // com.flurry.sdk.s1, com.flurry.sdk.v1
    public final ObjectType b(InputStream inputStream) throws IOException {
        GZIPInputStream gZIPInputStream = null;
        if (inputStream == null) {
            return null;
        }
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
            try {
                ObjectType objecttype = (ObjectType) super.b(gZIPInputStream2);
                c2.f(gZIPInputStream2);
                return objecttype;
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                c2.f(gZIPInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
