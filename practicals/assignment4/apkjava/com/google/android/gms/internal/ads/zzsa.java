package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.dataprovider.BuildConfig;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zzsa implements zzrv {
    private static final Pattern a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicReference<byte[]> f16697b = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    private final int f16699d;

    /* renamed from: e, reason: collision with root package name */
    private final int f16700e;

    /* renamed from: f, reason: collision with root package name */
    private final String f16701f;

    /* renamed from: j, reason: collision with root package name */
    private final zzsj<? super zzsa> f16705j;

    /* renamed from: k, reason: collision with root package name */
    private zzry f16706k;
    private HttpURLConnection l;
    private InputStream m;
    private boolean n;
    private long o;
    private long p;
    private long q;
    private long r;

    /* renamed from: g, reason: collision with root package name */
    private final zzsv<String> f16702g = null;

    /* renamed from: i, reason: collision with root package name */
    private final zzsd f16704i = new zzsd();

    /* renamed from: c, reason: collision with root package name */
    private final boolean f16698c = true;

    /* renamed from: h, reason: collision with root package name */
    private final zzsd f16703h = null;

    public zzsa(String str, zzsv<String> zzsvVar, zzsj<? super zzsa> zzsjVar, int i2, int i3, boolean z, zzsd zzsdVar) {
        this.f16701f = zzsk.c(str);
        this.f16705j = zzsjVar;
        this.f16699d = i2;
        this.f16700e = i3;
    }

    private final HttpURLConnection c(URL url, byte[] bArr, long j2, long j3, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f16699d);
        httpURLConnection.setReadTimeout(this.f16700e);
        for (Map.Entry<String, String> entry : this.f16704i.a().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (j2 != 0 || j3 != -1) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j2);
            sb.append("-");
            String sb2 = sb.toString();
            if (j3 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 20);
                sb3.append(valueOf);
                sb3.append((j2 + j3) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f16701f);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
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
                Log.e("DefaultHttpDataSource", sb.toString());
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
                Log.w("DefaultHttpDataSource", sb2.toString());
                return Math.max(parseLong, parseLong2);
            } catch (NumberFormatException unused2) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(headerField).length() + 27);
                sb3.append("Unexpected Content-Range [");
                sb3.append(headerField);
                sb3.append("]");
                Log.e("DefaultHttpDataSource", sb3.toString());
                return parseLong;
            }
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
        }
    }

    private final void e() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.l = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri I0() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0077, code lost:
    
        r0 = r1;
     */
    @Override // com.google.android.gms.internal.ads.zzrv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long a(zzry zzryVar) throws zzsb {
        HttpURLConnection httpURLConnection;
        this.f16706k = zzryVar;
        long j2 = 0;
        this.r = 0L;
        this.q = 0L;
        try {
            URL url = new URL(zzryVar.a.toString());
            byte[] bArr = zzryVar.f16684b;
            long j3 = zzryVar.f16686d;
            long j4 = zzryVar.f16687e;
            boolean a2 = zzryVar.a(1);
            if (this.f16698c) {
                URL url2 = url;
                byte[] bArr2 = bArr;
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (i2 <= 20) {
                        URL url3 = url2;
                        long j5 = j4;
                        long j6 = j3;
                        HttpURLConnection c2 = c(url2, bArr2, j3, j4, a2, false);
                        int responseCode = c2.getResponseCode();
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr2 != null || (responseCode != 307 && responseCode != 308))) {
                            break;
                        }
                        bArr2 = null;
                        String headerField = c2.getHeaderField("Location");
                        c2.disconnect();
                        if (headerField != null) {
                            url2 = new URL(url3, headerField);
                            String protocol = url2.getProtocol();
                            if (!BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equals(protocol) && !"http".equals(protocol)) {
                                String valueOf = String.valueOf(protocol);
                                throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
                            }
                            i2 = i3;
                            j4 = j5;
                            j3 = j6;
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
                httpURLConnection = c(url, bArr, j3, j4, a2, true);
            }
            this.l = httpURLConnection;
            try {
                int responseCode2 = httpURLConnection.getResponseCode();
                if (responseCode2 >= 200 && responseCode2 <= 299) {
                    this.l.getContentType();
                    if (responseCode2 == 200) {
                        long j7 = zzryVar.f16686d;
                        if (j7 != 0) {
                            j2 = j7;
                        }
                    }
                    this.o = j2;
                    if (!zzryVar.a(1)) {
                        long j8 = zzryVar.f16687e;
                        if (j8 != -1) {
                            this.p = j8;
                        } else {
                            long d2 = d(this.l);
                            this.p = d2 != -1 ? d2 - this.o : -1L;
                        }
                    } else {
                        this.p = zzryVar.f16687e;
                    }
                    try {
                        this.m = this.l.getInputStream();
                        this.n = true;
                        zzsj<? super zzsa> zzsjVar = this.f16705j;
                        if (zzsjVar != null) {
                            zzsjVar.n(this, zzryVar);
                        }
                        return this.p;
                    } catch (IOException e2) {
                        e();
                        throw new zzsb(e2, zzryVar, 1);
                    }
                }
                Map<String, List<String>> headerFields = this.l.getHeaderFields();
                e();
                zzsc zzscVar = new zzsc(responseCode2, headerFields, zzryVar);
                if (responseCode2 == 416) {
                    zzscVar.initCause(new zzrx(0));
                    throw zzscVar;
                }
                throw zzscVar;
            } catch (IOException e3) {
                e();
                String valueOf2 = String.valueOf(zzryVar.a.toString());
                throw new zzsb(valueOf2.length() != 0 ? "Unable to connect to ".concat(valueOf2) : new String("Unable to connect to "), e3, zzryVar, 1);
            }
        } catch (IOException e4) {
            String valueOf3 = String.valueOf(zzryVar.a.toString());
            throw new zzsb(valueOf3.length() != 0 ? "Unable to connect to ".concat(valueOf3) : new String("Unable to connect to "), e4, zzryVar, 1);
        }
    }

    public final Map<String, List<String>> b() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0032, code lost:
    
        if (r3 > 2048) goto L21;
     */
    @Override // com.google.android.gms.internal.ads.zzrv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void close() throws zzsb {
        try {
            if (this.m != null) {
                HttpURLConnection httpURLConnection = this.l;
                long j2 = this.p;
                if (j2 != -1) {
                    j2 -= this.r;
                }
                int i2 = zzsy.a;
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
                    } catch (Exception unused) {
                    }
                }
                try {
                    this.m.close();
                } catch (IOException e2) {
                    throw new zzsb(e2, this.f16706k, 3);
                }
            }
        } finally {
            this.m = null;
            e();
            if (this.n) {
                this.n = false;
                zzsj<? super zzsa> zzsjVar = this.f16705j;
                if (zzsjVar != null) {
                    zzsjVar.d(this);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i2, int i3) throws zzsb {
        try {
            if (this.q != this.o) {
                byte[] andSet = f16697b.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
                }
                while (true) {
                    long j2 = this.q;
                    long j3 = this.o;
                    if (j2 != j3) {
                        int read = this.m.read(andSet, 0, (int) Math.min(j3 - j2, andSet.length));
                        if (Thread.interrupted()) {
                            throw new InterruptedIOException();
                        }
                        if (read != -1) {
                            this.q += read;
                            zzsj<? super zzsa> zzsjVar = this.f16705j;
                            if (zzsjVar != null) {
                                zzsjVar.o(this, read);
                            }
                        } else {
                            throw new EOFException();
                        }
                    } else {
                        f16697b.set(andSet);
                        break;
                    }
                }
            }
            if (i3 == 0) {
                return 0;
            }
            long j4 = this.p;
            if (j4 != -1) {
                long j5 = j4 - this.r;
                if (j5 == 0) {
                    return -1;
                }
                i3 = (int) Math.min(i3, j5);
            }
            int read2 = this.m.read(bArr, i2, i3);
            if (read2 == -1) {
                if (this.p == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.r += read2;
            zzsj<? super zzsa> zzsjVar2 = this.f16705j;
            if (zzsjVar2 != null) {
                zzsjVar2.o(this, read2);
            }
            return read2;
        } catch (IOException e2) {
            throw new zzsb(e2, this.f16706k, 2);
        }
    }
}
