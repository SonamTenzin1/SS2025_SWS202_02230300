package cm.aptoide.pt.file;

import cm.aptoide.pt.dataprovider.cache.L2Cache;
import cm.aptoide.pt.downloadmanager.AptoideDownloadManager;
import cm.aptoide.pt.utils.FileUtils;
import rx.Single;

/* loaded from: classes.dex */
public class FileManager {
    private final String[] cacheFolders;
    private final CacheHelper cacheHelper;
    private final AptoideDownloadManager downloadManager;
    private final FileUtils fileUtils;
    private final L2Cache httpClientCache;

    public FileManager(CacheHelper cacheHelper, FileUtils fileUtils, String[] strArr, AptoideDownloadManager aptoideDownloadManager, L2Cache l2Cache) {
        this.cacheHelper = cacheHelper;
        this.fileUtils = fileUtils;
        this.cacheFolders = strArr;
        this.downloadManager = aptoideDownloadManager;
        this.httpClientCache = l2Cache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteCache$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(boolean z, Long l) {
        if (l.longValue() > 0 && z) {
            return this.downloadManager.invalidateDatabase().b(rx.e.S(l));
        }
        return rx.e.S(l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteCache$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Long l) {
        this.httpClientCache.clean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$purgeCache$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single c(Long l) {
        return this.downloadManager.invalidateDatabase().c(Single.m(l));
    }

    public rx.e<Long> deleteCache(final boolean z) {
        return this.fileUtils.deleteFolder(this.cacheFolders).G(new rx.m.e() { // from class: cm.aptoide.pt.file.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return FileManager.this.a(z, (Long) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.file.h
            @Override // rx.m.b
            public final void call(Object obj) {
                FileManager.this.b((Long) obj);
            }
        });
    }

    public Single<Long> purgeCache() {
        return this.cacheHelper.cleanCache().Z0().i(new rx.m.e() { // from class: cm.aptoide.pt.file.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return FileManager.this.c((Long) obj);
            }
        });
    }
}
