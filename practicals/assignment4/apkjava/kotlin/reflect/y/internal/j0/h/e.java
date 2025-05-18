package kotlin.reflect.y.internal.j0.h;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.jvm.internal.g;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
public enum e {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);


    /* renamed from: f, reason: collision with root package name */
    public static final a f24275f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final Set<e> f24276g;

    /* renamed from: h, reason: collision with root package name */
    public static final Set<e> f24277h;
    private final boolean x;

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        Set<e> I0;
        Set<e> l0;
        e[] values = values();
        ArrayList arrayList = new ArrayList();
        for (e eVar : values) {
            if (eVar.x) {
                arrayList.add(eVar);
            }
        }
        I0 = c0.I0(arrayList);
        f24276g = I0;
        l0 = n.l0(values());
        f24277h = l0;
    }

    e(boolean z) {
        this.x = z;
    }
}
