package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import androidx.room.q;
import androidx.room.t.b;
import c.u.a.f;
import cm.aptoide.pt.account.AccountAnalytics;
import h.a.m;
import h.a.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class StoreDao_Impl implements StoreDao {
    private final j __db;
    private final c<RoomStore> __insertionAdapterOfRoomStore;
    private final q __preparedStmtOfRemoveByStoreName;

    public StoreDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomStore = new c<RoomStore>(jVar) { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `store` (`storeId`,`iconPath`,`theme`,`downloads`,`storeName`,`username`,`passwordSha1`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomStore roomStore) {
                fVar.h0(1, roomStore.getStoreId());
                if (roomStore.getIconPath() == null) {
                    fVar.I0(2);
                } else {
                    fVar.w(2, roomStore.getIconPath());
                }
                if (roomStore.getTheme() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomStore.getTheme());
                }
                fVar.h0(4, roomStore.getDownloads());
                if (roomStore.getStoreName() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomStore.getStoreName());
                }
                if (roomStore.getUsername() == null) {
                    fVar.I0(6);
                } else {
                    fVar.w(6, roomStore.getUsername());
                }
                if (roomStore.getPasswordSha1() == null) {
                    fVar.I0(7);
                } else {
                    fVar.w(7, roomStore.getPasswordSha1());
                }
            }
        };
        this.__preparedStmtOfRemoveByStoreName = new q(jVar) { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE FROM store where storeName = ?";
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public m<List<RoomStore>> getAll() {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * from store", 0);
        return n.a(this.__db, false, new String[]{AccountAnalytics.STORE}, new Callable<List<RoomStore>>() { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.3
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomStore> call() throws Exception {
                Cursor b2 = androidx.room.t.c.b(StoreDao_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, RoomStore.STORE_ID);
                    int b4 = b.b(b2, RoomStore.ICON_PATH);
                    int b5 = b.b(b2, RoomStore.THEME);
                    int b6 = b.b(b2, RoomStore.DOWNLOADS);
                    int b7 = b.b(b2, "storeName");
                    int b8 = b.b(b2, "username");
                    int b9 = b.b(b2, RoomStore.PASSWORD_SHA1);
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        RoomStore roomStore = new RoomStore();
                        roomStore.setStoreId(b2.getLong(b3));
                        roomStore.setIconPath(b2.getString(b4));
                        roomStore.setTheme(b2.getString(b5));
                        roomStore.setDownloads(b2.getLong(b6));
                        roomStore.setStoreName(b2.getString(b7));
                        roomStore.setUsername(b2.getString(b8));
                        roomStore.setPasswordSha1(b2.getString(b9));
                        arrayList.add(roomStore);
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public s<RoomStore> getByStoreId(long j2) {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * from store where storeId = ?", 1);
        c2.h0(1, j2);
        return n.c(new Callable<RoomStore>() { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.5
            protected void finalize() {
                c2.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomStore call() throws Exception {
                RoomStore roomStore = null;
                Cursor b2 = androidx.room.t.c.b(StoreDao_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, RoomStore.STORE_ID);
                    int b4 = b.b(b2, RoomStore.ICON_PATH);
                    int b5 = b.b(b2, RoomStore.THEME);
                    int b6 = b.b(b2, RoomStore.DOWNLOADS);
                    int b7 = b.b(b2, "storeName");
                    int b8 = b.b(b2, "username");
                    int b9 = b.b(b2, RoomStore.PASSWORD_SHA1);
                    if (b2.moveToFirst()) {
                        roomStore = new RoomStore();
                        roomStore.setStoreId(b2.getLong(b3));
                        roomStore.setIconPath(b2.getString(b4));
                        roomStore.setTheme(b2.getString(b5));
                        roomStore.setDownloads(b2.getLong(b6));
                        roomStore.setStoreName(b2.getString(b7));
                        roomStore.setUsername(b2.getString(b8));
                        roomStore.setPasswordSha1(b2.getString(b9));
                    }
                    if (roomStore != null) {
                        return roomStore;
                    }
                    throw new EmptyResultSetException("Query returned empty result set: " + c2.a());
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public s<RoomStore> getByStoreName(String str) {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * from store where storeName = ?", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        return n.c(new Callable<RoomStore>() { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.4
            protected void finalize() {
                c2.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomStore call() throws Exception {
                RoomStore roomStore = null;
                Cursor b2 = androidx.room.t.c.b(StoreDao_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, RoomStore.STORE_ID);
                    int b4 = b.b(b2, RoomStore.ICON_PATH);
                    int b5 = b.b(b2, RoomStore.THEME);
                    int b6 = b.b(b2, RoomStore.DOWNLOADS);
                    int b7 = b.b(b2, "storeName");
                    int b8 = b.b(b2, "username");
                    int b9 = b.b(b2, RoomStore.PASSWORD_SHA1);
                    if (b2.moveToFirst()) {
                        roomStore = new RoomStore();
                        roomStore.setStoreId(b2.getLong(b3));
                        roomStore.setIconPath(b2.getString(b4));
                        roomStore.setTheme(b2.getString(b5));
                        roomStore.setDownloads(b2.getLong(b6));
                        roomStore.setStoreName(b2.getString(b7));
                        roomStore.setUsername(b2.getString(b8));
                        roomStore.setPasswordSha1(b2.getString(b9));
                    }
                    if (roomStore != null) {
                        return roomStore;
                    }
                    throw new EmptyResultSetException("Query returned empty result set: " + c2.a());
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public void insert(RoomStore roomStore) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomStore.insert((c<RoomStore>) roomStore);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public m<Integer> isSubscribed(long j2) {
        final androidx.room.m c2 = androidx.room.m.c("SELECT COUNT(*) from store where storeId = ?", 1);
        c2.h0(1, j2);
        return n.a(this.__db, false, new String[]{AccountAnalytics.STORE}, new Callable<Integer>() { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.6
            protected void finalize() {
                c2.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer num = null;
                Cursor b2 = androidx.room.t.c.b(StoreDao_Impl.this.__db, c2, false, null);
                try {
                    if (b2.moveToFirst() && !b2.isNull(0)) {
                        num = Integer.valueOf(b2.getInt(0));
                    }
                    return num;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public void removeByStoreName(String str) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfRemoveByStoreName.acquire();
        if (str == null) {
            acquire.I0(1);
        } else {
            acquire.w(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.E();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveByStoreName.release(acquire);
        }
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public void saveAll(List<RoomStore> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomStore.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
