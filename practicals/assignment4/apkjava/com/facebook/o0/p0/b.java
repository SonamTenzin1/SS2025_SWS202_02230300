package com.facebook.o0.p0;

import android.os.Build;
import android.os.Bundle;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.facebook.a0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import com.facebook.internal.p0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.m;
import kotlin.text.Regex;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MACARuleMatchingManager.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f10390b;

    /* renamed from: c, reason: collision with root package name */
    private static JSONArray f10391c;
    public static final b a = new b();

    /* renamed from: d, reason: collision with root package name */
    private static String[] f10392d = {"event", "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private b() {
    }

    public static final void a() {
        a.g();
        if (f10391c != null) {
            f10390b = true;
        }
    }

    public static final void b(Bundle bundle, String str) {
        String language;
        String country;
        m.f(bundle, "params");
        m.f(str, "event");
        bundle.putString("event", str);
        StringBuilder sb = new StringBuilder();
        p0 p0Var = p0.a;
        Locale G = p0Var.G();
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (G == null || (language = G.getLanguage()) == null) {
            language = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(language);
        sb.append('_');
        Locale G2 = p0Var.G();
        if (G2 == null || (country = G2.getCountry()) == null) {
            country = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(country);
        bundle.putString("_locale", sb.toString());
        String N = p0Var.N();
        if (N == null) {
            N = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        bundle.putString("_appVersion", N);
        bundle.putString("_deviceOS", "ANDROID");
        bundle.putString("_platform", "mobile");
        String str3 = Build.MODEL;
        if (str3 == null) {
            str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        bundle.putString("_deviceModel", str3);
        a0 a0Var = a0.a;
        bundle.putString("_nativeAppID", a0.d());
        String N2 = p0Var.N();
        if (N2 != null) {
            str2 = N2;
        }
        bundle.putString("_nativeAppShortVersion", str2);
        bundle.putString("_timezone", p0Var.B());
        bundle.putString("_carrier", p0Var.w());
        bundle.putString("_deviceOSTypeName", "ANDROID");
        bundle.putString("_deviceOSVersion", Build.VERSION.RELEASE);
        bundle.putLong("_remainingDiskGB", p0Var.u());
    }

    public static final String c(JSONObject jSONObject) {
        m.f(jSONObject, "logic");
        Iterator<String> keys = jSONObject.keys();
        if (keys.hasNext()) {
            return keys.next();
        }
        return null;
    }

    public static final String d(Bundle bundle) {
        String optString;
        JSONArray jSONArray = f10391c;
        if (jSONArray == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        Integer valueOf = jSONArray == null ? null : Integer.valueOf(jSONArray.length());
        if (valueOf != null && valueOf.intValue() == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        JSONArray jSONArray2 = f10391c;
        if (jSONArray2 != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int length = jSONArray2.length();
            if (length > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    String optString2 = jSONArray2.optString(i2);
                    if (optString2 != null) {
                        JSONObject jSONObject = new JSONObject(optString2);
                        long optLong = jSONObject.optLong(DeepLinkIntentReceiver.DeepLinksKeys.ID);
                        if (optLong != 0 && (optString = jSONObject.optString("rule")) != null && f(optString, bundle)) {
                            arrayList.add(Long.valueOf(optLong));
                        }
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            String jSONArray3 = new JSONArray((Collection) arrayList).toString();
            m.e(jSONArray3, "JSONArray(res).toString()");
            return jSONArray3;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
    }

    public static final ArrayList<String> e(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int i2 = 0;
        int length = jSONArray.length();
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                arrayList.add(jSONArray.get(i2).toString());
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return arrayList;
    }

    public static final boolean f(String str, Bundle bundle) {
        JSONObject jSONObject;
        String c2;
        int length;
        if (str == null || bundle == null || (c2 = c((jSONObject = new JSONObject(str)))) == null) {
            return false;
        }
        Object obj = jSONObject.get(c2);
        int hashCode = c2.hashCode();
        if (hashCode != 3555) {
            if (hashCode != 96727) {
                if (hashCode == 109267 && c2.equals("not")) {
                    return !f(obj.toString(), bundle);
                }
            } else if (c2.equals("and")) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray == null) {
                    return false;
                }
                int length2 = jSONArray.length();
                if (length2 > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        if (!f(jSONArray.get(i2).toString(), bundle)) {
                            return false;
                        }
                        if (i3 >= length2) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                return true;
            }
        } else if (c2.equals("or")) {
            JSONArray jSONArray2 = (JSONArray) obj;
            if (jSONArray2 != null && (length = jSONArray2.length()) > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (f(jSONArray2.get(i4).toString(), bundle)) {
                        return true;
                    }
                    if (i5 >= length) {
                        break;
                    }
                    i4 = i5;
                }
            }
            return false;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        if (jSONObject2 == null) {
            return false;
        }
        return j(c2, jSONObject2, bundle);
    }

    private final void g() {
        d0 d0Var = d0.a;
        a0 a0Var = a0.a;
        c0 o = d0.o(a0.d(), false);
        if (o == null) {
            return;
        }
        f10391c = o.f();
    }

    public static final void h(Bundle bundle, String str) {
        m.f(str, "event");
        if (f10390b && bundle != null) {
            try {
                b(bundle, str);
                bundle.putString("_audiencePropertyIds", d(bundle));
                bundle.putString("cs_maca", "1");
                i(bundle);
            } catch (Exception unused) {
            }
        }
    }

    public static final void i(Bundle bundle) {
        m.f(bundle, "params");
        String[] strArr = f10392d;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            bundle.remove(str);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x006c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x037f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x036a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x023a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0249 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean j(String str, JSONObject jSONObject, Bundle bundle) {
        Object obj;
        boolean J;
        boolean E;
        boolean J2;
        boolean J3;
        boolean J4;
        boolean E2;
        m.f(str, "variable");
        m.f(jSONObject, "values");
        String c2 = c(jSONObject);
        if (c2 == null) {
            return false;
        }
        String obj2 = jSONObject.get(c2).toString();
        ArrayList<String> e2 = e(jSONObject.optJSONArray(c2));
        if (m.a(c2, "exists")) {
            return m.a(bundle != null ? Boolean.valueOf(bundle.containsKey(str)) : null, Boolean.valueOf(Boolean.parseBoolean(obj2)));
        }
        if (bundle == null) {
            obj = null;
        } else {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            m.e(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            obj = bundle.get(lowerCase);
        }
        if (obj == null) {
            obj = bundle == null ? null : bundle.get(str);
            if (obj == null) {
                return false;
            }
        }
        switch (c2.hashCode()) {
            case -1729128927:
                if (!c2.equals("i_not_contains")) {
                    return false;
                }
                String obj3 = obj.toString();
                if (obj3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Locale locale = Locale.ROOT;
                String lowerCase2 = obj3.toLowerCase(locale);
                m.e(lowerCase2, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase3 = obj2.toLowerCase(locale);
                m.e(lowerCase3, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                J = v.J(lowerCase2, lowerCase3, false, 2, null);
                return !J;
            case -1179774633:
                if (!c2.equals("is_any")) {
                    return false;
                }
                if (e2 != null) {
                    return false;
                }
                return e2.contains(obj.toString());
            case -1039699439:
                if (!c2.equals("not_in")) {
                    return false;
                }
                if (e2 != null) {
                    return false;
                }
                return e2.contains(obj.toString());
            case -969266188:
                if (!c2.equals("starts_with")) {
                    return false;
                }
                E = u.E(obj.toString(), obj2, false, 2, null);
                return E;
            case -966353971:
                if (c2.equals("regex_match")) {
                    return new Regex(obj2).b(obj.toString());
                }
                return false;
            case -665609109:
                if (!c2.equals("is_not_any")) {
                    return false;
                }
                if (e2 != null) {
                }
                break;
            case -567445985:
                if (!c2.equals("contains")) {
                    return false;
                }
                J2 = v.J(obj.toString(), obj2, false, 2, null);
                return J2;
            case -327990090:
                if (!c2.equals("i_str_neq")) {
                    return false;
                }
                String obj4 = obj.toString();
                if (obj4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Locale locale2 = Locale.ROOT;
                String lowerCase4 = obj4.toLowerCase(locale2);
                m.e(lowerCase4, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase5 = obj2.toLowerCase(locale2);
                m.e(lowerCase5, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (m.a(lowerCase4, lowerCase5)) {
                    return false;
                }
                break;
            case -159812115:
                if (!c2.equals("i_is_any")) {
                    return false;
                }
                if (e2 != null || e2.isEmpty()) {
                    return false;
                }
                for (String str2 : e2) {
                    if (str2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    Locale locale3 = Locale.ROOT;
                    String lowerCase6 = str2.toLowerCase(locale3);
                    m.e(lowerCase6, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    String obj5 = obj.toString();
                    if (obj5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase7 = obj5.toLowerCase(locale3);
                    m.e(lowerCase7, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (m.a(lowerCase6, lowerCase7)) {
                    }
                }
                return false;
            case -92753547:
                if (!c2.equals("i_str_not_in")) {
                    return false;
                }
                if (e2 != null) {
                    return false;
                }
                if (!e2.isEmpty()) {
                    for (String str3 : e2) {
                        if (str3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        Locale locale4 = Locale.ROOT;
                        m.e(str3.toLowerCase(locale4), "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                        String obj6 = obj.toString();
                        if (obj6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        m.e(obj6.toLowerCase(locale4), "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                        if (!(!m.a(r9, r10))) {
                            return false;
                        }
                    }
                }
            case 60:
                if (!c2.equals("<")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) < Double.parseDouble(obj2)) {
                    return false;
                }
                break;
            case 61:
                if (!c2.equals("=")) {
                    return false;
                }
                return m.a(obj.toString(), obj2);
            case 62:
                if (!c2.equals(">")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) > Double.parseDouble(obj2)) {
                    return false;
                }
                break;
            case 1084:
                if (!c2.equals("!=")) {
                    return false;
                }
                if (m.a(obj.toString(), obj2)) {
                    return false;
                }
                break;
            case 1921:
                if (!c2.equals("<=")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) > Double.parseDouble(obj2)) {
                    return false;
                }
                break;
            case 1952:
                if (!c2.equals("==")) {
                    return false;
                }
                return m.a(obj.toString(), obj2);
            case 1983:
                if (!c2.equals(">=")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) < Double.parseDouble(obj2)) {
                    return false;
                }
                break;
            case 3244:
                if (!c2.equals("eq")) {
                    return false;
                }
                return m.a(obj.toString(), obj2);
            case 3294:
                if (!c2.equals("ge")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) < Double.parseDouble(obj2)) {
                }
                break;
            case 3309:
                if (!c2.equals("gt")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) > Double.parseDouble(obj2)) {
                }
                break;
            case 3365:
                if (!c2.equals("in")) {
                    return false;
                }
                if (e2 != null) {
                }
                break;
            case 3449:
                if (!c2.equals("le")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) > Double.parseDouble(obj2)) {
                }
                break;
            case 3464:
                if (!c2.equals("lt")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) < Double.parseDouble(obj2)) {
                }
                break;
            case 3511:
                if (!c2.equals("ne")) {
                    return false;
                }
                if (m.a(obj.toString(), obj2)) {
                }
                break;
            case 102680:
                if (!c2.equals("gte")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) < Double.parseDouble(obj2)) {
                }
                break;
            case 107485:
                if (!c2.equals("lte")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) > Double.parseDouble(obj2)) {
                }
                break;
            case 108954:
                if (!c2.equals("neq")) {
                    return false;
                }
                if (m.a(obj.toString(), obj2)) {
                }
                break;
            case 127966736:
                if (!c2.equals("i_str_eq")) {
                    return false;
                }
                String obj7 = obj.toString();
                if (obj7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Locale locale5 = Locale.ROOT;
                String lowerCase8 = obj7.toLowerCase(locale5);
                m.e(lowerCase8, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase9 = obj2.toLowerCase(locale5);
                m.e(lowerCase9, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                return m.a(lowerCase8, lowerCase9);
            case 127966857:
                if (!c2.equals("i_str_in")) {
                    return false;
                }
                if (e2 != null) {
                    return false;
                }
                while (r8.hasNext()) {
                }
                return false;
            case 363990325:
                if (!c2.equals("i_contains")) {
                    return false;
                }
                String obj8 = obj.toString();
                if (obj8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Locale locale6 = Locale.ROOT;
                String lowerCase10 = obj8.toLowerCase(locale6);
                m.e(lowerCase10, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase11 = obj2.toLowerCase(locale6);
                m.e(lowerCase11, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                J3 = v.J(lowerCase10, lowerCase11, false, 2, null);
                return J3;
            case 1091487233:
                if (!c2.equals("i_is_not_any")) {
                    return false;
                }
                if (e2 != null) {
                }
                break;
            case 1918401035:
                if (!c2.equals("not_contains")) {
                    return false;
                }
                J4 = v.J(obj.toString(), obj2, false, 2, null);
                if (J4) {
                    return false;
                }
                break;
            case 1961112862:
                if (!c2.equals("i_starts_with")) {
                    return false;
                }
                String obj9 = obj.toString();
                if (obj9 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Locale locale7 = Locale.ROOT;
                String lowerCase12 = obj9.toLowerCase(locale7);
                m.e(lowerCase12, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase13 = obj2.toLowerCase(locale7);
                m.e(lowerCase13, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                E2 = u.E(lowerCase12, lowerCase13, false, 2, null);
                return E2;
            default:
                return false;
        }
    }
}
