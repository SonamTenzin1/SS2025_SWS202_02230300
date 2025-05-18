package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;

/* loaded from: classes.dex */
final class SavedStateHandleController implements i {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1742b = false;

    /* renamed from: c, reason: collision with root package name */
    private final u f1743c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements SavedStateRegistry.a {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.a
        public void a(androidx.savedstate.c cVar) {
            if (cVar instanceof a0) {
                z viewModelStore = ((a0) cVar).getViewModelStore();
                SavedStateRegistry savedStateRegistry = cVar.getSavedStateRegistry();
                Iterator<String> it = viewModelStore.c().iterator();
                while (it.hasNext()) {
                    SavedStateHandleController.b(viewModelStore.b(it.next()), savedStateRegistry, cVar.getLifecycle());
                }
                if (viewModelStore.c().isEmpty()) {
                    return;
                }
                savedStateRegistry.e(a.class);
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    SavedStateHandleController(String str, u uVar) {
        this.a = str;
        this.f1743c = uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(x xVar, SavedStateRegistry savedStateRegistry, g gVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) xVar.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.f()) {
            return;
        }
        savedStateHandleController.c(savedStateRegistry, gVar);
        g(savedStateRegistry, gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SavedStateHandleController d(SavedStateRegistry savedStateRegistry, g gVar, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, u.a(savedStateRegistry.a(str), bundle));
        savedStateHandleController.c(savedStateRegistry, gVar);
        g(savedStateRegistry, gVar);
        return savedStateHandleController;
    }

    private static void g(final SavedStateRegistry savedStateRegistry, final g gVar) {
        g.c b2 = gVar.b();
        if (b2 != g.c.INITIALIZED && !b2.g(g.c.STARTED)) {
            gVar.a(new i() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // androidx.lifecycle.i
                public void a(k kVar, g.b bVar) {
                    if (bVar == g.b.ON_START) {
                        g.this.c(this);
                        savedStateRegistry.e(a.class);
                    }
                }
            });
        } else {
            savedStateRegistry.e(a.class);
        }
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, g.b bVar) {
        if (bVar == g.b.ON_DESTROY) {
            this.f1742b = false;
            kVar.getLifecycle().c(this);
        }
    }

    void c(SavedStateRegistry savedStateRegistry, g gVar) {
        if (!this.f1742b) {
            this.f1742b = true;
            gVar.a(this);
            savedStateRegistry.d(this.a, this.f1743c.b());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u e() {
        return this.f1743c;
    }

    boolean f() {
        return this.f1742b;
    }
}
