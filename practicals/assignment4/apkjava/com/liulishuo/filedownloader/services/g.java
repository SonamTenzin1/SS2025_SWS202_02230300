package com.liulishuo.filedownloader.services;

import android.text.TextUtils;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import e.h.a.b0;
import e.h.a.g0.d;
import e.h.a.y;
import java.util.Iterator;
import java.util.List;

/* compiled from: FileDownloadManager.java */
/* loaded from: classes2.dex */
class g implements y {
    private final e.h.a.f0.a a;

    /* renamed from: b, reason: collision with root package name */
    private final h f20524b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        e.h.a.g0.c j2 = e.h.a.g0.c.j();
        this.a = j2.f();
        this.f20524b = new h(j2.k());
    }

    @Override // e.h.a.y
    public boolean a(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            return false;
        }
        boolean g2 = this.f20524b.g(fileDownloadModel.e());
        if (com.liulishuo.filedownloader.model.b.e(fileDownloadModel.h())) {
            if (!g2) {
                return false;
            }
        } else if (!g2) {
            e.h.a.k0.d.b(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(fileDownloadModel.e()), Byte.valueOf(fileDownloadModel.h()));
            return false;
        }
        return true;
    }

    @Override // e.h.a.y
    public int b(String str, int i2) {
        return this.f20524b.e(str, i2);
    }

    public void c() {
        this.a.clear();
    }

    public boolean d(int i2) {
        if (i2 == 0) {
            e.h.a.k0.d.i(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i2));
            return false;
        }
        if (h(i2)) {
            e.h.a.k0.d.i(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i2));
            return false;
        }
        this.a.remove(i2);
        this.a.h(i2);
        return true;
    }

    public long e(int i2) {
        FileDownloadModel o = this.a.o(i2);
        if (o == null) {
            return 0L;
        }
        int a = o.a();
        if (a <= 1) {
            return o.g();
        }
        List<com.liulishuo.filedownloader.model.a> n = this.a.n(i2);
        if (n == null || n.size() != a) {
            return 0L;
        }
        return com.liulishuo.filedownloader.model.a.f(n);
    }

    public byte f(int i2) {
        FileDownloadModel o = this.a.o(i2);
        if (o == null) {
            return (byte) 0;
        }
        return o.h();
    }

    public long g(int i2) {
        FileDownloadModel o = this.a.o(i2);
        if (o == null) {
            return 0L;
        }
        return o.k();
    }

    public boolean h(int i2) {
        return a(this.a.o(i2));
    }

    public boolean i(String str, String str2) {
        return h(e.h.a.k0.f.r(str, str2));
    }

    public boolean j() {
        return this.f20524b.b() <= 0;
    }

    public boolean k(int i2) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "request pause the task %d", Integer.valueOf(i2));
        }
        FileDownloadModel o = this.a.o(i2);
        if (o == null) {
            return false;
        }
        o.y((byte) -2);
        this.f20524b.a(i2);
        return true;
    }

    public void l() {
        List<Integer> f2 = this.f20524b.f();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "pause all tasks %d", Integer.valueOf(f2.size()));
        }
        Iterator<Integer> it = f2.iterator();
        while (it.hasNext()) {
            k(it.next().intValue());
        }
    }

    public synchronized boolean m(int i2) {
        return this.f20524b.h(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0184 A[Catch: all -> 0x01cf, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0034, B:12:0x0044, B:14:0x004e, B:16:0x0052, B:17:0x0065, B:19:0x0072, B:21:0x0078, B:23:0x007c, B:28:0x008d, B:29:0x0096, B:31:0x009f, B:33:0x00a3, B:38:0x00b6, B:40:0x00bf, B:41:0x00c8, B:43:0x00d7, B:45:0x00db, B:47:0x00ec, B:51:0x00fa, B:53:0x0101, B:55:0x0108, B:57:0x010e, B:59:0x0115, B:61:0x011b, B:63:0x0121, B:65:0x013b, B:66:0x013f, B:68:0x0145, B:72:0x0184, B:73:0x0189, B:76:0x0154, B:78:0x015e, B:80:0x0164, B:81:0x016a, B:82:0x00c4, B:84:0x0092), top: B:3:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void n(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) {
        FileDownloadModel fileDownloadModel;
        List<com.liulishuo.filedownloader.model.a> list;
        String B;
        String C;
        boolean z4 = false;
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z));
        }
        b0.a();
        int s = e.h.a.k0.f.s(str, str2, z);
        FileDownloadModel o = this.a.o(s);
        if (z || o != null) {
            fileDownloadModel = o;
            list = null;
        } else {
            int s2 = e.h.a.k0.f.s(str, e.h.a.k0.f.A(str2), true);
            FileDownloadModel o2 = this.a.o(s2);
            if (o2 == null || !str2.equals(o2.i())) {
                list = null;
            } else {
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(s), Integer.valueOf(s2));
                }
                list = this.a.n(s2);
            }
            fileDownloadModel = o2;
        }
        if (e.h.a.k0.c.e(s, fileDownloadModel, this, true)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "has already started download %d", Integer.valueOf(s));
            }
            return;
        }
        if (fileDownloadModel != null) {
            B = fileDownloadModel.i();
        } else {
            B = e.h.a.k0.f.B(str2, z, null);
        }
        String str3 = B;
        if (e.h.a.k0.c.d(s, str3, z2, true)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "has already completed downloading %d", Integer.valueOf(s));
            }
            return;
        }
        long g2 = fileDownloadModel != null ? fileDownloadModel.g() : 0L;
        if (fileDownloadModel != null) {
            C = fileDownloadModel.j();
        } else {
            C = e.h.a.k0.f.C(str3);
        }
        if (e.h.a.k0.c.c(s, g2, C, str3, this)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(s), str3);
            }
            if (fileDownloadModel != null) {
                this.a.remove(s);
                this.a.h(s);
            }
            return;
        }
        if (fileDownloadModel != null && (fileDownloadModel.h() == -2 || fileDownloadModel.h() == -1 || fileDownloadModel.h() == 1 || fileDownloadModel.h() == 6 || fileDownloadModel.h() == 2)) {
            if (fileDownloadModel.e() != s) {
                this.a.remove(fileDownloadModel.e());
                this.a.h(fileDownloadModel.e());
                fileDownloadModel.v(s);
                fileDownloadModel.w(str2, z);
                if (list != null) {
                    for (com.liulishuo.filedownloader.model.a aVar : list) {
                        aVar.i(s);
                        this.a.g(aVar);
                    }
                }
            } else {
                if (!TextUtils.equals(str, fileDownloadModel.l())) {
                    fileDownloadModel.B(str);
                }
                if (z4) {
                    this.a.j(fileDownloadModel);
                }
                this.f20524b.c(new d.b().g(fileDownloadModel).d(fileDownloadHeader).h(this).f(Integer.valueOf(i3)).b(Integer.valueOf(i2)).c(Boolean.valueOf(z2)).i(Boolean.valueOf(z3)).e(Integer.valueOf(i4)).a());
            }
        } else {
            if (fileDownloadModel == null) {
                fileDownloadModel = new FileDownloadModel();
            }
            fileDownloadModel.B(str);
            fileDownloadModel.w(str2, z);
            fileDownloadModel.v(s);
            fileDownloadModel.x(0L);
            fileDownloadModel.z(0L);
            fileDownloadModel.y((byte) 1);
            fileDownloadModel.r(1);
        }
        z4 = true;
        if (z4) {
        }
        this.f20524b.c(new d.b().g(fileDownloadModel).d(fileDownloadHeader).h(this).f(Integer.valueOf(i3)).b(Integer.valueOf(i2)).c(Boolean.valueOf(z2)).i(Boolean.valueOf(z3)).e(Integer.valueOf(i4)).a());
    }
}
