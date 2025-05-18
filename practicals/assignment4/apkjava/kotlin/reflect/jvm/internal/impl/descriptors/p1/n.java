package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.e1;

/* compiled from: EnumEntrySyntheticClassDescriptor.java */
/* loaded from: classes2.dex */
public class n extends g {
    private final e1 n;
    private final kotlin.reflect.y.internal.j0.i.w.h o;
    private final kotlin.reflect.y.internal.j0.k.i<Set<kotlin.reflect.y.internal.j0.f.f>> p;
    private final kotlin.reflect.jvm.internal.impl.descriptors.n1.g q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EnumEntrySyntheticClassDescriptor.java */
    /* loaded from: classes2.dex */
    public class a extends kotlin.reflect.y.internal.j0.i.w.i {

        /* renamed from: b, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.g<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> f25252b;

        /* renamed from: c, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.g<kotlin.reflect.y.internal.j0.f.f, Collection<? extends t0>> f25253c;

        /* renamed from: d, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.m>> f25254d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ n f25255e;

        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.p1.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0411a implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ n f25256f;

            C0411a(n nVar) {
                this.f25256f = nVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Collection<? extends y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
                return a.this.m(fVar);
            }
        }

        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        /* loaded from: classes2.dex */
        class b implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends t0>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ n f25258f;

            b(n nVar) {
                this.f25258f = nVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Collection<? extends t0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
                return a.this.n(fVar);
            }
        }

        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        /* loaded from: classes2.dex */
        class c implements Function0<Collection<kotlin.reflect.jvm.internal.impl.descriptors.m>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ n f25260f;

