package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzapx {
    private final boolean a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f14056b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f14057c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f14058d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f14059e;

    private zzapx(zzapz zzapzVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        z = zzapzVar.a;
        this.a = z;
        z2 = zzapzVar.f14060b;
        this.f14056b = z2;
        z3 = zzapzVar.f14061c;
        this.f14057c = z3;
        z4 = zzapzVar.f14062d;
        this.f14058d = z4;
        z5 = zzapzVar.f14063e;
        this.f14059e = z5;
    }

    public final JSONObject a() {
        try {
            return new JSONObject().put("sms", this.a).put("tel", this.f14056b).put("calendar", this.f14057c).put("storePicture", this.f14058d).put("inlineVideo", this.f14059e);
        } catch (JSONException e2) {
            zzbad.c("Error occured while obtaining the MRAID capabilities.", e2);
            return null;
        }
    }
}
