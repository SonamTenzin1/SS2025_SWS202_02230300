package com.google.android.gms.tasks;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
@KeepForSdk
/* loaded from: classes2.dex */
public class NativeOnCompleteListener implements OnCompleteListener<Object> {
    private final long a;

    @Override // com.google.android.gms.tasks.OnCompleteListener
    @KeepForSdk
    public void a(Task<Object> task) {
        Object obj;
        String str;
        Exception i2;
        if (task.n()) {
            obj = task.j();
            str = null;
        } else if (task.l() || (i2 = task.i()) == null) {
            obj = null;
            str = null;
        } else {
            str = i2.getMessage();
            obj = null;
        }
        nativeOnComplete(this.a, obj, task.n(), task.l(), str);
    }

    @KeepForSdk
    public native void nativeOnComplete(long j2, Object obj, boolean z, boolean z2, String str);
}
