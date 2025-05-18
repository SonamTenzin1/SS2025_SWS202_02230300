package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* loaded from: classes2.dex */
final class pa implements DialogInterface.OnCancelListener {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ JsPromptResult f13159f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public pa(JsPromptResult jsPromptResult) {
        this.f13159f = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f13159f.cancel();
    }
}
