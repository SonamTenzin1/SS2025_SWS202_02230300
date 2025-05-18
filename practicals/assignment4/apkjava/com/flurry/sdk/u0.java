package com.flurry.sdk;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class u0 extends p0 {
    public u0() {
        super("Streaming", "FlurryStreamingWithFramesDataSender");
    }

    @Override // com.flurry.sdk.p0
    protected final void u(int i2, String str, String str2) {
        if (e7.a().l.r.get()) {
            c2.e(i2, str, str2, true);
            return;
        }
        p2.b("last_streaming_http_error_code", i2);
        p2.d("last_streaming_http_error_message", str);
        p2.d("last_streaming_http_report_identifier", str2);
    }

    @Override // com.flurry.sdk.p0
    protected final String z() {
        String b2 = f1.b();
        if (TextUtils.isEmpty(b2)) {
            return "https://data.flurry.com/v1/flr.do";
        }
        return b2 + "/v1/flr.do";
    }
}
