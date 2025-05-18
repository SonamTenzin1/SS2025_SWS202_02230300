package com.facebook.o0.l0;

import com.facebook.GraphRequest;
import com.facebook.g0;
import com.facebook.internal.j0;
import com.facebook.internal.p0;
import com.facebook.o0.l0.h;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.UninitializedPropertyAccessException;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.l0;
import kotlin.ranges.IntRange;
import kotlin.s;
import kotlin.text.v;
import kotlin.u;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
/* loaded from: classes.dex */
public final class h {
    public static final h a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final HashSet<Integer> f10197b;

    /* renamed from: c, reason: collision with root package name */
    private static final HashSet<Integer> f10198c;

    /* renamed from: d, reason: collision with root package name */
    public static a f10199d;

    /* renamed from: e, reason: collision with root package name */
    public static List<Map<String, Object>> f10200e;

    /* renamed from: f, reason: collision with root package name */
    private static int f10201f;

    /* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private final String a;

        /* renamed from: b, reason: collision with root package name */
        private final String f10202b;

        /* renamed from: c, reason: collision with root package name */
        private final String f10203c;

        public a(String str, String str2, String str3) {
            kotlin.jvm.internal.m.f(str, "datasetID");
            kotlin.jvm.internal.m.f(str2, "cloudBridgeURL");
            kotlin.jvm.internal.m.f(str3, "accessKey");
            this.a = str;
            this.f10202b = str2;
            this.f10203c = str3;
        }

        public final String a() {
            return this.f10203c;
        }

        public final String b() {
            return this.f10202b;
        }

