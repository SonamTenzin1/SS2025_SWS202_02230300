package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zzdtd {
    public static final zzdtd a = new zzdtd(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: b, reason: collision with root package name */
    private static final zzdtd f16158b = new zzdtd(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: c, reason: collision with root package name */
    private static final zzdtd f16159c = new zzdtd(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: d, reason: collision with root package name */
    private static final zzdtd f16160d = new zzdtd(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: e, reason: collision with root package name */
    private final double f16161e;

    /* renamed from: f, reason: collision with root package name */
    private final double f16162f;

    /* renamed from: g, reason: collision with root package name */
    private final double f16163g;

    /* renamed from: h, reason: collision with root package name */
    private final double f16164h;

    /* renamed from: i, reason: collision with root package name */
    private final double f16165i;

    /* renamed from: j, reason: collision with root package name */
    private final double f16166j;

    /* renamed from: k, reason: collision with root package name */
    private final double f16167k;
    private final double l;
    private final double m;

    private zzdtd(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.f16161e = d6;
        this.f16162f = d7;
        this.f16163g = d8;
        this.f16164h = d2;
        this.f16165i = d3;
        this.f16166j = d4;
        this.f16167k = d5;
        this.l = d9;
        this.m = d10;
    }

    public static zzdtd a(ByteBuffer byteBuffer) {
        double e2 = zzbc.e(byteBuffer);
        double e3 = zzbc.e(byteBuffer);
        double f2 = zzbc.f(byteBuffer);
        return new zzdtd(e2, e3, zzbc.e(byteBuffer), zzbc.e(byteBuffer), f2, zzbc.f(byteBuffer), zzbc.f(byteBuffer), zzbc.e(byteBuffer), zzbc.e(byteBuffer));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzdtd.class != obj.getClass()) {
            return false;
        }
        zzdtd zzdtdVar = (zzdtd) obj;
        return Double.compare(zzdtdVar.f16164h, this.f16164h) == 0 && Double.compare(zzdtdVar.f16165i, this.f16165i) == 0 && Double.compare(zzdtdVar.f16166j, this.f16166j) == 0 && Double.compare(zzdtdVar.f16167k, this.f16167k) == 0 && Double.compare(zzdtdVar.l, this.l) == 0 && Double.compare(zzdtdVar.m, this.m) == 0 && Double.compare(zzdtdVar.f16161e, this.f16161e) == 0 && Double.compare(zzdtdVar.f16162f, this.f16162f) == 0 && Double.compare(zzdtdVar.f16163g, this.f16163g) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f16161e);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f16162f);
        int i2 = (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.f16163g);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.f16164h);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.f16165i);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.f16166j);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)));
        long doubleToLongBits7 = Double.doubleToLongBits(this.f16167k);
        int i7 = (i6 * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)));
        long doubleToLongBits8 = Double.doubleToLongBits(this.l);
        int i8 = (i7 * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)));
        long doubleToLongBits9 = Double.doubleToLongBits(this.m);
        return (i8 * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(a)) {
            return "Rotate 0°";
        }
        if (equals(f16158b)) {
            return "Rotate 90°";
        }
        if (equals(f16159c)) {
            return "Rotate 180°";
        }
        if (equals(f16160d)) {
            return "Rotate 270°";
        }
        double d2 = this.f16161e;
        double d3 = this.f16162f;
        double d4 = this.f16163g;
        double d5 = this.f16164h;
        double d6 = this.f16165i;
        double d7 = this.f16166j;
        double d8 = this.f16167k;
        double d9 = this.l;
        double d10 = this.m;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d2);
        sb.append(", v=");
        sb.append(d3);
        sb.append(", w=");
        sb.append(d4);
        sb.append(", a=");
        sb.append(d5);
        sb.append(", b=");
        sb.append(d6);
        sb.append(", c=");
        sb.append(d7);
        sb.append(", d=");
        sb.append(d8);
        sb.append(", tx=");
        sb.append(d9);
        sb.append(", ty=");
        sb.append(d10);
        sb.append("}");
        return sb.toString();
    }
}
