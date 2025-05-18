package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes.dex */
final class c1<T> implements zzcz<T> {

    /* renamed from: f, reason: collision with root package name */
    private volatile zzcz<T> f17137f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f17138g;

    /* renamed from: h, reason: collision with root package name */
    @NullableDecl
    private T f17139h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c1(zzcz<T> zzczVar) {
        this.f17137f = (zzcz) zzcx.a(zzczVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final T a() {
        if (!this.f17138g) {
            synchronized (this) {
                if (!this.f17138g) {
                    T a = this.f17137f.a();
                    this.f17139h = a;
                    this.f17138g = true;
                    this.f17137f = null;
                    return a;
                }
            }
        }
        return this.f17139h;
    }

    public final String toString() {
        Object obj = this.f17137f;
        if (obj == null) {
            String valueOf = String.valueOf(this.f17139h);
            StringBuilder sb = new StringBuilder(valueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
