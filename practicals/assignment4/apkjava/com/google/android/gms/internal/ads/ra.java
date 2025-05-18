package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* loaded from: classes2.dex */
final class ra implements DialogInterface.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ JsPromptResult f13267f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ EditText f13268g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ra(JsPromptResult jsPromptResult, EditText editText) {
        this.f13267f = jsPromptResult;
        this.f13268g = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f13267f.confirm(this.f13268g.getText().toString());
    }
}
