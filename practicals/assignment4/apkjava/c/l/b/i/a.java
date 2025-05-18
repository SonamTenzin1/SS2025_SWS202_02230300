package c.l.b.i;

import c.l.b.i.d;
import cm.aptoide.pt.database.room.RoomNotification;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;

/* compiled from: Preferences.kt */
/* loaded from: classes.dex */
public final class a extends d {
    private final Map<d.a<?>, Object> a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f3326b;

    /* compiled from: Preferences.kt */
    /* renamed from: c.l.b.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0082a extends Lambda implements Function1<Map.Entry<d.a<?>, Object>, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final C0082a f3327f = new C0082a();

        C0082a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Map.Entry<d.a<?>, Object> entry) {
            m.f(entry, "entry");
            return "  " + entry.getKey().a() + " = " + entry.getValue();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ a(Map map, boolean z, int i2, kotlin.jvm.internal.g gVar) {
        this((i2 & 1) != 0 ? new LinkedHashMap() : map, (i2 & 2) != 0 ? true : z);
    }

    @Override // c.l.b.i.d
    public Map<d.a<?>, Object> a() {
        Map<d.a<?>, Object> unmodifiableMap = Collections.unmodifiableMap(this.a);
        m.e(unmodifiableMap, "unmodifiableMap(preferencesMap)");
        return unmodifiableMap;
    }

    @Override // c.l.b.i.d
    public <T> T b(d.a<T> aVar) {
        m.f(aVar, RoomNotification.KEY);
        return (T) this.a.get(aVar);
    }

    public final void e() {
        if (!(!this.f3326b.get())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return m.a(this.a, ((a) obj).a);
        }
        return false;
    }

    public final void f() {
        this.f3326b.set(true);
    }

    public final void g(d.b<?>... bVarArr) {
        m.f(bVarArr, "pairs");
        e();
        for (d.b<?> bVar : bVarArr) {
            j(bVar.a(), bVar.b());
        }
    }

    public final <T> T h(d.a<T> aVar) {
        m.f(aVar, RoomNotification.KEY);
        e();
        return (T) this.a.remove(aVar);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final <T> void i(d.a<T> aVar, T t) {
        m.f(aVar, RoomNotification.KEY);
        j(aVar, t);
    }

    public final void j(d.a<?> aVar, Object obj) {
        Set I0;
        m.f(aVar, RoomNotification.KEY);
        e();
        if (obj == null) {
            h(aVar);
            return;
        }
        if (!(obj instanceof Set)) {
            this.a.put(aVar, obj);
            return;
        }
        Map<d.a<?>, Object> map = this.a;
        I0 = c0.I0((Iterable) obj);
        Set unmodifiableSet = Collections.unmodifiableSet(I0);
        m.e(unmodifiableSet, "unmodifiableSet(value.toSet())");
        map.put(aVar, unmodifiableSet);
    }

    public String toString() {
        String e0;
        e0 = c0.e0(this.a.entrySet(), ",\n", "{\n", "\n}", 0, null, C0082a.f3327f, 24, null);
        return e0;
    }

    public a(Map<d.a<?>, Object> map, boolean z) {
        m.f(map, "preferencesMap");
        this.a = map;
        this.f3326b = new AtomicBoolean(z);
    }
}
