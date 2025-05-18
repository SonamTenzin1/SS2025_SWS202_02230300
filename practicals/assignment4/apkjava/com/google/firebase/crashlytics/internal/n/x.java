package com.google.firebase.crashlytics.internal.n;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.n.c0;
import com.google.firebase.crashlytics.internal.o.l;
import com.google.firebase.crashlytics.internal.p.f0;
import com.google.firebase.crashlytics.internal.p.g0;
import com.google.firebase.crashlytics.internal.t.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CrashlyticsController.java */
/* loaded from: classes2.dex */
public class x {
    static final FilenameFilter a = new FilenameFilter() { // from class: com.google.firebase.crashlytics.h.n.c
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean startsWith;
            startsWith = str.startsWith(".ae");
            return startsWith;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final Context f19094b;

    /* renamed from: c, reason: collision with root package name */
    private final e0 f19095c;

    /* renamed from: d, reason: collision with root package name */
    private final z f19096d;

    /* renamed from: e, reason: collision with root package name */
    private final l f19097e;

    /* renamed from: f, reason: collision with root package name */
    private final w f19098f;

    /* renamed from: g, reason: collision with root package name */
    private final i0 f19099g;

    /* renamed from: h, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.r.f f19100h;

    /* renamed from: i, reason: collision with root package name */
    private final l f19101i;

    /* renamed from: j, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.o.f f19102j;

    /* renamed from: k, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.d f19103k;
    private final com.google.firebase.crashlytics.internal.l.a l;
    private final v m;
    private final o0 n;
    private c0 o;
    private i p = null;
    final TaskCompletionSource<Boolean> q = new TaskCompletionSource<>();
    final TaskCompletionSource<Boolean> r = new TaskCompletionSource<>();
    final TaskCompletionSource<Void> s = new TaskCompletionSource<>();
    final AtomicBoolean t = new AtomicBoolean(false);

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes2.dex */
    class a implements c0.a {
        a() {
        }

        @Override // com.google.firebase.crashlytics.h.n.c0.a
        public void a(i iVar, Thread thread, Throwable th) {
            x.this.G(iVar, thread, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes2.dex */
    public class b implements Callable<Task<Void>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f19104f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Throwable f19105g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Thread f19106h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ i f19107i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f19108j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CrashlyticsController.java */
        /* loaded from: classes2.dex */
        public class a implements SuccessContinuation<com.google.firebase.crashlytics.internal.t.d, Void> {
            final /* synthetic */ Executor a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f19110b;

            a(Executor executor, String str) {
                this.a = executor;
                this.f19110b = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Task<Void> a(com.google.firebase.crashlytics.internal.t.d dVar) throws Exception {
                if (dVar != null) {
                    Task[] taskArr = new Task[2];
                    taskArr[0] = x.this.M();
                    taskArr[1] = x.this.n.w(this.a, b.this.f19108j ? this.f19110b : null);
                    return Tasks.g(taskArr);
                }
                h.f().k("Received null app settings, cannot send reports at crash time.");
                return Tasks.e(null);
            }
        }

        b(long j2, Throwable th, Thread thread, i iVar, boolean z) {
            this.f19104f = j2;
            this.f19105g = th;
            this.f19106h = thread;
            this.f19107i = iVar;
            this.f19108j = z;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task<Void> call() throws Exception {
            long E = x.E(this.f19104f);
            String A = x.this.A();
            if (A != null) {
                x.this.f19096d.a();
                x.this.n.s(this.f19105g, this.f19106h, A, E);
                x.this.v(this.f19104f);
                x.this.s(this.f19107i);
                x.this.u(new s(x.this.f19099g).toString(), Boolean.valueOf(this.f19108j));
                if (x.this.f19095c.d()) {
                    Executor c2 = x.this.f19098f.c();
                    return this.f19107i.a().p(c2, new a(c2, A));
                }
                return Tasks.e(null);
            }
            h.f().d("Tried to write a fatal exception while no session was open.");
            return Tasks.e(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes2.dex */
    public class c implements SuccessContinuation<Void, Boolean> {
        c() {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Task<Boolean> a(Void r1) throws Exception {
            return Tasks.e(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes2.dex */
    public class d implements SuccessContinuation<Boolean, Void> {
        final /* synthetic */ Task a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CrashlyticsController.java */
        /* loaded from: classes2.dex */
        public class a implements Callable<Task<Void>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Boolean f19113f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: CrashlyticsController.java */
            /* renamed from: com.google.firebase.crashlytics.h.n.x$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0207a implements SuccessContinuation<com.google.firebase.crashlytics.internal.t.d, Void> {
                final /* synthetic */ Executor a;

                C0207a(Executor executor) {
                    this.a = executor;
                }

                @Override // com.google.android.gms.tasks.SuccessContinuation
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public Task<Void> a(com.google.firebase.crashlytics.internal.t.d dVar) throws Exception {
                    if (dVar != null) {
                        x.this.M();
                        x.this.n.v(this.a);
                        x.this.s.e(null);
                        return Tasks.e(null);
                    }
                    h.f().k("Received null app settings at app startup. Cannot send cached reports");
                    return Tasks.e(null);
                }
            }

            a(Boolean bool) {
                this.f19113f = bool;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task<Void> call() throws Exception {
                if (!this.f19113f.booleanValue()) {
                    h.f().i("Deleting cached crash reports...");
                    x.q(x.this.K());
                    x.this.n.u();
                    x.this.s.e(null);
                    return Tasks.e(null);
                }
                h.f().b("Sending cached crash reports...");
                x.this.f19095c.c(this.f19113f.booleanValue());
                Executor c2 = x.this.f19098f.c();
                return d.this.a.p(c2, new C0207a(c2));
            }
        }

        d(Task task) {
            this.a = task;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Task<Void> a(Boolean bool) throws Exception {
            return x.this.f19098f.h(new a(bool));
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes2.dex */
    class e implements Callable<Void> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f19116f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f19117g;

        e(long j2, String str) {
            this.f19116f = j2;
            this.f19117g = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            if (x.this.I()) {
                return null;
            }
            x.this.f19102j.g(this.f19116f, this.f19117g);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes2.dex */
    public class f implements Callable<Void> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f19119f;

        f(String str) {
            this.f19119f = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            x.this.u(this.f19119f, Boolean.FALSE);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CrashlyticsController.java */
    /* loaded from: classes2.dex */
    public class g implements Callable<Void> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f19121f;

        g(long j2) {
            this.f19121f = j2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong("timestamp", this.f19121f);
            x.this.l.a("_ae", bundle);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Context context, w wVar, i0 i0Var, e0 e0Var, com.google.firebase.crashlytics.internal.r.f fVar, z zVar, l lVar, l lVar2, com.google.firebase.crashlytics.internal.o.f fVar2, o0 o0Var, com.google.firebase.crashlytics.internal.d dVar, com.google.firebase.crashlytics.internal.l.a aVar, v vVar) {
        this.f19094b = context;
        this.f19098f = wVar;
        this.f19099g = i0Var;
        this.f19095c = e0Var;
        this.f19100h = fVar;
        this.f19096d = zVar;
        this.f19101i = lVar;
        this.f19097e = lVar2;
        this.f19102j = fVar2;
        this.f19103k = dVar;
        this.l = aVar;
        this.m = vVar;
        this.n = o0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A() {
        SortedSet<String> o = this.n.o();
        if (o.isEmpty()) {
            return null;
        }
        return o.first();
    }

    private static long B() {
        return E(System.currentTimeMillis());
    }

    static List<l0> C(com.google.firebase.crashlytics.internal.i iVar, String str, com.google.firebase.crashlytics.internal.r.f fVar, byte[] bArr) {
        File o = fVar.o(str, "user-data");
        File o2 = fVar.o(str, "keys");
        File o3 = fVar.o(str, "rollouts-state");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new r("logs_file", "logs", bArr));
        arrayList.add(new h0("crash_meta_file", "metadata", iVar.g()));
        arrayList.add(new h0("session_meta_file", "session", iVar.f()));
        arrayList.add(new h0("app_meta_file", "app", iVar.a()));
        arrayList.add(new h0("device_meta_file", "device", iVar.c()));
        arrayList.add(new h0("os_meta_file", "os", iVar.b()));
        arrayList.add(O(iVar));
        arrayList.add(new h0("user_meta_file", "user", o));
        arrayList.add(new h0("keys_file", "keys", o2));
        arrayList.add(new h0("rollouts_file", "rollouts", o3));
        return arrayList;
    }

    private InputStream D(String str) {
        ClassLoader classLoader = x.class.getClassLoader();
        if (classLoader == null) {
            h.f().k("Couldn't get Class Loader");
            return null;
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        h.f().g("No version control information found");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long E(long j2) {
        return j2 / 1000;
    }

    private Task<Void> L(long j2) {
        if (z()) {
            h.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.e(null);
        }
        h.f().b("Logging app exception event to Firebase Analytics");
        return Tasks.c(new ScheduledThreadPoolExecutor(1), new g(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> M() {
        ArrayList arrayList = new ArrayList();
        for (File file : K()) {
            try {
                arrayList.add(L(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                h.f().k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.f(arrayList);
    }

    private static boolean N(String str, File file, f0.a aVar) {
        if (file == null || !file.exists()) {
            h.f().k("No minidump data found for session " + str);
        }
        if (aVar == null) {
            h.f().g("No Tombstones data found for session " + str);
        }
        return (file == null || !file.exists()) && aVar == null;
    }

    private static l0 O(com.google.firebase.crashlytics.internal.i iVar) {
        File e2 = iVar.e();
        if (e2 != null && e2.exists()) {
            return new h0("minidump_file", "minidump", e2);
        }
        return new r("minidump_file", "minidump", new byte[]{0});
    }

    private static byte[] Q(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private Task<Boolean> U() {
        if (this.f19095c.d()) {
            h.f().b("Automatic data collection is enabled. Allowing upload.");
            this.q.e(Boolean.FALSE);
            return Tasks.e(Boolean.TRUE);
        }
        h.f().b("Automatic data collection is disabled.");
        h.f().i("Notifying that unsent reports are available.");
        this.q.e(Boolean.TRUE);
        Task<TContinuationResult> o = this.f19095c.h().o(new c());
        h.f().b("Waiting for send/deleteUnsentReports to be called.");
        return q0.i(o, this.r.a());
    }

    private void V(String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.f19094b.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
            if (historicalProcessExitReasons.size() != 0) {
                this.n.t(str, historicalProcessExitReasons, new com.google.firebase.crashlytics.internal.o.f(this.f19100h, str), l.h(str, this.f19100h, this.f19098f));
                return;
            } else {
                h.f().i("No ApplicationExitInfo available. Session: " + str);
                return;
            }
        }
        h.f().i("ANR feature enabled, but device is API " + i2);
    }

    private static g0.a n(i0 i0Var, l lVar) {
        return g0.a.b(i0Var.f(), lVar.f19060f, lVar.f19061g, i0Var.a().c(), f0.g(lVar.f19058d).k(), lVar.f19062h);
    }

    private static g0.b o(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return g0.b.c(t.k(), Build.MODEL, Runtime.getRuntime().availableProcessors(), t.b(context), statFs.getBlockCount() * statFs.getBlockSize(), t.w(), t.l(), Build.MANUFACTURER, Build.PRODUCT);
    }

    private static g0.c p() {
        return g0.c.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, t.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(List<File> list) {
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t(boolean z, i iVar) {
        ArrayList arrayList = new ArrayList(this.n.o());
        if (arrayList.size() <= z) {
            h.f().i("No open sessions to be closed.");
            return;
        }
        String str = (String) arrayList.get(z ? 1 : 0);
        if (iVar.b().f19545b.f19552b) {
            V(str);
        } else {
            h.f().i("ANR feature disabled.");
        }
        if (this.f19103k.d(str)) {
            x(str);
        }
        String str2 = null;
        if (z != 0) {
            str2 = (String) arrayList.get(0);
        } else {
            this.m.e(null);
        }
        this.n.i(B(), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, Boolean bool) {
        long B = B();
        h.f().b("Opening a new session with ID " + str);
        this.f19103k.c(str, String.format(Locale.US, "Crashlytics Android SDK/%s", y.i()), B, g0.b(n(this.f19099g, this.f19101i), p(), o(this.f19094b)));
        if (bool.booleanValue() && str != null) {
            this.f19097e.k(str);
        }
        this.f19102j.e(str);
        this.m.e(str);
        this.n.p(str, B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(long j2) {
        try {
            if (this.f19100h.e(".ae" + j2).createNewFile()) {
            } else {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e2) {
            h.f().l("Could not create app exception marker file.", e2);
        }
    }

    private void x(String str) {
        h.f().i("Finalizing native report for session " + str);
        com.google.firebase.crashlytics.internal.i a2 = this.f19103k.a(str);
        File e2 = a2.e();
        f0.a d2 = a2.d();
        if (N(str, e2, d2)) {
            h.f().k("No native core present");
            return;
        }
        long lastModified = e2.lastModified();
        com.google.firebase.crashlytics.internal.o.f fVar = new com.google.firebase.crashlytics.internal.o.f(this.f19100h, str);
        File i2 = this.f19100h.i(str);
        if (!i2.isDirectory()) {
            h.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        v(lastModified);
        List<l0> C = C(a2, str, this.f19100h, fVar.b());
        m0.b(i2, C);
        h.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.n.h(str, C, d2);
        fVar.a();
    }

    private static boolean z() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    String F() throws IOException {
        InputStream D = D("META-INF/version-control-info.textproto");
        if (D == null) {
            return null;
        }
        h.f().b("Read version control info");
        return Base64.encodeToString(Q(D), 0);
    }

    void G(i iVar, Thread thread, Throwable th) {
        H(iVar, thread, th, false);
    }

    synchronized void H(i iVar, Thread thread, Throwable th, boolean z) {
        h.f().b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        try {
            q0.a(this.f19098f.h(new b(System.currentTimeMillis(), th, thread, iVar, z)));
        } catch (TimeoutException unused) {
            h.f().d("Cannot send reports. Timed out while fetching settings.");
        } catch (Exception e2) {
            h.f().e("Error handling uncaught exception", e2);
        }
    }

    boolean I() {
        c0 c0Var = this.o;
        return c0Var != null && c0Var.a();
    }

    List<File> K() {
        return this.f19100h.f(a);
    }

    void P(String str) {
        this.f19098f.g(new f(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        try {
            String F = F();
            if (F != null) {
                S("com.crashlytics.version-control-info", F);
                h.f().g("Saved version control info");
            }
        } catch (IOException e2) {
            h.f().l("Unable to save version control info", e2);
        }
    }

    void S(String str, String str2) {
        try {
            this.f19097e.j(str, str2);
        } catch (IllegalArgumentException e2) {
            Context context = this.f19094b;
            if (context != null && t.u(context)) {
                throw e2;
            }
            h.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"TaskMainThread"})
    public Task<Void> T(Task<com.google.firebase.crashlytics.internal.t.d> task) {
        if (!this.n.l()) {
            h.f().i("No crash reports are available to be sent.");
            this.q.e(Boolean.FALSE);
            return Tasks.e(null);
        }
        h.f().i("Crash reports are available to be sent.");
        return U().o(new d(task));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(long j2, String str) {
        this.f19098f.g(new e(j2, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        if (!this.f19096d.c()) {
            String A = A();
            return A != null && this.f19103k.d(A);
        }
        h.f().i("Found previous crash marker.");
        this.f19096d.d();
        return true;
    }

    void s(i iVar) {
        t(false, iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, i iVar) {
        this.p = iVar;
        P(str);
        c0 c0Var = new c0(new a(), iVar, uncaughtExceptionHandler, this.f19103k);
        this.o = c0Var;
        Thread.setDefaultUncaughtExceptionHandler(c0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(i iVar) {
        this.f19098f.b();
        if (I()) {
            h.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        h.f().i("Finalizing previously open sessions.");
        try {
            t(true, iVar);
            h.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e2) {
            h.f().e("Unable to finalize previously open sessions.", e2);
            return false;
        }
    }
}
