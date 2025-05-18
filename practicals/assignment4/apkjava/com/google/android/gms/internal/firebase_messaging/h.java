package com.google.android.gms.internal.firebase_messaging;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
final class h extends e {
    private final g a = new g();

    @Override // com.google.android.gms.internal.firebase_messaging.e
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            this.a.a(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
