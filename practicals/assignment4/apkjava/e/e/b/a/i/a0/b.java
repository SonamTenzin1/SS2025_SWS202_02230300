package e.e.b.a.i.a0;

/* compiled from: Retries.java */
/* loaded from: classes2.dex */
public final class b {
    public static <TInput, TResult, TException extends Throwable> TResult a(int i2, TInput tinput, a<TInput, TResult, TException> aVar, c<TInput, TResult> cVar) throws Throwable {
        TResult a;
        if (i2 < 1) {
            return aVar.a(tinput);
        }
        do {
            a = aVar.a(tinput);
            tinput = cVar.a(tinput, a);
            if (tinput == null) {
                break;
            }
            i2--;
        } while (i2 >= 1);
        return a;
    }
}
