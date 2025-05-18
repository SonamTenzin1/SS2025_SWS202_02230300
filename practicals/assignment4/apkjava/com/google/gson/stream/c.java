package com.google.gson.stream;

import cm.aptoide.pt.account.AdultContentAnalytics;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: JsonWriter.java */
/* loaded from: classes2.dex */
public class c implements Closeable, Flushable {

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f20168f = new String[128];

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f20169g;

    /* renamed from: h, reason: collision with root package name */
    private final Writer f20170h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f20171i = new int[32];

    /* renamed from: j, reason: collision with root package name */
    private int f20172j = 0;

    /* renamed from: k, reason: collision with root package name */
    private String f20173k;
    private String l;
    private boolean m;
    private boolean n;
    private String o;
    private boolean p;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f20168f[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f20168f;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f20169g = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        B(6);
        this.l = ":";
        this.p = true;
        if (writer != null) {
            this.f20170h = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private int A() {
        int i2 = this.f20172j;
        if (i2 != 0) {
            return this.f20171i[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void B(int i2) {
        int i3 = this.f20172j;
        int[] iArr = this.f20171i;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f20171i = iArr2;
        }
        int[] iArr3 = this.f20171i;
        int i4 = this.f20172j;
        this.f20172j = i4 + 1;
        iArr3[i4] = i2;
    }

    private void D(int i2) {
        this.f20171i[this.f20172j - 1] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void N(String str) throws IOException {
        int i2;
        String str2;
        String[] strArr = this.n ? f20169g : f20168f;
        this.f20170h.write("\"");
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i2 = str2 == null ? i2 + 1 : 0;
                if (i3 < i2) {
                    this.f20170h.write(str, i3, i2 - i3);
                }
                this.f20170h.write(str2);
                i3 = i2 + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i3 < i2) {
                }
                this.f20170h.write(str2);
                i3 = i2 + 1;
            }
        }
        if (i3 < length) {
            this.f20170h.write(str, i3, length - i3);
        }
        this.f20170h.write("\"");
    }

    private void a() throws IOException {
        int A = A();
        if (A == 5) {
            this.f20170h.write(44);
        } else if (A != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        x();
        D(4);
    }

    private void a0() throws IOException {
        if (this.o != null) {
            a();
            N(this.o);
            this.o = null;
        }
    }

    private void b() throws IOException {
        int A = A();
        if (A == 1) {
            D(2);
            x();
            return;
        }
        if (A == 2) {
            this.f20170h.append(',');
            x();
        } else {
            if (A != 4) {
                if (A != 6) {
                    if (A == 7) {
                        if (!this.m) {
                            throw new IllegalStateException("JSON must have only one top-level value.");
                        }
                    } else {
                        throw new IllegalStateException("Nesting problem.");
                    }
                }
                D(7);
                return;
            }
            this.f20170h.append((CharSequence) this.l);
            D(5);
        }
    }

    private c e(int i2, int i3, String str) throws IOException {
        int A = A();
        if (A != i3 && A != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.o == null) {
            this.f20172j--;
            if (A == i3) {
                x();
            }
            this.f20170h.write(str);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.o);
    }

    private void x() throws IOException {
        if (this.f20173k == null) {
            return;
        }
        this.f20170h.write("\n");
        int i2 = this.f20172j;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f20170h.write(this.f20173k);
        }
    }

    private c z(int i2, String str) throws IOException {
        b();
        B(i2);
        this.f20170h.write(str);
        return this;
    }

    public final void H(boolean z) {
        this.n = z;
    }

    public final void I(String str) {
        if (str.length() == 0) {
            this.f20173k = null;
            this.l = ":";
        } else {
            this.f20173k = str;
            this.l = ": ";
        }
    }

    public final void J(boolean z) {
        this.m = z;
    }

    public final void K(boolean z) {
        this.p = z;
    }

    public c Q(long j2) throws IOException {
        a0();
        b();
        this.f20170h.write(Long.toString(j2));
        return this;
    }

    public c T(Boolean bool) throws IOException {
        if (bool == null) {
            return y();
        }
        a0();
        b();
        this.f20170h.write(bool.booleanValue() ? "true" : AdultContentAnalytics.UNLOCK);
        return this;
    }

    public c W(Number number) throws IOException {
        if (number == null) {
            return y();
        }
        a0();
        String obj = number.toString();
        if (!this.m && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        b();
        this.f20170h.append((CharSequence) obj);
        return this;
    }

    public c Y(String str) throws IOException {
        if (str == null) {
            return y();
        }
        a0();
        b();
        N(str);
        return this;
    }

    public c Z(boolean z) throws IOException {
        a0();
        b();
        this.f20170h.write(z ? "true" : AdultContentAnalytics.UNLOCK);
        return this;
    }

    public c c() throws IOException {
        a0();
        return z(1, "[");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f20170h.close();
        int i2 = this.f20172j;
        if (i2 <= 1 && (i2 != 1 || this.f20171i[i2 - 1] == 7)) {
            this.f20172j = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public c d() throws IOException {
        a0();
        return z(3, "{");
    }

    public c f() throws IOException {
        return e(1, 2, "]");
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f20172j != 0) {
            this.f20170h.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c j() throws IOException {
        return e(3, 5, "}");
    }

    public final boolean k() {
        return this.p;
    }

    public final boolean l() {
        return this.n;
    }

    public boolean m() {
        return this.m;
    }

    public c p(String str) throws IOException {
        if (str != null) {
            if (this.o == null) {
                if (this.f20172j != 0) {
                    this.o = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public c y() throws IOException {
        if (this.o != null) {
            if (this.p) {
                a0();
            } else {
                this.o = null;
                return this;
            }
        }
        b();
        this.f20170h.write("null");
        return this;
    }
}
