package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
/* loaded from: classes2.dex */
public class DataHolderResult implements Releasable, Result {

    /* renamed from: f, reason: collision with root package name */
    @KeepForSdk
    protected final Status f11709f;

    /* renamed from: g, reason: collision with root package name */
    @KeepForSdk
    protected final DataHolder f11710g;

    @Override // com.google.android.gms.common.api.Releasable
    @KeepForSdk
    public void c() {
        DataHolder dataHolder = this.f11710g;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public Status getStatus() {
        return this.f11709f;
    }
}
