package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s implements Callable<Void> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Context f13299f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Context context) {
        this.f13299f = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        zzyt.e().a(this.f13299f);
        return null;
    }
}
