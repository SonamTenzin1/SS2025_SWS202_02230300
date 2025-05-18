package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.e1;

/* compiled from: MutableClassDescriptor.java */
/* loaded from: classes2.dex */
public class y extends g {
    private final kotlin.reflect.jvm.internal.impl.descriptors.f n;
    private final boolean o;
    private kotlin.reflect.jvm.internal.impl.descriptors.d0 p;
    private kotlin.reflect.jvm.internal.impl.descriptors.u q;
    private e1 r;
    private List<kotlin.reflect.jvm.internal.impl.descriptors.e1> s;
    private final Collection<kotlin.reflect.y.internal.j0.l.e0> t;
    private final kotlin.reflect.y.internal.j0.k.n u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.f fVar, boolean z, boolean z2, kotlin.reflect.y.internal.j0.f.f fVar2, z0 z0Var, kotlin.reflect.y.internal.j0.k.n nVar) {
        super(nVar, mVar, fVar2, z0Var, z2);
        if (mVar == null) {
            K(0);
        }
        if (fVar == null) {
            K(1);
        }
        if (fVar2 == null) {
            K(2);
        }
        if (z0Var == null) {
            K(3);
        }
        if (nVar == null) {
            K(4);
        }
        this.t = new ArrayList();
        this.u = nVar;
        this.n = fVar;
        this.o = z;
    }

    private static /* synthetic */ void K(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i3 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(format);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean A() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean D() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean E0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.t
    public kotlin.reflect.y.internal.j0.i.w.h H(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        if (gVar == null) {
            K(16);
        }
        h.b bVar = h.b.f24422b;
        if (bVar == null) {
            K(17);
        }
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> J() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            K(19);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean J0() {
        return false;
    }

    public void L0() {
        this.r = new kotlin.reflect.y.internal.j0.l.l(this, this.s, this.t, this.u);
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.d> it = k().iterator();
        while (it.hasNext()) {
            ((f) it.next()).h1(s());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public Set<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
        Set<kotlin.reflect.jvm.internal.impl.descriptors.d> emptySet = Collections.emptySet();
        if (emptySet == null) {
            K(13);
        }
        return emptySet;
    }

    public void N0(kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var) {
        if (d0Var == null) {
            K(6);
        }
        this.p = d0Var;
    }

    public void O0(List<kotlin.reflect.jvm.internal.impl.descriptors.e1> list) {
        if (list == null) {
            K(14);
        }
        if (this.s == null) {
            this.s = new ArrayList(list);
            return;
        }
        throw new IllegalStateException("Type parameters are already set for " + getName());
    }

    public void P0(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        if (uVar == null) {
            K(9);
        }
        this.q = uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.d R() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h S() {
        h.b bVar = h.b.f24422b;
        if (bVar == null) {
            K(18);
        }
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.e U() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.n1.g b2 = kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
        if (b2 == null) {
            K(5);
        }
        return b2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = this.q;
        if (uVar == null) {
            K(10);
        }
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public e1 h() {
        e1 e1Var = this.r;
        if (e1Var == null) {
            K(11);
        }
        return e1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.f i() {
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = this.n;
        if (fVar == null) {
            K(8);
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public kotlin.reflect.jvm.internal.impl.descriptors.d0 j() {
        kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var = this.p;
        if (d0Var == null) {
            K(7);
        }
        return d0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean l() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean m() {
        return this.o;
    }

    public String toString() {
        return j.H(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<kotlin.reflect.jvm.internal.impl.descriptors.e1> w() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.e1> list = this.s;
        if (list == null) {
            K(15);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public g1<kotlin.reflect.y.internal.j0.l.m0> z0() {
        return null;
    }
}
