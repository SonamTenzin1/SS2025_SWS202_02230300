package com.google.android.gms.internal.ads;

@zzard
/* loaded from: classes2.dex */
final class x9 extends zzay {

    /* renamed from: c, reason: collision with root package name */
    static final x9 f13566c = new x9();

    x9() {
    }

    @Override // com.google.android.gms.internal.ads.zzay
    public final zzbd b(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbf();
        }
        if ("mvhd".equals(str)) {
            return new zzbg();
        }
        return new zzbh(str);
    }
}
