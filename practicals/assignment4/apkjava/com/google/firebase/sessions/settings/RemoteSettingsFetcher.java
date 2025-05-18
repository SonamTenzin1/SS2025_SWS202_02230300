package com.google.firebase.sessions.settings;

import android.net.Uri;
import cm.aptoide.pt.dataprovider.BuildConfig;
import com.google.firebase.sessions.ApplicationInfo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* compiled from: RemoteSettingsFetcher.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJm\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f2\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000e2\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettingsFetcher;", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "blockingDispatcher", "Lkotlin/coroutines/CoroutineContext;", "baseUrl", HttpUrl.FRAGMENT_ENCODE_SET, "(Lcom/google/firebase/sessions/ApplicationInfo;Lkotlin/coroutines/CoroutineContext;Ljava/lang/String;)V", "doConfigFetch", HttpUrl.FRAGMENT_ENCODE_SET, "headerOptions", HttpUrl.FRAGMENT_ENCODE_SET, "onSuccess", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, "onFailure", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settingsUrl", "Ljava/net/URL;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.google.firebase.sessions.m0.d, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class RemoteSettingsFetcher implements CrashlyticsSettingsFetcher {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final ApplicationInfo f20035b;

    /* renamed from: c, reason: collision with root package name */
    private final CoroutineContext f20036c;

    /* renamed from: d, reason: collision with root package name */
    private final String f20037d;

    /* compiled from: RemoteSettingsFetcher.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettingsFetcher$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "FIREBASE_PLATFORM", HttpUrl.FRAGMENT_ENCODE_SET, "FIREBASE_SESSIONS_BASE_URL_STRING", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.google.firebase.sessions.m0.d$a */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* compiled from: RemoteSettingsFetcher.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2", f = "RemoteSettingsFetcher.kt", l = {68, 70, 73}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.m0.d$b */
    /* loaded from: classes2.dex */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super u>, Object> {

        /* renamed from: f, reason: collision with root package name */
        int f20038f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f20040h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Function2<JSONObject, Continuation<? super u>, Object> f20041i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Function2<String, Continuation<? super u>, Object> f20042j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Map<String, String> map, Function2<? super JSONObject, ? super Continuation<? super u>, ? extends Object> function2, Function2<? super String, ? super Continuation<? super u>, ? extends Object> function22, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f20040h = map;
            this.f20041i = function2;
            this.f20042j = function22;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new b(this.f20040h, this.f20041i, this.f20042j, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super u> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object c2;
            c2 = d.c();
            int i2 = this.f20038f;
            try {
                if (i2 == 0) {
                    o.b(obj);
                    URLConnection openConnection = RemoteSettingsFetcher.this.c().openConnection();
                    m.d(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setRequestProperty("Accept", "application/json");
                    for (Map.Entry<String, String> entry : this.f20040h.entrySet()) {
                        httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        InputStream inputStream = httpsURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder sb = new StringBuilder();
                        f0 f0Var = new f0();
                        while (true) {
                            ?? readLine = bufferedReader.readLine();
                            f0Var.f22943f = readLine;
                            if (readLine == 0) {
                                break;
                            }
                            sb.append((String) readLine);
                        }
                        bufferedReader.close();
                        inputStream.close();
                        JSONObject jSONObject = new JSONObject(sb.toString());
                        Function2<JSONObject, Continuation<? super u>, Object> function2 = this.f20041i;
                        this.f20038f = 1;
                        if (function2.invoke(jSONObject, this) == c2) {
                            return c2;
                        }
                    } else {
                        Function2<String, Continuation<? super u>, Object> function22 = this.f20042j;
                        String str = "Bad response code: " + responseCode;
                        this.f20038f = 2;
                        if (function22.invoke(str, this) == c2) {
                            return c2;
                        }
                    }
                } else if (i2 == 1 || i2 == 2) {
                    o.b(obj);
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    o.b(obj);
                }
            } catch (Exception e2) {
                Function2<String, Continuation<? super u>, Object> function23 = this.f20042j;
                String message = e2.getMessage();
                if (message == null) {
                    message = e2.toString();
                }
                this.f20038f = 3;
                if (function23.invoke(message, this) == c2) {
                    return c2;
                }
            }
            return u.a;
        }
    }

    public RemoteSettingsFetcher(ApplicationInfo applicationInfo, CoroutineContext coroutineContext, String str) {
        m.f(applicationInfo, "appInfo");
        m.f(coroutineContext, "blockingDispatcher");
        m.f(str, "baseUrl");
        this.f20035b = applicationInfo;
        this.f20036c = coroutineContext;
        this.f20037d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URL c() {
        return new URL(new Uri.Builder().scheme(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME).authority(this.f20037d).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.f20035b.getAppId()).appendPath("settings").appendQueryParameter("build_version", this.f20035b.getAndroidAppInfo().getAppBuildVersion()).appendQueryParameter("display_version", this.f20035b.getAndroidAppInfo().getVersionName()).build().toString());
    }

    @Override // com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher
    public Object a(Map<String, String> map, Function2<? super JSONObject, ? super Continuation<? super u>, ? extends Object> function2, Function2<? super String, ? super Continuation<? super u>, ? extends Object> function22, Continuation<? super u> continuation) {
        Object c2;
        Object e2 = h.e(this.f20036c, new b(map, function2, function22, null), continuation);
        c2 = d.c();
        return e2 == c2 ? e2 : u.a;
    }

    public /* synthetic */ RemoteSettingsFetcher(ApplicationInfo applicationInfo, CoroutineContext coroutineContext, String str, int i2, g gVar) {
        this(applicationInfo, coroutineContext, (i2 & 4) != 0 ? "firebase-settings.crashlytics.com" : str);
    }
}
