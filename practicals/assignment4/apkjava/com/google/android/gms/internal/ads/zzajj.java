package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzajj extends zzaju<zzalf> implements zzajq, zzajw {

    /* renamed from: h */
    private final zzbjb f13923h;

    /* renamed from: i */
    private zzajx f13924i;

    public zzajj(Context context, zzbai zzbaiVar) throws zzbhj {
        try {
            zzbjb zzbjbVar = new zzbjb(context, new z0(this));
            this.f13923h = zzbjbVar;
            zzbjbVar.setWillNotDraw(true);
            zzbjbVar.addJavascriptInterface(new y0(this), "GoogleJsInterface");
            zzk.zzlg().k(context, zzbaiVar.f14326f, zzbjbVar.getSettings());
            super.r0(this);
        } catch (Throwable th) {
            throw new zzbhj("Init failed.", th);
        }
    }

    public final /* synthetic */ void A0(String str) {
        this.f13923h.k(str);
    }

    public final /* synthetic */ void B0(String str) {
        this.f13923h.loadUrl(str);
    }

    public final /* synthetic */ void C0(String str) {
        this.f13923h.loadData(str, "text/html", "UTF-8");
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void T(String str) {
        zzbbm.a.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.v0

            /* renamed from: f, reason: collision with root package name */
            private final zzajj f13413f;

            /* renamed from: g, reason: collision with root package name */
            private final String f13414g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13413f = this;
                this.f13414g = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13413f.B0(this.f13414g);
            }
        });
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
        this.f13923h.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzaji
    public final void j(String str, JSONObject jSONObject) {
        zzajr.d(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzakg
    public final void k(String str) {
        zzbbm.a.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.w0

            /* renamed from: f, reason: collision with root package name */
            private final zzajj f13484f;

            /* renamed from: g, reason: collision with root package name */
            private final String f13485g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13484f = this;
                this.f13485g = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13484f.A0(this.f13485g);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final boolean l() {
        return this.f13923h.l();
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void o0(String str) {
        u0(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", str));
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void q(zzajx zzajxVar) {
        this.f13924i = zzajxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final zzalg q0() {
        return new zzalh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void u0(String str) {
        zzbbm.a.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.u0

            /* renamed from: f, reason: collision with root package name */
            private final zzajj f13372f;

            /* renamed from: g, reason: collision with root package name */
            private final String f13373g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13372f = this;
                this.f13373g = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13372f.C0(this.f13373g);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void y(String str, Map map) {
        zzajr.b(this, str, map);
    }
}
