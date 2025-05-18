package com.bumptech.glide.o;

import com.bumptech.glide.load.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry.java */
/* loaded from: classes.dex */
public class f {
    private final List<a<?>> a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceEncoderRegistry.java */
    /* loaded from: classes.dex */
    public static final class a<T> {
        private final Class<T> a;

        /* renamed from: b, reason: collision with root package name */
        final k<T> f9483b;

        a(Class<T> cls, k<T> kVar) {
            this.a = cls;
            this.f9483b = kVar;
        }

        boolean a(Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, k<Z> kVar) {
        this.a.add(new a<>(cls, kVar));
    }

    public synchronized <Z> k<Z> b(Class<Z> cls) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a<?> aVar = this.a.get(i2);
            if (aVar.a(cls)) {
                return (k<Z>) aVar.f9483b;
            }
        }
        return null;
    }
}
