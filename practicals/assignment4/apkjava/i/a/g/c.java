package i.a.g;

import com.google.android.gms.ads.AdRequest;
import i.a.g.h;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.HttpUrl;

/* compiled from: DNSIncoming.java */
/* loaded from: classes2.dex */
public final class c extends e {

    /* renamed from: h, reason: collision with root package name */
    private static k.b.b f21758h = k.b.c.i(c.class.getName());

    /* renamed from: i, reason: collision with root package name */
    public static boolean f21759i = true;

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f21760j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: k, reason: collision with root package name */
    private final DatagramPacket f21761k;
    private final long l;
    private final b m;
    private int n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DNSIncoming.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f21762b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f21763c;

        static {
            int[] iArr = new int[i.a.g.s.e.values().length];
            f21763c = iArr;
            try {
                iArr[i.a.g.s.e.TYPE_A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_AAAA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_CNAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_PTR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_TXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_SRV.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_HINFO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_OPT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[i.a.g.s.c.values().length];
            f21762b = iArr2;
            try {
                iArr2[i.a.g.s.c.Owner.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f21762b[i.a.g.s.c.LLQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f21762b[i.a.g.s.c.NSID.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f21762b[i.a.g.s.c.UL.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f21762b[i.a.g.s.c.Unknown.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr3 = new int[i.a.g.s.b.values().length];
            a = iArr3;
            try {
                iArr3[i.a.g.s.b.Standard.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[i.a.g.s.b.Compressed.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[i.a.g.s.b.Extended.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[i.a.g.s.b.Unknown.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* compiled from: DNSIncoming.java */
    /* loaded from: classes2.dex */
    public static class b extends ByteArrayInputStream {

        /* renamed from: f, reason: collision with root package name */
        private static k.b.b f21764f = k.b.c.i(b.class.getName());

        /* renamed from: g, reason: collision with root package name */
        final Map<Integer, String> f21765g;

        public b(byte[] bArr, int i2) {
            this(bArr, 0, i2);
        }

        public byte[] a(int i2) {
            byte[] bArr = new byte[i2];
            read(bArr, 0, i2);
            return bArr;
        }

        public String b() {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            while (!z) {
                int e2 = e();
                if (e2 == 0) {
                    break;
                }
                int i2 = a.a[i.a.g.s.b.k(e2).ordinal()];
                if (i2 == 1) {
                    int i3 = ((ByteArrayInputStream) this).pos - 1;
                    String str = d(e2) + ".";
                    sb.append(str);
                    Iterator it = hashMap.values().iterator();
                    while (it.hasNext()) {
                        ((StringBuilder) it.next()).append(str);
                    }
                    hashMap.put(Integer.valueOf(i3), new StringBuilder(str));
                } else if (i2 == 2) {
                    int q = (i.a.g.s.b.q(e2) << 8) | e();
                    String str2 = this.f21765g.get(Integer.valueOf(q));
                    if (str2 == null) {
                        f21764f.h("bad domain name: possible circular name detected. Bad offset: 0x" + Integer.toHexString(q) + " at 0x" + Integer.toHexString(((ByteArrayInputStream) this).pos - 2));
                        str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                    }
                    sb.append(str2);
                    Iterator it2 = hashMap.values().iterator();
                    while (it2.hasNext()) {
                        ((StringBuilder) it2.next()).append(str2);
                    }
                    z = true;
                } else if (i2 != 3) {
                    f21764f.h("unsupported dns label type: '" + Integer.toHexString(e2 & 192) + "'");
                } else {
                    f21764f.c("Extended label are not currently supported.");
                }
            }
            for (Integer num : hashMap.keySet()) {
                this.f21765g.put(num, ((StringBuilder) hashMap.get(num)).toString());
            }
            return sb.toString();
        }

        public String c() {
            return d(e());
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000e. Please report as an issue. */
        public String d(int i2) {
            int i3;
            int e2;
            StringBuilder sb = new StringBuilder(i2);
            int i4 = 0;
            while (i4 < i2) {
                int e3 = e();
                switch (e3 >> 4) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        break;
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    default:
                        i3 = (e3 & 63) << 4;
                        e2 = e() & 15;
                        e3 = i3 | e2;
                        i4++;
                        break;
                    case 12:
                    case 13:
                        i3 = (e3 & 31) << 6;
                        e2 = e() & 63;
                        e3 = i3 | e2;
                        i4++;
                        break;
                    case 14:
                        e3 = ((e3 & 15) << 12) | ((e() & 63) << 6) | (e() & 63);
                        i4++;
                        i4++;
                        break;
                }
                sb.append((char) e3);
                i4++;
            }
            return sb.toString();
        }

        public int e() {
            return read() & 255;
        }

        public int f() {
            return (e() << 8) | e();
        }

        public int readInt() {
            return (f() << 16) | f();
        }

        public b(byte[] bArr, int i2, int i3) {
            super(bArr, i2, i3);
            this.f21765g = new HashMap();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(DatagramPacket datagramPacket) throws IOException {
        super(0, 0, datagramPacket.getPort() == i.a.g.s.a.a);
        this.f21761k = datagramPacket;
        InetAddress address = datagramPacket.getAddress();
        b bVar = new b(datagramPacket.getData(), datagramPacket.getLength());
        this.m = bVar;
        this.l = System.currentTimeMillis();
        this.n = 1460;
        try {
            w(bVar.f());
            v(bVar.f());
            if (k() <= 0) {
                int f2 = bVar.f();
                int f3 = bVar.f();
                int f4 = bVar.f();
                int f5 = bVar.f();
                if (f21758h.b()) {
                    f21758h.c("DNSIncoming() questions:" + f2 + " answers:" + f3 + " authorities:" + f4 + " additionals:" + f5);
                }
                if ((f2 * 5) + ((f3 + f4 + f5) * 11) <= datagramPacket.getLength()) {
                    if (f2 > 0) {
                        for (int i2 = 0; i2 < f2; i2++) {
                            this.f21768d.add(E());
                        }
                    }
                    if (f3 > 0) {
                        for (int i3 = 0; i3 < f3; i3++) {
                            h D = D(address);
                            if (D != null) {
                                this.f21769e.add(D);
                            }
                        }
                    }
                    if (f4 > 0) {
                        for (int i4 = 0; i4 < f4; i4++) {
                            h D2 = D(address);
                            if (D2 != null) {
                                this.f21770f.add(D2);
                            }
                        }
                    }
                    if (f5 > 0) {
                        for (int i5 = 0; i5 < f5; i5++) {
                            h D3 = D(address);
                            if (D3 != null) {
                                this.f21771g.add(D3);
                            }
                        }
                    }
                    if (this.m.available() > 0) {
                        throw new IOException("Received a message with the wrong length.");
                    }
                    return;
                }
                throw new IOException("questions:" + f2 + " answers:" + f3 + " authorities:" + f4 + " additionals:" + f5);
            }
            throw new IOException("Received a message with a non standard operation code. Currently unsupported in the specification.");
        } catch (Exception e2) {
            f21758h.f("DNSIncoming() dump " + C(true) + "\n exception ", e2);
            IOException iOException = new IOException("DNSIncoming corrupted message");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0264 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private h D(InetAddress inetAddress) {
        h cVar;
        String c2;
        byte b2;
        byte b3;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        String str;
        String str2;
        String b4 = this.m.b();
        i.a.g.s.e k2 = i.a.g.s.e.k(this.m.f());
        if (k2 == i.a.g.s.e.TYPE_IGNORE) {
            f21758h.h("Could not find record type. domain: " + b4 + "\n" + C(true));
        }
        int f2 = this.m.f();
        i.a.g.s.e eVar = i.a.g.s.e.TYPE_OPT;
        i.a.g.s.d g2 = k2 == eVar ? i.a.g.s.d.CLASS_UNKNOWN : i.a.g.s.d.g(f2);
        if (g2 == i.a.g.s.d.CLASS_UNKNOWN && k2 != eVar) {
            f21758h.h("Could not find record class. domain: " + b4 + " type: " + k2 + "\n" + C(true));
        }
        boolean q = g2.q(f2);
        int readInt = this.m.readInt();
        int f3 = this.m.f();
        int i2 = a.f21763c[k2.ordinal()];
        String str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        switch (i2) {
            case 1:
                cVar = new h.c(b4, g2, q, readInt, this.m.a(f3));
                break;
            case 2:
                cVar = new h.d(b4, g2, q, readInt, this.m.a(f3));
                break;
            case 3:
            case 4:
                String b5 = this.m.b();
                if (b5.length() > 0) {
                    cVar = new h.e(b4, g2, q, readInt, b5);
                    break;
                } else {
                    f21758h.h("PTR record of class: " + g2 + ", there was a problem reading the service name of the answer for domain:" + b4);
                    cVar = null;
                    break;
                }
            case 5:
                cVar = new h.g(b4, g2, q, readInt, this.m.a(f3));
                break;
            case 6:
                int f4 = this.m.f();
                int f5 = this.m.f();
                int f6 = this.m.f();
                if (f21759i) {
                    c2 = this.m.b();
                } else {
                    c2 = this.m.c();
                }
                cVar = new h.f(b4, g2, q, readInt, f4, f5, f6, c2);
                break;
            case 7:
                StringBuilder sb = new StringBuilder();
                sb.append(this.m.d(f3));
                int indexOf = sb.indexOf(" ");
                String trim = (indexOf > 0 ? sb.substring(0, indexOf) : sb.toString()).trim();
                if (indexOf > 0) {
                    str3 = sb.substring(indexOf + 1);
                }
                cVar = new h.b(b4, g2, q, readInt, trim, str3.trim());
                break;
            case 8:
                i.a.g.s.f k3 = i.a.g.s.f.k(e(), readInt);
                int i3 = (16711680 & readInt) >> 16;
                if (i3 == 0) {
                    this.n = f2;
                    while (true) {
                        if (this.m.available() > 0) {
                            if (this.m.available() >= 2) {
                                int f7 = this.m.f();
                                i.a.g.s.c k4 = i.a.g.s.c.k(f7);
                                if (this.m.available() >= 2) {
                                    int f8 = this.m.f();
                                    byte[] bArr4 = new byte[0];
                                    if (this.m.available() >= f8) {
                                        bArr4 = this.m.a(f8);
                                    }
                                    int i4 = a.f21762b[k4.ordinal()];
                                    if (i4 == 1) {
                                        try {
                                            b2 = bArr4[0];
                                            try {
                                                b3 = bArr4[1];
                                                try {
                                                    bArr3 = new byte[]{bArr4[2], bArr4[3], bArr4[4], bArr4[5], bArr4[6], bArr4[7]};
                                                    try {
                                                        bArr2 = bArr4.length > 8 ? new byte[]{bArr4[8], bArr4[9], bArr4[10], bArr4[11], bArr4[12], bArr4[13]} : bArr3;
                                                        try {
                                                            bArr = bArr4.length == 18 ? new byte[]{bArr4[14], bArr4[15], bArr4[16], bArr4[17]} : null;
                                                        } catch (Exception unused) {
                                                            bArr = null;
                                                            f21758h.h("Malformed OPT answer. Option code: Owner data: " + x(bArr4));
                                                            if (f21758h.b()) {
                                                            }
                                                        }
                                                    } catch (Exception unused2) {
                                                        bArr2 = bArr3;
                                                    }
                                                } catch (Exception unused3) {
                                                    bArr = null;
                                                    bArr2 = null;
                                                    bArr3 = null;
                                                    f21758h.h("Malformed OPT answer. Option code: Owner data: " + x(bArr4));
                                                    if (f21758h.b()) {
                                                    }
                                                }
                                            } catch (Exception unused4) {
                                                b3 = 0;
                                                bArr = null;
                                                bArr2 = null;
                                                bArr3 = null;
                                                f21758h.h("Malformed OPT answer. Option code: Owner data: " + x(bArr4));
                                                if (f21758h.b()) {
                                                }
                                            }
                                        } catch (Exception unused5) {
                                            b2 = 0;
                                        }
                                        try {
                                            if (bArr4.length == 22) {
                                                bArr = new byte[]{bArr4[14], bArr4[15], bArr4[16], bArr4[17], bArr4[18], bArr4[19], bArr4[20], bArr4[21]};
                                            }
                                        } catch (Exception unused6) {
                                            f21758h.h("Malformed OPT answer. Option code: Owner data: " + x(bArr4));
                                            if (f21758h.b()) {
                                            }
                                        }
                                        if (f21758h.b()) {
                                            k.b.b bVar = f21758h;
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("Unhandled Owner OPT version: ");
                                            sb2.append((int) b2);
                                            sb2.append(" sequence: ");
                                            sb2.append((int) b3);
                                            sb2.append(" MAC address: ");
                                            sb2.append(x(bArr3));
                                            if (bArr2 != bArr3) {
                                                str = " wakeup MAC address: " + x(bArr2);
                                            } else {
                                                str = HttpUrl.FRAGMENT_ENCODE_SET;
                                            }
                                            sb2.append(str);
                                            if (bArr != null) {
                                                str2 = " password: " + x(bArr);
                                            } else {
                                                str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                                            }
                                            sb2.append(str2);
                                            bVar.c(sb2.toString());
                                        }
                                    } else if (i4 == 2 || i4 == 3 || i4 == 4) {
                                        if (f21758h.b()) {
                                            f21758h.c("There was an OPT answer. Option code: " + k4 + " data: " + x(bArr4));
                                        }
                                    } else if (i4 == 5) {
                                        if (f7 >= 65001 && f7 <= 65534) {
                                            if (f21758h.b()) {
                                                f21758h.c("There was an OPT answer using an experimental/local option code: " + f7 + " data: " + x(bArr4));
                                            }
                                        } else {
                                            f21758h.h("There was an OPT answer. Not currently handled. Option code: " + f7 + " data: " + x(bArr4));
                                        }
                                    }
                                } else {
                                    f21758h.h("There was a problem reading the OPT record. Ignoring.");
                                }
                            } else {
                                f21758h.h("There was a problem reading the OPT record. Ignoring.");
                            }
                        }
                    }
                } else {
                    f21758h.h("There was an OPT answer. Wrong version number: " + i3 + " result code: " + k3);
                }
                cVar = null;
                break;
            default:
                if (f21758h.b()) {
                    f21758h.c("DNSIncoming() unknown type:" + k2);
                }
                this.m.skip(f3);
                cVar = null;
                break;
        }
        if (cVar != null) {
            cVar.O(inetAddress);
        }
        return cVar;
    }

    private g E() {
        String b2 = this.m.b();
        i.a.g.s.e k2 = i.a.g.s.e.k(this.m.f());
        if (k2 == i.a.g.s.e.TYPE_IGNORE) {
            f21758h.h("Could not find record type: " + C(true));
        }
        int f2 = this.m.f();
        i.a.g.s.d g2 = i.a.g.s.d.g(f2);
        return g.C(b2, k2, g2, g2.q(f2));
    }

    private String x(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            int i2 = b2 & 255;
            char[] cArr = f21760j;
            sb.append(cArr[i2 / 16]);
            sb.append(cArr[i2 % 16]);
        }
        return sb.toString();
    }

    public int A() {
        return (int) (System.currentTimeMillis() - this.l);
    }

    public int B() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String C(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(t());
        if (z) {
            int length = this.f21761k.getLength();
            byte[] bArr = new byte[length];
            System.arraycopy(this.f21761k.getData(), 0, bArr, 0, length);
            sb.append(u(bArr));
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(p() ? "dns[query," : "dns[response,");
        if (this.f21761k.getAddress() != null) {
            sb.append(this.f21761k.getAddress().getHostAddress());
        }
        sb.append(':');
        sb.append(this.f21761k.getPort());
        sb.append(", length=");
        sb.append(this.f21761k.getLength());
        sb.append(", id=0x");
        sb.append(Integer.toHexString(f()));
        if (e() != 0) {
            sb.append(", flags=0x");
            sb.append(Integer.toHexString(e()));
            if ((e() & 32768) != 0) {
                sb.append(":r");
            }
            if ((e() & 1024) != 0) {
                sb.append(":aa");
            }
            if ((e() & AdRequest.MAX_CONTENT_URL_LENGTH) != 0) {
                sb.append(":tc");
            }
        }
        if (j() > 0) {
            sb.append(", questions=");
            sb.append(j());
        }
        if (h() > 0) {
            sb.append(", answers=");
            sb.append(h());
        }
        if (i() > 0) {
            sb.append(", authorities=");
            sb.append(i());
        }
        if (g() > 0) {
            sb.append(", additionals=");
            sb.append(g());
        }
        if (j() > 0) {
            sb.append("\nquestions:");
            for (g gVar : this.f21768d) {
                sb.append("\n\t");
                sb.append(gVar);
            }
        }
        if (h() > 0) {
            sb.append("\nanswers:");
            for (h hVar : this.f21769e) {
                sb.append("\n\t");
                sb.append(hVar);
            }
        }
        if (i() > 0) {
            sb.append("\nauthorities:");
            for (h hVar2 : this.f21770f) {
                sb.append("\n\t");
                sb.append(hVar2);
            }
        }
        if (g() > 0) {
            sb.append("\nadditionals:");
            for (h hVar3 : this.f21771g) {
                sb.append("\n\t");
                sb.append(hVar3);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(c cVar) {
        if (p() && r() && cVar.p()) {
            this.f21768d.addAll(cVar.l());
            this.f21769e.addAll(cVar.c());
            this.f21770f.addAll(cVar.d());
            this.f21771g.addAll(cVar.a());
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c(e(), f(), o(), this.f21761k, this.l);
        cVar.n = this.n;
        cVar.f21768d.addAll(this.f21768d);
        cVar.f21769e.addAll(this.f21769e);
        cVar.f21770f.addAll(this.f21770f);
        cVar.f21771g.addAll(this.f21771g);
        return cVar;
    }

    private c(int i2, int i3, boolean z, DatagramPacket datagramPacket, long j2) {
        super(i2, i3, z);
        this.f21761k = datagramPacket;
        this.m = new b(datagramPacket.getData(), datagramPacket.getLength());
        this.l = j2;
    }
}
