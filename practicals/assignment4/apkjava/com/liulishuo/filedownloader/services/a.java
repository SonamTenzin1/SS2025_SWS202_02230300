package com.liulishuo.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import e.h.a.h0.b;
import e.h.a.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseFileServiceUIGuard.java */
/* loaded from: classes2.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements u, ServiceConnection {

    /* renamed from: g, reason: collision with root package name */
    private volatile INTERFACE f20508g;

    /* renamed from: h, reason: collision with root package name */
    private final Class<?> f20509h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f20510i = false;

    /* renamed from: j, reason: collision with root package name */
    private final HashMap<String, Object> f20511j = new HashMap<>();

    /* renamed from: k, reason: collision with root package name */
    private final List<Context> f20512k = new ArrayList();
    private final ArrayList<Runnable> l = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private final CALLBACK f20507f = c();

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Class<?> cls) {
        this.f20509h = cls;
    }

    private void f(boolean z) {
        if (!z && this.f20508g != null) {
            try {
                g(this.f20508g, this.f20507f);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "release connect resources %s", this.f20508g);
        }
        this.f20508g = null;
        e.h.a.f.e().b(new e.h.a.h0.b(z ? b.a.lost : b.a.disconnected, this.f20509h));
    }

    protected abstract INTERFACE a(IBinder iBinder);

    public void b(Context context, Runnable runnable) {
        if (!e.h.a.k0.f.J(context)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.f20509h);
            if (runnable != null && !this.l.contains(runnable)) {
                this.l.add(runnable);
            }
            if (!this.f20512k.contains(context)) {
                this.f20512k.add(context);
            }
            boolean P = e.h.a.k0.f.P(context);
            this.f20510i = P;
            intent.putExtra("is_foreground", P);
            context.bindService(intent, this, 1);
            if (this.f20510i) {
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "start foreground service", new Object[0]);
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                    return;
                }
                return;
            }
            context.startService(intent);
            return;
        }
        throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
    }

    protected abstract CALLBACK c();

    /* JADX INFO: Access modifiers changed from: protected */
    public INTERFACE d() {
        return this.f20508g;
    }

    protected abstract void e(INTERFACE r1, CALLBACK callback) throws RemoteException;

    protected abstract void g(INTERFACE r1, CALLBACK callback) throws RemoteException;

    @Override // e.h.a.u
    public boolean isConnected() {
        return d() != null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f20508g = a(iBinder);
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "onServiceConnected %s %s", componentName, this.f20508g);
        }
        try {
            e(this.f20508g, this.f20507f);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        List list = (List) this.l.clone();
        this.l.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        e.h.a.f.e().b(new e.h.a.h0.b(b.a.connected, this.f20509h));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "onServiceDisconnected %s %s", componentName, this.f20508g);
        }
        f(true);
    }

    @Override // e.h.a.u
    public void u0(Context context) {
        b(context, null);
    }

    @Override // e.h.a.u
    public boolean v0() {
        return this.f20510i;
    }
}
