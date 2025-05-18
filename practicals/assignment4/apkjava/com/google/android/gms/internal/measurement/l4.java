package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class l4 implements Iterator<String> {

    /* renamed from: f, reason: collision with root package name */
    private Iterator<String> f17214f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzia f17215g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l4(zzia zziaVar) {
        zzfv zzfvVar;
        this.f17215g = zziaVar;
        zzfvVar = zziaVar.f17434f;
        this.f17214f = zzfvVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f17214f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f17214f.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
