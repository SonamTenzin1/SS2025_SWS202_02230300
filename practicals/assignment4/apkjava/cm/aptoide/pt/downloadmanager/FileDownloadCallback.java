package cm.aptoide.pt.downloadmanager;

import cm.aptoide.pt.downloadmanager.AppDownloadStatus;

/* loaded from: classes.dex */
public interface FileDownloadCallback {
    FileDownloadProgressResult getDownloadProgress();

    int getDownloadSpeed();

    AppDownloadStatus.AppDownloadState getDownloadState();

    DownloadError getError();

    int getFileType();

    String getMd5();

    boolean hasError();
}
