package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class w3 implements Thread.UncaughtExceptionHandler {

    /* renamed from: f, reason: collision with root package name */
    private final String f18000f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzfu f18001g;

    public w3(zzfu zzfuVar, String str) {
        this.f18001g = zzfuVar;
        Preconditions.k(str);
        this.f18000f = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f18001g.h().H().b(this.f18000f, th);
    }
}
