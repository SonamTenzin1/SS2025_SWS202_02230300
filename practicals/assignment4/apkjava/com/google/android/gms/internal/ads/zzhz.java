package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

@TargetApi(16)
/* loaded from: classes2.dex */
public interface zzhz {
    boolean a(String str);

    Exception b();

    void c(zzhw zzhwVar);

    void close();

    MediaCrypto d();

    int getState();
}
