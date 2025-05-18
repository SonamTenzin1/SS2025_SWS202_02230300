package cm.aptoide.pt.home.apps;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.home.apps.App;
import cm.aptoide.pt.home.apps.model.StateApp;
import cm.aptoide.pt.home.apps.model.UpdateApp;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.view.rx.RxAlertDialog;
import java.util.List;
import rx.exceptions.OnErrorNotImplementedException;

/* loaded from: classes.dex */
public class AppsPresenter implements Presenter {
    private final AptoideAccountManager accountManager;
    private final AppsManager appsManager;
    private final AppsNavigator appsNavigator;
    private final CrashReport crashReport;
    private final rx.h ioScheduler;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private final AppsFragmentView view;
    private final rx.h viewScheduler;

    public AppsPresenter(AppsFragmentView appsFragmentView, AppsManager appsManager, rx.h hVar, rx.h hVar2, CrashReport crashReport, PermissionManager permissionManager, PermissionService permissionService, AptoideAccountManager aptoideAccountManager, AppsNavigator appsNavigator) {
        this.view = appsFragmentView;
        this.appsManager = appsManager;
        this.viewScheduler = hVar;
        this.ioScheduler = hVar2;
        this.crashReport = crashReport;
        this.permissionManager = permissionManager;
        this.permissionService = permissionService;
        this.accountManager = aptoideAccountManager;
        this.appsNavigator = appsNavigator;
    }

