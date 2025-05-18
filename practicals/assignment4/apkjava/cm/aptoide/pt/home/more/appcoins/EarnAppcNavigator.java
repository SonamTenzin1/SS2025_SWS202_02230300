package cm.aptoide.pt.home.more.appcoins;

import android.content.Intent;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceDialogFragment;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceNavigatorWrapper;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.Result;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* compiled from: EarnAppcNavigator.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcm/aptoide/pt/home/more/appcoins/EarnAppcNavigator;", HttpUrl.FRAGMENT_ENCODE_SET, "fragmentNavigator", "Lcm/aptoide/pt/navigator/FragmentNavigator;", "(Lcm/aptoide/pt/navigator/FragmentNavigator;)V", "getFragmentNavigator", "()Lcm/aptoide/pt/navigator/FragmentNavigator;", "openOutOfSpaceDialog", "Lrx/Completable;", "requiredSpace", HttpUrl.FRAGMENT_ENCODE_SET, "packageName", HttpUrl.FRAGMENT_ENCODE_SET, "outOfSpaceDialogResult", "Lrx/Observable;", "Lcm/aptoide/pt/download/view/outofspace/OutOfSpaceNavigatorWrapper;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EarnAppcNavigator {
    private final FragmentNavigator fragmentNavigator;

    public EarnAppcNavigator(FragmentNavigator fragmentNavigator) {
        kotlin.jvm.internal.m.f(fragmentNavigator, "fragmentNavigator");
        this.fragmentNavigator = fragmentNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: openOutOfSpaceDialog$lambda-0, reason: not valid java name */
    public static final void m234openOutOfSpaceDialog$lambda0(EarnAppcNavigator earnAppcNavigator, long j2, String str) {
        kotlin.jvm.internal.m.f(earnAppcNavigator, "this$0");
        kotlin.jvm.internal.m.f(str, "$packageName");
        earnAppcNavigator.fragmentNavigator.navigateToDialogForResult(OutOfSpaceDialogFragment.INSTANCE.newInstance(j2, str), 1994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: outOfSpaceDialogResult$lambda-1, reason: not valid java name */
    public static final OutOfSpaceNavigatorWrapper m235outOfSpaceDialogResult$lambda1(Result result) {
        String str;
        kotlin.jvm.internal.m.f(result, "result");
        boolean z = result.getResultCode() == -1;
        if (result.getData() != null) {
            Intent data = result.getData();
            kotlin.jvm.internal.m.c(data);
            str = data.getPackage();
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return new OutOfSpaceNavigatorWrapper(z, str);
    }

    public final FragmentNavigator getFragmentNavigator() {
        return this.fragmentNavigator;
    }

    public final rx.b openOutOfSpaceDialog(final long j2, final String str) {
        kotlin.jvm.internal.m.f(str, "packageName");
        rx.b t = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.home.more.appcoins.d1
            @Override // rx.m.a
            public final void call() {
                EarnAppcNavigator.m234openOutOfSpaceDialog$lambda0(EarnAppcNavigator.this, j2, str);
            }
        });
        kotlin.jvm.internal.m.e(t, "fromAction {\n      fragm…SPACE_REQUEST_CODE)\n    }");
        return t;
    }

    public final rx.e<OutOfSpaceNavigatorWrapper> outOfSpaceDialogResult() {
        rx.e X = this.fragmentNavigator.results(1994).X(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.e1
            @Override // rx.m.e
            public final Object call(Object obj) {
                OutOfSpaceNavigatorWrapper m235outOfSpaceDialogResult$lambda1;
                m235outOfSpaceDialogResult$lambda1 = EarnAppcNavigator.m235outOfSpaceDialogResult$lambda1((Result) obj);
                return m235outOfSpaceDialogResult$lambda1;
            }
        });
        kotlin.jvm.internal.m.e(X, "fragmentNavigator.result…kage() else \"\")\n        }");
        return X;
    }
}
