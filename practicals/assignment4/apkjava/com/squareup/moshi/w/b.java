package com.squareup.moshi.w;

import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.o;
import java.io.IOException;

/* compiled from: NullSafeJsonAdapter.java */
/* loaded from: classes2.dex */
public final class b<T> extends f<T> {
    private final f<T> a;

    public b(f<T> fVar) {
        this.a = fVar;
    }

    @Override // com.squareup.moshi.f
    public T fromJson(i iVar) throws IOException {
        if (iVar.A() == i.b.NULL) {
            return (T) iVar.x();
        }
        return this.a.fromJson(iVar);
    }

    @Override // com.squareup.moshi.f
    public void toJson(o oVar, T t) throws IOException {
        if (t == null) {
            oVar.m();
        } else {
            this.a.toJson(oVar, (o) t);
        }
    }

    public String toString() {
        return this.a + ".nullSafe()";
    }
}
