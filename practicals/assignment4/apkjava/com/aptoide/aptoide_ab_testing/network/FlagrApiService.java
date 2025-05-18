package com.aptoide.aptoide_ab_testing.network;

import com.aptoide.aptoide_ab_testing.model.EvalContext;
import com.aptoide.aptoide_ab_testing.model.Flag;
import com.aptoide.aptoide_ab_testing.model.PostEvaluationResponseJson;
import com.aptoide.aptoide_ab_testing.service.FlagrService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* compiled from: FlagrApiService.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/aptoide/aptoide_ab_testing/network/FlagrApiService;", "Lcom/aptoide/aptoide_ab_testing/service/FlagrService;", "flagrBaseHost", HttpUrl.FRAGMENT_ENCODE_SET, "okHttpClient", "Lokhttp3/OkHttpClient;", "(Ljava/lang/String;Lokhttp3/OkHttpClient;)V", "flagr", "Lcom/aptoide/aptoide_ab_testing/network/FlagrApiService$Flagr;", "getFlag", "Lcom/aptoide/aptoide_ab_testing/model/Flag;", "flagID", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postEvaluation", "Lcom/aptoide/aptoide_ab_testing/model/PostEvaluationResponseJson;", "body", "Lcom/aptoide/aptoide_ab_testing/model/EvalContext;", "(Lcom/aptoide/aptoide_ab_testing/model/EvalContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Flagr", "aptoide-ab-testing"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlagrApiService implements FlagrService {
    private final Flagr flagr;
    private final String flagrBaseHost;

    /* compiled from: FlagrApiService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/aptoide/aptoide_ab_testing/network/FlagrApiService$Flagr;", HttpUrl.FRAGMENT_ENCODE_SET, "getFlag", "Lretrofit2/Response;", "Lcom/aptoide/aptoide_ab_testing/model/Flag;", "flagID", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postEvaluation", "Lcom/aptoide/aptoide_ab_testing/model/PostEvaluationResponseJson;", "body", "Lcom/aptoide/aptoide_ab_testing/model/EvalContext;", "(Lcom/aptoide/aptoide_ab_testing/model/EvalContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aptoide-ab-testing"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Flagr {
        @GET("/api/v1/flags/{flagID}")
        Object getFlag(@Path("flagID") String str, Continuation<? super Response<Flag>> continuation);

        @POST("/api/v1/evaluation")
        Object postEvaluation(@Body EvalContext evalContext, Continuation<? super Response<PostEvaluationResponseJson>> continuation);
    }

    public FlagrApiService(String str, OkHttpClient okHttpClient) {
        m.f(str, "flagrBaseHost");
        m.f(okHttpClient, "okHttpClient");
        this.flagrBaseHost = str;
        Object create = new Retrofit.Builder().baseUrl(str).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build().create(Flagr.class);
        m.e(create, "Builder()\n            .b…create(Flagr::class.java)");
        this.flagr = (Flagr) create;
    }

    @Override // com.aptoide.aptoide_ab_testing.service.FlagrService
    public Object getFlag(String str, Continuation<? super Flag> continuation) {
        return h.e(Dispatchers.b(), new FlagrApiService$getFlag$2(this, str, null), continuation);
    }

    @Override // com.aptoide.aptoide_ab_testing.service.FlagrService
    public Object postEvaluation(EvalContext evalContext, Continuation<? super PostEvaluationResponseJson> continuation) {
        return h.e(Dispatchers.b(), new FlagrApiService$postEvaluation$2(this, evalContext, null), continuation);
    }
}
