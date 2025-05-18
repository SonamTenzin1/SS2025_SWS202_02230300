package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import com.google.android.datatransport.cct.d;
import com.google.android.datatransport.cct.f.j;
import com.google.android.datatransport.cct.f.k;
import com.google.android.datatransport.cct.f.l;
import com.google.android.datatransport.cct.f.m;
import com.google.android.datatransport.cct.f.n;
import com.google.android.datatransport.cct.f.o;
import com.google.android.datatransport.cct.f.p;
import com.google.android.datatransport.runtime.backends.f;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.backends.m;
import com.google.firebase.encoders.EncodingException;
import e.e.b.a.i.i;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CctTransportBackend.java */
/* loaded from: classes2.dex */
public final class d implements m {
    private final com.google.firebase.encoders.a a;

    /* renamed from: b, reason: collision with root package name */
    private final ConnectivityManager f11192b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f11193c;

    /* renamed from: d, reason: collision with root package name */
    final URL f11194d;

    /* renamed from: e, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11195e;

    /* renamed from: f, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11196f;

    /* renamed from: g, reason: collision with root package name */
    private final int f11197g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CctTransportBackend.java */
    /* loaded from: classes2.dex */
    public static final class a {
        final URL a;

        /* renamed from: b, reason: collision with root package name */
        final j f11198b;

        /* renamed from: c, reason: collision with root package name */
        final String f11199c;

        a(URL url, j jVar, String str) {
            this.a = url;
            this.f11198b = jVar;
            this.f11199c = str;
        }

