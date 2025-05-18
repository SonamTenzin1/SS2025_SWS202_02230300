package com.liulishuo.filedownloader.services;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import e.h.a.b0;
import java.lang.ref.WeakReference;

@SuppressLint({"Registered"})
/* loaded from: classes2.dex */
public class FileDownloadService extends Service {

    /* renamed from: f, reason: collision with root package name */
    private j f20505f;

    /* renamed from: g, reason: collision with root package name */
    private b0 f20506g;

    /* loaded from: classes2.dex */
    public static class SeparateProcessService extends FileDownloadService {
    }

    /* loaded from: classes2.dex */
    public static class SharedMainProcessService extends FileDownloadService {
    }

    private void a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("is_foreground", false)) {
            i h2 = e.h.a.g0.c.j().h();
            if (h2.f() && Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(h2.c(), h2.d(), 2);
                NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                if (notificationManager == null) {
                    return;
                } else {
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            startForeground(h2.e(), h2.b(this));
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "run service foreground with config: %s", h2);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f20505f.P(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        e.h.a.k0.c.b(this);
        try {
            e.h.a.k0.f.T(e.h.a.k0.e.a().a);
            e.h.a.k0.f.U(e.h.a.k0.e.a().f21364b);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        g gVar = new g();
        if (e.h.a.k0.e.a().f21366d) {
            this.f20505f = new e(new WeakReference(this), gVar);
        } else {
            this.f20505f = new d(new WeakReference(this), gVar);
        }
        b0.a();
        b0 b0Var = new b0((e.h.a.i0.b) this.f20505f);
        this.f20506g = b0Var;
        b0Var.d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f20506g.e();
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        this.f20505f.k0(intent, i2, i3);
        a(intent);
        return 1;
    }
}
