package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: Internal.java */
/* loaded from: classes.dex */
public final class a0 {
    static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    static final Charset f1254b = Charset.forName("ISO-8859-1");

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f1255c;

    /* renamed from: d, reason: collision with root package name */
    public static final ByteBuffer f1256d;

    /* renamed from: e, reason: collision with root package name */
    public static final j f1257e;

    /* compiled from: Internal.java */
    /* loaded from: classes.dex */
    public interface a extends i<Boolean> {
    }

    /* compiled from: Internal.java */
    /* loaded from: classes.dex */
    public interface b extends i<Double> {
    }

    /* compiled from: Internal.java */
    /* loaded from: classes.dex */
    public interface c {
        int f();
    }

    /* compiled from: Internal.java */
    /* loaded from: classes.dex */
    public interface d<T extends c> {
        T a(int i2);
    }

    /* compiled from: Internal.java */
    /* loaded from: classes.dex */
    public interface e {
        boolean a(int i2);
    }

    /* compiled from: Internal.java */
    /* loaded from: classes.dex */
    public interface f extends i<Float> {
    }

    /* compiled from: Internal.java */
    /* loaded from: classes.dex */
    public interface g extends i<Integer> {
    }

    /* compiled from: Internal.java */
    /* loaded from: classes.dex */
    public interface h extends i<Long> {
    }

    /* compiled from: Internal.java */
    /* loaded from: classes.dex */
    public interface i<E> extends List<E>, RandomAccess {
        void B();

        i<E> J(int i2);

        boolean l1();
    }

    static {
        byte[] bArr = new byte[0];
        f1255c = bArr;
        f1256d = ByteBuffer.wrap(bArr);
        f1257e = j.h(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t) {
        t.getClass();
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i2, int i3) {
        int i4 = i(i3, bArr, i2, i3);
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    public static int f(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return q1.m(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object h(Object obj, Object obj2) {
        return ((q0) obj).d().z((q0) obj2).J0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, a);
    }
}
