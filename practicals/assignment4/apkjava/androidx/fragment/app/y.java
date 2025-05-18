package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentViewLifecycleOwner.java */
/* loaded from: classes.dex */
public class y implements androidx.savedstate.c {

    /* renamed from: f, reason: collision with root package name */
    private androidx.lifecycle.l f1712f = null;

    /* renamed from: g, reason: collision with root package name */
    private androidx.savedstate.b f1713g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.b bVar) {
        this.f1712f.h(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f1712f == null) {
            this.f1712f = new androidx.lifecycle.l(this);
            this.f1713g = androidx.savedstate.b.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f1712f != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Bundle bundle) {
        this.f1713g.c(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Bundle bundle) {
        this.f1713g.d(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(g.c cVar) {
        this.f1712f.o(cVar);
    }

    @Override // androidx.lifecycle.k
    public androidx.lifecycle.g getLifecycle() {
        b();
        return this.f1712f;
    }

    @Override // androidx.savedstate.c
    public SavedStateRegistry getSavedStateRegistry() {
        return this.f1713g.b();
    }
}
