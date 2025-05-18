package cm.aptoide.pt.store.view.my;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import rx.exceptions.OnErrorNotImplementedException;

/* loaded from: classes.dex */
public class MyStoresPresenter implements Presenter {
    private final AptoideAccountManager accountManager;
    private final MyStoresNavigator myStoresNavigator;
    private final MyStoresView view;
    private final rx.h viewScheduler;

    public MyStoresPresenter(MyStoresView myStoresView, rx.h hVar, AptoideAccountManager aptoideAccountManager, MyStoresNavigator myStoresNavigator) {
        this.view = myStoresView;
        this.viewScheduler = hVar;
        this.accountManager = aptoideAccountManager;
        this.myStoresNavigator = myStoresNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserAvatar, reason: merged with bridge method [inline-methods] */
    public rx.e<String> f(Account account) {
        return rx.e.S((account == null || !account.isLoggedIn()) ? null : account.getAvatar());
    }

    private void handleBottomNavigationEvent() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.store.view.my.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.store.view.my.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyStoresPresenter.this.b((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.j
            @Override // rx.m.b
            public final void call(Object obj) {
                MyStoresPresenter.lambda$handleBottomNavigationEvent$14((Integer) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.w
            @Override // rx.m.b
            public final void call(Object obj) {
                MyStoresPresenter.lambda$handleBottomNavigationEvent$15((Throwable) obj);
                throw null;
            }
        });
    }

    private void handleUserImageClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.store.view.my.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.store.view.my.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyStoresPresenter.this.d((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.i
            @Override // rx.m.b
            public final void call(Object obj) {
                MyStoresPresenter.lambda$handleUserImageClick$3((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.u
            @Override // rx.m.b
            public final void call(Object obj) {
                MyStoresPresenter.lambda$handleUserImageClick$4((Throwable) obj);
                throw null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleBottomNavigationEvent$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Integer num) {
        this.view.scrollToTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleBottomNavigationEvent$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(View.LifecycleEvent lifecycleEvent) {
        return this.myStoresNavigator.bottomNavigationEvent().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.r
            @Override // rx.m.b
            public final void call(Object obj) {
                MyStoresPresenter.this.a((Integer) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleBottomNavigationEvent$14(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleBottomNavigationEvent$15(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUserImageClick$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Void r1) {
        this.myStoresNavigator.navigateToMyAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleUserImageClick$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(View.LifecycleEvent lifecycleEvent) {
        return this.view.imageClick().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.s
            @Override // rx.m.b
            public final void call(Object obj) {
                MyStoresPresenter.this.c((Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleUserImageClick$3(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleUserImageClick$4(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$loadUserImage$10(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUserImage$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(View.LifecycleEvent lifecycleEvent) {
        return this.accountManager.accountStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUserImage$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(String str) {
        if (str != null) {
            this.view.setUserImage(str);
        } else {
            this.view.setDefaultUserImage();
        }
        this.view.showAvatar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$loadUserImage$9(String str) {
    }

    private void loadUserImage() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.store.view.my.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
                return valueOf;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.store.view.my.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyStoresPresenter.this.e((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.store.view.my.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MyStoresPresenter.this.f((Account) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.m
            @Override // rx.m.b
            public final void call(Object obj) {
                MyStoresPresenter.this.g((String) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.t
            @Override // rx.m.b
            public final void call(Object obj) {
                MyStoresPresenter.lambda$loadUserImage$9((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.v
            @Override // rx.m.b
            public final void call(Object obj) {
                MyStoresPresenter.lambda$loadUserImage$10((Throwable) obj);
                throw null;
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        loadUserImage();
        handleBottomNavigationEvent();
        handleUserImageClick();
    }
}