        a a(URL url) {
            return new a(url, this.f11198b, this.f11199c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CctTransportBackend.java */
    /* loaded from: classes2.dex */
    public static final class b {
        final int a;

        /* renamed from: b, reason: collision with root package name */
        final URL f11200b;

        /* renamed from: c, reason: collision with root package name */
        final long f11201c;

        b(int i2, URL url, long j2) {
            this.a = i2;
            this.f11200b = url;
            this.f11201c = j2;
        }
    }

    d(Context context, e.e.b.a.i.c0.a aVar, e.e.b.a.i.c0.a aVar2, int i2) {
        this.a = j.b();
        this.f11193c = context;
        this.f11192b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f11194d = m(c.a);
        this.f11195e = aVar2;
        this.f11196f = aVar;
        this.f11197g = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b c(a aVar) throws IOException {
        e.e.b.a.i.z.a.f("CctTransportBackend", "Making request to: %s", aVar.a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f11197g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.1.9"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f11199c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.a.a(aVar.f11198b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    e.e.b.a.i.z.a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    e.e.b.a.i.z.a.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    e.e.b.a.i.z.a.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream l = l(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        try {
                            b bVar = new b(responseCode, null, n.b(new BufferedReader(new InputStreamReader(l))).c());
                            if (l != null) {
                                l.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } catch (Throwable th) {
                            if (l != null) {
                                try {
                                    l.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th4;
            }
        } catch (EncodingException e2) {
            e = e2;
            e.e.b.a.i.z.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (ConnectException e3) {
            e = e3;
            e.e.b.a.i.z.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e4) {
            e = e4;
            e.e.b.a.i.z.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e5) {
            e = e5;
            e.e.b.a.i.z.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    private static int d(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return o.b.UNKNOWN_MOBILE_SUBTYPE.k();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return o.b.COMBINED.k();
        }
        if (o.b.g(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int e(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return o.c.NONE.k();
        }
        return networkInfo.getType();
    }

    private static int f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e.e.b.a.i.z.a.d("CctTransportBackend", "Unable to find version code for package", e2);
            return -1;
        }
    }

    private j g(f fVar) {
        l.a j2;
        HashMap hashMap = new HashMap();
        for (e.e.b.a.i.j jVar : fVar.b()) {
            String j3 = jVar.j();
            if (!hashMap.containsKey(j3)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(jVar);
                hashMap.put(j3, arrayList);
            } else {
                ((List) hashMap.get(j3)).add(jVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            e.e.b.a.i.j jVar2 = (e.e.b.a.i.j) ((List) entry.getValue()).get(0);
            m.a b2 = com.google.android.datatransport.cct.f.m.a().f(p.DEFAULT).g(this.f11196f.a()).h(this.f11195e.a()).b(k.a().c(k.b.ANDROID_FIREBASE).b(com.google.android.datatransport.cct.f.a.a().m(Integer.valueOf(jVar2.g("sdk-version"))).j(jVar2.b("model")).f(jVar2.b("hardware")).d(jVar2.b("device")).l(jVar2.b("product")).k(jVar2.b("os-uild")).h(jVar2.b("manufacturer")).e(jVar2.b("fingerprint")).c(jVar2.b("country")).g(jVar2.b("locale")).i(jVar2.b("mcc_mnc")).b(jVar2.b("application_build")).a()).a());
            try {
                b2.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                b2.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (e.e.b.a.i.j jVar3 : (List) entry.getValue()) {
                i e2 = jVar3.e();
                e.e.b.a.b b3 = e2.b();
                if (b3.equals(e.e.b.a.b.b("proto"))) {
                    j2 = l.j(e2.a());
                } else if (b3.equals(e.e.b.a.b.b(BodyInterceptorV3.RESPONSE_MODE_JSON))) {
                    j2 = l.i(new String(e2.a(), Charset.forName("UTF-8")));
                } else {
                    e.e.b.a.i.z.a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b3);
                }
                j2.c(jVar3.f()).d(jVar3.k()).h(jVar3.h("tz-offset")).e(o.a().c(o.c.g(jVar3.g("net-type"))).b(o.b.g(jVar3.g("mobile-subtype"))).a());
                if (jVar3.d() != null) {
                    j2.b(jVar3.d());
                }
                arrayList3.add(j2.a());
            }
            b2.c(arrayList3);
            arrayList2.add(b2.a());
        }
        return j.a(arrayList2);
    }

    private static TelephonyManager h(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    static long i() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ a k(a aVar, b bVar) {
        URL url = bVar.f11200b;
        if (url == null) {
            return null;
        }
        e.e.b.a.i.z.a.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f11200b);
    }

    private static InputStream l(InputStream inputStream, String str) throws IOException {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static URL m(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Invalid url: " + str, e2);
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.m
    public g a(f fVar) {
        j g2 = g(fVar);
        URL url = this.f11194d;
        if (fVar.c() != null) {
            try {
                c c2 = c.c(fVar.c());
                r3 = c2.d() != null ? c2.d() : null;
                if (c2.e() != null) {
                    url = m(c2.e());
                }
            } catch (IllegalArgumentException unused) {
                return g.a();
            }
        }
        try {
            b bVar = (b) e.e.b.a.i.a0.b.a(5, new a(url, g2, r3), new e.e.b.a.i.a0.a() { // from class: com.google.android.datatransport.cct.b
                @Override // e.e.b.a.i.a0.a
                public final Object a(Object obj) {
                    d.b c3;
                    c3 = d.this.c((d.a) obj);
                    return c3;
                }
            }, new e.e.b.a.i.a0.c() { // from class: com.google.android.datatransport.cct.a
                @Override // e.e.b.a.i.a0.c
                public final Object a(Object obj, Object obj2) {
                    return d.k((d.a) obj, (d.b) obj2);
                }
            });
            int i2 = bVar.a;
            if (i2 == 200) {
                return g.e(bVar.f11201c);
            }
            if (i2 < 500 && i2 != 404) {
                if (i2 == 400) {
                    return g.d();
                }
                return g.a();
            }
            return g.f();
        } catch (IOException e2) {
            e.e.b.a.i.z.a.d("CctTransportBackend", "Could not make request to the backend", e2);
            return g.f();
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.m
    public e.e.b.a.i.j b(e.e.b.a.i.j jVar) {
        NetworkInfo activeNetworkInfo = this.f11192b.getActiveNetworkInfo();
        return jVar.l().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", i()).a("net-type", e(activeNetworkInfo)).a("mobile-subtype", d(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", h(this.f11193c).getSimOperator()).c("application_build", Integer.toString(f(this.f11193c))).d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, e.e.b.a.i.c0.a aVar, e.e.b.a.i.c0.a aVar2) {
        this(context, aVar, aVar2, 130000);
    }
}
