package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s0 implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbbr f13300f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzaii f13301g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s0(zzaii zzaiiVar, zzbbr zzbbrVar) {
        this.f13301g = zzaiiVar;
        this.f13300f = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void H(int i2) {
        zzbbr zzbbrVar = this.f13300f;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i2);
        zzbbrVar.c(new RuntimeException(sb.toString()));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        zzahz zzahzVar;
        try {
            zzbbr zzbbrVar = this.f13300f;
            zzahzVar = this.f13301g.a;
            zzbbrVar.a(zzahzVar.e());
        } catch (DeadObjectException e2) {
            this.f13300f.c(e2);
        }
    }
}
