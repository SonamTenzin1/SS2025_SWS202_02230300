package kotlin.reflect.y.internal.j0.e.z;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.o;
import kotlin.reflect.y.internal.j0.e.p;

/* compiled from: NameResolverImpl.kt */
/* loaded from: classes3.dex */
public final class d implements c {
    private final p a;

    /* renamed from: b, reason: collision with root package name */
    private final o f24194b;

    /* compiled from: NameResolverImpl.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[o.c.EnumC0366c.values().length];
            iArr[o.c.EnumC0366c.CLASS.ordinal()] = 1;
            iArr[o.c.EnumC0366c.PACKAGE.ordinal()] = 2;
            iArr[o.c.EnumC0366c.LOCAL.ordinal()] = 3;
            a = iArr;
        }
    }

    public d(p pVar, o oVar) {
        m.f(pVar, "strings");
        m.f(oVar, "qualifiedNames");
        this.a = pVar;
        this.f24194b = oVar;
    }

    private final Triple<List<String>, List<String>, Boolean> c(int i2) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i2 != -1) {
            o.c v = this.f24194b.v(i2);
            String v2 = this.a.v(v.z());
            o.c.EnumC0366c x = v.x();
            m.c(x);
            int i3 = a.a[x.ordinal()];
            if (i3 == 1) {
                linkedList2.addFirst(v2);
            } else if (i3 == 2) {
                linkedList.addFirst(v2);
            } else if (i3 == 3) {
                linkedList2.addFirst(v2);
                z = true;
            }
            i2 = v.y();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z));
    }

    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public String a(int i2) {
        String e0;
        String e02;
        Triple<List<String>, List<String>, Boolean> c2 = c(i2);
        List<String> a2 = c2.a();
        e0 = c0.e0(c2.b(), ".", null, null, 0, null, null, 62, null);
        if (a2.isEmpty()) {
            return e0;
        }
        StringBuilder sb = new StringBuilder();
        e02 = c0.e0(a2, "/", null, null, 0, null, null, 62, null);
        sb.append(e02);
        sb.append('/');
        sb.append(e0);
        return sb.toString();
    }

    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public boolean b(int i2) {
        return c(i2).d().booleanValue();
    }

    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public String getString(int i2) {
        String v = this.a.v(i2);
        m.e(v, "strings.getString(index)");
        return v;
    }
}
