package cm.aptoide.pt.app;

/* loaded from: classes.dex */
public /* synthetic */ class x0 {
    public static /* synthetic */ int a(double d2) {
        long doubleToLongBits = Double.doubleToLongBits(d2);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }
}
