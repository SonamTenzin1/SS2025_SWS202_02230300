package com.google.android.gms.internal.ads;

import java.util.Random;

@zzard
/* loaded from: classes2.dex */
public final class zzyu extends zzzz {

    /* renamed from: g, reason: collision with root package name */
    private long f17012g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f17013h = new Object();

    /* renamed from: f, reason: collision with root package name */
    private final Random f17011f = new Random();

    public zzyu() {
        h7();
    }

    @Override // com.google.android.gms.internal.ads.zzzy
    public final long getValue() {
        return this.f17012g;
    }

    public final void h7() {
        synchronized (this.f17013h) {
            int i2 = 3;
            long j2 = 0;
            while (true) {
                i2--;
                if (i2 <= 0) {
                    break;
                }
                j2 = this.f17011f.nextInt() + 2147483648L;
                if (j2 != this.f17012g && j2 != 0) {
                    break;
                }
            }
            this.f17012g = j2;
        }
    }
}
