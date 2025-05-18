package cm.aptoide.pt.home.more.apps;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ListAppsMorePresenter.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ListAppsMorePresenter$url$2 extends Lambda implements Function0<String> {
    final /* synthetic */ ListAppsMorePresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListAppsMorePresenter$url$2(ListAppsMorePresenter listAppsMorePresenter) {
        super(0);
        this.this$0 = listAppsMorePresenter;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        ListAppsConfiguration listAppsConfiguration;
        ListAppsConfiguration listAppsConfiguration2;
        ListAppsConfiguration listAppsConfiguration3;
        SharedPreferences sharedPreferences;
        String A;
        ListAppsConfiguration listAppsConfiguration4;
        SharedPreferences sharedPreferences2;
        String A2;
        listAppsConfiguration = this.this$0.listAppsConfiguration;
        if (listAppsConfiguration.getAction() == null) {
            return null;
        }
        ListAppsMorePresenter listAppsMorePresenter = this.this$0;
        listAppsConfiguration2 = listAppsMorePresenter.listAppsConfiguration;
        if (V7.isUrlBaseCache(listAppsConfiguration2.getAction())) {
            listAppsConfiguration4 = listAppsMorePresenter.listAppsConfiguration;
            String action = listAppsConfiguration4.getAction();
            sharedPreferences2 = listAppsMorePresenter.sharedPreferences;
            String cacheHost = V7.getCacheHost(sharedPreferences2);
            m.e(cacheHost, "getCacheHost(sharedPreferences)");
            A2 = u.A(action, cacheHost, HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null);
            return A2;
        }
        listAppsConfiguration3 = listAppsMorePresenter.listAppsConfiguration;
        String action2 = listAppsConfiguration3.getAction();
        sharedPreferences = listAppsMorePresenter.sharedPreferences;
        String host = V7.getHost(sharedPreferences);
        m.e(host, "getHost(sharedPreferences)");
        A = u.A(action2, host, HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null);
        return A;
    }
}
