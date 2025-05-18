package com.google.firebase.sessions;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* compiled from: SessionEvents.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/google/firebase/sessions/SessionEvents;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "SESSION_EVENT_ENCODER", "Lcom/google/firebase/encoders/DataEncoder;", "getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions", "()Lcom/google/firebase/encoders/DataEncoder;", "buildSession", "Lcom/google/firebase/sessions/SessionEvent;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "sessionsSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "subscribers", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/google/firebase/sessions/api/SessionSubscriber$Name;", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "firebaseInstallationId", HttpUrl.FRAGMENT_ENCODE_SET, "getApplicationInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "toDataCollectionState", "Lcom/google/firebase/sessions/DataCollectionState;", "subscriber", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.google.firebase.sessions.a0, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class SessionEvents {
    public static final SessionEvents a = new SessionEvents();

    /* renamed from: b, reason: collision with root package name */
    private static final com.google.firebase.encoders.a f19910b;

    static {
        com.google.firebase.encoders.a f2 = new com.google.firebase.encoders.json.d().g(k.a).h(true).f();
        kotlin.jvm.internal.m.e(f2, "JsonDataEncoderBuilder()…lues(true)\n      .build()");
        f19910b = f2;
    }

    private SessionEvents() {
    }

    private final DataCollectionState d(SessionSubscriber sessionSubscriber) {
        if (sessionSubscriber == null) {
            return DataCollectionState.COLLECTION_SDK_NOT_INSTALLED;
        }
        if (sessionSubscriber.a()) {
            return DataCollectionState.COLLECTION_ENABLED;
        }
        return DataCollectionState.COLLECTION_DISABLED;
    }

    public final SessionEvent a(com.google.firebase.j jVar, SessionDetails sessionDetails, SessionsSettings sessionsSettings, Map<SessionSubscriber.a, ? extends SessionSubscriber> map, String str) {
        kotlin.jvm.internal.m.f(jVar, "firebaseApp");
        kotlin.jvm.internal.m.f(sessionDetails, "sessionDetails");
        kotlin.jvm.internal.m.f(sessionsSettings, "sessionsSettings");
        kotlin.jvm.internal.m.f(map, "subscribers");
        kotlin.jvm.internal.m.f(str, "firebaseInstallationId");
        return new SessionEvent(EventType.SESSION_START, new SessionInfo(sessionDetails.getSessionId(), sessionDetails.getFirstSessionId(), sessionDetails.getSessionIndex(), sessionDetails.getSessionStartTimestampUs(), new DataCollectionStatus(d(map.get(SessionSubscriber.a.PERFORMANCE)), d(map.get(SessionSubscriber.a.CRASHLYTICS)), sessionsSettings.b()), str), b(jVar));
    }

    public final ApplicationInfo b(com.google.firebase.j jVar) {
        String valueOf;
        kotlin.jvm.internal.m.f(jVar, "firebaseApp");
        Context i2 = jVar.i();
        kotlin.jvm.internal.m.e(i2, "firebaseApp.applicationContext");
        String packageName = i2.getPackageName();
        PackageInfo packageInfo = i2.getPackageManager().getPackageInfo(packageName, 0);
        if (Build.VERSION.SDK_INT >= 28) {
            valueOf = String.valueOf(packageInfo.getLongVersionCode());
        } else {
            valueOf = String.valueOf(packageInfo.versionCode);
        }
        String str = valueOf;
        String c2 = jVar.l().c();
        kotlin.jvm.internal.m.e(c2, "firebaseApp.options.applicationId");
        String str2 = Build.MODEL;
        kotlin.jvm.internal.m.e(str2, "MODEL");
        String str3 = Build.VERSION.RELEASE;
        kotlin.jvm.internal.m.e(str3, "RELEASE");
        LogEnvironment logEnvironment = LogEnvironment.LOG_ENVIRONMENT_PROD;
        kotlin.jvm.internal.m.e(packageName, "packageName");
        String str4 = packageInfo.versionName;
        String str5 = str4 == null ? str : str4;
        String str6 = Build.MANUFACTURER;
        kotlin.jvm.internal.m.e(str6, "MANUFACTURER");
        ProcessDetailsProvider processDetailsProvider = ProcessDetailsProvider.a;
        Context i3 = jVar.i();
        kotlin.jvm.internal.m.e(i3, "firebaseApp.applicationContext");
        ProcessDetails d2 = processDetailsProvider.d(i3);
        Context i4 = jVar.i();
        kotlin.jvm.internal.m.e(i4, "firebaseApp.applicationContext");
        return new ApplicationInfo(c2, str2, "1.2.1", str3, logEnvironment, new AndroidApplicationInfo(packageName, str5, str, str6, d2, processDetailsProvider.c(i4)));
    }

    public final com.google.firebase.encoders.a c() {
        return f19910b;
    }
}
