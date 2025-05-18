package cm.aptoide.pt.install;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.crashreports.CrashReport;

/* loaded from: classes.dex */
public class RootInstallNotificationEventReceiver extends BroadcastReceiver {
    public static final String ROOT_INSTALL_DISMISS_ACTION = "cm.aptoide.pt.ROOT_INSTALL_DISMISS_ACTION";
    public static final String ROOT_INSTALL_RETRY_ACTION = "cm.aptoide.pt.ROOT_INSTALL_RETRY_ACTION";
    private static final String TAG = RootInstallNotificationEventReceiver.class.getSimpleName();
    private CrashReport crashReport;
    private InstallManager installManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onReceive$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onReceive$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onReceive$2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onReceive$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Throwable th) {
        this.crashReport.log(th);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.installManager = ((AptoideApplication) context.getApplicationContext()).getInstallManager();
        this.crashReport = CrashReport.getInstance();
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        action.hashCode();
        if (!action.equals(ROOT_INSTALL_DISMISS_ACTION)) {
            if (!action.equals(ROOT_INSTALL_RETRY_ACTION)) {
                return;
            } else {
                this.installManager.retryTimedOutInstallations().I(new rx.m.a() { // from class: cm.aptoide.pt.install.h3
                    @Override // rx.m.a
                    public final void call() {
                        RootInstallNotificationEventReceiver.lambda$onReceive$0();
                    }
                }, new rx.m.b() { // from class: cm.aptoide.pt.install.e3
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        RootInstallNotificationEventReceiver.this.a((Throwable) obj);
                    }
                });
            }
        }
        this.installManager.cleanTimedOutInstalls().I(new rx.m.a() { // from class: cm.aptoide.pt.install.g3
            @Override // rx.m.a
            public final void call() {
                RootInstallNotificationEventReceiver.lambda$onReceive$2();
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.f3
            @Override // rx.m.b
            public final void call(Object obj) {
                RootInstallNotificationEventReceiver.this.b((Throwable) obj);
            }
        });
    }
}
