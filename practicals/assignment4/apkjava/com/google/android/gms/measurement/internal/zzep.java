package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzep extends u2 {

    /* renamed from: c, reason: collision with root package name */
    private final g3 f18091c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f18092d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzep(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18091c = new g3(this, f(), "google_app_measurement_local.db");
    }

    private static long B(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                long j2 = cursor.getLong(0);
                cursor.close();
                return j2;
            }
            cursor.close();
            return -1L;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean D(int i2, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase;
        ?? r13;
        b();
        d();
        ?? r3 = 0;
        if (this.f18092d) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i2));
        contentValues.put("entry", bArr);
        int i3 = 0;
        int i4 = 5;
        for (int i5 = 5; i3 < i5; i5 = 5) {
            Cursor cursor = null;
            cursor = null;
            cursor = null;
            cursor = null;
            cursor = null;
            Cursor cursor2 = null;
            cursor = null;
            SQLiteDatabase sQLiteDatabase2 = null;
            try {
                sQLiteDatabase = L();
                try {
                    if (sQLiteDatabase == null) {
                        try {
                            this.f18092d = true;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            return r3;
                        } catch (SQLiteFullException e2) {
                            e = e2;
                            try {
                                h().H().b("Error writing entry to local database", e);
                                this.f18092d = true;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase == null) {
                                    sQLiteDatabase.close();
                                }
                                i3++;
                                r3 = 0;
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            r13 = 0;
                            sQLiteDatabase2 = sQLiteDatabase;
                            r13 = r13;
                            if (sQLiteDatabase2 != null) {
                                try {
                                    if (sQLiteDatabase2.inTransaction()) {
                                        sQLiteDatabase2.endTransaction();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor = r13;
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    throw th;
                                }
                            }
                            h().H().b("Error writing entry to local database", e);
                            this.f18092d = true;
                            if (r13 != 0) {
                                r13.close();
                            }
                            if (sQLiteDatabase2 == null) {
                                sQLiteDatabase2.close();
                            }
                            i3++;
                            r3 = 0;
                        }
                    } else {
                        try {
                            sQLiteDatabase.beginTransaction();
                            long j2 = 0;
                            r13 = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                            if (r13 != 0) {
                                try {
                                    if (r13.moveToFirst()) {
                                        j2 = r13.getLong(r3);
                                    }
                                } catch (SQLiteDatabaseLockedException unused) {
                                    cursor2 = r13;
                                    SystemClock.sleep(i4);
                                    i4 += 20;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    i3++;
                                    r3 = 0;
                                } catch (SQLiteFullException e4) {
                                    e = e4;
                                    cursor = r13;
                                    h().H().b("Error writing entry to local database", e);
                                    this.f18092d = true;
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabase == null) {
                                    }
                                    i3++;
                                    r3 = 0;
                                } catch (SQLiteException e5) {
                                    e = e5;
                                    sQLiteDatabase2 = sQLiteDatabase;
                                    r13 = r13;
                                    if (sQLiteDatabase2 != null) {
                                    }
                                    h().H().b("Error writing entry to local database", e);
                                    this.f18092d = true;
                                    if (r13 != 0) {
                                    }
                                    if (sQLiteDatabase2 == null) {
                                    }
                                    i3++;
                                    r3 = 0;
                                } catch (Throwable th3) {
                                    th = th3;
                                    cursor = r13;
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    throw th;
                                }
                            }
                            if (j2 >= 100000) {
                                h().H().a("Data loss, local db full");
                                long j3 = (100000 - j2) + 1;
                                String[] strArr = new String[1];
                                strArr[r3] = Long.toString(j3);
                                long delete = sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                                if (delete != j3) {
                                    h().H().d("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j3), Long.valueOf(delete), Long.valueOf(j3 - delete));
                                }
                            }
                            sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                            if (r13 != 0) {
                                r13.close();
                            }
                            sQLiteDatabase.close();
                            return true;
                        } catch (SQLiteFullException e6) {
                            e = e6;
                        } catch (SQLiteException e7) {
                            e = e7;
                            r13 = 0;
                        } catch (Throwable th4) {
                            th = th4;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused2) {
                    cursor2 = null;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                sQLiteDatabase = null;
            } catch (SQLiteFullException e8) {
                e = e8;
                sQLiteDatabase = null;
            } catch (SQLiteException e9) {
                e = e9;
                r13 = 0;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase = null;
            }
        }
        h().K().a("Failed to write entry to local database");
        return false;
    }

    @VisibleForTesting
    private final SQLiteDatabase L() throws SQLiteException {
        if (this.f18092d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f18091c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f18092d = true;
        return null;
    }

    @VisibleForTesting
    private final boolean M() {
        return f().getDatabasePath("google_app_measurement_local.db").exists();
    }

    @Override // com.google.android.gms.measurement.internal.u2
    protected final boolean A() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x024a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x024a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x024a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0259  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v22, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<AbstractSafeParcelable> C(int i2) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase2;
        long j2;
        int i3;
        zzkj zzkjVar;
        zzv zzvVar;
        String str;
        String[] strArr;
        d();
        b();
        ?? r3 = 0;
        if (this.f18092d) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!M()) {
            return arrayList;
        }
        int i4 = 0;
        int i5 = 5;
        for (int i6 = 5; i4 < i6; i6 = 5) {
            try {
                sQLiteDatabase = L();
                try {
                    if (sQLiteDatabase == null) {
                        try {
                            this.f18092d = true;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            return r3;
                        } catch (SQLiteFullException e2) {
                            e = e2;
                            cursor = r3;
                            h().H().b("Error reading entries from local database", e);
                            this.f18092d = true;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            i4++;
                            r3 = 0;
                        } catch (SQLiteException e3) {
                            e = e3;
                            cursor = r3;
                            if (sQLiteDatabase != null) {
                            }
                            h().H().b("Error reading entries from local database", e);
                            this.f18092d = true;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            i4++;
                            r3 = 0;
                        } catch (Throwable th) {
                            th = th;
                            if (r3 != 0) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    } else {
                        try {
                            sQLiteDatabase.beginTransaction();
                            j2 = -1;
                        } catch (SQLiteFullException e4) {
                            e = e4;
                        } catch (SQLiteException e5) {
                            e = e5;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            if (n().r(zzap.G0)) {
                                long B = B(sQLiteDatabase);
                                if (B != -1) {
                                    try {
                                        str = "rowid<?";
                                        strArr = new String[]{String.valueOf(B)};
                                    } catch (SQLiteFullException e6) {
                                        e = e6;
                                        cursor = null;
                                        h().H().b("Error reading entries from local database", e);
                                        this.f18092d = true;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        i4++;
                                        r3 = 0;
                                    } catch (SQLiteException e7) {
                                        e = e7;
                                        cursor = null;
                                        if (sQLiteDatabase != null) {
                                            try {
                                                if (sQLiteDatabase.inTransaction()) {
                                                    sQLiteDatabase.endTransaction();
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                r3 = cursor;
                                                if (r3 != 0) {
                                                    r3.close();
                                                }
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.close();
                                                }
                                                throw th;
                                            }
                                        }
                                        h().H().b("Error reading entries from local database", e);
                                        this.f18092d = true;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        i4++;
                                        r3 = 0;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        r3 = 0;
                                        if (r3 != 0) {
                                        }
                                        if (sQLiteDatabase != null) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    str = null;
                                    strArr = null;
                                }
                                String str2 = str;
                                i3 = 3;
                                String[] strArr2 = strArr;
                                r3 = sQLiteDatabase;
                                cursor = sQLiteDatabase.query("messages", new String[]{"rowid", "type", "entry"}, str2, strArr2, null, null, "rowid asc", Integer.toString(100));
                            } else {
                                SQLiteDatabase sQLiteDatabase3 = sQLiteDatabase;
                                i3 = 3;
                                cursor = sQLiteDatabase3.query("messages", new String[]{"rowid", "type", "entry"}, null, null, null, null, "rowid asc", Integer.toString(100));
                                r3 = sQLiteDatabase3;
                            }
                            while (cursor.moveToNext()) {
                                try {
                                    j2 = cursor.getLong(0);
                                    int i7 = cursor.getInt(1);
                                    byte[] blob = cursor.getBlob(2);
                                    if (i7 == 0) {
                                        Parcel obtain = Parcel.obtain();
                                        try {
                                            try {
                                                obtain.unmarshall(blob, 0, blob.length);
                                                obtain.setDataPosition(0);
                                                zzan createFromParcel = zzan.CREATOR.createFromParcel(obtain);
                                                if (createFromParcel != null) {
                                                    arrayList.add(createFromParcel);
                                                }
                                            } finally {
                                            }
                                        } catch (SafeParcelReader.ParseException unused) {
                                            h().H().a("Failed to load event from local database");
                                            obtain.recycle();
                                        }
                                    } else if (i7 == 1) {
                                        Parcel obtain2 = Parcel.obtain();
                                        try {
                                            try {
                                                obtain2.unmarshall(blob, 0, blob.length);
                                                obtain2.setDataPosition(0);
                                                zzkjVar = zzkj.CREATOR.createFromParcel(obtain2);
                                            } finally {
                                            }
                                        } catch (SafeParcelReader.ParseException unused2) {
                                            h().H().a("Failed to load user property from local database");
                                            obtain2.recycle();
                                            zzkjVar = null;
                                        }
                                        if (zzkjVar != null) {
                                            arrayList.add(zzkjVar);
                                        }
                                    } else if (i7 == 2) {
                                        Parcel obtain3 = Parcel.obtain();
                                        try {
                                            try {
                                                obtain3.unmarshall(blob, 0, blob.length);
                                                obtain3.setDataPosition(0);
                                                zzvVar = zzv.CREATOR.createFromParcel(obtain3);
                                            } finally {
                                            }
                                        } catch (SafeParcelReader.ParseException unused3) {
                                            h().H().a("Failed to load user property from local database");
                                            obtain3.recycle();
                                            zzvVar = null;
                                        }
                                        if (zzvVar != null) {
                                            arrayList.add(zzvVar);
                                        }
                                    } else if (i7 == i3) {
                                        h().K().a("Skipping app launch break");
                                    } else {
                                        h().H().a("Unknown record type in local database");
                                    }
                                } catch (SQLiteDatabaseLockedException unused4) {
                                    sQLiteDatabase2 = r3;
                                    SystemClock.sleep(i5);
                                    i5 += 20;
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabase2 == null) {
                                    }
                                    i4++;
                                    r3 = 0;
                                } catch (SQLiteFullException e8) {
                                    e = e8;
                                    sQLiteDatabase = r3;
                                    h().H().b("Error reading entries from local database", e);
                                    this.f18092d = true;
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    i4++;
                                    r3 = 0;
                                } catch (SQLiteException e9) {
                                    e = e9;
                                    sQLiteDatabase = r3;
                                    if (sQLiteDatabase != null) {
                                    }
                                    h().H().b("Error reading entries from local database", e);
                                    this.f18092d = true;
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    i4++;
                                    r3 = 0;
                                } catch (Throwable th5) {
                                    th = th5;
                                    sQLiteDatabase = r3;
                                    r3 = cursor;
                                    if (r3 != 0) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    throw th;
                                }
                            }
                            if (r3.delete("messages", "rowid <= ?", new String[]{Long.toString(j2)}) < arrayList.size()) {
                                h().H().a("Fewer entries removed from local database than expected");
                            }
                            r3.setTransactionSuccessful();
                            r3.endTransaction();
                            cursor.close();
                            r3.close();
                            return arrayList;
                        } catch (SQLiteDatabaseLockedException unused5) {
                            sQLiteDatabase2 = r3;
                            cursor = null;
                            SystemClock.sleep(i5);
                            i5 += 20;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase2 == null) {
                                sQLiteDatabase2.close();
                            }
                            i4++;
                            r3 = 0;
                        } catch (SQLiteFullException e10) {
                            e = e10;
                            sQLiteDatabase = r3;
                        } catch (SQLiteException e11) {
                            e = e11;
                            sQLiteDatabase = r3;
                        } catch (Throwable th6) {
                            th = th6;
                            sQLiteDatabase = r3;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused6) {
                    r3 = sQLiteDatabase;
                }
            } catch (SQLiteDatabaseLockedException unused7) {
                cursor = null;
                sQLiteDatabase2 = null;
            } catch (SQLiteFullException e12) {
                e = e12;
                cursor = null;
                sQLiteDatabase = null;
            } catch (SQLiteException e13) {
                e = e13;
                cursor = null;
                sQLiteDatabase = null;
            } catch (Throwable th7) {
                th = th7;
                r3 = 0;
                sQLiteDatabase = null;
            }
        }
        h().K().a("Failed to read events from database in reasonable time");
        return null;
    }

    public final boolean E(zzan zzanVar) {
        Parcel obtain = Parcel.obtain();
        zzanVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            h().K().a("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return D(0, marshall);
    }

    public final boolean F(zzkj zzkjVar) {
        Parcel obtain = Parcel.obtain();
        zzkjVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            h().K().a("User property too long for local database. Sending directly to service");
            return false;
        }
        return D(1, marshall);
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    public final boolean H(zzv zzvVar) {
        l();
        byte[] g0 = zzkk.g0(zzvVar);
        if (g0.length > 131072) {
            h().K().a("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return D(2, g0);
    }

    public final void I() {
        b();
        d();
        try {
            int delete = L().delete("messages", null, null) + 0;
            if (delete > 0) {
                h().P().b("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            h().H().b("Error resetting local analytics data. error", e2);
        }
    }

    public final boolean J() {
        return D(3, new byte[0]);
    }

    public final boolean K() {
        d();
        b();
        if (this.f18092d || !M()) {
            return false;
        }
        int i2 = 5;
        for (int i3 = 0; i3 < 5; i3++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase L = L();
                    if (L == null) {
                        this.f18092d = true;
                        if (L != null) {
                            L.close();
                        }
                        return false;
                    }
                    L.beginTransaction();
                    L.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    L.setTransactionSuccessful();
                    L.endTransaction();
                    L.close();
                    return true;
                } catch (SQLiteFullException e2) {
                    h().H().b("Error deleting app launch break from local database", e2);
                    this.f18092d = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep(i2);
                i2 += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e3) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                h().H().b("Error deleting app launch break from local database", e3);
                this.f18092d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        h().K().a("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzb o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzhc p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzeq q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzik r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzif s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzep t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzjl u() {
        return super.u();
    }
}
