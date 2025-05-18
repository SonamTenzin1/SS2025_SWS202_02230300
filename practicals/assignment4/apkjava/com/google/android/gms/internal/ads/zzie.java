package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface zzie {
    void a(int i2) throws IOException, InterruptedException;

    boolean b(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException;

    long getPosition();

    void readFully(byte[] bArr, int i2, int i3) throws IOException, InterruptedException;
}
