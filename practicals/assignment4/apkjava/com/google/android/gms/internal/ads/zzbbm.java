package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

@zzard
/* loaded from: classes2.dex */
public final class zzbbm {
    public static final Executor a;

    /* renamed from: b, reason: collision with root package name */
    public static final Executor f14331b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzbbl f14332c;

    /* renamed from: d, reason: collision with root package name */
    private static final zzbbl f14333d;

    static {
        f7 f7Var = new f7();
        a = f7Var;
        g7 g7Var = new g7();
        f14331b = g7Var;
        f14332c = a(f7Var);
        f14333d = a(g7Var);
    }

    public static zzbbl a(Executor executor) {
        return new h7(executor, null);
    }
}
