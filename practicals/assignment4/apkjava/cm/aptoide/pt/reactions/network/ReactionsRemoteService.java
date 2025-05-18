package cm.aptoide.pt.reactions.network;

import cm.aptoide.pt.dataprovider.exception.NoNetworkConnectionException;
import cm.aptoide.pt.reactions.data.TopReaction;
import cm.aptoide.pt.reactions.network.ReactionsResponse;
import cm.aptoide.pt.reactions.network.TopReactionsResponse;
import java.net.ConnectException;
import java.util.ArrayList;
import okhttp3.HttpUrl;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Single;
import rx.e;
import rx.h;

/* loaded from: classes.dex */
public class ReactionsRemoteService implements ReactionsService {
    private h ioScheduler;
    private ServiceV8 service;

    /* loaded from: classes.dex */
    public interface ServiceV8 {
        @DELETE("echo/8.20181122/reactions/{uid}/")
        e<Response<Void>> deleteReaction(@Path("uid") String str);

        @GET("echo/8.20181122/groups/{group_id}/objects/{id}/reactions/summary")
        e<TopReactionsResponse> getTopReactionsResponse(@Path("group_id") String str, @Path("id") String str2);

        @POST("echo/8.20181122/reactions/")
        e<Response<Void>> setFirstUserReaction(@retrofit2.http.Body Body body);

        @PATCH("echo/8.20181122/reactions/{uid}/")
        e<Response<Void>> setSecondUserReaction(@Path("uid") String str, @retrofit2.http.Body Body body);
    }

    public ReactionsRemoteService(ServiceV8 serviceV8, h hVar) {
        this.service = serviceV8;
        this.ioScheduler = hVar;
    }

    public ReactionsResponse mapErrorResponse(Throwable th) {
        if (!(th instanceof NoNetworkConnectionException) && !(th instanceof ConnectException)) {
            return new ReactionsResponse(ReactionsResponse.ReactionResponseMessage.GENERAL_ERROR);
        }
        return new ReactionsResponse(ReactionsResponse.ReactionResponseMessage.NETWORK_ERROR);
    }

    public ReactionsResponse mapResponse(Response response) {
        return new ReactionsResponse(ReactionsResponse.ReactionResponseMapper.mapReactionResponse(response));
    }

    public LoadReactionModel mapToTopReactionsList(TopReactionsResponse topReactionsResponse) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (TopReactionsResponse.ReactionTypeResponse reactionTypeResponse : topReactionsResponse.getTop()) {
            arrayList.add(new TopReaction(reactionTypeResponse.getType(), reactionTypeResponse.getTotal()));
        }
        TopReactionsResponse.My my = topReactionsResponse.getMy();
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (my != null) {
            str2 = topReactionsResponse.getMy().getType();
            str = topReactionsResponse.getMy().getUid();
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return new LoadReactionModel(topReactionsResponse.getTotal(), str2, str, arrayList);
    }

    @Override // cm.aptoide.pt.reactions.network.ReactionsService
    public Single<ReactionsResponse> deleteReaction(String str) {
        return this.service.deleteReaction(str).X(new a(this)).Z0().v(this.ioScheduler).r(new b(this));
    }

    @Override // cm.aptoide.pt.reactions.network.ReactionsService
    public Single<LoadReactionModel> loadReactionModel(String str, String str2) {
        return this.service.getTopReactionsResponse(str2, str).X(new rx.m.e() { // from class: cm.aptoide.pt.reactions.network.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                LoadReactionModel mapToTopReactionsList;
                mapToTopReactionsList = ReactionsRemoteService.this.mapToTopReactionsList((TopReactionsResponse) obj);
                return mapToTopReactionsList;
            }
        }).Z0().v(this.ioScheduler);
    }

    @Override // cm.aptoide.pt.reactions.network.ReactionsService
    public Single<ReactionsResponse> setReaction(String str, String str2, String str3) {
        return this.service.setFirstUserReaction(new Body(str, str2, str3)).X(new a(this)).Z0().v(this.ioScheduler).r(new b(this));
    }

    @Override // cm.aptoide.pt.reactions.network.ReactionsService
    public Single<ReactionsResponse> setSecondReaction(String str, String str2) {
        return this.service.setSecondUserReaction(str, new Body(str2)).X(new a(this)).Z0().v(this.ioScheduler).r(new b(this));
    }

    /* loaded from: classes.dex */
    public static class Body {
        private String groupUid;
        private String objectUid;
        private String type;

        public Body(String str, String str2, String str3) {
            this.objectUid = str;
            this.groupUid = str2;
            this.type = str3;
        }

        public String getGroupUid() {
            return this.groupUid;
        }

        public String getObjectUid() {
            return this.objectUid;
        }

        public String getType() {
            return this.type;
        }

        public void setGroupUid(String str) {
            this.groupUid = str;
        }

        public void setObjectUid(String str) {
            this.objectUid = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public Body(String str) {
            this.type = str;
        }
    }
}
