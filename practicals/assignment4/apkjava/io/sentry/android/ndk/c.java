package io.sentry.android.ndk;

import io.sentry.a1;
import io.sentry.f5;
import io.sentry.s4;
import io.sentry.util.q;
import io.sentry.v0;
import io.sentry.x4;
import io.sentry.y1;
import io.sentry.z1;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: NdkScopeObserver.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class c implements z1 {
    private final x4 a;

    /* renamed from: b, reason: collision with root package name */
    private final b f22289b;

    public c(x4 x4Var) {
        this(x4Var, new NativeScope());
    }

    @Override // io.sentry.z1
    public /* synthetic */ void a(Collection collection) {
        y1.b(this, collection);
    }

    @Override // io.sentry.z1
    public /* synthetic */ void b(io.sentry.protocol.c cVar) {
        y1.c(this, cVar);
    }

    @Override // io.sentry.z1
    public /* synthetic */ void c(f5 f5Var) {
        y1.d(this, f5Var);
    }

    @Override // io.sentry.z1
    public /* synthetic */ void d(String str) {
        y1.e(this, str);
    }

    @Override // io.sentry.z1
    public void i(v0 v0Var) {
        try {
            String str = null;
            String lowerCase = v0Var.h() != null ? v0Var.h().name().toLowerCase(Locale.ROOT) : null;
            String g2 = a1.g(v0Var.j());
            try {
                Map<String, Object> g3 = v0Var.g();
                if (!g3.isEmpty()) {
                    str = this.a.getSerializer().f(g3);
                }
            } catch (Throwable th) {
                this.a.getLogger().a(s4.ERROR, th, "Breadcrumb data is not serializable.", new Object[0]);
            }
            this.f22289b.a(lowerCase, v0Var.i(), v0Var.f(), v0Var.k(), g2, str);
        } catch (Throwable th2) {
            this.a.getLogger().a(s4.ERROR, th2, "Scope sync addBreadcrumb has an error.", new Object[0]);
        }
    }

    c(x4 x4Var, b bVar) {
        this.a = (x4) q.c(x4Var, "The SentryOptions object is required.");
        this.f22289b = (b) q.c(bVar, "The NativeScope object is required.");
    }
}
