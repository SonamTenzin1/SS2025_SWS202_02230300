package com.facebook.o0;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: AnalyticsUserIDStore.kt */
/* loaded from: classes.dex */
public final class u {
    public static final u a = new u();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10503b = u.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    private static final ReentrantReadWriteLock f10504c = new ReentrantReadWriteLock();

    /* renamed from: d, reason: collision with root package name */
    private static String f10505d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f10506e;

    private u() {
    }

    public static final String a() {
        if (!f10506e) {
            Log.w(f10503b, "initStore should have been called before calling setUserID");
            a.b();
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f10504c;
        reentrantReadWriteLock.readLock().lock();
        try {
            String str = f10505d;
            reentrantReadWriteLock.readLock().unlock();
            return str;
        } catch (Throwable th) {
            f10504c.readLock().unlock();
            throw th;
        }
    }

    private final void b() {
        if (f10506e) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f10504c;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (f10506e) {
                reentrantReadWriteLock.writeLock().unlock();
                return;
            }
            com.facebook.a0 a0Var = com.facebook.a0.a;
            f10505d = PreferenceManager.getDefaultSharedPreferences(com.facebook.a0.c()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
            f10506e = true;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            f10504c.writeLock().unlock();
            throw th;
        }
    }

    public static final void c() {
        if (f10506e) {
            return;
        }
        g0.a.b().execute(new Runnable() { // from class: com.facebook.o0.b
            @Override // java.lang.Runnable
            public final void run() {
                u.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        a.b();
    }

    public static final void g(final String str) {
        com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
        com.facebook.o0.q0.g.b();
        if (!f10506e) {
            Log.w(f10503b, "initStore should have been called before calling setUserID");
            a.b();
        }
        g0.a.b().execute(new Runnable() { // from class: com.facebook.o0.a
            @Override // java.lang.Runnable
            public final void run() {
                u.h(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String str) {
        ReentrantReadWriteLock reentrantReadWriteLock = f10504c;
        reentrantReadWriteLock.writeLock().lock();
        try {
            f10505d = str;
            com.facebook.a0 a0Var = com.facebook.a0.a;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(com.facebook.a0.c()).edit();
            edit.putString("com.facebook.appevents.AnalyticsUserIDStore.userID", f10505d);
            edit.apply();
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            f10504c.writeLock().unlock();
            throw th;
        }
    }
}
