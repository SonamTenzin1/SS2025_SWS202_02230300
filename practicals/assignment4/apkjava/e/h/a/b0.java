package e.h.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import java.io.File;

/* compiled from: PauseAllMarker.java */
/* loaded from: classes2.dex */
public class b0 implements Handler.Callback {

    /* renamed from: f, reason: collision with root package name */
    private static File f21214f;

    /* renamed from: g, reason: collision with root package name */
    private static final Long f21215g = 1000L;

    /* renamed from: h, reason: collision with root package name */
    private HandlerThread f21216h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f21217i;

    /* renamed from: j, reason: collision with root package name */
    private final e.h.a.i0.b f21218j;

    public b0(e.h.a.i0.b bVar) {
        this.f21218j = bVar;
    }

    public static void a() {
        File c2 = c();
        if (c2.exists()) {
            e.h.a.k0.d.a(b0.class, "delete marker file " + c2.delete(), new Object[0]);
        }
    }

    private static boolean b() {
        return c().exists();
    }

    private static File c() {
        if (f21214f == null) {
            f21214f = new File(e.h.a.k0.c.a().getCacheDir() + File.separator + ".filedownloader_pause_all_marker.b");
        }
        return f21214f;
    }

    public void d() {
        HandlerThread handlerThread = new HandlerThread("PauseAllChecker");
        this.f21216h = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.f21216h.getLooper(), this);
        this.f21217i = handler;
        handler.sendEmptyMessageDelayed(0, f21215g.longValue());
    }

    public void e() {
        this.f21217i.removeMessages(0);
        this.f21216h.quit();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            if (b()) {
                try {
                    this.f21218j.Y6();
                } catch (RemoteException e2) {
                    e.h.a.k0.d.c(this, e2, "pause all failed", new Object[0]);
                }
            }
            this.f21217i.sendEmptyMessageDelayed(0, f21215g.longValue());
            return true;
        } finally {
            a();
        }
    }
}
