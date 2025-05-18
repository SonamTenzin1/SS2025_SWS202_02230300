package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.dataprovider.BuildConfig;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zzjs implements zzkf {
    private static final Pattern a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicReference<byte[]> f16366b = new AtomicReference<>();

    /* renamed from: c, reason: collision with root package name */
    private final boolean f16367c;

    /* renamed from: d, reason: collision with root package name */
    private final int f16368d;

    /* renamed from: e, reason: collision with root package name */
    private final int f16369e;

    /* renamed from: f, reason: collision with root package name */
    private final String f16370f;

    /* renamed from: g, reason: collision with root package name */
    private final zzkn<String> f16371g;

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<String, String> f16372h;

    /* renamed from: i, reason: collision with root package name */
    private final zzke f16373i;

    /* renamed from: j, reason: collision with root package name */
    private zzjq f16374j;

    /* renamed from: k, reason: collision with root package name */
    private HttpURLConnection f16375k;
    private InputStream l;
    private boolean m;
    private long n;
    private long o;
    private long p;
    private long q;

    public zzjs(String str, zzkn<String> zzknVar, zzke zzkeVar, int i2, int i3, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f16370f = str;
            this.f16371g = null;
            this.f16373i = null;
            this.f16372h = new HashMap<>();
            this.f16368d = i2;
            this.f16369e = i3;
            this.f16367c = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    private final void b() {
        HttpURLConnection httpURLConnection = this.f16375k;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.f16375k = null;
        }
    }

    private final HttpURLConnection c(URL url, long j2, long j3, boolean z) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f16368d);
        httpURLConnection.setReadTimeout(this.f16369e);
        httpURLConnection.setDoOutput(false);
        synchronized (this.f16372h) {
            for (Map.Entry<String, String> entry : this.f16372h.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (j2 != 0 || j3 != -1) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j2);
            sb.append("-");
            String sb2 = sb.toString();
            if (j3 != -1) {
                String valueOf = String.valueOf(sb2);
                long j4 = (j2 + j3) - 1;
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 20);
                sb3.append(valueOf);
                sb3.append(j4);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f16370f);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long d(HttpURLConnection httpURLConnection) {
        long parseLong;
        String headerField;
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(headerField2).length() + 28);
                sb.append("Unexpected Content-Length [");
                sb.append(headerField2);
                sb.append("]");
                Log.e("HttpDataSource", sb.toString());
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (!TextUtils.isEmpty(headerField)) {
                return parseLong;
            }
            Matcher matcher = a.matcher(headerField);
            if (!matcher.find()) {
                return parseLong;
            }
            try {
                long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                if (parseLong < 0) {
                    return parseLong2;
                }
                if (parseLong == parseLong2) {
                    return parseLong;
                }
                StringBuilder sb2 = new StringBuilder(String.valueOf(headerField2).length() + 26 + String.valueOf(headerField).length());
                sb2.append("Inconsistent headers [");
                sb2.append(headerField2);
                sb2.append("] [");
                sb2.append(headerField);
                sb2.append("]");
                Log.w("HttpDataSource", sb2.toString());
                return Math.max(parseLong, parseLong2);
            } catch (NumberFormatException unused2) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(headerField).length() + 27);
                sb3.append("Unexpected Content-Range [");
                sb3.append(headerField);
                sb3.append("]");
                Log.e("HttpDataSource", sb3.toString());
                return parseLong;
            }
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long a(zzjq zzjqVar) throws zzjx {
        HttpURLConnection httpURLConnection;
        this.f16374j = zzjqVar;
        long j2 = 0;
        this.q = 0L;
        this.p = 0L;
        try {
            URL url = new URL(zzjqVar.a.toString());
            long j3 = zzjqVar.f16359c;
            long j4 = zzjqVar.f16360d;
            boolean z = (zzjqVar.f16362f & 1) != 0;
            if (this.f16367c) {
                URL url2 = url;
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (i2 <= 20) {
                        URL url3 = url2;
                        long j5 = j4;
                        HttpURLConnection c2 = c(url2, j3, j4, z);
                        c2.setInstanceFollowRedirects(false);
                        c2.connect();
                        int responseCode = c2.getResponseCode();
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                            httpURLConnection = c2;
                            break;
                        }
                        String headerField = c2.getHeaderField("Location");
                        c2.disconnect();
                        if (headerField != null) {
                            URL url4 = new URL(url3, headerField);
                            String protocol = url4.getProtocol();
                            if (!BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equals(protocol) && !"http".equals(protocol)) {
                                String valueOf = String.valueOf(protocol);
                                throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
                            }
                            url2 = url4;
                            i2 = i3;
                            j4 = j5;
                        } else {
                            throw new ProtocolException("Null location redirect");
                        }
                    } else {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("Too many redirects: ");
                        sb.append(i3);
                        throw new NoRouteToHostException(sb.toString());
                    }
                }
            } else {
                httpURLConnection = c(url, j3, j4, z);
                httpURLConnection.connect();
            }
            this.f16375k = httpURLConnection;
            try {
                int responseCode2 = httpURLConnection.getResponseCode();
                if (responseCode2 >= 200 && responseCode2 <= 299) {
                    this.f16375k.getContentType();
                    if (responseCode2 == 200) {
                        long j6 = zzjqVar.f16359c;
                        if (j6 != 0) {
                            j2 = j6;
                        }
                    }
                    this.n = j2;
                    if ((zzjqVar.f16362f & 1) == 0) {
                        long d2 = d(this.f16375k);
                        long j7 = zzjqVar.f16360d;
                        if (j7 == -1) {
                            j7 = d2 != -1 ? d2 - this.n : -1L;
                        }
                        this.o = j7;
                    } else {
                        this.o = zzjqVar.f16360d;
                    }
                    try {
                        this.l = this.f16375k.getInputStream();
                        this.m = true;
                        zzke zzkeVar = this.f16373i;
                        if (zzkeVar != null) {
                            zzkeVar.b();
                        }
                        return this.o;
                    } catch (IOException e2) {
                        b();
                        throw new zzjx(e2, zzjqVar);
                    }
                }
                Map<String, List<String>> headerFields = this.f16375k.getHeaderFields();
                b();
                throw new zzjy(responseCode2, headerFields, zzjqVar);
            } catch (IOException e3) {
                b();
                String valueOf2 = String.valueOf(zzjqVar.a.toString());
                throw new zzjx(valueOf2.length() != 0 ? "Unable to connect to ".concat(valueOf2) : new String("Unable to connect to "), e3, zzjqVar);
            }
        } catch (IOException e4) {
            String valueOf3 = String.valueOf(zzjqVar.a.toString());
            throw new zzjx(valueOf3.length() != 0 ? "Unable to connect to ".concat(valueOf3) : new String("Unable to connect to "), e4, zzjqVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0031, code lost:
    
        if (r2 > 2048) goto L21;
     */
    @Override // com.google.android.gms.internal.ads.zzjp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void close() throws zzjx {
        try {
            if (this.l != null) {
                HttpURLConnection httpURLConnection = this.f16375k;
                long j2 = this.o;
                if (j2 != -1) {
                    j2 -= this.q;
                }
                int i2 = zzkq.a;
                if (i2 == 19 || i2 == 20) {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (j2 == -1) {
                            if (inputStream.read() == -1) {
                            }
                        }
                        String name = inputStream.getClass().getName();
                        if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                            Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(inputStream, new Object[0]);
                        }
                    } catch (IOException | Exception unused) {
                    }
                }
                try {
                    this.l.close();
                    this.l = null;
                } catch (IOException e2) {
                    throw new zzjx(e2, this.f16374j);
                }
            }
        } finally {
            if (this.m) {
                this.m = false;
                zzke zzkeVar = this.f16373i;
                if (zzkeVar != null) {
                    zzkeVar.c();
                }
                b();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i2, int i3) throws zzjx {
        try {
            if (this.p != this.n) {
                byte[] andSet = f16366b.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
                }
                while (true) {
                    long j2 = this.p;
                    long j3 = this.n;
                    if (j2 != j3) {
                        int read = this.l.read(andSet, 0, (int) Math.min(j3 - j2, andSet.length));
                        if (Thread.interrupted()) {
                            throw new InterruptedIOException();
                        }
                        if (read != -1) {
                            this.p += read;
                            zzke zzkeVar = this.f16373i;
                            if (zzkeVar != null) {
                                zzkeVar.a(read);
                            }
                        } else {
                            throw new EOFException();
                        }
                    } else {
                        f16366b.set(andSet);
                        break;
                    }
                }
            }
            long j4 = this.o;
            if (j4 != -1) {
                i3 = (int) Math.min(i3, j4 - this.q);
            }
            if (i3 == 0) {
                return -1;
            }
            int read2 = this.l.read(bArr, i2, i3);
            if (read2 == -1) {
                long j5 = this.o;
                if (j5 != -1 && j5 != this.q) {
                    throw new EOFException();
                }
                return -1;
            }
            this.q += read2;
            zzke zzkeVar2 = this.f16373i;
            if (zzkeVar2 != null) {
                zzkeVar2.a(read2);
            }
            return read2;
        } catch (IOException e2) {
            throw new zzjx(e2, this.f16374j);
        }
    }
}
