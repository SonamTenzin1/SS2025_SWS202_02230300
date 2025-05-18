package e.e.b.c.a0;

/* compiled from: CutCornerTreatment.java */
/* loaded from: classes2.dex */
public class e extends d {
    float a = -1.0f;

    @Override // e.e.b.c.a0.d
    public void a(m mVar, float f2, float f3, float f4) {
        mVar.o(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double sin = Math.sin(Math.toRadians(f2));
        double d2 = f4;
        Double.isNaN(d2);
        double d3 = f3;
        Double.isNaN(d3);
        double sin2 = Math.sin(Math.toRadians(90.0f - f2));
        Double.isNaN(d2);
        Double.isNaN(d3);
        mVar.m((float) (sin * d2 * d3), (float) (sin2 * d2 * d3));
    }
}
