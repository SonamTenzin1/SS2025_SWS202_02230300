package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class pv implements mw {
    private static final yv a = new rv();

    /* renamed from: b, reason: collision with root package name */
    private final yv f13189b;

    public pv() {
        this(new sv(fv.c(), c()));
    }

    private static boolean b(xv xvVar) {
        return xvVar.c() == zzdob.zze.f16029i;
    }

    private static yv c() {
        try {
            return (yv) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return a;
        }
    }

    @Override // com.google.android.gms.internal.ads.mw
    public final <T> lw<T> a(Class<T> cls) {
        nw.L(cls);
        xv a2 = this.f13189b.a(cls);
        if (a2.a()) {
            if (zzdob.class.isAssignableFrom(cls)) {
                return bw.k(nw.s(), xu.b(), a2.b());
            }
            return bw.k(nw.q(), xu.c(), a2.b());
        }
        if (zzdob.class.isAssignableFrom(cls)) {
            if (b(a2)) {
                return aw.p(cls, a2, ew.b(), kv.d(), nw.s(), xu.b(), wv.b());
            }
            return aw.p(cls, a2, ew.b(), kv.d(), nw.s(), null, wv.b());
        }
        if (b(a2)) {
            return aw.p(cls, a2, ew.a(), kv.c(), nw.q(), xu.c(), wv.a());
        }
        return aw.p(cls, a2, ew.a(), kv.c(), nw.r(), null, wv.a());
    }

    private pv(yv yvVar) {
        this.f13189b = (yv) zzdod.d(yvVar, "messageInfoFactory");
    }
}
