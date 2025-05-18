package kotlin.reflect.y.internal.j0.d.b;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.i;
import kotlin.reflect.y.internal.j0.d.b.l;
import kotlin.reflect.y.internal.j0.i.u.d;
import kotlin.reflect.y.internal.j0.i.u.e;
import kotlin.text.v;

/* compiled from: methodSignatureMapping.kt */
/* loaded from: classes3.dex */
final class n implements m<l> {
    public static final n a = new n();

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.values().length];
            iArr[i.BOOLEAN.ordinal()] = 1;
            iArr[i.CHAR.ordinal()] = 2;
            iArr[i.BYTE.ordinal()] = 3;
            iArr[i.SHORT.ordinal()] = 4;
            iArr[i.INT.ordinal()] = 5;
            iArr[i.FLOAT.ordinal()] = 6;
            iArr[i.LONG.ordinal()] = 7;
            iArr[i.DOUBLE.ordinal()] = 8;
            a = iArr;
        }
    }

    private n() {
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.m
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public l d(l lVar) {
        m.f(lVar, "possiblyPrimitiveType");
        if (!(lVar instanceof l.d)) {
            return lVar;
        }
        l.d dVar = (l.d) lVar;
        if (dVar.i() == null) {
            return lVar;
        }
        String f2 = d.c(dVar.i().y()).f();
        m.e(f2, "byFqNameWithoutInnerClas…apperFqName).internalName");
        return c(f2);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.m
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public l b(String str) {
        e eVar;
        l cVar;
        m.f(str, "representation");
        str.length();
        char charAt = str.charAt(0);
        e[] values = e.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                eVar = null;
                break;
            }
            eVar = values[i2];
            if (eVar.u().charAt(0) == charAt) {
                break;
            }
            i2++;
        }
        if (eVar != null) {
            return new l.d(eVar);
        }
        if (charAt == 'V') {
            return new l.d(null);
        }
        if (charAt == '[') {
            String substring = str.substring(1);
            m.e(substring, "this as java.lang.String).substring(startIndex)");
            cVar = new l.a(b(substring));
        } else {
            if (charAt == 'L') {
                v.M(str, ';', false, 2, null);
            }
            String substring2 = str.substring(1, str.length() - 1);
            m.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            cVar = new l.c(substring2);
        }
        return cVar;
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.m
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public l.c c(String str) {
        m.f(str, "internalName");
        return new l.c(str);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.m
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public l f(i iVar) {
        m.f(iVar, "primitiveType");
        switch (a.a[iVar.ordinal()]) {
            case 1:
                return l.a.a();
            case 2:
                return l.a.c();
            case 3:
                return l.a.b();
            case 4:
                return l.a.h();
            case 5:
                return l.a.f();
            case 6:
                return l.a.e();
            case 7:
                return l.a.g();
            case 8:
                return l.a.d();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.m
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public l e() {
        return c("java/lang/Class");
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.m
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String a(l lVar) {
        String u;
        m.f(lVar, "type");
        if (lVar instanceof l.a) {
            return '[' + a(((l.a) lVar).i());
        }
        if (lVar instanceof l.d) {
            e i2 = ((l.d) lVar).i();
            return (i2 == null || (u = i2.u()) == null) ? "V" : u;
        }
        if (!(lVar instanceof l.c)) {
            throw new NoWhenBranchMatchedException();
        }
        return 'L' + ((l.c) lVar).i() + ';';
    }
}
