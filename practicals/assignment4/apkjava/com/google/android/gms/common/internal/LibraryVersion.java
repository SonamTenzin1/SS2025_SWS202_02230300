package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
@Deprecated
/* loaded from: classes2.dex */
public class LibraryVersion {
    private static final GmsLogger a = new GmsLogger("LibraryVersion", HttpUrl.FRAGMENT_ENCODE_SET);

    /* renamed from: b, reason: collision with root package name */
    private static LibraryVersion f11991b = new LibraryVersion();

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap f11992c = new ConcurrentHashMap();

    @VisibleForTesting
    protected LibraryVersion() {
    }
}
