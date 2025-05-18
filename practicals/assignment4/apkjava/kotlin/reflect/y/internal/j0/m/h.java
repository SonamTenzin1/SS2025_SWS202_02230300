package kotlin.reflect.y.internal.j0.m;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.m.g;
import kotlin.text.Regex;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public final class h {
    private final f a;

    /* renamed from: b, reason: collision with root package name */
    private final Regex f24897b;

    /* renamed from: c, reason: collision with root package name */
    private final Collection<f> f24898c;

    /* renamed from: d, reason: collision with root package name */
    private final Function1<y, String> f24899d;

    /* renamed from: e, reason: collision with root package name */
    private final f[] f24900e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1 {

        /* renamed from: f, reason: collision with root package name */
        public static final a f24901f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke(y yVar) {
            m.f(yVar, "$this$null");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: f, reason: collision with root package name */
        public static final b f24902f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke(y yVar) {
            m.f(yVar, "$this$null");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: f, reason: collision with root package name */
        public static final c f24903f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke(y yVar) {
            m.f(yVar, "$this$null");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private h(f fVar, Regex regex, Collection<f> collection, Function1<? super y, String> function1, f... fVarArr) {
        this.a = fVar;
        this.f24897b = regex;
        this.f24898c = collection;
        this.f24899d = function1;
        this.f24900e = fVarArr;
    }

    public final g a(y yVar) {
        m.f(yVar, "functionDescriptor");
        for (f fVar : this.f24900e) {
            String a2 = fVar.a(yVar);
            if (a2 != null) {
                return new g.b(a2);
            }
        }
        String invoke = this.f24899d.invoke(yVar);
        if (invoke != null) {
            return new g.b(invoke);
        }
        return g.c.f24896b;
    }

    public final boolean b(y yVar) {
        m.f(yVar, "functionDescriptor");
        if (this.a != null && !m.a(yVar.getName(), this.a)) {
            return false;
        }
        if (this.f24897b != null) {
            String k2 = yVar.getName().k();
            m.e(k2, "functionDescriptor.name.asString()");
            if (!this.f24897b.b(k2)) {
                return false;
            }
        }
        Collection<f> collection = this.f24898c;
        return collection == null || collection.contains(yVar.getName());
    }

    public /* synthetic */ h(f fVar, f[] fVarArr, Function1 function1, int i2, kotlin.jvm.internal.g gVar) {
        this(fVar, fVarArr, (Function1<? super y, String>) ((i2 & 4) != 0 ? a.f24901f : function1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(f fVar, f[] fVarArr, Function1<? super y, String> function1) {
        this(fVar, (Regex) null, (Collection<f>) null, function1, (f[]) Arrays.copyOf(fVarArr, fVarArr.length));
        m.f(fVar, "name");
        m.f(fVarArr, "checks");
        m.f(function1, "additionalChecks");
    }

    public /* synthetic */ h(Regex regex, f[] fVarArr, Function1 function1, int i2, kotlin.jvm.internal.g gVar) {
        this(regex, fVarArr, (Function1<? super y, String>) ((i2 & 4) != 0 ? b.f24902f : function1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Regex regex, f[] fVarArr, Function1<? super y, String> function1) {
        this((f) null, regex, (Collection<f>) null, function1, (f[]) Arrays.copyOf(fVarArr, fVarArr.length));
        m.f(regex, "regex");
        m.f(fVarArr, "checks");
        m.f(function1, "additionalChecks");
    }

    public /* synthetic */ h(Collection collection, f[] fVarArr, Function1 function1, int i2, kotlin.jvm.internal.g gVar) {
        this((Collection<f>) collection, fVarArr, (Function1<? super y, String>) ((i2 & 4) != 0 ? c.f24903f : function1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Collection<f> collection, f[] fVarArr, Function1<? super y, String> function1) {
        this((f) null, (Regex) null, collection, function1, (f[]) Arrays.copyOf(fVarArr, fVarArr.length));
        m.f(collection, "nameList");
        m.f(fVarArr, "checks");
        m.f(function1, "additionalChecks");
    }
}
