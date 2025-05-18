package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class p40 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private ValueCallback<String> f13145f = new q40(this);

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ zzuo f13146g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ WebView f13147h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f13148i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ zzuu f13149j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p40(zzuu zzuuVar, zzuo zzuoVar, WebView webView, boolean z) {
        this.f13149j = zzuuVar;
        this.f13146g = zzuoVar;
        this.f13147h = webView;
        this.f13148i = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13147h.getSettings().getJavaScriptEnabled()) {
            try {
                this.f13147h.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f13145f);
            } catch (Throwable unused) {
                this.f13145f.onReceiveValue(HttpUrl.FRAGMENT_ENCODE_SET);
            }
        }
    }
}
