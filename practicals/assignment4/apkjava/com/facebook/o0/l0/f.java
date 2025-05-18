package com.facebook.o0.l0;

import android.content.SharedPreferences;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.d0;
import com.facebook.e0;
import com.facebook.g0;
import com.facebook.internal.j0;
import com.facebook.internal.p0;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.s;
import kotlin.text.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppEventsCAPIManager.kt */
/* loaded from: classes.dex */
public final class f {
    public static final f a = new f();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10177b = f.class.getCanonicalName();

    /* renamed from: c, reason: collision with root package name */
    private static boolean f10178c;

    private f() {
    }

    public static final void a() {
        String b2;
        try {
            a aVar = new GraphRequest.b() { // from class: com.facebook.o0.l0.a
                @Override // com.facebook.GraphRequest.b
                public final void b(d0 d0Var) {
                    f.b(d0Var);
                }
            };
            a0 a0Var = a0.a;
            GraphRequest graphRequest = new GraphRequest(null, kotlin.jvm.internal.m.n(a0.d(), "/cloudbridge_settings"), null, e0.GET, aVar, null, 32, null);
            j0.a aVar2 = j0.a;
            g0 g0Var = g0.APP_EVENTS;
            String str = f10177b;
            if (str != null) {
                aVar2.c(g0Var, str, " \n\nCreating Graph Request: \n=============\n%s\n\n ", graphRequest);
                graphRequest.k();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (JSONException e2) {
            j0.a aVar3 = j0.a;
            g0 g0Var2 = g0.APP_EVENTS;
            String str2 = f10177b;
            if (str2 != null) {
                b2 = kotlin.b.b(e2);
                aVar3.c(g0Var2, str2, " \n\nGraph Request Exception: \n=============\n%s\n\n ", b2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "response");
        a.c(d0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Map<String, Object> d() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean t;
        boolean t2;
        boolean t3;
        a0 a0Var = a0.a;
        SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
        if (sharedPreferences == null) {
            return null;
        }
        o oVar = o.DATASETID;
        String string = sharedPreferences.getString(oVar.k(), null);
        o oVar2 = o.URL;
        String string2 = sharedPreferences.getString(oVar2.k(), null);
        o oVar3 = o.ACCESSKEY;
        String string3 = sharedPreferences.getString(oVar3.k(), null);
        if (string != null) {
            t3 = u.t(string);
            if (!t3) {
                z = false;
                if (!z) {
                    return null;
                }
                if (string2 != null) {
                    t2 = u.t(string2);
                    if (!t2) {
                        z2 = false;
                        if (!z2) {
                            return null;
                        }
                        if (string3 != null) {
                            t = u.t(string3);
                            if (!t) {
                                z3 = false;
                                if (!z3) {
                                    return null;
                                }
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                linkedHashMap.put(oVar2.k(), string2);
                                linkedHashMap.put(oVar.k(), string);
                                linkedHashMap.put(oVar3.k(), string3);
                                j0.a.c(g0.APP_EVENTS, f10177b.toString(), " \n\nLoading Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", string, string2, string3);
                                return linkedHashMap;
                            }
                        }
                        z3 = true;
                        if (!z3) {
                        }
                    }
                }
                z2 = true;
                if (!z2) {
                }
            }
        }
        z = true;
        if (!z) {
        }
    }

    public final void c(d0 d0Var) {
        String b2;
        String b3;
        String b4;
        kotlin.jvm.internal.m.f(d0Var, "response");
        boolean z = false;
        if (d0Var.b() != null) {
            j0.a aVar = j0.a;
            g0 g0Var = g0.APP_EVENTS;
            String str = f10177b;
            if (str != null) {
                aVar.c(g0Var, str, " \n\nGraph Response Error: \n================\nResponse Error: %s\nResponse Error Exception: %s\n\n ", d0Var.b().toString(), String.valueOf(d0Var.b().e()));
                Map<String, Object> d2 = d();
                if (d2 != null) {
                    URL url = new URL(String.valueOf(d2.get(o.URL.k())));
                    h hVar = h.a;
                    h.c(String.valueOf(d2.get(o.DATASETID.k())), url.getProtocol() + "://" + ((Object) url.getHost()), String.valueOf(d2.get(o.ACCESSKEY.k())));
                    f10178c = true;
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        j0.a aVar2 = j0.a;
        g0 g0Var2 = g0.APP_EVENTS;
        String str2 = f10177b;
        if (str2 != null) {
            aVar2.c(g0Var2, str2, " \n\nGraph Response Received: \n================\n%s\n\n ", d0Var);
            JSONObject c2 = d0Var.c();
            try {
                p0 p0Var = p0.a;
                Object obj = c2 == null ? null : c2.get("data");
                if (obj != null) {
                    Map<String, ? extends Object> l = p0.l(new JSONObject((String) s.W(p0.k((JSONArray) obj))));
                    String str3 = (String) l.get(o.URL.k());
                    String str4 = (String) l.get(o.DATASETID.k());
                    String str5 = (String) l.get(o.ACCESSKEY.k());
                    if (str3 != null && str4 != null && str5 != null) {
                        try {
                            h hVar2 = h.a;
                            h.c(str4, str3, str5);
                            g(l);
                            o oVar = o.ENABLED;
                            if (l.get(oVar.k()) != null) {
                                Object obj2 = l.get(oVar.k());
                                if (obj2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                z = ((Boolean) obj2).booleanValue();
                            }
                            f10178c = z;
                            return;
                        } catch (MalformedURLException e2) {
                            j0.a aVar3 = j0.a;
                            g0 g0Var3 = g0.APP_EVENTS;
                            String str6 = f10177b;
                            kotlin.jvm.internal.m.e(str6, "TAG");
                            b4 = kotlin.b.b(e2);
                            aVar3.c(g0Var3, str6, "CloudBridge Settings API response doesn't have valid url\n %s ", b4);
                            return;
                        }
                    }
                    kotlin.jvm.internal.m.e(str2, "TAG");
                    aVar2.b(g0Var2, str2, "CloudBridge Settings API response doesn't have valid data");
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
            } catch (NullPointerException e3) {
                j0.a aVar4 = j0.a;
                g0 g0Var4 = g0.APP_EVENTS;
                String str7 = f10177b;
                kotlin.jvm.internal.m.e(str7, "TAG");
                b3 = kotlin.b.b(e3);
                aVar4.c(g0Var4, str7, "CloudBridge Settings API response is not a valid json: \n%s ", b3);
                return;
            } catch (JSONException e4) {
                j0.a aVar5 = j0.a;
                g0 g0Var5 = g0.APP_EVENTS;
                String str8 = f10177b;
                kotlin.jvm.internal.m.e(str8, "TAG");
                b2 = kotlin.b.b(e4);
                aVar5.c(g0Var5, str8, "CloudBridge Settings API response is not a valid json: \n%s ", b2);
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final boolean e() {
        return f10178c;
    }

    public final void g(Map<String, ? extends Object> map) {
        a0 a0Var = a0.a;
        SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
        if (sharedPreferences == null) {
            return;
        }
        if (map == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            edit.apply();
            return;
        }
        o oVar = o.DATASETID;
        Object obj = map.get(oVar.k());
        o oVar2 = o.URL;
        Object obj2 = map.get(oVar2.k());
        o oVar3 = o.ACCESSKEY;
        Object obj3 = map.get(oVar3.k());
        if (obj == null || obj2 == null || obj3 == null) {
            return;
        }
        SharedPreferences.Editor edit2 = sharedPreferences.edit();
        edit2.putString(oVar.k(), obj.toString());
        edit2.putString(oVar2.k(), obj2.toString());
        edit2.putString(oVar3.k(), obj3.toString());
        edit2.apply();
        j0.a.c(g0.APP_EVENTS, f10177b.toString(), " \n\nSaving Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", obj, obj2, obj3);
    }
}
