package com.google.firebase.w;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.components.p;
import com.google.firebase.components.r;
import com.google.firebase.components.s;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ComponentMonitor.java */
/* loaded from: classes2.dex */
public class b implements s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object b(String str, n nVar, p pVar) {
        try {
            c.b(str);
            return nVar.f().a(pVar);
        } finally {
            c.a();
        }
    }

    @Override // com.google.firebase.components.s
    public List<n<?>> a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final n<?> nVar : componentRegistrar.getComponents()) {
            final String g2 = nVar.g();
            if (g2 != null) {
                nVar = nVar.r(new r() { // from class: com.google.firebase.w.a
                    @Override // com.google.firebase.components.r
                    public final Object a(p pVar) {
                        return b.b(g2, nVar, pVar);
                    }
                });
            }
            arrayList.add(nVar);
        }
        return arrayList;
    }
}
