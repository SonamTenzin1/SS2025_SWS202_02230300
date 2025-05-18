package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    private final Runnable a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayDeque<b> f83b = new ArrayDeque<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LifecycleOnBackPressedCancellable implements i, androidx.activity.a {
        private final g a;

        /* renamed from: b, reason: collision with root package name */
        private final b f84b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.activity.a f85c;

        LifecycleOnBackPressedCancellable(g gVar, b bVar) {
            this.a = gVar;
            this.f84b = bVar;
            gVar.a(this);
        }

        @Override // androidx.lifecycle.i
        public void a(k kVar, g.b bVar) {
            if (bVar == g.b.ON_START) {
                this.f85c = OnBackPressedDispatcher.this.b(this.f84b);
                return;
            }
            if (bVar == g.b.ON_STOP) {
                androidx.activity.a aVar = this.f85c;
                if (aVar != null) {
                    aVar.cancel();
                    return;
                }
                return;
            }
            if (bVar == g.b.ON_DESTROY) {
                cancel();
            }
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.a.c(this);
            this.f84b.e(this);
            androidx.activity.a aVar = this.f85c;
            if (aVar != null) {
                aVar.cancel();
                this.f85c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.activity.a {
        private final b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f83b.remove(this.a);
            this.a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    public void a(k kVar, b bVar) {
        g lifecycle = kVar.getLifecycle();
        if (lifecycle.b() == g.c.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(lifecycle, bVar));
    }

    androidx.activity.a b(b bVar) {
        this.f83b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator<b> descendingIterator = this.f83b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
