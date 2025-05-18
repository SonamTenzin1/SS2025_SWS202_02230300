package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import androidx.room.q;
import androidx.room.t.b;
import c.u.a.f;
import cm.aptoide.pt.download.DownloadAnalytics;
import h.a.m;
import h.a.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class DownloadDAO_Impl implements DownloadDAO {
    private final j __db;
    private final c<RoomDownload> __insertionAdapterOfRoomDownload;
    private final q __preparedStmtOfRemove;
    private final q __preparedStmtOfRemove_1;

    public DownloadDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomDownload = new c<RoomDownload>(jVar) { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `download` (`filesToDownload`,`overallDownloadStatus`,`overallProgress`,`md5`,`appName`,`Icon`,`timeStamp`,`packageName`,`versionCode`,`action`,`versionName`,`hasAppc`,`size`,`storeName`,`trustedBadge`,`downloadError`,`attributionId`,`averageApkDownloadSpeed`,`averageObbDownloadSpeed`,`averageSplitsDownloadSpeed`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomDownload roomDownload) {
                String saveFileToDownloadList = FileToDownloadTypeConverter.saveFileToDownloadList(roomDownload.getFilesToDownload());
                if (saveFileToDownloadList == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, saveFileToDownloadList);
                }
                fVar.h0(2, roomDownload.getOverallDownloadStatus());
                fVar.h0(3, roomDownload.getOverallProgress());
                if (roomDownload.getMd5() == null) {
                    fVar.I0(4);
                } else {
                    fVar.w(4, roomDownload.getMd5());
                }
                if (roomDownload.getAppName() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomDownload.getAppName());
                }
                if (roomDownload.getIcon() == null) {
                    fVar.I0(6);
                } else {
                    fVar.w(6, roomDownload.getIcon());
                }
                fVar.h0(7, roomDownload.getTimeStamp());
                if (roomDownload.getPackageName() == null) {
                    fVar.I0(8);
                } else {
                    fVar.w(8, roomDownload.getPackageName());
                }
                fVar.h0(9, roomDownload.getVersionCode());
                fVar.h0(10, roomDownload.getAction());
                if (roomDownload.getVersionName() == null) {
                    fVar.I0(11);
                } else {
                    fVar.w(11, roomDownload.getVersionName());
                }
                fVar.h0(12, roomDownload.hasAppc() ? 1L : 0L);
                fVar.h0(13, roomDownload.getSize());
                if (roomDownload.getStoreName() == null) {
                    fVar.I0(14);
                } else {
                    fVar.w(14, roomDownload.getStoreName());
                }
                if (roomDownload.getTrustedBadge() == null) {
                    fVar.I0(15);
                } else {
                    fVar.w(15, roomDownload.getTrustedBadge());
                }
                fVar.h0(16, roomDownload.getDownloadError());
                if (roomDownload.getAttributionId() == null) {
                    fVar.I0(17);
                } else {
                    fVar.w(17, roomDownload.getAttributionId());
                }
                fVar.h0(18, roomDownload.getAverageApkDownloadSpeed());
                fVar.h0(19, roomDownload.getAverageObbDownloadSpeed());
                fVar.h0(20, roomDownload.getAverageSplitsDownloadSpeed());
            }
        };
        this.__preparedStmtOfRemove = new q(jVar) { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE from download where md5= ?";
            }
        };
        this.__preparedStmtOfRemove_1 = new q(jVar) { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.3
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE from download where packageName=? and versionCode=?";
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<List<RoomDownload>> getAll() {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * from download", 0);
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<List<RoomDownload>>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.4
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomDownload> call() throws Exception {
                Cursor b2 = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, "filesToDownload");
                    int b4 = b.b(b2, "overallDownloadStatus");
                    int b5 = b.b(b2, "overallProgress");
                    int b6 = b.b(b2, "md5");
                    int b7 = b.b(b2, "appName");
                    int b8 = b.b(b2, "Icon");
                    int b9 = b.b(b2, "timeStamp");
                    int b10 = b.b(b2, "packageName");
                    int b11 = b.b(b2, RoomInstalled.VERSION_CODE);
                    int b12 = b.b(b2, "action");
                    int b13 = b.b(b2, RoomInstalled.VERSION_NAME);
                    int b14 = b.b(b2, "hasAppc");
                    int b15 = b.b(b2, "size");
                    int b16 = b.b(b2, "storeName");
                    int b17 = b.b(b2, "trustedBadge");
                    int b18 = b.b(b2, "downloadError");
                    int b19 = b.b(b2, "attributionId");
                    int b20 = b.b(b2, "averageApkDownloadSpeed");
                    int b21 = b.b(b2, "averageObbDownloadSpeed");
                    int b22 = b.b(b2, "averageSplitsDownloadSpeed");
                    int i2 = b16;
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        RoomDownload roomDownload = new RoomDownload();
                        int i3 = b3;
                        roomDownload.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(b2.getString(b3)));
                        roomDownload.setOverallDownloadStatus(b2.getInt(b4));
                        roomDownload.setOverallProgress(b2.getInt(b5));
                        roomDownload.setMd5(b2.getString(b6));
                        roomDownload.setAppName(b2.getString(b7));
                        roomDownload.setIcon(b2.getString(b8));
                        int i4 = b4;
                        int i5 = b5;
                        roomDownload.setTimeStamp(b2.getLong(b9));
                        roomDownload.setPackageName(b2.getString(b10));
                        roomDownload.setVersionCode(b2.getInt(b11));
                        roomDownload.setAction(b2.getInt(b12));
                        roomDownload.setVersionName(b2.getString(b13));
                        roomDownload.setHasAppc(b2.getInt(b14) != 0);
                        roomDownload.setSize(b2.getLong(b15));
                        int i6 = i2;
                        roomDownload.setStoreName(b2.getString(i6));
                        int i7 = b17;
                        roomDownload.setTrustedBadge(b2.getString(i7));
                        i2 = i6;
                        int i8 = b18;
                        roomDownload.setDownloadError(b2.getInt(i8));
                        b18 = i8;
                        int i9 = b19;
                        roomDownload.setAttributionId(b2.getString(i9));
                        int i10 = b20;
                        roomDownload.setAverageApkDownloadSpeed(b2.getLong(i10));
                        int i11 = b21;
                        int i12 = b6;
                        roomDownload.setAverageObbDownloadSpeed(b2.getLong(i11));
                        int i13 = b22;
                        int i14 = b7;
                        roomDownload.setAverageSplitsDownloadSpeed(b2.getLong(i13));
                        arrayList.add(roomDownload);
                        b6 = i12;
                        b7 = i14;
                        b21 = i11;
                        b22 = i13;
                        b4 = i4;
                        b17 = i7;
                        b19 = i9;
                        b5 = i5;
                        b20 = i10;
                        b3 = i3;
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<List<RoomDownload>> getAsList(String str) {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * from download where md5 = ?", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<List<RoomDownload>>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.9
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomDownload> call() throws Exception {
                Cursor b2 = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, "filesToDownload");
                    int b4 = b.b(b2, "overallDownloadStatus");
                    int b5 = b.b(b2, "overallProgress");
                    int b6 = b.b(b2, "md5");
                    int b7 = b.b(b2, "appName");
                    int b8 = b.b(b2, "Icon");
                    int b9 = b.b(b2, "timeStamp");
                    int b10 = b.b(b2, "packageName");
                    int b11 = b.b(b2, RoomInstalled.VERSION_CODE);
                    int b12 = b.b(b2, "action");
                    int b13 = b.b(b2, RoomInstalled.VERSION_NAME);
                    int b14 = b.b(b2, "hasAppc");
                    int b15 = b.b(b2, "size");
                    int b16 = b.b(b2, "storeName");
                    int b17 = b.b(b2, "trustedBadge");
                    int b18 = b.b(b2, "downloadError");
                    int b19 = b.b(b2, "attributionId");
                    int b20 = b.b(b2, "averageApkDownloadSpeed");
                    int b21 = b.b(b2, "averageObbDownloadSpeed");
                    int b22 = b.b(b2, "averageSplitsDownloadSpeed");
                    int i2 = b16;
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        RoomDownload roomDownload = new RoomDownload();
                        int i3 = b3;
                        roomDownload.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(b2.getString(b3)));
                        roomDownload.setOverallDownloadStatus(b2.getInt(b4));
                        roomDownload.setOverallProgress(b2.getInt(b5));
                        roomDownload.setMd5(b2.getString(b6));
                        roomDownload.setAppName(b2.getString(b7));
                        roomDownload.setIcon(b2.getString(b8));
                        int i4 = b4;
                        int i5 = b5;
                        roomDownload.setTimeStamp(b2.getLong(b9));
                        roomDownload.setPackageName(b2.getString(b10));
                        roomDownload.setVersionCode(b2.getInt(b11));
                        roomDownload.setAction(b2.getInt(b12));
                        roomDownload.setVersionName(b2.getString(b13));
                        roomDownload.setHasAppc(b2.getInt(b14) != 0);
                        roomDownload.setSize(b2.getLong(b15));
                        int i6 = i2;
                        roomDownload.setStoreName(b2.getString(i6));
                        int i7 = b17;
                        roomDownload.setTrustedBadge(b2.getString(i7));
                        i2 = i6;
                        int i8 = b18;
                        roomDownload.setDownloadError(b2.getInt(i8));
                        b18 = i8;
                        int i9 = b19;
                        roomDownload.setAttributionId(b2.getString(i9));
                        int i10 = b20;
                        roomDownload.setAverageApkDownloadSpeed(b2.getLong(i10));
                        int i11 = b21;
                        int i12 = b6;
                        roomDownload.setAverageObbDownloadSpeed(b2.getLong(i11));
                        int i13 = b22;
                        int i14 = b7;
                        roomDownload.setAverageSplitsDownloadSpeed(b2.getLong(i13));
                        arrayList.add(roomDownload);
                        b6 = i12;
                        b7 = i14;
                        b21 = i11;
                        b22 = i13;
                        b4 = i4;
                        b17 = i7;
                        b19 = i9;
                        b5 = i5;
                        b20 = i10;
                        b3 = i3;
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<RoomDownload> getAsObservable(String str) {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * from download where md5 = ? LIMIT 1 ", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<RoomDownload>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.6
            protected void finalize() {
                c2.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomDownload call() throws Exception {
                RoomDownload roomDownload;
                Cursor b2 = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, "filesToDownload");
                    int b4 = b.b(b2, "overallDownloadStatus");
                    int b5 = b.b(b2, "overallProgress");
                    int b6 = b.b(b2, "md5");
                    int b7 = b.b(b2, "appName");
                    int b8 = b.b(b2, "Icon");
                    int b9 = b.b(b2, "timeStamp");
                    int b10 = b.b(b2, "packageName");
                    int b11 = b.b(b2, RoomInstalled.VERSION_CODE);
                    int b12 = b.b(b2, "action");
                    int b13 = b.b(b2, RoomInstalled.VERSION_NAME);
                    int b14 = b.b(b2, "hasAppc");
                    int b15 = b.b(b2, "size");
                    int b16 = b.b(b2, "storeName");
                    int b17 = b.b(b2, "trustedBadge");
                    int b18 = b.b(b2, "downloadError");
                    int b19 = b.b(b2, "attributionId");
                    int b20 = b.b(b2, "averageApkDownloadSpeed");
                    int b21 = b.b(b2, "averageObbDownloadSpeed");
                    int b22 = b.b(b2, "averageSplitsDownloadSpeed");
                    if (b2.moveToFirst()) {
                        RoomDownload roomDownload2 = new RoomDownload();
                        roomDownload2.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(b2.getString(b3)));
                        roomDownload2.setOverallDownloadStatus(b2.getInt(b4));
                        roomDownload2.setOverallProgress(b2.getInt(b5));
                        roomDownload2.setMd5(b2.getString(b6));
                        roomDownload2.setAppName(b2.getString(b7));
                        roomDownload2.setIcon(b2.getString(b8));
                        roomDownload2.setTimeStamp(b2.getLong(b9));
                        roomDownload2.setPackageName(b2.getString(b10));
                        roomDownload2.setVersionCode(b2.getInt(b11));
                        roomDownload2.setAction(b2.getInt(b12));
                        roomDownload2.setVersionName(b2.getString(b13));
                        roomDownload2.setHasAppc(b2.getInt(b14) != 0);
                        roomDownload2.setSize(b2.getLong(b15));
                        roomDownload2.setStoreName(b2.getString(b16));
                        roomDownload2.setTrustedBadge(b2.getString(b17));
                        roomDownload2.setDownloadError(b2.getInt(b18));
                        roomDownload2.setAttributionId(b2.getString(b19));
                        roomDownload2.setAverageApkDownloadSpeed(b2.getLong(b20));
                        roomDownload2.setAverageObbDownloadSpeed(b2.getLong(b21));
                        roomDownload2.setAverageSplitsDownloadSpeed(b2.getLong(b22));
                        roomDownload = roomDownload2;
                    } else {
                        roomDownload = null;
                    }
                    return roomDownload;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public s<RoomDownload> getAsSingle(String str) {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * from download where md5 = ? LIMIT 1 ", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        return n.c(new Callable<RoomDownload>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.5
            protected void finalize() {
                c2.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomDownload call() throws Exception {
                RoomDownload roomDownload;
                Cursor b2 = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, "filesToDownload");
                    int b4 = b.b(b2, "overallDownloadStatus");
                    int b5 = b.b(b2, "overallProgress");
                    int b6 = b.b(b2, "md5");
                    int b7 = b.b(b2, "appName");
                    int b8 = b.b(b2, "Icon");
                    int b9 = b.b(b2, "timeStamp");
                    int b10 = b.b(b2, "packageName");
                    int b11 = b.b(b2, RoomInstalled.VERSION_CODE);
                    int b12 = b.b(b2, "action");
                    int b13 = b.b(b2, RoomInstalled.VERSION_NAME);
                    int b14 = b.b(b2, "hasAppc");
                    int b15 = b.b(b2, "size");
                    int b16 = b.b(b2, "storeName");
                    try {
                        int b17 = b.b(b2, "trustedBadge");
                        int b18 = b.b(b2, "downloadError");
                        int b19 = b.b(b2, "attributionId");
                        int b20 = b.b(b2, "averageApkDownloadSpeed");
                        int b21 = b.b(b2, "averageObbDownloadSpeed");
                        int b22 = b.b(b2, "averageSplitsDownloadSpeed");
                        if (b2.moveToFirst()) {
                            RoomDownload roomDownload2 = new RoomDownload();
                            roomDownload2.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(b2.getString(b3)));
                            roomDownload2.setOverallDownloadStatus(b2.getInt(b4));
                            roomDownload2.setOverallProgress(b2.getInt(b5));
                            roomDownload2.setMd5(b2.getString(b6));
                            roomDownload2.setAppName(b2.getString(b7));
                            roomDownload2.setIcon(b2.getString(b8));
                            roomDownload2.setTimeStamp(b2.getLong(b9));
                            roomDownload2.setPackageName(b2.getString(b10));
                            roomDownload2.setVersionCode(b2.getInt(b11));
                            roomDownload2.setAction(b2.getInt(b12));
                            roomDownload2.setVersionName(b2.getString(b13));
                            roomDownload2.setHasAppc(b2.getInt(b14) != 0);
                            roomDownload2.setSize(b2.getLong(b15));
                            roomDownload2.setStoreName(b2.getString(b16));
                            roomDownload2.setTrustedBadge(b2.getString(b17));
                            roomDownload2.setDownloadError(b2.getInt(b18));
                            roomDownload2.setAttributionId(b2.getString(b19));
                            roomDownload2.setAverageApkDownloadSpeed(b2.getLong(b20));
                            roomDownload2.setAverageObbDownloadSpeed(b2.getLong(b21));
                            roomDownload2.setAverageSplitsDownloadSpeed(b2.getLong(b22));
                            roomDownload = roomDownload2;
                        } else {
                            roomDownload = null;
                        }
                        if (roomDownload != null) {
                            b2.close();
                            return roomDownload;
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

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<List<RoomDownload>> getInQueueSortedDownloads() {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * from download where overallDownloadStatus=13 ORDER BY timeStamp ASC", 0);
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<List<RoomDownload>>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.8
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomDownload> call() throws Exception {
                Cursor b2 = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, "filesToDownload");
                    int b4 = b.b(b2, "overallDownloadStatus");
                    int b5 = b.b(b2, "overallProgress");
                    int b6 = b.b(b2, "md5");
                    int b7 = b.b(b2, "appName");
                    int b8 = b.b(b2, "Icon");
                    int b9 = b.b(b2, "timeStamp");
                    int b10 = b.b(b2, "packageName");
                    int b11 = b.b(b2, RoomInstalled.VERSION_CODE);
                    int b12 = b.b(b2, "action");
                    int b13 = b.b(b2, RoomInstalled.VERSION_NAME);
                    int b14 = b.b(b2, "hasAppc");
                    int b15 = b.b(b2, "size");
                    int b16 = b.b(b2, "storeName");
                    int b17 = b.b(b2, "trustedBadge");
                    int b18 = b.b(b2, "downloadError");
                    int b19 = b.b(b2, "attributionId");
                    int b20 = b.b(b2, "averageApkDownloadSpeed");
                    int b21 = b.b(b2, "averageObbDownloadSpeed");
                    int b22 = b.b(b2, "averageSplitsDownloadSpeed");
                    int i2 = b16;
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        RoomDownload roomDownload = new RoomDownload();
                        int i3 = b3;
                        roomDownload.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(b2.getString(b3)));
                        roomDownload.setOverallDownloadStatus(b2.getInt(b4));
                        roomDownload.setOverallProgress(b2.getInt(b5));
                        roomDownload.setMd5(b2.getString(b6));
                        roomDownload.setAppName(b2.getString(b7));
                        roomDownload.setIcon(b2.getString(b8));
                        int i4 = b4;
                        int i5 = b5;
                        roomDownload.setTimeStamp(b2.getLong(b9));
                        roomDownload.setPackageName(b2.getString(b10));
                        roomDownload.setVersionCode(b2.getInt(b11));
                        roomDownload.setAction(b2.getInt(b12));
                        roomDownload.setVersionName(b2.getString(b13));
                        roomDownload.setHasAppc(b2.getInt(b14) != 0);
                        roomDownload.setSize(b2.getLong(b15));
                        int i6 = i2;
                        roomDownload.setStoreName(b2.getString(i6));
                        int i7 = b17;
                        roomDownload.setTrustedBadge(b2.getString(i7));
                        i2 = i6;
                        int i8 = b18;
                        roomDownload.setDownloadError(b2.getInt(i8));
                        b18 = i8;
                        int i9 = b19;
                        roomDownload.setAttributionId(b2.getString(i9));
                        int i10 = b20;
                        roomDownload.setAverageApkDownloadSpeed(b2.getLong(i10));
                        int i11 = b21;
                        int i12 = b6;
                        roomDownload.setAverageObbDownloadSpeed(b2.getLong(i11));
                        int i13 = b22;
                        int i14 = b7;
                        roomDownload.setAverageSplitsDownloadSpeed(b2.getLong(i13));
                        arrayList.add(roomDownload);
                        b6 = i12;
                        b7 = i14;
                        b21 = i11;
                        b22 = i13;
                        b4 = i4;
                        b17 = i7;
                        b19 = i9;
                        b5 = i5;
                        b20 = i10;
                        b3 = i3;
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<List<RoomDownload>> getOutOfSpaceDownloads() {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * from download where overallDownloadStatus=9 and downloadError=2 ORDER BY timeStamp ASC", 0);
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<List<RoomDownload>>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.10
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomDownload> call() throws Exception {
                Cursor b2 = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, "filesToDownload");
                    int b4 = b.b(b2, "overallDownloadStatus");
                    int b5 = b.b(b2, "overallProgress");
                    int b6 = b.b(b2, "md5");
                    int b7 = b.b(b2, "appName");
                    int b8 = b.b(b2, "Icon");
                    int b9 = b.b(b2, "timeStamp");
                    int b10 = b.b(b2, "packageName");
                    int b11 = b.b(b2, RoomInstalled.VERSION_CODE);
                    int b12 = b.b(b2, "action");
                    int b13 = b.b(b2, RoomInstalled.VERSION_NAME);
                    int b14 = b.b(b2, "hasAppc");
                    int b15 = b.b(b2, "size");
                    int b16 = b.b(b2, "storeName");
                    int b17 = b.b(b2, "trustedBadge");
                    int b18 = b.b(b2, "downloadError");
                    int b19 = b.b(b2, "attributionId");
                    int b20 = b.b(b2, "averageApkDownloadSpeed");
                    int b21 = b.b(b2, "averageObbDownloadSpeed");
                    int b22 = b.b(b2, "averageSplitsDownloadSpeed");
                    int i2 = b16;
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        RoomDownload roomDownload = new RoomDownload();
                        int i3 = b3;
                        roomDownload.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(b2.getString(b3)));
                        roomDownload.setOverallDownloadStatus(b2.getInt(b4));
                        roomDownload.setOverallProgress(b2.getInt(b5));
                        roomDownload.setMd5(b2.getString(b6));
                        roomDownload.setAppName(b2.getString(b7));
                        roomDownload.setIcon(b2.getString(b8));
                        int i4 = b4;
                        int i5 = b5;
                        roomDownload.setTimeStamp(b2.getLong(b9));
                        roomDownload.setPackageName(b2.getString(b10));
                        roomDownload.setVersionCode(b2.getInt(b11));
                        roomDownload.setAction(b2.getInt(b12));
                        roomDownload.setVersionName(b2.getString(b13));
                        roomDownload.setHasAppc(b2.getInt(b14) != 0);
                        roomDownload.setSize(b2.getLong(b15));
                        int i6 = i2;
                        roomDownload.setStoreName(b2.getString(i6));
                        int i7 = b17;
                        roomDownload.setTrustedBadge(b2.getString(i7));
                        i2 = i6;
                        int i8 = b18;
                        roomDownload.setDownloadError(b2.getInt(i8));
                        b18 = i8;
                        int i9 = b19;
                        roomDownload.setAttributionId(b2.getString(i9));
                        int i10 = b20;
                        roomDownload.setAverageApkDownloadSpeed(b2.getLong(i10));
                        int i11 = b21;
                        int i12 = b6;
                        roomDownload.setAverageObbDownloadSpeed(b2.getLong(i11));
                        int i13 = b22;
                        int i14 = b7;
                        roomDownload.setAverageSplitsDownloadSpeed(b2.getLong(i13));
                        arrayList.add(roomDownload);
                        b6 = i12;
                        b7 = i14;
                        b21 = i11;
                        b22 = i13;
                        b4 = i4;
                        b17 = i7;
                        b19 = i9;
                        b5 = i5;
                        b20 = i10;
                        b3 = i3;
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<List<RoomDownload>> getRunningDownloads() {
        final androidx.room.m c2 = androidx.room.m.c("SELECT * from download where overallDownloadStatus = 5 OR overallDownloadStatus = 13 OR overallDownloadStatus = 4", 0);
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<List<RoomDownload>>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.7
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomDownload> call() throws Exception {
                Cursor b2 = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, c2, false, null);
                try {
                    int b3 = b.b(b2, "filesToDownload");
                    int b4 = b.b(b2, "overallDownloadStatus");
                    int b5 = b.b(b2, "overallProgress");
                    int b6 = b.b(b2, "md5");
                    int b7 = b.b(b2, "appName");
                    int b8 = b.b(b2, "Icon");
                    int b9 = b.b(b2, "timeStamp");
                    int b10 = b.b(b2, "packageName");
                    int b11 = b.b(b2, RoomInstalled.VERSION_CODE);
                    int b12 = b.b(b2, "action");
                    int b13 = b.b(b2, RoomInstalled.VERSION_NAME);
                    int b14 = b.b(b2, "hasAppc");
                    int b15 = b.b(b2, "size");
                    int b16 = b.b(b2, "storeName");
                    int b17 = b.b(b2, "trustedBadge");
                    int b18 = b.b(b2, "downloadError");
                    int b19 = b.b(b2, "attributionId");
                    int b20 = b.b(b2, "averageApkDownloadSpeed");
                    int b21 = b.b(b2, "averageObbDownloadSpeed");
                    int b22 = b.b(b2, "averageSplitsDownloadSpeed");
                    int i2 = b16;
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        RoomDownload roomDownload = new RoomDownload();
                        int i3 = b3;
                        roomDownload.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(b2.getString(b3)));
                        roomDownload.setOverallDownloadStatus(b2.getInt(b4));
                        roomDownload.setOverallProgress(b2.getInt(b5));
                        roomDownload.setMd5(b2.getString(b6));
                        roomDownload.setAppName(b2.getString(b7));
                        roomDownload.setIcon(b2.getString(b8));
                        int i4 = b4;
                        int i5 = b5;
                        roomDownload.setTimeStamp(b2.getLong(b9));
                        roomDownload.setPackageName(b2.getString(b10));
                        roomDownload.setVersionCode(b2.getInt(b11));
                        roomDownload.setAction(b2.getInt(b12));
                        roomDownload.setVersionName(b2.getString(b13));
                        roomDownload.setHasAppc(b2.getInt(b14) != 0);
                        roomDownload.setSize(b2.getLong(b15));
                        int i6 = i2;
                        roomDownload.setStoreName(b2.getString(i6));
                        int i7 = b17;
                        roomDownload.setTrustedBadge(b2.getString(i7));
                        i2 = i6;
                        int i8 = b18;
                        roomDownload.setDownloadError(b2.getInt(i8));
                        b18 = i8;
                        int i9 = b19;
                        roomDownload.setAttributionId(b2.getString(i9));
                        int i10 = b20;
                        roomDownload.setAverageApkDownloadSpeed(b2.getLong(i10));
                        int i11 = b21;
                        int i12 = b6;
                        roomDownload.setAverageObbDownloadSpeed(b2.getLong(i11));
                        int i13 = b22;
                        int i14 = b7;
                        roomDownload.setAverageSplitsDownloadSpeed(b2.getLong(i13));
                        arrayList.add(roomDownload);
                        b6 = i12;
                        b7 = i14;
                        b21 = i11;
                        b22 = i13;
                        b4 = i4;
                        b17 = i7;
                        b19 = i9;
                        b5 = i5;
                        b20 = i10;
                        b3 = i3;
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public void insert(RoomDownload roomDownload) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomDownload.insert((c<RoomDownload>) roomDownload);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public void insertAll(List<RoomDownload> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomDownload.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public void remove(String str) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfRemove.acquire();
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
            this.__preparedStmtOfRemove.release(acquire);
        }
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public void remove(String str, int i2) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfRemove_1.acquire();
        if (str == null) {
            acquire.I0(1);
        } else {
            acquire.w(1, str);
        }
        acquire.h0(2, i2);
        this.__db.beginTransaction();
        try {
            acquire.E();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemove_1.release(acquire);
        }
    }
}
