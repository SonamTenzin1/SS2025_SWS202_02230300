package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t implements ResultCallback<Status> {
    private final /* synthetic */ StatusPendingResult a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f11791b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ GoogleApiClient f11792c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zaaw f11793d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(zaaw zaawVar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.f11793d = zaawVar;
        this.a = statusPendingResult;
        this.f11791b = z;
        this.f11792c = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* synthetic */ void a(Status status) {
        Context context;
        Status status2 = status;
        context = this.f11793d.f11820g;
        Storage.b(context).l();
        if (status2.e0() && this.f11793d.p()) {
            this.f11793d.s();
        }
        this.a.k(status2);
        if (this.f11791b) {
            this.f11792c.h();
        }
    }
}
