package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzg;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzfl implements ServiceConnection {

    /* renamed from: f, reason: collision with root package name */
    private final String f18134f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ zzfm f18135g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfl(zzfm zzfmVar, String str) {
        this.f18135g = zzfmVar;
        this.f18134f = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f18135g.a.h().K().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzd P = zzg.P(iBinder);
            if (P == null) {
                this.f18135g.a.h().K().a("Install Referrer Service implementation was not found");
            } else {
                this.f18135g.a.h().N().a("Install Referrer Service connected");
                this.f18135g.a.g().z(new s3(this, P, this));
            }
        } catch (Exception e2) {
            this.f18135g.a.h().K().b("Exception occurred while calling Install Referrer API", e2);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f18135g.a.h().N().a("Install Referrer Service disconnected");
    }
}
