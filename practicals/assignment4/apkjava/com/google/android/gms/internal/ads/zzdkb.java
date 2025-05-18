package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* loaded from: classes2.dex */
public final class zzdkb implements zzdbp {
    private static final byte[] a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private final ECPrivateKey f15937b;

    /* renamed from: c, reason: collision with root package name */
    private final zzdkd f15938c;

    /* renamed from: d, reason: collision with root package name */
    private final String f15939d;

    /* renamed from: e, reason: collision with root package name */
    private final byte[] f15940e;

    /* renamed from: f, reason: collision with root package name */
    private final zzdkv f15941f;

    /* renamed from: g, reason: collision with root package name */
    private final zzdka f15942g;

    public zzdkb(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzdkv zzdkvVar, zzdka zzdkaVar) throws GeneralSecurityException {
        this.f15937b = eCPrivateKey;
        this.f15938c = new zzdkd(eCPrivateKey);
        this.f15940e = bArr;
        this.f15939d = str;
        this.f15941f = zzdkvVar;
        this.f15942g = zzdkaVar;
    }
}
