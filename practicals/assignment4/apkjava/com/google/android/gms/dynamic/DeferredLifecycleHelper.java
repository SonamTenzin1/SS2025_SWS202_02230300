package com.google.android.gms.dynamic;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.LifecycleDelegate;

@KeepForSdk
/* loaded from: classes2.dex */
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    private final OnDelegateCreatedListener<T> a = new a(this);

    @KeepForSdk
    public DeferredLifecycleHelper() {
    }
}
