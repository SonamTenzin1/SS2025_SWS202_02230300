package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    private final Activity a;

    /* renamed from: b, reason: collision with root package name */
    private final int f11683b;

    @Override // com.google.android.gms.common.api.ResultCallbacks
    @KeepForSdk
    public final void b(Status status) {
        if (status.Y()) {
            try {
                status.i0(this.a, this.f11683b);
                return;
            } catch (IntentSender.SendIntentException e2) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e2);
                d(new Status(8));
                return;
            }
        }
        d(status);
    }

    public abstract void d(Status status);
}
