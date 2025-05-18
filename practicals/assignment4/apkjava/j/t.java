package j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.AbstractList;

/* compiled from: Options.kt */
/* loaded from: classes3.dex */
public final class t extends AbstractList<i> implements RandomAccess {

    /* renamed from: g, reason: collision with root package name */
    public static final a f22860g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private final i[] f22861h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f22862i;

    /* compiled from: Options.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        private final void a(long j2, f fVar, int i2, List<? extends i> list, int i3, int i4, List<Integer> list2) {
            int i5;
            int i6;
            int i7;
            int i8;
            f fVar2;
            int i9 = i2;
            if (i3 < i4) {
                for (int i10 = i3; i10 < i4; i10++) {
                    if (!(list.get(i10).P() >= i9)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                i iVar = list.get(i3);
                i iVar2 = list.get(i4 - 1);
                if (i9 == iVar.P()) {
                    int intValue = list2.get(i3).intValue();
                    int i11 = i3 + 1;
                    i iVar3 = list.get(i11);
                    i5 = i11;
                    i6 = intValue;
                    iVar = iVar3;
                } else {
                    i5 = i3;
                    i6 = -1;
                }
                if (iVar.x(i9) != iVar2.x(i9)) {
                    int i12 = 1;
                    for (int i13 = i5 + 1; i13 < i4; i13++) {
                        if (list.get(i13 - 1).x(i9) != list.get(i13).x(i9)) {
                            i12++;
                        }
                    }
                    long c2 = j2 + c(fVar) + 2 + (i12 * 2);
                    fVar.writeInt(i12);
                    fVar.writeInt(i6);
                    for (int i14 = i5; i14 < i4; i14++) {
                        byte x = list.get(i14).x(i9);
                        if (i14 == i5 || x != list.get(i14 - 1).x(i9)) {
                            fVar.writeInt(x & 255);
                        }
                    }
                    f fVar3 = new f();
                    while (i5 < i4) {
                        byte x2 = list.get(i5).x(i9);
                        int i15 = i5 + 1;
                        int i16 = i15;
                        while (true) {
                            if (i16 >= i4) {
                                i7 = i4;
                                break;
                            } else {
                                if (x2 != list.get(i16).x(i9)) {
                                    i7 = i16;
                                    break;
                                }
                                i16++;
                            }
                        }
                        if (i15 == i7 && i9 + 1 == list.get(i5).P()) {
                            fVar.writeInt(list2.get(i5).intValue());
                            i8 = i7;
                            fVar2 = fVar3;
                        } else {
                            fVar.writeInt(((int) (c2 + c(fVar3))) * (-1));
                            i8 = i7;
                            fVar2 = fVar3;
                            a(c2, fVar3, i9 + 1, list, i5, i7, list2);
                        }
                        fVar3 = fVar2;
                        i5 = i8;
                    }
                    fVar.B0(fVar3);
                    return;
                }
                int min = Math.min(iVar.P(), iVar2.P());
                int i17 = 0;
                for (int i18 = i9; i18 < min && iVar.x(i18) == iVar2.x(i18); i18++) {
                    i17++;
                }
                long c3 = j2 + c(fVar) + 2 + i17 + 1;
                fVar.writeInt(-i17);
                fVar.writeInt(i6);
                int i19 = i9 + i17;
                while (i9 < i19) {
                    fVar.writeInt(iVar.x(i9) & 255);
                    i9++;
                }
                if (i5 + 1 == i4) {
                    if (i19 == list.get(i5).P()) {
                        fVar.writeInt(list2.get(i5).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                f fVar4 = new f();
                fVar.writeInt(((int) (c(fVar4) + c3)) * (-1));
                a(c3, fVar4, i19, list, i5, i4, list2);
                fVar.B0(fVar4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        static /* synthetic */ void b(a aVar, long j2, f fVar, int i2, List list, int i3, int i4, List list2, int i5, Object obj) {
            aVar.a((i5 & 1) != 0 ? 0L : j2, fVar, (i5 & 4) != 0 ? 0 : i2, list, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? list.size() : i4, list2);
        }

        private final long c(f fVar) {
            return fVar.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ee, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final t d(i... iVarArr) {
            List i0;
            List p;
            int i2;
            kotlin.jvm.internal.m.f(iVarArr, "byteStrings");
            int i3 = 0;
            kotlin.jvm.internal.g gVar = null;
            if (iVarArr.length == 0) {
                return new t(new i[0], new int[]{0, -1}, gVar);
            }
            i0 = kotlin.collections.n.i0(iVarArr);
            kotlin.collections.y.x(i0);
            ArrayList arrayList = new ArrayList(iVarArr.length);
            for (i iVar : iVarArr) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array != null) {
                Integer[] numArr = (Integer[]) array;
                p = kotlin.collections.u.p((Integer[]) Arrays.copyOf(numArr, numArr.length));
                int length = iVarArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    i2 = kotlin.collections.u.i(i0, iVarArr[i4], 0, 0, 6, null);
                    p.set(i2, Integer.valueOf(i5));
                    i4++;
                    i5++;
                }
                if (((i) i0.get(0)).P() > 0) {
                    int i6 = 0;
                    while (i6 < i0.size()) {
                        i iVar2 = (i) i0.get(i6);
                        int i7 = i6 + 1;
                        int i8 = i7;
                        while (i8 < i0.size()) {
                            i iVar3 = (i) i0.get(i8);
                            if (!iVar3.Q(iVar2)) {
                                break;
                            }
                            if (!(iVar3.P() != iVar2.P())) {
                                throw new IllegalArgumentException(("duplicate option: " + iVar3).toString());
                            }
                            if (((Number) p.get(i8)).intValue() > ((Number) p.get(i6)).intValue()) {
                                i0.remove(i8);
                                p.remove(i8);
                            } else {
                                i8++;
                            }
                        }
                        i6 = i7;
                    }
                    f fVar = new f();
                    b(this, 0L, fVar, 0, i0, 0, 0, p, 53, null);
                    int[] iArr = new int[(int) c(fVar)];
                    while (!fVar.R()) {
                        iArr[i3] = fVar.readInt();
                        i3++;
                    }
                    Object[] copyOf = Arrays.copyOf(iVarArr, iVarArr.length);
                    kotlin.jvm.internal.m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                    return new t((i[]) copyOf, iArr, gVar);
                }
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public /* synthetic */ t(i[] iVarArr, int[] iArr, kotlin.jvm.internal.g gVar) {
        this(iVarArr, iArr);
    }

    public static final t r(i... iVarArr) {
        return f22860g.d(iVarArr);
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: c */
    public int getF25541i() {
        return this.f22861h.length;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof i) {
            return f((i) obj);
        }
        return false;
    }

    public /* bridge */ boolean f(i iVar) {
        return super.contains(iVar);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public i get(int i2) {
        return this.f22861h[i2];
    }

    public final i[] i() {
        return this.f22861h;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof i) {
            return o((i) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof i) {
            return q((i) obj);
        }
        return -1;
    }

    public final int[] n() {
        return this.f22862i;
    }

    public /* bridge */ int o(i iVar) {
        return super.indexOf(iVar);
    }

    public /* bridge */ int q(i iVar) {
        return super.lastIndexOf(iVar);
    }

    private t(i[] iVarArr, int[] iArr) {
        this.f22861h = iVarArr;
        this.f22862i = iArr;
    }
}
