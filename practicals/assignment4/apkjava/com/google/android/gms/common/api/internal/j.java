package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes2.dex */
final class j extends w {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f11763b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ i f11764c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, zabd zabdVar, ConnectionResult connectionResult) {
        super(zabdVar);
        this.f11764c = iVar;
        this.f11763b = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.w
    public final void a() {
        this.f11764c.f11762h.x(this.f11763b);
    }
}
