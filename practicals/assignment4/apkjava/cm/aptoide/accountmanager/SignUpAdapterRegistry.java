package cm.aptoide.accountmanager;

import java.util.Map;
import rx.Single;

/* loaded from: classes.dex */
public class SignUpAdapterRegistry {
    private final AccountService accountService;
    private final Map<String, SignUpAdapter> adapters;

    public SignUpAdapterRegistry(Map<String, SignUpAdapter> map, AccountService accountService) {
        this.adapters = map;
        this.accountService = accountService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ rx.b lambda$logoutAll$2(rx.b bVar) {
        return bVar;
    }

    public boolean isEnabled(String str) {
        return this.adapters.get(str).isEnabled();
    }

    public rx.b logoutAll() {
        return rx.e.N(this.adapters.values()).D(new rx.m.e() { // from class: cm.aptoide.accountmanager.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((SignUpAdapter) obj).isEnabled());
                return valueOf;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.accountmanager.y
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.b logout;
                logout = ((SignUpAdapter) obj).logout();
                return logout;
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.accountmanager.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.b bVar = (rx.b) obj;
                SignUpAdapterRegistry.lambda$logoutAll$2(bVar);
                return bVar;
            }
        }).X0();
    }

    public void register(String str, SignUpAdapter signUpAdapter) {
        this.adapters.put(str, signUpAdapter);
    }

    public <T> Single<Account> signUp(String str, T t) {
        return this.adapters.get(str).signUp(t, this.accountService);
    }
}
