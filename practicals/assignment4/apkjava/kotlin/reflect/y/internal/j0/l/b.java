package kotlin.reflect.y.internal.j0.l;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.y.internal.j0.i.t.a;
import kotlin.reflect.y.internal.j0.k.n;

/* compiled from: AbstractClassTypeConstructor.java */
/* loaded from: classes3.dex */
public abstract class b extends g implements e1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n nVar) {
        super(nVar);
        if (nVar == null) {
            v(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void v(int i2) {
        String format;
        String str = (i2 == 1 || i2 == 3 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 3 || i2 == 4) ? 2 : 3];
        if (i2 != 1) {
            if (i2 == 2) {
                objArr[0] = "classifier";
            } else if (i2 != 3 && i2 != 4) {
                objArr[0] = "storageManager";
            }
            if (i2 != 1) {
                objArr[1] = "getBuiltIns";
            } else if (i2 == 3 || i2 == 4) {
                objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    objArr[2] = "isSameClassifier";
                } else if (i2 != 3 && i2 != 4) {
                    objArr[2] = "<init>";
                }
            }
            format = String.format(str, objArr);
            if (i2 == 1 && i2 != 3 && i2 != 4) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }
        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        if (i2 != 1) {
        }
        if (i2 != 1) {
        }
        format = String.format(str, objArr);
        if (i2 == 1) {
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.y.internal.j0.l.m
    protected boolean i(h hVar) {
        if (hVar == null) {
            v(2);
        }
        return (hVar instanceof e) && g(w(), hVar);
    }

    @Override // kotlin.reflect.y.internal.j0.l.g
    protected e0 m() {
        if (kotlin.reflect.y.internal.j0.b.h.t0(w())) {
            return null;
        }
        return o().i();
    }

    @Override // kotlin.reflect.y.internal.j0.l.g
    protected Collection<e0> n(boolean z) {
        m b2 = w().b();
        if (!(b2 instanceof e)) {
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                v(3);
            }
            return emptyList;
        }
        kotlin.reflect.jvm.internal.impl.utils.e eVar = new kotlin.reflect.jvm.internal.impl.utils.e();
        e eVar2 = (e) b2;
        eVar.add(eVar2.s());
        e U = eVar2.U();
        if (z && U != null) {
            eVar.add(U.s());
        }
        return eVar;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public kotlin.reflect.y.internal.j0.b.h o() {
        kotlin.reflect.y.internal.j0.b.h f2 = a.f(w());
        if (f2 == null) {
            v(1);
        }
        return f2;
    }

    public abstract e w();
}
