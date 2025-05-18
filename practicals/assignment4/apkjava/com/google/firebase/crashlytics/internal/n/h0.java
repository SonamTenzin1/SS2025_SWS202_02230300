package com.google.firebase.crashlytics.internal.n;

import com.google.firebase.crashlytics.internal.p.f0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: FileBackedNativeSessionFile.java */
/* loaded from: classes2.dex */
class h0 implements l0 {
    private final File a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19044b;

    /* renamed from: c, reason: collision with root package name */
    private final String f19045c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(String str, String str2, File file) {
        this.f19044b = str;
        this.f19045c = str2;
        this.a = file;
    }

    private byte[] d() {
        byte[] bArr = new byte[8192];
        try {
            InputStream b2 = b();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (b2 == null) {
                        byteArrayOutputStream.close();
                        if (b2 != null) {
                            b2.close();
                        }
                        return null;
                    }
                    while (true) {
                        try {
                            int read = b2.read(bArr);
                            if (read > 0) {
                                gZIPOutputStream.write(bArr, 0, read);
                            } else {
                                gZIPOutputStream.finish();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                gZIPOutputStream.close();
                                byteArrayOutputStream.close();
                                b2.close();
                                return byteArray;
                            }
                        } finally {
                            try {
                                gZIPOutputStream.close();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (b2 != null) {
                    try {
                        b2.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th2;
            }
        } catch (IOException unused4) {
            return null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.n.l0
    public String a() {
        return this.f19045c;
    }

    @Override // com.google.firebase.crashlytics.internal.n.l0
    public InputStream b() {
        if (this.a.exists() && this.a.isFile()) {
            try {
                return new FileInputStream(this.a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.n.l0
    public f0.d.b c() {
        byte[] d2 = d();
        if (d2 != null) {
            return f0.d.b.a().b(d2).c(this.f19044b).a();
        }
        return null;
    }
}
