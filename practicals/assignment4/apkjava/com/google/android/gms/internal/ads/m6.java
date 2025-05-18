package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m6 implements zzban {
    private final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m6(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        zzk.zzlk().e(th, this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void b(Object obj) {
    }
}
