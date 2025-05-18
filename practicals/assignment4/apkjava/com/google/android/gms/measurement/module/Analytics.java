package com.google.android.gms.measurement.module;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.measurement.internal.zzfx;
import com.google.android.gms.measurement.internal.zzgv;
import com.google.android.gms.measurement.internal.zzgw;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
@ShowFirstParty
/* loaded from: classes2.dex */
public class Analytics {
    private static volatile Analytics a;

    /* renamed from: b, reason: collision with root package name */
    private final zzfx f18249b;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class Event extends zzgw {
        private Event() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class Param extends zzgv {
        private Param() {
        }
    }

    private Analytics(zzfx zzfxVar) {
        Preconditions.k(zzfxVar);
        this.f18249b = zzfxVar;
    }

    @ShowFirstParty
    @Keep
    public static Analytics getInstance(Context context) {
        if (a == null) {
            synchronized (Analytics.class) {
                if (a == null) {
                    a = new Analytics(zzfx.a(context, null));
                }
            }
        }
        return a;
    }
}
