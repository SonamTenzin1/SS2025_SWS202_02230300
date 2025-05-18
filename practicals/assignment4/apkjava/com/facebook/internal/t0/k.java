package com.facebook.internal.t0;

import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.internal.p0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.m;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InstrumentUtility.kt */
/* loaded from: classes2.dex */
public final class k {
    public static final k a = new k();

    private k() {
    }

    public static final boolean a(String str) {
        File c2 = c();
        if (c2 == null || str == null) {
            return false;
        }
        return new File(c2, str).delete();
    }

    public static final String b(Throwable th) {
        if (th == null) {
            return null;
        }
        if (th.getCause() == null) {
            return th.toString();
        }
        return String.valueOf(th.getCause());
    }

    public static final File c() {
        a0 a0Var = a0.a;
        File file = new File(a0.c().getCacheDir(), "instrument");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static final String d(Thread thread) {
        m.f(thread, "thread");
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONArray jSONArray = new JSONArray();
        m.e(stackTrace, "stackTrace");
        int length = stackTrace.length;
        int i2 = 0;
        while (i2 < length) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            i2++;
            jSONArray.put(stackTraceElement.toString());
        }
        return jSONArray.toString();
    }

    public static final String e(Throwable th) {
        Throwable th2 = null;
        if (th == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (th != null && th != th2) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            m.e(stackTrace, "t.stackTrace");
            int i2 = 0;
            int length = stackTrace.length;
            while (i2 < length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                i2++;
                jSONArray.put(stackTraceElement.toString());
            }
            th2 = th;
            th = th.getCause();
        }
        return jSONArray.toString();
    }

    public static final boolean f(StackTraceElement stackTraceElement) {
        boolean E;
        boolean E2;
        m.f(stackTraceElement, "element");
        String className = stackTraceElement.getClassName();
        m.e(className, "element.className");
        E = u.E(className, "com.facebook", false, 2, null);
        if (!E) {
            String className2 = stackTraceElement.getClassName();
            m.e(className2, "element.className");
            E2 = u.E(className2, "com.meta", false, 2, null);
            if (!E2) {
                return false;
            }
        }
        return true;
    }

    public static final boolean g(Throwable th) {
        if (th == null) {
            return false;
        }
        Throwable th2 = null;
        while (th != null && th != th2) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            m.e(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i2 = 0;
            while (i2 < length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                i2++;
                m.e(stackTraceElement, "element");
                if (f(stackTraceElement)) {
                    return true;
                }
            }
            th2 = th;
            th = th.getCause();
        }
        return false;
    }

    public static final boolean h(Thread thread) {
        StackTraceElement[] stackTrace;
        boolean E;
        boolean E2;
        boolean E3;
        boolean E4;
        boolean E5;
        if (thread != null && (stackTrace = thread.getStackTrace()) != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                m.e(stackTraceElement, "element");
                if (f(stackTraceElement)) {
                    String className = stackTraceElement.getClassName();
                    m.e(className, "element.className");
                    E = u.E(className, "com.facebook.appevents.codeless", false, 2, null);
                    if (!E) {
                        String className2 = stackTraceElement.getClassName();
                        m.e(className2, "element.className");
                        E5 = u.E(className2, "com.facebook.appevents.suggestedevents", false, 2, null);
                        if (!E5) {
                            return true;
                        }
                    }
                    String methodName = stackTraceElement.getMethodName();
                    m.e(methodName, "element.methodName");
                    E2 = u.E(methodName, "onClick", false, 2, null);
                    if (E2) {
                        continue;
                    } else {
                        String methodName2 = stackTraceElement.getMethodName();
                        m.e(methodName2, "element.methodName");
                        E3 = u.E(methodName2, "onItemClick", false, 2, null);
                        if (E3) {
                            continue;
                        } else {
                            String methodName3 = stackTraceElement.getMethodName();
                            m.e(methodName3, "element.methodName");
                            E4 = u.E(methodName3, "onTouch", false, 2, null);
                            if (!E4) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final File[] l() {
        File c2 = c();
        if (c2 == null) {
            return new File[0];
        }
        File[] listFiles = c2.listFiles(new FilenameFilter() { // from class: com.facebook.internal.t0.e
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean m;
                m = k.m(file, str);
                return m;
            }
        });
        return listFiles == null ? new File[0] : listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(File file, String str) {
        m.e(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"anr_log_"}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        return new Regex(format).b(str);
    }

    public static final File[] n() {
        File c2 = c();
        if (c2 == null) {
            return new File[0];
        }
        File[] listFiles = c2.listFiles(new FilenameFilter() { // from class: com.facebook.internal.t0.f
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean o;
                o = k.o(file, str);
                return o;
            }
        });
        return listFiles == null ? new File[0] : listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(File file, String str) {
        m.e(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"analysis_log_"}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        return new Regex(format).b(str);
    }

    public static final File[] p() {
        File c2 = c();
        if (c2 == null) {
            return new File[0];
        }
        File[] listFiles = c2.listFiles(new FilenameFilter() { // from class: com.facebook.internal.t0.g
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean q;
                q = k.q(file, str);
                return q;
            }
        });
        return listFiles == null ? new File[0] : listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(File file, String str) {
        m.e(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(new Object[]{"crash_log_", "shield_log_", "thread_check_log_"}, 3));
        m.e(format, "java.lang.String.format(format, *args)");
        return new Regex(format).b(str);
    }

    public static final JSONObject r(String str, boolean z) {
        File c2 = c();
        if (c2 != null && str != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(c2, str));
                p0 p0Var = p0.a;
                return new JSONObject(p0.s0(fileInputStream));
            } catch (Exception unused) {
                if (z) {
                    a(str);
                }
            }
        }
        return null;
    }

    public static final void s(String str, JSONArray jSONArray, GraphRequest.b bVar) {
        m.f(jSONArray, "reports");
        if (jSONArray.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, jSONArray.toString());
            p0 p0Var = p0.a;
            JSONObject A = p0.A();
            if (A != null) {
                Iterator<String> keys = A.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, A.get(next));
                }
            }
            GraphRequest.c cVar = GraphRequest.a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            a0 a0Var = a0.a;
            String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{a0.d()}, 1));
            m.e(format, "java.lang.String.format(format, *args)");
            cVar.A(null, format, jSONObject, bVar).k();
        } catch (JSONException unused) {
        }
    }

    public static final void t(String str, String str2) {
        File c2 = c();
        if (c2 == null || str == null || str2 == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(c2, str));
            byte[] bytes = str2.getBytes(Charsets.f25054b);
            m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }
}
