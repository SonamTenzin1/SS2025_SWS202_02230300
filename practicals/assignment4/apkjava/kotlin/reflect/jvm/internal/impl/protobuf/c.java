package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BoundedByteString.java */
/* loaded from: classes3.dex */
public class c extends n {

    /* renamed from: i, reason: collision with root package name */
    private final int f25394i;

    /* renamed from: j, reason: collision with root package name */
    private final int f25395j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BoundedByteString.java */
    /* loaded from: classes3.dex */
    public class b implements d.a {

        /* renamed from: f, reason: collision with root package name */
        private int f25396f;

        /* renamed from: g, reason: collision with root package name */
        private final int f25397g;

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(f());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte f() {
            int i2 = this.f25396f;
            if (i2 < this.f25397g) {
                byte[] bArr = c.this.f25448g;
                this.f25396f = i2 + 1;
                return bArr[i2];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25396f < this.f25397g;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b() {
            int M = c.this.M();
            this.f25396f = M;
            this.f25397g = M + c.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(byte[] bArr, int i2, int i3) {
        super(bArr);
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Offset too small: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i3 < 0) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Length too small: ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i2 + i3 <= bArr.length) {
            this.f25394i = i2;
            this.f25395j = i3;
            return;
        }
        StringBuilder sb3 = new StringBuilder(48);
        sb3.append("Offset+Length too large: ");
        sb3.append(i2);
        sb3.append("+");
        sb3.append(i3);
        throw new IllegalArgumentException(sb3.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
    public byte G(int i2) {
        if (i2 >= 0) {
            if (i2 < size()) {
                return this.f25448g[this.f25394i + i2];
            }
            int size = size();
            StringBuilder sb = new StringBuilder(41);
            sb.append("Index too large: ");
            sb.append(i2);
            sb.append(", ");
            sb.append(size);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(28);
        sb2.append("Index too small: ");
        sb2.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
    public int M() {
        return this.f25394i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n, kotlin.reflect.jvm.internal.impl.protobuf.d
    public void q(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f25448g, M() + i2, bArr, i3, i4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n, kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f25395j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n, kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* renamed from: u */
    public d.a iterator() {
        return new b();
    }
}
