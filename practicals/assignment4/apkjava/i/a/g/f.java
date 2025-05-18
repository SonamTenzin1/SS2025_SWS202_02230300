package i.a.g;

import com.google.android.gms.ads.AdRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DNSOutgoing.java */
/* loaded from: classes2.dex */
public final class f extends e {

    /* renamed from: h, reason: collision with root package name */
    public static boolean f21772h = true;

    /* renamed from: i, reason: collision with root package name */
    Map<String, Integer> f21773i;

    /* renamed from: j, reason: collision with root package name */
    private int f21774j;

    /* renamed from: k, reason: collision with root package name */
    private final a f21775k;
    private final a l;
    private final a m;
    private final a n;
    private InetSocketAddress o;

    /* compiled from: DNSOutgoing.java */
    /* loaded from: classes2.dex */
    public static class a extends ByteArrayOutputStream {

        /* renamed from: f, reason: collision with root package name */
        private final f f21776f;

        /* renamed from: g, reason: collision with root package name */
        private final int f21777g;

        a(int i2, f fVar) {
            this(i2, fVar, 0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i2) {
            write(i2 & 255);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(byte[] bArr, int i2, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                a(bArr[i2 + i4]);
            }
        }

        void c(int i2) {
            k(i2 >> 16);
            k(i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d(String str) {
            e(str, true);
        }

        void e(String str, boolean z) {
            while (true) {
                int indexOf = str.indexOf(46);
                if (indexOf < 0) {
                    indexOf = str.length();
                }
                if (indexOf <= 0) {
                    a(0);
                    return;
                }
                String substring = str.substring(0, indexOf);
                if (z && f.f21772h) {
                    Integer num = this.f21776f.f21773i.get(str);
                    if (num != null) {
                        int intValue = num.intValue();
                        a((intValue >> 8) | 192);
                        a(intValue & 255);
                        return;
                    }
                    this.f21776f.f21773i.put(str, Integer.valueOf(size() + this.f21777g));
                    l(substring, 0, substring.length());
                } else {
                    l(substring, 0, substring.length());
                }
                str = str.substring(indexOf);
                if (str.startsWith(".")) {
                    str = str.substring(1);
                }
            }
        }

        void f(g gVar) {
            d(gVar.c());
            k(gVar.f().g());
            k(gVar.e().k());
        }

        void j(h hVar, long j2) {
            d(hVar.c());
            k(hVar.f().g());
            k(hVar.e().k() | ((hVar.p() && this.f21776f.o()) ? 32768 : 0));
            c(j2 == 0 ? hVar.E() : hVar.A(j2));
            a aVar = new a(AdRequest.MAX_CONTENT_URL_LENGTH, this.f21776f, this.f21777g + size() + 2);
            hVar.S(aVar);
            byte[] byteArray = aVar.toByteArray();
            k(byteArray.length);
            write(byteArray, 0, byteArray.length);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void k(int i2) {
            a(i2 >> 8);
            a(i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void l(String str, int i2, int i3) {
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                char charAt = str.charAt(i2 + i5);
                i4 = (charAt < 1 || charAt > 127) ? charAt > 2047 ? i4 + 3 : i4 + 2 : i4 + 1;
            }
            a(i4);
            for (int i6 = 0; i6 < i3; i6++) {
                char charAt2 = str.charAt(i2 + i6);
                if (charAt2 >= 1 && charAt2 <= 127) {
                    a(charAt2);
                } else if (charAt2 > 2047) {
                    a(((charAt2 >> '\f') & 15) | 224);
                    a(((charAt2 >> 6) & 63) | 128);
                    a(((charAt2 >> 0) & 63) | 128);
                } else {
                    a(((charAt2 >> 6) & 31) | 192);
                    a(((charAt2 >> 0) & 63) | 128);
                }
            }
        }

        a(int i2, f fVar, int i3) {
            super(i2);
            this.f21776f = fVar;
            this.f21777g = i3;
        }
    }

    public f(int i2) {
        this(i2, true, 1460);
    }

    public void A(g gVar) throws IOException {
        a aVar = new a(AdRequest.MAX_CONTENT_URL_LENGTH, this);
        aVar.f(gVar);
        byte[] byteArray = aVar.toByteArray();
        aVar.close();
        if (byteArray.length < B()) {
            this.f21768d.add(gVar);
            this.f21775k.write(byteArray, 0, byteArray.length);
            return;
        }
        throw new IOException("message full");
    }

    public int B() {
        return ((((this.f21774j - 12) - this.f21775k.size()) - this.l.size()) - this.m.size()) - this.n.size();
    }

    public byte[] C() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f21773i.clear();
        a aVar = new a(this.f21774j, this);
        aVar.k(this.f21766b ? 0 : f());
        aVar.k(e());
        aVar.k(j());
        aVar.k(h());
        aVar.k(i());
        aVar.k(g());
        Iterator<g> it = this.f21768d.iterator();
        while (it.hasNext()) {
            aVar.f(it.next());
        }
        Iterator<h> it2 = this.f21769e.iterator();
        while (it2.hasNext()) {
            aVar.j(it2.next(), currentTimeMillis);
        }
        Iterator<h> it3 = this.f21770f.iterator();
        while (it3.hasNext()) {
            aVar.j(it3.next(), currentTimeMillis);
        }
        Iterator<h> it4 = this.f21771g.iterator();
        while (it4.hasNext()) {
            aVar.j(it4.next(), currentTimeMillis);
        }
        byte[] byteArray = aVar.toByteArray();
        try {
            aVar.close();
        } catch (IOException unused) {
        }
        return byteArray;
    }

    public InetSocketAddress D() {
        return this.o;
    }

    public int E() {
        return this.f21774j;
    }

    public void F(InetSocketAddress inetSocketAddress) {
        this.o = inetSocketAddress;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(p() ? "dns[query:" : "dns[response:");
        stringBuffer.append(" id=0x");
        stringBuffer.append(Integer.toHexString(f()));
        if (e() != 0) {
            stringBuffer.append(", flags=0x");
            stringBuffer.append(Integer.toHexString(e()));
            if (q()) {
                stringBuffer.append(":r");
            }
            if (m()) {
                stringBuffer.append(":aa");
            }
            if (r()) {
                stringBuffer.append(":tc");
            }
        }
        if (j() > 0) {
            stringBuffer.append(", questions=");
            stringBuffer.append(j());
        }
        if (h() > 0) {
            stringBuffer.append(", answers=");
            stringBuffer.append(h());
        }
        if (i() > 0) {
            stringBuffer.append(", authorities=");
            stringBuffer.append(i());
        }
        if (g() > 0) {
            stringBuffer.append(", additionals=");
            stringBuffer.append(g());
        }
        if (j() > 0) {
            stringBuffer.append("\nquestions:");
            for (g gVar : this.f21768d) {
                stringBuffer.append("\n\t");
                stringBuffer.append(gVar);
            }
        }
        if (h() > 0) {
            stringBuffer.append("\nanswers:");
            for (h hVar : this.f21769e) {
                stringBuffer.append("\n\t");
                stringBuffer.append(hVar);
            }
        }
        if (i() > 0) {
            stringBuffer.append("\nauthorities:");
            for (h hVar2 : this.f21770f) {
                stringBuffer.append("\n\t");
                stringBuffer.append(hVar2);
            }
        }
        if (g() > 0) {
            stringBuffer.append("\nadditionals:");
            for (h hVar3 : this.f21771g) {
                stringBuffer.append("\n\t");
                stringBuffer.append(hVar3);
            }
        }
        stringBuffer.append("\nnames=");
        stringBuffer.append(this.f21773i);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public void x(c cVar, h hVar) throws IOException {
        if (cVar == null || !hVar.Q(cVar)) {
            y(hVar, 0L);
        }
    }

    public void y(h hVar, long j2) throws IOException {
        if (hVar != null) {
            if (j2 == 0 || !hVar.j(j2)) {
                a aVar = new a(AdRequest.MAX_CONTENT_URL_LENGTH, this);
                aVar.j(hVar, j2);
                byte[] byteArray = aVar.toByteArray();
                aVar.close();
                if (byteArray.length < B()) {
                    this.f21769e.add(hVar);
                    this.l.write(byteArray, 0, byteArray.length);
                    return;
                }
                throw new IOException("message full");
            }
        }
    }

    public void z(h hVar) throws IOException {
        a aVar = new a(AdRequest.MAX_CONTENT_URL_LENGTH, this);
        aVar.j(hVar, 0L);
        byte[] byteArray = aVar.toByteArray();
        aVar.close();
        if (byteArray.length < B()) {
            this.f21770f.add(hVar);
            this.m.write(byteArray, 0, byteArray.length);
            return;
        }
        throw new IOException("message full");
    }

    public f(int i2, boolean z, int i3) {
        super(i2, 0, z);
        this.f21773i = new HashMap();
        this.f21774j = i3 > 0 ? i3 : 1460;
        this.f21775k = new a(i3, this);
        this.l = new a(i3, this);
        this.m = new a(i3, this);
        this.n = new a(i3, this);
    }
}
