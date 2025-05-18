package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;

@KeepForSdk
/* loaded from: classes2.dex */
public class StatusCallback extends IStatusCallback.Stub {

    /* renamed from: f, reason: collision with root package name */
    @KeepForSdk
    private final BaseImplementation.ResultHolder<Status> f11739f;

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    @KeepForSdk
    public void p2(Status status) {
        this.f11739f.a(status);
    }
}
