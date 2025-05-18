package com.google.firebase.sessions;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.p0;
import okhttp3.HttpUrl;

/* compiled from: SessionFirelogPublisher.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0019\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0011\u0010\u001a\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisherImpl;", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "firebaseInstallations", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "sessionSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "eventGDTLogger", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/settings/SessionsSettings;Lcom/google/firebase/sessions/EventGDTLoggerInterface;Lkotlin/coroutines/CoroutineContext;)V", "attemptLoggingSessionEvent", HttpUrl.FRAGMENT_ENCODE_SET, "sessionEvent", "Lcom/google/firebase/sessions/SessionEvent;", "getFirebaseInstallationId", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin.jvm.PlatformType", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logSession", "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "shouldCollectEvents", HttpUrl.FRAGMENT_ENCODE_SET, "shouldLogSession", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.google.firebase.sessions.c0, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class SessionFirelogPublisherImpl implements SessionFirelogPublisher {

    /* renamed from: b, reason: collision with root package name */
    public static final a f19911b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final double f19912c = Math.random();

    /* renamed from: d, reason: collision with root package name */
    private final com.google.firebase.j f19913d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.firebase.installations.i f19914e;

    /* renamed from: f, reason: collision with root package name */
    private final SessionsSettings f19915f;

    /* renamed from: g, reason: collision with root package name */
    private final EventGDTLoggerInterface f19916g;

    /* renamed from: h, reason: collision with root package name */
    private final CoroutineContext f19917h;

    /* compiled from: SessionFirelogPublisher.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisherImpl$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "TAG", HttpUrl.FRAGMENT_ENCODE_SET, "randomValueForSampling", HttpUrl.FRAGMENT_ENCODE_SET, "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.google.firebase.sessions.c0$a */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SessionFirelogPublisher.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", f = "SessionFirelogPublisher.kt", l = {111}, m = "getFirebaseInstallationId")
    /* renamed from: com.google.firebase.sessions.c0$b */
    /* loaded from: classes2.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f19918f;

        /* renamed from: h, reason: collision with root package name */
        int f19920h;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f19918f = obj;
            this.f19920h |= Integer.MIN_VALUE;
            return SessionFirelogPublisherImpl.this.h(this);
        }
    }

    /* compiled from: SessionFirelogPublisher.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", f = "SessionFirelogPublisher.kt", l = {64, 70, 71}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.c0$c */
    /* loaded from: classes2.dex */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kotlin.u>, Object> {

        /* renamed from: f, reason: collision with root package name */
        Object f19921f;

        /* renamed from: g, reason: collision with root package name */
        Object f19922g;

        /* renamed from: h, reason: collision with root package name */
        Object f19923h;

        /* renamed from: i, reason: collision with root package name */
        Object f19924i;

        /* renamed from: j, reason: collision with root package name */
        Object f19925j;

        /* renamed from: k, reason: collision with root package name */
        Object f19926k;
        int l;
        final /* synthetic */ SessionDetails n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SessionDetails sessionDetails, Continuation<? super c> continuation) {
            super(2, continuation);
            this.n = sessionDetails;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new c(this.n, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kotlin.u> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(kotlin.u.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00b2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00b3  */
        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object c2;
            com.google.firebase.j jVar;
            SessionFirelogPublisherImpl sessionFirelogPublisherImpl;
            SessionDetails sessionDetails;
            SessionEvents sessionEvents;
            SessionsSettings sessionsSettings;
            Object h2;
            SessionEvents sessionEvents2;
            Map<SessionSubscriber.a, ? extends SessionSubscriber> map;
            SessionDetails sessionDetails2;
            SessionsSettings sessionsSettings2;
            com.google.firebase.j jVar2;
            c2 = kotlin.coroutines.intrinsics.d.c();
            int i2 = this.l;
            if (i2 == 0) {
                kotlin.o.b(obj);
                SessionFirelogPublisherImpl sessionFirelogPublisherImpl2 = SessionFirelogPublisherImpl.this;
                this.l = 1;
                obj = sessionFirelogPublisherImpl2.j(this);
                if (obj == c2) {
                    return c2;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            Map<SessionSubscriber.a, ? extends SessionSubscriber> map2 = (Map) this.f19926k;
                            SessionsSettings sessionsSettings3 = (SessionsSettings) this.f19925j;
                            sessionDetails2 = (SessionDetails) this.f19924i;
                            com.google.firebase.j jVar3 = (com.google.firebase.j) this.f19923h;
                            SessionEvents sessionEvents3 = (SessionEvents) this.f19922g;
                            SessionFirelogPublisherImpl sessionFirelogPublisherImpl3 = (SessionFirelogPublisherImpl) this.f19921f;
                            kotlin.o.b(obj);
                            sessionFirelogPublisherImpl = sessionFirelogPublisherImpl3;
                            map = map2;
                            sessionEvents2 = sessionEvents3;
                            sessionsSettings2 = sessionsSettings3;
                            jVar2 = jVar3;
                            kotlin.jvm.internal.m.e(obj, "getFirebaseInstallationId()");
                            sessionFirelogPublisherImpl.g(sessionEvents2.a(jVar2, sessionDetails2, sessionsSettings2, map, (String) obj));
                            return kotlin.u.a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sessionsSettings = (SessionsSettings) this.f19925j;
                    sessionDetails = (SessionDetails) this.f19924i;
                    jVar = (com.google.firebase.j) this.f19923h;
                    sessionEvents = (SessionEvents) this.f19922g;
                    sessionFirelogPublisherImpl = (SessionFirelogPublisherImpl) this.f19921f;
                    kotlin.o.b(obj);
                    Map<SessionSubscriber.a, ? extends SessionSubscriber> map3 = (Map) obj;
                    SessionFirelogPublisherImpl sessionFirelogPublisherImpl4 = SessionFirelogPublisherImpl.this;
                    this.f19921f = sessionFirelogPublisherImpl;
                    this.f19922g = sessionEvents;
                    this.f19923h = jVar;
                    this.f19924i = sessionDetails;
                    this.f19925j = sessionsSettings;
                    this.f19926k = map3;
                    this.l = 3;
                    h2 = sessionFirelogPublisherImpl4.h(this);
                    if (h2 != c2) {
                        return c2;
                    }
                    sessionEvents2 = sessionEvents;
                    com.google.firebase.j jVar4 = jVar;
                    map = map3;
                    obj = h2;
                    sessionDetails2 = sessionDetails;
                    sessionsSettings2 = sessionsSettings;
                    jVar2 = jVar4;
                    kotlin.jvm.internal.m.e(obj, "getFirebaseInstallationId()");
                    sessionFirelogPublisherImpl.g(sessionEvents2.a(jVar2, sessionDetails2, sessionsSettings2, map, (String) obj));
                    return kotlin.u.a;
                }
                kotlin.o.b(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                SessionFirelogPublisherImpl sessionFirelogPublisherImpl5 = SessionFirelogPublisherImpl.this;
                SessionEvents sessionEvents4 = SessionEvents.a;
                jVar = sessionFirelogPublisherImpl5.f19913d;
                SessionDetails sessionDetails3 = this.n;
                SessionsSettings sessionsSettings4 = SessionFirelogPublisherImpl.this.f19915f;
                FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.a;
                this.f19921f = sessionFirelogPublisherImpl5;
                this.f19922g = sessionEvents4;
                this.f19923h = jVar;
                this.f19924i = sessionDetails3;
                this.f19925j = sessionsSettings4;
                this.l = 2;
                Object c3 = firebaseSessionsDependencies.c(this);
                if (c3 == c2) {
                    return c2;
                }
                sessionFirelogPublisherImpl = sessionFirelogPublisherImpl5;
                obj = c3;
                sessionDetails = sessionDetails3;
                sessionEvents = sessionEvents4;
                sessionsSettings = sessionsSettings4;
                Map<SessionSubscriber.a, ? extends SessionSubscriber> map32 = (Map) obj;
                SessionFirelogPublisherImpl sessionFirelogPublisherImpl42 = SessionFirelogPublisherImpl.this;
                this.f19921f = sessionFirelogPublisherImpl;
                this.f19922g = sessionEvents;
                this.f19923h = jVar;
                this.f19924i = sessionDetails;
                this.f19925j = sessionsSettings;
                this.f19926k = map32;
                this.l = 3;
                h2 = sessionFirelogPublisherImpl42.h(this);
                if (h2 != c2) {
                }
            }
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SessionFirelogPublisher.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", f = "SessionFirelogPublisher.kt", l = {93}, m = "shouldLogSession")
    /* renamed from: com.google.firebase.sessions.c0$d */
    /* loaded from: classes2.dex */
    public static final class d extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f19927f;

        /* renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f19928g;

        /* renamed from: i, reason: collision with root package name */
        int f19930i;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f19928g = obj;
            this.f19930i |= Integer.MIN_VALUE;
            return SessionFirelogPublisherImpl.this.j(this);
        }
    }

    public SessionFirelogPublisherImpl(com.google.firebase.j jVar, com.google.firebase.installations.i iVar, SessionsSettings sessionsSettings, EventGDTLoggerInterface eventGDTLoggerInterface, CoroutineContext coroutineContext) {
        kotlin.jvm.internal.m.f(jVar, "firebaseApp");
        kotlin.jvm.internal.m.f(iVar, "firebaseInstallations");
        kotlin.jvm.internal.m.f(sessionsSettings, "sessionSettings");
        kotlin.jvm.internal.m.f(eventGDTLoggerInterface, "eventGDTLogger");
        kotlin.jvm.internal.m.f(coroutineContext, "backgroundDispatcher");
        this.f19913d = jVar;
        this.f19914e = iVar;
        this.f19915f = sessionsSettings;
        this.f19916g = eventGDTLoggerInterface;
        this.f19917h = coroutineContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(SessionEvent sessionEvent) {
        try {
            this.f19916g.a(sessionEvent);
            Log.d("SessionFirelogPublisher", "Successfully logged Session Start event: " + sessionEvent.getSessionData().getSessionId());
        } catch (RuntimeException e2) {
            Log.e("SessionFirelogPublisher", "Error logging Session Start event to DataTransport: ", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Continuation<? super String> continuation) {
        b bVar;
        Object c2;
        int i2;
        try {
            if (continuation instanceof b) {
                bVar = (b) continuation;
                int i3 = bVar.f19920h;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    bVar.f19920h = i3 - Integer.MIN_VALUE;
                    Object obj = bVar.f19918f;
                    c2 = kotlin.coroutines.intrinsics.d.c();
                    i2 = bVar.f19920h;
                    if (i2 != 0) {
                        kotlin.o.b(obj);
                        Task<String> id = this.f19914e.getId();
                        kotlin.jvm.internal.m.e(id, "firebaseInstallations.id");
                        bVar.f19920h = 1;
                        obj = kotlinx.coroutines.tasks.b.a(id, bVar);
                        if (obj == c2) {
                            return c2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.o.b(obj);
                    }
                    return (String) obj;
                }
            }
            if (i2 != 0) {
            }
            return (String) obj;
        } catch (Exception e2) {
            Log.e("SessionFirelogPublisher", "Error getting Firebase Installation ID. Using an empty ID", e2);
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        bVar = new b(continuation);
        Object obj2 = bVar.f19918f;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = bVar.f19920h;
    }

    private final boolean i() {
        return f19912c <= this.f19915f.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(Continuation<? super Boolean> continuation) {
        d dVar;
        Object c2;
        int i2;
        SessionFirelogPublisherImpl sessionFirelogPublisherImpl;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i3 = dVar.f19930i;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                dVar.f19930i = i3 - Integer.MIN_VALUE;
                Object obj = dVar.f19928g;
                c2 = kotlin.coroutines.intrinsics.d.c();
                i2 = dVar.f19930i;
                if (i2 != 0) {
                    kotlin.o.b(obj);
                    Log.d("SessionFirelogPublisher", "Data Collection is enabled for at least one Subscriber");
                    SessionsSettings sessionsSettings = this.f19915f;
                    dVar.f19927f = this;
                    dVar.f19930i = 1;
                    if (sessionsSettings.g(dVar) == c2) {
                        return c2;
                    }
                    sessionFirelogPublisherImpl = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sessionFirelogPublisherImpl = (SessionFirelogPublisherImpl) dVar.f19927f;
                    kotlin.o.b(obj);
                }
                if (sessionFirelogPublisherImpl.f19915f.d()) {
                    Log.d("SessionFirelogPublisher", "Sessions SDK disabled. Events will not be sent.");
                    return kotlin.coroutines.j.internal.b.a(false);
                }
                if (!sessionFirelogPublisherImpl.i()) {
                    Log.d("SessionFirelogPublisher", "Sessions SDK has dropped this session due to sampling.");
                    return kotlin.coroutines.j.internal.b.a(false);
                }
                return kotlin.coroutines.j.internal.b.a(true);
            }
        }
        dVar = new d(continuation);
        Object obj2 = dVar.f19928g;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = dVar.f19930i;
        if (i2 != 0) {
        }
        if (sessionFirelogPublisherImpl.f19915f.d()) {
        }
    }

    @Override // com.google.firebase.sessions.SessionFirelogPublisher
    public void a(SessionDetails sessionDetails) {
        kotlin.jvm.internal.m.f(sessionDetails, "sessionDetails");
        kotlinx.coroutines.j.b(p0.a(this.f19917h), null, null, new c(sessionDetails, null), 3, null);
    }
}
