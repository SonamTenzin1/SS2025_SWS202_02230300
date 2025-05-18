package c.c.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import b.b.a.b;

/* compiled from: CustomTabsServiceConnection.java */
/* loaded from: classes.dex */
public abstract class d implements ServiceConnection {

    /* compiled from: CustomTabsServiceConnection.java */
    /* loaded from: classes.dex */
    class a extends b {
        a(b.b.a.b bVar, ComponentName componentName) {
            super(bVar, componentName);
        }
    }

    public abstract void a(ComponentName componentName, b bVar);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a(componentName, new a(b.a.H(iBinder), componentName));
    }
}
