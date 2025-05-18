package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Api;

/* loaded from: classes2.dex */
public final class AccountTransfer {
    private static final Api.ClientKey<com.google.android.gms.internal.auth.zzu> a;

    /* renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.auth.zzu, zzn> f11416b;

    /* renamed from: c, reason: collision with root package name */
    private static final Api<zzn> f11417c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    private static final zzb f11418d;

    /* renamed from: e, reason: collision with root package name */
    private static final zzq f11419e;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.auth.zzt, com.google.android.gms.auth.api.accounttransfer.zzb] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.auth.zzt, com.google.android.gms.auth.api.accounttransfer.zzq] */
    static {
        Api.ClientKey<com.google.android.gms.internal.auth.zzu> clientKey = new Api.ClientKey<>();
        a = clientKey;
        a aVar = new a();
        f11416b = aVar;
        f11417c = new Api<>("AccountTransfer.ACCOUNT_TRANSFER_API", aVar, clientKey);
        f11418d = new com.google.android.gms.internal.auth.zzt();
        f11419e = new com.google.android.gms.internal.auth.zzt();
    }

    private AccountTransfer() {
    }
}
