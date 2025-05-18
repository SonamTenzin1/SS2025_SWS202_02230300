package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class NamedThreadFactory implements ThreadFactory {

    /* renamed from: f, reason: collision with root package name */
    private final String f12165f;

    /* renamed from: g, reason: collision with root package name */
    private final ThreadFactory f12166g = Executors.defaultThreadFactory();

    @KeepForSdk
    public NamedThreadFactory(String str) {
        Preconditions.l(str, "Name must not be null");
        this.f12165f = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f12166g.newThread(new a(runnable, 0));
        newThread.setName(this.f12165f);
        return newThread;
    }
}
