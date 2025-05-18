package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;

/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements i {
    final /* synthetic */ Handler a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f2263b;

    @Override // androidx.lifecycle.i
    public void a(k kVar, g.b bVar) {
        if (bVar == g.b.ON_DESTROY) {
            this.a.removeCallbacks(this.f2263b);
            kVar.getLifecycle().c(this);
        }
    }
}
