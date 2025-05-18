package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public abstract class zzfk implements Callable {

    /* renamed from: f, reason: collision with root package name */
    private final String f16220f = getClass().getSimpleName();

    /* renamed from: g, reason: collision with root package name */
    protected final zzdy f16221g;

    /* renamed from: h, reason: collision with root package name */
    private final String f16222h;

    /* renamed from: i, reason: collision with root package name */
    private final String f16223i;

    /* renamed from: j, reason: collision with root package name */
    protected final zzbp.zza.C0176zza f16224j;

    /* renamed from: k, reason: collision with root package name */
    protected Method f16225k;
    private final int l;
    private final int m;

    public zzfk(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        this.f16221g = zzdyVar;
        this.f16222h = str;
        this.f16223i = str2;
        this.f16224j = c0176zza;
        this.l = i2;
        this.m = i3;
    }

    protected abstract void a() throws IllegalAccessException, InvocationTargetException;

    @Override // java.util.concurrent.Callable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        long nanoTime;
        Method p;
        int i2;
        try {
            nanoTime = System.nanoTime();
            p = this.f16221g.p(this.f16222h, this.f16223i);
            this.f16225k = p;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        if (p == null) {
            return null;
        }
        a();
        zzda w = this.f16221g.w();
        if (w != null && (i2 = this.l) != Integer.MIN_VALUE) {
            w.b(this.m, i2, (System.nanoTime() - nanoTime) / 1000);
        }
        return null;
    }
}
