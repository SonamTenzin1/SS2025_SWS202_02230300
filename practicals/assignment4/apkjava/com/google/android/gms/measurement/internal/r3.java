package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import cm.aptoide.pt.BuildConfig;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class r3 extends q4 {

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    static final Pair<String, Long> f17919c = new Pair<>(HttpUrl.FRAGMENT_ENCODE_SET, 0L);
    public zzfi A;
    public zzfh B;
    public final zzfj C;

    /* renamed from: d, reason: collision with root package name */
    private SharedPreferences f17920d;

    /* renamed from: e, reason: collision with root package name */
    public zzfk f17921e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfh f17922f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfh f17923g;

    /* renamed from: h, reason: collision with root package name */
    public final zzfh f17924h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfh f17925i;

    /* renamed from: j, reason: collision with root package name */
    public final zzfh f17926j;

    /* renamed from: k, reason: collision with root package name */
    public final zzfh f17927k;
    public final zzfh l;
    public final zzfj m;
    private String n;
    private boolean o;
    private long p;
    public final zzfh q;
    public final zzfh r;
    public final zzfi s;
    public final zzfj t;
    public final zzfi u;
    public final zzfi v;
    public final zzfh w;
    public final zzfh x;
    public boolean y;
    public zzfi z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r3(zzfx zzfxVar) {
        super(zzfxVar);
        this.f17922f = new zzfh(this, "last_upload", 0L);
        this.f17923g = new zzfh(this, "last_upload_attempt", 0L);
        this.f17924h = new zzfh(this, "backoff", 0L);
        this.f17925i = new zzfh(this, "last_delete_stale", 0L);
        this.q = new zzfh(this, "time_before_start", 10000L);
        this.r = new zzfh(this, "session_timeout", BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS);
        this.s = new zzfi(this, "start_new_session", true);
        this.w = new zzfh(this, "last_pause_time", 0L);
        this.x = new zzfh(this, "time_active", 0L);
        this.t = new zzfj(this, "non_personalized_ads", null);
        this.u = new zzfi(this, "use_dynamite_api", false);
        this.v = new zzfi(this, "allow_remote_dynamite", false);
        this.f17926j = new zzfh(this, "midnight_offset", 0L);
        this.f17927k = new zzfh(this, "first_open_time", 0L);
        this.l = new zzfh(this, "app_install_time", 0L);
        this.m = new zzfj(this, "app_instance_id", null);
        this.z = new zzfi(this, "app_backgrounded", false);
        this.A = new zzfi(this, "deep_link_retrieval_complete", false);
        this.B = new zzfh(this, "deep_link_retrieval_attempts", 0L);
        this.C = new zzfj(this, "firebase_feature_rollouts", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences N() {
        d();
        p();
        return this.f17920d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void A(String str) {
        d();
        SharedPreferences.Editor edit = N().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean B(boolean z) {
        d();
        return N().getBoolean("measurement_enabled", z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C(String str) {
        d();
        SharedPreferences.Editor edit = N().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void D(boolean z) {
        d();
        h().P().b("Updating deferred analytics collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = N().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String E() {
        d();
        return N().getString("gmp_app_id", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String F() {
        d();
        return N().getString("admob_app_id", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean H() {
        d();
        if (N().contains("use_service")) {
            return Boolean.valueOf(N().getBoolean("use_service", false));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void I() {
        d();
        h().P().a("Clearing collection preferences.");
        if (n().r(zzap.m0)) {
            Boolean J = J();
            SharedPreferences.Editor edit = N().edit();
            edit.clear();
            edit.apply();
            if (J != null) {
                z(J.booleanValue());
                return;
            }
            return;
        }
        boolean contains = N().contains("measurement_enabled");
        boolean B = contains ? B(true) : true;
        SharedPreferences.Editor edit2 = N().edit();
        edit2.clear();
        edit2.apply();
        if (contains) {
            z(B);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean J() {
        d();
        if (N().contains("measurement_enabled")) {
            return Boolean.valueOf(N().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String K() {
        d();
        String string = N().getString("previous_os_version", null);
        e().p();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = N().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean L() {
        d();
        return N().getBoolean("deferred_analytics_collection", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean M() {
        return this.f17920d.contains("deferred_analytics_collection");
    }

    @Override // com.google.android.gms.measurement.internal.q4
    protected final void o() {
        SharedPreferences sharedPreferences = f().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f17920d = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.y = z;
        if (!z) {
            SharedPreferences.Editor edit = this.f17920d.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f17921e = new zzfk(this, "health_monitor", Math.max(0L, zzap.f18079j.a(null).longValue()));
    }

    @Override // com.google.android.gms.measurement.internal.q4
    protected final boolean s() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair<String, Boolean> v(String str) {
        d();
        long b2 = j().b();
        if (this.n != null && b2 < this.p) {
            return new Pair<>(this.n, Boolean.valueOf(this.o));
        }
        this.p = b2 + n().p(str, zzap.f18078i);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(f());
            if (advertisingIdInfo != null) {
                this.n = advertisingIdInfo.getId();
                this.o = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.n == null) {
                this.n = HttpUrl.FRAGMENT_ENCODE_SET;
            }
        } catch (Exception e2) {
            h().O().b("Unable to get advertising id", e2);
            this.n = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.n, Boolean.valueOf(this.o));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w(boolean z) {
        d();
        h().P().b("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = N().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean x(long j2) {
        return j2 - this.r.a() > this.w.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String y(String str) {
        d();
        String str2 = (String) v(str).first;
        MessageDigest A0 = zzkk.A0();
        if (A0 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, A0.digest(str2.getBytes())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z(boolean z) {
        d();
        h().P().b("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = N().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }
}
