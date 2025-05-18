package com.google.firebase.crashlytics.internal.o;

import com.google.firebase.crashlytics.internal.n.t;
import com.google.firebase.crashlytics.internal.o.h;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* compiled from: QueueFileLogStore.java */
/* loaded from: classes2.dex */
class i implements d {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private final File f19169b;

    /* renamed from: c, reason: collision with root package name */
    private final int f19170c;

    /* renamed from: d, reason: collision with root package name */
    private h f19171d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QueueFileLogStore.java */
    /* loaded from: classes2.dex */
    public class a implements h.d {
        final /* synthetic */ byte[] a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int[] f19172b;

        a(byte[] bArr, int[] iArr) {
            this.a = bArr;
            this.f19172b = iArr;
        }

        @Override // com.google.firebase.crashlytics.h.o.h.d
        public void a(InputStream inputStream, int i2) throws IOException {
            try {
                inputStream.read(this.a, this.f19172b[0], i2);
                int[] iArr = this.f19172b;
                iArr[0] = iArr[0] + i2;
            } finally {
                inputStream.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QueueFileLogStore.java */
    /* loaded from: classes2.dex */
    public static class b {
        public final byte[] a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19174b;

        b(byte[] bArr, int i2) {
            this.a = bArr;
            this.f19174b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(File file, int i2) {
        this.f19169b = file;
        this.f19170c = i2;
    }

    private void f(long j2, String str) {
        if (this.f19171d == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i2 = this.f19170c / 4;
            if (str.length() > i2) {
                str = "..." + str.substring(str.length() - i2);
            }
            this.f19171d.e(String.format(Locale.US, "%d %s%n", Long.valueOf(j2), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(a));
            while (!this.f19171d.p() && this.f19171d.N() > this.f19170c) {
                this.f19171d.H();
            }
        } catch (IOException e2) {
            com.google.firebase.crashlytics.internal.h.f().e("There was a problem writing to the Crashlytics log.", e2);
        }
    }

    private b g() {
        if (!this.f19169b.exists()) {
            return null;
        }
        h();
        h hVar = this.f19171d;
        if (hVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[hVar.N()];
        try {
            this.f19171d.l(new a(bArr, iArr));
        } catch (IOException e2) {
            com.google.firebase.crashlytics.internal.h.f().e("A problem occurred while reading the Crashlytics log file.", e2);
        }
        return new b(bArr, iArr[0]);
    }

    private void h() {
        if (this.f19171d == null) {
            try {
                this.f19171d = new h(this.f19169b);
            } catch (IOException e2) {
                com.google.firebase.crashlytics.internal.h.f().e("Could not open log file: " + this.f19169b, e2);
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.o.d
    public void a() {
        t.f(this.f19171d, "There was a problem closing the Crashlytics log file.");
        this.f19171d = null;
    }

    @Override // com.google.firebase.crashlytics.internal.o.d
    public String b() {
        byte[] c2 = c();
        if (c2 != null) {
            return new String(c2, a);
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.o.d
    public byte[] c() {
        b g2 = g();
        if (g2 == null) {
            return null;
        }
        int i2 = g2.f19174b;
        byte[] bArr = new byte[i2];
        System.arraycopy(g2.a, 0, bArr, 0, i2);
        return bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.o.d
    public void d() {
        a();
        this.f19169b.delete();
    }

    @Override // com.google.firebase.crashlytics.internal.o.d
    public void e(long j2, String str) {
        h();
        f(j2, str);
    }
}
