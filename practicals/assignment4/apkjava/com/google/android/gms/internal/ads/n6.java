package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n6 implements zzban {
    private final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n6(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        zzk.zzlk().h(th, this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void b(Object obj) {
    }
}
