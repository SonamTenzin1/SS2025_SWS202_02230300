package com.squareup.moshi;

import com.squareup.moshi.f;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: ArrayJsonAdapter.java */
/* loaded from: classes2.dex */
final class a extends f<Object> {
    public static final f.e a = new C0248a();

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f20537b;

    /* renamed from: c, reason: collision with root package name */
    private final f<Object> f20538c;

    /* compiled from: ArrayJsonAdapter.java */
    /* renamed from: com.squareup.moshi.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0248a implements f.e {
        C0248a() {
        }

        @Override // com.squareup.moshi.f.e
        public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            Type a = u.a(type);
            if (a != null && set.isEmpty()) {
                return new a(u.g(a), rVar.d(a)).nullSafe();
            }
            return null;
        }
    }

    a(Class<?> cls, f<Object> fVar) {
        this.f20537b = cls;
        this.f20538c = fVar;
    }

    @Override // com.squareup.moshi.f
    public Object fromJson(i iVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        iVar.a();
        while (iVar.f()) {
            arrayList.add(this.f20538c.fromJson(iVar));
        }
        iVar.c();
        Object newInstance = Array.newInstance(this.f20537b, arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    @Override // com.squareup.moshi.f
    public void toJson(o oVar, Object obj) throws IOException {
        oVar.a();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f20538c.toJson(oVar, (o) Array.get(obj, i2));
        }
        oVar.d();
    }

    public String toString() {
        return this.f20538c + ".array()";
    }
}
