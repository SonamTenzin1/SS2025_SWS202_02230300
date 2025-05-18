package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i2 implements zzahw {
    private final zzakw a;

    /* renamed from: b, reason: collision with root package name */
    private final zzbbr f12740b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzalu f12741c;

    public i2(zzalu zzaluVar, zzakw zzakwVar, zzbbr zzbbrVar) {
        this.f12741c = zzaluVar;
        this.a = zzakwVar;
        this.f12740b = zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void a(JSONObject jSONObject) {
        zzall zzallVar;
        try {
            try {
                zzbbr zzbbrVar = this.f12740b;
                zzallVar = this.f12741c.a;
                zzbbrVar.a(zzallVar.a(jSONObject));
                this.a.f();
            } catch (IllegalStateException unused) {
                this.a.f();
            } catch (JSONException e2) {
                this.f12740b.a(e2);
                this.a.f();
            }
        } catch (Throwable th) {
            this.a.f();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void onFailure(String str) {
        try {
            if (str == null) {
                this.f12740b.c(new zzali());
            } else {
                this.f12740b.c(new zzali(str));
            }
        } catch (IllegalStateException unused) {
        } finally {
            this.a.f();
        }
    }
}
