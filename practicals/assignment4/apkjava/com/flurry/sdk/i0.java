package com.flurry.sdk;

/* loaded from: classes2.dex */
public final class i0 extends d7<h0> {
    private n p;
    private d0 q;
    private o r;
    private f7<c0> s;
    private f7<n> t;

    /* loaded from: classes2.dex */
    final class a implements f7<c0> {

        /* renamed from: com.flurry.sdk.i0$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        final class C0162a extends f2 {

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ c0 f10821h;

            C0162a(c0 c0Var) {
                this.f10821h = c0Var;
            }

            @Override // com.flurry.sdk.f2
            public final void a() throws Exception {
                h0 h0Var;
                if (this.f10821h.f10655e.equals(e0.SESSION_START)) {
                    h0Var = new h0(true, i0.this.p);
                } else {
                    h0Var = new h0(false, i0.this.p);
                }
                i0.this.t(h0Var);
            }
        }

        a() {
        }

        @Override // com.flurry.sdk.f7
        public final /* synthetic */ void a(c0 c0Var) {
            i0.this.m(new C0162a(c0Var));
        }
    }

    /* loaded from: classes2.dex */
    final class b implements f7<n> {

        /* loaded from: classes2.dex */
        final class a extends f2 {

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ n f10823h;

            a(n nVar) {
                this.f10823h = nVar;
            }

            @Override // com.flurry.sdk.f2
            public final void a() throws Exception {
                d1.c(3, "SessionPropertyProvider", "Receive instant app data");
                i0.this.p = this.f10823h;
            }
        }

        b() {
        }

        @Override // com.flurry.sdk.f7
        public final /* synthetic */ void a(n nVar) {
            i0.this.m(new a(nVar));
        }
    }

    public i0(d0 d0Var, o oVar) {
        super("SessionPropertyProvider");
        this.s = new a();
        this.t = new b();
        this.q = d0Var;
        d0Var.v(this.s);
        this.r = oVar;
        oVar.v(this.t);
    }
}
