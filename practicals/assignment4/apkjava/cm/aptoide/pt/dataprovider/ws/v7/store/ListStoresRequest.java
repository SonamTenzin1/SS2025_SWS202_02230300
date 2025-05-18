package cm.aptoide.pt.dataprovider.ws.v7.store;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.store.ListStores;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.Endless;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* loaded from: classes.dex */
public class ListStoresRequest extends V7<ListStores, Body> {
    static final String STORT_BY_DOWNLOADS = "downloads7d";
    private String url;

    /* loaded from: classes.dex */
    public static class Body extends BaseBody implements Endless {
        private Integer limit;
        private int offset;

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public Integer getLimit() {
            return this.limit;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public int getOffset() {
            return this.offset;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public void setOffset(int i2) {
            this.offset = i2;
        }
    }

    private ListStoresRequest(String str, Body body, String str2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator) {
        this(body, str2, bodyInterceptor, okHttpClient, factory, tokenInvalidator);
        this.url = str;
    }

    public static ListStoresRequest ofAction(String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        String replace = str.replace("listStores", HttpUrl.FRAGMENT_ENCODE_SET);
        if (!replace.startsWith("/")) {
            replace = "/" + replace;
        }
        return new ListStoresRequest(replace, new Body(), V7.getHost(sharedPreferences), bodyInterceptor, okHttpClient, factory, tokenInvalidator);
    }

    public static ListStoresRequest ofTopStores(int i2, int i3, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        Body body = new Body();
        body.setOffset(i2);
        body.limit = Integer.valueOf(i3);
        return new ListStoresRequest(body, V7.getHost(sharedPreferences), bodyInterceptor, okHttpClient, factory, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<ListStores> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        if (TextUtils.isEmpty(this.url)) {
            return interfaces.listTopStores(STORT_BY_DOWNLOADS, 10, (Body) this.body, z);
        }
        return interfaces.listStores(this.url, (Body) this.body, z);
    }

    private ListStoresRequest(Body body, String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator) {
        super(body, str, okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }
}
