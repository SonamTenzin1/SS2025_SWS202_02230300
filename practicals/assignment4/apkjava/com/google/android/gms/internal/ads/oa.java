package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* loaded from: classes2.dex */
final class oa implements DialogInterface.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ JsResult f13094f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public oa(JsResult jsResult) {
        this.f13094f = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f13094f.confirm();
    }
}
