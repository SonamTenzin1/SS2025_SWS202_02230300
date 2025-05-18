package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class zzpf extends Exception {

    /* renamed from: f, reason: collision with root package name */
    private final String f16577f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f16578g;

    /* renamed from: h, reason: collision with root package name */
    private final String f16579h;

    /* renamed from: i, reason: collision with root package name */
    private final String f16580i;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzpf(zzlh zzlhVar, Throwable th, boolean z, int i2) {
        super(r1.toString(), th);
        String valueOf = String.valueOf(zzlhVar);
        StringBuilder sb = new StringBuilder(valueOf.length() + 36);
        sb.append("Decoder init failed: [");
        sb.append(i2);
        sb.append("], ");
        sb.append(valueOf);
        this.f16577f = zzlhVar.f16427k;
        this.f16578g = false;
        this.f16579h = null;
        String str = i2 < 0 ? "neg_" : HttpUrl.FRAGMENT_ENCODE_SET;
        int abs = Math.abs(i2);
        StringBuilder sb2 = new StringBuilder(str.length() + 64);
        sb2.append("com.google.android.exoplayer.MediaCodecTrackRenderer_");
        sb2.append(str);
        sb2.append(abs);
        this.f16580i = sb2.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzpf(zzlh zzlhVar, Throwable th, boolean z, String str) {
        super(r1.toString(), th);
        String valueOf = String.valueOf(zzlhVar);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23 + valueOf.length());
        sb.append("Decoder init failed: ");
        sb.append(str);
        sb.append(", ");
        sb.append(valueOf);
        this.f16577f = zzlhVar.f16427k;
        this.f16578g = false;
        this.f16579h = str;
        String str2 = null;
        if (zzsy.a >= 21 && (th instanceof MediaCodec.CodecException)) {
            str2 = ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.f16580i = str2;
    }
}
