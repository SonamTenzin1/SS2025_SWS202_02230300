package io.sentry;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: JsonObjectReader.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class n2 extends io.sentry.vendor.gson.stream.a {
    public n2(Reader reader) {
        super(reader);
    }

    public static Date n0(String str, w1 w1Var) {
        if (str == null) {
            return null;
        }
        try {
            try {
                return a1.e(str);
            } catch (Exception e2) {
                w1Var.b(s4.ERROR, "Error when deserializing millis timestamp format.", e2);
                return null;
            }
        } catch (Exception unused) {
            return a1.f(str);
        }
    }

    public Integer E0() throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        return Integer.valueOf(z());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        r0.add(r6.a(r4, r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0024, code lost:
    
        r5.b(io.sentry.s4.WARNING, "Failed to deserialize object in list.", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
    
        if (l() != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> List<T> F0(w1 w1Var, l2<T> l2Var) throws IOException {
        ArrayList arrayList;
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        a();
        arrayList = new ArrayList();
        if (N() != io.sentry.vendor.gson.stream.b.BEGIN_OBJECT) {
            f();
            return arrayList;
        }
    }

    public Long G0() throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        return Long.valueOf(A());
    }

    public <T> Map<String, T> J0(w1 w1Var, l2<T> l2Var) throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        b();
        HashMap hashMap = new HashMap();
        if (l()) {
            while (true) {
                try {
                    hashMap.put(B(), l2Var.a(this, w1Var));
                } catch (Exception e2) {
                    w1Var.b(s4.WARNING, "Failed to deserialize object in map.", e2);
                }
                if (N() != io.sentry.vendor.gson.stream.b.BEGIN_OBJECT && N() != io.sentry.vendor.gson.stream.b.NAME) {
                    break;
                }
            }
        }
        j();
        return hashMap;
    }

    public Object K0() throws IOException {
        return new m2().a(this);
    }

    public <T> T M0(w1 w1Var, l2<T> l2Var) throws Exception {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        return l2Var.a(this, w1Var);
    }

    public String N0() throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        return J();
    }

    public TimeZone Q0(w1 w1Var) throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        try {
            return TimeZone.getTimeZone(J());
        } catch (Exception e2) {
            w1Var.b(s4.ERROR, "Error when deserializing TimeZone", e2);
            return null;
        }
    }

    public void R0(w1 w1Var, Map<String, Object> map, String str) {
        try {
            map.put(str, K0());
        } catch (Exception e2) {
            w1Var.a(s4.ERROR, e2, "Error deserializing unknown key: %s", str);
        }
    }

    public Boolean p0() throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        return Boolean.valueOf(x());
    }

    public Date q0(w1 w1Var) throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        return n0(J(), w1Var);
    }

    public Double t0() throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        return Double.valueOf(y());
    }

    public Float x0() throws IOException {
        return Float.valueOf((float) y());
    }

    public Float y0() throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        return x0();
    }
}
