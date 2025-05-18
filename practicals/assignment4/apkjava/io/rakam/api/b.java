package io.rakam.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.database.room.RoomNotification;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DatabaseHelper.java */
/* loaded from: classes2.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: f, reason: collision with root package name */
    static final Map<String, b> f21917f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private static final h f21918g = h.d();

    /* renamed from: h, reason: collision with root package name */
    File f21919h;

    /* renamed from: i, reason: collision with root package name */
    private String f21920i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f21921j;

    /* renamed from: k, reason: collision with root package name */
    private c f21922k;

    protected b(Context context, String str) {
        super(context, l(str), (SQLiteDatabase.CursorFactory) null, 3);
        this.f21921j = true;
        this.f21919h = context.getDatabasePath(l(str));
        this.f21920i = j.e(str);
    }

    private synchronized long H(String str, long j2) {
        long j3;
        j3 = -1;
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                try {
                    SQLiteStatement compileStatement = getReadableDatabase().compileStatement("SELECT id FROM " + str + " LIMIT 1 OFFSET " + (j2 - 1));
                    try {
                        j3 = compileStatement.simpleQueryForLong();
                    } catch (SQLiteDoneException e2) {
                        f21918g.h("io.rakam.api.DatabaseHelper", e2);
                    }
                    if (compileStatement != null) {
                        compileStatement.close();
                    }
                } catch (StackOverflowError e3) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("getNthEventId from %s failed", str), e3);
                    e.e().g(String.format("DB: Failed to getNthEventId from table %s", str), e3);
                    e();
                    if (0 != 0) {
                        sQLiteStatement.close();
                    }
                }
            } catch (SQLiteException e4) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("getNthEventId from %s failed", str), e4);
                e.e().g(String.format("DB: Failed to getNthEventId from table %s", str), e4);
                e();
                if (0 != 0) {
                    sQLiteStatement.close();
                }
            }
            close();
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteStatement.close();
            }
            close();
            throw th;
        }
        return j3;
    }

    private synchronized long b(String str, String str2) {
        StackOverflowError e2;
        long j2;
        SQLiteException e3;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("event", str2);
                j2 = Q(writableDatabase, str, contentValues);
                if (j2 == -1) {
                    try {
                        f21918g.g("io.rakam.api.DatabaseHelper", String.format("Insert into %s failed", str));
                    } catch (SQLiteException e4) {
                        e3 = e4;
                        f21918g.c("io.rakam.api.DatabaseHelper", String.format("addEvent to %s failed", str), e3);
                        e.e().g(String.format("DB: Failed to addEvent: %s", str2), e3);
                        e();
                        return j2;
                    } catch (StackOverflowError e5) {
                        e2 = e5;
                        f21918g.c("io.rakam.api.DatabaseHelper", String.format("addEvent to %s failed", str), e2);
                        e.e().g(String.format("DB: Failed to addEvent: %s", str2), e2);
                        e();
                        return j2;
                    }
                }
            } catch (SQLiteException e6) {
                e3 = e6;
                j2 = -1;
            } catch (StackOverflowError e7) {
                e2 = e7;
                j2 = -1;
            }
        } finally {
            close();
        }
        return j2;
    }

    private static void d(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        if (j.d(message)) {
            throw runtimeException;
        }
        if (message.startsWith("Cursor window allocation of")) {
            throw new CursorWindowAllocationException(message);
        }
        throw runtimeException;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e9, code lost:
    
        if (r3.isOpen() != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00eb, code lost:
    
        close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0112, code lost:
    
        if (r3.isOpen() != false) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                close();
                this.f21919h.delete();
            } catch (SecurityException e2) {
                f21918g.c("io.rakam.api.DatabaseHelper", "delete failed", e2);
                e.e().f("DB: Failed to delete database");
                if (this.f21922k == null || !this.f21921j) {
                    return;
                }
                this.f21921j = false;
                try {
                    try {
                        sQLiteDatabase = getWritableDatabase();
                        this.f21922k.a(sQLiteDatabase);
                        this.f21921j = true;
                        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                            return;
                        }
                    } catch (SQLiteException e3) {
                        f21918g.c("io.rakam.api.DatabaseHelper", String.format("databaseReset callback failed during delete", new Object[0]), e3);
                        e.e().g(String.format("DB: Failed to run databaseReset callback in delete", new Object[0]), e3);
                        this.f21921j = true;
                        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    this.f21921j = true;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        close();
                    }
                    throw th;
                }
            }
            if (this.f21922k == null || !this.f21921j) {
                return;
            }
            this.f21921j = false;
            try {
                try {
                    sQLiteDatabase = getWritableDatabase();
                    this.f21922k.a(sQLiteDatabase);
                    this.f21921j = true;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        return;
                    }
                } catch (SQLiteException e4) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("databaseReset callback failed during delete", new Object[0]), e4);
                    e.e().g(String.format("DB: Failed to run databaseReset callback in delete", new Object[0]), e4);
                    this.f21921j = true;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        return;
                    }
                }
                close();
            } catch (Throwable th2) {
                this.f21921j = true;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    close();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            if (this.f21922k != null && this.f21921j) {
                this.f21921j = false;
                try {
                    try {
                        sQLiteDatabase = getWritableDatabase();
                        this.f21922k.a(sQLiteDatabase);
                        this.f21921j = true;
                        if (sQLiteDatabase != null) {
                        }
                    } catch (SQLiteException e5) {
                        f21918g.c("io.rakam.api.DatabaseHelper", String.format("databaseReset callback failed during delete", new Object[0]), e5);
                        e.e().g(String.format("DB: Failed to run databaseReset callback in delete", new Object[0]), e5);
                        this.f21921j = true;
                        if (sQLiteDatabase != null) {
                        }
                        throw th3;
                    }
                } catch (Throwable th4) {
                    this.f21921j = true;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        close();
                    }
                    throw th4;
                }
            }
            throw th3;
        }
    }

    private synchronized void i0(String str, long j2) {
        try {
            try {
                try {
                    getWritableDatabase().delete(str, "id = " + j2, null);
                } catch (SQLiteException e2) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("removeEvent from %s failed", str), e2);
                    e.e().g(String.format("DB: Failed to removeEvent from table %s", str), e2);
                    e();
                }
            } catch (StackOverflowError e3) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("removeEvent from %s failed", str), e3);
                e.e().g(String.format("DB: Failed to removeEvent from table %s", str), e3);
                e();
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static b j(Context context) {
        return k(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized b k(Context context, String str) {
        b bVar;
        synchronized (b.class) {
            String e2 = j.e(str);
            Map<String, b> map = f21917f;
            bVar = map.get(e2);
            if (bVar == null) {
                bVar = new b(context.getApplicationContext(), e2);
                map.put(e2, bVar);
            }
        }
        return bVar;
    }

    private static String l(String str) {
        if (j.d(str) || str.equals("$default_instance")) {
            return "io.rakam.api";
        }
        return "io.rakam.api_" + str;
    }

    private synchronized void n0(String str, long j2) {
        try {
            try {
                try {
                    getWritableDatabase().delete(str, "id <= " + j2, null);
                } catch (SQLiteException e2) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("removeEvents from %s failed", str), e2);
                    e.e().g(String.format("DB: Failed to removeEvents from table %s", str), e2);
                    e();
                }
            } catch (StackOverflowError e3) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("removeEvents from %s failed", str), e3);
                e.e().g(String.format("DB: Failed to removeEvents from table %s", str), e3);
                e();
            }
        } finally {
        }
    }

    private synchronized long p(String str) {
        long j2;
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                try {
                    sQLiteStatement = getReadableDatabase().compileStatement("SELECT COUNT(*) FROM " + str);
                    j2 = sQLiteStatement.simpleQueryForLong();
                    sQLiteStatement.close();
                    close();
                } catch (SQLiteException e2) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("getNumberRows for %s failed", str), e2);
                    e.e().g(String.format("DB: Failed to getNumberRows for table %s", str), e2);
                    e();
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    j2 = 0;
                    return j2;
                }
            } catch (StackOverflowError e3) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("getNumberRows for %s failed", str), e3);
                e.e().g(String.format("DB: Failed to getNumberRows for table %s", str), e3);
                e();
                j2 = 0;
                return j2;
            }
        } finally {
            if (0 != 0) {
                sQLiteStatement.close();
            }
            close();
        }
        return j2;
    }

    private void t0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS long_store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identifys");
        onCreate(sQLiteDatabase);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<JSONObject> A(long j2, long j3) throws JSONException {
        return y("identifys", j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Long B(String str) {
        return (Long) N("long_store", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long D(long j2) {
        return H("events", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long I(long j2) {
        return H("identifys", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long J() {
        return m() + z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String K(String str) {
        return (String) N(AccountAnalytics.STORE, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00ca: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:46:0x00ca */
    protected synchronized Object N(String str, String str2) {
        Cursor cursor;
        Object obj;
        Cursor cursor2;
        cursor = null;
        try {
        } catch (Throwable th) {
            th = th;
            cursor = obj;
        }
        try {
            cursor2 = e0(getReadableDatabase(), str, new String[]{RoomNotification.KEY, "value"}, "key = ?", new String[]{str2}, null, null, null, null);
            try {
                if (cursor2.moveToFirst()) {
                    cursor = str.equals(AccountAnalytics.STORE) ? cursor2.getString(1) : Long.valueOf(cursor2.getLong(1));
                }
                cursor2.close();
            } catch (SQLiteException e2) {
                e = e2;
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("getValue from %s failed", str), e);
                e.e().g(String.format("DB: Failed to getValue: %s", str2), e);
                e();
                if (cursor2 != null) {
                    cursor2.close();
                }
                close();
                return cursor;
            } catch (RuntimeException e3) {
                e = e3;
                e.e().g(String.format("DB: Failed to getValue: %s", str2), e);
                d(e);
                if (cursor2 != null) {
                    cursor2.close();
                }
                close();
                return cursor;
            } catch (StackOverflowError e4) {
                e = e4;
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("getValue from %s failed", str), e);
                e.e().g(String.format("DB: Failed to getValue: %s", str2), e);
                e();
                if (cursor2 != null) {
                    cursor2.close();
                }
                close();
                return cursor;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursor2 = null;
        } catch (RuntimeException e6) {
            e = e6;
            cursor2 = null;
        } catch (StackOverflowError e7) {
            e = e7;
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            close();
            throw th;
        }
        close();
        return cursor;
    }

    synchronized long Q(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws SQLiteException, StackOverflowError {
        return sQLiteDatabase.insert(str, null, contentValues);
    }

    synchronized long T(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws SQLiteException, StackOverflowError {
        return sQLiteDatabase.insertWithOnConflict(str, null, contentValues, 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long W(String str, Long l) {
        long a0;
        if (l == null) {
            a0 = f("long_store", str);
        } else {
            a0 = a0("long_store", str, l);
        }
        return a0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long Y(String str, String str2) {
        long a0;
        if (str2 == null) {
            a0 = f(AccountAnalytics.STORE, str);
        } else {
            a0 = a0(AccountAnalytics.STORE, str, str2);
        }
        return a0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long Z(SQLiteDatabase sQLiteDatabase, String str, String str2, Object obj) throws SQLiteException, StackOverflowError {
        long T;
        ContentValues contentValues = new ContentValues();
        contentValues.put(RoomNotification.KEY, str2);
        if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            contentValues.put("value", (String) obj);
        }
        T = T(sQLiteDatabase, str, contentValues);
        if (T == -1) {
            f21918g.g("io.rakam.api.DatabaseHelper", "Insert failed");
        }
        return T;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long a(String str) {
        return b("events", str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        if (r2.isOpen() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        if (r2.isOpen() != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    synchronized long a0(String str, String str2, Object obj) {
        long j2;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                try {
                    sQLiteDatabase = getWritableDatabase();
                    j2 = Z(sQLiteDatabase, str, str2, obj);
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        close();
                    }
                } catch (StackOverflowError e2) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("insertOrReplaceKeyValue in %s failed", str), e2);
                    e.e().g(String.format("DB: Failed to insertOrReplaceKeyValue %s", str2), e2);
                    e();
                    if (sQLiteDatabase != null) {
                    }
                    j2 = -1;
                    return j2;
                }
            } catch (SQLiteException e3) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("insertOrReplaceKeyValue in %s failed", str), e3);
                e.e().g(String.format("DB: Failed to insertOrReplaceKeyValue %s", str2), e3);
                e();
                if (sQLiteDatabase != null) {
                }
                j2 = -1;
                return j2;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                close();
            }
            throw th;
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long c(String str) {
        return b("identifys", str);
    }

    Cursor e0(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    synchronized long f(String str, String str2) {
        long j2;
        try {
            try {
                try {
                    j2 = getWritableDatabase().delete(str, "key=?", new String[]{str2});
                } catch (StackOverflowError e2) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("deleteKey from %s failed", str), e2);
                    e.e().g(String.format("DB: Failed to deleteKey: %s", str2), e2);
                    e();
                    close();
                    j2 = -1;
                    return j2;
                }
            } catch (SQLiteException e3) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("deleteKey from %s failed", str), e3);
                e.e().g(String.format("DB: Failed to deleteKey: %s", str2), e3);
                e();
                close();
                j2 = -1;
                return j2;
            }
        } finally {
            close();
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void f0(long j2) {
        i0("events", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long m() {
        return p("events");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void m0(long j2) {
        n0("events", j2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        c cVar = this.f21922k;
        if (cVar == null || !this.f21921j) {
            return;
        }
        try {
            try {
                this.f21921j = false;
                cVar.a(sQLiteDatabase);
            } catch (SQLiteException e2) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("databaseReset callback failed during onCreate", new Object[0]), e2);
                e.e().g(String.format("DB: Failed to run databaseReset callback during onCreate", new Object[0]), e2);
            }
        } finally {
            this.f21921j = true;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 > i3) {
            f21918g.b("io.rakam.api.DatabaseHelper", "onUpgrade() with invalid oldVersion and newVersion");
            t0(sQLiteDatabase);
            return;
        }
        if (i3 <= 1) {
            return;
        }
        if (i2 == 1) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);");
            if (i3 <= 2) {
                return;
            }
        } else if (i2 != 2) {
            if (i2 != 3) {
                f21918g.b("io.rakam.api.DatabaseHelper", "onUpgrade() with unknown oldVersion " + i2);
                t0(sQLiteDatabase);
                return;
            }
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void p0(long j2) {
        i0("identifys", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void q0(long j2) {
        n0("identifys", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<JSONObject> x(long j2, long j3) throws JSONException {
        return y("events", j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x0(c cVar) {
        this.f21922k = cVar;
    }

    protected synchronized List<JSONObject> y(String str, long j2, long j3) throws JSONException {
        LinkedList linkedList;
        String str2;
        String str3;
        linkedList = new LinkedList();
        Cursor cursor = null;
        try {
            try {
                try {
                    try {
                        SQLiteDatabase readableDatabase = getReadableDatabase();
                        String[] strArr = {DeepLinkIntentReceiver.DeepLinksKeys.ID, "event"};
                        if (j2 >= 0) {
                            str2 = "id <= " + j2;
                        } else {
                            str2 = null;
                        }
                        if (j3 >= 0) {
                            str3 = HttpUrl.FRAGMENT_ENCODE_SET + j3;
                        } else {
                            str3 = null;
                        }
                        cursor = e0(readableDatabase, str, strArr, str2, null, null, null, "id ASC", str3);
                        while (cursor.moveToNext()) {
                            long j4 = cursor.getLong(0);
                            String string = cursor.getString(1);
                            if (!j.d(string)) {
                                JSONObject jSONObject = new JSONObject(string);
                                jSONObject.put("event_id", j4);
                                linkedList.add(jSONObject);
                            }
                        }
                        cursor.close();
                    } catch (SQLiteException e2) {
                        f21918g.c("io.rakam.api.DatabaseHelper", String.format("getEvents from %s failed", str), e2);
                        e.e().g(String.format("DB: Failed to getEventsFromTable %s", str), e2);
                        e();
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (RuntimeException e3) {
                    e.e().g(String.format("DB: Failed to getEventsFromTable %s", str), e3);
                    d(e3);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (StackOverflowError e4) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("getEvents from %s failed", str), e4);
                e.e().g(String.format("DB: Failed to getEventsFromTable %s", str), e4);
                e();
                if (cursor != null) {
                    cursor.close();
                }
            }
            close();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            close();
            throw th;
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long z() {
        return p("identifys");
    }
}
