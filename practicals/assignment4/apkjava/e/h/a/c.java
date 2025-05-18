package e.h.a;

import android.text.TextUtils;
import android.util.SparseArray;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import e.h.a.a;
import e.h.a.d;
import e.h.a.x;
import java.io.File;
import java.util.ArrayList;

/* compiled from: DownloadTask.java */
/* loaded from: classes2.dex */
public class c implements e.h.a.a, a.b, d.a {
    private final x a;

    /* renamed from: b, reason: collision with root package name */
    private final x.a f21219b;

    /* renamed from: c, reason: collision with root package name */
    private int f21220c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<a.InterfaceC0271a> f21221d;

    /* renamed from: e, reason: collision with root package name */
    private final String f21222e;

    /* renamed from: f, reason: collision with root package name */
    private String f21223f;

    /* renamed from: g, reason: collision with root package name */
    private String f21224g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f21225h;

    /* renamed from: i, reason: collision with root package name */
    private FileDownloadHeader f21226i;

    /* renamed from: j, reason: collision with root package name */
    private i f21227j;

    /* renamed from: k, reason: collision with root package name */
    private SparseArray<Object> f21228k;
    private Object l;
    private final Object u;
    private int m = 0;
    private boolean n = false;
    private boolean o = false;
    private int p = 100;
    private int q = 10;
    private boolean r = false;
    volatile int s = 0;
    private boolean t = false;
    private final Object v = new Object();
    private volatile boolean w = false;

    /* compiled from: DownloadTask.java */
    /* loaded from: classes2.dex */
    private static final class b implements a.c {
        private final c a;

        @Override // e.h.a.a.c
        public int a() {
            int id = this.a.getId();
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            h.i().b(this.a);
            return id;
        }

        private b(c cVar) {
            this.a = cVar;
            cVar.t = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.f21222e = str;
        Object obj = new Object();
        this.u = obj;
        d dVar = new d(this, obj);
        this.a = dVar;
        this.f21219b = dVar;
    }

    private void Y() {
        if (this.f21226i == null) {
            synchronized (this.v) {
                if (this.f21226i == null) {
                    this.f21226i = new FileDownloadHeader();
                }
            }
        }
    }

    private int c0() {
        if (a0()) {
            if (Z()) {
                throw new IllegalStateException(e.h.a.k0.f.o("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
            }
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.a.toString());
        }
        if (!p()) {
            F();
        }
        this.a.j();
        return getId();
    }

    @Override // e.h.a.a.b
    public boolean A(int i2) {
        return getId() == i2;
    }

    @Override // e.h.a.a
    public int B() {
        if (this.a.k() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.a.k();
    }

    @Override // e.h.a.a.b
    public void C(int i2) {
        this.s = i2;
    }

    @Override // e.h.a.d.a
    public ArrayList<a.InterfaceC0271a> D() {
        return this.f21221d;
    }

    @Override // e.h.a.a
    public long E() {
        return this.a.m();
    }

    @Override // e.h.a.a.b
    public void F() {
        int hashCode;
        if (G() != null) {
            hashCode = G().hashCode();
        } else {
            hashCode = hashCode();
        }
        this.s = hashCode;
    }

    @Override // e.h.a.a
    public i G() {
        return this.f21227j;
    }

    @Override // e.h.a.a.b
    public boolean H() {
        return this.w;
    }

    @Override // e.h.a.a.b
    public Object I() {
        return this.u;
    }

    @Override // e.h.a.a
    public boolean J(a.InterfaceC0271a interfaceC0271a) {
        ArrayList<a.InterfaceC0271a> arrayList = this.f21221d;
        return arrayList != null && arrayList.remove(interfaceC0271a);
    }

    @Override // e.h.a.a
    public int K() {
        return this.p;
    }

    @Override // e.h.a.a.b
    public void L() {
        c0();
    }

    @Override // e.h.a.a
    public boolean M() {
        return this.r;
    }

    @Override // e.h.a.d.a
    public FileDownloadHeader N() {
        return this.f21226i;
    }

    @Override // e.h.a.a
    public e.h.a.a O(int i2) {
        this.m = i2;
        return this;
    }

    @Override // e.h.a.a.b
    public boolean P() {
        return com.liulishuo.filedownloader.model.b.e(getStatus());
    }

    @Override // e.h.a.a
    public boolean Q() {
        return this.f21225h;
    }

    @Override // e.h.a.a
    public e.h.a.a R(int i2) {
        this.p = i2;
        return this;
    }

    @Override // e.h.a.a.b
    public boolean S() {
        ArrayList<a.InterfaceC0271a> arrayList = this.f21221d;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // e.h.a.a.b
    public void T() {
        this.w = true;
    }

    @Override // e.h.a.a
    public boolean U() {
        return this.n;
    }

    @Override // e.h.a.a
    public String V() {
        return this.f21224g;
    }

    @Override // e.h.a.a
    public e.h.a.a W(i iVar) {
        this.f21227j = iVar;
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "setListener %s", iVar);
        }
        return this;
    }

    public boolean Z() {
        if (q.e().f().a(this)) {
            return true;
        }
        return com.liulishuo.filedownloader.model.b.a(getStatus());
    }

    @Override // e.h.a.d.a
    public void a(String str) {
        this.f21224g = str;
    }

    public boolean a0() {
        return this.a.getStatus() != 0;
    }

    @Override // e.h.a.a.b
    public void b() {
        this.a.b();
        if (h.i().k(this)) {
            this.w = false;
        }
    }

    public e.h.a.a b0(String str, boolean z) {
        this.f21223f = str;
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "setPath %s", str);
        }
        this.f21225h = z;
        if (z) {
            this.f21224g = null;
        } else {
            this.f21224g = new File(str).getName();
        }
        return this;
    }

