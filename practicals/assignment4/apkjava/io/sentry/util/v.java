package io.sentry.util;

import io.sentry.o3;
import io.sentry.s3;
import io.sentry.t3;
import io.sentry.u0;
import io.sentry.v1;
import io.sentry.x4;

/* compiled from: TracingUtils.java */
/* loaded from: classes2.dex */
public final class v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(x4 x4Var, s3 s3Var, o3 o3Var) {
        u0 b2 = o3Var.b();
        if (b2 == null) {
            b2 = new u0(x4Var.getLogger());
            o3Var.g(b2);
        }
        if (b2.q()) {
            b2.D(s3Var, x4Var);
            b2.a();
        }
    }

    public static o3 d(final s3 s3Var, final x4 x4Var) {
        return s3Var.B(new s3.a() { // from class: io.sentry.util.f
            @Override // io.sentry.s3.a
            public final void a(o3 o3Var) {
                v.a(x4.this, s3Var, o3Var);
            }
        });
    }

    public static void e(v1 v1Var) {
        v1Var.o(new t3() { // from class: io.sentry.util.g
            @Override // io.sentry.t3
            public final void a(s3 s3Var) {
                s3Var.B(new s3.a() { // from class: io.sentry.util.e
                    @Override // io.sentry.s3.a
                    public final void a(o3 o3Var) {
                        s3.this.x(new o3());
                    }
                });
            }
        });
    }
}
