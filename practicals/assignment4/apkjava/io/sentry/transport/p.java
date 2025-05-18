package io.sentry.transport;

import io.sentry.h4;
import io.sentry.p3;
import io.sentry.s4;
import io.sentry.w1;
import io.sentry.x4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpConnection.java */
/* loaded from: classes2.dex */
public final class p {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private final Proxy f22742b;

    /* renamed from: c, reason: collision with root package name */
    private final p3 f22743c;

    /* renamed from: d, reason: collision with root package name */
    private final x4 f22744d;

    /* renamed from: e, reason: collision with root package name */
    private final y f22745e;

    public p(x4 x4Var, p3 p3Var, y yVar) {
        this(x4Var, p3Var, n.a(), yVar);
    }

    private void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
        httpURLConnection.disconnect();
    }

    private HttpURLConnection b() throws IOException {
        HttpURLConnection e2 = e();
        for (Map.Entry<String, String> entry : this.f22743c.a().entrySet()) {
            e2.setRequestProperty(entry.getKey(), entry.getValue());
        }
        e2.setRequestMethod("POST");
        e2.setDoOutput(true);
        e2.setRequestProperty("Content-Encoding", "gzip");
        e2.setRequestProperty("Content-Type", "application/x-sentry-envelope");
        e2.setRequestProperty("Accept", "application/json");
        e2.setRequestProperty("Connection", "close");
        e2.setConnectTimeout(this.f22744d.getConnectionTimeoutMillis());
        e2.setReadTimeout(this.f22744d.getReadTimeoutMillis());
        HostnameVerifier hostnameVerifier = this.f22744d.getHostnameVerifier();
        boolean z = e2 instanceof HttpsURLConnection;
        if (z && hostnameVerifier != null) {
            ((HttpsURLConnection) e2).setHostnameVerifier(hostnameVerifier);
        }
        SSLSocketFactory sslSocketFactory = this.f22744d.getSslSocketFactory();
        if (z && sslSocketFactory != null) {
            ((HttpsURLConnection) e2).setSSLSocketFactory(sslSocketFactory);
        }
        e2.connect();
        return e2;
    }

    private String c(HttpURLConnection httpURLConnection) {
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, a));
                try {
                    StringBuilder sb = new StringBuilder();
                    boolean z = true;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (!z) {
                            sb.append("\n");
                        }
                        sb.append(readLine);
                        z = false;
                    }
                    String sb2 = sb.toString();
                    bufferedReader.close();
                    if (errorStream != null) {
                        errorStream.close();
                    }
                    return sb2;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (IOException unused3) {
            return "Failed to obtain error message while analyzing send failure.";
        }
    }

    private boolean d(int i2) {
        return i2 == 200;
    }

    private a0 f(HttpURLConnection httpURLConnection) {
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                i(httpURLConnection, responseCode);
                if (!d(responseCode)) {
                    w1 logger = this.f22744d.getLogger();
                    s4 s4Var = s4.ERROR;
                    logger.c(s4Var, "Request failed, API returned %s", Integer.valueOf(responseCode));
                    if (this.f22744d.isDebug()) {
                        this.f22744d.getLogger().c(s4Var, "%s", c(httpURLConnection));
                    }
                    return a0.b(responseCode);
                }
                this.f22744d.getLogger().c(s4.DEBUG, "Envelope sent successfully.", new Object[0]);
                return a0.e();
            } catch (IOException e2) {
                this.f22744d.getLogger().a(s4.ERROR, e2, "Error reading and logging the response stream", new Object[0]);
                a(httpURLConnection);
                return a0.a();
            }
        } finally {
            a(httpURLConnection);
        }
    }

    private Proxy g(x4.e eVar) {
        if (eVar != null) {
            String c2 = eVar.c();
            String a2 = eVar.a();
            if (c2 != null && a2 != null) {
                try {
                    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(a2, Integer.parseInt(c2)));
                } catch (NumberFormatException e2) {
                    this.f22744d.getLogger().a(s4.ERROR, e2, "Failed to parse Sentry Proxy port: " + eVar.c() + ". Proxy is ignored", new Object[0]);
                }
            }
        }
        return null;
    }

    HttpURLConnection e() throws IOException {
        URLConnection openConnection;
        if (this.f22742b == null) {
            openConnection = this.f22743c.b().openConnection();
        } else {
            openConnection = this.f22743c.b().openConnection(this.f22742b);
        }
        return (HttpURLConnection) openConnection;
    }

    public a0 h(h4 h4Var) throws IOException {
        OutputStream outputStream;
        GZIPOutputStream gZIPOutputStream;
        try {
            outputStream = b().getOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } finally {
            try {
            } finally {
            }
        }
        try {
            this.f22744d.getSerializer().b(h4Var, gZIPOutputStream);
            gZIPOutputStream.close();
            if (outputStream != null) {
                outputStream.close();
            }
            return f(r0);
        } catch (Throwable th2) {
            try {
                gZIPOutputStream.close();
            } catch (Throwable unused2) {
            }
            throw th2;
        }
    }

    public void i(HttpURLConnection httpURLConnection, int i2) {
        String headerField = httpURLConnection.getHeaderField("Retry-After");
        this.f22745e.i(httpURLConnection.getHeaderField("X-Sentry-Rate-Limits"), headerField, i2);
    }

    p(x4 x4Var, p3 p3Var, n nVar, y yVar) {
        this.f22743c = p3Var;
        this.f22744d = x4Var;
        this.f22745e = yVar;
        Proxy g2 = g(x4Var.getProxy());
        this.f22742b = g2;
        if (g2 == null || x4Var.getProxy() == null) {
            return;
        }
        String d2 = x4Var.getProxy().d();
        String b2 = x4Var.getProxy().b();
        if (d2 == null || b2 == null) {
            return;
        }
        nVar.b(new w(d2, b2));
    }
}
