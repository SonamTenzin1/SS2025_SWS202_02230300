package com.google.android.gms.common;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* renamed from: g, reason: collision with root package name */
    private final int f11639g;

    public GooglePlayServicesRepairableException(int i2, String str, Intent intent) {
        super(str, intent);
        this.f11639g = i2;
    }
}
