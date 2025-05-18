package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cm.aptoide.pt.account.AdultContentAnalytics;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzmd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzhc extends u2 {

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    protected l5 f18176c;

    /* renamed from: d, reason: collision with root package name */
    private zzgx f18177d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<zzha> f18178e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f18179f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicReference<String> f18180g;

    /* renamed from: h, reason: collision with root package name */
    @VisibleForTesting
    protected boolean f18181h;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzhc(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18178e = new CopyOnWriteArraySet();
        this.f18181h = true;
        this.f18180g = new AtomicReference<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(Bundle bundle) {
        d();
        x();
        Preconditions.k(bundle);
        Preconditions.g(bundle.getString("name"));
        if (!this.a.p()) {
            h().O().a("Conditional property not cleared since collection is disabled");
            return;
        }
        try {
            r().Q(new zzv(bundle.getString(RateAndReviewsFragment.BundleCons.APP_ID), bundle.getString("origin"), new zzkj(bundle.getString("name"), 0L, null, null), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), l().C(bundle.getString(RateAndReviewsFragment.BundleCons.APP_ID), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), bundle.getLong("creation_timestamp"), true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(boolean z) {
        d();
        b();
        x();
        h().O().b("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        m().z(z);
        l0();
    }

    private final void R(String str, String str2, long j2, Object obj) {
        g().z(new x4(this, str, str2, obj, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        if (n().B(q().C(), zzap.l0)) {
            d();
            String a = m().t.a();
            if (a != null) {
                if ("unset".equals(a)) {
                    V("app", "_npa", null, j().a());
                } else {
                    V("app", "_npa", Long.valueOf("true".equals(a) ? 1L : 0L), j().a());
                }
            }
        }
        if (this.a.p() && this.f18181h) {
            h().O().a("Recording app launch after enabling measurement for the first time (FE)");
            h0();
        } else {
            h().O().a("Updating Scion state (FE)");
            r().W();
        }
    }

    @VisibleForTesting
    private final ArrayList<Bundle> m0(String str, String str2, String str3) {
        if (g().I()) {
            h().H().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzw.a()) {
            h().H().a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.a.g().z(new b5(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e2) {
                h().K().c("Interrupted waiting for get conditional user properties", str, e2);
            }
        }
        List list = (List) atomicReference.get();
        if (list == null) {
            h().K().b("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
        return zzkk.l0(list);
    }

    @VisibleForTesting
    private final Map<String, Object> n0(String str, String str2, String str3, boolean z) {
        if (g().I()) {
            h().H().a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzw.a()) {
            h().H().a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.a.g().z(new d5(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e2) {
                h().K().b("Interrupted waiting for get user properties", e2);
            }
        }
        List<zzkj> list = (List) atomicReference.get();
        if (list == null) {
            h().K().a("Timed out waiting for handle get user properties");
            return Collections.emptyMap();
        }
        c.e.a aVar = new c.e.a(list.size());
        for (zzkj zzkjVar : list) {
            aVar.put(zzkjVar.f18224g, zzkjVar.y());
        }
        return aVar;
    }

    private final void q0(Bundle bundle, long j2) {
        Preconditions.k(bundle);
        zzgt.a(bundle, RateAndReviewsFragment.BundleCons.APP_ID, String.class, null);
        zzgt.a(bundle, "origin", String.class, null);
        zzgt.a(bundle, "name", String.class, null);
        zzgt.a(bundle, "value", Object.class, null);
        zzgt.a(bundle, "trigger_event_name", String.class, null);
        zzgt.a(bundle, "trigger_timeout", Long.class, 0L);
        zzgt.a(bundle, "timed_out_event_name", String.class, null);
        zzgt.a(bundle, "timed_out_event_params", Bundle.class, null);
        zzgt.a(bundle, "triggered_event_name", String.class, null);
        zzgt.a(bundle, "triggered_event_params", Bundle.class, null);
        zzgt.a(bundle, "time_to_live", Long.class, 0L);
        zzgt.a(bundle, "expired_event_name", String.class, null);
        zzgt.a(bundle, "expired_event_params", Bundle.class, null);
        Preconditions.g(bundle.getString("name"));
        Preconditions.g(bundle.getString("origin"));
        Preconditions.k(bundle.get("value"));
        bundle.putLong("creation_timestamp", j2);
        String string = bundle.getString("name");
        Object obj = bundle.get("value");
        if (l().o0(string) != 0) {
            h().H().b("Invalid conditional user property name", k().B(string));
            return;
        }
        if (l().j0(string, obj) != 0) {
            h().H().c("Invalid conditional user property value", k().B(string), obj);
            return;
        }
        Object p0 = l().p0(string, obj);
        if (p0 == null) {
            h().H().c("Unable to normalize conditional user property value", k().B(string), obj);
            return;
        }
        zzgt.b(bundle, p0);
        long j3 = bundle.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle.getString("trigger_event_name")) && (j3 > 15552000000L || j3 < 1)) {
            h().H().c("Invalid conditional user property timeout", k().B(string), Long.valueOf(j3));
            return;
        }
        long j4 = bundle.getLong("time_to_live");
        if (j4 <= 15552000000L && j4 >= 1) {
            g().z(new z4(this, bundle));
        } else {
            h().H().c("Invalid conditional user property time to live", k().B(string), Long.valueOf(j4));
        }
    }

    private final void t0(String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        g().z(new v4(this, str, str2, j2, zzkk.k0(bundle), z, z2, z3, str3));
    }

    private final void v0(String str, String str2, String str3, Bundle bundle) {
        long a = j().a();
        Preconditions.g(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString(RateAndReviewsFragment.BundleCons.APP_ID, str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong("creation_timestamp", a);
        if (str3 != null) {
            bundle2.putString("expired_event_name", str3);
            bundle2.putBundle("expired_event_params", bundle);
        }
        g().z(new c5(this, bundle2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(Bundle bundle) {
        d();
        x();
        Preconditions.k(bundle);
        Preconditions.g(bundle.getString("name"));
        Preconditions.g(bundle.getString("origin"));
        Preconditions.k(bundle.get("value"));
        if (!this.a.p()) {
            h().O().a("Conditional property not sent since collection is disabled");
            return;
        }
        zzkj zzkjVar = new zzkj(bundle.getString("name"), bundle.getLong("triggered_timestamp"), bundle.get("value"), bundle.getString("origin"));
        try {
            zzan C = l().C(bundle.getString(RateAndReviewsFragment.BundleCons.APP_ID), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), bundle.getString("origin"), 0L, true, false);
            r().Q(new zzv(bundle.getString(RateAndReviewsFragment.BundleCons.APP_ID), bundle.getString("origin"), zzkjVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), l().C(bundle.getString(RateAndReviewsFragment.BundleCons.APP_ID), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), bundle.getString("origin"), 0L, true, false), bundle.getLong("trigger_timeout"), C, bundle.getLong("time_to_live"), l().C(bundle.getString(RateAndReviewsFragment.BundleCons.APP_ID), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), 0L, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // com.google.android.gms.measurement.internal.u2
    protected final boolean A() {
        return false;
    }

    public final ArrayList<Bundle> B(String str, String str2) {
        b();
        return m0(null, str, str2);
    }

    public final ArrayList<Bundle> C(String str, String str2, String str3) {
        Preconditions.g(str);
        a();
        return m0(str, str2, str3);
    }

    public final Map<String, Object> D(String str, String str2, String str3, boolean z) {
        Preconditions.g(str);
        a();
        return n0(str, str2, str3, z);
    }

    public final Map<String, Object> E(String str, String str2, boolean z) {
        b();
        return n0(null, str, str2, z);
    }

    public final void F(long j2) {
        b();
        g().z(new j5(this, j2));
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    public final void H(Bundle bundle) {
        I(bundle, j().a());
    }

    public final void I(Bundle bundle, long j2) {
        Preconditions.k(bundle);
        b();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString(RateAndReviewsFragment.BundleCons.APP_ID))) {
            h().K().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(RateAndReviewsFragment.BundleCons.APP_ID);
        q0(bundle2, j2);
    }

    public final void J(zzgx zzgxVar) {
        zzgx zzgxVar2;
        d();
        b();
        x();
        if (zzgxVar != null && zzgxVar != (zzgxVar2 = this.f18177d)) {
            Preconditions.o(zzgxVar2 == null, "EventInterceptor already set.");
        }
        this.f18177d = zzgxVar;
    }

    public final void K(zzha zzhaVar) {
        b();
        x();
        Preconditions.k(zzhaVar);
        if (this.f18178e.add(zzhaVar)) {
            return;
        }
        h().K().a("OnEventListener already registered");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(String str) {
        this.f18180g.set(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void P(String str, String str2, long j2, Bundle bundle) {
        b();
        d();
        Q(str, str2, j2, bundle, true, this.f18177d == null || zzkk.u0(str2), false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q(String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        long j3;
        String str4;
        String str5;
        String str6;
        String str7;
        List<String> list;
        String[] strArr;
        int i2;
        int i3;
        ArrayList arrayList;
        String str8;
        String str9;
        zzig zzigVar;
        Bundle bundle2;
        boolean z4;
        int i4;
        Class<?> cls;
        List<String> I;
        Preconditions.g(str);
        Preconditions.k(bundle);
        d();
        x();
        if (!this.a.p()) {
            h().O().a("Event not sent since app measurement is disabled");
            return;
        }
        if (n().B(q().C(), zzap.v0) && (I = q().I()) != null && !I.contains(str2)) {
            h().O().c("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.f18179f) {
            this.f18179f = true;
            try {
                if (!this.a.P()) {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, f().getClassLoader());
                } else {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                }
                try {
                    cls.getDeclaredMethod("initialize", Context.class).invoke(null, f());
                } catch (Exception e2) {
                    h().K().b("Failed to invoke Tag Manager's initialize() method", e2);
                }
            } catch (ClassNotFoundException unused) {
                h().N().a("Tag Manager is not found and thus will not be used");
            }
        }
        if (n().B(q().C(), zzap.H0) && "_cmp".equals(str2) && bundle.containsKey("gclid")) {
            V("auto", "_lgclid", bundle.getString("gclid"), j().a());
        }
        if (z3) {
            G();
            if (!"_iap".equals(str2)) {
                zzkk I2 = this.a.I();
                if (I2.b0("event", str2)) {
                    if (!I2.e0("event", zzgw.a, str2)) {
                        i4 = 13;
                    } else if (I2.a0("event", 40, str2)) {
                        i4 = 0;
                    }
                    if (i4 != 0) {
                        h().J().b("Invalid public event name. Event will not be logged (FE)", k().y(str2));
                        this.a.I();
                        this.a.I().I(i4, "_ev", zzkk.F(str2, 40, true), str2 != null ? str2.length() : 0);
                        return;
                    }
                }
                i4 = 2;
                if (i4 != 0) {
                }
            }
        }
        G();
        zzig L = s().L();
        if (L != null && !bundle.containsKey("_sc")) {
            L.f18191d = true;
        }
        zzif.I(L, bundle, z && z3);
        boolean equals = "am".equals(str);
        boolean u0 = zzkk.u0(str2);
        if (z && this.f18177d != null && !u0 && !equals) {
            h().O().c("Passing event to registered event handler (FE)", k().y(str2), k().u(bundle));
            this.f18177d.a(str, str2, bundle, j2);
            return;
        }
        if (this.a.u()) {
            int i0 = l().i0(str2);
            if (i0 != 0) {
                h().J().b("Invalid event name. Event will not be logged (FE)", k().y(str2));
                l();
                this.a.I().T(str3, i0, "_ev", zzkk.F(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            List<String> c2 = CollectionUtils.c("_o", "_sn", "_sc", "_si");
            Bundle A = l().A(str3, str2, bundle, c2, z3, true);
            zzig zzigVar2 = (A != null && A.containsKey("_sc") && A.containsKey("_si")) ? new zzig(A.getString("_sn"), A.getString("_sc"), Long.valueOf(A.getLong("_si")).longValue()) : null;
            zzig zzigVar3 = zzigVar2 == null ? L : zzigVar2;
            String str10 = str3;
            String str11 = "_ae";
            if (n().T(str10)) {
                G();
                if (s().L() != null && "_ae".equals(str2)) {
                    long e3 = u().f18204e.e();
                    if (e3 > 0) {
                        l().J(A, e3);
                    }
                }
            }
            if (zzkb.b() && n().r(zzap.X0)) {
                if (!"auto".equals(str) && "_ssr".equals(str2)) {
                    zzkk l = l();
                    String string = A.getString("_ffr");
                    String trim = Strings.a(string) ? null : string.trim();
                    if (zzkk.t0(trim, l.m().C.a())) {
                        l.h().O().a("Not logging duplicate session_start_with_rollout event");
                        z4 = false;
                    } else {
                        l.m().C.b(trim);
                        z4 = true;
                    }
                    if (!z4) {
                        return;
                    }
                } else if ("_ae".equals(str2)) {
                    String a = l().m().C.a();
                    if (!TextUtils.isEmpty(a)) {
                        A.putString("_ffr", a);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(A);
            long nextLong = l().z0().nextLong();
            if (n().B(q().C(), zzap.c0) && m().w.a() > 0 && m().x(j2) && m().z.b()) {
                h().P().a("Current session is expired, remove the session number, ID, and engagement time");
                if (n().B(q().C(), zzap.Y)) {
                    j3 = nextLong;
                    str4 = "_o";
                    V("auto", "_sid", null, j().a());
                } else {
                    j3 = nextLong;
                    str4 = "_o";
                }
                if (n().B(q().C(), zzap.Z)) {
                    V("auto", "_sno", null, j().a());
                }
                if (zzmd.b() && n().B(q().C(), zzap.A0)) {
                    V("auto", "_se", null, j().a());
                }
            } else {
                j3 = nextLong;
                str4 = "_o";
            }
            if (n().S(q().C()) && A.getLong("extend_session", 0L) == 1) {
                h().P().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                str5 = str2;
                this.a.D().f18203d.b(j2, true);
            } else {
                str5 = str2;
            }
            String[] strArr2 = (String[]) A.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr2);
            int length = strArr2.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                String str12 = strArr2[i5];
                Object obj = A.get(str12);
                l();
                Bundle[] h0 = zzkk.h0(obj);
                if (h0 != null) {
                    strArr = strArr2;
                    A.putInt(str12, h0.length);
                    int i7 = 0;
                    while (i7 < h0.length) {
                        Bundle bundle3 = h0[i7];
                        zzif.I(zzigVar3, bundle3, true);
                        int i8 = i5;
                        ArrayList arrayList3 = arrayList2;
                        Bundle A2 = l().A(str3, "_ep", bundle3, c2, z3, false);
                        A2.putString("_en", str5);
                        A2.putLong("_eid", j3);
                        A2.putString("_gn", str12);
                        A2.putInt("_ll", h0.length);
                        A2.putInt("_i", i7);
                        arrayList3.add(A2);
                        i7++;
                        A = A;
                        str10 = str10;
                        arrayList2 = arrayList3;
                        length = length;
                        zzigVar3 = zzigVar3;
                        i5 = i8;
                        c2 = c2;
                        str11 = str11;
                    }
                    list = c2;
                    i2 = i5;
                    i3 = length;
                    arrayList = arrayList2;
                    str8 = str11;
                    str9 = str10;
                    zzigVar = zzigVar3;
                    bundle2 = A;
                    i6 += h0.length;
                } else {
                    list = c2;
                    strArr = strArr2;
                    i2 = i5;
                    i3 = length;
                    arrayList = arrayList2;
                    str8 = str11;
                    str9 = str10;
                    zzigVar = zzigVar3;
                    bundle2 = A;
                }
                i5 = i2 + 1;
                strArr2 = strArr;
                A = bundle2;
                str10 = str9;
                arrayList2 = arrayList;
                length = i3;
                zzigVar3 = zzigVar;
                c2 = list;
                str11 = str8;
            }
            ArrayList arrayList4 = arrayList2;
            String str13 = str11;
            String str14 = str10;
            Bundle bundle4 = A;
            int i9 = i6;
            if (i9 != 0) {
                bundle4.putLong("_eid", j3);
                bundle4.putInt("_epc", i9);
            }
            int i10 = 0;
            while (i10 < arrayList4.size()) {
                Bundle bundle5 = (Bundle) arrayList4.get(i10);
                if (i10 != 0) {
                    str7 = "_ep";
                    str6 = str;
                } else {
                    str6 = str;
                    str7 = str5;
                }
                String str15 = str4;
                bundle5.putString(str15, str6);
                if (z2) {
                    bundle5 = l().z(bundle5);
                }
                Bundle bundle6 = bundle5;
                h().O().c("Logging event (FE)", k().y(str5), k().u(bundle6));
                String str16 = str14;
                String str17 = str5;
                r().K(new zzan(str7, new zzam(bundle6), str, j2), str16);
                if (!equals) {
                    Iterator<zzha> it = this.f18178e.iterator();
                    while (it.hasNext()) {
                        it.next().a(str, str2, new Bundle(bundle6), j2);
                    }
                }
                i10++;
                str4 = str15;
                str5 = str17;
                str14 = str16;
            }
            String str18 = str5;
            G();
            if (s().L() == null || !str13.equals(str18)) {
                return;
            }
            u().E(true, true);
        }
    }

    public final void S(String str, String str2, Bundle bundle) {
        U(str, str2, bundle, true, true, j().a());
    }

    public final void T(String str, String str2, Bundle bundle, boolean z) {
        U(str, str2, bundle, false, true, j().a());
    }

    public final void U(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) {
        b();
        t0(str == null ? "app" : str, str2, j2, bundle == null ? new Bundle() : bundle, z2, !z2 || this.f18177d == null || zzkk.u0(str2), !z, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V(String str, String str2, Object obj, long j2) {
        String str3;
        Object obj2;
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        b();
        x();
        if (n().B(q().C(), zzap.l0) && "allow_personalized_ads".equals(str2)) {
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    String lowerCase = str4.toLowerCase(Locale.ENGLISH);
                    String str5 = AdultContentAnalytics.UNLOCK;
                    Long valueOf = Long.valueOf(AdultContentAnalytics.UNLOCK.equals(lowerCase) ? 1L : 0L);
                    zzfj zzfjVar = m().t;
                    if (valueOf.longValue() == 1) {
                        str5 = "true";
                    }
                    zzfjVar.b(str5);
                    obj2 = valueOf;
                    str3 = "_npa";
                    if (!this.a.p()) {
                        h().O().a("User property not set since app measurement is disabled");
                        return;
                    } else {
                        if (this.a.u()) {
                            h().O().c("Setting user property (FE)", k().y(str3), obj2);
                            r().P(new zzkj(str3, j2, obj2, str));
                            return;
                        }
                        return;
                    }
                }
            }
            if (obj == null) {
                m().t.b("unset");
                obj2 = obj;
                str3 = "_npa";
                if (!this.a.p()) {
                }
            }
        }
        str3 = str2;
        obj2 = obj;
        if (!this.a.p()) {
        }
    }

    public final void W(String str, String str2, Object obj, boolean z) {
        X(str, str2, obj, z, j().a());
    }

    public final void X(String str, String str2, Object obj, boolean z, long j2) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i2 = 6;
        if (z) {
            i2 = l().o0(str2);
        } else {
            zzkk l = l();
            if (l.b0("user property", str2)) {
                if (!l.e0("user property", zzgy.a, str2)) {
                    i2 = 15;
                } else if (l.a0("user property", 24, str2)) {
                    i2 = 0;
                }
            }
        }
        if (i2 != 0) {
            l();
            this.a.I().I(i2, "_ev", zzkk.F(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj != null) {
            int j0 = l().j0(str2, obj);
            if (j0 != 0) {
                l();
                this.a.I().I(j0, "_ev", zzkk.F(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
                return;
            } else {
                Object p0 = l().p0(str2, obj);
                if (p0 != null) {
                    R(str3, str2, j2, p0);
                    return;
                }
                return;
            }
        }
        R(str3, str2, j2, null);
    }

    public final void Y(String str, String str2, String str3, Bundle bundle) {
        Preconditions.g(str);
        a();
        v0(str, str2, str3, bundle);
    }

    public final void Z(boolean z) {
        x();
        b();
        g().z(new h5(this, z));
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    public final void a0() {
        if (f().getApplicationContext() instanceof Application) {
            ((Application) f().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f18176c);
        }
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    public final Boolean b0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) g().v(atomicReference, 15000L, "boolean test flag value", new w4(this, atomicReference));
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public final String c0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) g().v(atomicReference, 15000L, "String test flag value", new e5(this, atomicReference));
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    public final Long d0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) g().v(atomicReference, 15000L, "long test flag value", new g5(this, atomicReference));
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    public final Integer e0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) g().v(atomicReference, 15000L, "int test flag value", new f5(this, atomicReference));
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    public final Double f0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) g().v(atomicReference, 15000L, "double test flag value", new i5(this, atomicReference));
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    public final String g0() {
        b();
        return this.f18180g.get();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    public final void h0() {
        d();
        b();
        x();
        if (this.a.u()) {
            if (n().B(this.a.T().C(), zzap.F0)) {
                zzx n = n();
                n.G();
                Boolean u = n.u("google_analytics_deferred_deep_link_enabled");
                if (u != null && u.booleanValue()) {
                    h().O().a("Deferred Deep Link feature enabled.");
                    g().z(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.u4

                        /* renamed from: f, reason: collision with root package name */
                        private final zzhc f17975f;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f17975f = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzhc zzhcVar = this.f17975f;
                            zzhcVar.d();
                            if (zzhcVar.m().A.b()) {
                                zzhcVar.h().O().a("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long a = zzhcVar.m().B.a();
                            zzhcVar.m().B.b(1 + a);
                            if (a >= 5) {
                                zzhcVar.h().K().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                zzhcVar.m().A.a(true);
                            } else {
                                zzhcVar.a.v();
                            }
                        }
                    });
                }
            }
            r().Y();
            this.f18181h = false;
            String K = m().K();
            if (TextUtils.isEmpty(K)) {
                return;
            }
            e().p();
            if (K.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", K);
            S("auto", "_ou", bundle);
        }
    }

    public final String i0() {
        zzig M = this.a.Q().M();
        if (M != null) {
            return M.a;
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    public final String j0() {
        zzig M = this.a.Q().M();
        if (M != null) {
            return M.f18189b;
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    public final String k0() {
        if (this.a.M() != null) {
            return this.a.M();
        }
        try {
            return GoogleServices.b();
        } catch (IllegalStateException e2) {
            this.a.h().H().b("getGoogleAppId failed with exception", e2);
            return null;
        }
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

    public final void o0(long j2) {
        b();
        g().z(new m5(this, j2));
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzhc p() {
        return super.p();
    }

    public final void p0(Bundle bundle) {
        Preconditions.k(bundle);
        Preconditions.g(bundle.getString(RateAndReviewsFragment.BundleCons.APP_ID));
        a();
        q0(new Bundle(bundle), j().a());
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzeq q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzik r() {
        return super.r();
    }

    public final void r0(zzha zzhaVar) {
        b();
        x();
        Preconditions.k(zzhaVar);
        if (this.f18178e.remove(zzhaVar)) {
            return;
        }
        h().K().a("OnEventListener had not been registered");
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void u0(String str, String str2, Bundle bundle) {
        b();
        d();
        P(str, str2, j().a(), bundle);
    }

    public final void w0(boolean z) {
        x();
        b();
        g().z(new k5(this, z));
    }

    public final void y0(String str, String str2, Bundle bundle) {
        b();
        v0(null, str, str2, bundle);
    }

    public final void z0(long j2) {
        O(null);
        g().z(new y4(this, j2));
    }
}
