package com.facebook.internal.v0;

import android.util.Base64;
import android.util.Log;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.database.room.RoomNotification;
import cm.aptoide.pt.dataprovider.BuildConfig;
import com.facebook.a0;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.io.g;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.m;
import kotlin.text.Charsets;
import kotlin.text.u;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* compiled from: OidcSecurityUtil.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final c a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final String f9908b = "/.well-known/oauth/openid/keys/";

    private c() {
    }

    public static final PublicKey a(String str) {
        String A;
        String A2;
        String A3;
        m.f(str, RoomNotification.KEY);
        A = u.A(str, "\n", HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null);
        A2 = u.A(A, "-----BEGIN PUBLIC KEY-----", HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null);
        A3 = u.A(A2, "-----END PUBLIC KEY-----", HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null);
        byte[] decode = Base64.decode(A3, 0);
        m.e(decode, "decode(pubKeyString, Base64.DEFAULT)");
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode));
        m.e(generatePublic, "kf.generatePublic(x509publicKey)");
        return generatePublic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String b(final String str) {
        m.f(str, "kid");
        a0 a0Var = a0.a;
        final URL url = new URL(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME, m.n("www.", a0.l()), f9908b);
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final f0 f0Var = new f0();
        a0.k().execute(new Runnable() { // from class: com.facebook.internal.v0.a
            @Override // java.lang.Runnable
            public final void run() {
                c.c(url, f0Var, str, reentrantLock, newCondition);
            }
        });
        reentrantLock.lock();
        try {
            newCondition.await(5000L, TimeUnit.MILLISECONDS);
            reentrantLock.unlock();
            return (String) f0Var.f22943f;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
    public static final void c(URL url, f0 f0Var, String str, ReentrantLock reentrantLock, Condition condition) {
        m.f(url, "$openIdKeyUrl");
        m.f(f0Var, "$result");
        m.f(str, "$kid");
        m.f(reentrantLock, "$lock");
        URLConnection openConnection = url.openConnection();
        if (openConnection != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            try {
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    m.e(inputStream, "connection.inputStream");
                    Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.f25054b);
                    String c2 = g.c(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
                    httpURLConnection.getInputStream().close();
                    f0Var.f22943f = new JSONObject(c2).optString(str);
                    httpURLConnection.disconnect();
                    reentrantLock.lock();
                    try {
                        condition.signal();
                        kotlin.u uVar = kotlin.u.a;
                    } finally {
                    }
                } catch (Exception e2) {
                    String name = a.getClass().getName();
                    String message = e2.getMessage();
                    if (message == null) {
                        message = "Error getting public key";
                    }
                    Log.d(name, message);
                    httpURLConnection.disconnect();
                    reentrantLock.lock();
                    try {
                        condition.signal();
                        kotlin.u uVar2 = kotlin.u.a;
                    } finally {
                    }
                }
                return;
            } catch (Throwable th) {
                httpURLConnection.disconnect();
                reentrantLock.lock();
                try {
                    condition.signal();
                    kotlin.u uVar3 = kotlin.u.a;
                    throw th;
                } finally {
                }
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
    }

    public static final boolean e(PublicKey publicKey, String str, String str2) {
        m.f(publicKey, "publicKey");
        m.f(str, "data");
        m.f(str2, RoomInstalled.SIGNATURE);
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            byte[] bytes = str.getBytes(Charsets.f25054b);
            m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            signature.update(bytes);
            byte[] decode = Base64.decode(str2, 8);
            m.e(decode, "decode(signature, Base64.URL_SAFE)");
            return signature.verify(decode);
        } catch (Exception unused) {
            return false;
        }
    }
}
