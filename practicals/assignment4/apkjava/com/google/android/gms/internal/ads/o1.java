package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o1 implements zzaho<zzalf> {
    private final /* synthetic */ zzala a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzajw f13073b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzakh f13074c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o1(zzakh zzakhVar, zzala zzalaVar, zzajw zzajwVar) {
        this.f13074c = zzakhVar;
        this.a = zzalaVar;
        this.f13073b = zzajwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzalf zzalfVar, Map map) {
        Object obj;
        zzayp zzaypVar;
        obj = this.f13074c.a;
        synchronized (obj) {
            if (this.a.a() != -1 && this.a.a() != 1) {
                this.f13074c.f13938h = 0;
                zzaypVar = this.f13074c.f13935e;
                zzaypVar.a(this.f13073b);
                this.a.e(this.f13073b);
                this.f13074c.f13937g = this.a;
                zzawz.m("Successfully loaded JS Engine.");
            }
        }
    }
}
