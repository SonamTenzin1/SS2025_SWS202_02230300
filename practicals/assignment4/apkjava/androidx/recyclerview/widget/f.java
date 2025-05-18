package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: DiffUtil.java */
/* loaded from: classes.dex */
public class f {
    private static final Comparator<g> a = new a();

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    static class a implements Comparator<g> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            int i2 = gVar.a - gVar2.a;
            return i2 == 0 ? gVar.f2059b - gVar2.f2059b : i2;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract boolean areContentsTheSame(int i2, int i3);

        public abstract boolean areItemsTheSame(int i2, int i3);

        public Object getChangePayload(int i2, int i3) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class c {
        private final List<g> a;

        /* renamed from: b, reason: collision with root package name */
        private final int[] f2048b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f2049c;

        /* renamed from: d, reason: collision with root package name */
        private final b f2050d;

        /* renamed from: e, reason: collision with root package name */
        private final int f2051e;

        /* renamed from: f, reason: collision with root package name */
        private final int f2052f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f2053g;

        c(b bVar, List<g> list, int[] iArr, int[] iArr2, boolean z) {
            this.a = list;
            this.f2048b = iArr;
            this.f2049c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f2050d = bVar;
            this.f2051e = bVar.getOldListSize();
            this.f2052f = bVar.getNewListSize();
            this.f2053g = z;
            a();
            h();
        }

        private void a() {
            g gVar = this.a.isEmpty() ? null : this.a.get(0);
            if (gVar != null && gVar.a == 0 && gVar.f2059b == 0) {
                return;
            }
            g gVar2 = new g();
            gVar2.a = 0;
            gVar2.f2059b = 0;
            gVar2.f2061d = false;
            gVar2.f2060c = 0;
            gVar2.f2062e = false;
            this.a.add(0, gVar2);
        }

        private void b(List<e> list, l lVar, int i2, int i3, int i4) {
            if (!this.f2053g) {
                lVar.b(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int[] iArr = this.f2049c;
                int i6 = i4 + i5;
                int i7 = iArr[i6] & 31;
                if (i7 == 0) {
                    lVar.b(i2, 1);
                    Iterator<e> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f2054b++;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = iArr[i6] >> 5;
                    lVar.a(j(list, i8, true).f2054b, i2);
                    if (i7 == 4) {
                        lVar.d(i2, 1, this.f2050d.getChangePayload(i8, i6));
                    }
                } else if (i7 == 16) {
                    list.add(new e(i6, i2, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                }
            }
        }

        private void c(List<e> list, l lVar, int i2, int i3, int i4) {
            if (!this.f2053g) {
                lVar.c(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int[] iArr = this.f2048b;
                int i6 = i4 + i5;
                int i7 = iArr[i6] & 31;
                if (i7 == 0) {
                    lVar.c(i2 + i5, 1);
                    Iterator<e> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f2054b--;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = iArr[i6] >> 5;
                    e j2 = j(list, i8, false);
                    lVar.a(i2 + i5, j2.f2054b - 1);
                    if (i7 == 4) {
                        lVar.d(j2.f2054b - 1, 1, this.f2050d.getChangePayload(i6, i8));
                    }
                } else if (i7 == 16) {
                    list.add(new e(i6, i2 + i5, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                }
            }
        }

        private void f(int i2, int i3, int i4) {
            if (this.f2048b[i2 - 1] != 0) {
                return;
            }
            g(i2, i3, i4, false);
        }

        private boolean g(int i2, int i3, int i4, boolean z) {
            int i5;
            int i6;
            int i7;
            if (z) {
                i3--;
                i6 = i2;
                i5 = i3;
            } else {
                i5 = i2 - 1;
                i6 = i5;
            }
            while (i4 >= 0) {
                g gVar = this.a.get(i4);
                int i8 = gVar.a;
                int i9 = gVar.f2060c;
                int i10 = i8 + i9;
                int i11 = gVar.f2059b + i9;
                if (z) {
                    for (int i12 = i6 - 1; i12 >= i10; i12--) {
                        if (this.f2050d.areItemsTheSame(i12, i5)) {
                            i7 = this.f2050d.areContentsTheSame(i12, i5) ? 8 : 4;
                            this.f2049c[i5] = (i12 << 5) | 16;
                            this.f2048b[i12] = (i5 << 5) | i7;
                            return true;
                        }
                    }
                } else {
                    for (int i13 = i3 - 1; i13 >= i11; i13--) {
                        if (this.f2050d.areItemsTheSame(i5, i13)) {
                            i7 = this.f2050d.areContentsTheSame(i5, i13) ? 8 : 4;
                            int i14 = i2 - 1;
                            this.f2048b[i14] = (i13 << 5) | 16;
                            this.f2049c[i13] = (i14 << 5) | i7;
                            return true;
                        }
                    }
                }
                i6 = gVar.a;
                i3 = gVar.f2059b;
                i4--;
            }
            return false;
        }

        private void h() {
            int i2 = this.f2051e;
            int i3 = this.f2052f;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                g gVar = this.a.get(size);
                int i4 = gVar.a;
                int i5 = gVar.f2060c;
                int i6 = i4 + i5;
                int i7 = gVar.f2059b + i5;
                if (this.f2053g) {
                    while (i2 > i6) {
                        f(i2, i3, size);
                        i2--;
                    }
                    while (i3 > i7) {
                        i(i2, i3, size);
                        i3--;
                    }
                }
                for (int i8 = 0; i8 < gVar.f2060c; i8++) {
                    int i9 = gVar.a + i8;
                    int i10 = gVar.f2059b + i8;
                    int i11 = this.f2050d.areContentsTheSame(i9, i10) ? 1 : 2;
                    this.f2048b[i9] = (i10 << 5) | i11;
                    this.f2049c[i10] = (i9 << 5) | i11;
                }
                i2 = gVar.a;
                i3 = gVar.f2059b;
            }
        }

        private void i(int i2, int i3, int i4) {
            if (this.f2049c[i3 - 1] != 0) {
                return;
            }
            g(i2, i3, i4, true);
        }

        private static e j(List<e> list, int i2, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                e eVar = list.get(size);
                if (eVar.a == i2 && eVar.f2055c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f2054b += z ? 1 : -1;
                        size++;
                    }
                    return eVar;
                }
                size--;
            }
            return null;
        }

        public void d(l lVar) {
            androidx.recyclerview.widget.c cVar;
            if (lVar instanceof androidx.recyclerview.widget.c) {
                cVar = (androidx.recyclerview.widget.c) lVar;
            } else {
                cVar = new androidx.recyclerview.widget.c(lVar);
            }
            ArrayList arrayList = new ArrayList();
            int i2 = this.f2051e;
            int i3 = this.f2052f;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                g gVar = this.a.get(size);
                int i4 = gVar.f2060c;
                int i5 = gVar.a + i4;
                int i6 = gVar.f2059b + i4;
                if (i5 < i2) {
                    c(arrayList, cVar, i5, i2 - i5, i5);
                }
                if (i6 < i3) {
                    b(arrayList, cVar, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    int[] iArr = this.f2048b;
                    int i8 = gVar.a;
                    if ((iArr[i8 + i7] & 31) == 2) {
                        cVar.d(i8 + i7, 1, this.f2050d.getChangePayload(i8 + i7, gVar.f2059b + i7));
                    }
                }
                i2 = gVar.a;
                i3 = gVar.f2059b;
            }
            cVar.e();
        }

        public void e(RecyclerView.g gVar) {
            d(new androidx.recyclerview.widget.b(gVar));
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static abstract class d<T> {
        public abstract boolean a(T t, T t2);

        public abstract boolean b(T t, T t2);

        public abstract Object c(T t, T t2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class e {
        int a;

        /* renamed from: b, reason: collision with root package name */
        int f2054b;

        /* renamed from: c, reason: collision with root package name */
        boolean f2055c;

        public e(int i2, int i3, boolean z) {
            this.a = i2;
            this.f2054b = i3;
            this.f2055c = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiffUtil.java */
    /* renamed from: androidx.recyclerview.widget.f$f, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0042f {
        int a;

        /* renamed from: b, reason: collision with root package name */
        int f2056b;

        /* renamed from: c, reason: collision with root package name */
        int f2057c;

        /* renamed from: d, reason: collision with root package name */
        int f2058d;

        public C0042f() {
        }

        public C0042f(int i2, int i3, int i4, int i5) {
            this.a = i2;
            this.f2056b = i3;
            this.f2057c = i4;
            this.f2058d = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class g {
        int a;

        /* renamed from: b, reason: collision with root package name */
        int f2059b;

        /* renamed from: c, reason: collision with root package name */
        int f2060c;

        /* renamed from: d, reason: collision with root package name */
        boolean f2061d;

        /* renamed from: e, reason: collision with root package name */
        boolean f2062e;

        g() {
        }
    }

    public static c a(b bVar) {
        return b(bVar, true);
    }

    public static c b(b bVar, boolean z) {
        int oldListSize = bVar.getOldListSize();
        int newListSize = bVar.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new C0042f(0, oldListSize, 0, newListSize));
        int abs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i2 = abs * 2;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            C0042f c0042f = (C0042f) arrayList2.remove(arrayList2.size() - 1);
            g c2 = c(bVar, c0042f.a, c0042f.f2056b, c0042f.f2057c, c0042f.f2058d, iArr, iArr2, abs);
            if (c2 != null) {
                if (c2.f2060c > 0) {
                    arrayList.add(c2);
                }
                c2.a += c0042f.a;
                c2.f2059b += c0042f.f2057c;
                C0042f c0042f2 = arrayList3.isEmpty() ? new C0042f() : (C0042f) arrayList3.remove(arrayList3.size() - 1);
                c0042f2.a = c0042f.a;
                c0042f2.f2057c = c0042f.f2057c;
                if (c2.f2062e) {
                    c0042f2.f2056b = c2.a;
                    c0042f2.f2058d = c2.f2059b;
                } else if (c2.f2061d) {
                    c0042f2.f2056b = c2.a - 1;
                    c0042f2.f2058d = c2.f2059b;
                } else {
                    c0042f2.f2056b = c2.a;
                    c0042f2.f2058d = c2.f2059b - 1;
                }
                arrayList2.add(c0042f2);
                if (c2.f2062e) {
                    if (c2.f2061d) {
                        int i3 = c2.a;
                        int i4 = c2.f2060c;
                        c0042f.a = i3 + i4 + 1;
                        c0042f.f2057c = c2.f2059b + i4;
                    } else {
                        int i5 = c2.a;
                        int i6 = c2.f2060c;
                        c0042f.a = i5 + i6;
                        c0042f.f2057c = c2.f2059b + i6 + 1;
                    }
                } else {
                    int i7 = c2.a;
                    int i8 = c2.f2060c;
                    c0042f.a = i7 + i8;
                    c0042f.f2057c = c2.f2059b + i8;
                }
                arrayList2.add(c0042f);
            } else {
                arrayList3.add(c0042f);
            }
        }
        Collections.sort(arrayList, a);
        return new c(bVar, arrayList, iArr, iArr2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (r24[r13 - 1] < r24[r13 + r5]) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b8, code lost:
    
        if (r25[r12 - 1] < r25[r12 + 1]) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e1 A[LOOP:4: B:54:0x00cd->B:58:0x00e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ec A[EDGE_INSN: B:59:0x00ec->B:60:0x00ec BREAK  A[LOOP:4: B:54:0x00cd->B:58:0x00e1], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static g c(b bVar, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        int i7;
        int i8;
        boolean z;
        int i9;
        int i10;
        int i11;
        boolean z2;
        int i12;
        int i13 = i3 - i2;
        int i14 = i5 - i4;
        int i15 = 1;
        if (i13 < 1 || i14 < 1) {
            return null;
        }
        int i16 = i13 - i14;
        int i17 = ((i13 + i14) + 1) / 2;
        int i18 = (i6 - i17) - 1;
        int i19 = i6 + i17 + 1;
        Arrays.fill(iArr, i18, i19, 0);
        Arrays.fill(iArr2, i18 + i16, i19 + i16, i13);
        boolean z3 = i16 % 2 != 0;
        int i20 = 0;
        while (i20 <= i17) {
            int i21 = -i20;
            int i22 = i21;
            while (i22 <= i20) {
                if (i22 != i21) {
                    if (i22 != i20) {
                        int i23 = i6 + i22;
                    }
                    i11 = iArr[(i6 + i22) - i15] + i15;
                    z2 = true;
                    for (i12 = i11 - i22; i11 < i13 && i12 < i14 && bVar.areItemsTheSame(i2 + i11, i4 + i12); i12++) {
                        i11++;
                    }
                    int i24 = i6 + i22;
                    iArr[i24] = i11;
                    if (!z3 && i22 >= (i16 - i20) + 1 && i22 <= (i16 + i20) - 1 && iArr[i24] >= iArr2[i24]) {
                        g gVar = new g();
                        int i25 = iArr2[i24];
                        gVar.a = i25;
                        gVar.f2059b = i25 - i22;
                        gVar.f2060c = iArr[i24] - iArr2[i24];
                        gVar.f2061d = z2;
                        gVar.f2062e = false;
                        return gVar;
                    }
                    i22 += 2;
                    i15 = 1;
                }
                i11 = iArr[i6 + i22 + i15];
                z2 = false;
                while (i11 < i13) {
                    i11++;
                }
                int i242 = i6 + i22;
                iArr[i242] = i11;
                if (!z3) {
                }
                i22 += 2;
                i15 = 1;
            }
            int i26 = i21;
            while (i26 <= i20) {
                int i27 = i26 + i16;
                if (i27 != i20 + i16) {
                    if (i27 != i21 + i16) {
                        int i28 = i6 + i27;
                        i7 = 1;
                    } else {
                        i7 = 1;
                    }
                    i8 = iArr2[(i6 + i27) + i7] - i7;
                    z = true;
                    i9 = i8 - i27;
                    while (i8 > 0 && i9 > 0) {
                        i10 = i13;
                        if (bVar.areItemsTheSame((i2 + i8) - 1, (i4 + i9) - 1)) {
                            break;
                        }
                        i8--;
                        i9--;
                        i13 = i10;
                    }
                    i10 = i13;
                    int i29 = i6 + i27;
                    iArr2[i29] = i8;
                    if (z3 && i27 >= i21 && i27 <= i20 && iArr[i29] >= iArr2[i29]) {
                        g gVar2 = new g();
                        int i30 = iArr2[i29];
                        gVar2.a = i30;
                        gVar2.f2059b = i30 - i27;
                        gVar2.f2060c = iArr[i29] - iArr2[i29];
                        gVar2.f2061d = z;
                        gVar2.f2062e = true;
                        return gVar2;
                    }
                    i26 += 2;
                    i13 = i10;
                } else {
                    i7 = 1;
                }
                i8 = iArr2[(i6 + i27) - i7];
                z = false;
                i9 = i8 - i27;
                while (i8 > 0) {
                    i10 = i13;
                    if (bVar.areItemsTheSame((i2 + i8) - 1, (i4 + i9) - 1)) {
                    }
                }
                i10 = i13;
                int i292 = i6 + i27;
                iArr2[i292] = i8;
                if (z3) {
                }
                i26 += 2;
                i13 = i10;
            }
            i20++;
            i13 = i13;
            i15 = 1;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
