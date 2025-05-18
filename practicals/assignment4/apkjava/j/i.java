package j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

/* compiled from: ByteString.kt */
/* loaded from: classes3.dex */
public class i implements Serializable, Comparable<i> {

    /* renamed from: h, reason: collision with root package name */
    private transient int f22843h;

    /* renamed from: i, reason: collision with root package name */
    private transient String f22844i;

    /* renamed from: j, reason: collision with root package name */
    private final byte[] f22845j;

    /* renamed from: g, reason: collision with root package name */
    public static final a f22842g = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final i f22841f = new i(new byte[0]);

    /* compiled from: ByteString.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ i f(a aVar, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = bArr.length;
            }
            return aVar.e(bArr, i2, i3);
        }

        public final i a(String str) {
            kotlin.jvm.internal.m.f(str, "$this$decodeBase64");
            byte[] a = j.a.a(str);
            if (a != null) {
                return new i(a);
            }
            return null;
        }

        public final i b(String str) {
            int e2;
            int e3;
            kotlin.jvm.internal.m.f(str, "$this$decodeHex");
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    e2 = j.g0.b.e(str.charAt(i3));
                    e3 = j.g0.b.e(str.charAt(i3 + 1));
                    bArr[i2] = (byte) ((e2 << 4) + e3);
                }
                return new i(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }

        public final i c(String str, Charset charset) {
            kotlin.jvm.internal.m.f(str, "$this$encode");
            kotlin.jvm.internal.m.f(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            kotlin.jvm.internal.m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return new i(bytes);
        }

        public final i d(String str) {
            kotlin.jvm.internal.m.f(str, "$this$encodeUtf8");
            i iVar = new i(b.a(str));
            iVar.M(str);
            return iVar;
        }

        public final i e(byte[] bArr, int i2, int i3) {
            byte[] h2;
            kotlin.jvm.internal.m.f(bArr, "$this$toByteString");
            c.b(bArr.length, i2, i3);
            h2 = kotlin.collections.m.h(bArr, i2, i3 + i2);
            return new i(h2);
        }

        public final i g(InputStream inputStream, int i2) throws IOException {
            kotlin.jvm.internal.m.f(inputStream, "$this$readByteString");
            int i3 = 0;
            if (i2 >= 0) {
                byte[] bArr = new byte[i2];
                while (i3 < i2) {
                    int read = inputStream.read(bArr, i3, i2 - i3);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    i3 += read;
                }
                return new i(bArr);
            }
            throw new IllegalArgumentException(("byteCount < 0: " + i2).toString());
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public i(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "data");
        this.f22845j = bArr;
    }

    public static final i q(String str) {
        return f22842g.b(str);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        i g2 = f22842g.g(objectInputStream, objectInputStream.readInt());
        Field declaredField = i.class.getDeclaredField("j");
        kotlin.jvm.internal.m.e(declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, g2.f22845j);
    }

    public static final i v(String str) {
        return f22842g.d(str);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f22845j.length);
        objectOutputStream.write(this.f22845j);
    }

    public final int A() {
        return this.f22843h;
    }

    public int D() {
        return y().length;
    }

    public final String E() {
        return this.f22844i;
    }

    public String F() {
        char[] cArr = new char[y().length * 2];
        int i2 = 0;
        for (byte b2 : y()) {
            int i3 = i2 + 1;
            cArr[i2] = j.g0.b.f()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = j.g0.b.f()[b2 & 15];
        }
        return new String(cArr);
    }

    public byte[] G() {
        return y();
    }

    public byte H(int i2) {
        return y()[i2];
    }

    public final i I() {
        return u("MD5");
    }

    public boolean J(int i2, i iVar, int i3, int i4) {
        kotlin.jvm.internal.m.f(iVar, "other");
        return iVar.K(i3, y(), i2, i4);
    }

    public boolean K(int i2, byte[] bArr, int i3, int i4) {
        kotlin.jvm.internal.m.f(bArr, "other");
        return i2 >= 0 && i2 <= y().length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && c.a(y(), i2, bArr, i3, i4);
    }

    public final void L(int i2) {
        this.f22843h = i2;
    }

    public final void M(String str) {
        this.f22844i = str;
    }

    public final i N() {
        return u("SHA-1");
    }

    public final i O() {
        return u("SHA-256");
    }

    public final int P() {
        return D();
    }

    public final boolean Q(i iVar) {
        kotlin.jvm.internal.m.f(iVar, "prefix");
        return J(0, iVar, 0, iVar.P());
    }

    public i R() {
        byte b2;
        for (int i2 = 0; i2 < y().length; i2++) {
            byte b3 = y()[i2];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] y = y();
                byte[] copyOf = Arrays.copyOf(y, y.length);
                kotlin.jvm.internal.m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 + 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 + 32);
                    }
                }
                return new i(copyOf);
            }
        }
        return this;
    }

    public String S() {
        String E = E();
        if (E != null) {
            return E;
        }
        String b2 = b.b(G());
        M(b2);
        return b2;
    }

    public void T(f fVar, int i2, int i3) {
        kotlin.jvm.internal.m.f(fVar, "buffer");
        j.g0.b.d(this, fVar, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (iVar.P() == y().length && iVar.K(0, y(), 0, y().length)) {
                return true;
            }
        }
        return false;
    }

    public String g() {
        return j.a.c(y(), null, 1, null);
    }

    public int hashCode() {
        int A = A();
        if (A != 0) {
            return A;
        }
        int hashCode = Arrays.hashCode(y());
        L(hashCode);
        return hashCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compareTo(i iVar) {
        kotlin.jvm.internal.m.f(iVar, "other");
        int P = P();
        int P2 = iVar.P();
        int min = Math.min(P, P2);
        for (int i2 = 0; i2 < min; i2++) {
            int x = x(i2) & 255;
            int x2 = iVar.x(i2) & 255;
            if (x != x2) {
                return x < x2 ? -1 : 1;
            }
        }
        if (P == P2) {
            return 0;
        }
        if (P < P2) {
        }
    }

    public String toString() {
        int c2;
        String A;
        String A2;
        String A3;
        i iVar;
        byte[] h2;
        if (y().length == 0) {
            return "[size=0]";
        }
        c2 = j.g0.b.c(y(), 64);
        if (c2 == -1) {
            if (y().length <= 64) {
                return "[hex=" + F() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(y().length);
            sb.append(" hex=");
            if (64 <= y().length) {
                if (64 == y().length) {
                    iVar = this;
                } else {
                    h2 = kotlin.collections.m.h(y(), 0, 64);
                    iVar = new i(h2);
                }
                sb.append(iVar.F());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + y().length + ')').toString());
        }
        String S = S();
        if (S != null) {
            String substring = S.substring(0, c2);
            kotlin.jvm.internal.m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            A = kotlin.text.u.A(substring, "\\", "\\\\", false, 4, null);
            A2 = kotlin.text.u.A(A, "\n", "\\n", false, 4, null);
            A3 = kotlin.text.u.A(A2, "\r", "\\r", false, 4, null);
            if (c2 < S.length()) {
                return "[size=" + y().length + " text=" + A3 + "…]";
            }
            return "[text=" + A3 + ']';
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public i u(String str) {
        kotlin.jvm.internal.m.f(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f22845j, 0, P());
        byte[] digest = messageDigest.digest();
        kotlin.jvm.internal.m.e(digest, "digestBytes");
        return new i(digest);
    }

    public final byte x(int i2) {
        return H(i2);
    }

    public final byte[] y() {
        return this.f22845j;
    }
}
