package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.l.j1;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.r1;

/* compiled from: PropertyDescriptorImpl.java */
/* loaded from: classes2.dex */
public class c0 extends n0 implements t0 {
    private w0 A;
    private List<e1> B;
    private d0 C;
    private v0 D;
    private boolean E;
    private kotlin.reflect.jvm.internal.impl.descriptors.w F;
    private kotlin.reflect.jvm.internal.impl.descriptors.w G;
    private final kotlin.reflect.jvm.internal.impl.descriptors.d0 n;
    private kotlin.reflect.jvm.internal.impl.descriptors.u o;
    private Collection<? extends t0> p;
    private final t0 q;
    private final b.a r;
    private final boolean s;
    private final boolean t;
    private final boolean u;
    private final boolean v;
    private final boolean w;
    private final boolean x;
    private List<w0> y;
    private w0 z;

    /* compiled from: PropertyDescriptorImpl.java */
    /* loaded from: classes2.dex */
    public class a {
        private kotlin.reflect.jvm.internal.impl.descriptors.m a;

        /* renamed from: b, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.d0 f25214b;

        /* renamed from: c, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.u f25215c;

        /* renamed from: f, reason: collision with root package name */
        private b.a f25218f;

        /* renamed from: i, reason: collision with root package name */
        private w0 f25221i;

        /* renamed from: k, reason: collision with root package name */
        private kotlin.reflect.y.internal.j0.f.f f25223k;
        private kotlin.reflect.y.internal.j0.l.e0 l;

        /* renamed from: d, reason: collision with root package name */
        private t0 f25216d = null;

        /* renamed from: e, reason: collision with root package name */
        private boolean f25217e = false;

        /* renamed from: g, reason: collision with root package name */
        private j1 f25219g = j1.f24750b;

        /* renamed from: h, reason: collision with root package name */
        private boolean f25220h = true;

        /* renamed from: j, reason: collision with root package name */
        private List<e1> f25222j = null;

        public a() {
            this.a = c0.this.b();
            this.f25214b = c0.this.j();
            this.f25215c = c0.this.getVisibility();
            this.f25218f = c0.this.i();
            this.f25221i = c0.this.z;
            this.f25223k = c0.this.getName();
            this.l = c0.this.getType();
        }

        private static /* synthetic */ void a(int i2) {
            String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? 2 : 3];
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i2 == 1) {
                objArr[1] = "setOwner";
            } else if (i2 == 2) {
                objArr[1] = "setOriginal";
            } else if (i2 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i2 == 5) {
                objArr[1] = "setReturnType";
            } else if (i2 == 7) {
                objArr[1] = "setModality";
            } else if (i2 == 9) {
                objArr[1] = "setVisibility";
            } else if (i2 == 11) {
                objArr[1] = "setKind";
            } else if (i2 == 19) {
                objArr[1] = "setName";
            } else if (i2 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i2 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i2 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i2 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 5 && i2 != 7 && i2 != 9 && i2 != 11 && i2 != 19 && i2 != 13 && i2 != 14 && i2 != 16 && i2 != 17) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public t0 n() {
            return c0.this.R0(this);
        }

        u0 o() {
            t0 t0Var = this.f25216d;
            if (t0Var == null) {
                return null;
            }
            return t0Var.getGetter();
        }

        v0 p() {
            t0 t0Var = this.f25216d;
            if (t0Var == null) {
                return null;
            }
            return t0Var.getSetter();
        }

        public a q(boolean z) {
            this.f25220h = z;
            return this;
        }

        public a r(b.a aVar) {
            if (aVar == null) {
                a(10);
            }
            this.f25218f = aVar;
            return this;
        }

        public a s(kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var) {
            if (d0Var == null) {
                a(6);
            }
            this.f25214b = d0Var;
            return this;
        }

        public a t(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            this.f25216d = (t0) bVar;
            return this;
        }

        public a u(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
            if (mVar == null) {
                a(0);
            }
            this.a = mVar;
            return this;
        }

        public a v(j1 j1Var) {
            if (j1Var == null) {
                a(15);
            }
            this.f25219g = j1Var;
            return this;
        }

