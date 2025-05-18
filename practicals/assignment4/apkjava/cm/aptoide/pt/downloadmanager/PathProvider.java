package cm.aptoide.pt.downloadmanager;

import cm.aptoide.pt.database.room.RoomFileToDownload;

/* loaded from: classes.dex */
public interface PathProvider {
    String getFilePathFromFileType(RoomFileToDownload roomFileToDownload);
}
