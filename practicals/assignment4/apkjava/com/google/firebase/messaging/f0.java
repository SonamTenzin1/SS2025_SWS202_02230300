package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cm.aptoide.pt.FirebaseConstants;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.messaging.y;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public class f0 {
    private static final com.google.firebase.encoders.a a = new com.google.firebase.encoders.json.d().a(y.b.class, new y.c()).a(y.class, new y.a()).f();

    public static boolean A(Intent intent) {
        if (intent == null || s(intent)) {
            return false;
        }
        return a();
    }

    public static boolean B(Intent intent) {
        if (intent == null || s(intent)) {
            return false;
        }
        return "1".equals(intent.getStringExtra("google.c.a.e"));
    }

    static boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            com.google.firebase.j.j();
            Context i2 = com.google.firebase.j.j().i();
            SharedPreferences sharedPreferences = i2.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = i2.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(i2.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Intent intent) {
        return intent.getStringExtra("collapse_key");
    }

    static String c(Intent intent) {
        return intent.getStringExtra("google.c.a.c_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(Intent intent) {
        return intent.getStringExtra(FirebaseConstants.FIREBASE_MESSAGE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(Intent intent) {
        String stringExtra = intent.getStringExtra("google.to");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        try {
            return (String) Tasks.a(com.google.firebase.installations.h.l(com.google.firebase.j.j()).getId());
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    static String f(Intent intent) {
        return intent.getStringExtra("google.c.a.m_c");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(Intent intent) {
        String stringExtra = intent.getStringExtra(FirebaseConstants.FIREBASE_MESSAGE_ID);
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(Intent intent) {
        return intent.getStringExtra(FirebaseConstants.FIREBASE_MESSAGE_LABEL);
    }

    private static int i(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    static String j(Intent intent) {
        return intent.getStringExtra("google.c.a.ts");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k(Intent intent) {
        return (intent.getExtras() == null || !h0.t(intent.getExtras())) ? "DATA_MESSAGE" : "DISPLAY_NOTIFICATION";
    }

    static String l(Intent intent) {
        return (intent.getExtras() == null || !h0.t(intent.getExtras())) ? "data" : "display";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m() {
        return com.google.firebase.j.j().i().getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(Intent intent) {
        String stringExtra = intent.getStringExtra("google.delivered_priority");
        if (stringExtra == null) {
            if ("1".equals(intent.getStringExtra("google.priority_reduced"))) {
                return 2;
            }
            stringExtra = intent.getStringExtra("google.priority");
        }
        return i(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String o(Intent intent) {
        if (intent.hasExtra("google.c.sender.id")) {
            return intent.getStringExtra("google.c.sender.id");
        }
        com.google.firebase.j j2 = com.google.firebase.j.j();
        String d2 = j2.l().d();
        if (d2 != null) {
            return d2;
        }
        String c2 = j2.l().c();
        if (!c2.startsWith("1:")) {
            return c2;
        }
        String[] split = c2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p(Intent intent) {
        String stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            return null;
        }
        return stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(Intent intent) {
        Object obj = intent.getExtras().get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(valueOf.length() + 13);
            sb.append("Invalid TTL: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0;
        }
    }

    static String r(Intent intent) {
        if (intent.hasExtra("google.c.a.udt")) {
            return intent.getStringExtra("google.c.a.udt");
        }
        return null;
    }

    private static boolean s(Intent intent) {
        return FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(intent.getAction());
    }

    public static void t(Intent intent) {
        y("_nd", intent);
    }

    public static void u(Intent intent) {
        y("_nf", intent);
    }

    public static void v(Intent intent) {
        z(intent);
        y("_no", intent);
    }

    public static void w(Intent intent) {
        if (B(intent)) {
            y("_nr", intent);
        }
        if (A(intent)) {
            e.e.b.a.g i2 = FirebaseMessaging.i();
            if (i2 != null) {
                x("MESSAGE_DELIVERED", intent, i2.a("FCM_CLIENT_EVENT_LOGGING", String.class, e.e.b.a.b.b(BodyInterceptorV3.RESPONSE_MODE_JSON), e0.a));
            } else {
                Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
            }
        }
    }

    private static void x(String str, Intent intent, e.e.b.a.f<String> fVar) {
        try {
            fVar.a(e.e.b.a.c.e(a.b(new y.b(new y("MESSAGE_DELIVERED", intent)))));
        } catch (EncodingException unused) {
            Log.d("FirebaseMessaging", "Failed to encode big query analytics payload. Skip sending");
        }
    }

    static void y(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String c2 = c(intent);
        if (c2 != null) {
            bundle.putString("_nmid", c2);
        }
        String d2 = d(intent);
        if (d2 != null) {
            bundle.putString("_nmn", d2);
        }
        String h2 = h(intent);
        if (!TextUtils.isEmpty(h2)) {
            bundle.putString("label", h2);
        }
        String f2 = f(intent);
        if (!TextUtils.isEmpty(f2)) {
            bundle.putString("message_channel", f2);
        }
        String p = p(intent);
        if (p != null) {
            bundle.putString("_nt", p);
        }
        String j2 = j(intent);
        if (j2 != null) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(j2));
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e2);
            }
        }
        String r = r(intent);
        if (r != null) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(r));
            } catch (NumberFormatException e3) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e3);
            }
        }
        String l = l(intent);
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", l);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(str.length() + 37 + valueOf.length());
            sb.append("Logging to scion event=");
            sb.append(str);
            sb.append(" scionPayload=");
            sb.append(valueOf);
            Log.d("FirebaseMessaging", sb.toString());
        }
        com.google.firebase.analytics.a.a aVar = (com.google.firebase.analytics.a.a) com.google.firebase.j.j().h(com.google.firebase.analytics.a.a.class);
        if (aVar != null) {
            aVar.m0("fcm", str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }

    private static void z(Intent intent) {
        if (intent == null) {
            return;
        }
        if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
            com.google.firebase.analytics.a.a aVar = (com.google.firebase.analytics.a.a) com.google.firebase.j.j().h(com.google.firebase.analytics.a.a.class);
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
            }
            if (aVar != null) {
                String stringExtra = intent.getStringExtra("google.c.a.c_id");
                aVar.a("fcm", "_ln", stringExtra);
                Bundle bundle = new Bundle();
                bundle.putString("source", "Firebase");
                bundle.putString("medium", "notification");
                bundle.putString("campaign", stringExtra);
                aVar.m0("fcm", "_cmp", bundle);
                return;
            }
            Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
            return;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
        }
    }
}
