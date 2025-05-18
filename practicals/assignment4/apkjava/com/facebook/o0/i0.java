package com.facebook.o0;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.internal.p0;
import com.facebook.o0.q0.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SessionEventsState.kt */
/* loaded from: classes.dex */
public final class i0 {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final String f10134b = i0.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    private static final int f10135c = 1000;

    /* renamed from: d, reason: collision with root package name */
    private final com.facebook.internal.q f10136d;

    /* renamed from: e, reason: collision with root package name */
    private final String f10137e;

    /* renamed from: f, reason: collision with root package name */
    private List<v> f10138f;

    /* renamed from: g, reason: collision with root package name */
    private final List<v> f10139g;

    /* renamed from: h, reason: collision with root package name */
    private int f10140h;

    /* compiled from: SessionEventsState.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public i0(com.facebook.internal.q qVar, String str) {
        kotlin.jvm.internal.m.f(qVar, "attributionIdentifiers");
        kotlin.jvm.internal.m.f(str, "anonymousAppDeviceGUID");
        this.f10136d = qVar;
        this.f10137e = str;
        this.f10138f = new ArrayList();
        this.f10139g = new ArrayList();
    }

    private final void f(GraphRequest graphRequest, Context context, int i2, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject;
        try {
            com.facebook.o0.q0.h hVar = com.facebook.o0.q0.h.a;
            jSONObject = com.facebook.o0.q0.h.a(h.a.CUSTOM_APP_EVENTS, this.f10136d, this.f10137e, z, context);
            if (this.f10140h > 0) {
                jSONObject.put("num_skipped_events", i2);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        graphRequest.F(jSONObject);
        Bundle t = graphRequest.t();
        String jSONArray2 = jSONArray.toString();
        kotlin.jvm.internal.m.e(jSONArray2, "events.toString()");
        t.putString("custom_events", jSONArray2);
        graphRequest.I(jSONArray2);
        graphRequest.H(t);
    }

    public final synchronized void a(v vVar) {
        kotlin.jvm.internal.m.f(vVar, "event");
        if (this.f10138f.size() + this.f10139g.size() >= f10135c) {
            this.f10140h++;
        } else {
            this.f10138f.add(vVar);
        }
    }

    public final synchronized void b(boolean z) {
        if (z) {
            this.f10138f.addAll(this.f10139g);
        }
        this.f10139g.clear();
        this.f10140h = 0;
    }

    public final synchronized int c() {
        return this.f10138f.size();
    }

    public final synchronized List<v> d() {
        List<v> list;
        list = this.f10138f;
        this.f10138f = new ArrayList();
        return list;
    }

    public final int e(GraphRequest graphRequest, Context context, boolean z, boolean z2) {
        kotlin.jvm.internal.m.f(graphRequest, "request");
        kotlin.jvm.internal.m.f(context, "applicationContext");
        synchronized (this) {
            int i2 = this.f10140h;
            com.facebook.o0.n0.a aVar = com.facebook.o0.n0.a.a;
            com.facebook.o0.n0.a.d(this.f10138f);
            this.f10139g.addAll(this.f10138f);
            this.f10138f.clear();
            JSONArray jSONArray = new JSONArray();
            for (v vVar : this.f10139g) {
                if (vVar.g()) {
                    if (z || !vVar.h()) {
                        jSONArray.put(vVar.e());
                    }
                } else {
                    p0 p0Var = p0.a;
                    p0.j0(f10134b, kotlin.jvm.internal.m.n("Event with invalid checksum: ", vVar));
                }
            }
            if (jSONArray.length() == 0) {
                return 0;
            }
            kotlin.u uVar = kotlin.u.a;
            f(graphRequest, context, i2, jSONArray, z2);
            return jSONArray.length();
        }
    }
}
