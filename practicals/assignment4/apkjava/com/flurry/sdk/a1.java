package com.flurry.sdk;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class a1 implements Comparator<Runnable> {
    private static int a(Runnable runnable) {
        if (runnable == null) {
            return Integer.MAX_VALUE;
        }
        if (runnable instanceof b1) {
            g2 g2Var = (g2) ((b1) runnable).a();
            if (g2Var != null) {
                return g2Var.f10782h;
            }
            return Integer.MAX_VALUE;
        }
        if (runnable instanceof g2) {
            return ((g2) runnable).f10782h;
        }
        d1.c(6, "PriorityComparator", "Unknown runnable class: " + runnable.getClass().getName());
        return Integer.MAX_VALUE;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Runnable runnable, Runnable runnable2) {
        int a = a(runnable);
        int a2 = a(runnable2);
        if (a < a2) {
            return -1;
        }
        return a > a2 ? 1 : 0;
    }
}
