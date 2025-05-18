package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ViewModelStore.java */
/* loaded from: classes.dex */
public class z {
    private final HashMap<String, x> a = new HashMap<>();

    public final void a() {
        Iterator<x> it = this.a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final x b(String str) {
        return this.a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> c() {
        return new HashSet(this.a.keySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str, x xVar) {
        x put = this.a.put(str, xVar);
        if (put != null) {
            put.d();
        }
    }
}
