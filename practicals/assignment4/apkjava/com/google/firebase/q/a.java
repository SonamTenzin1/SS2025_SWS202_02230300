package com.google.firebase.q;

/* compiled from: Event.java */
/* loaded from: classes2.dex */
public class a<T> {
    private final Class<T> a;

    /* renamed from: b, reason: collision with root package name */
    private final T f19889b;

    public T a() {
        return this.f19889b;
    }

    public Class<T> b() {
        return this.a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.a, this.f19889b);
    }
}
