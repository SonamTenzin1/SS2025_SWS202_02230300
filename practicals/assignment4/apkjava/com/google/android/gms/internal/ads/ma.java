package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* loaded from: classes2.dex */
final class ma implements DialogInterface.OnCancelListener {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ JsResult f12975f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ma(JsResult jsResult) {
        this.f12975f = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f12975f.cancel();
    }
}
