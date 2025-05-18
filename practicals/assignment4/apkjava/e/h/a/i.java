package e.h.a;

/* compiled from: FileDownloadListener.java */
/* loaded from: classes2.dex */
public abstract class i {
    public i() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void blockComplete(a aVar) throws Throwable {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void completed(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void connected(a aVar, String str, boolean z, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void error(a aVar, Throwable th);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isInvalid() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void paused(a aVar, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void pending(a aVar, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void progress(a aVar, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void retry(a aVar, Throwable th, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void started(a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void warn(a aVar);

    public i(int i2) {
        e.h.a.k0.d.i(this, "not handle priority any more", new Object[0]);
    }
}
