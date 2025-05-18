package com.flurry.sdk;

/* loaded from: classes2.dex */
public final class m2 {
    static m2 a;

    /* renamed from: b, reason: collision with root package name */
    public t2 f10913b = new t2();

    /* renamed from: c, reason: collision with root package name */
    public z6 f10914c;

    /* renamed from: d, reason: collision with root package name */
    public v6 f10915d;

    private m2() {
        v6 k2Var;
        int a2 = f1.a();
        if (a2 == 0 || a2 == 2) {
            k2Var = f1.c() ? new k2() : new j2();
        } else {
            k2Var = null;
        }
        this.f10915d = k2Var;
        this.f10914c = new z6(this.f10915d);
    }

    public static synchronized m2 a() {
        m2 m2Var;
        synchronized (m2.class) {
            if (a == null) {
                a = new m2();
            }
            m2Var = a;
        }
        return m2Var;
    }

    public final void b(u6 u6Var) {
        if (u6Var != null) {
            this.f10913b.a(u6Var);
        } else {
            d1.c(5, "StreamingManager", "sendFrameToStreaming failed -- message is null");
        }
    }
}
