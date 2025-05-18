package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.u.b;
import java.io.IOException;
import java.util.Map;

/* compiled from: ExtensionSchema.java */
/* loaded from: classes.dex */
abstract class q<T extends u.b<T>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a(Map.Entry<?, ?> entry);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object b(p pVar, q0 q0Var, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract u<T> c(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract u<T> d(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean e(q0 q0Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <UT, UB> UB g(e1 e1Var, Object obj, p pVar, u<T> uVar, UB ub, l1<UT, UB> l1Var) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void h(e1 e1Var, Object obj, p pVar, u<T> uVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void i(h hVar, Object obj, p pVar, u<T> uVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void j(s1 s1Var, Map.Entry<?, ?> entry) throws IOException;
}
