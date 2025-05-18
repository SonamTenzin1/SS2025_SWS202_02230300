package e.h.a.f0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import e.h.a.f0.a;
import e.h.a.k0.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: SqliteDatabaseImpl.java */
/* loaded from: classes2.dex */
public class d implements e.h.a.f0.a {
    private final SQLiteDatabase a = new e(e.h.a.k0.c.a()).getWritableDatabase();

    /* compiled from: SqliteDatabaseImpl.java */
    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0272a {

        /* renamed from: f, reason: collision with root package name */
        private final SparseArray<FileDownloadModel> f21256f;

        /* renamed from: g, reason: collision with root package name */
        private b f21257g;

        /* renamed from: h, reason: collision with root package name */
        private final SparseArray<FileDownloadModel> f21258h;

        /* renamed from: i, reason: collision with root package name */
        private final SparseArray<List<com.liulishuo.filedownloader.model.a>> f21259i;

        a(d dVar) {
            this(null, null);
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void K(FileDownloadModel fileDownloadModel) {
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void T(FileDownloadModel fileDownloadModel) {
            SparseArray<FileDownloadModel> sparseArray = this.f21258h;
            if (sparseArray != null) {
                sparseArray.put(fileDownloadModel.e(), fileDownloadModel);
            }
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void T0() {
            b bVar = this.f21257g;
            if (bVar != null) {
                bVar.c();
            }
            int size = this.f21256f.size();
            if (size < 0) {
                return;
            }
            d.this.a.beginTransaction();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    int keyAt = this.f21256f.keyAt(i2);
                    FileDownloadModel fileDownloadModel = this.f21256f.get(keyAt);
                    d.this.a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                    d.this.a.insert("filedownloader", null, fileDownloadModel.C());
                    if (fileDownloadModel.a() > 1) {
                        List<com.liulishuo.filedownloader.model.a> n = d.this.n(keyAt);
                        if (n.size() > 0) {
                            d.this.a.delete("filedownloaderConnection", "id = ?", new String[]{String.valueOf(keyAt)});
                            for (com.liulishuo.filedownloader.model.a aVar : n) {
                                aVar.i(fileDownloadModel.e());
                                d.this.a.insert("filedownloaderConnection", null, aVar.l());
                            }
                        }
                    }
                } finally {
                    d.this.a.endTransaction();
                }
            }
            SparseArray<FileDownloadModel> sparseArray = this.f21258h;
            if (sparseArray != null && this.f21259i != null) {
                int size2 = sparseArray.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    int e2 = this.f21258h.valueAt(i3).e();
                    List<com.liulishuo.filedownloader.model.a> n2 = d.this.n(e2);
                    if (n2 != null && n2.size() > 0) {
                        this.f21259i.put(e2, n2);
                    }
                }
            }
            d.this.a.setTransactionSuccessful();
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void f0(int i2, FileDownloadModel fileDownloadModel) {
            this.f21256f.put(i2, fileDownloadModel);
        }

        @Override // java.lang.Iterable
        public Iterator<FileDownloadModel> iterator() {
            b bVar = new b();
            this.f21257g = bVar;
            return bVar;
        }

        a(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<com.liulishuo.filedownloader.model.a>> sparseArray2) {
            this.f21256f = new SparseArray<>();
            this.f21258h = sparseArray;
            this.f21259i = sparseArray2;
        }
    }

    /* compiled from: SqliteDatabaseImpl.java */
    /* loaded from: classes2.dex */
    class b implements Iterator<FileDownloadModel> {

        /* renamed from: f, reason: collision with root package name */
        private final Cursor f21261f;

        /* renamed from: g, reason: collision with root package name */
        private final List<Integer> f21262g = new ArrayList();

        /* renamed from: h, reason: collision with root package name */
        private int f21263h;

        b() {
            this.f21261f = d.this.a.rawQuery("SELECT * FROM filedownloader", null);
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileDownloadModel next() {
            FileDownloadModel t = d.t(this.f21261f);
            this.f21263h = t.e();
            return t;
        }

        void c() {
            this.f21261f.close();
            if (this.f21262g.isEmpty()) {
                return;
            }
            String join = TextUtils.join(", ", this.f21262g);
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "delete %s", join);
            }
            d.this.a.execSQL(f.o("DELETE FROM %s WHERE %s IN (%s);", "filedownloader", "_id", join));
            d.this.a.execSQL(f.o("DELETE FROM %s WHERE %s IN (%s);", "filedownloaderConnection", DeepLinkIntentReceiver.DeepLinksKeys.ID, join));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21261f.moveToNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f21262g.add(Integer.valueOf(this.f21263h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileDownloadModel t(Cursor cursor) {
        FileDownloadModel fileDownloadModel = new FileDownloadModel();
        fileDownloadModel.v(cursor.getInt(cursor.getColumnIndex("_id")));
        fileDownloadModel.B(cursor.getString(cursor.getColumnIndex("url")));
        fileDownloadModel.w(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        fileDownloadModel.y((byte) cursor.getShort(cursor.getColumnIndex("status")));
        fileDownloadModel.x(cursor.getLong(cursor.getColumnIndex("sofar")));
        fileDownloadModel.z(cursor.getLong(cursor.getColumnIndex("total")));
        fileDownloadModel.t(cursor.getString(cursor.getColumnIndex("errMsg")));
        fileDownloadModel.s(cursor.getString(cursor.getColumnIndex("etag")));
        fileDownloadModel.u(cursor.getString(cursor.getColumnIndex("filename")));
        fileDownloadModel.r(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return fileDownloadModel;
    }

    private void w(int i2, ContentValues contentValues) {
        this.a.update("filedownloader", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
    }

    @Override // e.h.a.f0.a
    public void a(int i2) {
    }

    @Override // e.h.a.f0.a
    public a.InterfaceC0272a b() {
        return new a(this);
    }

    @Override // e.h.a.f0.a
    public void c(int i2, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public void clear() {
        this.a.delete("filedownloader", null, null);
        this.a.delete("filedownloaderConnection", null, null);
    }

    @Override // e.h.a.f0.a
    public void d(int i2, long j2) {
        remove(i2);
    }

    @Override // e.h.a.f0.a
    public void e(int i2, String str, long j2, long j3, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j2));
        contentValues.put("total", Long.valueOf(j3));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i3));
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public void f(int i2, int i3, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j2));
        this.a.update("filedownloaderConnection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
    }

    @Override // e.h.a.f0.a
    public void g(com.liulishuo.filedownloader.model.a aVar) {
        this.a.insert("filedownloaderConnection", null, aVar.l());
    }

    @Override // e.h.a.f0.a
    public void h(int i2) {
        this.a.execSQL("DELETE FROM filedownloaderConnection WHERE id = " + i2);
    }

    @Override // e.h.a.f0.a
    public void i(int i2) {
    }

    @Override // e.h.a.f0.a
    public void j(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            e.h.a.k0.d.i(this, "update but model == null!", new Object[0]);
        } else if (o(fileDownloadModel.e()) != null) {
            this.a.update("filedownloader", fileDownloadModel.C(), "_id = ? ", new String[]{String.valueOf(fileDownloadModel.e())});
        } else {
            u(fileDownloadModel);
        }
    }

    @Override // e.h.a.f0.a
    public void k(int i2, Throwable th, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j2));
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public void l(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j2));
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public void m(int i2, long j2, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("filename", str2);
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public List<com.liulishuo.filedownloader.model.a> n(int i2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.a.rawQuery(f.o("SELECT * FROM %s WHERE %s = ?", "filedownloaderConnection", DeepLinkIntentReceiver.DeepLinksKeys.ID), new String[]{Integer.toString(i2)});
            while (cursor.moveToNext()) {
                com.liulishuo.filedownloader.model.a aVar = new com.liulishuo.filedownloader.model.a();
                aVar.i(i2);
                aVar.j(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                aVar.k(cursor.getLong(cursor.getColumnIndex("startOffset")));
                aVar.g(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                aVar.h(cursor.getLong(cursor.getColumnIndex("endOffset")));
                arrayList.add(aVar);
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // e.h.a.f0.a
    public FileDownloadModel o(int i2) {
        Throwable th;
        Cursor cursor;
        try {
            cursor = this.a.rawQuery(f.o("SELECT * FROM %s WHERE %s = ?", "filedownloader", "_id"), new String[]{Integer.toString(i2)});
            try {
                if (!cursor.moveToNext()) {
                    cursor.close();
                    return null;
                }
                FileDownloadModel t = t(cursor);
                cursor.close();
                return t;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // e.h.a.f0.a
    public void p(int i2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i3));
        this.a.update("filedownloader", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
    }

    @Override // e.h.a.f0.a
    public void q(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j2));
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public boolean remove(int i2) {
        return this.a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(i2)}) != 0;
    }

    public void u(FileDownloadModel fileDownloadModel) {
        this.a.insert("filedownloader", null, fileDownloadModel.C());
    }

    public a.InterfaceC0272a v(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<com.liulishuo.filedownloader.model.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }
}
