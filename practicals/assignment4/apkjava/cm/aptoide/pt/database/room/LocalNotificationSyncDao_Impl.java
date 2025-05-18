package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import androidx.room.q;
import androidx.room.t.b;
import c.u.a.f;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import h.a.m;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class LocalNotificationSyncDao_Impl implements LocalNotificationSyncDao {
    private final j __db;
    private final c<RoomLocalNotificationSync> __insertionAdapterOfRoomLocalNotificationSync;
    private final q __preparedStmtOfDelete;

    public LocalNotificationSyncDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomLocalNotificationSync = new c<RoomLocalNotificationSync>(jVar) { // from class: cm.aptoide.pt.database.room.LocalNotificationSyncDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `localNotificationSync` (`notificationId`,`title`,`body`,`image`,`navigationUrl`,`trigger`,`id`,`actionStringRes`,`type`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomLocalNotificationSync roomLocalNotificationSync) {
                if (roomLocalNotificationSync.getNotificationId() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomLocalNotificationSync.getNotificationId());
                }
                if (roomLocalNotificationSync.getTitle() == null) {
                    fVar.I0(2);
                } else {
                    fVar.w(2, roomLocalNotificationSync.getTitle());
                }
                if (roomLocalNotificationSync.getBody() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomLocalNotificationSync.getBody());
                }
                if (roomLocalNotificationSync.getImage() == null) {
                    fVar.I0(4);
                } else {
                    fVar.w(4, roomLocalNotificationSync.getImage());
                }
                if (roomLocalNotificationSync.getNavigationUrl() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomLocalNotificationSync.getNavigationUrl());
                }
                fVar.h0(6, roomLocalNotificationSync.getTrigger());
                if (roomLocalNotificationSync.getId() == null) {
                    fVar.I0(7);
                } else {
                    fVar.w(7, roomLocalNotificationSync.getId());
                }
                fVar.h0(8, roomLocalNotificationSync.getActionStringRes());
                fVar.h0(9, roomLocalNotificationSync.getType());
            }
        };
        this.__preparedStmtOfDelete = new q(jVar) { // from class: cm.aptoide.pt.database.room.LocalNotificationSyncDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE FROM localNotificationSync WHERE notificationId = ?";
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.LocalNotificationSyncDao
    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDelete.acquire();
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
            this.__preparedStmtOfDelete.release(acquire);
        }
    }

    @Override // cm.aptoide.pt.database.room.LocalNotificationSyncDao
    public m<RoomLocalNotificationSync> get(String str) {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * FROM localNotificationSync WHERE notificationId = ?", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        return n.a(this.__db, false, new String[]{"localNotificationSync"}, new Callable<RoomLocalNotificationSync>() { // from class: cm.aptoide.pt.database.room.LocalNotificationSyncDao_Impl.3
            protected void finalize() {
                c2.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomLocalNotificationSync call() throws Exception {
                RoomLocalNotificationSync roomLocalNotificationSync = null;
                Cursor b2 = androidx.room.t.c.b(LocalNotificationSyncDao_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, "notificationId");
                    int b4 = b.b(b2, "title");
                    int b5 = b.b(b2, "body");
                    int b6 = b.b(b2, "image");
                    int b7 = b.b(b2, "navigationUrl");
                    int b8 = b.b(b2, "trigger");
                    int b9 = b.b(b2, DeepLinkIntentReceiver.DeepLinksKeys.ID);
                    int b10 = b.b(b2, "actionStringRes");
                    int b11 = b.b(b2, "type");
                    if (b2.moveToFirst()) {
                        roomLocalNotificationSync = new RoomLocalNotificationSync(b2.getString(b3), b2.getString(b4), b2.getString(b5), b2.getString(b6), b2.getInt(b10), b2.getString(b7), b2.getLong(b8), b2.getString(b9), b2.getInt(b11));
                    }
                    return roomLocalNotificationSync;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.LocalNotificationSyncDao
    public void save(RoomLocalNotificationSync roomLocalNotificationSync) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomLocalNotificationSync.insert((c<RoomLocalNotificationSync>) roomLocalNotificationSync);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
