package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
final class m implements ServiceConnection, zzs {

    /* renamed from: f, reason: collision with root package name */
    private final Map f12035f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private int f12036g = 2;

    /* renamed from: h, reason: collision with root package name */
    private boolean f12037h;

    /* renamed from: i, reason: collision with root package name */
    private IBinder f12038i;

    /* renamed from: j, reason: collision with root package name */
    private final zzn f12039j;

    /* renamed from: k, reason: collision with root package name */
    private ComponentName f12040k;
    final /* synthetic */ o l;

    public m(o oVar, zzn zznVar) {
        this.l = oVar;
        this.f12039j = zznVar;
    }

    public final int a() {
        return this.f12036g;
    }

    public final ComponentName b() {
        return this.f12040k;
    }

    public final IBinder c() {
        return this.f12038i;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f12035f.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        ConnectionTracker connectionTracker;
        Context context;
        Context context2;
        ConnectionTracker connectionTracker2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j2;
        this.f12036g = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (PlatformVersion.o()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            o oVar = this.l;
            connectionTracker = oVar.f12046j;
            context = oVar.f12043g;
            zzn zznVar = this.f12039j;
            context2 = oVar.f12043g;
            boolean d2 = connectionTracker.d(context, str, zznVar.c(context2), this, this.f12039j.a(), executor);
            this.f12037h = d2;
            if (d2) {
                handler = this.l.f12044h;
                Message obtainMessage = handler.obtainMessage(1, this.f12039j);
                handler2 = this.l.f12044h;
                j2 = this.l.l;
                handler2.sendMessageDelayed(obtainMessage, j2);
            } else {
                this.f12036g = 2;
                try {
                    o oVar2 = this.l;
                    connectionTracker2 = oVar2.f12046j;
                    context3 = oVar2.f12043g;
                    connectionTracker2.c(context3, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f12035f.remove(serviceConnection);
    }

    public final void g(String str) {
        Handler handler;
        ConnectionTracker connectionTracker;
        Context context;
        handler = this.l.f12044h;
        handler.removeMessages(1, this.f12039j);
        o oVar = this.l;
        connectionTracker = oVar.f12046j;
        context = oVar.f12043g;
        connectionTracker.c(context, this);
        this.f12037h = false;
        this.f12036g = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f12035f.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f12035f.isEmpty();
    }

    public final boolean j() {
        return this.f12037h;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.l.f12042f;
        synchronized (hashMap) {
            handler = this.l.f12044h;
            handler.removeMessages(1, this.f12039j);
            this.f12038i = iBinder;
            this.f12040k = componentName;
            Iterator it = this.f12035f.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
            }
            this.f12036g = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.l.f12042f;
        synchronized (hashMap) {
            handler = this.l.f12044h;
            handler.removeMessages(1, this.f12039j);
            this.f12038i = null;
            this.f12040k = componentName;
            Iterator it = this.f12035f.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
            }
            this.f12036g = 2;
        }
    }
}
