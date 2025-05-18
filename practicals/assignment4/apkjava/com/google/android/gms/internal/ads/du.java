package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class du extends fu {

    /* renamed from: f, reason: collision with root package name */
    private int f12484f = 0;

    /* renamed from: g, reason: collision with root package name */
    private final int f12485g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzdmr f12486h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(zzdmr zzdmrVar) {
        this.f12486h = zzdmrVar;
        this.f12485g = zzdmrVar.size();
    }

    @Override // com.google.android.gms.internal.ads.zzdmy
    public final byte f() {
        int i2 = this.f12484f;
        if (i2 < this.f12485g) {
            this.f12484f = i2 + 1;
            return this.f12486h.w(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12484f < this.f12485g;
    }
}
