package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzauq implements zzavb {
    private static List<Future<Void>> a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b, reason: collision with root package name */
    private static ScheduledExecutorService f14166b = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: c, reason: collision with root package name */
    private final zzdsj f14167c;

    /* renamed from: d, reason: collision with root package name */
    private final LinkedHashMap<String, zzdsp> f14168d;

    /* renamed from: g, reason: collision with root package name */
    private final Context f14171g;

    /* renamed from: h, reason: collision with root package name */
    private final zzavd f14172h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f14173i;

    /* renamed from: j, reason: collision with root package name */
    private final zzauy f14174j;

    /* renamed from: k, reason: collision with root package name */
    private final c4 f14175k;

    /* renamed from: e, reason: collision with root package name */
    private final List<String> f14169e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f14170f = new ArrayList();
    private final Object l = new Object();
    private HashSet<String> m = new HashSet<>();
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    public zzauq(Context context, zzbai zzbaiVar, zzauy zzauyVar, String str, zzavd zzavdVar) {
        Preconditions.l(zzauyVar, "SafeBrowsing config is not present.");
        this.f14171g = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f14168d = new LinkedHashMap<>();
        this.f14172h = zzavdVar;
        this.f14174j = zzauyVar;
        Iterator<String> it = zzauyVar.f14180j.iterator();
        while (it.hasNext()) {
            this.m.add(it.next().toLowerCase(Locale.ENGLISH));
        }
        this.m.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzdsj zzdsjVar = new zzdsj();
        zzdsjVar.f16110c = 8;
        zzdsjVar.f16112e = str;
        zzdsjVar.f16113f = str;
        zzdsk zzdskVar = new zzdsk();
        zzdsjVar.f16115h = zzdskVar;
        zzdskVar.f16119c = this.f14174j.f14176f;
        zzdsq zzdsqVar = new zzdsq();
        zzdsqVar.f16140c = zzbaiVar.f14326f;
        zzdsqVar.f16142e = Boolean.valueOf(Wrappers.a(this.f14171g).f());
        long b2 = GoogleApiAvailabilityLight.h().b(this.f14171g);
        if (b2 > 0) {
            zzdsqVar.f16141d = Long.valueOf(b2);
        }
        zzdsjVar.r = zzdsqVar;
        this.f14167c = zzdsjVar;
        this.f14175k = new c4(this.f14171g, this.f14174j.m, this);
    }

    private final zzdsp m(String str) {
        zzdsp zzdspVar;
        synchronized (this.l) {
            zzdspVar = this.f14168d.get(str);
        }
        return zzdspVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Void n(String str) {
        return null;
    }

    private final zzbbh<Void> p() {
        zzbbh<Void> d2;
        boolean z = this.f14173i;
        if (!((z && this.f14174j.l) || (this.p && this.f14174j.f14181k) || (!z && this.f14174j.f14179i))) {
            return zzbar.o(null);
        }
        synchronized (this.l) {
            this.f14167c.f16116i = new zzdsp[this.f14168d.size()];
            this.f14168d.values().toArray(this.f14167c.f16116i);
            this.f14167c.s = (String[]) this.f14169e.toArray(new String[0]);
            this.f14167c.t = (String[]) this.f14170f.toArray(new String[0]);
            if (zzava.a()) {
                zzdsj zzdsjVar = this.f14167c;
                String str = zzdsjVar.f16112e;
                String str2 = zzdsjVar.f16117j;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(str);
                sb.append("\n  clickUrl: ");
                sb.append(str2);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzdsp zzdspVar : this.f14167c.f16116i) {
                    sb2.append("    [");
                    sb2.append(zzdspVar.l.length);
                    sb2.append("] ");
                    sb2.append(zzdspVar.f16133e);
                }
                zzava.b(sb2.toString());
            }
            zzbbh<String> a2 = new zzayu(this.f14171g).a(1, this.f14174j.f14177g, null, zzdrw.b(this.f14167c));
            if (zzava.a()) {
                a2.k(new b4(this), zzaxg.a);
            }
            d2 = zzbar.d(a2, y3.a, zzbbm.f14331b);
        }
        return d2;
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void a(String str, Map<String, String> map, int i2) {
        synchronized (this.l) {
            if (i2 == 3) {
                this.p = true;
            }
            if (this.f14168d.containsKey(str)) {
                if (i2 == 3) {
                    this.f14168d.get(str).f16139k = Integer.valueOf(i2);
                }
                return;
            }
            zzdsp zzdspVar = new zzdsp();
            zzdspVar.f16139k = Integer.valueOf(i2);
            zzdspVar.f16132d = Integer.valueOf(this.f14168d.size());
            zzdspVar.f16133e = str;
            zzdspVar.f16134f = new zzdsm();
            if (this.m.size() > 0 && map != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        String key = entry.getKey() != null ? entry.getKey() : HttpUrl.FRAGMENT_ENCODE_SET;
                        String value = entry.getValue() != null ? entry.getValue() : HttpUrl.FRAGMENT_ENCODE_SET;
                        if (this.m.contains(key.toLowerCase(Locale.ENGLISH))) {
                            zzdsl zzdslVar = new zzdsl();
                            zzdslVar.f16121d = key.getBytes("UTF-8");
                            zzdslVar.f16122e = value.getBytes("UTF-8");
                            arrayList.add(zzdslVar);
                        }
                    } catch (UnsupportedEncodingException unused) {
                        zzava.b("Cannot convert string to bytes, skip header.");
                    }
                }
                zzdsl[] zzdslVarArr = new zzdsl[arrayList.size()];
                arrayList.toArray(zzdslVarArr);
                zzdspVar.f16134f.f16124d = zzdslVarArr;
            }
            this.f14168d.put(str, zzdspVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void b(String str) {
        synchronized (this.l) {
            this.f14167c.f16117j = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void c() {
        synchronized (this.l) {
            zzbbh<Map<String, String>> a2 = this.f14172h.a(this.f14171g, this.f14168d.keySet());
            zzbal zzbalVar = new zzbal(this) { // from class: com.google.android.gms.internal.ads.x3
                private final zzauq a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    return this.a.o((Map) obj);
                }
            };
            Executor executor = zzbbm.f14331b;
            zzbbh c2 = zzbar.c(a2, zzbalVar, executor);
            zzbbh b2 = zzbar.b(c2, 10L, TimeUnit.SECONDS, f14166b);
            zzbar.f(c2, new a4(this, b2), executor);
            a.add(b2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final String[] d(String[] strArr) {
        return (String[]) this.f14175k.a(strArr).toArray(new String[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void e() {
        this.n = true;
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void f(View view) {
        if (this.f14174j.f14178h && !this.o) {
            zzk.zzlg();
            Bitmap a0 = zzaxi.a0(view);
            if (a0 == null) {
                zzava.b("Failed to capture the webview bitmap.");
            } else {
                this.o = true;
                zzaxi.O(new z3(this, a0));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final boolean g() {
        return PlatformVersion.f() && this.f14174j.f14178h && !this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final zzauy h() {
        return this.f14174j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(String str) {
        synchronized (this.l) {
            this.f14169e.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(String str) {
        synchronized (this.l) {
            this.f14170f.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh o(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.l) {
                            int length = optJSONArray.length();
                            zzdsp m = m(str);
                            if (m == null) {
                                String valueOf = String.valueOf(str);
                                zzava.b(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                m.l = new String[length];
                                for (int i2 = 0; i2 < length; i2++) {
                                    m.l[i2] = optJSONArray.getJSONObject(i2).getString("threat_type");
                                }
                                this.f14173i = (length > 0) | this.f14173i;
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                if (((Boolean) zzyt.e().c(zzacu.q3)).booleanValue()) {
                    zzbad.b("Failed to get SafeBrowsing metadata", e2);
                }
                return zzbar.l(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.f14173i) {
            synchronized (this.l) {
                this.f14167c.f16110c = 9;
            }
        }
        return p();
    }
}
