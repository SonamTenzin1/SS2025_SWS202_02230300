package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public abstract class zzdu implements Serializable, Iterable<Byte> {

    /* renamed from: f, reason: collision with root package name */
    public static final zzdu f17368f = new u1(zzff.f17408c);

    /* renamed from: g, reason: collision with root package name */
    private static final r1 f17369g;

    /* renamed from: h, reason: collision with root package name */
    private static final Comparator<zzdu> f17370h;

    /* renamed from: i, reason: collision with root package name */
    private int f17371i = 0;

    static {
        o1 o1Var = null;
        f17369g = k1.b() ? new w1(o1Var) : new p1(o1Var);
        f17370h = new n1();
    }

    public static zzdu n(String str) {
        return new u1(str.getBytes(zzff.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdu o(byte[] bArr) {
        return new u1(bArr);
    }

    public static zzdu q(byte[] bArr, int i2, int i3) {
        v(i2, i2 + i3, bArr.length);
        return new u1(f17369g.a(bArr, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int u(byte b2) {
        return b2 & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i2);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i3 < i2) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(i3);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i3);
        sb3.append(" >= ");
        sb3.append(i4);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t1 x(int i2) {
        return new t1(i2, null);
    }

    public abstract byte c(int i2);

    public abstract boolean equals(Object obj);

    public abstract int f();

    protected abstract int h(int i2, int i3, int i4);

    public final int hashCode() {
        int i2 = this.f17371i;
        if (i2 == 0) {
            int f2 = f();
            i2 = h(f2, 0, f2);
            if (i2 == 0) {
                i2 = 1;
            }
            this.f17371i = i2;
        }
        return i2;
    }

    public abstract zzdu i(int i2, int i3);

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new o1(this);
    }

    protected abstract String r(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void s(zzdv zzdvVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte t(int i2);

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(f()));
    }

    public final String w() {
        return f() == 0 ? HttpUrl.FRAGMENT_ENCODE_SET : r(zzff.a);
    }

    public abstract boolean y();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int z() {
        return this.f17371i;
    }
}
