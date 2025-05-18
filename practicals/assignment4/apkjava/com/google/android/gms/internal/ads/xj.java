package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final /* synthetic */ class xj implements Callable {

    /* renamed from: f, reason: collision with root package name */
    private final zzcja f13581f;

    private xj(zzcja zzcjaVar) {
        this.f13581f = zzcjaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Callable a(zzcja zzcjaVar) {
        return new xj(zzcjaVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f13581f.getWritableDatabase();
    }
}
