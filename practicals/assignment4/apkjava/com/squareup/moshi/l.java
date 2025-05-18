package com.squareup.moshi;

import cm.aptoide.pt.account.AdultContentAnalytics;
import java.io.IOException;

/* compiled from: JsonUtf8Writer.java */
/* loaded from: classes2.dex */
final class l extends o {
    private static final String[] o = new String[128];
    private final j.g p;
    private String q = ":";
    private String r;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            o[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = o;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j.g gVar) {
        if (gVar != null) {
            this.p = gVar;
            z(6);
            return;
        }
        throw new NullPointerException("sink == null");
    }

    private void T() throws IOException {
        int x = x();
        if (x == 5) {
            this.p.writeByte(44);
        } else if (x != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        Z();
        A(4);
    }

    private void W() throws IOException {
        int x = x();
        int i2 = 7;
        if (x != 1) {
            if (x == 2) {
                this.p.writeByte(44);
            } else {
                if (x == 4) {
                    i2 = 5;
                    this.p.r0(this.q);
                } else {
                    if (x == 9) {
                        throw new IllegalStateException("Sink from valueSink() was not closed");
                    }
                    if (x != 6) {
                        if (x == 7) {
                            if (!this.f20577k) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                }
                A(i2);
            }
        }
        Z();
        i2 = 2;
        A(i2);
    }

    private o Y(int i2, int i3, char c2) throws IOException {
        int x = x();
        if (x != i3 && x != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.r == null) {
            int i4 = this.f20572f;
            int i5 = this.n;
            if (i4 == (i5 ^ (-1))) {
                this.n = i5 ^ (-1);
                return this;
            }
            int i6 = i4 - 1;
            this.f20572f = i6;
            this.f20574h[i6] = null;
            int[] iArr = this.f20575i;
            int i7 = i6 - 1;
            iArr[i7] = iArr[i7] + 1;
            if (x == i3) {
                Z();
            }
            this.p.writeByte(c2);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.r);
    }

    private void Z() throws IOException {
        if (this.f20576j == null) {
            return;
        }
        this.p.writeByte(10);
        int i2 = this.f20572f;
        for (int i3 = 1; i3 < i2; i3++) {
            this.p.r0(this.f20576j);
        }
    }

    private o a0(int i2, int i3, char c2) throws IOException {
        int i4 = this.f20572f;
        int i5 = this.n;
        if (i4 == i5) {
            int[] iArr = this.f20573g;
            if (iArr[i4 - 1] == i2 || iArr[i4 - 1] == i3) {
                this.n = i5 ^ (-1);
                return this;
            }
        }
        W();
        c();
        z(i2);
        this.f20575i[this.f20572f - 1] = 0;
        this.p.writeByte(c2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e0(j.g gVar, String str) throws IOException {
        int i2;
        String str2;
        String[] strArr = o;
        gVar.writeByte(34);
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i2 = str2 == null ? i2 + 1 : 0;
                if (i3 < i2) {
                    gVar.A0(str, i3, i2);
                }
                gVar.r0(str2);
                i3 = i2 + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i3 < i2) {
                }
                gVar.r0(str2);
                i3 = i2 + 1;
            }
        }
        if (i3 < length) {
            gVar.A0(str, i3, length);
        }
        gVar.writeByte(34);
    }

    private void f0() throws IOException {
        if (this.r != null) {
            T();
            e0(this.p, this.r);
            this.r = null;
        }
    }

    @Override // com.squareup.moshi.o
    public void B(String str) {
        super.B(str);
        this.q = !str.isEmpty() ? ": " : ":";
    }

    @Override // com.squareup.moshi.o
    public o I(double d2) throws IOException {
        if (!this.f20577k && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        if (this.m) {
            this.m = false;
            return l(Double.toString(d2));
        }
        f0();
        W();
        this.p.r0(Double.toString(d2));
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o J(long j2) throws IOException {
        if (this.m) {
            this.m = false;
            return l(Long.toString(j2));
        }
        f0();
        W();
        this.p.r0(Long.toString(j2));
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o K(Number number) throws IOException {
        if (number == null) {
            return m();
        }
        String obj = number.toString();
        if (!this.f20577k && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        if (this.m) {
            this.m = false;
            return l(obj);
        }
        f0();
        W();
        this.p.r0(obj);
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o N(String str) throws IOException {
        if (str == null) {
            return m();
        }
        if (this.m) {
            this.m = false;
            return l(str);
        }
        f0();
        W();
        e0(this.p, str);
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o Q(boolean z) throws IOException {
        if (!this.m) {
            f0();
            W();
            this.p.r0(z ? "true" : AdultContentAnalytics.UNLOCK);
            int[] iArr = this.f20575i;
            int i2 = this.f20572f - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + g());
    }

    @Override // com.squareup.moshi.o
    public o a() throws IOException {
        if (!this.m) {
            f0();
            return a0(1, 2, '[');
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + g());
    }

    @Override // com.squareup.moshi.o
    public o b() throws IOException {
        if (!this.m) {
            f0();
            return a0(3, 5, '{');
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + g());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.p.close();
        int i2 = this.f20572f;
        if (i2 <= 1 && (i2 != 1 || this.f20573g[i2 - 1] == 7)) {
            this.f20572f = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.squareup.moshi.o
    public o d() throws IOException {
        return Y(1, 2, ']');
    }

    @Override // com.squareup.moshi.o
    public o e() throws IOException {
        this.m = false;
        return Y(3, 5, '}');
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f20572f != 0) {
            this.p.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    @Override // com.squareup.moshi.o
    public o l(String str) throws IOException {
        if (str != null) {
            if (this.f20572f != 0) {
                int x = x();
                if ((x == 3 || x == 5) && this.r == null && !this.m) {
                    this.r = str;
                    this.f20574h[this.f20572f - 1] = str;
                    return this;
                }
                throw new IllegalStateException("Nesting problem.");
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new NullPointerException("name == null");
    }

    @Override // com.squareup.moshi.o
    public o m() throws IOException {
        if (!this.m) {
            if (this.r != null) {
                if (this.l) {
                    f0();
                } else {
                    this.r = null;
                    return this;
                }
            }
            W();
            this.p.r0("null");
            int[] iArr = this.f20575i;
            int i2 = this.f20572f - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("null cannot be used as a map key in JSON at path " + g());
    }
}
