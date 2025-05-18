package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public class t0 {
    private static final long a = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: b, reason: collision with root package name */
    private final Context f19863b;

    /* renamed from: c, reason: collision with root package name */
    private final g0 f19864c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f19865d;

    /* renamed from: e, reason: collision with root package name */
    private final FirebaseMessaging f19866e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.firebase.installations.i f19867f;

    /* renamed from: h, reason: collision with root package name */
    private final ScheduledExecutorService f19869h;

    /* renamed from: j, reason: collision with root package name */
    private final r0 f19871j;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> f19868g = new c.e.a();

    /* renamed from: i, reason: collision with root package name */
    private boolean f19870i = false;

    private t0(FirebaseMessaging firebaseMessaging, com.google.firebase.installations.i iVar, g0 g0Var, r0 r0Var, b0 b0Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f19866e = firebaseMessaging;
        this.f19867f = iVar;
        this.f19864c = g0Var;
        this.f19871j = r0Var;
        this.f19865d = b0Var;
        this.f19863b = context;
        this.f19869h = scheduledExecutorService;
    }

    private static <T> T a(Task<T> task) throws IOException {
        try {
            return (T) Tasks.b(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            e = e2;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e3);
            }
            throw ((IOException) cause);
        } catch (TimeoutException e4) {
            e = e4;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    private void b(String str) throws IOException {
        a(this.f19865d.j((String) a(this.f19867f.getId()), this.f19866e.c(), str));
    }

    private void c(String str) throws IOException {
        a(this.f19865d.k((String) a(this.f19867f.getId()), this.f19866e.c(), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Task<t0> d(final FirebaseMessaging firebaseMessaging, final com.google.firebase.installations.i iVar, final g0 g0Var, final b0 b0Var, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.c(scheduledExecutorService, new Callable(context, scheduledExecutorService, firebaseMessaging, iVar, g0Var, b0Var) { // from class: com.google.firebase.messaging.s0

            /* renamed from: f, reason: collision with root package name */
            private final Context f19856f;

            /* renamed from: g, reason: collision with root package name */
            private final ScheduledExecutorService f19857g;

            /* renamed from: h, reason: collision with root package name */
            private final FirebaseMessaging f19858h;

            /* renamed from: i, reason: collision with root package name */
            private final com.google.firebase.installations.i f19859i;

            /* renamed from: j, reason: collision with root package name */
            private final g0 f19860j;

            /* renamed from: k, reason: collision with root package name */
            private final b0 f19861k;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f19856f = context;
                this.f19857g = scheduledExecutorService;
                this.f19858h = firebaseMessaging;
                this.f19859i = iVar;
                this.f19860j = g0Var;
                this.f19861k = b0Var;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                return t0.h(this.f19856f, this.f19857g, this.f19858h, this.f19859i, this.f19860j, this.f19861k);
            }
        });
    }

    static boolean f() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ t0 h(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, com.google.firebase.installations.i iVar, g0 g0Var, b0 b0Var) throws Exception {
        return new t0(firebaseMessaging, iVar, g0Var, r0.a(context, scheduledExecutorService), b0Var, context, scheduledExecutorService);
    }

    private void i(q0 q0Var) {
        synchronized (this.f19868g) {
            String e2 = q0Var.e();
            if (this.f19868g.containsKey(e2)) {
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.f19868g.get(e2);
                TaskCompletionSource<Void> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.c(null);
                }
                if (arrayDeque.isEmpty()) {
                    this.f19868g.remove(e2);
                }
            }
        }
    }

    private void m() {
        if (g()) {
            return;
        }
        p(0L);
    }

    boolean e() {
        return this.f19871j.b() != null;
    }

    synchronized boolean g() {
        return this.f19870i;
    }

    boolean j(q0 q0Var) throws IOException {
        char c2;
        try {
            String b2 = q0Var.b();
            int hashCode = b2.hashCode();
            if (hashCode != 83) {
                if (hashCode == 85 && b2.equals("U")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (b2.equals("S")) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                b(q0Var.c());
                if (f()) {
                    String c3 = q0Var.c();
                    StringBuilder sb = new StringBuilder(String.valueOf(c3).length() + 31);
                    sb.append("Subscribe to topic: ");
                    sb.append(c3);
                    sb.append(" succeeded.");
                    Log.d("FirebaseMessaging", sb.toString());
                }
            } else if (c2 != 1) {
                if (f()) {
                    String valueOf = String.valueOf(q0Var);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
                    sb2.append("Unknown topic operation");
                    sb2.append(valueOf);
                    sb2.append(".");
                    Log.d("FirebaseMessaging", sb2.toString());
                }
            } else {
                c(q0Var.c());
                if (f()) {
                    String c4 = q0Var.c();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(c4).length() + 35);
                    sb3.append("Unsubscribe from topic: ");
                    sb3.append(c4);
                    sb3.append(" succeeded.");
                    Log.d("FirebaseMessaging", sb3.toString());
                }
            }
            return true;
        } catch (IOException e2) {
            if (!"SERVICE_NOT_AVAILABLE".equals(e2.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e2.getMessage())) {
                if (e2.getMessage() == null) {
                    Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                    return false;
                }
                throw e2;
            }
            String message = e2.getMessage();
            StringBuilder sb4 = new StringBuilder(String.valueOf(message).length() + 53);
            sb4.append("Topic operation failed: ");
            sb4.append(message);
            sb4.append(". Will retry Topic operation.");
            Log.e("FirebaseMessaging", sb4.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Runnable runnable, long j2) {
        this.f19869h.schedule(runnable, j2, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void l(boolean z) {
        this.f19870i = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        if (e()) {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x000d, code lost:
    
        if (f() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x000f, code lost:
    
        android.util.Log.d("FirebaseMessaging", "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0017, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean o() throws IOException {
        while (true) {
            synchronized (this) {
                q0 b2 = this.f19871j.b();
                if (b2 == null) {
                    break;
                }
                if (!j(b2)) {
                    return false;
                }
                this.f19871j.d(b2);
                i(b2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(long j2) {
        k(new u0(this, this.f19863b, this.f19864c, Math.min(Math.max(30L, j2 + j2), a)), j2);
        l(true);
    }
}
