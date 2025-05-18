package com.facebook.internal.t0;

import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.c0;
import com.facebook.d0;
import com.facebook.internal.a0;
import com.facebook.internal.p0;
import com.facebook.internal.t0.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ExceptionAnalyzer.kt */
/* loaded from: classes2.dex */
public final class h {
    public static final h a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f9866b;

    private h() {
    }

    public static final void a() {
        h hVar = a;
        f9866b = true;
        a0 a0Var = a0.a;
        if (a0.g()) {
            hVar.e();
        }
    }

    public static final void b(Throwable th) {
        if (!f9866b || c() || th == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        StackTraceElement[] stackTrace = th.getStackTrace();
        m.e(stackTrace, "e.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            com.facebook.internal.a0 a0Var = com.facebook.internal.a0.a;
            String className = stackTraceElement.getClassName();
            m.e(className, "it.className");
            a0.b d2 = com.facebook.internal.a0.d(className);
            if (d2 != a0.b.Unknown) {
                com.facebook.internal.a0.c(d2);
                hashSet.add(d2.toString());
            }
        }
        com.facebook.a0 a0Var2 = com.facebook.a0.a;
        if (com.facebook.a0.g() && (!hashSet.isEmpty())) {
            i.a aVar = i.a.a;
            i.a.c(new JSONArray((Collection) hashSet)).g();
        }
    }

    public static final boolean c() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(i iVar, d0 d0Var) {
        m.f(iVar, "$instrumentData");
        m.f(d0Var, "response");
        try {
            if (d0Var.b() == null) {
                JSONObject d2 = d0Var.d();
                if (m.a(d2 == null ? null : Boolean.valueOf(d2.getBoolean(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)), Boolean.TRUE)) {
                    iVar.a();
                }
            }
        } catch (JSONException unused) {
        }
    }

    public final void e() {
        p0 p0Var = p0.a;
        if (p0.X()) {
            return;
        }
        k kVar = k.a;
        File[] n = k.n();
        ArrayList arrayList = new ArrayList();
        int length = n.length;
        int i2 = 0;
        while (i2 < length) {
            File file = n[i2];
            i2++;
            i.a aVar = i.a.a;
            final i d2 = i.a.d(file);
            if (d2.f()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crash_shield", d2.toString());
                    GraphRequest.c cVar = GraphRequest.a;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                    com.facebook.a0 a0Var = com.facebook.a0.a;
                    String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{com.facebook.a0.d()}, 1));
                    m.e(format, "java.lang.String.format(format, *args)");
                    arrayList.add(cVar.A(null, format, jSONObject, new GraphRequest.b() { // from class: com.facebook.internal.t0.a
                        @Override // com.facebook.GraphRequest.b
                        public final void b(d0 d0Var) {
                            h.f(i.this, d0Var);
                        }
                    }));
                } catch (JSONException unused) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        new c0(arrayList).o();
    }
}
