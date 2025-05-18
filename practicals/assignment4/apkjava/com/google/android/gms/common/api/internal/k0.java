package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k0 implements IBinder.DeathRecipient, l0 {
    private final WeakReference<BasePendingResult<?>> a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<com.google.android.gms.common.api.zac> f11766b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference<IBinder> f11767c;

    private k0(BasePendingResult<?> basePendingResult, com.google.android.gms.common.api.zac zacVar, IBinder iBinder) {
        this.f11766b = new WeakReference<>(zacVar);
        this.a = new WeakReference<>(basePendingResult);
        this.f11767c = new WeakReference<>(iBinder);
    }

    private final void b() {
        BasePendingResult<?> basePendingResult = this.a.get();
        com.google.android.gms.common.api.zac zacVar = this.f11766b.get();
        if (zacVar != null && basePendingResult != null) {
            zacVar.a(basePendingResult.g().intValue());
        }
        IBinder iBinder = this.f11767c.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.l0
    public final void a(BasePendingResult<?> basePendingResult) {
        b();
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k0(BasePendingResult basePendingResult, com.google.android.gms.common.api.zac zacVar, IBinder iBinder, j0 j0Var) {
        this(basePendingResult, null, iBinder);
    }
}
