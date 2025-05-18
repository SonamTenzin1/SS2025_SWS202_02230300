package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.database.room.RoomNotification;
import cm.aptoide.pt.dataprovider.BuildConfig;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.internal.a0;
import com.facebook.internal.p0;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: Utility.kt */
/* loaded from: classes2.dex */
public final class p0 {

    /* renamed from: b, reason: collision with root package name */
    private static int f9817b;

    /* renamed from: j, reason: collision with root package name */
    private static Locale f9825j;
    public static final p0 a = new p0();

    /* renamed from: c, reason: collision with root package name */
    private static long f9818c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static long f9819d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static long f9820e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static String f9821f = HttpUrl.FRAGMENT_ENCODE_SET;

    /* renamed from: g, reason: collision with root package name */
    private static String f9822g = HttpUrl.FRAGMENT_ENCODE_SET;

    /* renamed from: h, reason: collision with root package name */
    private static String f9823h = "NoCarrier";

    /* renamed from: i, reason: collision with root package name */
    private static String f9824i = HttpUrl.FRAGMENT_ENCODE_SET;

    /* compiled from: Utility.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void a(JSONObject jSONObject);

        void b(FacebookException facebookException);
    }

    private p0() {
    }

    public static final JSONObject A() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String string = com.facebook.a0.c().getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).getString("data_processing_options", null);
        if (string != null) {
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final void A0() {
        try {
            if (p()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f9819d = statFs.getBlockCount() * statFs.getBlockSize();
            }
            f9819d = j(f9819d);
        } catch (Exception unused) {
        }
    }

    public static final void B0(Runnable runnable) {
        try {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            com.facebook.a0.k().execute(runnable);
        } catch (Exception unused) {
        }
    }

    public static final String C(String str) {
        String A;
        String A2;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String l = com.facebook.a0.l();
        if (str == null) {
            return l;
        }
        if (kotlin.jvm.internal.m.a(str, "gaming")) {
            A2 = kotlin.text.u.A(l, "facebook.com", "fb.gg", false, 4, null);
            return A2;
        }
        if (!kotlin.jvm.internal.m.a(str, "instagram")) {
            return l;
        }
        A = kotlin.text.u.A(l, "facebook.com", "instagram.com", false, 4, null);
        return A;
    }

    public static final void C0(JSONObject jSONObject, q qVar, String str, boolean z, Context context) throws JSONException {
        kotlin.jvm.internal.m.f(jSONObject, "params");
        kotlin.jvm.internal.m.f(context, "context");
        a0 a0Var = a0.a;
        a0.b bVar = a0.b.ServiceUpdateCompliance;
        if (!a0.g(bVar)) {
            jSONObject.put("anon_id", str);
        }
        jSONObject.put("application_tracking_enabled", !z);
        com.facebook.a0 a0Var2 = com.facebook.a0.a;
        jSONObject.put("advertiser_id_collection_enabled", com.facebook.a0.b());
        if (qVar != null) {
            if (a0.g(bVar)) {
                a.a(jSONObject, qVar, str, context);
            }
            if (qVar.j() != null) {
                if (a0.g(bVar)) {
                    a.b(jSONObject, qVar, context);
                } else {
                    jSONObject.put("attribution", qVar.j());
                }
            }
            if (qVar.h() != null) {
                jSONObject.put("advertiser_id", qVar.h());
                jSONObject.put("advertiser_tracking_enabled", !qVar.k());
            }
            if (!qVar.k()) {
                com.facebook.o0.j0 j0Var = com.facebook.o0.j0.a;
                String a2 = com.facebook.o0.j0.a();
                if (!(a2.length() == 0)) {
                    jSONObject.put("ud", a2);
                }
            }
            if (qVar.i() != null) {
                jSONObject.put("installer_package", qVar.i());
            }
        }
    }

    private final GraphRequest D(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", K(z()));
        bundle.putString("access_token", str);
        GraphRequest y = GraphRequest.a.y(null, null);
        y.H(bundle);
        y.G(com.facebook.e0.GET);
        return y;
    }

    public static final void D0(JSONObject jSONObject, Context context) throws JSONException {
        Locale locale;
        String language;
        int i2;
        Display display;
        String country;
        PackageInfo packageInfo;
        kotlin.jvm.internal.m.f(jSONObject, "params");
        kotlin.jvm.internal.m.f(context, "appContext");
        JSONArray jSONArray = new JSONArray();
        p0 p0Var = a;
        jSONArray.put("a2");
        p0Var.y0(context);
        String packageName = context.getPackageName();
        int i3 = 0;
        int i4 = -1;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return;
        }
        i4 = packageInfo.versionCode;
        f9824i = packageInfo.versionName;
        jSONArray.put(packageName);
        jSONArray.put(i4);
        jSONArray.put(f9824i);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception unused2) {
            locale = Locale.getDefault();
        }
        f9825j = locale;
        StringBuilder sb = new StringBuilder();
        Locale locale2 = f9825j;
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (locale2 == null || (language = locale2.getLanguage()) == null) {
            language = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(language);
        sb.append('_');
        Locale locale3 = f9825j;
        if (locale3 != null && (country = locale3.getCountry()) != null) {
            str = country;
        }
        sb.append(str);
        jSONArray.put(sb.toString());
        jSONArray.put(f9821f);
        jSONArray.put(f9823h);
        double d2 = 0.0d;
        try {
            display = null;
            if (Build.VERSION.SDK_INT >= 17) {
                Object systemService = context.getSystemService("display");
                DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
                if (displayManager != null) {
                    display = displayManager.getDisplay(0);
                }
            } else {
                Object systemService2 = context.getSystemService("window");
                WindowManager windowManager = systemService2 instanceof WindowManager ? (WindowManager) systemService2 : null;
                if (windowManager != null) {
                    display = windowManager.getDefaultDisplay();
                }
            }
        } catch (Exception unused3) {
        }
        if (display != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getMetrics(displayMetrics);
            int i5 = displayMetrics.widthPixels;
            try {
                int i6 = displayMetrics.heightPixels;
                try {
                    d2 = displayMetrics.density;
                } catch (Exception unused4) {
                }
                i2 = i6;
                i3 = i5;
            } catch (Exception unused5) {
                i3 = i5;
            }
            jSONArray.put(i3);
            jSONArray.put(i2);
            jSONArray.put(new DecimalFormat("#.##").format(d2));
            jSONArray.put(a.v0());
            jSONArray.put(f9819d);
            jSONArray.put(f9820e);
            jSONArray.put(f9822g);
            jSONObject.put("extinfo", jSONArray.toString());
        }
        i2 = 0;
        jSONArray.put(i3);
        jSONArray.put(i2);
        jSONArray.put(new DecimalFormat("#.##").format(d2));
        jSONArray.put(a.v0());
        jSONArray.put(f9819d);
        jSONArray.put(f9820e);
        jSONArray.put(f9822g);
        jSONObject.put("extinfo", jSONArray.toString());
    }

    public static final void E(final String str, final a aVar) {
        kotlin.jvm.internal.m.f(str, "accessToken");
        kotlin.jvm.internal.m.f(aVar, "callback");
        m0 m0Var = m0.a;
        JSONObject a2 = m0.a(str);
        if (a2 != null) {
            aVar.a(a2);
            return;
        }
        GraphRequest.b bVar = new GraphRequest.b() { // from class: com.facebook.internal.k
            @Override // com.facebook.GraphRequest.b
            public final void b(com.facebook.d0 d0Var) {
                p0.F(p0.a.this, str, d0Var);
            }
        };
        GraphRequest D = a.D(str);
        D.D(bVar);
        D.k();
    }

    public static final String E0(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "bytes");
        return a.Q("SHA-1", bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(a aVar, String str, com.facebook.d0 d0Var) {
        kotlin.jvm.internal.m.f(aVar, "$callback");
        kotlin.jvm.internal.m.f(str, "$accessToken");
        kotlin.jvm.internal.m.f(d0Var, "response");
        if (d0Var.b() != null) {
            aVar.b(d0Var.b().e());
            return;
        }
        m0 m0Var = m0.a;
        JSONObject d2 = d0Var.d();
        if (d2 != null) {
            m0.b(str, d2);
            aVar.a(d0Var.d());
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final String F0(String str) {
        if (str == null) {
            return null;
        }
        return a.P("SHA-256", str);
    }

    public static final void G0(Parcel parcel, Map<String, String> map) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    public static final String H(Context context) {
        q0 q0Var = q0.a;
        q0.j(context, "context");
        com.facebook.a0 a0Var = com.facebook.a0.a;
        return com.facebook.a0.d();
    }

    public static final void H0(Parcel parcel, Map<String, String> map) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    public static final Method I(Class<?> cls, String str, Class<?>... clsArr) {
        kotlin.jvm.internal.m.f(cls, "clazz");
        kotlin.jvm.internal.m.f(str, "methodName");
        kotlin.jvm.internal.m.f(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static final Method J(String str, String str2, Class<?>... clsArr) {
        kotlin.jvm.internal.m.f(str, "className");
        kotlin.jvm.internal.m.f(str2, "methodName");
        kotlin.jvm.internal.m.f(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            kotlin.jvm.internal.m.e(cls, "clazz");
            return I(cls, str2, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final String K(String str) {
        return kotlin.jvm.internal.m.a(str, "instagram") ? "id,name,profile_picture" : "id,name,first_name,middle_name,last_name";
    }

    public static final Locale L() {
        try {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            return com.facebook.a0.c().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Object M(JSONObject jSONObject, String str, String str2) throws JSONException {
        kotlin.jvm.internal.m.f(jSONObject, "jsonObject");
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    private final String O(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        kotlin.jvm.internal.m.e(digest, "digest");
        int length = digest.length;
        int i2 = 0;
        while (i2 < length) {
            byte b2 = digest[i2];
            i2++;
            sb.append(Integer.toHexString((b2 >> 4) & 15));
            sb.append(Integer.toHexString((b2 >> 0) & 15));
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.e(sb2, "builder.toString()");
        return sb2;
    }

    private final String P(String str, String str2) {
        Charset charset = Charsets.f25054b;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str2.getBytes(charset);
        kotlin.jvm.internal.m.e(bytes, "(this as java.lang.String).getBytes(charset)");
        return Q(str, bytes);
    }

    private final String Q(String str, byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            kotlin.jvm.internal.m.e(messageDigest, "hash");
            return O(messageDigest, bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static final Object R(Object obj, Method method, Object... objArr) {
        kotlin.jvm.internal.m.f(method, "method");
        kotlin.jvm.internal.m.f(objArr, "args");
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean S() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            com.facebook.a0 a0Var = com.facebook.a0.a;
            String format = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{com.facebook.a0.d()}, 1));
            kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(format));
            Context c2 = com.facebook.a0.c();
            PackageManager packageManager = c2.getPackageManager();
            String packageName = c2.getPackageName();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            kotlin.jvm.internal.m.e(queryIntentActivities, "packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
            Iterator<ResolveInfo> it = queryIntentActivities.iterator();
            while (it.hasNext()) {
                if (kotlin.jvm.internal.m.a(packageName, it.next().activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean T(Context context) {
        AutofillManager autofillManager;
        kotlin.jvm.internal.m.f(context, "context");
        return Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled();
    }

    public static final boolean U(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        if (str != null) {
            kotlin.jvm.internal.m.e(str, "DEVICE");
            if (new Regex(".+_cheets|cheets_.+").b(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean V(Uri uri) {
        boolean q;
        if (uri != null) {
            q = kotlin.text.u.q("content", uri.getScheme(), true);
            if (q) {
                return true;
            }
        }
        return false;
    }

    public static final boolean W(AccessToken accessToken) {
        return accessToken != null && kotlin.jvm.internal.m.a(accessToken, AccessToken.f9559f.e());
    }

    public static final boolean X() {
        JSONObject A = A();
        if (A == null) {
            return false;
        }
        try {
            JSONArray jSONArray = A.getJSONArray("data_processing_options");
            int length = jSONArray.length();
            if (length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    String string = jSONArray.getString(i2);
                    kotlin.jvm.internal.m.e(string, "options.getString(i)");
                    String lowerCase = string.toLowerCase();
                    kotlin.jvm.internal.m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (kotlin.jvm.internal.m.a(lowerCase, "ldu")) {
                        return true;
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean Y(Uri uri) {
        boolean q;
        if (uri != null) {
            q = kotlin.text.u.q("file", uri.getScheme(), true);
            if (q) {
                return true;
            }
        }
        return false;
    }

    private final boolean Z(Context context) {
        Method J = J("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (J == null) {
            return false;
        }
        Object R = R(null, J, context);
        return (R instanceof Integer) && kotlin.jvm.internal.m.a(R, 0);
    }

    private final void a(JSONObject jSONObject, q qVar, String str, Context context) {
        if (Build.VERSION.SDK_INT >= 31 && Z(context)) {
            if (qVar.k()) {
                return;
            }
            jSONObject.put("anon_id", str);
            return;
        }
        jSONObject.put("anon_id", str);
    }

    public static final boolean a0(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    private final void b(JSONObject jSONObject, q qVar, Context context) {
        if (Build.VERSION.SDK_INT >= 31 && Z(context)) {
            if (qVar.k()) {
                return;
            }
            jSONObject.put("attribution", qVar.j());
            return;
        }
        jSONObject.put("attribution", qVar.j());
    }

    public static final boolean b0(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static final <T> boolean c(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return kotlin.jvm.internal.m.a(t, t2);
    }

    public static final boolean c0(Uri uri) {
        boolean q;
        boolean q2;
        boolean q3;
        if (uri != null) {
            q = kotlin.text.u.q("http", uri.getScheme(), true);
            if (q) {
                return true;
            }
            q2 = kotlin.text.u.q(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME, uri.getScheme(), true);
            if (q2) {
                return true;
            }
            q3 = kotlin.text.u.q("fbstaging", uri.getScheme(), true);
            if (q3) {
                return true;
            }
        }
        return false;
    }

    public static final JSONObject d(String str) {
        kotlin.jvm.internal.m.f(str, "accessToken");
        m0 m0Var = m0.a;
        JSONObject a2 = m0.a(str);
        if (a2 != null) {
            return a2;
        }
        com.facebook.d0 j2 = a.D(str).j();
        if (j2.b() != null) {
            return null;
        }
        return j2.d();
    }

    public static final Set<String> d0(JSONArray jSONArray) throws JSONException {
        kotlin.jvm.internal.m.f(jSONArray, "jsonArray");
        HashSet hashSet = new HashSet();
        int length = jSONArray.length();
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                String string = jSONArray.getString(i2);
                kotlin.jvm.internal.m.e(string, "jsonArray.getString(i)");
                hashSet.add(string);
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return hashSet;
    }

    public static final Uri e(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        kotlin.jvm.internal.m.e(build, "builder.build()");
        return build;
    }

    public static final List<String> e0(JSONArray jSONArray) throws JSONException {
        kotlin.jvm.internal.m.f(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                arrayList.add(jSONArray.getString(i2));
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return arrayList;
    }

    private final void f(Context context, String str) {
        List v0;
        List v02;
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        v0 = kotlin.text.v.v0(cookie, new String[]{";"}, false, 0, 6, null);
        Object[] array = v0.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str2 = strArr[i2];
                i2++;
                v02 = kotlin.text.v.v0(str2, new String[]{"="}, false, 0, 6, null);
                Object[] array2 = v02.toArray(new String[0]);
                if (array2 != null) {
                    String[] strArr2 = (String[]) array2;
                    if (strArr2.length > 0) {
                        String str3 = strArr2[0];
                        int length2 = str3.length() - 1;
                        int i3 = 0;
                        boolean z = false;
                        while (i3 <= length2) {
                            boolean z2 = kotlin.jvm.internal.m.h(str3.charAt(!z ? i3 : length2), 32) <= 0;
                            if (z) {
                                if (!z2) {
                                    break;
                                } else {
                                    length2--;
                                }
                            } else if (z2) {
                                i3++;
                            } else {
                                z = true;
                            }
                        }
                        cookieManager.setCookie(str, kotlin.jvm.internal.m.n(str3.subSequence(i3, length2 + 1).toString(), "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;"));
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            cookieManager.removeExpiredCookie();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final Map<String, String> f0(String str) {
        kotlin.jvm.internal.m.f(str, "str");
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                kotlin.jvm.internal.m.e(next, RoomNotification.KEY);
                String string = jSONObject.getString(next);
                kotlin.jvm.internal.m.e(string, "jsonObject.getString(key)");
                hashMap.put(next, string);
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static final void g(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        try {
            p0 p0Var = a;
            p0Var.f(context, "facebook.com");
            p0Var.f(context, ".facebook.com");
            p0Var.f(context, "https://facebook.com");
            p0Var.f(context, "https://.facebook.com");
        } catch (Exception unused) {
        }
    }

    public static final void h(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final String i(String str, String str2) {
        return a0(str) ? str2 : str;
    }

    public static final void i0(String str, Exception exc) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (!com.facebook.a0.u() || str == null || exc == null) {
            return;
        }
        Log.d(str, exc.getClass().getSimpleName() + ": " + ((Object) exc.getMessage()));
    }

    private final long j(double d2) {
        return Math.round(d2 / 1.073741824E9d);
    }

    public static final void j0(String str, String str2) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (!com.facebook.a0.u() || str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    public static final List<String> k(JSONArray jSONArray) {
        kotlin.jvm.internal.m.f(jSONArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int length = jSONArray.length();
            if (length <= 0) {
                return arrayList;
            }
            while (true) {
                int i3 = i2 + 1;
                String string = jSONArray.getString(i2);
                kotlin.jvm.internal.m.e(string, "jsonArray.getString(i)");
                arrayList.add(string);
                if (i3 >= length) {
                    return arrayList;
                }
                i2 = i3;
            }
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static final void k0(String str, String str2, Throwable th) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (!com.facebook.a0.u() || a0(str)) {
            return;
        }
        Log.d(str, str2, th);
    }

    public static final Map<String, Object> l(JSONObject jSONObject) {
        kotlin.jvm.internal.m.f(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        if (names == null) {
            return hashMap;
        }
        int i2 = 0;
        int length = names.length();
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                try {
                    String string = names.getString(i2);
                    kotlin.jvm.internal.m.e(string, "keys.getString(i)");
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        obj = l((JSONObject) obj);
                    }
                    kotlin.jvm.internal.m.e(obj, "value");
                    hashMap.put(string, obj);
                } catch (JSONException unused) {
                }
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return hashMap;
    }

    public static final String l0(Map<String, String> map) {
        kotlin.jvm.internal.m.f(map, "map");
        boolean isEmpty = map.isEmpty();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (!isEmpty) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                str = jSONObject.toString();
            } catch (JSONException unused) {
            }
            kotlin.jvm.internal.m.e(str, "{\n      try {\n        val jsonObject = JSONObject()\n        for ((key, value) in map) {\n          jsonObject.put(key, value)\n        }\n        jsonObject.toString()\n      } catch (_e: JSONException) {\n        \"\"\n      }\n    }");
        }
        return str;
    }

    public static final Map<String, String> m(JSONObject jSONObject) {
        kotlin.jvm.internal.m.f(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                kotlin.jvm.internal.m.e(next, RoomNotification.KEY);
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    public static final String m0(String str) {
        kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
        return a.P("MD5", str);
    }

    public static final int n(InputStream inputStream, OutputStream outputStream) throws IOException {
        kotlin.jvm.internal.m.f(outputStream, "outputStream");
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[8192];
                int i2 = 0;
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    i2 += read;
                }
                bufferedInputStream2.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return i2;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final boolean n0(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        return T(context);
    }

    public static final void o(URLConnection uRLConnection) {
        if (uRLConnection == null || !(uRLConnection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) uRLConnection).disconnect();
    }

    public static final Bundle o0(String str) {
        List v0;
        List v02;
        Bundle bundle = new Bundle();
        if (!a0(str)) {
            if (str != null) {
                v0 = kotlin.text.v.v0(str, new String[]{"&"}, false, 0, 6, null);
                Object[] array = v0.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    int length = strArr.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String str2 = strArr[i2];
                        i2++;
                        v02 = kotlin.text.v.v0(str2, new String[]{"="}, false, 0, 6, null);
                        Object[] array2 = v02.toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            try {
                                if (strArr2.length == 2) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                                } else if (strArr2.length == 1) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), HttpUrl.FRAGMENT_ENCODE_SET);
                                }
                            } catch (UnsupportedEncodingException e2) {
                                i0("FacebookSDK", e2);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return bundle;
    }

    private final boolean p() {
        return kotlin.jvm.internal.m.a("mounted", Environment.getExternalStorageState());
    }

    public static final boolean p0(Bundle bundle, String str, Object obj) {
        kotlin.jvm.internal.m.f(bundle, "bundle");
        if (obj == null) {
            bundle.remove(str);
            return true;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        }
        if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return true;
        }
        if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return true;
        }
        if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return true;
        }
        if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        }
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        }
        if (obj instanceof JSONArray) {
            bundle.putString(str, ((JSONArray) obj).toString());
            return true;
        }
        if (!(obj instanceof JSONObject)) {
            return false;
        }
        bundle.putString(str, ((JSONObject) obj).toString());
        return true;
    }

    public static final String q(int i2) {
        String bigInteger = new BigInteger(i2 * 5, new Random()).toString(32);
        kotlin.jvm.internal.m.e(bigInteger, "BigInteger(length * 5, r).toString(32)");
        return bigInteger;
    }

    public static final void q0(Bundle bundle, String str, String str2) {
        kotlin.jvm.internal.m.f(bundle, "b");
        if (a0(str2)) {
            return;
        }
        bundle.putString(str, str2);
    }

    public static final String r(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        kotlin.jvm.internal.m.e(simpleName, "{\n      context.javaClass.simpleName\n    }");
        return simpleName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        r1.put(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if (r2 < r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r0 > 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        r2 = r2 + 1;
        r3 = r5.readString();
        r4 = r5.readString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        if (r3 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r4 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Map<String, String> r0(Parcel parcel) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int i2 = 0;
    }

    public static final String s(Context context) {
        String string;
        kotlin.jvm.internal.m.f(context, "context");
        try {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            String e2 = com.facebook.a0.e();
            if (e2 != null) {
                return e2;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.labelRes;
            if (i2 == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i2);
                kotlin.jvm.internal.m.e(string, "context.getString(stringId)");
            }
            return string;
        } catch (Exception unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static final String s0(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[RecyclerView.l.FLAG_MOVED];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            sb.append(cArr, 0, read);
                        } else {
                            String sb2 = sb.toString();
                            kotlin.jvm.internal.m.e(sb2, "{\n      bufferedInputStream = BufferedInputStream(inputStream)\n      reader = InputStreamReader(bufferedInputStream)\n      val stringBuilder = StringBuilder()\n      val bufferSize = 1024 * 2\n      val buffer = CharArray(bufferSize)\n      var n = 0\n      while (reader.read(buffer).also { n = it } != -1) {\n        stringBuilder.append(buffer, 0, n)\n      }\n      stringBuilder.toString()\n    }");
                            h(bufferedInputStream);
                            h(inputStreamReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    h(bufferedInputStream);
                    h(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
        }
    }

    public static final String t() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        Context c2 = com.facebook.a0.c();
        if (c2 == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = c2.getPackageManager().getPackageInfo(c2.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r0 > 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        r2 = r2 + 1;
        r1.put(r5.readString(), r5.readString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r2 < r0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Map<String, String> t0(Parcel parcel) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int i2 = 0;
    }

    private final void u0() {
        try {
            if (p()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f9820e = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            f9820e = j(f9820e);
        } catch (Exception unused) {
        }
    }

    public static final Date v(Bundle bundle, String str, Date date) {
        long parseLong;
        kotlin.jvm.internal.m.f(date, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            parseLong = ((Number) obj).longValue();
        } else {
            if (obj instanceof String) {
                try {
                    parseLong = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        if (parseLong == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(date.getTime() + (parseLong * 1000));
    }

    private final int v0() {
        int i2 = f9817b;
        if (i2 > 0) {
            return i2;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: com.facebook.internal.l
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    boolean w0;
                    w0 = p0.w0(file, str);
                    return w0;
                }
            });
            if (listFiles != null) {
                f9817b = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (f9817b <= 0) {
            f9817b = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return f9817b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w0(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }

    public static final long x(Uri uri) {
        kotlin.jvm.internal.m.f(uri, "contentUri");
        Cursor cursor = null;
        try {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            cursor = com.facebook.a0.c().getContentResolver().query(uri, null, null, null, null);
            if (cursor == null) {
                return 0L;
            }
            int columnIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            long j2 = cursor.getLong(columnIndex);
            cursor.close();
            return j2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final void x0(Context context) {
        if (kotlin.jvm.internal.m.a(f9823h, "NoCarrier")) {
            try {
                Object systemService = context.getSystemService("phone");
                if (systemService != null) {
                    String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                    kotlin.jvm.internal.m.e(networkOperatorName, "telephonyManager.networkOperatorName");
                    f9823h = networkOperatorName;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            } catch (Exception unused) {
            }
        }
    }

    public static final Locale y() {
        Locale L = L();
        if (L != null) {
            return L;
        }
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.m.e(locale, "getDefault()");
        return locale;
    }

    private final void y0(Context context) {
        if (f9818c == -1 || System.currentTimeMillis() - f9818c >= cm.aptoide.pt.BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS) {
            f9818c = System.currentTimeMillis();
            z0();
            x0(context);
            A0();
            u0();
        }
    }

    private final String z() {
        AccessToken e2 = AccessToken.f9559f.e();
        return (e2 == null || e2.h() == null) ? "facebook" : e2.h();
    }

    private final void z0() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            kotlin.jvm.internal.m.e(displayName, "tz.getDisplayName(tz.inDaylightTime(Date()), TimeZone.SHORT)");
            f9821f = displayName;
            String id = timeZone.getID();
            kotlin.jvm.internal.m.e(id, "tz.id");
            f9822g = id;
        } catch (AssertionError | Exception unused) {
        }
    }

    public final String B() {
        return f9822g;
    }

    public final Locale G() {
        return f9825j;
    }

    public final String N() {
        return f9824i;
    }

    public final long u() {
        return f9820e;
    }

    public final String w() {
        return f9823h;
    }
}
