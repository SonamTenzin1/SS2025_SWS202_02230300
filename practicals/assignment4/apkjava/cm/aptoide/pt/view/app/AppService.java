package cm.aptoide.pt.view.app;

import android.content.SharedPreferences;
import cm.aptoide.pt.aab.Split;
import cm.aptoide.pt.aab.SplitsMapper;
import cm.aptoide.pt.app.mmpcampaigns.CampaignMapper;
import cm.aptoide.pt.dataprovider.exception.NoNetworkConnectionException;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.GetApp;
import cm.aptoide.pt.dataprovider.model.v7.GetAppMeta;
import cm.aptoide.pt.dataprovider.model.v7.ListApps;
import cm.aptoide.pt.dataprovider.model.v7.Malware;
import cm.aptoide.pt.dataprovider.model.v7.Obb;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.dataprovider.model.v7.listapp.File;
import cm.aptoide.pt.dataprovider.model.v7.listapp.ListAppVersions;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.GetAppRequest;
import cm.aptoide.pt.dataprovider.ws.v7.GetRecommendedRequest;
import cm.aptoide.pt.dataprovider.ws.v7.ListAppsRequest;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtils;
import cm.aptoide.pt.view.app.AppsList;
import cm.aptoide.pt.view.app.DetailedAppRequestResult;
import cm.aptoide.pt.view.app.FlagsVote;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.Single;

/* loaded from: classes.dex */
public class AppService {
    private static final int MATURE_APP_RATING = 18;
    private final BodyInterceptor<BaseBody> bodyInterceptorV7;
    private final CampaignMapper campaignMapper;
    private final Converter.Factory converterFactory;
    private final OkHttpClient httpClient;
    private boolean loadingAppcSimilarApps;
    private boolean loadingApps;
    private boolean loadingSimilarApps;
    private final SharedPreferences sharedPreferences;
    private final SplitsMapper splitsMapper;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final TokenInvalidator tokenInvalidator;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cm.aptoide.pt.view.app.AppService$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type;

