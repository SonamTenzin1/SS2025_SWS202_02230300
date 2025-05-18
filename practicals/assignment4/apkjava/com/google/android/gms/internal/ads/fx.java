package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class fx implements Iterator<String> {

    /* renamed from: f, reason: collision with root package name */
    private Iterator<String> f12606f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzdqw f12607g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fx(zzdqw zzdqwVar) {
        zzdot zzdotVar;
        this.f12607g = zzdqwVar;
        zzdotVar = zzdqwVar.f16057f;
        this.f12606f = zzdotVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12606f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f12606f.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
