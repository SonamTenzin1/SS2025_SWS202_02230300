package com.google.gson.stream;

import cm.aptoide.pt.account.AdultContentAnalytics;
import com.google.gson.t.f;
import com.google.gson.t.n.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* compiled from: JsonReader.java */
/* loaded from: classes2.dex */
public class a implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private static final char[] f20156f = ")]}'\n".toCharArray();

    /* renamed from: g, reason: collision with root package name */
    private final Reader f20157g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f20158h = false;

    /* renamed from: i, reason: collision with root package name */
    private final char[] f20159i = new char[1024];

    /* renamed from: j, reason: collision with root package name */
    private int f20160j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f20161k = 0;
    private int l = 0;
    private int m = 0;
    int n = 0;
    private long o;
    private int p;
    private String q;
    private int[] r;
    private int s;
    private String[] t;
    private int[] u;

    /* compiled from: JsonReader.java */
    /* renamed from: com.google.gson.stream.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0240a extends f {
        C0240a() {
        }

        @Override // com.google.gson.t.f
        public void a(a aVar) throws IOException {
            if (aVar instanceof e) {
                ((e) aVar).y0();
                return;
            }
            int i2 = aVar.n;
            if (i2 == 0) {
                i2 = aVar.e();
            }
            if (i2 == 13) {
                aVar.n = 9;
                return;
            }
            if (i2 == 12) {
                aVar.n = 8;
                return;
            }
            if (i2 == 14) {
                aVar.n = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.Q() + aVar.x());
        }
    }

    static {
        f.a = new C0240a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.r = iArr;
        this.s = 0;
        this.s = 0 + 1;
        iArr[0] = 6;
        this.t = new String[32];
        this.u = new int[32];
        if (reader != null) {
            this.f20157g = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private int H(boolean z) throws IOException {
        char[] cArr = this.f20159i;
        int i2 = this.f20160j;
        int i3 = this.f20161k;
        while (true) {
            if (i2 == i3) {
                this.f20160j = i2;
                if (!k(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + x());
                }
                i2 = this.f20160j;
                i3 = this.f20161k;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.l++;
                this.m = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f20160j = i4;
                    if (i4 == i3) {
                        this.f20160j = i4 - 1;
                        boolean k2 = k(2);
                        this.f20160j++;
                        if (!k2) {
                            return c2;
                        }
                    }
                    c();
                    int i5 = this.f20160j;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f20160j = i5 + 1;
                        if (f0("*/")) {
                            i2 = this.f20160j + 2;
                            i3 = this.f20161k;
                        } else {
                            throw p0("Unterminated comment");
                        }
                    } else {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.f20160j = i5 + 1;
                        i0();
                        i2 = this.f20160j;
                        i3 = this.f20161k;
                    }
                } else if (c2 == '#') {
                    this.f20160j = i4;
                    c();
                    i0();
                    i2 = this.f20160j;
                    i3 = this.f20161k;
                } else {
                    this.f20160j = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006c, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.f20160j = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String J(char c2) throws IOException {
        char[] cArr = this.f20159i;
        StringBuilder sb = null;
        do {
            int i2 = this.f20160j;
            int i3 = this.f20161k;
            while (true) {
                int i4 = i3;
                int i5 = i2;
                while (i2 < i4) {
                    int i6 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.f20160j = i6;
                        int i7 = (i6 - i5) - 1;
                        if (sb == null) {
                            return new String(cArr, i5, i7);
                        }
                        sb.append(cArr, i5, i7);
                        return sb.toString();
                    }
                    if (c3 == '\\') {
                        this.f20160j = i6;
                        int i8 = (i6 - i5) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i8 + 1) * 2, 16));
                        }
                        sb.append(cArr, i5, i8);
                        sb.append(Z());
                        i2 = this.f20160j;
                        i3 = this.f20161k;
                    } else {
                        if (c3 == '\n') {
                            this.l++;
                            this.m = i6;
                        }
                        i2 = i6;
                    }
                }
                break;
            }
        } while (k(1));
        throw p0("Unterminated string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        c();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String N() throws IOException {
        String sb;
        int i2 = 0;
        StringBuilder sb2 = null;
        do {
            int i3 = 0;
            while (true) {
                int i4 = this.f20160j;
                if (i4 + i3 < this.f20161k) {
                    char c2 = this.f20159i[i4 + i3];
                    if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (c2 != '/' && c2 != '=') {
                                    if (c2 != '{' && c2 != '}' && c2 != ':') {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i3++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i3 < this.f20159i.length) {
                    if (k(i3 + 1)) {
                    }
                } else {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i3, 16));
                    }
                    sb2.append(this.f20159i, this.f20160j, i3);
                    this.f20160j += i3;
                }
            }
            i2 = i3;
            if (sb2 != null) {
                sb = new String(this.f20159i, this.f20160j, i2);
            } else {
                sb2.append(this.f20159i, this.f20160j, i2);
                sb = sb2.toString();
            }
            this.f20160j += i2;
            return sb;
        } while (k(1));
        if (sb2 != null) {
        }
        this.f20160j += i2;
        return sb;
    }

    private int T() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f20159i[this.f20160j];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str = AdultContentAnalytics.UNLOCK;
            str2 = "FALSE";
        } else {
            if (c2 != 'n' && c2 != 'N') {
                return 0;
            }
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f20160j + i3 >= this.f20161k && !k(i3 + 1)) {
                return 0;
            }
            char c3 = this.f20159i[this.f20160j + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f20160j + length < this.f20161k || k(length + 1)) && p(this.f20159i[this.f20160j + length])) {
            return 0;
        }
        this.f20160j += length;
        this.n = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0099, code lost:
    
        if (r9 != 2) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x009b, code lost:
    
        if (r10 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a1, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a3, code lost:
    
        if (r13 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a9, code lost:
    
        if (r11 != 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ab, code lost:
    
        if (r13 != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ad, code lost:
    
        if (r13 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b0, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b1, code lost:
    
        r18.o = r11;
        r18.f20160j += r8;
        r18.n = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00bc, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bd, code lost:
    
        if (r9 == 2) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c0, code lost:
    
        if (r9 == 4) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c3, code lost:
    
        if (r9 != 7) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c6, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c8, code lost:
    
        r18.p = r8;
        r18.n = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ce, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0097, code lost:
    
        if (p(r14) != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00cf, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int W() throws IOException {
        char[] cArr = this.f20159i;
        int i2 = this.f20160j;
        int i3 = this.f20161k;
        int i4 = 0;
        int i5 = 0;
        char c2 = 0;
        boolean z = true;
        long j2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 + i5 == i3) {
                if (i5 == cArr.length) {
                    return i4;
                }
                if (!k(i5 + 1)) {
                    break;
                }
                i2 = this.f20160j;
                i3 = this.f20161k;
            }
            char c3 = cArr[i2 + i5];
            if (c3 != '+') {
                if (c3 == 'E' || c3 == 'e') {
                    i4 = 0;
                    if (c2 != 2 && c2 != 4) {
                        return 0;
                    }
                    c2 = 5;
                } else if (c3 == '-') {
                    i4 = 0;
                    if (c2 == 0) {
                        c2 = 1;
                        z2 = true;
                    } else if (c2 != 5) {
                        return 0;
                    }
                } else if (c3 == '.') {
                    i4 = 0;
                    if (c2 != 2) {
                        return 0;
                    }
                    c2 = 3;
                } else {
                    if (c3 < '0' || c3 > '9') {
                        break;
                    }
                    if (c2 == 1 || c2 == 0) {
                        j2 = -(c3 - '0');
                        i4 = 0;
                        c2 = 2;
                    } else {
                        if (c2 == 2) {
                            if (j2 == 0) {
                                return 0;
                            }
                            long j3 = (10 * j2) - (c3 - '0');
                            z &= j2 > -922337203685477580L || (j2 == -922337203685477580L && j3 < j2);
                            j2 = j3;
                        } else if (c2 == 3) {
                            i4 = 0;
                            c2 = 4;
                        } else if (c2 == 5 || c2 == 6) {
                            i4 = 0;
                            c2 = 7;
                        }
                        i4 = 0;
                    }
                }
                i5++;
            } else {
                i4 = 0;
                if (c2 != 5) {
                    return 0;
                }
            }
            c2 = 6;
            i5++;
        }
    }

    private void Y(int i2) {
        int i3 = this.s;
        int[] iArr = this.r;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            int[] iArr3 = new int[i3 * 2];
            String[] strArr = new String[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.u, 0, iArr3, 0, this.s);
            System.arraycopy(this.t, 0, strArr, 0, this.s);
            this.r = iArr2;
            this.u = iArr3;
            this.t = strArr;
        }
        int[] iArr4 = this.r;
        int i4 = this.s;
        this.s = i4 + 1;
        iArr4[i4] = i2;
    }

    private char Z() throws IOException {
        int i2;
        int i3;
        if (this.f20160j == this.f20161k && !k(1)) {
            throw p0("Unterminated escape sequence");
        }
        char[] cArr = this.f20159i;
        int i4 = this.f20160j;
        int i5 = i4 + 1;
        this.f20160j = i5;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.l++;
            this.m = i5;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 == 'b') {
                return '\b';
            }
            if (c2 == 'f') {
                return '\f';
            }
            if (c2 == 'n') {
                return '\n';
            }
            if (c2 == 'r') {
                return '\r';
            }
            if (c2 == 't') {
                return '\t';
            }
            if (c2 == 'u') {
                if (i5 + 4 > this.f20161k && !k(4)) {
                    throw p0("Unterminated escape sequence");
                }
                char c3 = 0;
                int i6 = this.f20160j;
                int i7 = i6 + 4;
                while (i6 < i7) {
                    char c4 = this.f20159i[i6];
                    char c5 = (char) (c3 << 4);
                    if (c4 < '0' || c4 > '9') {
                        if (c4 >= 'a' && c4 <= 'f') {
                            i2 = c4 - 'a';
                        } else {
                            if (c4 < 'A' || c4 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f20159i, this.f20160j, 4));
                            }
                            i2 = c4 - 'A';
                        }
                        i3 = i2 + 10;
                    } else {
                        i3 = c4 - '0';
                    }
                    c3 = (char) (c5 + i3);
                    i6++;
                }
                this.f20160j += 4;
                return c3;
            }
            throw p0("Invalid escape sequence");
        }
        return c2;
    }

    private void c() throws IOException {
        if (!this.f20158h) {
            throw p0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void d() throws IOException {
        H(true);
        int i2 = this.f20160j - 1;
        this.f20160j = i2;
        char[] cArr = f20156f;
        if (i2 + cArr.length > this.f20161k && !k(cArr.length)) {
            return;
        }
        int i3 = 0;
        while (true) {
            char[] cArr2 = f20156f;
            if (i3 < cArr2.length) {
                if (this.f20159i[this.f20160j + i3] != cArr2[i3]) {
                    return;
                } else {
                    i3++;
                }
            } else {
                this.f20160j += cArr2.length;
                return;
            }
        }
    }

    private void e0(char c2) throws IOException {
        char[] cArr = this.f20159i;
        do {
            int i2 = this.f20160j;
            int i3 = this.f20161k;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f20160j = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f20160j = i4;
                    Z();
                    i2 = this.f20160j;
                    i3 = this.f20161k;
                } else {
                    if (c3 == '\n') {
                        this.l++;
                        this.m = i4;
                    }
                    i2 = i4;
                }
            }
            this.f20160j = i2;
        } while (k(1));
        throw p0("Unterminated string");
    }

    private boolean f0(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f20160j + length > this.f20161k && !k(length)) {
                return false;
            }
            char[] cArr = this.f20159i;
            int i2 = this.f20160j;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f20159i[this.f20160j + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.l++;
            this.m = i2 + 1;
            this.f20160j++;
        }
    }

    private void i0() throws IOException {
        char c2;
        do {
            if (this.f20160j >= this.f20161k && !k(1)) {
                return;
            }
            char[] cArr = this.f20159i;
            int i2 = this.f20160j;
            int i3 = i2 + 1;
            this.f20160j = i3;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.l++;
                this.m = i3;
                return;
            }
        } while (c2 != '\r');
    }

    private boolean k(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.f20159i;
        int i5 = this.m;
        int i6 = this.f20160j;
        this.m = i5 - i6;
        int i7 = this.f20161k;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f20161k = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f20161k = 0;
        }
        this.f20160j = 0;
        do {
            Reader reader = this.f20157g;
            int i9 = this.f20161k;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.f20161k + read;
            this.f20161k = i3;
            if (this.l == 0 && (i4 = this.m) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f20160j++;
                this.m = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:242)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private void m0() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f20160j
            int r2 = r1 + r0
            int r3 = r4.f20161k
            if (r2 >= r3) goto L51
            char[] r2 = r4.f20159i
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.c()
        L4b:
            int r1 = r4.f20160j
            int r1 = r1 + r0
            r4.f20160j = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f20160j = r1
            r0 = 1
            boolean r0 = r4.k(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.m0():void");
    }

    private boolean p(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    private IOException p0(String str) throws IOException {
        throw new MalformedJsonException(str + x());
    }

    public int A() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            long j2 = this.o;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.n = 0;
                int[] iArr = this.u;
                int i4 = this.s - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.o + x());
        }
        if (i2 == 16) {
            this.q = new String(this.f20159i, this.f20160j, this.p);
            this.f20160j += this.p;
        } else {
            if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected an int but was " + Q() + x());
            }
            if (i2 == 10) {
                this.q = N();
            } else {
                this.q = J(i2 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.q);
                this.n = 0;
                int[] iArr2 = this.u;
                int i5 = this.s - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.n = 11;
        double parseDouble = Double.parseDouble(this.q);
        int i6 = (int) parseDouble;
        if (i6 == parseDouble) {
            this.q = null;
            this.n = 0;
            int[] iArr3 = this.u;
            int i7 = this.s - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.q + x());
    }

    public long B() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            this.n = 0;
            int[] iArr = this.u;
            int i3 = this.s - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.o;
        }
        if (i2 == 16) {
            this.q = new String(this.f20159i, this.f20160j, this.p);
            this.f20160j += this.p;
        } else {
            if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected a long but was " + Q() + x());
            }
            if (i2 == 10) {
                this.q = N();
            } else {
                this.q = J(i2 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.q);
                this.n = 0;
                int[] iArr2 = this.u;
                int i4 = this.s - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.n = 11;
        double parseDouble = Double.parseDouble(this.q);
        long j2 = (long) parseDouble;
        if (j2 == parseDouble) {
            this.q = null;
            this.n = 0;
            int[] iArr3 = this.u;
            int i5 = this.s - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.q + x());
    }

    public String D() throws IOException {
        String J;
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 14) {
            J = N();
        } else if (i2 == 12) {
            J = J('\'');
        } else if (i2 == 13) {
            J = J('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + Q() + x());
        }
        this.n = 0;
        this.t[this.s - 1] = J;
        return J;
    }

    public void I() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 7) {
            this.n = 0;
            int[] iArr = this.u;
            int i3 = this.s - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + Q() + x());
    }

    public String K() throws IOException {
        String str;
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 10) {
            str = N();
        } else if (i2 == 8) {
            str = J('\'');
        } else if (i2 == 9) {
            str = J('\"');
        } else if (i2 == 11) {
            str = this.q;
            this.q = null;
        } else if (i2 == 15) {
            str = Long.toString(this.o);
        } else if (i2 == 16) {
            str = new String(this.f20159i, this.f20160j, this.p);
            this.f20160j += this.p;
        } else {
            throw new IllegalStateException("Expected a string but was " + Q() + x());
        }
        this.n = 0;
        int[] iArr = this.u;
        int i3 = this.s - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public b Q() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        switch (i2) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void a() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 3) {
            Y(1);
            this.u[this.s - 1] = 0;
            this.n = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + Q() + x());
        }
    }

    public final void a0(boolean z) {
        this.f20158h = z;
    }

    public void b() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 1) {
            Y(3);
            this.n = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + Q() + x());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.n = 0;
        this.r[0] = 8;
        this.s = 1;
        this.f20157g.close();
    }

    int e() throws IOException {
        int H;
        int[] iArr = this.r;
        int i2 = this.s;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int H2 = H(true);
            if (H2 != 44) {
                if (H2 != 59) {
                    if (H2 == 93) {
                        this.n = 4;
                        return 4;
                    }
                    throw p0("Unterminated array");
                }
                c();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5 && (H = H(true)) != 44) {
                    if (H != 59) {
                        if (H == 125) {
                            this.n = 2;
                            return 2;
                        }
                        throw p0("Unterminated object");
                    }
                    c();
                }
                int H3 = H(true);
                if (H3 == 34) {
                    this.n = 13;
                    return 13;
                }
                if (H3 == 39) {
                    c();
                    this.n = 12;
                    return 12;
                }
                if (H3 == 125) {
                    if (i3 != 5) {
                        this.n = 2;
                        return 2;
                    }
                    throw p0("Expected name");
                }
                c();
                this.f20160j--;
                if (p((char) H3)) {
                    this.n = 14;
                    return 14;
                }
                throw p0("Expected name");
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int H4 = H(true);
                if (H4 != 58) {
                    if (H4 == 61) {
                        c();
                        if (this.f20160j < this.f20161k || k(1)) {
                            char[] cArr = this.f20159i;
                            int i4 = this.f20160j;
                            if (cArr[i4] == '>') {
                                this.f20160j = i4 + 1;
                            }
                        }
                    } else {
                        throw p0("Expected ':'");
                    }
                }
            } else if (i3 == 6) {
                if (this.f20158h) {
                    d();
                }
                this.r[this.s - 1] = 7;
            } else if (i3 == 7) {
                if (H(false) == -1) {
                    this.n = 17;
                    return 17;
                }
                c();
                this.f20160j--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int H5 = H(true);
        if (H5 == 34) {
            this.n = 9;
            return 9;
        }
        if (H5 == 39) {
            c();
            this.n = 8;
            return 8;
        }
        if (H5 != 44 && H5 != 59) {
            if (H5 == 91) {
                this.n = 3;
                return 3;
            }
            if (H5 != 93) {
                if (H5 != 123) {
                    this.f20160j--;
                    int T = T();
                    if (T != 0) {
                        return T;
                    }
                    int W = W();
                    if (W != 0) {
                        return W;
                    }
                    if (p(this.f20159i[this.f20160j])) {
                        c();
                        this.n = 10;
                        return 10;
                    }
                    throw p0("Expected value");
                }
                this.n = 1;
                return 1;
            }
            if (i3 == 1) {
                this.n = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw p0("Unexpected value");
        }
        c();
        this.f20160j--;
        this.n = 7;
        return 7;
    }

    public void f() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 4) {
            int i3 = this.s - 1;
            this.s = i3;
            int[] iArr = this.u;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.n = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + Q() + x());
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.s;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.r[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.u[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.t;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public void j() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 2) {
            int i3 = this.s - 1;
            this.s = i3;
            this.t[i3] = null;
            int[] iArr = this.u;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.n = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + Q() + x());
    }

    public boolean l() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final boolean m() {
        return this.f20158h;
    }

    public void n0() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.n;
            if (i3 == 0) {
                i3 = e();
            }
            if (i3 == 3) {
                Y(1);
            } else if (i3 == 1) {
                Y(3);
            } else {
                if (i3 == 4) {
                    this.s--;
                } else if (i3 == 2) {
                    this.s--;
                } else {
                    if (i3 == 14 || i3 == 10) {
                        m0();
                    } else if (i3 == 8 || i3 == 12) {
                        e0('\'');
                    } else if (i3 == 9 || i3 == 13) {
                        e0('\"');
                    } else if (i3 == 16) {
                        this.f20160j += this.p;
                    }
                    this.n = 0;
                }
                i2--;
                this.n = 0;
            }
            i2++;
            this.n = 0;
        } while (i2 != 0);
        int[] iArr = this.u;
        int i4 = this.s;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.t[i4 - 1] = "null";
    }

    public String toString() {
        return getClass().getSimpleName() + x();
    }

    String x() {
        return " at line " + (this.l + 1) + " column " + ((this.f20160j - this.m) + 1) + " path " + g();
    }

    public boolean y() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 5) {
            this.n = 0;
            int[] iArr = this.u;
            int i3 = this.s - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (i2 == 6) {
            this.n = 0;
            int[] iArr2 = this.u;
            int i4 = this.s - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + Q() + x());
    }

    public double z() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            this.n = 0;
            int[] iArr = this.u;
            int i3 = this.s - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.o;
        }
        if (i2 == 16) {
            this.q = new String(this.f20159i, this.f20160j, this.p);
            this.f20160j += this.p;
        } else if (i2 == 8 || i2 == 9) {
            this.q = J(i2 == 8 ? '\'' : '\"');
        } else if (i2 == 10) {
            this.q = N();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + Q() + x());
        }
        this.n = 11;
        double parseDouble = Double.parseDouble(this.q);
        if (!this.f20158h && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + x());
        }
        this.q = null;
        this.n = 0;
        int[] iArr2 = this.u;
        int i4 = this.s - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return parseDouble;
    }
}
