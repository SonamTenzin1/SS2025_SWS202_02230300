package cm.aptoide.pt.account.view.user;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.LoginSignupManager;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;

/* loaded from: classes.dex */
public class ProfileStepTwoPresenter implements Presenter {
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final AccountNavigator accountNavigator;
    private final CrashReport crashReport;
    private LoginSignupManager loginSignupManager;
    private final ProfileStepTwoView view;

    public ProfileStepTwoPresenter(ProfileStepTwoView profileStepTwoView, AptoideAccountManager aptoideAccountManager, CrashReport crashReport, AccountNavigator accountNavigator, AccountAnalytics accountAnalytics, LoginSignupManager loginSignupManager) {
        this.view = profileStepTwoView;
        this.accountManager = aptoideAccountManager;
        this.crashReport = crashReport;
        this.accountNavigator = accountNavigator;
        this.accountAnalytics = accountAnalytics;
        this.loginSignupManager = loginSignupManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$makeAccountPrivate$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(Throwable th) {
        this.crashReport.log(th);
        return this.view.showGenericErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$makeAccountPublic$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b b(Throwable th) {
        this.crashReport.log(th);
        return this.view.showGenericErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$present$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Boolean bool) {
        this.view.showWaitDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$present$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d() {
        sendAnalytics(AccountAnalytics.ProfileAction.CONTINUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$present$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b e(final Boolean bool) {
        return makeAccountPrivate().z(rx.l.c.a.b()).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.x0
            @Override // rx.m.a
            public final void call() {
                ProfileStepTwoPresenter.this.k();
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.z0
            @Override // rx.m.a
            public final void call() {
                ProfileStepTwoPresenter.this.l();
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.j1
            @Override // rx.m.a
            public final void call() {
                ProfileStepTwoPresenter.this.m(bool);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$present$11(Boolean bool) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$present$14(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$present$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$present$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g() {
        this.view.dismissWaitDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$present$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Boolean bool) {
        navigate(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$present$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b i(final Boolean bool) {
        return makeAccountPublic().z(rx.l.c.a.b()).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.g1
            @Override // rx.m.a
            public final void call() {
                ProfileStepTwoPresenter.this.d();
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.c1
            @Override // rx.m.a
            public final void call() {
                ProfileStepTwoPresenter.this.g();
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.f1
            @Override // rx.m.a
            public final void call() {
                ProfileStepTwoPresenter.this.h(bool);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$present$5(Boolean bool) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$present$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Boolean bool) {
        this.view.showWaitDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$present$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k() {
        sendAnalytics(AccountAnalytics.ProfileAction.PRIVATE_PROFILE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$present$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l() {
        this.view.dismissWaitDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$present$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(Boolean bool) {
        navigate(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendAnalytics$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(AccountAnalytics.ProfileAction profileAction) {
        this.accountAnalytics.accountProfileAction(2, profileAction);
    }

    private rx.b makeAccountPrivate() {
        return this.accountManager.updateAccount(Account.Access.UNLISTED).C(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.d1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ProfileStepTwoPresenter.this.a((Throwable) obj);
            }
        });
    }

    private rx.b makeAccountPublic() {
        return this.accountManager.updateAccount(Account.Access.PUBLIC).C(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ProfileStepTwoPresenter.this.b((Throwable) obj);
            }
        });
    }

    private void navigate(boolean z) {
        if (!z && this.loginSignupManager.shouldShowCreateStore()) {
            this.accountNavigator.navigateToCreateStoreView();
        } else {
            this.accountNavigator.navigateToHomeView();
        }
    }

    private rx.b sendAnalytics(final AccountAnalytics.ProfileAction profileAction) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.account.view.user.b1
            @Override // rx.m.a
            public final void call() {
                ProfileStepTwoPresenter.this.n(profileAction);
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        final rx.e<R> X = this.view.continueButtonClick().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.h1
            @Override // rx.m.b
            public final void call(Object obj) {
                ProfileStepTwoPresenter.this.c((Boolean) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.y0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ProfileStepTwoPresenter.this.i((Boolean) obj);
            }
        }).s0().X(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.e1
            @Override // rx.m.e
            public final Object call(Object obj) {
                ProfileStepTwoPresenter.lambda$present$5((Boolean) obj);
                return null;
            }
        });
        final rx.e<R> X2 = this.view.makePrivateProfileButtonClick().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.i1
            @Override // rx.m.b
            public final void call(Object obj) {
                ProfileStepTwoPresenter.this.j((Boolean) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.o1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ProfileStepTwoPresenter.this.e((Boolean) obj);
            }
        }).s0().X(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                ProfileStepTwoPresenter.lambda$present$11((Boolean) obj);
                return null;
            }
        });
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.m1
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1 == View.LifecycleEvent.CREATE);
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.l1
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e a0;
                a0 = rx.e.a0(rx.e.this, X2);
                return a0;
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.a1
            @Override // rx.m.b
            public final void call(Object obj) {
                ProfileStepTwoPresenter.lambda$present$14((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.n1
            @Override // rx.m.b
            public final void call(Object obj) {
                ProfileStepTwoPresenter.this.f((Throwable) obj);
            }
        });
    }
}
