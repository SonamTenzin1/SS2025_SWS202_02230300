package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
abstract class s2 {
    private static final s2 a;

    /* renamed from: b, reason: collision with root package name */
    private static final s2 f17254b;

    static {
        r2 r2Var = null;
        a = new u2();
        f17254b = new t2();
    }

    private s2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s2 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s2 d() {
        return f17254b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> b(Object obj, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void c(Object obj, Object obj2, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(Object obj, long j2);
}
