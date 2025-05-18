package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: SentryExceptionFactory.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class m4 {
    private final z4 a;

    public m4(z4 z4Var) {
        this.a = (z4) io.sentry.util.q.c(z4Var, "The SentryStackTraceFactory is required.");
    }

    private io.sentry.protocol.p b(Throwable th, io.sentry.protocol.i iVar, Long l, List<io.sentry.protocol.u> list, boolean z) {
        Package r0 = th.getClass().getPackage();
        String name = th.getClass().getName();
        io.sentry.protocol.p pVar = new io.sentry.protocol.p();
        String message = th.getMessage();
        if (r0 != null) {
            name = name.replace(r0.getName() + ".", HttpUrl.FRAGMENT_ENCODE_SET);
        }
        String name2 = r0 != null ? r0.getName() : null;
        if (list != null && !list.isEmpty()) {
            io.sentry.protocol.v vVar = new io.sentry.protocol.v(list);
            if (z) {
                vVar.e(Boolean.TRUE);
            }
            pVar.l(vVar);
        }
        pVar.m(l);
        pVar.n(name);
        pVar.j(iVar);
        pVar.k(name2);
        pVar.p(message);
        return pVar;
    }

    private List<io.sentry.protocol.p> d(Deque<io.sentry.protocol.p> deque) {
        return new ArrayList(deque);
    }

    Deque<io.sentry.protocol.p> a(Throwable th) {
        Thread currentThread;
        io.sentry.protocol.i iVar;
        boolean z;
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        while (th != null && hashSet.add(th)) {
            if (th instanceof ExceptionMechanismException) {
                ExceptionMechanismException exceptionMechanismException = (ExceptionMechanismException) th;
                io.sentry.protocol.i a = exceptionMechanismException.a();
                Throwable c2 = exceptionMechanismException.c();
                currentThread = exceptionMechanismException.b();
                z = exceptionMechanismException.d();
                iVar = a;
                th = c2;
            } else {
                currentThread = Thread.currentThread();
                iVar = null;
                z = false;
            }
            arrayDeque.addFirst(b(th, iVar, Long.valueOf(currentThread.getId()), this.a.a(th.getStackTrace()), z));
            th = th.getCause();
        }
        return arrayDeque;
    }

    public List<io.sentry.protocol.p> c(Throwable th) {
        return d(a(th));
    }

    public List<io.sentry.protocol.p> e(io.sentry.protocol.w wVar, io.sentry.protocol.i iVar, Throwable th) {
        io.sentry.protocol.v n = wVar.n();
        if (n == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(b(th, iVar, wVar.l(), n.d(), true));
        return arrayList;
    }
}
