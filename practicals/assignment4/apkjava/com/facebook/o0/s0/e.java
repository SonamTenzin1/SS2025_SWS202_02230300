package com.facebook.o0.s0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.facebook.a0;
import com.facebook.internal.p0;
import com.facebook.internal.y;
import com.facebook.o0.q0.g;
import com.facebook.o0.v;
import com.facebook.q0.a.a;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.collections.u;
import kotlin.jvm.internal.m;

/* compiled from: RemoteServiceWrapper.kt */
/* loaded from: classes2.dex */
public final class e {
    public static final e a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10480b = e.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f10481c;

    /* compiled from: RemoteServiceWrapper.kt */
    /* loaded from: classes2.dex */
    public enum a {
        MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
        CUSTOM_APP_EVENTS("CUSTOM_APP_EVENTS");


        /* renamed from: i, reason: collision with root package name */
        private final String f10485i;

        a(String str) {
            this.f10485i = str;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            return (a[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f10485i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteServiceWrapper.kt */
    /* loaded from: classes2.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: f, reason: collision with root package name */
        private final CountDownLatch f10486f = new CountDownLatch(1);

        /* renamed from: g, reason: collision with root package name */
        private IBinder f10487g;

        public final IBinder a() throws InterruptedException {
            this.f10486f.await(5L, TimeUnit.SECONDS);
            return this.f10487g;
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            m.f(componentName, "name");
            this.f10486f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            m.f(componentName, "name");
            m.f(iBinder, "serviceBinder");
            this.f10487g = iBinder;
            this.f10486f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            m.f(componentName, "name");
        }
    }

    /* compiled from: RemoteServiceWrapper.kt */
    /* loaded from: classes2.dex */
    public enum c {
        OPERATION_SUCCESS,
        SERVICE_NOT_AVAILABLE,
        SERVICE_ERROR;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static c[] valuesCustom() {
            c[] valuesCustom = values();
            return (c[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    private e() {
    }

    private final Intent a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        Intent intent = new Intent("ReceiverService");
        intent.setPackage("com.facebook.katana");
        if (packageManager.resolveService(intent, 0) != null) {
            y yVar = y.a;
            if (y.a(context, "com.facebook.katana")) {
                return intent;
            }
        }
        Intent intent2 = new Intent("ReceiverService");
        intent2.setPackage("com.facebook.wakizashi");
        if (packageManager.resolveService(intent2, 0) == null) {
            return null;
        }
        y yVar2 = y.a;
        if (y.a(context, "com.facebook.wakizashi")) {
            return intent2;
        }
        return null;
    }

    public static final boolean b() {
        if (f10481c == null) {
            a0 a0Var = a0.a;
            f10481c = Boolean.valueOf(a.a(a0.c()) != null);
        }
        Boolean bool = f10481c;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static final c c(String str, List<v> list) {
        m.f(str, "applicationId");
        m.f(list, "appEvents");
        return a.d(a.CUSTOM_APP_EVENTS, str, list);
    }

    private final c d(a aVar, String str, List<v> list) {
        c cVar;
        String str2;
        c cVar2 = c.SERVICE_NOT_AVAILABLE;
        g gVar = g.a;
        g.b();
        a0 a0Var = a0.a;
        Context c2 = a0.c();
        Intent a2 = a(c2);
        if (a2 == null) {
            return cVar2;
        }
        b bVar = new b();
        try {
            if (c2.bindService(a2, bVar, 1)) {
                try {
                    try {
                        IBinder a3 = bVar.a();
                        if (a3 != null) {
                            com.facebook.q0.a.a H = a.AbstractBinderC0154a.H(a3);
                            d dVar = d.a;
                            Bundle a4 = d.a(aVar, str, list);
                            if (a4 != null) {
                                H.u1(a4);
                                p0 p0Var = p0.a;
                                p0.j0(f10480b, m.n("Successfully sent events to the remote service: ", a4));
                            }
                            cVar2 = c.OPERATION_SUCCESS;
                        }
                        return cVar2;
                    } catch (RemoteException e2) {
                        cVar = c.SERVICE_ERROR;
                        p0 p0Var2 = p0.a;
                        str2 = f10480b;
                        p0.i0(str2, e2);
                        c2.unbindService(bVar);
                        p0.j0(str2, "Unbound from the remote service");
                        return cVar;
                    }
                } catch (InterruptedException e3) {
                    cVar = c.SERVICE_ERROR;
                    p0 p0Var3 = p0.a;
                    str2 = f10480b;
                    p0.i0(str2, e3);
                    c2.unbindService(bVar);
                    p0.j0(str2, "Unbound from the remote service");
                    return cVar;
                }
            }
            return c.SERVICE_ERROR;
        } finally {
            c2.unbindService(bVar);
            p0 p0Var4 = p0.a;
            p0.j0(f10480b, "Unbound from the remote service");
        }
    }

    public static final c e(String str) {
        List<v> j2;
        m.f(str, "applicationId");
        e eVar = a;
        a aVar = a.MOBILE_APP_INSTALL;
        j2 = u.j();
        return eVar.d(aVar, str, j2);
    }
}
