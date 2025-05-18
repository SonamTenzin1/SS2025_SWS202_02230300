package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzajy implements zzajq, zzajw {

    /* renamed from: f, reason: collision with root package name */
    private final zzbgz f13927f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f13928g;

    public zzajy(Context context, zzbai zzbaiVar, zzdh zzdhVar, com.google.android.gms.ads.internal.zza zzaVar) throws zzbhj {
        this.f13928g = context;
        zzk.zzlh();
        zzbgz b2 = zzbhf.b(context, zzbin.b(), HttpUrl.FRAGMENT_ENCODE_SET, false, false, zzdhVar, zzbaiVar, null, null, null, zzwj.f());
        this.f13927f = b2;
        b2.getView().setWillNotDraw(true);
    }

    private static void u(Runnable runnable) {
        zzyt.a();
        if (zzazt.w()) {
            runnable.run();
        } else {
            zzaxi.a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void L(String str) {
        this.f13927f.k(str);
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void T(String str) {
        u(new g1(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzajq
    public final void X(String str, String str2) {
        zzajr.a(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void Y(String str, JSONObject jSONObject) {
        zzajr.c(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void destroy() {
        this.f13927f.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void f(String str, zzaho<? super zzalf> zzahoVar) {
        this.f13927f.f(str, new h1(this, zzahoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void i(String str, final zzaho<? super zzalf> zzahoVar) {
        this.f13927f.t(str, new Predicate(zzahoVar) { // from class: com.google.android.gms.internal.ads.c1
            private final zzaho a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = zzahoVar;
            }

            @Override // com.google.android.gms.common.util.Predicate
            public final boolean a(Object obj) {
                zzaho zzahoVar2;
                zzaho zzahoVar3 = this.a;
                zzaho zzahoVar4 = (zzaho) obj;
                if (!(zzahoVar4 instanceof h1)) {
                    return false;
                }
                zzahoVar2 = ((h1) zzahoVar4).a;
                return zzahoVar2.equals(zzahoVar3);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzaji
    public final void j(String str, JSONObject jSONObject) {
        zzajr.d(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzakg
    public final void k(final String str) {
        u(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.b1

            /* renamed from: f, reason: collision with root package name */
            private final zzajy f12288f;

            /* renamed from: g, reason: collision with root package name */
            private final String f12289g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12288f = this;
                this.f12289g = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12288f.L(this.f12289g);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final boolean l() {
        return this.f13927f.l();
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void o0(String str) {
        u(new e1(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void q(zzajx zzajxVar) {
        zzbii p = this.f13927f.p();
        zzajxVar.getClass();
        p.j(d1.b(zzajxVar));
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final zzalg q0() {
        return new zzalh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void u0(String str) {
        u(new f1(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void y(String str, Map map) {
        zzajr.b(this, str, map);
    }
}
