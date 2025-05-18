package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.n;
import androidx.room.q;
import c.u.a.f;
import h.a.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class UpdateDao_Impl implements UpdateDao {
    private final j __db;
    private final b<RoomUpdate> __deletionAdapterOfRoomUpdate;
    private final c<RoomUpdate> __insertionAdapterOfRoomUpdate;
    private final q __preparedStmtOfDeleteByPackageName;

    public UpdateDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomUpdate = new c<RoomUpdate>(jVar) { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `update` (`packageName`,`appId`,`label`,`icon`,`md5`,`apkPath`,`size`,`updateVersionName`,`updateVersionCode`,`excluded`,`trustedBadge`,`alternativeApkPath`,`storeName`,`mainObbName`,`mainObbPath`,`mainObbMd5`,`patchObbName`,`patchObbPath`,`patchObbMd5`,`roomSplits`,`requiredSplits`,`hasAppc`,`downloadCampaigns`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomUpdate roomUpdate) {
                if (roomUpdate.getPackageName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomUpdate.getPackageName());
                }
                fVar.h0(2, roomUpdate.getAppId());
                if (roomUpdate.getLabel() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomUpdate.getLabel());
                }
                if (roomUpdate.getIcon() == null) {
                    fVar.I0(4);
                } else {
                    fVar.w(4, roomUpdate.getIcon());
                }
                if (roomUpdate.getMd5() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomUpdate.getMd5());
                }
                if (roomUpdate.getApkPath() == null) {
                    fVar.I0(6);
                } else {
                    fVar.w(6, roomUpdate.getApkPath());
                }
                fVar.h0(7, roomUpdate.getSize());
                if (roomUpdate.getUpdateVersionName() == null) {
                    fVar.I0(8);
                } else {
                    fVar.w(8, roomUpdate.getUpdateVersionName());
                }
                fVar.h0(9, roomUpdate.getUpdateVersionCode());
                fVar.h0(10, roomUpdate.isExcluded() ? 1L : 0L);
                if (roomUpdate.getTrustedBadge() == null) {
                    fVar.I0(11);
                } else {
                    fVar.w(11, roomUpdate.getTrustedBadge());
                }
                if (roomUpdate.getAlternativeApkPath() == null) {
                    fVar.I0(12);
                } else {
                    fVar.w(12, roomUpdate.getAlternativeApkPath());
                }
                if (roomUpdate.getStoreName() == null) {
                    fVar.I0(13);
                } else {
                    fVar.w(13, roomUpdate.getStoreName());
                }
                if (roomUpdate.getMainObbName() == null) {
                    fVar.I0(14);
                } else {
                    fVar.w(14, roomUpdate.getMainObbName());
                }
                if (roomUpdate.getMainObbPath() == null) {
                    fVar.I0(15);
                } else {
                    fVar.w(15, roomUpdate.getMainObbPath());
                }
                if (roomUpdate.getMainObbMd5() == null) {
                    fVar.I0(16);
                } else {
                    fVar.w(16, roomUpdate.getMainObbMd5());
                }
                if (roomUpdate.getPatchObbName() == null) {
                    fVar.I0(17);
                } else {
                    fVar.w(17, roomUpdate.getPatchObbName());
                }
                if (roomUpdate.getPatchObbPath() == null) {
                    fVar.I0(18);
                } else {
                    fVar.w(18, roomUpdate.getPatchObbPath());
                }
                if (roomUpdate.getPatchObbMd5() == null) {
                    fVar.I0(19);
                } else {
                    fVar.w(19, roomUpdate.getPatchObbMd5());
                }
                String saveSplitList = SplitTypeConverter.saveSplitList(roomUpdate.getRoomSplits());
                if (saveSplitList == null) {
                    fVar.I0(20);
                } else {
                    fVar.w(20, saveSplitList);
                }
                String saveList = StringTypeConverter.saveList(roomUpdate.getRequiredSplits());
                if (saveList == null) {
                    fVar.I0(21);
                } else {
                    fVar.w(21, saveList);
                }
                fVar.h0(22, roomUpdate.hasAppc() ? 1L : 0L);
                String saveCampaignUrlList = CampaignUrlTypeConverter.saveCampaignUrlList(roomUpdate.getDownloadCampaigns());
                if (saveCampaignUrlList == null) {
                    fVar.I0(23);
                } else {
                    fVar.w(23, saveCampaignUrlList);
                }
            }
        };
        this.__deletionAdapterOfRoomUpdate = new b<RoomUpdate>(jVar) { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.2
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `update` WHERE `packageName` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, RoomUpdate roomUpdate) {
                if (roomUpdate.getPackageName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomUpdate.getPackageName());
                }
            }
        };
        this.__preparedStmtOfDeleteByPackageName = new q(jVar) { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.3
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE from `update` where packageName = ?";
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public void deleteAll(List<RoomUpdate> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRoomUpdate.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public void deleteByPackageName(String str) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteByPackageName.acquire();
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
            this.__preparedStmtOfDeleteByPackageName.release(acquire);
        }
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public s<RoomUpdate> get(String str) {
        final m c2 = m.c("SELECT * from `update` where packageName = ?", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        return n.c(new Callable<RoomUpdate>() { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.4
            protected void finalize() {
                c2.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomUpdate call() throws Exception {
                RoomUpdate roomUpdate;
                Cursor b2 = androidx.room.t.c.b(UpdateDao_Impl.this.__db, c2, false, null);
                try {
                    int b3 = androidx.room.t.b.b(b2, "packageName");
                    int b4 = androidx.room.t.b.b(b2, "appId");
                    int b5 = androidx.room.t.b.b(b2, "label");
                    int b6 = androidx.room.t.b.b(b2, RoomInstalled.ICON);
                    int b7 = androidx.room.t.b.b(b2, "md5");
                    int b8 = androidx.room.t.b.b(b2, "apkPath");
                    int b9 = androidx.room.t.b.b(b2, "size");
                    int b10 = androidx.room.t.b.b(b2, "updateVersionName");
                    int b11 = androidx.room.t.b.b(b2, "updateVersionCode");
                    int b12 = androidx.room.t.b.b(b2, "excluded");
                    int b13 = androidx.room.t.b.b(b2, "trustedBadge");
                    int b14 = androidx.room.t.b.b(b2, "alternativeApkPath");
                    int b15 = androidx.room.t.b.b(b2, "storeName");
                    int b16 = androidx.room.t.b.b(b2, "mainObbName");
                    try {
                        int b17 = androidx.room.t.b.b(b2, "mainObbPath");
                        int b18 = androidx.room.t.b.b(b2, "mainObbMd5");
                        int b19 = androidx.room.t.b.b(b2, "patchObbName");
                        int b20 = androidx.room.t.b.b(b2, "patchObbPath");
                        int b21 = androidx.room.t.b.b(b2, "patchObbMd5");
                        int b22 = androidx.room.t.b.b(b2, "roomSplits");
                        int b23 = androidx.room.t.b.b(b2, "requiredSplits");
                        int b24 = androidx.room.t.b.b(b2, "hasAppc");
                        int b25 = androidx.room.t.b.b(b2, "downloadCampaigns");
                        if (b2.moveToFirst()) {
                            String string = b2.getString(b3);
                            long j2 = b2.getLong(b4);
                            String string2 = b2.getString(b5);
                            String string3 = b2.getString(b6);
                            String string4 = b2.getString(b7);
                            String string5 = b2.getString(b8);
                            long j3 = b2.getLong(b9);
                            String string6 = b2.getString(b10);
                            int i2 = b2.getInt(b11);
                            String string7 = b2.getString(b13);
                            String string8 = b2.getString(b14);
                            String string9 = b2.getString(b15);
                            roomUpdate = new RoomUpdate(j2, string2, string3, string, string4, string5, j3, string6, string8, i2, string7, b2.getString(b16), b2.getString(b17), b2.getString(b18), b2.getString(b19), b2.getString(b20), b2.getString(b21), b2.getInt(b24) != 0, SplitTypeConverter.restoreSplitList(b2.getString(b22)), StringTypeConverter.restoreList(b2.getString(b23)), string9, CampaignUrlTypeConverter.restoreCampaignUrlList(b2.getString(b25)));
                            roomUpdate.setExcluded(b2.getInt(b12) != 0);
                        } else {
                            roomUpdate = null;
                        }
                        if (roomUpdate != null) {
                            b2.close();
                            return roomUpdate;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Query returned empty result set: ");
                        try {
                            sb.append(c2.a());
                            throw new EmptyResultSetException(sb.toString());
                        } catch (Throwable th) {
                            th = th;
                            b2.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public s<List<RoomUpdate>> getAllByExcluded(boolean z) {
        final m c2 = m.c("SELECT * from `update` where excluded = ?", 1);
        c2.h0(1, z ? 1L : 0L);
        return n.c(new Callable<List<RoomUpdate>>() { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.5
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomUpdate> call() throws Exception {
                int i2;
                boolean z2;
                boolean z3;
                Cursor b2 = androidx.room.t.c.b(UpdateDao_Impl.this.__db, c2, false, null);
                try {
                    int b3 = androidx.room.t.b.b(b2, "packageName");
                    int b4 = androidx.room.t.b.b(b2, "appId");
                    int b5 = androidx.room.t.b.b(b2, "label");
                    int b6 = androidx.room.t.b.b(b2, RoomInstalled.ICON);
                    int b7 = androidx.room.t.b.b(b2, "md5");
                    int b8 = androidx.room.t.b.b(b2, "apkPath");
                    int b9 = androidx.room.t.b.b(b2, "size");
                    int b10 = androidx.room.t.b.b(b2, "updateVersionName");
                    int b11 = androidx.room.t.b.b(b2, "updateVersionCode");
                    int b12 = androidx.room.t.b.b(b2, "excluded");
                    int b13 = androidx.room.t.b.b(b2, "trustedBadge");
                    int b14 = androidx.room.t.b.b(b2, "alternativeApkPath");
                    int b15 = androidx.room.t.b.b(b2, "storeName");
                    int b16 = androidx.room.t.b.b(b2, "mainObbName");
                    int b17 = androidx.room.t.b.b(b2, "mainObbPath");
                    int i3 = b12;
                    int b18 = androidx.room.t.b.b(b2, "mainObbMd5");
                    int b19 = androidx.room.t.b.b(b2, "patchObbName");
                    int b20 = androidx.room.t.b.b(b2, "patchObbPath");
                    int b21 = androidx.room.t.b.b(b2, "patchObbMd5");
                    int b22 = androidx.room.t.b.b(b2, "roomSplits");
                    int b23 = androidx.room.t.b.b(b2, "requiredSplits");
                    int b24 = androidx.room.t.b.b(b2, "hasAppc");
                    int b25 = androidx.room.t.b.b(b2, "downloadCampaigns");
                    int i4 = b17;
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        String string = b2.getString(b3);
                        long j2 = b2.getLong(b4);
                        String string2 = b2.getString(b5);
                        String string3 = b2.getString(b6);
                        String string4 = b2.getString(b7);
                        String string5 = b2.getString(b8);
                        long j3 = b2.getLong(b9);
                        String string6 = b2.getString(b10);
                        int i5 = b2.getInt(b11);
                        String string7 = b2.getString(b13);
                        String string8 = b2.getString(b14);
                        String string9 = b2.getString(b15);
                        String string10 = b2.getString(b16);
                        int i6 = i4;
                        String string11 = b2.getString(i6);
                        int i7 = b3;
                        int i8 = b18;
                        String string12 = b2.getString(i8);
                        b18 = i8;
                        int i9 = b19;
                        String string13 = b2.getString(i9);
                        b19 = i9;
                        int i10 = b20;
                        String string14 = b2.getString(i10);
                        b20 = i10;
                        int i11 = b21;
                        String string15 = b2.getString(i11);
                        b21 = i11;
                        int i12 = b22;
                        List<RoomSplit> restoreSplitList = SplitTypeConverter.restoreSplitList(b2.getString(i12));
                        b22 = i12;
                        int i13 = b23;
                        List<String> restoreList = StringTypeConverter.restoreList(b2.getString(i13));
                        b23 = i13;
                        int i14 = b24;
                        if (b2.getInt(i14) != 0) {
                            b24 = i14;
                            i2 = b25;
                            z2 = true;
                        } else {
                            b24 = i14;
                            i2 = b25;
                            z2 = false;
                        }
                        b25 = i2;
                        RoomUpdate roomUpdate = new RoomUpdate(j2, string2, string3, string, string4, string5, j3, string6, string8, i5, string7, string10, string11, string12, string13, string14, string15, z2, restoreSplitList, restoreList, string9, CampaignUrlTypeConverter.restoreCampaignUrlList(b2.getString(i2)));
                        int i15 = i3;
                        if (b2.getInt(i15) != 0) {
                            i3 = i15;
                            z3 = true;
                        } else {
                            i3 = i15;
                            z3 = false;
                        }
                        roomUpdate.setExcluded(z3);
                        arrayList.add(roomUpdate);
                        b3 = i7;
                        i4 = i6;
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public h.a.m<List<RoomUpdate>> getAllByExcludedSorted(boolean z) {
        final m c2 = m.c("SELECT * from `update` where excluded = ? ORDER BY label", 1);
        c2.h0(1, z ? 1L : 0L);
        return n.a(this.__db, false, new String[]{"update"}, new Callable<List<RoomUpdate>>() { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.6
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomUpdate> call() throws Exception {
                int i2;
                boolean z2;
                boolean z3;
                Cursor b2 = androidx.room.t.c.b(UpdateDao_Impl.this.__db, c2, false, null);
                try {
                    int b3 = androidx.room.t.b.b(b2, "packageName");
                    int b4 = androidx.room.t.b.b(b2, "appId");
                    int b5 = androidx.room.t.b.b(b2, "label");
                    int b6 = androidx.room.t.b.b(b2, RoomInstalled.ICON);
                    int b7 = androidx.room.t.b.b(b2, "md5");
                    int b8 = androidx.room.t.b.b(b2, "apkPath");
                    int b9 = androidx.room.t.b.b(b2, "size");
                    int b10 = androidx.room.t.b.b(b2, "updateVersionName");
                    int b11 = androidx.room.t.b.b(b2, "updateVersionCode");
                    int b12 = androidx.room.t.b.b(b2, "excluded");
                    int b13 = androidx.room.t.b.b(b2, "trustedBadge");
                    int b14 = androidx.room.t.b.b(b2, "alternativeApkPath");
                    int b15 = androidx.room.t.b.b(b2, "storeName");
                    int b16 = androidx.room.t.b.b(b2, "mainObbName");
                    int b17 = androidx.room.t.b.b(b2, "mainObbPath");
                    int i3 = b12;
                    int b18 = androidx.room.t.b.b(b2, "mainObbMd5");
                    int b19 = androidx.room.t.b.b(b2, "patchObbName");
                    int b20 = androidx.room.t.b.b(b2, "patchObbPath");
                    int b21 = androidx.room.t.b.b(b2, "patchObbMd5");
                    int b22 = androidx.room.t.b.b(b2, "roomSplits");
                    int b23 = androidx.room.t.b.b(b2, "requiredSplits");
                    int b24 = androidx.room.t.b.b(b2, "hasAppc");
                    int b25 = androidx.room.t.b.b(b2, "downloadCampaigns");
                    int i4 = b17;
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        String string = b2.getString(b3);
                        long j2 = b2.getLong(b4);
                        String string2 = b2.getString(b5);
                        String string3 = b2.getString(b6);
                        String string4 = b2.getString(b7);
                        String string5 = b2.getString(b8);
                        long j3 = b2.getLong(b9);
                        String string6 = b2.getString(b10);
                        int i5 = b2.getInt(b11);
                        String string7 = b2.getString(b13);
                        String string8 = b2.getString(b14);
                        String string9 = b2.getString(b15);
                        String string10 = b2.getString(b16);
                        int i6 = i4;
                        String string11 = b2.getString(i6);
                        int i7 = b3;
                        int i8 = b18;
                        String string12 = b2.getString(i8);
                        b18 = i8;
                        int i9 = b19;
                        String string13 = b2.getString(i9);
                        b19 = i9;
                        int i10 = b20;
                        String string14 = b2.getString(i10);
                        b20 = i10;
                        int i11 = b21;
                        String string15 = b2.getString(i11);
                        b21 = i11;
                        int i12 = b22;
                        List<RoomSplit> restoreSplitList = SplitTypeConverter.restoreSplitList(b2.getString(i12));
                        b22 = i12;
                        int i13 = b23;
                        List<String> restoreList = StringTypeConverter.restoreList(b2.getString(i13));
                        b23 = i13;
                        int i14 = b24;
                        if (b2.getInt(i14) != 0) {
                            b24 = i14;
                            i2 = b25;
                            z2 = true;
                        } else {
                            b24 = i14;
                            i2 = b25;
                            z2 = false;
                        }
                        b25 = i2;
                        RoomUpdate roomUpdate = new RoomUpdate(j2, string2, string3, string, string4, string5, j3, string6, string8, i5, string7, string10, string11, string12, string13, string14, string15, z2, restoreSplitList, restoreList, string9, CampaignUrlTypeConverter.restoreCampaignUrlList(b2.getString(i2)));
                        int i15 = i3;
                        if (b2.getInt(i15) != 0) {
                            i3 = i15;
                            z3 = true;
                        } else {
                            i3 = i15;
                            z3 = false;
                        }
                        roomUpdate.setExcluded(z3);
                        arrayList.add(roomUpdate);
                        b3 = i7;
                        i4 = i6;
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public s<RoomUpdate> getByPackageAndExcluded(String str, boolean z) {
        final m c2 = m.c("SELECT * from `update` where excluded = ? and packageName = ? LIMIT 1", 2);
        c2.h0(1, z ? 1L : 0L);
        if (str == null) {
            c2.I0(2);
        } else {
            c2.w(2, str);
        }
        return n.c(new Callable<RoomUpdate>() { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.7
            protected void finalize() {
                c2.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomUpdate call() throws Exception {
                RoomUpdate roomUpdate;
                Cursor b2 = androidx.room.t.c.b(UpdateDao_Impl.this.__db, c2, false, null);
                try {
                    int b3 = androidx.room.t.b.b(b2, "packageName");
                    int b4 = androidx.room.t.b.b(b2, "appId");
                    int b5 = androidx.room.t.b.b(b2, "label");
                    int b6 = androidx.room.t.b.b(b2, RoomInstalled.ICON);
                    int b7 = androidx.room.t.b.b(b2, "md5");
                    int b8 = androidx.room.t.b.b(b2, "apkPath");
                    int b9 = androidx.room.t.b.b(b2, "size");
                    int b10 = androidx.room.t.b.b(b2, "updateVersionName");
                    int b11 = androidx.room.t.b.b(b2, "updateVersionCode");
                    int b12 = androidx.room.t.b.b(b2, "excluded");
                    int b13 = androidx.room.t.b.b(b2, "trustedBadge");
                    int b14 = androidx.room.t.b.b(b2, "alternativeApkPath");
                    int b15 = androidx.room.t.b.b(b2, "storeName");
                    int b16 = androidx.room.t.b.b(b2, "mainObbName");
                    try {
                        int b17 = androidx.room.t.b.b(b2, "mainObbPath");
                        int b18 = androidx.room.t.b.b(b2, "mainObbMd5");
                        int b19 = androidx.room.t.b.b(b2, "patchObbName");
                        int b20 = androidx.room.t.b.b(b2, "patchObbPath");
                        int b21 = androidx.room.t.b.b(b2, "patchObbMd5");
                        int b22 = androidx.room.t.b.b(b2, "roomSplits");
                        int b23 = androidx.room.t.b.b(b2, "requiredSplits");
                        int b24 = androidx.room.t.b.b(b2, "hasAppc");
                        int b25 = androidx.room.t.b.b(b2, "downloadCampaigns");
                        if (b2.moveToFirst()) {
                            String string = b2.getString(b3);
                            long j2 = b2.getLong(b4);
                            String string2 = b2.getString(b5);
                            String string3 = b2.getString(b6);
                            String string4 = b2.getString(b7);
                            String string5 = b2.getString(b8);
                            long j3 = b2.getLong(b9);
                            String string6 = b2.getString(b10);
                            int i2 = b2.getInt(b11);
                            String string7 = b2.getString(b13);
                            String string8 = b2.getString(b14);
                            String string9 = b2.getString(b15);
                            roomUpdate = new RoomUpdate(j2, string2, string3, string, string4, string5, j3, string6, string8, i2, string7, b2.getString(b16), b2.getString(b17), b2.getString(b18), b2.getString(b19), b2.getString(b20), b2.getString(b21), b2.getInt(b24) != 0, SplitTypeConverter.restoreSplitList(b2.getString(b22)), StringTypeConverter.restoreList(b2.getString(b23)), string9, CampaignUrlTypeConverter.restoreCampaignUrlList(b2.getString(b25)));
                            roomUpdate.setExcluded(b2.getInt(b12) != 0);
                        } else {
                            roomUpdate = null;
                        }
                        if (roomUpdate != null) {
                            b2.close();
                            return roomUpdate;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Query returned empty result set: ");
                        try {
                            sb.append(c2.a());
                            throw new EmptyResultSetException(sb.toString());
                        } catch (Throwable th) {
                            th = th;
                            b2.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public void insert(RoomUpdate roomUpdate) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomUpdate.insert((c<RoomUpdate>) roomUpdate);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public void insertAll(List<RoomUpdate> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomUpdate.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
