package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.p0;
import okhttp3.HttpUrl;

/* compiled from: FirebaseSessions.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions;", HttpUrl.FRAGMENT_ENCODE_SET, "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "settings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/sessions/settings/SessionsSettings;Lkotlin/coroutines/CoroutineContext;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.google.firebase.sessions.q, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class FirebaseSessions {
    public static final b a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private final com.google.firebase.j f20078b;

    /* renamed from: c, reason: collision with root package name */
    private final SessionsSettings f20079c;

    /* compiled from: FirebaseSessions.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", l = {44, 48}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.q$a */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kotlin.u>, Object> {

        /* renamed from: f, reason: collision with root package name */
        int f20080f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ CoroutineContext f20082h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(CoroutineContext coroutineContext, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f20082h = coroutineContext;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new a(this.f20082h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kotlin.u> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(kotlin.u.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0079  */
        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object c2;
            c2 = kotlin.coroutines.intrinsics.d.c();
            int i2 = this.f20080f;
            boolean z = true;
            if (i2 == 0) {
                kotlin.o.b(obj);
                FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.a;
                this.f20080f = 1;
                obj = firebaseSessionsDependencies.c(this);
                if (obj == c2) {
                    return c2;
                }
            } else {
                if (i2 != 1) {
                    if (i2 == 2) {
                        kotlin.o.b(obj);
                        if (FirebaseSessions.this.f20079c.d()) {
                            Log.d("FirebaseSessions", "Sessions SDK disabled. Not listening to lifecycle events.");
                        } else {
                            SessionLifecycleClient sessionLifecycleClient = new SessionLifecycleClient(this.f20082h);
                            sessionLifecycleClient.i();
                            SessionsActivityLifecycleCallbacks.f19960f.a(sessionLifecycleClient);
                            FirebaseSessions.this.f20078b.f(new com.google.firebase.k() { // from class: com.google.firebase.sessions.b
                            });
                        }
                        return kotlin.u.a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            Collection values = ((Map) obj).values();
            if (!(values instanceof Collection) || !values.isEmpty()) {
                Iterator it = values.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((SessionSubscriber) it.next()).a()) {
                        z = false;
                        break;
                    }
                }
            }
            if (!z) {
                SessionsSettings sessionsSettings = FirebaseSessions.this.f20079c;
                this.f20080f = 2;
                if (sessionsSettings.g(this) == c2) {
                    return c2;
                }
                if (FirebaseSessions.this.f20079c.d()) {
                }
                return kotlin.u.a;
            }
            Log.d("FirebaseSessions", "No Sessions subscribers. Not listening to lifecycle events.");
            return kotlin.u.a;
        }
    }

    /* compiled from: FirebaseSessions.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "TAG", HttpUrl.FRAGMENT_ENCODE_SET, "instance", "Lcom/google/firebase/sessions/FirebaseSessions;", "getInstance", "()Lcom/google/firebase/sessions/FirebaseSessions;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.google.firebase.sessions.q$b */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public FirebaseSessions(com.google.firebase.j jVar, SessionsSettings sessionsSettings, CoroutineContext coroutineContext) {
        kotlin.jvm.internal.m.f(jVar, "firebaseApp");
        kotlin.jvm.internal.m.f(sessionsSettings, "settings");
        kotlin.jvm.internal.m.f(coroutineContext, "backgroundDispatcher");
        this.f20078b = jVar;
        this.f20079c = sessionsSettings;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions SDK.");
        Context applicationContext = jVar.i().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(SessionsActivityLifecycleCallbacks.f19960f);
            kotlinx.coroutines.j.b(p0.a(coroutineContext), null, null, new a(coroutineContext, null), 3, null);
            return;
        }
        Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
    }
}
