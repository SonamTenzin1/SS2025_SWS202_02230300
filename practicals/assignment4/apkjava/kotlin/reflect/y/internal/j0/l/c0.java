package kotlin.reflect.y.internal.j0.l;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;

/* compiled from: TypeSubstitution.kt */
/* loaded from: classes3.dex */
public final class c0 extends j1 {

    /* renamed from: c, reason: collision with root package name */
    private final e1[] f24678c;

    /* renamed from: d, reason: collision with root package name */
    private final g1[] f24679d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f24680e;

    public /* synthetic */ c0(e1[] e1VarArr, g1[] g1VarArr, boolean z, int i2, g gVar) {
        this(e1VarArr, g1VarArr, (i2 & 4) != 0 ? false : z);
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public boolean b() {
        return this.f24680e;
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public g1 e(e0 e0Var) {
        m.f(e0Var, RoomNotification.KEY);
        h c2 = e0Var.O0().c();
        e1 e1Var = c2 instanceof e1 ? (e1) c2 : null;
        if (e1Var == null) {
            return null;
        }
        int g2 = e1Var.g();
        e1[] e1VarArr = this.f24678c;
        if (g2 >= e1VarArr.length || !m.a(e1VarArr[g2].h(), e1Var.h())) {
            return null;
        }
        return this.f24679d[g2];
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public boolean f() {
        return this.f24679d.length == 0;
    }

    public final g1[] i() {
        return this.f24679d;
    }

    public final e1[] j() {
        return this.f24678c;
    }

    public c0(e1[] e1VarArr, g1[] g1VarArr, boolean z) {
        m.f(e1VarArr, "parameters");
        m.f(g1VarArr, "arguments");
        this.f24678c = e1VarArr;
        this.f24679d = g1VarArr;
        this.f24680e = z;
        int length = e1VarArr.length;
        int length2 = g1VarArr.length;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c0(List<? extends e1> list, List<? extends g1> list2) {
        this(r3, (g1[]) r9, false, 4, null);
        m.f(list, "parameters");
        m.f(list2, "argumentsList");
        Object[] array = list.toArray(new e1[0]);
        m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        e1[] e1VarArr = (e1[]) array;
        Object[] array2 = list2.toArray(new g1[0]);
        m.d(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
