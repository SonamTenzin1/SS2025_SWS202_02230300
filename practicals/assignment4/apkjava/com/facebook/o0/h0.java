package com.facebook.o0;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: PersistedEvents.kt */
/* loaded from: classes.dex */
public final class h0 implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final a f10129f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private final HashMap<t, List<v>> f10130g;

    /* compiled from: PersistedEvents.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* compiled from: PersistedEvents.kt */
    /* loaded from: classes.dex */
    public static final class b implements Serializable {

        /* renamed from: f, reason: collision with root package name */
        public static final a f10131f = new a(null);

        /* renamed from: g, reason: collision with root package name */
        private final HashMap<t, List<v>> f10132g;

        /* compiled from: PersistedEvents.kt */
        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public b(HashMap<t, List<v>> hashMap) {
            kotlin.jvm.internal.m.f(hashMap, "proxyEvents");
            this.f10132g = hashMap;
        }

        private final Object readResolve() throws ObjectStreamException {
            return new h0(this.f10132g);
        }
    }

    public h0() {
        this.f10130g = new HashMap<>();
    }

    private final Object writeReplace() throws ObjectStreamException {
        return new b(this.f10130g);
    }

    public final void a(t tVar, List<v> list) {
        List<v> G0;
        kotlin.jvm.internal.m.f(tVar, "accessTokenAppIdPair");
        kotlin.jvm.internal.m.f(list, "appEvents");
        if (!this.f10130g.containsKey(tVar)) {
            HashMap<t, List<v>> hashMap = this.f10130g;
            G0 = kotlin.collections.c0.G0(list);
            hashMap.put(tVar, G0);
        } else {
            List<v> list2 = this.f10130g.get(tVar);
            if (list2 == null) {
                return;
            }
            list2.addAll(list);
        }
    }

    public final Set<Map.Entry<t, List<v>>> b() {
        Set<Map.Entry<t, List<v>>> entrySet = this.f10130g.entrySet();
        kotlin.jvm.internal.m.e(entrySet, "events.entries");
        return entrySet;
    }

    public h0(HashMap<t, List<v>> hashMap) {
        kotlin.jvm.internal.m.f(hashMap, "appEventMap");
        HashMap<t, List<v>> hashMap2 = new HashMap<>();
        this.f10130g = hashMap2;
        hashMap2.putAll(hashMap);
    }
}
