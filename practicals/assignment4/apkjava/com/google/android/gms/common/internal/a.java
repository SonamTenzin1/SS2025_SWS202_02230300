package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes2.dex */
final class a extends DialogRedirect {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Intent f12017f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Activity f12018g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f12019h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Intent intent, Activity activity, int i2) {
        this.f12017f = intent;
        this.f12018g = activity;
        this.f12019h = i2;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void d() {
        Intent intent = this.f12017f;
        if (intent != null) {
            this.f12018g.startActivityForResult(intent, this.f12019h);
        }
    }
}
