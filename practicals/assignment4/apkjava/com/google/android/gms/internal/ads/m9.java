package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
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
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

@zzard
/* loaded from: classes2.dex */
final class m9 implements zzrv {
    private static final Pattern a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicReference<byte[]> f12965b = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    private final int f12967d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12968e;

    /* renamed from: f, reason: collision with root package name */
    private final String f12969f;

    /* renamed from: h, reason: collision with root package name */
    private final zzsj<? super m9> f12971h;

    /* renamed from: i, reason: collision with root package name */
    private zzry f12972i;

    /* renamed from: j, reason: collision with root package name */
    private HttpURLConnection f12973j;

    /* renamed from: k, reason: collision with root package name */
    private InputStream f12974k;
    private boolean l;
    private long m;
    private long n;
    private long o;
    private long p;
    private int q;

    /* renamed from: c, reason: collision with root package name */
    private SSLSocketFactory f12966c = new n9(this);
    private Set<Socket> r = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private final zzsd f12970g = new zzsd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public m9(String str, zzsj<? super m9> zzsjVar, int i2, int i3, int i4) {
        this.f12969f = zzsk.c(str);
        this.f12971h = zzsjVar;
        this.f12967d = i2;
        this.f12968e = i3;
        this.q = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(Socket socket) {
        this.r.add(socket);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long f(HttpURLConnection httpURLConnection) {
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
                zzbad.g(sb.toString());
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
                zzbad.i(sb2.toString());
                return Math.max(parseLong, parseLong2);
            } catch (NumberFormatException unused2) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(headerField).length() + 27);
                sb3.append("Unexpected Content-Range [");
                sb3.append(headerField);
                sb3.append("]");
                zzbad.g(sb3.toString());
                return parseLong;
            }
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
        }
    }

    private final void g() {
        HttpURLConnection httpURLConnection = this.f12973j;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                zzbad.c("Unexpected error while disconnecting", e2);
            }
            this.f12973j = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri I0() {
        HttpURLConnection httpURLConnection = this.f12973j;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0127, code lost:
    
        r23.f12973j = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0129, code lost:
    
        r0 = r14.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012f, code lost:
    
        if (r0 < 200) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0133, code lost:
    
        if (r0 <= 299) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0136, code lost:
    
        if (r0 != 200) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0138, code lost:
    
        r3 = r24.f16686d;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013e, code lost:
    
        if (r3 == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0140, code lost:
    
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0145, code lost:
    
        r23.m = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x014c, code lost:
    
        if (r24.a(1) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014e, code lost:
    
        r3 = r24.f16687e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0154, code lost:
    
        if (r3 == (-1)) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0156, code lost:
    
        r23.n = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0170, code lost:
    
        r23.f12974k = r23.f12973j.getInputStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0178, code lost:
    
        r23.l = true;
        r0 = r23.f12971h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x017d, code lost:
    
        if (r0 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x017f, code lost:
    
        r0.n(r23, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0184, code lost:
    
        return r23.n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0185, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0186, code lost:
    
        g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018f, code lost:
    
        throw new com.google.android.gms.internal.ads.zzsb(r0, r24, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0159, code lost:
    
        r3 = f(r23.f12973j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0161, code lost:
    
        if (r3 == (-1)) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0163, code lost:
    
        r4 = r3 - r23.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0169, code lost:
    
        r23.n = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0168, code lost:
    
        r4 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x016c, code lost:
    
        r23.n = r24.f16687e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0144, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0142, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0190, code lost:
    
        r3 = r23.f12973j.getHeaderFields();
        g();
        r4 = new com.google.android.gms.internal.ads.zzsc(r0, r3, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a0, code lost:
    
        if (r0 != 416) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01a2, code lost:
    
        r4.initCause(new com.google.android.gms.internal.ads.zzrx(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ab, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01ac, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01ad, code lost:
    
        g();
        r5 = java.lang.String.valueOf(r24.a.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c1, code lost:
    
        if (r5.length() != 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c3, code lost:
    
        r3 = "Unable to connect to ".concat(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d2, code lost:
    
        throw new com.google.android.gms.internal.ads.zzsb(r3, r0, r24, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01c8, code lost:
    
        r3 = new java.lang.String("Unable to connect to ");
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0220 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5 A[Catch: IOException -> 0x0241, TryCatch #1 {IOException -> 0x0241, blocks: (B:3:0x000f, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:20:0x00cc, B:22:0x00d5, B:23:0x00dc, B:26:0x00e5, B:28:0x00ea, B:30:0x00f2, B:31:0x0107, B:46:0x0127, B:97:0x01d7, B:99:0x01e2, B:101:0x01f3, B:104:0x01fb, B:106:0x0209, B:107:0x0213, B:108:0x0216, B:109:0x020e, B:114:0x0220, B:115:0x0227, B:116:0x0104, B:118:0x0085, B:120:0x00a1, B:121:0x00c7, B:124:0x0228, B:125:0x0240), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ea A[Catch: IOException -> 0x0241, TryCatch #1 {IOException -> 0x0241, blocks: (B:3:0x000f, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:20:0x00cc, B:22:0x00d5, B:23:0x00dc, B:26:0x00e5, B:28:0x00ea, B:30:0x00f2, B:31:0x0107, B:46:0x0127, B:97:0x01d7, B:99:0x01e2, B:101:0x01f3, B:104:0x01fb, B:106:0x0209, B:107:0x0213, B:108:0x0216, B:109:0x020e, B:114:0x0220, B:115:0x0227, B:116:0x0104, B:118:0x0085, B:120:0x00a1, B:121:0x00c7, B:124:0x0228, B:125:0x0240), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e2 A[Catch: IOException -> 0x0241, TryCatch #1 {IOException -> 0x0241, blocks: (B:3:0x000f, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:20:0x00cc, B:22:0x00d5, B:23:0x00dc, B:26:0x00e5, B:28:0x00ea, B:30:0x00f2, B:31:0x0107, B:46:0x0127, B:97:0x01d7, B:99:0x01e2, B:101:0x01f3, B:104:0x01fb, B:106:0x0209, B:107:0x0213, B:108:0x0216, B:109:0x020e, B:114:0x0220, B:115:0x0227, B:116:0x0104, B:118:0x0085, B:120:0x00a1, B:121:0x00c7, B:124:0x0228, B:125:0x0240), top: B:2:0x000f }] */
    @Override // com.google.android.gms.internal.ads.zzrv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long a(zzry zzryVar) throws zzsb {
        long j2;
        int responseCode;
        String headerField;
        this.f12972i = zzryVar;
        this.p = 0L;
        this.o = 0L;
        try {
            URL url = new URL(zzryVar.a.toString());
            byte[] bArr = zzryVar.f16684b;
            long j3 = zzryVar.f16686d;
            long j4 = zzryVar.f16687e;
            boolean a2 = zzryVar.a(1);
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 <= 20) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    if (httpURLConnection instanceof HttpsURLConnection) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f12966c);
                    }
                    httpURLConnection.setConnectTimeout(this.f12967d);
                    httpURLConnection.setReadTimeout(this.f12968e);
                    for (Map.Entry<String, String> entry : this.f12970g.a().entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    if (j3 == 0 && j4 == -1) {
                        j2 = j3;
                        httpURLConnection.setRequestProperty("User-Agent", this.f12969f);
                        if (!a2) {
                            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                        }
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setDoOutput(bArr == null);
                        if (bArr != null) {
                            httpURLConnection.setRequestMethod("POST");
                            if (bArr.length != 0) {
                                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                                httpURLConnection.connect();
                                OutputStream outputStream = httpURLConnection.getOutputStream();
                                outputStream.write(bArr);
                                outputStream.close();
                                responseCode = httpURLConnection.getResponseCode();
                                if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                                    break;
                                }
                                headerField = httpURLConnection.getHeaderField("Location");
                                httpURLConnection.disconnect();
                                if (headerField != null) {
                                    URL url2 = new URL(url, headerField);
                                    String protocol = url2.getProtocol();
                                    if (!BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equals(protocol) && !"http".equals(protocol)) {
                                        String valueOf = String.valueOf(protocol);
                                        throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
                                    }
                                    bArr = null;
                                    url = url2;
                                    i2 = i3;
                                    j3 = j2;
                                } else {
                                    throw new ProtocolException("Null location redirect");
                                }
                            }
                        }
                        httpURLConnection.connect();
                        responseCode = httpURLConnection.getResponseCode();
                        if (responseCode != 300) {
                            break;
                        }
                        headerField = httpURLConnection.getHeaderField("Location");
                        httpURLConnection.disconnect();
                        if (headerField != null) {
                        }
                    }
                    StringBuilder sb = new StringBuilder(27);
                    sb.append("bytes=");
                    sb.append(j3);
                    sb.append("-");
                    String sb2 = sb.toString();
                    if (j4 != -1) {
                        String valueOf2 = String.valueOf(sb2);
                        long j5 = (j3 + j4) - 1;
                        j2 = j3;
                        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 20);
                        sb3.append(valueOf2);
                        sb3.append(j5);
                        sb2 = sb3.toString();
                    } else {
                        j2 = j3;
                    }
                    httpURLConnection.setRequestProperty("Range", sb2);
                    httpURLConnection.setRequestProperty("User-Agent", this.f12969f);
                    if (!a2) {
                    }
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setDoOutput(bArr == null);
                    if (bArr != null) {
                    }
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 300) {
                    }
                    headerField = httpURLConnection.getHeaderField("Location");
                    httpURLConnection.disconnect();
                    if (headerField != null) {
                    }
                } else {
                    StringBuilder sb4 = new StringBuilder(31);
                    sb4.append("Too many redirects: ");
                    sb4.append(i3);
                    throw new NoRouteToHostException(sb4.toString());
                }
            }
        } catch (IOException e2) {
            String valueOf3 = String.valueOf(zzryVar.a.toString());
            throw new zzsb(valueOf3.length() != 0 ? "Unable to connect to ".concat(valueOf3) : new String("Unable to connect to "), e2, zzryVar, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i2) {
        this.q = i2;
        for (Socket socket : this.r) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.q);
                } catch (SocketException e2) {
                    zzbad.d("Failed to update receive buffer size.", e2);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0032, code lost:
    
        if (r3 > 2048) goto L21;
     */
    @Override // com.google.android.gms.internal.ads.zzrv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void close() throws zzsb {
        try {
            if (this.f12974k != null) {
                HttpURLConnection httpURLConnection = this.f12973j;
                long j2 = this.n;
                if (j2 != -1) {
                    j2 -= this.p;
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
                    this.f12974k.close();
                } catch (IOException e2) {
                    throw new zzsb(e2, this.f12972i, 3);
                }
            }
        } finally {
            this.f12974k = null;
            g();
            if (this.l) {
                this.l = false;
                zzsj<? super m9> zzsjVar = this.f12971h;
                if (zzsjVar != null) {
                    zzsjVar.d(this);
                }
            }
            this.r.clear();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i2, int i3) throws zzsb {
        try {
            if (this.o != this.m) {
                byte[] andSet = f12965b.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
                }
                while (true) {
                    long j2 = this.o;
                    long j3 = this.m;
                    if (j2 != j3) {
                        int read = this.f12974k.read(andSet, 0, (int) Math.min(j3 - j2, andSet.length));
                        if (Thread.interrupted()) {
                            throw new InterruptedIOException();
                        }
                        if (read != -1) {
                            this.o += read;
                            zzsj<? super m9> zzsjVar = this.f12971h;
                            if (zzsjVar != null) {
                                zzsjVar.o(this, read);
                            }
                        } else {
                            throw new EOFException();
                        }
                    } else {
                        f12965b.set(andSet);
                        break;
                    }
                }
            }
            if (i3 == 0) {
                return 0;
            }
            long j4 = this.n;
            if (j4 != -1) {
                long j5 = j4 - this.p;
                if (j5 == 0) {
                    return -1;
                }
                i3 = (int) Math.min(i3, j5);
            }
            int read2 = this.f12974k.read(bArr, i2, i3);
            if (read2 == -1) {
                if (this.n == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.p += read2;
            zzsj<? super m9> zzsjVar2 = this.f12971h;
            if (zzsjVar2 != null) {
                zzsjVar2.o(this, read2);
            }
            return read2;
        } catch (IOException e2) {
            throw new zzsb(e2, this.f12972i, 2);
        }
    }
}
