package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class g1 extends d1 {

    /* renamed from: b, reason: collision with root package name */
    private final f1 f17154b = new f1();

    @Override // com.google.android.gms.internal.measurement.d1
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 != null) {
            this.f17154b.a(th, true).add(th2);
            return;
        }
        throw new NullPointerException("The suppressed exception cannot be null.");
    }
}
