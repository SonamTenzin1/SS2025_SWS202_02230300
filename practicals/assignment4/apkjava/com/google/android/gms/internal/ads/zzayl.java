package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

@zzard
/* loaded from: classes2.dex */
public final class zzayl extends zzak {

    /* renamed from: e, reason: collision with root package name */
    private final Context f14278e;

    private zzayl(Context context, zzas zzasVar) {
        super(zzasVar);
        this.f14278e = context;
    }

    public static zzv d(Context context) {
        zzv zzvVar = new zzv(new zzan(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzayl(context, new zzat()));
        zzvVar.a();
        return zzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzak, com.google.android.gms.internal.ads.zzm
    public final zzp a(zzr<?> zzrVar) throws zzaf {
        if (zzrVar.P() && zzrVar.k() == 0) {
            if (Pattern.matches((String) zzyt.e().c(zzacu.D3), zzrVar.q())) {
                zzyt.a();
                if (zzazt.s(this.f14278e, 13400000)) {
                    zzp a = new zzaii(this.f14278e).a(zzrVar);
                    if (a != null) {
                        String valueOf = String.valueOf(zzrVar.q());
                        zzawz.m(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return a;
                    }
                    String valueOf2 = String.valueOf(zzrVar.q());
                    zzawz.m(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.a(zzrVar);
    }
}
