package com.google.android.gms.dynamite;

import android.os.Looper;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzb {
    private static volatile ClassLoader a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Thread f12205b;

    public static synchronized ClassLoader a() {
        ClassLoader classLoader;
        synchronized (zzb.class) {
            if (a == null) {
                a = b();
            }
            classLoader = a;
        }
        return classLoader;
    }

    private static synchronized ClassLoader b() {
        synchronized (zzb.class) {
            ClassLoader classLoader = null;
            if (f12205b == null) {
                f12205b = c();
                if (f12205b == null) {
                    return null;
                }
            }
            synchronized (f12205b) {
                try {
                    classLoader = f12205b.getContextClassLoader();
                } catch (SecurityException e2) {
                    Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e2.getMessage());
                }
            }
            return classLoader;
        }
    }

    private static synchronized Thread c() {
        SecurityException e2;
        Thread thread;
        Thread thread2;
        ThreadGroup threadGroup;
        synchronized (zzb.class) {
            ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
            if (threadGroup2 == null) {
                return null;
            }
            synchronized (Void.class) {
                try {
                    int activeGroupCount = threadGroup2.activeGroupCount();
                    ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                    threadGroup2.enumerate(threadGroupArr);
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= activeGroupCount) {
                            threadGroup = null;
                            break;
                        }
                        threadGroup = threadGroupArr[i3];
                        if ("dynamiteLoader".equals(threadGroup.getName())) {
                            break;
                        }
                        i3++;
                    }
                    if (threadGroup == null) {
                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                    }
                    int activeCount = threadGroup.activeCount();
                    Thread[] threadArr = new Thread[activeCount];
                    threadGroup.enumerate(threadArr);
                    while (true) {
                        if (i2 >= activeCount) {
                            thread2 = null;
                            break;
                        }
                        thread2 = threadArr[i2];
                        if ("GmsDynamite".equals(thread2.getName())) {
                            break;
                        }
                        i2++;
                    }
                } catch (SecurityException e3) {
                    e2 = e3;
                    thread = null;
                }
                if (thread2 == null) {
                    try {
                        thread = new a(threadGroup, "GmsDynamite");
                        try {
                            thread.setContextClassLoader(null);
                            thread.start();
                        } catch (SecurityException e4) {
                            e2 = e4;
                            Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e2.getMessage());
                            thread2 = thread;
                            return thread2;
                        }
                    } catch (SecurityException e5) {
                        e2 = e5;
                        thread = thread2;
                    }
                    thread2 = thread;
                }
            }
            return thread2;
        }
    }
}
