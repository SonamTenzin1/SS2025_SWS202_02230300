package kotlin.reflect.y.internal.j0.d.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.y.internal.j0.f.c;

/* compiled from: JavaTypeEnhancementState.kt */
/* loaded from: classes2.dex */
public final class w {
    public static final b a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final w f23695b = new w(u.b(null, 1, null), a.f23699h);

    /* renamed from: c, reason: collision with root package name */
    private final y f23696c;

    /* renamed from: d, reason: collision with root package name */
    private final Function1<c, f0> f23697d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f23698e;

    /* compiled from: JavaTypeEnhancementState.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class a extends i implements Function1<c, f0> {

        /* renamed from: h, reason: collision with root package name */
        public static final a f23699h = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "getDefaultReportLevelForAnnotation";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.d(u.class, "compiler.common.jvm");
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final f0 invoke(c cVar) {
            m.f(cVar, "p0");
            return u.d(cVar);
        }
    }

    /* compiled from: JavaTypeEnhancementState.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final w a() {
            return w.f23695b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(y yVar, Function1<? super c, ? extends f0> function1) {
        m.f(yVar, "jsr305");
        m.f(function1, "getReportLevelForAnnotation");
        this.f23696c = yVar;
        this.f23697d = function1;
        this.f23698e = yVar.d() || function1.invoke(u.e()) == f0.IGNORE;
    }

    public final boolean b() {
        return this.f23698e;
    }

    public final Function1<c, f0> c() {
        return this.f23697d;
    }

    public final y d() {
        return this.f23696c;
    }

    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f23696c + ", getReportLevelForAnnotation=" + this.f23697d + ')';
    }
}
