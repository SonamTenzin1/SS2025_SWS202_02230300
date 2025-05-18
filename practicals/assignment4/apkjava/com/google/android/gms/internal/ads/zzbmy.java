package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbmy implements zzue {

    /* renamed from: f, reason: collision with root package name */
    private zzbgz f14573f;

    /* renamed from: g, reason: collision with root package name */
    private final Executor f14574g;

    /* renamed from: h, reason: collision with root package name */
    private final zzbml f14575h;

    /* renamed from: i, reason: collision with root package name */
    private final Clock f14576i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14577j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f14578k = false;
    private zzbmp l = new zzbmp();

    public zzbmy(Executor executor, zzbml zzbmlVar, Clock clock) {
        this.f14574g = executor;
        this.f14575h = zzbmlVar;
        this.f14576i = clock;
    }

    private final void q() {
        try {
            final JSONObject b2 = this.f14575h.b(this.l);
            if (this.f14573f != null) {
                this.f14574g.execute(new Runnable(this, b2) { // from class: com.google.android.gms.internal.ads.wc

                    /* renamed from: f, reason: collision with root package name */
                    private final zzbmy f13506f;

                    /* renamed from: g, reason: collision with root package name */
                    private final JSONObject f13507g;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f13506f = this;
                        this.f13507g = b2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f13506f.y(this.f13507g);
                    }
                });
            }
        } catch (JSONException e2) {
            zzawz.l("Failed to call video active view js", e2);
        }
    }

    public final void j() {
        this.f14577j = false;
    }

    public final void k() {
        this.f14577j = true;
        q();
    }

    public final void r(boolean z) {
        this.f14578k = z;
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final void r0(zzud zzudVar) {
        zzbmp zzbmpVar = this.l;
        zzbmpVar.a = this.f14578k ? false : zzudVar.m;
        zzbmpVar.f14553d = this.f14576i.b();
        this.l.f14555f = zzudVar;
        if (this.f14577j) {
            q();
        }
    }

    public final void u(zzbgz zzbgzVar) {
        this.f14573f = zzbgzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void y(JSONObject jSONObject) {
        this.f14573f.Y("AFMA_updateActiveView", jSONObject);
    }
}
