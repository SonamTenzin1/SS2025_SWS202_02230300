package com.squareup.moshi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonValueWriter.java */
/* loaded from: classes2.dex */
public final class n extends o {
    Object[] o = new Object[32];
    private String p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n() {
        z(6);
    }

    private n T(Object obj) {
        String str;
        Object put;
        int x = x();
        int i2 = this.f20572f;
        if (i2 == 1) {
            if (x == 6) {
                this.f20573g[i2 - 1] = 7;
                this.o[i2 - 1] = obj;
            } else {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        } else if (x != 3 || (str = this.p) == null) {
            if (x != 1) {
                if (x == 9) {
                    throw new IllegalStateException("Sink from valueSink() was not closed");
                }
                throw new IllegalStateException("Nesting problem.");
            }
            ((List) this.o[i2 - 1]).add(obj);
        } else if ((obj == null && !this.l) || (put = ((Map) this.o[i2 - 1]).put(str, obj)) == null) {
            this.p = null;
        } else {
            throw new IllegalArgumentException("Map key '" + this.p + "' has multiple values at path " + g() + ": " + put + " and " + obj);
        }
        return this;
    }

    @Override // com.squareup.moshi.o
    public o I(double d2) throws IOException {
        if (!this.f20577k && (Double.isNaN(d2) || d2 == Double.NEGATIVE_INFINITY || d2 == Double.POSITIVE_INFINITY)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        if (this.m) {
            this.m = false;
            return l(Double.toString(d2));
        }
        T(Double.valueOf(d2));
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
        T(Long.valueOf(j2));
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o K(Number number) throws IOException {
        if (!(number instanceof Byte) && !(number instanceof Short) && !(number instanceof Integer) && !(number instanceof Long)) {
            if ((number instanceof Float) || (number instanceof Double)) {
                return I(number.doubleValue());
            }
            if (number == null) {
                return m();
            }
            BigDecimal bigDecimal = number instanceof BigDecimal ? (BigDecimal) number : new BigDecimal(number.toString());
            if (this.m) {
                this.m = false;
                return l(bigDecimal.toString());
            }
            T(bigDecimal);
            int[] iArr = this.f20575i;
            int i2 = this.f20572f - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        return J(number.longValue());
    }

    @Override // com.squareup.moshi.o
    public o N(String str) throws IOException {
        if (this.m) {
            this.m = false;
            return l(str);
        }
        T(str);
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o Q(boolean z) throws IOException {
        if (!this.m) {
            T(Boolean.valueOf(z));
            int[] iArr = this.f20575i;
            int i2 = this.f20572f - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + g());
    }

    public Object W() {
        int i2 = this.f20572f;
        if (i2 <= 1 && (i2 != 1 || this.f20573g[i2 - 1] == 7)) {
            return this.o[0];
        }
        throw new IllegalStateException("Incomplete document");
    }

    @Override // com.squareup.moshi.o
    public o a() throws IOException {
        if (!this.m) {
            int i2 = this.f20572f;
            int i3 = this.n;
            if (i2 == i3 && this.f20573g[i2 - 1] == 1) {
                this.n = i3 ^ (-1);
                return this;
            }
            c();
            ArrayList arrayList = new ArrayList();
            T(arrayList);
            Object[] objArr = this.o;
            int i4 = this.f20572f;
            objArr[i4] = arrayList;
            this.f20575i[i4] = 0;
            z(1);
            return this;
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + g());
    }

    @Override // com.squareup.moshi.o
    public o b() throws IOException {
        if (!this.m) {
            int i2 = this.f20572f;
            int i3 = this.n;
            if (i2 == i3 && this.f20573g[i2 - 1] == 3) {
                this.n = i3 ^ (-1);
                return this;
            }
            c();
            p pVar = new p();
            T(pVar);
            this.o[this.f20572f] = pVar;
            z(3);
            return this;
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + g());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i2 = this.f20572f;
        if (i2 <= 1 && (i2 != 1 || this.f20573g[i2 - 1] == 7)) {
            this.f20572f = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.squareup.moshi.o
    public o d() throws IOException {
        if (x() == 1) {
            int i2 = this.f20572f;
            int i3 = this.n;
            if (i2 == (i3 ^ (-1))) {
                this.n = i3 ^ (-1);
                return this;
            }
            int i4 = i2 - 1;
            this.f20572f = i4;
            this.o[i4] = null;
            int[] iArr = this.f20575i;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override // com.squareup.moshi.o
    public o e() throws IOException {
        if (x() == 3) {
            if (this.p == null) {
                int i2 = this.f20572f;
                int i3 = this.n;
                if (i2 == (i3 ^ (-1))) {
                    this.n = i3 ^ (-1);
                    return this;
                }
                this.m = false;
                int i4 = i2 - 1;
                this.f20572f = i4;
                this.o[i4] = null;
                this.f20574h[i4] = null;
                int[] iArr = this.f20575i;
                int i5 = i4 - 1;
                iArr[i5] = iArr[i5] + 1;
                return this;
            }
            throw new IllegalStateException("Dangling name: " + this.p);
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f20572f == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    @Override // com.squareup.moshi.o
    public o l(String str) throws IOException {
        if (str != null) {
            if (this.f20572f != 0) {
                if (x() == 3 && this.p == null && !this.m) {
                    this.p = str;
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
            T(null);
            int[] iArr = this.f20575i;
            int i2 = this.f20572f - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("null cannot be used as a map key in JSON at path " + g());
    }
}
