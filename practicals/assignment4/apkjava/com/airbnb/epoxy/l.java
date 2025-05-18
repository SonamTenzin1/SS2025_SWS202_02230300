package com.airbnb.epoxy;

import java.util.List;

/* compiled from: EpoxyAdapter.java */
/* loaded from: classes.dex */
public abstract class l extends d {

    /* renamed from: k, reason: collision with root package name */
    private final x f8439k = new x();
    protected final List<s<?>> l = new c0();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.epoxy.d
    public List<s<?>> j() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.epoxy.d
    public s<?> k(int i2) {
        s<?> sVar = this.l.get(i2);
        return sVar.isShown() ? sVar : this.f8439k;
    }
}
