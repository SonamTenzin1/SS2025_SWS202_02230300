package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.IOUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzciu implements zzczc<zzciv, zzciw> {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15276b;

    /* renamed from: c, reason: collision with root package name */
    private final zzasm f15277c;

    /* renamed from: d, reason: collision with root package name */
    private final String f15278d;

    public zzciu(Context context, String str, zzasm zzasmVar, String str2) {
        this.a = context;
        this.f15276b = str;
        this.f15277c = zzasmVar;
        this.f15278d = str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x020f, code lost:
    
        r2 = new java.lang.StringBuilder(46);
        r2.append("Received error HTTP response code: ");
        r2.append(r10);
        com.google.android.gms.internal.ads.zzbad.i(r2.toString());
        r4 = new java.lang.StringBuilder(46);
        r4.append("Received error HTTP response code: ");
        r4.append(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0237, code lost:
    
        throw new com.google.android.gms.internal.ads.zzcif(r4.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzciw b(String str, zzasd zzasdVar, JSONObject jSONObject, String str2) throws zzcif {
        byte[] bArr;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        BufferedOutputStream bufferedOutputStream;
        String str3 = "doritos_v2";
        String str4 = "doritos";
        String str5 = HttpUrl.FRAGMENT_ENCODE_SET;
        try {
            zzciw zzciwVar = new zzciw();
            String valueOf = String.valueOf(this.f15276b);
            zzbad.h(valueOf.length() != 0 ? "SDK version: ".concat(valueOf) : new String("SDK version: "));
            String valueOf2 = String.valueOf(str);
            zzbad.e(valueOf2.length() != 0 ? "AdRequestServiceImpl: Sending request: ".concat(valueOf2) : new String("AdRequestServiceImpl: Sending request: "));
            URL url = new URL(str);
            HashMap hashMap = new HashMap();
            long b2 = zzk.zzln().b();
            boolean z = false;
            int i2 = 0;
            while (true) {
                this.f15277c.b();
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    zzk.zzlg().m(this.a, this.f15276b, z, httpURLConnection);
                    if (!TextUtils.isEmpty(str2)) {
                        httpURLConnection.addRequestProperty("Cookie", str2);
                    }
                    if (zzasdVar.d()) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("pii");
                        if (optJSONObject != null) {
                            if (!TextUtils.isEmpty(optJSONObject.optString(str4, str5))) {
                                httpURLConnection.addRequestProperty("x-afma-drt-cookie", optJSONObject.optString(str4, str5));
                            }
                            if (!TextUtils.isEmpty(optJSONObject.optString(str3, str5))) {
                                httpURLConnection.addRequestProperty("x-afma-drt-v2-cookie", optJSONObject.optString(str3, str5));
                            }
                        } else {
                            zzawz.m("DSID signal does not exist.");
                        }
                    }
                    if (TextUtils.isEmpty(zzasdVar.c())) {
                        bArr = null;
                    } else {
                        httpURLConnection.setDoOutput(true);
                        bArr = zzasdVar.c().getBytes();
                        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            try {
                                bufferedOutputStream.write(bArr);
                                IOUtils.a(bufferedOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                IOUtils.a(bufferedOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream = null;
                        }
                    }
                    zzazx zzazxVar = new zzazx();
                    zzazxVar.i(httpURLConnection, bArr);
                    int responseCode = httpURLConnection.getResponseCode();
                    for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                        String str6 = str3;
                        String key = entry.getKey();
                        String str7 = str4;
                        List<String> value = entry.getValue();
                        if (hashMap.containsKey(key)) {
                            ((List) hashMap.get(key)).addAll(value);
                        } else {
                            hashMap.put(key, new ArrayList(value));
                            str5 = str5;
                        }
                        str4 = str7;
                        str3 = str6;
                    }
                    String str8 = str3;
                    String str9 = str4;
                    String str10 = str5;
                    zzazxVar.h(httpURLConnection, responseCode);
                    if (responseCode >= 200 && responseCode < 300) {
                        try {
                            inputStreamReader2 = new InputStreamReader(httpURLConnection.getInputStream());
                        } catch (Throwable th3) {
                            th = th3;
                            inputStreamReader = null;
                        }
                        try {
                            zzk.zzlg();
                            String f2 = zzaxi.f(inputStreamReader2);
                            IOUtils.a(inputStreamReader2);
                            zzazxVar.p(f2);
                            zzciwVar.a = responseCode;
                            zzciwVar.f15281c = f2;
                            zzciwVar.f15280b = hashMap;
                            if (TextUtils.isEmpty(f2)) {
                                if (!((Boolean) zzyt.e().c(zzacu.r4)).booleanValue()) {
                                    throw new zzcif("No Fill", 3);
                                }
                            }
                            zzciwVar.f15282d = zzk.zzln().b() - b2;
                            return zzciwVar;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStreamReader = inputStreamReader2;
                            IOUtils.a(inputStreamReader);
                            throw th;
                        }
                    }
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (!TextUtils.isEmpty(headerField)) {
                        URL url2 = new URL(headerField);
                        i2++;
                        if (i2 > ((Integer) zzyt.e().c(zzacu.a4)).intValue()) {
                            zzbad.i("Too many redirects.");
                            throw new zzcif("Too many redirects");
                        }
                        url = url2;
                        str5 = str10;
                        str4 = str9;
                        str3 = str8;
                        z = false;
                    } else {
                        zzbad.i("No location header to follow redirect.");
                        throw new zzcif("No location header to follow redirect");
                    }
                } finally {
                    httpURLConnection.disconnect();
                    this.f15277c.a();
                }
            }
        } catch (IOException e2) {
            String valueOf3 = String.valueOf(e2.getMessage());
            zzbad.i(valueOf3.length() != 0 ? "Error while connecting to ad server: ".concat(valueOf3) : new String("Error while connecting to ad server: "));
            String valueOf4 = String.valueOf(e2.getMessage());
            throw new zzcif(valueOf4.length() != 0 ? "Error connecting to ad server:".concat(valueOf4) : new String("Error connecting to ad server:"), 2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final /* synthetic */ zzciw a(zzciv zzcivVar) throws Exception {
        zzasd zzasdVar;
        zzasd zzasdVar2;
        JSONObject jSONObject;
        zzciv zzcivVar2 = zzcivVar;
        zzasdVar = zzcivVar2.f15279b;
        String a = zzasdVar.a();
        zzasdVar2 = zzcivVar2.f15279b;
        jSONObject = zzcivVar2.a;
        return b(a, zzasdVar2, jSONObject, this.f15278d);
    }
}
