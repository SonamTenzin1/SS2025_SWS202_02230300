package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.f;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: classes2.dex */
public final class j extends f implements kotlin.reflect.y.internal.j0.d.a.n0.e {

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f25344c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(kotlin.reflect.y.internal.j0.f.f fVar, Object[] objArr) {
        super(fVar, null);
        kotlin.jvm.internal.m.f(objArr, "values");
        this.f25344c = objArr;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.e
    public List<f> e() {
        Object[] objArr = this.f25344c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            f.a aVar = f.a;
            kotlin.jvm.internal.m.c(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
