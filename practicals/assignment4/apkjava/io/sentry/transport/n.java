package io.sentry.transport;

import java.net.Authenticator;

/* compiled from: AuthenticatorWrapper.java */
/* loaded from: classes2.dex */
final class n {
    private static final n a = new n();

    private n() {
    }

    public static n a() {
        return a;
    }

    public void b(Authenticator authenticator) {
        Authenticator.setDefault(authenticator);
    }
}
