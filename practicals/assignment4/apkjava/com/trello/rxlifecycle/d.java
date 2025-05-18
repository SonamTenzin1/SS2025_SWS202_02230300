package com.trello.rxlifecycle;

/* compiled from: TakeUntilGenerator.java */
/* loaded from: classes2.dex */
final class d {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: TakeUntilGenerator.java */
    /* loaded from: classes2.dex */
    static class a<T> implements rx.m.e<T, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f20653f;

        a(Object obj) {
            this.f20653f = obj;
        }

        @Override // rx.m.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(T t) {
            return Boolean.valueOf(t.equals(this.f20653f));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: TakeUntilGenerator.java */
    /* loaded from: classes2.dex */
    static class b<T> implements rx.m.f<T, T, Boolean> {
        b() {
        }

        @Override // rx.m.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(T t, T t2) {
            return Boolean.valueOf(t2.equals(t));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> rx.e<Boolean> a(rx.e<T> eVar, rx.m.e<T, T> eVar2) {
        return rx.e.e(eVar.N0(1).X(eVar2), eVar.y0(1), new b()).p0(com.trello.rxlifecycle.a.a).O0(com.trello.rxlifecycle.a.f20651b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> rx.e<T> b(rx.e<T> eVar, T t) {
        return eVar.O0(new a(t));
    }
}
