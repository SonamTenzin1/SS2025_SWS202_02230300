package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzpd {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16569b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16570c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f16571d;

    /* renamed from: e, reason: collision with root package name */
    private final String f16572e;

    /* renamed from: f, reason: collision with root package name */
    private final MediaCodecInfo.CodecCapabilities f16573f;

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        if ((com.google.android.gms.internal.ads.zzsy.a >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private zzpd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        this.a = (String) zzsk.d(str);
        this.f16572e = str2;
        this.f16573f = codecCapabilities;
        boolean z5 = true;
        if (!z && codecCapabilities != null) {
            if (zzsy.a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback")) {
                z3 = true;
                this.f16569b = z3;
                if (codecCapabilities != null) {
                    if (zzsy.a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback")) {
                        z4 = true;
                        this.f16570c = z4;
                        if (!z2) {
                            if (codecCapabilities != null) {
                            }
                            z5 = false;
                        }
                        this.f16571d = z5;
                    }
                }
                z4 = false;
                this.f16570c = z4;
                if (!z2) {
                }
                this.f16571d = z5;
            }
        }
        z3 = false;
        this.f16569b = z3;
        if (codecCapabilities != null) {
        }
        z4 = false;
        this.f16570c = z4;
        if (!z2) {
        }
        this.f16571d = z5;
    }

    public static zzpd a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzpd(str, str2, codecCapabilities, z, z2);
    }

    @TargetApi(21)
    private static boolean c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        if (d2 != -1.0d && d2 > 0.0d) {
            return videoCapabilities.areSizeAndRateSupported(i2, i3, d2);
        }
        return videoCapabilities.isSizeSupported(i2, i3);
    }

    public static zzpd g(String str) {
        return new zzpd(str, null, null, false, false);
    }

    private final void h(String str) {
        String str2 = this.a;
        String str3 = this.f16572e;
        String str4 = zzsy.f16743e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    @TargetApi(21)
    public final boolean b(int i2, int i3, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f16573f;
        if (codecCapabilities == null) {
            h("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            h("sizeAndRate.vCaps");
            return false;
        }
        if (c(videoCapabilities, i2, i3, d2)) {
            return true;
        }
        if (i2 < i3 && c(videoCapabilities, i3, i2, d2)) {
            StringBuilder sb = new StringBuilder(69);
            sb.append("sizeAndRate.rotated, ");
            sb.append(i2);
            sb.append("x");
            sb.append(i3);
            sb.append("x");
            sb.append(d2);
            String sb2 = sb.toString();
            String str = this.a;
            String str2 = this.f16572e;
            String str3 = zzsy.f16743e;
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 25 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
            sb3.append("AssumedSupport [");
            sb3.append(sb2);
            sb3.append("] [");
            sb3.append(str);
            sb3.append(", ");
            sb3.append(str2);
            sb3.append("] [");
            sb3.append(str3);
            sb3.append("]");
            Log.d("MediaCodecInfo", sb3.toString());
            return true;
        }
        StringBuilder sb4 = new StringBuilder(69);
        sb4.append("sizeAndRate.support, ");
        sb4.append(i2);
        sb4.append("x");
        sb4.append(i3);
        sb4.append("x");
        sb4.append(d2);
        h(sb4.toString());
        return false;
    }

    public final boolean d(String str) {
        String str2;
        if (str == null || this.f16572e == null) {
            return true;
        }
        String trim = str.trim();
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            str2 = "video/avc";
        } else if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            str2 = "video/hevc";
        } else if (trim.startsWith("vp9")) {
            str2 = "video/x-vnd.on2.vp9";
        } else if (trim.startsWith("vp8")) {
            str2 = "video/x-vnd.on2.vp8";
        } else if (trim.startsWith("mp4a")) {
            str2 = "audio/mp4a-latm";
        } else if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
            str2 = "audio/ac3";
        } else if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
            str2 = "audio/eac3";
        } else if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
            str2 = "audio/vnd.dts";
        } else if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
            str2 = "audio/vnd.dts.hd";
        } else if (trim.startsWith("opus")) {
            str2 = "audio/opus";
        } else {
            str2 = trim.startsWith("vorbis") ? "audio/vorbis" : null;
        }
        if (str2 == null) {
            return true;
        }
        if (!this.f16572e.equals(str2)) {
            StringBuilder sb = new StringBuilder(str.length() + 13 + str2.length());
            sb.append("codec.mime ");
            sb.append(str);
            sb.append(", ");
            sb.append(str2);
            h(sb.toString());
            return false;
        }
        Pair<Integer, Integer> c2 = zzpi.c(str);
        if (c2 == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : j()) {
            if (codecProfileLevel.profile == ((Integer) c2.first).intValue() && codecProfileLevel.level >= ((Integer) c2.second).intValue()) {
                return true;
            }
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 22 + str2.length());
        sb2.append("codec.profileLevel, ");
        sb2.append(str);
        sb2.append(", ");
        sb2.append(str2);
        h(sb2.toString());
        return false;
    }

    @TargetApi(21)
    public final boolean e(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f16573f;
        if (codecCapabilities == null) {
            h("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            h("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("sampleRate.support, ");
        sb.append(i2);
        h(sb.toString());
        return false;
    }

    @TargetApi(21)
    public final boolean f(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f16573f;
        if (codecCapabilities == null) {
            h("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            h("channelCount.aCaps");
            return false;
        }
        if (audioCapabilities.getMaxInputChannelCount() >= i2) {
            return true;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("channelCount.support, ");
        sb.append(i2);
        h(sb.toString());
        return false;
    }

    @TargetApi(21)
    public final Point i(int i2, int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f16573f;
        if (codecCapabilities == null) {
            h("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            h("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzsy.j(i2, widthAlignment) * widthAlignment, zzsy.j(i3, heightAlignment) * heightAlignment);
    }

    public final MediaCodecInfo.CodecProfileLevel[] j() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f16573f;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }
}
