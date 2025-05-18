package com.squareup.moshi;

import com.squareup.moshi.i;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

/* compiled from: JsonAdapter.java */
/* loaded from: classes2.dex */
public abstract class f<T> {

    /* compiled from: JsonAdapter.java */
    /* loaded from: classes2.dex */
    class a extends f<T> {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        @Override // com.squareup.moshi.f
        public T fromJson(i iVar) throws IOException {
            return (T) this.a.fromJson(iVar);
        }

        @Override // com.squareup.moshi.f
        boolean isLenient() {
            return this.a.isLenient();
        }

        @Override // com.squareup.moshi.f
        public void toJson(o oVar, T t) throws IOException {
            boolean j2 = oVar.j();
            oVar.H(true);
            try {
                this.a.toJson(oVar, (o) t);
            } finally {
                oVar.H(j2);
            }
        }

        public String toString() {
            return this.a + ".serializeNulls()";
        }
    }

    /* compiled from: JsonAdapter.java */
    /* loaded from: classes2.dex */
    class b extends f<T> {
        final /* synthetic */ f a;

        b(f fVar) {
            this.a = fVar;
        }

        @Override // com.squareup.moshi.f
        public T fromJson(i iVar) throws IOException {
            boolean j2 = iVar.j();
            iVar.K(true);
            try {
                return (T) this.a.fromJson(iVar);
            } finally {
                iVar.K(j2);
            }
        }

        @Override // com.squareup.moshi.f
        boolean isLenient() {
            return true;
        }

        @Override // com.squareup.moshi.f
        public void toJson(o oVar, T t) throws IOException {
            boolean k2 = oVar.k();
            oVar.D(true);
            try {
                this.a.toJson(oVar, (o) t);
            } finally {
                oVar.D(k2);
            }
        }

        public String toString() {
            return this.a + ".lenient()";
        }
    }

    /* compiled from: JsonAdapter.java */
    /* loaded from: classes2.dex */
    class c extends f<T> {
        final /* synthetic */ f a;

        c(f fVar) {
            this.a = fVar;
        }

        @Override // com.squareup.moshi.f
        public T fromJson(i iVar) throws IOException {
            boolean e2 = iVar.e();
            iVar.J(true);
            try {
                return (T) this.a.fromJson(iVar);
            } finally {
                iVar.J(e2);
            }
        }

        @Override // com.squareup.moshi.f
        boolean isLenient() {
            return this.a.isLenient();
        }

        @Override // com.squareup.moshi.f
        public void toJson(o oVar, T t) throws IOException {
            this.a.toJson(oVar, (o) t);
        }

        public String toString() {
            return this.a + ".failOnUnknown()";
        }
    }

    /* compiled from: JsonAdapter.java */
    /* loaded from: classes2.dex */
    class d extends f<T> {
        final /* synthetic */ f a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f20554b;

        d(f fVar, String str) {
            this.a = fVar;
            this.f20554b = str;
        }

        @Override // com.squareup.moshi.f
        public T fromJson(i iVar) throws IOException {
            return (T) this.a.fromJson(iVar);
        }

        @Override // com.squareup.moshi.f
        boolean isLenient() {
            return this.a.isLenient();
        }

        @Override // com.squareup.moshi.f
        public void toJson(o oVar, T t) throws IOException {
            String f2 = oVar.f();
            oVar.B(this.f20554b);
            try {
                this.a.toJson(oVar, (o) t);
            } finally {
                oVar.B(f2);
            }
        }

        public String toString() {
            return this.a + ".indent(\"" + this.f20554b + "\")";
        }
    }

    /* compiled from: JsonAdapter.java */
    /* loaded from: classes2.dex */
    public interface e {
        f<?> a(Type type, Set<? extends Annotation> set, r rVar);
    }

    public final f<T> failOnUnknown() {
        return new c(this);
    }

    public abstract T fromJson(i iVar) throws IOException;

    public final T fromJson(j.h hVar) throws IOException {
        return fromJson(i.z(hVar));
    }

    public final T fromJsonValue(Object obj) {
        try {
            return fromJson(new m(obj));
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public f<T> indent(String str) {
        if (str != null) {
            return new d(this, str);
        }
        throw new NullPointerException("indent == null");
    }

    boolean isLenient() {
        return false;
    }

    public final f<T> lenient() {
        return new b(this);
    }

    public final f<T> nonNull() {
        return this instanceof com.squareup.moshi.w.a ? this : new com.squareup.moshi.w.a(this);
    }

    public final f<T> nullSafe() {
        return this instanceof com.squareup.moshi.w.b ? this : new com.squareup.moshi.w.b(this);
    }

    public final f<T> serializeNulls() {
        return new a(this);
    }

    public abstract void toJson(o oVar, T t) throws IOException;

    public final void toJson(j.g gVar, T t) throws IOException {
        toJson(o.p(gVar), (o) t);
    }

    public final Object toJsonValue(T t) {
        n nVar = new n();
        try {
            toJson((o) nVar, (n) t);
            return nVar.W();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final T fromJson(String str) throws IOException {
        i z = i.z(new j.f().r0(str));
        T fromJson = fromJson(z);
        if (isLenient() || z.A() == i.b.END_DOCUMENT) {
            return fromJson;
        }
        throw new JsonDataException("JSON document was not fully consumed.");
    }

    public final String toJson(T t) {
        j.f fVar = new j.f();
        try {
            toJson((j.g) fVar, (j.f) t);
            return fVar.T();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
