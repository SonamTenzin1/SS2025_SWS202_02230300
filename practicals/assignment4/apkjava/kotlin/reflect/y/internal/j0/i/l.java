package kotlin.reflect.y.internal.j0.i;

import android.R;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.collections.s;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.utils.f;
import kotlin.u;

/* compiled from: overridingUtils.kt */
/* loaded from: classes3.dex */
public final class l {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [H] */
    /* compiled from: overridingUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a<H> extends Lambda implements Function1<H, u> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f<H> f24350f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(f<H> fVar) {
            super(1);
            this.f24350f = fVar;
        }

        public final void b(H h2) {
            f<H> fVar = this.f24350f;
            m.e(h2, "it");
            fVar.add(h2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Object obj) {
            b(obj);
            return u.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> a(Collection<? extends H> collection, Function1<? super H, ? extends kotlin.reflect.jvm.internal.impl.descriptors.a> function1) {
        m.f(collection, "<this>");
        m.f(function1, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        f a2 = f.f25524f.a();
        while (!linkedList.isEmpty()) {
            Object U = s.U(linkedList);
            f a3 = f.f25524f.a();
            Collection<R.attr> p = j.p(U, linkedList, function1, new a(a3));
            m.e(p, "val conflictedHandles = …nflictedHandles.add(it) }");
            if (p.size() == 1 && a3.isEmpty()) {
                Object r0 = s.r0(p);
                m.e(r0, "overridableGroup.single()");
                a2.add(r0);
            } else {
                R.attr attrVar = (Object) j.L(p, function1);
                m.e(attrVar, "selectMostSpecificMember…roup, descriptorByHandle)");
                kotlin.reflect.jvm.internal.impl.descriptors.a invoke = function1.invoke(attrVar);
                for (R.attr attrVar2 : p) {
                    m.e(attrVar2, "it");
                    if (!j.B(invoke, function1.invoke(attrVar2))) {
                        a3.add(attrVar2);
                    }
                }
                if (!a3.isEmpty()) {
                    a2.addAll(a3);
                }
                a2.add(attrVar);
            }
        }
        return a2;
    }
}
