package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
abstract class kv {
    private static final kv a;

    /* renamed from: b, reason: collision with root package name */
    private static final kv f12896b;

    static {
        lv lvVar = null;
        a = new mv();
        f12896b = new nv();
    }

    private kv() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static kv c() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static kv d() {
        return f12896b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> a(Object obj, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void b(Object obj, Object obj2, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(Object obj, long j2);
}
