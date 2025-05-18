package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@zzard
/* loaded from: classes2.dex */
public final class zzazh {
    private Map<Integer, Bitmap> a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f14297b = new AtomicInteger(0);

    public final Bitmap a(Integer num) {
        return this.a.get(num);
    }
}
