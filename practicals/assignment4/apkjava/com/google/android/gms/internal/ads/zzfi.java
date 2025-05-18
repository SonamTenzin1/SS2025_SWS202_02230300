package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class zzfi {
    private final zzdy a;

    /* renamed from: b, reason: collision with root package name */
    private final String f16214b;

    /* renamed from: c, reason: collision with root package name */
    private final String f16215c;

    /* renamed from: f, reason: collision with root package name */
    private final Class<?>[] f16218f;

    /* renamed from: d, reason: collision with root package name */
    private final int f16216d = 2;

    /* renamed from: e, reason: collision with root package name */
    private volatile Method f16217e = null;

    /* renamed from: g, reason: collision with root package name */
    private CountDownLatch f16219g = new CountDownLatch(1);

    public zzfi(zzdy zzdyVar, String str, String str2, Class<?>... clsArr) {
        this.a = zzdyVar;
        this.f16214b = str;
        this.f16215c = str2;
        this.f16218f = clsArr;
        zzdyVar.r().submit(new vy(this));
    }

    private final String b(byte[] bArr, String str) throws zzdk, UnsupportedEncodingException {
        return new String(this.a.t().b(bArr, str), "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        try {
            Class loadClass = this.a.s().loadClass(b(this.a.u(), this.f16214b));
            if (loadClass == null) {
                return;
            }
            this.f16217e = loadClass.getMethod(b(this.a.u(), this.f16215c), this.f16218f);
            if (this.f16217e == null) {
            }
        } catch (zzdk unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.f16219g.countDown();
        }
    }

    public final Method d() {
        if (this.f16217e != null) {
            return this.f16217e;
        }
        try {
            if (this.f16219g.await(2L, TimeUnit.SECONDS)) {
                return this.f16217e;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
