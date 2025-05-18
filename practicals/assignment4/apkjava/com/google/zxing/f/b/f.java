package com.google.zxing.f.b;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: State.java */
/* loaded from: classes2.dex */
public final class f {
    static final f a = new f(g.a, 0, 0, 0);

    /* renamed from: b, reason: collision with root package name */
    private final int f20334b;

    /* renamed from: c, reason: collision with root package name */
    private final g f20335c;

    /* renamed from: d, reason: collision with root package name */
    private final int f20336d;

    /* renamed from: e, reason: collision with root package name */
    private final int f20337e;

    private f(g gVar, int i2, int i3, int i4) {
        this.f20335c = gVar;
        this.f20334b = i2;
        this.f20336d = i3;
        this.f20337e = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f a(int i2) {
        g gVar = this.f20335c;
        int i3 = this.f20334b;
        int i4 = this.f20337e;
        if (i3 == 4 || i3 == 2) {
            int i5 = d.f20327b[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            gVar = gVar.a(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.f20336d;
        f fVar = new f(gVar, i3, i8 + 1, i4 + ((i8 == 0 || i8 == 31) ? 18 : i8 == 62 ? 9 : 8));
        return fVar.f20336d == 2078 ? fVar.b(i2 + 1) : fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f b(int i2) {
        int i3 = this.f20336d;
        return i3 == 0 ? this : new f(this.f20335c.b(i2 - i3, i3), this.f20334b, 0, this.f20337e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f20336d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f20337e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f20334b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(f fVar) {
        int i2;
        int i3 = this.f20337e + (d.f20327b[this.f20334b][fVar.f20334b] >> 16);
        int i4 = fVar.f20336d;
        if (i4 > 0 && ((i2 = this.f20336d) == 0 || i2 > i4)) {
            i3 += 10;
        }
        return i3 <= fVar.f20337e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f g(int i2, int i3) {
        int i4 = this.f20337e;
        g gVar = this.f20335c;
        int i5 = this.f20334b;
        if (i2 != i5) {
            int i6 = d.f20327b[i5][i2];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            gVar = gVar.a(i7, i8);
            i4 += i8;
        }
        int i9 = i2 == 2 ? 4 : 5;
        return new f(gVar.a(i3, i9), i2, 0, i4 + i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f h(int i2, int i3) {
        g gVar = this.f20335c;
        int i4 = this.f20334b;
        int i5 = i4 == 2 ? 4 : 5;
        return new f(gVar.a(d.f20329d[i4][i2], i5).a(i3, 5), this.f20334b, 0, this.f20337e + i5 + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.g.a i(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (g gVar = b(bArr.length).f20335c; gVar != null; gVar = gVar.d()) {
            linkedList.addFirst(gVar);
        }
        com.google.zxing.g.a aVar = new com.google.zxing.g.a();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.a[this.f20334b], Integer.valueOf(this.f20337e), Integer.valueOf(this.f20336d));
    }
}
