package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzard
/* loaded from: classes2.dex */
public final class zzyc {
    public static final zzyc a = new zzyc();

    @VisibleForTesting
    protected zzyc() {
    }

    public static zzxz a(Context context, zzaaz zzaazVar) {
        Context context2;
        List list;
        String str;
        Date a2 = zzaazVar.a();
        long time = a2 != null ? a2.getTime() : -1L;
        String b2 = zzaazVar.b();
        int e2 = zzaazVar.e();
        Set<String> f2 = zzaazVar.f();
        if (f2.isEmpty()) {
            context2 = context;
            list = null;
        } else {
            list = Collections.unmodifiableList(new ArrayList(f2));
            context2 = context;
        }
        boolean n = zzaazVar.n(context2);
        int s = zzaazVar.s();
        Location g2 = zzaazVar.g();
        Bundle k2 = zzaazVar.k(AdMobAdapter.class);
        boolean h2 = zzaazVar.h();
        String l = zzaazVar.l();
        SearchAdRequest p = zzaazVar.p();
        zzaca zzacaVar = p != null ? new zzaca(p) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzyt.a();
            str = zzazt.c(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        return new zzxz(8, time, k2, e2, list, n, s, h2, l, zzacaVar, g2, b2, zzaazVar.r(), zzaazVar.d(), Collections.unmodifiableList(new ArrayList(zzaazVar.t())), zzaazVar.o(), str, zzaazVar.m(), null, zzaazVar.u(), zzaazVar.i());
    }
}
