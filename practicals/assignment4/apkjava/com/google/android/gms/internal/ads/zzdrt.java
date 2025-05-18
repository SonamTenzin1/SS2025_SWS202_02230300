package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzdrt implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    private static final vx f16073f = new vx();

    /* renamed from: g, reason: collision with root package name */
    private boolean f16074g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f16075h;

    /* renamed from: i, reason: collision with root package name */
    private vx[] f16076i;

    /* renamed from: j, reason: collision with root package name */
    private int f16077j;

    zzdrt() {
        this(10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.f16077j;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i2 = this.f16077j;
        zzdrt zzdrtVar = new zzdrt(i2);
        System.arraycopy(this.f16075h, 0, zzdrtVar.f16075h, 0, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            vx[] vxVarArr = this.f16076i;
            if (vxVarArr[i3] != null) {
                zzdrtVar.f16076i[i3] = (vx) vxVarArr[i3].clone();
            }
        }
        zzdrtVar.f16077j = i2;
        return zzdrtVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final vx d(int i2) {
        return this.f16076i[i2];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdrt)) {
            return false;
        }
        zzdrt zzdrtVar = (zzdrt) obj;
        int i2 = this.f16077j;
        if (i2 != zzdrtVar.f16077j) {
            return false;
        }
        int[] iArr = this.f16075h;
        int[] iArr2 = zzdrtVar.f16075h;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                z = true;
                break;
            }
            if (iArr[i3] != iArr2[i3]) {
                z = false;
                break;
            }
            i3++;
        }
        if (z) {
            vx[] vxVarArr = this.f16076i;
            vx[] vxVarArr2 = zzdrtVar.f16076i;
            int i4 = this.f16077j;
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    z2 = true;
                    break;
                }
                if (!vxVarArr[i5].equals(vxVarArr2[i5])) {
                    z2 = false;
                    break;
                }
                i5++;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = 17;
        for (int i3 = 0; i3 < this.f16077j; i3++) {
            i2 = (((i2 * 31) + this.f16075h[i3]) * 31) + this.f16076i[i3].hashCode();
        }
        return i2;
    }

    private zzdrt(int i2) {
        this.f16074g = false;
        int i3 = i2 << 2;
        int i4 = 4;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            int i5 = (1 << i4) - 12;
            if (i3 <= i5) {
                i3 = i5;
                break;
            }
            i4++;
        }
        int i6 = i3 / 4;
        this.f16075h = new int[i6];
        this.f16076i = new vx[i6];
        this.f16077j = 0;
    }
}
