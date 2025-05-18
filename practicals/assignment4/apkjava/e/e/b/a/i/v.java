package e.e.b.a.i;

import android.content.Context;
import e.e.b.a.i.b0.j.j0;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransportRuntimeComponent.java */
@Singleton
/* loaded from: classes2.dex */
public abstract class v implements Closeable {

    /* compiled from: TransportRuntimeComponent.java */
    /* loaded from: classes2.dex */
    interface a {
        a a(Context context);

        v c();
    }

    abstract j0 a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract u b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a().close();
    }
}
