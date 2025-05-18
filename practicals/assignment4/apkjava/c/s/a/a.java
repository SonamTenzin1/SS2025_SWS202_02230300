package c.s.a;

import android.graphics.Color;
import android.util.TimingLogger;
import c.s.a.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorCutQuantizer.java */
/* loaded from: classes.dex */
public final class a {
    private static final Comparator<b> a = new C0092a();

    /* renamed from: b, reason: collision with root package name */
    final int[] f3411b;

    /* renamed from: c, reason: collision with root package name */
    final int[] f3412c;

    /* renamed from: d, reason: collision with root package name */
    final List<b.e> f3413d;

    /* renamed from: f, reason: collision with root package name */
    final b.c[] f3415f;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f3416g = new float[3];

    /* renamed from: e, reason: collision with root package name */
    final TimingLogger f3414e = null;

    /* compiled from: ColorCutQuantizer.java */
    /* renamed from: c.s.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0092a implements Comparator<b> {
        C0092a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar2.g() - bVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ColorCutQuantizer.java */
    /* loaded from: classes.dex */
    public class b {
        private int a;

        /* renamed from: b, reason: collision with root package name */
        private int f3417b;

        /* renamed from: c, reason: collision with root package name */
        private int f3418c;

        /* renamed from: d, reason: collision with root package name */
        private int f3419d;

        /* renamed from: e, reason: collision with root package name */
        private int f3420e;

        /* renamed from: f, reason: collision with root package name */
        private int f3421f;

        /* renamed from: g, reason: collision with root package name */
        private int f3422g;

        /* renamed from: h, reason: collision with root package name */
        private int f3423h;

        /* renamed from: i, reason: collision with root package name */
        private int f3424i;

        b(int i2, int i3) {
            this.a = i2;
            this.f3417b = i3;
            c();
        }

        final boolean a() {
            return e() > 1;
        }

        final int b() {
            int f2 = f();
            a aVar = a.this;
            int[] iArr = aVar.f3411b;
            int[] iArr2 = aVar.f3412c;
            a.e(iArr, f2, this.a, this.f3417b);
            Arrays.sort(iArr, this.a, this.f3417b + 1);
            a.e(iArr, f2, this.a, this.f3417b);
            int i2 = this.f3418c / 2;
            int i3 = this.a;
            int i4 = 0;
            while (true) {
                int i5 = this.f3417b;
                if (i3 <= i5) {
                    i4 += iArr2[iArr[i3]];
                    if (i4 >= i2) {
                        return Math.min(i5 - 1, i3);
                    }
                    i3++;
                } else {
                    return this.a;
                }
            }
        }

        final void c() {
            a aVar = a.this;
            int[] iArr = aVar.f3411b;
            int[] iArr2 = aVar.f3412c;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = 0;
            for (int i9 = this.a; i9 <= this.f3417b; i9++) {
                int i10 = iArr[i9];
                i8 += iArr2[i10];
                int k2 = a.k(i10);
                int j2 = a.j(i10);
                int i11 = a.i(i10);
                if (k2 > i5) {
                    i5 = k2;
                }
                if (k2 < i2) {
                    i2 = k2;
                }
                if (j2 > i6) {
                    i6 = j2;
                }
                if (j2 < i3) {
                    i3 = j2;
                }
                if (i11 > i7) {
                    i7 = i11;
                }
                if (i11 < i4) {
                    i4 = i11;
                }
            }
            this.f3419d = i2;
            this.f3420e = i5;
            this.f3421f = i3;
            this.f3422g = i6;
            this.f3423h = i4;
            this.f3424i = i7;
            this.f3418c = i8;
        }

        final b.e d() {
            a aVar = a.this;
            int[] iArr = aVar.f3411b;
            int[] iArr2 = aVar.f3412c;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = this.a; i6 <= this.f3417b; i6++) {
                int i7 = iArr[i6];
                int i8 = iArr2[i7];
                i3 += i8;
                i2 += a.k(i7) * i8;
                i4 += a.j(i7) * i8;
                i5 += i8 * a.i(i7);
            }
            float f2 = i3;
            return new b.e(a.b(Math.round(i2 / f2), Math.round(i4 / f2), Math.round(i5 / f2)), i3);
        }

        final int e() {
            return (this.f3417b + 1) - this.a;
        }

