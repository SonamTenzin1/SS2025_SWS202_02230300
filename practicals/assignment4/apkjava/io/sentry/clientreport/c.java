package io.sentry.clientreport;

import io.sentry.util.q;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: ClientReportKey.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
final class c {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f22359b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2) {
        this.a = str;
        this.f22359b = str2;
    }

    public String a() {
        return this.f22359b;
    }

    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return q.a(b(), cVar.b()) && q.a(a(), cVar.a());
    }

    public int hashCode() {
        return q.b(b(), a());
    }
}
