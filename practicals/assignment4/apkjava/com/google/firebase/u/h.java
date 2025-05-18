package com.google.firebase.u;

import android.content.Context;
import com.google.firebase.components.n;
import com.google.firebase.components.p;
import com.google.firebase.components.r;
import com.google.firebase.components.v;

/* compiled from: LibraryVersionComponent.java */
/* loaded from: classes2.dex */
public class h {

    /* compiled from: LibraryVersionComponent.java */
    /* loaded from: classes2.dex */
    public interface a<T> {
        String a(T t);
    }

    public static n<?> a(String str, String str2) {
        return n.j(g.a(str, str2), g.class);
    }

    public static n<?> b(final String str, final a<Context> aVar) {
        return n.k(g.class).b(v.k(Context.class)).f(new r() { // from class: com.google.firebase.u.b
            @Override // com.google.firebase.components.r
            public final Object a(p pVar) {
                g a2;
                a2 = g.a(str, aVar.a((Context) pVar.a(Context.class)));
                return a2;
            }
        }).d();
    }
}
