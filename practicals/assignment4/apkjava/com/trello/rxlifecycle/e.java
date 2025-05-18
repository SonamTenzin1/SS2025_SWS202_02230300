package com.trello.rxlifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UntilCorrespondingEventObservableTransformer.java */
/* loaded from: classes2.dex */
public final class e<T, R> implements b<T> {

    /* renamed from: f, reason: collision with root package name */
    final rx.e<R> f20654f;

    /* renamed from: g, reason: collision with root package name */
    final rx.m.e<R, R> f20655g;

    public e(rx.e<R> eVar, rx.m.e<R, R> eVar2) {
        this.f20654f = eVar;
        this.f20655g = eVar2;
    }

    @Override // rx.m.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.e<T> call(rx.e<T> eVar) {
        return eVar.P0(d.a(this.f20654f, this.f20655g));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f20654f.equals(eVar.f20654f)) {
            return this.f20655g.equals(eVar.f20655g);
        }
        return false;
    }

    public int hashCode() {
        return (this.f20654f.hashCode() * 31) + this.f20655g.hashCode();
    }

    public String toString() {
        return "UntilCorrespondingEventObservableTransformer{sharedLifecycle=" + this.f20654f + ", correspondingEvents=" + this.f20655g + '}';
    }
}
