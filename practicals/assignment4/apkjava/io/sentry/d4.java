package io.sentry;

import io.sentry.d5;
import io.sentry.exception.SentryEnvelopeException;
import io.sentry.s3;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: SentryClient.java */
/* loaded from: classes2.dex */
public final class d4 implements a2 {

    /* renamed from: b, reason: collision with root package name */
    private final x4 f22371b;

    /* renamed from: c, reason: collision with root package name */
    private final io.sentry.transport.r f22372c;

    /* renamed from: d, reason: collision with root package name */
    private final SecureRandom f22373d;

    /* renamed from: e, reason: collision with root package name */
    private final b f22374e = new b();
    private boolean a = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SentryClient.java */
    /* loaded from: classes2.dex */
    public static final class b implements Comparator<v0> {
        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(v0 v0Var, v0 v0Var2) {
            return v0Var.j().compareTo(v0Var2.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public d4(x4 x4Var) {
        this.f22371b = (x4) io.sentry.util.q.c(x4Var, "SentryOptions is required.");
        g2 transportFactory = x4Var.getTransportFactory();
        if (transportFactory instanceof g3) {
            transportFactory = new r0();
            x4Var.setTransportFactory(transportFactory);
        }
        this.f22372c = transportFactory.a(x4Var, new q3(x4Var).a());
        this.f22373d = x4Var.getSampleRate() != null ? new SecureRandom() : null;
    }

    private void d(s3 s3Var, n1 n1Var) {
        if (s3Var != null) {
            n1Var.a(s3Var.i());
        }
    }

    private <T extends c4> T e(T t, s3 s3Var) {
        if (s3Var != null) {
            if (t.K() == null) {
                t.Z(s3Var.q());
            }
            if (t.Q() == null) {
                t.e0(s3Var.w());
            }
            if (t.N() == null) {
                t.d0(new HashMap(s3Var.t()));
            } else {
                for (Map.Entry<String, String> entry : s3Var.t().entrySet()) {
                    if (!t.N().containsKey(entry.getKey())) {
                        t.N().put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (t.B() == null) {
                t.R(new ArrayList(s3Var.j()));
            } else {
                v(t, s3Var.j());
            }
            if (t.H() == null) {
                t.W(new HashMap(s3Var.m()));
            } else {
                for (Map.Entry<String, Object> entry2 : s3Var.m().entrySet()) {
                    if (!t.H().containsKey(entry2.getKey())) {
                        t.H().put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            io.sentry.protocol.c C = t.C();
            for (Map.Entry<String, Object> entry3 : new io.sentry.protocol.c(s3Var.k()).entrySet()) {
                if (!C.containsKey(entry3.getKey())) {
                    C.put(entry3.getKey(), entry3.getValue());
                }
            }
        }
        return t;
    }

    private l4 f(l4 l4Var, s3 s3Var, n1 n1Var) {
        if (s3Var == null) {
            return l4Var;
        }
        e(l4Var, s3Var);
        if (l4Var.t0() == null) {
            l4Var.E0(s3Var.v());
        }
        if (l4Var.p0() == null) {
            l4Var.y0(s3Var.n());
        }
        if (s3Var.o() != null) {
            l4Var.z0(s3Var.o());
        }
        d2 s = s3Var.s();
        if (l4Var.C().e() == null) {
            if (s == null) {
                l4Var.C().n(r5.q(s3Var.p()));
            } else {
                l4Var.C().n(s.m());
            }
        }
        return q(l4Var, n1Var, s3Var.l());
    }

    private h4 g(c4 c4Var, List<s0> list, d5 d5Var, o5 o5Var, m3 m3Var) throws IOException, SentryEnvelopeException {
        io.sentry.protocol.q qVar;
        ArrayList arrayList = new ArrayList();
        if (c4Var != null) {
            arrayList.add(j4.d(this.f22371b.getSerializer(), c4Var));
            qVar = c4Var.G();
        } else {
            qVar = null;
        }
        if (d5Var != null) {
            arrayList.add(j4.f(this.f22371b.getSerializer(), d5Var));
        }
        if (m3Var != null) {
            arrayList.add(j4.e(m3Var, this.f22371b.getMaxTraceFileSize(), this.f22371b.getSerializer()));
            if (qVar == null) {
                qVar = new io.sentry.protocol.q(m3Var.z());
            }
        }
        if (list != null) {
            Iterator<s0> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(j4.b(this.f22371b.getSerializer(), this.f22371b.getLogger(), it.next(), this.f22371b.getMaxAttachmentSize()));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new h4(new i4(qVar, this.f22371b.getSdkVersion(), o5Var), arrayList);
    }

    private l4 i(l4 l4Var, n1 n1Var) {
        x4.b beforeSend = this.f22371b.getBeforeSend();
        if (beforeSend == null) {
            return l4Var;
        }
        try {
            return beforeSend.a(l4Var, n1Var);
        } catch (Throwable th) {
            this.f22371b.getLogger().b(s4.ERROR, "The BeforeSend callback threw an exception. It will be added as breadcrumb and continue.", th);
            return null;
        }
    }

    private io.sentry.protocol.x k(io.sentry.protocol.x xVar, n1 n1Var) {
        x4.c beforeSendTransaction = this.f22371b.getBeforeSendTransaction();
        if (beforeSendTransaction == null) {
            return xVar;
        }
        try {
            return beforeSendTransaction.a(xVar, n1Var);
        } catch (Throwable th) {
            this.f22371b.getLogger().b(s4.ERROR, "The BeforeSendTransaction callback threw an exception. It will be added as breadcrumb and continue.", th);
            return null;
        }
    }

    private List<s0> l(List<s0> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (s0 s0Var : list) {
            if (s0Var.j()) {
                arrayList.add(s0Var);
            }
        }
        return arrayList;
    }

    private List<s0> m(n1 n1Var) {
        List<s0> e2 = n1Var.e();
        s0 f2 = n1Var.f();
        if (f2 != null) {
            e2.add(f2);
        }
        s0 h2 = n1Var.h();
        if (h2 != null) {
            e2.add(h2);
        }
        s0 g2 = n1Var.g();
        if (g2 != null) {
            e2.add(g2);
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(d5 d5Var) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(l4 l4Var, n1 n1Var, d5 d5Var) {
        if (d5Var != null) {
            String str = null;
            d5.b bVar = l4Var.v0() ? d5.b.Crashed : null;
            boolean z = d5.b.Crashed == bVar || l4Var.w0();
            String str2 = (l4Var.K() == null || l4Var.K().l() == null || !l4Var.K().l().containsKey("user-agent")) ? null : l4Var.K().l().get("user-agent");
            Object c2 = io.sentry.util.m.c(n1Var);
            if (c2 instanceof io.sentry.hints.b) {
                str = ((io.sentry.hints.b) c2).f();
                bVar = d5.b.Abnormal;
            }
            if (d5Var.q(bVar, str2, z, str) && d5Var.m()) {
                d5Var.c();
                return;
            }
            return;
        }
        this.f22371b.getLogger().c(s4.INFO, "Session is null on scope.withSession", new Object[0]);
    }

    private l4 q(l4 l4Var, n1 n1Var, List<k1> list) {
        Iterator<k1> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            k1 next = it.next();
            try {
                boolean z = next instanceof t0;
                boolean d2 = io.sentry.util.m.d(n1Var, io.sentry.hints.d.class);
                if (d2 && z) {
                    l4Var = next.b(l4Var, n1Var);
                } else if (!d2 && !z) {
                    l4Var = next.b(l4Var, n1Var);
                }
            } catch (Throwable th) {
                this.f22371b.getLogger().a(s4.ERROR, th, "An exception occurred while processing event by processor: %s", next.getClass().getName());
            }
            if (l4Var == null) {
                this.f22371b.getLogger().c(s4.DEBUG, "Event was dropped by a processor: %s", next.getClass().getName());
                this.f22371b.getClientReportRecorder().a(io.sentry.clientreport.e.EVENT_PROCESSOR, z0.Error);
                break;
            }
        }
        return l4Var;
    }

    private io.sentry.protocol.x r(io.sentry.protocol.x xVar, n1 n1Var, List<k1> list) {
        Iterator<k1> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            k1 next = it.next();
            try {
                xVar = next.e(xVar, n1Var);
            } catch (Throwable th) {
                this.f22371b.getLogger().a(s4.ERROR, th, "An exception occurred while processing transaction by processor: %s", next.getClass().getName());
            }
            if (xVar == null) {
                this.f22371b.getLogger().c(s4.DEBUG, "Transaction was dropped by a processor: %s", next.getClass().getName());
                this.f22371b.getClientReportRecorder().a(io.sentry.clientreport.e.EVENT_PROCESSOR, z0.Transaction);
                break;
            }
        }
        return xVar;
    }

    private boolean s() {
        return this.f22371b.getSampleRate() == null || this.f22373d == null || this.f22371b.getSampleRate().doubleValue() >= this.f22373d.nextDouble();
    }

    private boolean t(c4 c4Var, n1 n1Var) {
        if (io.sentry.util.m.q(n1Var)) {
            return true;
        }
        this.f22371b.getLogger().c(s4.DEBUG, "Event was cached so not applying scope: %s", c4Var.G());
        return false;
    }

    private boolean u(d5 d5Var, d5 d5Var2) {
        if (d5Var2 == null) {
            return false;
        }
        if (d5Var == null) {
            return true;
        }
        d5.b l = d5Var2.l();
        d5.b bVar = d5.b.Crashed;
        if (l == bVar && d5Var.l() != bVar) {
            return true;
        }
        return d5Var2.e() > 0 && d5Var.e() <= 0;
    }

    private void v(c4 c4Var, Collection<v0> collection) {
        List<v0> B = c4Var.B();
        if (B == null || collection.isEmpty()) {
            return;
        }
        B.addAll(collection);
        Collections.sort(B, this.f22374e);
    }

    @Override // io.sentry.a2
    @ApiStatus.Internal
    public void a(d5 d5Var, n1 n1Var) {
        io.sentry.util.q.c(d5Var, "Session is required.");
        if (d5Var.h() != null && !d5Var.h().isEmpty()) {
            try {
                j(h4.a(this.f22371b.getSerializer(), d5Var, this.f22371b.getSdkVersion()), n1Var);
                return;
            } catch (IOException e2) {
                this.f22371b.getLogger().b(s4.ERROR, "Failed to capture session.", e2);
                return;
            }
        }
        this.f22371b.getLogger().c(s4.WARNING, "Sessions can't be captured without setting a release.", new Object[0]);
    }

    @Override // io.sentry.a2
    public io.sentry.protocol.q b(l4 l4Var, s3 s3Var, n1 n1Var) {
        l4 l4Var2;
        e2 u;
        o5 h2;
        o5 o5Var;
        io.sentry.util.q.c(l4Var, "SentryEvent is required.");
        if (n1Var == null) {
            n1Var = new n1();
        }
        if (t(l4Var, n1Var)) {
            d(s3Var, n1Var);
        }
        w1 logger = this.f22371b.getLogger();
        s4 s4Var = s4.DEBUG;
        logger.c(s4Var, "Capturing event: %s", l4Var.G());
        Throwable O = l4Var.O();
        if (O != null && this.f22371b.containsIgnoredExceptionForType(O)) {
            this.f22371b.getLogger().c(s4Var, "Event was dropped as the exception %s is ignored", O.getClass());
            this.f22371b.getClientReportRecorder().a(io.sentry.clientreport.e.EVENT_PROCESSOR, z0.Error);
            return io.sentry.protocol.q.f22645f;
        }
        if (t(l4Var, n1Var) && (l4Var = f(l4Var, s3Var, n1Var)) == null) {
            this.f22371b.getLogger().c(s4Var, "Event was dropped by applyScope", new Object[0]);
            return io.sentry.protocol.q.f22645f;
        }
        l4 q = q(l4Var, n1Var, this.f22371b.getEventProcessors());
        if (q != null && (q = i(q, n1Var)) == null) {
            this.f22371b.getLogger().c(s4Var, "Event was dropped by beforeSend", new Object[0]);
            this.f22371b.getClientReportRecorder().a(io.sentry.clientreport.e.BEFORE_SEND, z0.Error);
        }
        if (q == null) {
            return io.sentry.protocol.q.f22645f;
        }
        d5 C = s3Var != null ? s3Var.C(new s3.b() { // from class: io.sentry.v
            @Override // io.sentry.s3.b
            public final void a(d5 d5Var) {
                d4.n(d5Var);
            }
        }) : null;
        d5 w = (C == null || !C.m()) ? w(q, n1Var, s3Var) : null;
        if (s()) {
            l4Var2 = q;
        } else {
            this.f22371b.getLogger().c(s4Var, "Event %s was dropped due to sampling decision.", q.G());
            this.f22371b.getClientReportRecorder().a(io.sentry.clientreport.e.SAMPLE_RATE, z0.Error);
            l4Var2 = null;
        }
        boolean u2 = u(C, w);
        if (l4Var2 == null && !u2) {
            this.f22371b.getLogger().c(s4Var, "Not sending session update for dropped event as it did not cause the session health to change.", new Object[0]);
            return io.sentry.protocol.q.f22645f;
        }
        io.sentry.protocol.q qVar = io.sentry.protocol.q.f22645f;
        if (l4Var2 != null && l4Var2.G() != null) {
            qVar = l4Var2.G();
        }
        try {
            if (io.sentry.util.m.d(n1Var, io.sentry.hints.d.class)) {
                if (l4Var2 != null) {
                    h2 = u0.b(l4Var2, this.f22371b).F();
                    o5Var = h2;
                }
                o5Var = null;
            } else {
                if (s3Var != null) {
                    e2 u3 = s3Var.u();
                    if (u3 != null) {
                        h2 = u3.a();
                    } else {
                        h2 = io.sentry.util.v.d(s3Var, this.f22371b).h();
                    }
                    o5Var = h2;
                }
                o5Var = null;
            }
            h4 g2 = g(l4Var2, l4Var2 != null ? m(n1Var) : null, w, o5Var, null);
            n1Var.b();
            if (g2 != null) {
                this.f22372c.V(g2, n1Var);
            }
        } catch (SentryEnvelopeException | IOException e2) {
            this.f22371b.getLogger().a(s4.WARNING, e2, "Capturing event %s failed.", qVar);
            qVar = io.sentry.protocol.q.f22645f;
        }
        if (s3Var != null && (u = s3Var.u()) != null && io.sentry.util.m.d(n1Var, io.sentry.hints.q.class)) {
            u.e(j5.ABORTED, false);
        }
        return qVar;
    }

    @Override // io.sentry.a2
    public io.sentry.protocol.q c(io.sentry.protocol.x xVar, o5 o5Var, s3 s3Var, n1 n1Var, m3 m3Var) {
        io.sentry.protocol.x xVar2 = xVar;
        io.sentry.util.q.c(xVar, "Transaction is required.");
        n1 n1Var2 = n1Var == null ? new n1() : n1Var;
        if (t(xVar, n1Var2)) {
            d(s3Var, n1Var2);
        }
        w1 logger = this.f22371b.getLogger();
        s4 s4Var = s4.DEBUG;
        logger.c(s4Var, "Capturing transaction: %s", xVar.G());
        io.sentry.protocol.q qVar = io.sentry.protocol.q.f22645f;
        io.sentry.protocol.q G = xVar.G() != null ? xVar.G() : qVar;
        if (t(xVar, n1Var2)) {
            xVar2 = (io.sentry.protocol.x) e(xVar, s3Var);
            if (xVar2 != null && s3Var != null) {
                xVar2 = r(xVar2, n1Var2, s3Var.l());
            }
            if (xVar2 == null) {
                this.f22371b.getLogger().c(s4Var, "Transaction was dropped by applyScope", new Object[0]);
            }
        }
        if (xVar2 != null) {
            xVar2 = r(xVar2, n1Var2, this.f22371b.getEventProcessors());
        }
        if (xVar2 == null) {
            this.f22371b.getLogger().c(s4Var, "Transaction was dropped by Event processors.", new Object[0]);
            return qVar;
        }
        io.sentry.protocol.x k2 = k(xVar2, n1Var2);
        if (k2 == null) {
            this.f22371b.getLogger().c(s4Var, "Transaction was dropped by beforeSendTransaction.", new Object[0]);
            this.f22371b.getClientReportRecorder().a(io.sentry.clientreport.e.BEFORE_SEND, z0.Transaction);
            return qVar;
        }
        try {
            h4 g2 = g(k2, l(m(n1Var2)), null, o5Var, m3Var);
            n1Var2.b();
            if (g2 == null) {
                return qVar;
            }
            this.f22372c.V(g2, n1Var2);
            return G;
        } catch (SentryEnvelopeException | IOException e2) {
            this.f22371b.getLogger().a(s4.WARNING, e2, "Capturing transaction %s failed.", G);
            return io.sentry.protocol.q.f22645f;
        }
    }

    @Override // io.sentry.a2
    public void close() {
        this.f22371b.getLogger().c(s4.INFO, "Closing SentryClient.", new Object[0]);
        try {
            h(this.f22371b.getShutdownTimeoutMillis());
            this.f22372c.close();
        } catch (IOException e2) {
            this.f22371b.getLogger().b(s4.WARNING, "Failed to close the connection to the Sentry Server.", e2);
        }
        for (k1 k1Var : this.f22371b.getEventProcessors()) {
            if (k1Var instanceof Closeable) {
                try {
                    ((Closeable) k1Var).close();
                } catch (IOException e3) {
                    this.f22371b.getLogger().c(s4.WARNING, "Failed to close the event processor {}.", k1Var, e3);
                }
            }
        }
        this.a = false;
    }

    @Override // io.sentry.a2
    public void h(long j2) {
        this.f22372c.h(j2);
    }

    @Override // io.sentry.a2
    @ApiStatus.Internal
    public io.sentry.protocol.q j(h4 h4Var, n1 n1Var) {
        io.sentry.util.q.c(h4Var, "SentryEnvelope is required.");
        if (n1Var == null) {
            n1Var = new n1();
        }
        try {
            n1Var.b();
            this.f22372c.V(h4Var, n1Var);
            io.sentry.protocol.q a2 = h4Var.b().a();
            return a2 != null ? a2 : io.sentry.protocol.q.f22645f;
        } catch (IOException e2) {
            this.f22371b.getLogger().b(s4.ERROR, "Failed to capture envelope.", e2);
            return io.sentry.protocol.q.f22645f;
        }
    }

    d5 w(final l4 l4Var, final n1 n1Var, s3 s3Var) {
        if (io.sentry.util.m.q(n1Var)) {
            if (s3Var != null) {
                return s3Var.C(new s3.b() { // from class: io.sentry.w
                    @Override // io.sentry.s3.b
                    public final void a(d5 d5Var) {
                        d4.this.p(l4Var, n1Var, d5Var);
                    }
                });
            }
            this.f22371b.getLogger().c(s4.INFO, "Scope is null on client.captureEvent", new Object[0]);
        }
        return null;
    }
}
