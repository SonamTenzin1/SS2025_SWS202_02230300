package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* loaded from: classes2.dex */
final class qa implements DialogInterface.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ JsPromptResult f13228f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qa(JsPromptResult jsPromptResult) {
        this.f13228f = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f13228f.cancel();
    }
}
