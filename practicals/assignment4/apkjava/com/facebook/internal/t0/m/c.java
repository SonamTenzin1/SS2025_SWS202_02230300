package com.facebook.internal.t0.m;

import android.util.Log;
import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.d0;
import com.facebook.internal.p0;
import com.facebook.internal.t0.h;
import com.facebook.internal.t0.i;
import com.facebook.internal.t0.k;
import com.facebook.internal.t0.m.c;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.IntIterator;
import kotlin.collections.c0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CrashHandler.kt */
/* loaded from: classes2.dex */
public final class c implements Thread.UncaughtExceptionHandler {

    /* renamed from: f, reason: collision with root package name */
    public static final a f9888f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final String f9889g = c.class.getCanonicalName();

    /* renamed from: h, reason: collision with root package name */
    private static c f9890h;

    /* renamed from: i, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f9891i;

    /* compiled from: CrashHandler.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private final void d() {
            final List x0;
            IntRange k2;
            p0 p0Var = p0.a;
            if (p0.X()) {
                return;
            }
            k kVar = k.a;
            File[] p = k.p();
            ArrayList arrayList = new ArrayList(p.length);
            for (File file : p) {
                i.a aVar = i.a.a;
                arrayList.add(i.a.d(file));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((i) obj).f()) {
                    arrayList2.add(obj);
                }
            }
            x0 = c0.x0(arrayList2, new Comparator() { // from class: com.facebook.internal.t0.m.b
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    int e2;
                    e2 = c.a.e((i) obj2, (i) obj3);
                    return e2;
                }
            });
            JSONArray jSONArray = new JSONArray();
            k2 = l.k(0, Math.min(x0.size(), 5));
            Iterator<Integer> it = k2.iterator();
            while (it.hasNext()) {
                jSONArray.put(x0.get(((IntIterator) it).b()));
            }
            k kVar2 = k.a;
            k.s("crash_reports", jSONArray, new GraphRequest.b() { // from class: com.facebook.internal.t0.m.a
                @Override // com.facebook.GraphRequest.b
                public final void b(d0 d0Var) {
                    c.a.f(x0, d0Var);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int e(i iVar, i iVar2) {
            m.e(iVar2, "o2");
            return iVar.b(iVar2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(List list, d0 d0Var) {
            m.f(list, "$validReports");
            m.f(d0Var, "response");
            try {
                if (d0Var.b() == null) {
                    JSONObject d2 = d0Var.d();
                    if (m.a(d2 == null ? null : Boolean.valueOf(d2.getBoolean(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)), Boolean.TRUE)) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((i) it.next()).a();
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }

        public final synchronized void a() {
            a0 a0Var = a0.a;
            if (a0.g()) {
                d();
            }
            if (c.f9890h != null) {
                Log.w(c.f9889g, "Already enabled!");
            } else {
                c.f9890h = new c(Thread.getDefaultUncaughtExceptionHandler(), null);
                Thread.setDefaultUncaughtExceptionHandler(c.f9890h);
            }
        }
    }

    private c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f9891i = uncaughtExceptionHandler;
    }

    public /* synthetic */ c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, g gVar) {
        this(uncaughtExceptionHandler);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m.f(thread, "t");
        m.f(th, "e");
        k kVar = k.a;
        if (k.g(th)) {
            h hVar = h.a;
            h.b(th);
            i.a aVar = i.a.a;
            i.a.b(th, i.c.CrashReport).g();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f9891i;
        if (uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
