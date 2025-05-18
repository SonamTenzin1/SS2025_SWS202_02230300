package com.google.firebase.sessions.settings;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.e;
import c.l.b.i.d;
import com.google.firebase.Firebase;
import com.google.firebase.installations.i;
import com.google.firebase.j;
import com.google.firebase.l;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.ProcessDetailsProvider;
import com.google.firebase.sessions.SessionDataStoreConfigs;
import com.google.firebase.sessions.SessionEvents;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.u;
import okhttp3.HttpUrl;

/* compiled from: SessionsSettings.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B/\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB'\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000eB\u0015\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001d\u0010 \u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u00020$H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00188Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Lcom/google/firebase/sessions/settings/SessionsSettings;", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Landroid/content/Context;", "blockingDispatcher", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;)V", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "(Lcom/google/firebase/FirebaseApp;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;)V", "localOverrideSettings", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "remoteSettings", "(Lcom/google/firebase/sessions/settings/SettingsProvider;Lcom/google/firebase/sessions/settings/SettingsProvider;)V", "samplingRate", HttpUrl.FRAGMENT_ENCODE_SET, "getSamplingRate", "()D", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-UwyO8pc", "()J", "sessionsEnabled", HttpUrl.FRAGMENT_ENCODE_SET, "getSessionsEnabled", "()Z", "isValidSamplingRate", "isValidSessionRestartTimeout", "isValidSessionRestartTimeout-LRDsOJo", "(J)Z", "updateSettings", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.google.firebase.sessions.m0.f, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class SessionsSettings {
    public static final b a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final ReadOnlyProperty<Context, e<d>> f20047b = c.l.b.a.b(SessionDataStoreConfigs.a.b(), new androidx.datastore.core.o.b(a.f20050f), null, null, 12, null);

    /* renamed from: c, reason: collision with root package name */
    private final SettingsProvider f20048c;

    /* renamed from: d, reason: collision with root package name */
    private final SettingsProvider f20049d;

    /* compiled from: SessionsSettings.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "ex", "Landroidx/datastore/core/CorruptionException;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.google.firebase.sessions.m0.f$a */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function1<CorruptionException, d> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f20050f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final d invoke(CorruptionException corruptionException) {
            m.f(corruptionException, "ex");
            Log.w("SessionsSettings", "CorruptionException in settings DataStore in " + ProcessDetailsProvider.a.e() + '.', corruptionException);
            return c.l.b.i.e.a();
        }
    }

    /* compiled from: SessionsSettings.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/sessions/settings/SessionsSettings$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "TAG", HttpUrl.FRAGMENT_ENCODE_SET, "instance", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "getInstance", "()Lcom/google/firebase/sessions/settings/SessionsSettings;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "dataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.google.firebase.sessions.m0.f$b */
    /* loaded from: classes2.dex */
    public static final class b {
        static final /* synthetic */ KProperty<Object>[] a = {g0.i(new a0(b.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final e<d> b(Context context) {
            return (e) SessionsSettings.f20047b.a(context, a[0]);
        }

        public final SessionsSettings c() {
            Object h2 = l.a(Firebase.a).h(SessionsSettings.class);
            m.e(h2, "Firebase.app[SessionsSettings::class.java]");
            return (SessionsSettings) h2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SessionsSettings.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SessionsSettings", f = "SessionsSettings.kt", l = {138, 139}, m = "updateSettings")
    /* renamed from: com.google.firebase.sessions.m0.f$c */
    /* loaded from: classes2.dex */
    public static final class c extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f20051f;

        /* renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f20052g;

        /* renamed from: i, reason: collision with root package name */
        int f20054i;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f20052g = obj;
            this.f20054i |= Integer.MIN_VALUE;
            return SessionsSettings.this.g(this);
        }
    }

    public SessionsSettings(SettingsProvider settingsProvider, SettingsProvider settingsProvider2) {
        m.f(settingsProvider, "localOverrideSettings");
        m.f(settingsProvider2, "remoteSettings");
        this.f20048c = settingsProvider;
        this.f20049d = settingsProvider2;
    }

    private final boolean e(double d2) {
        return 0.0d <= d2 && d2 <= 1.0d;
    }

    private final boolean f(long j2) {
        return Duration.T(j2) && Duration.O(j2);
    }

    public final double b() {
        Double c2 = this.f20048c.c();
        if (c2 != null) {
            double doubleValue = c2.doubleValue();
            if (e(doubleValue)) {
                return doubleValue;
            }
        }
        Double c3 = this.f20049d.c();
        if (c3 == null) {
            return 1.0d;
        }
        double doubleValue2 = c3.doubleValue();
        if (e(doubleValue2)) {
            return doubleValue2;
        }
        return 1.0d;
    }

    public final long c() {
        Duration b2 = this.f20048c.b();
        if (b2 != null) {
            long f25094j = b2.getF25094j();
            if (f(f25094j)) {
                return f25094j;
            }
        }
        Duration b3 = this.f20049d.b();
        if (b3 != null) {
            long f25094j2 = b3.getF25094j();
            if (f(f25094j2)) {
                return f25094j2;
            }
        }
        Duration.a aVar = Duration.f25090f;
        return kotlin.time.c.h(30, DurationUnit.MINUTES);
    }

    public final boolean d() {
        Boolean a2 = this.f20048c.a();
        if (a2 != null) {
            return a2.booleanValue();
        }
        Boolean a3 = this.f20049d.a();
        if (a3 != null) {
            return a3.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(Continuation<? super u> continuation) {
        c cVar;
        Object c2;
        int i2;
        SessionsSettings sessionsSettings;
        SettingsProvider settingsProvider;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i3 = cVar.f20054i;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                cVar.f20054i = i3 - Integer.MIN_VALUE;
                Object obj = cVar.f20052g;
                c2 = kotlin.coroutines.intrinsics.d.c();
                i2 = cVar.f20054i;
                if (i2 != 0) {
                    o.b(obj);
                    SettingsProvider settingsProvider2 = this.f20048c;
                    cVar.f20051f = this;
                    cVar.f20054i = 1;
                    if (settingsProvider2.d(cVar) == c2) {
                        return c2;
                    }
                    sessionsSettings = this;
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        o.b(obj);
                        return u.a;
                    }
                    sessionsSettings = (SessionsSettings) cVar.f20051f;
                    o.b(obj);
                }
                settingsProvider = sessionsSettings.f20049d;
                cVar.f20051f = null;
                cVar.f20054i = 2;
                if (settingsProvider.d(cVar) == c2) {
                    return c2;
                }
                return u.a;
            }
        }
        cVar = new c(continuation);
        Object obj2 = cVar.f20052g;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = cVar.f20054i;
        if (i2 != 0) {
        }
        settingsProvider = sessionsSettings.f20049d;
        cVar.f20051f = null;
        cVar.f20054i = 2;
        if (settingsProvider.d(cVar) == c2) {
        }
        return u.a;
    }

    private SessionsSettings(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, i iVar, ApplicationInfo applicationInfo) {
        this(new LocalOverrideSettings(context), new RemoteSettings(coroutineContext2, iVar, applicationInfo, new RemoteSettingsFetcher(applicationInfo, coroutineContext, null, 4, null), a.b(context)));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SessionsSettings(j jVar, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, i iVar) {
        this(r2, coroutineContext, coroutineContext2, iVar, SessionEvents.a.b(jVar));
        m.f(jVar, "firebaseApp");
        m.f(coroutineContext, "blockingDispatcher");
        m.f(coroutineContext2, "backgroundDispatcher");
        m.f(iVar, "firebaseInstallationsApi");
        Context i2 = jVar.i();
        m.e(i2, "firebaseApp.applicationContext");
    }
}