    @Override // e.h.a.a
    public int c() {
        return this.a.c();
    }

    @Override // e.h.a.a
    public int d() {
        return this.a.d();
    }

    @Override // e.h.a.a
    public Throwable e() {
        return this.a.e();
    }

    @Override // e.h.a.a
    public e.h.a.a f(String str, String str2) {
        Y();
        this.f21226i.a(str, str2);
        return this;
    }

    @Override // e.h.a.a
    public String g() {
        return this.f21223f;
    }

    @Override // e.h.a.a
    public int getId() {
        int i2 = this.f21220c;
        if (i2 != 0) {
            return i2;
        }
        if (TextUtils.isEmpty(this.f21223f) || TextUtils.isEmpty(this.f21222e)) {
            return 0;
        }
        int s = e.h.a.k0.f.s(this.f21222e, this.f21223f, this.f21225h);
        this.f21220c = s;
        return s;
    }

    @Override // e.h.a.a
    public byte getStatus() {
        return this.a.getStatus();
    }

    @Override // e.h.a.a
    public Object getTag() {
        return this.l;
    }

    @Override // e.h.a.a
    public boolean h() {
        return this.a.h();
    }

    @Override // e.h.a.a
    public int i() {
        if (this.a.m() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.a.m();
    }

    @Override // e.h.a.a
    public e.h.a.a j(int i2, Object obj) {
        if (this.f21228k == null) {
            this.f21228k = new SparseArray<>(2);
        }
        this.f21228k.put(i2, obj);
        return this;
    }

    @Override // e.h.a.a
    public e.h.a.a k(String str) {
        return b0(str, false);
    }

    @Override // e.h.a.a
    public String l() {
        return e.h.a.k0.f.B(g(), Q(), V());
    }

    @Override // e.h.a.a
    public a.c m() {
        return new b();
    }

    @Override // e.h.a.a
    public String n() {
        return this.f21222e;
    }

    @Override // e.h.a.a
    public long o() {
        return this.a.k();
    }

    @Override // e.h.a.a
    public boolean p() {
        return this.s != 0;
    }

    @Override // e.h.a.a
    public boolean pause() {
        boolean pause;
        synchronized (this.u) {
            pause = this.a.pause();
        }
        return pause;
    }

    @Override // e.h.a.a
    public int q() {
        return this.q;
    }

    @Override // e.h.a.a
    public boolean r() {
        return this.o;
    }

    @Override // e.h.a.d.a
    public a.b s() {
        return this;
    }

    @Override // e.h.a.a
    public int t() {
        return this.m;
    }

    public String toString() {
        return e.h.a.k0.f.o("%d@%s", Integer.valueOf(getId()), super.toString());
    }

    @Override // e.h.a.a
    public e.h.a.a u(a.InterfaceC0271a interfaceC0271a) {
        if (this.f21221d == null) {
            this.f21221d = new ArrayList<>();
        }
        if (!this.f21221d.contains(interfaceC0271a)) {
            this.f21221d.add(interfaceC0271a);
        }
        return this;
    }

    @Override // e.h.a.a.b
    public e.h.a.a v() {
        return this;
    }

    @Override // e.h.a.a.b
    public void w() {
        c0();
    }

    @Override // e.h.a.a.b
    public int x() {
        return this.s;
    }

    @Override // e.h.a.a.b
    public x.a y() {
        return this.f21219b;
    }

    @Override // e.h.a.a.b
    public boolean z(i iVar) {
        return G() == iVar;
    }
}
