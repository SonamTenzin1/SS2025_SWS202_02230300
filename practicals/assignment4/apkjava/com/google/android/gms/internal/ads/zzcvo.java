package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzcvo implements zzcva<zzcvn> {
    private final zzawi a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f15685b;

    /* renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f15686c;

    /* renamed from: d, reason: collision with root package name */
    private final Executor f15687d;

    public zzcvo(zzawi zzawiVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.a = zzawiVar;
        this.f15685b = context;
        this.f15686c = scheduledExecutorService;
        this.f15687d = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void a(zzbbh zzbbhVar, zzbbr zzbbrVar) {
        String str;
        try {
            AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) zzbbhVar.get();
            if (info == null || !TextUtils.isEmpty(info.getId())) {
                str = null;
            } else {
                zzyt.a();
                str = zzazt.m(this.f15685b);
            }
            zzbbrVar.a(new zzcvn(info, this.f15685b, str));
        } catch (InterruptedException | CancellationException | ExecutionException unused) {
            zzyt.a();
            zzbbrVar.a(new zzcvn(null, this.f15685b, zzazt.m(this.f15685b)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvn> b() {
        if (((Boolean) zzyt.e().c(zzacu.g1)).booleanValue()) {
            final zzbbr zzbbrVar = new zzbbr();
            final zzbbh<AdvertisingIdClient.Info> a = this.a.a(this.f15685b);
            a.k(new Runnable(this, a, zzbbrVar) { // from class: com.google.android.gms.internal.ads.fp

                /* renamed from: f, reason: collision with root package name */
                private final zzcvo f12602f;

                /* renamed from: g, reason: collision with root package name */
                private final zzbbh f12603g;

                /* renamed from: h, reason: collision with root package name */
                private final zzbbr f12604h;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12602f = this;
                    this.f12603g = a;
                    this.f12604h = zzbbrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12602f.a(this.f12603g, this.f12604h);
                }
            }, this.f15687d);
            this.f15686c.schedule(new Runnable(a) { // from class: com.google.android.gms.internal.ads.gp

                /* renamed from: f, reason: collision with root package name */
                private final zzbbh f12657f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12657f = a;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12657f.cancel(true);
                }
            }, ((Long) zzyt.e().c(zzacu.h1)).longValue(), TimeUnit.MILLISECONDS);
            return zzbbrVar;
        }
        return zzbar.l(new Exception("Did not ad Ad ID into query param."));
    }
}
