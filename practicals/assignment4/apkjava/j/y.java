package j;

import java.util.Arrays;

/* compiled from: Segment.kt */
/* loaded from: classes3.dex */
public final class y {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f22878b;

    /* renamed from: c, reason: collision with root package name */
    public int f22879c;

    /* renamed from: d, reason: collision with root package name */
    public int f22880d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f22881e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f22882f;

    /* renamed from: g, reason: collision with root package name */
    public y f22883g;

    /* renamed from: h, reason: collision with root package name */
    public y f22884h;

    /* compiled from: Segment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public y() {
        this.f22878b = new byte[8192];
        this.f22882f = true;
        this.f22881e = false;
    }

    public final void a() {
        y yVar = this.f22884h;
        int i2 = 0;
        if (yVar != this) {
            kotlin.jvm.internal.m.c(yVar);
            if (yVar.f22882f) {
                int i3 = this.f22880d - this.f22879c;
                y yVar2 = this.f22884h;
                kotlin.jvm.internal.m.c(yVar2);
                int i4 = 8192 - yVar2.f22880d;
                y yVar3 = this.f22884h;
                kotlin.jvm.internal.m.c(yVar3);
                if (!yVar3.f22881e) {
                    y yVar4 = this.f22884h;
                    kotlin.jvm.internal.m.c(yVar4);
                    i2 = yVar4.f22879c;
                }
                if (i3 > i4 + i2) {
                    return;
                }
                y yVar5 = this.f22884h;
                kotlin.jvm.internal.m.c(yVar5);
                g(yVar5, i3);
                b();
                z.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    public final y b() {
        y yVar = this.f22883g;
        if (yVar == this) {
            yVar = null;
        }
        y yVar2 = this.f22884h;
        kotlin.jvm.internal.m.c(yVar2);
        yVar2.f22883g = this.f22883g;
        y yVar3 = this.f22883g;
        kotlin.jvm.internal.m.c(yVar3);
        yVar3.f22884h = this.f22884h;
        this.f22883g = null;
        this.f22884h = null;
        return yVar;
    }

    public final y c(y yVar) {
        kotlin.jvm.internal.m.f(yVar, "segment");
        yVar.f22884h = this;
        yVar.f22883g = this.f22883g;
        y yVar2 = this.f22883g;
        kotlin.jvm.internal.m.c(yVar2);
        yVar2.f22884h = yVar;
        this.f22883g = yVar;
        return yVar;
    }

    public final y d() {
        this.f22881e = true;
        return new y(this.f22878b, this.f22879c, this.f22880d, true, false);
    }

    public final y e(int i2) {
        y c2;
        if (i2 > 0 && i2 <= this.f22880d - this.f22879c) {
            if (i2 >= 1024) {
                c2 = d();
            } else {
                c2 = z.c();
                byte[] bArr = this.f22878b;
                byte[] bArr2 = c2.f22878b;
                int i3 = this.f22879c;
                kotlin.collections.m.f(bArr, bArr2, 0, i3, i3 + i2, 2, null);
            }
            c2.f22880d = c2.f22879c + i2;
            this.f22879c += i2;
            y yVar = this.f22884h;
            kotlin.jvm.internal.m.c(yVar);
            yVar.c(c2);
            return c2;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final y f() {
        byte[] bArr = this.f22878b;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new y(copyOf, this.f22879c, this.f22880d, false, true);
    }

    public final void g(y yVar, int i2) {
        kotlin.jvm.internal.m.f(yVar, "sink");
        if (yVar.f22882f) {
            int i3 = yVar.f22880d;
            if (i3 + i2 > 8192) {
                if (!yVar.f22881e) {
                    int i4 = yVar.f22879c;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = yVar.f22878b;
                        kotlin.collections.m.f(bArr, bArr, 0, i4, i3, 2, null);
                        yVar.f22880d -= yVar.f22879c;
                        yVar.f22879c = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f22878b;
            byte[] bArr3 = yVar.f22878b;
            int i5 = yVar.f22880d;
            int i6 = this.f22879c;
            kotlin.collections.m.d(bArr2, bArr3, i5, i6, i6 + i2);
            yVar.f22880d += i2;
            this.f22879c += i2;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public y(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        kotlin.jvm.internal.m.f(bArr, "data");
        this.f22878b = bArr;
        this.f22879c = i2;
        this.f22880d = i3;
        this.f22881e = z;
        this.f22882f = z2;
    }
}
