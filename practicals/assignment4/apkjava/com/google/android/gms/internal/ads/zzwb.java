package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Future;

@zzard
/* loaded from: classes2.dex */
public final class zzwb {
    private zzvu a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f16869b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f16870c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f16871d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwb(Context context) {
        this.f16870c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        synchronized (this.f16871d) {
            zzvu zzvuVar = this.a;
            if (zzvuVar == null) {
                return;
            }
            zzvuVar.disconnect();
            this.a = null;
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean c(zzwb zzwbVar, boolean z) {
        zzwbVar.f16869b = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future<InputStream> e(zzvv zzvvVar) {
        y40 y40Var = new y40(this);
        z40 z40Var = new z40(this, zzvvVar, y40Var);
        d50 d50Var = new d50(this, y40Var);
        synchronized (this.f16871d) {
            zzvu zzvuVar = new zzvu(this.f16870c, zzk.zzlu().b(), z40Var, d50Var);
            this.a = zzvuVar;
            zzvuVar.checkAvailabilityAndConnect();
        }
        return y40Var;
    }
}
