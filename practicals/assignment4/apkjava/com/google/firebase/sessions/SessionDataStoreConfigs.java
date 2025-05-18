package com.google.firebase.sessions;

import android.util.Base64;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* compiled from: SessionDataStoreConfigs.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/google/firebase/sessions/SessionDataStoreConfigs;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "PROCESS_NAME", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin.jvm.PlatformType", "SESSIONS_CONFIG_NAME", "getSESSIONS_CONFIG_NAME", "()Ljava/lang/String;", "SETTINGS_CONFIG_NAME", "getSETTINGS_CONFIG_NAME", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.google.firebase.sessions.v, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class SessionDataStoreConfigs {
    public static final SessionDataStoreConfigs a = new SessionDataStoreConfigs();

    /* renamed from: b, reason: collision with root package name */
    private static final String f20092b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f20093c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f20094d;

    static {
        byte[] n;
        n = kotlin.text.u.n(ProcessDetailsProvider.a.e());
        String encodeToString = Base64.encodeToString(n, 10);
        f20092b = encodeToString;
        f20093c = "firebase_session_" + encodeToString + "_data";
        f20094d = "firebase_session_" + encodeToString + "_settings";
    }

    private SessionDataStoreConfigs() {
    }

    public final String a() {
        return f20093c;
    }

    public final String b() {
        return f20094d;
    }
}
