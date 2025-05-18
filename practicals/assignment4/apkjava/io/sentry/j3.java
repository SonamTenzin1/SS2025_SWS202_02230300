package io.sentry;

import io.sentry.util.m;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: OutboxSender.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class j3 extends e1 implements t1 {

    /* renamed from: c, reason: collision with root package name */
    private static final Charset f22452c = Charset.forName("UTF-8");

    /* renamed from: d, reason: collision with root package name */
    private final v1 f22453d;

    /* renamed from: e, reason: collision with root package name */
    private final s1 f22454e;

    /* renamed from: f, reason: collision with root package name */
    private final c2 f22455f;

    /* renamed from: g, reason: collision with root package name */
    private final w1 f22456g;

    public j3(v1 v1Var, s1 s1Var, c2 c2Var, w1 w1Var, long j2) {
        super(w1Var, j2);
        this.f22453d = (v1) io.sentry.util.q.c(v1Var, "Hub is required.");
        this.f22454e = (s1) io.sentry.util.q.c(s1Var, "Envelope reader is required.");
        this.f22455f = (c2) io.sentry.util.q.c(c2Var, "Serializer is required.");
        this.f22456g = (w1) io.sentry.util.q.c(w1Var, "Logger is required.");
    }

    private q5 g(o5 o5Var) {
        String a;
        if (o5Var != null && (a = o5Var.a()) != null) {
            try {
                Double valueOf = Double.valueOf(Double.parseDouble(a));
                if (!io.sentry.util.t.e(valueOf, false)) {
                    this.f22456g.c(s4.ERROR, "Invalid sample rate parsed from TraceContext: %s", a);
                } else {
                    return new q5(Boolean.TRUE, valueOf);
                }
            } catch (Exception unused) {
                this.f22456g.c(s4.ERROR, "Unable to parse sample rate from TraceContext: %s", a);
            }
        }
        return new q5(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(File file, io.sentry.hints.k kVar) {
        if (kVar.b()) {
            return;
        }
        try {
            if (file.delete()) {
                return;
            }
            this.f22456g.c(s4.ERROR, "Failed to delete: %s", file.getAbsolutePath());
        } catch (RuntimeException e2) {
            this.f22456g.a(s4.ERROR, e2, "Failed to delete: %s", file.getAbsolutePath());
        }
    }

    private void k(j4 j4Var, int i2) {
        this.f22456g.c(s4.ERROR, "Item %d of type %s returned null by the parser.", Integer.valueOf(i2), j4Var.i().b());
    }

    private void l(int i2) {
        this.f22456g.c(s4.DEBUG, "Item %d is being captured.", Integer.valueOf(i2));
    }

    private void m(io.sentry.protocol.q qVar) {
        this.f22456g.c(s4.WARNING, "Timed out waiting for event id submission: %s", qVar);
    }

    private void n(h4 h4Var, io.sentry.protocol.q qVar, int i2) {
        this.f22456g.c(s4.ERROR, "Item %d of has a different event id (%s) to the envelope header (%s)", Integer.valueOf(i2), h4Var.b().a(), qVar);
    }

    private void o(h4 h4Var, n1 n1Var) throws IOException {
        BufferedReader bufferedReader;
        Object c2;
        this.f22456g.c(s4.DEBUG, "Processing Envelope with %d item(s)", Integer.valueOf(io.sentry.util.i.d(h4Var.c())));
        int i2 = 0;
        for (j4 j4Var : h4Var.c()) {
            i2++;
            if (j4Var.i() == null) {
                this.f22456g.c(s4.ERROR, "Item %d has no header", Integer.valueOf(i2));
            } else if (r4.Event.equals(j4Var.i().b())) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(j4Var.h()), f22452c));
                    try {
                        l4 l4Var = (l4) this.f22455f.c(bufferedReader, l4.class);
                        if (l4Var == null) {
                            k(j4Var, i2);
                        } else {
                            if (l4Var.L() != null) {
                                io.sentry.util.m.o(n1Var, l4Var.L().e());
                            }
                            if (h4Var.b().a() != null && !h4Var.b().a().equals(l4Var.G())) {
                                n(h4Var, l4Var.G(), i2);
                                bufferedReader.close();
                            } else {
                                this.f22453d.t(l4Var, n1Var);
                                l(i2);
                                if (!p(n1Var)) {
                                    m(l4Var.G());
                                    bufferedReader.close();
                                    return;
                                }
                            }
                        }
                        bufferedReader.close();
                    } finally {
                    }
                } catch (Throwable th) {
                    this.f22456g.b(s4.ERROR, "Item failed to process.", th);
                }
                c2 = io.sentry.util.m.c(n1Var);
                if (!(c2 instanceof io.sentry.hints.p) && !((io.sentry.hints.p) c2).f()) {
                    this.f22456g.c(s4.WARNING, "Envelope had a failed capture at item %d. No more items will be sent.", Integer.valueOf(i2));
                    return;
                }
                io.sentry.util.m.k(n1Var, io.sentry.hints.j.class, new m.a() { // from class: io.sentry.q
                    @Override // io.sentry.util.m.a
                    public final void a(Object obj) {
                        ((io.sentry.hints.j) obj).a();
                    }
                });
            } else {
                if (r4.Transaction.equals(j4Var.i().b())) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(j4Var.h()), f22452c));
                        try {
                            io.sentry.protocol.x xVar = (io.sentry.protocol.x) this.f22455f.c(bufferedReader, io.sentry.protocol.x.class);
                            if (xVar == null) {
                                k(j4Var, i2);
                            } else if (h4Var.b().a() != null && !h4Var.b().a().equals(xVar.G())) {
                                n(h4Var, xVar.G(), i2);
                                bufferedReader.close();
                            } else {
                                o5 c3 = h4Var.b().c();
                                if (xVar.C().e() != null) {
                                    xVar.C().e().n(g(c3));
                                }
                                this.f22453d.m(xVar, c3, n1Var);
                                l(i2);
                                if (!p(n1Var)) {
                                    m(xVar.G());
                                    bufferedReader.close();
                                    return;
                                }
                            }
                            bufferedReader.close();
                        } finally {
                        }
                    } catch (Throwable th2) {
                        this.f22456g.b(s4.ERROR, "Item failed to process.", th2);
                    }
                } else {
                    this.f22453d.j(new h4(h4Var.b().a(), h4Var.b().b(), j4Var), n1Var);
                    this.f22456g.c(s4.DEBUG, "%s item %d is being captured.", j4Var.i().b().getItemType(), Integer.valueOf(i2));
                    if (!p(n1Var)) {
                        this.f22456g.c(s4.WARNING, "Timed out waiting for item type submission: %s", j4Var.i().b().getItemType());
                        return;
                    }
                }
                c2 = io.sentry.util.m.c(n1Var);
                if (!(c2 instanceof io.sentry.hints.p)) {
                }
                io.sentry.util.m.k(n1Var, io.sentry.hints.j.class, new m.a() { // from class: io.sentry.q
                    @Override // io.sentry.util.m.a
                    public final void a(Object obj) {
                        ((io.sentry.hints.j) obj).a();
                    }
                });
            }
        }
    }

    private boolean p(n1 n1Var) {
        Object c2 = io.sentry.util.m.c(n1Var);
        if (c2 instanceof io.sentry.hints.i) {
            return ((io.sentry.hints.i) c2).e();
        }
        io.sentry.util.p.a(io.sentry.hints.i.class, c2, this.f22456g);
        return true;
    }

    @Override // io.sentry.t1
    public void a(String str, n1 n1Var) {
        io.sentry.util.q.c(str, "Path is required.");
        f(new File(str), n1Var);
    }

    @Override // io.sentry.e1
    protected boolean b(String str) {
        return (str == null || str.startsWith("session") || str.startsWith("previous_session") || str.startsWith("startup_crash")) ? false : true;
    }

    @Override // io.sentry.e1
    public /* bridge */ /* synthetic */ void e(File file) {
        super.e(file);
    }

    @Override // io.sentry.e1
    protected void f(final File file, n1 n1Var) {
        w1 w1Var;
        m.a aVar;
        io.sentry.util.q.c(file, "File is required.");
        try {
            if (!b(file.getName())) {
                this.f22456g.c(s4.DEBUG, "File '%s' should be ignored.", file.getAbsolutePath());
                return;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    h4 a = this.f22454e.a(bufferedInputStream);
                    if (a == null) {
                        this.f22456g.c(s4.ERROR, "Stream from path %s resulted in a null envelope.", file.getAbsolutePath());
                    } else {
                        o(a, n1Var);
                        this.f22456g.c(s4.DEBUG, "File '%s' is done.", file.getAbsolutePath());
                    }
                    bufferedInputStream.close();
                    w1Var = this.f22456g;
                    aVar = new m.a() { // from class: io.sentry.p
                        @Override // io.sentry.util.m.a
                        public final void a(Object obj) {
                            j3.this.j(file, (io.sentry.hints.k) obj);
                        }
                    };
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (IOException e2) {
                this.f22456g.b(s4.ERROR, "Error processing envelope.", e2);
                w1Var = this.f22456g;
                aVar = new m.a() { // from class: io.sentry.p
                    @Override // io.sentry.util.m.a
                    public final void a(Object obj) {
                        j3.this.j(file, (io.sentry.hints.k) obj);
                    }
                };
            }
            io.sentry.util.m.m(n1Var, io.sentry.hints.k.class, w1Var, aVar);
        } catch (Throwable th2) {
            io.sentry.util.m.m(n1Var, io.sentry.hints.k.class, this.f22456g, new m.a() { // from class: io.sentry.p
                @Override // io.sentry.util.m.a
                public final void a(Object obj) {
                    j3.this.j(file, (io.sentry.hints.k) obj);
                }
            });
            throw th2;
        }
    }
}
