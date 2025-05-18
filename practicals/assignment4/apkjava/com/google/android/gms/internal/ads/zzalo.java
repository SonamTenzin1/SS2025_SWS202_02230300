package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzalo {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    public static final zzaln<JSONObject> f13955b = new d2();

    /* renamed from: c, reason: collision with root package name */
    public static final zzall<InputStream> f13956c = c2.a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ InputStream a(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(a));
    }
}
