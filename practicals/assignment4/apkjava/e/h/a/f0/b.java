package e.h.a.f0;

import android.util.SparseArray;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import e.h.a.f0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NoDatabaseImpl.java */
/* loaded from: classes2.dex */
public class b implements e.h.a.f0.a {
    final SparseArray<FileDownloadModel> a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    final SparseArray<List<com.liulishuo.filedownloader.model.a>> f21246b = new SparseArray<>();

    /* compiled from: NoDatabaseImpl.java */
    /* loaded from: classes2.dex */
    class a implements a.InterfaceC0272a {
        a() {
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void K(FileDownloadModel fileDownloadModel) {
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void T(FileDownloadModel fileDownloadModel) {
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void T0() {
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void f0(int i2, FileDownloadModel fileDownloadModel) {
        }

        @Override // java.lang.Iterable
        public Iterator<FileDownloadModel> iterator() {
            return new C0273b();
        }
    }

    /* compiled from: NoDatabaseImpl.java */
    /* renamed from: e.h.a.f0.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0273b implements Iterator<FileDownloadModel> {
        C0273b() {
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileDownloadModel next() {
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    }

    @Override // e.h.a.f0.a
    public void a(int i2) {
    }

    @Override // e.h.a.f0.a
    public a.InterfaceC0272a b() {
        return new a();
    }

    @Override // e.h.a.f0.a
    public void c(int i2, Throwable th) {
    }

    @Override // e.h.a.f0.a
    public void clear() {
        synchronized (this.a) {
            this.a.clear();
        }
    }

    @Override // e.h.a.f0.a
    public void d(int i2, long j2) {
        remove(i2);
    }

    @Override // e.h.a.f0.a
    public void e(int i2, String str, long j2, long j3, int i3) {
    }

    @Override // e.h.a.f0.a
    public void f(int i2, int i3, long j2) {
        synchronized (this.f21246b) {
            List<com.liulishuo.filedownloader.model.a> list = this.f21246b.get(i2);
            if (list == null) {
                return;
            }
            for (com.liulishuo.filedownloader.model.a aVar : list) {
                if (aVar.d() == i3) {
                    aVar.g(j2);
                    return;
                }
            }
        }
    }

    @Override // e.h.a.f0.a
    public void g(com.liulishuo.filedownloader.model.a aVar) {
        int c2 = aVar.c();
        synchronized (this.f21246b) {
            List<com.liulishuo.filedownloader.model.a> list = this.f21246b.get(c2);
            if (list == null) {
                list = new ArrayList<>();
                this.f21246b.put(c2, list);
            }
            list.add(aVar);
        }
    }

    @Override // e.h.a.f0.a
    public void h(int i2) {
        synchronized (this.f21246b) {
            this.f21246b.remove(i2);
        }
    }

    @Override // e.h.a.f0.a
    public void i(int i2) {
    }

    @Override // e.h.a.f0.a
    public void j(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            e.h.a.k0.d.i(this, "update but model == null!", new Object[0]);
            return;
        }
        if (o(fileDownloadModel.e()) != null) {
            synchronized (this.a) {
                this.a.remove(fileDownloadModel.e());
                this.a.put(fileDownloadModel.e(), fileDownloadModel);
            }
            return;
        }
        r(fileDownloadModel);
    }

    @Override // e.h.a.f0.a
    public void k(int i2, Throwable th, long j2) {
    }

    @Override // e.h.a.f0.a
    public void l(int i2, long j2) {
    }

    @Override // e.h.a.f0.a
    public void m(int i2, long j2, String str, String str2) {
    }

    @Override // e.h.a.f0.a
    public List<com.liulishuo.filedownloader.model.a> n(int i2) {
        List<com.liulishuo.filedownloader.model.a> list;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f21246b) {
            list = this.f21246b.get(i2);
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override // e.h.a.f0.a
    public FileDownloadModel o(int i2) {
        FileDownloadModel fileDownloadModel;
        synchronized (this.a) {
            fileDownloadModel = this.a.get(i2);
        }
        return fileDownloadModel;
    }

    @Override // e.h.a.f0.a
    public void p(int i2, int i3) {
    }

    @Override // e.h.a.f0.a
    public void q(int i2, long j2) {
    }

    public void r(FileDownloadModel fileDownloadModel) {
        synchronized (this.a) {
            this.a.put(fileDownloadModel.e(), fileDownloadModel);
        }
    }

    @Override // e.h.a.f0.a
    public boolean remove(int i2) {
        synchronized (this.a) {
            this.a.remove(i2);
        }
        return true;
    }
}
