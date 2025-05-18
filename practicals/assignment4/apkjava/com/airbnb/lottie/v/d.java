package com.airbnb.lottie.v;

/* compiled from: MeanCalculator.java */
/* loaded from: classes.dex */
public class d {
    private float a;

    /* renamed from: b, reason: collision with root package name */
    private int f8856b;

    public void a(float f2) {
        float f3 = this.a + f2;
        this.a = f3;
        int i2 = this.f8856b + 1;
        this.f8856b = i2;
        if (i2 == Integer.MAX_VALUE) {
            this.a = f3 / 2.0f;
            this.f8856b = i2 / 2;
        }
    }
}
