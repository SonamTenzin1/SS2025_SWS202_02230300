package com.flurry.sdk;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class p {
    public final a a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f10968b;

    /* loaded from: classes2.dex */
    public enum a {
        CREATED,
        STARTED,
        RESUMED,
        PAUSED,
        STOPPED,
        DESTROYED,
        SAVE_STATE,
        APP_ORIENTATION_CHANGE,
        APP_BACKGROUND,
        TRIM_MEMORY
    }

    public p(a aVar, Bundle bundle) {
        this.a = aVar;
        this.f10968b = bundle;
    }
}
