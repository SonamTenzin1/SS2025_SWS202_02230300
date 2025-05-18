package e.h.a;

/* compiled from: FileDownloadLargeFileListener.java */
/* loaded from: classes2.dex */
public abstract class g extends i {
    public g() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.h.a.i
    public void connected(a aVar, String str, boolean z, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void connected(a aVar, String str, boolean z, long j2, long j3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.h.a.i
    public void paused(a aVar, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void paused(a aVar, long j2, long j3);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.h.a.i
    public void pending(a aVar, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void pending(a aVar, long j2, long j3);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.h.a.i
    public void progress(a aVar, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void progress(a aVar, long j2, long j3);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.h.a.i
    public void retry(a aVar, Throwable th, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void retry(a aVar, Throwable th, int i2, long j2) {
    }

    public g(int i2) {
        super(i2);
    }
}
