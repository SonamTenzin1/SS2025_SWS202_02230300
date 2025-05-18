package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class i implements Iterator<String> {

    /* renamed from: f, reason: collision with root package name */
    private Iterator<String> f17812f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzam f17813g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(zzam zzamVar) {
        Bundle bundle;
        this.f17813g = zzamVar;
        bundle = zzamVar.f18066f;
        this.f17812f = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f17812f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f17812f.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
