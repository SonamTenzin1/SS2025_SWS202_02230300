package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcgb {

    /* renamed from: e, reason: collision with root package name */
    private final Context f15198e;

    /* renamed from: f, reason: collision with root package name */
    private final zzclc f15199f;

    /* renamed from: g, reason: collision with root package name */
    private final Executor f15200g;

    /* renamed from: h, reason: collision with root package name */
    private final Executor f15201h;

    /* renamed from: i, reason: collision with root package name */
    private final ScheduledExecutorService f15202i;
    private boolean a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f15195b = false;

    /* renamed from: d, reason: collision with root package name */
    private final zzbbr<Boolean> f15197d = new zzbbr<>();

    /* renamed from: j, reason: collision with root package name */
    private Map<String, zzaio> f15203j = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final long f15196c = zzk.zzln().b();

    public zzcgb(Executor executor, Context context, Executor executor2, zzclc zzclcVar, ScheduledExecutorService scheduledExecutorService) {
        this.f15199f = zzclcVar;
        this.f15198e = context;
        this.f15200g = executor2;
        this.f15202i = scheduledExecutorService;
        this.f15201h = executor;
        d("com.google.android.gms.ads.MobileAds", false, HttpUrl.FRAGMENT_ENCODE_SET, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String str, boolean z, String str2, int i2) {
        this.f15203j.put(str, new zzaio(str, z, i2, str2));
    }

    private final synchronized void g() {
        if (!this.f15195b) {
            zzk.zzlk().r().u(new Runnable(this) { // from class: com.google.android.gms.internal.ads.li

                /* renamed from: f, reason: collision with root package name */
                private final zzcgb f12939f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12939f = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12939f.j();
                }
            });
            this.f15195b = true;
            this.f15202i.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.mi

                /* renamed from: f, reason: collision with root package name */
                private final zzcgb f12989f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12989f = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12989f.i();
                }
            }, ((Long) zzyt.e().c(zzacu.h2)).longValue(), TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzams zzamsVar, zzaiq zzaiqVar, List list) {
        try {
            try {
                zzamsVar.G4(ObjectWrapper.E0(this.f15198e), zzaiqVar, list);
            } catch (RemoteException e2) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            }
        } catch (RemoteException unused) {
            zzaiqVar.onInitializationFailed("Failed to create Adapter.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(Object obj, zzbbr zzbbrVar, String str, long j2) {
        synchronized (obj) {
            if (!zzbbrVar.isDone()) {
                d(str, false, "timeout", (int) (zzk.zzln().b() - j2));
                zzbbrVar.a(Boolean.FALSE);
            }
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final void k() {
        if (((Boolean) zzyt.e().c(zzacu.f2)).booleanValue() && !this.a) {
            synchronized (this) {
                if (this.a) {
                    return;
                }
                final String c2 = zzk.zzlk().r().q().c();
                if (TextUtils.isEmpty(c2)) {
                    g();
                    return;
                }
                this.a = true;
                d("com.google.android.gms.ads.MobileAds", true, HttpUrl.FRAGMENT_ENCODE_SET, (int) (zzk.zzln().b() - this.f15196c));
                this.f15200g.execute(new Runnable(this, c2) { // from class: com.google.android.gms.internal.ads.ki

                    /* renamed from: f, reason: collision with root package name */
                    private final zzcgb f12882f;

                    /* renamed from: g, reason: collision with root package name */
                    private final String f12883g;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f12882f = this;
                        this.f12883g = c2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12882f.n(this.f12883g);
                    }
                });
            }
        }
    }

    public final List<zzaio> f() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f15203j.keySet()) {
            zzaio zzaioVar = this.f15203j.get(str);
            arrayList.add(new zzaio(str, zzaioVar.f13916g, zzaioVar.f13917h, zzaioVar.f13918i));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object h() throws Exception {
        this.f15197d.a(Boolean.TRUE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            d("com.google.android.gms.ads.MobileAds", false, "timeout", (int) (zzk.zzln().b() - this.f15196c));
            this.f15197d.a(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void j() {
        this.f15200g.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.qi

            /* renamed from: f, reason: collision with root package name */
            private final zzcgb f13233f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13233f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13233f.k();
            }
        });
    }

    public final void l(final zzait zzaitVar) {
        this.f15197d.k(new Runnable(this, zzaitVar) { // from class: com.google.android.gms.internal.ads.ji

            /* renamed from: f, reason: collision with root package name */
            private final zzcgb f12826f;

            /* renamed from: g, reason: collision with root package name */
            private final zzait f12827g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12826f = this;
                this.f12827g = zzaitVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12826f.m(this.f12827g);
            }
        }, this.f15201h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void m(zzait zzaitVar) {
        try {
            zzaitVar.u0(f());
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void n(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                final String next = keys.next();
                final Object obj = new Object();
                final zzbbr zzbbrVar = new zzbbr();
                zzbbh b2 = zzbar.b(zzbbrVar, ((Long) zzyt.e().c(zzacu.g2)).longValue(), TimeUnit.SECONDS, this.f15202i);
                final long b3 = zzk.zzln().b();
                Iterator<String> it = keys;
                b2.k(new Runnable(this, obj, zzbbrVar, next, b3) { // from class: com.google.android.gms.internal.ads.ni

                    /* renamed from: f, reason: collision with root package name */
                    private final zzcgb f13055f;

                    /* renamed from: g, reason: collision with root package name */
                    private final Object f13056g;

                    /* renamed from: h, reason: collision with root package name */
                    private final zzbbr f13057h;

                    /* renamed from: i, reason: collision with root package name */
                    private final String f13058i;

                    /* renamed from: j, reason: collision with root package name */
                    private final long f13059j;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f13055f = this;
                        this.f13056g = obj;
                        this.f13057h = zzbbrVar;
                        this.f13058i = next;
                        this.f13059j = b3;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f13055f.c(this.f13056g, this.f13057h, this.f13058i, this.f13059j);
                    }
                }, this.f15200g);
                arrayList.add(b2);
                final ri riVar = new ri(this, obj, next, b3, zzbbrVar);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            String optString = jSONObject2.optString("format", HttpUrl.FRAGMENT_ENCODE_SET);
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, HttpUrl.FRAGMENT_ENCODE_SET));
                                }
                            }
                            arrayList2.add(new zzaiw(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                d(next, false, HttpUrl.FRAGMENT_ENCODE_SET, 0);
                try {
                    try {
                        final zzams e2 = this.f15199f.e(next, new JSONObject());
                        this.f15201h.execute(new Runnable(this, e2, riVar, arrayList2) { // from class: com.google.android.gms.internal.ads.pi

                            /* renamed from: f, reason: collision with root package name */
                            private final zzcgb f13169f;

                            /* renamed from: g, reason: collision with root package name */
                            private final zzams f13170g;

                            /* renamed from: h, reason: collision with root package name */
                            private final zzaiq f13171h;

                            /* renamed from: i, reason: collision with root package name */
                            private final List f13172i;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f13169f = this;
                                this.f13170g = e2;
                                this.f13171h = riVar;
                                this.f13172i = arrayList2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f13169f.a(this.f13170g, this.f13171h, this.f13172i);
                            }
                        });
                    } catch (RemoteException e3) {
                        zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e3);
                    }
                } catch (RemoteException unused2) {
                    riVar.onInitializationFailed("Failed to create Adapter.");
                }
                keys = it;
            }
            zzbar.n(arrayList).a(new Callable(this) { // from class: com.google.android.gms.internal.ads.oi

                /* renamed from: f, reason: collision with root package name */
                private final zzcgb f13104f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f13104f = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f13104f.h();
                }
            }, this.f15200g);
        } catch (JSONException e4) {
            zzawz.l("Malformed CLD response", e4);
        }
    }
}
