package com.google.firebase.crashlytics.internal.o;

import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QueueFile.java */
/* loaded from: classes2.dex */
public class h implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private static final Logger f19156f = Logger.getLogger(h.class.getName());

    /* renamed from: g, reason: collision with root package name */
    private final RandomAccessFile f19157g;

    /* renamed from: h, reason: collision with root package name */
    int f19158h;

    /* renamed from: i, reason: collision with root package name */
    private int f19159i;

    /* renamed from: j, reason: collision with root package name */
    private b f19160j;

    /* renamed from: k, reason: collision with root package name */
    private b f19161k;
    private final byte[] l = new byte[16];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QueueFile.java */
    /* loaded from: classes2.dex */
    public class a implements d {
        boolean a = true;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f19162b;

        a(StringBuilder sb) {
            this.f19162b = sb;
        }

        @Override // com.google.firebase.crashlytics.h.o.h.d
        public void a(InputStream inputStream, int i2) throws IOException {
            if (this.a) {
                this.a = false;
            } else {
                this.f19162b.append(", ");
            }
            this.f19162b.append(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QueueFile.java */
    /* loaded from: classes2.dex */
    public static class b {
        static final b a = new b(0, 0);

        /* renamed from: b, reason: collision with root package name */
        final int f19164b;

        /* renamed from: c, reason: collision with root package name */
        final int f19165c;

        b(int i2, int i3) {
            this.f19164b = i2;
            this.f19165c = i3;
        }

        public String toString() {
            return b.class.getSimpleName() + "[position = " + this.f19164b + ", length = " + this.f19165c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QueueFile.java */
    /* loaded from: classes2.dex */
    public final class c extends InputStream {

        /* renamed from: f, reason: collision with root package name */
        private int f19166f;

        /* renamed from: g, reason: collision with root package name */
        private int f19167g;

        /* synthetic */ c(h hVar, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            h.x(bArr, "buffer");
            if ((i2 | i3) >= 0 && i3 <= bArr.length - i2) {
                int i4 = this.f19167g;
                if (i4 <= 0) {
                    return -1;
                }
                if (i3 > i4) {
                    i3 = i4;
                }
                h.this.I(this.f19166f, bArr, i2, i3);
                this.f19166f = h.this.Q(this.f19166f + i3);
                this.f19167g -= i3;
                return i3;
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        private c(b bVar) {
            this.f19166f = h.this.Q(bVar.f19164b + 4);
            this.f19167g = bVar.f19165c;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f19167g == 0) {
                return -1;
            }
            h.this.f19157g.seek(this.f19166f);
            int read = h.this.f19157g.read();
            this.f19166f = h.this.Q(this.f19166f + 1);
            this.f19167g--;
            return read;
        }
    }

    /* compiled from: QueueFile.java */
    /* loaded from: classes2.dex */
    public interface d {
        void a(InputStream inputStream, int i2) throws IOException;
    }

    public h(File file) throws IOException {
        if (!file.exists()) {
            m(file);
        }
        this.f19157g = y(file);
        A();
    }

    private void A() throws IOException {
        this.f19157g.seek(0L);
        this.f19157g.readFully(this.l);
        int B = B(this.l, 0);
        this.f19158h = B;
        if (B <= this.f19157g.length()) {
            this.f19159i = B(this.l, 4);
            int B2 = B(this.l, 8);
            int B3 = B(this.l, 12);
            this.f19160j = z(B2);
            this.f19161k = z(B3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f19158h + ", Actual length: " + this.f19157g.length());
    }

    private static int B(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i2 + 3] & 255);
    }

    private int D() {
        return this.f19158h - N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i2, byte[] bArr, int i3, int i4) throws IOException {
        int Q = Q(i2);
        int i5 = Q + i4;
        int i6 = this.f19158h;
        if (i5 <= i6) {
            this.f19157g.seek(Q);
            this.f19157g.readFully(bArr, i3, i4);
            return;
        }
        int i7 = i6 - Q;
        this.f19157g.seek(Q);
        this.f19157g.readFully(bArr, i3, i7);
        this.f19157g.seek(16L);
        this.f19157g.readFully(bArr, i3 + i7, i4 - i7);
    }

    private void J(int i2, byte[] bArr, int i3, int i4) throws IOException {
        int Q = Q(i2);
        int i5 = Q + i4;
        int i6 = this.f19158h;
        if (i5 <= i6) {
            this.f19157g.seek(Q);
            this.f19157g.write(bArr, i3, i4);
            return;
        }
        int i7 = i6 - Q;
        this.f19157g.seek(Q);
        this.f19157g.write(bArr, i3, i7);
        this.f19157g.seek(16L);
        this.f19157g.write(bArr, i3 + i7, i4 - i7);
    }

    private void K(int i2) throws IOException {
        this.f19157g.setLength(i2);
        this.f19157g.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Q(int i2) {
        int i3 = this.f19158h;
        return i2 < i3 ? i2 : (i2 + 16) - i3;
    }

    private void T(int i2, int i3, int i4, int i5) throws IOException {
        Y(this.l, i2, i3, i4, i5);
        this.f19157g.seek(0L);
        this.f19157g.write(this.l);
    }

    private static void W(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >> 24);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    private static void Y(byte[] bArr, int... iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            W(bArr, i2, i3);
            i2 += 4;
        }
    }

    private void k(int i2) throws IOException {
        int i3 = i2 + 4;
        int D = D();
        if (D >= i3) {
            return;
        }
        int i4 = this.f19158h;
        do {
            D += i4;
            i4 <<= 1;
        } while (D < i3);
        K(i4);
        b bVar = this.f19161k;
        int Q = Q(bVar.f19164b + 4 + bVar.f19165c);
        if (Q < this.f19160j.f19164b) {
            FileChannel channel = this.f19157g.getChannel();
            channel.position(this.f19158h);
            long j2 = Q - 4;
            if (channel.transferTo(16L, j2, channel) != j2) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i5 = this.f19161k.f19164b;
        int i6 = this.f19160j.f19164b;
        if (i5 < i6) {
            int i7 = (this.f19158h + i5) - 16;
            T(i4, this.f19159i, i6, i7);
            this.f19161k = new b(i7, this.f19161k.f19165c);
        } else {
            T(i4, this.f19159i, i6, i5);
        }
        this.f19158h = i4;
    }

    private static void m(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile y = y(file2);
        try {
            y.setLength(4096L);
            y.seek(0L);
            byte[] bArr = new byte[16];
            Y(bArr, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT, 0, 0, 0);
            y.write(bArr);
            y.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            y.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T x(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile y(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private b z(int i2) throws IOException {
        if (i2 == 0) {
            return b.a;
        }
        this.f19157g.seek(i2);
        return new b(i2, this.f19157g.readInt());
    }

    public synchronized void H() throws IOException {
        if (!p()) {
            if (this.f19159i == 1) {
                j();
            } else {
                b bVar = this.f19160j;
                int Q = Q(bVar.f19164b + 4 + bVar.f19165c);
                I(Q, this.l, 0, 4);
                int B = B(this.l, 0);
                T(this.f19158h, this.f19159i - 1, Q, this.f19161k.f19164b);
                this.f19159i--;
                this.f19160j = new b(Q, B);
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    public int N() {
        if (this.f19159i == 0) {
            return 16;
        }
        b bVar = this.f19161k;
        int i2 = bVar.f19164b;
        int i3 = this.f19160j.f19164b;
        if (i2 >= i3) {
            return (i2 - i3) + 4 + bVar.f19165c + 16;
        }
        return (((i2 + 4) + bVar.f19165c) + this.f19158h) - i3;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f19157g.close();
    }

    public void e(byte[] bArr) throws IOException {
        f(bArr, 0, bArr.length);
    }

    public synchronized void f(byte[] bArr, int i2, int i3) throws IOException {
        int Q;
        x(bArr, "buffer");
        if ((i2 | i3) >= 0 && i3 <= bArr.length - i2) {
            k(i3);
            boolean p = p();
            if (p) {
                Q = 16;
            } else {
                b bVar = this.f19161k;
                Q = Q(bVar.f19164b + 4 + bVar.f19165c);
            }
            b bVar2 = new b(Q, i3);
            W(this.l, 0, i3);
            J(bVar2.f19164b, this.l, 0, 4);
            J(bVar2.f19164b + 4, bArr, i2, i3);
            T(this.f19158h, this.f19159i + 1, p ? bVar2.f19164b : this.f19160j.f19164b, bVar2.f19164b);
            this.f19161k = bVar2;
            this.f19159i++;
            if (p) {
                this.f19160j = bVar2;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public synchronized void j() throws IOException {
        T(RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT, 0, 0, 0);
        this.f19159i = 0;
        b bVar = b.a;
        this.f19160j = bVar;
        this.f19161k = bVar;
        if (this.f19158h > 4096) {
            K(RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
        }
        this.f19158h = RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
    }

    public synchronized void l(d dVar) throws IOException {
        int i2 = this.f19160j.f19164b;
        for (int i3 = 0; i3 < this.f19159i; i3++) {
            b z = z(i2);
            dVar.a(new c(this, z, null), z.f19165c);
            i2 = Q(z.f19164b + 4 + z.f19165c);
        }
    }

    public synchronized boolean p() {
        return this.f19159i == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(h.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f19158h);
        sb.append(", size=");
        sb.append(this.f19159i);
        sb.append(", first=");
        sb.append(this.f19160j);
        sb.append(", last=");
        sb.append(this.f19161k);
        sb.append(", element lengths=[");
        try {
            l(new a(sb));
        } catch (IOException e2) {
            f19156f.log(Level.WARNING, "read error", (Throwable) e2);
        }
        sb.append("]]");
        return sb.toString();
    }
}