            c(n nVar) {
                this.f25260f = nVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> invoke() {
                return a.this.l();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        /* loaded from: classes2.dex */
        public class d extends kotlin.reflect.y.internal.j0.i.h {
            final /* synthetic */ Set a;

            d(Set set) {
                this.a = set;
            }

            private static /* synthetic */ void f(int i2) {
                Object[] objArr = new Object[3];
                if (i2 == 1) {
                    objArr[0] = "fromSuper";
                } else if (i2 != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i2 == 1 || i2 == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.y.internal.j0.i.i
            public void a(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
                if (bVar == null) {
                    f(0);
                }
                kotlin.reflect.y.internal.j0.i.j.K(bVar, null);
                this.a.add(bVar);
            }

            @Override // kotlin.reflect.y.internal.j0.i.h
            protected void e(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar2) {
                if (bVar == null) {
                    f(1);
                }
                if (bVar2 == null) {
                    f(2);
                }
            }
        }

        public a(n nVar, kotlin.reflect.y.internal.j0.k.n nVar2) {
            if (nVar2 == null) {
                h(0);
            }
            this.f25255e = nVar;
            this.f25252b = nVar2.h(new C0411a(nVar));
            this.f25253c = nVar2.h(new b(nVar));
            this.f25254d = nVar2.d(new c(nVar));
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b5 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static /* synthetic */ void h(int i2) {
            String str;
            int i3;
            if (i2 != 3 && i2 != 7 && i2 != 9 && i2 != 12) {
                switch (i2) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
                if (i2 != 3 && i2 != 7 && i2 != 9 && i2 != 12) {
                    switch (i2) {
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            break;
                        default:
                            i3 = 3;
                            break;
                    }
                    Object[] objArr = new Object[i3];
                    switch (i2) {
                        case 1:
                        case 4:
                        case 5:
                        case 8:
                        case 10:
                            objArr[0] = "name";
                            break;
                        case 2:
                        case 6:
                            objArr[0] = "location";
                            break;
                        case 3:
                        case 7:
                        case 9:
                        case 12:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                            break;
                        case 11:
                            objArr[0] = "fromSupertypes";
                            break;
                        case 13:
                            objArr[0] = "kindFilter";
                            break;
                        case 14:
                            objArr[0] = "nameFilter";
                            break;
                        case 20:
                            objArr[0] = "p";
                            break;
                        default:
                            objArr[0] = "storageManager";
                            break;
                    }
                    if (i2 != 3) {
                        objArr[1] = "getContributedVariables";
                    } else if (i2 == 7) {
                        objArr[1] = "getContributedFunctions";
                    } else if (i2 == 9) {
                        objArr[1] = "getSupertypeScope";
                    } else if (i2 != 12) {
                        switch (i2) {
                            case 15:
                                objArr[1] = "getContributedDescriptors";
                                break;
                            case 16:
                                objArr[1] = "computeAllDeclarations";
                                break;
                            case 17:
                                objArr[1] = "getFunctionNames";
                                break;
                            case 18:
                                objArr[1] = "getClassifierNames";
                                break;
                            case 19:
                                objArr[1] = "getVariableNames";
                                break;
                            default:
                                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                                break;
                        }
                    } else {
                        objArr[1] = "resolveFakeOverrides";
                    }
                    switch (i2) {
                        case 1:
                        case 2:
                            objArr[2] = "getContributedVariables";
                            break;
                        case 3:
                        case 7:
                        case 9:
                        case 12:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            break;
                        case 4:
                            objArr[2] = "computeProperties";
                            break;
                        case 5:
                        case 6:
                            objArr[2] = "getContributedFunctions";
                            break;
                        case 8:
                            objArr[2] = "computeFunctions";
                            break;
                        case 10:
                        case 11:
                            objArr[2] = "resolveFakeOverrides";
                            break;
                        case 13:
                        case 14:
                            objArr[2] = "getContributedDescriptors";
                            break;
                        case 20:
                            objArr[2] = "printScopeStructure";
                            break;
                        default:
                            objArr[2] = "<init>";
                            break;
                    }
                    String format = String.format(str, objArr);
                    if (i2 != 3 && i2 != 7 && i2 != 9 && i2 != 12) {
                        switch (i2) {
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
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
                if (i2 != 3) {
                }
                switch (i2) {
                }
                String format2 = String.format(str, objArr2);
                if (i2 != 3) {
                    switch (i2) {
                    }
                }
                throw new IllegalStateException(format2);
            }
            str = "@NotNull method %s.%s must not return null";
            if (i2 != 3) {
                switch (i2) {
                }
                Object[] objArr22 = new Object[i3];
                switch (i2) {
                }
                if (i2 != 3) {
                }
                switch (i2) {
                }
                String format22 = String.format(str, objArr22);
                if (i2 != 3) {
                }
                throw new IllegalStateException(format22);
            }
            i3 = 2;
            Object[] objArr222 = new Object[i3];
            switch (i2) {
            }
            if (i2 != 3) {
            }
            switch (i2) {
            }
            String format222 = String.format(str, objArr222);
            if (i2 != 3) {
            }
            throw new IllegalStateException(format222);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> l() {
            HashSet hashSet = new HashSet();
            for (kotlin.reflect.y.internal.j0.f.f fVar : (Set) this.f25255e.p.invoke()) {
                kotlin.reflect.y.internal.j0.c.b.d dVar = kotlin.reflect.y.internal.j0.c.b.d.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(a(fVar, dVar));
                hashSet.addAll(c(fVar, dVar));
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection<? extends y0> m(kotlin.reflect.y.internal.j0.f.f fVar) {
            if (fVar == null) {
                h(8);
            }
            return p(fVar, o().a(fVar, kotlin.reflect.y.internal.j0.c.b.d.FOR_NON_TRACKED_SCOPE));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection<? extends t0> n(kotlin.reflect.y.internal.j0.f.f fVar) {
            if (fVar == null) {
                h(4);
            }
            return p(fVar, o().c(fVar, kotlin.reflect.y.internal.j0.c.b.d.FOR_NON_TRACKED_SCOPE));
        }

        private kotlin.reflect.y.internal.j0.i.w.h o() {
            kotlin.reflect.y.internal.j0.i.w.h q = this.f25255e.h().a().iterator().next().q();
            if (q == null) {
                h(9);
            }
            return q;
        }

        private <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> Collection<? extends D> p(kotlin.reflect.y.internal.j0.f.f fVar, Collection<? extends D> collection) {
            if (fVar == null) {
                h(10);
            }
            if (collection == null) {
                h(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            kotlin.reflect.y.internal.j0.i.j.f24327b.v(fVar, collection, Collections.emptySet(), this.f25255e, new d(linkedHashSet));
            return linkedHashSet;
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
        public Collection<? extends y0> a(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
            if (fVar == null) {
                h(5);
            }
            if (bVar == null) {
                h(6);
            }
            Collection<? extends y0> invoke = this.f25252b.invoke(fVar);
            if (invoke == null) {
                h(7);
            }
            return invoke;
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
        public Set<kotlin.reflect.y.internal.j0.f.f> b() {
            Set<kotlin.reflect.y.internal.j0.f.f> set = (Set) this.f25255e.p.invoke();
            if (set == null) {
                h(17);
            }
            return set;
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
        public Collection<? extends t0> c(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
            if (fVar == null) {
                h(1);
            }
            if (bVar == null) {
                h(2);
            }
            Collection<? extends t0> invoke = this.f25253c.invoke(fVar);
            if (invoke == null) {
                h(3);
            }
            return invoke;
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
        public Set<kotlin.reflect.y.internal.j0.f.f> d() {
            Set<kotlin.reflect.y.internal.j0.f.f> set = (Set) this.f25255e.p.invoke();
            if (set == null) {
                h(19);
            }
            return set;
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
        public Set<kotlin.reflect.y.internal.j0.f.f> e() {
            Set<kotlin.reflect.y.internal.j0.f.f> emptySet = Collections.emptySet();
            if (emptySet == null) {
                h(18);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
            if (dVar == null) {
                h(13);
            }
            if (function1 == null) {
                h(14);
            }
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> invoke = this.f25254d.invoke();
            if (invoke == null) {
                h(15);
            }
            return invoke;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private n(kotlin.reflect.y.internal.j0.k.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.k.i<Set<kotlin.reflect.y.internal.j0.f.f>> iVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, z0 z0Var) {
        super(nVar, eVar, fVar, z0Var, false);
        if (nVar == null) {
            K(6);
        }
        if (eVar == null) {
            K(7);
        }
        if (e0Var == null) {
            K(8);
        }
        if (fVar == null) {
            K(9);
        }
        if (iVar == null) {
            K(10);
        }
        if (gVar == null) {
            K(11);
        }
        if (z0Var == null) {
            K(12);
        }
        this.q = gVar;
        this.n = new kotlin.reflect.y.internal.j0.l.l(this, Collections.emptyList(), Collections.singleton(e0Var), nVar);
        this.o = new a(this, nVar);
        this.p = iVar;
    }

    private static /* synthetic */ void K(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static n M0(kotlin.reflect.y.internal.j0.k.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.k.i<Set<kotlin.reflect.y.internal.j0.f.f>> iVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, z0 z0Var) {
        if (nVar == null) {
            K(0);
        }
        if (eVar == null) {
            K(1);
        }
        if (fVar == null) {
            K(2);
        }
        if (iVar == null) {
            K(3);
        }
        if (gVar == null) {
            K(4);
        }
        if (z0Var == null) {
            K(5);
        }
        return new n(nVar, eVar, eVar.s(), fVar, iVar, gVar, z0Var);
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
            K(13);
        }
        kotlin.reflect.y.internal.j0.i.w.h hVar = this.o;
        if (hVar == null) {
            K(14);
        }
        return hVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> J() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            K(23);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean J0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.d R() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h S() {
        h.b bVar = h.b.f24422b;
        if (bVar == null) {
            K(15);
        }
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.e U() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar = this.q;
        if (gVar == null) {
            K(21);
        }
        return gVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = kotlin.reflect.jvm.internal.impl.descriptors.t.f25368e;
        if (uVar == null) {
            K(20);
        }
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public e1 h() {
        e1 e1Var = this.n;
        if (e1Var == null) {
            K(17);
        }
        return e1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.f i() {
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY;
        if (fVar == null) {
            K(18);
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public kotlin.reflect.jvm.internal.impl.descriptors.d0 j() {
        kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var = kotlin.reflect.jvm.internal.impl.descriptors.d0.FINAL;
        if (d0Var == null) {
            K(19);
        }
        return d0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            K(16);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean l() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean m() {
        return false;
    }

    public String toString() {
        return "enum entry " + getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<kotlin.reflect.jvm.internal.impl.descriptors.e1> w() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.e1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            K(22);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public g1<kotlin.reflect.y.internal.j0.l.m0> z0() {
        return null;
    }
}
