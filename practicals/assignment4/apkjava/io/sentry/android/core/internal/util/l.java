package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import io.sentry.android.core.s0;
import io.sentry.z2;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: ContentProviderSecurityChecker.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class l {
    private final s0 a;

    public l() {
        this(new s0(z2.e()));
    }

    @SuppressLint({"NewApi"})
    public void a(ContentProvider contentProvider) {
        int d2 = this.a.d();
        if (d2 < 26 || d2 > 28) {
            return;
        }
        String callingPackage = contentProvider.getCallingPackage();
        String packageName = contentProvider.getContext().getPackageName();
        if (callingPackage == null || !callingPackage.equals(packageName)) {
            throw new SecurityException("Provider does not allow for granting of Uri permissions");
        }
    }

    public l(s0 s0Var) {
        this.a = s0Var;
    }
}
