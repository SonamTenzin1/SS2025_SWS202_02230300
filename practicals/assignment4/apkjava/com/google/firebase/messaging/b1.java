package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.b1;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
class b1 implements ServiceConnection {

    /* renamed from: f, reason: collision with root package name */
    private final Context f19798f;

    /* renamed from: g, reason: collision with root package name */
    private final Intent f19799g;

    /* renamed from: h, reason: collision with root package name */
    private final ScheduledExecutorService f19800h;

    /* renamed from: i, reason: collision with root package name */
    private final Queue<a> f19801i;

    /* renamed from: j, reason: collision with root package name */
    private y0 f19802j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f19803k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes2.dex */
    public static class a {
        final Intent a;

        /* renamed from: b, reason: collision with root package name */
        private final TaskCompletionSource<Void> f19804b = new TaskCompletionSource<>();

        a(Intent intent) {
            this.a = intent;
        }

        void a(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable(this) { // from class: com.google.firebase.messaging.z0

                /* renamed from: f, reason: collision with root package name */
                private final b1.a f19886f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f19886f = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f19886f.d();
                }
            }, 9000L, TimeUnit.MILLISECONDS);
            c().c(scheduledExecutorService, new OnCompleteListener(schedule) { // from class: com.google.firebase.messaging.a1
                private final ScheduledFuture a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = schedule;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void a(Task task) {
                    this.a.cancel(false);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            this.f19804b.e(null);
        }

        Task<Void> c() {
            return this.f19804b.a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void d() {
            String action = this.a.getAction();
            StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
            sb.append("Service took too long to process intent: ");
            sb.append(action);
            sb.append(" App may get closed.");
            Log.w("FirebaseMessaging", sb.toString());
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(Context context, String str) {
        this(context, "com.google.firebase.MESSAGING_EVENT", new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private void a() {
        while (!this.f19801i.isEmpty()) {
            this.f19801i.poll().b();
        }
    }

    private synchronized void b() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "flush queue called");
        }
        while (!this.f19801i.isEmpty()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "found intent to be delivered");
            }
            y0 y0Var = this.f19802j;
            if (y0Var != null && y0Var.isBinderAlive()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f19802j.b(this.f19801i.poll());
            } else {
                d();
                return;
            }
        }
    }

    private void d() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            boolean z = this.f19803k;
            StringBuilder sb = new StringBuilder(39);
            sb.append("binder is dead. start connection? ");
            sb.append(!z);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.f19803k) {
            return;
        }
        this.f19803k = true;
        try {
        } catch (SecurityException e2) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e2);
        }
        if (ConnectionTracker.b().a(this.f19798f, this.f19799g, this, 65)) {
            return;
        }
        Log.e("FirebaseMessaging", "binding to the service failed");
        this.f19803k = false;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Task<Void> c(Intent intent) {
        a aVar;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
        }
        aVar = new a(intent);
        aVar.a(this.f19800h);
        this.f19801i.add(aVar);
        b();
        return aVar.c();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(valueOf.length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
            Log.d("FirebaseMessaging", sb.toString());
        }
        this.f19803k = false;
        if (!(iBinder instanceof y0)) {
            String valueOf2 = String.valueOf(iBinder);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 28);
            sb2.append("Invalid service connection: ");
            sb2.append(valueOf2);
            Log.e("FirebaseMessaging", sb2.toString());
            a();
            return;
        }
        this.f19802j = (y0) iBinder;
        b();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(valueOf.length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d("FirebaseMessaging", sb.toString());
        }
        b();
    }

    b1(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f19801i = new ArrayDeque();
        this.f19803k = false;
        Context applicationContext = context.getApplicationContext();
        this.f19798f = applicationContext;
        this.f19799g = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.f19800h = scheduledExecutorService;
    }
}
