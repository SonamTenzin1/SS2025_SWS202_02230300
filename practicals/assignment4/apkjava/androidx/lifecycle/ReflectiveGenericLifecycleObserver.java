package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements i {
    private final Object a;

    /* renamed from: b, reason: collision with root package name */
    private final b.a f1741b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.f1741b = b.a.c(obj.getClass());
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, g.b bVar) {
        this.f1741b.a(kVar, bVar, this.a);
    }
}
