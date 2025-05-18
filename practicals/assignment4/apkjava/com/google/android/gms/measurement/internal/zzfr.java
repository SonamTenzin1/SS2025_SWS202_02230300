package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfo;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzfr extends f7 implements x7 {

    /* renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    private static int f18136d = 65535;

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private static int f18137e = 2;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, Map<String, String>> f18138f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f18139g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f18140h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, zzbo.zzb> f18141i;

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, Map<String, Integer>> f18142j;

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, String> f18143k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfr(zzkc zzkcVar) {
        super(zzkcVar);
        this.f18138f = new c.e.a();
        this.f18139g = new c.e.a();
        this.f18140h = new c.e.a();
        this.f18141i = new c.e.a();
        this.f18143k = new c.e.a();
        this.f18142j = new c.e.a();
    }

    private final void M(String str) {
        t();
        d();
        Preconditions.g(str);
        if (this.f18141i.get(str) == null) {
            byte[] r0 = q().r0(str);
            if (r0 == null) {
                this.f18138f.put(str, null);
                this.f18139g.put(str, null);
                this.f18140h.put(str, null);
                this.f18141i.put(str, null);
                this.f18143k.put(str, null);
                this.f18142j.put(str, null);
                return;
            }
            zzbo.zzb.zza v = x(str, r0).v();
            z(str, v);
            this.f18138f.put(str, y((zzbo.zzb) ((zzfd) v.y())));
            this.f18141i.put(str, (zzbo.zzb) ((zzfd) v.y()));
            this.f18143k.put(str, null);
        }
    }

    private final zzbo.zzb x(String str, byte[] bArr) {
        if (bArr == null) {
            return zzbo.zzb.O();
        }
        try {
            zzbo.zzb zzbVar = (zzbo.zzb) ((zzfd) ((zzbo.zzb.zza) zzkg.A(zzbo.zzb.N(), bArr)).y());
            h().P().c("Parsed config. version, gmp_app_id", zzbVar.F() ? Long.valueOf(zzbVar.G()) : null, zzbVar.H() ? zzbVar.I() : null);
            return zzbVar;
        } catch (zzfo e2) {
            h().K().c("Unable to merge remote config. appId", zzet.x(str), e2);
            return zzbo.zzb.O();
        } catch (RuntimeException e3) {
            h().K().c("Unable to merge remote config. appId", zzet.x(str), e3);
            return zzbo.zzb.O();
        }
    }

    private static Map<String, String> y(zzbo.zzb zzbVar) {
        c.e.a aVar = new c.e.a();
        if (zzbVar != null) {
            for (zzbo.zzc zzcVar : zzbVar.J()) {
                aVar.put(zzcVar.B(), zzcVar.C());
            }
        }
        return aVar;
    }

    private final void z(String str, zzbo.zzb.zza zzaVar) {
        c.e.a aVar = new c.e.a();
        c.e.a aVar2 = new c.e.a();
        c.e.a aVar3 = new c.e.a();
        if (zzaVar != null) {
            for (int i2 = 0; i2 < zzaVar.w(); i2++) {
                zzbo.zza.C0190zza v = zzaVar.A(i2).v();
                if (TextUtils.isEmpty(v.A())) {
                    h().K().a("EventConfig contained null event name");
                } else {
                    String b2 = zzgw.b(v.A());
                    if (!TextUtils.isEmpty(b2)) {
                        v = v.w(b2);
                        zzaVar.B(i2, v);
                    }
                    aVar.put(v.A(), Boolean.valueOf(v.B()));
                    aVar2.put(v.A(), Boolean.valueOf(v.C()));
                    if (v.D()) {
                        if (v.E() >= f18137e && v.E() <= f18136d) {
                            aVar3.put(v.A(), Integer.valueOf(v.E()));
                        } else {
                            h().K().c("Invalid sampling rate. Event name, sample rate", v.A(), Integer.valueOf(v.E()));
                        }
                    }
                }
            }
        }
        this.f18139g.put(str, aVar);
        this.f18140h.put(str, aVar2);
        this.f18142j.put(str, aVar3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean A(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        boolean z;
        t();
        d();
        Preconditions.g(str);
        zzbo.zzb.zza v = x(str, bArr).v();
        if (v == null) {
            return false;
        }
        z(str, v);
        this.f18141i.put(str, (zzbo.zzb) ((zzfd) v.y()));
        this.f18143k.put(str, str2);
        this.f18138f.put(str, y((zzbo.zzb) ((zzfd) v.y())));
        q7 o = o();
        ArrayList arrayList = new ArrayList(v.C());
        Preconditions.k(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            zzbj.zza.C0189zza v2 = arrayList.get(i2).v();
            if (v2.D() != 0) {
                for (int i3 = 0; i3 < v2.D(); i3++) {
                    zzbj.zzb.zza v3 = v2.E(i3).v();
                    zzbj.zzb.zza zzaVar = (zzbj.zzb.zza) ((zzfd.zzb) v3.clone());
                    String b2 = zzgw.b(v3.C());
                    if (b2 != null) {
                        zzaVar.A(b2);
                        z = true;
                    } else {
                        z = false;
                    }
                    for (int i4 = 0; i4 < v3.D(); i4++) {
                        zzbj.zzc B = v3.B(i4);
                        String a = zzgv.a(B.J());
                        if (a != null) {
                            zzaVar.w(i4, (zzbj.zzc) ((zzfd) B.v().w(a).y()));
                            z = true;
                        }
                    }
                    if (z) {
                        v2 = v2.A(i3, zzaVar);
                        arrayList.set(i2, (zzbj.zza) ((zzfd) v2.y()));
                    }
                }
            }
            if (v2.w() != 0) {
                for (int i5 = 0; i5 < v2.w(); i5++) {
                    zzbj.zze C = v2.C(i5);
                    String a2 = zzgy.a(C.F());
                    if (a2 != null) {
                        v2 = v2.B(i5, C.v().w(a2));
                        arrayList.set(i2, (zzbj.zza) ((zzfd) v2.y()));
                    }
                }
            }
        }
        o.q().P(str, arrayList);
        try {
            v.D();
            bArr2 = ((zzbo.zzb) ((zzfd) v.y())).j();
        } catch (RuntimeException e2) {
            h().K().c("Unable to serialize reduced-size config. Storing full config instead. appId", zzet.x(str), e2);
            bArr2 = bArr;
        }
        c q = q();
        Preconditions.g(str);
        q.d();
        q.t();
        new ContentValues().put("remote_config", bArr2);
        try {
            if (q.x().update(DeepLinkIntentReceiver.DeepLinksTargets.APPS, r6, "app_id = ?", new String[]{str}) == 0) {
                q.h().H().b("Failed to update remote config (got 0). appId", zzet.x(str));
            }
        } catch (SQLiteException e3) {
            q.h().H().c("Error storing remote config. appId", zzet.x(str), e3);
        }
        this.f18141i.put(str, (zzbo.zzb) ((zzfd) v.y()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String B(String str) {
        d();
        return this.f18143k.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean C(String str, String str2) {
        Boolean bool;
        d();
        M(str);
        if (K(str) && zzkk.u0(str2)) {
            return true;
        }
        if (L(str) && zzkk.Y(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f18139g.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D(String str) {
        d();
        this.f18143k.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean E(String str, String str2) {
        Boolean bool;
        d();
        M(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f18140h.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int F(String str, String str2) {
        Integer num;
        d();
        M(str);
        Map<String, Integer> map = this.f18142j.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void H(String str) {
        d();
        this.f18141i.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean I(String str) {
        d();
        zzbo.zzb w = w(str);
        if (w == null) {
            return false;
        }
        return w.M();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long J(String str) {
        String i2 = i(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(i2)) {
            return 0L;
        }
        try {
            return Long.parseLong(i2);
        } catch (NumberFormatException e2) {
            h().K().c("Unable to parse timezone offset. appId", zzet.x(str), e2);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean K(String str) {
        return "1".equals(i(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean L(String str) {
        return "1".equals(i(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.x7
    public final String i(String str, String str2) {
        d();
        M(str);
        Map<String, String> map = this.f18138f.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ q7 o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ zzkg p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ c q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ zzfr r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.f7
    protected final boolean v() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbo.zzb w(String str) {
        t();
        d();
        Preconditions.g(str);
        M(str);
        return this.f18141i.get(str);
    }
}
