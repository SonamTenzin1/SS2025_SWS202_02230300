package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class eb implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ bb f12519f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(bb bbVar) {
        this.f12519f = bbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
