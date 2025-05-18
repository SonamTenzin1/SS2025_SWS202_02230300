package androidx.appcompat.app;

/* compiled from: TwilightCalculator.java */
/* loaded from: classes.dex */
class m {
    private static m a;

    /* renamed from: b, reason: collision with root package name */
    public long f221b;

    /* renamed from: c, reason: collision with root package name */
    public long f222c;

    /* renamed from: d, reason: collision with root package name */
    public int f223d;

    m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m b() {
        if (a == null) {
            a = new m();
        }
        return a;
    }

    public void a(long j2, double d2, double d3) {
        float f2 = ((float) (j2 - 946728000000L)) / 8.64E7f;
        double d4 = (0.01720197f * f2) + 6.24006f;
        double sin = Math.sin(d4) * 0.03341960161924362d;
        Double.isNaN(d4);
        double sin2 = sin + d4 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d5 = (-d3) / 360.0d;
        double d6 = f2 - 9.0E-4f;
        Double.isNaN(d6);
        double round = ((float) Math.round(d6 - d5)) + 9.0E-4f;
        Double.isNaN(round);
        double sin3 = round + d5 + (Math.sin(d4) * 0.0053d) + (Math.sin(2.0d * sin2) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin2) * Math.sin(0.4092797040939331d));
        double d7 = 0.01745329238474369d * d2;
        double sin4 = (Math.sin(-0.10471975803375244d) - (Math.sin(d7) * Math.sin(asin))) / (Math.cos(d7) * Math.cos(asin));
        if (sin4 >= 1.0d) {
            this.f223d = 1;
            this.f221b = -1L;
            this.f222c = -1L;
            return;
        }
        if (sin4 <= -1.0d) {
            this.f223d = 0;
            this.f221b = -1L;
            this.f222c = -1L;
            return;
        }
        double acos = (float) (Math.acos(sin4) / 6.283185307179586d);
        Double.isNaN(acos);
        this.f221b = Math.round((sin3 + acos) * 8.64E7d) + 946728000000L;
        Double.isNaN(acos);
        long round2 = Math.round((sin3 - acos) * 8.64E7d) + 946728000000L;
        this.f222c = round2;
        if (round2 < j2 && this.f221b > j2) {
            this.f223d = 0;
        } else {
            this.f223d = 1;
        }
    }
}
