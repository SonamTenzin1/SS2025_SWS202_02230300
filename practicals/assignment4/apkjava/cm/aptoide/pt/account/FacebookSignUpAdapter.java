package cm.aptoide.pt.account;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AccountService;
import cm.aptoide.accountmanager.SignUpAdapter;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Single;
import rx.schedulers.Schedulers;

/* loaded from: classes.dex */
public class FacebookSignUpAdapter implements SignUpAdapter<FacebookLoginResult> {
    public static final String TYPE = "FACEBOOK";
    private final List<String> facebookRequiredPermissions;
    private final com.facebook.login.x loginManager;
    private final LoginPreferences loginPreferences;

    public FacebookSignUpAdapter(List<String> list, com.facebook.login.x xVar, LoginPreferences loginPreferences) {
        this.facebookRequiredPermissions = list;
        this.loginManager = xVar;
        this.loginPreferences = loginPreferences;
    }

    private Single<String> getFacebookEmail(final AccessToken accessToken) {
        return Single.c(new Callable() { // from class: cm.aptoide.pt.account.o0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FacebookSignUpAdapter.lambda$getFacebookEmail$3(AccessToken.this);
            }
        }).v(Schedulers.io());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Single lambda$getFacebookEmail$3(AccessToken accessToken) throws Exception {
        try {
            com.facebook.d0 j2 = GraphRequest.B(accessToken, null).j();
            JSONObject c2 = j2.c();
            if (j2.b() == null && c2 != null) {
                try {
                    return Single.m(c2.has("email") ? c2.getString("email") : c2.getString(DeepLinkIntentReceiver.DeepLinksKeys.ID));
                } catch (JSONException unused) {
                    return Single.h(new FacebookSignUpException(99, "Error parsing email"));
                }
            }
            return Single.h(new FacebookSignUpException(99, "Unknown error(maybe network error when getting user data)"));
        } catch (RuntimeException e2) {
            return Single.h(new FacebookSignUpException(99, e2.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$logout$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a() {
        this.loginManager.m();
    }

    @Override // cm.aptoide.accountmanager.SignUpAdapter
    public boolean isEnabled() {
        return this.loginPreferences.isFacebookLoginEnabled();
    }

    @Override // cm.aptoide.accountmanager.SignUpAdapter
    public rx.b logout() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.account.q0
            @Override // rx.m.a
            public final void call() {
                FacebookSignUpAdapter.this.a();
            }
        });
    }

    @Override // cm.aptoide.accountmanager.SignUpAdapter
    public Single<Account> signUp(final FacebookLoginResult facebookLoginResult, final AccountService accountService) {
        if (!isEnabled()) {
            return Single.h(new IllegalStateException("Facebook sign up is not enabled"));
        }
        if (facebookLoginResult.getState() == 1) {
            return Single.h(new FacebookSignUpException(2, "USER_CANCELLED"));
        }
        if (facebookLoginResult.getState() == 99) {
            return Single.c(new Callable() { // from class: cm.aptoide.pt.account.p0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Single h2;
                    h2 = Single.h(new FacebookSignUpException(99, FacebookLoginResult.this.getError().getMessage()));
                    return h2;
                }
            });
        }
        if (!facebookLoginResult.getResult().a().j().containsAll(this.facebookRequiredPermissions)) {
            return Single.h(new FacebookSignUpException(1, "MISSING_REQUIRED_PERMISSIONS"));
        }
        return getFacebookEmail(facebookLoginResult.getResult().a()).i(new rx.m.e() { // from class: cm.aptoide.pt.account.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Single createAccount;
                createAccount = AccountService.this.createAccount((String) obj, facebookLoginResult.getResult().a().l(), FacebookSignUpAdapter.TYPE);
                return createAccount;
            }
        });
    }
}
