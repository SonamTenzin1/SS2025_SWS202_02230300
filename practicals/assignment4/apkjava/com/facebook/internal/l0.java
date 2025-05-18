package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* compiled from: PlatformServiceClient.kt */
/* loaded from: classes2.dex */
public abstract class l0 implements ServiceConnection {

    /* renamed from: f, reason: collision with root package name */
    private final Context f9797f;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f9798g;

    /* renamed from: h, reason: collision with root package name */
    private b f9799h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f9800i;

    /* renamed from: j, reason: collision with root package name */
    private Messenger f9801j;

    /* renamed from: k, reason: collision with root package name */
    private final int f9802k;
    private final int l;
    private final String m;
    private final int n;
    private final String o;

    /* compiled from: PlatformServiceClient.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            kotlin.jvm.internal.m.f(message, "message");
            l0.this.d(message);
        }
    }

    /* compiled from: PlatformServiceClient.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void a(Bundle bundle);
    }

    public l0(Context context, int i2, int i3, int i4, String str, String str2) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(str, "applicationId");
        Context applicationContext = context.getApplicationContext();
        this.f9797f = applicationContext != null ? applicationContext : context;
        this.f9802k = i2;
        this.l = i3;
        this.m = str;
        this.n = i4;
        this.o = str2;
        this.f9798g = new a();
    }

    private final void a(Bundle bundle) {
        if (this.f9800i) {
            this.f9800i = false;
            b bVar = this.f9799h;
            if (bVar == null) {
                return;
            }
            bVar.a(bundle);
        }
    }

    private final void f() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.m);
        String str = this.o;
        if (str != null) {
            bundle.putString("com.facebook.platform.extra.NONCE", str);
        }
        e(bundle);
        Message obtain = Message.obtain((Handler) null, this.f9802k);
        obtain.arg1 = this.n;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.f9798g);
        try {
            Messenger messenger = this.f9801j;
            if (messenger == null) {
                return;
            }
            messenger.send(obtain);
        } catch (RemoteException unused) {
            a(null);
        }
    }

    public final void b() {
        this.f9800i = false;
    }

    protected final Context c() {
        return this.f9797f;
    }

    protected final void d(Message message) {
        kotlin.jvm.internal.m.f(message, "message");
        if (message.what == this.l) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                a(null);
            } else {
                a(data);
            }
            try {
                this.f9797f.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    protected abstract void e(Bundle bundle);

    public final void g(b bVar) {
        this.f9799h = bVar;
    }

    public final boolean h() {
        synchronized (this) {
            boolean z = false;
            if (this.f9800i) {
                return false;
            }
            k0 k0Var = k0.a;
            if (k0.r(this.n) == -1) {
                return false;
            }
            Intent k2 = k0.k(c());
            if (k2 != null) {
                this.f9800i = true;
                c().bindService(k2, this, 1);
                z = true;
            }
            return z;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        kotlin.jvm.internal.m.f(componentName, "name");
        kotlin.jvm.internal.m.f(iBinder, "service");
        this.f9801j = new Messenger(iBinder);
        f();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        kotlin.jvm.internal.m.f(componentName, "name");
        this.f9801j = null;
        try {
            this.f9797f.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        a(null);
    }
}
