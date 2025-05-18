package androidx.datastore.preferences.protobuf;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.HttpUrl;

/* compiled from: CodedInputStream.java */
/* loaded from: classes.dex */
public abstract class j {
    int a;

    /* renamed from: b, reason: collision with root package name */
    int f1334b;

    /* renamed from: c, reason: collision with root package name */
    int f1335c;

    /* renamed from: d, reason: collision with root package name */
    k f1336d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1337e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CodedInputStream.java */
    /* loaded from: classes.dex */
    public static final class b extends j {

        /* renamed from: f, reason: collision with root package name */
        private final byte[] f1338f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f1339g;

        /* renamed from: h, reason: collision with root package name */
        private int f1340h;

        /* renamed from: i, reason: collision with root package name */
        private int f1341i;

        /* renamed from: j, reason: collision with root package name */
        private int f1342j;

        /* renamed from: k, reason: collision with root package name */
        private int f1343k;
        private int l;
        private boolean m;
        private int n;

        private void M() {
            int i2 = this.f1340h + this.f1341i;
            this.f1340h = i2;
            int i3 = i2 - this.f1343k;
            int i4 = this.n;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.f1341i = i5;
                this.f1340h = i2 - i5;
                return;
            }
            this.f1341i = 0;
        }

        private void P() throws IOException {
            if (this.f1340h - this.f1342j >= 10) {
                Q();
            } else {
                R();
            }
        }