        public final String c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.m.a(this.a, aVar.a) && kotlin.jvm.internal.m.a(this.f10202b, aVar.f10202b) && kotlin.jvm.internal.m.a(this.f10203c, aVar.f10203c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.f10202b.hashCode()) * 31) + this.f10203c.hashCode();
        }

        public String toString() {
            return "CloudBridgeCredentials(datasetID=" + this.a + ", cloudBridgeURL=" + this.f10202b + ", accessKey=" + this.f10203c + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
    /* loaded from: classes.dex */
    public static final class b extends Lambda implements Function2<String, Integer, u> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<Map<String, Object>> f10204f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(List<? extends Map<String, ? extends Object>> list) {
            super(2);
            this.f10204f = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Integer num, List list) {
            boolean K;
            kotlin.jvm.internal.m.f(list, "$processedEvents");
            K = c0.K(h.f10197b, num);
            if (K) {
                return;
            }
            h.a.f(num, list, 5);
        }

        public final void b(String str, final Integer num) {
            p0 p0Var = p0.a;
            final List<Map<String, Object>> list = this.f10204f;
            p0.B0(new Runnable() { // from class: com.facebook.o0.l0.c
                @Override // java.lang.Runnable
                public final void run() {
                    h.b.c(num, list);
                }
            });
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ u invoke(String str, Integer num) {
            b(str, num);
            return u.a;
        }
    }

    static {
        HashSet<Integer> e2;
        HashSet<Integer> e3;
        e2 = w0.e(200, 202);
        f10197b = e2;
        e3 = w0.e(503, 504, 429);
        f10198c = e3;
    }

    private h() {
    }

    public static final void c(String str, String str2, String str3) {
        kotlin.jvm.internal.m.f(str, "datasetID");
        kotlin.jvm.internal.m.f(str2, "url");
        kotlin.jvm.internal.m.f(str3, "accessKey");
        j0.a aVar = j0.a;
        g0 g0Var = g0.APP_EVENTS;
        h hVar = a;
        aVar.c(g0Var, "CAPITransformerWebRequests", " \n\nCloudbridge Configured: \n================\ndatasetID: %s\nurl: %s\naccessKey: %s\n\n", str, str2, str3);
        hVar.i(new a(str, str2, str3));
        hVar.j(new ArrayList());
    }

    private final List<Map<String, Object>> k(GraphRequest graphRequest) {
        Map<String, ? extends Object> u;
        JSONObject p = graphRequest.p();
        if (p == null) {
            return null;
        }
        p0 p0Var = p0.a;
        u = q0.u(p0.l(p));
        Object v = graphRequest.v();
        if (v != null) {
            u.put("custom_events", v);
            StringBuilder sb = new StringBuilder();
            for (String str : u.keySet()) {
                sb.append(str);
                sb.append(" : ");
                sb.append(u.get(str));
                sb.append(System.getProperty("line.separator"));
            }
            j0.a.c(g0.APP_EVENTS, "CAPITransformerWebRequests", "\nGraph Request data: \n\n%s \n\n", sb);
            return g.a.e(u);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    public static final void l(final GraphRequest graphRequest) {
        kotlin.jvm.internal.m.f(graphRequest, "request");
        p0 p0Var = p0.a;
        p0.B0(new Runnable() { // from class: com.facebook.o0.l0.b
            @Override // java.lang.Runnable
            public final void run() {
                h.m(GraphRequest.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GraphRequest graphRequest) {
        List v0;
        Map<String, String> f2;
        kotlin.jvm.internal.m.f(graphRequest, "$request");
        String q = graphRequest.q();
        List v02 = q == null ? null : v.v0(q, new String[]{"/"}, false, 0, 6, null);
        if (v02 != null && v02.size() == 2) {
            try {
                h hVar = a;
                String str = hVar.d().b() + "/capi/" + hVar.d().c() + "/events";
                List<Map<String, Object>> k2 = hVar.k(graphRequest);
                if (k2 == null) {
                    return;
                }
                hVar.b(k2);
                int min = Math.min(hVar.e().size(), 10);
                v0 = c0.v0(hVar.e(), new IntRange(0, min - 1));
                hVar.e().subList(0, min).clear();
                JSONArray jSONArray = new JSONArray((Collection) v0);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("data", jSONArray);
                linkedHashMap.put("accessKey", hVar.d().a());
                JSONObject jSONObject = new JSONObject(linkedHashMap);
                j0.a aVar = j0.a;
                g0 g0Var = g0.APP_EVENTS;
                String jSONObject2 = jSONObject.toString(2);
                kotlin.jvm.internal.m.e(jSONObject2, "jsonBodyStr.toString(2)");
                aVar.c(g0Var, "CAPITransformerWebRequests", "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n", str, graphRequest, jSONObject2);
                String jSONObject3 = jSONObject.toString();
                f2 = kotlin.collections.p0.f(s.a("Content-Type", "application/json"));
                hVar.h(str, "POST", jSONObject3, f2, 60000, new b(v0));
                return;
            } catch (UninitializedPropertyAccessException e2) {
                j0.a.c(g0.DEVELOPER_ERRORS, "CAPITransformerWebRequests", "\n Credentials not initialized Error when logging: \n%s", e2);
                return;
            }
        }
        j0.a.c(g0.DEVELOPER_ERRORS, "CAPITransformerWebRequests", "\n GraphPathComponents Error when logging: \n%s", graphRequest);
    }

    public final void b(List<? extends Map<String, ? extends Object>> list) {
        List M;
        if (list != null) {
            e().addAll(list);
        }
        int max = Math.max(0, e().size() - 1000);
        if (max > 0) {
            M = c0.M(e(), max);
            j(l0.b(M));
        }
    }

    public final a d() {
        a aVar = f10199d;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.m.w("credentials");
        throw null;
    }

    public final List<Map<String, Object>> e() {
        List<Map<String, Object>> list = f10200e;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.m.w("transformedEvents");
        throw null;
    }

    public final void f(Integer num, List<? extends Map<String, ? extends Object>> list, int i2) {
        boolean K;
        kotlin.jvm.internal.m.f(list, "processedEvents");
        K = c0.K(f10198c, num);
        if (K) {
            if (f10201f >= i2) {
                e().clear();
                f10201f = 0;
            } else {
                e().addAll(0, list);
                f10201f++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x009b A[Catch: IOException -> 0x00f7, UnknownHostException -> 0x010a, TRY_LEAVE, TryCatch #4 {UnknownHostException -> 0x010a, IOException -> 0x00f7, blocks: (B:3:0x0011, B:5:0x001c, B:8:0x0045, B:10:0x0051, B:14:0x0061, B:16:0x009b, B:23:0x00b5, B:30:0x00bc, B:31:0x00bf, B:33:0x00c0, B:35:0x00e3, B:39:0x0024, B:42:0x002b, B:43:0x002f, B:45:0x0035, B:47:0x00ef, B:48:0x00f6), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e3 A[Catch: IOException -> 0x00f7, UnknownHostException -> 0x010a, TryCatch #4 {UnknownHostException -> 0x010a, IOException -> 0x00f7, blocks: (B:3:0x0011, B:5:0x001c, B:8:0x0045, B:10:0x0051, B:14:0x0061, B:16:0x009b, B:23:0x00b5, B:30:0x00bc, B:31:0x00bf, B:33:0x00c0, B:35:0x00e3, B:39:0x0024, B:42:0x002b, B:43:0x002f, B:45:0x0035, B:47:0x00ef, B:48:0x00f6), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(String str, String str2, String str3, Map<String, String> map, int i2, Function2<? super String, ? super Integer, u> function2) {
        Set<String> keySet;
        boolean z;
        kotlin.jvm.internal.m.f(str, "urlStr");
        kotlin.jvm.internal.m.f(str2, "requestMethod");
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setRequestMethod(str2);
                if (map != null && (keySet = map.keySet()) != null) {
                    for (String str4 : keySet) {
                        httpURLConnection.setRequestProperty(str4, map.get(str4));
                    }
                }
                if (!httpURLConnection.getRequestMethod().equals("POST") && !httpURLConnection.getRequestMethod().equals("PUT")) {
                    z = false;
                    httpURLConnection.setDoOutput(z);
                    httpURLConnection.setConnectTimeout(i2);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream, "UTF-8"));
                    bufferedWriter.write(str3);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    bufferedOutputStream.close();
                    StringBuilder sb = new StringBuilder();
                    if (f10197b.contains(Integer.valueOf(httpURLConnection.getResponseCode()))) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                } else {
                                    sb.append(readLine);
                                }
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    kotlin.io.a.a(bufferedReader, th);
                                    throw th2;
                                }
                            }
                        }
                        u uVar = u.a;
                        kotlin.io.a.a(bufferedReader, null);
                    }
                    String sb2 = sb.toString();
                    kotlin.jvm.internal.m.e(sb2, "connResponseSB.toString()");
                    j0.a.c(g0.APP_EVENTS, "CAPITransformerWebRequests", "\nResponse Received: \n%s\n%s", sb2, Integer.valueOf(httpURLConnection.getResponseCode()));
                    if (function2 == null) {
                        function2.invoke(sb2, Integer.valueOf(httpURLConnection.getResponseCode()));
                        return;
                    }
                    return;
                }
                z = true;
                httpURLConnection.setDoOutput(z);
                httpURLConnection.setConnectTimeout(i2);
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream2, "UTF-8"));
                bufferedWriter2.write(str3);
                bufferedWriter2.flush();
                bufferedWriter2.close();
                bufferedOutputStream2.close();
                StringBuilder sb3 = new StringBuilder();
                if (f10197b.contains(Integer.valueOf(httpURLConnection.getResponseCode()))) {
                }
                String sb22 = sb3.toString();
                kotlin.jvm.internal.m.e(sb22, "connResponseSB.toString()");
                j0.a.c(g0.APP_EVENTS, "CAPITransformerWebRequests", "\nResponse Received: \n%s\n%s", sb22, Integer.valueOf(httpURLConnection.getResponseCode()));
                if (function2 == null) {
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
        } catch (UnknownHostException e2) {
            j0.a.c(g0.APP_EVENTS, "CAPITransformerWebRequests", "Connection failed, retrying: \n%s", e2.toString());
            if (function2 != null) {
                function2.invoke(null, 503);
            }
        } catch (IOException e3) {
            j0.a.c(g0.DEVELOPER_ERRORS, "CAPITransformerWebRequests", "Send to server failed: \n%s", e3.toString());
        }
    }

    public final void i(a aVar) {
        kotlin.jvm.internal.m.f(aVar, "<set-?>");
        f10199d = aVar;
    }

    public final void j(List<Map<String, Object>> list) {
        kotlin.jvm.internal.m.f(list, "<set-?>");
        f10200e = list;
    }
}
