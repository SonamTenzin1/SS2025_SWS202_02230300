package com.facebook.o0.q0;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.a0;
import com.facebook.internal.b0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import com.facebook.o0.g0;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AutomaticAnalyticsLogger.kt */
/* loaded from: classes2.dex */
public final class i {
    public static final i a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10419b = i.class.getCanonicalName();

    /* renamed from: c, reason: collision with root package name */
    private static final g0 f10420c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutomaticAnalyticsLogger.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private BigDecimal a;

        /* renamed from: b, reason: collision with root package name */
        private Currency f10421b;

        /* renamed from: c, reason: collision with root package name */
        private Bundle f10422c;

        public a(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
            kotlin.jvm.internal.m.f(bigDecimal, "purchaseAmount");
            kotlin.jvm.internal.m.f(currency, "currency");
            kotlin.jvm.internal.m.f(bundle, "param");
            this.a = bigDecimal;
            this.f10421b = currency;
            this.f10422c = bundle;
        }

        public final Currency a() {
            return this.f10421b;
        }

        public final Bundle b() {
            return this.f10422c;
        }

        public final BigDecimal c() {
            return this.a;
        }
    }

    static {
        a0 a0Var = a0.a;
        f10420c = new g0(a0.c());
    }

    private i() {
    }

    private final a a(String str, String str2) {
        return b(str, str2, new HashMap());
    }

    private final a b(String str, String str2, Map<String, String> map) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            boolean z = true;
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence("fb_iap_product_id", jSONObject.getString("productId"));
            bundle.putCharSequence("fb_iap_purchase_time", jSONObject.getString("purchaseTime"));
            bundle.putCharSequence("fb_iap_purchase_token", jSONObject.getString("purchaseToken"));
            bundle.putCharSequence("fb_iap_package_name", jSONObject.optString("packageName"));
            bundle.putCharSequence("fb_iap_product_title", jSONObject2.optString("title"));
            bundle.putCharSequence("fb_iap_product_description", jSONObject2.optString("description"));
            String optString = jSONObject2.optString("type");
            bundle.putCharSequence("fb_iap_product_type", optString);
            if (kotlin.jvm.internal.m.a(optString, "subs")) {
                bundle.putCharSequence("fb_iap_subs_auto_renewing", Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                bundle.putCharSequence("fb_iap_subs_period", jSONObject2.optString("subscriptionPeriod"));
                bundle.putCharSequence("fb_free_trial_period", jSONObject2.optString("freeTrialPeriod"));
                String optString2 = jSONObject2.optString("introductoryPriceCycles");
                kotlin.jvm.internal.m.e(optString2, "introductoryPriceCycles");
                if (optString2.length() != 0) {
                    z = false;
                }
                if (!z) {
                    bundle.putCharSequence("fb_intro_price_amount_micros", jSONObject2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence("fb_intro_price_cycles", optString2);
                }
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putCharSequence(entry.getKey(), entry.getValue());
            }
            double d2 = jSONObject2.getLong("price_amount_micros");
            Double.isNaN(d2);
            BigDecimal bigDecimal = new BigDecimal(d2 / 1000000.0d);
            Currency currency = Currency.getInstance(jSONObject2.getString("price_currency_code"));
            kotlin.jvm.internal.m.e(currency, "getInstance(skuDetailsJSON.getString(\"price_currency_code\"))");
            return new a(bigDecimal, currency, bundle);
        } catch (JSONException e2) {
            Log.e(f10419b, "Error parsing in-app subscription data.", e2);
            return null;
        }
    }

    public static final boolean c() {
        a0 a0Var = a0.a;
        String d2 = a0.d();
        d0 d0Var = d0.a;
        c0 c2 = d0.c(d2);
        return c2 != null && a0.g() && c2.e();
    }

    public static final void d() {
        a0 a0Var = a0.a;
        Context c2 = a0.c();
        String d2 = a0.d();
        if (a0.g()) {
            if (c2 instanceof Application) {
                com.facebook.o0.a0.a.b((Application) c2, d2);
            } else {
                Log.w(f10419b, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
            }
        }
    }

    public static final void e(String str, long j2) {
        a0 a0Var = a0.a;
        Context c2 = a0.c();
        String d2 = a0.d();
        d0 d0Var = d0.a;
        c0 o = d0.o(d2, false);
        if (o == null || !o.a() || j2 <= 0) {
            return;
        }
        g0 g0Var = new g0(c2);
        Bundle bundle = new Bundle(1);
        bundle.putCharSequence("fb_aa_time_spent_view_name", str);
        g0Var.c("fb_aa_time_spent_on_view", j2, bundle);
    }

    public static final void f(String str, String str2, boolean z) {
        a a2;
        kotlin.jvm.internal.m.f(str, "purchase");
        kotlin.jvm.internal.m.f(str2, "skuDetails");
        i iVar = a;
        if (c() && (a2 = iVar.a(str, str2)) != null) {
            boolean z2 = false;
            if (z) {
                b0 b0Var = b0.a;
                a0 a0Var = a0.a;
                if (b0.b("app_events_if_auto_log_subs", a0.d(), false)) {
                    z2 = true;
                }
            }
            if (z2) {
                f10420c.i(com.facebook.o0.o0.i.a.m(str2) ? "StartTrial" : "Subscribe", a2.c(), a2.a(), a2.b());
            } else {
                f10420c.j(a2.c(), a2.a(), a2.b());
            }
        }
    }
}
