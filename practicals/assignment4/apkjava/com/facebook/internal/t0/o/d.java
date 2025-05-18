package com.facebook.internal.t0.o;

import com.facebook.internal.t0.k;
import java.io.File;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ErrorReportData.kt */
/* loaded from: classes2.dex */
public final class d {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private String f9895b;

    /* renamed from: c, reason: collision with root package name */
    private String f9896c;

    /* renamed from: d, reason: collision with root package name */
    private Long f9897d;

    /* compiled from: ErrorReportData.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public d(String str) {
        this.f9897d = Long.valueOf(System.currentTimeMillis() / 1000);
        this.f9896c = str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("error_log_");
        Long l = this.f9897d;
        if (l != null) {
            stringBuffer.append(l.longValue());
            stringBuffer.append(".json");
            String stringBuffer2 = stringBuffer.toString();
            m.e(stringBuffer2, "StringBuffer()\n            .append(InstrumentUtility.ERROR_REPORT_PREFIX)\n            .append(timestamp as Long)\n            .append(\".json\")\n            .toString()");
            this.f9895b = stringBuffer2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    public final void a() {
        k kVar = k.a;
        k.a(this.f9895b);
    }

    public final int b(d dVar) {
        m.f(dVar, "data");
        Long l = this.f9897d;
        if (l == null) {
            return -1;
        }
        long longValue = l.longValue();
        Long l2 = dVar.f9897d;
        if (l2 == null) {
            return 1;
        }
        return m.i(l2.longValue(), longValue);
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l = this.f9897d;
            if (l != null) {
                jSONObject.put("timestamp", l);
            }
            jSONObject.put("error_message", this.f9896c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean d() {
        return (this.f9896c == null || this.f9897d == null) ? false : true;
    }

    public final void e() {
        if (d()) {
            k kVar = k.a;
            k.t(this.f9895b, toString());
        }
    }

    public String toString() {
        JSONObject c2 = c();
        if (c2 == null) {
            return super.toString();
        }
        String jSONObject = c2.toString();
        m.e(jSONObject, "params.toString()");
        return jSONObject;
    }

    public d(File file) {
        m.f(file, "file");
        String name = file.getName();
        m.e(name, "file.name");
        this.f9895b = name;
        k kVar = k.a;
        JSONObject r = k.r(name, true);
        if (r != null) {
            this.f9897d = Long.valueOf(r.optLong("timestamp", 0L));
            this.f9896c = r.optString("error_message", null);
        }
    }
}
