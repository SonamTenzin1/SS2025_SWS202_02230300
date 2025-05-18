package com.facebook.login;

/* compiled from: NonceUtil.kt */
/* loaded from: classes2.dex */
public final class a0 {
    public static final a0 a = new a0();

    private a0() {
    }

    public static final boolean a(String str) {
        int V;
        if (str == null || str.length() == 0) {
            return false;
        }
        V = kotlin.text.v.V(str, ' ', 0, false, 6, null);
        return !(V >= 0);
    }
}
