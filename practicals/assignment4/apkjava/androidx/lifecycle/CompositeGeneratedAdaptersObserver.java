package androidx.lifecycle;

import androidx.lifecycle.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements i {
    private final f[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(f[] fVarArr) {
        this.a = fVarArr;
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, g.b bVar) {
        p pVar = new p();
        for (f fVar : this.a) {
            fVar.a(kVar, bVar, false, pVar);
        }
        for (f fVar2 : this.a) {
            fVar2.a(kVar, bVar, true, pVar);
        }
    }
}
