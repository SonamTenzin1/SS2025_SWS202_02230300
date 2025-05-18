package com.google.firebase.sessions.settings;

import android.os.Build;
import android.util.Log;
import androidx.datastore.core.e;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.i;
import com.google.firebase.sessions.ApplicationInfo;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.q0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.s;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.u;
import kotlinx.coroutines.sync.Mutex;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RemoteSettings.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\r\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0015H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\u0011\u0010%\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "configsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "(Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Landroidx/datastore/core/DataStore;)V", "fetchInProgress", "Lkotlinx/coroutines/sync/Mutex;", "samplingRate", HttpUrl.FRAGMENT_ENCODE_SET, "getSamplingRate", "()Ljava/lang/Double;", "sessionEnabled", HttpUrl.FRAGMENT_ENCODE_SET, "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "settingsCache", "Lcom/google/firebase/sessions/settings/SettingsCache;", "clearCachedSettings", HttpUrl.FRAGMENT_ENCODE_SET, "clearCachedSettings$com_google_firebase_firebase_sessions", "isSettingsStale", "removeForwardSlashesIn", HttpUrl.FRAGMENT_ENCODE_SET, "s", "updateSettings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.google.firebase.sessions.m0.c, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class RemoteSettings implements SettingsProvider {
    private static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final CoroutineContext f20017b;

    /* renamed from: c, reason: collision with root package name */
    private final i f20018c;

    /* renamed from: d, reason: collision with root package name */
    private final ApplicationInfo f20019d;

    /* renamed from: e, reason: collision with root package name */
    private final CrashlyticsSettingsFetcher f20020e;

    /* renamed from: f, reason: collision with root package name */
    private final SettingsCache f20021f;

    /* renamed from: g, reason: collision with root package name */
    private final Mutex f20022g;

    /* compiled from: RemoteSettings.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "FORWARD_SLASH_STRING", HttpUrl.FRAGMENT_ENCODE_SET, "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.google.firebase.sessions.m0.c$a */
    /* loaded from: classes2.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteSettings.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", l = {170, 76, 94}, m = "updateSettings")
    /* renamed from: com.google.firebase.sessions.m0.c$b */
    /* loaded from: classes2.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f20023f;

        /* renamed from: g, reason: collision with root package name */
        Object f20024g;

        /* renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f20025h;

        /* renamed from: j, reason: collision with root package name */
        int f20027j;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f20025h = obj;
            this.f20027j |= Integer.MIN_VALUE;
            return RemoteSettings.this.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteSettings.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "it", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", l = {125, 128, 131, 133, 134, 136}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.m0.c$c */
    /* loaded from: classes2.dex */
    public static final class c extends SuspendLambda implements Function2<JSONObject, Continuation<? super u>, Object> {

        /* renamed from: f, reason: collision with root package name */
        Object f20028f;

        /* renamed from: g, reason: collision with root package name */
        Object f20029g;

        /* renamed from: h, reason: collision with root package name */
        int f20030h;

        /* renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f20031i;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(continuation);
            cVar.f20031i = obj;
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(JSONObject jSONObject, Continuation<? super u> continuation) {
            return ((c) create(jSONObject, continuation)).invokeSuspend(u.a);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x019f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00f4  */
        /* JADX WARN: Type inference failed for: r13v12, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Double] */
        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object c2;
            f0 f0Var;
            Boolean bool;
            f0 f0Var2;
            f0 f0Var3;
            f0 f0Var4;
            f0 f0Var5;
            Integer num;
            Double d2;
            Integer num2;
            u uVar;
            SettingsCache settingsCache;
            Long c3;
            c2 = kotlin.coroutines.intrinsics.d.c();
            switch (this.f20030h) {
                case 0:
                    o.b(obj);
                    JSONObject jSONObject = (JSONObject) this.f20031i;
                    Log.d("SessionConfigFetcher", "Fetched settings: " + jSONObject);
                    f0 f0Var6 = new f0();
                    f0Var = new f0();
                    f0 f0Var7 = new f0();
                    if (jSONObject.has("app_quality")) {
                        Object obj2 = jSONObject.get("app_quality");
                        m.d(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                        JSONObject jSONObject2 = (JSONObject) obj2;
                        try {
                            bool = jSONObject2.has("sessions_enabled") ? (Boolean) jSONObject2.get("sessions_enabled") : null;
                            try {
                                if (jSONObject2.has("sampling_rate")) {
                                    f0Var6.f22943f = (Double) jSONObject2.get("sampling_rate");
                                }
                                if (jSONObject2.has("session_timeout_seconds")) {
                                    f0Var.f22943f = (Integer) jSONObject2.get("session_timeout_seconds");
                                }
                                if (jSONObject2.has("cache_duration")) {
                                    f0Var7.f22943f = (Integer) jSONObject2.get("cache_duration");
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                Log.e("SessionConfigFetcher", "Error parsing the configs remotely fetched: ", e);
                                if (bool == null) {
                                }
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            bool = null;
                        }
                    } else {
                        bool = null;
                    }
                    if (bool == null) {
                        RemoteSettings remoteSettings = RemoteSettings.this;
                        bool.booleanValue();
                        SettingsCache settingsCache2 = remoteSettings.f20021f;
                        this.f20031i = f0Var6;
                        this.f20028f = f0Var;
                        this.f20029g = f0Var7;
                        this.f20030h = 1;
                        if (settingsCache2.n(bool, this) == c2) {
                            return c2;
                        }
                        f0Var4 = f0Var6;
                        f0Var5 = f0Var;
                        f0Var3 = f0Var7;
                        f0Var = f0Var5;
                        f0Var2 = f0Var4;
                        num = (Integer) f0Var.f22943f;
                        if (num != null) {
                            RemoteSettings remoteSettings2 = RemoteSettings.this;
                            num.intValue();
                            SettingsCache settingsCache3 = remoteSettings2.f20021f;
                            Integer num3 = (Integer) f0Var.f22943f;
                            this.f20031i = f0Var2;
                            this.f20028f = f0Var3;
                            this.f20029g = null;
                            this.f20030h = 2;
                            if (settingsCache3.m(num3, this) == c2) {
                                return c2;
                            }
                        }
                        d2 = (Double) f0Var2.f22943f;
                        if (d2 != null) {
                            RemoteSettings remoteSettings3 = RemoteSettings.this;
                            d2.doubleValue();
                            SettingsCache settingsCache4 = remoteSettings3.f20021f;
                            Double d3 = (Double) f0Var2.f22943f;
                            this.f20031i = f0Var3;
                            this.f20028f = null;
                            this.f20029g = null;
                            this.f20030h = 3;
                            if (settingsCache4.i(d3, this) == c2) {
                                return c2;
                            }
                        }
                        num2 = (Integer) f0Var3.f22943f;
                        if (num2 != null) {
                            RemoteSettings remoteSettings4 = RemoteSettings.this;
                            num2.intValue();
                            SettingsCache settingsCache5 = remoteSettings4.f20021f;
                            Integer num4 = (Integer) f0Var3.f22943f;
                            this.f20031i = null;
                            this.f20028f = null;
                            this.f20029g = null;
                            this.f20030h = 4;
                            if (settingsCache5.j(num4, this) == c2) {
                                return c2;
                            }
                            uVar = u.a;
                            if (uVar == null) {
                                SettingsCache settingsCache6 = RemoteSettings.this.f20021f;
                                Integer b2 = kotlin.coroutines.j.internal.b.b(86400);
                                this.f20031i = null;
                                this.f20028f = null;
                                this.f20029g = null;
                                this.f20030h = 5;
                                if (settingsCache6.j(b2, this) == c2) {
                                    return c2;
                                }
                            }
                            settingsCache = RemoteSettings.this.f20021f;
                            c3 = kotlin.coroutines.j.internal.b.c(System.currentTimeMillis());
                            this.f20031i = null;
                            this.f20028f = null;
                            this.f20029g = null;
                            this.f20030h = 6;
                            if (settingsCache.k(c3, this) == c2) {
                                return c2;
                            }
                            return u.a;
                        }
                        uVar = null;
                        if (uVar == null) {
                        }
                        settingsCache = RemoteSettings.this.f20021f;
                        c3 = kotlin.coroutines.j.internal.b.c(System.currentTimeMillis());
                        this.f20031i = null;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 6;
                        if (settingsCache.k(c3, this) == c2) {
                        }
                        return u.a;
                    }
                    f0Var2 = f0Var6;
                    f0Var3 = f0Var7;
                    num = (Integer) f0Var.f22943f;
                    if (num != null) {
                    }
                    d2 = (Double) f0Var2.f22943f;
                    if (d2 != null) {
                    }
                    num2 = (Integer) f0Var3.f22943f;
                    if (num2 != null) {
                    }
                case 1:
                    f0Var3 = (f0) this.f20029g;
                    f0Var5 = (f0) this.f20028f;
                    f0Var4 = (f0) this.f20031i;
                    o.b(obj);
                    f0Var = f0Var5;
                    f0Var2 = f0Var4;
                    num = (Integer) f0Var.f22943f;
                    if (num != null) {
                    }
                    d2 = (Double) f0Var2.f22943f;
                    if (d2 != null) {
                    }
                    num2 = (Integer) f0Var3.f22943f;
                    if (num2 != null) {
                    }
                    break;
                case 2:
                    f0Var3 = (f0) this.f20028f;
                    f0Var2 = (f0) this.f20031i;
                    o.b(obj);
                    d2 = (Double) f0Var2.f22943f;
                    if (d2 != null) {
                    }
                    num2 = (Integer) f0Var3.f22943f;
                    if (num2 != null) {
                    }
                    break;
                case 3:
                    f0Var3 = (f0) this.f20031i;
                    o.b(obj);
                    num2 = (Integer) f0Var3.f22943f;
                    if (num2 != null) {
                    }
                    break;
                case 4:
                    o.b(obj);
                    uVar = u.a;
                    if (uVar == null) {
                    }
                    settingsCache = RemoteSettings.this.f20021f;
                    c3 = kotlin.coroutines.j.internal.b.c(System.currentTimeMillis());
                    this.f20031i = null;
                    this.f20028f = null;
                    this.f20029g = null;
                    this.f20030h = 6;
                    if (settingsCache.k(c3, this) == c2) {
                    }
                    return u.a;
                case 5:
                    o.b(obj);
                    settingsCache = RemoteSettings.this.f20021f;
                    c3 = kotlin.coroutines.j.internal.b.c(System.currentTimeMillis());
                    this.f20031i = null;
                    this.f20028f = null;
                    this.f20029g = null;
                    this.f20030h = 6;
                    if (settingsCache.k(c3, this) == c2) {
                    }
                    return u.a;
                case 6:
                    o.b(obj);
                    return u.a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteSettings.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "msg", HttpUrl.FRAGMENT_ENCODE_SET}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2", f = "RemoteSettings.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.m0.c$d */
    /* loaded from: classes2.dex */
    public static final class d extends SuspendLambda implements Function2<String, Continuation<? super u>, Object> {

        /* renamed from: f, reason: collision with root package name */
        int f20033f;

        /* renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f20034g;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(continuation);
            dVar.f20034g = obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, Continuation<? super u> continuation) {
            return ((d) create(str, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.d.c();
            if (this.f20033f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o.b(obj);
            Log.e("SessionConfigFetcher", "Error failing to fetch the remote configs: " + ((String) this.f20034g));
            return u.a;
        }
    }

    public RemoteSettings(CoroutineContext coroutineContext, i iVar, ApplicationInfo applicationInfo, CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, e<c.l.b.i.d> eVar) {
        m.f(coroutineContext, "backgroundDispatcher");
        m.f(iVar, "firebaseInstallationsApi");
        m.f(applicationInfo, "appInfo");
        m.f(crashlyticsSettingsFetcher, "configsFetcher");
        m.f(eVar, "dataStore");
        this.f20017b = coroutineContext;
        this.f20018c = iVar;
        this.f20019d = applicationInfo;
        this.f20020e = crashlyticsSettingsFetcher;
        this.f20021f = new SettingsCache(eVar);
        this.f20022g = kotlinx.coroutines.sync.d.b(false, 1, null);
    }

    private final String f(String str) {
        return new Regex("/").c(str, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean a() {
        return this.f20021f.g();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Duration b() {
        Integer e2 = this.f20021f.e();
        if (e2 == null) {
            return null;
        }
        Duration.a aVar = Duration.f25090f;
        return Duration.k(kotlin.time.c.h(e2.intValue(), DurationUnit.SECONDS));
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double c() {
        return this.f20021f.f();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:26:0x004e, B:27:0x00b4, B:29:0x00b8, B:33:0x00c4, B:38:0x0089, B:40:0x0091, B:43:0x009c), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0091 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:26:0x004e, B:27:0x00b4, B:29:0x00b8, B:33:0x00c4, B:38:0x0089, B:40:0x0091, B:43:0x009c), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c A[Catch: all -> 0x0052, TRY_ENTER, TryCatch #0 {all -> 0x0052, blocks: (B:26:0x004e, B:27:0x00b4, B:29:0x00b8, B:33:0x00c4, B:38:0x0089, B:40:0x0091, B:43:0x009c), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object d(Continuation<? super u> continuation) {
        b bVar;
        Object c2;
        ?? r4;
        Mutex mutex;
        Mutex mutex2;
        RemoteSettings remoteSettings;
        String str;
        Map<String, String> l;
        try {
            if (continuation instanceof b) {
                bVar = (b) continuation;
                int i2 = bVar.f20027j;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    bVar.f20027j = i2 - Integer.MIN_VALUE;
                    Object obj = bVar.f20025h;
                    c2 = kotlin.coroutines.intrinsics.d.c();
                    r4 = bVar.f20027j;
                    if (r4 != 0) {
                        o.b(obj);
                        if (!this.f20022g.a() && !this.f20021f.d()) {
                            return u.a;
                        }
                        Mutex mutex3 = this.f20022g;
                        bVar.f20023f = this;
                        bVar.f20024g = mutex3;
                        bVar.f20027j = 1;
                        if (mutex3.b(null, bVar) == c2) {
                            return c2;
                        }
                        mutex2 = mutex3;
                        remoteSettings = this;
                    } else {
                        if (r4 != 1) {
                            if (r4 != 2) {
                                if (r4 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutex = (Mutex) bVar.f20023f;
                                try {
                                    o.b(obj);
                                    u uVar = u.a;
                                    mutex.c(null);
                                    return uVar;
                                } catch (Throwable th) {
                                    th = th;
                                    mutex.c(null);
                                    throw th;
                                }
                            }
                            mutex2 = (Mutex) bVar.f20024g;
                            remoteSettings = (RemoteSettings) bVar.f20023f;
                            o.b(obj);
                            str = (String) obj;
                            if (str != null) {
                                Log.w("SessionConfigFetcher", "Error getting Firebase Installation ID. Skipping this Session Event.");
                                u uVar2 = u.a;
                                mutex2.c(null);
                                return uVar2;
                            }
                            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                            String format = String.format("%s/%s", Arrays.copyOf(new Object[]{Build.MANUFACTURER, Build.MODEL}, 2));
                            m.e(format, "format(format, *args)");
                            String str2 = Build.VERSION.INCREMENTAL;
                            m.e(str2, "INCREMENTAL");
                            String str3 = Build.VERSION.RELEASE;
                            m.e(str3, "RELEASE");
                            l = q0.l(s.a("X-Crashlytics-Installation-ID", str), s.a("X-Crashlytics-Device-Model", remoteSettings.f(format)), s.a("X-Crashlytics-OS-Build-Version", remoteSettings.f(str2)), s.a("X-Crashlytics-OS-Display-Version", remoteSettings.f(str3)), s.a("X-Crashlytics-API-Client-Version", remoteSettings.f20019d.getSessionSdkVersion()));
                            Log.d("SessionConfigFetcher", "Fetching settings from server.");
                            CrashlyticsSettingsFetcher crashlyticsSettingsFetcher = remoteSettings.f20020e;
                            c cVar = new c(null);
                            d dVar = new d(null);
                            bVar.f20023f = mutex2;
                            bVar.f20024g = null;
                            bVar.f20027j = 3;
                            if (crashlyticsSettingsFetcher.a(l, cVar, dVar, bVar) == c2) {
                                return c2;
                            }
                            mutex = mutex2;
                            u uVar3 = u.a;
                            mutex.c(null);
                            return uVar3;
                        }
                        mutex2 = (Mutex) bVar.f20024g;
                        remoteSettings = (RemoteSettings) bVar.f20023f;
                        o.b(obj);
                    }
                    if (remoteSettings.f20021f.d()) {
                        Log.d("SessionConfigFetcher", "Remote settings cache not expired. Using cached values.");
                        u uVar4 = u.a;
                        mutex2.c(null);
                        return uVar4;
                    }
                    Task<String> id = remoteSettings.f20018c.getId();
                    m.e(id, "firebaseInstallationsApi.id");
                    bVar.f20023f = remoteSettings;
                    bVar.f20024g = mutex2;
                    bVar.f20027j = 2;
                    obj = kotlinx.coroutines.tasks.b.a(id, bVar);
                    if (obj == c2) {
                        return c2;
                    }
                    str = (String) obj;
                    if (str != null) {
                    }
                }
            }
            if (r4 != 0) {
            }
            if (remoteSettings.f20021f.d()) {
            }
        } catch (Throwable th2) {
            th = th2;
            mutex = r4;
        }
        bVar = new b(continuation);
        Object obj2 = bVar.f20025h;
        c2 = kotlin.coroutines.intrinsics.d.c();
        r4 = bVar.f20027j;
    }
}
