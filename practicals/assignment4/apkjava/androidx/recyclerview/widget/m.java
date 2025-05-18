package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OpReorderer.java */
/* loaded from: classes.dex */
public class m {
    final a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OpReorderer.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(a.b bVar);

        a.b b(int i2, int i3, int i4, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.a = aVar;
    }

    private int a(List<a.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<a.b> list, int i2, a.b bVar, int i3, a.b bVar2) {
        int i4 = bVar.f2008d;
        int i5 = bVar2.f2006b;
        int i6 = i4 < i5 ? -1 : 0;
        int i7 = bVar.f2006b;
        if (i7 < i5) {
            i6++;
        }
        if (i5 <= i7) {
            bVar.f2006b = i7 + bVar2.f2008d;
        }
        int i8 = bVar2.f2006b;
        if (i8 <= i4) {
            bVar.f2008d = i4 + bVar2.f2008d;
        }
        bVar2.f2006b = i8 + i6;
        list.set(i2, bVar2);
        list.set(i3, bVar);
    }

    private void d(List<a.b> list, int i2, int i3) {
        a.b bVar = list.get(i2);
        a.b bVar2 = list.get(i3);
        int i4 = bVar2.a;
        if (i4 == 1) {
            c(list, i2, bVar, i3, bVar2);
        } else if (i4 == 2) {
            e(list, i2, bVar, i3, bVar2);
        } else {
            if (i4 != 4) {
                return;
            }
            f(list, i2, bVar, i3, bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(List<a.b> list) {
        while (true) {
            int a2 = a(list);
            if (a2 == -1) {
                return;
            } else {
                d(list, a2, a2 + 1);
            }
        }
    }

    void e(List<a.b> list, int i2, a.b bVar, int i3, a.b bVar2) {
        boolean z;
        int i4 = bVar.f2006b;
        int i5 = bVar.f2008d;
        boolean z2 = false;
        if (i4 < i5) {
            if (bVar2.f2006b == i4 && bVar2.f2008d == i5 - i4) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.f2006b == i5 + 1 && bVar2.f2008d == i4 - i5) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i6 = bVar2.f2006b;
        if (i5 < i6) {
            bVar2.f2006b = i6 - 1;
        } else {
            int i7 = bVar2.f2008d;
            if (i5 < i6 + i7) {
                bVar2.f2008d = i7 - 1;
                bVar.a = 2;
                bVar.f2008d = 1;
                if (bVar2.f2008d == 0) {
                    list.remove(i3);
                    this.a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i8 = bVar.f2006b;
        int i9 = bVar2.f2006b;
        a.b bVar3 = null;
        if (i8 <= i9) {
            bVar2.f2006b = i9 + 1;
        } else {
            int i10 = bVar2.f2008d;
            if (i8 < i9 + i10) {
                bVar3 = this.a.b(2, i8 + 1, (i9 + i10) - i8, null);
                bVar2.f2008d = bVar.f2006b - bVar2.f2006b;
            }
        }
        if (z2) {
            list.set(i2, bVar2);
            list.remove(i3);
            this.a.a(bVar);
            return;
        }
        if (z) {
            if (bVar3 != null) {
                int i11 = bVar.f2006b;
                if (i11 > bVar3.f2006b) {
                    bVar.f2006b = i11 - bVar3.f2008d;
                }
                int i12 = bVar.f2008d;
                if (i12 > bVar3.f2006b) {
                    bVar.f2008d = i12 - bVar3.f2008d;
                }
            }
            int i13 = bVar.f2006b;
            if (i13 > bVar2.f2006b) {
                bVar.f2006b = i13 - bVar2.f2008d;
            }
            int i14 = bVar.f2008d;
            if (i14 > bVar2.f2006b) {
                bVar.f2008d = i14 - bVar2.f2008d;
            }
        } else {
            if (bVar3 != null) {
                int i15 = bVar.f2006b;
                if (i15 >= bVar3.f2006b) {
                    bVar.f2006b = i15 - bVar3.f2008d;
                }
                int i16 = bVar.f2008d;
                if (i16 >= bVar3.f2006b) {
                    bVar.f2008d = i16 - bVar3.f2008d;
                }
            }
            int i17 = bVar.f2006b;
            if (i17 >= bVar2.f2006b) {
                bVar.f2006b = i17 - bVar2.f2008d;
            }
            int i18 = bVar.f2008d;
            if (i18 >= bVar2.f2006b) {
                bVar.f2008d = i18 - bVar2.f2008d;
            }
        }
        list.set(i2, bVar2);
        if (bVar.f2006b != bVar.f2008d) {
            list.set(i3, bVar);
        } else {
            list.remove(i3);
        }
        if (bVar3 != null) {
            list.add(i2, bVar3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void f(List<a.b> list, int i2, a.b bVar, int i3, a.b bVar2) {
        a.b b2;
        int i4;
        int i5;
        int i6 = bVar.f2008d;
        int i7 = bVar2.f2006b;
        a.b bVar3 = null;
        if (i6 < i7) {
            bVar2.f2006b = i7 - 1;
        } else {
            int i8 = bVar2.f2008d;
            if (i6 < i7 + i8) {
                bVar2.f2008d = i8 - 1;
                b2 = this.a.b(4, bVar.f2006b, 1, bVar2.f2007c);
                i4 = bVar.f2006b;
                i5 = bVar2.f2006b;
                if (i4 > i5) {
                    bVar2.f2006b = i5 + 1;
                } else {
                    int i9 = bVar2.f2008d;
                    if (i4 < i5 + i9) {
                        int i10 = (i5 + i9) - i4;
                        bVar3 = this.a.b(4, i4 + 1, i10, bVar2.f2007c);
                        bVar2.f2008d -= i10;
                    }
                }
                list.set(i3, bVar);
                if (bVar2.f2008d <= 0) {
                    list.set(i2, bVar2);
                } else {
                    list.remove(i2);
                    this.a.a(bVar2);
                }
                if (b2 != null) {
                    list.add(i2, b2);
                }
                if (bVar3 == null) {
                    list.add(i2, bVar3);
                    return;
                }
                return;
            }
        }
        b2 = null;
        i4 = bVar.f2006b;
        i5 = bVar2.f2006b;
        if (i4 > i5) {
        }
        list.set(i3, bVar);
        if (bVar2.f2008d <= 0) {
        }
        if (b2 != null) {
        }
        if (bVar3 == null) {
        }
    }
}
