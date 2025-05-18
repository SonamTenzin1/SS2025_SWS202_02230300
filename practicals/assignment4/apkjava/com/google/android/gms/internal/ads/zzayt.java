package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzayt {
    private final List<String> a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<Double> f14290b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<Double> f14291c = new ArrayList();

    public final zzayt a(String str, double d2, double d3) {
        int i2 = 0;
        while (i2 < this.a.size()) {
            double doubleValue = this.f14291c.get(i2).doubleValue();
            double doubleValue2 = this.f14290b.get(i2).doubleValue();
            if (d2 < doubleValue || (doubleValue == d2 && d3 < doubleValue2)) {
                break;
            }
            i2++;
        }
        this.a.add(i2, str);
        this.f14291c.add(i2, Double.valueOf(d2));
        this.f14290b.add(i2, Double.valueOf(d3));
        return this;
    }

    public final zzayq e() {
        return new zzayq(this);
    }
}
