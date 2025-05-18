package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
/* loaded from: classes2.dex */
public final class zzlw {
    private static final zzlw a = new zzlw(new int[]{2}, 2);

    /* renamed from: b, reason: collision with root package name */
    private final int[] f16454b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16455c;

    private zzlw(int[] iArr, int i2) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.f16454b = copyOf;
        Arrays.sort(copyOf);
        this.f16455c = 2;
    }

    public final boolean a(int i2) {
        return Arrays.binarySearch(this.f16454b, i2) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlw)) {
            return false;
        }
        zzlw zzlwVar = (zzlw) obj;
        return Arrays.equals(this.f16454b, zzlwVar.f16454b) && this.f16455c == zzlwVar.f16455c;
    }

    public final int hashCode() {
        return this.f16455c + (Arrays.hashCode(this.f16454b) * 31);
    }

    public final String toString() {
        int i2 = this.f16455c;
        String arrays = Arrays.toString(this.f16454b);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i2);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
