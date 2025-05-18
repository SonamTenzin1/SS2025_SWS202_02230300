package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.g;

/* compiled from: SavedStateRegistryController.java */
/* loaded from: classes.dex */
public final class b {
    private final c a;

    /* renamed from: b, reason: collision with root package name */
    private final SavedStateRegistry f2236b = new SavedStateRegistry();

    private b(c cVar) {
        this.a = cVar;
    }

    public static b a(c cVar) {
        return new b(cVar);
    }

    public SavedStateRegistry b() {
        return this.f2236b;
    }

    public void c(Bundle bundle) {
        g lifecycle = this.a.getLifecycle();
        if (lifecycle.b() == g.c.INITIALIZED) {
            lifecycle.a(new Recreator(this.a));
            this.f2236b.b(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void d(Bundle bundle) {
        this.f2236b.c(bundle);
    }
}
