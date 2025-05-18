package io.sentry.internal.debugmeta;

import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: NoOpDebugMetaLoader.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class b implements a {
    private static final b a = new b();

    private b() {
    }

    public static b b() {
        return a;
    }

    @Override // io.sentry.internal.debugmeta.a
    public Properties a() {
        return null;
    }
}
