package io.sentry.vendor.gson.stream;

import cm.aptoide.pt.account.AdultContentAnalytics;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: JsonReader.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public class a implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private final Reader f22784f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f22785g = false;

    /* renamed from: h, reason: collision with root package name */
    private final char[] f22786h = new char[1024];

    /* renamed from: i, reason: collision with root package name */
    private int f22787i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f22788j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f22789k = 0;
    private int l = 0;
    int m = 0;
    private long n;
    private int o;
    private String p;
    private int[] q;
    private int r;
    private String[] s;
    private int[] t;

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.q = iArr;
        this.r = 0;
        this.r = 0 + 1;
        iArr[0] = 6;
        this.s = new String[32];
        this.t = new int[32];
        if (reader != null) {
            this.f22784f = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private int D(boolean z) throws IOException {
        char[] cArr = this.f22786h;
        int i2 = this.f22787i;
        int i3 = this.f22788j;
        while (true) {
            if (i2 == i3) {
                this.f22787i = i2;
                if (!k(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + p());
                }
                i2 = this.f22787i;
                i3 = this.f22788j;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f22789k++;
                this.l = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f22787i = i4;
                    if (i4 == i3) {
                        this.f22787i = i4 - 1;
                        boolean k2 = k(2);
                        this.f22787i++;
                        if (!k2) {
                            return c2;
                        }
                    }
                    c();
                    int i5 = this.f22787i;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f22787i = i5 + 1;
                        if (a0("*/")) {
                            i2 = this.f22787i + 2;
                            i3 = this.f22788j;
                        } else {
                            throw m0("Unterminated comment");
                        }
                    } else {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.f22787i = i5 + 1;
                        e0();
                        i2 = this.f22787i;
                        i3 = this.f22788j;
                    }
                } else if (c2 == '#') {
                    this.f22787i = i4;
                    c();
                    e0();
                    i2 = this.f22787i;
                    i3 = this.f22788j;
                } else {
                    this.f22787i = i4;
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
        r9.f22787i = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String I(char c2) throws IOException {
        char[] cArr = this.f22786h;
        StringBuilder sb = null;
        do {
            int i2 = this.f22787i;
            int i3 = this.f22788j;
            while (true) {
                int i4 = i3;
                int i5 = i2;
                while (i2 < i4) {
                    int i6 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.f22787i = i6;
                        int i7 = (i6 - i5) - 1;
                        if (sb == null) {
                            return new String(cArr, i5, i7);
                        }
                        sb.append(cArr, i5, i7);
                        return sb.toString();
                    }
                    if (c3 == '\\') {
                        this.f22787i = i6;
                        int i8 = (i6 - i5) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i8 + 1) * 2, 16));
                        }
                        sb.append(cArr, i5, i8);
                        sb.append(Y());
                        i2 = this.f22787i;
                        i3 = this.f22788j;
                    } else {
                        if (c3 == '\n') {
                            this.f22789k++;
                            this.l = i6;
                        }
                        i2 = i6;
                    }
                }
                break;
            }
        } while (k(1));
        throw m0("Unterminated string");
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
    private String K() throws IOException {
        String sb;
        int i2 = 0;
        StringBuilder sb2 = null;
        do {
            int i3 = 0;
            while (true) {
                int i4 = this.f22787i;
                if (i4 + i3 < this.f22788j) {
                    char c2 = this.f22786h[i4 + i3];
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
                } else if (i3 < this.f22786h.length) {
                    if (k(i3 + 1)) {
                    }
                } else {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i3, 16));
                    }
                    sb2.append(this.f22786h, this.f22787i, i3);
                    this.f22787i += i3;
                }
            }
            i2 = i3;
            if (sb2 != null) {
                sb = new String(this.f22786h, this.f22787i, i2);
            } else {
                sb2.append(this.f22786h, this.f22787i, i2);
                sb = sb2.toString();
            }
            this.f22787i += i2;
            return sb;
        } while (k(1));
        if (sb2 != null) {
        }
        this.f22787i += i2;
        return sb;
    }

    private int Q() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f22786h[this.f22787i];
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
            if (this.f22787i + i3 >= this.f22788j && !k(i3 + 1)) {
                return 0;
            }
            char c3 = this.f22786h[this.f22787i + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f22787i + length < this.f22788j || k(length + 1)) && m(this.f22786h[this.f22787i + length])) {
            return 0;
        }
        this.f22787i += length;
        this.m = i2;
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
    
        r18.n = r11;
        r18.f22787i += r8;
        r18.m = 15;
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
    
        r18.o = r8;
        r18.m = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ce, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0097, code lost:
    
        if (m(r14) != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00cf, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int T() throws IOException {
        char[] cArr = this.f22786h;
        int i2 = this.f22787i;
        int i3 = this.f22788j;
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
                i2 = this.f22787i;
                i3 = this.f22788j;
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

    private void W(int i2) {
        int i3 = this.r;
        int[] iArr = this.q;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.q = Arrays.copyOf(iArr, i4);
            this.t = Arrays.copyOf(this.t, i4);
            this.s = (String[]) Arrays.copyOf(this.s, i4);
        }
        int[] iArr2 = this.q;
        int i5 = this.r;
        this.r = i5 + 1;
        iArr2[i5] = i2;
    }

    private char Y() throws IOException {
        int i2;
        int i3;
        if (this.f22787i == this.f22788j && !k(1)) {
            throw m0("Unterminated escape sequence");
        }
        char[] cArr = this.f22786h;
        int i4 = this.f22787i;
        int i5 = i4 + 1;
        this.f22787i = i5;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.f22789k++;
            this.l = i5;
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
                if (i5 + 4 > this.f22788j && !k(4)) {
                    throw m0("Unterminated escape sequence");
                }
                char c3 = 0;
                int i6 = this.f22787i;
                int i7 = i6 + 4;
                while (i6 < i7) {
                    char c4 = this.f22786h[i6];
                    char c5 = (char) (c3 << 4);
                    if (c4 < '0' || c4 > '9') {
                        if (c4 >= 'a' && c4 <= 'f') {
                            i2 = c4 - 'a';
                        } else {
                            if (c4 < 'A' || c4 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f22786h, this.f22787i, 4));
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
                this.f22787i += 4;
                return c3;
            }
            throw m0("Invalid escape sequence");
        }
        return c2;
    }

    private void Z(char c2) throws IOException {
        char[] cArr = this.f22786h;
        do {
            int i2 = this.f22787i;
            int i3 = this.f22788j;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f22787i = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f22787i = i4;
                    Y();
                    i2 = this.f22787i;
                    i3 = this.f22788j;
                } else {
                    if (c3 == '\n') {
                        this.f22789k++;
                        this.l = i4;
                    }
                    i2 = i4;
                }
            }
            this.f22787i = i2;
        } while (k(1));
        throw m0("Unterminated string");
    }

    private boolean a0(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f22787i + length > this.f22788j && !k(length)) {
                return false;
            }
            char[] cArr = this.f22786h;
            int i2 = this.f22787i;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f22786h[this.f22787i + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f22789k++;
            this.l = i2 + 1;
            this.f22787i++;
        }
    }

    private void c() throws IOException {
        if (!this.f22785g) {
            throw m0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void d() throws IOException {
        D(true);
        int i2 = this.f22787i - 1;
        this.f22787i = i2;
        if (i2 + 5 <= this.f22788j || k(5)) {
            char[] cArr = this.f22786h;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.f22787i += 5;
            }
        }
    }

    private void e0() throws IOException {
        char c2;
        do {
            if (this.f22787i >= this.f22788j && !k(1)) {
                return;
            }
            char[] cArr = this.f22786h;
            int i2 = this.f22787i;
            int i3 = i2 + 1;
            this.f22787i = i3;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.f22789k++;
                this.l = i3;
                return;
            }
        } while (c2 != '\r');
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
    private void f0() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f22787i
            int r2 = r1 + r0
            int r3 = r4.f22788j
            if (r2 >= r3) goto L51
            char[] r2 = r4.f22786h
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
            int r1 = r4.f22787i
            int r1 = r1 + r0
            r4.f22787i = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f22787i = r1
            r0 = 1
            boolean r0 = r4.k(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.f0():void");
    }

    private boolean k(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.f22786h;
        int i5 = this.l;
        int i6 = this.f22787i;
        this.l = i5 - i6;
        int i7 = this.f22788j;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f22788j = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f22788j = 0;
        }
        this.f22787i = 0;
        do {
            Reader reader = this.f22784f;
            int i9 = this.f22788j;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.f22788j + read;
            this.f22788j = i3;
            if (this.f22789k == 0 && (i4 = this.l) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f22787i++;
                this.l = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    private boolean m(char c2) throws IOException {
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

    private IOException m0(String str) throws IOException {
        throw new MalformedJsonException(str + p());
    }

    public long A() throws IOException {
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            this.m = 0;
            int[] iArr = this.t;
            int i3 = this.r - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.n;
        }
        if (i2 == 16) {
            this.p = new String(this.f22786h, this.f22787i, this.o);
            this.f22787i += this.o;
        } else {
            if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected a long but was " + N() + p());
            }
            if (i2 == 10) {
                this.p = K();
            } else {
                this.p = I(i2 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.p);
                this.m = 0;
                int[] iArr2 = this.t;
                int i4 = this.r - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.m = 11;
        double parseDouble = Double.parseDouble(this.p);
        long j2 = (long) parseDouble;
        if (j2 == parseDouble) {
            this.p = null;
            this.m = 0;
            int[] iArr3 = this.t;
            int i5 = this.r - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.p + p());
    }

    public String B() throws IOException {
        String I;
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 14) {
            I = K();
        } else if (i2 == 12) {
            I = I('\'');
        } else if (i2 == 13) {
            I = I('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + N() + p());
        }
        this.m = 0;
        this.s[this.r - 1] = I;
        return I;
    }

    public void H() throws IOException {
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 7) {
            this.m = 0;
            int[] iArr = this.t;
            int i3 = this.r - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + N() + p());
    }

    public String J() throws IOException {
        String str;
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 10) {
            str = K();
        } else if (i2 == 8) {
            str = I('\'');
        } else if (i2 == 9) {
            str = I('\"');
        } else if (i2 == 11) {
            str = this.p;
            this.p = null;
        } else if (i2 == 15) {
            str = Long.toString(this.n);
        } else if (i2 == 16) {
            str = new String(this.f22786h, this.f22787i, this.o);
            this.f22787i += this.o;
        } else {
            throw new IllegalStateException("Expected a string but was " + N() + p());
        }
        this.m = 0;
        int[] iArr = this.t;
        int i3 = this.r - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public b N() throws IOException {
        int i2 = this.m;
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
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 3) {
            W(1);
            this.t[this.r - 1] = 0;
            this.m = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + N() + p());
        }
    }

    public void b() throws IOException {
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 1) {
            W(3);
            this.m = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + N() + p());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.m = 0;
        this.q[0] = 8;
        this.r = 1;
        this.f22784f.close();
    }

    int e() throws IOException {
        int D;
        int[] iArr = this.q;
        int i2 = this.r;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int D2 = D(true);
            if (D2 != 44) {
                if (D2 != 59) {
                    if (D2 == 93) {
                        this.m = 4;
                        return 4;
                    }
                    throw m0("Unterminated array");
                }
                c();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5 && (D = D(true)) != 44) {
                    if (D != 59) {
                        if (D == 125) {
                            this.m = 2;
                            return 2;
                        }
                        throw m0("Unterminated object");
                    }
                    c();
                }
                int D3 = D(true);
                if (D3 == 34) {
                    this.m = 13;
                    return 13;
                }
                if (D3 == 39) {
                    c();
                    this.m = 12;
                    return 12;
                }
                if (D3 == 125) {
                    if (i3 != 5) {
                        this.m = 2;
                        return 2;
                    }
                    throw m0("Expected name");
                }
                c();
                this.f22787i--;
                if (m((char) D3)) {
                    this.m = 14;
                    return 14;
                }
                throw m0("Expected name");
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int D4 = D(true);
                if (D4 != 58) {
                    if (D4 == 61) {
                        c();
                        if (this.f22787i < this.f22788j || k(1)) {
                            char[] cArr = this.f22786h;
                            int i4 = this.f22787i;
                            if (cArr[i4] == '>') {
                                this.f22787i = i4 + 1;
                            }
                        }
                    } else {
                        throw m0("Expected ':'");
                    }
                }
            } else if (i3 == 6) {
                if (this.f22785g) {
                    d();
                }
                this.q[this.r - 1] = 7;
            } else if (i3 == 7) {
                if (D(false) == -1) {
                    this.m = 17;
                    return 17;
                }
                c();
                this.f22787i--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int D5 = D(true);
        if (D5 == 34) {
            this.m = 9;
            return 9;
        }
        if (D5 == 39) {
            c();
            this.m = 8;
            return 8;
        }
        if (D5 != 44 && D5 != 59) {
            if (D5 == 91) {
                this.m = 3;
                return 3;
            }
            if (D5 != 93) {
                if (D5 != 123) {
                    this.f22787i--;
                    int Q = Q();
                    if (Q != 0) {
                        return Q;
                    }
                    int T = T();
                    if (T != 0) {
                        return T;
                    }
                    if (m(this.f22786h[this.f22787i])) {
                        c();
                        this.m = 10;
                        return 10;
                    }
                    throw m0("Expected value");
                }
                this.m = 1;
                return 1;
            }
            if (i3 == 1) {
                this.m = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw m0("Unexpected value");
        }
        c();
        this.f22787i--;
        this.m = 7;
        return 7;
    }

    public void f() throws IOException {
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 4) {
            int i3 = this.r - 1;
            this.r = i3;
            int[] iArr = this.t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.m = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + N() + p());
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.r;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.q[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.t[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.s;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public void i0() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.m;
            if (i3 == 0) {
                i3 = e();
            }
            if (i3 == 3) {
                W(1);
            } else if (i3 == 1) {
                W(3);
            } else {
                if (i3 == 4) {
                    this.r--;
                } else if (i3 == 2) {
                    this.r--;
                } else {
                    if (i3 == 14 || i3 == 10) {
                        f0();
                    } else if (i3 == 8 || i3 == 12) {
                        Z('\'');
                    } else if (i3 == 9 || i3 == 13) {
                        Z('\"');
                    } else if (i3 == 16) {
                        this.f22787i += this.o;
                    }
                    this.m = 0;
                }
                i2--;
                this.m = 0;
            }
            i2++;
            this.m = 0;
        } while (i2 != 0);
        int[] iArr = this.t;
        int i4 = this.r;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.s[i4 - 1] = "null";
    }

    public void j() throws IOException {
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 2) {
            int i3 = this.r - 1;
            this.r = i3;
            this.s[i3] = null;
            int[] iArr = this.t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.m = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + N() + p());
    }

    public boolean l() throws IOException {
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    String p() {
        return " at line " + (this.f22789k + 1) + " column " + ((this.f22787i - this.l) + 1) + " path " + g();
    }

    public String toString() {
        return getClass().getSimpleName() + p();
    }

    public boolean x() throws IOException {
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 5) {
            this.m = 0;
            int[] iArr = this.t;
            int i3 = this.r - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (i2 == 6) {
            this.m = 0;
            int[] iArr2 = this.t;
            int i4 = this.r - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + N() + p());
    }

    public double y() throws IOException {
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            this.m = 0;
            int[] iArr = this.t;
            int i3 = this.r - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.n;
        }
        if (i2 == 16) {
            this.p = new String(this.f22786h, this.f22787i, this.o);
            this.f22787i += this.o;
        } else if (i2 == 8 || i2 == 9) {
            this.p = I(i2 == 8 ? '\'' : '\"');
        } else if (i2 == 10) {
            this.p = K();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + N() + p());
        }
        this.m = 11;
        double parseDouble = Double.parseDouble(this.p);
        if (!this.f22785g && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + p());
        }
        this.p = null;
        this.m = 0;
        int[] iArr2 = this.t;
        int i4 = this.r - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return parseDouble;
    }

    public int z() throws IOException {
        int i2 = this.m;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            long j2 = this.n;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.m = 0;
                int[] iArr = this.t;
                int i4 = this.r - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.n + p());
        }
        if (i2 == 16) {
            this.p = new String(this.f22786h, this.f22787i, this.o);
            this.f22787i += this.o;
        } else {
            if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected an int but was " + N() + p());
            }
            if (i2 == 10) {
                this.p = K();
            } else {
                this.p = I(i2 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.p);
                this.m = 0;
                int[] iArr2 = this.t;
                int i5 = this.r - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.m = 11;
        double parseDouble = Double.parseDouble(this.p);
        int i6 = (int) parseDouble;
        if (i6 == parseDouble) {
            this.p = null;
            this.m = 0;
            int[] iArr3 = this.t;
            int i7 = this.r - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.p + p());
    }
}
