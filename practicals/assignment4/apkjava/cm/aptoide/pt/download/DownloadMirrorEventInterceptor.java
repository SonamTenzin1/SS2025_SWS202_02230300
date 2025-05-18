package cm.aptoide.pt.download;

import cm.aptoide.pt.downloadmanager.Constants;
import cm.aptoide.pt.install.InstallAnalytics;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes.dex */
public class DownloadMirrorEventInterceptor implements Interceptor {
    private final DownloadAnalytics downloadAnalytics;
    private final InstallAnalytics installAnalytics;

    public DownloadMirrorEventInterceptor(DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics) {
        this.downloadAnalytics = downloadAnalytics;
        this.installAnalytics = installAnalytics;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String header = request.header(Constants.VERSION_CODE);
        String header2 = request.header(Constants.PACKAGE);
        int parseInt = Integer.parseInt(request.header(Constants.FILE_TYPE));
        Response proceed = chain.proceed(request.newBuilder().removeHeader(Constants.VERSION_CODE).removeHeader(Constants.PACKAGE).removeHeader(Constants.FILE_TYPE).build());
        if (proceed != null && proceed.headers() != null) {
            this.installAnalytics.updateInstallEvents(Integer.valueOf(header).intValue(), header2, parseInt, request.url().getUrl());
        }
        return proceed;
    }
}
