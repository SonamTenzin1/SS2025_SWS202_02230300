package io.sentry;

import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DirectoryProcessor.java */
/* loaded from: classes2.dex */
public abstract class e1 {
    private final w1 a;

    /* renamed from: b, reason: collision with root package name */
    private final long f22383b;

    /* compiled from: DirectoryProcessor.java */
    /* loaded from: classes2.dex */
    private static final class a implements io.sentry.hints.f, io.sentry.hints.k, io.sentry.hints.p, io.sentry.hints.i {
        boolean a = false;

        /* renamed from: b, reason: collision with root package name */
        boolean f22384b = false;

        /* renamed from: c, reason: collision with root package name */
        private final CountDownLatch f22385c = new CountDownLatch(1);

        /* renamed from: d, reason: collision with root package name */
        private final long f22386d;

        /* renamed from: e, reason: collision with root package name */
        private final w1 f22387e;

        public a(long j2, w1 w1Var) {
            this.f22386d = j2;
            this.f22387e = w1Var;
        }

        @Override // io.sentry.hints.k
        public boolean b() {
            return this.a;
        }

        @Override // io.sentry.hints.p
        public void c(boolean z) {
            this.f22384b = z;
            this.f22385c.countDown();
        }

        @Override // io.sentry.hints.k
        public void d(boolean z) {
            this.a = z;
        }

        @Override // io.sentry.hints.i
        public boolean e() {
            try {
                return this.f22385c.await(this.f22386d, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                this.f22387e.b(s4.ERROR, "Exception while awaiting on lock.", e2);
                return false;
            }
        }

        @Override // io.sentry.hints.p
        public boolean f() {
            return this.f22384b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(w1 w1Var, long j2) {
        this.a = w1Var;
        this.f22383b = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean d(File file, String str) {
        return b(str);
    }

    protected abstract boolean b(String str);

    public void e(File file) {
        try {
            w1 w1Var = this.a;
            s4 s4Var = s4.DEBUG;
            w1Var.c(s4Var, "Processing dir. %s", file.getAbsolutePath());
            if (!file.exists()) {
                this.a.c(s4.WARNING, "Directory '%s' doesn't exist. No cached events to send.", file.getAbsolutePath());
                return;
            }
            if (!file.isDirectory()) {
                this.a.c(s4.ERROR, "Cache dir %s is not a directory.", file.getAbsolutePath());
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                this.a.c(s4.ERROR, "Cache dir %s is null.", file.getAbsolutePath());
                return;
            }
            File[] listFiles2 = file.listFiles(new FilenameFilter() { // from class: io.sentry.b
                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str) {
                    return e1.this.d(file2, str);
                }
            });
            w1 w1Var2 = this.a;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(listFiles2 != null ? listFiles2.length : 0);
            objArr[1] = file.getAbsolutePath();
            w1Var2.c(s4Var, "Processing %d items from cache dir %s", objArr);
            for (File file2 : listFiles) {
                if (!file2.isFile()) {
                    this.a.c(s4.DEBUG, "File %s is not a File.", file2.getAbsolutePath());
                } else {
                    this.a.c(s4.DEBUG, "Processing file: %s", file2.getAbsolutePath());
                    f(file2, io.sentry.util.m.a(new a(this.f22383b, this.a)));
                }
            }
        } catch (Throwable th) {
            this.a.a(s4.ERROR, th, "Failed processing '%s'", file.getAbsolutePath());
        }
    }

    protected abstract void f(File file, n1 n1Var);
}
