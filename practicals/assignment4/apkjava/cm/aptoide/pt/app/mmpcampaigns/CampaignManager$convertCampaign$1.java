package cm.aptoide.pt.app.mmpcampaigns;

import android.content.SharedPreferences;
import cm.aptoide.pt.apkfy.ApkFyParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CampaignManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "cm.aptoide.pt.app.mmpcampaigns.CampaignManager$convertCampaign$1", f = "CampaignManager.kt", l = {14}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CampaignManager$convertCampaign$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super u>, Object> {
    final /* synthetic */ Campaign $campaign;
    final /* synthetic */ String $medium;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CampaignManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CampaignManager$convertCampaign$1(Campaign campaign, CampaignManager campaignManager, String str, Continuation<? super CampaignManager$convertCampaign$1> continuation) {
        super(2, continuation);
        this.$campaign = campaign;
        this.this$0 = campaignManager;
        this.$medium = str;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CampaignManager$convertCampaign$1(this.$campaign, this.this$0, this.$medium, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super u> continuation) {
        return ((CampaignManager$convertCampaign$1) create(coroutineScope, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        String str;
        Iterator it;
        CampaignManager campaignManager;
        CampaignRepository campaignRepository;
        SharedPreferences sharedPreferences;
        c2 = d.c();
        int i2 = this.label;
        if (i2 == 0) {
            o.b(obj);
            List<CampaignUrl> download = this.$campaign.getDownload();
            if (download != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : download) {
                    if (m.a(((CampaignUrl) obj2).getName(), "aptoide-mmp")) {
                        arrayList.add(obj2);
                    }
                }
                CampaignManager campaignManager2 = this.this$0;
                str = this.$medium;
                it = arrayList.iterator();
                campaignManager = campaignManager2;
            }
            return u.a;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        it = (Iterator) this.L$2;
        str = (String) this.L$1;
        campaignManager = (CampaignManager) this.L$0;
        o.b(obj);
        while (it.hasNext()) {
            CampaignUrl campaignUrl = (CampaignUrl) it.next();
            campaignRepository = campaignManager.campaignRepository;
            String url = campaignUrl.getUrl();
            sharedPreferences = campaignManager.securePreferences;
            String injectCampaignAttributes = CampaignManagerKt.injectCampaignAttributes(url, str, sharedPreferences.getString(ApkFyParser.MMP_GUEST_UID, HttpUrl.FRAGMENT_ENCODE_SET));
            this.L$0 = campaignManager;
            this.L$1 = str;
            this.L$2 = it;
            this.label = 1;
            if (campaignRepository.knock(injectCampaignAttributes, this) == c2) {
                return c2;
            }
        }
        return u.a;
    }
}
