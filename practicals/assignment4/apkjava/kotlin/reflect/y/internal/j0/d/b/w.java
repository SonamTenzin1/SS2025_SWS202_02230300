package kotlin.reflect.y.internal.j0.d.b;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;

/* compiled from: PackagePartProvider.kt */
/* loaded from: classes3.dex */
public interface w {

    /* compiled from: PackagePartProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a implements w {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.reflect.y.internal.j0.d.b.w
        public List<String> a(String str) {
            List<String> j2;
            m.f(str, "packageFqName");
            j2 = u.j();
            return j2;
        }
    }

    List<String> a(String str);
}
