package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import okhttp3.HttpUrl;

/* compiled from: ByteString.java */
/* loaded from: classes.dex */
public abstract class h implements Iterable<Byte>, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final h f1298f = new j(a0.f1255c);

    /* renamed from: g, reason: collision with root package name */
    private static final f f1299g;

    /* renamed from: h, reason: collision with root package name */
    private static final Comparator<h> f1300h;

    /* renamed from: i, reason: collision with root package name */
    private int f1301i = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteString.java */
    /* loaded from: classes.dex */
    public class a extends c {

        /* renamed from: f, reason: collision with root package name */
        private int f1302f = 0;

        /* renamed from: g, reason: collision with root package name */
        private final int f1303g;

        a() {
            this.f1303g = h.this.size();
        }

        @Override // androidx.datastore.preferences.protobuf.h.g
        public byte f() {
            int i2 = this.f1302f;
            if (i2 < this.f1303g) {
                this.f1302f = i2 + 1;
                return h.this.r(i2);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1302f < this.f1303g;
        }
    }

    /* compiled from: ByteString.java */
    /* loaded from: classes.dex */
    static class b implements Comparator<h> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            g it = hVar.iterator();
            g it2 = hVar2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int a = androidx.datastore.preferences.protobuf.i.a(h.A(it.f()), h.A(it2.f()));
                if (a != 0) {
                    return a;
                }
            }
            return androidx.datastore.preferences.protobuf.i.a(hVar.size(), hVar2.size());
        }
    }

    /* compiled from: ByteString.java */
    /* loaded from: classes.dex */
    static abstract class c implements g {
        c() {
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(f());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: ByteString.java */
    /* loaded from: classes.dex */
    private static final class d implements f {
        private d() {
        }

        @Override // androidx.datastore.preferences.protobuf.h.f
        public byte[] a(byte[] bArr, int i2, int i3) {
            return Arrays.copyOfRange(bArr, i2, i3 + i2);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteString.java */
    /* loaded from: classes.dex */
    public static final class e extends j {

        /* renamed from: k, reason: collision with root package name */
        private final int f1305k;
        private final int l;

        e(byte[] bArr, int i2, int i3) {
            super(bArr);
            h.h(i2, i2 + i3, bArr.length);
            this.f1305k = i2;
            this.l = i3;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // androidx.datastore.preferences.protobuf.h.j
        protected int O() {
            return this.f1305k;
        }

        @Override // androidx.datastore.preferences.protobuf.h.j, androidx.datastore.preferences.protobuf.h
        public byte f(int i2) {
            h.g(i2, size());
            return this.f1307j[this.f1305k + i2];
        }

        @Override // androidx.datastore.preferences.protobuf.h.j, androidx.datastore.preferences.protobuf.h
        protected void q(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.f1307j, O() + i2, bArr, i3, i4);
        }

        @Override // androidx.datastore.preferences.protobuf.h.j, androidx.datastore.preferences.protobuf.h
        byte r(int i2) {
            return this.f1307j[this.f1305k + i2];
        }

        @Override // androidx.datastore.preferences.protobuf.h.j, androidx.datastore.preferences.protobuf.h
        public int size() {
            return this.l;
        }

        Object writeReplace() {
            return h.F(z());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteString.java */
    /* loaded from: classes.dex */
    public interface f {
        byte[] a(byte[] bArr, int i2, int i3);
    }

    /* compiled from: ByteString.java */
    /* loaded from: classes.dex */
    public interface g extends Iterator<Byte> {
        byte f();
    }

    /* compiled from: ByteString.java */
    /* renamed from: androidx.datastore.preferences.protobuf.h$h, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0033h {
        private final CodedOutputStream a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f1306b;

        /* synthetic */ C0033h(int i2, a aVar) {
            this(i2);
        }

        public h a() {
            this.a.c();
            return new j(this.f1306b);
        }

        public CodedOutputStream b() {
            return this.a;
        }

        private C0033h(int i2) {
            byte[] bArr = new byte[i2];
            this.f1306b = bArr;
            this.a = CodedOutputStream.g0(bArr);
        }
    }

    /* compiled from: ByteString.java */
    /* loaded from: classes.dex */
    static abstract class i extends h {
        i() {
        }

        @Override // androidx.datastore.preferences.protobuf.h, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteString.java */
    /* loaded from: classes.dex */
    public static class j extends i {

        /* renamed from: j, reason: collision with root package name */
        protected final byte[] f1307j;

        j(byte[] bArr) {
            bArr.getClass();
            this.f1307j = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        protected final String D(Charset charset) {
            return new String(this.f1307j, O(), size(), charset);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        final void L(androidx.datastore.preferences.protobuf.g gVar) throws IOException {
            gVar.a(this.f1307j, O(), size());
        }

        final boolean M(h hVar, int i2, int i3) {
            if (i3 <= hVar.size()) {
                int i4 = i2 + i3;
                if (i4 <= hVar.size()) {
                    if (hVar instanceof j) {
                        j jVar = (j) hVar;
                        byte[] bArr = this.f1307j;
                        byte[] bArr2 = jVar.f1307j;
                        int O = O() + i3;
                        int O2 = O();
                        int O3 = jVar.O() + i2;
                        while (O2 < O) {
                            if (bArr[O2] != bArr2[O3]) {
                                return false;
                            }
                            O2++;
                            O3++;
                        }
                        return true;
                    }
                    return hVar.y(i2, i4).equals(y(0, i3));
                }
                throw new IllegalArgumentException("Ran off end of other: " + i2 + ", " + i3 + ", " + hVar.size());
            }
            throw new IllegalArgumentException("Length too large: " + i3 + size());
        }

        protected int O() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof h) || size() != ((h) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (obj instanceof j) {
                j jVar = (j) obj;
                int x = x();
                int x2 = jVar.x();
                if (x == 0 || x2 == 0 || x == x2) {
                    return M(jVar, 0, size());
                }
                return false;
            }
            return obj.equals(this);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public byte f(int i2) {
            return this.f1307j[i2];
        }

        @Override // androidx.datastore.preferences.protobuf.h
        protected void q(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.f1307j, i2, bArr, i3, i4);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        byte r(int i2) {
            return this.f1307j[i2];
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final boolean s() {
            int O = O();
            return q1.n(this.f1307j, O, size() + O);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int size() {
            return this.f1307j.length;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final androidx.datastore.preferences.protobuf.j v() {
            return androidx.datastore.preferences.protobuf.j.j(this.f1307j, O(), size(), true);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        protected final int w(int i2, int i3, int i4) {
            return a0.i(i2, this.f1307j, O() + i3, i4);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final h y(int i2, int i3) {
            int h2 = h.h(i2, i3, size());
            if (h2 == 0) {
                return h.f1298f;
            }
            return new e(this.f1307j, O() + i2, h2);
        }
    }

    /* compiled from: ByteString.java */
    /* loaded from: classes.dex */
    private static final class k implements f {
        private k() {
        }

        @Override // androidx.datastore.preferences.protobuf.h.f
        public byte[] a(byte[] bArr, int i2, int i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }

        /* synthetic */ k(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f1299g = androidx.datastore.preferences.protobuf.d.c() ? new k(aVar) : new d(aVar);
        f1300h = new b();
    }

    h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int A(byte b2) {
        return b2 & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h F(byte[] bArr) {
        return new j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h G(byte[] bArr, int i2, int i3) {
        return new e(bArr, i2, i3);
    }

    static void g(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i2);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
        }
    }

    static int h(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
        }
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + ", " + i3);
        }
        throw new IndexOutOfBoundsException("End index: " + i3 + " >= " + i4);
    }

    public static h i(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    public static h n(byte[] bArr, int i2, int i3) {
        h(i2, i2 + i3, bArr.length);
        return new j(f1299g.a(bArr, i2, i3));
    }

    public static h o(String str) {
        return new j(str.getBytes(a0.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C0033h u(int i2) {
        return new C0033h(i2, null);
    }

    public final String C(Charset charset) {
        return size() == 0 ? HttpUrl.FRAGMENT_ENCODE_SET : D(charset);
    }

    protected abstract String D(Charset charset);

    public final String E() {
        return C(a0.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void L(androidx.datastore.preferences.protobuf.g gVar) throws IOException;

    public abstract boolean equals(Object obj);

    public abstract byte f(int i2);

    public final int hashCode() {
        int i2 = this.f1301i;
        if (i2 == 0) {
            int size = size();
            i2 = w(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.f1301i = i2;
        }
        return i2;
    }

    protected abstract void q(byte[] bArr, int i2, int i3, int i4);

    abstract byte r(int i2);

    public abstract boolean s();

    public abstract int size();

    @Override // java.lang.Iterable
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public g iterator() {
        return new a();
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract androidx.datastore.preferences.protobuf.j v();

    protected abstract int w(int i2, int i3, int i4);

    protected final int x() {
        return this.f1301i;
    }

    public abstract h y(int i2, int i3);

    public final byte[] z() {
        int size = size();
        if (size == 0) {
            return a0.f1255c;
        }
        byte[] bArr = new byte[size];
        q(bArr, 0, 0, size);
        return bArr;
    }
}
