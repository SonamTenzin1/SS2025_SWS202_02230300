package kotlin.reflect.jvm.internal.impl.protobuf;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import okhttp3.HttpUrl;

/* compiled from: CodedInputStream.java */
/* loaded from: classes3.dex */
public final class e {
    private final byte[] a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f25406b;

    /* renamed from: c, reason: collision with root package name */
    private int f25407c;

    /* renamed from: d, reason: collision with root package name */
    private int f25408d;

    /* renamed from: e, reason: collision with root package name */
    private int f25409e;

    /* renamed from: f, reason: collision with root package name */
    private final InputStream f25410f;

    /* renamed from: g, reason: collision with root package name */
    private int f25411g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f25412h;

    /* renamed from: i, reason: collision with root package name */
    private int f25413i;

    /* renamed from: j, reason: collision with root package name */
    private int f25414j;

    /* renamed from: k, reason: collision with root package name */
    private int f25415k;
    private int l;
    private int m;
    private a n;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CodedInputStream.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    private e(InputStream inputStream) {
        this.f25412h = false;
        this.f25414j = Integer.MAX_VALUE;
        this.l = 64;
        this.m = 67108864;
        this.n = null;
        this.a = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
        this.f25407c = 0;
        this.f25409e = 0;
        this.f25413i = 0;
        this.f25410f = inputStream;
        this.f25406b = false;
    }

