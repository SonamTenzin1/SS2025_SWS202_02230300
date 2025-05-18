package com.facebook.internal;

/* compiled from: InternalSettings.kt */
/* loaded from: classes2.dex */
public final class h0 {
    public static final h0 a = new h0();

    /* renamed from: b, reason: collision with root package name */
    private static volatile String f9778b;

    private h0() {
    }

    public static final String a() {
        return f9778b;
    }

    public static final boolean b() {
        boolean E;
        String str = f9778b;
        Boolean bool = null;
        if (str != null) {
            E = kotlin.text.u.E(str, "Unity.", false, 2, null);
            bool = Boolean.valueOf(E);
        }
        return kotlin.jvm.internal.m.a(bool, Boolean.TRUE);
    }
}
