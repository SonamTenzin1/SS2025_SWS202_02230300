package com.flurry.sdk;

/* loaded from: classes2.dex */
public final class m0 {
    private static m0 a;

    private m0() {
    }

    public static synchronized m0 a() {
        m0 m0Var;
        synchronized (m0.class) {
            if (a == null) {
                a = new m0();
            }
            m0Var = a;
        }
        return m0Var;
    }
}
