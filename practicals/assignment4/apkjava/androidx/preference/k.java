package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
@Deprecated
/* loaded from: classes.dex */
public class k extends androidx.recyclerview.widget.o {

    /* renamed from: f, reason: collision with root package name */
    final RecyclerView f1858f;

    /* renamed from: g, reason: collision with root package name */
    final androidx.core.view.a f1859g;

    /* renamed from: h, reason: collision with root package name */
    final androidx.core.view.a f1860h;

    /* compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
    /* loaded from: classes.dex */
    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.d0.c cVar) {
            Preference j2;
            k.this.f1859g.g(view, cVar);
            int childAdapterPosition = k.this.f1858f.getChildAdapterPosition(view);
            RecyclerView.g adapter = k.this.f1858f.getAdapter();
            if ((adapter instanceof h) && (j2 = ((h) adapter).j(childAdapterPosition)) != null) {
                j2.p0(cVar);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i2, Bundle bundle) {
            return k.this.f1859g.j(view, i2, bundle);
        }
    }

    public k(RecyclerView recyclerView) {
        super(recyclerView);
        this.f1859g = super.n();
        this.f1860h = new a();
        this.f1858f = recyclerView;
    }

    @Override // androidx.recyclerview.widget.o
    public androidx.core.view.a n() {
        return this.f1860h;
    }
}
