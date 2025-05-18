package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class r5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final URL f17928f;

    /* renamed from: g, reason: collision with root package name */
    private final byte[] f17929g;

    /* renamed from: h, reason: collision with root package name */
    private final o5 f17930h;

    /* renamed from: i, reason: collision with root package name */
    private final String f17931i;

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, String> f17932j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzia f17933k;

    public r5(zzia zziaVar, String str, URL url, byte[] bArr, Map<String, String> map, o5 o5Var) {
        this.f17933k = zziaVar;
        Preconditions.g(str);
        Preconditions.k(url);
        Preconditions.k(o5Var);
        this.f17928f = url;
        this.f17929g = null;
        this.f17930h = o5Var;
        this.f17931i = str;
        this.f17932j = null;
    }

    private final void b(final int i2, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.f17933k.g().z(new Runnable(this, i2, exc, bArr, map) { // from class: com.google.android.gms.measurement.internal.q5

            /* renamed from: f, reason: collision with root package name */
            private final r5 f17913f;

            /* renamed from: g, reason: collision with root package name */
            private final int f17914g;

            /* renamed from: h, reason: collision with root package name */
            private final Exception f17915h;

            /* renamed from: i, reason: collision with root package name */
            private final byte[] f17916i;

            /* renamed from: j, reason: collision with root package name */
            private final Map f17917j;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f17913f = this;
                this.f17914g = i2;
                this.f17915h = exc;
                this.f17916i = bArr;
                this.f17917j = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f17913f.a(this.f17914g, this.f17915h, this.f17916i, this.f17917j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i2, Exception exc, byte[] bArr, Map map) {
        this.f17930h.a(this.f17931i, i2, exc, bArr, map);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map;
        Map<String, List<String>> map2;
        Map<String, List<String>> headerFields;
        byte[] w;
        this.f17933k.c();
        int i2 = 0;
        try {
            httpURLConnection = this.f17933k.u(this.f17928f);
            try {
                Map<String, String> map3 = this.f17932j;
                if (map3 != null) {
                    for (Map.Entry<String, String> entry : map3.entrySet()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                i2 = httpURLConnection.getResponseCode();
                headerFields = httpURLConnection.getHeaderFields();
            } catch (IOException e2) {
                e = e2;
                map2 = null;
            } catch (Throwable th) {
                th = th;
                map = null;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            map = null;
        }
        try {
            zzia zziaVar = this.f17933k;
            w = zzia.w(httpURLConnection);
            httpURLConnection.disconnect();
            b(i2, null, w, headerFields);
        } catch (IOException e4) {
            map2 = headerFields;
            e = e4;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            b(i2, e, null, map2);
        } catch (Throwable th3) {
            map = headerFields;
            th = th3;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            b(i2, null, null, map);
            throw th;
        }
    }
}
