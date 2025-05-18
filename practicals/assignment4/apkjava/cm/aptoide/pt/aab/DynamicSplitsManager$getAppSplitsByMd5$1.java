package cm.aptoide.pt.aab;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DynamicSplitsManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcm/aptoide/pt/aab/DynamicSplitsModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "cm.aptoide.pt.aab.DynamicSplitsManager$getAppSplitsByMd5$1", f = "DynamicSplitsManager.kt", l = {9}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DynamicSplitsManager$getAppSplitsByMd5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DynamicSplitsModel>, Object> {
    final /* synthetic */ String $apkMd5Sum;
    int label;
    final /* synthetic */ DynamicSplitsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicSplitsManager$getAppSplitsByMd5$1(DynamicSplitsManager dynamicSplitsManager, String str, Continuation<? super DynamicSplitsManager$getAppSplitsByMd5$1> continuation) {
        super(2, continuation);
        this.this$0 = dynamicSplitsManager;
        this.$apkMd5Sum = str;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new DynamicSplitsManager$getAppSplitsByMd5$1(this.this$0, this.$apkMd5Sum, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DynamicSplitsModel> continuation) {
        return ((DynamicSplitsManager$getAppSplitsByMd5$1) create(coroutineScope, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        DynamicSplitsService dynamicSplitsService;
        c2 = d.c();
        int i2 = this.label;
        if (i2 == 0) {
            o.b(obj);
            dynamicSplitsService = this.this$0.dynamicSplitsService;
            String str = this.$apkMd5Sum;
            this.label = 1;
            obj = dynamicSplitsService.getDynamicSplitsByMd5(str, this);
            if (obj == c2) {
                return c2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o.b(obj);
        }
        return obj;
    }
}
