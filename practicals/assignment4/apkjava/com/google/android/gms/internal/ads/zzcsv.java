package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcsv implements zzcva<zzcsu> {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final zzbbl f15611b;

    public zzcsv(Context context, zzbbl zzbblVar) {
        this.a = context;
        this.f15611b = zzbblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcsu> b() {
        return this.f15611b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.eo

            /* renamed from: f, reason: collision with root package name */
            private final zzcsv f12540f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12540f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String g2;
                String A;
                String str;
                zzk.zzlg();
                zzuu o = zzk.zzlk().r().o();
                Bundle bundle = null;
                if (o != null && (!zzk.zzlk().r().k() || !zzk.zzlk().r().b())) {
                    if (o.i()) {
                        o.a();
                    }
                    zzuo g3 = o.g();
                    if (g3 != null) {
                        g2 = g3.i();
                        str = g3.j();
                        A = g3.k();
                        if (g2 != null) {
                            zzk.zzlk().r().l(g2);
                        }
                        if (A != null) {
                            zzk.zzlk().r().p(A);
                        }
                    } else {
                        g2 = zzk.zzlk().r().g();
                        A = zzk.zzlk().r().A();
                        str = null;
                    }
                    Bundle bundle2 = new Bundle(1);
                    if (A != null && !zzk.zzlk().r().b()) {
                        bundle2.putString("v_fp_vertical", A);
                    }
                    if (g2 != null && !zzk.zzlk().r().k()) {
                        bundle2.putString("fingerprint", g2);
                        if (!g2.equals(str)) {
                            bundle2.putString("v_fp", str);
                        }
                    }
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                }
                return new zzcsu(bundle);
            }
        });
    }
}
