package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes2.dex */
public class WakeLock {
    private static ScheduledExecutorService a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile zza f18299b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final Object f18300c;

    /* renamed from: d, reason: collision with root package name */
    private final PowerManager.WakeLock f18301d;

    /* renamed from: e, reason: collision with root package name */
    private WorkSource f18302e;

    /* renamed from: f, reason: collision with root package name */
    private final int f18303f;

    /* renamed from: g, reason: collision with root package name */
    private final String f18304g;

    /* renamed from: h, reason: collision with root package name */
    private final String f18305h;

    /* renamed from: i, reason: collision with root package name */
    private final String f18306i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f18307j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f18308k;
    private final Map<String, Integer[]> l;
    private final Set<Future<?>> m;
    private int n;
    private AtomicInteger o;

    /* loaded from: classes2.dex */
    public interface zza {
    }

    @KeepForSdk
    public WakeLock(Context context, int i2, String str) {
        this(context, i2, str, null, context == null ? null : context.getPackageName());
    }

    private final String d(String str) {
        return (!this.f18308k || TextUtils.isEmpty(str)) ? this.f18305h : str;
    }

    private final List<String> e() {
        return WorkSourceUtil.d(this.f18302e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int i2) {
        if (this.f18301d.isHeld()) {
            try {
                this.f18301d.release();
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.f18304g).concat(" was already released!"), e2);
                } else {
                    throw e2;
                }
            }
            this.f18301d.isHeld();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        if (r2 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
    
        com.google.android.gms.common.stats.WakeLockTracker.a().c(r13.f18307j, com.google.android.gms.common.stats.StatsUtils.a(r13.f18301d, r6), 7, r13.f18304g, r6, null, r13.f18303f, e(), r14);
        r13.n++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r13.n == 0) goto L22;
     */
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(long j2) {
        this.o.incrementAndGet();
        String d2 = d(null);
        synchronized (this.f18300c) {
            boolean z = false;
            if ((!this.l.isEmpty() || this.n > 0) && !this.f18301d.isHeld()) {
                this.l.clear();
                this.n = 0;
            }
            if (this.f18308k) {
                Integer[] numArr = this.l.get(d2);
                if (numArr == null) {
                    this.l.put(d2, new Integer[]{1});
                    z = true;
                } else {
                    numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                }
            }
            if (!this.f18308k) {
            }
        }
        this.f18301d.acquire();
        if (j2 > 0) {
            a.schedule(new b(this), j2, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:
    
        if (r1 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
    
        com.google.android.gms.common.stats.WakeLockTracker.a().b(r12.f18307j, com.google.android.gms.common.stats.StatsUtils.a(r12.f18301d, r6), 8, r12.f18304g, r6, null, r12.f18303f, e());
        r12.n--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        if (r12.n == 1) goto L21;
     */
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        boolean z;
        if (this.o.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f18304g).concat(" release without a matched acquire!"));
        }
        String d2 = d(null);
        synchronized (this.f18300c) {
            if (this.f18308k) {
                Integer[] numArr = this.l.get(d2);
                if (numArr != null) {
                    if (numArr[0].intValue() == 1) {
                        this.l.remove(d2);
                        z = true;
                    } else {
                        numArr[0] = Integer.valueOf(numArr[0].intValue() - 1);
                    }
                }
                z = false;
            }
            if (!this.f18308k) {
            }
        }
        f(0);
    }

    @KeepForSdk
    public void c(boolean z) {
        this.f18301d.setReferenceCounted(z);
        this.f18308k = z;
    }

    private WakeLock(Context context, int i2, String str, String str2, String str3) {
        this(context, i2, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private WakeLock(Context context, int i2, String str, String str2, String str3, String str4) {
        this.f18300c = this;
        this.f18308k = true;
        this.l = new HashMap();
        this.m = Collections.synchronizedSet(new HashSet());
        this.o = new AtomicInteger(0);
        Preconditions.l(context, "WakeLock: context must not be null");
        Preconditions.h(str, "WakeLock: wakeLockName must not be empty");
        this.f18303f = i2;
        this.f18305h = null;
        this.f18306i = null;
        Context applicationContext = context.getApplicationContext();
        this.f18307j = applicationContext;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.f18304g = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.f18304g = str;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i2, str);
        this.f18301d = newWakeLock;
        if (WorkSourceUtil.e(context)) {
            WorkSource b2 = WorkSourceUtil.b(context, Strings.a(str3) ? context.getPackageName() : str3);
            this.f18302e = b2;
            if (b2 != null && WorkSourceUtil.e(applicationContext)) {
                WorkSource workSource = this.f18302e;
                if (workSource != null) {
                    workSource.add(b2);
                } else {
                    this.f18302e = b2;
                }
                try {
                    newWakeLock.setWorkSource(this.f18302e);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    Log.wtf("WakeLock", e2.toString());
                }
            }
        }
        if (a == null) {
            a = PooledExecutorsProvider.a().a();
        }
    }
}
