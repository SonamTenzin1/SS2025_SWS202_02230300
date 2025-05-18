package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zace f11753f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(zace zaceVar) {
        this.f11753f = zaceVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zach zachVar;
        zachVar = this.f11753f.m;
        zachVar.c(new ConnectionResult(4));
    }
}
