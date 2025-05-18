package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public interface LifecycleFragment {
    @KeepForSdk
    void a(String str, LifecycleCallback lifecycleCallback);

    @KeepForSdk
    <T extends LifecycleCallback> T b(String str, Class<T> cls);

    @KeepForSdk
    Activity c();

    @KeepForSdk
    void startActivityForResult(Intent intent, int i2);
}
