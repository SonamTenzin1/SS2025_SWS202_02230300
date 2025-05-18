package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import androidx.room.q;
import androidx.room.t.b;
import c.u.a.f;
import h.a.m;
import h.a.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class NotificationDao_Impl implements NotificationDao {
    private final j __db;
    private final c<RoomNotification> __insertionAdapterOfRoomNotification;
    private final q __preparedStmtOfDeleteAllByType;

    public NotificationDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomNotification = new c<RoomNotification>(jVar) { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `notification` (`expire`,`abTestingGroup`,`body`,`campaignId`,`img`,`lang`,`title`,`url`,`urlTrack`,`notificationCenterUrlTrack`,`type`,`timeStamp`,`appName`,`graphic`,`ownerId`,`processed`,`actionStringRes`,`whitelistedPackages`,`key`,`dismissed`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomNotification roomNotification) {
                if (roomNotification.getExpire() == null) {
                    fVar.I0(1);
                } else {
                    fVar.h0(1, roomNotification.getExpire().longValue());
                }
                if (roomNotification.getAbTestingGroup() == null) {
                    fVar.I0(2);
                } else {
                    fVar.w(2, roomNotification.getAbTestingGroup());
                }
                if (roomNotification.getBody() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomNotification.getBody());
                }
                fVar.h0(4, roomNotification.getCampaignId());
                if (roomNotification.getImg() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomNotification.getImg());
                }
                if (roomNotification.getLang() == null) {
                    fVar.I0(6);
                } else {
                    fVar.w(6, roomNotification.getLang());
                }
                if (roomNotification.getTitle() == null) {
                    fVar.I0(7);
                } else {
                    fVar.w(7, roomNotification.getTitle());
                }
                if (roomNotification.getUrl() == null) {
                    fVar.I0(8);
                } else {
                    fVar.w(8, roomNotification.getUrl());
                }
                if (roomNotification.getUrlTrack() == null) {
                    fVar.I0(9);
                } else {
                    fVar.w(9, roomNotification.getUrlTrack());
                }
                if (roomNotification.getNotificationCenterUrlTrack() == null) {
                    fVar.I0(10);
                } else {
                    fVar.w(10, roomNotification.getNotificationCenterUrlTrack());
                }
                fVar.h0(11, roomNotification.getType());
                fVar.h0(12, roomNotification.getTimeStamp());
                if (roomNotification.getAppName() == null) {
                    fVar.I0(13);
                } else {
                    fVar.w(13, roomNotification.getAppName());
                }
                if (roomNotification.getGraphic() == null) {
                    fVar.I0(14);
                } else {
                    fVar.w(14, roomNotification.getGraphic());
                }
                if (roomNotification.getOwnerId() == null) {
                    fVar.I0(15);
                } else {
                    fVar.w(15, roomNotification.getOwnerId());
                }
                fVar.h0(16, roomNotification.isProcessed() ? 1L : 0L);
                fVar.h0(17, roomNotification.getActionStringRes());
                String saveList = StringTypeConverter.saveList(roomNotification.getWhitelistedPackages());
                if (saveList == null) {
                    fVar.I0(18);
                } else {
                    fVar.w(18, saveList);
                }
                if (roomNotification.getKey() == null) {
                    fVar.I0(19);
                } else {
                    fVar.w(19, roomNotification.getKey());
                }
                fVar.h0(20, roomNotification.getDismissed());
            }
        };
        this.__preparedStmtOfDeleteAllByType = new q(jVar) { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE FROM notification where type = ?";
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public void deleteAllByType(int i2) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteAllByType.acquire();
        acquire.h0(1, i2);
        this.__db.beginTransaction();
        try {
            acquire.E();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllByType.release(acquire);
        }
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public void deleteAllExcluding(List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder b2 = androidx.room.t.f.b();
        b2.append("DELETE FROM notification where ownerId NOT IN (");
        androidx.room.t.f.a(b2, list.size());
        b2.append(") ");
        f compileStatement = this.__db.compileStatement(b2.toString());
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.I0(i2);
            } else {
                compileStatement.w(i2, str);
            }
            i2++;
        }
        this.__db.beginTransaction();
        try {
            compileStatement.E();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public void deleteByKey(List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder b2 = androidx.room.t.f.b();
        b2.append("DELETE FROM notification where `key` IN (");
        androidx.room.t.f.a(b2, list.size());
        b2.append(") ");
        f compileStatement = this.__db.compileStatement(b2.toString());
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.I0(i2);
            } else {
                compileStatement.w(i2, str);
            }
            i2++;
        }
        this.__db.beginTransaction();
        try {
            compileStatement.E();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public m<List<RoomNotification>> getAll() {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * FROM notification", 0);
        return n.a(this.__db, false, new String[]{"notification"}, new Callable<List<RoomNotification>>() { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.6
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomNotification> call() throws Exception {
                int i2;
                boolean z;
                Cursor b2 = androidx.room.t.c.b(NotificationDao_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, "expire");
                    int b4 = b.b(b2, "abTestingGroup");
                    int b5 = b.b(b2, "body");
                    int b6 = b.b(b2, "campaignId");
                    int b7 = b.b(b2, "img");
                    int b8 = b.b(b2, "lang");
                    int b9 = b.b(b2, "title");
                    int b10 = b.b(b2, "url");
                    int b11 = b.b(b2, "urlTrack");
                    int b12 = b.b(b2, "notificationCenterUrlTrack");
                    int b13 = b.b(b2, "type");
                    int b14 = b.b(b2, "timeStamp");
                    int b15 = b.b(b2, "appName");
                    int b16 = b.b(b2, "graphic");
                    int b17 = b.b(b2, "ownerId");
                    int b18 = b.b(b2, "processed");
                    int b19 = b.b(b2, "actionStringRes");
                    int b20 = b.b(b2, "whitelistedPackages");
                    int b21 = b.b(b2, RoomNotification.KEY);
                    int b22 = b.b(b2, "dismissed");
                    int i3 = b16;
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        Long valueOf = b2.isNull(b3) ? null : Long.valueOf(b2.getLong(b3));
                        String string = b2.getString(b4);
                        String string2 = b2.getString(b5);
                        int i4 = b2.getInt(b6);
                        String string3 = b2.getString(b7);
                        String string4 = b2.getString(b8);
                        String string5 = b2.getString(b9);
                        String string6 = b2.getString(b10);
                        String string7 = b2.getString(b11);
                        String string8 = b2.getString(b12);
                        int i5 = b2.getInt(b13);
                        long j2 = b2.getLong(b14);
                        String string9 = b2.getString(b15);
                        int i6 = i3;
                        String string10 = b2.getString(i6);
                        int i7 = b3;
                        int i8 = b17;
                        String string11 = b2.getString(i8);
                        b17 = i8;
                        int i9 = b18;
                        if (b2.getInt(i9) != 0) {
                            b18 = i9;
                            i2 = b19;
                            z = true;
                        } else {
                            b18 = i9;
                            i2 = b19;
                            z = false;
                        }
                        int i10 = b2.getInt(i2);
                        b19 = i2;
                        int i11 = b20;
                        List<String> restoreList = StringTypeConverter.restoreList(b2.getString(i11));
                        b20 = i11;
                        int i12 = b22;
                        b22 = i12;
                        RoomNotification roomNotification = new RoomNotification(valueOf, string, string2, i4, string3, string4, string5, string6, string7, string8, j2, i5, b2.getLong(i12), string9, string10, string11, z, i10, restoreList);
                        int i13 = b15;
                        int i14 = b21;
                        roomNotification.setKey(b2.getString(i14));
                        arrayList.add(roomNotification);
                        b3 = i7;
                        i3 = i6;
                        b21 = i14;
                        b15 = i13;
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public m<List<RoomNotification>> getAllSortedDesc() {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * from notification ORDER BY timeStamp DESC", 0);
        return n.a(this.__db, false, new String[]{"notification"}, new Callable<List<RoomNotification>>() { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.5
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomNotification> call() throws Exception {
                int i2;
                boolean z;
                Cursor b2 = androidx.room.t.c.b(NotificationDao_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, "expire");
                    int b4 = b.b(b2, "abTestingGroup");
                    int b5 = b.b(b2, "body");
                    int b6 = b.b(b2, "campaignId");
                    int b7 = b.b(b2, "img");
                    int b8 = b.b(b2, "lang");
                    int b9 = b.b(b2, "title");
                    int b10 = b.b(b2, "url");
                    int b11 = b.b(b2, "urlTrack");
                    int b12 = b.b(b2, "notificationCenterUrlTrack");
                    int b13 = b.b(b2, "type");
                    int b14 = b.b(b2, "timeStamp");
                    int b15 = b.b(b2, "appName");
                    int b16 = b.b(b2, "graphic");
                    int b17 = b.b(b2, "ownerId");
                    int b18 = b.b(b2, "processed");
                    int b19 = b.b(b2, "actionStringRes");
                    int b20 = b.b(b2, "whitelistedPackages");
                    int b21 = b.b(b2, RoomNotification.KEY);
                    int b22 = b.b(b2, "dismissed");
                    int i3 = b16;
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        Long valueOf = b2.isNull(b3) ? null : Long.valueOf(b2.getLong(b3));
                        String string = b2.getString(b4);
                        String string2 = b2.getString(b5);
                        int i4 = b2.getInt(b6);
                        String string3 = b2.getString(b7);
                        String string4 = b2.getString(b8);
                        String string5 = b2.getString(b9);
                        String string6 = b2.getString(b10);
                        String string7 = b2.getString(b11);
                        String string8 = b2.getString(b12);
                        int i5 = b2.getInt(b13);
                        long j2 = b2.getLong(b14);
                        String string9 = b2.getString(b15);
                        int i6 = i3;
                        String string10 = b2.getString(i6);
                        int i7 = b3;
                        int i8 = b17;
                        String string11 = b2.getString(i8);
                        b17 = i8;
                        int i9 = b18;
                        if (b2.getInt(i9) != 0) {
                            b18 = i9;
                            i2 = b19;
                            z = true;
                        } else {
                            b18 = i9;
                            i2 = b19;
                            z = false;
                        }
                        int i10 = b2.getInt(i2);
                        b19 = i2;
                        int i11 = b20;
                        List<String> restoreList = StringTypeConverter.restoreList(b2.getString(i11));
                        b20 = i11;
                        int i12 = b22;
                        b22 = i12;
                        RoomNotification roomNotification = new RoomNotification(valueOf, string, string2, i4, string3, string4, string5, string6, string7, string8, j2, i5, b2.getLong(i12), string9, string10, string11, z, i10, restoreList);
                        int i13 = b15;
                        int i14 = b21;
                        roomNotification.setKey(b2.getString(i14));
                        arrayList.add(roomNotification);
                        b3 = i7;
                        i3 = i6;
                        b21 = i14;
                        b15 = i13;
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public s<List<RoomNotification>> getAllSortedDescByType(Integer[] numArr) {
        StringBuilder b2 = androidx.room.t.f.b();
        b2.append("SELECT ");
        b2.append("*");
        b2.append(" from notification where type IN (");
        int length = numArr.length;
        androidx.room.t.f.a(b2, length);
        b2.append(") ORDER BY timeStamp DESC");
        final androidx.room.m c2 = androidx.room.m.c(b2.toString(), length + 0);
        int i2 = 1;
        for (Integer num : numArr) {
            if (num == null) {
                c2.I0(i2);
            } else {
                c2.h0(i2, r4.intValue());
            }
            i2++;
        }
        return n.c(new Callable<List<RoomNotification>>() { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.4
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomNotification> call() throws Exception {
                int i3;
                boolean z;
                Cursor b3 = androidx.room.t.c.b(NotificationDao_Impl.this.__db, c2, false, null);
                try {
                    int b4 = b.b(b3, "expire");
                    int b5 = b.b(b3, "abTestingGroup");
                    int b6 = b.b(b3, "body");
                    int b7 = b.b(b3, "campaignId");
                    int b8 = b.b(b3, "img");
                    int b9 = b.b(b3, "lang");
                    int b10 = b.b(b3, "title");
                    int b11 = b.b(b3, "url");
                    int b12 = b.b(b3, "urlTrack");
                    int b13 = b.b(b3, "notificationCenterUrlTrack");
                    int b14 = b.b(b3, "type");
                    int b15 = b.b(b3, "timeStamp");
                    int b16 = b.b(b3, "appName");
                    int b17 = b.b(b3, "graphic");
                    int b18 = b.b(b3, "ownerId");
                    int b19 = b.b(b3, "processed");
                    int b20 = b.b(b3, "actionStringRes");
                    int b21 = b.b(b3, "whitelistedPackages");
                    int b22 = b.b(b3, RoomNotification.KEY);
                    int b23 = b.b(b3, "dismissed");
                    int i4 = b17;
                    ArrayList arrayList = new ArrayList(b3.getCount());
                    while (b3.moveToNext()) {
                        Long valueOf = b3.isNull(b4) ? null : Long.valueOf(b3.getLong(b4));
                        String string = b3.getString(b5);
                        String string2 = b3.getString(b6);
                        int i5 = b3.getInt(b7);
                        String string3 = b3.getString(b8);
                        String string4 = b3.getString(b9);
                        String string5 = b3.getString(b10);
                        String string6 = b3.getString(b11);
                        String string7 = b3.getString(b12);
                        String string8 = b3.getString(b13);
                        int i6 = b3.getInt(b14);
                        long j2 = b3.getLong(b15);
                        String string9 = b3.getString(b16);
                        int i7 = i4;
                        String string10 = b3.getString(i7);
                        int i8 = b4;
                        int i9 = b18;
                        String string11 = b3.getString(i9);
                        b18 = i9;
                        int i10 = b19;
                        if (b3.getInt(i10) != 0) {
                            b19 = i10;
                            i3 = b20;
                            z = true;
                        } else {
                            b19 = i10;
                            i3 = b20;
                            z = false;
                        }
                        int i11 = b3.getInt(i3);
                        b20 = i3;
                        int i12 = b21;
                        List<String> restoreList = StringTypeConverter.restoreList(b3.getString(i12));
                        b21 = i12;
                        int i13 = b23;
                        b23 = i13;
                        RoomNotification roomNotification = new RoomNotification(valueOf, string, string2, i5, string3, string4, string5, string6, string7, string8, j2, i6, b3.getLong(i13), string9, string10, string11, z, i11, restoreList);
                        int i14 = b16;
                        int i15 = b22;
                        roomNotification.setKey(b3.getString(i15));
                        arrayList.add(roomNotification);
                        b4 = i8;
                        i4 = i7;
                        b22 = i15;
                        b16 = i14;
                    }
                    return arrayList;
                } finally {
                    b3.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public s<List<RoomNotification>> getDismissed(Integer[] numArr, long j2, long j3) {
        StringBuilder b2 = androidx.room.t.f.b();
        b2.append("SELECT ");
        b2.append("*");
        b2.append(" from notification where type IN (");
        int length = numArr.length;
        androidx.room.t.f.a(b2, length);
        b2.append(") AND dismissed BETWEEN ");
        b2.append("?");
        b2.append(" AND ");
        b2.append("?");
        b2.append(" ");
        int i2 = length + 2;
        final androidx.room.m c2 = androidx.room.m.c(b2.toString(), i2);
        int i3 = 1;
        for (Integer num : numArr) {
            if (num == null) {
                c2.I0(i3);
            } else {
                c2.h0(i3, r7.intValue());
            }
            i3++;
        }
        c2.h0(length + 1, j2);
        c2.h0(i2, j3);
        return n.c(new Callable<List<RoomNotification>>() { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.3
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomNotification> call() throws Exception {
                int i4;
                boolean z;
                Cursor b3 = androidx.room.t.c.b(NotificationDao_Impl.this.__db, c2, false, null);
                try {
                    int b4 = b.b(b3, "expire");
                    int b5 = b.b(b3, "abTestingGroup");
                    int b6 = b.b(b3, "body");
                    int b7 = b.b(b3, "campaignId");
                    int b8 = b.b(b3, "img");
                    int b9 = b.b(b3, "lang");
                    int b10 = b.b(b3, "title");
                    int b11 = b.b(b3, "url");
                    int b12 = b.b(b3, "urlTrack");
                    int b13 = b.b(b3, "notificationCenterUrlTrack");
                    int b14 = b.b(b3, "type");
                    int b15 = b.b(b3, "timeStamp");
                    int b16 = b.b(b3, "appName");
                    int b17 = b.b(b3, "graphic");
                    int b18 = b.b(b3, "ownerId");
                    int b19 = b.b(b3, "processed");
                    int b20 = b.b(b3, "actionStringRes");
                    int b21 = b.b(b3, "whitelistedPackages");
                    int b22 = b.b(b3, RoomNotification.KEY);
                    int b23 = b.b(b3, "dismissed");
                    int i5 = b17;
                    ArrayList arrayList = new ArrayList(b3.getCount());
                    while (b3.moveToNext()) {
                        Long valueOf = b3.isNull(b4) ? null : Long.valueOf(b3.getLong(b4));
                        String string = b3.getString(b5);
                        String string2 = b3.getString(b6);
                        int i6 = b3.getInt(b7);
                        String string3 = b3.getString(b8);
                        String string4 = b3.getString(b9);
                        String string5 = b3.getString(b10);
                        String string6 = b3.getString(b11);
                        String string7 = b3.getString(b12);
                        String string8 = b3.getString(b13);
                        int i7 = b3.getInt(b14);
                        long j4 = b3.getLong(b15);
                        String string9 = b3.getString(b16);
                        int i8 = i5;
                        String string10 = b3.getString(i8);
                        int i9 = b4;
                        int i10 = b18;
                        String string11 = b3.getString(i10);
                        b18 = i10;
                        int i11 = b19;
                        if (b3.getInt(i11) != 0) {
                            b19 = i11;
                            i4 = b20;
                            z = true;
                        } else {
                            b19 = i11;
                            i4 = b20;
                            z = false;
                        }
                        int i12 = b3.getInt(i4);
                        b20 = i4;
                        int i13 = b21;
                        List<String> restoreList = StringTypeConverter.restoreList(b3.getString(i13));
                        b21 = i13;
                        int i14 = b23;
                        b23 = i14;
                        RoomNotification roomNotification = new RoomNotification(valueOf, string, string2, i6, string3, string4, string5, string6, string7, string8, j4, i7, b3.getLong(i14), string9, string10, string11, z, i12, restoreList);
                        int i15 = b16;
                        int i16 = b22;
                        roomNotification.setKey(b3.getString(i16));
                        arrayList.add(roomNotification);
                        b4 = i9;
                        i5 = i8;
                        b22 = i16;
                        b16 = i15;
                    }
                    return arrayList;
                } finally {
                    b3.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public void insert(RoomNotification roomNotification) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomNotification.insert((c<RoomNotification>) roomNotification);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public void insertAll(List<RoomNotification> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomNotification.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
