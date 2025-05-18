package io.sentry.internal.modules;

import io.sentry.w1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: CompositeModulesLoader.java */
@ApiStatus.Internal
@ApiStatus.Experimental
/* loaded from: classes2.dex */
public final class a extends d {

    /* renamed from: d, reason: collision with root package name */
    private final List<b> f22443d;

    public a(List<b> list, w1 w1Var) {
        super(w1Var);
        this.f22443d = list;
    }

    @Override // io.sentry.internal.modules.d
    protected Map<String, String> b() {
        TreeMap treeMap = new TreeMap();
        Iterator<b> it = this.f22443d.iterator();
        while (it.hasNext()) {
            Map<String, String> a = it.next().a();
            if (a != null) {
                treeMap.putAll(a);
            }
        }
        return treeMap;
    }
}
