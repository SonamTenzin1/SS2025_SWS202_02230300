package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a30 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ d30 f12215f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ x20 f12216g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a30(x20 x20Var, d30 d30Var) {
        this.f12216g = x20Var;
        this.f12215f = d30Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        this.f12215f.a();
        sparseArray = this.f12216g.u;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray2 = this.f12216g.u;
            ((zzqt) sparseArray2.valueAt(i2)).e();
        }
    }
}
