package com.bumptech.glide.load.m;

import com.bumptech.glide.load.m.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry.java */
/* loaded from: classes.dex */
public class f {
    private static final e.a<?> a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f9267b = new HashMap();

    /* compiled from: DataRewinderRegistry.java */
    /* loaded from: classes.dex */
    class a implements e.a<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.m.e.a
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.m.e.a
        public e<Object> b(Object obj) {
            return new b(obj);
        }
    }

    /* compiled from: DataRewinderRegistry.java */
    /* loaded from: classes.dex */
    private static final class b implements e<Object> {
        private final Object a;

        b(Object obj) {
            this.a = obj;
        }

        @Override // com.bumptech.glide.load.m.e
        public Object a() {
            return this.a;
        }

        @Override // com.bumptech.glide.load.m.e
        public void b() {
        }
    }

    public synchronized <T> e<T> a(T t) {
        e.a<?> aVar;
        com.bumptech.glide.r.j.d(t);
        aVar = this.f9267b.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f9267b.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = a;
        }
        return (e<T>) aVar.b(t);
    }

    public synchronized void b(e.a<?> aVar) {
        this.f9267b.put(aVar.a(), aVar);
    }
}
