package e.e.b.a.i;

import android.annotation.SuppressLint;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

/* compiled from: ExecutionModule.java */
/* loaded from: classes2.dex */
abstract class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Singleton
    @SuppressLint({"ThreadPoolCreation"})
    public static Executor a() {
        return new o(Executors.newSingleThreadExecutor());
    }
}
