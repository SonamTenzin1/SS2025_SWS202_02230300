package cm.aptoide.pt.apkfy;

import android.content.SharedPreferences;
import cm.aptoide.pt.preferences.secure.SecurePreferences;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApkFyParser.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "cm.aptoide.pt.apkfy.ApkFyParser$run$1", f = "ApkFyParser.kt", l = {30}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ApkFyParser$run$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super u>, Object> {
    int label;
    final /* synthetic */ ApkFyParser this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkFyParser$run$1(ApkFyParser apkFyParser, Continuation<? super ApkFyParser$run$1> continuation) {
        super(2, continuation);
        this.this$0 = apkFyParser;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new ApkFyParser$run$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super u> continuation) {
        return ((ApkFyParser$run$1) create(coroutineScope, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        ApkfyManager apkfyManager;
        c2 = d.c();
        int i2 = this.label;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (i2 == 0) {
            o.b(obj);
            sharedPreferences = this.this$0.securePreferences;
            String string = sharedPreferences.getString(ApkFyParser.MMP_GUEST_UID, HttpUrl.FRAGMENT_ENCODE_SET);
            boolean z = false;
            boolean z2 = !(string == null || string.length() == 0);
            sharedPreferences2 = this.this$0.securePreferences;
            if (SecurePreferences.shouldRunApkFy(sharedPreferences2) && !z2) {
                z = true;
            }
            if (z) {
                apkfyManager = this.this$0.apkfyManager;
                this.label = 1;
                obj = apkfyManager.getApkfy(this);
                if (obj == c2) {
                    return c2;
                }
            }
            return u.a;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        o.b(obj);
        ApkfyModel apkfyModel = (ApkfyModel) obj;
        this.this$0.saveGuestUID(apkfyModel.getGuestUid());
        this.this$0.updateApkfy(apkfyModel);
        this.this$0.setApkfyUtmProperties(apkfyModel);
        return u.a;
    }
}
