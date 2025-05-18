package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class g implements PendingResult.StatusListener {
    private final /* synthetic */ PendingResult a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f12028b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ PendingResultUtil.ResultConverter f12029c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ PendingResultUtil.zaa f12030d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.zaa zaaVar) {
        this.a = pendingResult;
        this.f12028b = taskCompletionSource;
        this.f12029c = resultConverter;
        this.f12030d = zaaVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        if (status.e0()) {
            this.f12028b.c(this.f12029c.a(this.a.c(0L, TimeUnit.MILLISECONDS)));
        } else {
            this.f12028b.b(this.f12030d.a(status));
        }
    }
}
