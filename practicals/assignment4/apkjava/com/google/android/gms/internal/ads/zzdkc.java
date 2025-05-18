package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* loaded from: classes2.dex */
public final class zzdkc implements zzdbq {
    private static final byte[] a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private final zzdke f15943b;

    /* renamed from: c, reason: collision with root package name */
    private final String f15944c;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f15945d;

    /* renamed from: e, reason: collision with root package name */
    private final zzdkv f15946e;

    /* renamed from: f, reason: collision with root package name */
    private final zzdka f15947f;

    public zzdkc(ECPublicKey eCPublicKey, byte[] bArr, String str, zzdkv zzdkvVar, zzdka zzdkaVar) throws GeneralSecurityException {
        zzdkr.g(eCPublicKey);
        this.f15943b = new zzdke(eCPublicKey);
        this.f15945d = bArr;
        this.f15944c = str;
        this.f15946e = zzdkvVar;
        this.f15947f = zzdkaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbq
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzdkf a2 = this.f15943b.a(this.f15944c, this.f15945d, bArr2, this.f15947f.b(), this.f15946e);
        byte[] a3 = this.f15947f.a(a2.b()).a(bArr, a);
        byte[] a4 = a2.a();
        return ByteBuffer.allocate(a4.length + a3.length).put(a4).put(a3).array();
    }
}
