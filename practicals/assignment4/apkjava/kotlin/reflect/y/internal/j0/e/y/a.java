package kotlin.reflect.y.internal.j0.e.y;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;

/* compiled from: BuiltInsBinaryVersion.kt */
/* loaded from: classes3.dex */
public final class a extends kotlin.reflect.y.internal.j0.e.z.a {

    /* renamed from: g, reason: collision with root package name */
    public static final C0368a f24164g = new C0368a(null);

    /* renamed from: h, reason: collision with root package name */
    public static final a f24165h = new a(1, 0, 7);

    /* renamed from: i, reason: collision with root package name */
    public static final a f24166i = new a(new int[0]);

    /* compiled from: BuiltInsBinaryVersion.kt */
    /* renamed from: kotlin.f0.y.e.j0.e.y.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0368a {
        private C0368a() {
        }

        public /* synthetic */ C0368a(g gVar) {
            this();
        }

        public final a a(InputStream inputStream) {
            int u;
            int[] D0;
            m.f(inputStream, "stream");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            IntRange intRange = new IntRange(1, dataInputStream.readInt());
            u = v.u(intRange, 10);
            ArrayList arrayList = new ArrayList(u);
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                ((IntIterator) it).b();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            D0 = c0.D0(arrayList);
            return new a(Arrays.copyOf(D0, D0.length));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int... iArr) {
        super(Arrays.copyOf(iArr, iArr.length));
        m.f(iArr, "numbers");
    }

    public boolean h() {
        return f(f24165h);
    }
}
