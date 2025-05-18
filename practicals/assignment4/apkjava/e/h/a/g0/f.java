package e.h.a.g0;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* compiled from: DownloadStatusCallback.java */
/* loaded from: classes2.dex */
public class f implements Handler.Callback {

    /* renamed from: f, reason: collision with root package name */
    private final FileDownloadModel f21311f;

    /* renamed from: h, reason: collision with root package name */
    private final a f21313h;

    /* renamed from: i, reason: collision with root package name */
    private final int f21314i;

    /* renamed from: j, reason: collision with root package name */
    private final int f21315j;

    /* renamed from: k, reason: collision with root package name */
    private final int f21316k;
    private long l;
    private Handler m;
    private HandlerThread n;
    private volatile Thread p;
    private volatile boolean o = false;
    private volatile long q = 0;
    private final AtomicLong r = new AtomicLong();
    private final AtomicBoolean s = new AtomicBoolean(false);
    private final AtomicBoolean t = new AtomicBoolean(false);
    private final AtomicBoolean u = new AtomicBoolean(true);

    /* renamed from: g, reason: collision with root package name */
    private final e.h.a.f0.a f21312g = c.j().f();

    /* compiled from: DownloadStatusCallback.java */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean a;

        /* renamed from: b, reason: collision with root package name */
        private Exception f21317b;

        /* renamed from: c, reason: collision with root package name */
        private int f21318c;

        public Exception a() {
            return this.f21317b;
        }

        public int b() {
            return this.f21318c;
        }

        public boolean c() {
            return this.a;
        }

        void d(Exception exc) {
            this.f21317b = exc;
        }

        void e(boolean z) {
            this.a = z;
        }

        void f(int i2) {
            this.f21318c = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FileDownloadModel fileDownloadModel, int i2, int i3, int i4) {
        this.f21311f = fileDownloadModel;
        this.f21315j = i3 < 5 ? 5 : i3;
        this.f21316k = i4;
        this.f21313h = new a();
        this.f21314i = i2;
    }

    private static long a(long j2, long j3) {
        if (j3 <= 0) {
            return -1L;
        }
        if (j2 == -1) {
            return 1L;
        }
        long j4 = j2 / j3;
        if (j4 <= 0) {
            return 1L;
        }
        return j4;
    }

