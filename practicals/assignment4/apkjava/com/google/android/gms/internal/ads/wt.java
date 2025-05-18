package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.util.List;

/* loaded from: classes2.dex */
final class wt extends tt {

    /* renamed from: b, reason: collision with root package name */
    private final ut f13521b = new ut();

    @Override // com.google.android.gms.internal.ads.tt
    public final void a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> a = this.f13521b.a(th, false);
        if (a == null) {
            return;
        }
        synchronized (a) {
            for (Throwable th2 : a) {
                printWriter.print("Suppressed: ");
                th2.printStackTrace(printWriter);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.tt
    public final void b(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 != null) {
            this.f13521b.a(th, true).add(th2);
            return;
        }
        throw new NullPointerException("The suppressed exception cannot be null.");
    }

    @Override // com.google.android.gms.internal.ads.tt
    public final void c(Throwable th) {
        th.printStackTrace();
        List<Throwable> a = this.f13521b.a(th, false);
        if (a == null) {
            return;
        }
        synchronized (a) {
            for (Throwable th2 : a) {
                System.err.print("Suppressed: ");
                th2.printStackTrace();
            }
        }
    }
}
