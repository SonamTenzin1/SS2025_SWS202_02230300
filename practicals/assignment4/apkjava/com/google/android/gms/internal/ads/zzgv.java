package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class zzgv extends Exception {

    /* renamed from: f, reason: collision with root package name */
    private final String f16262f;

    /* renamed from: g, reason: collision with root package name */
    private final String f16263g;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzgv(zzhj zzhjVar, Throwable th, int i2) {
        super(r0.toString(), th);
        String valueOf = String.valueOf(zzhjVar);
        StringBuilder sb = new StringBuilder(valueOf.length() + 36);
        sb.append("Decoder init failed: [");
        sb.append(i2);
        sb.append("], ");
        sb.append(valueOf);
        this.f16262f = null;
        String str = i2 < 0 ? "neg_" : HttpUrl.FRAGMENT_ENCODE_SET;
        int abs = Math.abs(i2);
        StringBuilder sb2 = new StringBuilder(str.length() + 64);
        sb2.append("com.google.android.gms.ads.exoplayer1.MediaCodecTrackRenderer_");
        sb2.append(str);
        sb2.append(abs);
        this.f16263g = sb2.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzgv(zzhj zzhjVar, Throwable th, String str) {
        super(r0.toString(), th);
        String valueOf = String.valueOf(zzhjVar);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23 + valueOf.length());
        sb.append("Decoder init failed: ");
        sb.append(str);
        sb.append(", ");
        sb.append(valueOf);
        this.f16262f = str;
        String str2 = null;
        if (zzkq.a >= 21 && (th instanceof MediaCodec.CodecException)) {
            str2 = ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.f16263g = str2;
    }
}
