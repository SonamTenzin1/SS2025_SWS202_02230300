package androidx.work.impl.n;

/* compiled from: WorkProgressDao_Impl.java */
/* loaded from: classes.dex */
public final class o implements n {
    private final androidx.room.j a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.c<m> f2521b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.q f2522c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.q f2523d;

    /* compiled from: WorkProgressDao_Impl.java */
    /* loaded from: classes.dex */
    class a extends androidx.room.c<m> {
        a(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(c.u.a.f fVar, m mVar) {
            String str = mVar.a;
            if (str == null) {
                fVar.I0(1);
            } else {
                fVar.w(1, str);
            }
            byte[] l = androidx.work.e.l(mVar.f2520b);
            if (l == null) {
                fVar.I0(2);
            } else {
                fVar.o0(2, l);
            }
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }
    }

    /* compiled from: WorkProgressDao_Impl.java */
    /* loaded from: classes.dex */
    class b extends androidx.room.q {
        b(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* compiled from: WorkProgressDao_Impl.java */
    /* loaded from: classes.dex */
    class c extends androidx.room.q {
        c(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE FROM WorkProgress";
        }
    }

    public o(androidx.room.j jVar) {
        this.a = jVar;
        this.f2521b = new a(jVar);
        this.f2522c = new b(jVar);
        this.f2523d = new c(jVar);
    }

    @Override // androidx.work.impl.n.n
    public void a() {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f acquire = this.f2523d.acquire();
        this.a.beginTransaction();
        try {
            acquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f2523d.release(acquire);
        }
    }

    @Override // androidx.work.impl.n.n
    public void b(m mVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f2521b.insert((androidx.room.c<m>) mVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.n.n
    public void delete(String str) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f acquire = this.f2522c.acquire();
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
            this.f2522c.release(acquire);
        }
    }
}
