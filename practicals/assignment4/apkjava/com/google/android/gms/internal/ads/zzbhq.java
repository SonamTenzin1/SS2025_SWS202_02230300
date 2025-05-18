package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzbhq extends zzaas {

    /* renamed from: f, reason: collision with root package name */
    private final zzbdf f14461f;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f14463h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f14464i;

    /* renamed from: j, reason: collision with root package name */
    private int f14465j;

    /* renamed from: k, reason: collision with root package name */
    private zzaau f14466k;
    private boolean l;
    private float n;
    private float o;
    private float p;
    private boolean q;
    private boolean r;

    /* renamed from: g, reason: collision with root package name */
    private final Object f14462g = new Object();
    private boolean m = true;

    public zzbhq(zzbdf zzbdfVar, float f2, boolean z, boolean z2) {
        this.f14461f = zzbdfVar;
        this.n = f2;
        this.f14463h = z;
        this.f14464i = z2;
    }

    private final void j7(final int i2, final int i3, final boolean z, final boolean z2) {
        zzbbm.a.execute(new Runnable(this, i2, i3, z, z2) { // from class: com.google.android.gms.internal.ads.gb

            /* renamed from: f, reason: collision with root package name */
            private final zzbhq f12640f;

            /* renamed from: g, reason: collision with root package name */
            private final int f12641g;

            /* renamed from: h, reason: collision with root package name */
            private final int f12642h;

            /* renamed from: i, reason: collision with root package name */
            private final boolean f12643i;

            /* renamed from: j, reason: collision with root package name */
            private final boolean f12644j;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12640f = this;
                this.f12641g = i2;
                this.f12642h = i3;
                this.f12643i = z;
                this.f12644j = z2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12640f.l7(this.f12641g, this.f12642h, this.f12643i, this.f12644j);
            }
        });
    }

    private final void o7(String str, Map<String, String> map) {
        final HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbbm.a.execute(new Runnable(this, hashMap) { // from class: com.google.android.gms.internal.ads.fb

            /* renamed from: f, reason: collision with root package name */
            private final zzbhq f12578f;

            /* renamed from: g, reason: collision with root package name */
            private final Map f12579g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12578f = this;
                this.f12579g = hashMap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12578f.p7(this.f12579g);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final int F() {
        int i2;
        synchronized (this.f14462g) {
            i2 = this.f14465j;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean G1() {
        boolean z;
        synchronized (this.f14462g) {
            z = this.m;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float Q6() {
        float f2;
        synchronized (this.f14462g) {
            f2 = this.n;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void R1(zzaau zzaauVar) {
        synchronized (this.f14462g) {
            this.f14466k = zzaauVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float S5() {
        float f2;
        synchronized (this.f14462g) {
            f2 = this.o;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float T() {
        float f2;
        synchronized (this.f14462g) {
            f2 = this.p;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final zzaau a5() throws RemoteException {
        zzaau zzaauVar;
        synchronized (this.f14462g) {
            zzaauVar = this.f14466k;
        }
        return zzaauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean d1() {
        boolean z;
        boolean l5 = l5();
        synchronized (this.f14462g) {
            if (!l5) {
                try {
                    z = this.r && this.f14464i;
                } finally {
                }
            }
        }
        return z;
    }

    public final void i7(float f2, float f3, int i2, boolean z, float f4) {
        boolean z2;
        int i3;
        synchronized (this.f14462g) {
            this.n = f3;
            this.o = f2;
            z2 = this.m;
            this.m = z;
            i3 = this.f14465j;
            this.f14465j = i2;
            float f5 = this.p;
            this.p = f4;
            if (Math.abs(f4 - f5) > 1.0E-4f) {
                this.f14461f.getView().invalidate();
            }
        }
        j7(i3, i2, z2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void k5() {
        o7("play", null);
    }

    public final void k7() {
        boolean z;
        int i2;
        synchronized (this.f14462g) {
            z = this.m;
            i2 = this.f14465j;
            this.f14465j = 3;
        }
        j7(i2, 3, z, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean l5() {
        boolean z;
        synchronized (this.f14462g) {
            z = this.f14463h && this.q;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void l7(int i2, int i3, boolean z, boolean z2) {
        zzaau zzaauVar;
        zzaau zzaauVar2;
        zzaau zzaauVar3;
        synchronized (this.f14462g) {
            boolean z3 = i2 != i3;
            boolean z4 = this.l;
            boolean z5 = !z4 && i3 == 1;
            boolean z6 = z3 && i3 == 1;
            boolean z7 = z3 && i3 == 2;
            boolean z8 = z3 && i3 == 3;
            boolean z9 = z != z2;
            this.l = z4 || z5;
            if (z5) {
                try {
                    zzaau zzaauVar4 = this.f14466k;
                    if (zzaauVar4 != null) {
                        zzaauVar4.onVideoStart();
                    }
                } catch (RemoteException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
            if (z6 && (zzaauVar3 = this.f14466k) != null) {
                zzaauVar3.onVideoPlay();
            }
            if (z7 && (zzaauVar2 = this.f14466k) != null) {
                zzaauVar2.onVideoPause();
            }
            if (z8) {
                zzaau zzaauVar5 = this.f14466k;
                if (zzaauVar5 != null) {
                    zzaauVar5.n0();
                }
                this.f14461f.M();
            }
            if (z9 && (zzaauVar = this.f14466k) != null) {
                zzaauVar.T0(z2);
            }
        }
    }

    public final void m7(zzacd zzacdVar) {
        boolean z = zzacdVar.f13785f;
        boolean z2 = zzacdVar.f13786g;
        boolean z3 = zzacdVar.f13787h;
        synchronized (this.f14462g) {
            this.q = z2;
            this.r = z3;
        }
        o7("initialState", CollectionUtils.d("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    public final void n7(float f2) {
        synchronized (this.f14462g) {
            this.o = f2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void o2(boolean z) {
        o7(z ? "mute" : "unmute", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void p7(Map map) {
        this.f14461f.y("pubVideoCmd", map);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void pause() {
        o7("pause", null);
    }
}
