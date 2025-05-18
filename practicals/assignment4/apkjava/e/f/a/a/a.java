package e.f.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Indicative.java */
/* loaded from: classes.dex */
public class a {
    private static a a;

    /* renamed from: b, reason: collision with root package name */
    private Context f21120b;

    /* renamed from: c, reason: collision with root package name */
    private String f21121c;

    /* compiled from: Indicative.java */
    /* renamed from: e.f.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0264a {
        private String a;

        /* renamed from: b, reason: collision with root package name */
        private String f21122b;

        /* renamed from: c, reason: collision with root package name */
        private long f21123c = System.currentTimeMillis();

        /* renamed from: d, reason: collision with root package name */
        private String f21124d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, Object> f21125e;

        public C0264a(String str, String str2, String str3, Map<String, Object> map) {
            this.a = str;
            this.f21122b = str2;
            this.f21124d = str3;
            this.f21125e = map;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("apiKey", this.a);
                jSONObject.put("eventName", this.f21122b);
                jSONObject.put("eventTime", this.f21123c);
                jSONObject.put("eventUniqueId", this.f21124d);
                Map<String, Object> map = this.f21125e;
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, Object> entry : this.f21125e.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put("properties", jSONObject2);
                }
            } catch (JSONException e2) {
                Log.v("Indicative", "Event" + e2.getMessage(), e2.fillInStackTrace());
            }
            return jSONObject;
        }
    }

    /* compiled from: Indicative.java */
    /* loaded from: classes2.dex */
    public class b extends AsyncTask<Void, Void, Integer> {
        private Context a;

        /* renamed from: b, reason: collision with root package name */
        private String f21126b;

        public b(Context context, String str) {
            this.a = context;
            this.f21126b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                HttpPost httpPost = new HttpPost("https://api.indicative.com/service/event");
                httpPost.setHeader("Content-Type", "application/json");
                httpPost.addHeader("Indicative-Client", "Android");
                httpPost.setEntity(new StringEntity(this.f21126b, "UTF-8"));
                return Integer.valueOf(defaultHttpClient.execute(httpPost).getStatusLine().getStatusCode());
            } catch (Exception e2) {
                Log.v("Indicative", "AsyncTask: " + e2.getMessage(), e2);
                return 400;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            if (num.intValue() == 0 || num.intValue() == 408 || num.intValue() == 500) {
                a.b(this.f21126b);
            }
        }
    }

    /* compiled from: Indicative.java */
    /* loaded from: classes2.dex */
    public class c extends Thread {

        /* renamed from: f, reason: collision with root package name */
        private Context f21128f;

        /* renamed from: g, reason: collision with root package name */
        private Handler f21129g;

        c(Context context, Handler handler) {
            this.f21128f = context;
            this.f21129g = handler;
            setName("SendEventsTimer");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a.this.s(this.f21128f);
            this.f21129g.postDelayed(this, 60000L);
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(String str) {
        synchronized (a.class) {
            if (k().f21120b == null) {
                Log.v("Indicative", "Indicative instance has not been initialized; not recording event");
                return;
            }
            SharedPreferences sharedPreferences = k().f21120b.getSharedPreferences("indicative_events", 0);
            sharedPreferences.edit().putInt(str, sharedPreferences.getInt(str, 0) + 1).commit();
        }
    }

    public static void c(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof Boolean) {
                f(entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            } else if (entry.getValue() instanceof String) {
                e(entry.getKey(), (String) entry.getValue());
            } else if (entry.getValue() instanceof Integer) {
                d(entry.getKey(), ((Integer) entry.getValue()).intValue());
            }
        }
    }

    public static void d(String str, int i2) {
        g(str, i2);
    }

    public static void e(String str, String str2) {
        h(str, str2);
    }

    public static void f(String str, boolean z) {
        i(str, z);
    }

    private static synchronized void g(String str, int i2) {
        synchronized (a.class) {
            if (k().f21120b == null) {
                Log.v("Indicative", "Indicative instance has not been initialized; not adding common prop");
            } else {
                k().f21120b.getSharedPreferences("indicative_prop_cache", 0).edit().putInt(str, i2).commit();
            }
        }
    }

    private static synchronized void h(String str, String str2) {
        synchronized (a.class) {
            if (k().f21120b == null) {
                Log.v("Indicative", "Indicative instance has not been initialized; not adding common prop");
            } else {
                k().f21120b.getSharedPreferences("indicative_prop_cache", 0).edit().putString(str, str2).commit();
            }
        }
    }

    private static synchronized void i(String str, boolean z) {
        synchronized (a.class) {
            if (k().f21120b == null) {
                Log.v("Indicative", "Indicative instance has not been initialized; not adding common prop");
            } else {
                k().f21120b.getSharedPreferences("indicative_prop_cache", 0).edit().putBoolean(str, z).commit();
            }
        }
    }

    private static synchronized Map<String, Object> j() {
        synchronized (a.class) {
            if (k().f21120b == null) {
                Log.v("Indicative", "Indicative instance has not been initialized; not getting common props");
                return new HashMap();
            }
            return k().f21120b.getSharedPreferences("indicative_prop_cache", 0).getAll();
        }
    }

    public static a k() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    private static synchronized String l() {
        synchronized (a.class) {
            if (k().f21120b == null) {
                Log.v("Indicative", "Indicative instance has not been initialized; not setting up unique id");
                return null;
            }
            SharedPreferences sharedPreferences = k().f21120b.getSharedPreferences("indicative_unique", 0);
            String string = sharedPreferences.getString("indicative_unique", null);
            if (string == null || string.isEmpty()) {
                string = sharedPreferences.getString("uuid", null);
            }
            return string;
        }
    }

    public static a m(Context context, String str) {
        a k2 = k();
        k2.f21121c = str;
        k2.f21120b = context;
        u();
        k2.r();
        return k2;
    }

    public static void n(String str) {
        o(str, null, null);
    }

    public static void o(String str, String str2, Map<String, Object> map) {
        p(str, str2, map, false);
    }

    public static void p(String str, String str2, Map<String, Object> map, boolean z) {
        Map<String, Object> j2 = j();
        if (map != null) {
            j2.putAll(map);
        }
        if (str2 == null || str2.isEmpty()) {
            str2 = l();
        }
        String jSONObject = new C0264a(k().f21121c, str, str2, j2).a().toString();
        if (z) {
            k().t(jSONObject);
        } else {
            b(jSONObject);
        }
    }

    public static void q(String str, Map<String, Object> map) {
        o(str, null, map);
    }

    private void t(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        new b(k().f21120b, str).execute(new Void[0]);
    }

    private static synchronized void u() {
        synchronized (a.class) {
            if (k().f21120b == null) {
                Log.v("Indicative", "Indicative instance has not been initialized; not setting up unique id");
                return;
            }
            SharedPreferences sharedPreferences = k().f21120b.getSharedPreferences("indicative_unique", 0);
            if (sharedPreferences.getString("uuid", null) == null) {
                sharedPreferences.edit().putString("uuid", UUID.randomUUID().toString()).commit();
            }
        }
    }

    public static void v(String str) {
        w(str);
    }

    private static synchronized void w(String str) {
        synchronized (a.class) {
            if (k().f21120b == null) {
                Log.v("Indicative", "Indicative instance has not been initialized; not setting up unique id");
            } else {
                k().f21120b.getSharedPreferences("indicative_unique", 0).edit().putString("indicative_unique", str).commit();
            }
        }
    }

    public void r() {
        Handler handler = new Handler();
        handler.post(new c(this.f21120b, handler));
    }

    public synchronized void s(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("indicative_events", 0);
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null && !all.isEmpty()) {
            for (String str : all.keySet()) {
                for (int i2 = 0; i2 < ((Integer) all.get(str)).intValue(); i2++) {
                    new b(context, str).execute(new Void[0]);
                    int i3 = sharedPreferences.getInt(str, 0);
                    if (i3 > 1) {
                        sharedPreferences.edit().putInt(str, i3 - 1).commit();
                    } else {
                        sharedPreferences.edit().remove(str).commit();
                    }
                }
            }
        }
    }
}
