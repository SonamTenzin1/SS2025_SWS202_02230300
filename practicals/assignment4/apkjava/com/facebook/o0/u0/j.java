package com.facebook.o0.u0;

import android.os.Bundle;
import android.view.View;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.internal.p0;
import com.facebook.o0.g0;
import com.facebook.o0.r0.h;
import com.facebook.o0.u0.j;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ViewOnClickListener.kt */
/* loaded from: classes2.dex */
public final class j implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    public static final a f10532f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Set<Integer> f10533g = new HashSet();

    /* renamed from: h, reason: collision with root package name */
    private final View.OnClickListener f10534h;

    /* renamed from: i, reason: collision with root package name */
    private final WeakReference<View> f10535i;

    /* renamed from: j, reason: collision with root package name */
    private final WeakReference<View> f10536j;

    /* renamed from: k, reason: collision with root package name */
    private final String f10537k;

    /* compiled from: ViewOnClickListener.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(String str, String str2, float[] fArr) {
            h hVar = h.a;
            if (h.e(str)) {
                a0 a0Var = a0.a;
                new g0(a0.c()).e(str, str2);
            } else if (h.d(str)) {
                h(str, str2, fArr);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f(String str, final String str2) {
            f fVar = f.a;
            final String d2 = f.d(str);
            if (d2 == null) {
                return false;
            }
            if (m.a(d2, "other")) {
                return true;
            }
            p0 p0Var = p0.a;
            p0.B0(new Runnable() { // from class: com.facebook.o0.u0.c
                @Override // java.lang.Runnable
                public final void run() {
                    j.a.g(d2, str2);
                }
            });
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(String str, String str2) {
            m.f(str, "$queriedEvent");
            m.f(str2, "$buttonText");
            j.f10532f.e(str, str2, new float[0]);
        }

        private final void h(String str, String str2, float[] fArr) {
            Bundle bundle = new Bundle();
            try {
                bundle.putString("event_name", str);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder();
                int length = fArr.length;
                int i2 = 0;
                while (i2 < length) {
                    float f2 = fArr[i2];
                    i2++;
                    sb.append(f2);
                    sb.append(",");
                }
                jSONObject.put("dense", sb.toString());
                jSONObject.put("button_text", str2);
                bundle.putString("metadata", jSONObject.toString());
                GraphRequest.c cVar = GraphRequest.a;
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                Locale locale = Locale.US;
                a0 a0Var = a0.a;
                String format = String.format(locale, "%s/suggested_events", Arrays.copyOf(new Object[]{a0.d()}, 1));
                m.e(format, "java.lang.String.format(locale, format, *args)");
                GraphRequest A = cVar.A(null, format, null, null);
                A.H(bundle);
                A.j();
            } catch (JSONException unused) {
            }
        }

        public final void c(View view, View view2, String str) {
            m.f(view, "hostView");
            m.f(view2, "rootView");
            m.f(str, "activityName");
            int hashCode = view.hashCode();
            if (j.f10533g.contains(Integer.valueOf(hashCode))) {
                return;
            }
            com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
            com.facebook.o0.m0.n.f.r(view, new j(view, view2, str, null));
            j.f10533g.add(Integer.valueOf(hashCode));
        }
    }

    private j(View view, View view2, String str) {
        String A;
        com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
        this.f10534h = com.facebook.o0.m0.n.f.g(view);
        this.f10535i = new WeakReference<>(view2);
        this.f10536j = new WeakReference<>(view);
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
        A = u.A(lowerCase, "activity", HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null);
        this.f10537k = A;
    }

    public /* synthetic */ j(View view, View view2, String str, kotlin.jvm.internal.g gVar) {
        this(view, view2, str);
    }

    private final void c(final String str, final String str2, final JSONObject jSONObject) {
        p0 p0Var = p0.a;
        p0.B0(new Runnable() { // from class: com.facebook.o0.u0.d
            @Override // java.lang.Runnable
            public final void run() {
                j.d(jSONObject, str2, this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(JSONObject jSONObject, String str, j jVar, String str2) {
        m.f(jSONObject, "$viewData");
        m.f(str, "$buttonText");
        m.f(jVar, "this$0");
        m.f(str2, "$pathID");
        try {
            p0 p0Var = p0.a;
            a0 a0Var = a0.a;
            String s = p0.s(a0.c());
            if (s != null) {
                String lowerCase = s.toLowerCase();
                m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                e eVar = e.a;
                float[] a2 = e.a(jSONObject, lowerCase);
                String c2 = e.c(str, jVar.f10537k, lowerCase);
                if (a2 == null) {
                    return;
                }
                com.facebook.o0.r0.h hVar = com.facebook.o0.r0.h.a;
                String[] q = com.facebook.o0.r0.h.q(h.a.MTML_APP_EVENT_PREDICTION, new float[][]{a2}, new String[]{c2});
                if (q == null) {
                    return;
                }
                String str3 = q[0];
                f fVar = f.a;
                f.a(str2, str3);
                if (m.a(str3, "other")) {
                    return;
                }
                f10532f.e(str3, str, a2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception unused) {
        }
    }

    private final void e() {
        View view = this.f10535i.get();
        View view2 = this.f10536j.get();
        if (view != null && view2 != null) {
            try {
                g gVar = g.a;
                String d2 = g.d(view2);
                f fVar = f.a;
                String b2 = f.b(view2, d2);
                if (b2 == null || f10532f.f(b2, d2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("view", g.b(view, view2));
                jSONObject.put("screenname", this.f10537k);
                c(b2, d2, jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m.f(view, "view");
        View.OnClickListener onClickListener = this.f10534h;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        e();
    }
}