        public a w(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
            if (uVar == null) {
                a(8);
            }
            this.f25215c = uVar;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, t0 t0Var, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, boolean z, kotlin.reflect.y.internal.j0.f.f fVar, b.a aVar, z0 z0Var, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        super(mVar, gVar, fVar, null, z, z0Var);
        if (mVar == null) {
            v(0);
        }
        if (gVar == null) {
            v(1);
        }
        if (d0Var == null) {
            v(2);
        }
        if (uVar == null) {
            v(3);
        }
        if (fVar == null) {
            v(4);
        }
        if (aVar == null) {
            v(5);
        }
        if (z0Var == null) {
            v(6);
        }
        this.p = null;
        this.y = Collections.emptyList();
        this.n = d0Var;
        this.o = uVar;
        this.q = t0Var == null ? this : t0Var;
        this.r = aVar;
        this.s = z2;
        this.t = z3;
        this.u = z4;
        this.v = z5;
        this.w = z6;
        this.x = z7;
    }

    public static c0 P0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, boolean z, kotlin.reflect.y.internal.j0.f.f fVar, b.a aVar, z0 z0Var, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        if (mVar == null) {
            v(7);
        }
        if (gVar == null) {
            v(8);
        }
        if (d0Var == null) {
            v(9);
        }
        if (uVar == null) {
            v(10);
        }
        if (fVar == null) {
            v(11);
        }
        if (aVar == null) {
            v(12);
        }
        if (z0Var == null) {
            v(13);
        }
        return new c0(mVar, null, gVar, d0Var, uVar, z, fVar, aVar, z0Var, z2, z3, z4, z5, z6, z7);
    }

    private z0 T0(boolean z, t0 t0Var) {
        z0 z0Var;
        if (z) {
            if (t0Var == null) {
                t0Var = a();
            }
            z0Var = t0Var.t();
        } else {
            z0Var = z0.a;
        }
        if (z0Var == null) {
            v(28);
        }
        return z0Var;
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.y U0(l1 l1Var, s0 s0Var) {
        if (l1Var == null) {
            v(30);
        }
        if (s0Var == null) {
            v(31);
        }
        if (s0Var.d0() != null) {
            return s0Var.d0().c(l1Var);
        }
        return null;
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.u Z0(kotlin.reflect.jvm.internal.impl.descriptors.u uVar, b.a aVar) {
        return (aVar == b.a.FAKE_OVERRIDE && kotlin.reflect.jvm.internal.impl.descriptors.t.g(uVar.f())) ? kotlin.reflect.jvm.internal.impl.descriptors.t.f25371h : uVar;
    }

    private static w0 e1(l1 l1Var, t0 t0Var, w0 w0Var) {
        kotlin.reflect.y.internal.j0.l.e0 p = l1Var.p(w0Var.getType(), r1.IN_VARIANCE);
        if (p == null) {
            return null;
        }
        return new f0(t0Var, new kotlin.reflect.y.internal.j0.i.w.o.c(t0Var, p, w0Var.getValue()), w0Var.getAnnotations());
    }

    private static w0 f1(l1 l1Var, t0 t0Var, w0 w0Var) {
        kotlin.reflect.y.internal.j0.l.e0 p = l1Var.p(w0Var.getType(), r1.IN_VARIANCE);
        if (p == null) {
            return null;
        }
        return new f0(t0Var, new kotlin.reflect.y.internal.j0.i.w.o.d(t0Var, p, w0Var.getValue()), w0Var.getAnnotations());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void v(int i2) {
        String str;
        int i3;
        if (i2 != 28 && i2 != 38 && i2 != 39 && i2 != 41 && i2 != 42) {
            switch (i2) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (i2 != 28 && i2 != 38 && i2 != 39 && i2 != 41 && i2 != 42) {
                switch (i2) {
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                        break;
                    default:
                        i3 = 3;
                        break;
                }
                Object[] objArr = new Object[i3];
                switch (i2) {
                    case 1:
                    case 8:
                        objArr[0] = "annotations";
                        break;
                    case 2:
                    case 9:
                        objArr[0] = "modality";
                        break;
                    case 3:
                    case 10:
                    case 20:
                        objArr[0] = "visibility";
                        break;
                    case 4:
                    case 11:
                        objArr[0] = "name";
                        break;
                    case 5:
                    case 12:
                    case 35:
                        objArr[0] = "kind";
                        break;
                    case 6:
                    case 13:
                    case 37:
                        objArr[0] = "source";
                        break;
                    case 7:
                    default:
                        objArr[0] = "containingDeclaration";
                        break;
                    case 14:
                        objArr[0] = "inType";
                        break;
                    case 15:
                    case 17:
                        objArr[0] = "outType";
                        break;
                    case 16:
                    case 18:
                        objArr[0] = "typeParameters";
                        break;
                    case 19:
                        objArr[0] = "contextReceiverParameters";
                        break;
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 28:
                    case 38:
                    case 39:
                    case 41:
                    case 42:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                        break;
                    case 27:
                        objArr[0] = "originalSubstitutor";
                        break;
                    case 29:
                        objArr[0] = "copyConfiguration";
                        break;
                    case 30:
                        objArr[0] = "substitutor";
                        break;
                    case 31:
                        objArr[0] = "accessorDescriptor";
                        break;
                    case 32:
                        objArr[0] = "newOwner";
                        break;
                    case 33:
                        objArr[0] = "newModality";
                        break;
                    case 34:
                        objArr[0] = "newVisibility";
                        break;
                    case 36:
                        objArr[0] = "newName";
                        break;
                    case 40:
                        objArr[0] = "overriddenDescriptors";
                        break;
                }
                if (i2 != 28) {
                    objArr[1] = "getSourceToUseForCopy";
                } else if (i2 == 38) {
                    objArr[1] = "getOriginal";
                } else if (i2 == 39) {
                    objArr[1] = "getKind";
                } else if (i2 == 41) {
                    objArr[1] = "getOverriddenDescriptors";
                } else if (i2 != 42) {
                    switch (i2) {
                        case 21:
                            objArr[1] = "getTypeParameters";
                            break;
                        case 22:
                            objArr[1] = "getContextReceiverParameters";
                            break;
                        case 23:
                            objArr[1] = "getReturnType";
                            break;
                        case 24:
                            objArr[1] = "getModality";
                            break;
                        case 25:
                            objArr[1] = "getVisibility";
                            break;
                        case 26:
                            objArr[1] = "getAccessors";
                            break;
                        default:
                            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                            break;
                    }
                } else {
                    objArr[1] = "copy";
                }
                switch (i2) {
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        objArr[2] = "create";
                        break;
                    case 14:
                        objArr[2] = "setInType";
                        break;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        objArr[2] = "setType";
                        break;
                    case 20:
                        objArr[2] = "setVisibility";
                        break;
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 28:
                    case 38:
                    case 39:
                    case 41:
                    case 42:
                        break;
                    case 27:
                        objArr[2] = "substitute";
                        break;
                    case 29:
                        objArr[2] = "doSubstitute";
                        break;
                    case 30:
                    case 31:
                        objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                        break;
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                        objArr[2] = "createSubstitutedCopy";
                        break;
                    case 40:
                        objArr[2] = "setOverriddenDescriptors";
                        break;
                    default:
                        objArr[2] = "<init>";
                        break;
                }
                String format = String.format(str, objArr);
                if (i2 != 28 && i2 != 38 && i2 != 39 && i2 != 41 && i2 != 42) {
                    switch (i2) {
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                            break;
                        default:
                            throw new IllegalArgumentException(format);
                    }
                }
                throw new IllegalStateException(format);
            }
            i3 = 2;
            Object[] objArr2 = new Object[i3];
            switch (i2) {
            }
            if (i2 != 28) {
            }
            switch (i2) {
            }
            String format2 = String.format(str, objArr2);
            if (i2 != 28) {
                switch (i2) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i2 != 28) {
            switch (i2) {
            }
            Object[] objArr22 = new Object[i3];
            switch (i2) {
            }
            if (i2 != 28) {
            }
            switch (i2) {
            }
            String format22 = String.format(str, objArr22);
            if (i2 != 28) {
            }
            throw new IllegalStateException(format22);
        }
        i3 = 2;
        Object[] objArr222 = new Object[i3];
        switch (i2) {
        }
        if (i2 != 28) {
        }
        switch (i2) {
        }
        String format222 = String.format(str, objArr222);
        if (i2 != 28) {
        }
        throw new IllegalStateException(format222);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean E0() {
        return this.v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d2) {
        return oVar.d(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k1
    public boolean O() {
        return this.x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public t0 k0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, b.a aVar, boolean z) {
        t0 n = Y0().u(mVar).t(null).s(d0Var).w(uVar).r(aVar).q(z).n();
        if (n == null) {
            v(42);
        }
        return n;
    }

    protected c0 Q0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, t0 t0Var, b.a aVar, kotlin.reflect.y.internal.j0.f.f fVar, z0 z0Var) {
        if (mVar == null) {
            v(32);
        }
        if (d0Var == null) {
            v(33);
        }
        if (uVar == null) {
            v(34);
        }
        if (aVar == null) {
            v(35);
        }
        if (fVar == null) {
            v(36);
        }
        if (z0Var == null) {
            v(37);
        }
        return new c0(mVar, t0Var, getAnnotations(), d0Var, uVar, j0(), fVar, aVar, z0Var, s0(), isConst(), M(), E0(), z(), O());
    }

    protected t0 R0(a aVar) {
        w0 w0Var;
        Function0<kotlin.reflect.y.internal.j0.k.j<kotlin.reflect.y.internal.j0.i.r.g<?>>> function0;
        if (aVar == null) {
            v(29);
        }
        c0 Q0 = Q0(aVar.a, aVar.f25214b, aVar.f25215c, aVar.f25216d, aVar.f25218f, aVar.f25223k, T0(aVar.f25217e, aVar.f25216d));
        List<e1> typeParameters = aVar.f25222j == null ? getTypeParameters() : aVar.f25222j;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        l1 b2 = kotlin.reflect.y.internal.j0.l.t.b(typeParameters, aVar.f25219g, Q0, arrayList);
        kotlin.reflect.y.internal.j0.l.e0 e0Var = aVar.l;
        kotlin.reflect.y.internal.j0.l.e0 p = b2.p(e0Var, r1.OUT_VARIANCE);
        if (p == null) {
            return null;
        }
        kotlin.reflect.y.internal.j0.l.e0 p2 = b2.p(e0Var, r1.IN_VARIANCE);
        if (p2 != null) {
            Q0.a1(p2);
        }
        w0 w0Var2 = aVar.f25221i;
        if (w0Var2 != null) {
            w0 c2 = w0Var2.c(b2);
            if (c2 == null) {
                return null;
            }
            w0Var = c2;
        } else {
            w0Var = null;
        }
        w0 w0Var3 = this.A;
        w0 f1 = w0Var3 != null ? f1(b2, Q0, w0Var3) : null;
        ArrayList arrayList2 = new ArrayList();
        Iterator<w0> it = this.y.iterator();
        while (it.hasNext()) {
            w0 e1 = e1(b2, Q0, it.next());
            if (e1 != null) {
                arrayList2.add(e1);
            }
        }
        Q0.c1(p, arrayList, w0Var, f1, arrayList2);
        d0 d0Var = this.C == null ? null : new d0(Q0, this.C.getAnnotations(), aVar.f25214b, Z0(this.C.getVisibility(), aVar.f25218f), this.C.V(), this.C.z(), this.C.isInline(), aVar.f25218f, aVar.o(), z0.a);
        if (d0Var != null) {
            kotlin.reflect.y.internal.j0.l.e0 returnType = this.C.getReturnType();
            d0Var.O0(U0(b2, this.C));
            d0Var.R0(returnType != null ? b2.p(returnType, r1.OUT_VARIANCE) : null);
        }
        e0 e0Var2 = this.D == null ? null : new e0(Q0, this.D.getAnnotations(), aVar.f25214b, Z0(this.D.getVisibility(), aVar.f25218f), this.D.V(), this.D.z(), this.D.isInline(), aVar.f25218f, aVar.p(), z0.a);
        if (e0Var2 != null) {
            List<i1> Q02 = p.Q0(e0Var2, this.D.f(), b2, false, false, null);
            if (Q02 == null) {
                Q0.b1(true);
                Q02 = Collections.singletonList(e0.Q0(e0Var2, kotlin.reflect.y.internal.j0.i.t.a.f(aVar.a).H(), this.D.f().get(0).getAnnotations()));
            }
            if (Q02.size() == 1) {
                e0Var2.O0(U0(b2, this.D));
                e0Var2.S0(Q02.get(0));
            } else {
                throw new IllegalStateException();
            }
        }
        kotlin.reflect.jvm.internal.impl.descriptors.w wVar = this.F;
        o oVar = wVar == null ? null : new o(wVar.getAnnotations(), Q0);
        kotlin.reflect.jvm.internal.impl.descriptors.w wVar2 = this.G;
        Q0.W0(d0Var, e0Var2, oVar, wVar2 != null ? new o(wVar2.getAnnotations(), Q0) : null);
        if (aVar.f25220h) {
            kotlin.reflect.jvm.internal.impl.utils.f c3 = kotlin.reflect.jvm.internal.impl.utils.f.c();
            Iterator<? extends t0> it2 = e().iterator();
            while (it2.hasNext()) {
                c3.add(it2.next().c(b2));
            }
            Q0.x0(c3);
        }
        if (isConst() && (function0 = this.m) != null) {
            Q0.L0(this.l, function0);
        }
        return Q0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public d0 getGetter() {
        return this.C;
    }

    public void V0(d0 d0Var, v0 v0Var) {
        W0(d0Var, v0Var, null, null);
    }

    public void W0(d0 d0Var, v0 v0Var, kotlin.reflect.jvm.internal.impl.descriptors.w wVar, kotlin.reflect.jvm.internal.impl.descriptors.w wVar2) {
        this.C = d0Var;
        this.D = v0Var;
        this.F = wVar;
        this.G = wVar2;
    }

    public boolean X0() {
        return this.E;
    }

    public a Y0() {
        return new a();
    }

    public void a1(kotlin.reflect.y.internal.j0.l.e0 e0Var) {
        if (e0Var == null) {
            v(14);
        }
    }

    public void b1(boolean z) {
        this.E = z;
    }

    public void c1(kotlin.reflect.y.internal.j0.l.e0 e0Var, List<? extends e1> list, w0 w0Var, w0 w0Var2, List<w0> list2) {
        if (e0Var == null) {
            v(17);
        }
        if (list == null) {
            v(18);
        }
        if (list2 == null) {
            v(19);
        }
        A0(e0Var);
        this.B = new ArrayList(list);
        this.A = w0Var2;
        this.z = w0Var;
        this.y = list2;
    }

    public void d1(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        if (uVar == null) {
            v(20);
        }
        this.o = uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends t0> e() {
        Collection<? extends t0> collection = this.p;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            v(41);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public w0 f0() {
        return this.z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.y.internal.j0.l.e0 getReturnType() {
        kotlin.reflect.y.internal.j0.l.e0 type = getType();
        if (type == null) {
            v(23);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    public v0 getSetter() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<e1> getTypeParameters() {
        List<e1> list = this.B;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = this.o;
        if (uVar == null) {
            v(25);
        }
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    public b.a i() {
        b.a aVar = this.r;
        if (aVar == null) {
            v(39);
        }
        return aVar;
    }

    public <V> V i0(a.InterfaceC0406a<V> interfaceC0406a) {
        return null;
    }

    public boolean isConst() {
        return this.t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public kotlin.reflect.jvm.internal.impl.descriptors.d0 j() {
        kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var = this.n;
        if (d0Var == null) {
            v(24);
        }
        return d0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    public w0 m0() {
        return this.A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    public kotlin.reflect.jvm.internal.impl.descriptors.w n0() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    public kotlin.reflect.jvm.internal.impl.descriptors.w q0() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<w0> r0() {
        List<w0> list = this.y;
        if (list == null) {
            v(22);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean s0() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    public List<s0> x() {
        ArrayList arrayList = new ArrayList(2);
        d0 d0Var = this.C;
        if (d0Var != null) {
            arrayList.add(d0Var);
        }
        v0 v0Var = this.D;
        if (v0Var != null) {
            arrayList.add(v0Var);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    public void x0(Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
        if (collection == 0) {
            v(40);
        }
        this.p = collection;
    }

    public boolean z() {
        return this.w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b1
    public kotlin.reflect.jvm.internal.impl.descriptors.a c(l1 l1Var) {
        if (l1Var == null) {
            v(27);
        }
        return l1Var.k() ? this : Y0().v(l1Var.j()).t(a()).n();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.k, kotlin.reflect.jvm.internal.impl.descriptors.p1.j, kotlin.reflect.jvm.internal.impl.descriptors.m
    public t0 a() {
        t0 t0Var = this.q;
        t0 a2 = t0Var == this ? this : t0Var.a();
        if (a2 == null) {
            v(38);
        }
        return a2;
    }
}
