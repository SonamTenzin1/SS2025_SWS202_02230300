package com.flurry.sdk;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.flurry.sdk.b7;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class h extends d7<l> {
    protected l p;
    protected h7 q;
    protected j r;
    protected g s;
    protected f t;
    protected AtomicBoolean u;
    protected f7<i7> v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a extends f2 {
        a() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            h.this.r.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends f2 {
        b() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            g0.a();
            g0.f("IdProvider: Provider start", Collections.emptyMap());
            h.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends f2 {

        /* loaded from: classes2.dex */
        final class a extends f2 {

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f10804h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f10805i;

            a(boolean z, String str) {
                this.f10804h = z;
                this.f10805i = str;
            }

            @Override // com.flurry.sdk.f2
            public final void a() throws Exception {
                h.this.t.a();
                boolean z = this.f10804h;
                f fVar = h.this.t;
                if (z == fVar.p && this.f10805i.equals(fVar.o)) {
                    return;
                }
                g0.a();
                g0.f("IdProvider: Advertising Info update", Collections.emptyMap());
                h.this.d();
            }
        }

        c() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(12:1|(7:2|3|(1:5)(1:66)|6|(1:8)|9|(1:11))|(2:13|14)|(4:16|(1:18)(1:62)|19|(8:21|(1:23)|25|26|(5:28|(1:30)(1:43)|31|(3:33|(1:35)(2:38|(1:40)(1:41))|36)(1:42)|37)|(1:45)|47|(2:49|50)(1:52))(3:55|(3:57|(1:59)|60)|61))|63|(0)|25|26|(0)|(0)|47|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x01bc, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x01bd, code lost:
        
            com.flurry.sdk.d1.c(6, "IdProvider", "Error Fetching Install Id - " + r2.getLocalizedMessage());
            com.flurry.sdk.g0.a();
            com.flurry.sdk.g0.c("Error fetching Install Id", "Exception happened during fetching Install Id", r2);
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0127 A[Catch: Exception -> 0x0131, TRY_LEAVE, TryCatch #2 {Exception -> 0x0131, blocks: (B:14:0x009a, B:16:0x00a6, B:19:0x00ca, B:23:0x0127, B:55:0x00d1, B:57:0x00db, B:59:0x00e5, B:60:0x011e, B:61:0x0121, B:62:0x00c4, B:63:0x0123), top: B:13:0x009a }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x015a A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:26:0x0151, B:28:0x015a, B:30:0x0160, B:31:0x0165, B:33:0x016f, B:36:0x01a4, B:37:0x01aa, B:38:0x0184, B:40:0x0193, B:41:0x01a0, B:43:0x0163, B:45:0x01ae), top: B:25:0x0151 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01ae A[Catch: Exception -> 0x01bc, TRY_LEAVE, TryCatch #0 {Exception -> 0x01bc, blocks: (B:26:0x0151, B:28:0x015a, B:30:0x0160, B:31:0x0165, B:33:0x016f, B:36:0x01a4, B:37:0x01aa, B:38:0x0184, B:40:0x0193, B:41:0x01a0, B:43:0x0163, B:45:0x01ae), top: B:25:0x0151 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x01eb  */
        /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
        @Override // com.flurry.sdk.f2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            byte[] bArr;
            g gVar;
            String str;
            h.this.u.set(false);
            h.this.r.a();
            byte[] bArr2 = null;
            try {
                f fVar = h.this.t;
                String g2 = p2.g("advertising_id", null);
                boolean z = !b0.a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getBoolean(String.format(Locale.US, "com.flurry.sdk.%s", "ad_tracking_enabled"), false);
                if (g2 != null) {
                    fVar.o = g2;
                    fVar.p = z;
                } else {
                    fVar.a();
                }
                f fVar2 = h.this.t;
                String str2 = fVar2.o;
                boolean z2 = fVar2.p;
                if (!str2.isEmpty()) {
                    h.this.p.b(m.AndroidAdvertisingId, str2);
                    h.this.p.f10893b = z2;
                }
                if (!h.this.t.q.get()) {
                    h.this.m(new a(z2, str2));
                }
            } catch (Exception e2) {
                d1.c(6, "IdProvider", "Error Fetching Ad Id - " + e2.getLocalizedMessage());
                g0.a();
                g0.c("Error fetching Ad Id", "Exception happened during fetching Ad Id", e2);
            }
            try {
                gVar = h.this.s;
            } catch (Exception e3) {
                d1.c(6, "IdProvider", "Error Fetching Device Id - " + e3.getLocalizedMessage());
                g0.a();
                g0.c("Error fetching Device Id", "Exception happened during fetching Device Id", e3);
            }
            if (TextUtils.isEmpty(gVar.a)) {
                String string = Settings.Secure.getString(b0.a().getContentResolver(), "android_id");
                str = gVar.f10766b.contains(string.toLowerCase(Locale.US)) ? null : "AND".concat(string);
                if (TextUtils.isEmpty(str)) {
                    String a2 = g.a();
                    if (TextUtils.isEmpty(a2)) {
                        a2 = gVar.c();
                        if (TextUtils.isEmpty(a2)) {
                            a2 = "ID" + Long.toString(Double.doubleToLongBits(new SecureRandom().nextDouble()) + ((System.nanoTime() + (c2.j(a2.a(b0.a())) * 37)) * 37), 16);
                        }
                        g.b(a2);
                    }
                    gVar.a = a2;
                } else {
                    if (str != null) {
                        h.this.p.b(m.DeviceId, str);
                    }
                    j jVar = h.this.r;
                    bArr = jVar.f10836b;
                    if (bArr == null) {
                        b7.a aVar = Build.VERSION.SDK_INT < 23 ? b7.a.CRYPTO_ALGO_PADDING_5 : b7.a.CRYPTO_ALGO_PADDING_7;
                        byte[] c2 = jVar.c(jVar.d());
                        if (c2 == null) {
                            String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.ENGLISH);
                            if (!TextUtils.isEmpty(lowerCase)) {
                                String replaceAll = lowerCase.replaceAll("[^a-f0-9]+", HttpUrl.FRAGMENT_ENCODE_SET);
                                if (replaceAll.length() % 2 != 0) {
                                    d1.c(4, "InstallationIdProvider", "Input string must contain an even number of characters ".concat(replaceAll));
                                } else {
                                    bArr2 = c2.i(replaceAll);
                                }
                            }
                            jVar.b(bArr2, aVar);
                            bArr = bArr2;
                        } else {
                            bArr = c2;
                        }
                        jVar.f10836b = bArr;
                    }
                    if (bArr != null) {
                        h.this.p.b(m.AndroidInstallationId, Base64.encodeToString(bArr, 2));
                    }
                    h.this.u.set(true);
                    if (h.this.c()) {
                        return;
                    }
                    h hVar = h.this;
                    hVar.t(hVar.p.c());
                    return;
                }
            }
            str = gVar.a;
            if (str != null) {
            }
            j jVar2 = h.this.r;
            bArr = jVar2.f10836b;
            if (bArr == null) {
            }
            if (bArr != null) {
            }
            h.this.u.set(true);
            if (h.this.c()) {
            }
        }
    }

    /* loaded from: classes2.dex */
    final class d implements f7<i7> {
        d() {
        }

        @Override // com.flurry.sdk.f7
        public final /* synthetic */ void a(i7 i7Var) {
            h.this.d();
            h.z(i7Var);
        }
    }

    public h(h7 h7Var) {
        super("IdProvider");
        this.p = null;
        this.u = new AtomicBoolean(false);
        this.v = new d();
        this.q = h7Var;
        this.r = new j();
        this.s = new g();
        this.t = new f();
        this.p = new l();
        this.q.v(this.v);
    }

    static /* synthetic */ void z(i7 i7Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("previous_state", i7Var.a.name());
        hashMap.put("current_state", i7Var.f10835b.name());
        g0.a();
        g0.f("IdProvider: App State Change", hashMap);
    }

    public final boolean c() {
        boolean z = this.u.get();
        l lVar = this.p;
        return z && (lVar != null && lVar.a() != null && this.p.a().size() > 0);
    }

    protected final void d() {
        m(new c());
    }

    @Override // com.flurry.sdk.d7
    public final void u() {
        m(new a());
        m(new b());
    }

    @Override // com.flurry.sdk.d7
    public final void v(f7<l> f7Var) {
        super.v(f7Var);
    }
}
