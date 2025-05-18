package androidx.lifecycle;

import androidx.lifecycle.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements i {
    private final f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleGeneratedAdapterObserver(f fVar) {
        this.a = fVar;
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, g.b bVar) {
        this.a.a(kVar, bVar, false, null);
        this.a.a(kVar, bVar, true, null);
    }
}
