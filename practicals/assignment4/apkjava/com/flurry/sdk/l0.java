package com.flurry.sdk;

/* loaded from: classes2.dex */
public final class l0 {
    private static l0 a;

    private l0() {
    }

    public static synchronized l0 a() {
        l0 l0Var;
        synchronized (l0.class) {
            if (a == null) {
                a = new l0();
            }
            l0Var = a;
        }
        return l0Var;
    }
}
