package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import c.u.a.f;
import h.a.m;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class StoredMinimalAdDAO_Impl implements StoredMinimalAdDAO {
    private final j __db;
    private final b<RoomStoredMinimalAd> __deletionAdapterOfRoomStoredMinimalAd;
    private final c<RoomStoredMinimalAd> __insertionAdapterOfRoomStoredMinimalAd;

    public StoredMinimalAdDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomStoredMinimalAd = new c<RoomStoredMinimalAd>(jVar) { // from class: cm.aptoide.pt.database.room.StoredMinimalAdDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `storedMinimalAd` (`packageName`,`referrer`,`cpcUrl`,`cpdUrl`,`cpiUrl`,`timestamp`,`adId`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomStoredMinimalAd roomStoredMinimalAd) {
                if (roomStoredMinimalAd.getPackageName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomStoredMinimalAd.getPackageName());
                }
                if (roomStoredMinimalAd.getReferrer() == null) {
                    fVar.I0(2);
                } else {
                    fVar.w(2, roomStoredMinimalAd.getReferrer());
                }
                if (roomStoredMinimalAd.getCpcUrl() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomStoredMinimalAd.getCpcUrl());
                }
                if (roomStoredMinimalAd.getCpdUrl() == null) {
                    fVar.I0(4);
                } else {
                    fVar.w(4, roomStoredMinimalAd.getCpdUrl());
                }
                if (roomStoredMinimalAd.getCpiUrl() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomStoredMinimalAd.getCpiUrl());
                }
                if (roomStoredMinimalAd.getTimestamp() == null) {
                    fVar.I0(6);
                } else {
                    fVar.h0(6, roomStoredMinimalAd.getTimestamp().longValue());
                }
                if (roomStoredMinimalAd.getAdId() == null) {
                    fVar.I0(7);
                } else {
                    fVar.h0(7, roomStoredMinimalAd.getAdId().longValue());
                }
            }
        };
        this.__deletionAdapterOfRoomStoredMinimalAd = new b<RoomStoredMinimalAd>(jVar) { // from class: cm.aptoide.pt.database.room.StoredMinimalAdDAO_Impl.2
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `storedMinimalAd` WHERE `packageName` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, RoomStoredMinimalAd roomStoredMinimalAd) {
                if (roomStoredMinimalAd.getPackageName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomStoredMinimalAd.getPackageName());
                }
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.StoredMinimalAdDAO
    public void delete(RoomStoredMinimalAd roomStoredMinimalAd) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRoomStoredMinimalAd.handle(roomStoredMinimalAd);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.StoredMinimalAdDAO
    public m<RoomStoredMinimalAd> get(String str) {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * FROM storedMinimalAd WHERE packageName = ?", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        return n.a(this.__db, false, new String[]{"storedMinimalAd"}, new Callable<RoomStoredMinimalAd>() { // from class: cm.aptoide.pt.database.room.StoredMinimalAdDAO_Impl.3
            protected void finalize() {
                c2.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomStoredMinimalAd call() throws Exception {
                RoomStoredMinimalAd roomStoredMinimalAd = null;
                Long valueOf = null;
                Cursor b2 = androidx.room.t.c.b(StoredMinimalAdDAO_Impl.this.__db, c2, false, null);
                try {
                    int b3 = androidx.room.t.b.b(b2, "packageName");
                    int b4 = androidx.room.t.b.b(b2, "referrer");
                    int b5 = androidx.room.t.b.b(b2, "cpcUrl");
                    int b6 = androidx.room.t.b.b(b2, "cpdUrl");
                    int b7 = androidx.room.t.b.b(b2, "cpiUrl");
                    int b8 = androidx.room.t.b.b(b2, "timestamp");
                    int b9 = androidx.room.t.b.b(b2, "adId");
                    if (b2.moveToFirst()) {
                        RoomStoredMinimalAd roomStoredMinimalAd2 = new RoomStoredMinimalAd(b2.getString(b3), b2.getString(b4), b2.getString(b5), b2.getString(b6), b2.getString(b7), b2.isNull(b9) ? null : Long.valueOf(b2.getLong(b9)));
                        if (!b2.isNull(b8)) {
                            valueOf = Long.valueOf(b2.getLong(b8));
                        }
                        roomStoredMinimalAd2.setTimestamp(valueOf);
                        roomStoredMinimalAd = roomStoredMinimalAd2;
                    }
                    return roomStoredMinimalAd;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.StoredMinimalAdDAO
    public void insert(RoomStoredMinimalAd roomStoredMinimalAd) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomStoredMinimalAd.insert((c<RoomStoredMinimalAd>) roomStoredMinimalAd);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
