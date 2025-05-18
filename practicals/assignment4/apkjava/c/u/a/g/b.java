package c.u.a.g;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import c.u.a.c;
import java.io.File;

/* compiled from: FrameworkSQLiteOpenHelper.java */
/* loaded from: classes.dex */
class b implements c.u.a.c {

    /* renamed from: f, reason: collision with root package name */
    private final Context f3481f;

    /* renamed from: g, reason: collision with root package name */
    private final String f3482g;

    /* renamed from: h, reason: collision with root package name */
    private final c.a f3483h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f3484i;

    /* renamed from: j, reason: collision with root package name */
    private final Object f3485j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private a f3486k;
    private boolean l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FrameworkSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {

        /* renamed from: f, reason: collision with root package name */
        final c.u.a.g.a[] f3487f;

        /* renamed from: g, reason: collision with root package name */
        final c.a f3488g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f3489h;

        /* compiled from: FrameworkSQLiteOpenHelper.java */
        /* renamed from: c.u.a.g.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0096a implements DatabaseErrorHandler {
            final /* synthetic */ c.a a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ c.u.a.g.a[] f3490b;

            C0096a(c.a aVar, c.u.a.g.a[] aVarArr) {
                this.a = aVar;
                this.f3490b = aVarArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.a.c(a.b(this.f3490b, sQLiteDatabase));
            }
        }

        a(Context context, String str, c.u.a.g.a[] aVarArr, c.a aVar) {
            super(context, str, null, aVar.a, new C0096a(aVar, aVarArr));
            this.f3488g = aVar;
            this.f3487f = aVarArr;
        }

        static c.u.a.g.a b(c.u.a.g.a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            c.u.a.g.a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new c.u.a.g.a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        c.u.a.g.a a(SQLiteDatabase sQLiteDatabase) {
            return b(this.f3487f, sQLiteDatabase);
        }

        synchronized c.u.a.b c() {
            this.f3489h = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f3489h) {
                close();
                return c();
            }
            return a(writableDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f3487f[0] = null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f3488g.b(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f3488g.d(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f3489h = true;
            this.f3488g.e(a(sQLiteDatabase), i2, i3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f3489h) {
                return;
            }
            this.f3488g.f(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f3489h = true;
            this.f3488g.g(a(sQLiteDatabase), i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str, c.a aVar, boolean z) {
        this.f3481f = context;
        this.f3482g = str;
        this.f3483h = aVar;
        this.f3484i = z;
    }

    private a a() {
        a aVar;
        synchronized (this.f3485j) {
            if (this.f3486k == null) {
                c.u.a.g.a[] aVarArr = new c.u.a.g.a[1];
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 23 && this.f3482g != null && this.f3484i) {
                    this.f3486k = new a(this.f3481f, new File(this.f3481f.getNoBackupFilesDir(), this.f3482g).getAbsolutePath(), aVarArr, this.f3483h);
                } else {
                    this.f3486k = new a(this.f3481f, this.f3482g, aVarArr, this.f3483h);
                }
                if (i2 >= 16) {
                    this.f3486k.setWriteAheadLoggingEnabled(this.l);
                }
            }
            aVar = this.f3486k;
        }
        return aVar;
    }

    @Override // c.u.a.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a().close();
    }

    @Override // c.u.a.c
    public String getDatabaseName() {
        return this.f3482g;
    }

    @Override // c.u.a.c
    public c.u.a.b s0() {
        return a().c();
    }

    @Override // c.u.a.c
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.f3485j) {
            a aVar = this.f3486k;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z);
            }
            this.l = z;
        }
    }
}
