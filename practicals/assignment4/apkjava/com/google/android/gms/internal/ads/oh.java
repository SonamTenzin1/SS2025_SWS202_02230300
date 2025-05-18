package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class oh implements zzban<zzbgz> {
    private final /* synthetic */ String a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Map f13103b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public oh(zzccj zzccjVar, String str, Map map) {
        this.a = str;
        this.f13103b = map;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzbgz zzbgzVar) {
        zzbgzVar.y(this.a, this.f13103b);
    }
}
