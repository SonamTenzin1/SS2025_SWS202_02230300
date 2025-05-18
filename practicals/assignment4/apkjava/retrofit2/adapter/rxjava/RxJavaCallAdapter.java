package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
import rx.e;
import rx.h;

/* loaded from: classes3.dex */
final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final h scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxJavaCallAdapter(Type type, h hVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.responseType = type;
        this.scheduler = hVar;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isSingle = z4;
        this.isCompletable = z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    @Override // retrofit2.CallAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object adapt(Call<R> call) {
        e.a bodyOnSubscribe;
        h hVar;
        e.a callEnqueueOnSubscribe = this.isAsync ? new CallEnqueueOnSubscribe(call) : new CallExecuteOnSubscribe(call);
        if (this.isResult) {
            bodyOnSubscribe = new ResultOnSubscribe(callEnqueueOnSubscribe);
        } else {
            if (this.isBody) {
                bodyOnSubscribe = new BodyOnSubscribe(callEnqueueOnSubscribe);
            }
            e l = e.l(callEnqueueOnSubscribe);
            hVar = this.scheduler;
            if (hVar != null) {
                l = l.I0(hVar);
            }
            if (this.isSingle) {
                return this.isCompletable ? l.X0() : l;
            }
            return l.Z0();
        }
        callEnqueueOnSubscribe = bodyOnSubscribe;
        e l2 = e.l(callEnqueueOnSubscribe);
        hVar = this.scheduler;
        if (hVar != null) {
        }
        if (this.isSingle) {
        }
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}
