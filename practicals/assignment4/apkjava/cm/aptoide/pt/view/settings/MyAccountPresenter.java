package cm.aptoide.pt.view.settings;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.aptoideviews.socialmedia.SocialMediaView;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStore;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.socialmedia.SocialMediaAnalytics;

/* loaded from: classes.dex */
public class MyAccountPresenter implements Presenter {
    private static final int EDIT_STORE_REQUEST_CODE = 1230;
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final CrashReport crashReport;
    private final MyAccountNavigator myAccountNavigator;
    private final rx.h scheduler;
    private final SocialMediaAnalytics socialMediaAnalytics;
    private final MyAccountView view;

    public MyAccountPresenter(MyAccountView myAccountView, AptoideAccountManager aptoideAccountManager, CrashReport crashReport, rx.h hVar, MyAccountNavigator myAccountNavigator, AccountAnalytics accountAnalytics, SocialMediaAnalytics socialMediaAnalytics) {
        this.view = myAccountView;
        this.accountManager = aptoideAccountManager;
        this.crashReport = crashReport;
        this.scheduler = hVar;
        this.myAccountNavigator = myAccountNavigator;
        this.accountAnalytics = accountAnalytics;
        this.socialMediaAnalytics = socialMediaAnalytics;
    }

    private void handleAptoideBackupCardViewClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.h2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.f((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.f
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.g((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.q
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleAptoideBackupCardViewClick$84((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.g
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.h((Throwable) obj);
            }
        });
    }

    private void handleAptoideTvCardViewClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.y
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.i((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.v0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.j((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.z
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleAptoideTvCardViewClick$74((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.w0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.k((Throwable) obj);
            }
        });
    }

    private void handleAptoideUploaderCardViewClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.z1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.l((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.i2
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.m((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.h1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleAptoideUploaderCardViewClick$79((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.o1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.n((Throwable) obj);
            }
        });
    }

    private void handleSocialMediaPromotionClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.H((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.d0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.I((SocialMediaView.SocialMediaType) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.j1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleSocialMediaPromotionClick$3((SocialMediaView.SocialMediaType) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.n1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.J((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkIfStoreIsInvalidAndRefresh$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(View.LifecycleEvent lifecycleEvent) {
        return this.accountManager.accountStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkIfStoreIsInvalidAndRefresh$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean b(Account account) {
        return Boolean.valueOf(!storeExistsInAccount(account) && account.hasStore());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkIfStoreIsInvalidAndRefresh$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Store store) {
        this.view.refreshUI(store);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkIfStoreIsInvalidAndRefresh$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(Account account) {
        return this.view.getStore().X(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                Store data;
                data = ((GetStore) obj).getNodes().getMeta().getData();
                return data;
            }
        }).j0(this.scheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.d2
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.c((Store) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkIfStoreIsInvalidAndRefresh$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(Store store) {
        return this.accountManager.updateAccount().M();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$checkIfStoreIsInvalidAndRefresh$57(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleAptoideBackupCardViewClick$82, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(View.LifecycleEvent lifecycleEvent) {
        return this.view.aptoideBackupCardViewClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleAptoideBackupCardViewClick$83, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Void r1) {
        this.myAccountNavigator.navigateToBackupApps();
        this.accountAnalytics.sendPromoteAptoideBackupAppsEvent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleAptoideBackupCardViewClick$84(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleAptoideBackupCardViewClick$85, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleAptoideTvCardViewClick$72, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e i(View.LifecycleEvent lifecycleEvent) {
        return this.view.aptoideTvCardViewClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleAptoideTvCardViewClick$73, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Void r1) {
        this.view.startAptoideTvWebView();
        this.accountAnalytics.sendPromoteAptoideTVEvent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleAptoideTvCardViewClick$74(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleAptoideTvCardViewClick$75, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleAptoideUploaderCardViewClick$77, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e l(View.LifecycleEvent lifecycleEvent) {
        return this.view.aptoideUploaderCardViewClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleAptoideUploaderCardViewClick$78, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(Void r1) {
        this.myAccountNavigator.navigateToUploader();
        this.accountAnalytics.sendPromoteAptoideUploaderEvent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleAptoideUploaderCardViewClick$79(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleAptoideUploaderCardViewClick$80, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleCreateStoreClick$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e o(View.LifecycleEvent lifecycleEvent) {
        return this.view.createStoreClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleCreateStoreClick$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(Void r1) {
        this.myAccountNavigator.navigateToCreateStore();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleCreateStoreClick$48(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleCreateStoreClick$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleLogOutClick$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e r(View.LifecycleEvent lifecycleEvent) {
        return signOutClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleLogOutClick$61(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleLogOutClick$62, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleLoginClick$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e t(View.LifecycleEvent lifecycleEvent) {
        return this.view.loginClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleLoginClick$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(Void r2) {
        this.myAccountNavigator.navigateToLoginView(AccountAnalytics.AccountOrigins.MY_ACCOUNT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleLoginClick$8(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleLoginClick$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleProfileDisplayableClick$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e w(View.LifecycleEvent lifecycleEvent) {
        return this.view.userClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleProfileDisplayableClick$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e x(Void r1) {
        return this.accountManager.accountStatus().E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleProfileDisplayableClick$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(Account account) {
        this.myAccountNavigator.navigateToUserView(account.getId(), account.getStore().getTheme());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleProfileDisplayableClick$19(Account account) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleProfileDisplayableClick$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleProfileEditClick$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e A(Void r1) {
        return this.accountManager.accountStatus().E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleProfileEditClick$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(Account account) {
        this.myAccountNavigator.navigateToEditProfileView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleProfileEditClick$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e C(View.LifecycleEvent lifecycleEvent) {
        return this.view.editUserProfileClick().G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.A((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.o0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.B((Account) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleProfileEditClick$25(Account account) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleProfileEditClick$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleSettingsClicked$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e E(View.LifecycleEvent lifecycleEvent) {
        return this.view.settingsClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleSettingsClicked$65, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(Void r1) {
        this.myAccountNavigator.navigateToSettings();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleSettingsClicked$66(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleSettingsClicked$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleSocialMediaPromotionClick$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e H(View.LifecycleEvent lifecycleEvent) {
        return this.view.socialMediaClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleSocialMediaPromotionClick$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(SocialMediaView.SocialMediaType socialMediaType) {
        this.myAccountNavigator.navigateToSocialMedia(socialMediaType);
        this.socialMediaAnalytics.sendPromoteSocialMediaClickEvent(socialMediaType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleSocialMediaPromotionClick$3(SocialMediaView.SocialMediaType socialMediaType) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleSocialMediaPromotionClick$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreDisplayableClick$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e K(View.LifecycleEvent lifecycleEvent) {
        return this.view.storeClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreDisplayableClick$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e L(Void r1) {
        return this.accountManager.accountStatus().E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreDisplayableClick$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(Account account) {
        this.myAccountNavigator.navigateToStoreView(account.getStore().getName(), account.getStore().getTheme());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleStoreDisplayableClick$31(Account account) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreDisplayableClick$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreEditClick$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e O(Void r1) {
        return this.view.getStore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreEditClick$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e P(View.LifecycleEvent lifecycleEvent) {
        return this.view.editStoreClick().G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.u1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.O((Void) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Store data;
                data = ((GetStore) obj).getNodes().getMeta().getData();
                return data;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreEditClick$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(Store store) {
        this.myAccountNavigator.navigateToEditStoreView(store, EDIT_STORE_REQUEST_CODE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreEditClick$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreEditResult$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e S(View.LifecycleEvent lifecycleEvent) {
        return this.myAccountNavigator.editStoreResult(EDIT_STORE_REQUEST_CODE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreEditResult$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e T(Boolean bool) {
        return this.accountManager.accountStatus().E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreEditResult$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(Account account) {
        this.view.showAccount(account);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleStoreEditResult$43(Account account) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleStoreEditResult$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$populateAccountViews$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e W(View.LifecycleEvent lifecycleEvent) {
        return this.accountManager.accountStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$populateAccountViews$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X(Account account) {
        this.view.showAccount(account);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$populateAccountViews$13(Account account) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$populateAccountViews$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$signOutClick$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z() {
        this.view.showLoginAccountDisplayable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$signOutClick$69, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$signOutClick$70, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b0(Void r2) {
        return this.accountManager.logout().z(this.scheduler).m(new rx.m.a() { // from class: cm.aptoide.pt.view.settings.r0
            @Override // rx.m.a
            public final void call() {
                MyAccountPresenter.this.Z();
            }
        }).n(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.s0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.a0((Throwable) obj);
            }
        }).M();
    }

    private rx.e<Void> signOutClick() {
        return this.view.signOutClick().G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.q0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.b0((Void) obj);
            }
        }).s0();
    }

    private boolean storeExistsInAccount(Account account) {
        return account.getStore().getId() != 0;
    }

    public void checkIfStoreIsInvalidAndRefresh() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.v1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.a((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.w
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.b((Account) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.d((Account) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.x1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.e((Store) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.a2
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$checkIfStoreIsInvalidAndRefresh$57(obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.g2
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    public void handleCreateStoreClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.w1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.o((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.b0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.p((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.u0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleCreateStoreClick$48((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.f1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.q((Throwable) obj);
            }
        });
    }

    public void handleLogOutClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.y1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.r1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.r((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.y0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleLogOutClick$61((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.k0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.s((Throwable) obj);
            }
        });
    }

    public void handleLoginClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.c2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.t((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.e2
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.u((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.l
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleLoginClick$8((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.z0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.v((Throwable) obj);
            }
        });
    }

    public void handleProfileDisplayableClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.s1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.w((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.x((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.v
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.y((Account) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.l1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleProfileDisplayableClick$19((Account) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.f2
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.z((Throwable) obj);
            }
        });
    }

    public void handleProfileEditClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.i1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.t0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.C((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.c1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleProfileEditClick$25((Account) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.u
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.D((Throwable) obj);
            }
        });
    }

    public void handleSettingsClicked() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.b1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.E((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.m
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.F((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.p1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleSettingsClicked$66((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.e
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.G((Throwable) obj);
            }
        });
    }

    public void handleStoreDisplayableClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.K((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.a1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.L((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.m1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.M((Account) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.n
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleStoreDisplayableClick$31((Account) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.j0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.N((Throwable) obj);
            }
        });
    }

    public void handleStoreEditClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.e1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.P((View.LifecycleEvent) obj);
            }
        }).j0(this.scheduler).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.o
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.Q((Store) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.q1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.R((Throwable) obj);
            }
        });
    }

    public void handleStoreEditResult() {
        rx.e<View.LifecycleEvent> D = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.x0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        });
        MyAccountView myAccountView = this.view;
        View.LifecycleEvent lifecycleEvent = View.LifecycleEvent.DESTROY;
        D.f(myAccountView.bindUntilEvent(lifecycleEvent)).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.S((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.j2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.T((Boolean) obj);
            }
        }).j0(this.scheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.m0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.U((Account) obj);
            }
        }).f(this.view.bindUntilEvent(lifecycleEvent)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.a0
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$handleStoreEditResult$43((Account) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.k2
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.V((Throwable) obj);
            }
        });
    }

    public void populateAccountViews() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.g1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyAccountPresenter.this.W((View.LifecycleEvent) obj);
            }
        }).j0(this.scheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.d1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.X((Account) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.settings.t1
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.lambda$populateAccountViews$13((Account) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.settings.b2
            @Override // rx.m.b
            public final void call(Object obj) {
                MyAccountPresenter.this.Y((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        populateAccountViews();
        checkIfStoreIsInvalidAndRefresh();
        handleLoginClick();
        handleLogOutClick();
        handleCreateStoreClick();
        handleStoreEditClick();
        handleStoreEditResult();
        handleStoreDisplayableClick();
        handleProfileEditClick();
        handleProfileDisplayableClick();
        handleSettingsClicked();
        handleAptoideTvCardViewClick();
        handleAptoideUploaderCardViewClick();
        handleAptoideBackupCardViewClick();
        handleSocialMediaPromotionClick();
    }
}
