package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes.dex */
final class a1<T> implements zzcz<T>, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final zzcz<T> f17124f;

    /* renamed from: g, reason: collision with root package name */
    private volatile transient boolean f17125g;

    /* renamed from: h, reason: collision with root package name */
    @NullableDecl
    private transient T f17126h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(zzcz<T> zzczVar) {
        this.f17124f = (zzcz) zzcx.a(zzczVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final T a() {
        if (!this.f17125g) {
            synchronized (this) {
                if (!this.f17125g) {
                    T a = this.f17124f.a();
                    this.f17126h = a;
                    this.f17125g = true;
                    return a;
                }
            }
        }
        return this.f17126h;
    }

    public final String toString() {
        Object obj;
        if (this.f17125g) {
            String valueOf = String.valueOf(this.f17126h);
            StringBuilder sb = new StringBuilder(valueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        } else {
            obj = this.f17124f;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