    private rx.e<AppsModel> getAppsModel() {
        return rx.e.d(this.appsManager.getDownloadApps(), this.appsManager.getInstalledApps(), this.appsManager.getUpdatesList(), new rx.m.g() { // from class: cm.aptoide.pt.home.apps.s1
            @Override // rx.m.g
            public final Object a(Object obj, Object obj2, Object obj3) {
                return AppsPresenter.lambda$getAppsModel$61((List) obj, (List) obj2, (List) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserAvatar, reason: merged with bridge method [inline-methods] */
    public rx.e<String> M(Account account) {
        return rx.e.S((account == null || !account.isLoggedIn()) ? null : account.getAvatar());
    }

    private void handleBottomNavigationEvents() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.f3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.a((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.z0
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.b((Integer) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.f1
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleBottomNavigationEvents$37((Integer) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.apps.y0
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleBottomNavigationEvents$38((Throwable) obj);
                throw null;
            }
        });
    }

    private void handleCancelDownloadClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.v0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.m3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.c((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.b1
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleCancelDownloadClick$51((App) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.apps.q1
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.d((Throwable) obj);
            }
        });
    }

    private void handleCardClick() {
        rx.e f2 = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.x1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.o3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.e((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.k3
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.f((App) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        l2 l2Var = new rx.m.b() { // from class: cm.aptoide.pt.home.apps.l2
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleCardClick$13((App) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        f2.H0(l2Var, new b(crashReport));
    }

    private void handleDownloadAbortEvent(String str) {
        this.appsManager.handleDownloadAbort(str).A().H();
    }

    private void handleInstallAppClick() {
        rx.e j0 = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.n1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.i2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.g((View.LifecycleEvent) obj);
            }
        }).j0(this.ioScheduler);
        final AppsManager appsManager = this.appsManager;
        appsManager.getClass();
        j0.H(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.p3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsManager.this.installApp((App) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.o2
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleInstallAppClick$47((App) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.apps.u0
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.h((Throwable) obj);
            }
        });
    }

    private void handleOutOfSpaceAnalytics() {
        rx.e f2 = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.z2
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.h1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.i((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        x0 x0Var = new rx.m.b() { // from class: cm.aptoide.pt.home.apps.x0
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleOutOfSpaceAnalytics$2((List) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        f2.H0(x0Var, new b(crashReport));
    }

    private void handlePauseDownloadClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.b2
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.e1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.j((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.j2
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handlePauseDownloadClick$55((App) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.apps.i3
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.k((Throwable) obj);
            }
        });
    }

    private void handleRefreshApps() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.s2
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.i1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.o((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.t2
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.p((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.apps.w1
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.q((Throwable) obj);
            }
        });
    }

    private void handleResumeClick() {
        rx.e f2 = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.y1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.y2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.r((View.LifecycleEvent) obj);
            }
        }).j0(this.ioScheduler).H(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.p2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.s((App) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        g3 g3Var = new rx.m.b() { // from class: cm.aptoide.pt.home.apps.g3
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleResumeClick$23((App) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        f2.H0(g3Var, new b(crashReport));
    }

    private void handleStartDownloadClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.h3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.z((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.x2
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleStartDownloadClick$32((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.apps.g2
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.A((Throwable) obj);
            }
        });
    }

    private void handleUpdateAllClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.f2
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.c3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.C((View.LifecycleEvent) obj);
            }
        }).j0(this.ioScheduler).H(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.m2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.D((Void) obj);
            }
        }).j0(this.viewScheduler).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.d1
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleUpdateAllClick$43((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.apps.a1
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.E((Throwable) obj);
            }
        });
    }

    private void handleUpdateCardLongClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.v1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.k2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.F((View.LifecycleEvent) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.e2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.H((App) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.d2
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleUpdateCardLongClick$18((App) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.apps.d3
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.I((Throwable) obj);
            }
        });
    }

    private void handleUserAvatarClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.e3
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.w2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.K((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.l3
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleUserAvatarClick$71((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.apps.p1
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$handleUserAvatarClick$72((Throwable) obj);
                throw null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AppsModel lambda$getAppsModel$61(List list, List list2, List list3) {
        return new AppsModel(list3, list2, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleBottomNavigationEvents$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(View.LifecycleEvent lifecycleEvent) {
        return this.appsNavigator.bottomNavigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleBottomNavigationEvents$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Integer num) {
        this.view.scrollToTop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleBottomNavigationEvents$37(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleBottomNavigationEvents$38(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleCancelDownloadClick$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(View.LifecycleEvent lifecycleEvent) {
        rx.e<App> j0 = this.view.cancelDownload().j0(this.ioScheduler);
        final AppsManager appsManager = this.appsManager;
        appsManager.getClass();
        return j0.H(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.s3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsManager.this.cancelDownload((App) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleCancelDownloadClick$51(App app) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleCancelDownloadClick$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleCardClick$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(View.LifecycleEvent lifecycleEvent) {
        return this.view.cardClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleCardClick$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(App app) {
        if (app.getType() == App.Type.DOWNLOAD || app.getType() == App.Type.UPDATE) {
            this.appsManager.setAppViewAnalyticsEvent();
        }
        this.appsNavigator.navigateToAppView(((StateApp) app).getMd5());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleCardClick$13(App app) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleInstallAppClick$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g(View.LifecycleEvent lifecycleEvent) {
        return this.view.installApp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleInstallAppClick$47(App app) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleInstallAppClick$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleOutOfSpaceAnalytics$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e i(View.LifecycleEvent lifecycleEvent) {
        return this.appsManager.observeOutOfSpaceApps();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleOutOfSpaceAnalytics$2(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handlePauseDownloadClick$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e j(View.LifecycleEvent lifecycleEvent) {
        rx.e<App> j0 = this.view.pauseDownload().j0(this.ioScheduler);
        final AppsManager appsManager = this.appsManager;
        appsManager.getClass();
        return j0.H(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.v3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsManager.this.pauseDownload((App) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handlePauseDownloadClick$55(App app) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handlePauseDownloadClick$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleRefreshApps$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l() {
        this.view.hidePullToRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleRefreshApps$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(Throwable th) {
        this.view.hidePullToRefresh();
        th.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleRefreshApps$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b n(Void r2) {
        return this.appsManager.refreshAllUpdates().z(this.viewScheduler).m(new rx.m.a() { // from class: cm.aptoide.pt.home.apps.q2
            @Override // rx.m.a
            public final void call() {
                AppsPresenter.this.l();
            }
        }).n(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.m1
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.m((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleRefreshApps$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e o(View.LifecycleEvent lifecycleEvent) {
        return this.view.refreshApps().j0(this.ioScheduler).H(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.g1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.n((Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleRefreshApps$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(Void r1) {
        this.view.hidePullToRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleRefreshApps$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(Throwable th) {
        this.view.hidePullToRefresh();
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleResumeClick$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e r(View.LifecycleEvent lifecycleEvent) {
        return this.view.resumeDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleResumeClick$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b s(App app) {
        return this.appsManager.resumeDownload(app, app.getType().toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleResumeClick$23(App app) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStartDownloadClick$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(App app, Throwable th) {
        handleDownloadAbortEvent(((UpdateApp) app).getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStartDownloadClick$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(Boolean bool) {
        this.appsManager.storeRootAnswer(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStartDownloadClick$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e v(Void r2) {
        if (this.appsManager.showWarning()) {
            return this.view.showRootWarning().x(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.r1
                @Override // rx.m.b
                public final void call(Object obj) {
                    AppsPresenter.this.u((Boolean) obj);
                }
            });
        }
        return rx.e.S(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStartDownloadClick$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e w(Boolean bool) {
        return this.permissionManager.requestDownloadAccess(this.permissionService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStartDownloadClick$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b x(App app, Void r2) {
        return this.appsManager.updateApp(app);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStartDownloadClick$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e y(final App app) {
        return this.permissionManager.requestExternalStoragePermission(this.permissionService).w(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.b3
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.t(app, (Throwable) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.j3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.v((Void) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.o1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.w((Boolean) obj);
            }
        }).j0(this.ioScheduler).H(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.j1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.x(app, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStartDownloadClick$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e z(View.LifecycleEvent lifecycleEvent) {
        return this.view.startDownload().G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.c1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.y((App) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleStartDownloadClick$32(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStartDownloadClick$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUpdateAllClick$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e B(Void r2) {
        return this.permissionManager.requestExternalStoragePermission(this.permissionService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUpdateAllClick$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e C(View.LifecycleEvent lifecycleEvent) {
        return this.view.updateAll().G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.a3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.B((Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUpdateAllClick$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b D(Void r1) {
        return this.appsManager.updateAll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleUpdateAllClick$43(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUpdateAllClick$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUpdateCardLongClick$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e F(View.LifecycleEvent lifecycleEvent) {
        return this.view.updateLongClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUpdateCardLongClick$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b G(App app, RxAlertDialog.Result result) {
        if (result == RxAlertDialog.Result.POSITIVE) {
            return this.appsManager.excludeUpdate(app);
        }
        return rx.b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUpdateCardLongClick$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b H(final App app) {
        return this.view.showIgnoreUpdateDialog().j(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.c2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.G(app, (RxAlertDialog.Result) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleUpdateCardLongClick$18(App app) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUpdateCardLongClick$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(Throwable th) {
        this.view.showUnknownErrorMessage();
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUserAvatarClick$69, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(Void r1) {
        this.appsNavigator.navigateToMyAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUserAvatarClick$70, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e K(View.LifecycleEvent lifecycleEvent) {
        return this.view.imageClick().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.l1
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.J((Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleUserAvatarClick$71(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleUserAvatarClick$72(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUserImage$63, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e L(View.LifecycleEvent lifecycleEvent) {
        return this.accountManager.accountStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUserImage$65, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(String str) {
        if (str != null) {
            this.view.setUserImage(str);
        } else {
            this.view.setDefaultUserImage();
        }
        this.view.showAvatar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$loadUserImage$66(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$loadUserImage$67(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$observeAppModelState$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e O(View.LifecycleEvent lifecycleEvent) {
        return getAppsModel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$observeAppModelState$59(AppsModel appsModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$observeAppModelState$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(Throwable th) {
        this.crashReport.log(th);
    }

    private void loadUserImage() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.v2
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.u1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.L((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.u2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.M((Account) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.z1
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.N((String) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.t1
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$loadUserImage$66((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.apps.r2
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$loadUserImage$67((Throwable) obj);
                throw null;
            }
        });
    }

    private void observeAppModelState() {
        rx.e j0 = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.h2
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).j0(this.ioScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.a2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsPresenter.this.O((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler);
        final AppsFragmentView appsFragmentView = this.view;
        appsFragmentView.getClass();
        j0.x(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.y3
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsFragmentView.this.showModel((AppsModel) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.n2
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.lambda$observeAppModelState$59((AppsModel) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.apps.n3
            @Override // rx.m.b
            public final void call(Object obj) {
                AppsPresenter.this.P((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        observeAppModelState();
        handlePauseDownloadClick();
        handleResumeClick();
        handleCancelDownloadClick();
        handleInstallAppClick();
        handleUpdateAllClick();
        handleStartDownloadClick();
        handleCardClick();
        handleUpdateCardLongClick();
        loadUserImage();
        handleUserAvatarClick();
        handleBottomNavigationEvents();
        handleRefreshApps();
        handleOutOfSpaceAnalytics();
    }
}
