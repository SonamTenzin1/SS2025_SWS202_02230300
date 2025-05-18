package com.google.firebase.components;

import com.google.firebase.s.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionalProvider.java */
/* loaded from: classes2.dex */
public class z<T> implements com.google.firebase.s.b<T>, com.google.firebase.s.a<T> {
    private static final a.InterfaceC0234a<Object> a = new a.InterfaceC0234a() { // from class: com.google.firebase.components.k
        @Override // com.google.firebase.s.a.InterfaceC0234a
        public final void a(com.google.firebase.s.b bVar) {
            z.c(bVar);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static final com.google.firebase.s.b<Object> f18920b = new com.google.firebase.s.b() { // from class: com.google.firebase.components.j
        @Override // com.google.firebase.s.b
        public final Object get() {
            z.d();
            return null;
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private a.InterfaceC0234a<T> f18921c;

    /* renamed from: d, reason: collision with root package name */
    private volatile com.google.firebase.s.b<T> f18922d;

    private z(a.InterfaceC0234a<T> interfaceC0234a, com.google.firebase.s.b<T> bVar) {
        this.f18921c = interfaceC0234a;
        this.f18922d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> z<T> b() {
        return new z<>(a, f18920b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(com.google.firebase.s.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object d() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(a.InterfaceC0234a interfaceC0234a, a.InterfaceC0234a interfaceC0234a2, com.google.firebase.s.b bVar) {
        interfaceC0234a.a(bVar);
        interfaceC0234a2.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> z<T> f(com.google.firebase.s.b<T> bVar) {
        return new z<>(null, bVar);
    }

    @Override // com.google.firebase.s.a
    public void a(final a.InterfaceC0234a<T> interfaceC0234a) {
        com.google.firebase.s.b<T> bVar;
        com.google.firebase.s.b<T> bVar2 = this.f18922d;
        com.google.firebase.s.b<Object> bVar3 = f18920b;
        if (bVar2 != bVar3) {
            interfaceC0234a.a(bVar2);
            return;
        }
        com.google.firebase.s.b<T> bVar4 = null;
        synchronized (this) {
            bVar = this.f18922d;
            if (bVar != bVar3) {
                bVar4 = bVar;
            } else {
                final a.InterfaceC0234a<T> interfaceC0234a2 = this.f18921c;
                this.f18921c = new a.InterfaceC0234a() { // from class: com.google.firebase.components.l
                    @Override // com.google.firebase.s.a.InterfaceC0234a
                    public final void a(com.google.firebase.s.b bVar5) {
                        z.e(a.InterfaceC0234a.this, interfaceC0234a, bVar5);
                    }
                };
            }
        }
        if (bVar4 != null) {
            interfaceC0234a.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(com.google.firebase.s.b<T> bVar) {
        a.InterfaceC0234a<T> interfaceC0234a;
        if (this.f18922d == f18920b) {
            synchronized (this) {
                interfaceC0234a = this.f18921c;
                this.f18921c = null;
                this.f18922d = bVar;
            }
            interfaceC0234a.a(bVar);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }

    @Override // com.google.firebase.s.b
    public T get() {
        return this.f18922d.get();
    }
}