        static {
            int[] iArr = new int[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type = iArr;
            try {
                iArr[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.FAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.GOOD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.VIRUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.FREEZE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.LICENSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public AppService(StoreCredentialsProvider storeCredentialsProvider, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, SplitsMapper splitsMapper, CampaignMapper campaignMapper) {
        this.storeCredentialsProvider = storeCredentialsProvider;
        this.bodyInterceptorV7 = bodyInterceptor;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
        this.splitsMapper = splitsMapper;
        this.campaignMapper = campaignMapper;
    }

    private boolean canCompare(ListAppVersions listAppVersions) {
        return (listAppVersions == null || listAppVersions.getList() == null || listAppVersions.getList().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createDetailedAppRequestResultError, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public DetailedAppRequestResult N(Throwable th) {
        if (th instanceof NoNetworkConnectionException) {
            return new DetailedAppRequestResult(DetailedAppRequestResult.Error.NETWORK);
        }
        return new DetailedAppRequestResult(DetailedAppRequestResult.Error.GENERIC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createErrorAppsList, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public AppsList I(Throwable th) {
        if (th instanceof NoNetworkConnectionException) {
            return new AppsList(AppsList.Error.NETWORK);
        }
        return new AppsList(AppsList.Error.GENERIC);
    }

    private String getCategory(GetApp.Nodes nodes) {
        try {
            return !nodes.getGroups().getDataList().getList().isEmpty() ? nodes.getGroups().getDataList().getList().get(0).getParent().getName() : HttpUrl.FRAGMENT_ENCODE_SET;
        } catch (Exception e2) {
            e2.printStackTrace();
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    private boolean isBeta(List<String> list, String str) {
        for (String str2 : list) {
            if ("beta".equals(str2) || "alpha".equals(str2)) {
                return true;
            }
        }
        return str.contains("alpha") || str.contains("beta");
    }

    private boolean isLatestTrustedVersion(ListAppVersions listAppVersions, File file) {
        return canCompare(listAppVersions) && file.getMd5sum().equals(listAppVersions.getList().get(0).getFile().getMd5sum()) && file.getMalware().getRank() == Malware.Rank.TRUSTED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAppcRecommendedApps$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a() {
        this.loadingAppcSimilarApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAppcRecommendedApps$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.loadingAppcSimilarApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAppcRecommendedApps$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c() {
        this.loadingAppcSimilarApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadApps$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadApps$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadApps$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedApp$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedApp$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedApp$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedApp$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e n(GetApp getApp) {
        return lambda$loadDetailedAppFromUniqueName$28(getApp, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedApp$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedApp$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedApp$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedApp$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e s(GetApp getApp) {
        return lambda$loadDetailedAppFromUniqueName$28(getApp, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedApp$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ DetailedAppRequestResult t(Throwable th) {
        th.printStackTrace();
        return lambda$unsafeLoadDetailedApp$14(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedAppFromMd5$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedAppFromMd5$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedAppFromMd5$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedAppFromMd5$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e x(GetApp getApp) {
        return lambda$loadDetailedAppFromUniqueName$28(getApp, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedAppFromUniqueName$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedAppFromUniqueName$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDetailedAppFromUniqueName$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadRecommendedApps$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E() {
        this.loadingSimilarApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadRecommendedApps$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F() {
        this.loadingSimilarApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadRecommendedApps$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G() {
        this.loadingSimilarApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$unsafeLoadDetailedApp$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$unsafeLoadDetailedApp$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$unsafeLoadDetailedApp$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$unsafeLoadDetailedApp$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e M(GetApp getApp) {
        return lambda$loadDetailedAppFromUniqueName$28(getApp, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    private Single<AppsList> loadApps(long j2, boolean z, int i2, int i3) {
        if (this.loadingApps) {
            return Single.m(new AppsList(true));
        }
        ListAppsRequest.Body body = new ListAppsRequest.Body(this.storeCredentialsProvider.get(j2), i3, this.sharedPreferences);
        body.setOffset(i2);
        body.setStoreId(j2);
        return new ListAppsRequest(body, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(z, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.v0
            @Override // rx.m.a
            public final void call() {
                AppService.this.f();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.n0
            @Override // rx.m.a
            public final void call() {
                AppService.this.g();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.a0
            @Override // rx.m.a
            public final void call() {
                AppService.this.h();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.i((ListApps) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.j((Throwable) obj);
            }
        });
    }

    private FlagsVote.VoteType map(GetAppMeta.GetAppMetaFile.Flags.Vote.Type type) {
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type[type.ordinal()];
        if (i2 == 1) {
            return FlagsVote.VoteType.FAKE;
        }
        if (i2 == 2) {
            return FlagsVote.VoteType.GOOD;
        }
        if (i2 == 3) {
            return FlagsVote.VoteType.VIRUS;
        }
        if (i2 == 4) {
            return FlagsVote.VoteType.FREEZE;
        }
        if (i2 != 5) {
            return null;
        }
        return FlagsVote.VoteType.LICENSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mapApp, reason: merged with bridge method [inline-methods] */
    public rx.e<DetailedAppRequestResult> C(GetApp getApp, String str) {
        List<Split> emptyList;
        if (getApp.isOk()) {
            GetAppMeta.App data = getApp.getNodes().getMeta().getData();
            ListAppVersions versions = getApp.getNodes().getVersions();
            GetAppMeta.GetAppMetaFile file = data.getFile();
            GetAppMeta.GetAppMetaFile.Flags flags = data.getFile().getFlags();
            GetAppMeta.Developer developer = data.getDeveloper();
            GetAppMeta.Stats stats = data.getStats();
            GetAppMeta.Stats.Rating rating = stats.getRating();
            GetAppMeta.Stats.Rating globalRating = stats.getGlobalRating();
            GetAppMeta.Media media = data.getMedia();
            AppFlags appFlags = new AppFlags(flags.getReview(), mapToFlagsVote(flags.getVotes()));
            AppDeveloper appDeveloper = new AppDeveloper(developer.getName(), developer.getEmail(), developer.getPrivacy(), developer.getWebsite());
            AppStats appStats = new AppStats(new AppRating(rating.getAvg(), rating.getTotal(), mapToRatingsVote(rating.getVotes())), new AppRating(globalRating.getAvg(), globalRating.getTotal(), mapToRatingsVote(globalRating.getVotes())), stats.getDownloads(), stats.getPdownloads());
            AppMedia appMedia = new AppMedia(media.getDescription(), media.getKeywords(), media.getNews(), mapToScreenShots(media.getScreenshots()), mapToVideo(media.getVideos()));
            long id = data.getId();
            String name = data.getName();
            String packageName = data.getPackageName();
            long size = data.getSize();
            String icon = data.getIcon();
            String graphic = data.getGraphic();
            String added = data.getAdded();
            String modified = data.getModified();
            boolean isGoodApp = file.isGoodApp();
            Malware malware = file.getMalware();
            List<String> tags = file.getTags();
            List<String> usedFeatures = file.getUsedFeatures();
            List<String> usedPermissions = file.getUsedPermissions();
            long filesize = file.getFilesize();
            String md5 = data.getMd5();
            String path = file.getPath();
            String pathAlt = file.getPathAlt();
            int vercode = file.getVercode();
            String vername = file.getVername();
            Store store = data.getStore();
            Obb obb = data.getObb();
            boolean isLatestTrustedVersion = isLatestTrustedVersion(versions, file);
            String uname = data.getUname();
            boolean hasBilling = data.hasBilling();
            boolean hasAdvertising = data.hasAdvertising();
            List<String> bdsFlags = data.getBdsFlags();
            boolean z = data.getAge().getRating() == 18;
            String sha1 = data.getFile().getSignature().getSha1();
            if (data.hasSplits()) {
                emptyList = this.splitsMapper.mapSplits(data.getAab().getSplits());
            } else {
                emptyList = Collections.emptyList();
            }
            return rx.e.S(new DetailedAppRequestResult(new DetailedApp(id, name, packageName, size, icon, graphic, added, modified, isGoodApp, malware, appFlags, tags, usedFeatures, usedPermissions, filesize, md5, path, pathAlt, vercode, vername, appDeveloper, store, appMedia, appStats, obb, isLatestTrustedVersion, uname, hasBilling, hasAdvertising, bdsFlags, z, sha1, emptyList, data.hasSplits() ? data.getAab().getRequiredSplits() : Collections.emptyList(), isBeta(file.getTags(), file.getVername()), getCategory(getApp.getNodes()), this.campaignMapper.mapCampaign(data.getUrls()))));
        }
        return rx.e.C(new IllegalStateException("Could not obtain request from server."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mapListApps, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public rx.e<AppsList> H(ListApps listApps) {
        if (listApps.isOk()) {
            ArrayList arrayList = new ArrayList();
            for (App app : listApps.getDataList().getList()) {
                arrayList.add(new Application(app.getName(), app.getIcon(), app.getStats().getRating().getAvg(), app.getStats().getDownloads(), app.getPackageName(), app.getId(), HttpUrl.FRAGMENT_ENCODE_SET, app.getAppcoins() != null && app.getAppcoins().hasBilling()));
            }
            return rx.e.S(new AppsList(arrayList, false, listApps.getDataList().getNext()));
        }
        return rx.e.C(new IllegalStateException("Could not obtain request from server."));
    }

    private List<FlagsVote> mapToFlagsVote(List<GetAppMeta.GetAppMetaFile.Flags.Vote> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GetAppMeta.GetAppMetaFile.Flags.Vote vote : list) {
                arrayList.add(new FlagsVote(vote.getCount(), map(vote.getType())));
            }
        }
        return arrayList;
    }

    private List<RatingVote> mapToRatingsVote(List<GetAppMeta.Stats.Rating.Vote> list) {
        ArrayList arrayList = new ArrayList();
        for (GetAppMeta.Stats.Rating.Vote vote : list) {
            arrayList.add(new RatingVote(vote.getCount(), vote.getValue()));
        }
        return arrayList;
    }

    private List<AppScreenshot> mapToScreenShots(List<GetAppMeta.Media.Screenshot> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GetAppMeta.Media.Screenshot screenshot : list) {
                arrayList.add(new AppScreenshot(screenshot.getHeight(), screenshot.getWidth(), screenshot.getOrientation(), screenshot.getUrl()));
            }
        }
        return arrayList;
    }

    private List<AppVideo> mapToVideo(List<GetAppMeta.Media.Video> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GetAppMeta.Media.Video video : list) {
                arrayList.add(new AppVideo(video.getThumbnail(), video.getType(), video.getUrl()));
            }
        }
        return arrayList;
    }

    public Single<AppsList> loadAppcRecommendedApps(int i2, String str) {
        if (this.loadingAppcSimilarApps) {
            return Single.m(new AppsList(true));
        }
        return new GetRecommendedRequest(new GetRecommendedRequest.Body(i2, str, "appc"), this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(true, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.k0
            @Override // rx.m.a
            public final void call() {
                AppService.this.a();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.p0
            @Override // rx.m.a
            public final void call() {
                AppService.this.b();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.x
            @Override // rx.m.a
            public final void call() {
                AppService.this.c();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.d((ListApps) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.e((Throwable) obj);
            }
        });
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(long j2, String str, String str2) {
        if (this.loadingApps) {
            return Single.m(new DetailedAppRequestResult(true));
        }
        return GetAppRequest.of(j2, null, StoreUtils.getStoreCredentials(str, this.storeCredentialsProvider), str2, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.g0
            @Override // rx.m.a
            public final void call() {
                AppService.this.p();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.t0
            @Override // rx.m.a
            public final void call() {
                AppService.this.q();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.q0
            @Override // rx.m.a
            public final void call() {
                AppService.this.r();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.s((GetApp) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.t((Throwable) obj);
            }
        });
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromMd5(String str) {
        if (this.loadingApps) {
            return Single.m(new DetailedAppRequestResult(true));
        }
        return GetAppRequest.ofMd5(str, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, ManagerPreferences.getAndResetForceServerRefresh(this.sharedPreferences)).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.s0
            @Override // rx.m.a
            public final void call() {
                AppService.this.u();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.v
            @Override // rx.m.a
            public final void call() {
                AppService.this.v();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.l
            @Override // rx.m.a
            public final void call() {
                AppService.this.w();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.x((GetApp) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.y((Throwable) obj);
            }
        });
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromUniqueName(final String str) {
        if (this.loadingApps) {
            return Single.m(new DetailedAppRequestResult(true));
        }
        return GetAppRequest.ofUname(str, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.m0
            @Override // rx.m.a
            public final void call() {
                AppService.this.z();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.y0
            @Override // rx.m.a
            public final void call() {
                AppService.this.A();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.u
            @Override // rx.m.a
            public final void call() {
                AppService.this.B();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.C(str, (GetApp) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.D((Throwable) obj);
            }
        });
    }

    public Single<AppsList> loadFreshApps(long j2, int i2) {
        return loadApps(j2, true, 0, i2);
    }

    public Single<AppsList> loadRecommendedApps(int i2, String str) {
        if (this.loadingSimilarApps) {
            return Single.m(new AppsList(true));
        }
        return new GetRecommendedRequest(new GetRecommendedRequest.Body(i2, str), this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(true, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.w
            @Override // rx.m.a
            public final void call() {
                AppService.this.E();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.r
            @Override // rx.m.a
            public final void call() {
                AppService.this.F();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.y
            @Override // rx.m.a
            public final void call() {
                AppService.this.G();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.H((ListApps) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.I((Throwable) obj);
            }
        });
    }

    public Single<DetailedAppRequestResult> unsafeLoadDetailedApp(long j2, String str, String str2) {
        return GetAppRequest.of(j2, null, StoreUtils.getStoreCredentials(str, this.storeCredentialsProvider), str2, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.o0
            @Override // rx.m.a
            public final void call() {
                AppService.this.J();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.m
            @Override // rx.m.a
            public final void call() {
                AppService.this.K();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.x0
            @Override // rx.m.a
            public final void call() {
                AppService.this.L();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.M((GetApp) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.N((Throwable) obj);
            }
        });
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(String str, String str2) {
        if (this.loadingApps) {
            return Single.m(new DetailedAppRequestResult(true));
        }
        return GetAppRequest.of(str, str2, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.q
            @Override // rx.m.a
            public final void call() {
                AppService.this.k();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.j0
            @Override // rx.m.a
            public final void call() {
                AppService.this.l();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.c0
            @Override // rx.m.a
            public final void call() {
                AppService.this.m();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.n((GetApp) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppService.this.o((Throwable) obj);
            }
        });
    }

    public Single<AppsList> loadApps(long j2, int i2, int i3) {
        return loadApps(j2, false, i2, i3);
    }
}
