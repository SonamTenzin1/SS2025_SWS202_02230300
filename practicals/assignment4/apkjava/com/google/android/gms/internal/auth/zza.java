package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public class zza implements IInterface {

    /* renamed from: f, reason: collision with root package name */
    private final IBinder f17025f;

    /* renamed from: g, reason: collision with root package name */
    private final String f17026g;

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(IBinder iBinder, String str) {
        this.f17025f = iBinder;
        this.f17026g = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f17025f;
    }
}
