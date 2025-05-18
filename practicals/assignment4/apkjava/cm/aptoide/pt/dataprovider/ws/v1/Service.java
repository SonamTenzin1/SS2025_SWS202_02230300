package cm.aptoide.pt.dataprovider.ws.v1;

import cm.aptoide.pt.dataprovider.model.v1.GetPullNotificationsResponse;
import java.util.List;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.e;

/* loaded from: classes.dex */
public interface Service {
    @GET("notifications/{id}/campaigns")
    e<List<GetPullNotificationsResponse>> getPullCampaignNotifications(@Path("id") String str, @QueryMap Map<String, String> map, @Header("X-Bypass-Cache") boolean z);
}
