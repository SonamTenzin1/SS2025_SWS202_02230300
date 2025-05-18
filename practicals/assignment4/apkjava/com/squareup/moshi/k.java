package com.squareup.moshi;

import cm.aptoide.pt.account.AdultContentAnalytics;
import com.squareup.moshi.i;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes2.dex */
public final class k extends i {
    private static final j.i l = j.i.v("'\\");
    private static final j.i m = j.i.v("\"\\");
    private static final j.i n = j.i.v("{}[]:, \n\t\r\f/\\;#=");
    private static final j.i o = j.i.v("\n\r");
    private static final j.i p = j.i.v("*/");
    private final j.h q;
    private final j.f r;
    private int s = 0;
    private long t;
    private int u;
    private String v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j.h hVar) {
        if (hVar != null) {
            this.q = hVar;
            this.r = hVar.i();
            D(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private boolean E0() throws IOException {
        long P = this.q.P(p);
        boolean z = P != -1;
        j.f fVar = this.r;
        fVar.skip(z ? P + r1.P() : fVar.size());
        return z;
    }

    private void F0() throws IOException {
        long b0 = this.q.b0(o);
        j.f fVar = this.r;
        fVar.skip(b0 != -1 ? b0 + 1 : fVar.size());
    }

    private void G0() throws IOException {
        long b0 = this.q.b0(n);
        j.f fVar = this.r;
        if (b0 == -1) {
            b0 = fVar.size();
        }
        fVar.skip(b0);
    }

    private void Y() throws IOException {
        if (!this.f20560j) {
            throw T("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int Z() throws IOException {
        int[] iArr = this.f20557g;
        int i2 = this.f20556f;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int m0 = m0(true);
            this.r.readByte();
            if (m0 != 44) {
                if (m0 != 59) {
                    if (m0 == 93) {
                        this.s = 4;
                        return 4;
                    }
                    throw T("Unterminated array");
                }
                Y();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5) {
                    int m02 = m0(true);
                    this.r.readByte();
                    if (m02 != 44) {
                        if (m02 != 59) {
                            if (m02 == 125) {
                                this.s = 2;
                                return 2;
                            }
                            throw T("Unterminated object");
                        }
                        Y();
                    }
                }
                int m03 = m0(true);
                if (m03 == 34) {
                    this.r.readByte();
                    this.s = 13;
                    return 13;
                }
                if (m03 == 39) {
                    this.r.readByte();
                    Y();
                    this.s = 12;
                    return 12;
                }
                if (m03 != 125) {
                    Y();
                    if (f0((char) m03)) {
                        this.s = 14;
                        return 14;
                    }
                    throw T("Expected name");
                }
                if (i3 != 5) {
                    this.r.readByte();
                    this.s = 2;
                    return 2;
                }
                throw T("Expected name");
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int m04 = m0(true);
                this.r.readByte();
                if (m04 != 58) {
                    if (m04 == 61) {
                        Y();
                        if (this.q.request(1L) && this.r.m(0L) == 62) {
                            this.r.readByte();
                        }
                    } else {
                        throw T("Expected ':'");
                    }
                }
            } else if (i3 == 6) {
                iArr[i2 - 1] = 7;
            } else if (i3 == 7) {
                if (m0(false) == -1) {
                    this.s = 18;
                    return 18;
                }
                Y();
            } else {
                if (i3 == 9) {
                    throw null;
                }
                if (i3 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
            }
        }
        int m05 = m0(true);
        if (m05 == 34) {
            this.r.readByte();
            this.s = 9;
            return 9;
        }
        if (m05 == 39) {
            Y();
            this.r.readByte();
            this.s = 8;
            return 8;
        }
        if (m05 != 44 && m05 != 59) {
            if (m05 == 91) {
                this.r.readByte();
                this.s = 3;
                return 3;
            }
            if (m05 != 93) {
                if (m05 != 123) {
                    int q0 = q0();
                    if (q0 != 0) {
                        return q0;
                    }
                    int t0 = t0();
                    if (t0 != 0) {
                        return t0;
                    }
                    if (f0(this.r.m(0L))) {
                        Y();
                        this.s = 10;
                        return 10;
                    }
                    throw T("Expected value");
                }
                this.r.readByte();
                this.s = 1;
                return 1;
            }
            if (i3 == 1) {
                this.r.readByte();
                this.s = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw T("Unexpected value");
        }
        Y();
        this.s = 7;
        return 7;
    }

    private int a0(String str, i.a aVar) {
        int length = aVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.a[i2])) {
                this.s = 0;
                this.f20558h[this.f20556f - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    private int e0(String str, i.a aVar) {
        int length = aVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.a[i2])) {
                this.s = 0;
                int[] iArr = this.f20559i;
                int i3 = this.f20556f - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
        }
        return -1;
    }

    private boolean f0(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        Y();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.r.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r1 != 47) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
    
        if (r1 != 35) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
        Y();
        F0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r6.q.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003c, code lost:
    
        Y();
        r3 = r6.r.m(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        if (r3 == 42) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        r6.r.readByte();
        r6.r.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
    
        if (E0() == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
    
        throw T("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004b, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
    
        r6.r.readByte();
        r6.r.readByte();
        F0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x003b, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int m0(boolean z) throws IOException {
        while (true) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (!this.q.request(i3)) {
                    if (z) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                byte m2 = this.r.m(i2);
                if (m2 != 10 && m2 != 32 && m2 != 13 && m2 != 9) {
                    break;
                }
                i2 = i3;
            }
        }
    }

    private String n0(j.i iVar) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long b0 = this.q.b0(iVar);
            if (b0 != -1) {
                if (this.r.m(b0) != 92) {
                    if (sb == null) {
                        String Z = this.r.Z(b0);
                        this.r.readByte();
                        return Z;
                    }
                    sb.append(this.r.Z(b0));
                    this.r.readByte();
                    return sb.toString();
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.r.Z(b0));
                this.r.readByte();
                sb.append(x0());
            } else {
                throw T("Unterminated string");
            }
        }
    }

    private String p0() throws IOException {
        long b0 = this.q.b0(n);
        return b0 != -1 ? this.r.Z(b0) : this.r.T();
    }

    private int q0() throws IOException {
        int i2;
        String str;
        String str2;
        byte m2 = this.r.m(0L);
        if (m2 == 116 || m2 == 84) {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (m2 == 102 || m2 == 70) {
            i2 = 6;
            str = AdultContentAnalytics.UNLOCK;
            str2 = "FALSE";
        } else {
            if (m2 != 110 && m2 != 78) {
                return 0;
            }
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.q.request(i4)) {
                return 0;
            }
            byte m3 = this.r.m(i3);
            if (m3 != str.charAt(i3) && m3 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.q.request(length + 1) && f0(this.r.m(length))) {
            return 0;
        }
        this.r.skip(length);
        this.s = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0089, code lost:
    
        if (f0(r11) != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008b, code lost:
    
        if (r6 != 2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008d, code lost:
    
        if (r7 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
    
        if (r10 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0099, code lost:
    
        if (r8 != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009b, code lost:
    
        if (r10 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x009d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a0, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a1, code lost:
    
        r16.t = r8;
        r16.r.skip(r5);
        r16.s = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ad, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ae, code lost:
    
        if (r6 == 2) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b1, code lost:
    
        if (r6 == 4) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b4, code lost:
    
        if (r6 != 7) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b7, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b9, code lost:
    
        r16.u = r5;
        r16.s = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bf, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c0, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int t0() throws IOException {
        boolean z = true;
        int i2 = 0;
        long j2 = 0;
        int i3 = 0;
        char c2 = 0;
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            int i4 = i3 + 1;
            if (!this.q.request(i4)) {
                break;
            }
            byte m2 = this.r.m(i3);
            if (m2 != 43) {
                if (m2 == 69 || m2 == 101) {
                    if (c2 != 2 && c2 != 4) {
                        return i2;
                    }
                    c2 = 5;
                } else if (m2 != 45) {
                    if (m2 != 46) {
                        if (m2 < 48 || m2 > 57) {
                            break;
                        }
                        if (c2 == z || c2 == 0) {
                            j2 = -(m2 - 48);
                            i2 = 0;
                            c2 = 2;
                        } else {
                            if (c2 == 2) {
                                if (j2 == 0) {
                                    return i2;
                                }
                                long j3 = (10 * j2) - (m2 - 48);
                                z2 &= j2 > -922337203685477580L || (j2 == -922337203685477580L && j3 < j2);
                                j2 = j3;
                            } else if (c2 == 3) {
                                i2 = 0;
                                c2 = 4;
                            } else if (c2 == 5 || c2 == 6) {
                                i2 = 0;
                                c2 = 7;
                            }
                            i2 = 0;
                        }
                    } else {
                        if (c2 != 2) {
                            return i2;
                        }
                        c2 = 3;
                    }
                } else if (c2 == 0) {
                    c2 = 1;
                    z3 = true;
                } else if (c2 != 5) {
                    return i2;
                }
                i3 = i4;
                z = true;
            } else if (c2 != 5) {
                return i2;
            }
            c2 = 6;
            i3 = i4;
            z = true;
        }
    }

    private char x0() throws IOException {
        int i2;
        int i3;
        if (this.q.request(1L)) {
            byte readByte = this.r.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return '\b';
            }
            if (readByte == 102) {
                return '\f';
            }
            if (readByte == 110) {
                return '\n';
            }
            if (readByte == 114) {
                return '\r';
            }
            if (readByte == 116) {
                return '\t';
            }
            if (readByte != 117) {
                if (this.f20560j) {
                    return (char) readByte;
                }
                throw T("Invalid escape sequence: \\" + ((char) readByte));
            }
            if (this.q.request(4L)) {
                char c2 = 0;
                for (int i4 = 0; i4 < 4; i4++) {
                    byte m2 = this.r.m(i4);
                    char c3 = (char) (c2 << 4);
                    if (m2 < 48 || m2 > 57) {
                        if (m2 >= 97 && m2 <= 102) {
                            i2 = m2 - 97;
                        } else {
                            if (m2 < 65 || m2 > 70) {
                                throw T("\\u" + this.r.Z(4L));
                            }
                            i2 = m2 - 65;
                        }
                        i3 = i2 + 10;
                    } else {
                        i3 = m2 - 48;
                    }
                    c2 = (char) (c3 + i3);
                }
                this.r.skip(4L);
                return c2;
            }
            throw new EOFException("Unterminated escape sequence at path " + g());
        }
        throw T("Unterminated escape sequence");
    }

    private void y0(j.i iVar) throws IOException {
        while (true) {
            long b0 = this.q.b0(iVar);
            if (b0 != -1) {
                if (this.r.m(b0) == 92) {
                    this.r.skip(b0 + 1);
                    x0();
                } else {
                    this.r.skip(b0 + 1);
                    return;
                }
            } else {
                throw T("Unterminated string");
            }
        }
    }

    @Override // com.squareup.moshi.i
    public i.b A() throws IOException {
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        switch (i2) {
            case 1:
                return i.b.BEGIN_OBJECT;
            case 2:
                return i.b.END_OBJECT;
            case 3:
                return i.b.BEGIN_ARRAY;
            case 4:
                return i.b.END_ARRAY;
            case 5:
            case 6:
                return i.b.BOOLEAN;
            case 7:
                return i.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return i.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return i.b.NAME;
            case 16:
            case 17:
                return i.b.NUMBER;
            case 18:
                return i.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.squareup.moshi.i
    public void B() throws IOException {
        if (f()) {
            this.v = i0();
            this.s = 11;
        }
    }

    @Override // com.squareup.moshi.i
    public int H(i.a aVar) throws IOException {
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 < 12 || i2 > 15) {
            return -1;
        }
        if (i2 == 15) {
            return a0(this.v, aVar);
        }
        int p1 = this.q.p1(aVar.f20562b);
        if (p1 != -1) {
            this.s = 0;
            this.f20558h[this.f20556f - 1] = aVar.a[p1];
            return p1;
        }
        String str = this.f20558h[this.f20556f - 1];
        String i0 = i0();
        int a0 = a0(i0, aVar);
        if (a0 == -1) {
            this.s = 15;
            this.v = i0;
            this.f20558h[this.f20556f - 1] = str;
        }
        return a0;
    }

    @Override // com.squareup.moshi.i
    public int I(i.a aVar) throws IOException {
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 < 8 || i2 > 11) {
            return -1;
        }
        if (i2 == 11) {
            return e0(this.v, aVar);
        }
        int p1 = this.q.p1(aVar.f20562b);
        if (p1 != -1) {
            this.s = 0;
            int[] iArr = this.f20559i;
            int i3 = this.f20556f - 1;
            iArr[i3] = iArr[i3] + 1;
            return p1;
        }
        String y = y();
        int e0 = e0(y, aVar);
        if (e0 == -1) {
            this.s = 11;
            this.v = y;
            this.f20559i[this.f20556f - 1] = r0[r1] - 1;
        }
        return e0;
    }

    @Override // com.squareup.moshi.i
    public void N() throws IOException {
        if (!this.f20561k) {
            int i2 = this.s;
            if (i2 == 0) {
                i2 = Z();
            }
            if (i2 == 14) {
                G0();
            } else if (i2 == 13) {
                y0(m);
            } else if (i2 == 12) {
                y0(l);
            } else if (i2 != 15) {
                throw new JsonDataException("Expected a name but was " + A() + " at path " + g());
            }
            this.s = 0;
            this.f20558h[this.f20556f - 1] = "null";
            return;
        }
        i.b A = A();
        i0();
        throw new JsonDataException("Cannot skip unexpected " + A + " at " + g());
    }

    @Override // com.squareup.moshi.i
    public void Q() throws IOException {
        if (!this.f20561k) {
            int i2 = 0;
            do {
                int i3 = this.s;
                if (i3 == 0) {
                    i3 = Z();
                }
                if (i3 == 3) {
                    D(1);
                } else if (i3 == 1) {
                    D(3);
                } else {
                    if (i3 == 4) {
                        i2--;
                        if (i2 >= 0) {
                            this.f20556f--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + A() + " at path " + g());
                        }
                    } else if (i3 == 2) {
                        i2--;
                        if (i2 >= 0) {
                            this.f20556f--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + A() + " at path " + g());
                        }
                    } else if (i3 == 14 || i3 == 10) {
                        G0();
                    } else if (i3 == 9 || i3 == 13) {
                        y0(m);
                    } else if (i3 == 8 || i3 == 12) {
                        y0(l);
                    } else if (i3 == 17) {
                        this.r.skip(this.u);
                    } else if (i3 == 18) {
                        throw new JsonDataException("Expected a value but was " + A() + " at path " + g());
                    }
                    this.s = 0;
                }
                i2++;
                this.s = 0;
            } while (i2 != 0);
            int[] iArr = this.f20559i;
            int i4 = this.f20556f;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
            this.f20558h[i4 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + A() + " at " + g());
    }

    @Override // com.squareup.moshi.i
    public void a() throws IOException {
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 3) {
            D(1);
            this.f20559i[this.f20556f - 1] = 0;
            this.s = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + A() + " at path " + g());
        }
    }

    @Override // com.squareup.moshi.i
    public void b() throws IOException {
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 1) {
            D(3);
            this.s = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + A() + " at path " + g());
    }

    @Override // com.squareup.moshi.i
    public void c() throws IOException {
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 4) {
            int i3 = this.f20556f - 1;
            this.f20556f = i3;
            int[] iArr = this.f20559i;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.s = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + A() + " at path " + g());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.s = 0;
        this.f20557g[0] = 8;
        this.f20556f = 1;
        this.r.b();
        this.q.close();
    }

    @Override // com.squareup.moshi.i
    public void d() throws IOException {
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 2) {
            int i3 = this.f20556f - 1;
            this.f20556f = i3;
            this.f20558h[i3] = null;
            int[] iArr = this.f20559i;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.s = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + A() + " at path " + g());
    }

    @Override // com.squareup.moshi.i
    public boolean f() throws IOException {
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        return (i2 == 2 || i2 == 4 || i2 == 18) ? false : true;
    }

    public String i0() throws IOException {
        String str;
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 14) {
            str = p0();
        } else if (i2 == 13) {
            str = n0(m);
        } else if (i2 == 12) {
            str = n0(l);
        } else if (i2 == 15) {
            str = this.v;
            this.v = null;
        } else {
            throw new JsonDataException("Expected a name but was " + A() + " at path " + g());
        }
        this.s = 0;
        this.f20558h[this.f20556f - 1] = str;
        return str;
    }

    @Override // com.squareup.moshi.i
    public boolean k() throws IOException {
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 5) {
            this.s = 0;
            int[] iArr = this.f20559i;
            int i3 = this.f20556f - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (i2 == 6) {
            this.s = 0;
            int[] iArr2 = this.f20559i;
            int i4 = this.f20556f - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + A() + " at path " + g());
    }

    @Override // com.squareup.moshi.i
    public double l() throws IOException {
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 16) {
            this.s = 0;
            int[] iArr = this.f20559i;
            int i3 = this.f20556f - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.t;
        }
        if (i2 == 17) {
            this.v = this.r.Z(this.u);
        } else if (i2 == 9) {
            this.v = n0(m);
        } else if (i2 == 8) {
            this.v = n0(l);
        } else if (i2 == 10) {
            this.v = p0();
        } else if (i2 != 11) {
            throw new JsonDataException("Expected a double but was " + A() + " at path " + g());
        }
        this.s = 11;
        try {
            double parseDouble = Double.parseDouble(this.v);
            if (!this.f20560j && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + g());
            }
            this.v = null;
            this.s = 0;
            int[] iArr2 = this.f20559i;
            int i4 = this.f20556f - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.v + " at path " + g());
        }
    }

    @Override // com.squareup.moshi.i
    public int m() throws IOException {
        String n0;
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 16) {
            long j2 = this.t;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.s = 0;
                int[] iArr = this.f20559i;
                int i4 = this.f20556f - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new JsonDataException("Expected an int but was " + this.t + " at path " + g());
        }
        if (i2 == 17) {
            this.v = this.r.Z(this.u);
        } else if (i2 == 9 || i2 == 8) {
            if (i2 == 9) {
                n0 = n0(m);
            } else {
                n0 = n0(l);
            }
            this.v = n0;
            try {
                int parseInt = Integer.parseInt(n0);
                this.s = 0;
                int[] iArr2 = this.f20559i;
                int i5 = this.f20556f - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i2 != 11) {
            throw new JsonDataException("Expected an int but was " + A() + " at path " + g());
        }
        this.s = 11;
        try {
            double parseDouble = Double.parseDouble(this.v);
            int i6 = (int) parseDouble;
            if (i6 == parseDouble) {
                this.v = null;
                this.s = 0;
                int[] iArr3 = this.f20559i;
                int i7 = this.f20556f - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new JsonDataException("Expected an int but was " + this.v + " at path " + g());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.v + " at path " + g());
        }
    }

    @Override // com.squareup.moshi.i
    public long p() throws IOException {
        String n0;
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 16) {
            this.s = 0;
            int[] iArr = this.f20559i;
            int i3 = this.f20556f - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.t;
        }
        if (i2 == 17) {
            this.v = this.r.Z(this.u);
        } else if (i2 == 9 || i2 == 8) {
            if (i2 == 9) {
                n0 = n0(m);
            } else {
                n0 = n0(l);
            }
            this.v = n0;
            try {
                long parseLong = Long.parseLong(n0);
                this.s = 0;
                int[] iArr2 = this.f20559i;
                int i4 = this.f20556f - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else if (i2 != 11) {
            throw new JsonDataException("Expected a long but was " + A() + " at path " + g());
        }
        this.s = 11;
        try {
            long longValueExact = new BigDecimal(this.v).longValueExact();
            this.v = null;
            this.s = 0;
            int[] iArr3 = this.f20559i;
            int i5 = this.f20556f - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return longValueExact;
        } catch (ArithmeticException | NumberFormatException unused2) {
            throw new JsonDataException("Expected a long but was " + this.v + " at path " + g());
        }
    }

    public String toString() {
        return "JsonReader(" + this.q + ")";
    }

    @Override // com.squareup.moshi.i
    public <T> T x() throws IOException {
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 7) {
            this.s = 0;
            int[] iArr = this.f20559i;
            int i3 = this.f20556f - 1;
            iArr[i3] = iArr[i3] + 1;
            return null;
        }
        throw new JsonDataException("Expected null but was " + A() + " at path " + g());
    }

    @Override // com.squareup.moshi.i
    public String y() throws IOException {
        String Z;
        int i2 = this.s;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 10) {
            Z = p0();
        } else if (i2 == 9) {
            Z = n0(m);
        } else if (i2 == 8) {
            Z = n0(l);
        } else if (i2 == 11) {
            Z = this.v;
            this.v = null;
        } else if (i2 == 16) {
            Z = Long.toString(this.t);
        } else if (i2 == 17) {
            Z = this.r.Z(this.u);
        } else {
            throw new JsonDataException("Expected a string but was " + A() + " at path " + g());
        }
        this.s = 0;
        int[] iArr = this.f20559i;
        int i3 = this.f20556f - 1;
        iArr[i3] = iArr[i3] + 1;
        return Z;
    }
}
