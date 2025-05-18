package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zza;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public class Rpc {
    private static int a;

    /* renamed from: b, reason: collision with root package name */
    private static PendingIntent f11571b;

    /* renamed from: c, reason: collision with root package name */
    private static final Executor f11572c = v.f11607f;

    /* renamed from: e, reason: collision with root package name */
    private final Context f11574e;

    /* renamed from: f, reason: collision with root package name */
    private final zzr f11575f;

    /* renamed from: g, reason: collision with root package name */
    private final ScheduledExecutorService f11576g;

    /* renamed from: i, reason: collision with root package name */
    private Messenger f11578i;

    /* renamed from: j, reason: collision with root package name */
    private zza f11579j;

    /* renamed from: d, reason: collision with root package name */
    private final c.e.g<String, TaskCompletionSource<Bundle>> f11573d = new c.e.g<>();

    /* renamed from: h, reason: collision with root package name */
    private Messenger f11577h = new Messenger(new u(this, Looper.getMainLooper()));

    public Rpc(Context context) {
        this.f11574e = context;
        this.f11575f = new zzr(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f11576g = scheduledThreadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Bundle b(Task task) throws Exception {
        if (task.n()) {
            return (Bundle) task.j();
        }
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(task.i());
            StringBuilder sb = new StringBuilder(valueOf.length() + 22);
            sb.append("Error making request: ");
            sb.append(valueOf);
            Log.d("Rpc", sb.toString());
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", task.i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Task c(Bundle bundle) throws Exception {
        if (l(bundle)) {
            return Tasks.e(null);
        }
        return Tasks.e(bundle);
    }

    private static synchronized String e() {
        String num;
        synchronized (Rpc.class) {
            int i2 = a;
            a = i2 + 1;
            num = Integer.toString(i2);
        }
        return num;
    }

    private static synchronized void f(Context context, Intent intent) {
        synchronized (Rpc.class) {
            if (f11571b == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f11571b = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f11571b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zza.C0173zza());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zza) {
                        this.f11579j = (zza) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f11578i = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("Rpc", 3)) {
                        String valueOf = String.valueOf(action);
                        Log.d("Rpc", valueOf.length() != 0 ? "Unexpected response action: ".concat(valueOf) : new String("Unexpected response action: "));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    String stringExtra2 = intent2.getStringExtra("error");
                    if (stringExtra2 == null) {
                        String valueOf2 = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(valueOf2.length() + 49);
                        sb.append("Unexpected response, no error or registration id ");
                        sb.append(valueOf2);
                        Log.w("Rpc", sb.toString());
                        return;
                    }
                    if (Log.isLoggable("Rpc", 3)) {
                        Log.d("Rpc", stringExtra2.length() != 0 ? "Received InstanceID error ".concat(stringExtra2) : new String("Received InstanceID error "));
                    }
                    if (stringExtra2.startsWith("|")) {
                        String[] split = stringExtra2.split("\\|");
                        if (split.length > 2 && "ID".equals(split[1])) {
                            String str = split[2];
                            String str2 = split[3];
                            if (str2.startsWith(":")) {
                                str2 = str2.substring(1);
                            }
                            j(str, intent2.putExtra("error", str2).getExtras());
                            return;
                        }
                        Log.w("Rpc", stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                        return;
                    }
                    synchronized (this.f11573d) {
                        for (int i2 = 0; i2 < this.f11573d.size(); i2++) {
                            j(this.f11573d.j(i2), intent2.getExtras());
                        }
                    }
                    return;
                }
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (!matcher.matches()) {
                    if (Log.isLoggable("Rpc", 3)) {
                        Log.d("Rpc", stringExtra.length() != 0 ? "Unexpected response string: ".concat(stringExtra) : new String("Unexpected response string: "));
                        return;
                    }
                    return;
                }
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                if (group != null) {
                    Bundle extras = intent2.getExtras();
                    extras.putString("registration_id", group2);
                    j(group, extras);
                    return;
                }
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void i(TaskCompletionSource taskCompletionSource) {
        if (taskCompletionSource.d(new IOException("TIMEOUT"))) {
            Log.w("Rpc", "No response");
        }
    }

    private final void j(String str, Bundle bundle) {
        synchronized (this.f11573d) {
            TaskCompletionSource<Bundle> remove = this.f11573d.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("Rpc", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
            } else {
                remove.c(bundle);
            }
        }
    }

    private static boolean l(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    private final Task<Bundle> m(Bundle bundle) {
        final String e2 = e();
        final TaskCompletionSource<Bundle> taskCompletionSource = new TaskCompletionSource<>();
        synchronized (this.f11573d) {
            this.f11573d.put(e2, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f11575f.a() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        f(this.f11574e, intent);
        StringBuilder sb = new StringBuilder(String.valueOf(e2).length() + 5);
        sb.append("|ID|");
        sb.append(e2);
        sb.append("|");
        intent.putExtra("kid", sb.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 8);
            sb2.append("Sending ");
            sb2.append(valueOf);
            Log.d("Rpc", sb2.toString());
        }
        intent.putExtra("google.messenger", this.f11577h);
        if (this.f11578i != null || this.f11579j != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f11578i;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.f11579j.b(obtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
            final ScheduledFuture<?> schedule = this.f11576g.schedule(new Runnable(taskCompletionSource) { // from class: com.google.android.gms.cloudmessaging.p

                /* renamed from: f, reason: collision with root package name */
                private final TaskCompletionSource f11603f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11603f = taskCompletionSource;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Rpc.i(this.f11603f);
                }
            }, 30L, TimeUnit.SECONDS);
            taskCompletionSource.a().c(f11572c, new OnCompleteListener(this, e2, schedule) { // from class: com.google.android.gms.cloudmessaging.t
                private final Rpc a;

                /* renamed from: b, reason: collision with root package name */
                private final String f11605b;

                /* renamed from: c, reason: collision with root package name */
                private final ScheduledFuture f11606c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f11605b = e2;
                    this.f11606c = schedule;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void a(Task task) {
                    this.a.k(this.f11605b, this.f11606c, task);
                }
            });
            return taskCompletionSource.a();
        }
        if (this.f11575f.a() == 2) {
            this.f11574e.sendBroadcast(intent);
        } else {
            this.f11574e.startService(intent);
        }
        final ScheduledFuture schedule2 = this.f11576g.schedule(new Runnable(taskCompletionSource) { // from class: com.google.android.gms.cloudmessaging.p

            /* renamed from: f, reason: collision with root package name */
            private final TaskCompletionSource f11603f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11603f = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Rpc.i(this.f11603f);
            }
        }, 30L, TimeUnit.SECONDS);
        taskCompletionSource.a().c(f11572c, new OnCompleteListener(this, e2, schedule2) { // from class: com.google.android.gms.cloudmessaging.t
            private final Rpc a;

            /* renamed from: b, reason: collision with root package name */
            private final String f11605b;

            /* renamed from: c, reason: collision with root package name */
            private final ScheduledFuture f11606c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f11605b = e2;
                this.f11606c = schedule2;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void a(Task task) {
                this.a.k(this.f11605b, this.f11606c, task);
            }
        });
        return taskCompletionSource.a();
    }

    public Task<Bundle> a(final Bundle bundle) {
        if (this.f11575f.c() >= 12000000) {
            return zze.c(this.f11574e).f(1, bundle).g(f11572c, o.a);
        }
        if (!(this.f11575f.a() != 0)) {
            return Tasks.d(new IOException("MISSING_INSTANCEID_SERVICE"));
        }
        return m(bundle).h(f11572c, new Continuation(this, bundle) { // from class: com.google.android.gms.cloudmessaging.q
            private final Rpc a;

            /* renamed from: b, reason: collision with root package name */
            private final Bundle f11604b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f11604b = bundle;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object a(Task task) {
                return this.a.d(this.f11604b, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task d(Bundle bundle, Task task) throws Exception {
        return (task.n() && l((Bundle) task.j())) ? m(bundle).p(f11572c, s.a) : task;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void k(String str, ScheduledFuture scheduledFuture, Task task) {
        synchronized (this.f11573d) {
            this.f11573d.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
