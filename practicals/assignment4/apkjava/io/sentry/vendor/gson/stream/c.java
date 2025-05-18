package io.sentry.vendor.gson.stream;

import cm.aptoide.pt.account.AdultContentAnalytics;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: JsonWriter.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public class c implements Closeable, Flushable {

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f22790f = new String[128];

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f22791g;

    /* renamed from: h, reason: collision with root package name */
    private final Writer f22792h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f22793i = new int[32];

    /* renamed from: j, reason: collision with root package name */
    private int f22794j = 0;

    /* renamed from: k, reason: collision with root package name */
    private String f22795k;
    private String l;
    private boolean m;
    private boolean n;
    private String o;
    private boolean p;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f22790f[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f22790f;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f22791g = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        y(6);
        this.l = ":";
        this.p = true;
        if (writer != null) {
            this.f22792h = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void B(String str) throws IOException {
        int i2;
        String str2;
        String[] strArr = this.n ? f22791g : f22790f;
        this.f22792h.write(34);
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i2 = str2 == null ? i2 + 1 : 0;
                if (i3 < i2) {
                    this.f22792h.write(str, i3, i2 - i3);
                }
                this.f22792h.write(str2);
                i3 = i2 + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i3 < i2) {
                }
                this.f22792h.write(str2);
                i3 = i2 + 1;
            }
        }
        if (i3 < length) {
            this.f22792h.write(str, i3, length - i3);
        }
        this.f22792h.write(34);
    }

    private void N() throws IOException {
        if (this.o != null) {
            a();
            B(this.o);
            this.o = null;
        }
    }

    private void a() throws IOException {
        int x = x();
        if (x == 5) {
            this.f22792h.write(44);
        } else if (x != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        l();
        z(4);
    }

    private void b() throws IOException {
        int x = x();
        if (x == 1) {
            z(2);
            l();
            return;
        }
        if (x == 2) {
            this.f22792h.append(',');
            l();
        } else {
            if (x != 4) {
                if (x != 6) {
                    if (x == 7) {
                        if (!this.m) {
                            throw new IllegalStateException("JSON must have only one top-level value.");
                        }
                    } else {
                        throw new IllegalStateException("Nesting problem.");
                    }
                }
                z(7);
                return;
            }
            this.f22792h.append((CharSequence) this.l);
            z(5);
        }
    }

    private c e(int i2, int i3, char c2) throws IOException {
        int x = x();
        if (x != i3 && x != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.o == null) {
            this.f22794j--;
            if (x == i3) {
                l();
            }
            this.f22792h.write(c2);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.o);
    }

    private void l() throws IOException {
        if (this.f22795k == null) {
            return;
        }
        this.f22792h.write(10);
        int i2 = this.f22794j;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f22792h.write(this.f22795k);
        }
    }

    private c p(int i2, char c2) throws IOException {
        b();
        y(i2);
        this.f22792h.write(c2);
        return this;
    }

    private int x() {
        int i2 = this.f22794j;
        if (i2 != 0) {
            return this.f22793i[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void y(int i2) {
        int i3 = this.f22794j;
        int[] iArr = this.f22793i;
        if (i3 == iArr.length) {
            this.f22793i = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.f22793i;
        int i4 = this.f22794j;
        this.f22794j = i4 + 1;
        iArr2[i4] = i2;
    }

    private void z(int i2) {
        this.f22793i[this.f22794j - 1] = i2;
    }

    public final void A(String str) {
        if (str.length() == 0) {
            this.f22795k = null;
            this.l = ":";
        } else {
            this.f22795k = str;
            this.l = ": ";
        }
    }

    public c D(long j2) throws IOException {
        N();
        b();
        this.f22792h.write(Long.toString(j2));
        return this;
    }

    public c H(Boolean bool) throws IOException {
        if (bool == null) {
            return m();
        }
        N();
        b();
        this.f22792h.write(bool.booleanValue() ? "true" : AdultContentAnalytics.UNLOCK);
        return this;
    }

    public c I(Number number) throws IOException {
        if (number == null) {
            return m();
        }
        N();
        String obj = number.toString();
        if (!this.m && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        b();
        this.f22792h.append((CharSequence) obj);
        return this;
    }

    public c J(String str) throws IOException {
        if (str == null) {
            return m();
        }
        N();
        b();
        B(str);
        return this;
    }

    public c K(boolean z) throws IOException {
        N();
        b();
        this.f22792h.write(z ? "true" : AdultContentAnalytics.UNLOCK);
        return this;
    }

    public c c() throws IOException {
        N();
        return p(1, '[');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22792h.close();
        int i2 = this.f22794j;
        if (i2 <= 1 && (i2 != 1 || this.f22793i[i2 - 1] == 7)) {
            this.f22794j = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public c d() throws IOException {
        N();
        return p(3, '{');
    }

    public c f() throws IOException {
        return e(1, 2, ']');
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f22794j != 0) {
            this.f22792h.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c j() throws IOException {
        return e(3, 5, '}');
    }

    public c k(String str) throws IOException {
        if (str != null) {
            if (this.o == null) {
                if (this.f22794j != 0) {
                    this.o = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public c m() throws IOException {
        if (this.o != null) {
            if (this.p) {
                N();
            } else {
                this.o = null;
                return this;
            }
        }
        b();
        this.f22792h.write("null");
        return this;
    }
}
