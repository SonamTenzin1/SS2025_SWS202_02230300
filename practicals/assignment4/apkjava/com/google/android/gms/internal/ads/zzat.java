package com.google.android.gms.internal.ads;

import cm.aptoide.pt.dataprovider.BuildConfig;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public final class zzat extends zzaj {
    private final zzav a;

    /* renamed from: b, reason: collision with root package name */
    private final SSLSocketFactory f14148b;

    public zzat() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream c(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static List<zzl> d(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new zzl(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    private static void e(HttpURLConnection httpURLConnection, zzr<?> zzrVar) throws IOException, zza {
        byte[] O = zzrVar.O();
        if (O != null) {
            httpURLConnection.setDoOutput(true);
            if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                httpURLConnection.setRequestProperty("Content-Type", "UTF-8".length() != 0 ? "application/x-www-form-urlencoded; charset=".concat("UTF-8") : new String("application/x-www-form-urlencoded; charset="));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(O);
            dataOutputStream.close();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x008a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d0 A[Catch: all -> 0x0125, TryCatch #1 {all -> 0x0125, blocks: (B:15:0x0068, B:16:0x0070, B:18:0x0076, B:20:0x0086, B:21:0x008a, B:22:0x008d, B:23:0x011f, B:24:0x0124, B:25:0x0091, B:26:0x009a, B:27:0x00a0, B:28:0x00a6, B:29:0x00ac, B:30:0x00b2, B:31:0x00bb, B:32:0x00c4, B:33:0x00c9, B:35:0x00d0, B:47:0x00ec, B:60:0x0117, B:61:0x011e), top: B:14:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0117 A[Catch: all -> 0x0125, TRY_ENTER, TryCatch #1 {all -> 0x0125, blocks: (B:15:0x0068, B:16:0x0070, B:18:0x0076, B:20:0x0086, B:21:0x008a, B:22:0x008d, B:23:0x011f, B:24:0x0124, B:25:0x0091, B:26:0x009a, B:27:0x00a0, B:28:0x00a6, B:29:0x00ac, B:30:0x00b2, B:31:0x00bb, B:32:0x00c4, B:33:0x00c9, B:35:0x00d0, B:47:0x00ec, B:60:0x0117, B:61:0x011e), top: B:14:0x0068 }] */
    @Override // com.google.android.gms.internal.ads.zzaj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzar b(zzr<?> zzrVar, Map<String, String> map) throws IOException, zza {
        int responseCode;
        String q = zzrVar.q();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(zzrVar.g());
        zzav zzavVar = this.a;
        if (zzavVar != null) {
            String a = zzavVar.a(q);
            if (a == null) {
                String valueOf = String.valueOf(q);
                throw new IOException(valueOf.length() != 0 ? "URL blocked by rewriter: ".concat(valueOf) : new String("URL blocked by rewriter: "));
            }
            q = a;
        }
        URL url = new URL(q);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int Q = zzrVar.Q();
        httpURLConnection.setConnectTimeout(Q);
        httpURLConnection.setReadTimeout(Q);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equals(url.getProtocol());
        try {
            for (String str : hashMap.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) hashMap.get(str));
            }
            switch (zzrVar.k()) {
                case -1:
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != -1) {
                        if (!((zzrVar.k() == 4 || (100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304) ? false : true)) {
                            zzar zzarVar = new zzar(responseCode, d(httpURLConnection.getHeaderFields()));
                            httpURLConnection.disconnect();
                            return zzarVar;
                        }
                        try {
                            return new zzar(responseCode, d(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new v3(httpURLConnection));
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            if (!z) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                    throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                case 0:
                    httpURLConnection.setRequestMethod("GET");
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != -1) {
                    }
                    break;
                case 1:
                    httpURLConnection.setRequestMethod("POST");
                    e(httpURLConnection, zzrVar);
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != -1) {
                    }
                    break;
                case 2:
                    httpURLConnection.setRequestMethod("PUT");
                    e(httpURLConnection, zzrVar);
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != -1) {
                    }
                    break;
                case 3:
                    httpURLConnection.setRequestMethod("DELETE");
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != -1) {
                    }
                    break;
                case 4:
                    httpURLConnection.setRequestMethod("HEAD");
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != -1) {
                    }
                    break;
                case 5:
                    httpURLConnection.setRequestMethod("OPTIONS");
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != -1) {
                    }
                    break;
                case 6:
                    httpURLConnection.setRequestMethod("TRACE");
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != -1) {
                    }
                    break;
                case 7:
                    httpURLConnection.setRequestMethod("PATCH");
                    e(httpURLConnection, zzrVar);
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != -1) {
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown method type.");
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private zzat(zzav zzavVar) {
        this(null, null);
    }

    private zzat(zzav zzavVar, SSLSocketFactory sSLSocketFactory) {
        this.a = null;
        this.f14148b = null;
    }
}
