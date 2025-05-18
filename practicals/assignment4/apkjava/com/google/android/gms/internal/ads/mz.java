package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class mz extends Thread {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AudioTrack f12999f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhq f13000g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mz(zzhq zzhqVar, AudioTrack audioTrack) {
        this.f13000g = zzhqVar;
        this.f12999f = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        try {
            this.f12999f.release();
        } finally {
            conditionVariable = this.f13000g.a;
            conditionVariable.open();
        }
    }
}
