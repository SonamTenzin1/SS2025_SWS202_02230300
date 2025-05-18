package androidx.datastore.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.u;

/* compiled from: DataMigrationInitializer.kt */
/* loaded from: classes.dex */
public final class d<T> {
    public static final a a = new a(null);

    /* compiled from: DataMigrationInitializer.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* compiled from: DataMigrationInitializer.kt */
        @DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {33}, m = "invokeSuspend")
        /* renamed from: androidx.datastore.core.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0027a extends SuspendLambda implements Function2<h<T>, Continuation<? super u>, Object> {

            /* renamed from: f, reason: collision with root package name */
            int f1129f;

            /* renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f1130g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ List<androidx.datastore.core.c<T>> f1131h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0027a(List<? extends androidx.datastore.core.c<T>> list, Continuation<? super C0027a> continuation) {
                super(2, continuation);
                this.f1131h = list;
            }

            @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                C0027a c0027a = new C0027a(this.f1131h, continuation);
                c0027a.f1130g = obj;
                return c0027a;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(h<T> hVar, Continuation<? super u> continuation) {
                return ((C0027a) create(hVar, continuation)).invokeSuspend(u.a);
            }

            @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object c2;
                c2 = kotlin.coroutines.intrinsics.d.c();
                int i2 = this.f1129f;
                if (i2 == 0) {
                    o.b(obj);
                    h hVar = (h) this.f1130g;
                    a aVar = d.a;
                    List<androidx.datastore.core.c<T>> list = this.f1131h;
                    this.f1129f = 1;
                    if (aVar.c(list, hVar, this) == c2) {
                        return c2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    o.b(obj);
                }
                return u.a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DataMigrationInitializer.kt */
        @DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, 57}, m = "runMigrations")
        /* loaded from: classes.dex */
        public static final class b<T> extends ContinuationImpl {

            /* renamed from: f, reason: collision with root package name */
            Object f1132f;

            /* renamed from: g, reason: collision with root package name */
            Object f1133g;

            /* renamed from: h, reason: collision with root package name */
            /* synthetic */ Object f1134h;

            /* renamed from: j, reason: collision with root package name */
            int f1136j;

            b(Continuation<? super b> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f1134h = obj;
                this.f1136j |= Integer.MIN_VALUE;
                return a.this.c(null, null, this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DataMigrationInitializer.kt */
        @DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
        /* loaded from: classes.dex */
        public static final class c extends SuspendLambda implements Function2<T, Continuation<? super T>, Object> {

            /* renamed from: f, reason: collision with root package name */
            Object f1137f;

            /* renamed from: g, reason: collision with root package name */
            Object f1138g;

            /* renamed from: h, reason: collision with root package name */
            Object f1139h;

            /* renamed from: i, reason: collision with root package name */
            int f1140i;

            /* renamed from: j, reason: collision with root package name */
            /* synthetic */ Object f1141j;

            /* renamed from: k, reason: collision with root package name */
            final /* synthetic */ List<androidx.datastore.core.c<T>> f1142k;
            final /* synthetic */ List<Function1<Continuation<? super u>, Object>> l;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DataMigrationInitializer.kt */
            @DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
            /* renamed from: androidx.datastore.core.d$a$c$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0028a extends SuspendLambda implements Function1<Continuation<? super u>, Object> {

                /* renamed from: f, reason: collision with root package name */
                int f1143f;

                /* renamed from: g, reason: collision with root package name */
                final /* synthetic */ androidx.datastore.core.c<T> f1144g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0028a(androidx.datastore.core.c<T> cVar, Continuation<? super C0028a> continuation) {
                    super(1, continuation);
                    this.f1144g = cVar;
                }

                @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
                public final Continuation<u> create(Continuation<?> continuation) {
                    return new C0028a(this.f1144g, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: i, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Continuation<? super u> continuation) {
                    return ((C0028a) create(continuation)).invokeSuspend(u.a);
                }

                @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object c2;
                    c2 = kotlin.coroutines.intrinsics.d.c();
                    int i2 = this.f1143f;
                    if (i2 == 0) {
                        o.b(obj);
                        androidx.datastore.core.c<T> cVar = this.f1144g;
                        this.f1143f = 1;
                        if (cVar.a(this) == c2) {
                            return c2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        o.b(obj);
                    }
                    return u.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            c(List<? extends androidx.datastore.core.c<T>> list, List<Function1<Continuation<? super u>, Object>> list2, Continuation<? super c> continuation) {
                super(2, continuation);
                this.f1142k = list;
                this.l = list2;
            }

            @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                c cVar = new c(this.f1142k, this.l, continuation);
                cVar.f1141j = obj;
                return cVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(T t, Continuation<? super T> continuation) {
                return ((c) create(t, continuation)).invokeSuspend(u.a);
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0091 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:9:0x004e  */
            @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object c2;
                List<Function1<Continuation<? super u>, Object>> list;
                Iterator<T> it;
                c cVar;
                c cVar2;
                androidx.datastore.core.c cVar3;
                Iterator<T> it2;
                Object obj2;
                c2 = kotlin.coroutines.intrinsics.d.c();
                int i2 = this.f1140i;
                if (i2 == 0) {
                    o.b(obj);
                    obj = this.f1141j;
                    List<androidx.datastore.core.c<T>> list2 = this.f1142k;
                    list = this.l;
                    it = list2.iterator();
                    cVar = this;
                    if (!it.hasNext()) {
                    }
                } else if (i2 == 1) {
                    obj2 = this.f1139h;
                    androidx.datastore.core.c cVar4 = (androidx.datastore.core.c) this.f1138g;
                    it2 = (Iterator) this.f1137f;
                    List<Function1<Continuation<? super u>, Object>> list3 = (List) this.f1141j;
                    o.b(obj);
                    cVar2 = this;
                    cVar3 = cVar4;
                    list = list3;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    cVar = cVar2;
                    if (!it.hasNext()) {
                    }
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) this.f1137f;
                    list = (List) this.f1141j;
                    o.b(obj);
                    cVar2 = this;
                    cVar = cVar2;
                    if (!it.hasNext()) {
                        androidx.datastore.core.c cVar5 = (androidx.datastore.core.c) it.next();
                        cVar.f1141j = list;
                        cVar.f1137f = it;
                        cVar.f1138g = cVar5;
                        cVar.f1139h = obj;
                        cVar.f1140i = 1;
                        Object b2 = cVar5.b(obj, cVar);
                        if (b2 == c2) {
                            return c2;
                        }
                        Iterator<T> it3 = it;
                        obj2 = obj;
                        obj = b2;
                        cVar2 = cVar;
                        it2 = it3;
                        cVar3 = cVar5;
                        if (((Boolean) obj).booleanValue()) {
                            obj = obj2;
                            it = it2;
                        } else {
                            list.add(new C0028a(cVar3, null));
                            cVar2.f1141j = list;
                            cVar2.f1137f = it2;
                            cVar2.f1138g = null;
                            cVar2.f1139h = null;
                            cVar2.f1140i = 2;
                            obj = cVar3.c(obj2, cVar2);
                            if (obj == c2) {
                                return c2;
                            }
                            it = it2;
                        }
                        cVar = cVar2;
                        if (!it.hasNext()) {
                            return obj;
                        }
                    }
                }
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Throwable, T] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0086 -> B:13:0x0069). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0089 -> B:13:0x0069). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> Object c(List<? extends androidx.datastore.core.c<T>> list, h<T> hVar, Continuation<? super u> continuation) {
            b bVar;
            Object c2;
            int i2;
            List list2;
            f0 f0Var;
            Iterator<T> it;
            Throwable th;
            if (continuation instanceof b) {
                bVar = (b) continuation;
                int i3 = bVar.f1136j;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    bVar.f1136j = i3 - Integer.MIN_VALUE;
                    Object obj = bVar.f1134h;
                    c2 = kotlin.coroutines.intrinsics.d.c();
                    i2 = bVar.f1136j;
                    if (i2 != 0) {
                        o.b(obj);
                        ArrayList arrayList = new ArrayList();
                        Function2<? super T, ? super Continuation<? super T>, ? extends Object> cVar = new c(list, arrayList, null);
                        bVar.f1132f = arrayList;
                        bVar.f1136j = 1;
                        if (hVar.a(cVar, bVar) == c2) {
                            return c2;
                        }
                        list2 = arrayList;
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            it = (Iterator) bVar.f1133g;
                            f0Var = (f0) bVar.f1132f;
                            try {
                                o.b(obj);
                            } catch (Throwable 
                            /*  JADX ERROR: Method code generation error
                                java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                                	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:367)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:330)
                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                */
                            /*
                                this = this;
                                boolean r0 = r9 instanceof androidx.datastore.core.d.a.b
                                if (r0 == 0) goto L13
                                r0 = r9
                                androidx.datastore.core.d$a$b r0 = (androidx.datastore.core.d.a.b) r0
                                int r1 = r0.f1136j
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.f1136j = r1
                                goto L18
                            L13:
                                androidx.datastore.core.d$a$b r0 = new androidx.datastore.core.d$a$b
                                r0.<init>(r9)
                            L18:
                                java.lang.Object r9 = r0.f1134h
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
                                int r2 = r0.f1136j
                                r3 = 2
                                r4 = 1
                                if (r2 == 0) goto L46
                                if (r2 == r4) goto L3e
                                if (r2 != r3) goto L36
                                java.lang.Object r7 = r0.f1133g
                                java.util.Iterator r7 = (java.util.Iterator) r7
                                java.lang.Object r8 = r0.f1132f
                                kotlin.a0.d.f0 r8 = (kotlin.jvm.internal.f0) r8
                                kotlin.o.b(r9)     // Catch: java.lang.Throwable -> L34
                                goto L69
                            L34:
                                r9 = move-exception
                                goto L82
                            L36:
                                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                                r7.<init>(r8)
                                throw r7
                            L3e:
                                java.lang.Object r7 = r0.f1132f
                                java.util.List r7 = (java.util.List) r7
                                kotlin.o.b(r9)
                                goto L60
                            L46:
                                kotlin.o.b(r9)
                                java.util.ArrayList r9 = new java.util.ArrayList
                                r9.<init>()
                                androidx.datastore.core.d$a$c r2 = new androidx.datastore.core.d$a$c
                                r5 = 0
                                r2.<init>(r7, r9, r5)
                                r0.f1132f = r9
                                r0.f1136j = r4
                                java.lang.Object r7 = r8.a(r2, r0)
                                if (r7 != r1) goto L5f
                                return r1
                            L5f:
                                r7 = r9
                            L60:
                                kotlin.a0.d.f0 r8 = new kotlin.a0.d.f0
                                r8.<init>()
                                java.util.Iterator r7 = r7.iterator()
                            L69:
                                boolean r9 = r7.hasNext()
                                if (r9 == 0) goto L94
                                java.lang.Object r9 = r7.next()
                                kotlin.a0.c.l r9 = (kotlin.jvm.functions.Function1) r9
                                r0.f1132f = r8     // Catch: java.lang.Throwable -> L34
                                r0.f1133g = r7     // Catch: java.lang.Throwable -> L34
                                r0.f1136j = r3     // Catch: java.lang.Throwable -> L34
                                java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L34
                                if (r9 != r1) goto L69
                                return r1
                            L82:
                                T r2 = r8.f22943f
                                if (r2 != 0) goto L89
                                r8.f22943f = r9
                                goto L69
                            L89:
                                kotlin.jvm.internal.m.c(r2)
                                T r2 = r8.f22943f
                                java.lang.Throwable r2 = (java.lang.Throwable) r2
                                kotlin.a.a(r2, r9)
                                goto L69
                            L94:
                                T r7 = r8.f22943f
                                java.lang.Throwable r7 = (java.lang.Throwable) r7
                                if (r7 != 0) goto L9d
                                kotlin.u r7 = kotlin.u.a
                                return r7
                            L9d:
                                goto L9f
                            L9e:
                                throw r7
                            L9f:
                                goto L9e
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.d.a.c(java.util.List, androidx.datastore.core.h, kotlin.y.d):java.lang.Object");
                        }

                        public final <T> Function2<h<T>, Continuation<? super u>, Object> b(List<? extends androidx.datastore.core.c<T>> list) {
                            kotlin.jvm.internal.m.f(list, "migrations");
                            return new C0027a(list, null);
                        }
                    }
                }
