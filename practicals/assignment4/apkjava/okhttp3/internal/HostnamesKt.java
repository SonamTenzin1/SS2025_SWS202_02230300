package okhttp3.internal;

import j.f;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.HttpUrl;

/* compiled from: hostnames.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u001a\u0013\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a7\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {HttpUrl.FRAGMENT_ENCODE_SET, "toCanonicalHost", "(Ljava/lang/String;)Ljava/lang/String;", HttpUrl.FRAGMENT_ENCODE_SET, "containsInvalidHostnameAsciiCodes", "(Ljava/lang/String;)Z", "input", HttpUrl.FRAGMENT_ENCODE_SET, "pos", "limit", "Ljava/net/InetAddress;", "decodeIpv6", "(Ljava/lang/String;II)Ljava/net/InetAddress;", HttpUrl.FRAGMENT_ENCODE_SET, "address", "addressOffset", "decodeIpv4Suffix", "(Ljava/lang/String;II[BI)Z", "inet6AddressToAscii", "([B)Ljava/lang/String;", "okhttp"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int V;
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (m.h(charAt, 31) <= 0 || m.h(charAt, 127) >= 0) {
                return true;
            }
            V = v.V(" #%/:?@[\\]", charAt, 0, false, 6, null);
            if (V != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (m.h(charAt, 48) < 0 || m.h(charAt, 57) > 0) {
                    break;
                }
                if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i6++;
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0097, code lost:
    
        if (r13 == 16) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0099, code lost:
    
        if (r14 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
    
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
    
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final InetAddress decodeIpv6(String str, int i2, int i3) {
        boolean D;
        boolean D2;
        int i4;
        boolean D3;
        byte[] bArr = new byte[16];
        int i5 = i2;
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        while (true) {
            if (i5 < i3) {
                if (i6 != 16) {
                    int i9 = i5 + 2;
                    if (i9 <= i3) {
                        D3 = u.D(str, "::", i5, false, 4, null);
                        if (D3) {
                            if (i7 != -1) {
                                return null;
                            }
                            i6 += 2;
                            if (i9 == i3) {
                                i7 = i6;
                                break;
                            }
                            i8 = i9;
                            i7 = i6;
                            i5 = i8;
                            int i10 = 0;
                            while (i5 < i3) {
                                int parseHexDigit = Util.parseHexDigit(str.charAt(i5));
                                if (parseHexDigit == -1) {
                                    break;
                                }
                                i10 = (i10 << 4) + parseHexDigit;
                                i5++;
                            }
                            i4 = i5 - i8;
                            if (i4 == 0 || i4 > 4) {
                                break;
                            }
                            int i11 = i6 + 1;
                            bArr[i6] = (byte) ((i10 >>> 8) & 255);
                            i6 = i11 + 1;
                            bArr[i11] = (byte) (i10 & 255);
                        }
                    }
                    if (i6 != 0) {
                        D = u.D(str, ":", i5, false, 4, null);
                        if (D) {
                            i5++;
                        } else {
                            D2 = u.D(str, ".", i5, false, 4, null);
                            if (!D2 || !decodeIpv4Suffix(str, i8, i3, bArr, i6 - 2)) {
                                return null;
                            }
                            i6 += 2;
                        }
                    }
                    i8 = i5;
                    i5 = i8;
                    int i102 = 0;
                    while (i5 < i3) {
                    }
                    i4 = i5 - i8;
                    if (i4 == 0) {
                        break;
                    }
                    break;
                }
                return null;
            }
            break;
        }
        return null;
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i3 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        f fVar = new f();
        while (i2 < bArr.length) {
            if (i2 == i3) {
                fVar.writeByte(58);
                i2 += i5;
                if (i2 == 16) {
                    fVar.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    fVar.writeByte(58);
                }
                fVar.C0((Util.and(bArr[i2], 255) << 8) | Util.and(bArr[i2 + 1], 255));
                i2 += 2;
            }
        }
        return fVar.T();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String toCanonicalHost(String str) {
        boolean J;
        boolean E;
        InetAddress decodeIpv6;
        boolean p;
        m.f(str, "$this$toCanonicalHost");
        J = v.J(str, ":", false, 2, null);
        if (J) {
            E = u.E(str, "[", false, 2, null);
            if (E) {
                p = u.p(str, "]", false, 2, null);
                if (p) {
                    decodeIpv6 = decodeIpv6(str, 1, str.length() - 1);
                    if (decodeIpv6 != null) {
                        return null;
                    }
                    byte[] address = decodeIpv6.getAddress();
                    if (address.length == 16) {
                        m.e(address, "address");
                        return inet6AddressToAscii(address);
                    }
                    if (address.length == 4) {
                        return decodeIpv6.getHostAddress();
                    }
                    throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
                }
            }
            decodeIpv6 = decodeIpv6(str, 0, str.length());
            if (decodeIpv6 != null) {
            }
        } else {
            try {
                String ascii = IDN.toASCII(str);
                m.e(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                m.e(locale, "Locale.US");
                if (ascii != null) {
                    String lowerCase = ascii.toLowerCase(locale);
                    m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (!(lowerCase.length() == 0) && !containsInvalidHostnameAsciiCodes(lowerCase)) {
                        return lowerCase;
                    }
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }
}
