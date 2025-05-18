package com.google.gson.t.n;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes2.dex */
public final class g implements r {

    /* renamed from: f, reason: collision with root package name */
    private final com.google.gson.t.c f20234f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f20235g;

    /* compiled from: MapTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    private final class a<K, V> extends q<Map<K, V>> {
        private final q<K> a;

        /* renamed from: b, reason: collision with root package name */
        private final q<V> f20236b;

        /* renamed from: c, reason: collision with root package name */
        private final com.google.gson.t.i<? extends Map<K, V>> f20237c;

        public a(com.google.gson.e eVar, Type type, q<K> qVar, Type type2, q<V> qVar2, com.google.gson.t.i<? extends Map<K, V>> iVar) {
            this.a = new m(eVar, qVar, type);
            this.f20236b = new m(eVar, qVar2, type2);
            this.f20237c = iVar;
        }

        private String e(com.google.gson.j jVar) {
            if (jVar.o()) {
                com.google.gson.m g2 = jVar.g();
                if (g2.z()) {
                    return String.valueOf(g2.v());
                }
                if (g2.x()) {
                    return Boolean.toString(g2.q());
                }
                if (g2.C()) {
                    return g2.w();
                }
                throw new AssertionError();
            }
            if (jVar.i()) {
                return "null";
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b Q = aVar.Q();
            if (Q == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            Map<K, V> a = this.f20237c.a();
            if (Q == com.google.gson.stream.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.l()) {
                    aVar.a();
                    K b2 = this.a.b(aVar);
                    if (a.put(b2, this.f20236b.b(aVar)) == null) {
                        aVar.f();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + b2);
                    }
                }
                aVar.f();
            } else {
                aVar.b();
                while (aVar.l()) {
                    com.google.gson.t.f.a.a(aVar);
                    K b3 = this.a.b(aVar);
                    if (a.put(b3, this.f20236b.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b3);
                    }
                }
                aVar.j();
            }
            return a;
        }

        @Override // com.google.gson.q
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.y();
                return;
            }
            if (!g.this.f20235g) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.p(String.valueOf(entry.getKey()));
                    this.f20236b.d(cVar, entry.getValue());
                }
                cVar.j();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i2 = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                com.google.gson.j c2 = this.a.c(entry2.getKey());
                arrayList.add(c2);
                arrayList2.add(entry2.getValue());
                z |= c2.h() || c2.n();
            }
            if (z) {
                cVar.c();
                int size = arrayList.size();
                while (i2 < size) {
                    cVar.c();
                    com.google.gson.t.l.b((com.google.gson.j) arrayList.get(i2), cVar);
                    this.f20236b.d(cVar, arrayList2.get(i2));
                    cVar.f();
                    i2++;
                }
                cVar.f();
                return;
            }
            cVar.d();
            int size2 = arrayList.size();
            while (i2 < size2) {
                cVar.p(e((com.google.gson.j) arrayList.get(i2)));
                this.f20236b.d(cVar, arrayList2.get(i2));
                i2++;
            }
            cVar.j();
        }
    }

    public g(com.google.gson.t.c cVar, boolean z) {
        this.f20234f = cVar;
        this.f20235g = z;
    }

    private q<?> a(com.google.gson.e eVar, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return eVar.j(com.google.gson.u.a.get(type));
        }
        return n.f20269f;
    }

    @Override // com.google.gson.r
    public <T> q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] j2 = com.google.gson.t.b.j(type, com.google.gson.t.b.k(type));
        return new a(eVar, j2[0], a(eVar, j2[0]), j2[1], eVar.j(com.google.gson.u.a.get(j2[1])), this.f20234f.a(aVar));
    }
}