    public static int B(int i2, InputStream inputStream) throws IOException {
        if ((i2 & 128) == 0) {
            return i2;
        }
        int i3 = i2 & 127;
        int i4 = 7;
        while (i4 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.k();
            }
            i3 |= (read & 127) << i4;
            if ((read & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        while (i4 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.k();
            }
            if ((read2 & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        throw InvalidProtocolBufferException.f();
    }

    private void N() {
        int i2 = this.f25407c + this.f25408d;
        this.f25407c = i2;
        int i3 = this.f25413i + i2;
        int i4 = this.f25414j;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f25408d = i5;
            this.f25407c = i2 - i5;
            return;
        }
        this.f25408d = 0;
    }

    private void O(int i2) throws IOException {
        if (!T(i2)) {
            throw InvalidProtocolBufferException.k();
        }
    }

    private void S(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.f25413i;
            int i4 = this.f25409e;
            int i5 = i3 + i4 + i2;
            int i6 = this.f25414j;
            if (i5 <= i6) {
                int i7 = this.f25407c;
                int i8 = i7 - i4;
                this.f25409e = i7;
                O(1);
                while (true) {
                    int i9 = i2 - i8;
                    int i10 = this.f25407c;
                    if (i9 > i10) {
                        i8 += i10;
                        this.f25409e = i10;
                        O(1);
                    } else {
                        this.f25409e = i9;
                        return;
                    }
                }
            } else {
                R((i6 - i3) - i4);
                throw InvalidProtocolBufferException.k();
            }
        } else {
            throw InvalidProtocolBufferException.g();
        }
    }

    private boolean T(int i2) throws IOException {
        int i3 = this.f25409e;
        if (i3 + i2 > this.f25407c) {
            if (this.f25413i + i3 + i2 > this.f25414j) {
                return false;
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.a();
            }
            if (this.f25410f != null) {
                int i4 = this.f25409e;
                if (i4 > 0) {
                    int i5 = this.f25407c;
                    if (i5 > i4) {
                        byte[] bArr = this.a;
                        System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                    }
                    this.f25413i += i4;
                    this.f25407c -= i4;
                    this.f25409e = 0;
                }
                InputStream inputStream = this.f25410f;
                byte[] bArr2 = this.a;
                int i6 = this.f25407c;
                int read = inputStream.read(bArr2, i6, bArr2.length - i6);
                if (read == 0 || read < -1 || read > this.a.length) {
                    StringBuilder sb = new StringBuilder(102);
                    sb.append("InputStream#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                }
                if (read > 0) {
                    this.f25407c += read;
                    if ((this.f25413i + i2) - this.m <= 0) {
                        N();
                        if (this.f25407c >= i2) {
                            return true;
                        }
                        return T(i2);
                    }
                    throw InvalidProtocolBufferException.j();
                }
            }
            return false;
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i2);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    public static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long c(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private void d(int i2) throws IOException {
        if (this.f25407c - this.f25409e < i2) {
            O(i2);
        }
    }

    public static e g(InputStream inputStream) {
        return new e(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e h(n nVar) {
        e eVar = new e(nVar);
        try {
            eVar.j(nVar.size());
            return eVar;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private byte[] x(int i2) throws IOException {
        if (i2 <= 0) {
            if (i2 == 0) {
                return i.a;
            }
            throw InvalidProtocolBufferException.g();
        }
        int i3 = this.f25413i;
        int i4 = this.f25409e;
        int i5 = i3 + i4 + i2;
        int i6 = this.f25414j;
        if (i5 > i6) {
            R((i6 - i3) - i4);
            throw InvalidProtocolBufferException.k();
        }
        if (i2 < 4096) {
            byte[] bArr = new byte[i2];
            int i7 = this.f25407c - i4;
            System.arraycopy(this.a, i4, bArr, 0, i7);
            this.f25409e = this.f25407c;
            int i8 = i2 - i7;
            d(i8);
            System.arraycopy(this.a, 0, bArr, i7, i8);
            this.f25409e = i8;
            return bArr;
        }
        int i9 = this.f25407c;
        this.f25413i = i3 + i9;
        this.f25409e = 0;
        this.f25407c = 0;
        int i10 = i9 - i4;
        int i11 = i2 - i10;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i11 > 0) {
            int min = Math.min(i11, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
            byte[] bArr2 = new byte[min];
            int i12 = 0;
            while (i12 < min) {
                InputStream inputStream = this.f25410f;
                int read = inputStream == null ? -1 : inputStream.read(bArr2, i12, min - i12);
                if (read == -1) {
                    throw InvalidProtocolBufferException.k();
                }
                this.f25413i += read;
                i12 += read;
            }
            i11 -= min;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(this.a, i4, bArr3, 0, i10);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, i10, bArr4.length);
            i10 += bArr4.length;
        }
        return bArr3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
    
        if (r2[r3] < 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int A() throws IOException {
        int i2;
        long j2;
        int i3 = this.f25409e;
        int i4 = this.f25407c;
        if (i4 != i3) {
            byte[] bArr = this.a;
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f25409e = i5;
                return b2;
            }
            if (i4 - i5 >= 9) {
                int i6 = i5 + 1;
                int i7 = b2 ^ (bArr[i5] << 7);
                long j3 = i7;
                if (j3 >= 0) {
                    int i8 = i6 + 1;
                    int i9 = i7 ^ (bArr[i6] << 14);
                    long j4 = i9;
                    if (j4 >= 0) {
                        i2 = (int) (16256 ^ j4);
                    } else {
                        i6 = i8 + 1;
                        j3 = i9 ^ (bArr[i8] << 21);
                        if (j3 < 0) {
                            j2 = -2080896;
                        } else {
                            i8 = i6 + 1;
                            i2 = (int) ((r0 ^ (r1 << 28)) ^ 266354560);
                            if (bArr[i6] < 0) {
                                i6 = i8 + 1;
                                if (bArr[i8] < 0) {
                                    i8 = i6 + 1;
                                    if (bArr[i6] < 0) {
                                        i6 = i8 + 1;
                                        if (bArr[i8] < 0) {
                                            i8 = i6 + 1;
                                            if (bArr[i6] < 0) {
                                                i6 = i8 + 1;
                                            }
                                        }
                                    }
                                }
                                this.f25409e = i6;
                                return i2;
                            }
                        }
                    }
                    i6 = i8;
                    this.f25409e = i6;
                    return i2;
                }
                j2 = -128;
                i2 = (int) (j3 ^ j2);
                this.f25409e = i6;
                return i2;
            }
        }
        return (int) D();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
    
        if (r2[r0] < 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long C() throws IOException {
        long j2;
        long j3;
        long j4;
        int i2 = this.f25409e;
        int i3 = this.f25407c;
        if (i3 != i2) {
            byte[] bArr = this.a;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.f25409e = i4;
                return b2;
            }
            if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                long j5 = b2 ^ (bArr[i4] << 7);
                if (j5 >= 0) {
                    int i6 = i5 + 1;
                    long j6 = j5 ^ (bArr[i5] << 14);
                    if (j6 >= 0) {
                        j4 = 16256;
                    } else {
                        i5 = i6 + 1;
                        j5 = j6 ^ (bArr[i6] << 21);
                        if (j5 < 0) {
                            j3 = -2080896;
                        } else {
                            i6 = i5 + 1;
                            j6 = j5 ^ (bArr[i5] << 28);
                            if (j6 >= 0) {
                                j4 = 266354560;
                            } else {
                                i5 = i6 + 1;
                                j5 = j6 ^ (bArr[i6] << 35);
                                if (j5 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i6 = i5 + 1;
                                    j6 = j5 ^ (bArr[i5] << 42);
                                    if (j6 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i5 = i6 + 1;
                                        j5 = j6 ^ (bArr[i6] << 49);
                                        if (j5 >= 0) {
                                            i6 = i5 + 1;
                                            j2 = (j5 ^ (bArr[i5] << 56)) ^ 71499008037633920L;
                                            if (j2 < 0) {
                                                i5 = i6 + 1;
                                            }
                                            i5 = i6;
                                            this.f25409e = i5;
                                            return j2;
                                        }
                                        j3 = -558586000294016L;
                                    }
                                }
                            }
                        }
                    }
                    j2 = j6 ^ j4;
                    i5 = i6;
                    this.f25409e = i5;
                    return j2;
                }
                j3 = -128;
                j2 = j5 ^ j3;
                this.f25409e = i5;
                return j2;
            }
        }
        return D();
    }

    long D() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            j2 |= (r3 & Byte.MAX_VALUE) << i2;
            if ((w() & 128) == 0) {
                return j2;
            }
        }
        throw InvalidProtocolBufferException.f();
    }

    public int E() throws IOException {
        return y();
    }

    public long F() throws IOException {
        return z();
    }

    public int G() throws IOException {
        return b(A());
    }

    public long H() throws IOException {
        return c(C());
    }

    public String I() throws IOException {
        int A = A();
        if (A > this.f25407c - this.f25409e || A <= 0) {
            return A == 0 ? HttpUrl.FRAGMENT_ENCODE_SET : new String(x(A), "UTF-8");
        }
        String str = new String(this.a, this.f25409e, A, "UTF-8");
        this.f25409e += A;
        return str;
    }

    public String J() throws IOException {
        byte[] x;
        int A = A();
        int i2 = this.f25409e;
        if (A <= this.f25407c - i2 && A > 0) {
            x = this.a;
            this.f25409e = i2 + A;
        } else {
            if (A == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            x = x(A);
            i2 = 0;
        }
        if (v.f(x, i2, i2 + A)) {
            return new String(x, i2, A, "UTF-8");
        }
        throw InvalidProtocolBufferException.d();
    }

    public int K() throws IOException {
        if (f()) {
            this.f25411g = 0;
            return 0;
        }
        int A = A();
        this.f25411g = A;
        if (w.a(A) != 0) {
            return this.f25411g;
        }
        throw InvalidProtocolBufferException.c();
    }

    public int L() throws IOException {
        return A();
    }

    public long M() throws IOException {
        return C();
    }

    public boolean P(int i2, CodedOutputStream codedOutputStream) throws IOException {
        int b2 = w.b(i2);
        if (b2 == 0) {
            long t = t();
            codedOutputStream.o0(i2);
            codedOutputStream.z0(t);
            return true;
        }
        if (b2 == 1) {
            long z = z();
            codedOutputStream.o0(i2);
            codedOutputStream.V(z);
            return true;
        }
        if (b2 == 2) {
            d l = l();
            codedOutputStream.o0(i2);
            codedOutputStream.P(l);
            return true;
        }
        if (b2 == 3) {
            codedOutputStream.o0(i2);
            Q(codedOutputStream);
            int c2 = w.c(w.a(i2), 4);
            a(c2);
            codedOutputStream.o0(c2);
            return true;
        }
        if (b2 == 4) {
            return false;
        }
        if (b2 == 5) {
            int y = y();
            codedOutputStream.o0(i2);
            codedOutputStream.U(y);
            return true;
        }
        throw InvalidProtocolBufferException.e();
    }

    public void Q(CodedOutputStream codedOutputStream) throws IOException {
        int K;
        do {
            K = K();
            if (K == 0) {
                return;
            }
        } while (P(K, codedOutputStream));
    }

    public void R(int i2) throws IOException {
        int i3 = this.f25407c;
        int i4 = this.f25409e;
        if (i2 <= i3 - i4 && i2 >= 0) {
            this.f25409e = i4 + i2;
        } else {
            S(i2);
        }
    }

    public void a(int i2) throws InvalidProtocolBufferException {
        if (this.f25411g != i2) {
            throw InvalidProtocolBufferException.b();
        }
    }

    public int e() {
        int i2 = this.f25414j;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - (this.f25413i + this.f25409e);
    }

    public boolean f() throws IOException {
        return this.f25409e == this.f25407c && !T(1);
    }

    public void i(int i2) {
        this.f25414j = i2;
        N();
    }

    public int j(int i2) throws InvalidProtocolBufferException {
        if (i2 >= 0) {
            int i3 = i2 + this.f25413i + this.f25409e;
            int i4 = this.f25414j;
            if (i3 <= i4) {
                this.f25414j = i3;
                N();
                return i4;
            }
            throw InvalidProtocolBufferException.k();
        }
        throw InvalidProtocolBufferException.g();
    }

    public boolean k() throws IOException {
        return C() != 0;
    }

    public d l() throws IOException {
        int A = A();
        int i2 = this.f25407c;
        int i3 = this.f25409e;
        if (A > i2 - i3 || A <= 0) {
            if (A == 0) {
                return d.f25399f;
            }
            return new n(x(A));
        }
        d cVar = (this.f25406b && this.f25412h) ? new c(this.a, this.f25409e, A) : d.i(this.a, i3, A);
        this.f25409e += A;
        return cVar;
    }

    public double m() throws IOException {
        return Double.longBitsToDouble(z());
    }

    public int n() throws IOException {
        return A();
    }

    public int o() throws IOException {
        return y();
    }

    public long p() throws IOException {
        return z();
    }

    public float q() throws IOException {
        return Float.intBitsToFloat(y());
    }

    public void r(int i2, o.a aVar, f fVar) throws IOException {
        int i3 = this.f25415k;
        if (i3 < this.l) {
            this.f25415k = i3 + 1;
            aVar.i(this, fVar);
            a(w.c(i2, 4));
            this.f25415k--;
            return;
        }
        throw InvalidProtocolBufferException.h();
    }

    public int s() throws IOException {
        return A();
    }

    public long t() throws IOException {
        return C();
    }

    public <T extends o> T u(q<T> qVar, f fVar) throws IOException {
        int A = A();
        if (this.f25415k < this.l) {
            int j2 = j(A);
            this.f25415k++;
            T b2 = qVar.b(this, fVar);
            a(0);
            this.f25415k--;
            i(j2);
            return b2;
        }
        throw InvalidProtocolBufferException.h();
    }

    public void v(o.a aVar, f fVar) throws IOException {
        int A = A();
        if (this.f25415k < this.l) {
            int j2 = j(A);
            this.f25415k++;
            aVar.i(this, fVar);
            a(0);
            this.f25415k--;
            i(j2);
            return;
        }
        throw InvalidProtocolBufferException.h();
    }

    public byte w() throws IOException {
        if (this.f25409e == this.f25407c) {
            O(1);
        }
        byte[] bArr = this.a;
        int i2 = this.f25409e;
        this.f25409e = i2 + 1;
        return bArr[i2];
    }

    public int y() throws IOException {
        int i2 = this.f25409e;
        if (this.f25407c - i2 < 4) {
            O(4);
            i2 = this.f25409e;
        }
        byte[] bArr = this.a;
        this.f25409e = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public long z() throws IOException {
        int i2 = this.f25409e;
        if (this.f25407c - i2 < 8) {
            O(8);
            i2 = this.f25409e;
        }
        byte[] bArr = this.a;
        this.f25409e = i2 + 8;
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    private e(n nVar) {
        this.f25412h = false;
        this.f25414j = Integer.MAX_VALUE;
        this.l = 64;
        this.m = 67108864;
        this.n = null;
        this.a = nVar.f25448g;
        int M = nVar.M();
        this.f25409e = M;
        this.f25407c = M + nVar.size();
        this.f25413i = -this.f25409e;
        this.f25410f = null;
        this.f25406b = true;
    }
}
