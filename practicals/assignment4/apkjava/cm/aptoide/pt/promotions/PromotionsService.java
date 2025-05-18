package cm.aptoide.pt.promotions;

import android.content.SharedPreferences;
import cm.aptoide.pt.aab.Split;
import cm.aptoide.pt.aab.SplitsMapper;
import cm.aptoide.pt.dataprovider.exception.AptoideWsV7Exception;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.model.v7.Obb;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.ClaimPromotionRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPackagePromotionsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPackagePromotionsResponse;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionAppsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionAppsResponse;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionsResponse;
import cm.aptoide.pt.promotions.ClaimStatusWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.Single;

/* loaded from: classes.dex */
public class PromotionsService {
    private static final String ALREADY_CLAIMED = "PROMOTION-3";
    private static final String WALLET_NOT_VERIFIED = "PROMOTION-5";
    private static final String WRONG_ADDRESS = "PROMOTION-2";
    private final BodyInterceptor<BaseBody> bodyInterceptorPoolV7;
    private final Converter.Factory converterFactory;
    private final OkHttpClient okHttpClient;
    private final SharedPreferences sharedPreferences;
    private final SplitsMapper splitsMapper;
    private final TokenInvalidator tokenInvalidator;
    private String walletAddress;

    public PromotionsService(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, Converter.Factory factory, SharedPreferences sharedPreferences, SplitsMapper splitsMapper) {
        this.bodyInterceptorPoolV7 = bodyInterceptor;
        this.okHttpClient = okHttpClient;
        this.tokenInvalidator = tokenInvalidator;
        this.converterFactory = factory;
        this.sharedPreferences = sharedPreferences;
        this.splitsMapper = splitsMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$claimPromotion$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ClaimStatusWrapper a(Throwable th) {
        if (th instanceof AptoideWsV7Exception) {
            return mapClaim(((AptoideWsV7Exception) th).getBaseResponse());
        }
        throw new RuntimeException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: map, reason: merged with bridge method [inline-methods] */
    public List<PromotionMeta> b(GetPromotionsResponse getPromotionsResponse) {
        ArrayList arrayList = new ArrayList();
        if (getPromotionsResponse.getDataList() != null && getPromotionsResponse.getDataList().getList() != null) {
            for (GetPromotionsResponse.PromotionModel promotionModel : getPromotionsResponse.getDataList().getList()) {
                arrayList.add(new PromotionMeta(promotionModel.getTitle(), promotionModel.getPromotionId(), promotionModel.getType(), promotionModel.getBackground(), promotionModel.getDialogDescription(), promotionModel.getDescription()));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ClaimStatusWrapper mapClaim(BaseV7Response baseV7Response) {
        return new ClaimStatusWrapper(mapStatus(baseV7Response.getInfo().getStatus()), mapError(baseV7Response.getErrors()));
    }

    private List<ClaimStatusWrapper.Error> mapError(List<BaseV7Response.Error> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (BaseV7Response.Error error : list) {
                if (error.getCode().equals(WRONG_ADDRESS)) {
                    arrayList.add(ClaimStatusWrapper.Error.WRONG_ADDRESS);
                } else if (error.getCode().equals(ALREADY_CLAIMED)) {
                    arrayList.add(ClaimStatusWrapper.Error.PROMOTION_CLAIMED);
                } else if (error.getCode().equals(WALLET_NOT_VERIFIED)) {
                    arrayList.add(ClaimStatusWrapper.Error.WALLET_NOT_VERIFIED);
                } else {
                    arrayList.add(ClaimStatusWrapper.Error.GENERIC);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<PromotionApp> mapPromotionsResponse(GetPromotionAppsResponse getPromotionAppsResponse) {
        Iterator<GetPromotionAppsResponse.PromotionAppModel> it;
        List<Split> emptyList;
        ArrayList arrayList = new ArrayList();
        if (getPromotionAppsResponse != null && getPromotionAppsResponse.getDataList() != null && getPromotionAppsResponse.getDataList().getList() != null) {
            for (Iterator<GetPromotionAppsResponse.PromotionAppModel> it2 = getPromotionAppsResponse.getDataList().getList().iterator(); it2.hasNext(); it2 = it) {
                GetPromotionAppsResponse.PromotionAppModel next = it2.next();
                String name = next.getApp().getName();
                String packageName = next.getApp().getPackageName();
                long id = next.getApp().getId();
                String path = next.getApp().getFile().getPath();
                String pathAlt = next.getApp().getFile().getPathAlt();
                String icon = next.getApp().getIcon();
                String promotionDescription = next.getPromotionDescription();
                long size = next.getApp().getSize();
                float avg = next.getApp().getStats().getRating().getAvg();
                int downloads = next.getApp().getStats().getDownloads();
                String md5sum = next.getApp().getFile().getMd5sum();
                int vercode = next.getApp().getFile().getVercode();
                boolean isClaimed = next.isClaimed();
                String vername = next.getApp().getFile().getVername();
                Obb obb = next.getApp().getObb();
                float appc = next.getAppc();
                String sha1 = next.getApp().getFile().getSignature().getSha1();
                boolean z = next.getApp().hasAdvertising() || next.getApp().hasBilling();
                if (next.getApp().hasSplits()) {
                    it = it2;
                    emptyList = this.splitsMapper.mapSplits(next.getApp().getAab().getSplits());
                } else {
                    it = it2;
                    emptyList = Collections.emptyList();
                }
                arrayList.add(new PromotionApp(name, packageName, id, path, pathAlt, icon, promotionDescription, size, avg, downloads, md5sum, vercode, isClaimed, vername, obb, appc, sha1, z, emptyList, next.getApp().hasSplits() ? next.getApp().getAab().getRequiredSplits() : Collections.emptyList(), next.getApp().getFile().getMalware().getRank().toString(), next.getApp().getStore().getName(), next.getFiat().getAmount(), next.getFiat().getSymbol(), next.getApp().getBdsFlags()));
            }
        }
        return arrayList;
    }

    private ClaimStatusWrapper.Status mapStatus(BaseV7Response.Info.Status status) {
        if (status.equals(BaseV7Response.Info.Status.OK)) {
            return ClaimStatusWrapper.Status.OK;
        }
        return ClaimStatusWrapper.Status.FAIL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Promotion> mapToPromotion(GetPackagePromotionsResponse getPackagePromotionsResponse) {
        ArrayList arrayList = new ArrayList();
        if (getPackagePromotionsResponse != null && getPackagePromotionsResponse.getDataList() != null && getPackagePromotionsResponse.getDataList().getList() != null) {
            for (GetPackagePromotionsResponse.PromotionAppModel promotionAppModel : getPackagePromotionsResponse.getDataList().getList()) {
                arrayList.add(new Promotion(promotionAppModel.isClaimed(), promotionAppModel.getAppc(), promotionAppModel.getPackageName(), promotionAppModel.getPromotionId(), Collections.emptyList()));
            }
        }
        return arrayList;
    }

    public Single<ClaimStatusWrapper> claimPromotion(String str, String str2, String str3) {
        return ClaimPromotionRequest.of(str, str2, str3, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(true).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.w6
            @Override // rx.m.e
            public final Object call(Object obj) {
                ClaimStatusWrapper mapClaim;
                mapClaim = PromotionsService.this.mapClaim((BaseV7Response) obj);
                return mapClaim;
            }
        }).p0(new rx.m.e() { // from class: cm.aptoide.pt.promotions.t6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return PromotionsService.this.a((Throwable) obj);
            }
        }).Z0();
    }

    public Single<List<PromotionApp>> getPromotionApps(String str) {
        return GetPromotionAppsRequest.of(str, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.v6
            @Override // rx.m.e
            public final Object call(Object obj) {
                List mapPromotionsResponse;
                mapPromotionsResponse = PromotionsService.this.mapPromotionsResponse((GetPromotionAppsResponse) obj);
                return mapPromotionsResponse;
            }
        }).Z0();
    }

    public Single<List<PromotionMeta>> getPromotions(String str) {
        return GetPromotionsRequest.of(str, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe().X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.s6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return PromotionsService.this.b((GetPromotionsResponse) obj);
            }
        }).Z0();
    }

    public Single<List<Promotion>> getPromotionsForPackage(String str) {
        return GetPackagePromotionsRequest.of(str, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.u6
            @Override // rx.m.e
            public final Object call(Object obj) {
                List mapToPromotion;
                mapToPromotion = PromotionsService.this.mapToPromotion((GetPackagePromotionsResponse) obj);
                return mapToPromotion;
            }
        }).Z0();
    }

    public String getWalletAddress() {
        return this.walletAddress;
    }

    public void saveWalletAddress(String str) {
        this.walletAddress = str;
    }

    private List<Split> map(List<cm.aptoide.pt.dataprovider.model.v7.Split> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (cm.aptoide.pt.dataprovider.model.v7.Split split : list) {
            arrayList.add(new Split(split.getName(), split.getType(), split.getPath(), split.getFilesize(), split.getMd5sum()));
        }
        return arrayList;
    }
}
