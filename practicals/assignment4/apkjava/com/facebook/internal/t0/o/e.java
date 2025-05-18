package com.facebook.internal.t0.o;

import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.d0;
import com.facebook.internal.p0;
import com.facebook.internal.t0.k;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.collections.s;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.m;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ErrorReportHandler.kt */
/* loaded from: classes2.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    public static final void a() {
        a0 a0Var = a0.a;
        if (a0.g()) {
            h();
        }
    }

    public static final File[] e() {
        k kVar = k.a;
        File c2 = k.c();
        if (c2 == null) {
            return new File[0];
        }
        File[] listFiles = c2.listFiles(new FilenameFilter() { // from class: com.facebook.internal.t0.o.c
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean f2;
                f2 = e.f(file, str);
                return f2;
            }
        });
        m.e(listFiles, "reportDir.listFiles { dir, name ->\n      name.matches(Regex(String.format(\"^%s[0-9]+.json$\", InstrumentUtility.ERROR_REPORT_PREFIX)))\n    }");
        return listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(File file, String str) {
        m.e(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"error_log_"}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        return new Regex(format).b(str);
    }

    public static final void g(String str) {
        try {
            new d(str).e();
        } catch (Exception unused) {
        }
    }

    public static final void h() {
        p0 p0Var = p0.a;
        if (p0.X()) {
            return;
        }
        File[] e2 = e();
        final ArrayList arrayList = new ArrayList();
        int length = e2.length;
        int i2 = 0;
        while (i2 < length) {
            File file = e2[i2];
            i2++;
            d dVar = new d(file);
            if (dVar.d()) {
                arrayList.add(dVar);
            }
        }
        s.y(arrayList, new Comparator() { // from class: com.facebook.internal.t0.o.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i3;
                i3 = e.i((d) obj, (d) obj2);
                return i3;
            }
        });
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < arrayList.size() && i3 < 1000; i3++) {
            jSONArray.put(arrayList.get(i3));
        }
        k kVar = k.a;
        k.s("error_reports", jSONArray, new GraphRequest.b() { // from class: com.facebook.internal.t0.o.b
            @Override // com.facebook.GraphRequest.b
            public final void b(d0 d0Var) {
                e.j(arrayList, d0Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(d dVar, d dVar2) {
        m.e(dVar2, "o2");
        return dVar.b(dVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ArrayList arrayList, d0 d0Var) {
        m.f(arrayList, "$validReports");
        m.f(d0Var, "response");
        try {
            if (d0Var.b() == null) {
                JSONObject d2 = d0Var.d();
                if (m.a(d2 == null ? null : Boolean.valueOf(d2.getBoolean(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)), Boolean.TRUE)) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).a();
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }
}
