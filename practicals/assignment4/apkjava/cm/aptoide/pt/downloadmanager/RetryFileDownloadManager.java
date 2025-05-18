package cm.aptoide.pt.downloadmanager;

import cm.aptoide.pt.downloadmanager.AppDownloadStatus;
import cm.aptoide.pt.logger.Logger;

/* loaded from: classes.dex */
public class RetryFileDownloadManager implements RetryFileDownloader {
    private static final String TAG = "RetryFileDownloadManage";
    private String alternativeDownloadPath;
    private final String attributionId;
    private FileDownloader fileDownloader;
    private FileDownloaderProvider fileDownloaderProvider;
    private final String fileName;
    private final int fileType;
    private final String mainDownloadPath;
    private String md5;
    private final String packageName;
    private boolean retried;
    private rx.s.b<FileDownloadCallback> retryFileDownloadSubject = rx.s.b.g1();
    private rx.k startDownloadSubscription;
    private final int versionCode;

    public RetryFileDownloadManager(String str, int i2, String str2, int i3, String str3, String str4, FileDownloaderProvider fileDownloaderProvider, String str5, String str6) {
        this.mainDownloadPath = str;
        this.fileType = i2;
        this.packageName = str2;
        this.versionCode = i3;
        this.fileName = str3;
        this.md5 = str4;
        this.fileDownloaderProvider = fileDownloaderProvider;
        this.alternativeDownloadPath = str5;
        this.attributionId = str6;
    }

    private rx.e<FileDownloadCallback> handleFileDownloadProgress(FileDownloader fileDownloader) {
        return fileDownloader.observeFileDownloadProgress().Q0(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.t1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1.getDownloadState() == AppDownloadStatus.AppDownloadState.ERROR_FILE_NOT_FOUND);
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.s1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RetryFileDownloadManager.this.a((FileDownloadCallback) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.downloadmanager.r1
            @Override // rx.m.b
            public final void call(Object obj) {
                RetryFileDownloadManager.this.b((FileDownloadCallback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleFileDownloadProgress$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(FileDownloadCallback fileDownloadCallback) {
        if (fileDownloadCallback.getDownloadState() == AppDownloadStatus.AppDownloadState.ERROR_FILE_NOT_FOUND && !this.retried) {
            Logger.getInstance().d(TAG, "File not found error, restarting the download with the alternative link");
            FileDownloader createFileDownloader = this.fileDownloaderProvider.createFileDownloader(this.md5, this.alternativeDownloadPath, this.fileType, this.packageName, this.versionCode, this.fileName, rx.s.b.g1(), this.attributionId);
            this.retried = true;
            this.fileDownloader = createFileDownloader;
            return createFileDownloader.startFileDownload().b(handleFileDownloadProgress(createFileDownloader));
        }
        return rx.e.S(fileDownloadCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleFileDownloadProgress$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(FileDownloadCallback fileDownloadCallback) {
        this.retryFileDownloadSubject.onNext(fileDownloadCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startFileDownload$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(FileDownloader fileDownloader) {
        return fileDownloader.startFileDownload().b(handleFileDownloadProgress(fileDownloader));
    }

    private FileDownloader setupFileDownloader() {
        FileDownloader createFileDownloader = this.fileDownloaderProvider.createFileDownloader(this.md5, this.mainDownloadPath, this.fileType, this.packageName, this.versionCode, this.fileName, rx.s.b.g1(), this.attributionId);
        this.fileDownloader = createFileDownloader;
        return createFileDownloader;
    }

    @Override // cm.aptoide.pt.downloadmanager.RetryFileDownloader
    public rx.e<FileDownloadCallback> observeFileDownloadProgress() {
        return this.retryFileDownloadSubject;
    }

    @Override // cm.aptoide.pt.downloadmanager.RetryFileDownloader
    public rx.b pauseDownload() {
        return this.fileDownloader.pauseDownload();
    }

    @Override // cm.aptoide.pt.downloadmanager.RetryFileDownloader
    public rx.b removeDownloadFile() {
        return this.fileDownloader.removeDownloadFile();
    }

    @Override // cm.aptoide.pt.downloadmanager.RetryFileDownloader
    public void startFileDownload() {
        this.startDownloadSubscription = rx.e.S(setupFileDownloader()).G(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.q1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RetryFileDownloadManager.this.c((FileDownloader) obj);
            }
        }).D0();
    }

    @Override // cm.aptoide.pt.downloadmanager.RetryFileDownloader
    public void stop() {
        rx.k kVar = this.startDownloadSubscription;
        if (kVar == null || kVar.isUnsubscribed()) {
            return;
        }
        this.startDownloadSubscription.unsubscribe();
    }

    @Override // cm.aptoide.pt.downloadmanager.RetryFileDownloader
    public void stopFailedDownload() {
        this.fileDownloader.stopFailedDownload();
    }
}
