package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentLifecycleCallbacksDispatcher.java */
/* loaded from: classes.dex */
public class l {
    private final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final FragmentManager f1622b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentLifecycleCallbacksDispatcher.java */
    /* loaded from: classes.dex */
    public static final class a {
        final FragmentManager.m a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f1623b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FragmentManager fragmentManager) {
        this.f1622b = fragmentManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().a(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment, boolean z) {
        this.f1622b.w0().f();
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().b(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().c(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().d(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().e(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().f(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Fragment fragment, boolean z) {
        this.f1622b.w0().f();
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().g(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment, Bundle bundle, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().h(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Fragment fragment, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().i(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Fragment fragment, Bundle bundle, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().j(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().k(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Fragment fragment, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().l(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Fragment fragment, boolean z) {
        Fragment z0 = this.f1622b.z0();
        if (z0 != null) {
            z0.getParentFragmentManager().y0().n(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1623b) {
                FragmentManager.m mVar = next.a;
                throw null;
            }
        }
    }
}
