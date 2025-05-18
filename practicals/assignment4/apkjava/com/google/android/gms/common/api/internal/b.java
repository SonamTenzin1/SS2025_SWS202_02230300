package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements PendingResult.StatusListener {
    private final /* synthetic */ BasePendingResult a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zaab f11743b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zaab zaabVar, BasePendingResult basePendingResult) {
        this.f11743b = zaabVar;
        this.a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        Map map;
        map = this.f11743b.a;
        map.remove(this.a);
    }
}
