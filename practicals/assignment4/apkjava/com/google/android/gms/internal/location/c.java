package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;

/* loaded from: classes2.dex */
final class c implements ListenerHolder.Notifier<LocationCallback> {
    private final /* synthetic */ LocationAvailability a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, LocationAvailability locationAvailability) {
        this.a = locationAvailability;
    }
}
