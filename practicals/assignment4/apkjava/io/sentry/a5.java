package io.sentry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: SentryThreadFactory.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class a5 {
    private final z4 a;

    /* renamed from: b, reason: collision with root package name */
    private final x4 f22004b;

    public a5(z4 z4Var, x4 x4Var) {
        this.a = (z4) io.sentry.util.q.c(z4Var, "The SentryStackTraceFactory is required.");
        this.f22004b = (x4) io.sentry.util.q.c(x4Var, "The SentryOptions is required");
    }

    private io.sentry.protocol.w d(boolean z, StackTraceElement[] stackTraceElementArr, Thread thread) {
        io.sentry.protocol.w wVar = new io.sentry.protocol.w();
        wVar.w(thread.getName());
        wVar.x(Integer.valueOf(thread.getPriority()));
        wVar.u(Long.valueOf(thread.getId()));
        wVar.s(Boolean.valueOf(thread.isDaemon()));
        wVar.z(thread.getState().name());
        wVar.q(Boolean.valueOf(z));
        List<io.sentry.protocol.u> a = this.a.a(stackTraceElementArr);
        if (this.f22004b.isAttachStacktrace() && a != null && !a.isEmpty()) {
            io.sentry.protocol.v vVar = new io.sentry.protocol.v(a);
            vVar.e(Boolean.TRUE);
            wVar.y(vVar);
        }
        return wVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<io.sentry.protocol.w> a() {
        HashMap hashMap = new HashMap();
        Thread currentThread = Thread.currentThread();
        hashMap.put(currentThread, currentThread.getStackTrace());
        return c(hashMap, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<io.sentry.protocol.w> b(List<Long> list, boolean z) {
        return c(Thread.getAllStackTraces(), list, z);
    }

    List<io.sentry.protocol.w> c(Map<Thread, StackTraceElement[]> map, List<Long> list, boolean z) {
        Thread currentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(currentThread)) {
            map.put(currentThread, currentThread.getStackTrace());
        }
        for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
            Thread key = entry.getKey();
            arrayList.add(d((key == currentThread && !z) || (list != null && list.contains(Long.valueOf(key.getId()))), entry.getValue(), entry.getKey()));
        }
        return arrayList;
    }
}
