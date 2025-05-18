package cm.aptoide.pt.download;

import cm.aptoide.pt.downloadmanager.Constants;
import cm.aptoide.pt.downloadmanager.FileDownloadCallback;
import cm.aptoide.pt.downloadmanager.FileDownloader;
import e.h.a.q;

/* loaded from: classes.dex */
public class FileDownloadManager implements FileDownloader {
    private static final int APTOIDE_DOWNLOAD_TASK_TAG_KEY = 888;
    public static final int PROGRESS_MAX_VALUE = 100;
    public static final int RETRY_TIMES = 3;
    private int downloadId;
    private String downloadsPath;
    private FileDownloadTask fileDownloadTask;
    private q fileDownloader;
    private final String fileName;
    private final int fileType;
    private final String mainDownloadPath;
    private final String packageName;
    private final int versionCode;

    public FileDownloadManager(q qVar, FileDownloadTask fileDownloadTask, String str, String str2, int i2, String str3, int i3, String str4) {
        this.fileDownloader = qVar;
        this.fileDownloadTask = fileDownloadTask;
        this.downloadsPath = str;
        this.mainDownloadPath = str2;
        this.fileType = i2;
        this.packageName = str3;
        this.versionCode = i3;
        this.fileName = str4;
    }

    private void createBaseDownloadTask(String str, int i2, String str2, int i3, String str3) {
        e.h.a.a d2 = this.fileDownloader.d(str);
        d2.O(3);
        d2.f(Constants.VERSION_CODE, String.valueOf(i2));
        d2.f(Constants.PACKAGE, str2);
        d2.f(Constants.FILE_TYPE, String.valueOf(i3));
        d2.j(APTOIDE_DOWNLOAD_TASK_TAG_KEY, this.fileDownloadTask);
        d2.W(this.fileDownloadTask);
        d2.R(100);
        d2.k(this.downloadsPath + str3);
        this.downloadId = d2.m().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$pauseDownload$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a() {
        this.fileDownloader.k(this.fileDownloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeDownloadFile$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.fileDownloader.c(this.downloadId, this.mainDownloadPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startFileDownload$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c() {
        String str = this.mainDownloadPath;
        if (str != null && !str.isEmpty()) {
            createBaseDownloadTask(this.mainDownloadPath, this.versionCode, this.packageName, this.fileType, this.fileName);
            this.fileDownloader.m(this.fileDownloadTask, true);
            return;
        }
        throw new IllegalArgumentException("The url for the download can not be empty");
    }

    @Override // cm.aptoide.pt.downloadmanager.FileDownloader
    public rx.e<FileDownloadCallback> observeFileDownloadProgress() {
        return this.fileDownloadTask.onDownloadStateChanged();
    }

    @Override // cm.aptoide.pt.downloadmanager.FileDownloader
    public rx.b pauseDownload() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.download.g
            @Override // rx.m.a
            public final void call() {
                FileDownloadManager.this.a();
            }
        });
    }

    @Override // cm.aptoide.pt.downloadmanager.FileDownloader
    public rx.b removeDownloadFile() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.download.f
            @Override // rx.m.a
            public final void call() {
                FileDownloadManager.this.b();
            }
        });
    }

    @Override // cm.aptoide.pt.downloadmanager.FileDownloader
    public rx.b startFileDownload() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.download.h
            @Override // rx.m.a
            public final void call() {
                FileDownloadManager.this.c();
            }
        });
    }

    @Override // cm.aptoide.pt.downloadmanager.FileDownloader
    public void stopFailedDownload() {
        int l = this.fileDownloader.l(this.downloadId, null);
        if (l != 0) {
            this.fileDownloader.j(l);
        }
    }
}
