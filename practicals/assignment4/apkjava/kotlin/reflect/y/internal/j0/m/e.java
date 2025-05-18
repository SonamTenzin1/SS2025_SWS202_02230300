package kotlin.reflect.y.internal.j0.m;

import kotlin.jvm.internal.m;
import kotlin.reflect.KClass;

/* compiled from: AttributeArrayOwner.kt */
/* loaded from: classes3.dex */
public abstract class e<K, T> extends a<K, T> {

    /* renamed from: f, reason: collision with root package name */
    private c<T> f24893f;

    protected e(c<T> cVar) {
        m.f(cVar, "arrayMap");
        this.f24893f = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.m.a
    public final c<T> c() {
        return this.f24893f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final void h(KClass<? extends K> kClass, T t) {
        m.f(kClass, "tClass");
        m.f(t, "value");
        int d2 = f().d(kClass);
        int c2 = this.f24893f.c();
        if (c2 != 0) {
            if (c2 == 1) {
                c<T> cVar = this.f24893f;
                m.d(cVar, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                o oVar = (o) cVar;
                if (oVar.h() == d2) {
                    this.f24893f = new o(t, d2);
                    return;
                } else {
                    d dVar = new d();
                    this.f24893f = dVar;
                    dVar.f(oVar.h(), oVar.i());
                }
            }
            this.f24893f.f(d2, t);
            return;
        }
        this.f24893f = new o(t, d2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e() {
        this(r0);
        i iVar = i.f24904f;
        m.d(iVar, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
    }
}
