package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LiteralByteString.java */
/* loaded from: classes3.dex */
public class n extends d {

    /* renamed from: g, reason: collision with root package name */
    protected final byte[] f25448g;

    /* renamed from: h, reason: collision with root package name */
    private int f25449h = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LiteralByteString.java */
    /* loaded from: classes3.dex */
    public class b implements d.a {

        /* renamed from: f, reason: collision with root package name */
        private int f25450f;

        /* renamed from: g, reason: collision with root package name */
        private final int f25451g;

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(f());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte f() {
            try {
                byte[] bArr = n.this.f25448g;
                int i2 = this.f25450f;
                this.f25450f = i2 + 1;
                return bArr[i2];
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new NoSuchElementException(e2.getMessage());
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25450f < this.f25451g;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b() {
            this.f25450f = 0;
            this.f25451g = n.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(byte[] bArr) {
        this.f25448g = bArr;
    }

    static int O(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String C(String str) throws UnsupportedEncodingException {
        return new String(this.f25448g, M(), size(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void F(OutputStream outputStream, int i2, int i3) throws IOException {
        outputStream.write(this.f25448g, M() + i2, i3);
    }

    public byte G(int i2) {
        return this.f25448g[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean L(n nVar, int i2, int i3) {
        if (i3 <= nVar.size()) {
            if (i2 + i3 <= nVar.size()) {
                byte[] bArr = this.f25448g;
                byte[] bArr2 = nVar.f25448g;
                int M = M() + i3;
                int M2 = M();
                int M3 = nVar.M() + i2;
                while (M2 < M) {
                    if (bArr[M2] != bArr2[M3]) {
                        return false;
                    }
                    M2++;
                    M3++;
                }
                return true;
            }
            int size = nVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: ");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i3);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d) || size() != ((d) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof n) {
            return L((n) obj, 0, size());
        }
        if (obj instanceof s) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(obj.getClass());
        StringBuilder sb = new StringBuilder(valueOf.length() + 49);
        sb.append("Has a new type of ByteString been created? Found ");
        sb.append(valueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    public int hashCode() {
        int i2 = this.f25449h;
        if (i2 == 0) {
            int size = size();
            i2 = x(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.f25449h = i2;
        }
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void q(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f25448g, i2, bArr, i3, i4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int r() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean s() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f25448g.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean t() {
        int M = M();
        return v.f(this.f25448g, M, size() + M);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public d.a iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public e v() {
        return e.h(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int x(int i2, int i3, int i4) {
        return O(i2, this.f25448g, M() + i3, i4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int y(int i2, int i3, int i4) {
        int M = M() + i3;
        return v.g(i2, this.f25448g, M, i4 + M);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int z() {
        return this.f25449h;
    }
}
