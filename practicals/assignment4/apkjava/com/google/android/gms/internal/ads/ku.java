package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes2.dex */
final class ku implements zzdu {
    private final /* synthetic */ Activity a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Bundle f12895b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ku(st stVar, Activity activity, Bundle bundle) {
        this.a = activity;
        this.f12895b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.a, this.f12895b);
    }
}
