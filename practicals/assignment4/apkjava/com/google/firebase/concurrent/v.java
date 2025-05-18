package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomThreadFactory.java */
/* loaded from: classes2.dex */
public class v implements ThreadFactory {

    /* renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f18965f = Executors.defaultThreadFactory();

    /* renamed from: g, reason: collision with root package name */
    private final AtomicLong f18966g = new AtomicLong();

    /* renamed from: h, reason: collision with root package name */
    private final String f18967h;

    /* renamed from: i, reason: collision with root package name */
    private final int f18968i;

    /* renamed from: j, reason: collision with root package name */
    private final StrictMode.ThreadPolicy f18969j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        this.f18967h = str;
        this.f18968i = i2;
        this.f18969j = threadPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Runnable runnable) {
        Process.setThreadPriority(this.f18968i);
        StrictMode.ThreadPolicy threadPolicy = this.f18969j;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread newThread = f18965f.newThread(new Runnable() { // from class: com.google.firebase.concurrent.a
            @Override // java.lang.Runnable
            public final void run() {
                v.this.b(runnable);
            }
        });
        newThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f18967h, Long.valueOf(this.f18966g.getAndIncrement())));
        return newThread;
    }
}
