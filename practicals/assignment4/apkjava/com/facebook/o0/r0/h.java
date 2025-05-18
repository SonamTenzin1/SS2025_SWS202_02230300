package com.facebook.o0.r0;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.internal.a0;
import com.facebook.internal.p0;
import com.facebook.o0.q0.k;
import com.facebook.o0.r0.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import kotlin.text.u;
import kotlin.text.v;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ModelManager.kt */
/* loaded from: classes2.dex */
public final class h {
    public static final h a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, b> f10457b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f10458c;

    /* renamed from: d, reason: collision with root package name */
    private static final List<String> f10459d;

    /* compiled from: ModelManager.kt */
    /* loaded from: classes2.dex */
    public enum a {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        /* compiled from: ModelManager.kt */
        /* renamed from: com.facebook.o0.r0.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public /* synthetic */ class C0150a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[a.valuesCustom().length];
                iArr[a.MTML_INTEGRITY_DETECT.ordinal()] = 1;
                iArr[a.MTML_APP_EVENT_PREDICTION.ordinal()] = 2;
                a = iArr;
            }
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            return (a[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        public final String k() {
            int i2 = C0150a.a[ordinal()];
            if (i2 == 1) {
                return "integrity_detect";
            }
            if (i2 == 2) {
                return "app_event_pred";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String q() {
            int i2 = C0150a.a[ordinal()];
            if (i2 == 1) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (i2 == 2) {
                return "MTML_APP_EVENT_PRED";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: ModelManager.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        public static final a a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private String f10463b;

        /* renamed from: c, reason: collision with root package name */
        private String f10464c;

        /* renamed from: d, reason: collision with root package name */
        private String f10465d;

        /* renamed from: e, reason: collision with root package name */
        private int f10466e;

        /* renamed from: f, reason: collision with root package name */
        private float[] f10467f;

        /* renamed from: g, reason: collision with root package name */
        private File f10468g;

        /* renamed from: h, reason: collision with root package name */
        private g f10469h;

        /* renamed from: i, reason: collision with root package name */
        private Runnable f10470i;

        /* compiled from: ModelManager.kt */
        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }

            private final void b(String str, int i2) {
                File[] listFiles;
                boolean E;
                boolean E2;
                j jVar = j.a;
                File a = j.a();
                if (a == null || (listFiles = a.listFiles()) == null) {
                    return;
                }
                if (listFiles.length == 0) {
                    return;
                }
                String str2 = str + '_' + i2;
                int length = listFiles.length;
                int i3 = 0;
                while (i3 < length) {
                    File file = listFiles[i3];
                    i3++;
                    String name = file.getName();
                    m.e(name, "name");
                    E = u.E(name, str, false, 2, null);
                    if (E) {
                        E2 = u.E(name, str2, false, 2, null);
                        if (!E2) {
                            file.delete();
                        }
                    }
                }
            }

            private final void c(String str, String str2, k.a aVar) {
                j jVar = j.a;
                File file = new File(j.a(), str2);
                if (str != null && !file.exists()) {
                    new k(str, file, aVar).execute(new String[0]);
                } else {
                    aVar.a(file);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void e(List list, File file) {
                m.f(list, "$slaves");
                m.f(file, "file");
                final g a = g.a.a(file);
                if (a != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        final b bVar = (b) it.next();
                        b.a.c(bVar.e(), bVar.g() + '_' + bVar.h() + "_rule", new k.a() { // from class: com.facebook.o0.r0.c
                            @Override // com.facebook.o0.q0.k.a
                            public final void a(File file2) {
                                h.b.a.f(h.b.this, a, file2);
                            }
                        });
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void f(b bVar, g gVar, File file) {
                m.f(bVar, "$slave");
                m.f(file, "file");
                bVar.i(gVar);
                bVar.k(file);
                Runnable runnable = bVar.f10470i;
                if (runnable == null) {
                    return;
                }
                runnable.run();
            }

            public final b a(JSONObject jSONObject) {
                String string;
                String string2;
                String optString;
                int i2;
                float[] o;
                if (jSONObject != null) {
                    try {
                        string = jSONObject.getString("use_case");
                        string2 = jSONObject.getString("asset_uri");
                        optString = jSONObject.optString("rules_uri", null);
                        i2 = jSONObject.getInt("version_id");
                        o = h.a.o(jSONObject.getJSONArray("thresholds"));
                        m.e(string, "useCase");
                        m.e(string2, "assetUri");
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return new b(string, string2, optString, i2, o);
            }

            public final void d(b bVar, final List<b> list) {
                m.f(bVar, "master");
                m.f(list, "slaves");
                b(bVar.g(), bVar.h());
                c(bVar.b(), bVar.g() + '_' + bVar.h(), new k.a() { // from class: com.facebook.o0.r0.b
                    @Override // com.facebook.o0.q0.k.a
                    public final void a(File file) {
                        h.b.a.e(list, file);
                    }
                });
            }
        }

        public b(String str, String str2, String str3, int i2, float[] fArr) {
            m.f(str, "useCase");
            m.f(str2, "assetUri");
            this.f10463b = str;
            this.f10464c = str2;
            this.f10465d = str3;
            this.f10466e = i2;
            this.f10467f = fArr;
        }

        public final String b() {
            return this.f10464c;
        }

        public final g c() {
            return this.f10469h;
        }

        public final File d() {
            return this.f10468g;
        }

        public final String e() {
            return this.f10465d;
        }

        public final float[] f() {
            return this.f10467f;
        }

        public final String g() {
            return this.f10463b;
        }

        public final int h() {
            return this.f10466e;
        }

        public final void i(g gVar) {
            this.f10469h = gVar;
        }

        public final b j(Runnable runnable) {
            this.f10470i = runnable;
            return this;
        }

        public final void k(File file) {
            this.f10468g = file;
        }
    }

    /* compiled from: ModelManager.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.valuesCustom().length];
            iArr[a.MTML_APP_EVENT_PREDICTION.ordinal()] = 1;
            iArr[a.MTML_INTEGRITY_DETECT.ordinal()] = 2;
            a = iArr;
        }
    }

    static {
        List<String> m;
        List<String> m2;
        m = kotlin.collections.u.m("other", "fb_mobile_complete_registration", "fb_mobile_add_to_cart", "fb_mobile_purchase", "fb_mobile_initiated_checkout");
        f10458c = m;
        m2 = kotlin.collections.u.m("none", "address", "health");
        f10459d = m2;
    }

    private h() {
    }

    private final void b(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                b a2 = b.a.a(jSONObject.getJSONObject(keys.next()));
                if (a2 != null) {
                    f10457b.put(a2.g(), a2);
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    public static final void c() {
        p0 p0Var = p0.a;
        p0.B0(new Runnable() { // from class: com.facebook.o0.r0.e
            @Override // java.lang.Runnable
            public final void run() {
                h.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054 A[Catch: Exception -> 0x0073, TryCatch #0 {Exception -> 0x0073, blocks: (B:3:0x0004, B:5:0x0018, B:10:0x0022, B:11:0x002d, B:13:0x003d, B:15:0x0043, B:17:0x006b, B:21:0x004b, B:24:0x0054, B:25:0x0028), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d() {
        JSONObject jSONObject;
        try {
            a0 a0Var = a0.a;
            SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.internal.MODEL_STORE", 0);
            String string = sharedPreferences.getString("models", null);
            if (string != null) {
                if (!(string.length() == 0)) {
                    jSONObject = new JSONObject(string);
                    long j2 = sharedPreferences.getLong("model_request_timestamp", 0L);
                    com.facebook.internal.a0 a0Var2 = com.facebook.internal.a0.a;
                    if (com.facebook.internal.a0.g(a0.b.ModelRequest) || jSONObject.length() == 0 || !a.k(j2)) {
                        jSONObject = a.h();
                        if (jSONObject != null) {
                            return;
                        } else {
                            sharedPreferences.edit().putString("models", jSONObject.toString()).putLong("model_request_timestamp", System.currentTimeMillis()).apply();
                        }
                    }
                    h hVar = a;
                    hVar.b(jSONObject);
                    hVar.e();
                    return;
                }
            }
            jSONObject = new JSONObject();
            long j22 = sharedPreferences.getLong("model_request_timestamp", 0L);
            com.facebook.internal.a0 a0Var22 = com.facebook.internal.a0.a;
            if (com.facebook.internal.a0.g(a0.b.ModelRequest)) {
            }
            jSONObject = a.h();
            if (jSONObject != null) {
            }
        } catch (Exception unused) {
        }
    }

    private final void e() {
        ArrayList arrayList = new ArrayList();
        String str = null;
        int i2 = 0;
        for (Map.Entry<String, b> entry : f10457b.entrySet()) {
            String key = entry.getKey();
            b value = entry.getValue();
            if (m.a(key, a.MTML_APP_EVENT_PREDICTION.q())) {
                String b2 = value.b();
                int max = Math.max(i2, value.h());
                com.facebook.internal.a0 a0Var = com.facebook.internal.a0.a;
                if (com.facebook.internal.a0.g(a0.b.SuggestedEvents) && j()) {
                    arrayList.add(value.j(new Runnable() { // from class: com.facebook.o0.r0.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.f();
                        }
                    }));
                }
                str = b2;
                i2 = max;
            }
            if (m.a(key, a.MTML_INTEGRITY_DETECT.q())) {
                str = value.b();
                i2 = Math.max(i2, value.h());
                com.facebook.internal.a0 a0Var2 = com.facebook.internal.a0.a;
                if (com.facebook.internal.a0.g(a0.b.IntelligentIntegrity)) {
                    arrayList.add(value.j(new Runnable() { // from class: com.facebook.o0.r0.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.g();
                        }
                    }));
                }
            }
        }
        if (str == null || i2 <= 0 || arrayList.isEmpty()) {
            return;
        }
        b.a.d(new b("MTML", str, null, i2, null), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        com.facebook.o0.u0.h hVar = com.facebook.o0.u0.h.a;
        com.facebook.o0.u0.h.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        com.facebook.o0.p0.a aVar = com.facebook.o0.p0.a.a;
        com.facebook.o0.p0.a.a();
    }

    private final JSONObject h() {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", new String[]{"use_case", "version_id", "asset_uri", "rules_uri", "thresholds"}));
        GraphRequest x = GraphRequest.a.x(null, "app/model_asset", null);
        x.H(bundle);
        JSONObject c2 = x.j().c();
        if (c2 == null) {
            return null;
        }
        return p(c2);
    }

    public static final File i(a aVar) {
        m.f(aVar, "task");
        b bVar = f10457b.get(aVar.q());
        if (bVar == null) {
            return null;
        }
        return bVar.d();
    }

    private final boolean j() {
        boolean J;
        p0 p0Var = p0.a;
        Locale L = p0.L();
        if (L != null) {
            String language = L.getLanguage();
            m.e(language, "locale.language");
            J = v.J(language, "en", false, 2, null);
            if (!J) {
                return false;
            }
        }
        return true;
    }

    private final boolean k(long j2) {
        return j2 != 0 && System.currentTimeMillis() - j2 < 259200000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] o(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        float[] fArr = new float[jSONArray.length()];
        int i2 = 0;
        int length = jSONArray.length();
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                try {
                    String string = jSONArray.getString(i2);
                    m.e(string, "jsonArray.getString(i)");
                    fArr[i2] = Float.parseFloat(string);
                } catch (JSONException unused) {
                }
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return fArr;
    }

    private final JSONObject p(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            int i2 = 0;
            int length = jSONArray.length();
            if (length <= 0) {
                return jSONObject2;
            }
            while (true) {
                int i3 = i2 + 1;
                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("version_id", jSONObject3.getString("version_id"));
                jSONObject4.put("use_case", jSONObject3.getString("use_case"));
                jSONObject4.put("thresholds", jSONObject3.getJSONArray("thresholds"));
                jSONObject4.put("asset_uri", jSONObject3.getString("asset_uri"));
                if (jSONObject3.has("rules_uri")) {
                    jSONObject4.put("rules_uri", jSONObject3.getString("rules_uri"));
                }
                jSONObject2.put(jSONObject3.getString("use_case"), jSONObject4);
                if (i3 >= length) {
                    return jSONObject2;
                }
                i2 = i3;
            }
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static final String[] q(a aVar, float[][] fArr, String[] strArr) {
        m.f(aVar, "task");
        m.f(fArr, "denses");
        m.f(strArr, "texts");
        b bVar = f10457b.get(aVar.q());
        g c2 = bVar == null ? null : bVar.c();
        if (c2 == null) {
            return null;
        }
        float[] f2 = bVar.f();
        int length = strArr.length;
        int length2 = fArr[0].length;
        f fVar = new f(new int[]{length, length2});
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                System.arraycopy(fArr[i2], 0, fVar.a(), i2 * length2, length2);
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        f b2 = c2.b(fVar, strArr, aVar.k());
        if (b2 == null || f2 == null) {
            return null;
        }
        if (b2.a().length == 0) {
            return null;
        }
        if (f2.length == 0) {
            return null;
        }
        int i4 = c.a[aVar.ordinal()];
        if (i4 == 1) {
            return a.s(b2, f2);
        }
        if (i4 == 2) {
            return a.r(b2, f2);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String[] r(f fVar, float[] fArr) {
        IntRange k2;
        int u;
        int b2 = fVar.b(0);
        int b3 = fVar.b(1);
        float[] a2 = fVar.a();
        if (b3 != fArr.length) {
            return null;
        }
        k2 = l.k(0, b2);
        u = kotlin.collections.v.u(k2, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<Integer> it = k2.iterator();
        while (it.hasNext()) {
            int b4 = ((IntIterator) it).b();
            int length = fArr.length;
            String str = "none";
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3 + 1;
                if (a2[(b4 * b3) + i3] >= fArr[i2]) {
                    str = f10459d.get(i3);
                }
                i2++;
                i3 = i4;
            }
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final String[] s(f fVar, float[] fArr) {
        IntRange k2;
        int u;
        int b2 = fVar.b(0);
        int b3 = fVar.b(1);
        float[] a2 = fVar.a();
        if (b3 != fArr.length) {
            return null;
        }
        k2 = l.k(0, b2);
        u = kotlin.collections.v.u(k2, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<Integer> it = k2.iterator();
        while (it.hasNext()) {
            int b4 = ((IntIterator) it).b();
            int length = fArr.length;
            String str = "other";
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3 + 1;
                if (a2[(b4 * b3) + i3] >= fArr[i2]) {
                    str = f10458c.get(i3);
                }
                i2++;
                i3 = i4;
            }
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
