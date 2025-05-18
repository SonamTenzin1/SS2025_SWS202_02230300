package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a10 extends Thread {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AudioTrack f12211f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzmh f12212g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a10(zzmh zzmhVar, AudioTrack audioTrack) {
        this.f12212g = zzmhVar;
        this.f12211f = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        try {
            this.f12211f.flush();
            this.f12211f.release();
        } finally {
            conditionVariable = this.f12212g.f16461f;
            conditionVariable.open();
        }
    }
}
