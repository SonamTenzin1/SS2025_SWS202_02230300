package com.bumptech.glide.r;

/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class i {
    private Class<?> a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f9554b;

    /* renamed from: c, reason: collision with root package name */
    private Class<?> f9555c;

    public i() {
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.a = cls;
        this.f9554b = cls2;
        this.f9555c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.a.equals(iVar.a) && this.f9554b.equals(iVar.f9554b) && k.d(this.f9555c, iVar.f9555c);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.f9554b.hashCode()) * 31;
        Class<?> cls = this.f9555c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.f9554b + '}';
    }

    public i(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
