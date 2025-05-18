package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class h3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f17794f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17795g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ Object f17796h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ Object f17797i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Object f17798j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzet f17799k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h3(zzet zzetVar, int i2, String str, Object obj, Object obj2, Object obj3) {
        this.f17799k = zzetVar;
        this.f17794f = i2;
        this.f17795g = str;
        this.f17796h = obj;
        this.f17797i = obj2;
        this.f17798j = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c2;
        long j2;
        char c3;
        long j3;
        r3 B = this.f17799k.a.B();
        if (B.t()) {
            c2 = this.f17799k.f18105c;
            if (c2 == 0) {
                if (this.f17799k.n().E()) {
                    zzet zzetVar = this.f17799k;
                    zzetVar.G();
                    zzetVar.f18105c = 'C';
                } else {
                    zzet zzetVar2 = this.f17799k;
                    zzetVar2.G();
                    zzetVar2.f18105c = 'c';
                }
            }
            j2 = this.f17799k.f18106d;
            if (j2 < 0) {
                zzet zzetVar3 = this.f17799k;
                zzetVar3.f18106d = zzetVar3.n().C();
            }
            char charAt = "01VDIWEA?".charAt(this.f17794f);
            c3 = this.f17799k.f18105c;
            j3 = this.f17799k.f18106d;
            String z = zzet.z(true, this.f17795g, this.f17796h, this.f17797i, this.f17798j);
            StringBuilder sb = new StringBuilder(String.valueOf(z).length() + 24);
            sb.append("2");
            sb.append(charAt);
            sb.append(c3);
            sb.append(j3);
            sb.append(":");
            sb.append(z);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.f17795g.substring(0, 1024);
            }
            B.f17921e.b(sb2, 1L);
            return;
        }
        this.f17799k.A(6, "Persisted config not initialized. Not logging error/warn");
    }
}
