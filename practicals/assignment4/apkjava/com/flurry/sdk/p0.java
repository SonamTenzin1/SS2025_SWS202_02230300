package com.flurry.sdk;

import com.flurry.sdk.i1;
import com.flurry.sdk.i2;
import com.flurry.sdk.k1;
import com.flurry.sdk.r0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class p0 extends l2 {
    protected final String o;
    protected String p;
    protected o0 q;
    Set<String> r;
    public r0 s;
    private w t;
    private f7<v> u;

    /* loaded from: classes2.dex */
    final class a implements f7<v> {
        a() {
        }

        @Override // com.flurry.sdk.f7
        public final /* synthetic */ void a(v vVar) {
            v vVar2 = vVar;
            d1.l(p0.this.o, "NetworkAvailabilityChanged : NetworkAvailable = " + vVar2.a);
            if (vVar2.a) {
                p0.this.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends f2 {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ byte[] f10975h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f10976i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f10977j;

        b(byte[] bArr, String str, String str2) {
            this.f10975h = bArr;
            this.f10976i = str;
            this.f10977j = str2;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            p0.this.x(this.f10975h, this.f10976i, this.f10977j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends f2 {
        c() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            p0.this.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class d implements i1.b<byte[], String> {
        final /* synthetic */ String a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10980b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10981c;

        /* loaded from: classes2.dex */
        final class a extends f2 {

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f10983h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f10984i;

            a(int i2, String str) {
                this.f10983h = i2;
                this.f10984i = str;
            }

            @Override // com.flurry.sdk.f2
            public final void a() throws Exception {
                p0.this.u(this.f10983h, p0.s(this.f10984i), d.this.a);
            }
        }

        d(String str, String str2, String str3) {
            this.a = str;
            this.f10980b = str2;
            this.f10981c = str3;
        }

        @Override // com.flurry.sdk.i1.b
        public final /* synthetic */ void a(i1<byte[], String> i1Var, String str) {
            String str2 = str;
            int i2 = i1Var.A;
            if (i2 != 200) {
                p0.this.m(new a(i2, str2));
            }
            if ((i2 >= 200 && i2 < 300) || i2 == 400) {
                d1.o(p0.this.o, "Analytics report sent to " + this.f10980b);
                d1.c(3, p0.this.o, "FlurryDataSender: report " + this.a + " sent. HTTP response: " + i2);
                String str3 = p0.this.o;
                StringBuilder sb = new StringBuilder("FlurryDataSender:");
                sb.append(p0.s(str2));
                d1.c(3, str3, sb.toString());
                if (str2 != null) {
                    d1.c(3, p0.this.o, "HTTP response: ".concat(str2));
                }
                p0 p0Var = p0.this;
                p0Var.m(new e(i2, this.a, this.f10981c));
                p0.this.d();
                return;
            }
            d1.o(p0.this.o, "Analytics report sent with error " + this.f10980b);
            p0 p0Var2 = p0.this;
            p0Var2.m(new f(this.a));
        }
    }

    /* loaded from: classes2.dex */
    final class e extends f2 {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f10986h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f10987i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f10988j;

        e(int i2, String str, String str2) {
            this.f10986h = i2;
            this.f10987i = str;
            this.f10988j = str2;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            o0 o0Var = p0.this.q;
            if (o0Var != null) {
                if (this.f10986h == 200) {
                    o0Var.a();
                } else {
                    o0Var.d();
                }
            }
            if (!p0.this.s.e(this.f10987i, this.f10988j)) {
                d1.c(6, p0.this.o, "Internal error. Block wasn't deleted with id = " + this.f10987i);
            }
            if (p0.this.r.remove(this.f10987i)) {
                return;
            }
            d1.c(6, p0.this.o, "Internal error. Block with id = " + this.f10987i + " was not in progress state");
        }
    }

    /* loaded from: classes2.dex */
    final class f extends f2 {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f10990h;

        f(String str) {
            this.f10990h = str;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            o0 o0Var = p0.this.q;
            if (o0Var != null) {
                o0Var.d();
            }
            if (p0.this.r.remove(this.f10990h)) {
                return;
            }
            d1.c(6, p0.this.o, "Internal error. Block with id = " + this.f10990h + " was not in progress state");
        }
    }

    public p0(String str, String str2) {
        super(str2, i2.a(i2.b.REPORTS));
        this.r = new HashSet();
        this.t = e7.a().f10724c;
        a aVar = new a();
        this.u = aVar;
        this.o = str2;
        this.p = "AnalyticsData_";
        this.t.v(aVar);
        this.s = new r0(str);
    }

    private boolean A() {
        return B() <= 5;
    }

    private int B() {
        return this.r.size();
    }

    static /* synthetic */ String s(String str) {
        if (str != null && str.contains("<body>") && str.contains("</body>")) {
            return str.substring(str.indexOf("<body>") + 6, str.indexOf("</body>"));
        }
        StringBuilder sb = new StringBuilder("Can not parse http error message: ");
        if (str == null) {
            str = "NULL";
        }
        sb.append(str);
        return sb.toString();
    }

    public final void a() {
        r0 r0Var = this.s;
        String str = r0Var.f11029b;
        ArrayList<String> arrayList = new ArrayList();
        File fileStreamPath = b0.a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        d1.c(5, "FlurryDataSenderIndex", "isOldIndexFilePresent: for " + str + fileStreamPath.exists());
        if (fileStreamPath.exists()) {
            List<String> b2 = r0Var.b(str);
            if (b2 != null && b2.size() > 0) {
                arrayList.addAll(b2);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    r0Var.g((String) it.next());
                }
            }
            r0.h(str);
        } else {
            List list = (List) new c7(b0.a().getFileStreamPath(r0.i(r0Var.f11029b)), str, 1, new r0.a()).a();
            if (list == null) {
                d1.l("FlurryDataSenderIndex", "New main file also not found. returning..");
                d();
            } else {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((s0) it2.next()).a);
                }
            }
        }
        for (String str2 : arrayList) {
            List<String> j2 = r0Var.j(str2);
            if (j2 != null && !j2.isEmpty()) {
                r0Var.f11030c.put(str2, j2);
            }
        }
        d();
    }

    protected final void d() {
        m(new c());
    }

    protected abstract void u(int i2, String str, String str2);

    public final void v(o0 o0Var) {
        this.q = o0Var;
    }

    public final void w(byte[] bArr, String str, String str2) {
        if (bArr != null && bArr.length != 0) {
            m(new b(bArr, str, str2));
            d();
        } else {
            d1.c(6, this.o, "Report that has to be sent is EMPTY or NULL");
        }
    }

    protected final void x(byte[] bArr, String str, String str2) {
        String str3 = this.p + str + "_" + str2;
        q0 q0Var = new q0(bArr);
        String str4 = q0Var.a;
        q0.b(str4).b(q0Var);
        d1.c(5, this.o, "Saving Block File " + str4 + " at " + b0.a().getFileStreamPath(q0.a(str4)));
        this.s.c(q0Var, str3);
    }

    /* JADX WARN: Type inference failed for: r6v10, types: [RequestObjectType, byte[]] */
    protected final void y() {
        if (!x0.a()) {
            d1.c(5, this.o, "Reports were not sent! No Internet connection!");
            return;
        }
        List<String> a2 = this.s.a();
        if (a2.isEmpty()) {
            d1.c(4, this.o, "No more reports to send.");
            return;
        }
        for (String str : a2) {
            if (!A()) {
                return;
            }
            List<String> k2 = this.s.k(str);
            d1.c(4, this.o, "Number of not sent blocks = " + k2.size());
            for (String str2 : k2) {
                if (!this.r.contains(str2)) {
                    if (A()) {
                        q0 a3 = q0.b(str2).a();
                        if (a3 == null) {
                            d1.c(6, this.o, "Internal ERROR! Cannot read!");
                            this.s.e(str2, str);
                        } else {
                            ?? r6 = a3.f11010b;
                            if (r6 != 0 && r6.length != 0) {
                                d1.c(5, this.o, "Reading block info ".concat(String.valueOf(str2)));
                                this.r.add(str2);
                                String z = z();
                                d1.c(4, this.o, "FlurryDataSender: start upload data with id = " + str2 + " to " + z);
                                i1 i1Var = new i1();
                                i1Var.l = z;
                                i1Var.f10782h = 100000;
                                i1Var.m = k1.c.kPost;
                                i1Var.b("Content-Type", "application/octet-stream");
                                i1Var.b("X-Flurry-Api-Key", k0.a().b());
                                i1Var.J = new r1();
                                i1Var.K = new w1();
                                i1Var.H = r6;
                                com.flurry.sdk.d dVar = e7.a().f10730i;
                                i1Var.D = dVar != null && dVar.r;
                                i1Var.G = new d(str2, z, str);
                                y0.f().c(this, i1Var);
                            } else {
                                d1.c(6, this.o, "Internal ERROR! Report is empty!");
                                this.s.e(str2, str);
                            }
                        }
                    }
                }
            }
        }
    }

    protected abstract String z();
}
