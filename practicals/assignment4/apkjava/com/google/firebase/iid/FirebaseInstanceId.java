package com.google.firebase.iid;

import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.s;
import com.google.firebase.iid.u;
import com.google.firebase.iid.w.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
@Deprecated
/* loaded from: classes2.dex */
public class FirebaseInstanceId {

    /* renamed from: b, reason: collision with root package name */
    private static u f19620b;

    /* renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    static ScheduledExecutorService f19622d;

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    final Executor f19623e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.firebase.j f19624f;

    /* renamed from: g, reason: collision with root package name */
    private final n f19625g;

    /* renamed from: h, reason: collision with root package name */
    private final k f19626h;

    /* renamed from: i, reason: collision with root package name */
    private final s f19627i;

    /* renamed from: j, reason: collision with root package name */
    private final com.google.firebase.installations.i f19628j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f19629k;
    private final List<a.InterfaceC0229a> l;
    private static final long a = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f19621c = Pattern.compile("\\AA[\\w-]{38}\\z");

    FirebaseInstanceId(com.google.firebase.j jVar, n nVar, Executor executor, Executor executor2, com.google.firebase.s.b<com.google.firebase.u.i> bVar, com.google.firebase.s.b<com.google.firebase.r.j> bVar2, com.google.firebase.installations.i iVar) {
        this.f19629k = false;
        this.l = new ArrayList();
        if (n.c(jVar) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f19620b == null) {
                    f19620b = new u(jVar.i());
                }
            }
            this.f19624f = jVar;
            this.f19625g = nVar;
            this.f19626h = new k(jVar, nVar, bVar, bVar2, iVar);
            this.f19623e = executor2;
            this.f19627i = new s(executor);
            this.f19628j = iVar;
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    private static String B(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    private void F() {
        if (H(q())) {
            E();
        }
    }

    private <T> T b(Task<T> task) throws IOException {
        try {
            return (T) Tasks.b(task, 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    C();
                }
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e2);
        }
    }

    private static <T> T c(Task<T> task) throws InterruptedException {
        Preconditions.l(task, "Task must not be null");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.c(d.f19633f, new OnCompleteListener(countDownLatch) { // from class: com.google.firebase.iid.e
            private final CountDownLatch a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = countDownLatch;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void a(Task task2) {
                this.a.countDown();
            }
        });
        countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
        return (T) m(task);
    }

