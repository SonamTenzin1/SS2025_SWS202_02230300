package e.h.a.g0;

import android.text.TextUtils;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import e.h.a.g0.b;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ConnectTask.java */
/* loaded from: classes2.dex */
public class a {
    final int a;

    /* renamed from: b, reason: collision with root package name */
    final String f21265b;

    /* renamed from: c, reason: collision with root package name */
    final FileDownloadHeader f21266c;

    /* renamed from: d, reason: collision with root package name */
    private e.h.a.g0.b f21267d;

    /* renamed from: e, reason: collision with root package name */
    private String f21268e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, List<String>> f21269f;

    /* renamed from: g, reason: collision with root package name */
    private List<String> f21270g;

    /* compiled from: ConnectTask.java */
    /* loaded from: classes2.dex */
    static class b {
        private Integer a;

        /* renamed from: b, reason: collision with root package name */
        private String f21271b;

        /* renamed from: c, reason: collision with root package name */
        private String f21272c;

        /* renamed from: d, reason: collision with root package name */
        private FileDownloadHeader f21273d;

        /* renamed from: e, reason: collision with root package name */
        private e.h.a.g0.b f21274e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a() {
            e.h.a.g0.b bVar;
            Integer num = this.a;
            if (num != null && (bVar = this.f21274e) != null && this.f21271b != null) {
                return new a(bVar, num.intValue(), this.f21271b, this.f21272c, this.f21273d);
            }
            throw new IllegalArgumentException();
        }

        public b b(e.h.a.g0.b bVar) {
            this.f21274e = bVar;
            return this;
        }

        public b c(int i2) {
            this.a = Integer.valueOf(i2);
            return this;
        }

        public b d(String str) {
            this.f21272c = str;
            return this;
        }

        public b e(FileDownloadHeader fileDownloadHeader) {
            this.f21273d = fileDownloadHeader;
            return this;
        }

        public b f(String str) {
            this.f21271b = str;
            return this;
        }
    }

    private void a(e.h.a.e0.b bVar) throws ProtocolException {
        if (bVar.c(this.f21268e, this.f21267d.a)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f21268e)) {
            bVar.f("If-Match", this.f21268e);
        }
        this.f21267d.a(bVar);
    }

    private void b(e.h.a.e0.b bVar) {
        HashMap<String, List<String>> b2;
        FileDownloadHeader fileDownloadHeader = this.f21266c;
        if (fileDownloadHeader == null || (b2 = fileDownloadHeader.b()) == null) {
            return;
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "%d add outside header: %s", Integer.valueOf(this.a), b2);
        }
        for (Map.Entry<String, List<String>> entry : b2.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bVar.f(key, it.next());
                }
            }
        }
    }

    private void d(e.h.a.e0.b bVar) {
        FileDownloadHeader fileDownloadHeader = this.f21266c;
        if (fileDownloadHeader == null || fileDownloadHeader.b().get("User-Agent") == null) {
            bVar.f("User-Agent", e.h.a.k0.f.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e.h.a.e0.b c() throws IOException, IllegalAccessException {
        e.h.a.e0.b a = c.j().a(this.f21265b);
        b(a);
        a(a);
        d(a);
        this.f21269f = a.i();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "<---- %s request header %s", Integer.valueOf(this.a), this.f21269f);
        }
        a.execute();
        ArrayList arrayList = new ArrayList();
        this.f21270g = arrayList;
        e.h.a.e0.b c2 = e.h.a.e0.d.c(this.f21269f, a, arrayList);
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "----> %s response header %s", Integer.valueOf(this.a), c2.b());
        }
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        List<String> list = this.f21270g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.f21270g.get(r0.size() - 1);
    }

    public e.h.a.g0.b f() {
        return this.f21267d;
    }

    public Map<String, List<String>> g() {
        return this.f21269f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f21267d.f21275b > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(long j2) {
        e.h.a.g0.b bVar = this.f21267d;
        long j3 = bVar.f21275b;
        if (j2 == j3) {
            e.h.a.k0.d.i(this, "no data download, no need to update", new Object[0]);
            return;
        }
        e.h.a.g0.b b2 = b.C0275b.b(bVar.a, j2, bVar.f21276c, bVar.f21277d - (j2 - j3));
        this.f21267d = b2;
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.e(this, "after update profile:%s", b2);
        }
    }

    private a(e.h.a.g0.b bVar, int i2, String str, String str2, FileDownloadHeader fileDownloadHeader) {
        this.a = i2;
        this.f21265b = str;
        this.f21268e = str2;
        this.f21266c = fileDownloadHeader;
        this.f21267d = bVar;
    }
}
