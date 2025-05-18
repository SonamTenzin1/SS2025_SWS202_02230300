package androidx.work.impl.n;

import android.database.Cursor;
import androidx.work.impl.n.p;
import androidx.work.x;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WorkSpecDao_Impl.java */
/* loaded from: classes.dex */
public final class r implements q {
    private final androidx.room.j a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.c<p> f2540b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.q f2541c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.q f2542d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.room.q f2543e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.room.q f2544f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.room.q f2545g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.room.q f2546h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.room.q f2547i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.room.q f2548j;

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class a extends androidx.room.c<p> {
        a(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(c.u.a.f fVar, p pVar) {
            String str = pVar.f2525c;
            if (str == null) {
                fVar.I0(1);
            } else {
                fVar.w(1, str);
            }
            fVar.h0(2, v.j(pVar.f2526d));
            String str2 = pVar.f2527e;
            if (str2 == null) {
                fVar.I0(3);
            } else {
                fVar.w(3, str2);
            }
            String str3 = pVar.f2528f;
            if (str3 == null) {
                fVar.I0(4);
            } else {
                fVar.w(4, str3);
            }
            byte[] l = androidx.work.e.l(pVar.f2529g);
            if (l == null) {
                fVar.I0(5);
            } else {
                fVar.o0(5, l);
            }
            byte[] l2 = androidx.work.e.l(pVar.f2530h);
            if (l2 == null) {
                fVar.I0(6);
            } else {
                fVar.o0(6, l2);
            }
            fVar.h0(7, pVar.f2531i);
            fVar.h0(8, pVar.f2532j);
            fVar.h0(9, pVar.f2533k);
            fVar.h0(10, pVar.m);
            fVar.h0(11, v.a(pVar.n));
            fVar.h0(12, pVar.o);
            fVar.h0(13, pVar.p);
            fVar.h0(14, pVar.q);
            fVar.h0(15, pVar.r);
            fVar.h0(16, pVar.s ? 1L : 0L);
            fVar.h0(17, v.i(pVar.t));
            androidx.work.c cVar = pVar.l;
            if (cVar != null) {
                fVar.h0(18, v.h(cVar.b()));
                fVar.h0(19, cVar.g() ? 1L : 0L);
                fVar.h0(20, cVar.h() ? 1L : 0L);
                fVar.h0(21, cVar.f() ? 1L : 0L);
                fVar.h0(22, cVar.i() ? 1L : 0L);
                fVar.h0(23, cVar.c());
                fVar.h0(24, cVar.d());
                byte[] c2 = v.c(cVar.a());
                if (c2 == null) {
                    fVar.I0(25);
                    return;
                } else {
                    fVar.o0(25, c2);
                    return;
                }
            }
            fVar.I0(18);
            fVar.I0(19);
            fVar.I0(20);
            fVar.I0(21);
            fVar.I0(22);
            fVar.I0(23);
            fVar.I0(24);
            fVar.I0(25);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class b extends androidx.room.q {
        b(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class c extends androidx.room.q {
        c(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class d extends androidx.room.q {
        d(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class e extends androidx.room.q {
        e(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class f extends androidx.room.q {
        f(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class g extends androidx.room.q {
        g(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class h extends androidx.room.q {
        h(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    /* loaded from: classes.dex */
    class i extends androidx.room.q {
        i(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public r(androidx.room.j jVar) {
        this.a = jVar;
        this.f2540b = new a(jVar);
        this.f2541c = new b(jVar);
        this.f2542d = new c(jVar);
        this.f2543e = new d(jVar);
        this.f2544f = new e(jVar);
        this.f2545g = new f(jVar);
        this.f2546h = new g(jVar);
        this.f2547i = new h(jVar);
        this.f2548j = new i(jVar);
    }

    @Override // androidx.work.impl.n.q
    public int a(x.a aVar, String... strArr) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder b2 = androidx.room.t.f.b();
        b2.append("UPDATE workspec SET state=");
        b2.append("?");
        b2.append(" WHERE id IN (");
        androidx.room.t.f.a(b2, strArr.length);
        b2.append(")");
        c.u.a.f compileStatement = this.a.compileStatement(b2.toString());
        compileStatement.h0(1, v.j(aVar));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.I0(i2);
            } else {
                compileStatement.w(i2, str);
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            int E = compileStatement.E();
            this.a.setTransactionSuccessful();
            return E;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.n.q
    public int b(String str, long j2) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f acquire = this.f2546h.acquire();
        acquire.h0(1, j2);
        if (str == null) {
            acquire.I0(2);
        } else {
            acquire.w(2, str);
        }
        this.a.beginTransaction();
        try {
            int E = acquire.E();
            this.a.setTransactionSuccessful();
            return E;
        } finally {
            this.a.endTransaction();
            this.f2546h.release(acquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public List<p.b> c(String str) {
        androidx.room.m c2 = androidx.room.m.c("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            int b3 = androidx.room.t.b.b(b2, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int b4 = androidx.room.t.b.b(b2, "state");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                p.b bVar = new p.b();
                bVar.a = b2.getString(b3);
                bVar.f2534b = v.g(b2.getInt(b4));
                arrayList.add(bVar);
            }
            return arrayList;
        } finally {
            b2.close();
            c2.f();
        }
    }

    @Override // androidx.work.impl.n.q
    public List<p> d(long j2) {
        androidx.room.m mVar;
        androidx.room.m c2 = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        c2.h0(1, j2);
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            int b3 = androidx.room.t.b.b(b2, "required_network_type");
            int b4 = androidx.room.t.b.b(b2, "requires_charging");
            int b5 = androidx.room.t.b.b(b2, "requires_device_idle");
            int b6 = androidx.room.t.b.b(b2, "requires_battery_not_low");
            int b7 = androidx.room.t.b.b(b2, "requires_storage_not_low");
            int b8 = androidx.room.t.b.b(b2, "trigger_content_update_delay");
            int b9 = androidx.room.t.b.b(b2, "trigger_max_content_delay");
            int b10 = androidx.room.t.b.b(b2, "content_uri_triggers");
            int b11 = androidx.room.t.b.b(b2, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int b12 = androidx.room.t.b.b(b2, "state");
            int b13 = androidx.room.t.b.b(b2, "worker_class_name");
            int b14 = androidx.room.t.b.b(b2, "input_merger_class_name");
            int b15 = androidx.room.t.b.b(b2, "input");
            int b16 = androidx.room.t.b.b(b2, "output");
            mVar = c2;
            try {
                int b17 = androidx.room.t.b.b(b2, "initial_delay");
                int b18 = androidx.room.t.b.b(b2, "interval_duration");
                int b19 = androidx.room.t.b.b(b2, "flex_duration");
                int b20 = androidx.room.t.b.b(b2, "run_attempt_count");
                int b21 = androidx.room.t.b.b(b2, "backoff_policy");
                int b22 = androidx.room.t.b.b(b2, "backoff_delay_duration");
                int b23 = androidx.room.t.b.b(b2, "period_start_time");
                int b24 = androidx.room.t.b.b(b2, "minimum_retention_duration");
                int b25 = androidx.room.t.b.b(b2, "schedule_requested_at");
                int b26 = androidx.room.t.b.b(b2, "run_in_foreground");
                int b27 = androidx.room.t.b.b(b2, "out_of_quota_policy");
                int i2 = b16;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b11);
                    int i3 = b11;
                    String string2 = b2.getString(b13);
                    int i4 = b13;
                    androidx.work.c cVar = new androidx.work.c();
                    int i5 = b3;
                    cVar.k(v.e(b2.getInt(b3)));
                    cVar.m(b2.getInt(b4) != 0);
                    cVar.n(b2.getInt(b5) != 0);
                    cVar.l(b2.getInt(b6) != 0);
                    cVar.o(b2.getInt(b7) != 0);
                    int i6 = b4;
                    int i7 = b5;
                    cVar.p(b2.getLong(b8));
                    cVar.q(b2.getLong(b9));
                    cVar.j(v.b(b2.getBlob(b10)));
                    p pVar = new p(string, string2);
                    pVar.f2526d = v.g(b2.getInt(b12));
                    pVar.f2528f = b2.getString(b14);
                    pVar.f2529g = androidx.work.e.g(b2.getBlob(b15));
                    int i8 = i2;
                    pVar.f2530h = androidx.work.e.g(b2.getBlob(i8));
                    int i9 = b17;
                    i2 = i8;
                    pVar.f2531i = b2.getLong(i9);
                    int i10 = b14;
                    int i11 = b18;
                    pVar.f2532j = b2.getLong(i11);
                    int i12 = b6;
                    int i13 = b19;
                    pVar.f2533k = b2.getLong(i13);
                    int i14 = b20;
                    pVar.m = b2.getInt(i14);
                    int i15 = b21;
                    pVar.n = v.d(b2.getInt(i15));
                    b19 = i13;
                    int i16 = b22;
                    pVar.o = b2.getLong(i16);
                    int i17 = b23;
                    pVar.p = b2.getLong(i17);
                    b23 = i17;
                    int i18 = b24;
                    pVar.q = b2.getLong(i18);
                    int i19 = b25;
                    pVar.r = b2.getLong(i19);
                    int i20 = b26;
                    pVar.s = b2.getInt(i20) != 0;
                    int i21 = b27;
                    pVar.t = v.f(b2.getInt(i21));
                    pVar.l = cVar;
                    arrayList.add(pVar);
                    b4 = i6;
                    b27 = i21;
                    b14 = i10;
                    b17 = i9;
                    b18 = i11;
                    b20 = i14;
                    b25 = i19;
                    b11 = i3;
                    b13 = i4;
                    b3 = i5;
                    b26 = i20;
                    b24 = i18;
                    b5 = i7;
                    b22 = i16;
                    b6 = i12;
                    b21 = i15;
                }
                b2.close();
                mVar.f();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b2.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = c2;
        }
    }

    @Override // androidx.work.impl.n.q
    public void delete(String str) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f acquire = this.f2541c.acquire();
        if (str == null) {
            acquire.I0(1);
        } else {
            acquire.w(1, str);
        }
        this.a.beginTransaction();
        try {
            acquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f2541c.release(acquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public List<p> e(int i2) {
        androidx.room.m mVar;
        androidx.room.m c2 = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        c2.h0(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            int b3 = androidx.room.t.b.b(b2, "required_network_type");
            int b4 = androidx.room.t.b.b(b2, "requires_charging");
            int b5 = androidx.room.t.b.b(b2, "requires_device_idle");
            int b6 = androidx.room.t.b.b(b2, "requires_battery_not_low");
            int b7 = androidx.room.t.b.b(b2, "requires_storage_not_low");
            int b8 = androidx.room.t.b.b(b2, "trigger_content_update_delay");
            int b9 = androidx.room.t.b.b(b2, "trigger_max_content_delay");
            int b10 = androidx.room.t.b.b(b2, "content_uri_triggers");
            int b11 = androidx.room.t.b.b(b2, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int b12 = androidx.room.t.b.b(b2, "state");
            int b13 = androidx.room.t.b.b(b2, "worker_class_name");
            int b14 = androidx.room.t.b.b(b2, "input_merger_class_name");
            int b15 = androidx.room.t.b.b(b2, "input");
            int b16 = androidx.room.t.b.b(b2, "output");
            mVar = c2;
            try {
                int b17 = androidx.room.t.b.b(b2, "initial_delay");
                int b18 = androidx.room.t.b.b(b2, "interval_duration");
                int b19 = androidx.room.t.b.b(b2, "flex_duration");
                int b20 = androidx.room.t.b.b(b2, "run_attempt_count");
                int b21 = androidx.room.t.b.b(b2, "backoff_policy");
                int b22 = androidx.room.t.b.b(b2, "backoff_delay_duration");
                int b23 = androidx.room.t.b.b(b2, "period_start_time");
                int b24 = androidx.room.t.b.b(b2, "minimum_retention_duration");
                int b25 = androidx.room.t.b.b(b2, "schedule_requested_at");
                int b26 = androidx.room.t.b.b(b2, "run_in_foreground");
                int b27 = androidx.room.t.b.b(b2, "out_of_quota_policy");
                int i3 = b16;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b11);
                    int i4 = b11;
                    String string2 = b2.getString(b13);
                    int i5 = b13;
                    androidx.work.c cVar = new androidx.work.c();
                    int i6 = b3;
                    cVar.k(v.e(b2.getInt(b3)));
                    cVar.m(b2.getInt(b4) != 0);
                    cVar.n(b2.getInt(b5) != 0);
                    cVar.l(b2.getInt(b6) != 0);
                    cVar.o(b2.getInt(b7) != 0);
                    int i7 = b4;
                    int i8 = b5;
                    cVar.p(b2.getLong(b8));
                    cVar.q(b2.getLong(b9));
                    cVar.j(v.b(b2.getBlob(b10)));
                    p pVar = new p(string, string2);
                    pVar.f2526d = v.g(b2.getInt(b12));
                    pVar.f2528f = b2.getString(b14);
                    pVar.f2529g = androidx.work.e.g(b2.getBlob(b15));
                    int i9 = i3;
                    pVar.f2530h = androidx.work.e.g(b2.getBlob(i9));
                    i3 = i9;
                    int i10 = b17;
                    pVar.f2531i = b2.getLong(i10);
                    int i11 = b14;
                    int i12 = b18;
                    pVar.f2532j = b2.getLong(i12);
                    int i13 = b6;
                    int i14 = b19;
                    pVar.f2533k = b2.getLong(i14);
                    int i15 = b20;
                    pVar.m = b2.getInt(i15);
                    int i16 = b21;
                    pVar.n = v.d(b2.getInt(i16));
                    b19 = i14;
                    int i17 = b22;
                    pVar.o = b2.getLong(i17);
                    int i18 = b23;
                    pVar.p = b2.getLong(i18);
                    b23 = i18;
                    int i19 = b24;
                    pVar.q = b2.getLong(i19);
                    int i20 = b25;
                    pVar.r = b2.getLong(i20);
                    int i21 = b26;
                    pVar.s = b2.getInt(i21) != 0;
                    int i22 = b27;
                    pVar.t = v.f(b2.getInt(i22));
                    pVar.l = cVar;
                    arrayList.add(pVar);
                    b27 = i22;
                    b4 = i7;
                    b14 = i11;
                    b17 = i10;
                    b18 = i12;
                    b20 = i15;
                    b25 = i20;
                    b11 = i4;
                    b13 = i5;
                    b3 = i6;
                    b26 = i21;
                    b24 = i19;
                    b5 = i8;
                    b22 = i17;
                    b6 = i13;
                    b21 = i16;
                }
                b2.close();
                mVar.f();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b2.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = c2;
        }
    }

    @Override // androidx.work.impl.n.q
    public void f(p pVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f2540b.insert((androidx.room.c<p>) pVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.n.q
    public List<p> g() {
        androidx.room.m mVar;
        androidx.room.m c2 = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            int b3 = androidx.room.t.b.b(b2, "required_network_type");
            int b4 = androidx.room.t.b.b(b2, "requires_charging");
            int b5 = androidx.room.t.b.b(b2, "requires_device_idle");
            int b6 = androidx.room.t.b.b(b2, "requires_battery_not_low");
            int b7 = androidx.room.t.b.b(b2, "requires_storage_not_low");
            int b8 = androidx.room.t.b.b(b2, "trigger_content_update_delay");
            int b9 = androidx.room.t.b.b(b2, "trigger_max_content_delay");
            int b10 = androidx.room.t.b.b(b2, "content_uri_triggers");
            int b11 = androidx.room.t.b.b(b2, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int b12 = androidx.room.t.b.b(b2, "state");
            int b13 = androidx.room.t.b.b(b2, "worker_class_name");
            int b14 = androidx.room.t.b.b(b2, "input_merger_class_name");
            int b15 = androidx.room.t.b.b(b2, "input");
            int b16 = androidx.room.t.b.b(b2, "output");
            mVar = c2;
            try {
                int b17 = androidx.room.t.b.b(b2, "initial_delay");
                int b18 = androidx.room.t.b.b(b2, "interval_duration");
                int b19 = androidx.room.t.b.b(b2, "flex_duration");
                int b20 = androidx.room.t.b.b(b2, "run_attempt_count");
                int b21 = androidx.room.t.b.b(b2, "backoff_policy");
                int b22 = androidx.room.t.b.b(b2, "backoff_delay_duration");
                int b23 = androidx.room.t.b.b(b2, "period_start_time");
                int b24 = androidx.room.t.b.b(b2, "minimum_retention_duration");
                int b25 = androidx.room.t.b.b(b2, "schedule_requested_at");
                int b26 = androidx.room.t.b.b(b2, "run_in_foreground");
                int b27 = androidx.room.t.b.b(b2, "out_of_quota_policy");
                int i2 = b16;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b11);
                    int i3 = b11;
                    String string2 = b2.getString(b13);
                    int i4 = b13;
                    androidx.work.c cVar = new androidx.work.c();
                    int i5 = b3;
                    cVar.k(v.e(b2.getInt(b3)));
                    cVar.m(b2.getInt(b4) != 0);
                    cVar.n(b2.getInt(b5) != 0);
                    cVar.l(b2.getInt(b6) != 0);
                    cVar.o(b2.getInt(b7) != 0);
                    int i6 = b4;
                    int i7 = b5;
                    cVar.p(b2.getLong(b8));
                    cVar.q(b2.getLong(b9));
                    cVar.j(v.b(b2.getBlob(b10)));
                    p pVar = new p(string, string2);
                    pVar.f2526d = v.g(b2.getInt(b12));
                    pVar.f2528f = b2.getString(b14);
                    pVar.f2529g = androidx.work.e.g(b2.getBlob(b15));
                    int i8 = i2;
                    pVar.f2530h = androidx.work.e.g(b2.getBlob(i8));
                    i2 = i8;
                    int i9 = b17;
                    pVar.f2531i = b2.getLong(i9);
                    int i10 = b15;
                    int i11 = b18;
                    pVar.f2532j = b2.getLong(i11);
                    int i12 = b6;
                    int i13 = b19;
                    pVar.f2533k = b2.getLong(i13);
                    int i14 = b20;
                    pVar.m = b2.getInt(i14);
                    int i15 = b21;
                    pVar.n = v.d(b2.getInt(i15));
                    b19 = i13;
                    int i16 = b22;
                    pVar.o = b2.getLong(i16);
                    int i17 = b23;
                    pVar.p = b2.getLong(i17);
                    b23 = i17;
                    int i18 = b24;
                    pVar.q = b2.getLong(i18);
                    int i19 = b25;
                    pVar.r = b2.getLong(i19);
                    int i20 = b26;
                    pVar.s = b2.getInt(i20) != 0;
                    int i21 = b27;
                    pVar.t = v.f(b2.getInt(i21));
                    pVar.l = cVar;
                    arrayList.add(pVar);
                    b27 = i21;
                    b4 = i6;
                    b15 = i10;
                    b17 = i9;
                    b18 = i11;
                    b20 = i14;
                    b25 = i19;
                    b11 = i3;
                    b13 = i4;
                    b3 = i5;
                    b26 = i20;
                    b24 = i18;
                    b5 = i7;
                    b22 = i16;
                    b6 = i12;
                    b21 = i15;
                }
                b2.close();
                mVar.f();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b2.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = c2;
        }
    }

    @Override // androidx.work.impl.n.q
    public void h(String str, androidx.work.e eVar) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f acquire = this.f2542d.acquire();
        byte[] l = androidx.work.e.l(eVar);
        if (l == null) {
            acquire.I0(1);
        } else {
            acquire.o0(1, l);
        }
        if (str == null) {
            acquire.I0(2);
        } else {
            acquire.w(2, str);
        }
        this.a.beginTransaction();
        try {
            acquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f2542d.release(acquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public List<p> i() {
        androidx.room.m mVar;
        androidx.room.m c2 = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            int b3 = androidx.room.t.b.b(b2, "required_network_type");
            int b4 = androidx.room.t.b.b(b2, "requires_charging");
            int b5 = androidx.room.t.b.b(b2, "requires_device_idle");
            int b6 = androidx.room.t.b.b(b2, "requires_battery_not_low");
            int b7 = androidx.room.t.b.b(b2, "requires_storage_not_low");
            int b8 = androidx.room.t.b.b(b2, "trigger_content_update_delay");
            int b9 = androidx.room.t.b.b(b2, "trigger_max_content_delay");
            int b10 = androidx.room.t.b.b(b2, "content_uri_triggers");
            int b11 = androidx.room.t.b.b(b2, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int b12 = androidx.room.t.b.b(b2, "state");
            int b13 = androidx.room.t.b.b(b2, "worker_class_name");
            int b14 = androidx.room.t.b.b(b2, "input_merger_class_name");
            int b15 = androidx.room.t.b.b(b2, "input");
            int b16 = androidx.room.t.b.b(b2, "output");
            mVar = c2;
            try {
                int b17 = androidx.room.t.b.b(b2, "initial_delay");
                int b18 = androidx.room.t.b.b(b2, "interval_duration");
                int b19 = androidx.room.t.b.b(b2, "flex_duration");
                int b20 = androidx.room.t.b.b(b2, "run_attempt_count");
                int b21 = androidx.room.t.b.b(b2, "backoff_policy");
                int b22 = androidx.room.t.b.b(b2, "backoff_delay_duration");
                int b23 = androidx.room.t.b.b(b2, "period_start_time");
                int b24 = androidx.room.t.b.b(b2, "minimum_retention_duration");
                int b25 = androidx.room.t.b.b(b2, "schedule_requested_at");
                int b26 = androidx.room.t.b.b(b2, "run_in_foreground");
                int b27 = androidx.room.t.b.b(b2, "out_of_quota_policy");
                int i2 = b16;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b11);
                    int i3 = b11;
                    String string2 = b2.getString(b13);
                    int i4 = b13;
                    androidx.work.c cVar = new androidx.work.c();
                    int i5 = b3;
                    cVar.k(v.e(b2.getInt(b3)));
                    cVar.m(b2.getInt(b4) != 0);
                    cVar.n(b2.getInt(b5) != 0);
                    cVar.l(b2.getInt(b6) != 0);
                    cVar.o(b2.getInt(b7) != 0);
                    int i6 = b4;
                    int i7 = b5;
                    cVar.p(b2.getLong(b8));
                    cVar.q(b2.getLong(b9));
                    cVar.j(v.b(b2.getBlob(b10)));
                    p pVar = new p(string, string2);
                    pVar.f2526d = v.g(b2.getInt(b12));
                    pVar.f2528f = b2.getString(b14);
                    pVar.f2529g = androidx.work.e.g(b2.getBlob(b15));
                    int i8 = i2;
                    pVar.f2530h = androidx.work.e.g(b2.getBlob(i8));
                    i2 = i8;
                    int i9 = b17;
                    pVar.f2531i = b2.getLong(i9);
                    int i10 = b15;
                    int i11 = b18;
                    pVar.f2532j = b2.getLong(i11);
                    int i12 = b6;
                    int i13 = b19;
                    pVar.f2533k = b2.getLong(i13);
                    int i14 = b20;
                    pVar.m = b2.getInt(i14);
                    int i15 = b21;
                    pVar.n = v.d(b2.getInt(i15));
                    b19 = i13;
                    int i16 = b22;
                    pVar.o = b2.getLong(i16);
                    int i17 = b23;
                    pVar.p = b2.getLong(i17);
                    b23 = i17;
                    int i18 = b24;
                    pVar.q = b2.getLong(i18);
                    int i19 = b25;
                    pVar.r = b2.getLong(i19);
                    int i20 = b26;
                    pVar.s = b2.getInt(i20) != 0;
                    int i21 = b27;
                    pVar.t = v.f(b2.getInt(i21));
                    pVar.l = cVar;
                    arrayList.add(pVar);
                    b27 = i21;
                    b4 = i6;
                    b15 = i10;
                    b17 = i9;
                    b18 = i11;
                    b20 = i14;
                    b25 = i19;
                    b11 = i3;
                    b13 = i4;
                    b3 = i5;
                    b26 = i20;
                    b24 = i18;
                    b5 = i7;
                    b22 = i16;
                    b6 = i12;
                    b21 = i15;
                }
                b2.close();
                mVar.f();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b2.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = c2;
        }
    }

    @Override // androidx.work.impl.n.q
    public boolean j() {
        boolean z = false;
        androidx.room.m c2 = androidx.room.m.c("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            if (b2.moveToFirst()) {
                if (b2.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            b2.close();
            c2.f();
        }
    }

    @Override // androidx.work.impl.n.q
    public List<String> k(String str) {
        androidx.room.m c2 = androidx.room.m.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            c2.f();
        }
    }

    @Override // androidx.work.impl.n.q
    public x.a l(String str) {
        androidx.room.m c2 = androidx.room.m.c("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            return b2.moveToFirst() ? v.g(b2.getInt(0)) : null;
        } finally {
            b2.close();
            c2.f();
        }
    }

    @Override // androidx.work.impl.n.q
    public p m(String str) {
        androidx.room.m mVar;
        p pVar;
        androidx.room.m c2 = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            int b3 = androidx.room.t.b.b(b2, "required_network_type");
            int b4 = androidx.room.t.b.b(b2, "requires_charging");
            int b5 = androidx.room.t.b.b(b2, "requires_device_idle");
            int b6 = androidx.room.t.b.b(b2, "requires_battery_not_low");
            int b7 = androidx.room.t.b.b(b2, "requires_storage_not_low");
            int b8 = androidx.room.t.b.b(b2, "trigger_content_update_delay");
            int b9 = androidx.room.t.b.b(b2, "trigger_max_content_delay");
            int b10 = androidx.room.t.b.b(b2, "content_uri_triggers");
            int b11 = androidx.room.t.b.b(b2, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int b12 = androidx.room.t.b.b(b2, "state");
            int b13 = androidx.room.t.b.b(b2, "worker_class_name");
            int b14 = androidx.room.t.b.b(b2, "input_merger_class_name");
            int b15 = androidx.room.t.b.b(b2, "input");
            int b16 = androidx.room.t.b.b(b2, "output");
            mVar = c2;
            try {
                int b17 = androidx.room.t.b.b(b2, "initial_delay");
                int b18 = androidx.room.t.b.b(b2, "interval_duration");
                int b19 = androidx.room.t.b.b(b2, "flex_duration");
                int b20 = androidx.room.t.b.b(b2, "run_attempt_count");
                int b21 = androidx.room.t.b.b(b2, "backoff_policy");
                int b22 = androidx.room.t.b.b(b2, "backoff_delay_duration");
                int b23 = androidx.room.t.b.b(b2, "period_start_time");
                int b24 = androidx.room.t.b.b(b2, "minimum_retention_duration");
                int b25 = androidx.room.t.b.b(b2, "schedule_requested_at");
                int b26 = androidx.room.t.b.b(b2, "run_in_foreground");
                int b27 = androidx.room.t.b.b(b2, "out_of_quota_policy");
                if (b2.moveToFirst()) {
                    String string = b2.getString(b11);
                    String string2 = b2.getString(b13);
                    androidx.work.c cVar = new androidx.work.c();
                    cVar.k(v.e(b2.getInt(b3)));
                    cVar.m(b2.getInt(b4) != 0);
                    cVar.n(b2.getInt(b5) != 0);
                    cVar.l(b2.getInt(b6) != 0);
                    cVar.o(b2.getInt(b7) != 0);
                    cVar.p(b2.getLong(b8));
                    cVar.q(b2.getLong(b9));
                    cVar.j(v.b(b2.getBlob(b10)));
                    p pVar2 = new p(string, string2);
                    pVar2.f2526d = v.g(b2.getInt(b12));
                    pVar2.f2528f = b2.getString(b14);
                    pVar2.f2529g = androidx.work.e.g(b2.getBlob(b15));
                    pVar2.f2530h = androidx.work.e.g(b2.getBlob(b16));
                    pVar2.f2531i = b2.getLong(b17);
                    pVar2.f2532j = b2.getLong(b18);
                    pVar2.f2533k = b2.getLong(b19);
                    pVar2.m = b2.getInt(b20);
                    pVar2.n = v.d(b2.getInt(b21));
                    pVar2.o = b2.getLong(b22);
                    pVar2.p = b2.getLong(b23);
                    pVar2.q = b2.getLong(b24);
                    pVar2.r = b2.getLong(b25);
                    pVar2.s = b2.getInt(b26) != 0;
                    pVar2.t = v.f(b2.getInt(b27));
                    pVar2.l = cVar;
                    pVar = pVar2;
                } else {
                    pVar = null;
                }
                b2.close();
                mVar.f();
                return pVar;
            } catch (Throwable th) {
                th = th;
                b2.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = c2;
        }
    }

    @Override // androidx.work.impl.n.q
    public int n(String str) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f acquire = this.f2545g.acquire();
        if (str == null) {
            acquire.I0(1);
        } else {
            acquire.w(1, str);
        }
        this.a.beginTransaction();
        try {
            int E = acquire.E();
            this.a.setTransactionSuccessful();
            return E;
        } finally {
            this.a.endTransaction();
            this.f2545g.release(acquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public List<String> o(String str) {
        androidx.room.m c2 = androidx.room.m.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            c2.f();
        }
    }

    @Override // androidx.work.impl.n.q
    public List<androidx.work.e> p(String str) {
        androidx.room.m c2 = androidx.room.m.c("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            c2.I0(1);
        } else {
            c2.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(androidx.work.e.g(b2.getBlob(0)));
            }
            return arrayList;
        } finally {
            b2.close();
            c2.f();
        }
    }

    @Override // androidx.work.impl.n.q
    public int q(String str) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f acquire = this.f2544f.acquire();
        if (str == null) {
            acquire.I0(1);
        } else {
            acquire.w(1, str);
        }
        this.a.beginTransaction();
        try {
            int E = acquire.E();
            this.a.setTransactionSuccessful();
            return E;
        } finally {
            this.a.endTransaction();
            this.f2544f.release(acquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public void r(String str, long j2) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f acquire = this.f2543e.acquire();
        acquire.h0(1, j2);
        if (str == null) {
            acquire.I0(2);
        } else {
            acquire.w(2, str);
        }
        this.a.beginTransaction();
        try {
            acquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f2543e.release(acquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public List<p> s(int i2) {
        androidx.room.m mVar;
        androidx.room.m c2 = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        c2.h0(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.a, c2, false, null);
        try {
            int b3 = androidx.room.t.b.b(b2, "required_network_type");
            int b4 = androidx.room.t.b.b(b2, "requires_charging");
            int b5 = androidx.room.t.b.b(b2, "requires_device_idle");
            int b6 = androidx.room.t.b.b(b2, "requires_battery_not_low");
            int b7 = androidx.room.t.b.b(b2, "requires_storage_not_low");
            int b8 = androidx.room.t.b.b(b2, "trigger_content_update_delay");
            int b9 = androidx.room.t.b.b(b2, "trigger_max_content_delay");
            int b10 = androidx.room.t.b.b(b2, "content_uri_triggers");
            int b11 = androidx.room.t.b.b(b2, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int b12 = androidx.room.t.b.b(b2, "state");
            int b13 = androidx.room.t.b.b(b2, "worker_class_name");
            int b14 = androidx.room.t.b.b(b2, "input_merger_class_name");
            int b15 = androidx.room.t.b.b(b2, "input");
            int b16 = androidx.room.t.b.b(b2, "output");
            mVar = c2;
            try {
                int b17 = androidx.room.t.b.b(b2, "initial_delay");
                int b18 = androidx.room.t.b.b(b2, "interval_duration");
                int b19 = androidx.room.t.b.b(b2, "flex_duration");
                int b20 = androidx.room.t.b.b(b2, "run_attempt_count");
                int b21 = androidx.room.t.b.b(b2, "backoff_policy");
                int b22 = androidx.room.t.b.b(b2, "backoff_delay_duration");
                int b23 = androidx.room.t.b.b(b2, "period_start_time");
                int b24 = androidx.room.t.b.b(b2, "minimum_retention_duration");
                int b25 = androidx.room.t.b.b(b2, "schedule_requested_at");
                int b26 = androidx.room.t.b.b(b2, "run_in_foreground");
                int b27 = androidx.room.t.b.b(b2, "out_of_quota_policy");
                int i3 = b16;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(b11);
                    int i4 = b11;
                    String string2 = b2.getString(b13);
                    int i5 = b13;
                    androidx.work.c cVar = new androidx.work.c();
                    int i6 = b3;
                    cVar.k(v.e(b2.getInt(b3)));
                    cVar.m(b2.getInt(b4) != 0);
                    cVar.n(b2.getInt(b5) != 0);
                    cVar.l(b2.getInt(b6) != 0);
                    cVar.o(b2.getInt(b7) != 0);
                    int i7 = b4;
                    int i8 = b5;
                    cVar.p(b2.getLong(b8));
                    cVar.q(b2.getLong(b9));
                    cVar.j(v.b(b2.getBlob(b10)));
                    p pVar = new p(string, string2);
                    pVar.f2526d = v.g(b2.getInt(b12));
                    pVar.f2528f = b2.getString(b14);
                    pVar.f2529g = androidx.work.e.g(b2.getBlob(b15));
                    int i9 = i3;
                    pVar.f2530h = androidx.work.e.g(b2.getBlob(i9));
                    i3 = i9;
                    int i10 = b17;
                    pVar.f2531i = b2.getLong(i10);
                    int i11 = b14;
                    int i12 = b18;
                    pVar.f2532j = b2.getLong(i12);
                    int i13 = b6;
                    int i14 = b19;
                    pVar.f2533k = b2.getLong(i14);
                    int i15 = b20;
                    pVar.m = b2.getInt(i15);
                    int i16 = b21;
                    pVar.n = v.d(b2.getInt(i16));
                    b19 = i14;
                    int i17 = b22;
                    pVar.o = b2.getLong(i17);
                    int i18 = b23;
                    pVar.p = b2.getLong(i18);
                    b23 = i18;
                    int i19 = b24;
                    pVar.q = b2.getLong(i19);
                    int i20 = b25;
                    pVar.r = b2.getLong(i20);
                    int i21 = b26;
                    pVar.s = b2.getInt(i21) != 0;
                    int i22 = b27;
                    pVar.t = v.f(b2.getInt(i22));
                    pVar.l = cVar;
                    arrayList.add(pVar);
                    b27 = i22;
                    b4 = i7;
                    b14 = i11;
                    b17 = i10;
                    b18 = i12;
                    b20 = i15;
                    b25 = i20;
                    b11 = i4;
                    b13 = i5;
                    b3 = i6;
                    b26 = i21;
                    b24 = i19;
                    b5 = i8;
                    b22 = i17;
                    b6 = i13;
                    b21 = i16;
                }
                b2.close();
                mVar.f();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b2.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = c2;
        }
    }

    @Override // androidx.work.impl.n.q
    public int t() {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f acquire = this.f2547i.acquire();
        this.a.beginTransaction();
        try {
            int E = acquire.E();
            this.a.setTransactionSuccessful();
            return E;
        } finally {
            this.a.endTransaction();
            this.f2547i.release(acquire);
        }
    }
}
