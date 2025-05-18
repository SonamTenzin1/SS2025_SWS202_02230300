package kotlin.reflect.y.internal.j0.d.a.n0;

import kotlin.collections.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.c;

/* compiled from: javaLoading.kt */
/* loaded from: classes2.dex */
public final class p {
    private static final boolean a(r rVar) {
        c d2;
        b0 b0Var = (b0) s.u0(rVar.f());
        x type = b0Var != null ? b0Var.getType() : null;
        j jVar = type instanceof j ? (j) type : null;
        if (jVar == null) {
            return false;
        }
        i c2 = jVar.c();
        return (c2 instanceof g) && (d2 = ((g) c2).d()) != null && m.a(d2.b(), "java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return r3.f().isEmpty();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r0.equals("toString") != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r0.equals("hashCode") == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean b(r rVar) {
        String k2 = rVar.getName().k();
        int hashCode = k2.hashCode();
        if (hashCode != -1776922004) {
            if (hashCode != -1295482945) {
                if (hashCode == 147696667) {
                }
            } else if (k2.equals("equals")) {
                return a(rVar);
            }
            return false;
        }
    }

    public static final boolean c(q qVar) {
        m.f(qVar, "<this>");
        return qVar.P().H() && (qVar instanceof r) && b((r) qVar);
    }
}
