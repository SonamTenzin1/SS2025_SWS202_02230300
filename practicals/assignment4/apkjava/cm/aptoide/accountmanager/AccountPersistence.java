package cm.aptoide.accountmanager;

import rx.Single;

/* loaded from: classes.dex */
public interface AccountPersistence {
    Single<Account> getAccount();

    rx.b removeAccount();

    rx.b saveAccount(Account account);
}