    private Exception c(Exception exc) {
        long length;
        String j2 = this.f21311f.j();
        if ((!this.f21311f.n() && !e.h.a.k0.e.a().f21368f) || !(exc instanceof IOException) || !new File(j2).exists()) {
            return exc;
        }
        long x = e.h.a.k0.f.x(j2);
        if (x > 4096) {
            return exc;
        }
        File file = new File(j2);
        if (!file.exists()) {
            e.h.a.k0.d.c(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            length = 0;
        } else {
            length = file.length();
        }
        if (Build.VERSION.SDK_INT >= 9) {
            return new FileDownloadOutOfSpaceException(x, 4096L, length, exc);
        }
        return new FileDownloadOutOfSpaceException(x, 4096L, length);
    }

    private void d() throws IOException {
        w();
        this.f21311f.y((byte) -3);
        this.f21312g.d(this.f21311f.e(), this.f21311f.k());
        this.f21312g.h(this.f21311f.e());
        v((byte) -3);
        if (e.h.a.k0.e.a().f21369g) {
            com.liulishuo.filedownloader.services.f.a(this.f21311f);
        }
    }

    private void e(Exception exc) {
        Exception exc2;
        Exception c2 = c(exc);
        if (c2 instanceof SQLiteFullException) {
            i((SQLiteFullException) c2);
            exc2 = c2;
        } else {
            try {
                this.f21311f.y((byte) -1);
                this.f21311f.t(exc.toString());
                this.f21312g.k(this.f21311f.e(), c2, this.f21311f.g());
                exc2 = c2;
            } catch (SQLiteFullException e2) {
                SQLiteFullException sQLiteFullException = e2;
                i(sQLiteFullException);
                exc2 = sQLiteFullException;
            }
        }
        this.f21313h.d(exc2);
        v((byte) -1);
    }

    private void f() {
        this.f21311f.y((byte) -2);
        this.f21312g.q(this.f21311f.e(), this.f21311f.g());
        v((byte) -2);
    }

    private void g() {
        if (this.f21311f.g() == this.f21311f.k()) {
            this.f21312g.l(this.f21311f.e(), this.f21311f.g());
            return;
        }
        if (this.t.compareAndSet(true, false)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.e(this, "handleProgress update model's status with progress", new Object[0]);
            }
            this.f21311f.y((byte) 3);
        }
        if (this.s.compareAndSet(true, false)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.e(this, "handleProgress notify user progress status", new Object[0]);
            }
            v((byte) 3);
        }
    }

    private void h(Exception exc, int i2) {
        Exception c2 = c(exc);
        this.f21313h.d(c2);
        this.f21313h.f(this.f21314i - i2);
        this.f21311f.y((byte) 5);
        this.f21311f.t(c2.toString());
        this.f21312g.c(this.f21311f.e(), c2);
        v((byte) 5);
    }

    private void i(SQLiteFullException sQLiteFullException) {
        int e2 = this.f21311f.e();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(e2), sQLiteFullException.toString());
        }
        this.f21311f.t(sQLiteFullException.toString());
        this.f21311f.y((byte) -1);
        this.f21312g.remove(e2);
        this.f21312g.h(e2);
    }

    private void j(long j2) {
        boolean z;
        if (!this.u.compareAndSet(true, false)) {
            long j3 = j2 - this.q;
            if (this.l == -1 || this.r.get() < this.l || j3 < this.f21315j) {
                z = false;
                if (z || !this.s.compareAndSet(false, true)) {
                }
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.e(this, "inspectNeedCallbackToUser need callback to user", new Object[0]);
                }
                this.q = j2;
                this.r.set(0L);
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    private boolean k() {
        if (this.f21311f.n()) {
            FileDownloadModel fileDownloadModel = this.f21311f;
            fileDownloadModel.z(fileDownloadModel.g());
        } else if (this.f21311f.g() != this.f21311f.k()) {
            o(new FileDownloadGiveUpRetryException(e.h.a.k0.f.o("sofar[%d] not equal total[%d]", Long.valueOf(this.f21311f.g()), Long.valueOf(this.f21311f.k()))));
            return true;
        }
        return false;
    }

    private void v(byte b2) {
        if (b2 == -2) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.f21311f.e()));
                return;
            }
            return;
        }
        com.liulishuo.filedownloader.message.b.a().b(com.liulishuo.filedownloader.message.c.e(b2, this.f21311f, this.f21313h));
    }

    private void w() throws IOException {
        boolean z;
        String j2 = this.f21311f.j();
        String i2 = this.f21311f.i();
        File file = new File(j2);
        try {
            File file2 = new File(i2);
            if (file2.exists()) {
                long length = file2.length();
                if (file2.delete()) {
                    e.h.a.k0.d.i(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", i2, Long.valueOf(length), Long.valueOf(file.length()));
                } else {
                    throw new IOException(e.h.a.k0.f.o("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", i2, Long.valueOf(length)));
                }
            }
            z = !file.renameTo(file2);
            if (!z) {
                if (z && file.exists() && !file.delete()) {
                    e.h.a.k0.d.i(this, "delete the temp file(%s) failed, on completed downloading.", j2);
                    return;
                }
                return;
            }
            try {
                throw new IOException(e.h.a.k0.f.o("Can't rename the  temp downloaded file(%s) to the target file(%s)", j2, i2));
            } catch (Throwable th) {
                th = th;
                if (z && file.exists() && !file.delete()) {
                    e.h.a.k0.d.i(this, "delete the temp file(%s) failed, on completed downloading.", j2);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
    }

    private synchronized void x(Message message) {
        if (!this.n.isAlive()) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.m.sendMessage(message);
        } catch (IllegalStateException e2) {
            if (!this.n.isAlive()) {
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                }
            } else {
                throw e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.n.quit();
            this.p = Thread.currentThread();
            while (this.o) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.p = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        this.o = true;
        int i2 = message.what;
        try {
            if (i2 != 3) {
                if (i2 == 5) {
                    h((Exception) message.obj, message.arg1);
                }
                return true;
            }
            g();
            return true;
        } finally {
            this.o = false;
            if (this.p != null) {
                LockSupport.unpark(this.p);
            }
        }
    }

    public boolean l() {
        HandlerThread handlerThread = this.n;
        return handlerThread != null && handlerThread.isAlive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() throws IOException {
        if (k()) {
            return;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(boolean z, long j2, String str, String str2) throws IllegalArgumentException {
        String b2 = this.f21311f.b();
        if (b2 != null && !b2.equals(str)) {
            throw new IllegalArgumentException(e.h.a.k0.f.o("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, b2));
        }
        this.f21313h.e(z);
        this.f21311f.y((byte) 2);
        this.f21311f.z(j2);
        this.f21311f.s(str);
        this.f21311f.u(str2);
        this.f21312g.m(this.f21311f.e(), j2, str, str2);
        v((byte) 2);
        this.l = a(j2, this.f21316k);
        this.t.compareAndSet(false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Exception exc) {
        e(exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback");
        this.n = handlerThread;
        handlerThread.start();
        this.m = new Handler(this.n.getLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        f();
    }

    public void r() {
        this.f21311f.y((byte) 1);
        this.f21312g.a(this.f21311f.e());
        v((byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(long j2) {
        this.r.addAndGet(j2);
        this.f21311f.m(j2);
        j(SystemClock.elapsedRealtime());
        if (this.m == null) {
            g();
        } else if (this.s.get()) {
            x(this.m.obtainMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Exception exc, int i2) {
        this.r.set(0L);
        Handler handler = this.m;
        if (handler == null) {
            h(exc, i2);
        } else {
            x(handler.obtainMessage(5, i2, 0, exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        this.f21311f.y((byte) 6);
        v((byte) 6);
        this.f21312g.i(this.f21311f.e());
    }
}
