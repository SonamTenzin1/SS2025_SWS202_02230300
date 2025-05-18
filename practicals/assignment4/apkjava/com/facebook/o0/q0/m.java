package com.facebook.o0.q0;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.a0;
import java.util.UUID;

/* compiled from: SessionInfo.kt */
/* loaded from: classes2.dex */
public final class m {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Long f10430b;

    /* renamed from: c, reason: collision with root package name */
    private Long f10431c;

    /* renamed from: d, reason: collision with root package name */
    private UUID f10432d;

    /* renamed from: e, reason: collision with root package name */
    private int f10433e;

    /* renamed from: f, reason: collision with root package name */
    private Long f10434f;

    /* renamed from: g, reason: collision with root package name */
    private o f10435g;

    /* compiled from: SessionInfo.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final void a() {
            a0 a0Var = a0.a;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(a0.c()).edit();
            edit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
            edit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
            edit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
            edit.remove("com.facebook.appevents.SessionInfo.sessionId");
            edit.apply();
            o.a.a();
        }

        public final m b() {
            a0 a0Var = a0.a;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a0.c());
            long j2 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0L);
            long j3 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0L);
            String string = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
            if (j2 == 0 || j3 == 0 || string == null) {
                return null;
            }
            m mVar = new m(Long.valueOf(j2), Long.valueOf(j3), null, 4, null);
            mVar.f10433e = defaultSharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
            mVar.l(o.a.b());
            mVar.i(Long.valueOf(System.currentTimeMillis()));
            UUID fromString = UUID.fromString(string);
            kotlin.jvm.internal.m.e(fromString, "fromString(sessionIDStr)");
            mVar.j(fromString);
            return mVar;
        }
    }

    public m(Long l, Long l2, UUID uuid) {
        kotlin.jvm.internal.m.f(uuid, "sessionId");
        this.f10430b = l;
        this.f10431c = l2;
        this.f10432d = uuid;
    }

    public final Long b() {
        Long l = this.f10434f;
        if (l == null) {
            return 0L;
        }
        return l;
    }

    public final int c() {
        return this.f10433e;
    }

    public final UUID d() {
        return this.f10432d;
    }

    public final Long e() {
        return this.f10431c;
    }

    public final long f() {
        Long l;
        if (this.f10430b == null || (l = this.f10431c) == null) {
            return 0L;
        }
        if (l != null) {
            return l.longValue() - this.f10430b.longValue();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final o g() {
        return this.f10435g;
    }

    public final void h() {
        this.f10433e++;
    }

    public final void i(Long l) {
        this.f10434f = l;
    }

    public final void j(UUID uuid) {
        kotlin.jvm.internal.m.f(uuid, "<set-?>");
        this.f10432d = uuid;
    }

    public final void k(Long l) {
        this.f10431c = l;
    }

    public final void l(o oVar) {
        this.f10435g = oVar;
    }

    public final void m() {
        a0 a0Var = a0.a;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(a0.c()).edit();
        Long l = this.f10430b;
        edit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", l == null ? 0L : l.longValue());
        Long l2 = this.f10431c;
        edit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", l2 != null ? l2.longValue() : 0L);
        edit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.f10433e);
        edit.putString("com.facebook.appevents.SessionInfo.sessionId", this.f10432d.toString());
        edit.apply();
        o oVar = this.f10435g;
        if (oVar == null || oVar == null) {
            return;
        }
        oVar.a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ m(Long l, Long l2, UUID uuid, int i2, kotlin.jvm.internal.g gVar) {
        this(l, l2, uuid);
        if ((i2 & 4) != 0) {
            uuid = UUID.randomUUID();
            kotlin.jvm.internal.m.e(uuid, "randomUUID()");
        }
    }
}
