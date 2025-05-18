package com.google.firebase.sessions.api;

import android.util.Log;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.p0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.d;
import okhttp3.HttpUrl;

/* compiled from: FirebaseSessionsDependencies.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u001f\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\nH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\u0014J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0010H\u0007J\r\u0010\u0017\u001a\u00020\fH\u0001¢\u0006\u0002\b\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000RN\u0010\u0005\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\t0\t \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\t0\t\u0018\u00010\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "TAG", HttpUrl.FRAGMENT_ENCODE_SET, "dependencies", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/google/firebase/sessions/api/SessionSubscriber$Name;", "kotlin.jvm.PlatformType", "Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", HttpUrl.FRAGMENT_ENCODE_SET, "addDependency", HttpUrl.FRAGMENT_ENCODE_SET, "subscriberName", "getDependency", "getRegisteredSubscribers", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "getRegisteredSubscribers$com_google_firebase_firebase_sessions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscriber", "getSubscriber$com_google_firebase_firebase_sessions", "register", "subscriber", "reset", "reset$com_google_firebase_firebase_sessions", "Dependency", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.google.firebase.sessions.l0.a, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class FirebaseSessionsDependencies {
    public static final FirebaseSessionsDependencies a = new FirebaseSessionsDependencies();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<SessionSubscriber.a, Dependency> f20002b = Collections.synchronizedMap(new LinkedHashMap());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FirebaseSessionsDependencies.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", HttpUrl.FRAGMENT_ENCODE_SET, "mutex", "Lkotlinx/coroutines/sync/Mutex;", "subscriber", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "(Lkotlinx/coroutines/sync/Mutex;Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "getSubscriber", "()Lcom/google/firebase/sessions/api/SessionSubscriber;", "setSubscriber", "(Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "component1", "component2", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.google.firebase.sessions.l0.a$a, reason: from toString */
    /* loaded from: classes2.dex */
    public static final /* data */ class Dependency {

        /* renamed from: a, reason: from toString */
        private final Mutex mutex;

        /* renamed from: b, reason: collision with root package name and from toString */
        private SessionSubscriber subscriber;

        public Dependency(Mutex mutex, SessionSubscriber sessionSubscriber) {
            m.f(mutex, "mutex");
            this.mutex = mutex;
            this.subscriber = sessionSubscriber;
        }

        /* renamed from: a, reason: from getter */
        public final Mutex getMutex() {
            return this.mutex;
        }

        /* renamed from: b, reason: from getter */
        public final SessionSubscriber getSubscriber() {
            return this.subscriber;
        }

        public final void c(SessionSubscriber sessionSubscriber) {
            this.subscriber = sessionSubscriber;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dependency)) {
                return false;
            }
            Dependency dependency = (Dependency) other;
            return m.a(this.mutex, dependency.mutex) && m.a(this.subscriber, dependency.subscriber);
        }

        public int hashCode() {
            int hashCode = this.mutex.hashCode() * 31;
            SessionSubscriber sessionSubscriber = this.subscriber;
            return hashCode + (sessionSubscriber == null ? 0 : sessionSubscriber.hashCode());
        }

        public String toString() {
            return "Dependency(mutex=" + this.mutex + ", subscriber=" + this.subscriber + ')';
        }

        public /* synthetic */ Dependency(Mutex mutex, SessionSubscriber sessionSubscriber, int i2, g gVar) {
            this(mutex, (i2 & 2) != 0 ? null : sessionSubscriber);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FirebaseSessionsDependencies.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.api.FirebaseSessionsDependencies", f = "FirebaseSessionsDependencies.kt", l = {124}, m = "getRegisteredSubscribers$com_google_firebase_firebase_sessions")
    /* renamed from: com.google.firebase.sessions.l0.a$b */
    /* loaded from: classes2.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f20004f;

        /* renamed from: g, reason: collision with root package name */
        Object f20005g;

        /* renamed from: h, reason: collision with root package name */
        Object f20006h;

        /* renamed from: i, reason: collision with root package name */
        Object f20007i;

        /* renamed from: j, reason: collision with root package name */
        Object f20008j;

        /* renamed from: k, reason: collision with root package name */
        Object f20009k;
        /* synthetic */ Object l;
        int n;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.l = obj;
            this.n |= Integer.MIN_VALUE;
            return FirebaseSessionsDependencies.this.c(this);
        }
    }

    private FirebaseSessionsDependencies() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(SessionSubscriber.a aVar) {
        m.f(aVar, "subscriberName");
        if (aVar != SessionSubscriber.a.PERFORMANCE) {
            Map<SessionSubscriber.a, Dependency> map = f20002b;
            if (map.containsKey(aVar)) {
                Log.d("SessionsDependencies", "Dependency " + aVar + " already added.");
                return;
            }
            m.e(map, "dependencies");
            map.put(aVar, new Dependency(d.a(true), null, 2, 0 == true ? 1 : 0));
            Log.d("SessionsDependencies", "Dependency to " + aVar + " added.");
            return;
        }
        throw new IllegalArgumentException("Incompatible versions of Firebase Perf and Firebase Sessions.\nA safe combination would be:\n  firebase-sessions:1.1.0\n  firebase-crashlytics:18.5.0\n  firebase-perf:20.5.0\nFor more information contact Firebase Support.");
    }

    private final Dependency b(SessionSubscriber.a aVar) {
        Map<SessionSubscriber.a, Dependency> map = f20002b;
        m.e(map, "dependencies");
        Dependency dependency = map.get(aVar);
        if (dependency != null) {
            m.e(dependency, "dependencies.getOrElse(s…load time.\"\n      )\n    }");
            return dependency;
        }
        throw new IllegalStateException("Cannot get dependency " + aVar + ". Dependencies should be added at class load time.");
    }

    public static final void e(SessionSubscriber sessionSubscriber) {
        m.f(sessionSubscriber, "subscriber");
        SessionSubscriber.a b2 = sessionSubscriber.b();
        Dependency b3 = a.b(b2);
        if (b3.getSubscriber() != null) {
            Log.d("SessionsDependencies", "Subscriber " + b2 + " already registered.");
            return;
        }
        b3.c(sessionSubscriber);
        Log.d("SessionsDependencies", "Subscriber " + b2 + " registered.");
        Mutex.a.a(b3.getMutex(), null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x009f -> B:10:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(Continuation<? super Map<SessionSubscriber.a, ? extends SessionSubscriber>> continuation) {
        b bVar;
        Object c2;
        int i2;
        int e2;
        Iterator it;
        Map map;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i3 = bVar.n;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                bVar.n = i3 - Integer.MIN_VALUE;
                Object obj = bVar.l;
                c2 = kotlin.coroutines.intrinsics.d.c();
                i2 = bVar.n;
                if (i2 != 0) {
                    o.b(obj);
                    Map<SessionSubscriber.a, Dependency> map2 = f20002b;
                    m.e(map2, "dependencies");
                    e2 = p0.e(map2.size());
                    LinkedHashMap linkedHashMap = new LinkedHashMap(e2);
                    it = map2.entrySet().iterator();
                    map = linkedHashMap;
                    if (it.hasNext()) {
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object key = bVar.f20009k;
                    map = (Map) bVar.f20008j;
                    Mutex mutex = (Mutex) bVar.f20007i;
                    SessionSubscriber.a aVar = (SessionSubscriber.a) bVar.f20006h;
                    it = (Iterator) bVar.f20005g;
                    Map map3 = (Map) bVar.f20004f;
                    o.b(obj);
                    try {
                        SessionSubscriber d2 = a.d(aVar);
                        mutex.c(null);
                        map.put(key, d2);
                        map = map3;
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            key = entry.getKey();
                            aVar = (SessionSubscriber.a) entry.getKey();
                            mutex = ((Dependency) entry.getValue()).getMutex();
                            bVar.f20004f = map;
                            bVar.f20005g = it;
                            bVar.f20006h = aVar;
                            bVar.f20007i = mutex;
                            bVar.f20008j = map;
                            bVar.f20009k = key;
                            bVar.n = 1;
                            if (mutex.b(null, bVar) == c2) {
                                return c2;
                            }
                            map3 = map;
                            SessionSubscriber d22 = a.d(aVar);
                            mutex.c(null);
                            map.put(key, d22);
                            map = map3;
                            if (it.hasNext()) {
                                return map;
                            }
                        }
                    } catch (Throwable th) {
                        mutex.c(null);
                        throw th;
                    }
                }
            }
        }
        bVar = new b(continuation);
        Object obj2 = bVar.l;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = bVar.n;
        if (i2 != 0) {
        }
    }

    public final SessionSubscriber d(SessionSubscriber.a aVar) {
        m.f(aVar, "subscriberName");
        SessionSubscriber subscriber = b(aVar).getSubscriber();
        if (subscriber != null) {
            return subscriber;
        }
        throw new IllegalStateException("Subscriber " + aVar + " has not been registered.");
    }
}
