package com.airbnb.lottie.t;

import android.content.Context;
import c.i.j.e;
import com.airbnb.lottie.d;
import com.airbnb.lottie.k;
import com.airbnb.lottie.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* compiled from: NetworkFetcher.java */
/* loaded from: classes.dex */
public class c {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final String f8846b;

    /* renamed from: c, reason: collision with root package name */
    private final b f8847c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NetworkFetcher.java */
    /* loaded from: classes.dex */
    public class a implements Callable<k<d>> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k<d> call() throws Exception {
            return c.this.f();
        }
    }

    private c(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f8846b = str;
        this.f8847c = new b(applicationContext, str);
    }

    private l<d> a() {
        return new l<>(new a());
    }

    public static l<d> b(Context context, String str) {
        return new c(context, str).a();
    }

    private d c() {
        k<d> f2;
        e<com.airbnb.lottie.t.a, InputStream> a2 = this.f8847c.a();
        if (a2 == null) {
            return null;
        }
        com.airbnb.lottie.t.a aVar = a2.a;
        InputStream inputStream = a2.f3281b;
        if (aVar == com.airbnb.lottie.t.a.Zip) {
            f2 = com.airbnb.lottie.e.m(new ZipInputStream(inputStream), this.f8846b);
        } else {
            f2 = com.airbnb.lottie.e.f(inputStream, this.f8846b);
        }
        if (f2.b() != null) {
            return f2.b();
        }
        return null;
    }

    private k<d> d() {
        try {
            return e();
        } catch (IOException e2) {
            return new k<>((Throwable) e2);
        }
    }

    private k e() throws IOException {
        com.airbnb.lottie.t.a aVar;
        k<d> m;
        com.airbnb.lottie.c.b("Fetching " + this.f8846b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f8846b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
            String contentType = httpURLConnection.getContentType();
            char c2 = 65535;
            int hashCode = contentType.hashCode();
            if (hashCode != -1248325150) {
                if (hashCode == -43840953 && contentType.equals("application/json")) {
                    c2 = 1;
                }
            } else if (contentType.equals("application/zip")) {
                c2 = 0;
            }
            if (c2 != 0) {
                com.airbnb.lottie.c.b("Received json response.");
                aVar = com.airbnb.lottie.t.a.Json;
                m = com.airbnb.lottie.e.f(new FileInputStream(new File(this.f8847c.e(httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f8846b);
            } else {
                com.airbnb.lottie.c.b("Handling zip response.");
                aVar = com.airbnb.lottie.t.a.Zip;
                m = com.airbnb.lottie.e.m(new ZipInputStream(new FileInputStream(this.f8847c.e(httpURLConnection.getInputStream(), aVar))), this.f8846b);
            }
            if (m.b() != null) {
                this.f8847c.d(aVar);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Completed fetch from network. Success: ");
            sb.append(m.b() != null);
            com.airbnb.lottie.c.b(sb.toString());
            return m;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
                sb2.append('\n');
            } else {
                return new k((Throwable) new IllegalArgumentException("Unable to fetch " + this.f8846b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb2)));
            }
        }
    }

    public k<d> f() {
        d c2 = c();
        if (c2 != null) {
            return new k<>(c2);
        }
        com.airbnb.lottie.c.b("Animation for " + this.f8846b + " not found in cache. Fetching from network.");
        return d();
    }
}
