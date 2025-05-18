package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
final /* synthetic */ class i4 implements r4 {
    static final r4 a = new i4();

    private i4() {
    }

    @Override // com.google.android.gms.internal.ads.r4
    public final Object a(zzbjf zzbjfVar) {
        String J2 = zzbjfVar.J2();
        if (J2 != null) {
            return J2;
        }
        String O4 = zzbjfVar.O4();
        return O4 != null ? O4 : HttpUrl.FRAGMENT_ENCODE_SET;
    }
}