    private static void e(com.google.firebase.j jVar) {
        Preconditions.h(jVar.l().e(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        Preconditions.h(jVar.l().c(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        Preconditions.h(jVar.l().b(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        Preconditions.b(v(jVar.l().c()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.b(u(jVar.l().b()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @Keep
    public static FirebaseInstanceId getInstance(com.google.firebase.j jVar) {
        e(jVar);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) jVar.h(FirebaseInstanceId.class);
        Preconditions.l(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    public static FirebaseInstanceId j() {
        return getInstance(com.google.firebase.j.j());
    }

    private Task<l> l(final String str, String str2) {
        final String B = B(str2);
        return Tasks.e(null).h(this.f19623e, new Continuation(this, str, B) { // from class: com.google.firebase.iid.c
            private final FirebaseInstanceId a;

            /* renamed from: b, reason: collision with root package name */
            private final String f19631b;

            /* renamed from: c, reason: collision with root package name */
            private final String f19632c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f19631b = str;
                this.f19632c = B;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object a(Task task) {
                return this.a.A(this.f19631b, this.f19632c, task);
            }
        });
    }

    private static <T> T m(Task<T> task) {
        if (task.n()) {
            return task.j();
        }
        if (!task.l()) {
            if (task.m()) {
                throw new IllegalStateException(task.i());
            }
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
        throw new CancellationException("Task is already canceled");
    }

    private String n() {
        return "[DEFAULT]".equals(this.f19624f.k()) ? HttpUrl.FRAGMENT_ENCODE_SET : this.f19624f.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s() {
        return Log.isLoggable("FirebaseInstanceId", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3));
    }

    static boolean u(String str) {
        return f19621c.matcher(str).matches();
    }

    static boolean v(String str) {
        return str.contains(":");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task A(final String str, final String str2, Task task) throws Exception {
        final String i2 = i();
        final u.a r = r(str, str2);
        if (!H(r)) {
            return Tasks.e(new m(i2, r.f19659b));
        }
        return this.f19627i.a(str, str2, new s.a(this, i2, str, str2, r) { // from class: com.google.firebase.iid.f
            private final FirebaseInstanceId a;

            /* renamed from: b, reason: collision with root package name */
            private final String f19634b;

            /* renamed from: c, reason: collision with root package name */
            private final String f19635c;

            /* renamed from: d, reason: collision with root package name */
            private final String f19636d;

            /* renamed from: e, reason: collision with root package name */
            private final u.a f19637e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f19634b = i2;
                this.f19635c = str;
                this.f19636d = str2;
                this.f19637e = r;
            }

            @Override // com.google.firebase.iid.s.a
            public Task start() {
                return this.a.z(this.f19634b, this.f19635c, this.f19636d, this.f19637e);
            }
        });
    }

    synchronized void C() {
        f19620b.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void D(boolean z) {
        this.f19629k = z;
    }

    synchronized void E() {
        if (this.f19629k) {
            return;
        }
        G(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void G(long j2) {
        f(new v(this, Math.min(Math.max(30L, j2 + j2), a)), j2);
        this.f19629k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H(u.a aVar) {
        return aVar == null || aVar.c(this.f19625g.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.InterfaceC0229a interfaceC0229a) {
        this.l.add(interfaceC0229a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() throws IOException {
        return p(n.c(this.f19624f), "*");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Runnable runnable, long j2) {
        synchronized (FirebaseInstanceId.class) {
            if (f19622d == null) {
                f19622d = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            f19622d.schedule(runnable, j2, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.firebase.j g() {
        return this.f19624f;
    }

    @Deprecated
    public String h() {
        e(this.f19624f);
        F();
        return i();
    }

    String i() {
        try {
            f19620b.i(this.f19624f.m());
            return (String) c(this.f19628j.getId());
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Deprecated
    public Task<l> k() {
        e(this.f19624f);
        return l(n.c(this.f19624f), "*");
    }

    @Deprecated
    public String o() {
        e(this.f19624f);
        u.a q = q();
        if (H(q)) {
            E();
        }
        return u.a.b(q);
    }

    @Deprecated
    public String p(String str, String str2) throws IOException {
        e(this.f19624f);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((l) b(l(str, str2))).a();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u.a q() {
        return r(n.c(this.f19624f), "*");
    }

    @VisibleForTesting
    u.a r(String str, String str2) {
        return f19620b.f(n(), str, str2);
    }

    @VisibleForTesting
    public boolean t() {
        return this.f19625g.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task x(String str, String str2, String str3, String str4) throws Exception {
        f19620b.h(n(), str, str2, str4, this.f19625g.a());
        return Tasks.e(new m(str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void y(u.a aVar, l lVar) {
        String a2 = lVar.a();
        if (aVar == null || !a2.equals(aVar.f19659b)) {
            Iterator<a.InterfaceC0229a> it = this.l.iterator();
            while (it.hasNext()) {
                it.next().a(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task z(final String str, final String str2, final String str3, final u.a aVar) {
        return this.f19626h.d(str, str2, str3).p(this.f19623e, new SuccessContinuation(this, str2, str3, str) { // from class: com.google.firebase.iid.g
            private final FirebaseInstanceId a;

            /* renamed from: b, reason: collision with root package name */
            private final String f19638b;

            /* renamed from: c, reason: collision with root package name */
            private final String f19639c;

            /* renamed from: d, reason: collision with root package name */
            private final String f19640d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f19638b = str2;
                this.f19639c = str3;
                this.f19640d = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public Task a(Object obj) {
                return this.a.x(this.f19638b, this.f19639c, this.f19640d, (String) obj);
            }
        }).e(h.f19641f, new OnSuccessListener(this, aVar) { // from class: com.google.firebase.iid.i
            private final FirebaseInstanceId a;

            /* renamed from: b, reason: collision with root package name */
            private final u.a f19642b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f19642b = aVar;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Object obj) {
                this.a.y(this.f19642b, (l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseInstanceId(com.google.firebase.j jVar, com.google.firebase.s.b<com.google.firebase.u.i> bVar, com.google.firebase.s.b<com.google.firebase.r.j> bVar2, com.google.firebase.installations.i iVar) {
        this(jVar, new n(jVar.i()), b.b(), b.b(), bVar, bVar2, iVar);
    }
}
