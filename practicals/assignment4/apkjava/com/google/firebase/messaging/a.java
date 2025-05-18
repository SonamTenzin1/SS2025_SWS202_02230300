package com.google.firebase.messaging;

import android.R;
import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.i;
import cm.aptoide.pt.BuildConfig;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public final class a {
    private static final AtomicInteger a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* renamed from: com.google.firebase.messaging.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0233a {
        public final i.e a;

        /* renamed from: b, reason: collision with root package name */
        public final String f19791b;

        /* renamed from: c, reason: collision with root package name */
        public final int f19792c = 0;

        C0233a(i.e eVar, String str, int i2) {
            this.a = eVar;
            this.f19791b = str;
        }
    }

    private static PendingIntent a(Context context, h0 h0Var, String str, PackageManager packageManager) {
        Intent f2 = f(str, h0Var, packageManager);
        if (f2 == null) {
            return null;
        }
        f2.addFlags(67108864);
        f2.putExtras(h0Var.y());
        PendingIntent activity = PendingIntent.getActivity(context, g(), f2, l(1073741824));
        return q(h0Var) ? r(context, h0Var, activity) : activity;
    }

    private static PendingIntent b(Context context, h0 h0Var) {
        if (q(h0Var)) {
            return c(context, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(h0Var.x()));
        }
        return null;
    }

    private static PendingIntent c(Context context, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), l(1073741824));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C0233a d(Context context, h0 h0Var) {
        Bundle j2 = j(context.getPackageManager(), context.getPackageName());
        return e(context, context.getPackageName(), h0Var, k(context, h0Var.k(), j2), context.getResources(), context.getPackageManager(), j2);
    }

    public static C0233a e(Context context, String str, h0 h0Var, String str2, Resources resources, PackageManager packageManager, Bundle bundle) {
        i.e eVar = new i.e(context, str2);
        String n = h0Var.n(resources, str, "gcm.n.title");
        if (!TextUtils.isEmpty(n)) {
            eVar.l(n);
        }
        String n2 = h0Var.n(resources, str, "gcm.n.body");
        if (!TextUtils.isEmpty(n2)) {
            eVar.k(n2);
            eVar.A(new i.c().h(n2));
        }
        eVar.y(m(packageManager, resources, str, h0Var.p("gcm.n.icon"), bundle));
        Uri n3 = n(str, h0Var, resources);
        if (n3 != null) {
            eVar.z(n3);
        }
        eVar.j(a(context, h0Var, str, packageManager));
        PendingIntent b2 = b(context, h0Var);
        if (b2 != null) {
            eVar.n(b2);
        }
        Integer h2 = h(context, h0Var.p("gcm.n.color"), bundle);
        if (h2 != null) {
            eVar.i(h2.intValue());
        }
        eVar.g(!h0Var.a("gcm.n.sticky"));
        eVar.r(h0Var.a("gcm.n.local_only"));
        String p = h0Var.p("gcm.n.ticker");
        if (p != null) {
            eVar.B(p);
        }
        Integer m = h0Var.m();
        if (m != null) {
            eVar.v(m.intValue());
        }
        Integer r = h0Var.r();
        if (r != null) {
            eVar.D(r.intValue());
        }
        Integer l = h0Var.l();
        if (l != null) {
            eVar.s(l.intValue());
        }
        Long j2 = h0Var.j("gcm.n.event_time");
        if (j2 != null) {
            eVar.x(true);
            eVar.E(j2.longValue());
        }
        long[] q = h0Var.q();
        if (q != null) {
            eVar.C(q);
        }
        int[] e2 = h0Var.e();
        if (e2 != null) {
            eVar.q(e2[0], e2[1], e2[2]);
        }
        eVar.m(i(h0Var));
        return new C0233a(eVar, o(h0Var), 0);
    }

    private static Intent f(String str, h0 h0Var, PackageManager packageManager) {
        String p = h0Var.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(p)) {
            Intent intent = new Intent(p);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri f2 = h0Var.f();
        if (f2 != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(f2);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int g() {
        return a.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
                sb.append("Color is invalid: ");
                sb.append(str);
                sb.append(". Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i2 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i2 != 0) {
            try {
                return Integer.valueOf(androidx.core.content.a.d(context, i2));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    private static int i(h0 h0Var) {
        boolean a2 = h0Var.a("gcm.n.default_sound");
        ?? r0 = a2;
        if (h0Var.a("gcm.n.default_vibrate_timings")) {
            r0 = (a2 ? 1 : 0) | 2;
        }
        return h0Var.a("gcm.n.default_light_settings") ? r0 | 4 : r0;
    }

    private static Bundle j(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle;
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
        }
        return Bundle.EMPTY;
    }

    @TargetApi(26)
    public static String k(Context context, String str, Bundle bundle) {
        String string;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion >= 26) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                if (!TextUtils.isEmpty(str)) {
                    if (notificationManager.getNotificationChannel(str) != null) {
                        return str;
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
                    sb.append("Notification Channel requested (");
                    sb.append(str);
                    sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                    Log.w("FirebaseMessaging", sb.toString());
                }
                String string2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
                if (!TextUtils.isEmpty(string2)) {
                    if (notificationManager.getNotificationChannel(string2) != null) {
                        return string2;
                    }
                    Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                } else {
                    Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                }
                if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                    int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName());
                    if (identifier == 0) {
                        Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                        string = "Misc";
                    } else {
                        string = context.getString(identifier);
                    }
                    notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", string, 3));
                }
                return "fcm_fallback_notification_channel";
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static int l(int i2) {
        return Build.VERSION.SDK_INT >= 23 ? 1140850688 : 1073741824;
    }

    private static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 61);
            sb.append("Icon resource ");
            sb.append(str2);
            sb.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        int i2 = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i2 == 0 || !p(resources, i2)) {
            try {
                i2 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
                Log.w("FirebaseMessaging", sb2.toString());
            }
        }
        return (i2 == 0 || !p(resources, i2)) ? R.drawable.sym_def_app_icon : i2;
    }

    private static Uri n(String str, h0 h0Var, Resources resources) {
        String o = h0Var.o();
        if (TextUtils.isEmpty(o)) {
            return null;
        }
        if (!BuildConfig.APTOIDE_THEME.equals(o) && resources.getIdentifier(o, "raw", str) != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(o).length());
            sb.append("android.resource://");
            sb.append(str);
            sb.append("/raw/");
            sb.append(o);
            return Uri.parse(sb.toString());
        }
        return RingtoneManager.getDefaultUri(2);
    }

    private static String o(h0 h0Var) {
        String p = h0Var.p("gcm.n.tag");
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        StringBuilder sb = new StringBuilder(37);
        sb.append("FCM-Notification:");
        sb.append(uptimeMillis);
        return sb.toString();
    }

    @TargetApi(26)
    private static boolean p(Resources resources, int i2) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i2, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i2);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i2);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }

    static boolean q(h0 h0Var) {
        return h0Var.a("google.c.a.e");
    }

    private static PendingIntent r(Context context, h0 h0Var, PendingIntent pendingIntent) {
        return c(context, new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(h0Var.x()).putExtra("pending_intent", pendingIntent));
    }
}
