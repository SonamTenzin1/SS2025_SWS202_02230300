package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzik extends u2 {

    /* renamed from: c, reason: collision with root package name */
    private final zzjc f18192c;

    /* renamed from: d, reason: collision with root package name */
    private zzel f18193d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Boolean f18194e;

    /* renamed from: f, reason: collision with root package name */
    private final f f18195f;

    /* renamed from: g, reason: collision with root package name */
    private final c7 f18196g;

    /* renamed from: h, reason: collision with root package name */
    private final List<Runnable> f18197h;

    /* renamed from: i, reason: collision with root package name */
    private final f f18198i;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzik(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18197h = new ArrayList();
        this.f18196g = new c7(zzfxVar.j());
        this.f18192c = new zzjc(this);
        this.f18195f = new v5(this, zzfxVar);
        this.f18198i = new e6(this, zzfxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzel B(zzik zzikVar, zzel zzelVar) {
        zzikVar.f18193d = null;
        return null;
    }

    private final zzm D(boolean z) {
        G();
        return q().B(z ? h().Q() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(ComponentName componentName) {
        d();
        if (this.f18193d != null) {
            this.f18193d = null;
            h().P().b("Disconnected from device MeasurementService", componentName);
            d();
            Z();
        }
    }

    private final void R(Runnable runnable) throws IllegalStateException {
        d();
        if (V()) {
            runnable.run();
        } else {
            if (this.f18197h.size() >= 1000) {
                h().H().a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f18197h.add(runnable);
            this.f18198i.c(60000L);
            Z();
        }
    }

    private final boolean c0() {
        G();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        d();
        this.f18196g.a();
        this.f18195f.c(zzap.N.a(null).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        d();
        if (V()) {
            h().P().a("Inactivity, disconnecting from the service");
            b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        d();
        h().P().b("Processing queued up service tasks", Integer.valueOf(this.f18197h.size()));
        Iterator<Runnable> it = this.f18197h.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e2) {
                h().H().b("Task exception while flushing queue", e2);
            }
        }
        this.f18197h.clear();
        this.f18198i.e();
    }

    @Override // com.google.android.gms.measurement.internal.u2
    protected final boolean A() {
        return false;
    }

    public final void F(zzn zznVar) {
        d();
        x();
        R(new a6(this, D(false), zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    public final void H(zzn zznVar, zzan zzanVar, String str) {
        d();
        x();
        if (l().u(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            h().K().a("Not bundling data. Service unavailable or out of date");
            l().S(zznVar, new byte[0]);
        } else {
            R(new b6(this, zzanVar, str, zznVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I(zzn zznVar, String str, String str2) {
        d();
        x();
        R(new h6(this, str, str2, D(false), zznVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J(zzn zznVar, String str, String str2, boolean z) {
        d();
        x();
        R(new j6(this, str, str2, z, D(false), zznVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(zzan zzanVar, String str) {
        Preconditions.k(zzanVar);
        d();
        x();
        boolean c0 = c0();
        R(new g6(this, c0, c0 && t().E(zzanVar), zzanVar, D(true), str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final void L(zzel zzelVar) {
        d();
        Preconditions.k(zzelVar);
        this.f18193d = zzelVar;
        d0();
        f0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void M(zzel zzelVar, AbstractSafeParcelable abstractSafeParcelable, zzm zzmVar) {
        int i2;
        List<AbstractSafeParcelable> C;
        d();
        b();
        x();
        boolean c0 = c0();
        int i3 = 0;
        int i4 = 100;
        while (i3 < 1001 && i4 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!c0 || (C = t().C(100)) == null) {
                i2 = 0;
            } else {
                arrayList.addAll(C);
                i2 = C.size();
            }
            if (abstractSafeParcelable != null && i2 < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzan) {
                    try {
                        zzelVar.Z5((zzan) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e2) {
                        h().H().b("Failed to send event to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkj) {
                    try {
                        zzelVar.b4((zzkj) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e3) {
                        h().H().b("Failed to send attribute to the service", e3);
                    }
                } else if (abstractSafeParcelable2 instanceof zzv) {
                    try {
                        zzelVar.h2((zzv) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e4) {
                        h().H().b("Failed to send conditional property to the service", e4);
                    }
                } else {
                    h().H().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i3++;
            i4 = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N(zzig zzigVar) {
        d();
        x();
        R(new c6(this, zzigVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P(zzkj zzkjVar) {
        d();
        x();
        R(new w5(this, c0() && t().F(zzkjVar), zzkjVar, D(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q(zzv zzvVar) {
        Preconditions.k(zzvVar);
        d();
        x();
        G();
        R(new f6(this, true, t().H(zzvVar), new zzv(zzvVar), D(true), zzvVar));
    }

    public final void S(AtomicReference<String> atomicReference) {
        d();
        x();
        R(new x5(this, atomicReference, D(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void T(AtomicReference<List<zzv>> atomicReference, String str, String str2, String str3) {
        d();
        x();
        R(new i6(this, atomicReference, str, str2, str3, D(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U(AtomicReference<List<zzkj>> atomicReference, String str, String str2, String str3, boolean z) {
        d();
        x();
        R(new l6(this, atomicReference, str, str2, str3, z, D(false)));
    }

    public final boolean V() {
        d();
        x();
        return this.f18193d != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void W() {
        d();
        x();
        R(new d6(this, D(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void X() {
        d();
        b();
        x();
        zzm D = D(false);
        if (c0()) {
            t().I();
        }
        R(new y5(this, D));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Y() {
        d();
        x();
        zzm D = D(true);
        boolean r = n().r(zzap.G0);
        if (r) {
            t().J();
        }
        R(new z5(this, D, r));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Z() {
        boolean z;
        boolean z2;
        d();
        x();
        if (V()) {
            return;
        }
        boolean z3 = false;
        if (this.f18194e == null) {
            d();
            x();
            Boolean H = m().H();
            if (H == null || !H.booleanValue()) {
                G();
                if (q().H() != 1) {
                    h().P().a("Checking service availability");
                    int u = l().u(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                    if (u != 0) {
                        if (u != 1) {
                            if (u == 2) {
                                h().O().a("Service container out of date");
                                if (l().B0() >= 17443) {
                                    Boolean H2 = m().H();
                                    if (H2 == null || H2.booleanValue()) {
                                        z = true;
                                        z2 = false;
                                        if (!z && n().Y()) {
                                            h().H().a("No way to upload. Consider using the full version of Analytics");
                                            z2 = false;
                                        }
                                        if (z2) {
                                            m().w(z);
                                        }
                                    }
                                }
                            } else if (u == 3) {
                                h().K().a("Service disabled");
                            } else if (u == 9) {
                                h().K().a("Service invalid");
                            } else if (u != 18) {
                                h().K().b("Unexpected service status", Integer.valueOf(u));
                            } else {
                                h().K().a("Service updating");
                            }
                            z = false;
                            z2 = false;
                            if (!z) {
                                h().H().a("No way to upload. Consider using the full version of Analytics");
                                z2 = false;
                            }
                            if (z2) {
                            }
                        } else {
                            h().P().a("Service missing");
                        }
                        z = false;
                        z2 = true;
                        if (!z) {
                        }
                        if (z2) {
                        }
                    } else {
                        h().P().a("Service available");
                    }
                }
                z = true;
                z2 = true;
                if (!z) {
                }
                if (z2) {
                }
            } else {
                z = true;
            }
            this.f18194e = Boolean.valueOf(z);
        }
        if (this.f18194e.booleanValue()) {
            this.f18192c.d();
            return;
        }
        if (n().Y()) {
            return;
        }
        G();
        List<ResolveInfo> queryIntentServices = f().getPackageManager().queryIntentServices(new Intent().setClassName(f(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            z3 = true;
        }
        if (z3) {
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            Context f2 = f();
            G();
            intent.setComponent(new ComponentName(f2, "com.google.android.gms.measurement.AppMeasurementService"));
            this.f18192c.b(intent);
            return;
        }
        h().H().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean a0() {
        return this.f18194e;
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    public final void b0() {
        d();
        x();
        this.f18192c.a();
        try {
            ConnectionTracker.b().c(f(), this.f18192c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f18193d = null;
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
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

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzb o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzhc p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzeq q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzik r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzif s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzep t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzjl u() {
        return super.u();
    }
}
