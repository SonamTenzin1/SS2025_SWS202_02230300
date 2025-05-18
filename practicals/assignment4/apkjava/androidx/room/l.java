package androidx.room;

import android.database.Cursor;
import c.u.a.c;
import java.util.Iterator;
import java.util.List;

/* compiled from: RoomOpenHelper.java */
/* loaded from: classes.dex */
public class l extends c.a {

    /* renamed from: b, reason: collision with root package name */
    private androidx.room.a f2180b;

    /* renamed from: c, reason: collision with root package name */
    private final a f2181c;

    /* renamed from: d, reason: collision with root package name */
    private final String f2182d;

    /* renamed from: e, reason: collision with root package name */
    private final String f2183e;

    /* compiled from: RoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        public final int version;

        public a(int i2) {
            this.version = i2;
        }

        protected abstract void createAllTables(c.u.a.b bVar);

        protected abstract void dropAllTables(c.u.a.b bVar);

        protected abstract void onCreate(c.u.a.b bVar);

        protected abstract void onOpen(c.u.a.b bVar);

        protected abstract void onPostMigrate(c.u.a.b bVar);

        protected abstract void onPreMigrate(c.u.a.b bVar);

        protected abstract b onValidateSchema(c.u.a.b bVar);

        @Deprecated
        protected void validateMigration(c.u.a.b bVar) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    /* compiled from: RoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static class b {
        public final boolean a;

        /* renamed from: b, reason: collision with root package name */
        public final String f2184b;

        public b(boolean z, String str) {
            this.a = z;
            this.f2184b = str;
        }
    }

    public l(androidx.room.a aVar, a aVar2, String str, String str2) {
        super(aVar2.version);
        this.f2180b = aVar;
        this.f2181c = aVar2;
        this.f2182d = str;
        this.f2183e = str2;
    }

    private void h(c.u.a.b bVar) {
        if (k(bVar)) {
            Cursor H0 = bVar.H0(new c.u.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                String string = H0.moveToFirst() ? H0.getString(0) : null;
                H0.close();
                if (!this.f2182d.equals(string) && !this.f2183e.equals(string)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
                return;
            } catch (Throwable th) {
                H0.close();
                throw th;
            }
        }
        b onValidateSchema = this.f2181c.onValidateSchema(bVar);
        if (onValidateSchema.a) {
            this.f2181c.onPostMigrate(bVar);
            l(bVar);
        } else {
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.f2184b);
        }
    }

    private void i(c.u.a.b bVar) {
        bVar.v("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean j(c.u.a.b bVar) {
        Cursor u0 = bVar.u0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (u0.moveToFirst()) {
                if (u0.getInt(0) == 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            u0.close();
        }
    }

    private static boolean k(c.u.a.b bVar) {
        Cursor u0 = bVar.u0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (u0.moveToFirst()) {
                if (u0.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            u0.close();
        }
    }

    private void l(c.u.a.b bVar) {
        i(bVar);
        bVar.v(k.a(this.f2182d));
    }

    @Override // c.u.a.c.a
    public void b(c.u.a.b bVar) {
        super.b(bVar);
    }

    @Override // c.u.a.c.a
    public void d(c.u.a.b bVar) {
        boolean j2 = j(bVar);
        this.f2181c.createAllTables(bVar);
        if (!j2) {
            b onValidateSchema = this.f2181c.onValidateSchema(bVar);
            if (!onValidateSchema.a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.f2184b);
            }
        }
        l(bVar);
        this.f2181c.onCreate(bVar);
    }

    @Override // c.u.a.c.a
    public void e(c.u.a.b bVar, int i2, int i3) {
        g(bVar, i2, i3);
    }

    @Override // c.u.a.c.a
    public void f(c.u.a.b bVar) {
        super.f(bVar);
        h(bVar);
        this.f2181c.onOpen(bVar);
        this.f2180b = null;
    }

    @Override // c.u.a.c.a
    public void g(c.u.a.b bVar, int i2, int i3) {
        boolean z;
        List<androidx.room.s.a> c2;
        androidx.room.a aVar = this.f2180b;
        if (aVar == null || (c2 = aVar.f2119d.c(i2, i3)) == null) {
            z = false;
        } else {
            this.f2181c.onPreMigrate(bVar);
            Iterator<androidx.room.s.a> it = c2.iterator();
            while (it.hasNext()) {
                it.next().migrate(bVar);
            }
            b onValidateSchema = this.f2181c.onValidateSchema(bVar);
            if (onValidateSchema.a) {
                this.f2181c.onPostMigrate(bVar);
                l(bVar);
                z = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + onValidateSchema.f2184b);
            }
        }
        if (z) {
            return;
        }
        androidx.room.a aVar2 = this.f2180b;
        if (aVar2 != null && !aVar2.a(i2, i3)) {
            this.f2181c.dropAllTables(bVar);
            this.f2181c.createAllTables(bVar);
            return;
        }
        throw new IllegalStateException("A migration from " + i2 + " to " + i3 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }
}
