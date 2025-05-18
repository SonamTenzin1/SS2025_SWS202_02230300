package com.google.firebase.sessions;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.HttpUrl;

/* compiled from: FirebaseSessionsRegistrar.kt */
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a0\u0012,\u0012*\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/google/firebase/components/Component;", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin.jvm.PlatformType", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {

    @Deprecated
    private static final String LIBRARY_NAME = "fire-sessions";
    private static final a Companion = new a(null);

    @Deprecated
    private static final com.google.firebase.components.b0<com.google.firebase.j> firebaseApp = com.google.firebase.components.b0.b(com.google.firebase.j.class);

    @Deprecated
    private static final com.google.firebase.components.b0<com.google.firebase.installations.i> firebaseInstallationsApi = com.google.firebase.components.b0.b(com.google.firebase.installations.i.class);

    @Deprecated
    private static final com.google.firebase.components.b0<CoroutineDispatcher> backgroundDispatcher = com.google.firebase.components.b0.a(com.google.firebase.o.a.a.class, CoroutineDispatcher.class);

    @Deprecated
    private static final com.google.firebase.components.b0<CoroutineDispatcher> blockingDispatcher = com.google.firebase.components.b0.a(com.google.firebase.o.a.b.class, CoroutineDispatcher.class);

    @Deprecated
    private static final com.google.firebase.components.b0<e.e.b.a.g> transportFactory = com.google.firebase.components.b0.b(e.e.b.a.g.class);

    @Deprecated
    private static final com.google.firebase.components.b0<SessionsSettings> sessionsSettings = com.google.firebase.components.b0.b(SessionsSettings.class);

    /* compiled from: FirebaseSessionsRegistrar.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000b0\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000f0\u000f \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0010\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00110\u0011 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "LIBRARY_NAME", HttpUrl.FRAGMENT_ENCODE_SET, "backgroundDispatcher", "Lcom/google/firebase/components/Qualified;", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlin.jvm.PlatformType", "blockingDispatcher", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "sessionsSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "transportFactory", "Lcom/google/android/datatransport/TransportFactory;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes2.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-0, reason: not valid java name */
    public static final FirebaseSessions m365getComponents$lambda0(com.google.firebase.components.p pVar) {
        Object f2 = pVar.f(firebaseApp);
        kotlin.jvm.internal.m.e(f2, "container[firebaseApp]");
        Object f3 = pVar.f(sessionsSettings);
        kotlin.jvm.internal.m.e(f3, "container[sessionsSettings]");
        Object f4 = pVar.f(backgroundDispatcher);
        kotlin.jvm.internal.m.e(f4, "container[backgroundDispatcher]");
        return new FirebaseSessions((com.google.firebase.j) f2, (SessionsSettings) f3, (CoroutineContext) f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-1, reason: not valid java name */
    public static final SessionGenerator m366getComponents$lambda1(com.google.firebase.components.p pVar) {
        return new SessionGenerator(WallClock.a, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-2, reason: not valid java name */
    public static final SessionFirelogPublisher m367getComponents$lambda2(com.google.firebase.components.p pVar) {
        Object f2 = pVar.f(firebaseApp);
        kotlin.jvm.internal.m.e(f2, "container[firebaseApp]");
        com.google.firebase.j jVar = (com.google.firebase.j) f2;
        Object f3 = pVar.f(firebaseInstallationsApi);
        kotlin.jvm.internal.m.e(f3, "container[firebaseInstallationsApi]");
        com.google.firebase.installations.i iVar = (com.google.firebase.installations.i) f3;
        Object f4 = pVar.f(sessionsSettings);
        kotlin.jvm.internal.m.e(f4, "container[sessionsSettings]");
        SessionsSettings sessionsSettings2 = (SessionsSettings) f4;
        com.google.firebase.s.b b2 = pVar.b(transportFactory);
        kotlin.jvm.internal.m.e(b2, "container.getProvider(transportFactory)");
        EventGDTLogger eventGDTLogger = new EventGDTLogger(b2);
        Object f5 = pVar.f(backgroundDispatcher);
        kotlin.jvm.internal.m.e(f5, "container[backgroundDispatcher]");
        return new SessionFirelogPublisherImpl(jVar, iVar, sessionsSettings2, eventGDTLogger, (CoroutineContext) f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-3, reason: not valid java name */
    public static final SessionsSettings m368getComponents$lambda3(com.google.firebase.components.p pVar) {
        Object f2 = pVar.f(firebaseApp);
        kotlin.jvm.internal.m.e(f2, "container[firebaseApp]");
        Object f3 = pVar.f(blockingDispatcher);
        kotlin.jvm.internal.m.e(f3, "container[blockingDispatcher]");
        Object f4 = pVar.f(backgroundDispatcher);
        kotlin.jvm.internal.m.e(f4, "container[backgroundDispatcher]");
        Object f5 = pVar.f(firebaseInstallationsApi);
        kotlin.jvm.internal.m.e(f5, "container[firebaseInstallationsApi]");
        return new SessionsSettings((com.google.firebase.j) f2, (CoroutineContext) f3, (CoroutineContext) f4, (com.google.firebase.installations.i) f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-4, reason: not valid java name */
    public static final SessionDatastore m369getComponents$lambda4(com.google.firebase.components.p pVar) {
        Context i2 = ((com.google.firebase.j) pVar.f(firebaseApp)).i();
        kotlin.jvm.internal.m.e(i2, "container[firebaseApp].applicationContext");
        Object f2 = pVar.f(backgroundDispatcher);
        kotlin.jvm.internal.m.e(f2, "container[backgroundDispatcher]");
        return new SessionDatastoreImpl(i2, (CoroutineContext) f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getComponents$lambda-5, reason: not valid java name */
    public static final SessionLifecycleServiceBinder m370getComponents$lambda5(com.google.firebase.components.p pVar) {
        Object f2 = pVar.f(firebaseApp);
        kotlin.jvm.internal.m.e(f2, "container[firebaseApp]");
        return new SessionLifecycleServiceBinderImpl((com.google.firebase.j) f2);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<com.google.firebase.components.n<? extends Object>> getComponents() {
        List<com.google.firebase.components.n<? extends Object>> m;
        n.b h2 = com.google.firebase.components.n.c(FirebaseSessions.class).h(LIBRARY_NAME);
        com.google.firebase.components.b0<com.google.firebase.j> b0Var = firebaseApp;
        n.b b2 = h2.b(com.google.firebase.components.v.j(b0Var));
        com.google.firebase.components.b0<SessionsSettings> b0Var2 = sessionsSettings;
        n.b b3 = b2.b(com.google.firebase.components.v.j(b0Var2));
        com.google.firebase.components.b0<CoroutineDispatcher> b0Var3 = backgroundDispatcher;
        n.b b4 = com.google.firebase.components.n.c(SessionFirelogPublisher.class).h("session-publisher").b(com.google.firebase.components.v.j(b0Var));
        com.google.firebase.components.b0<com.google.firebase.installations.i> b0Var4 = firebaseInstallationsApi;
        m = kotlin.collections.u.m(b3.b(com.google.firebase.components.v.j(b0Var3)).f(new com.google.firebase.components.r() { // from class: com.google.firebase.sessions.g
            @Override // com.google.firebase.components.r
            public final Object a(com.google.firebase.components.p pVar) {
                FirebaseSessions m365getComponents$lambda0;
                m365getComponents$lambda0 = FirebaseSessionsRegistrar.m365getComponents$lambda0(pVar);
                return m365getComponents$lambda0;
            }
        }).e().d(), com.google.firebase.components.n.c(SessionGenerator.class).h("session-generator").f(new com.google.firebase.components.r() { // from class: com.google.firebase.sessions.d
            @Override // com.google.firebase.components.r
            public final Object a(com.google.firebase.components.p pVar) {
                SessionGenerator m366getComponents$lambda1;
                m366getComponents$lambda1 = FirebaseSessionsRegistrar.m366getComponents$lambda1(pVar);
                return m366getComponents$lambda1;
            }
        }).d(), b4.b(com.google.firebase.components.v.j(b0Var4)).b(com.google.firebase.components.v.j(b0Var2)).b(com.google.firebase.components.v.l(transportFactory)).b(com.google.firebase.components.v.j(b0Var3)).f(new com.google.firebase.components.r() { // from class: com.google.firebase.sessions.f
            @Override // com.google.firebase.components.r
            public final Object a(com.google.firebase.components.p pVar) {
                SessionFirelogPublisher m367getComponents$lambda2;
                m367getComponents$lambda2 = FirebaseSessionsRegistrar.m367getComponents$lambda2(pVar);
                return m367getComponents$lambda2;
            }
        }).d(), com.google.firebase.components.n.c(SessionsSettings.class).h("sessions-settings").b(com.google.firebase.components.v.j(b0Var)).b(com.google.firebase.components.v.j(blockingDispatcher)).b(com.google.firebase.components.v.j(b0Var3)).b(com.google.firebase.components.v.j(b0Var4)).f(new com.google.firebase.components.r() { // from class: com.google.firebase.sessions.h
            @Override // com.google.firebase.components.r
            public final Object a(com.google.firebase.components.p pVar) {
                SessionsSettings m368getComponents$lambda3;
                m368getComponents$lambda3 = FirebaseSessionsRegistrar.m368getComponents$lambda3(pVar);
                return m368getComponents$lambda3;
            }
        }).d(), com.google.firebase.components.n.c(SessionDatastore.class).h("sessions-datastore").b(com.google.firebase.components.v.j(b0Var)).b(com.google.firebase.components.v.j(b0Var3)).f(new com.google.firebase.components.r() { // from class: com.google.firebase.sessions.e
            @Override // com.google.firebase.components.r
            public final Object a(com.google.firebase.components.p pVar) {
                SessionDatastore m369getComponents$lambda4;
                m369getComponents$lambda4 = FirebaseSessionsRegistrar.m369getComponents$lambda4(pVar);
                return m369getComponents$lambda4;
            }
        }).d(), com.google.firebase.components.n.c(SessionLifecycleServiceBinder.class).h("sessions-service-binder").b(com.google.firebase.components.v.j(b0Var)).f(new com.google.firebase.components.r() { // from class: com.google.firebase.sessions.c
            @Override // com.google.firebase.components.r
            public final Object a(com.google.firebase.components.p pVar) {
                SessionLifecycleServiceBinder m370getComponents$lambda5;
                m370getComponents$lambda5 = FirebaseSessionsRegistrar.m370getComponents$lambda5(pVar);
                return m370getComponents$lambda5;
            }
        }).d(), com.google.firebase.u.h.a(LIBRARY_NAME, "1.2.1"));
        return m;
    }
}
