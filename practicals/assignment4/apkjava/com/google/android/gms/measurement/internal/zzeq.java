package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.measurement.zzky;
import com.google.android.gms.internal.measurement.zzmo;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzeq extends u2 {

    /* renamed from: c, reason: collision with root package name */
    private String f18093c;

    /* renamed from: d, reason: collision with root package name */
    private String f18094d;

    /* renamed from: e, reason: collision with root package name */
    private int f18095e;

    /* renamed from: f, reason: collision with root package name */
    private String f18096f;

    /* renamed from: g, reason: collision with root package name */
    private String f18097g;

    /* renamed from: h, reason: collision with root package name */
    private long f18098h;

    /* renamed from: i, reason: collision with root package name */
    private long f18099i;

    /* renamed from: j, reason: collision with root package name */
    private long f18100j;

    /* renamed from: k, reason: collision with root package name */
    private List<String> f18101k;
    private int l;
    private String m;
    private String n;
    private String o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeq(zzfx zzfxVar, long j2) {
        super(zzfxVar);
        this.f18100j = j2;
    }

    @VisibleForTesting
    private final String J() {
        if (zzmo.b() && n().r(zzap.Q0)) {
            h().P().a("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> loadClass = f().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, f());
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    h().M().a("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                h().L().a("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    @Override // com.google.android.gms.measurement.internal.u2
    protected final boolean A() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzm B(String str) {
        String str2;
        Boolean u;
        d();
        b();
        String C = C();
        String D = D();
        x();
        String str3 = this.f18094d;
        long F = F();
        x();
        String str4 = this.f18096f;
        long C2 = n().C();
        x();
        d();
        if (this.f18098h == 0) {
            this.f18098h = this.a.I().w(f(), f().getPackageName());
        }
        long j2 = this.f18098h;
        boolean p = this.a.p();
        boolean z = !m().y;
        d();
        b();
        String J = !this.a.p() ? null : J();
        x();
        long j3 = this.f18099i;
        long q = this.a.q();
        int H = H();
        boolean booleanValue = n().L().booleanValue();
        zzx n = n();
        n.b();
        Boolean u2 = n.u("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(u2 == null || u2.booleanValue()).booleanValue();
        boolean L = m().L();
        String E = E();
        Boolean valueOf = (!n().B(C(), zzap.k0) || (u = n().u("google_analytics_default_allow_ad_personalization_signals")) == null) ? null : Boolean.valueOf(!u.booleanValue());
        long j4 = this.f18100j;
        List<String> list = n().B(C(), zzap.v0) ? this.f18101k : null;
        if (zzky.b() && n().B(C(), zzap.N0)) {
            x();
            str2 = this.o;
        } else {
            str2 = null;
        }
        return new zzm(C, D, str3, F, str4, C2, j2, str, p, z, J, j3, q, H, booleanValue, booleanValue2, L, E, valueOf, j4, list, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String C() {
        x();
        return this.f18093c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String D() {
        x();
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String E() {
        x();
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int F() {
        x();
        return this.f18095e;
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int H() {
        x();
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> I() {
        return this.f18101k;
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzb o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzhc p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzeq q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzik r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzif s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzep t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzjl u() {
        return super.u();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:1|(1:3)(6:100|101|(1:103)(2:118|(1:120))|104|105|(27:107|(1:109)(1:116)|111|112|5|(1:99)(1:9)|10|(1:98)(1:14)|15|(1:(1:18)(1:19))|(2:21|(2:23|(1:25))(1:(1:(14:36|37|(1:41)|42|43|(1:45)(1:94)|46|47|(2:91|(1:93))(4:51|(1:53)(1:90)|54|(1:89))|(1:59)|61|(3:63|(3:65|(1:67)(3:69|(3:72|(1:74)(1:75)|70)|76)|68)(0)|(1:78))|79|(1:(2:82|83)(2:85|86))(2:87|88))(1:35))(2:29|(1:31))))|97|37|(2:39|41)|42|43|(0)(0)|46|47|(1:49)|91|(0)|(0)|61|(0)|79|(0)(0)))|4|5|(1:7)|99|10|(1:12)|98|15|(0)|(0)|97|37|(0)|42|43|(0)(0)|46|47|(0)|91|(0)|(0)|61|(0)|79|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x020d, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x020e, code lost:
    
        h().H().c("getGoogleAppId or isMeasurementEnabled failed with exception. appId", com.google.android.gms.measurement.internal.zzet.x(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ac A[Catch: IllegalStateException -> 0x020d, TRY_ENTER, TryCatch #3 {IllegalStateException -> 0x020d, blocks: (B:43:0x0195, B:46:0x01a2, B:49:0x01ac, B:51:0x01b8, B:54:0x01cf, B:56:0x01d7, B:59:0x01fb, B:89:0x01dd, B:91:0x01e4, B:93:0x01ea), top: B:42:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01fb A[Catch: IllegalStateException -> 0x020d, TRY_LEAVE, TryCatch #3 {IllegalStateException -> 0x020d, blocks: (B:43:0x0195, B:46:0x01a2, B:49:0x01ac, B:51:0x01b8, B:54:0x01cf, B:56:0x01d7, B:59:0x01fb, B:89:0x01dd, B:91:0x01e4, B:93:0x01ea), top: B:42:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ea A[Catch: IllegalStateException -> 0x020d, TryCatch #3 {IllegalStateException -> 0x020d, blocks: (B:43:0x0195, B:46:0x01a2, B:49:0x01ac, B:51:0x01b8, B:54:0x01cf, B:56:0x01d7, B:59:0x01fb, B:89:0x01dd, B:91:0x01e4, B:93:0x01ea), top: B:42:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a1  */
    @Override // com.google.android.gms.measurement.internal.u2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void v() {
        String str;
        String str2;
        PackageInfo packageInfo;
        boolean z;
        boolean z2;
        String b2;
        String packageName = f().getPackageName();
        PackageManager packageManager = f().getPackageManager();
        String str3 = "Unknown";
        String str4 = HttpUrl.FRAGMENT_ENCODE_SET;
        String str5 = "unknown";
        int i2 = Integer.MIN_VALUE;
        if (packageManager == null) {
            h().H().b("PackageManager is null, app identity information might be inaccurate. appId", zzet.x(packageName));
        } else {
            try {
                str5 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                h().H().b("Error retrieving app installer package name. appId", zzet.x(packageName));
            }
            if (str5 == null) {
                str5 = "manual_install";
            } else if ("com.android.vending".equals(str5)) {
                str5 = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            try {
                packageInfo = packageManager.getPackageInfo(f().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused2) {
                str = "Unknown";
            }
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                str2 = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                try {
                    str3 = packageInfo.versionName;
                    i2 = packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = str3;
                    str3 = str2;
                    h().H().c("Error retrieving package info. appId, appName", zzet.x(packageName), str3);
                    str2 = str3;
                    str3 = str;
                    this.f18093c = packageName;
                    this.f18096f = str5;
                    this.f18094d = str3;
                    this.f18095e = i2;
                    this.f18097g = str2;
                    this.f18098h = 0L;
                    G();
                    Status c2 = GoogleServices.c(f());
                    boolean z3 = true;
                    z = (c2 == null && c2.e0()) | (TextUtils.isEmpty(this.a.M()) && "am".equals(this.a.N()));
                    if (!z) {
                    }
                    if (z) {
                    }
                    z2 = false;
                    this.m = HttpUrl.FRAGMENT_ENCODE_SET;
                    this.n = HttpUrl.FRAGMENT_ENCODE_SET;
                    this.o = HttpUrl.FRAGMENT_ENCODE_SET;
                    this.f18099i = 0L;
                    G();
                    if (!TextUtils.isEmpty(this.a.M())) {
                    }
                    b2 = GoogleServices.b();
                    this.m = !TextUtils.isEmpty(b2) ? HttpUrl.FRAGMENT_ENCODE_SET : b2;
                    if (!zzky.b()) {
                    }
                    if (!TextUtils.isEmpty(b2)) {
                    }
                    if (z2) {
                    }
                    this.f18101k = null;
                    if (n().B(this.f18093c, zzap.v0)) {
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                    }
                }
                this.f18093c = packageName;
                this.f18096f = str5;
                this.f18094d = str3;
                this.f18095e = i2;
                this.f18097g = str2;
                this.f18098h = 0L;
                G();
                Status c22 = GoogleServices.c(f());
                boolean z32 = true;
                z = (c22 == null && c22.e0()) | (TextUtils.isEmpty(this.a.M()) && "am".equals(this.a.N()));
                if (!z) {
                    if (c22 == null) {
                        h().H().a("GoogleService failed to initialize (no status)");
                    } else {
                        h().H().c("GoogleService failed to initialize, status", Integer.valueOf(c22.z()), c22.W());
                    }
                }
                if (z) {
                    Boolean J = n().J();
                    if (n().I()) {
                        if (this.a.L()) {
                            h().N().a("Collection disabled with firebase_analytics_collection_deactivated=1");
                        }
                    } else if (J != null && !J.booleanValue()) {
                        if (this.a.L()) {
                            h().N().a("Collection disabled with firebase_analytics_collection_enabled=0");
                        }
                    } else if (J == null && GoogleServices.d()) {
                        h().N().a("Collection disabled with google_app_measurement_enable=0");
                    } else {
                        h().P().a("Collection enabled");
                        z2 = true;
                        this.m = HttpUrl.FRAGMENT_ENCODE_SET;
                        this.n = HttpUrl.FRAGMENT_ENCODE_SET;
                        this.o = HttpUrl.FRAGMENT_ENCODE_SET;
                        this.f18099i = 0L;
                        G();
                        if (!TextUtils.isEmpty(this.a.M()) && "am".equals(this.a.N())) {
                            this.n = this.a.M();
                        }
                        b2 = GoogleServices.b();
                        this.m = !TextUtils.isEmpty(b2) ? HttpUrl.FRAGMENT_ENCODE_SET : b2;
                        if (!zzky.b() && n().B(packageName, zzap.N0)) {
                            StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(f());
                            String a = stringResourceValueReader.a("ga_app_id");
                            if (!TextUtils.isEmpty(a)) {
                                str4 = a;
                            }
                            this.o = str4;
                            if (!TextUtils.isEmpty(b2) || !TextUtils.isEmpty(a)) {
                                this.n = stringResourceValueReader.a("admob_app_id");
                            }
                        } else if (!TextUtils.isEmpty(b2)) {
                            this.n = new StringResourceValueReader(f()).a("admob_app_id");
                        }
                        if (z2) {
                            h().P().c("App package, google app id", this.f18093c, this.m);
                        }
                        this.f18101k = null;
                        if (n().B(this.f18093c, zzap.v0)) {
                            G();
                            List<String> w = n().w("analytics.safelisted_events");
                            if (w != null) {
                                if (w.size() == 0) {
                                    h().K().a("Safelisted event list cannot be empty. Ignoring");
                                } else {
                                    Iterator<String> it = w.iterator();
                                    while (it.hasNext()) {
                                        if (!l().n0("safelisted event", it.next())) {
                                        }
                                    }
                                }
                                z32 = false;
                                break;
                            }
                            if (z32) {
                                this.f18101k = w;
                            }
                        }
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.l = 0;
                            return;
                        } else if (packageManager != null) {
                            this.l = InstantApps.a(f()) ? 1 : 0;
                            return;
                        } else {
                            this.l = 0;
                            return;
                        }
                    }
                }
                z2 = false;
                this.m = HttpUrl.FRAGMENT_ENCODE_SET;
                this.n = HttpUrl.FRAGMENT_ENCODE_SET;
                this.o = HttpUrl.FRAGMENT_ENCODE_SET;
                this.f18099i = 0L;
                G();
                if (!TextUtils.isEmpty(this.a.M())) {
                    this.n = this.a.M();
                }
                b2 = GoogleServices.b();
                this.m = !TextUtils.isEmpty(b2) ? HttpUrl.FRAGMENT_ENCODE_SET : b2;
                if (!zzky.b()) {
                }
                if (!TextUtils.isEmpty(b2)) {
                }
                if (z2) {
                }
                this.f18101k = null;
                if (n().B(this.f18093c, zzap.v0)) {
                }
                if (Build.VERSION.SDK_INT >= 16) {
                }
            }
        }
        str2 = "Unknown";
        this.f18093c = packageName;
        this.f18096f = str5;
        this.f18094d = str3;
        this.f18095e = i2;
        this.f18097g = str2;
        this.f18098h = 0L;
        G();
        Status c222 = GoogleServices.c(f());
        boolean z322 = true;
        z = (c222 == null && c222.e0()) | (TextUtils.isEmpty(this.a.M()) && "am".equals(this.a.N()));
        if (!z) {
        }
        if (z) {
        }
        z2 = false;
        this.m = HttpUrl.FRAGMENT_ENCODE_SET;
        this.n = HttpUrl.FRAGMENT_ENCODE_SET;
        this.o = HttpUrl.FRAGMENT_ENCODE_SET;
        this.f18099i = 0L;
        G();
        if (!TextUtils.isEmpty(this.a.M())) {
        }
        b2 = GoogleServices.b();
        this.m = !TextUtils.isEmpty(b2) ? HttpUrl.FRAGMENT_ENCODE_SET : b2;
        if (!zzky.b()) {
        }
        if (!TextUtils.isEmpty(b2)) {
        }
        if (z2) {
        }
        this.f18101k = null;
        if (n().B(this.f18093c, zzap.v0)) {
        }
        if (Build.VERSION.SDK_INT >= 16) {
        }
    }
}