        final int f() {
            int i2 = this.f3420e - this.f3419d;
            int i3 = this.f3422g - this.f3421f;
            int i4 = this.f3424i - this.f3423h;
            if (i2 < i3 || i2 < i4) {
                return (i3 < i2 || i3 < i4) ? -1 : -2;
            }
            return -3;
        }

        final int g() {
            return ((this.f3420e - this.f3419d) + 1) * ((this.f3422g - this.f3421f) + 1) * ((this.f3424i - this.f3423h) + 1);
        }

        final b h() {
            if (a()) {
                int b2 = b();
                b bVar = new b(b2 + 1, this.f3417b);
                this.f3417b = b2;
                c();
                return bVar;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int[] iArr, int i2, b.c[] cVarArr) {
        this.f3415f = cVarArr;
        int[] iArr2 = new int[32768];
        this.f3412c = iArr2;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int g2 = g(iArr[i3]);
            iArr[i3] = g2;
            iArr2[g2] = iArr2[g2] + 1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 32768; i5++) {
            if (iArr2[i5] > 0 && l(i5)) {
                iArr2[i5] = 0;
            }
            if (iArr2[i5] > 0) {
                i4++;
            }
        }
        int[] iArr3 = new int[i4];
        this.f3411b = iArr3;
        int i6 = 0;
        for (int i7 = 0; i7 < 32768; i7++) {
            if (iArr2[i7] > 0) {
                iArr3[i6] = i7;
                i6++;
            }
        }
        if (i4 <= i2) {
            this.f3413d = new ArrayList();
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = iArr3[i8];
                this.f3413d.add(new b.e(a(i9), iArr2[i9]));
            }
            return;
        }
        this.f3413d = h(i2);
    }

    private static int a(int i2) {
        return b(k(i2), j(i2), i(i2));
    }

    static int b(int i2, int i3, int i4) {
        return Color.rgb(f(i2, 5, 8), f(i3, 5, 8), f(i4, 5, 8));
    }

    private List<b.e> c(Collection<b> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<b> it = collection.iterator();
        while (it.hasNext()) {
            b.e d2 = it.next().d();
            if (!n(d2)) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    static void e(int[] iArr, int i2, int i3, int i4) {
        if (i2 == -2) {
            while (i3 <= i4) {
                int i5 = iArr[i3];
                iArr[i3] = i(i5) | (j(i5) << 10) | (k(i5) << 5);
                i3++;
            }
            return;
        }
        if (i2 != -1) {
            return;
        }
        while (i3 <= i4) {
            int i6 = iArr[i3];
            iArr[i3] = k(i6) | (i(i6) << 10) | (j(i6) << 5);
            i3++;
        }
    }

    private static int f(int i2, int i3, int i4) {
        return (i4 > i3 ? i2 << (i4 - i3) : i2 >> (i3 - i4)) & ((1 << i4) - 1);
    }

    private static int g(int i2) {
        return f(Color.blue(i2), 8, 5) | (f(Color.red(i2), 8, 5) << 10) | (f(Color.green(i2), 8, 5) << 5);
    }

    private List<b.e> h(int i2) {
        PriorityQueue<b> priorityQueue = new PriorityQueue<>(i2, a);
        priorityQueue.offer(new b(0, this.f3411b.length - 1));
        o(priorityQueue, i2);
        return c(priorityQueue);
    }

    static int i(int i2) {
        return i2 & 31;
    }

    static int j(int i2) {
        return (i2 >> 5) & 31;
    }

    static int k(int i2) {
        return (i2 >> 10) & 31;
    }

    private boolean l(int i2) {
        int a2 = a(i2);
        c.i.e.a.g(a2, this.f3416g);
        return m(a2, this.f3416g);
    }

    private boolean m(int i2, float[] fArr) {
        b.c[] cVarArr = this.f3415f;
        if (cVarArr != null && cVarArr.length > 0) {
            int length = cVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (!this.f3415f[i3].a(i2, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean n(b.e eVar) {
        return m(eVar.e(), eVar.c());
    }

    private void o(PriorityQueue<b> priorityQueue, int i2) {
        b poll;
        while (priorityQueue.size() < i2 && (poll = priorityQueue.poll()) != null && poll.a()) {
            priorityQueue.offer(poll.h());
            priorityQueue.offer(poll);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b.e> d() {
        return this.f3413d;
    }
}
