package cm.aptoide.pt;

import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.bonus.BonusAppcService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCoinsManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcm/aptoide/pt/bonus/BonusAppcModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "cm.aptoide.pt.AppCoinsManager$getBonusAppc$1", f = "AppCoinsManager.kt", l = {13}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AppCoinsManager$getBonusAppc$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BonusAppcModel>, Object> {
    int label;
    final /* synthetic */ AppCoinsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCoinsManager$getBonusAppc$1(AppCoinsManager appCoinsManager, Continuation<? super AppCoinsManager$getBonusAppc$1> continuation) {
        super(2, continuation);
        this.this$0 = appCoinsManager;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new AppCoinsManager$getBonusAppc$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BonusAppcModel> continuation) {
        return ((AppCoinsManager$getBonusAppc$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        BonusAppcService bonusAppcService;
        c2 = kotlin.coroutines.intrinsics.d.c();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.o.b(obj);
            bonusAppcService = this.this$0.bonusAppcService;
            this.label = 1;
            obj = bonusAppcService.getBonusAppc(this);
            if (obj == c2) {
                return c2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.o.b(obj);
        }
        return obj;
    }
}