        private void Q() throws IOException {
            for (int i2 = 0; i2 < 10; i2++) {
                byte[] bArr = this.f1338f;
                int i3 = this.f1342j;
                this.f1342j = i3 + 1;
                if (bArr[i3] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void R() throws IOException {
            for (int i2 = 0; i2 < 10; i2++) {
                if (F() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public String A() throws IOException {
            int J = J();
            if (J > 0) {
                int i2 = this.f1340h;
                int i3 = this.f1342j;
                if (J <= i2 - i3) {
                    String e2 = q1.e(this.f1338f, i3, J);
                    this.f1342j += J;
                    return e2;
                }
            }
            if (J == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            if (J <= 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.k();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int B() throws IOException {
            if (e()) {
                this.l = 0;
                return 0;
            }
            int J = J();
            this.l = J;
            if (r1.a(J) != 0) {
                return this.l;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int C() throws IOException {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long D() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean E(int i2) throws IOException {
            int b2 = r1.b(i2);
            if (b2 == 0) {
                P();
                return true;
            }
            if (b2 == 1) {
                O(8);
                return true;
            }
            if (b2 == 2) {
                O(J());
                return true;
            }
            if (b2 == 3) {
                N();
                a(r1.c(r1.a(i2), 4));
                return true;
            }
            if (b2 == 4) {
                return false;
            }
            if (b2 == 5) {
                O(4);
                return true;
            }
            throw InvalidProtocolBufferException.d();
        }

        public byte F() throws IOException {
            int i2 = this.f1342j;
            if (i2 != this.f1340h) {
                byte[] bArr = this.f1338f;
                this.f1342j = i2 + 1;
                return bArr[i2];
            }
            throw InvalidProtocolBufferException.k();
        }

        public byte[] G(int i2) throws IOException {
            if (i2 > 0) {
                int i3 = this.f1340h;
                int i4 = this.f1342j;
                if (i2 <= i3 - i4) {
                    int i5 = i2 + i4;
                    this.f1342j = i5;
                    return Arrays.copyOfRange(this.f1338f, i4, i5);
                }
            }
            if (i2 > 0) {
                throw InvalidProtocolBufferException.k();
            }
            if (i2 == 0) {
                return a0.f1255c;
            }
            throw InvalidProtocolBufferException.f();
        }

        public int H() throws IOException {
            int i2 = this.f1342j;
            if (this.f1340h - i2 >= 4) {
                byte[] bArr = this.f1338f;
                this.f1342j = i2 + 4;
                return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.k();
        }

        public long I() throws IOException {
            int i2 = this.f1342j;
            if (this.f1340h - i2 >= 8) {
                byte[] bArr = this.f1338f;
                this.f1342j = i2 + 8;
                return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
            }
            throw InvalidProtocolBufferException.k();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        
            if (r2[r3] < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int J() throws IOException {
            int i2;
            int i3 = this.f1342j;
            int i4 = this.f1340h;
            if (i4 != i3) {
                byte[] bArr = this.f1338f;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.f1342j = i5;
                    return b2;
                }
                if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b2 ^ (bArr[i5] << 7);
                    if (i7 < 0) {
                        i2 = i7 ^ (-128);
                    } else {
                        int i8 = i6 + 1;
                        int i9 = i7 ^ (bArr[i6] << 14);
                        if (i9 >= 0) {
                            i2 = i9 ^ 16256;
                        } else {
                            i6 = i8 + 1;
                            int i10 = i9 ^ (bArr[i8] << 21);
                            if (i10 < 0) {
                                i2 = i10 ^ (-2080896);
                            } else {
                                i8 = i6 + 1;
                                byte b3 = bArr[i6];
                                i2 = (i10 ^ (b3 << 28)) ^ 266354560;
                                if (b3 < 0) {
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
                                }
                            }
                        }
                        i6 = i8;
                    }
                    this.f1342j = i6;
                    return i2;
                }
            }
            return (int) L();
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b4, code lost:
        
            if (r2[r0] < 0) goto L41;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long K() throws IOException {
            long j2;
            long j3;
            long j4;
            long j5;
            int i2;
            int i3 = this.f1342j;
            int i4 = this.f1340h;
            if (i4 != i3) {
                byte[] bArr = this.f1338f;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.f1342j = i5;
                    return b2;
                }
                if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b2 ^ (bArr[i5] << 7);
                    if (i7 >= 0) {
                        int i8 = i6 + 1;
                        int i9 = i7 ^ (bArr[i6] << 14);
                        if (i9 >= 0) {
                            i6 = i8;
                            j5 = i9 ^ 16256;
                        } else {
                            i6 = i8 + 1;
                            int i10 = i9 ^ (bArr[i8] << 21);
                            if (i10 < 0) {
                                i2 = i10 ^ (-2080896);
                            } else {
                                long j6 = i10;
                                int i11 = i6 + 1;
                                long j7 = j6 ^ (bArr[i6] << 28);
                                if (j7 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    i6 = i11 + 1;
                                    long j8 = j7 ^ (bArr[i11] << 35);
                                    if (j8 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i11 = i6 + 1;
                                        j7 = j8 ^ (bArr[i6] << 42);
                                        if (j7 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i6 = i11 + 1;
                                            j8 = j7 ^ (bArr[i11] << 49);
                                            if (j8 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                int i12 = i6 + 1;
                                                j2 = (j8 ^ (bArr[i6] << 56)) ^ 71499008037633920L;
                                                i6 = j2 < 0 ? i12 + 1 : i12;
                                                j5 = j2;
                                            }
                                        }
                                    }
                                    j2 = j8 ^ j3;
                                    j5 = j2;
                                }
                                j5 = j4 ^ j7;
                                i6 = i11;
                            }
                        }
                        this.f1342j = i6;
                        return j5;
                    }
                    i2 = i7 ^ (-128);
                    j5 = i2;
                    this.f1342j = i6;
                    return j5;
                }
            }
            return L();
        }

        long L() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                j2 |= (r3 & Byte.MAX_VALUE) << i2;
                if ((F() & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public void N() throws IOException {
            int B;
            do {
                B = B();
                if (B == 0) {
                    return;
                }
            } while (E(B));
        }

        public void O(int i2) throws IOException {
            if (i2 >= 0) {
                int i3 = this.f1340h;
                int i4 = this.f1342j;
                if (i2 <= i3 - i4) {
                    this.f1342j = i4 + i2;
                    return;
                }
            }
            if (i2 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.k();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public void a(int i2) throws InvalidProtocolBufferException {
            if (this.l != i2) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int d() {
            return this.f1342j - this.f1343k;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean e() throws IOException {
            return this.f1342j == this.f1340h;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public void k(int i2) {
            this.n = i2;
            M();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int l(int i2) throws InvalidProtocolBufferException {
            if (i2 >= 0) {
                int d2 = i2 + d();
                int i3 = this.n;
                if (d2 <= i3) {
                    this.n = d2;
                    M();
                    return i3;
                }
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean m() throws IOException {
            return K() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public h n() throws IOException {
            h n;
            int J = J();
            if (J > 0) {
                int i2 = this.f1340h;
                int i3 = this.f1342j;
                if (J <= i2 - i3) {
                    if (this.f1339g && this.m) {
                        n = h.G(this.f1338f, i3, J);
                    } else {
                        n = h.n(this.f1338f, i3, J);
                    }
                    this.f1342j += J;
                    return n;
                }
            }
            if (J == 0) {
                return h.f1298f;
            }
            return h.F(G(J));
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public double o() throws IOException {
            return Double.longBitsToDouble(I());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int p() throws IOException {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int q() throws IOException {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long r() throws IOException {
            return I();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public float s() throws IOException {
            return Float.intBitsToFloat(H());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int t() throws IOException {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long u() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int v() throws IOException {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long w() throws IOException {
            return I();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int x() throws IOException {
            return j.b(J());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long y() throws IOException {
            return j.c(K());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public String z() throws IOException {
            int J = J();
            if (J > 0 && J <= this.f1340h - this.f1342j) {
                String str = new String(this.f1338f, this.f1342j, J, a0.a);
                this.f1342j += J;
                return str;
            }
            if (J == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            if (J < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.k();
        }

        private b(byte[] bArr, int i2, int i3, boolean z) {
            super();
            this.n = Integer.MAX_VALUE;
            this.f1338f = bArr;
            this.f1340h = i3 + i2;
            this.f1342j = i2;
            this.f1343k = i2;
            this.f1339g = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CodedInputStream.java */
    /* loaded from: classes.dex */
    public static final class c extends j {

        /* renamed from: f, reason: collision with root package name */
        private final InputStream f1344f;

        /* renamed from: g, reason: collision with root package name */
        private final byte[] f1345g;

        /* renamed from: h, reason: collision with root package name */
        private int f1346h;

        /* renamed from: i, reason: collision with root package name */
        private int f1347i;

        /* renamed from: j, reason: collision with root package name */
        private int f1348j;

        /* renamed from: k, reason: collision with root package name */
        private int f1349k;
        private int l;
        private int m;
        private a n;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: CodedInputStream.java */
        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        private h F(int i2) throws IOException {
            byte[] I = I(i2);
            if (I != null) {
                return h.i(I);
            }
            int i3 = this.f1348j;
            int i4 = this.f1346h;
            int i5 = i4 - i3;
            this.l += i4;
            this.f1348j = 0;
            this.f1346h = 0;
            List<byte[]> J = J(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f1345g, i3, bArr, 0, i5);
            for (byte[] bArr2 : J) {
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return h.F(bArr);
        }

        private byte[] H(int i2, boolean z) throws IOException {
            byte[] I = I(i2);
            if (I != null) {
                return z ? (byte[]) I.clone() : I;
            }
            int i3 = this.f1348j;
            int i4 = this.f1346h;
            int i5 = i4 - i3;
            this.l += i4;
            this.f1348j = 0;
            this.f1346h = 0;
            List<byte[]> J = J(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f1345g, i3, bArr, 0, i5);
            for (byte[] bArr2 : J) {
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return bArr;
        }

        private byte[] I(int i2) throws IOException {
            if (i2 == 0) {
                return a0.f1255c;
            }
            if (i2 >= 0) {
                int i3 = this.l;
                int i4 = this.f1348j;
                int i5 = i3 + i4 + i2;
                if (i5 - this.f1335c <= 0) {
                    int i6 = this.m;
                    if (i5 <= i6) {
                        int i7 = this.f1346h - i4;
                        int i8 = i2 - i7;
                        if (i8 >= 4096 && i8 > this.f1344f.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i2];
                        System.arraycopy(this.f1345g, this.f1348j, bArr, 0, i7);
                        this.l += this.f1346h;
                        this.f1348j = 0;
                        this.f1346h = 0;
                        while (i7 < i2) {
                            int read = this.f1344f.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.l += read;
                                i7 += read;
                            } else {
                                throw InvalidProtocolBufferException.k();
                            }
                        }
                        return bArr;
                    }
                    S((i6 - i3) - i4);
                    throw InvalidProtocolBufferException.k();
                }
                throw InvalidProtocolBufferException.j();
            }
            throw InvalidProtocolBufferException.f();
        }

        private List<byte[]> J(int i2) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                int min = Math.min(i2, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
                byte[] bArr = new byte[min];
                int i3 = 0;
                while (i3 < min) {
                    int read = this.f1344f.read(bArr, i3, min - i3);
                    if (read != -1) {
                        this.l += read;
                        i3 += read;
                    } else {
                        throw InvalidProtocolBufferException.k();
                    }
                }
                i2 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void P() {
            int i2 = this.f1346h + this.f1347i;
            this.f1346h = i2;
            int i3 = this.l + i2;
            int i4 = this.m;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.f1347i = i5;
                this.f1346h = i2 - i5;
                return;
            }
            this.f1347i = 0;
        }

        private void Q(int i2) throws IOException {
            if (X(i2)) {
                return;
            }
            if (i2 > (this.f1335c - this.l) - this.f1348j) {
                throw InvalidProtocolBufferException.j();
            }
            throw InvalidProtocolBufferException.k();
        }

        private void T(int i2) throws IOException {
            if (i2 >= 0) {
                int i3 = this.l;
                int i4 = this.f1348j;
                int i5 = i3 + i4 + i2;
                int i6 = this.m;
                if (i5 <= i6) {
                    int i7 = 0;
                    if (this.n == null) {
                        this.l = i3 + i4;
                        int i8 = this.f1346h - i4;
                        this.f1346h = 0;
                        this.f1348j = 0;
                        i7 = i8;
                        while (i7 < i2) {
                            try {
                                long j2 = i2 - i7;
                                long skip = this.f1344f.skip(j2);
                                if (skip < 0 || skip > j2) {
                                    throw new IllegalStateException(this.f1344f.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                                }
                                if (skip == 0) {
                                    break;
                                } else {
                                    i7 += (int) skip;
                                }
                            } finally {
                                this.l += i7;
                                P();
                            }
                        }
                    }
                    if (i7 >= i2) {
                        return;
                    }
                    int i9 = this.f1346h;
                    int i10 = i9 - this.f1348j;
                    this.f1348j = i9;
                    Q(1);
                    while (true) {
                        int i11 = i2 - i10;
                        int i12 = this.f1346h;
                        if (i11 > i12) {
                            i10 += i12;
                            this.f1348j = i12;
                            Q(1);
                        } else {
                            this.f1348j = i11;
                            return;
                        }
                    }
                } else {
                    S((i6 - i3) - i4);
                    throw InvalidProtocolBufferException.k();
                }
            } else {
                throw InvalidProtocolBufferException.f();
            }
        }

        private void U() throws IOException {
            if (this.f1346h - this.f1348j >= 10) {
                V();
            } else {
                W();
            }
        }

        private void V() throws IOException {
            for (int i2 = 0; i2 < 10; i2++) {
                byte[] bArr = this.f1345g;
                int i3 = this.f1348j;
                this.f1348j = i3 + 1;
                if (bArr[i3] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void W() throws IOException {
            for (int i2 = 0; i2 < 10; i2++) {
                if (G() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private boolean X(int i2) throws IOException {
            int i3 = this.f1348j;
            if (i3 + i2 > this.f1346h) {
                int i4 = this.f1335c;
                int i5 = this.l;
                if (i2 > (i4 - i5) - i3 || i5 + i3 + i2 > this.m) {
                    return false;
                }
                a aVar = this.n;
                if (aVar != null) {
                    aVar.a();
                }
                int i6 = this.f1348j;
                if (i6 > 0) {
                    int i7 = this.f1346h;
                    if (i7 > i6) {
                        byte[] bArr = this.f1345g;
                        System.arraycopy(bArr, i6, bArr, 0, i7 - i6);
                    }
                    this.l += i6;
                    this.f1346h -= i6;
                    this.f1348j = 0;
                }
                InputStream inputStream = this.f1344f;
                byte[] bArr2 = this.f1345g;
                int i8 = this.f1346h;
                int read = inputStream.read(bArr2, i8, Math.min(bArr2.length - i8, (this.f1335c - this.l) - i8));
                if (read == 0 || read < -1 || read > this.f1345g.length) {
                    throw new IllegalStateException(this.f1344f.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                }
                if (read <= 0) {
                    return false;
                }
                this.f1346h += read;
                P();
                if (this.f1346h >= i2) {
                    return true;
                }
                return X(i2);
            }
            throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public String A() throws IOException {
            byte[] H;
            int M = M();
            int i2 = this.f1348j;
            int i3 = this.f1346h;
            if (M <= i3 - i2 && M > 0) {
                H = this.f1345g;
                this.f1348j = i2 + M;
            } else {
                if (M == 0) {
                    return HttpUrl.FRAGMENT_ENCODE_SET;
                }
                if (M <= i3) {
                    Q(M);
                    H = this.f1345g;
                    this.f1348j = M + 0;
                } else {
                    H = H(M, false);
                }
                i2 = 0;
            }
            return q1.e(H, i2, M);
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int B() throws IOException {
            if (e()) {
                this.f1349k = 0;
                return 0;
            }
            int M = M();
            this.f1349k = M;
            if (r1.a(M) != 0) {
                return this.f1349k;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int C() throws IOException {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long D() throws IOException {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean E(int i2) throws IOException {
            int b2 = r1.b(i2);
            if (b2 == 0) {
                U();
                return true;
            }
            if (b2 == 1) {
                S(8);
                return true;
            }
            if (b2 == 2) {
                S(M());
                return true;
            }
            if (b2 == 3) {
                R();
                a(r1.c(r1.a(i2), 4));
                return true;
            }
            if (b2 == 4) {
                return false;
            }
            if (b2 == 5) {
                S(4);
                return true;
            }
            throw InvalidProtocolBufferException.d();
        }

        public byte G() throws IOException {
            if (this.f1348j == this.f1346h) {
                Q(1);
            }
            byte[] bArr = this.f1345g;
            int i2 = this.f1348j;
            this.f1348j = i2 + 1;
            return bArr[i2];
        }

        public int K() throws IOException {
            int i2 = this.f1348j;
            if (this.f1346h - i2 < 4) {
                Q(4);
                i2 = this.f1348j;
            }
            byte[] bArr = this.f1345g;
            this.f1348j = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public long L() throws IOException {
            int i2 = this.f1348j;
            if (this.f1346h - i2 < 8) {
                Q(8);
                i2 = this.f1348j;
            }
            byte[] bArr = this.f1345g;
            this.f1348j = i2 + 8;
            return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        
            if (r2[r3] < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int M() throws IOException {
            int i2;
            int i3 = this.f1348j;
            int i4 = this.f1346h;
            if (i4 != i3) {
                byte[] bArr = this.f1345g;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.f1348j = i5;
                    return b2;
                }
                if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b2 ^ (bArr[i5] << 7);
                    if (i7 < 0) {
                        i2 = i7 ^ (-128);
                    } else {
                        int i8 = i6 + 1;
                        int i9 = i7 ^ (bArr[i6] << 14);
                        if (i9 >= 0) {
                            i2 = i9 ^ 16256;
                        } else {
                            i6 = i8 + 1;
                            int i10 = i9 ^ (bArr[i8] << 21);
                            if (i10 < 0) {
                                i2 = i10 ^ (-2080896);
                            } else {
                                i8 = i6 + 1;
                                byte b3 = bArr[i6];
                                i2 = (i10 ^ (b3 << 28)) ^ 266354560;
                                if (b3 < 0) {
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
                                }
                            }
                        }
                        i6 = i8;
                    }
                    this.f1348j = i6;
                    return i2;
                }
            }
            return (int) O();
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b4, code lost:
        
            if (r2[r0] < 0) goto L41;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long N() throws IOException {
            long j2;
            long j3;
            long j4;
            long j5;
            int i2;
            int i3 = this.f1348j;
            int i4 = this.f1346h;
            if (i4 != i3) {
                byte[] bArr = this.f1345g;
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.f1348j = i5;
                    return b2;
                }
                if (i4 - i5 >= 9) {
                    int i6 = i5 + 1;
                    int i7 = b2 ^ (bArr[i5] << 7);
                    if (i7 >= 0) {
                        int i8 = i6 + 1;
                        int i9 = i7 ^ (bArr[i6] << 14);
                        if (i9 >= 0) {
                            i6 = i8;
                            j5 = i9 ^ 16256;
                        } else {
                            i6 = i8 + 1;
                            int i10 = i9 ^ (bArr[i8] << 21);
                            if (i10 < 0) {
                                i2 = i10 ^ (-2080896);
                            } else {
                                long j6 = i10;
                                int i11 = i6 + 1;
                                long j7 = j6 ^ (bArr[i6] << 28);
                                if (j7 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    i6 = i11 + 1;
                                    long j8 = j7 ^ (bArr[i11] << 35);
                                    if (j8 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i11 = i6 + 1;
                                        j7 = j8 ^ (bArr[i6] << 42);
                                        if (j7 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i6 = i11 + 1;
                                            j8 = j7 ^ (bArr[i11] << 49);
                                            if (j8 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                int i12 = i6 + 1;
                                                j2 = (j8 ^ (bArr[i6] << 56)) ^ 71499008037633920L;
                                                i6 = j2 < 0 ? i12 + 1 : i12;
                                                j5 = j2;
                                            }
                                        }
                                    }
                                    j2 = j8 ^ j3;
                                    j5 = j2;
                                }
                                j5 = j4 ^ j7;
                                i6 = i11;
                            }
                        }
                        this.f1348j = i6;
                        return j5;
                    }
                    i2 = i7 ^ (-128);
                    j5 = i2;
                    this.f1348j = i6;
                    return j5;
                }
            }
            return O();
        }

        long O() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                j2 |= (r3 & Byte.MAX_VALUE) << i2;
                if ((G() & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public void R() throws IOException {
            int B;
            do {
                B = B();
                if (B == 0) {
                    return;
                }
            } while (E(B));
        }

        public void S(int i2) throws IOException {
            int i3 = this.f1346h;
            int i4 = this.f1348j;
            if (i2 <= i3 - i4 && i2 >= 0) {
                this.f1348j = i4 + i2;
            } else {
                T(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public void a(int i2) throws InvalidProtocolBufferException {
            if (this.f1349k != i2) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int d() {
            return this.l + this.f1348j;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean e() throws IOException {
            return this.f1348j == this.f1346h && !X(1);
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public void k(int i2) {
            this.m = i2;
            P();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int l(int i2) throws InvalidProtocolBufferException {
            if (i2 >= 0) {
                int i3 = i2 + this.l + this.f1348j;
                int i4 = this.m;
                if (i3 <= i4) {
                    this.m = i3;
                    P();
                    return i4;
                }
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean m() throws IOException {
            return N() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public h n() throws IOException {
            int M = M();
            int i2 = this.f1346h;
            int i3 = this.f1348j;
            if (M > i2 - i3 || M <= 0) {
                if (M == 0) {
                    return h.f1298f;
                }
                return F(M);
            }
            h n = h.n(this.f1345g, i3, M);
            this.f1348j += M;
            return n;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public double o() throws IOException {
            return Double.longBitsToDouble(L());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int p() throws IOException {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int q() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long r() throws IOException {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public float s() throws IOException {
            return Float.intBitsToFloat(K());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int t() throws IOException {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long u() throws IOException {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int v() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long w() throws IOException {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int x() throws IOException {
            return j.b(M());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long y() throws IOException {
            return j.c(N());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public String z() throws IOException {
            int M = M();
            if (M > 0 && M <= this.f1346h - this.f1348j) {
                String str = new String(this.f1345g, this.f1348j, M, a0.a);
                this.f1348j += M;
                return str;
            }
            if (M == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            if (M <= this.f1346h) {
                Q(M);
                String str2 = new String(this.f1345g, this.f1348j, M, a0.a);
                this.f1348j += M;
                return str2;
            }
            return new String(H(M, false), a0.a);
        }

        private c(InputStream inputStream, int i2) {
            super();
            this.m = Integer.MAX_VALUE;
            this.n = null;
            a0.b(inputStream, "input");
            this.f1344f = inputStream;
            this.f1345g = new byte[i2];
            this.f1346h = 0;
            this.f1348j = 0;
            this.l = 0;
        }
    }

    public static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long c(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static j f(InputStream inputStream) {
        return g(inputStream, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
    }

    public static j g(InputStream inputStream, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        }
        if (inputStream == null) {
            return h(a0.f1255c);
        }
        return new c(inputStream, i2);
    }

    public static j h(byte[] bArr) {
        return i(bArr, 0, bArr.length);
    }

    public static j i(byte[] bArr, int i2, int i3) {
        return j(bArr, i2, i3, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j j(byte[] bArr, int i2, int i3, boolean z) {
        b bVar = new b(bArr, i2, i3, z);
        try {
            bVar.l(i3);
            return bVar;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract String A() throws IOException;

    public abstract int B() throws IOException;

    public abstract int C() throws IOException;

    public abstract long D() throws IOException;

    public abstract boolean E(int i2) throws IOException;

    public abstract void a(int i2) throws InvalidProtocolBufferException;

    public abstract int d();

    public abstract boolean e() throws IOException;

    public abstract void k(int i2);

    public abstract int l(int i2) throws InvalidProtocolBufferException;

    public abstract boolean m() throws IOException;

    public abstract h n() throws IOException;

    public abstract double o() throws IOException;

    public abstract int p() throws IOException;

    public abstract int q() throws IOException;

    public abstract long r() throws IOException;

    public abstract float s() throws IOException;

    public abstract int t() throws IOException;

    public abstract long u() throws IOException;

    public abstract int v() throws IOException;

    public abstract long w() throws IOException;

    public abstract int x() throws IOException;

    public abstract long y() throws IOException;

    public abstract String z() throws IOException;

    private j() {
        this.f1334b = 100;
        this.f1335c = Integer.MAX_VALUE;
        this.f1337e = false;
    }
}
