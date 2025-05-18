package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q40 implements ValueCallback<String> {
    private final /* synthetic */ p40 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q40(p40 p40Var) {
        this.a = p40Var;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        p40 p40Var = this.a;
        p40Var.f13149j.c(p40Var.f13146g, p40Var.f13147h, str, p40Var.f13148i);
    }
}
