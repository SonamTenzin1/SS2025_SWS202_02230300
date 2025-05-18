package cm.aptoide.pt.home.more.appcoins;

import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceNavigatorWrapper;
import cm.aptoide.pt.home.bundles.apps.RewardApp;
import cm.aptoide.pt.home.more.base.ListAppsClickEvent;
import cm.aptoide.pt.home.more.base.ListAppsPresenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.promotions.WalletApp;
import cm.aptoide.pt.repository.request.RewardAppCoinsAppsRepository;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* compiled from: EarnAppcListPresenter.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0016J\b\u0010)\u001a\u00020&H\u0002J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0\u001fH\u0002J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\u0014\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020 0\u001fH\u0016J\b\u00100\u001a\u00020&H\u0002J\u000e\u00101\u001a\b\u0012\u0004\u0012\u0002020\u001fH\u0002J\u000e\u00103\u001a\b\u0012\u0004\u0012\u0002020\u001fH\u0002J\b\u00104\u001a\u00020&H\u0016J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0002J\u0016\u00108\u001a\b\u0012\u0004\u0012\u0002020\u001f2\u0006\u00109\u001a\u000202H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcm/aptoide/pt/home/more/appcoins/EarnAppcListPresenter;", "Lcm/aptoide/pt/home/more/base/ListAppsPresenter;", "Lcm/aptoide/pt/home/bundles/apps/RewardApp;", "view", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListView;", "viewScheduler", "Lrx/Scheduler;", "crashReporter", "Lcm/aptoide/pt/crashreports/CrashReport;", "rewardAppsRepository", "Lcm/aptoide/pt/repository/request/RewardAppCoinsAppsRepository;", "analyticsManager", "Lcm/aptoide/analytics/AnalyticsManager;", "appNavigator", "Lcm/aptoide/pt/app/AppNavigator;", "earnAppcListConfiguration", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListConfiguration;", "earnAppcListManager", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListManager;", "permissionManager", "Lcm/aptoide/pt/actions/PermissionManager;", "permissionService", "Lcm/aptoide/pt/actions/PermissionService;", "moPubAdsManager", "Lcm/aptoide/pt/ads/MoPubAdsManager;", "earnAppcListAnalytics", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListAnalytics;", "earnAppcNavigator", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcNavigator;", "(Lcm/aptoide/pt/home/more/appcoins/EarnAppcListView;Lrx/Scheduler;Lcm/aptoide/pt/crashreports/CrashReport;Lcm/aptoide/pt/repository/request/RewardAppCoinsAppsRepository;Lcm/aptoide/analytics/AnalyticsManager;Lcm/aptoide/pt/app/AppNavigator;Lcm/aptoide/pt/home/more/appcoins/EarnAppcListConfiguration;Lcm/aptoide/pt/home/more/appcoins/EarnAppcListManager;Lcm/aptoide/pt/actions/PermissionManager;Lcm/aptoide/pt/actions/PermissionService;Lcm/aptoide/pt/ads/MoPubAdsManager;Lcm/aptoide/pt/home/more/appcoins/EarnAppcListAnalytics;Lcm/aptoide/pt/home/more/appcoins/EarnAppcNavigator;)V", "getApps", "Lrx/Observable;", HttpUrl.FRAGMENT_ENCODE_SET, "refresh", HttpUrl.FRAGMENT_ENCODE_SET, "getTitle", HttpUrl.FRAGMENT_ENCODE_SET, "handleAppClick", HttpUrl.FRAGMENT_ENCODE_SET, "appClickEvent", "Lcm/aptoide/pt/home/more/base/ListAppsClickEvent;", "handleCancelDownload", "handleOnWalletInstalled", "handleOutOfSpaceDialogResult", "handlePauseDownload", "handleResumeDownload", "handleWalletInstallClick", "loadMoreApps", "loadWalletApp", "observeWalletDownloadError", "Lcm/aptoide/pt/promotions/WalletApp;", "observeWalletState", "present", "startWalletDownload", "Lrx/Completable;", "actionCompletable", "verifyNotEnoughSpaceError", "walletApp", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EarnAppcListPresenter extends ListAppsPresenter<RewardApp> {
    private final AnalyticsManager analyticsManager;
    private final AppNavigator appNavigator;
    private final CrashReport crashReporter;
    private final EarnAppcListAnalytics earnAppcListAnalytics;
    private final EarnAppcListConfiguration earnAppcListConfiguration;
    private final EarnAppcListManager earnAppcListManager;
    private final EarnAppcNavigator earnAppcNavigator;
    private final MoPubAdsManager moPubAdsManager;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private final RewardAppCoinsAppsRepository rewardAppsRepository;
    private final EarnAppcListView view;
    private final rx.h viewScheduler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarnAppcListPresenter(EarnAppcListView earnAppcListView, rx.h hVar, CrashReport crashReport, RewardAppCoinsAppsRepository rewardAppCoinsAppsRepository, AnalyticsManager analyticsManager, AppNavigator appNavigator, EarnAppcListConfiguration earnAppcListConfiguration, EarnAppcListManager earnAppcListManager, PermissionManager permissionManager, PermissionService permissionService, MoPubAdsManager moPubAdsManager, EarnAppcListAnalytics earnAppcListAnalytics, EarnAppcNavigator earnAppcNavigator) {
        super(earnAppcListView, hVar, crashReport);
        kotlin.jvm.internal.m.f(earnAppcListView, "view");
        kotlin.jvm.internal.m.f(hVar, "viewScheduler");
        kotlin.jvm.internal.m.f(crashReport, "crashReporter");
        kotlin.jvm.internal.m.f(rewardAppCoinsAppsRepository, "rewardAppsRepository");
        kotlin.jvm.internal.m.f(analyticsManager, "analyticsManager");
        kotlin.jvm.internal.m.f(appNavigator, "appNavigator");
        kotlin.jvm.internal.m.f(earnAppcListConfiguration, "earnAppcListConfiguration");
        kotlin.jvm.internal.m.f(earnAppcListManager, "earnAppcListManager");
        kotlin.jvm.internal.m.f(permissionManager, "permissionManager");
        kotlin.jvm.internal.m.f(permissionService, "permissionService");
        kotlin.jvm.internal.m.f(moPubAdsManager, "moPubAdsManager");
        kotlin.jvm.internal.m.f(earnAppcListAnalytics, "earnAppcListAnalytics");
        kotlin.jvm.internal.m.f(earnAppcNavigator, "earnAppcNavigator");
        this.view = earnAppcListView;
        this.viewScheduler = hVar;
        this.crashReporter = crashReport;
        this.rewardAppsRepository = rewardAppCoinsAppsRepository;
        this.analyticsManager = analyticsManager;
        this.appNavigator = appNavigator;
        this.earnAppcListConfiguration = earnAppcListConfiguration;
        this.earnAppcListManager = earnAppcListManager;
        this.permissionManager = permissionManager;
        this.permissionService = permissionService;
        this.moPubAdsManager = moPubAdsManager;
        this.earnAppcListAnalytics = earnAppcListAnalytics;
        this.earnAppcNavigator = earnAppcNavigator;
    }

    private final void handleCancelDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean m188handleCancelDownload$lambda20;
                m188handleCancelDownload$lambda20 = EarnAppcListPresenter.m188handleCancelDownload$lambda20((View.LifecycleEvent) obj);
                return m188handleCancelDownload$lambda20;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e m189handleCancelDownload$lambda22;
                m189handleCancelDownload$lambda22 = EarnAppcListPresenter.m189handleCancelDownload$lambda22(EarnAppcListPresenter.this, (View.LifecycleEvent) obj);
                return m189handleCancelDownload$lambda22;
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.p
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m191handleCancelDownload$lambda23((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.i0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m192handleCancelDownload$lambda24(EarnAppcListPresenter.this, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleCancelDownload$lambda-20, reason: not valid java name */
    public static final Boolean m188handleCancelDownload$lambda20(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleCancelDownload$lambda-22, reason: not valid java name */
    public static final rx.e m189handleCancelDownload$lambda22(final EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.view.cancelDownload().H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.b m190handleCancelDownload$lambda22$lambda21;
                m190handleCancelDownload$lambda22$lambda21 = EarnAppcListPresenter.m190handleCancelDownload$lambda22$lambda21(EarnAppcListPresenter.this, (Void) obj);
                return m190handleCancelDownload$lambda22$lambda21;
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleCancelDownload$lambda-22$lambda-21, reason: not valid java name */
    public static final rx.b m190handleCancelDownload$lambda22$lambda21(EarnAppcListPresenter earnAppcListPresenter, Void r1) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.earnAppcListManager.cancelWalletDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleCancelDownload$lambda-23, reason: not valid java name */
    public static final void m191handleCancelDownload$lambda23(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleCancelDownload$lambda-24, reason: not valid java name */
    public static final void m192handleCancelDownload$lambda24(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    private final rx.e<Boolean> handleOnWalletInstalled() {
        rx.e<Boolean> x = this.earnAppcListManager.onWalletInstalled().E().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.m0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m193handleOnWalletInstalled$lambda6(EarnAppcListPresenter.this, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.e(x, "earnAppcListManager.onWa…{ view.hideWalletArea() }");
        return x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleOnWalletInstalled$lambda-6, reason: not valid java name */
    public static final void m193handleOnWalletInstalled$lambda6(EarnAppcListPresenter earnAppcListPresenter, Boolean bool) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.view.hideWalletArea();
    }

    private final void handleOutOfSpaceDialogResult() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.a1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean m194handleOutOfSpaceDialogResult$lambda0;
                m194handleOutOfSpaceDialogResult$lambda0 = EarnAppcListPresenter.m194handleOutOfSpaceDialogResult$lambda0((View.LifecycleEvent) obj);
                return m194handleOutOfSpaceDialogResult$lambda0;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e m195handleOutOfSpaceDialogResult$lambda1;
                m195handleOutOfSpaceDialogResult$lambda1 = EarnAppcListPresenter.m195handleOutOfSpaceDialogResult$lambda1(EarnAppcListPresenter.this, (View.LifecycleEvent) obj);
                return m195handleOutOfSpaceDialogResult$lambda1;
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean m196handleOutOfSpaceDialogResult$lambda2;
                m196handleOutOfSpaceDialogResult$lambda2 = EarnAppcListPresenter.m196handleOutOfSpaceDialogResult$lambda2((OutOfSpaceNavigatorWrapper) obj);
                return m196handleOutOfSpaceDialogResult$lambda2;
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.a0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.b m197handleOutOfSpaceDialogResult$lambda3;
                m197handleOutOfSpaceDialogResult$lambda3 = EarnAppcListPresenter.m197handleOutOfSpaceDialogResult$lambda3(EarnAppcListPresenter.this, (OutOfSpaceNavigatorWrapper) obj);
                return m197handleOutOfSpaceDialogResult$lambda3;
            }
        }).s0().f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.b0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m198handleOutOfSpaceDialogResult$lambda4((OutOfSpaceNavigatorWrapper) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.h0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m199handleOutOfSpaceDialogResult$lambda5(EarnAppcListPresenter.this, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleOutOfSpaceDialogResult$lambda-0, reason: not valid java name */
    public static final Boolean m194handleOutOfSpaceDialogResult$lambda0(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleOutOfSpaceDialogResult$lambda-1, reason: not valid java name */
    public static final rx.e m195handleOutOfSpaceDialogResult$lambda1(EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.earnAppcNavigator.outOfSpaceDialogResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleOutOfSpaceDialogResult$lambda-2, reason: not valid java name */
    public static final Boolean m196handleOutOfSpaceDialogResult$lambda2(OutOfSpaceNavigatorWrapper outOfSpaceNavigatorWrapper) {
        return Boolean.valueOf(outOfSpaceNavigatorWrapper.getClearedSuccessfully());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleOutOfSpaceDialogResult$lambda-3, reason: not valid java name */
    public static final rx.b m197handleOutOfSpaceDialogResult$lambda3(EarnAppcListPresenter earnAppcListPresenter, OutOfSpaceNavigatorWrapper outOfSpaceNavigatorWrapper) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.startWalletDownload(earnAppcListPresenter.earnAppcListManager.resumeWalletDownload());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleOutOfSpaceDialogResult$lambda-4, reason: not valid java name */
    public static final void m198handleOutOfSpaceDialogResult$lambda4(OutOfSpaceNavigatorWrapper outOfSpaceNavigatorWrapper) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleOutOfSpaceDialogResult$lambda-5, reason: not valid java name */
    public static final void m199handleOutOfSpaceDialogResult$lambda5(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    private final void handlePauseDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean m200handlePauseDownload$lambda30;
                m200handlePauseDownload$lambda30 = EarnAppcListPresenter.m200handlePauseDownload$lambda30((View.LifecycleEvent) obj);
                return m200handlePauseDownload$lambda30;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.w
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e m201handlePauseDownload$lambda32;
                m201handlePauseDownload$lambda32 = EarnAppcListPresenter.m201handlePauseDownload$lambda32(EarnAppcListPresenter.this, (View.LifecycleEvent) obj);
                return m201handlePauseDownload$lambda32;
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.q0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m203handlePauseDownload$lambda33((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.s0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m204handlePauseDownload$lambda34(EarnAppcListPresenter.this, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handlePauseDownload$lambda-30, reason: not valid java name */
    public static final Boolean m200handlePauseDownload$lambda30(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handlePauseDownload$lambda-32, reason: not valid java name */
    public static final rx.e m201handlePauseDownload$lambda32(final EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.view.pauseDownload().H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.b m202handlePauseDownload$lambda32$lambda31;
                m202handlePauseDownload$lambda32$lambda31 = EarnAppcListPresenter.m202handlePauseDownload$lambda32$lambda31(EarnAppcListPresenter.this, (Void) obj);
                return m202handlePauseDownload$lambda32$lambda31;
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handlePauseDownload$lambda-32$lambda-31, reason: not valid java name */
    public static final rx.b m202handlePauseDownload$lambda32$lambda31(EarnAppcListPresenter earnAppcListPresenter, Void r1) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.earnAppcListManager.pauseWalletDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handlePauseDownload$lambda-33, reason: not valid java name */
    public static final void m203handlePauseDownload$lambda33(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handlePauseDownload$lambda-34, reason: not valid java name */
    public static final void m204handlePauseDownload$lambda34(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    private final void handleResumeDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean m205handleResumeDownload$lambda25;
                m205handleResumeDownload$lambda25 = EarnAppcListPresenter.m205handleResumeDownload$lambda25((View.LifecycleEvent) obj);
                return m205handleResumeDownload$lambda25;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.j0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e m206handleResumeDownload$lambda27;
                m206handleResumeDownload$lambda27 = EarnAppcListPresenter.m206handleResumeDownload$lambda27(EarnAppcListPresenter.this, (View.LifecycleEvent) obj);
                return m206handleResumeDownload$lambda27;
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.u
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m208handleResumeDownload$lambda28((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.l0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m209handleResumeDownload$lambda29(EarnAppcListPresenter.this, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResumeDownload$lambda-25, reason: not valid java name */
    public static final Boolean m205handleResumeDownload$lambda25(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResumeDownload$lambda-27, reason: not valid java name */
    public static final rx.e m206handleResumeDownload$lambda27(final EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.view.resumeDownload().H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.v0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.b m207handleResumeDownload$lambda27$lambda26;
                m207handleResumeDownload$lambda27$lambda26 = EarnAppcListPresenter.m207handleResumeDownload$lambda27$lambda26(EarnAppcListPresenter.this, (Void) obj);
                return m207handleResumeDownload$lambda27$lambda26;
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResumeDownload$lambda-27$lambda-26, reason: not valid java name */
    public static final rx.b m207handleResumeDownload$lambda27$lambda26(EarnAppcListPresenter earnAppcListPresenter, Void r1) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.startWalletDownload(earnAppcListPresenter.earnAppcListManager.resumeWalletDownload());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResumeDownload$lambda-28, reason: not valid java name */
    public static final void m208handleResumeDownload$lambda28(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResumeDownload$lambda-29, reason: not valid java name */
    public static final void m209handleResumeDownload$lambda29(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    private final void handleWalletInstallClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean m210handleWalletInstallClick$lambda13;
                m210handleWalletInstallClick$lambda13 = EarnAppcListPresenter.m210handleWalletInstallClick$lambda13((View.LifecycleEvent) obj);
                return m210handleWalletInstallClick$lambda13;
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e m211handleWalletInstallClick$lambda15;
                m211handleWalletInstallClick$lambda15 = EarnAppcListPresenter.m211handleWalletInstallClick$lambda15(EarnAppcListPresenter.this, (View.LifecycleEvent) obj);
                return m211handleWalletInstallClick$lambda15;
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.b1
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m213handleWalletInstallClick$lambda16((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.j
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m214handleWalletInstallClick$lambda17(EarnAppcListPresenter.this, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleWalletInstallClick$lambda-13, reason: not valid java name */
    public static final Boolean m210handleWalletInstallClick$lambda13(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleWalletInstallClick$lambda-15, reason: not valid java name */
    public static final rx.e m211handleWalletInstallClick$lambda15(final EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.view.onWalletInstallClick().H(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.b m212handleWalletInstallClick$lambda15$lambda14;
                m212handleWalletInstallClick$lambda15$lambda14 = EarnAppcListPresenter.m212handleWalletInstallClick$lambda15$lambda14(EarnAppcListPresenter.this, (Void) obj);
                return m212handleWalletInstallClick$lambda15$lambda14;
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleWalletInstallClick$lambda-15$lambda-14, reason: not valid java name */
    public static final rx.b m212handleWalletInstallClick$lambda15$lambda14(EarnAppcListPresenter earnAppcListPresenter, Void r1) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.startWalletDownload(earnAppcListPresenter.earnAppcListManager.downloadApp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleWalletInstallClick$lambda-16, reason: not valid java name */
    public static final void m213handleWalletInstallClick$lambda16(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleWalletInstallClick$lambda-17, reason: not valid java name */
    public static final void m214handleWalletInstallClick$lambda17(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    private final void loadWalletApp() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean m218loadWalletApp$lambda7;
                m218loadWalletApp$lambda7 = EarnAppcListPresenter.m218loadWalletApp$lambda7((View.LifecycleEvent) obj);
                return m218loadWalletApp$lambda7;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e m219loadWalletApp$lambda8;
                m219loadWalletApp$lambda8 = EarnAppcListPresenter.m219loadWalletApp$lambda8(EarnAppcListPresenter.this, (View.LifecycleEvent) obj);
                return m219loadWalletApp$lambda8;
            }
        }).E().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.z
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m220loadWalletApp$lambda9(EarnAppcListPresenter.this, (WalletApp) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e m215loadWalletApp$lambda10;
                m215loadWalletApp$lambda10 = EarnAppcListPresenter.m215loadWalletApp$lambda10(EarnAppcListPresenter.this, (WalletApp) obj);
                return m215loadWalletApp$lambda10;
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.o0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m216loadWalletApp$lambda11(obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.r
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m217loadWalletApp$lambda12(EarnAppcListPresenter.this, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadWalletApp$lambda-10, reason: not valid java name */
    public static final rx.e m215loadWalletApp$lambda10(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return rx.e.g0(earnAppcListPresenter.observeWalletState(), earnAppcListPresenter.handleOnWalletInstalled(), earnAppcListPresenter.observeWalletDownloadError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadWalletApp$lambda-11, reason: not valid java name */
    public static final void m216loadWalletApp$lambda11(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadWalletApp$lambda-12, reason: not valid java name */
    public static final void m217loadWalletApp$lambda12(EarnAppcListPresenter earnAppcListPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        earnAppcListPresenter.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadWalletApp$lambda-7, reason: not valid java name */
    public static final Boolean m218loadWalletApp$lambda7(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadWalletApp$lambda-8, reason: not valid java name */
    public static final rx.e m219loadWalletApp$lambda8(EarnAppcListPresenter earnAppcListPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.earnAppcListManager.getWalletApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadWalletApp$lambda-9, reason: not valid java name */
    public static final void m220loadWalletApp$lambda9(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        EarnAppcListView earnAppcListView = earnAppcListPresenter.view;
        kotlin.jvm.internal.m.e(walletApp, "walletApp");
        earnAppcListView.setupWallet(walletApp);
    }

    private final rx.e<WalletApp> observeWalletDownloadError() {
        rx.e<WalletApp> s0 = rx.e.a0(this.view.resumeDownload(), this.view.onWalletInstallClick()).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e m221observeWalletDownloadError$lambda40;
                m221observeWalletDownloadError$lambda40 = EarnAppcListPresenter.m221observeWalletDownloadError$lambda40(EarnAppcListPresenter.this, (Void) obj);
                return m221observeWalletDownloadError$lambda40;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e m224observeWalletDownloadError$lambda41;
                m224observeWalletDownloadError$lambda41 = EarnAppcListPresenter.m224observeWalletDownloadError$lambda41(EarnAppcListPresenter.this, (WalletApp) obj);
                return m224observeWalletDownloadError$lambda41;
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.y
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).s0();
        kotlin.jvm.internal.m.e(s0, "merge(view.resumeDownloa…kTrace() }\n      .retry()");
        return s0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeWalletDownloadError$lambda-40, reason: not valid java name */
    public static final rx.e m221observeWalletDownloadError$lambda40(final EarnAppcListPresenter earnAppcListPresenter, Void r2) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        return earnAppcListPresenter.earnAppcListManager.observeWalletApp().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean m222observeWalletDownloadError$lambda40$lambda38;
                m222observeWalletDownloadError$lambda40$lambda38 = EarnAppcListPresenter.m222observeWalletDownloadError$lambda40$lambda38((WalletApp) obj);
                return m222observeWalletDownloadError$lambda40$lambda38;
            }
        }).j0(earnAppcListPresenter.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.v
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m223observeWalletDownloadError$lambda40$lambda39(EarnAppcListPresenter.this, (WalletApp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeWalletDownloadError$lambda-40$lambda-38, reason: not valid java name */
    public static final Boolean m222observeWalletDownloadError$lambda40$lambda38(WalletApp walletApp) {
        DownloadModel downloadModel = walletApp.getDownloadModel();
        if (downloadModel != null) {
            return Boolean.valueOf(downloadModel.hasError());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeWalletDownloadError$lambda-40$lambda-39, reason: not valid java name */
    public static final void m223observeWalletDownloadError$lambda40$lambda39(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        kotlin.jvm.internal.m.f(walletApp, "walletApp");
        DownloadModel downloadModel = walletApp.getDownloadModel();
        if ((downloadModel != null ? downloadModel.getDownloadState() : null) == DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR) {
            earnAppcListPresenter.earnAppcNavigator.openOutOfSpaceDialog(walletApp.getSize(), walletApp.getPackageName());
        } else {
            earnAppcListPresenter.view.showDownloadError(walletApp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeWalletDownloadError$lambda-41, reason: not valid java name */
    public static final rx.e m224observeWalletDownloadError$lambda41(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        kotlin.jvm.internal.m.e(walletApp, "walletApp");
        return earnAppcListPresenter.verifyNotEnoughSpaceError(walletApp);
    }

    private final rx.e<WalletApp> observeWalletState() {
        rx.e<WalletApp> w = this.earnAppcListManager.observeWalletApp().G(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.t0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e m226observeWalletState$lambda35;
                m226observeWalletState$lambda35 = EarnAppcListPresenter.m226observeWalletState$lambda35(EarnAppcListPresenter.this, (WalletApp) obj);
                return m226observeWalletState$lambda35;
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.z0
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListPresenter.m227observeWalletState$lambda36(EarnAppcListPresenter.this, (WalletApp) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.x
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
        kotlin.jvm.internal.m.e(w, "earnAppcListManager.obse… -> e.printStackTrace() }");
        return w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeWalletState$lambda-35, reason: not valid java name */
    public static final rx.e m226observeWalletState$lambda35(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        kotlin.jvm.internal.m.e(walletApp, "walletApp");
        return earnAppcListPresenter.verifyNotEnoughSpaceError(walletApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeWalletState$lambda-36, reason: not valid java name */
    public static final void m227observeWalletState$lambda36(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        EarnAppcListView earnAppcListView = earnAppcListPresenter.view;
        kotlin.jvm.internal.m.e(walletApp, "walletApp");
        earnAppcListView.updateState(walletApp);
    }

    private final rx.b startWalletDownload(rx.b bVar) {
        rx.b X0 = rx.e.p(new rx.m.d() { // from class: cm.aptoide.pt.home.more.appcoins.o
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                rx.e m229startWalletDownload$lambda19;
                m229startWalletDownload$lambda19 = EarnAppcListPresenter.m229startWalletDownload$lambda19(EarnAppcListPresenter.this);
                return m229startWalletDownload$lambda19;
            }
        }).j0(this.viewScheduler).G(new EarnAppcListPresenter$startWalletDownload$2(this, bVar)).X0();
        kotlin.jvm.internal.m.e(X0, "private fun startWalletD…    }.toCompletable()\n  }");
        return X0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startWalletDownload$lambda-19, reason: not valid java name */
    public static final rx.e m229startWalletDownload$lambda19(final EarnAppcListPresenter earnAppcListPresenter) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        if (earnAppcListPresenter.earnAppcListManager.shouldShowRootInstallWarningPopup()) {
            earnAppcListPresenter.view.showRootInstallWarningPopup().x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.c1
                @Override // rx.m.b
                public final void call(Object obj) {
                    EarnAppcListPresenter.m230startWalletDownload$lambda19$lambda18(EarnAppcListPresenter.this, (Boolean) obj);
                }
            });
        }
        return rx.e.S(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startWalletDownload$lambda-19$lambda-18, reason: not valid java name */
    public static final void m230startWalletDownload$lambda19$lambda18(EarnAppcListPresenter earnAppcListPresenter, Boolean bool) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        EarnAppcListManager earnAppcListManager = earnAppcListPresenter.earnAppcListManager;
        kotlin.jvm.internal.m.e(bool, "answer");
        earnAppcListManager.allowRootInstall(bool.booleanValue());
    }

    private final rx.e<WalletApp> verifyNotEnoughSpaceError(final WalletApp walletApp) {
        DownloadModel downloadModel = walletApp.getDownloadModel();
        if (downloadModel != null && downloadModel.getDownloadState() == DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR) {
            rx.e.S(walletApp).x(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.k0
                @Override // rx.m.b
                public final void call(Object obj) {
                    EarnAppcListPresenter.m231verifyNotEnoughSpaceError$lambda44$lambda43(EarnAppcListPresenter.this, walletApp, (WalletApp) obj);
                }
            });
        }
        rx.e<WalletApp> S = rx.e.S(walletApp);
        kotlin.jvm.internal.m.e(S, "just(walletApp)");
        return S;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verifyNotEnoughSpaceError$lambda-44$lambda-43, reason: not valid java name */
    public static final void m231verifyNotEnoughSpaceError$lambda44$lambda43(EarnAppcListPresenter earnAppcListPresenter, WalletApp walletApp, WalletApp walletApp2) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "this$0");
        kotlin.jvm.internal.m.f(walletApp, "$walletApp");
        earnAppcListPresenter.earnAppcListAnalytics.sendNotEnoughSpaceErrorEvent(walletApp.getMd5sum());
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsPresenter
    public rx.e<List<RewardApp>> getApps(boolean z) {
        rx.e<List<RewardApp>> freshAppCoinsRewardAppsFromHomeMore = this.rewardAppsRepository.getFreshAppCoinsRewardAppsFromHomeMore("appcoins-ads");
        kotlin.jvm.internal.m.e(freshAppCoinsRewardAppsFromHomeMore, "rewardAppsRepository.get…mHomeMore(\"appcoins-ads\")");
        return freshAppCoinsRewardAppsFromHomeMore;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsPresenter
    public String getTitle() {
        String title = this.earnAppcListConfiguration.getTitle();
        return title == null ? HttpUrl.FRAGMENT_ENCODE_SET : title;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsPresenter
    public void handleAppClick(ListAppsClickEvent<RewardApp> appClickEvent) {
        kotlin.jvm.internal.m.f(appClickEvent, "appClickEvent");
        RewardApp application = appClickEvent.getApplication();
        this.analyticsManager.logEvent(appClickEvent.getApplication().getClickUrl());
        AppNavigator appNavigator = this.appNavigator;
        long appId = application.getAppId();
        String packageName = application.getPackageName();
        String tag = this.earnAppcListConfiguration.getTag();
        String downloadUrl = application.getDownloadUrl();
        RewardApp.Reward reward = application.getReward();
        appNavigator.navigateWithDownloadUrlAndReward(appId, packageName, tag, downloadUrl, reward != null ? (float) reward.getAppc() : -1.0f);
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsPresenter
    public rx.e<List<RewardApp>> loadMoreApps() {
        rx.e<List<RewardApp>> nextAppCoinsRewardAppsFromHomeMore = this.rewardAppsRepository.getNextAppCoinsRewardAppsFromHomeMore("appcoins-ads");
        kotlin.jvm.internal.m.e(nextAppCoinsRewardAppsFromHomeMore, "rewardAppsRepository.get…mHomeMore(\"appcoins-ads\")");
        return nextAppCoinsRewardAppsFromHomeMore;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsPresenter, cm.aptoide.pt.presenter.Presenter
    public void present() {
        super.present();
        loadWalletApp();
        handleWalletInstallClick();
        handleResumeDownload();
        handlePauseDownload();
        handleCancelDownload();
        handleOutOfSpaceDialogResult();
    }
}
