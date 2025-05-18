package androidx.core.app;

import android.app.RemoteInput;

/* compiled from: RemoteInput.java */
/* loaded from: classes.dex */
public final class n {
    static RemoteInput a(n nVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput[] b(n[] nVarArr) {
        if (nVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[nVarArr.length];
        for (int i2 = 0; i2 < nVarArr.length; i2++) {
            remoteInputArr[i2] = a(nVarArr[i2]);
        }
        return remoteInputArr;
    }
}
