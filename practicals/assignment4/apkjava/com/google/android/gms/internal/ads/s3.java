package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s3 implements Callable<zzase> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Context f13306f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzasg f13307g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s3(zzasg zzasgVar, Context context) {
        this.f13307g = zzasgVar;
        this.f13306f = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzase call() throws Exception {
        WeakHashMap weakHashMap;
        zzase g2;
        WeakHashMap weakHashMap2;
        weakHashMap = this.f13307g.a;
        t3 t3Var = (t3) weakHashMap.get(this.f13306f);
        if (t3Var != null) {
            if (!(t3Var.a + ((Long) zzyt.e().c(zzacu.T1)).longValue() < zzk.zzln().a())) {
                g2 = new zzasf(this.f13306f, t3Var.f13342b).g();
                weakHashMap2 = this.f13307g.a;
                weakHashMap2.put(this.f13306f, new t3(this.f13307g, g2));
                return g2;
            }
        }
        g2 = new zzasf(this.f13306f).g();
        weakHashMap2 = this.f13307g.a;
        weakHashMap2.put(this.f13306f, new t3(this.f13307g, g2));
        return g2;
    }
}
